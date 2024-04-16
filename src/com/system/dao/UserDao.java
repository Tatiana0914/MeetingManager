package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.model.User;
import com.system.util.StringUtil;
import com.system.view.AddUserInterFrm;

public class UserDao {
	public ResultSet listUser(Connection con) throws Exception {
		String sql="select * from t_users";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		ResultSet rs=preparedStatement.executeQuery();
		return rs;
	}
	
	public int addUser(Connection con,User user) throws Exception {
		String sql="insert into t_users values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,user.getSid());
		pst.setString(2,user.getName());
		pst.setString(3,user.getPassword());
		return pst.executeUpdate();
	}
	
	public User login(Connection con,User user) throws Exception {
		User resultUser=null;
		String sql="select * from t_users where sid=? and password=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, user.getSid());
		pst.setString(2, user.getPassword());
		ResultSet rs= pst.executeQuery();
		if(rs.next()) {
			resultUser=new User();
			resultUser.setSid(rs.getString("sid"));
			resultUser.setName(rs.getString("name"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
	
	public ResultSet list(Connection con,User user) throws Exception{
		StringBuffer sBu=new StringBuffer("select * from t_users");
		if(!StringUtil.isEmpty(user.getSid())) {
			sBu.append(" and sid='"+user.getSid()+"' ");
		}
		if(!StringUtil.isEmpty(user.getName())) {
			sBu.append(" and name='"+user.getName()+"' ");
		}
		PreparedStatement pst=con.prepareStatement(sBu.toString().replace("and", "where"));
		ResultSet rs= pst.executeQuery();
		return rs;
	}
	
	public int update(Connection con,User user) throws Exception{
		String sql="update t_users set name=?,password=? where sid=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getSid());
		return pst.executeUpdate();
	}
}
