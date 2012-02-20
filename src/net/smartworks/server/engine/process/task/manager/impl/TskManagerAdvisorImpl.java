/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.process.task.manager.impl;

import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.process.task.model.TskTaskDefCond;

public class TskManagerAdvisorImpl extends AbstractTskManagerAdvisor {

	public void preGetTask(String user, String id, String level) throws Exception {
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
	}
	public void preRemoveTask(String user, String id) throws Exception {
	}
	public void preGetTaskSize(String user, TskTaskCond cond) throws Exception {
	}
	public void preGetTasks(String user, TskTaskCond cond, String level) throws Exception {
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
	}
	public void postGetTask(String user, String id, String level, TskTask res) throws Exception {
	}
	public void postSetTask(String user, TskTask obj, String level) throws Exception {
	}
	public void postRemoveTask(String user, String id) throws Exception {
	}
	public void postGetTaskSize(String user, TskTaskCond cond, long res) throws Exception {
	}
	public void postGetTasks(String user, TskTaskCond cond, String level, TskTask[] res) throws Exception {
	}
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
	}

	public void preGetTaskDef(String user, String id, String level) throws Exception {
	}
	public void preSetTaskDef(String user, TskTaskDef obj, String level) throws Exception {
	}
	public void preRemoveTaskDef(String user, String id) throws Exception {
	}
	public void preGetTaskDefSize(String user, TskTaskDefCond cond) throws Exception {
	}
	public void preGetTaskDefs(String user, TskTaskDefCond cond, String level) throws Exception {
	}
	public void preExecuteTaskDef(String user, TskTaskDef obj, String action) throws Exception {
	}
	public void postGetTaskDef(String user, String id, String level, TskTaskDef res) throws Exception {
	}
	public void postSetTaskDef(String user, TskTaskDef obj, String level) throws Exception {
	}
	public void postRemoveTaskDef(String user, String id) throws Exception {
	}
	public void postGetTaskDefSize(String user, TskTaskDefCond cond, long res) throws Exception {
	}
	public void postGetTaskDefs(String user, TskTaskDefCond cond, String level, TskTaskDef[] res) throws Exception {
	}
	public void postExecuteTaskDef(String user, TskTaskDef obj, String action) throws Exception {
	}
	
	
	
}
