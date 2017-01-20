package com.tcs.bean;



public class Room{
	private int roomNo;
	private String category;
	private String specality;
	private double tariff;
	private String ADStatus;
	private int CategoryId;
	private String startDate;
	private String endDate;
	private String image;
	
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
	public String getSpecality() {
		return specality;
	}
	public void setSpecality(String specality) {
		this.specality = specality;
	}
	public double getTariff() {
		return tariff;
	}
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	public String getADStatus() {
		return ADStatus;
	}
	public void setADStatus(String aDStatus) {
		ADStatus = aDStatus;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
