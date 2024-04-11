package com.mailorderpharma.webportal.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.mailorderpharma.webportal.entity.AdHocModel;
import com.mailorderpharma.webportal.entity.AuthResponse;
import com.mailorderpharma.webportal.entity.DateModel;
import com.mailorderpharma.webportal.entity.DrugDetails;
import com.mailorderpharma.webportal.entity.PrescriptionDetails;
import com.mailorderpharma.webportal.entity.RefillDueResponse;
import com.mailorderpharma.webportal.entity.RefillOrder;
import com.mailorderpharma.webportal.entity.RefillOrderSubscription;
import com.mailorderpharma.webportal.entity.SearchById;
import com.mailorderpharma.webportal.entity.SubscriptionDetails;
import com.mailorderpharma.webportal.entity.UserData;
import com.mailorderpharma.webportal.exceptions.DrugQuantityNotAvailable;
import com.mailorderpharma.webportal.exceptions.InvalidTokenException;
import com.mailorderpharma.webportal.restclients.AuthClient;
import com.mailorderpharma.webportal.restclients.DrugClient;
import com.mailorderpharma.webportal.restclients.RefillClient;
import com.mailorderpharma.webportal.restclients.SubscriptionClient;

import feign.FeignException;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PortalServiceImpl implements PortalService {

	@Autowired
	AuthClient authClient;
	@Autowired
	SubscriptionClient subscriptionClient;
	@Autowired
	DrugClient drugClient;
	@Autowired
	RefillClient refillClient;

	@SuppressWarnings("unused")
	private AuthResponse authResponse;

	@Override
	public Boolean isSessionValid(HttpSession session) {
		try {
			authResponse = authClient.getValidity((String) session.getAttribute("token"));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public String postLogin(UserData user, HttpSession session, ModelMap warning) {
		UserData res = null;
		try {
			res = authClient.login(user);
			//log.info("inn login post login success");
		} catch (Exception e) {
			String errmsg = "";
			if (e.getClass().toString().contains("feign.RetryableException"))
				errmsg = "Site is Temporarily down. Try again later.";
			else
				errmsg = "Unable to login. please check your credentials.";
			warning.addAttribute("errormsg", errmsg);
			return "login";
		}
		session.setAttribute("token", "Bearer " + res.getAuthToken());
		session.setAttribute("memberId", res.getUserid());
		return getWelcome((String) session.getAttribute("token"));
	}

	@Override
	public String getWelcome(String token) {
		try {
			authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return "redirect:/";
		}
		return "welcome";

	}

	@Override
	public String getSupportedDrugs(HttpSession session, ModelMap modelMap) {
		try {
			String token = (String) session.getAttribute("token");
			authResponse = authClient.getValidity(token);
		} catch (ExpiredJwtException e) {
			modelMap.addAttribute("Warning", "Please login again");
			return "redirect:/";
		}
		try {
			//log.info("2");
			List<DrugDetails> drugList = drugClient.getAllDrugs();
			modelMap.addAttribute("drugList", drugList);
			//log.info("4");
		}

		catch (NullPointerException e) {
			modelMap.addAttribute("Warning", "Null Pointer");
			return "redirect:/";
		}
		return "availabledrugs";

	}

	@Override
	public String subscribe(PrescriptionDetails prescriptionDetails, HttpSession session) throws FeignException {
		try {
			authResponse = authClient.getValidity((String) session.getAttribute("token"));
		} catch (Exception e) {
			//log.info(e.getClass().toString());
			return "session expired...Please login again";
		}
		prescriptionDetails.setMemberId((String) session.getAttribute("memberId"));
		String msg = "";
		try {
			msg = subscriptionClient.subscribe((String) session.getAttribute("token"), prescriptionDetails);
		} catch (Exception e) {
			//log.info("in catch portalservice subscribe method " + e.getMessage() + " " + e.getClass().toString());
			if (e.getClass().toString().contains("feign.RetryableException")
					|| e.getClass().toString().contains("UndeclaredThrowableException"))
				msg = "Service is Temporarily down. Try again later.";
			else if (e.getMessage().toString().contains("Content is not available"))
				msg = "Currently we do not support this Medicine.";
		}
		return msg;
	}

	public List<SubscriptionDetails> getSubscriptions(HttpSession session, Model model) {
		List<SubscriptionDetails> subscriptionList = null;
		try {
			subscriptionList = subscriptionClient.getAllSubscriptionsforMember((String) session.getAttribute("token"),
					(String) session.getAttribute("memberId"));

			//log.info(subscriptionList.toString());

			model.addAttribute("subscriptionList", subscriptionList);
		} catch (Exception e) {
			//log.info("hey" + e.getClass().toString());
			if (e.getClass().toString().contains("feign.RetryableException")) {
				model.addAttribute("msg", "Service is Temporarily down. Try again later.");
			} else
				model.addAttribute("msg", "No Subscriptions? Check out our vast range of medicines.");

		}
		return subscriptionList;

	}

	@Override
	public String postSubscriptions(HttpSession session, Model model) {
		try {
			authResponse = authClient.getValidity((String) session.getAttribute("token"));
		} catch (Exception e) {
			//log.info("hey" + e.getClass().toString());
			return "redirect:/";
		}
		//log.info("token validation success");
		getSubscriptions(session, model);
		return "subscriptions";
	}

	@Override
	public String unsubscribe(HttpSession session, Long sId) {
		try {
			authResponse = authClient.getValidity((String) session.getAttribute("token"));
		} catch (Exception e) {
			//log.info("hey" + e.getClass().toString());
			return "redirect:/";
		}
		subscriptionClient.unsubscribe((String) session.getAttribute("token"),
				(String) session.getAttribute("memberId"), sId);

		return "redirect:/subscriptions";
	}

	@Override
	public String getRefillDueAsofDate(HttpSession session, DateModel dateModel, Model model)
			throws NumberFormatException, InvalidTokenException {
		List<RefillOrderSubscription> refillOrderSubscriptions = null;
		String token = (String) session.getAttribute("token");
		try {
			authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			//log.info("hey" + e.getClass().toString());
			return "redirect:/";
		}
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		String str = format.format(dateModel.getDate());
		try {
			refillOrderSubscriptions = refillClient.getRefillDuesAsOfDate(token,
					(String) session.getAttribute("memberId"), Integer.parseInt(str.substring(8, 10))).getBody();
			//log.info("refillOrderSubscriptions " + refillOrderSubscriptions.toString());
		} catch (Exception e) {
			//log.info("hey" + e.getClass().toString());
			if (e.getClass().toString().contains("feign.RetryableException")
					|| e.getClass().toString().contains("UndeclaredThrowableException")) {
				model.addAttribute("msg", "Service is Temporarily down. Try again later.");
				return "refillDueAsofDate";
			} else {
				model.addAttribute("msg", "Something went wrong. Try again later.");
				return "refillDueAsofDate";
			}
		}
		List<RefillDueResponse> refillDueList = getDrugNamesBySubId(refillOrderSubscriptions, token, session, model);
		if (refillDueList == null || refillDueList.isEmpty())
			model.addAttribute("msg", "Sit back and relax, there are no refill dues.");
		else
			model.addAttribute("refillResponses", refillDueList);
		for (RefillDueResponse r : refillDueList) {
			//log.info("refillDues--------" + r.getDrugName());
		}

//		return getDrugNamesBySubId(refillOrderSubscriptions, token, session,model);
		return "refillDueAsofDate";
	}

	@Override
	public ModelAndView requestAdhocRefill(HttpSession session, AdHocModel adHocModel, ModelAndView view)
			throws NumberFormatException, FeignException, ParseException, InvalidTokenException,
			DrugQuantityNotAvailable {

		try {
			authResponse = authClient.getValidity((String) session.getAttribute("token"));
		} catch (Exception e) {
			//log.info("hey" + e.getClass().toString());
//			return "redirect:/";
		}
		RefillOrder refillOrder = null;
		try {
			refillOrder = refillClient
					.requestAdhocRefill((String) session.getAttribute("token"), ((long) session.getAttribute("sub_Id")),
							adHocModel.isPaymentStatus(), adHocModel.getQuantity(), adHocModel.getLocation())
					.getBody();
			//log.info("service method requestadhoc after feign"+refillOrder.getPayStatus());
		} catch (Exception e) {
			//log.info(e.getClass().toString() + " clas---  msg " + e.getMessage());
//			view.addObject("ackmsg", "cannot request refill.Try again later.");
		}
		if (refillOrder == null)
			view.addObject("ackmsg", "Sorry request is not valid.");
		else
			view.addObject("ackmsg", "Order placed successfully");
		
		view.addObject("msg", refillOrder);
		return view;
	}

	public List<RefillDueResponse> getDrugNamesBySubId(List<RefillOrderSubscription> refillOrderSubscription,
			String token, HttpSession session, Model model) {
		List<String> drugNames = new ArrayList<>();
		List<RefillDueResponse> refillResponses = new ArrayList<>();
		List<SubscriptionDetails> details = getSubscriptions(session, model);
		if (details == null)
			return null;
		for (SubscriptionDetails s : details) {
			drugNames.add(subscriptionClient.getDrugNameBySubscriptionId(token, s.getSubscriptionId()));
		}
		Map<Long, String> drugList = new HashMap<Long, String>();
		for (int itr = drugNames.size() - 1; itr >= 0; itr--) {
			drugList.put(details.get(itr).getSubscriptionId(), drugNames.get(itr));
		}
		for (int itr = 0; itr < refillOrderSubscription.size(); itr++) {

			long id = refillOrderSubscription.get(itr).getId();
			long subscriptionId = refillOrderSubscription.get(itr).getSubscriptionId();
			String memberId = refillOrderSubscription.get(itr).getMemberId();
			int refillQuantity = refillOrderSubscription.get(itr).getRefillQuantity();
			int refillTime = refillOrderSubscription.get(itr).getRefillTime();
			LocalDate date = null;
			RefillDueResponse refillDueResponse = new RefillDueResponse(drugList.get(subscriptionId), id,
					subscriptionId, memberId, refillQuantity, refillTime,date);
			refillResponses.add(refillDueResponse);
		}
		return refillResponses;
	}
	
	public DrugDetails searchById(HttpSession session,SearchById searchModel){
		String token=(String)session.getAttribute("token");
		String id=searchModel.getId();
		DrugDetails drugdetails=new DrugDetails();
		String msg="";
		try {
			drugdetails=drugClient.getDrugById(token, id);
			drugdetails.setMsg("Drug Details :");
			return drugdetails;
		} catch (Exception e) {
			log.info("in catch portalservice searchById method " + e.getMessage() + " " + e.getClass().toString());
			if (e.getClass().toString().contains("feign.RetryableException")
					|| e.getClass().toString().contains("UndeclaredThrowableException"))
				msg = "Service is Temporarily down. Try again later.";
			else if (e.getMessage().toString().contains("Content is not available"))
				msg = "Please search drug by Id.";
		}
		
		drugdetails.setMsg(msg);
		return drugdetails;
	}
	public DrugDetails searchByName(HttpSession session,SearchById searchModel){
		String token=(String)session.getAttribute("token");
		String name=searchModel.getName();
		DrugDetails drugdetails=new DrugDetails();
		String msg="";
		try {
			drugdetails=drugClient.getDrugByName(token, name);
			drugdetails.setMsg("Drug Details :");
			return drugdetails;
		} catch (Exception e) {
			log.info("in catch portalservice searchByName method " + e.getMessage() + " " + e.getClass().toString());
			if (e.getClass().toString().contains("feign.RetryableException")
					|| e.getClass().toString().contains("UndeclaredThrowableException"))
				msg = "Service is Temporarily down. Try again later.";
			else if (e.getMessage().toString().contains("Content is not available"))
				msg = "Please search drug by Name.";
		}
		
		drugdetails.setMsg(msg);
		return drugdetails;
	}
}
