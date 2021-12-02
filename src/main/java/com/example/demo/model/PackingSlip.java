package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PackingSlip {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	int packageId;
	String ordertype;
	String orderId;
	double orderAmount;
	double commissionPayment;
	
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public double getCommissionPayment() {
		return commissionPayment;
	}
	public void setCommissionPayment(double commissionPayment) {
		this.commissionPayment = commissionPayment;
	}
	
}
