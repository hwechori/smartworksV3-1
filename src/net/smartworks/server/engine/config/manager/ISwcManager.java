package net.smartworks.server.engine.config.manager;

import java.util.Date;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.config.exception.SwcException;
import net.smartworks.server.engine.config.model.SwcEventDay;
import net.smartworks.server.engine.config.model.SwcEventDayCond;
import net.smartworks.server.engine.config.model.SwcExternalForm;
import net.smartworks.server.engine.config.model.SwcExternalFormCond;
import net.smartworks.server.engine.config.model.SwcWebService;
import net.smartworks.server.engine.config.model.SwcWebServiceCond;
import net.smartworks.server.engine.config.model.SwcWorkHour;
import net.smartworks.server.engine.config.model.SwcWorkHourCond;

public interface ISwcManager extends IManager {

	// WorkHour
	public SwcWorkHour getWorkhour(String user, String id, String level) throws SwcException;
	public SwcWorkHour getWorkhour(String user, SwcWorkHourCond cond, String level) throws SwcException;
	public void setWorkhour(String user, SwcWorkHour obj, String level) throws SwcException;
	public void createWorkhour(String user, SwcWorkHour obj) throws SwcException;
	public void removeWorkhour(String user, String id) throws SwcException;
	public void removeWorkhour(String user, SwcWorkHourCond cond) throws SwcException;
	public long getWorkhourSize(String user, SwcWorkHourCond cond) throws SwcException;
	public SwcWorkHour[] getWorkhours(String user, SwcWorkHourCond cond, String level) throws SwcException;
	public SwcWorkHour getPublishedWorkhour(String user, String companyId) throws SwcException;
	public SwcWorkHour[] getValidWorkhoursByFromTo(String user, String companyId, Date from, Date to) throws SwcException;

	// EventDay
	public SwcEventDay getEventday(String user, String id, String level) throws SwcException;
	public SwcEventDay getEventday(String user, SwcEventDayCond cond, String level) throws SwcException;
	public void setEventday(String user, SwcEventDay obj, String level) throws SwcException;
	public void createEventday(String user, SwcEventDay obj) throws SwcException;
	public void removeEventday(String user, String id) throws SwcException;
	public void removeEventday(String user, SwcEventDayCond cond) throws SwcException;
	public long getEventdaySize(String user, SwcEventDayCond cond) throws SwcException;
	public SwcEventDay[] getEventdays(String user, SwcEventDayCond cond, String level) throws SwcException;

	// WebService
	public SwcWebService getWebService(String userId, String objId, String level) throws SwcException;
	public SwcWebService getWebService(String userId, SwcWebServiceCond cond, String level) throws SwcException;
	public void setWebService(String userId, SwcWebService obj, String level) throws SwcException;
	public void createWebService(String userId, SwcWebService obj) throws SwcException;
	public void removeWebService(String userId, String objId) throws SwcException;
	public void removeWebService(String userId, SwcWebServiceCond cond) throws SwcException;
	public long getWebServiceSize(String userId, SwcWebServiceCond cond) throws SwcException;
	public SwcWebService[] getWebServices(String userId, SwcWebServiceCond cond, String level) throws SwcException;
	public void removeWebServices(String userId, String packageId) throws SwcException;

	// ExternalForm
	public SwcExternalForm getExternalForm(String userId, String objId, String level) throws SwcException;
	public SwcExternalForm getExternalForm(String userId, SwcExternalFormCond cond, String level) throws SwcException;
	public void setExternalForm(String userId, SwcExternalForm obj, String level) throws SwcException;
	public void createExternalForm(String userId, SwcExternalForm obj) throws SwcException;
	public void removeExternalForm(String userId, String objId) throws SwcException;
	public void removeExternalForm(String userId, SwcExternalFormCond cond) throws SwcException;
	public long getExternalFormSize(String userId, SwcExternalFormCond cond) throws SwcException;
	public SwcExternalForm[] getExternalForms(String userId, SwcExternalFormCond cond, String level) throws SwcException;
	public void removeExternalForms(String userId, String packageId) throws SwcException;

}