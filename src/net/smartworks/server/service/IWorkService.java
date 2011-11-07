package net.smartworks.server.service;

import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;

public interface IWorkService {

	SmartWork[] getMyAllWorksByCategoryId(String categoryId) throws Exception;

	SmartWork[] getMyFavoriteWorks() throws Exception;

	WorkCategory[] getMyWorkCategories() throws Exception;

	SmartWork[] getMyAllWorksByGroupId(String groupId) throws Exception;

	SmartWork[] searchWork(String key) throws Exception;
	
	Work getWorkById(String workId) throws Exception;

}
