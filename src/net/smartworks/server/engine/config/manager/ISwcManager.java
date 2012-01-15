package net.smartworks.server.engine.config.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.config.exception.SwcException;
import net.smartworks.server.engine.config.model.SwcEventDay;
import net.smartworks.server.engine.config.model.SwcEventDayCond;

public interface ISwcManager extends IManager {

	// EventDay
	public SwcEventDay getEventday(String user, String id, String level) throws SwcException;
	public SwcEventDay getEventday(String user, SwcEventDayCond cond, String level) throws SwcException;
	public void setEventday(String user, SwcEventDay obj, String level) throws SwcException;
	public void createEventday(String user, SwcEventDay obj) throws SwcException;
	public void removeEventday(String user, String id) throws SwcException;
	public void removeEventday(String user, SwcEventDayCond cond) throws SwcException;
	public long getEventdaySize(String user, SwcEventDayCond cond) throws SwcException;
	public SwcEventDay[] getEventdays(String user, SwcEventDayCond cond, String level) throws SwcException;

	// ExternalForm

	// WebService

}
