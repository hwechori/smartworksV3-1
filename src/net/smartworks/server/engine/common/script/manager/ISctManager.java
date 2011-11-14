/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.script.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.script.exception.SctException;

public interface ISctManager extends IManager {

	public Object execute(String script, Object context) throws SctException;
	public boolean executeBoolean(String script, Object context) throws SctException;

}