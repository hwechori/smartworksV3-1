package net.smartworks.server.engine.process.task.manager.impl;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskDef;

public class TskManagerServiceAdvisorImpl extends AbstractTskManagerAdvisor {

	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
		System.out.println("ServiceAdvisor postExecuteTask");
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
		
		System.out.println("ServiceAdvisor preExecuteTask");
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
		if (!obj.getType().equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("service"), "SERVICE")))
			return;
		
		String taskDefId = obj.getDef();
		if (taskDefId == null)
			return;
		TskTaskDef taskDef = getTskManager().getTaskDef(user, taskDefId, IManager.LEVEL_LITE);
		if (taskDef.getDocument() == null)
			return;
		
	}
	public void postSetTask(String user, TskTask obj, String level) throws Exception {
		if (!obj.getType().equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskDefTypeMap().get("service"), "SERVICE"))) 
			return;

		String taskDefId = obj.getDef();
		if (taskDefId == null)
			return;
		TskTaskDef taskDef = getTskManager().getTaskDef(user, taskDefId, IManager.LEVEL_ALL);
		
	}
}
