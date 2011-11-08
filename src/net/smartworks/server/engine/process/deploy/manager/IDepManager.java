package net.smartworks.server.engine.process.deploy.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.process.deploy.exception.DepException;

public interface IDepManager extends IManager {
	public void deploy(String user, String str, Property[] opts) throws DepException;
	public void undeploy(String user, String str) throws DepException;
}
