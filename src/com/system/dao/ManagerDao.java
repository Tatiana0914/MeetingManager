package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.system.model.Manager;

public class ManagerDao {
	public Manager login(Connection con,Manager manager) throws Exception{
		Manager resultManer=null;
		String sqlString="select * from t_managers where mName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sqlString);
		pstmt.setString(1,manager.getmName());
		pstmt.setString(2, manager.getPassword());
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()) {
			resultManer=new Manager();
			resultManer.setSid(rs.getInt("sid"));
			resultManer.setmName(rs.getString("mName"));
			resultManer.setPassword(rs.getString("password"));
		}
		return resultManer;
	}
}
