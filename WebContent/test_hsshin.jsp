<%@page import="net.smartworks.model.instance.info.InstanceInfoList"%>
<%@page import="net.smartworks.server.engine.common.manager.IManager"%>
<%@page import="net.smartworks.server.engine.common.model.Property"%>
<%@page import="net.smartworks.server.engine.process.task.model.TskTaskCond"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.server.service.IInstanceService"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.calendar.CompanyCalendar"%>
<%@page import="net.smartworks.server.service.IWorkService"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.community.WorkSpace"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="net.smartworks.server.engine.factory.SwManagerFactory"%>
<%@page import="net.smartworks.server.engine.infowork.domain.model.SwdDataField"%>
<%@page import="net.smartworks.server.engine.infowork.domain.model.SwdRecordCond"%>
<%@page import="net.smartworks.server.engine.infowork.domain.model.SwdRecord"%>
<%@page import="net.smartworks.server.engine.infowork.domain.manager.ISwdManager"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfField"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfForm"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfFormCond"%>
<%@page import="net.smartworks.server.engine.infowork.form.manager.ISwfManager"%>
<%@page import="net.smartworks.server.engine.process.process.model.PrcProcessCond"%>
<%@page import="net.smartworks.server.engine.process.deploy.manager.IDepManager"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoUserCond"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoUser"%>
<%@page import="net.smartworks.server.engine.organization.manager.ISwoManager"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.server.engine.process.link.model.LnkLink"%>
<%@page import="net.smartworks.server.engine.process.link.manager.ILnkManager"%>
<%@page import="net.smartworks.server.engine.process.process.model.PrcProcess"%>
<%@page import="net.smartworks.server.engine.process.process.manager.IPrcManager"%>
<%@page import="net.smartworks.server.engine.process.task.model.TskTaskDef"%>
<%@page import="net.smartworks.server.engine.process.task.model.TskTask"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="net.smartworks.server.engine.process.task.manager.impl.TskManagerImpl"%>
<%@page import="net.smartworks.server.engine.process.task.manager.ITskManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	/* IDepManager mgr = (IDepManager)SmartUtil.getBean("depManager", request);

	IPrcManager prcMgr = (IPrcManager)SmartUtil.getBean("prcManager", request);

	PrcProcessCond cond = new PrcProcessCond();
	
	cond.setObjId("pkg_01584e5c9ae544bfb390a526cb22e26c|prc_8c4176cba1ed46ed95997b71028291c7");
	
	PrcProcess[] prcs = prcMgr.getProcesses("hsshin@maninsoft.co.kr", cond, null);
	
	
	String xpdl = prcs[0].getDiagram();
	
	mgr.deploy("hsshin@maninsoft.co.kr", xpdl, null); */
	
/* 	ISwfManager swfMgr = (ISwfManager)SmartUtil.getBean("swfManager", request);

	SwfForm swfForm = swfMgr.getForm("hsshin@maninsoft.co.kr", "frm_3dbf6b88c28346a181172db0828a4bd4");

	SwfField[] fields = swfForm.getFields();

	for(SwfField field : fields) {
		System.out.println(field.getName());
		System.out.println(field.getSystemType());
	}

	ISwdManager swdMgr = (ISwdManager)SmartUtil.getBean("swdManager", request);

	SwdRecordCond swdRecordCond = new SwdRecordCond();
	swdRecordCond.setFormId("frm_board_SYSTEM");
	swdRecordCond.setRecordId("402880a53169245601316a27f1530005");

	SwdRecord swdRecord = swdMgr.getRecord("hsshin@maninsoft.co.kr", swdRecordCond, null);

	System.out.println(swdRecord.toString(null, null));
	SwdDataField[] dataFields = swdRecord.getDataFields();
	for(SwdDataField dataField : dataFields) {
		dataField.getId();
		dataField.getName();
		dataField.getValue();
	}

	List<String> list = SwManagerFactory.getInstance().getDocManager().findDocIdByGroupId("fg_0019ae0b682e451b953fbf823a633db6");
	for(String str : list) {
		out.println(str);
	} */

	ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);

	//InformationWork infoWork = (InformationWork)smartworks.getWorkById("Maninsoft", "hsshin@maninsoft.co.kr", "pkg_af2c5abbdc694feab78b2706c31f3bde");
	//Work work = smartworks.getWorkById("Maninsoft", "hsshin@maninsoft.co.kr", "pkg_af2c5abbdc694feab78b2706c31f3bde");

	//System.out.println("PackageName = " + work.getName() + ", PackageId = " + work.getId() + ", PackageType = " + work.getType() + ", PackageDescription = " + work.getDesc());

 	/* InformationWork infoWork = (InformationWork) smartworks.getWorkById("Semiteq", "hsshin@maninsoft.co.kr", "pkg_af2c5abbdc694feab78b2706c31f3bde");

 	System.out.println("getAccessPolicy().getLevel()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+infoWork.getAccessPolicy().getLevel());
	System.out.println("getWritePolicy().getLevel()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+infoWork.getWritePolicy().getLevel());
	System.out.println("getEditPolicy().getLevel()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+infoWork.getEditPolicy().getLevel());

 	for(FormField form : infoWork.getDisplayFields()) {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+CommonUtil.toNotNull(form.getId()) + " " + form.getName());
		} catch(NullPointerException e){
			e.printStackTrace();
		}
	}
 */
/* 	SmartWork smartWork = (SmartWork) smartworks.getWorkById("Semiteq", "hsshin@maninsoft.co.kr", "pkg_af2c5abbdc694feab78b2706c31f3bde");
	System.out.println(smartWork.getFullpathName()); */
/* 	WorkSpace workSpace = smartworks.getWorkSpaceById("PROTEC1_TEAM");
	if(workSpace.getClass().equals(User.class)) {
		User user = (User)workSpace;
		System.out.println(user.getName());
	} else if(workSpace.getClass().equals(Department.class)) {
		Department department = (Department)workSpace;
		System.out.println(department.getName());
	} else {
		System.out.println("null");
	} */

/* 	User user = smartworks.getUserById("hsshin@maninsoft.co.kr");
	System.out.println(user.getEmailAddressShown() + user.getName());
	Department department = smartworks.getDepartmentById("PROTEC1_TEAM");
	System.out.println(department.getName() + department.getParent().getName()); */

/*	IWorkService workService = (IWorkService)SmartUtil.getBean("workServiceImpl", request);

	workService.addAFavoriteWork("pkg_ba32f6e9af594c9ea9cf921ffa2cadee");
	*/

	//CompanyCalendar[] companyCalendars = smartworks.getCompanyCalendars(new LocalDate(), 3);
	//workService.removeAFavoriteWork("pkg_ba32f6e9af594c9ea9cf921ffa2cadee");

	IInstanceService instanceService = (IInstanceService)SmartUtil.getBean("instanceServiceImpl", request);

/* 	ITskManager tskMgr = (ITskManager)SmartUtil.getBean("tskManager", request);
	TskTaskCond tskCond = new TskTaskCond();
	tskCond.setForm("frm_98aa2e3d4f334536a441ff484ac37611");
	tskCond.setExtendedProperties(new Property[] {new Property("referencedRecordId", "52fca4b2252dcd8d012534040dd00029")});
	TskTask[] tasks = tskMgr.getTasks("", tskCond, IManager.LEVEL_LITE);

	System.out.println(tasks.length); */

/* 	ISwdManager swdMgr = (ISwdManager)SmartUtil.getBean("swdManager", request);

	SwdRecordCond swdRecordCond = new SwdRecordCond();
	swdRecordCond.setFormId("frm_98aa2e3d4f334536a441ff484ac37611");
	swdRecordCond.setReferencedRecordId("52fca4b2252dcd8d012534040dd00029");

	long totalSize = swdMgr.getRecordSize("hsshin@maninsoft.co.kr", swdRecordCond);  

	System.out.println(totalSize);
	SwdRecord[] swdRecords = swdMgr.getRecords("", swdRecordCond, null); */

	//TaskInstanceInfo[] taskInstanceInfos = instanceService.getInstanceTaskHistoriesById("52fca4b22ca0dbd5012ca52c28ae0011");
	//System.out.println(taskInstanceInfos);
	//InstanceInfoList[] resultList = instanceService.getInstanceRelatedWorksById("52fca4b2265f233c012684fba2630068");
	//System.out.println(resultList.length);

	ISwfManager swfMgr = (ISwfManager)SmartUtil.getBean("swfManager", request);

	int size = swfMgr.getReferenceFormSize("", "52fca4b2265f233c012684fba2630068");

	System.out.println("size ::: " + size);
%>
<textarea style="width:800px;height:400px;">
</textarea>
</body>
</html>
