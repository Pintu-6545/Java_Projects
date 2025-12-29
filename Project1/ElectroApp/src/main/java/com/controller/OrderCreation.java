package com.controller;

import java.io.IOException;


import org.json.*;

import com.bean.User;
import com.razorpay.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/OrderCreation")
public class OrderCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RazorpayClient client=null;
		String orderId=null;
		System.out.println(request.getParameter("amount"));
		try {
			client=new RazorpayClient("rzp_test_RhCnXhN1GpmjzM","6fBsUD3dYLpdHFD6XlU1IIQd");
			JSONObject options=new JSONObject();
			options.put("amount", request.getParameter("amount"));
			options.put("currency", "INR");
			options.put("receipt", "zxr456");
			options.put("payment_capture", true);
			Order order=client.orders.create(options);
			orderId=order.get("id");
			System.out.println("Order Id : "+orderId);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		response.getWriter().append(orderId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RazorpayClient client=null;
		try {
			client=new RazorpayClient("rzp_test_RhCnXhN1GpmjzM","6fBsUD3dYLpdHFD6XlU1IIQd");
			JSONObject options=new JSONObject();
			options.put("razorpay_payment_id",request.getParameter("razorpay_payment_id"));
			options.put("razorpay_order_id",request.getParameter("razorpay_order_id"));
			options.put("razorpay_signature",request.getParameter("razorpay_signature"));
			boolean SigRes=Utils.verifyPaymentSignature(options,"Secret");
			if(SigRes)
			{
				HttpSession session=request.getSession();
				User u=(User) session.getAttribute("u");
				System.out.println(u.getFname());
				response.getWriter().append("Payment Successfull");
			}
			else
			{
				response.getWriter().append("Payment Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
