<%@ page contentType="text/xml; charset=UTF-8" %>
<%@page import="net.smartworks.server.engine.resource.util.lang.ExceptionUtil"%>
<%@page import="net.smartworks.server.engine.common.manager.IManager"%>
<%@page import="com.sun.org.apache.xpath.internal.XPathAPI"%>
<%@page import="net.smartworks.server.engine.organization.model.SwoUser"%>
<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="net.smartworks.server.engine.common.util.XmlUtil"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="net.smartworks.server.engine.resource.util.lang.StringUtil"%>
<%@page import="net.smartworks.server.engine.factory.SwManagerFactory"%>
<%@page import="net.smartworks.server.engine.resource.model.IFormModel"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.server.engine.pkg.model.PkgPackage"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>
<%!
	//사용자
	public static String convertUserId(String xml) throws Exception {
		Document doc = XmlUtil.toDocument(xml, "utf-8");
		Element ele = doc.getDocumentElement();
	
		NodeList actNodes = XPathAPI.selectNodeList(ele, "//xpdl:Activity");
		
		if (actNodes != null && actNodes.getLength() != 0) {
	
			for (int i=0; i<actNodes.getLength(); i++) {
				Node actNode = actNodes.item(i);
				Element actElement = (Element)actNode;
				if (actElement != null) {
					String performerName = actElement.getAttribute("PerformerName");
					if (!CommonUtil.isEmpty(performerName)) {
						SwoUser userObj = SwManagerFactory.getInstance().getSwoManager().getUser(performerName, performerName, IManager.LEVEL_LITE);
						if (userObj != null)
							performerName = userObj.getPosition() + " " + userObj.getName();
						actElement.setAttribute("PerformerName", performerName);
					}
				}
			}
		}
		return XmlUtil.toXmlString(doc);
	}
%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	
	String userId = request.getParameter("userId");
	String userLanguage = request.getParameter("userLanguage");
	String compId = request.getParameter("compId");
	
	String method = StringUtil.toNotNull(request.getParameter("method"));
	StringBuffer buffer = new StringBuffer();
	
	try {
		// 에러 - 메소드 이름이 없음
		if(method.equals("")) {
			buffer.append("<Result status=\"Failed\"><message>Invalid method! Not found method parameter</message><trace/></Result>");
		
		// 사용자 이름 검색
		} else if(method.equals("monitorPrcInst")) {
			String prcInstId = request.getParameter("prcInstId");
			String xml = SwManagerFactory.getInstance().getMonManager().monitor(null, prcInstId, null);
			//TODO 없어져야함 플렉스에서 사용자 아이디를 받아서 이름으로 컨버팅하는 작업을 해주어야함 , 서버에서 할일X
			xml = convertUserId(xml);
			
			xml = xml.substring(xml.indexOf("?>") + 1);
		
			buffer.append(xml);
			
		// 특정 워크아이템 아이디로 그룹 워크아이템 인스턴스 리스트를 검색
		} else {
			buffer.append("<Result status=\"Failed\"><message>Invalid method! Not found method parameter</message><trace/></Result>");
		}
		
	} catch (Throwable e) {
		buffer.append("<Result status=\"Failed\">");
		buffer.append("<message>");
		buffer.append("Failed to execute method (" + method + ") - " + e.getMessage());
		buffer.append("</message>");
		buffer.append("<trace><![CDATA[");
		buffer.append(ExceptionUtil.getTraceMessage("", e));
		buffer.append("]]></trace>");
		buffer.append("</Result>");
		LogFactory.getLog("searchingService").error(buffer.toString());
		e.printStackTrace();
	}
%><%= buffer.toString() %>