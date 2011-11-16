package net.smartworks.server.service;

import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;

public interface IWorkService {

	Work[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception;

	SmartWork[] getMyFavoriteWorks(String companyId, String userId) throws Exception;

	SmartWork[] searchWork(String companyId, String userId, String key) throws Exception;
	
	Work getWorkById(String companyId, String workId) throws Exception;

}
