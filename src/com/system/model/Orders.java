package com.system.model;

/**
 * 预约实体类
 */
public class Orders {
	private int orders_id;//预约编号
	private int freetime_id;//会议室时间段编号
	private int opentime_id;//时间段编号
	private int room_id;//会议室编号
	private String users_id;//用户编号
	private int status;//状态（正常预约/缺席等）
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getFreetime_id() {
		return freetime_id;
	}
	public void setFreetime_id(int freetime_id) {
		this.freetime_id = freetime_id;
	}
	public int getOpentime_id() {
		return opentime_id;
	}
	public void setOpentime_id(int opentime_id) {
		this.opentime_id = opentime_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
