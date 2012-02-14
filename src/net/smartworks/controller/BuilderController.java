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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuilderController {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/builder_home")
	public ModelAndView builderHome(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/builder/home.jsp", "builder_home.tiles");
	}

	@RequestMapping("/tab_workbench")
	public ModelAndView tabWorkbench(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/builder/tab_workbench.jsp", "tab_workbench.tiles");
	}

	@RequestMapping("/tab_work_settings")
	public ModelAndView tabWorkSettings(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/builder/tab_work_settings.jsp", "tab_work_settings.tiles");
	}

	@RequestMapping("/tab_work_sharing")
	public ModelAndView tabWorkSharing(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/builder/tab_work_sharing.jsp", "tab_work_sharing.tiles");
	}

	@RequestMapping("/worklist_by_category")
	public ModelAndView worklistByCategory(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/nav/worklist_by_category.jsp", "");
	}

	@RequestMapping("/start_work_service")
	public ModelAndView startWorkService(HttpServletRequest request, HttpServletResponse response) {
		String workId = request.getParameter("workId");
		try{
			smartworks.startWorkService(workId);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
		String cid = ISmartWorks.CONTEXT_PREFIX_BUILDER_SPACE + workId;
		return SmartUtil.returnMnv(request, "jsp/content/builder/tab_workbench.jsp?cid=" + cid, "");
	}

	@RequestMapping("/stop_work_service")
	public ModelAndView stopWorkService(HttpServletRequest request, HttpServletResponse response) {
		String workId = request.getParameter("workId");
		try{
			smartworks.stopWorkService(workId);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
		String cid = ISmartWorks.CONTEXT_PREFIX_BUILDER_SPACE + workId;
		return SmartUtil.returnMnv(request, "jsp/content/builder/tab_workbench.jsp?cid=" + cid, "");
	}

	@RequestMapping("/start_work_editing")
	public ModelAndView startWorkEditing(HttpServletRequest request, HttpServletResponse response) {
		String workId = request.getParameter("workId");
		try{
			smartworks.startWorkEditing(workId);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
		String cid = ISmartWorks.CONTEXT_PREFIX_BUILDER_SPACE + workId;
		return SmartUtil.returnMnv(request, "jsp/content/builder/tab_workbench.jsp?cid=" + cid, "");
	}

	@RequestMapping("/stop_work_editing")
	public ModelAndView stopWorkEditing(HttpServletRequest request, HttpServletResponse response) {
		String workId = request.getParameter("workId");
		try{
			smartworks.stopWorkEditing(workId);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
		String cid = ISmartWorks.CONTEXT_PREFIX_BUILDER_SPACE + workId;
		return SmartUtil.returnMnv(request, "jsp/content/builder/tab_workbench.jsp?cid=" + cid, "");
	}

	@RequestMapping(value = "/set_work_settings", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView setWorkSettings(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String workId = (String)requestBody.get("workId");
		ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);
		ModelAndView mnv = new ModelAndView();
		return mnv;
	}
}
