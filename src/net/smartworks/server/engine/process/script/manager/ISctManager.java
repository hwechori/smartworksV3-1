package net.smartworks.server.engine.process.script.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.process.script.exception.SctException;

public interface ISctManager extends IManager {
	public Object execute(String script, Object context) throws SctException;
	public boolean executeBoolean(String script, Object context) throws SctException;
}
