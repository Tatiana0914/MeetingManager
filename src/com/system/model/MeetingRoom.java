package com.system.model;

/**
 * 会议室类
 */
public class MeetingRoom {
	private int room_id;
	private int building_id;
	private String building_name;
	private String roomname;
	private int seat;
	
	public MeetingRoom() {
	}
	public MeetingRoom(int room_id, int building_id, String building_name, String roomname, int seat) {
		this.room_id = room_id;
		this.building_id = building_id;
		this.building_name = building_name;
		this.roomname = roomname;
		this.seat = seat;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
