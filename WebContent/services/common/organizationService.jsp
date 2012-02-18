<%@page import="net.smartworks.server.engine.resource.model.hb.HbOrgUserModel"%>
<%@page import="net.smartworks.server.engine.resource.model.IOrgUserModel"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoUser"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoUserCond"%>
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
	public String convertUser(SwoUser[] users, long totalSize) {
		return convertUser(toUserModelList(users), totalSize);
	}
	public String convertUser(List<IOrgUserModel> userList, long totalSize) {
		String str = "<Result status=\"OK\" totalSize=\""+totalSize+"\">";
		for(IOrgUserModel user : userList)
			str += user.toString();
		str += "</Result>";
		return str;
	}
	public List<IOrgUserModel> toUserModelList(SwoUser[] users) {
		List<IOrgUserModel> list = new ArrayList<IOrgUserModel>();
		if (CommonUtil.isEmpty(users))
			return list;
		for (SwoUser user : users)
			list.add(toUserModel(user));
		return list;
	}
	public IOrgUserModel toUserModel(SwoUser user) {
		IOrgUserModel userModel = new HbOrgUserModel();
		userModel.setAuthId(user.getAuthId());
		userModel.setCompanyId(user.getCompanyId());
		userModel.setDeptId(user.getDeptId());
		userModel.setEmail(user.getEmail());
		userModel.setEmpNo(user.getEmpNo());
		userModel.setId(user.getId());
		userModel.setLang(user.getLang());
		userModel.setName(user.getName());
		userModel.setPasswd(user.getPassword());
		userModel.setPicture(user.getPicture());
		userModel.setPosition(user.getPosition());
		userModel.setRoleId(user.getRoleId());
		userModel.setStdTime(user.getStdTime());
		userModel.setType(user.getType());
		return userModel;
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
			
		} else if(method.equals("findUserByDept")) {
			String deptId = StringUtil.toNotNull(request.getParameter("deptId"));
			SwoUserCond cond = new SwoUserCond();
			cond.setDeptId(deptId);
			long totalSize = SwManagerFactory.getInstance().getSwoManager().getUserSize(userId, cond);
			cond.setOrders(new Order[] {new Order("name", true)});
			SwoUser[] users = SwManagerFactory.getInstance().getSwoManager().getUsers(userId, cond, null);
			buffer.append(this.convertUser(users, totalSize));
			
		// 루트 부서 조회
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