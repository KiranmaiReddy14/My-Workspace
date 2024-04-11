package com.mailorderpharma.webportal.controller;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mailorderpharma.webportal.entity.AdHocModel;
import com.mailorderpharma.webportal.entity.DateModel;
import com.mailorderpharma.webportal.entity.PrescriptionDetails;
import com.mailorderpharma.webportal.entity.SearchById;
import com.mailorderpharma.webportal.entity.UserData;
import com.mailorderpharma.webportal.exceptions.DrugQuantityNotAvailable;
import com.mailorderpharma.webportal.exceptions.InvalidTokenException;
import com.mailorderpharma.webportal.restclients.DrugClient;
import com.mailorderpharma.webportal.service.PortalService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebPortalController {

	@Autowired
	private PortalService portalService;

	@Autowired
	DrugClient drugClient;

	/* Login end-points */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String postLogin(@ModelAttribute UserData user, HttpSession session, ModelMap warning)
			throws FeignException {
		return portalService.postLogin(user, session, warning);
	}

	@GetMapping("/home")
	public String getWelcome(HttpSession session) throws FeignException {
		return portalService.getWelcome((String) session.getAttribute("token"));
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) throws FeignException {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/supportedDrugs")
	public String getSupportedDrugs(HttpSession session, ModelMap warning) {
		if (portalService.isSessionValid(session))
			return postSupportedDrugs(session, warning);
		return "redirect:/";
	}

	@PostMapping(path = "/supportedDrugs")
	public String postSupportedDrugs(HttpSession session, ModelMap warning) throws FeignException {
		return portalService.getSupportedDrugs(session, warning);
	}

	@GetMapping("/prescriptionform")
	public String getPrescriptionForm(HttpSession session) {
		if (portalService.isSessionValid(session))
			return "prescription";
		return "redirect:/";
	}

	@PostMapping("/subscribe")
	public ModelAndView subscribe(@ModelAttribute PrescriptionDetails prescriptionDetails, HttpSession session)
			throws FeignException {
		ModelAndView view = new ModelAndView("prescription");
		view.addObject("msg", portalService.subscribe(prescriptionDetails, session));
		return view;
	}

	@GetMapping("/subscriptions")
	public String getAllSubscriptions(HttpSession session, Model model) throws FeignException {
		return portalService.postSubscriptions(session, model);
	}

	@PostMapping("/unsubscribe/{sId}")
	public String getSubsAfterUnsubscribe(@PathVariable Long sId, HttpSession session, Model model) {

		return portalService.unsubscribe(session, sId);
	}

	@PostMapping("/refillDueAsOfDate")
	public String getRefillDueAsofDate(@ModelAttribute DateModel dateModel, HttpSession session, Model model)
			throws NumberFormatException, InvalidTokenException {
		return portalService.getRefillDueAsofDate(session, dateModel, model);
	}

	@GetMapping("/refillDateEntry")
	public ModelAndView refillDateEntry() {
		return new ModelAndView("refillDateEntry");
	}

	@GetMapping("/adhocRefill/{sId}")
	public String adhocRefill(@PathVariable("sId") Long sId, HttpSession session) {
		session.setAttribute("sub_Id", sId);
		return "adhocRefill";
	}

	@PostMapping("/postAdhocRefill")
	public ModelAndView postAdHocDetails(@ModelAttribute AdHocModel adHocModel, HttpSession session)
			throws NumberFormatException, FeignException, ParseException, InvalidTokenException,
			DrugQuantityNotAvailable {
		ModelAndView view = new ModelAndView("refillstatus");
		return portalService.requestAdhocRefill(session, adHocModel, view);
	}

	@GetMapping("/refillstatus")
	public ModelAndView refillStatus() {
		return new ModelAndView("refillstatus");
	}

	@GetMapping("/search")
	public String search() {
		return "search";
	}

	@PostMapping("/searchDrugById")
	public ModelAndView searchDrugById(HttpSession session, @ModelAttribute SearchById searchModel) {
		ModelAndView view = new ModelAndView("search");
		view.addObject("id", searchModel.getId());
		view.addObject("drugdetails", portalService.searchById(session, searchModel));
		return view;
	}

	@PostMapping("/searchDrugByName")
	public ModelAndView searchDrugByName(HttpSession session, @ModelAttribute SearchById searchModel) {
		ModelAndView view = new ModelAndView("search");
		view.addObject("name", searchModel.getName());
		view.addObject("drugdetails", portalService.searchByName(session, searchModel));
		return view;
	}
}
