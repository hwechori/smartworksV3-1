/*	
 * $Id: ContentController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 10. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.service.ISmartWorks;
import net.smartworks.util.SmartUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingsController {
	
	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/settings_home")
	public ModelAndView settings(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/home.jsp", "settings_home.tiles");
	}

	@RequestMapping("/company_general")
	public ModelAndView companyGeneral(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/company_general.jsp", "company_general.tiles");
	}

	@RequestMapping("/company_work_hour")
	public ModelAndView companyWorkHour(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/company_work_hour.jsp", "company_work_hour.tiles");
	}

	@RequestMapping("/company_event")
	public ModelAndView companyCalendar(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/company_event.jsp", "company_event.tiles");
	}

	@RequestMapping("/organization_management")
	public ModelAndView organizationManagement(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/organization_management.jsp", "organization_management.tiles");
	}

	@RequestMapping("/approval_line")
	public ModelAndView approvalLine(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/approval_line.jsp", "approval_line.tiles");
	}

	@RequestMapping("/web_service")
	public ModelAndView webserviceManagement(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/web_service.jsp", "web_service.tiles");
	}

	@RequestMapping("/external_form")
	public ModelAndView externalformManagement(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/external_form.jsp", "external_form.tiles");
	}

	@RequestMapping(value = "/set_company_general", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setCompanyGeneral(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setCompanyGeneral(requestBody, request);
	}
	
	@RequestMapping("/edit_work_hour")
	public ModelAndView editWorkHour(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/edit_work_hour.jsp", "edit_work_hour.tiles");
	}

	@RequestMapping(value = "/create_work_hour_policy", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createWorkHourPolicy(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setWorkHourPolicy(requestBody, request);
	}
	
	@RequestMapping(value = "/set_work_hour_policy", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setWorkHourPolicy(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setWorkHourPolicy(requestBody, request);
	}
	
	@RequestMapping(value = "/remove_work_hour_policy", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void removeHorkHourPolicy(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeWorkHourPolicy(requestBody, request);
	}
	
	@RequestMapping("/edit_company_event")
	public ModelAndView editCompanyEvent(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/edit_company_event.jsp", "edit_company_event.tiles");
	}

	@RequestMapping(value = "/create_company_event", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createCompanyEvent(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setCompanyEvent(requestBody, request);
	}
	
	@RequestMapping(value = "/set_company_event", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setCompanyEvent(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setCompanyEvent(requestBody, request);
	}
	
	@RequestMapping(value = "/remove_company_event", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void removeCompanyEvent(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeCompanyEvent(requestBody, request);
	}
	
	@RequestMapping("/edit_approval_line")
	public ModelAndView editApprovalLine(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/edit_approval_line.jsp", "edit_approval_line.tiles");
	}

	@RequestMapping(value = "/create_approval_line", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createApprovalLine(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setApprovalLine(requestBody, request);
	}
	
	@RequestMapping(value = "/set_approval_line", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setApprovalLine(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setApprovalLine(requestBody, request);
	}
	
	@RequestMapping(value = "/remove_approval_line", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void removeApprovalLine(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeApprovalLine(requestBody, request);
	}
	
	@RequestMapping("/edit_web_service")
	public ModelAndView editWebService(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/edit_web_service.jsp", "edit_web_service.tiles");
	}

	@RequestMapping("/wsdl_detail")
	public ModelAndView wsdlDetail(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/wsdl_detail.jsp", "");
	}

	@RequestMapping(value = "/create_web_service", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createWebService(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setWebService(requestBody, request);
	}
	
	@RequestMapping(value = "/set_web_service", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setWebService(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setWebService(requestBody, request);
	}
	
	@RequestMapping(value = "/remove_web_service", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void removeWebService(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeWebService(requestBody, request);
	}
	
	@RequestMapping("/edit_external_form")
	public ModelAndView editExternalForm(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/edit_external_form.jsp", "edit_external_form.tiles");
	}

	@RequestMapping(value = "/create_external_form", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createExternalForm(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setExternalForm(requestBody, request);
	}
	
	@RequestMapping(value = "/set_external_form", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setExternalForm(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setExternalForm(requestBody, request);
	}
	
	@RequestMapping(value = "/remove_external_form", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void removeExternalForm(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeExternalForm(requestBody, request);
	}
	
	@RequestMapping("/comlist_by_depart")
	public ModelAndView comlistByDepart(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/comlist_by_depart.jsp", "");
	}

	@RequestMapping("/edit_member")
	public ModelAndView editMember(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/edit_member.jsp", "");
	}

	@RequestMapping(value = "/create_member", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createMember(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setMember(requestBody, request);
	}
	
	@RequestMapping(value = "/set_member", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setMember(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setMember(requestBody, request);
	}
	
	@RequestMapping(value = "/remove_member", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void removeMember(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeMember(requestBody, request);
	}
	
	@RequestMapping("/edit_department")
	public ModelAndView editDepartment(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/settings/edit_department.jsp", "");
	}

	@RequestMapping(value = "/create_department", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createDepartment(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setDepartment(requestBody, request);
	}
	
	@RequestMapping(value = "/set_department", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void setDepartment(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.setDepartment(requestBody, request);
	}
	
	@RequestMapping(value = "/remove_department", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void removeDepartment(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeDepartment(requestBody, request);
	}

	@RequestMapping(value = "/check_id_duplication", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void checkIdDuplication(HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.checkIdDuplication(request);
	}
	
}
