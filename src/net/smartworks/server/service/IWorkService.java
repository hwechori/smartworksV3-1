package net.smartworks.server.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.report.Data;
import net.smartworks.model.report.Report;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.form.exception.SwfException;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;

public interface IWorkService {

	public WorkInfo[] getMyAllWorksByCategoryId(String categoryId) throws Exception;

	public WorkInfo[] getAllWorksByCategoryId(String categoryId) throws Exception;

	public SmartWorkInfo[] getMyFavoriteWorks() throws Exception;

	public SmartWorkInfo[] searchWork(String key) throws Exception;

	public String getWorkIdByFormId(String formId) throws Exception;

	public Work getWorkById(String workId) throws Exception;

	public Report getReportById(String reportId) throws Exception;

	public SearchFilter getSearchFilterById(String filterId) throws Exception;

	public List<SwfFormFieldDef> findFormFieldByForm(String formId, boolean deployedCondition) throws SwfException, Exception;

	public Data getReportData(HttpServletRequest request) throws Exception;

	public String getFormXml(String formId, String workId) throws Exception;

	public SwdRecord getRecord(HttpServletRequest request) throws Exception;

	public void setMyProfile(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public CommunityInfo[] getAllComsByDepartmentId(String departmentId, boolean departmentOnly) throws Exception;

	public RequestParams setInstanceListParams(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public void addAFavoriteWork(String workId) throws Exception;

	public void removeAFavoriteWork(String workId) throws Exception;

}