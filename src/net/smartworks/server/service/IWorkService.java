package net.smartworks.server.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.filter.SearchFilter;
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

	public SmartWorkInfo[] getMyFavoriteWorks() throws Exception;

	public SmartWorkInfo[] searchWork(String key) throws Exception;
	
	public Work getWorkById(String workId) throws Exception;

	public Report getReportById(String reportId) throws Exception;

	public SearchFilter getSearchFilterById(String filterId) throws Exception;

	public List<SwfFormFieldDef> findFormFieldByForm(String formId, boolean deployedCondition) throws SwfException, Exception;

	public Data getReportData(HttpServletRequest request) throws Exception;

	public String getFormXml(String workId) throws Exception;

	public SwdRecord getRecord(HttpServletRequest request) throws Exception;

	public void setMyProfile(HttpServletRequest request) throws Exception;

}