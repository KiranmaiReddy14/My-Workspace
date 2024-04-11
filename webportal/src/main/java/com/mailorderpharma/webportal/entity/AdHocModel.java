package com.mailorderpharma.webportal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdHocModel {

	public int quantity;
	public String location;
	public boolean paymentStatus;
	
}