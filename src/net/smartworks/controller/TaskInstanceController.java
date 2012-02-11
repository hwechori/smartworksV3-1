/*	
 * $Id: TaskInstanceController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 10. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.instance.info.RequestParams;
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
public class TaskInstanceController {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/new_iwork")
	public ModelAndView newIwork(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/start/new_iwork.jsp", "");
	}

	@RequestMapping("/start_pwork")
	public ModelAndView startPwork(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/start/start_pwork.jsp", "");
	}

	@RequestMapping("/plan_swork")
	public ModelAndView planSwork(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/start/plan_swork.jsp", "");
	}

	@RequestMapping("/append_task_forward")
	public ModelAndView appendTaskForward(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/upload/append_task_forward.jsp", "");
	}

	@RequestMapping("/append_task_approval")
	public ModelAndView appendTaskApproval(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/upload/append_task_approval.jsp", "");
	}

	@RequestMapping("/more_space_task_histories")
	public ModelAndView moreSpaceTaskHistories(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/community/space/more_space_task_histories.jsp", "");
	}
	//처리
	@RequestMapping(value = "/perform_task_instance", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void performTaskInstance(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		smartworks.performTaskInstance(requestBody, request);
	}
	//반려
	@RequestMapping(value = "/return_task_instance", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void returnTaskInstance(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		smartworks.returnTaskInstance(requestBody, request);
	}
	//위임
	@RequestMapping(value = "/reassign_task_instance", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void reassignTaskInstance(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		smartworks.reassignTaskInstance(requestBody, request);
	}
	//저장
	@RequestMapping(value = "/temp_save_task_instance", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void tempSaveTaskInstance(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		smartworks.tempSaveTaskInstance(requestBody, request);
	}

}