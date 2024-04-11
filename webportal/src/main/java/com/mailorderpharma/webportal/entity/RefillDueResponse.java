package com.mailorderpharma.webportal.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefillDueResponse {

	String drugName;
	long id;
	long subscriptionId;
	String memberId;
	int refillQuantity;
	int refillTime;
	LocalDate date;

	public RefillDueResponse(String drugName, long id, long subscriptionId, String memberId, int refillQuantity,
			int refillTime, LocalDate date) {
		super();
		this.drugName = drugName;
		this.id = id;
		this.subscriptionId = subscriptionId;
		this.memberId = memberId;
		this.refillQuantity = refillQuantity;
		this.refillTime = refillTime;
		this.date = date;
	}
}
