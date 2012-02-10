/*	
 * $Id: ContentController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 10. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingsController {
	
	@RequestMapping("/settings_home")
	public ModelAndView settings(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/home.jsp", "settings_home.tiles");
	}

	@RequestMapping("/company_general")
	public ModelAndView companyGeneral(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/company_general.jsp", "company_general.tiles");
	}

	@RequestMapping("/company_mailing")
	public ModelAndView companyMailing(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/company_mailing.jsp", "company_mailing.tiles");
	}

	@RequestMapping("/company_work_hour")
	public ModelAndView companyWorkHour(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/company_work_hour.jsp", "company_work_hour.tiles");
	}

	@RequestMapping("/company_calendar")
	public ModelAndView companyCalendar(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/company_calendar.jsp", "company_calendar.tiles");
	}

	@RequestMapping("/organization_management")
	public ModelAndView organizationManagement(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/organization_management.jsp", "organization_management.tiles");
	}

	@RequestMapping("/approval_line")
	public ModelAndView approvalLine(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/approval_line.jsp", "approval_line.tiles");
	}

	@RequestMapping("/webservice_management")
	public ModelAndView webserviceManagement(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/webservice_management.jsp", "webservice_management.tiles");
	}

	@RequestMapping("/externalform_management")
	public ModelAndView externalformManagement(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/externalform_management.jsp", "externalform_management.tiles");
	}

}
