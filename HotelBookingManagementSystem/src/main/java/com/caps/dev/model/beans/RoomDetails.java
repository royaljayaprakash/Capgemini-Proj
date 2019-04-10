package com.caps.dev.model.beans;

import com.mysql.cj.jdbc.Blob;

public class RoomDetails {
	private int hotelId;
	private int roomId;
	private int roomNo;
	private String roomType;
	private int perNightRate;
	private boolean availability;
	private Blob photo;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getPerNightRate() {
		return perNightRate;
	}

	public void setPerNightRate(int perNightRate) {
		this.perNightRate = perNightRate;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "RoomDetails [hotelId=" + hotelId + ", roomId=" + roomId + ", roomNo=" + roomNo + ", roomType="
				+ roomType + ", perNightRate=" + perNightRate + ", availability=" + availability + ", photo=" + photo
				+ "]";
	}

}
