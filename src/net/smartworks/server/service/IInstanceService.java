package net.smartworks.server.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.util.LocalDate;

public interface IInstanceService {

	BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception;

	WorkInstance[] getMyRecentInstances(String companyId, String userId) throws Exception;

	BoardInstance[] getBoardInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception;

	Instance getInstanceById(String companyId, String instanceId) throws Exception;

	Instance[] getMyRunningInstances(String companyId, String userId) throws Exception;

	Instance[] searchMyRunningInstance(String companyId, String userId, String key) throws Exception;

	String setInformationWorkInstance(HttpServletRequest request) throws Exception;

	String startProcessWorkInstance(HttpServletRequest request) throws Exception;

	String setFileInstance(HttpServletRequest request) throws Exception;

	String setEventInstance(HttpServletRequest request) throws Exception;

	String setMemoInstance(HttpServletRequest request) throws Exception;

	String setBoardInstance(HttpServletRequest request) throws Exception;

}
