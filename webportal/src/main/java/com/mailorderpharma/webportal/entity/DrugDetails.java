package com.mailorderpharma.webportal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugDetails {

	@Id
	private String drugId;
	private String drugName;
	private String manufacturer;
	private Date manufactureDate;
	private Date expiryDate;
	
	private String msg;

	@OneToMany(mappedBy="drugDetails")
	private List<DrugLocationDetails> druglocationQuantities = new ArrayList<DrugLocationDetails>();
}