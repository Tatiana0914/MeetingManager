package com.system.model;

import java.util.Date;

public class FreeRoom {
	private int freetime_id;//会议室可用时间段编号
	//private int opentime_id;
	private int room_id;//会议室编号
	private String room_nameString;//会议室名称
	private String building_name;//楼名称
	private int seat;//可用座位数
	private Date date;//日期
	private Date begin_time;//开始时间
	private Date end_time;//结束时间
	private int order_flag;//预约状态
	public int getFreetime_id() {
		return freetime_id;
	}
	public void setFreetime_id(int freetime_id) {
		this.freetime_id = freetime_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_nameString() {
		return room_nameString;
	}
	public void setRoom_nameString(String room_nameString) {
		this.room_nameString = room_nameString;
	}
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getOrder_flag() {
		return order_flag;
	}
	public void setOrder_flag(int order_flag) {
		this.order_flag = order_flag;
	}
	
}
