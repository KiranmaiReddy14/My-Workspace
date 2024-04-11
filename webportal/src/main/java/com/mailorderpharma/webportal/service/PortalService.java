package com.mailorderpharma.webportal.service;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.mailorderpharma.webportal.entity.AdHocModel;
import com.mailorderpharma.webportal.entity.DateModel;
import com.mailorderpharma.webportal.entity.DrugDetails;
import com.mailorderpharma.webportal.entity.PrescriptionDetails;
import com.mailorderpharma.webportal.entity.RefillOrder;
import com.mailorderpharma.webportal.entity.SearchById;
import com.mailorderpharma.webportal.entity.UserData;
import com.mailorderpharma.webportal.exceptions.DrugQuantityNotAvailable;
import com.mailorderpharma.webportal.exceptions.InvalidTokenException;

import feign.FeignException;

public interface PortalService {

	Boolean isSessionValid(HttpSession session);

	String postLogin(UserData user, HttpSession session, ModelMap warning);

	String getWelcome(String attribute);

	String subscribe(PrescriptionDetails prescriptionDetails, HttpSession session);

	String unsubscribe(HttpSession session, Long sId);

	String getSupportedDrugs(HttpSession session, ModelMap modelMap);

	ModelAndView requestAdhocRefill(HttpSession session, AdHocModel adHocModel, ModelAndView view) throws NumberFormatException,
			FeignException, ParseException, InvalidTokenException, DrugQuantityNotAvailable;

	String postSubscriptions(HttpSession session, Model model);

	String getRefillDueAsofDate( HttpSession session, DateModel dateModel, Model model)
			throws NumberFormatException, InvalidTokenException;
	public DrugDetails searchById(HttpSession session,SearchById searchModel);
	public DrugDetails searchByName(HttpSession session,SearchById searchModel);
}
