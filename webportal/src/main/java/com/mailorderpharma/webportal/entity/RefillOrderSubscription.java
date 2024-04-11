package com.mailorderpharma.webportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "RefillOrderSubscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RefillOrderSubscription")
public class RefillOrderSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	long subscriptionId;
	String memberId;
	int refillQuantity;
	int refillTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getRefillQuantity() {
		return refillQuantity;
	}

	public void setRefillQuantity(int refillQuantity) {
		this.refillQuantity = refillQuantity;
	}

	public int getRefillTime() {
		return refillTime;
	}

	public void setRefillTime(int refillTime) {
		this.refillTime = refillTime;
	}

}
