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
	public ModelAndView popUserInfo(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_user_info.jsp", "jsp/popup/pop_user_info.jsp");
	}

	@RequestMapping("/pop_select_user")
	public ModelAndView popSelectUser(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_select_user.jsp", "jsp/popup/pop_select_user.jsp");
	}

	@RequestMapping("/pop_select_work")
	public ModelAndView popSelectWork(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_select_work.jsp", "jsp/popup/pop_select_work.jsp");
	}

	@RequestMapping("/pop_select_work_item")
	public ModelAndView popSelectWorkItem(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_select_work_item.jsp", "jsp/popup/pop_select_work_item.jsp");
	}

	@RequestMapping("/pop_worklist_by_category")
	public ModelAndView popWorklistByCategory(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_worklist_by_category.jsp", "");
	}

	@RequestMapping("/pop_userlist_by_depart")
	public ModelAndView popUserlistByDepart(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_userlist_by_depart.jsp", "");
	}

	@RequestMapping("/pop_iwork_instance_list")
	public ModelAndView popIworkInstanceList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_iwork_instance_list.jsp", "");
	}

	@RequestMapping("/pop_new_group")
	public ModelAndView newGroup(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_new_group.jsp", "");
	}

	@RequestMapping("/pop_new_category")
	public ModelAndView popNewCategory(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_new_category.jsp", "");
	}

	@RequestMapping("/pop_change_category_name")
	public ModelAndView popChangeCategoryName(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_change_category_name.jsp", "");
	}

	@RequestMapping("/pop_new_work_definition")
	public ModelAndView popNewWorkDefinition(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_new_work_definition.jsp", "");
	}

	@RequestMapping("/pop_change_work_definition")
	public ModelAndView popChangeWorkDefinition(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_change_work_definition.jsp", "");
	}

	@RequestMapping("/pop_copy_work_definition")
	public ModelAndView popCopyWorkDefinition(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_copy_work_definition.jsp", "");
	}

	@RequestMapping("/pop_download_from_appstore")
	public ModelAndView popDownloadFromAppstore(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_download_from_appstore.jsp", "");
	}

	@RequestMapping("/group_options_by_category")
	public ModelAndView groupOptionsByCategory(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/group_options_by_category.jsp", "");
	}

	@RequestMapping("/pop_new_event")
	public ModelAndView popNewEvent(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/popup/pop_new_event.jsp", "");
	}
}
