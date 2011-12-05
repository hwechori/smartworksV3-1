<%@page import="net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef"%>
<%@page import="java.util.List"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfForm"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfFormCond"%>
<%@page import="net.smartworks.server.engine.factory.SwManagerFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%

	String key = request.getParameter("key");
	
	String packageId = "pkg_7078af4990b84cc284850186c3ed807a";

	SwfFormCond cond = new SwfFormCond();
	cond.setPackageId(packageId);
	
	SwfForm[] forms = SwManagerFactory.getInstance().getSwfManager().getForms("kmyu@maninsoft.co.kr", cond, "all");
	
	for (int i = 0; i < forms.length; i++) {
		SwfForm form = forms[i];
%>
<textarea cols="100" rows="100">
<%= form.getObjString() %>
</textarea>
<%
	}
%>