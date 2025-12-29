<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%

     int cid = Integer.parseInt(request.getParameter("cid"));
     int product_qty=Integer.parseInt(request.getParameter("product_qty"));
     Cart c= CartDao.getCart(cid);
     c.setTotal_price(product_qty*c.getProduct_price());
     c.setProduct_qty(product_qty);
     CartDao.updateCart(c);
     response.sendRedirect("cart.jsp"); 
     
%>