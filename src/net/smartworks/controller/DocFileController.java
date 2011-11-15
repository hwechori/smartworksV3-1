/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.service.ISmartWorks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class DocFileController {

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public @ResponseBody String nullPointExceptionHandler(NullPointerException e) {
		return e.getMessage();
	}

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping(value = "/create_file_xml", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String createFileXml(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String groupId = "";
		smartworks.createFileXml(request);
		// TO DO : Exception handler

		return groupId;
	}

	@RequestMapping(value = "/find_file_group", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody List<IFileModel> findFileGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<IFileModel> list = new ArrayList<IFileModel>();
		list = smartworks.findFileGroup(request);
		// TO DO : Exception handler

		return list;
	}

	@RequestMapping(value = "/delete_file", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void deleteFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		smartworks.findFileGroup(request);
		// TO DO : Exception handler

	}

}