package com.mailorderpharma.webportal.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateModel {
	 @DateTimeFormat(pattern = "yyyy-mm-dd")
	Date date;
}
