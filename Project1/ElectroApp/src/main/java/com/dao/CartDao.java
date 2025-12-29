package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Cart;
import com.bean.Wishlist;
import com.util.ElectroUtil;

public class CartDao {
	
	public static void addToCart(Cart c)
	{
		try {
	     		Connection conn = ElectroUtil.createConnection();
	     		String sql="insert into cart (pid,user_id,product_price,product_qty,total_price) values(?,?,?,?,?)";
	     		PreparedStatement pst = conn.prepareStatement(sql);
	     		pst.setInt(1, c.getPid());
	     		pst.setInt(2, c.getUser_id());
	     		pst.setInt(3, c.getProduct_price());
	     		pst.setInt(4, c.getProduct_qty());
	     		pst.setInt(5, c.getTotal_price());
	     		pst.executeUpdate();
		  	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//  view Cart data
	public static List<Cart> getCartByUser(int user_id)
	{
		// payment time false
		boolean payment_status=false;
		
	    List<Cart> list = new ArrayList<Cart>();
	    try {
	        Connection conn = ElectroUtil.createConnection();
	        String sql="select * from cart where user_id=? and payment_status=?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, user_id);
	        pst.setBoolean(2, payment_status);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next())    // <- FIXED
	        {
	            Cart c = new Cart();
	            c.setCid(rs.getInt("cid"));
	            c.setPid(rs.getInt("pid"));
	            c.setUser_id(rs.getInt("user_id"));
	            c.setProduct_price(rs.getInt("product_price"));
	            c.setProduct_qty(rs.getInt("product_qty"));
	            c.setTotal_price(rs.getInt("total_price"));
	            c.setPayment_status(rs.getBoolean("payment_status"));
	            list.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	// Cart order detail
	public static List<Cart> getOder(int user_id)
	{
		// payment time false
		boolean payment_status=true;
		
	    List<Cart> list = new ArrayList<Cart>();
	    try {
	        Connection conn = ElectroUtil.createConnection();
	        String sql="select * from cart where user_id=? and payment_status=?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, user_id);
	        pst.setBoolean(2, payment_status);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next())    // <- FIXED
	        {
	            Cart c = new Cart();
	            c.setCid(rs.getInt("cid"));
	            c.setPid(rs.getInt("pid"));
	            c.setUser_id(rs.getInt("user_id"));
	            c.setProduct_price(rs.getInt("product_price"));
	            c.setProduct_qty(rs.getInt("product_qty"));
	            c.setTotal_price(rs.getInt("total_price"));
	            c.setPayment_status(rs.getBoolean("payment_status"));
	            list.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

// Check Cart product data
	
	public static boolean checkCart(int pid,int user_id)
	{
		boolean flag=false;
		try {
			Connection conn = ElectroUtil.createConnection();
			String sql="select * from cart where pid=? and user_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.setInt(2, user_id);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return flag;
	}
	
	// remove Cart product data
	
	public static void  removeFromCart(Cart c)
	{
		
		try {
			Connection conn = ElectroUtil.createConnection();
			String sql="delete from cart where pid=? and user_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getPid());
			pst.setInt(2, c.getUser_id());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
//	product cart qty total
	public static Cart getCart(int cid)
	{
		Cart c=null;
	    try {
	        Connection conn = ElectroUtil.createConnection();
	        String sql="select * from cart where cid=?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, cid);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next())    // <- FIXED
	        {
	             c = new Cart();
	            c.setCid(rs.getInt("cid"));
	            c.setPid(rs.getInt("pid"));
	            c.setUser_id(rs.getInt("user_id"));
	            c.setProduct_price(rs.getInt("product_price"));
	            c.setProduct_qty(rs.getInt("product_qty"));
	            c.setTotal_price(rs.getInt("total_price"));
	            c.setPayment_status(rs.getBoolean("payment_status"));
	           
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return c;
	}
	
	// update Cart product qty and total
	
		public static void  updateCart(Cart c)
		{
			
			try {
				Connection conn = ElectroUtil.createConnection();
				String sql="update cart set product_qty=?,total_price=? where cid=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, c.getProduct_qty());
				pst.setInt(2, c.getTotal_price());
				pst.setInt(3, c.getCid());
				pst.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void updatePaymentStatus(int user_id)
		{
			boolean flag=true;
			try {
				Connection conn=ElectroUtil.createConnection();
				String sql="update cart set payment_status=? where user_id=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setBoolean(1,flag);
				pst.setInt(2, user_id);
				pst.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
