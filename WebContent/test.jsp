<%@page import="net.smartworks.server.engine.organization.model.SwoUserCond"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoUser"%>
<%@page import="net.smartworks.server.engine.organization.manager.ISwoManager"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.server.engine.factory.MisManagerFactory"%>
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
<%!
public static Object getBean(String beanName, HttpServletRequest request) {

	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

	return (Object) wac.getBean(beanName);
}
%>
<%

	//String getHeader = request.getHeader("X-Requested-With");
	//ILnkManager mgr = (ILnkManager)getBean("lnkManagerImpl", request);
	/* 
	MisManagerFactory fac = MisManagerFactory.createInstance();
	ILnkManager mgr = (ILnkManager)fac.getLnkManager(); */

	//ILnkManager mgr = (ILnkManager)MisManagerFactory.getInstance().getLnkManager();
	ISwoManager mgr = (ISwoManager)SmartUtil.getBean("swoManagerImpl", request);

	SwoUserCond swoUserCond = new SwoUserCond();
	swoUserCond.setId("hsshin@maninsoft.co.kr");
	SwoUser swoUser = mgr.getUser("", swoUserCond, null);

%>
<textarea style="width:800px;height:400px;">
<%=swoUser.getName()%>
<%=swoUser.getEmail()%>
<%=swoUser.getMobileNo()%>
</textarea>
</body>
</html>