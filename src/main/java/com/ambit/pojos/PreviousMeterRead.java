package com.ambit.pojos;

import java.util.Date;

public class PreviousMeterRead {
	
	private Date date;
	private int read;
	
	
	
	public PreviousMeterRead() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PreviousMeterRead(Date date, int read) {
		super();
		this.date = date;
		this.read = read;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	

}
