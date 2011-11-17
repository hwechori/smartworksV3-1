package net.smartworks.server.service;

import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;

public interface IWorkService {

	public Work[] getMyRecentlyExecutedWork(String companyId, String userId) throws Exception;
	
	public Work[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception;

	public SmartWork[] getMyFavoriteWorks(String companyId, String userId) throws Exception;

	public SmartWork[] searchWork(String companyId, String userId, String key) throws Exception;
	
	public Work getWorkById(String companyId, String workId) throws Exception;

}
