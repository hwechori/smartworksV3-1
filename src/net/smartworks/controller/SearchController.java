/*	
 * $Id: CommunityController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
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
public class SearchController {

	@RequestMapping("/available_chatter")
	public ModelAndView availableChatter(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/available_chatter.jsp",
				"");
	}

	@RequestMapping("/community")
	public ModelAndView community(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/community.jsp",
				"");
	}

	@RequestMapping("/community_member")
	public ModelAndView communityMember(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/community_member.jsp",
				"");
	}

	@RequestMapping("/my_running_instance")
	public ModelAndView myRunningInstance(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/my_running_instance.jsp",
				"");
	}

	@RequestMapping("/work")
	public ModelAndView work(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/work.jsp",
				"");
	}

	@RequestMapping("/work_name")
	public ModelAndView workName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/work_name.jsp",
				"");
	}

	@RequestMapping("/community_name")
	public ModelAndView communityName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/community_name.jsp",
				"");
	}

	@RequestMapping("/user_name")
	public ModelAndView userName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/search/user_name.jsp",
				"");
	}
	
	@RequestMapping("/search_filter")
	public ModelAndView searchFilter(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/search_filter.jsp", "");
	}

	
	@RequestMapping("/date_field")
	public ModelAndView dateField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/date_field.jsp", "");
	}
	
	@RequestMapping("/boolean_field")
	public ModelAndView booleanField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/boolean_field.jsp", "");
	}
	
	@RequestMapping("/datetime_field")
	public ModelAndView datetimeField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/datetime_field.jsp", "");
	}
	
	@RequestMapping("/file_field")
	public ModelAndView fileField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/file_field.jsp", "");
	}
	
	@RequestMapping("/number_field")
	public ModelAndView numberField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/number_field.jsp", "");
	}
	
	@RequestMapping("/string_field")
	public ModelAndView stringField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/string_field.jsp", "");
	}
	
	@RequestMapping("/time_field")
	public ModelAndView timeField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/time_field.jsp", "");
	}
	
	@RequestMapping("/user_field")
	public ModelAndView userField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/user_field.jsp", "");
	}
	
	@RequestMapping("/work_field")
	public ModelAndView workField(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/filter/work_field.jsp", "");
	}

}