<%@page import="java.util.List"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.Wishlist"%>
<%
  
   int pid = Integer.parseInt(request.getParameter("pid"));
   int user_id = Integer.parseInt(request.getParameter("user_id"));
   Wishlist w = new Wishlist();
   w.setPid(pid);
   w.setUser_id(user_id);
   WishlistDao.addToWishlist(w);
   // Dynamic Wishlist data update
   List<Wishlist> list=WishlistDao.getWiListByUser(user_id);
   session.setAttribute("wishlist_count", list.size());
   
   response.sendRedirect("wishlist.jsp");
%> 