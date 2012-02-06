/*	
 * $Id: TaskInstanceController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
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
public class TaskInstanceController {

	@RequestMapping("/iwork_task")
	public ModelAndView iworkTask(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/task/iwork_task.jsp", "iwork_task.tiles");
	}

	@RequestMapping("/pwork_task")
	public ModelAndView pworkTask(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/task/pwork_task.jsp", "pwork_task.tiles");
	}

	@RequestMapping("/swork_task")
	public ModelAndView sworkTask(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/task/swork_task.jsp", "swork_task.tiles");
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

}