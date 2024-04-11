package com.mailorderpharma.webportal.entity;

import java.time.LocalDate;

import javax.persistence.Id;

import lombok.Data;

@Data
public class SubscriptionDetails {
	@Id
	private Long subscriptionId;
	private Long prescriptionId;
	private int refillCycle;
	private int quantity;
	private String memberId;
	private LocalDate subscriptionDate;
	private String memberLocation;
	private String subscriptionStatus;
	private String drugName;

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getRefillCycle() {
		return refillCycle;
	}

	public void setRefillCycle(int refillCycle) {
		this.refillCycle = refillCycle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getMemberLocation() {
		return memberLocation;
	}

	public void setMemberLocation(String memberLocation) {
		this.memberLocation = memberLocation;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
}
