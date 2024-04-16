package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.system.model.MeetingRoom;

public class MeetingRoomDao {
	public int add(Connection con,MeetingRoom meetingRoom)throws Exception {
		String sql="insert into t_meetingroom values(?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,meetingRoom.getRoom_id());
		pst.setInt(2,meetingRoom.getBuilding_id());
		pst.setString(3,meetingRoom.getBuilding_name());
		pst.setString(4,meetingRoom.getRoomname());
		pst.setInt(5,meetingRoom.getSeat());
		return pst.executeUpdate();
	}
//	public int delete() {
//		
//	}
//	public int change() {
//		
//	}
//	public int find() {
//		
//	}
}
