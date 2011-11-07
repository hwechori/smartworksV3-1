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
		System.out.println("preGetTask");
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
		System.out.println("preSetTask");
	}
	public void preRemoveTask(String user, String id) throws Exception {
		System.out.println("preRemoveTask");
	}
	public void preGetTaskSize(String user, TskTaskCond cond) throws Exception {
		System.out.println("preGetTaskSize");
	}
	public void preGetTasks(String user, TskTaskCond cond, String level) throws Exception {
		System.out.println("preGetTasks");
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
		System.out.println("preExecuteTask");
	}
	public void postGetTask(String user, String id, String level, TskTask res) throws Exception {
		System.out.println("postGetTask");
	}
	public void postSetTask(String user, TskTask obj, String level) throws Exception {
		System.out.println("postSetTask");
	}
	public void postRemoveTask(String user, String id) throws Exception {
		System.out.println("postRemoveTask");
	}
	public void postGetTaskSize(String user, TskTaskCond cond, long res) throws Exception {
		System.out.println("postGetTaskSize");
	}
	public void postGetTasks(String user, TskTaskCond cond, String level, TskTask[] res) throws Exception {
		System.out.println("postGetTasks");
	}
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
		System.out.println("postExecuteTask");
	}

	public void preGetTaskDef(String user, String id, String level) throws Exception {
		System.out.println("preGetTaskDef");
	}
	public void preSetTaskDef(String user, TskTaskDef obj, String level) throws Exception {
		System.out.println("preSetTaskDef");
	}
	public void preRemoveTaskDef(String user, String id) throws Exception {
		System.out.println("preRemoveTaskDef");
	}
	public void preGetTaskDefSize(String user, TskTaskDefCond cond) throws Exception {
		System.out.println("preGetTaskDefSize");
	}
	public void preGetTaskDefs(String user, TskTaskDefCond cond, String level) throws Exception {
		System.out.println("preGetTaskDefs");
	}
	public void preExecuteTaskDef(String user, TskTaskDef obj, String action) throws Exception {
		System.out.println("preExecuteTaskDef");
	}
	public void postGetTaskDef(String user, String id, String level, TskTaskDef res) throws Exception {
		System.out.println("postGetTaskDef");
	}
	public void postSetTaskDef(String user, TskTaskDef obj, String level) throws Exception {
		System.out.println("postSetTaskDef");
	}
	public void postRemoveTaskDef(String user, String id) throws Exception {
		System.out.println("postRemoveTaskDef");
	}
	public void postGetTaskDefSize(String user, TskTaskDefCond cond, long res) throws Exception {
		System.out.println("postGetTaskDefSize");
	}
	public void postGetTaskDefs(String user, TskTaskDefCond cond, String level, TskTaskDef[] res) throws Exception {
		System.out.println("postGetTaskDefs");
	}
	public void postExecuteTaskDef(String user, TskTaskDef obj, String action) throws Exception {
		System.out.println("postExecuteTaskDef");
	}
	
	
	
}
