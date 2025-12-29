package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.bean.Cart;
import com.bean.User;
import com.bean.Wishlist;
import com.dao.CartDao;
import com.dao.UserDao;
import com.dao.WishlistDao;
import com.service.Services;

@WebServlet("/UserController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512,
maxFileSize = 1024 * 1024 * 512,
maxRequestSize = 1024 * 1024 * 512)

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String extractFilename(Part file) {
        String cd = file.getHeader("content-disposition");
        for (String part : cd.split(";")) {
            if (part.trim().startsWith("filename")) {
                return part.substring(part.indexOf('=') + 2, part.length() - 1);
            }
        }
        return "";
    }
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			
			if(action.equalsIgnoreCase("sign up"))
			{
				boolean flag = UserDao.checkEmail(request.getParameter("email"));
				if(!flag)
				{
					if(request.getParameter("password").equals(request.getParameter("cpassword")))
					{
						String savePath = "C:\\Users\\hp\\OneDrive\\Desktop\\Project1\\ElectroApp\\src\\main\\webapp\\profile_picture";
						File fileSaveDir = new File(savePath);
						if(!fileSaveDir.exists())
						{
							fileSaveDir.mkdir();
						}
						Part filePart = request.getPart("profile_picture");
						String fileName = extractFilename(filePart);
						filePart.write(savePath + File.separator + fileName);
						String savePath1 = "C:\\Users\\hp\\OneDrive\\Desktop\\Project1\\ElectroApp\\src\\main\\webapp\\profile_picture";
						File imgSaveDir = new File(savePath1);
						if(!imgSaveDir.exists())
						{
							imgSaveDir.mkdir();
						}
						User u = new User();
						u.setFname(request.getParameter("fname"));
						u.setLname(request.getParameter("lname"));
						u.setEmail(request.getParameter("email"));
						u.setMobile(Long.parseLong(request.getParameter("mobile")));
						u.setPassword(request.getParameter("password"));
						u.setAddress(request.getParameter("address"));
						u.setProfile_picture(fileName);
						u.setUsertype(request.getParameter("usertype"));
						
						UserDao.signupUser(u);
						
						request.setAttribute("msg", "User Signed Up Successfully!");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					else
					{
						request.setAttribute("msg", "Password and confirm Password do not match!");
						request.getRequestDispatcher("signup.jsp").forward(request, response);
					}
				}
				else 
				{
					request.setAttribute("msg", "Email already register!");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("login"))
			{
				User u = UserDao.userLogin(request.getParameter("email"));
	
				if(u!=null)
				{
					if(u.getPassword().equals(request.getParameter("password")))
					{
						HttpSession session = request.getSession();
						session.setAttribute("u", u);
						if(u.getUsertype().equals("Buyer"))
						{
							// single wishlist product count header
							List<Wishlist> list = WishlistDao.getWiListByUser(u.getUser_id());
							session.setAttribute("wishlist_count",list.size());
							
							// single Cart product count header
							List<Cart> list1 = CartDao.getCartByUser(u.getUser_id());
							session.setAttribute("cart_count",list1.size());
							
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
						else
						{
							request.getRequestDispatcher("seller-index.jsp").forward(request, response);
						}
					}
					else
					{
						request.setAttribute("msg", "Incorrect Invalid Password");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
				else
				{
					request.setAttribute("msg", "Email Not Register !");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			
			else if(action.equalsIgnoreCase("update profile"))
			{
				HttpSession session = request.getSession();
				User oldUser = (User) session.getAttribute("u");
				
				// File upload handling
				String savePath="C:\\Users\\hp\\OneDrive\\Desktop\\Project1\\ElectroApp\\src\\main\\webapp\\profile_picture";
				File fileSaveDir = new File(savePath);
				if(!fileSaveDir.exists())
				{
					fileSaveDir.mkdir();
				}
				
				Part filePart = request.getPart("profile_picture");
				String fileName = extractFilename(filePart);
				
				String finalFileName = oldUser.getProfile_picture(); // keep old if not updated
				
				// check if new File Uploaded
				if(fileName!=null && !fileName.trim().isEmpty())
				{
					filePart.write(savePath + File.separator + fileName);
					finalFileName = fileName;
					
				}
				
				User u = new User();
				u.setFname(request.getParameter("fname"));
				u.setLname(request.getParameter("lname"));
				u.setEmail(request.getParameter("email"));
				u.setMobile(Long.parseLong(request.getParameter("mobile")));
				u.setAddress(request.getParameter("address"));
				u.setProfile_picture(finalFileName);
				u.setUsertype(request.getParameter("usertype"));
				
				UserDao.updateUser(u);
				
				// session remove
				session.setAttribute("u", u);
				
				if(u.getUsertype().equals("buyer"))
				{
					request.setAttribute("msg", "Profile updated successfully!");
					request.getRequestDispatcher("profile.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("seller-profile.jsp").forward(request, response);
				}
				
			}
			
		else if(action.equalsIgnoreCase("change password"))
		{
			HttpSession session=request.getSession();
			User u=(User)session.getAttribute("u");
			if(u.getPassword().equals(request.getParameter("old_password")))
			{
				if(request.getParameter("new_password").equals(request.getParameter("confirm_password")))
				{
					if(!u.getPassword().equals(request.getParameter("new_password")))
					{
						UserDao.changePassword(request.getParameter("new_password"),u.getEmail());
						response.sendRedirect("logout.jsp");
					}
					else
					{
						request.setAttribute("msg", "Old Password & New Password Can't Be Same");
						if(u.getUsertype().equals("buyer"))
						{
							request.getRequestDispatcher("change-password.jsp").forward(request, response);
						}
						else
						{
							request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
						}
						
					}
				}
				else
				{
					request.setAttribute("msg", "New Password & MConfirm New Password Does Not Matched");
					if(u.getUsertype().equals("buyer"))
					{
						request.getRequestDispatcher("change-password.jsp").forward(request, response);
					}
					else
					{
						request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
					}
				}
			}
			else
			{
				request.setAttribute("msg", "Old Password Does Not Matched");
				if(u.getUsertype().equals("buyer"))
				{
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
				}
			}
		}
			
			else if(action.equalsIgnoreCase("forgot password"))
			{
				boolean flag=UserDao.checkEmail(request.getParameter("email"));
				if(flag==false)
				{
					request.setAttribute("msg", "Email Not Registered");
					request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
				}
				else
				{
					Random t = new Random();
			    	int minRange = 1000, maxRange= 9999;
		        	int otp = t.nextInt(maxRange - minRange) + minRange;
		        	Services.sendMail(request.getParameter("email"), otp);
		        	HttpSession session=request.getSession();
		        	session.setAttribute("email", request.getParameter("email"));
		        	session.setAttribute("otp", otp);
		        	request.getRequestDispatcher("otp.jsp").forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("verify otp"))
			{
				int otp1=Integer.parseInt(request.getParameter("otp"));
				HttpSession session=request.getSession();
				int otp2=Integer.parseInt(session.getAttribute("otp").toString());
				if(otp1==otp2)
				{
					session.removeAttribute("otp");
					request.setAttribute("msg", "Set Your New Password");
					request.getRequestDispatcher("new-password.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Invalid OTP");
					request.getRequestDispatcher("otp.jsp").forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("update password"))
			{
				HttpSession session=request.getSession();
				String email=session.getAttribute("email").toString();
				if(request.getParameter("new_password").equals(request.getParameter("confirm_password")))
				{
					session.removeAttribute("email");
					UserDao.changePassword(request.getParameter("new_password"),email);
					response.sendRedirect("login.jsp");
				}
				else
				{
					request.setAttribute("msg", "New Password & MConfirm New Password Does Not Matched");
					request.getRequestDispatcher("new-password.jsp").forward(request, response);
				}
			}
	}

}
