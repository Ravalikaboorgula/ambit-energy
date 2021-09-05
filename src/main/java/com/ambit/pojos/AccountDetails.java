package com.ambit.pojos;

import javax.persistence.Entity;

@Entity
public class AccountDetails implements Comparable<AccountDetails>
{
	
	private int MeterNumber;
	private int BillingDays;
	private String Actualtype;
	private PreviousMeterRead PreviousMeterRead;
	private CurrentMeterRead CurrentMeterRead;
	private int MeterMultiplier;
	private int BilledUsage;
	private int Demand;
	private Customer customer;
	
	
	
	
	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public AccountDetails(int meterNumber, int billingDays, String actualtype,
			com.ambit.pojos.PreviousMeterRead previousMeterRead, com.ambit.pojos.CurrentMeterRead currentMeterRead,
			int meterMultiplier, int billedUsage, int demand, Customer customer) {
		super();
		MeterNumber = meterNumber;
		BillingDays = billingDays;
		Actualtype = actualtype;
		PreviousMeterRead = previousMeterRead;
		CurrentMeterRead = currentMeterRead;
		MeterMultiplier = meterMultiplier;
		BilledUsage = billedUsage;
		Demand = demand;
		this.customer = customer;
	}

	
	public int getMeterNumber() {
		return MeterNumber;
	}
	public void setMeterNumber(int meterNumber) {
		MeterNumber = meterNumber;
	}
	public int getBillingDays() {
		return BillingDays;
	}
	public void setBillingDays(int billingDays) {
		BillingDays = billingDays;
	}
	public String getActualtype() {
		return Actualtype;
	}
	public void setActualtype(String actualtype) {
		Actualtype = actualtype;
	}
	public PreviousMeterRead getPreviousMeterRead() {
		return PreviousMeterRead;
	}
	public void setPreviousMeterRead(PreviousMeterRead previousMeterRead) {
		PreviousMeterRead = previousMeterRead;
	}
	public CurrentMeterRead getCurrentMeterRead() {
		return CurrentMeterRead;
	}
	public void setCurrentMeterRead(CurrentMeterRead currentMeterRead) {
		CurrentMeterRead = currentMeterRead;
	}
	public int getMeterMultiplier() {
		return MeterMultiplier;
	}
	public void setMeterMultiplier(int meterMultiplier) {
		MeterMultiplier = meterMultiplier;
	}
	public int getBilledUsage() {
		return BilledUsage;
	}
	public void setBilledUsage(int billedUsage) {
		BilledUsage = billedUsage;
	}
	public int getDemand() {
		return Demand;
	}
	public void setDemand(int demand) {
		Demand = demand;
	}
	public int compareTo(AccountDetails o) {
		// TODO Auto-generated method stub
		if(this.customer.getCustomerId() == o.getCustomer().getCustomerId())
			return 0;
		else if(this.customer.getCustomerId() > o.getCustomer().getCustomerId())
			return 1;
		else
			return -1;
	}
	
	
	
	
	
}
