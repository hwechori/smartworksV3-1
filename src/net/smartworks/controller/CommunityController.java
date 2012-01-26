/*	
 * $Id: CommunityController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 10. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.service.ISmartWorks;
import net.smartworks.service.impl.SmartWorks;
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
public class CommunityController {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/department_space")
	public ModelAndView departmentSpace(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return SmartUtil.returnMnv(request, "jsp/content/community/space/department_space.jsp", "department_space.tiles");
	}

	@RequestMapping("/group_space")
	public ModelAndView groupSpace(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/community/space/group_space.jsp", "group_space.tiles");
	}

	@RequestMapping("/user_space")
	public ModelAndView userSpace(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/community/space/user_space.jsp", "user_space.tiles");
	}

	@RequestMapping("/chatting_box")
	public ModelAndView chattingBox(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/chatting/chatting_box.jsp", "");
	}

	@RequestMapping(value = "/create_new_group", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Map<String, Object> createNewGroup(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String instanceId = "";//smartworks.setInformationWorkInstance(requestBody, request);
		// TO DO : Exception handler
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("href", "group_space.sw?cid=" + SmartWorks.CONTEXT_PREFIX_GROUP_SPACE + instanceId);
		return map;
	}

}