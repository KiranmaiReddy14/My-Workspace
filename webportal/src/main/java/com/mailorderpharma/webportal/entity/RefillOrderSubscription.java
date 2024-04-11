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
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	long subscriptionId;
	String memberId;
	int refillQuantity;
	int refillTime;
	

}
