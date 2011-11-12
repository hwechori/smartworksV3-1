package net.smartworks.server.engine.process.monitoring.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.process.monitoring.Exception.MonException;

public interface IMonManager extends IManager {
	public String monitor(String user, String str, Property[] opts) throws MonException;
}