package net.smartworks.server.engine.resource.util;

import java.util.Date;
import java.util.List;

import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl2.Implementation7;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;
import net.smartworks.server.engine.process.xpdl.xpdl2.Task;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskApplication;
import net.smartworks.server.engine.process.xpdl.xpdl2.Version;
import net.smartworks.server.engine.resource.model.IProcessModel;

import org.w3c.dom.Document;

/**
 * 유틸리티
 * 
 * @author jhnam
 * @version $Id: SmartServerUtil.java,v 1.1 2011/11/08 03:15:20 kmyu Exp $
 */
public class SmartServerUtil {

	/**
	 * 템플릿 프로세스를 생성한다.
	 * 
	 * @param creatorId
	 * @param processId
	 * @param version
	 * @param processName
	 * @return
	 * @throws Exception
	 */
	public static String createTempleteProcess(String creatorId, String processId, int version, String processName) throws Exception {
		PackageType processModel = ProcessModelHelper.createProcessTemplate(processId, processName, version, creatorId);
		return ProcessModelHelper.save(processModel, null);		
	}
	
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
	
	/**
	 * 업데이트하려는 프로세스 내용 중 업데이트 해야할 정보를 새로운 프로세스 메타 정보로 부터 업데이트한다.
	 * 
	 * @param processXml
	 * @param newProcess
	 * @return
	 */
	public static String updateProcessContent(String processXml, IProcessModel newProcess) throws Exception {
		int newVersion = newProcess.getVersion();
		PackageType pkg = ProcessModelHelper.load(processXml);
		Version v = pkg.getRedefinableHeader().getVersion();
		v.setValue("" + newVersion);		
		ProcessType1 process = (ProcessType1)pkg.getWorkflowProcesses().getWorkflowProcess().get(0);
		Activities acts = process.getActivities();
		
		// Task의 id, version 정보 업데이트
		if(acts != null) {
			List actList = acts.getActivity();
			for(int i = 0 ; i < actList.size() ; i++) {
				Activity act = (Activity)actList.get(i);
				
				if(act.isSetImplementation()) {
					Implementation7 imp = act.getImplementation();
					if(imp.isSetTask()) {
						Task task = imp.getTask();
						if(task.isSetTaskApplication()) {
							TaskApplication taskApp = task.getTaskApplication();
							taskApp.setVersion("" + newVersion);
						}
					}
				}
			}
		}
		
		return ProcessModelHelper.save(pkg, "UTF-8");
	}
	
	/**
	 * 폼 xml을 업데이트한다.
	 * 
	 * @param formXml
	 * @param newFormId
	 * @param newVersion
	 * @return
	 * @throws Exception
	 */
	public static String updateFormContent(String formXml, String newFormId, int newVersion) throws Exception {
		Document doc = XmlUtil.parse(formXml, false, "UTF-8");
		doc.getDocumentElement().setAttribute("version", "" + newVersion);		
		formXml = XmlUtil.elementToString(doc.getDocumentElement(), "UTF-8", true, true);
		return formXml;
	}
	
	/**
	 * 폼 컨텐트 내의 타이틀을 변경한다.
	 *  
	 * @param formXml
	 * @param formName
	 * @return
	 * @throws Exception
	 */
	public static String updateTitleFormContent(String formXml, String formName) throws Exception {
		Document doc = XmlUtil.parse(formXml, false, "UTF-8");
		doc.getDocumentElement().setAttribute("name", formName);
		doc.getDocumentElement().setAttribute("title", formName);
		formXml = XmlUtil.elementToString(doc.getDocumentElement(), "UTF-8", true, true);
		return formXml;
	}
	
	/**
	 * 프로세스 컨텐트 내의 프로세스 이름을 변경한다.
	 * 
	 * @param processContent
	 * @param processName
	 * @return
	 * @throws Exception
	 */
	public static String updateTitleProcessContent(String processContent, String processName) throws Exception {
		PackageType pkg = ProcessModelHelper.load(processContent);
		ProcessType1 process = (ProcessType1)pkg.getWorkflowProcesses().getWorkflowProcess().get(0);
		
		pkg.setName(processName);
		if(process != null)
			process.setName(processName);
		
		return ProcessModelHelper.save(pkg, "UTF-8");
	}
	
	/**
	 * form xml로 부터 폼 이름을 찾아 리턴
	 * 
	 * @param formXml
	 * @return
	 * @throws Exception
	 */
	public static String getFormName(String formXml) throws Exception {
		Document doc = XmlUtil.parse(formXml, false, "UTF-8");
		return doc.getDocumentElement().getAttribute("name");
	}
	
}
