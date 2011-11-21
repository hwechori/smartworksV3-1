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
	}
%>
<textarea style="width:800px;height:400px;">
<%=swfForm %>
</textarea>
</body>
</html>