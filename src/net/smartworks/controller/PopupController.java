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
public class PopupController {
	
	@RequestMapping("/pop_user_info")
	public ModelAndView popUserInfo(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_user_info.jsp",
				"jsp/popup/pop_user_info.jsp");
	}

	@RequestMapping("/pop_select_user")
	public ModelAndView popSelectUser(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_select_user.jsp",
				"jsp/popup/pop_select_user.jsp");
	}

	@RequestMapping("/pop_select_work")
	public ModelAndView popSelectWork(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_select_work.jsp",
				"jsp/popup/pop_select_work.jsp");
	}

	@RequestMapping("/pop_select_work_item")
	public ModelAndView popSelectWorkItem(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_select_work_item.jsp",
				"jsp/popup/pop_select_work_item.jsp");
	}

	@RequestMapping("/pop_worklist_by_category")
	public ModelAndView popWorklistByCategory(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_worklist_by_category.jsp",
				"");
	}

	@RequestMapping("/pop_userlist_by_depart")
	public ModelAndView popUserlistByDepart(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_userlist_by_depart.jsp",
				"");
	}

	@RequestMapping("/pop_departlist_by_depart")
	public ModelAndView popDepartlistByDepart(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_departlist_by_depart.jsp",
				"");
	}

	@RequestMapping("/pop_iwork_instance_list")
	public ModelAndView popIworkInstanceList(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_iwork_instance_list.jsp",
				"");
	}
}
