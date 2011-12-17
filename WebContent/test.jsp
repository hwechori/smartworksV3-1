<%@page import="net.smartworks.server.engine.infowork.domain.model.SwdRecord"%>
<%@page import="net.smartworks.server.engine.common.manager.IManager"%>
<%@page import="net.smartworks.server.engine.process.process.model.PrcProcessInstExtend"%>
<%@page import="net.smartworks.server.engine.process.process.model.PrcProcessInstCond"%>
<%@page import="java.io.File"%>
<%@page import="net.smartworks.server.engine.process.task.model.TskTaskCond"%>
<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.server.service.impl.InstanceServiceImpl"%>
<%@page import="net.smartworks.server.service.impl.WorkServiceImpl"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.server.service.IWorkService"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.WorkCategory"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@page import="net.smartworks.server.engine.process.approval.model.AprApproval"%>
<%@page import="net.smartworks.server.engine.factory.SwManagerFactory"%>
<%@page import="net.smartworks.server.engine.process.approval.manager.IAprManager"%>
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
<%!public static Object getBean(String beanName, HttpServletRequest request) {

	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

	return (Object) wac.getBean(beanName);
}%>
<%
			
	StringBuffer strBuff = new StringBuffer();
	strBuff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	strBuff.append("<DataRecord domainId=\"md_38713a9cf8354ed3aef4fccd521d88df\" formId=\"frm_b5d88ed991dd4677a9f0d482f412fb55\" formVersion=\"1\">");
	strBuff.append("	<DataField id=\"0\" name=\"text\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[text1111]]></DataField>");
	strBuff.append("	<DataField id=\"1\" name=\"number\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[1231111]]></DataField>");
	strBuff.append("	<DataField id=\"2\" name=\"currency\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[100111]]></DataField>");
	strBuff.append("	<DataField id=\"3\" name=\"percent\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[50]]></DataField>");
	strBuff.append("	<DataField id=\"4\" name=\"combo\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[list 1]]></DataField>");
	strBuff.append("	<DataField id=\"5\" name=\"check\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[true]]></DataField>");
	strBuff.append("	<DataField id=\"6\" name=\"radio\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[radio 2]]></DataField>");
	strBuff.append("	<DataField id=\"7\" name=\"date\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[2011-12-11]]></DataField>");
	strBuff.append("	<DataField id=\"8\" name=\"time\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[17:30]]></DataField>");
	strBuff.append("	<DataField id=\"9\" name=\"email\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[email@maninsoft.co.kr]]></DataField>");
	strBuff.append("	<DataField id=\"10\" name=\"image\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"/>");
	strBuff.append("	<DataField id=\"11\" name=\"user\" row=\"0\" refForm=\"frm_user_SYSTEM\" refFormField=\"4\" refRecordId=\"hsshin@maninsoft.co.kr\"><![CDATA[선임연구원 신현성]]></DataField>");
	strBuff.append("	<DataField id=\"12\" name=\"referencework\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"/>");
	strBuff.append("	<DataField id=\"14\" name=\"file\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"/>");
	strBuff.append("	<DataField id=\"13\" name=\"richtext\" row=\"0\" refForm=\"\" refFormField=\"\" refRecordId=\"\"><![CDATA[rich]]></DataField>");
	strBuff.append("</DataRecord>");
	
	SwManagerFactory.getInstance().getSwdManager().setRecord("kmyu@maninsoft.co.kr", (SwdRecord)SwdRecord.toObject(strBuff.toString()), IManager.LEVEL_ALL);





	




%>
<textarea style="width:800px;height:400px;">
</textarea>
</body>
</html>
