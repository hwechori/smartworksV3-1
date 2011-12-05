/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 4.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.worklist.manager;

import net.smartworks.server.engine.worklist.model.TaskWork;
import net.smartworks.server.engine.worklist.model.TaskWorkCond;

public interface IWorkListManager {
	public long getTaskWorkListSize(String user, TaskWorkCond cond) throws Exception;
	public TaskWork[] getTaskWorkList(String user, TaskWorkCond cond) throws Exception;
}
