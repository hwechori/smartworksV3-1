/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 

package net.smartworks.server.engine.common.util;

import java.util.Map;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.process.task.model.TskTaskDefCond;

public class SmartUtil {

	public static Map<String, SwfForm> formMap = new SizeMap(500);
	public SmartUtil() {
		super();
	}
	//프로세스의 시작업무가 서브프로세스라면 제일 말단의 프로세스아이디를 찾아서 리턴한다.
	public String getStartSubProcess(String user, String processId) throws Exception {

		ITskManager tskMgr = SwManagerFactory.getInstance().getTskManager();
		IPrcManager prcMgr = SwManagerFactory.getInstance().getPrcManager();

		TskTaskDefCond cond = new TskTaskDefCond();
		cond.setExtendedProperties(new Property[] {new Property("startActivity", "true"), new Property("processId", processId)});
		TskTaskDef[] taskDefs = tskMgr.getTaskDefs(user, cond, IManager.LEVEL_ALL);
		
		if (taskDefs == null || taskDefs.length == 0)
			return processId;
		
		if (taskDefs[0].getType().equalsIgnoreCase("SUBFLOW")) {

			PrcProcessCond prcCond = new PrcProcessCond();
			prcCond.setDiagramId(taskDefs[0].getSubFlowTargetId());
			PrcProcess[] prcs = prcMgr.getProcesses(user, prcCond, IManager.LEVEL_LITE);
			if (prcs == null || prcs.length == 0)
				return processId;
			return getStartSubProcess(user, prcs[0].getProcessId());
		}
		return processId;
	}

}*/