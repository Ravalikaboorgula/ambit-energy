package com.ambit.pojos;

public class Address {
	private String road;
	private int aptNo;
	private String city;
	private String state;
	private int zipcode;
	
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String road, int aptNo, String city, String state, int zipcode) {
		super();
		this.road = road;
		this.aptNo = aptNo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public int getAptNo() {
		return aptNo;
	}
	public void setAptNo(int aptNo) {
		this.aptNo = aptNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
