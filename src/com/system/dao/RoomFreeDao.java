package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;

import com.system.model.FreeRoom;
import com.system.util.StringUtil;

public class RoomFreeDao {
	/**
	 * 根据条件查找可用会议室
	 * @param con
	 * @param freeRoom
	 * @return
	 * @throws Exception
	 */
	public ResultSet showFree(Connection con,FreeRoom freeRoom) throws Exception{
		StringBuffer sBuffer=new StringBuffer("select * from v_freeroom where (date>CURDATE() or (date = CURDATE() and CURTIME()<=begin_time))");
		if(freeRoom.getFreetime_id()!=0) {
			sBuffer.append(" and freetime_id like '%" +freeRoom.getFreetime_id()+"%'");
		}
		if(freeRoom.getDate()!=null) {
			sBuffer.append(" and date = '"+DateFormat.getDateInstance().format(freeRoom.getDate())+"'");
		}
		if(freeRoom.getBegin_time()!=null) {
			sBuffer.append(" and begin_time <= '"+DateFormat.getTimeInstance().format(freeRoom.getBegin_time())+"'");
		}
		if(freeRoom.getEnd_time()!=null) {
			sBuffer.append(" and end_time >= '"+DateFormat.getTimeInstance().format(freeRoom.getEnd_time())+"'");
		}
		if(!StringUtil.isEmpty(freeRoom.getBuilding_name())) {
			sBuffer.append(" and building_name like '%" +freeRoom.getBuilding_name()+"%'");
		}
		PreparedStatement pStatement=con.prepareStatement(sBuffer.toString());
		ResultSet rSet=pStatement.executeQuery();
		return rSet;
	}
	
	/**
	 * 根据编号查询单条会议室信息
	 * @param con
	 * @param freetime_id
	 * @return
	 * @throws Exception
	 */
	public ResultSet select(Connection con,int freetime_id)throws Exception{
		StringBuffer sBuffer=new StringBuffer("select * from v_freeroom where freetime_id = '"+freetime_id+"'");
		PreparedStatement pStatement=con.prepareStatement(sBuffer.toString());
		ResultSet rSet=pStatement.executeQuery();
		return rSet;
	}
}
















