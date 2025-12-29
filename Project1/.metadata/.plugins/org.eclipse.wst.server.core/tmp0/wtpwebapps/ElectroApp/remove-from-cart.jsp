<%@page import="com.bean.Product"%>
<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.Wishlist"%>
<%
  
   int pid = Integer.parseInt(request.getParameter("pid"));
   int user_id = Integer.parseInt(request.getParameter("user_id"));
   Cart c = new Cart();
   c.setPid(pid);
   c.setUser_id(user_id);
   CartDao.removeFromCart(c);
   
  //  Dynamic Cart data remove
   List<Cart> list=CartDao.getCartByUser(user_id);
   session.setAttribute("cart_count", list.size());
   
   response.sendRedirect("cart.jsp");
%> 