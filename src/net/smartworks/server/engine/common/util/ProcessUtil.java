package net.smartworks.server.engine.common.util;

import java.util.Date;

import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;

/**
 * 유틸리티
 * 
 * @author jhnam
 * @version $Id: SmartServerUtil.java,v 1.1 2011/11/08 03:15:20 kmyu Exp $
 */
public class ProcessUtil {

	/**
	 * 템플릿 프로세스를 생성한다.
	 * 
	 * @param xpdl
	 * @param userId
	 * @param packageId
	 * @param processId
	 * @param version
	 * @param processName
	 * @return
	 * @throws Exception
	 */
	public static String createProcessByTemplate(PackageType xpdl, String userId, String packageId, String processId, int version, String processName) throws Exception {
		xpdl.setId(packageId);
		xpdl.setName(processName);
		xpdl.getRedefinableHeader().getVersion().setValue("" + version);
		xpdl.getRedefinableHeader().getAuthor().setValue(userId);
		xpdl.getRedefinableHeader().getCodepage().setValue("UTF-8");
		xpdl.getPackageHeader().getCreated().setValue(new Date().toString());
		
		ProcessType1 process = (ProcessType1)xpdl.getWorkflowProcesses().getWorkflowProcess().get(0);
		process.setId(processId);
		process.setName(processName);
		return ProcessModelHelper.save(xpdl, null);
	}
	

}
