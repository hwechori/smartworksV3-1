/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.service.ISmartWorks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocFileController {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/create_file_xml")
	public String createFileXml(HttpServletRequest request, HttpServletResponse response) {

		String groupId = "";
		try {
			groupId = smartworks.createFileXml(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return groupId;
	}

	@RequestMapping("/find_file_group")
	public String findFileGroup(HttpServletRequest request, HttpServletResponse response) {

		String groupId = "";
		try {
			groupId = smartworks.createFileXml(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return groupId;
	}

}