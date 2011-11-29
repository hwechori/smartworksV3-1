<%@page import="net.smartworks.server.engine.process.process.model.PrcProcessInstExtend"%>
<%@page import="net.smartworks.server.engine.process.process.manager.impl.PrcManagerImpl"%>
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
		long size = SwManagerFactory.getInstance().getPrcManager().getProcessInstExtendsSize("kmyu@maninsoft.co.kr","pkg_e4e0150049fd4a44828dd01c797ee07e");
		
		PrcProcessInstExtend[] works = SwManagerFactory.getInstance().getPrcManager().getProcessInstExtends("kmyu@maninsoft.co.kr", 10, 0, "pkg_e4e0150049fd4a44828dd01c797ee07e");
		System.out.println(size);
		System.out.println(works.length);
		System.out.println(works[0].getPrcTitle());
			
%>
<textarea style="width:800px;height:400px;">
<%= works[0].getPrcTitle() %>
</textarea>
</body>
</html>
