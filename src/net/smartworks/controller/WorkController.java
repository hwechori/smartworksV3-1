/*	
 * $Id: WorkListController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
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

import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.service.ISmartWorks;
import net.smartworks.util.SmartUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkController extends ExceptionInterceptor {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/iwork_list")
	public ModelAndView iworkList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/iwork_list.jsp", "iwork_list.tiles");
	}

	@RequestMapping("/iwork_manual")
	public ModelAndView iworkManual(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/iwork_manual.jsp", "");
	}

	@RequestMapping("/pwork_list")
	public ModelAndView pworkList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/pwork_list.jsp", "pwork_list.tiles");
	}

	@RequestMapping("/pwork_manual")
	public ModelAndView pworkManual(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/pwork_manual.jsp", "");
	}

	@RequestMapping("/swork_list")
	public ModelAndView sworkList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/swork_list.jsp", "swork_list.tiles");
	}

	@RequestMapping("/work_list")
	public ModelAndView workList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/work_list.jsp", "work_list.tiles");
	}

	@RequestMapping("/board_list")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/board_list.jsp", "board_list.tiles");
	}

	@RequestMapping("/event_list")
	public ModelAndView eventList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/event_list.jsp", "event_list.tiles");
	}

	@RequestMapping("/file_list")
	public ModelAndView fileList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/file_list.jsp", "file_list.tiles");
	}

	@RequestMapping("/image_list")
	public ModelAndView imageList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/image_list.jsp", "image_list.tiles");
	}

	@RequestMapping("/memo_list")
	public ModelAndView memoList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/memo_list.jsp", "memo_list.tiles");
	}

	@RequestMapping("/mail_list")
	public ModelAndView mailList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/mail_list.jsp", "mail_list.tiles");
	}

	@RequestMapping("/saved_list")
	public ModelAndView savedList(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/saved_list.jsp", "saved_list.tiles");
	}

	@RequestMapping("/search_filter")
	public ModelAndView searchFilter(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/search_filter.jsp", "");
	}

	@RequestMapping("/comment_list_in_manual")
	public ModelAndView commentListInManual(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/list/comment_list_in_manual.jsp", "");
	}

	@RequestMapping(value = "/get_form_xml", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getFormXml(HttpServletRequest request, HttpServletResponse response) {
		String formXml = "";
		try {
			formXml = smartworks.getFormXml(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8"); 
		return new ResponseEntity<String>(formXml, responseHeaders, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "/get_form_xml", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.CREATED)
//	public @ResponseBody String getFormXml(HttpServletRequest request, HttpServletResponse response) {
//		String formXml = "";
//		try {
//			formXml = smartworks.getFormXml(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return formXml;
//	}

	@RequestMapping(value = "/get_record", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map<String, Object> getRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SwdRecord swdRecord = smartworks.getRecord(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", swdRecord);
		return map;
	}

	@RequestMapping(value = "/set_iwork_search_filter", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView setIworkSearchFilter(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filterId = smartworks.setIWorkSearchFilter(requestBody, request);
		String workId = (String)requestBody.get("workId");
		ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);
		ModelAndView mnv = new ModelAndView();
		mnv.addObject(smartworks);
		mnv.setViewName("jsp/content/work/list/search_filter_list_box.jsp?workId=" + workId + "&filterId=" + filterId);
		return mnv;
	}

	@RequestMapping(value = "/create_iwork_search_filter", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAndView createIworkSearchFilter(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filterId = smartworks.setIWorkSearchFilter(requestBody, request);
		String workId = (String)requestBody.get("workId");
		ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);
		ModelAndView mnv = new ModelAndView();
		mnv.addObject(smartworks);
		mnv.setViewName("jsp/content/work/list/search_filter_list_box.jsp?workId=" + workId + "&filterId=" + filterId);
		return mnv;
	}

	@RequestMapping(value = "/remove_iwork_search_filter", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void removeIworkSearchFilter(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
		smartworks.removeIworkSearchFilter(requestBody, request);
	}

}