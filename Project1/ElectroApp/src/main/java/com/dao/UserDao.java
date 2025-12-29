package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;
import com.util.ElectroUtil;

public class UserDao {
 
	public static void signupUser(User u)
	{
		try {
			Connection conn = ElectroUtil.createConnection();
			String sql="insert into user (fname,lname,email,mobile,password,address,profile_picture,usertype) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5, u.getPassword());
			pst.setString(6, u.getAddress());
			pst.setString(7, u.getProfile_picture());
			pst.setString(8, u.getUsertype());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String email)
	{
		boolean flag =false;
		try {
			Connection conn = ElectroUtil.createConnection();
			String sql="select * from user where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
			//rs.close();
            //pst.close();
           // conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static User userLogin(String email)
	{
		User u = null;
		try {
			Connection conn = ElectroUtil.createConnection();
			String  sql="select * from user where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				u = new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getLong("mobile"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setProfile_picture(rs.getString("profile_picture"));
				u.setUsertype(rs.getString("usertype"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static void updateUser(User u)
	{
		try {
			Connection conn = ElectroUtil.createConnection();
			String sql="update user set fname=?, lname=?, mobile=?, address=?, profile_picture=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setLong(3, u.getMobile());
			pst.setString(4, u.getAddress());
			pst.setString(5, u.getProfile_picture());
			pst.setString(6, u.getEmail());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changePassword(String password,String email)
	{
		try {
			Connection conn=ElectroUtil.createConnection();
			String sql="update user set password=? where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
