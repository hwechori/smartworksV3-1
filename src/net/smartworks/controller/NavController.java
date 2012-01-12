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

import net.smartworks.service.ISmartWorks;
import net.smartworks.util.SmartUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavController {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/community_members.sw")
	public ModelAndView communityMembers(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request,
				"jsp/nav/community_members.jsp",
				"");
	}

	@RequestMapping("/members_by_community")
	public ModelAndView membersByCommunity(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/nav/members_by_community.jsp",
				"");
	}

	@RequestMapping("/my_all_works")
	public ModelAndView myAllWorks(HttpServletRequest request,
			HttpServletResponse response) {
		
		SmartUtil.publishMessage("broadcasting", "BCAST", new String[]{"좋은하루입니다. ㅎㅎㅎ", "내일은 일요일입니다. 절대 토요일이 아닙니다. ㅋㅋ"} );
		return SmartUtil.returnMnv(request, "jsp/nav/my_all_works.jsp",
				"");
	}

	@RequestMapping("/my_departments")
	public ModelAndView myDepartments(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/nav/my_departments.jsp",
				"");
	}

	@RequestMapping("/my_favorite_works")
	public ModelAndView myFavoriteWorks(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/nav/my_favorite_works.jsp",
				"");
	}

	@RequestMapping("/my_groups")
	public ModelAndView myGroups(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/nav/my_groups.jsp",
				"");
	}

	@RequestMapping("/my_recent_instances")
	public ModelAndView myRecentInstances(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/nav/my_recent_instances.jsp",
				"");
	}

	@RequestMapping("/worklist_by_category")
	public ModelAndView worklistByCategory(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/nav/worklist_by_category.jsp",
				"");
	}

	@RequestMapping(value = "/add_a_favorite_work", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void addAFavoriteWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.addAFavoriteWork(request);
	}

	@RequestMapping(value = "/remove_a_favorite_work", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void removeAFavoriteWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeAFavoriteWork(request);
	}

}