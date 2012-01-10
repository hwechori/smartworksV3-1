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

import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.report.ChartReport;
import net.smartworks.model.report.Data;
import net.smartworks.model.report.Report;
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
public class ReportController {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/work_report")
	public ModelAndView workReport(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/report/work_report.jsp", "");
	}

	@RequestMapping("/new_work_report")
	public ModelAndView newWorkReport(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/report/new_work_report.jsp", "");
	}

	@RequestMapping("/work_report_chart")
	public ModelAndView workReportChart(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/report/work_report_chart.jsp", "");
	}

	@RequestMapping("/work_report_table")
	public ModelAndView workReportTable(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/report/work_report_table.jsp", "");
	}

	@RequestMapping("/work_report_view")
	public ModelAndView workReportView(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/report/work_report_view.jsp", "");
	}

	@RequestMapping("/work_report_edit")
	public ModelAndView workReportEdit(HttpServletRequest request, HttpServletResponse response) {

		return SmartUtil.returnMnv(request, "jsp/content/work/report/work_report_edit.jsp", "");
	}

	@RequestMapping(value = "/get_report_data", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getReportData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Data reportData = smartworks.getReportData(request);
		// TO DO : Exception handler
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xFieldName", reportData.getxFieldName());
		map.put("yValueName", reportData.getyValueName());
		map.put("groupNames", reportData.getGroupNames());
		map.put("values", reportData.getValues());
		return map;
	}
	
	@RequestMapping(value = "/get_report_data_by_def", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map<String, Object> getReportDataByDef(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Data reportData = smartworks.getReportDataByDef(requestBody, request);
		Data reportData = smartworks.getReportData(request);
		// TO DO : Exception handler
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xFieldName", reportData.getxFieldName());
		map.put("yValueName", reportData.getyValueName());
		map.put("groupNames", reportData.getGroupNames());
		map.put("values", reportData.getValues());
		return map;
	}
	
	@RequestMapping(value = "/create_new_work_report", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAndView createNewWorkReport(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String reportId = smartworks.setNewWorkReport(requestBody, request);
		String reportId = "";
		String workId = (String)requestBody.get("workId");
		ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);
		ModelAndView mnv = new ModelAndView();
		mnv.addObject(smartworks);
		mnv.setViewName("jsp/content/work/report/work_report_list_box.jsp?workId=" + workId + "&reportId=" + reportId);
		return mnv;
	}

	@RequestMapping(value = "/set_work_report", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAndView setWorkReport(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String reportId = smartworks.setNewWorkReport(requestBody, request);
		String reportId = "";
		String workId = (String)requestBody.get("workId");
		ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);
		ModelAndView mnv = new ModelAndView();
		mnv.addObject(smartworks);
		mnv.setViewName("jsp/content/work/report/work_report_list_box.jsp?workId=" + workId + "&reportId=" + reportId);
		return mnv;
	}

	@RequestMapping(value = "/remove_work_report", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAndView removeWorkReport(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String reportId = smartworks.setNewWorkReport(requestBody, request);
		String reportId = "";
		String workId = (String)requestBody.get("workId");
		ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);
		ModelAndView mnv = new ModelAndView();
		mnv.addObject(smartworks);
		mnv.setViewName("jsp/content/work/report/work_report_list_box.jsp?workId=" + workId);
		return mnv;
	}
	
}