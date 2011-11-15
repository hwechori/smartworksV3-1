package net.smartworks.server.service;

import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;

public interface IWorkService {

	Work[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception;

	SmartWork[] getMyFavoriteWorks() throws Exception;

	SmartWork[] searchWork(String key) throws Exception;
	
	Work getWorkById(String workId) throws Exception;

}
