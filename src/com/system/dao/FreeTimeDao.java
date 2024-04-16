package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 会议室可用时段Dao类
 */
public class FreeTimeDao {
	public int order(Connection con,int freeTimeid)throws Exception{
		String sql="update t_freetime set order_flag=0 where freetime_id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,freeTimeid);
		return pst.executeUpdate();
	}
	public int resetorder(Connection con,int freeTimeid)throws Exception{
		String sql="update t_freetime set order_flag=1 where freetime_id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,freeTimeid);
		return pst.executeUpdate();
	}
}
