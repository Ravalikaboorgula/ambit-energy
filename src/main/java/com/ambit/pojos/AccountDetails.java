package com.ambit.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "AMBIT_ENERGY")
public class AccountDetails implements Comparable<AccountDetails>
{
	@Id
	//@GeneratedValue
	@Column(name="meter_Number")
	private Integer meter_Number;
	
	@Column(name="billing_Days")
	private int billingDays;
	
	@Column(name="Actual_type")
	private String Actualtype;
	
	@Column(name="meter_Multiplier")
	private int meterMultiplier;
	
	@Column(name="billed_Usage")
	private int billedUsage;
	
	@Column(name="demand")
	private int demand;
	
	@JsonFormat(pattern="YYYY-MM-DD")
	private String test;
	
	
	
	
	
	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public AccountDetails(Integer meterNumber, int billingDays, String actualtype, int meterMultiplier, int billedUsage,
			int demand, String test) {
		super();
		this.meter_Number = meterNumber;
		this.billingDays = billingDays;
		Actualtype = actualtype;
		this.meterMultiplier = meterMultiplier;
		this.billedUsage = billedUsage;
		this.demand = demand;
		this.test = test;
	}




	public Integer getMeterNumber() {
		return meter_Number;
	}



	public void setMeterNumber(Integer meterNumber) {
		this.meter_Number = meterNumber;
	}



	public int getBillingDays() {
		return billingDays;
	}



	public void setBillingDays(int billingDays) {
		this.billingDays = billingDays;
	}



	public String getActualtype() {
		return Actualtype;
	}



	public void setActualtype(String actualtype) {
		Actualtype = actualtype;
	}



	public int getMeterMultiplier() {
		return meterMultiplier;
	}



	public void setMeterMultiplier(int meterMultiplier) {
		this.meterMultiplier = meterMultiplier;
	}



	public int getBilledUsage() {
		return billedUsage;
	}



	public void setBilledUsage(int billedUsage) {
		this.billedUsage = billedUsage;
	}



	public int getDemand() {
		return demand;
	}



	public void setDemand(int demand) {
		this.demand = demand;
	}



	public int compareTo(AccountDetails o) {
		// TODO Auto-generated method stub
		if(this.getMeterNumber() == o.getMeterNumber())
			return 0;
		else if(this.getMeterNumber() > o.getMeterNumber())
			return 1;
		else
			return -1;
	}
	
	
	
	
	
}
