<%@page import="net.smartworks.server.engine.resource.model.hb.HbOrgDeptModel"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.server.engine.resource.model.IOrgDeptModel"%>
<%@page import="net.smartworks.server.engine.common.manager.IManager"%>
<%@page import="net.smartworks.server.engine.factory.SwManagerFactory"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoDepartment"%>
<%@page import="net.smartworks.server.engine.common.model.Order"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoDepartmentCond"%>
<%@page import="net.smartworks.server.engine.resource.util.lang.ExceptionUtil"%>
<%@page import="net.smartworks.server.engine.resource.util.lang.StringUtil"%>
<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>
<%!
	public List<IOrgDeptModel> toDeptModelList(SwoDepartment[] depts) {
		List<IOrgDeptModel> list = new ArrayList<IOrgDeptModel>();
		if (CommonUtil.isEmpty(depts))
			return list;
		for (SwoDepartment dept : depts)
			list.add(toDeptModel(dept));
		return list;
	}
	public IOrgDeptModel toDeptModel(SwoDepartment dept) {
		IOrgDeptModel deptModel = new HbOrgDeptModel();
		deptModel.setCompanyId(dept.getCompanyId());
		deptModel.setDescription(dept.getDescription());
		deptModel.setId(dept.getId());
		deptModel.setName(dept.getName());
		deptModel.setParentId(dept.getParentId());
		deptModel.setType(dept.getType());
		return deptModel;
	}
	public String convertDept(SwoDepartment dept) {
		return convertDept(toDeptModel(dept));
	}
	public String convertDept(IOrgDeptModel dept) {
		String str = "<Result status=\"OK\">";
		str += "<item id=\""+ dept.getId() + "\" type=\"" + dept.getType() + "\" name=\"" +dept.getName()+ "\" nodeType=\"Directory\" />";
		str += "</Result>";
		return str;
	}
	
	public String convertDept(SwoDepartment[] depts) {
		return convertDept(toDeptModelList(depts));
	}
	public String convertDept(List<IOrgDeptModel> deptList) {
		String str = "<Result status=\"OK\">";
		for(IOrgDeptModel dept : deptList)
			str += "<item id=\""+ dept.getId() + "\" type=\"" + dept.getType() + "\" name=\"" +dept.getName()+ "\" nodeType=\"Directory\" />";
		str += "</Result>";
		return str;
	}
%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	
	String userId = request.getParameter("userId");
	String method = StringUtil.toNotNull(request.getParameter("method"));
//	StringBuffer buffer = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	StringBuffer buffer = new StringBuffer();
	
	try {
		if(method.equals("")) {
			buffer.append("<Result status=\"Failed\"><message>Invalid method! Not found method parameter</message><trace/></Result>");
		
		// 사용자 생성
		} else if(method.equals("findChildDept")) {			
			String parentId = StringUtil.toNotNull(request.getParameter("parentId"));
			SwoDepartmentCond cond = new SwoDepartmentCond();
			cond.setParentId(parentId);
			cond.setOrders(new Order[] {new Order("name", true)});
			SwoDepartment[] depts = SwManagerFactory.getInstance().getSwoManager().getDepartments(userId, cond, IManager.LEVEL_LITE);
			buffer.append(this.convertDept(depts));
			
		} else {
			buffer.append("<Result status=\"Failed\"><message>Invalid method! Not found method parameter</message><trace/></Result>");
		}
		
	} catch (Throwable th) {
		buffer.append("<Result status=\"Failed\">");
		buffer.append("<message>");
		buffer.append("Failed to execute method (" + method + ") - " + th.getMessage());
		buffer.append("</message>");
		buffer.append("<trace><![CDATA[");
		buffer.append(ExceptionUtil.getTraceMessage("", th));
		buffer.append("]]></trace>");
		buffer.append("</Result>");
		LogFactory.getLog("organizationService").error(buffer.toString());
	}
%><%= buffer.toString() %>