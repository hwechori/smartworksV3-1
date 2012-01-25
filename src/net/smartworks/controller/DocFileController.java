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
	public @ResponseBody
	String nullPointExceptionHandler(NullPointerException e) {
		return e.getMessage();
	}

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

//	@RequestMapping(value = "/upload_file", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public @ResponseBody
//	String uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		String groupId = "";
//		groupId = smartworks.uploadFile(request);
//
//		return groupId;
//	}

	@RequestMapping(value = "/ajax_upload_file", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.ajaxUploadFile(request, response);
	}

	@RequestMapping(value = "/upload_temp_file", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void uploadTempFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.uploadTempFile(request, response);
	}

	@RequestMapping(value = "/find_file_group", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	List<IFileModel> findFileGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<IFileModel> list = new ArrayList<IFileModel>();
		list = smartworks.findFileGroup(request);

		return list;
	}

	@RequestMapping(value = "/delete_file", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	void deleteFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.deleteFile(request, response);
		// TO DO : Exception handler
	}

	@RequestMapping(value = "/download_file", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			smartworks.downloadFile(request, response);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}