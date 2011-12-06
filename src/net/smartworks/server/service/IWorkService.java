package net.smartworks.server.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.report.Data;
import net.smartworks.model.report.Report;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.infowork.form.exception.SwfException;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;

public interface IWorkService {

	public WorkInfo[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception;

	public SmartWorkInfo[] getMyFavoriteWorks(String companyId, String userId) throws Exception;

	public SmartWorkInfo[] searchWork(String companyId, String userId, String key) throws Exception;
	
	public Work getWorkById(String companyId, String userId, String workId) throws Exception;

	public Report getReportById(String companyId, String userId, String reportId) throws Exception;

	public SearchFilter getSearchFilterById(String companyId, String userId, String filterId) throws Exception;

	public List<SwfFormFieldDef> findFormFieldByForm(String formId, boolean deployedCondition) throws SwfException, Exception;

	public Data getReportData(HttpServletRequest request) throws Exception;

	public String getFormXml(String companyId, String userId, String workId) throws Exception;

	public String setMyProfile(HttpServletRequest request) throws Exception;

}