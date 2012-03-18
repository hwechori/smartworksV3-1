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

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeraController {
	
	@RequestMapping("/seraCampus")
	public ModelAndView seraCampus(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "sera/jsp/layouts.jsp", "seraCampus.tiles");
	}

	@RequestMapping("/logins")
	public ModelAndView logins(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mnv = new ModelAndView();
		String type = CommonUtil.toNotNull(request.getParameter("type"));
		mnv.addObject("type", type);
		mnv.setViewName("sera/jsp/login.jsp");
		return mnv;
	}

	@RequestMapping("/myPAGE")
	public ModelAndView myPAGE(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "sera/jsp/content/my_page.jsp", "myPAGE.tiles");
	}

	@RequestMapping("/Course")
	public ModelAndView Course(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "sera/jsp/content/course.jsp", "Course.tiles");
	}

}
