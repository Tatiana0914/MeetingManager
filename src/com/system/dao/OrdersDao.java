package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.system.model.Orders;

public class OrdersDao {
	public int add(Connection con,Orders orders) throws Exception{
		String sql="insert into t_orders values(null,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,orders.getFreetime_id());
		pst.setInt(2,orders.getOpentime_id());
		pst.setInt(3,orders.getRoom_id());
		pst.setString(4,orders.getUsers_id());
		pst.setInt(5,orders.getStatus());
		return pst.executeUpdate();
    }
	
	//要根据用户编号寻找相应的预约信息（订单）
	public ResultSet show(Connection con,String userid)throws Exception {
		String sql="select * from t_orders where users_id = '"+userid+"'";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rSet=pst.executeQuery();
		return rSet;
	}
}
