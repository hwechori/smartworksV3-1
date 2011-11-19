<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef"%>
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
	
	ISwfManager swfMgr = (ISwfManager)SmartUtil.getBean("swfManager", request);

	SwfForm swfForm = swfMgr.getForm("hsshin@maninsoft.co.kr", "frm_3dbf6b88c28346a181172db0828a4bd4");

/* 	SwfField[] fields = swfForm.getFields();

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

	List<SwfFormFieldDef> formFieldDefList = SwManagerFactory.getInstance().getSwfManager().findFormFieldByForm("frm_board_SYSTEM", true);
/* 	HashMap<String, SwfFormFieldDef> hash = new HashMap<String, SwfFormFieldDef>();
	for (int idx = 0 ; idx < formFieldDefList.size() ; idx++) {
		SwfFormFieldDef fieldDef = (SwfFormFieldDef)formFieldDefList.get(idx);
		hash.put(fieldDef.getId(), fieldDef);
		System.out.println("key : " + fieldDef.getId() + " value : " + fieldDef);	
	} */

	for(SwfFormFieldDef formFieldDef : formFieldDefList) {
		//System.out.println(formFieldDef.getId() + formFieldDef.getName() + formFieldDef.getViewingType() + formFieldDef.getFormatType() + formFieldDef.getSystemName());
	}

	ISmartWorks smartworks = (ISmartWorks)SmartUtil.getBean("smartWorks", request);

	//InformationWork infoWork = (InformationWork)smartworks.getWorkById("Maninsoft", "hsshin@maninsoft.co.kr", "pkg_af2c5abbdc694feab78b2706c31f3bde");
	//Work work = smartworks.getWorkById("Maninsoft", "hsshin@maninsoft.co.kr", "pkg_af2c5abbdc694feab78b2706c31f3bde");

	//System.out.println("PackageName = " + work.getName() + ", PackageId = " + work.getId() + ", PackageType = " + work.getType() + ", PackageDescription = " + work.getDesc());

	//InformationWork infoWork = (InformationWork) smartworks.getWorkById("Maninsoft", "hsshin@maninsoft.co.kr", "pkg_af2c5abbdc694feab78b2706c31f3bde");

/* 	System.out.println("getAccessPolicy().getLevel()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+infoWork.getAccessPolicy().getLevel());
	System.out.println("getWritePolicy().getLevel()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+infoWork.getWritePolicy().getLevel());
	System.out.println("getEditPolicy().getLevel()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+infoWork.getEditPolicy().getLevel()); */

	//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+infoWork.getDisplayFields().length);

/* 	for(FormField form : infoWork.getDisplayFields()) {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+CommonUtil.toNotNull(form.getId()));
		} catch(NullPointerException e){
			e.printStackTrace();
		}
	} */

	SmartWork smartWork = (SmartWork) smartworks.getWorkById("Maninsoft", "hsshin@maninsoft.co.kr", "pkg_265abe124f0d4349b7e298f90f98c9fc");

	System.out.println(smartWork.getFullpathName());
%>
<textarea style="width:800px;height:400px;">
<%=swfForm %>
</textarea>
</body>
</html>