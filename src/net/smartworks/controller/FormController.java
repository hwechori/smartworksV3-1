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
public class FormController {

	@RequestMapping("/load_view_form")
	public ModelAndView loadViewForm(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/form/load_view_form.jsp",
				"");
	}

	@RequestMapping("/load_brief_form")
	public ModelAndView loadBriefForm(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/form/load_brief_form.jsp",
				"");
	}

	@RequestMapping("/load_detail_form")
	public ModelAndView loadDetailForm(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/form/load_detail_form.jsp",
				"");
	}

	@RequestMapping("/file_detail_form")
	public ModelAndView fileDetailForm(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/form/file_detail_form.jsp",
				"");
	}
	
	@RequestMapping("/date_field")
	public ModelAndView dateField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/date_field.jsp", "");
	}
	
	@RequestMapping("/boolean_field")
	public ModelAndView booleanField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/boolean_field.jsp", "");
	}
	
	@RequestMapping("/datetime_field")
	public ModelAndView datetimeField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/datetime_field.jsp", "");
	}
	
	@RequestMapping("/file_field")
	public ModelAndView fileField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/file_field.jsp", "");
	}
	
	@RequestMapping("/number_field")
	public ModelAndView numberField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/number_field.jsp", "");
	}
	
	@RequestMapping("/string_field")
	public ModelAndView stringField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/string_field.jsp", "");
	}
	
	@RequestMapping("/time_field")
	public ModelAndView timeField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/time_field.jsp", "");
	}
	
	@RequestMapping("/user_field")
	public ModelAndView userField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/user_field.jsp", "");
	}
	
	@RequestMapping("/work_field")
	public ModelAndView workField(HttpServletRequest request, HttpServletResponse response) {
	
		return SmartUtil.returnMnv(request, "jsp/content/work/field/work_field.jsp", "");
	}
}