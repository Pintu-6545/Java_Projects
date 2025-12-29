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

import javax.mail.Session;

import com.bean.Product;
import com.bean.User;
import com.dao.ProductDao;
import com.dao.UserDao;

@WebServlet("/ProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 10,
                 maxRequestSize = 1024 * 1024 * 50)
public class ProductController extends HttpServlet {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("add product")) {
            
        	String savePath = "C:\\Users\\hp\\OneDrive\\Desktop\\Project1\\ElectroApp\\src\\main\\webapp\\product_image";
			File fileSaveDir = new File(savePath);
			if(!fileSaveDir.exists())
			{
				fileSaveDir.mkdir();
			}
			Part filePart = request.getPart("product_image");
			String fileName = extractFilename(filePart);
			filePart.write(savePath + File.separator + fileName);
			String savePath1 = "C:\\Users\\hp\\OneDrive\\Desktop\\Project1\\ElectroApp\\src\\main\\webapp\\product_image";
			File imgSaveDir = new File(savePath1);
			if(!imgSaveDir.exists())
			{
				imgSaveDir.mkdir();
			}
            
            
            Product p = new Product();
            p.setUser_id(Integer.parseInt(request.getParameter("user_id")));
            p.setProduct_category(request.getParameter("product_category"));
            p.setProduct_name(request.getParameter("product_name"));
            p.setProduct_desc(request.getParameter("product_desc"));
            p.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
            p.setProduct_image(fileName);

            ProductDao.addProduct(p);

            request.setAttribute("msg", " Product added successfully!");
            request.getRequestDispatcher("seller-add-product.jsp").forward(request, response);
        }
        
        else if (action.equals("update product")) {

            int pid = Integer.parseInt(request.getParameter("pid"));
            Product oldProduct = ProductDao.getProductPid(pid);

//            Live Image Upload and Change without any folder save Image 
            
//            String savePath = getServletContext().getRealPath("") + File.separator + "product_image";
//            File fileSaveDir = new File(savePath);
//            if (!fileSaveDir.exists()) fileSaveDir.mkdir();
//
//            Part filePart = request.getPart("product_image");
//            String fileName = extractFilename(filePart);
//
//            // Keep old image if no new image uploaded
//            String finalFileName = oldProduct.getProduct_image();
//            if (fileName != null && !fileName.trim().isEmpty()) {
//                filePart.write(savePath + File.separator + fileName);
//                finalFileName = fileName;
//            }
            
         // File upload handling
			String savePath="C:\\Users\\hp\\OneDrive\\Desktop\\Project1\\ElectroApp\\src\\main\\webapp\\product_image";
			File fileSaveDir = new File(savePath);
			if(!fileSaveDir.exists())
			{
				fileSaveDir.mkdir();
			}
			
			Part filePart = request.getPart("product_image");
			String fileName = extractFilename(filePart);
			
			String finalFileName = oldProduct.getProduct_image(); // keep old if not updated
			
			// check if new File Uploaded
			if(fileName!=null && !fileName.trim().isEmpty())
			{
				filePart.write(savePath + File.separator + fileName);
				finalFileName = fileName;
				
			}

            Product p = new Product();
            p.setPid(pid);
            p.setProduct_category(request.getParameter("product_category"));
            p.setProduct_name(request.getParameter("product_name"));
            p.setProduct_desc(request.getParameter("product_desc"));
            p.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
            p.setProduct_image(finalFileName);

            ProductDao.updateProduct(p);

            request.setAttribute("p", p);
            request.setAttribute("msg", "Product updated successfully!");
            request.getRequestDispatcher("seller-product-detail.jsp").forward(request, response);
        }


    }
}
