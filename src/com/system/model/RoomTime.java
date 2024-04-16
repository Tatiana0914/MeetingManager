package com.system.model;

import java.util.Date;

/**
 * 会议室可用时间段实体类
 */
public class RoomTime {
	private int freetime_id;
	private int room_id;
	private int opentime_id;
	private Date date;
	private int seat;
	private int order_flag;
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
	public int getOpentime_id() {
		return opentime_id;
	}
	public void setOpentime_id(int opentime_id) {
		this.opentime_id = opentime_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getOrder_flag() {
		return order_flag;
	}
	public void setOrder_flag(int order_flag) {
		this.order_flag = order_flag;
	}
}
