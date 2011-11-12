package net.smartworks.server.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.instance.BoardInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.util.LocalDate;

public interface IInstanceService {

	BoardInstance[] getBoardInstances(LocalDate fromDate, LocalDate toDate) throws Exception;

	WorkInstance[] getMyRecentInstances() throws Exception;

	BoardInstance[] getBoardInstances(LocalDate fromDate, int days) throws Exception;

	Instance getInstanceById(String instanceId) throws Exception;

	Instance[] getMyRunningInstances() throws Exception;

	Instance[] searchMyRunningInstance(String key) throws Exception;

	void setMemoInstance(HttpServletRequest request) throws Exception;

}
