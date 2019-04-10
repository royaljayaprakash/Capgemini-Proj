package com.caps.dev.model.beans;

public class Hotel {
	private int hotelId;
	private String hotelName;
	private String address;
	private int avgRatePerNight;
	private String mobileno1;
	private String mobileno2;
	private String rating;
	private String email;
	private String fax;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAvgRatePerNight() {
		return avgRatePerNight;
	}

	public void setAvgRatePerNight(int avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	public String getMobileno1() {
		return mobileno1;
	}

	public void setMobileno1(String mobileno1) {
		this.mobileno1 = mobileno1;
	}

	public String getMobileno2() {
		return mobileno2;
	}

	public void setMobileno2(String mobileno2) {
		this.mobileno2 = mobileno2;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", avgRatePerNight="
				+ avgRatePerNight + ", mobileno1=" + mobileno1 + ", mobileno2=" + mobileno2 + ", rating=" + rating
				+ ", email=" + email + ", fax=" + fax + "]";
	}

}
