package net.smartworks.server.service;

import net.smartworks.model.work.Work;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkInfo;

public interface IWorkService {

	public WorkInfo[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception;

	public SmartWorkInfo[] getMyFavoriteWorks(String companyId, String userId) throws Exception;

	public SmartWorkInfo[] searchWork(String companyId, String userId, String key) throws Exception;
	
	public Work getWorkById(String companyId, String userId, String workId) throws Exception;

}
