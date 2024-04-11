package com.mailorderpharma.webportal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RefillDueAsOfDateModel {

	String memberId;
	int date;
}
