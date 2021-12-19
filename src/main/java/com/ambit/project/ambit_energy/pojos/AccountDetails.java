package com.ambit.project.ambit_energy.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@Entity
@Table(name = "AMBIT_ENERGY")
public class AccountDetails implements Comparable<AccountDetails> {
	@Id
	@Column(name = "meter_Number")
	private Integer meter_Number;

	@Column(name = "billing_Days")
	private int billingDays;

	@Column(name = "Actual_type")
	private String actualtype;

	@Column(name = "meterMultiplier")
	private int meterMultiplier;

	@Column(name = "billed_Usage")
	private int billedUsage;

	@Column(name = "demand")
	private int demand;

	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDetails(Integer meter_Number, int billingDays, String actualtype, int meterMultiplier,
			int billedUsage, int demand) {
		this.meter_Number = meter_Number;
		this.billingDays = billingDays;
		this.actualtype = actualtype;
		this.meterMultiplier = meterMultiplier;
		this.billedUsage = billedUsage;
		this.demand = demand;

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
		return actualtype;
	}

	public void setActualtype(String actualtype) {
		this.actualtype = actualtype;
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
		if (this.getMeterNumber() == o.getMeterNumber())
			return 0;
		else if (this.getMeterNumber() > o.getMeterNumber())
			return 1;
		else
			return -1;
	}

}
