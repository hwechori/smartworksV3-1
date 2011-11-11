<%@page language="java" pageEncoding="UTF-8" contentType="text/xml; charset=UTF-8"%>
<%@page import="com.maninsoft.model.AcpActualParameter"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="java.net.URL"%>
<%@page import="org.apache.axis.client.Call"%>
<%@page import="org.apache.axis.client.Service"%>
<%@page import="java.net.MalformedURLException"%>
<%@page import="javax.xml.rpc.ServiceException"%>
<%@page import="java.rmi.RemoteException"%>
<%@page import="com.maninsoft.model.MappingService"%>
<%@page import="com.maninsoft.smart.webservice.model.WebWebService"%>
<%@page import="com.maninsoft.smart.webservice.model.WebWebServiceParameter"%>
<%@page import="com.maninsoft.smart.form.model.SwfFieldMapping"%>
<%@page import="com.maninsoft.manager.IManager"%>
<%@page import="com.maninsoft.factory.MisManagerFactory"%>
<%@page import="com.maninsoft.model.Property"%>
<%@page import="com.maninsoft.task.model.TskTaskDefCond"%>
<%@page import="com.maninsoft.task.model.TskTaskDef"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>
<%@ page import="com.maninsoft.smart.util.lang.StringUtil"%>
<%@ page import="com.maninsoft.smart.util.lang.ExceptionUtil"%>
<%@ page import="com.maninsoft.smart.server.util.SmartServerModelUtil"%>
<%@ page import="com.maninsoft.smart.worklist.util.WorklistUtil"%>
<%@ page import="com.maninsoft.smart.worklist.model.IWorkItem"%>
<%@ page import="com.maninsoft.smart.worklist.model.IWorkItemInfo"%>
<%@ page import="com.maninsoft.smart.worklist.api.WorklistManager"%>
<%@ page import="com.maninsoft.smart.worklist.api.IWorklistSearcher"%>
<%@ page import="com.maninsoft.smart.worklist.api.IWorklistHandler"%>
<%@ page import="com.maninsoft.smart.server.api.SmartServerManager"%>
<%@ page import="com.maninsoft.smart.server.api.IResourceRuntimeManager"%>
<%@ page import="com.maninsoft.smart.server.api.IResourceDesigntimeManager"%>
<%@ page import="com.maninsoft.smart.server.model.IWorkTypeModel"%>
<%@ page import="com.maninsoft.smart.server.model.hb.HbDomainFieldData"%>
<%@ page import="com.maninsoft.smart.server.model.IDomainFieldData"%>
<%@ page import="com.maninsoft.smart.server.model.hb.HbDomainRecordData"%>
<%@ page import="com.maninsoft.smart.server.model.IDomainRecordData"%>
<%@ page import="com.maninsoft.smart.engine.data.model.ISmartMessage"%>
<%@ page import="com.maninsoft.smart.engine.SmartBpmsEngine"%>
<%@ page import="com.maninsoft.task.model.TskTask" %> 
<%@ page import="com.maninsoft.factory.MisServiceFactory" %> 
<%@ page import="com.maninsoft.util.CommonUtil" %>
<%@ page import="com.maninsoft.framework2smart.SmartApi"%>
<%@ page import="com.maninsoft.chart.model.ChtPertChart"%>
<%@ page import="com.maninsoft.chart.model.ChtPertItem"%>
<%@ page import="com.maninsoft.smart.portal.jsp.util.SmartUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.maninsoft.smart.domain.model.SwdRecord"%>
<%@ page import="com.maninsoft.smart.domain.model.SwdDataField"%>
<%@ page import="com.maninsoft.smart.factory.SwManagerFactory" %>
<%@ page import="com.maninsoft.smart.form.model.SwfForm" %>
<%@ page import="com.maninsoft.smart.form.model.SwfFormRef" %>
<%@ page import="com.maninsoft.smart.form.model.SwfFormLink" %>
<%@ page import="com.maninsoft.smart.form.model.SwfField" %>
<%@ page import="com.maninsoft.smart.form.model.SwfFieldRef" %>
<%@ page import="com.maninsoft.smart.form.model.SwfFormat" %>
<%@ page import="com.maninsoft.smart.form.model.SwfMapping" %>
<%@ page import="com.maninsoft.smart.form.model.SwfMappings" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.maninsoft.util.DateUtil" %>
<%@ page import="com.maninsoft.smart.organization.model.SwoUser"%>
<%@ page import="java.util.Date" %>
<%@ page import="com.maninsoft.approval.model.AprApproval" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@page import="javax.xml.xpath.XPathExpressionException"%>
<%@page import="java.io.IOException"%>
<%@page import="org.xml.sax.SAXException"%>
<%@page import="javax.xml.parsers.ParserConfigurationException"%>
<%@page import="org.w3c.dom.NamedNodeMap"%>
<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="com.maninsoft.util.XmlUtil"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="com.maninsoft.smart.portal.webapp.common.util.ManagerUtil"%>
<%@page import="com.maninsoft.smart.portal.webapp.log.manager.LogManager"%>
<%@page import="com.maninsoft.smart.portal.webapp.log.model.LogModel"%>
<%@page import="com.maninsoft.smart.server.model.IPackageModel"%>
<%@page import="com.maninsoft.smart.organization.model.SwoUserCond"%>
<%@page import="com.maninsoft.smart.organization.model.SwoDepartment"%>
<%@page import="com.maninsoft.smart.organization.manager.ISwoManager"%>
<%!
public String RETURN_TYPE_ARRAY = "ArrayOf_xsd_string";

public String[] invokeWebService(String targetEndpointAddress, String operation, String[] inputParams, String returnType)  throws MalformedURLException, ServiceException, RemoteException {
	if (CommonUtil.isEmpty(targetEndpointAddress) || CommonUtil.isEmpty(operation))
		return null;
	Service service = new Service();
	Call call = (Call)service.createCall();
	call.setTargetEndpointAddress(new URL(targetEndpointAddress));
	call.setOperationName(new QName("", operation));
	String[] returnValue = null;
	if (CommonUtil.toNotNull(returnType).equalsIgnoreCase(RETURN_TYPE_ARRAY)) {
		returnValue = (String[])call.invoke(inputParams);
	} else {
		returnValue = new String[] {(String)call.invoke(inputParams)};
	}
	return returnValue;
}

public String[] getInputParams(AcpActualParameter[] actualParameters, Map<String,String> checkMap, SwdRecord oldRec){
	
	if(actualParameters != null){
		List<String> paramFieldIds = null;
		for(AcpActualParameter param : actualParameters){
			if(param.getMode().equalsIgnoreCase("IN")){
				if(paramFieldIds == null) paramFieldIds = new ArrayList<String>();
				paramFieldIds.add(param.getFieldId());
			}
		}
		if(paramFieldIds != null && oldRec.getDataFields() != null){
			String[] getInputParams = new String[paramFieldIds.size()];
			int idxx = 0;
			for(String paramId : paramFieldIds){
				SwdDataField[] dataFields = oldRec.getDataFields();
				SwdDataField tempDataField = null;
				int cnt = 0;
				String value = checkMap.get(paramId);
				if(value != null && dataFields !=null){
					for(SwdDataField dataField : dataFields){
						if(dataField.getId().equals(paramId) && dataField.getValue().equals(value)){
							tempDataField = dataField;
						}
						if(dataField.getId().equals(paramId)){
							cnt++;
						}
					}
				}
				
				SwdDataField oldDataField = oldRec.getDataField(paramId);
				if(cnt > 1){
					oldDataField = tempDataField;
				}else{
					SwdDataField[] dataF =  oldRec.getDataFields();
					if(dataF !=null){
						for(int di = 0; di<dataF.length;di++){
							if(dataF[di].getId().equals(paramId) && dataF[di].getRefForm() !=null){
								oldDataField = dataF[di];
							}
						}
					}
				}
				
				if(oldDataField !=null)
					getInputParams[idxx++] = oldDataField.getValue();
			}
			String arrayParam[] = new String[getInputParams.length];
			
				arrayParam = new String[getInputParams.length];
			
			int gidx = 0;
			for(int gi = 0; gi < getInputParams.length ; gi++){
				arrayParam[gidx++] = getInputParams[gi];
			}
			return arrayParam;
		}
	}
	return null;
}

	// 파라미터 맵으로 워크아이템 데이터를 생성한다.
	public String convert(String formId, String formVersion, Map<String, String[]> parameterMap) {
		
		Iterator<String> pIt = parameterMap.keySet().iterator();
		
		String[] idList = null;
		String[] nameList = null;
		String[] typeList = null;
		String[] dataList = null;
		
		while(pIt.hasNext()) {
			String key = pIt.next();
			String[] value = parameterMap.get(key);
			
			// 예약어
			if(key.startsWith("$"))
				continue;
			
			// 데이터 필드 아이디
			if(key.equals("FIELD_ID")) {
				idList = value;
				
			// 데이터 필드 타입
			} else if(key.equals("FIELD_TYPE")) {
				typeList = value;
				
			// 데이터 필드 이름
			} else if(key.equals("FIELD_NAME")) {
				nameList = value;
				
			// 데이터 필드 데이터
			} else if(key.equals("FIELD_DATA")) {
				dataList = value;
			}
		}
		
		IDomainRecordData record = new HbDomainRecordData();
		record.setFormId(formId);
		record.setFormVersion(Integer.parseInt(formVersion));
		
		for(int i = 0 ; i < idList.length ; i++) {
			IDomainFieldData fieldData = new HbDomainFieldData();
			fieldData.setId(idList[i]);
			fieldData.setName(nameList[i]);
			fieldData.setType(typeList[i]);
			fieldData.setData(dataList[i]);
			record.addDataField(fieldData);
		}
		
		return record.toString();
	}

	public String convert(List<IDomainRecordData> recordList) {
		StringBuffer str = new StringBuffer("<DataRecords>");
		if(!CommonUtil.isEmpty(recordList)) {
			for(IDomainRecordData record : recordList)
				str.append(record.toString());
		}
		str.append("</DataRecords>");
		return str.toString();
	}
	
	public SwdDataField toDataField(String user, SwfField field, String id) throws Exception {
		if (CommonUtil.isEmpty(id))
			return null;
		SwfFormat fieldFormat = field.getFormat();
		SwdDataField obj = null;
		if (fieldFormat == null || !"userField".equals(fieldFormat.getType())) {
			obj = new SwdDataField();
			obj.setId(field.getId());
			obj.setType(field.getSystemType());
			obj.setValue(id);
		} else {
			obj = toUserDataField(user, id);
		}
		
		// FIXME 깔끔하게 수정 필요
		/*
		dataField = newRec.getDataField(fieldId);
		if (dataField != null) {
			SwfFormat format = field.getFormat();
			if (format != null) {
				String formatType = format.getType();
				if (formatType != null && formatType.equalsIgnoreCase("refFormField")) {
					SwfFormRef formRef = format.getRefForm();
					if (formRef != null) {
						dataField.setRefForm(formRef.getId());
						SwfFieldRef fieldRef = formRef.getField();
						if (fieldRef != null) {
							dataField.setRefFormField(fieldRef.getId());
							if (CommonUtil.toNull(dataField.getRefRecordId()) == null &&
									CommonUtil.toNull(dataField.getRefForm()) != null && 
									CommonUtil.toNull(dataField.getRefFormField()) != null && 
									CommonUtil.toNull(dataField.getValue()) != null) {
								SwdRecordCond recCond = new SwdRecordCond();
								recCond.setFormId(dataField.getRefForm());
								recCond.addFilter(new Filter("=", dataField.getRefFormField(), dataField.getValue()));
								recCond.setOrders(new Order[] {new Order("createdTime", false)});
								recCond.setPageSize(1);
								SwdRecord[] rec = SmartApi.getRecords(userId, recCond);
								if (!CommonUtil.isEmpty(rec)) {
									dataField.setRefRecordId(rec[0].getRecordId());
								}
							}
						}
					}
				}
			}
		}
		*/
		return obj;
	}
	public SwdDataField toUserDataField(String user, String id) throws Exception {
		if (CommonUtil.isEmpty(id))
			return null;
		SwoUser userModel = SmartApi.getUser(user, id);
		if (userModel == null)
			return null;
		SwdDataField dataField = new SwdDataField();
		dataField.setRefForm("frm_user_SYSTEM");
		dataField.setRefFormField("4");
		dataField.setRefRecordId(id);
		dataField.setValue(userModel.getPosition() + " " + userModel.getName());
		return dataField;
	}
	
	public MappingService setMappingService(String xml){
		MappingService mappingService = new MappingService();
		try {
			Document doc = XmlUtil.toDocument(xml);
			Element root = doc.getDocumentElement();
	
			String mappingId = root.getAttribute("id");
			String mappingName = root.getAttribute("name");
			String mappingTargetServiceId = root.getAttribute("targetServiceId");
			String mappingExecution = root.getAttribute("Execution");
			
			mappingService.setId(mappingId);
			mappingService.setName(mappingName);
			mappingService.setTargetServiceId(mappingTargetServiceId);
			mappingService.setExecution(mappingExecution);
			
			NodeList itemNodeList = doc.getElementsByTagName("ActualParmeter");
			AcpActualParameter[] actualParameters = new AcpActualParameter[itemNodeList.getLength()];
			for (int j = 0; j < itemNodeList.getLength(); j++) {
				AcpActualParameter actualParameter = new AcpActualParameter();
				Node itemNode = itemNodeList.item(j);
				if (itemNode.getNodeType() != Node.ELEMENT_NODE)
					continue;
				
				NamedNodeMap nodeMap = itemNode.getAttributes();
				
				Node paramIdNode = nodeMap.getNamedItem("Id");
				if (paramIdNode != null)
					actualParameter.setId(paramIdNode.getNodeValue());
				
				Node paramNameNode = nodeMap.getNamedItem("Name");
				if (paramNameNode != null)
					actualParameter.setName(paramNameNode.getNodeValue());
				
				Node paramDataTypeNode = nodeMap.getNamedItem("DataType");
				if (paramDataTypeNode != null)
					actualParameter.setDataType(paramDataTypeNode.getNodeValue());
				
				Node paramModeNode = nodeMap.getNamedItem("Mode");
				if (paramModeNode != null)
					actualParameter.setMode(paramModeNode.getNodeValue());
				
				Node paramTargetTypeNode = nodeMap.getNamedItem("TargetType");
				if (paramTargetTypeNode != null){
					actualParameter.setTargetType(paramTargetTypeNode.getNodeValue());
					
					Node paramFieldIdNode = nodeMap.getNamedItem("FieldId");
					if (paramFieldIdNode != null)
						actualParameter.setFieldId(paramFieldIdNode.getNodeValue());
					Node paramFieldNameNode = nodeMap.getNamedItem("FieldName");
					if (paramFieldNameNode != null)
						actualParameter.setFieldName(paramFieldNameNode.getNodeValue());
				}
				
				Node paramValueTypeNode = nodeMap.getNamedItem("ValueType");
				if (paramValueTypeNode != null)
					actualParameter.setValueType(paramValueTypeNode.getNodeValue());
				
				Node paramExpressionNode = nodeMap.getNamedItem("Expression");
				if (paramExpressionNode != null)
					actualParameter.setExpression(paramExpressionNode.getNodeValue());
				
				actualParameters[j] = actualParameter;
			}
			mappingService.setActualParameters(actualParameters);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return mappingService;
	}
	
	public String setSwdRecord(List webServiceAfter, String workItemData){
		String data = null;
		try{
			if(webServiceAfter !=null){
				SwdRecord sRecord = (SwdRecord)SwdRecord.toObject(workItemData);
				if(sRecord!=null){
					SwdDataField[] fields = sRecord.getDataFields();
					for(int i = 0 ; i < webServiceAfter.size(); i++){
						Map map = (HashMap)webServiceAfter.get(i);
						if(map != null){
							String endPoint = (String)map.get("endPoint");
							String operation = (String)map.get("operation");
							String[] inputParams = (String[])map.get("inputParams");
							String returnType = (String)map.get("returnType");
							String objId = (String)map.get("objId");
							AcpActualParameter[] actualParameters = (AcpActualParameter[])map.get("actualParameters");
							Map<String, String> checkMap = (Map<String, String>)map.get("checkMap");
							SwdRecord oldRec = (SwdRecord)map.get("oldRec");
							//if(oldRec.getDataFields() == null)
								oldRec = (SwdRecord)SwdRecord.toObject(workItemData);
							if(inputParams == null){
								inputParams = this.getInputParams(actualParameters, checkMap, oldRec);
							}else if(inputParams.length == 1 && inputParams[0] == null){
								inputParams = this.getInputParams(actualParameters, checkMap, oldRec);
							}
							
							if(fields !=null){
								for(int j = 0 ; j < fields.length; j++){
									SwdDataField field = fields[j];
									if(field.getId().equals(objId)){
										String[] webServiceData = this.invokeWebService(endPoint, operation, inputParams, returnType);							
										field.setValue(webServiceData[0]);
									}
								}
							}
						}
					}
					if(fields != null){
						sRecord.setDataFields(fields);
						data = sRecord.toString();
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}
%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	
	String method = StringUtil.toNotNull(request.getParameter("method"));
	StringBuffer buffer = new StringBuffer();
	String userId = request.getParameter("userId");

	IResourceRuntimeManager rscMgr = SmartServerManager.getInstance().getResourceRuntimeManager();
	IResourceDesigntimeManager rdtMgr = SmartServerManager.getInstance().getResourceDesigntimeManager();

	try {
		// 에러 - 메소드 이름이 없음
		if(method.equals("")) {
			buffer.append("<Result status=\"Failed\"><message>Invalid method! Not found method parameter</message><trace/></Result>");
		
		// 워크아이템을 찾는다.
		} else if (method.equals("getWorkItem")) {	
			String workItemId = request.getParameter("workItemId");
			IWorkItemInfo workItem = WorklistManager.getInstance().getWorklistSearcher().retrieveWorkItemInfo(userId, workItemId);
			buffer.append("<Result status=\"OK\">");
			buffer.append(workItem);
			buffer.append("</Result>");
			
		// 워크아이템의 XML 데이터를 찾는다.
		} else if (method.equals("getWorkItemData")) {	
			String workItemId = request.getParameter("workItemId");
			TskTask task = SmartApi.getTask(userId, workItemId);
			String data = task.getDocument();
			
			//IWorkItem workItem = WorklistManager.getInstance().getWorklistSearcher().retrieve(userId, workItemId);
			//String data = workItem.getData();
			buffer.append("<Result status=\"OK\">");
			buffer.append(StringUtils.replace(data, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", ""));
			buffer.append("</Result>");
			
		// 업무를 할당합니다.
		} else if (method.equals("createWorkItem")) {
			String formId = request.getParameter("formId");
			int version = StringUtil.getIntValue(request.getParameter("version"), 0);				
			String title = request.getParameter("title");
			String assignee = request.getParameter("assignee");
			String relatedWorkItemId = request.getParameter("relatedWorkItemId");
			String workItemData = request.getParameter("workItemData");
			
			IWorkTypeModel workType = SmartServerManager.getInstance().getResourceRuntimeManager().retrieveWorkTypeByForm(userId, formId, version);	
			IWorkItem workItem = WorklistUtil.createBasicCommonWorkItem(userId, workType.getId(), title, assignee, relatedWorkItemId, workItemData);
			
			// 지시 업무 라면 groupId에 프로세스 인스턴스 아이디를 설정한다.
			if(IWorkTypeModel.WORKTYPE_INSTRUCT.equals(workType.getType())) {
				if(relatedWorkItemId != null) {
					IWorkItem relatedWork = WorklistManager.getInstance().getWorklistSearcher().retrieve(userId, relatedWorkItemId);
					if(relatedWork.getGroupId() != null) {
						workItem.setGroupId(relatedWork.getGroupId());
					}
				}
			}
			
			IWorklistHandler wh = WorklistManager.getInstance().getWorklistHandler();
			workItem = wh.create(userId, workItem);
			
			buffer.append("<Result status=\"OK\">");
			buffer.append("WorkItem [" + workItem.getId() + "], [" + title + "] created!");
			buffer.append("</Result>");
			
		// 업무를 처리합니다.
		} else if (method.equals("executeWorkItem") || method.equals("returnWorkItem") || method.equals("cancelWorkItem")) {
			
			String workItemId = request.getParameter("workItemId");
			String workItemData = CommonUtil.toNotNull(request.getParameter("workItemData"));
			/*
			webServiceMap.put("endPoint",endPoint);
			webServiceMap.put("operation",operation);
			webServiceMap.put("inputParams",inputParams);
			webServiceMap.put("returnType",returnType);
			webServiceMap.put("objId",objId);
			afterList.add(webServiceMap);
			if(webServiceAfter !=null){
				SwdRecord sRecord = (SwdRecord)SwdRecord.toObject(workItemData);
				if(sRecord!=null){
					for(int i = 0 ; i < webServiceAfter.size(); i++){
						Map map = (HashMap)webServiceAfter.get(i);
						if(map != null){
							String endPoint = (String)map.get("endPoint");
							String operation = (String)map.get("operation");
							String inputParams = (String)map.get("inputParams");
							String returnType = (String)map.get("returnType");
							String objId = (String)map.get("objId");
							
						}
					}
				}
			}
			*/
			List webServiceAfter = (ArrayList)request.getSession().getAttribute("afterWebService");
			String data = CommonUtil.toNotNull(this.setSwdRecord(webServiceAfter, workItemData));
			request.getSession().removeAttribute("afterWebService");
			if(!data.equals("")) workItemData = data;
			
			String receiptTitle = CommonUtil.toNull(request.getParameter("receiptTitle"));//연결업무, 참조업무, 결재품의 제목
			String subject = CommonUtil.toNull(request.getParameter("subject"));//기본 제목

			String workContents = CommonUtil.toNotNull(request.getParameter("workContents")); //참조, 기본 업무 설명
			
			String comment = CommonUtil.toNull(request.getParameter("comment"));//연결(전달의견), 결재 설명
			String projectName = CommonUtil.toNotNull(request.getParameter("projectName")); // 프로젝트팀명

			String isPublic = CommonUtil.toNull(request.getParameter("isPublic")); //공개여부

			String priority = CommonUtil.toNull(request.getParameter("priority")); //중요도
			
			String receiptFormId = CommonUtil.toNull(request.getParameter("receiptFormId")); //연결업무
			String receiptUser = CommonUtil.toNull(request.getParameter("receiptUser")); //연결업무 수신자
			String referenceUser = CommonUtil.toNull(request.getParameter("referenceUser"));//참조업무 수신자
			
			String hopeEndDate = CommonUtil.toNull(request.getParameter("hopeEndDate"));//희망 종료 날짜
			String hopeEndTime = CommonUtil.toNull(request.getParameter("hopeEndTime"));//희망 종료 시간
			
			String approvalsId = CommonUtil.toNotNull(request.getParameter("approvalsId"));
			String approvalType = CommonUtil.toNotNull(request.getParameter("approvalType"));
			String approvalName = CommonUtil.toNotNull(request.getParameter("approvalName"));

			String userLanguage = "KOR";
			SwoUser userInfo = SmartApi.getUser(userId, userId);
			userLanguage = CommonUtil.toDefault(userInfo.getLang(), userLanguage);

			String cancelComment = userLanguage.equals("KOR") ? "기안취소" : "Cancel Task";
			String referenceComment = method.equals("cancelWorkItem") ? cancelComment : CommonUtil.toNotNull(request.getParameter("referenceComment"));

			//추가  전자결재, 업무전달 
			String preservation 	= CommonUtil.toNotNull(request.getParameter("preservation"));//보존년한
			//String dueDate		    = CommonUtil.toNotNull(request.getParameter("dueDate"));      	   //처리기한

			// 간트 차트에서 사용하는 업무 시작일과 종료일
			String executionFrom = request.getParameter("executionFrom");
			String executionTo = request.getParameter("executionTo");
			
			String[] arrApproval = null;
			String[] approvalTypes = null;
			String[] approvalNames = null;
			
			AprApproval[] approvals = null;
			if(!approvalsId.equals("")) {
				arrApproval = StringUtils.tokenizeToStringArray(approvalsId, ";");
				approvalTypes = StringUtils.tokenizeToStringArray(approvalType, ";");
				approvalNames = StringUtils.tokenizeToStringArray(approvalName, ";");
				
				approvals = new AprApproval[arrApproval.length];
				for(int i=0; i<arrApproval.length; i++) {
					approvals[i] = new AprApproval();
					approvals[i].setApprover(arrApproval[i]);
					approvals[i].setType(approvalTypes[i]);
					approvals[i].setName(approvalNames[i]);
				}
			}
			
			TskTask task = MisServiceFactory.getInstance().getTskAdminService().getTask(userId, workItemId);
			String taskType = task.getType();

			if (!CommonUtil.isEmpty(workItemData)) {
				task.setDocument(workItemData);
			} else {
				task.setDocument(referenceComment);
			}
			/*
			if (taskType == null || (!taskType.equalsIgnoreCase("REFERENCE") && !taskType.equalsIgnoreCase("APPROVAL"))) {
				if (workItemData != null) {
					task.setDocument(workItemData);
				}
			} else {
				task.setDocument(referenceComment);
			}
			*/
			
		     //수신자		
			if(!CommonUtil.isEqual("", receiptUser))
				task.setExtendedPropertyValue("receiptUser", receiptUser);	
				
		     //제목		
			if(!CommonUtil.isEqual("", receiptTitle) || !CommonUtil.isEqual("", subject)) {
				task.setExtendedPropertyValue("subject", CommonUtil.isEqual("", receiptTitle) ? subject : receiptTitle);	
			}
		     //중요도		
			if(!CommonUtil.isEqual("", priority))
				task.setExtendedPropertyValue("receiptPriority", priority);	

		     //수신자 업무		
			if(!CommonUtil.isEqual("", receiptFormId)) {
				task.setExtendedPropertyValue("receiptForm", receiptFormId);	
				SwfForm form = SmartApi.getForm(userId, receiptFormId);
				if (form != null)
					task.setExtendedPropertyValue("receiptName", form.getName());
			}	
		    //참조자 
			if(!CommonUtil.isEqual("", referenceUser))
				task.setExtendedPropertyValue("referenceUser", referenceUser); 

		     //전달자의견, 전자결재 내용		
			if(!CommonUtil.isEqual("", comment)) {
				task.setExtendedPropertyValue("receiptDescription", comment);	
				task.setDescription(comment);
			}
			
			 //공개여부
			if(!CommonUtil.isEqual("", isPublic))
				task.setExtendedPropertyValue("isPublic", isPublic);     
			
			//보존년한
			if(!CommonUtil.isEqual("", preservation))
				task.setExtendedPropertyValue("preservation", preservation);    			

			//처리기한
			//if(!CommonUtil.isEqual("", dueDate))
			//	task.setExtendedPropertyValue("receiptDueDate", dueDate);    			
			
			if(!CommonUtil.isEqual("", hopeEndDate))
				task.setExtendedPropertyValue("hopeEndDate", hopeEndDate+" "+hopeEndTime);
			
			if(!CommonUtil.isEqual("", projectName))
				task.setExtendedPropertyValue("projectName", projectName);
			
			if(!CommonUtil.isEqual("", workContents))
				task.setExtendedPropertyValue("workContents", workContents);
			
			String action = "";
			
			if(method.equals("returnWorkItem")) {
				action = "return";
			} else if(method.equals("cancelWorkItem")) {
				action = "cancel";
			} else {
				action = null;	
			}

			String tag = request.getParameter("tag");
			task.setExtendedAttributeValue("tag", tag);
			
			if(taskType.equalsIgnoreCase("GANTT")) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				task = SmartApi.executeTask(userId, task, action, df.parse(executionFrom), df.parse(executionTo));
			} else {
				if(method.equals("executeWorkItem")) {
					task = SmartApi.executeTask(userId, task, action, null, approvals);
				} else {
					task = SmartApi.executeTask(userId, task, action, null);
				}
			}
			
			String title = task.getTitle();

			buffer.append("<Result status=\"OK\">");
			buffer.append("WorkItem [" + workItemId + "], [" + title + "] executed");
			buffer.append("</Result>");
		// 시작업무를 처리함으로써 프로세스 인스턴스를 시작합니다.
		} else if (method.equals("executeStartWorkItem")) {
			
			String receiptTitle = request.getParameter("receiptTitle");
			String workItemData = request.getParameter("workItemData");
			String version = request.getParameter("version");
			String formId = request.getParameter("formId");
			String priority = CommonUtil.toNotNull(request.getParameter("priority"));
			String processId = CommonUtil.toNotNull(request.getParameter("processId"));
			String packageId = CommonUtil.toNotNull(request.getParameter("packageId"));
			
			List webServiceAfter = (ArrayList)request.getSession().getAttribute("afterWebService");
			String data = CommonUtil.toNotNull(this.setSwdRecord(webServiceAfter, workItemData));
			request.getSession().removeAttribute("afterWebService");
			if(!data.equals("")) workItemData = data;
			
			//추가  전자결재
			String isPublic  = CommonUtil.toNull(request.getParameter("isPublic")); //공개여부
			String preservation = CommonUtil.toNull(request.getParameter("preservation"));//보존년한
			String referenceUser  = CommonUtil.toNull(request.getParameter("referenceUser"));//참조 사용자 ID
			String comment  		= CommonUtil.toNull(request.getParameter("comment")); 	      //내용
			
			String v_name = StringUtil.toNotNull(request.getParameter("name"));
			String v_type = StringUtil.toNotNull(request.getParameter("pertType"));
			String v_ref = StringUtil.toNotNull(request.getParameter("ref"));

			// jk yoon 향후 교체되어야 할 사항. hopeEndTime, hopeEndDate, requiredDay, requiredTime, requiredMinute
			String v_planDuration = StringUtil.toNotNull(request.getParameter("planDuration"));
			
			String v_assignee = StringUtil.toNotNull(request.getParameter("assignee"));
			String v_executionDuration = StringUtil.toNotNull(request.getParameter("executionDuration"));
			String v_executionFrom = StringUtil.toNotNull(request.getParameter("executionFrom"));
			String v_executionTo = StringUtil.toNotNull(request.getParameter("executionTo"));

			// jk yoon 추가된 새업무시작하기 부분 프로세스업무
			String projectName = CommonUtil.toNotNull(request.getParameter("projectName"));
			String workContents = CommonUtil.toNotNull(request.getParameter("workContents"));
			String subject = CommonUtil.toNotNull(request.getParameter("subject"));
			
			if(CommonUtil.isEmpty(receiptTitle)){
				receiptTitle = subject;
			}
			
			String def = null;
			TskTaskDef taskDef = null;
			//시작 업무가 서브태스크일수도 있음 서브태스크는 폼이 없음
//			if (formId.equalsIgnoreCase("SYSTEMFORM")) {
				Property[] extProps = new Property[] {new Property("processId", processId), new Property("startActivity", "true")};
				TskTaskDefCond taskCond = new TskTaskDefCond();
				taskCond.setExtendedProperties(extProps);
				TskTaskDef[] taskDefs = MisServiceFactory.getInstance().getTskAdminService().getTaskDefs(userId, taskCond);
				if (CommonUtil.isEmpty(taskDefs))
					throw new Exception(new StringBuffer("No start activity. -> processId:").append(processId).toString());
				taskDef = taskDefs[0];
				def = taskDef.getObjId();
//			} else {
//				IWorkTypeModel workType = SmartServerManager.getInstance().getResourceRuntimeManager().retrieveWorkTypeByForm(userId, formId, CommonUtil.isEmpty(version) ? 1 : Integer.parseInt(version));
//				def = workType.getId();
//				taskDef = MisServiceFactory.getInstance().getTskAdminService().getTaskDef(userId, def);
//			}
			
			TskTask task = new TskTask();
			task.setTitle(receiptTitle);
			task.setPriority(priority);
			if (taskDef.getType().equalsIgnoreCase("SUBFLOW")) {
				task.setExtendedAttributeValue("workItemData", workItemData);
			} else {
				task.setDocument(workItemData);
			}
			task.setAssigner(userId);
			if (!taskDef.getType().equalsIgnoreCase("SUBFLOW")) {
				task.setAssignee(userId);
			} else {
				task.setPerformer(userId);
			}
					
			task.setForm(formId);
			task.setDef(def);
			
			//def에서 예상 소요 시간을 구하여 예정 시작 시간 종료 시간 실제 시작, 종료 시간을 체크 한다
			if (taskDef != null) {
				Date now = new Date();
				task.setExpectStartDate(now);
				task.setRealStartDate(now);
				Date expectEndDate = new Date();
				if (taskDef != null &&  !CommonUtil.isEmpty(taskDef.getDueDate())) {
					//dueDate 는 분단위로 설정이 되어 있다
					expectEndDate.setTime(now.getTime() + ((Long.parseLong(taskDef.getDueDate())) * 60 * 1000));
				} else {
					expectEndDate.setTime(now.getTime() + 1800000);
				}
				task.setExpectEndDate(expectEndDate);
			}

			 //참조자
			if(!CommonUtil.isEqual("", referenceUser))
				task.setExtendedPropertyValue("referenceUser", referenceUser);		

		     //전달자의견, 전자결재 내용		
			if(!CommonUtil.isEqual("", comment))
				task.setExtendedAttributeValue("receiptDescription", comment);	
			
			 //공개여부
			if(!CommonUtil.isEqual("", isPublic))
				task.setExtendedPropertyValue("isPublic", isPublic);     
			
			//보존년한
			if(!CommonUtil.isEqual("", preservation))
				task.setExtendedPropertyValue("preservation", preservation);    			
 
			if(!CommonUtil.isEqual("", subject))
				task.setExtendedPropertyValue("subject", subject);
			
			if(!CommonUtil.isEqual("", workContents))
				task.setExtendedPropertyValue("workContents", workContents);
			
			if(!CommonUtil.isEqual("", projectName))
				task.setExtendedPropertyValue("projectName", projectName);
			
			ChtPertChart pert = new ChtPertChart();	
			ChtPertItem item = null;
			AprApproval[] approvals = null;

			String[] name = v_name.split(";");
			String[] type = v_type.split(";");
			String[] ref = v_ref.split(";");
			String[] planDuration = v_planDuration.split(";");
			String[] assignee = v_assignee.split(";");
			String[] executionDuration = v_executionDuration.split(";");
			String[] executionFrom = v_executionFrom.split(";");
			String[] executionTo = v_executionTo.split(";");

			int k = 0;
			
			SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");

			if (planDuration.length > 0) {
				for (int i=0;  i < planDuration.length; i++) {
					item = new ChtPertItem();
					item.setName(name[i].trim());
					item.setType(type[i].trim());
					item.setRef(ref[i].trim());
					item.setPlanDuration(SmartUtil.toInt(planDuration[i].trim()));
					item.setAssignee(CommonUtil.toNull(assignee[i].trim()));
					item.setExecutionDuration(SmartUtil.toInt(executionDuration[i].trim()));
					if(!executionFrom[i].trim().equals("")) {
						item.setExecutionFrom(df.parse(executionFrom[i].trim()));
					}
					if(!executionTo[i].trim().equals("")) {
						item.setExecutionTo(df.parse(executionTo[i].trim()));
					}
					pert.addItem(item);
					k = SmartUtil.toInt(planDuration[i].trim()) + k;
				}
			}
			
			String approvalsId  = CommonUtil.toNotNull(request.getParameter("approvalsId"));
			String approvalType = CommonUtil.toNotNull(request.getParameter("approvalType"));
			String approvalName = CommonUtil.toNotNull(request.getParameter("approvalName"));
			
			String[] arrApproval = null;
			String[] approvalTypes = null;
			String[] approvalNames = null;
			
			if(!approvalsId.equals("")) {
				arrApproval = StringUtils.tokenizeToStringArray(approvalsId, ";");
				approvalTypes = StringUtils.tokenizeToStringArray(approvalType, ";");
				approvalNames = StringUtils.tokenizeToStringArray(approvalName, ";");
				
				approvals = new AprApproval[arrApproval.length];
				for(int i=0; i<arrApproval.length; i++) {
					approvals[i] = new AprApproval();
					approvals[i].setApprover(arrApproval[i]);
					approvals[i].setType(approvalTypes[i]);
					approvals[i].setName(approvalNames[i]);
				}
			}
			if (taskDef.getType().equalsIgnoreCase("SUBFLOW")) {
				task.setType("SUBFLOW");
				task = MisManagerFactory.getInstance().getTskManager().setTask(userId, task, IManager.LEVEL_ALL);
			
			} else {
				task = SmartApi.executeTask(userId, task, null, pert, approvals);
			}
			String taskId = task.getObjId();
			String procInstId = task.getProcessInstId();
			
			buffer.append("<Result status=\"OK\"><workitem id=\"").append(taskId).append("\" processInstId=\"").append(procInstId).append("\"/></Result>");
			
		// 시작 업무를 처리함으로써 프로세스 인스턴스를 시작한다. - admin에서 테스트 하기 위함
		} else if (method.equals("initiateProcess")) {
			Map<String, String[]> parameterMap = request.getParameterMap();
			SmartBpmsEngine engine = SmartBpmsEngine.getInstance();
			ISmartMessage message = engine.getDataHandler().createSmartMessage(parameterMap);
			message.setInitMessage(true);
			String prcInstId = engine.getProcessManager().execute(message);	
			buffer.append("<Result status=\"OK\">Process Instance  [").append(prcInstId).append("] executed</Result>");
			
		// 업무 임시 저장
		} else if (method.equals("saveWorkItemData")) {
			String taskId = request.getParameter("taskId");
			String workItemData = request.getParameter("workItemData");			
			TskTask task = SmartApi.getTask(userId, taskId);
			task.setDocument(workItemData);
			// 간트 차트에서 사용하는 업무 시작일과 종료일
			String executionFrom = CommonUtil.toNull(request.getParameter("executionFrom"));
			String executionTo 	 = CommonUtil.toNull(request.getParameter("executionTo"));

			//String user, TskTask obj, Date from, Date to
			SmartApi.setTask(userId, task , DateUtil.toDate(executionFrom) , DateUtil.toDate(executionTo));
			buffer.append("<Result status=\"OK\"/>");
		// 폼을 가져온다.
		} else if (method.equals("getFormByWorkItemId")) {
			String workItemId = request.getParameter("workItemId");	
			IWorklistSearcher ws = WorklistManager.getInstance().getWorklistSearcher();
			IWorkItem workItem = ws.retrieve(userId, workItemId);			
			IWorkTypeModel workType = rscMgr.retrieveWorkType(userId, workItem.getWorkTypeId());	
			String formUid = workType.getFormUid();
			//String formContent = rscMgr.retrieveFormContent(userId, formUid);
			String formContent = rdtMgr.retrieveLatestFormContent(userId, formUid);
			buffer.append(formContent);
		
		// 폼을 가져온다.
		} else if (method.equals("getForm")) {
			String formId = request.getParameter("formId");
			String type = request.getParameter("type");
			String mode = request.getParameter("mode");

			if(formId != null || formId != "") {
				if(formId.indexOf(";")>-1){
					formId = formId.split(";")[1];
				}
			}
			String versionStr = CommonUtil.toNotNull(request.getParameter("version"));
			if(CommonUtil.isEmpty(versionStr) || versionStr.equals("0")) {
				versionStr = "1";
			}

			// User's Action Log Save

			SwfForm sform = SmartApi.getForm(userId, formId);
			String formName = "";
			String categoryName = "";
			if(sform != null){	
				formName = CommonUtil.toNotNull(sform.getName());
			} else {
				formName = "외부화면";
			}

			SwoUser swoUser = SmartApi.getUser(userId, userId);
			String userName = "";
			String compId = "";
			String deptId = "";
			String deptName = "";
			String position = "";
			String menuType = (type.equals("2") ||  type.equals("3")) ? "SmartForm" : (type.equals("1") || type.equals("4") || type.equals("5")) ? "SmartProcess" : "SmartScheduler";
			String actionType = "";
			actionType = (type.equals("3") || type.equals("4")) ? "insert" : ((type.equals("2") || type.equals("5")) && mode.equals("edit")) ? "update" : "view";

			if(swoUser != null) {
				compId = swoUser.getCompanyId();
				userName = swoUser.getName();
				deptId = swoUser.getDeptId();
				position = swoUser.getPosition();
			}

			SwoDepartment dept = null;
			if (!CommonUtil.isEmpty(deptId)) {
				dept = SmartApi.getDepartment(userId, deptId);
			}
			if (dept != null){ 
				deptName = dept.getName();
			}

			if(sform != null) {
				IPackageModel pkg = SmartServerManager.getInstance().getResourceRuntimeManager().retrieveLatestPackage(userId, CommonUtil.toNotNull(sform.getPackageId()));
				if(pkg != null) {
					categoryName = SmartApi.getCategoryName(compId, userId, pkg.getCategoryId());
				}
			} else {
				categoryName = "외부화면사용";
			}

			LogModel logModel = new LogModel();
			logModel.setUserId(userId);
			logModel.setUserName(userName);
			logModel.setDeptName(deptName);
			logModel.setPosition(position);
			logModel.setCategoryName(categoryName);
			logModel.setMenuName(formName);
			logModel.setMenuType(menuType);
			logModel.setActionType(actionType);

			LogManager logManager = (LogManager)ManagerUtil.getManager("logManager", request);
			logManager.insertActionLog(logModel);

			String formContent = null;
			
			if(versionStr != null && !versionStr.trim().equals("")) {
				int version = Integer.parseInt(versionStr);
				formContent = rscMgr.retrieveFormContent(userId, formId, version);
			} else {
				formContent = rscMgr.retrieveLatestFormContent(userId, formId);
			}
			buffer.append(formContent);

		// 단위 업무에 데이터를 저장한다.
		} else if (method.equals("createSingleFormRecord")) {
			String xmlData = request.getParameter("data");
			String domainId = request.getParameter("domainId");
			String recordId = request.getParameter("recordId");
			String tag = request.getParameter("tag");
			
			List webServiceAfter = (ArrayList)request.getSession().getAttribute("afterWebService");
			String data = CommonUtil.toNotNull(this.setSwdRecord(webServiceAfter, xmlData));
			request.getSession().removeAttribute("afterWebService");
			if(!data.equals("")) xmlData = data;

			SwdRecord sRecord = (SwdRecord)SwdRecord.toObject(xmlData);
			if(sRecord != null){
				//System.out.println(sRecord.toString());
			}
			String receiptTitle = CommonUtil.toNull(request.getParameter("receiptTitle"));//연결업무, 참조업무, 결재품의 제목
			String subject = CommonUtil.toNotNull(request.getParameter("subject"));//기본 제목
			
			String workContents = CommonUtil.toNotNull(request.getParameter("workContents")); //참조, 기본 업무 설명
			
			String comment = CommonUtil.toNull(request.getParameter("comment"));//연결(전달의견), 결재 설명
			
			String projectName = CommonUtil.toNotNull(request.getParameter("projectName")); // 프로젝트팀명

			String isPublic = CommonUtil.toNull(request.getParameter("isPublic")); //공개여부

			String priority = CommonUtil.toNull(request.getParameter("priority")); //중요도
			
			String receiptFormId = CommonUtil.toNull(request.getParameter("receiptFormId")); //연결업무
			String receiptUser = CommonUtil.toNull(request.getParameter("receiptUser")); //연결업무 수신자
			String referenceUser = CommonUtil.toNull(request.getParameter("referenceUser"));//참조업무 수신자
			
			String hopeEndDate = CommonUtil.toNull(request.getParameter("hopeEndDate"));//희망 종료 날짜
			String hopeEndTime = CommonUtil.toNull(request.getParameter("hopeEndTime"));//희망 종료 시간
			
			String approvalsId = CommonUtil.toNotNull(request.getParameter("approvalsId"));
			String approvalType = CommonUtil.toNotNull(request.getParameter("approvalType"));
			String approvalName = CommonUtil.toNotNull(request.getParameter("approvalName"));

			System.out.println("approvalsId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + approvalsId);
			System.out.println("approvalType>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + approvalType);
			System.out.println("approvalName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + approvalName);
			//String dueDate		    = CommonUtil.toNull(request.getParameter("dueDate"));      	   //처리기한
			
			String[] approvalsIds = null;
			String[] approvalTypes = null;
			String[] approvalNames = null;
			
			AprApproval[] approvals = null;
			if(!approvalsId.equals("")) {
				approvalsIds = StringUtils.tokenizeToStringArray(approvalsId, ";");
				approvalTypes = StringUtils.tokenizeToStringArray(approvalType, ";");
				approvalNames = StringUtils.tokenizeToStringArray(approvalName, ";");
				
				approvals = new AprApproval[approvalsIds.length];
				for(int i=0; i<approvalsIds.length; i++) {
					approvals[i] = new AprApproval();
					approvals[i].setApprover(approvalsIds[i]);
					approvals[i].setType(approvalTypes[i]);
					approvals[i].setName(approvalNames[i]);
				}
			}
			
			SwdRecord record = (SwdRecord)SwdRecord.toObject(xmlData);
			record.setDomainId(domainId);
			record.setModificationUser(userId);
			if(recordId != null && !recordId.equals("")) {
				record.setRecordId(recordId);
			}
			record.setExtendedAttributeValue("tag", tag);

			
			Date startTime = null;
			Date endTime = null;
			
			// 버튼 클릭시간 - 시작시간. Long 타입으로 변환해서 Date로 넣어줌.
			String startTime_t = CommonUtil.toNotNull(request.getParameter("startTime"));
			String endTime_t   = CommonUtil.toNotNull(request.getParameter("endTime"));
			if(startTime_t.equals("")){
				startTime = new Date(Long.parseLong(endTime_t));			
			}else{
				startTime = new Date(Long.parseLong(startTime_t));
			}
			endTime   = new Date(Long.parseLong(endTime_t));
			
			//예상 시작, 종료 , 실제 시작, 종료 시간을 넘긴다
			if (startTime != null && endTime != null ) {
				record.setExtendedAttributeValue("startDate", DateUtil.toString(startTime, "yyyy-MM-dd HH:mm:ss"));
				record.setExtendedAttributeValue("endDate", DateUtil.toString(endTime, "yyyy-MM-dd HH:mm:ss"));
			}
			
			//제목
			if(!CommonUtil.isEqual("", receiptTitle) || !CommonUtil.isEqual("", subject)) {
				record.setExtendedAttributeValue("subject", CommonUtil.isEqual("", receiptTitle) ? subject : receiptTitle);	
			}
			//참조, 기본 업무 설명
			if(!CommonUtil.isEqual("", workContents))
				record.setExtendedAttributeValue("workContents", workContents);
			
			
		     //전달자의견, 전자결재 내용		
			if(!CommonUtil.isEqual("", comment))
				record.setExtendedAttributeValue("receiptDescription", comment);
		     
			//프로젝트 팀명(ID?)
			if(!CommonUtil.isEqual("", projectName))
				record.setExtendedAttributeValue("projectName", projectName);

			 //공개여부
			if(!CommonUtil.isEqual("", isPublic))
				record.setExtendedAttributeValue("isPublic", isPublic);   

			//중요도
			if(!CommonUtil.isEqual("", priority))
				record.setExtendedAttributeValue("priority", priority);

			//수신자 업무
			if(!CommonUtil.isEqual("", receiptFormId))
				record.setExtendedAttributeValue("receiptForm", receiptFormId);
			
			//수신자
			if(!CommonUtil.isEqual("", receiptUser))
				record.setExtendedAttributeValue("receiptUser", receiptUser);
			
			//참조자
			if(!CommonUtil.isEqual("", referenceUser))
				record.setExtendedAttributeValue("referenceUser", referenceUser);
			
			//희망완료날짜
			String hopeEndDateStr = hopeEndDate + " " + hopeEndTime;
			if(!CommonUtil.isEqual("", hopeEndDate))
				record.setExtendedAttributeValue("hopeEndDate", hopeEndDateStr);
  
			
			//처리기한
			//if(!CommonUtil.isEqual("", dueDate))
			//	record.setExtendedAttributeValue("receiptDueDate", dueDate);    			

			SmartApi.setRecord(userId , record, approvals);
			buffer.append("<Result status=\"OK\"><record id=\"").append(record.getRecordId()).append("\"/></Result>");

		// 위임
		} else if (method.equals("delegateTask")) {
			String taskId = CommonUtil.toNotNull(request.getParameter("taskId"));
			String delegateUserId = CommonUtil.toNotNull(request.getParameter("delegateUserId"));
			if(!CommonUtil.isEmpty(delegateUserId) && !CommonUtil.isEmpty(taskId)) {
				TskTask tskObj = SmartApi.getTask(userId, taskId);
				if (tskObj != null ) {
					tskObj.setAssignee(delegateUserId);
				}
				SmartApi.setTask(userId, tskObj, null, null);
			}
			buffer.append("<Result status=\"OK\"/>");
		// 업무 임시 저장
		} else if (method.equals("saveSingleFormRecord")) {
			String xmlData = request.getParameter("data");
			//IDomainRecordData record = SmartServerModelUtil.xmlToDataRecord(xmlData);
			//SmartServerManager.getInstance().getDomainManager().updateDomainRecord(userId, record);
			SwdRecord record = (SwdRecord)SwdRecord.toObject(xmlData);
			
			String title = CommonUtil.toNull(request.getParameter("title"));
			String receiver = CommonUtil.toNull(request.getParameter("receiver"));
			String referencer = CommonUtil.toNull(request.getParameter("referencer"));
			String desc = CommonUtil.toNull(request.getParameter("desc"));
			
			record.setExtendedAttributeValue("receiptTitle", title);
			record.setExtendedAttributeValue("receiptUser", receiver);
			record.setExtendedAttributeValue("referenceUser", referencer);
			// 수신 업무 설명 : 현재 사용하지 않음.
			//record.setExtendedAttributeValue("receiptDescription", desc);
				
			SmartApi.setRecord(userId, record);
			buffer.append("<Result status=\"OK\"/>");
			
		// 참조 매핑 데이터 레코드를 검색
		} else if (method.equals("findMappingRecord")) {
			String formId = request.getParameter("formId");
			String version = request.getParameter("version");
			String mappingId = request.getParameter("mappingId");
			String parameter = request.getParameter("parameter");
			IDomainRecordData filter = SmartServerModelUtil.xmlToDataRecord(parameter);
			List<IDomainRecordData> recordList = SmartServerManager.getInstance().getDomainManager().findMappingRecord(userId, formId, Integer.parseInt(version), mappingId, filter);
			buffer.append(this.convert(recordList));
			
		// 단위 업무 레코드 로드
		} else if (method.equals("getSingleFormRecord")) {
			String recordId = request.getParameter("recordId");
			String formId = request.getParameter("formId");
			SwdRecord record = SmartApi.getRecordByFormId(userId, formId, recordId);
			buffer.append(record.toString(null, null));

		// 단위 업무 레코드 삭제
		} else if (method.equals("removeSingleFormRecord")) {
			String recordId = request.getParameter("recordId");
			String formId = request.getParameter("formId");
			String domainId = request.getParameter("domainId");
			SmartApi.removeRecord(userId, domainId, recordId);
			buffer.append("<Result status=\"OK\"><record id=\"").append(recordId).append("\"/></Result>");
			
		// 폼 아이디, 레코드 아이디, 폼 필드 아이디로 해당 데이터를 조회
		} else if (method.equals("getDomainFieldData")) {
			String formId = request.getParameter("formId");
			String recordId = request.getParameter("recordId");
			String formFieldId = request.getParameter("formFieldId");
			Object value = SmartServerManager.getInstance().getDomainManager().retrieveSelectedDomainData(userId, formId, recordId, formFieldId);
			buffer.append("<Result status=\"OK\">").append(value).append("</Result>");
		
		// 가져오기
		} else if (method.equals("refreshDataFields")) {
			request.getSession().removeAttribute("afterWebService");

			List afterList = new ArrayList();
			String id = CommonUtil.toNull(request.getParameter("formId"));
			String xmlData = CommonUtil.toNull(request.getParameter("data"));
			String mappingServicesXml = CommonUtil.toNull(request.getParameter("mappingServicesXml"));
			String realStrData = CommonUtil.toNotNull(request.getParameter("realStrData"));
			String editMode = CommonUtil.toNotNull(request.getParameter("editMode"));
			Map<String, String> checkMap = new HashMap<String, String>();
			if(!realStrData.equals("")){
				String[] realStrDataArr = realStrData.split("@");
				for(int i = 0 ; i < realStrDataArr.length; i++){
					if(realStrDataArr[i].split("%").length == 2){
						String keys = realStrDataArr[i].split("%")[0];
						String values = realStrDataArr[i].split("%")[1];
						checkMap.put(keys, values);
					}
				}
			}
			// 유효성 체크 시작
			if (id == null)
				return;
			SwfForm form = SwManagerFactory.getInstance().getSwfManager().getForm(null, id);
			if (form == null)
				return;
			SwfField[] fields = form.getFields();
			if (CommonUtil.isEmpty(fields))
				return;
			// 유효성 체크 끝
			
			// 현재 레코드
			SwdRecord record = null;
			if (xmlData != null)
				record = (SwdRecord)SwdRecord.toObject(xmlData);

			SwfFormLink[] formLinks = form.getMappingForms();
			Map<String, SwfFormLink> formLinkMap = new HashMap<String, SwfFormLink>();
			if (!CommonUtil.isEmpty(formLinks)) {
				for (SwfFormLink formLink:formLinks)
					formLinkMap.put(formLink.getId(), formLink);
			}
			
			// 업무연결아이디와 해당 업무 맵
			Map<String, SwdRecord[]> formLinkIdRecordMap = new HashMap<String, SwdRecord[]>();

			// 새로 계산된 레코드
			SwdRecord newRec = record;
			String newRecStr = null;
			SwdRecord oldRec = null;
			boolean hasSelfMapping = true;
			int loopCounter = 0;
			while (loopCounter++ < 10 && hasSelfMapping && (newRecStr == null || oldRec == null || !newRecStr.equals(oldRec.toString(null, null)))) {
				hasSelfMapping = false;
				oldRec = newRec;
				newRec = (SwdRecord)newRec.clone();

				for (SwfField field : fields) {
					// 가져오기 매핑정의가 있는지 확인 시작
					SwfMappings mappings = field.getMappings();
					if (mappings == null)
						continue;
					SwfMapping[] preMappings = mappings.getPreMappings();
					if (CommonUtil.isEmpty(preMappings))
						continue;
					// 가져오기 매핑정의가 있는지 확인 끝
					
					String fieldId = field.getId();
					String fieldType = field.getSystemType();
					
					for (SwfMapping preMapping : preMappings) {
						if (!preMapping.isEachTime() && newRec != null && !CommonUtil.isEmpty(newRec.getRecordId()))
							continue;
						
						String mappingType = preMapping.getType();
						// 단순항목
						if (SwfMapping.TYPE_SIMPLE.equalsIgnoreCase(mappingType)) {
							String mappingFormType = preMapping.getMappingFormType();
							if (CommonUtil.isEmpty(mappingFormType))
								continue;
							
							// 현재업무항목
							if (SwfMapping.MAPPINGTYPE_SELFFORM.equalsIgnoreCase(mappingFormType)) {
								String mappingFieldId = CommonUtil.toNull(preMapping.getFieldId());
								if (CommonUtil.isEmpty(mappingFieldId))
									continue;
// jk								
								hasSelfMapping = true;
								
								SwdDataField[] dataFields = oldRec.getDataFields();
								SwdDataField tempDataField = null;
								int cnt = 0;
								String value = checkMap.get(mappingFieldId);
								if(value != null && dataFields !=null){
									for(SwdDataField dataField : dataFields){
										if(dataField.getId().equals(mappingFieldId)){
											cnt++;
										}
									}
								}
								
								String fieldValue = newRec.getDataFieldValue(mappingFieldId); 
								if(cnt > 1){
									fieldValue = value;
								}
								
								newRec.setDataFieldValue(fieldId, fieldType, fieldValue);
								
							// 다른업무항목
							} else if (loopCounter > 1) {
								
							} else if (SwfMapping.MAPPINGTYPE_OTHERFORM.equalsIgnoreCase(mappingFormType)) {
								String formLinkId = preMapping.getMappingFormId();
								String mappingFieldId = preMapping.getFieldId();
								SwfFieldMapping[] fieldMappings = preMapping.getFieldMappings();
								
								if (CommonUtil.isEmpty(formLinkId) || !formLinkMap.containsKey(formLinkId) || 
									(CommonUtil.isEmpty(mappingFieldId) && CommonUtil.isEmpty(fieldMappings))) {
									newRec.setDataFieldValue(fieldId, fieldType, null);
									continue;
								}

								String valueFunc = preMapping.getValueFunc();
								if (valueFunc == null || valueFunc.equalsIgnoreCase("value")) {
									SwdRecord[] mappingRecords = null;
									if (formLinkIdRecordMap.containsKey(formLinkId)) {
										mappingRecords = formLinkIdRecordMap.get(formLinkId);
									} else {
										if (!CommonUtil.isEmpty(mappingFieldId)) {
											SwdRecord mappingRecord = SmartApi.getMappingRecord(userId, newRec, formLinkMap.get(formLinkId));
											if (mappingRecord != null)
												mappingRecords = new SwdRecord[] {mappingRecord};
										} else {
											mappingRecords = SmartApi.getMappingRecords(userId, newRec, formLinkMap.get(formLinkId));
										}
										formLinkIdRecordMap.put(formLinkId, mappingRecords);
									}
									
									if (CommonUtil.isEmpty(mappingRecords)) {
										newRec.setDataFieldValue(fieldId, fieldType, null);
										continue;
									}
									
									if (!CommonUtil.isEmpty(mappingFieldId)) {
										SwdDataField dataField = newRec.getDataField(fieldId);
										if (dataField == null) {
											dataField = new SwdDataField();
											dataField.setId(fieldId);
											dataField.setType(fieldType);
											newRec.addDataField(dataField);
										}
										
										SwdRecord mappingRecord = mappingRecords[0];
										SwdDataField mappingDataField = mappingRecord.getDataField(mappingFieldId);
										if (mappingDataField == null) {
											dataField.setValue(null);
											dataField.setRefRecordId(null);
										} else {
											dataField.setValue(mappingDataField.getValue());
											dataField.setRefRecordId(mappingDataField.getRefRecordId());
										}
										
										// 뭔지 모르겠다. ^^
										SwfFormat format = field.getFormat();
										if (format == null)
											continue;
										String formatType = format.getType();
										if (!"refFormField".equalsIgnoreCase(formatType))
											continue;
										SwfFormRef formRef = format.getRefForm();
										if (formRef == null)
											continue;
										dataField.setRefForm(formRef.getId());
										SwfFieldRef fieldRef = formRef.getField();
										if (fieldRef == null)
											continue;
										dataField.setRefFormField(fieldRef.getId());
										if (CommonUtil.toNull(dataField.getRefRecordId()) == null &&
												CommonUtil.toNull(dataField.getRefForm()) != null && 
												CommonUtil.toNull(dataField.getRefFormField()) != null && 
												CommonUtil.toNull(dataField.getValue()) != null) {
											dataField.setRefRecordId(mappingRecord.getRecordId());
											/*
											SwdRecordCond recCond = new SwdRecordCond();
											recCond.setFormId(dataField.getRefForm());
											recCond.addFilter(new Filter("=", dataField.getRefFormField(), dataField.getValue()));
											recCond.setOrders(new Order[] {new Order("createdTime", false)});
											recCond.setPageSize(1);
											SwdRecord[] rec = SmartApi.getRecords(userId, recCond);
											if (!CommonUtil.isEmpty(rec)) {
												dataField.setRefRecordId(rec[0].getRecordId());
											}
											*/
										}
										
									} else {
										SwfField[] subFields = field.getFields();
										Map<String, SwfField> subFieldMap = new HashMap<String, SwfField>();
										for (SwfField subField:subFields)
											subFieldMap.put(subField.getId(), subField);
										
										SwdDataField dataField = newRec.getDataField(fieldId);
										if (dataField == null) {
											dataField = new SwdDataField();
											dataField.setId(fieldId);
											dataField.setType(fieldType);
											newRec.addDataField(dataField);
										}
										
										List<SwdDataField> subDataFields = new ArrayList<SwdDataField>();
										int i = 0;
										for (SwdRecord mappingRecord:mappingRecords) {
											SwdDataField row = new SwdDataField();
											row.setRow(i++);
											
											boolean added = false;
											for (SwfFieldMapping fieldMapping:fieldMappings) {
												String leftOperand = fieldMapping.getLeftOperand();
												String rightOperand = fieldMapping.getRightOperand();
												if (CommonUtil.isEmpty(leftOperand) || !subFieldMap.containsKey(leftOperand))
													continue;
												
												SwfField colField = subFieldMap.get(leftOperand);
												SwdDataField col = new SwdDataField();
												col.setId(colField.getId());
												col.setType(colField.getSystemType());
												row.addDataField(col);
												added = true;
												
												SwdDataField mappingDataField = mappingRecord.getDataField(rightOperand);
												if (mappingDataField == null) {
													col.setValue(null);
													col.setRefRecordId(null);
												} else {
													col.setValue(mappingDataField.getValue());
													col.setRefRecordId(mappingDataField.getRefRecordId());
												}
												
												// TODO
											}
											
											if (!added)
												break;
											dataField.addDataField(row);
										}
										
									}
									
								} else {
									double value = SmartApi.getMappingRecordValue(userId, newRec, formLinkMap.get(formLinkId), mappingFieldId, valueFunc);
									newRec.setDataFieldValue(fieldId, fieldType, value + "");
									
								}
								
							// 프로세스업무항목
							} else if (SwfMapping.MAPPINGTYPE_PROCESSFORM.equalsIgnoreCase(mappingFormType)) {
								String mappingFormId = preMapping.getMappingFormId();
								if (!mappingFormId.equalsIgnoreCase("processParam"))
									continue;
								
							// 시스템함수
							} else if (SwfMapping.MAPPINGTYPE_SYSTEM.equalsIgnoreCase(mappingFormType)) {
								ISwoManager mgr = SwManagerFactory.getInstance().getSwoManager();
								SwoUser func = mgr.getUser(userId, userId, "all");
								String functionId = CommonUtil.toNull(preMapping.getFieldId());
								String funcDeptId = "";
								String funcDeptName = "";
								String funcTeamLeader = "";
								if (CommonUtil.isEmpty(functionId))
									continue;
								if(editMode.equals("")) {
									if (functionId.equals("mis:generateId")) {
										newRec.setDataFieldValue(fieldId, fieldType, CommonUtil.newId());
									} else if (functionId.equals("mis:getCurrentDate")) {
										newRec.setDataFieldValue(fieldId, fieldType, DateUtil.toXsdDateString(new Date()));
									} else if (functionId.equals("mis:getCurrentUser")) {
										newRec.setDataField(fieldId, toDataField(userId, field, userId));
									} else if (functionId.equals("mis:getDeptId")){		
										if(func != null){
										funcDeptId = func.getDeptId();
										SwoDepartment funcdept = mgr.getDepartment(userId, funcDeptId, "all");
											if(funcdept != null){
												funcDeptName = funcdept.getName();
											}
										}
										newRec.setDataField(fieldId, toDataField(userId, field, funcDeptName));
									} else if (functionId.equals("mis:getTeamLeaderId")){
										if(func != null){
											funcDeptId = func.getDeptId();
											SwoUserCond cond = new SwoUserCond();
											cond.setDeptId(funcDeptId);
											cond.setRoleId("DEPT LEADER");
											
											SwoUser[] funcs = mgr.getUsers(userId, cond, "all");
											if(funcs != null){
												funcTeamLeader = funcs[0].getId();
											}
										}
										newRec.setDataField(fieldId, toDataField(userId, field, funcTeamLeader));
									} else if (functionId.equals("mis:getEmpNo")){
										String funcEmpNo = func.getEmpNo();
										newRec.setDataField(fieldId, toDataField(userId, field, funcEmpNo));
									} else if (functionId.equals("mis:getMobileNo")){
										String funcMobileNo = func.getMobileNo();
										newRec.setDataField(fieldId, toDataField(userId, field, funcMobileNo));
									} else if (functionId.equals("mis:getInternalNo")){
										String funcInternalNo = func.getInternalNo();
										newRec.setDataField(fieldId, toDataField(userId, field, funcInternalNo));
									}
								}
						//web Service
							} else if("service_form".equalsIgnoreCase(mappingFormType)){

								String mappingServiceXml = mappingServicesXml.trim();
								String[] mappingStr = mappingServiceXml.split("@@");
								List<String[]> mappingList = new ArrayList<String[]>();
								String mappingServiceId = preMapping.getMappingServiceId();
								for(String str : mappingStr){
									//MappingService objs =(MappingService)MappingService.toObject(str);
									MappingService objs = this.setMappingService(str);
									String objId = objs.getId();
									String targetServiceId = objs.getTargetServiceId();
									String execution = objs.getExecution();
									
									if(mappingServiceId.equals(objId)){
										WebWebService webService = SwManagerFactory.getInstance().getWebManager().getWebService(userId,targetServiceId,"all");
										String endPoint = CommonUtil.toNotNull(webService.getWebServiceAddress());
										String wsdlUrl = CommonUtil.toNotNull(webService.getWsdlAddress());
										if(wsdlUrl.indexOf(".jws")>-1){
											if(!(endPoint.indexOf(".jws")>-1)){
												if(!endPoint.equals(""))
													endPoint = endPoint+".jws";
											}
										}
										String operation = webService.getOperationName();
										AcpActualParameter[] actualParameters = objs.getActualParameters();
										WebWebServiceParameter[] params = webService.getWebServiceParameters();
										List<String> list = new ArrayList<String>();
										String returnType = null;
											for(int ii = 0 ; ii < params.length; ii++){
												if(params[ii].getType().equalsIgnoreCase("I")){
													
													if(actualParameters != null){
														for(AcpActualParameter param : actualParameters){
															if(param.getId().equals(params[ii].getParameterName())){
																list.add(param.getExpression());
															}
														}
													}
												}else if(params[ii].getType().equalsIgnoreCase("O")){
													returnType = params[ii].getParameterType();
												}
											}
											
											String[] inputParams = new String[list.size()];
											int idx = 0;
											for(String str1 : list){
												inputParams[idx++] = str1;
											}
											if(actualParameters != null){
												List<String> paramFieldIds = null;
												for(AcpActualParameter param : actualParameters){
													if(param.getMode().equalsIgnoreCase("IN")){
														if(paramFieldIds == null) paramFieldIds = new ArrayList<String>();
														paramFieldIds.add(param.getFieldId());
													}
												}
												if(paramFieldIds != null && oldRec.getDataFields() != null){
													String[] getInputParams = new String[paramFieldIds.size()];
													int idxx = 0;
													for(String paramId : paramFieldIds){
														SwdDataField[] dataFields = oldRec.getDataFields();
														SwdDataField tempDataField = null;
														int cnt = 0;
														String value = checkMap.get(paramId);
														if(value != null && dataFields !=null){
															for(SwdDataField dataField : dataFields){
																if(dataField.getId().equals(paramId) && dataField.getValue().equals(value)){
																	tempDataField = dataField;
																}
																if(dataField.getId().equals(paramId)){
																	cnt++;
																}
															}
														}
														
														SwdDataField oldDataField = oldRec.getDataField(paramId);
														if(cnt > 1){
															oldDataField = tempDataField;
														}else{
															SwdDataField[] dataF =  oldRec.getDataFields();
															if(dataF !=null){
																for(int di = 0; di<dataF.length;di++){
																	if(dataF[di].getId().equals(paramId) && dataF[di].getRefForm() !=null){
																		oldDataField = dataF[di];
																	}
																}
															}
														}
														
														if(oldDataField !=null)
															getInputParams[idxx++] = oldDataField.getValue();
													}
													String arrayParam[] = new String[inputParams.length+getInputParams.length];
													int gidx = inputParams.length;
													if(gidx != 1 && inputParams[0] != null){
														for(int ai = 0; ai < gidx ; ai++){
															arrayParam[ai] = inputParams[ai];
														}
													}else if(gidx == 1 && inputParams[0] == null){
														arrayParam = new String[getInputParams.length];
														gidx = 0;
													}
													for(int gi = 0; gi < getInputParams.length ; gi++){
														arrayParam[gidx++] = getInputParams[gi];
													}
													inputParams = new String[arrayParam.length];
													inputParams = arrayParam;
												}
											}

										if(execution.equalsIgnoreCase("before")){
											Map webServiceMap = new HashMap();
											String[] returnWebService = this.invokeWebService(endPoint,operation, inputParams, returnType);
											if(returnWebService !=null){
												mappingList.add(returnWebService);
											}else{
												mappingList.add(new String[]{"내용없음"});
											}
										}else{
											Map webServiceMap = new HashMap();
											webServiceMap.put("endPoint",endPoint);
											webServiceMap.put("operation",operation);
											webServiceMap.put("inputParams",inputParams);
											webServiceMap.put("returnType",returnType);
											webServiceMap.put("objId",fieldId);
											webServiceMap.put("actualParameters",actualParameters);
											webServiceMap.put("checkMap",checkMap);
											webServiceMap.put("oldRec",oldRec);
											afterList.add(webServiceMap);
										}
									}
								}
								List<SwdDataField> fieldList = new ArrayList<SwdDataField>();
								SwdDataField[] beforeRec = newRec.getDataFields();
								SwdDataField[] afterRec = null;

								if(mappingList.size()>0){
									for(String[] str : mappingList){
										for(int ix = 0; ix < str.length ; ix++){
											int flag = 0;
											if(beforeRec != null){
												List<SwdDataField> recTemp = new ArrayList<SwdDataField>();
												for(SwdDataField beforeField: beforeRec){
													if(!fieldId.equalsIgnoreCase(beforeField.getId())){
														recTemp.add(beforeField);
													}
												}
												if(recTemp.size()>0){
													afterRec = new SwdDataField[recTemp.size()];
													recTemp.toArray(afterRec);
													/*
													int idx = 0;
													for(SwdDataField recField: recTemp){
														afterRec[idx++] = recField;
													}
													*/
												}
											}
											SwdDataField sdField = new SwdDataField();
											sdField.setId(fieldId);
											sdField.setType("string");
											sdField.setRow(0);
											sdField.setValue(str[ix]);
											fieldList.add(sdField);
										}
									}
									newRec.setDataFields(afterRec);
									//SwdDataField[] sdFields = new SwdDataField[fieldList.size()];
									int xIdx = 0;
									for(SwdDataField fe : fieldList){
										newRec.setDataField2(fieldId,fe);
									}
								}else{
									newRec.setDataField2(null,null);
								}
							} else if (SwfMapping.TYPE_EXPRESSION.equalsIgnoreCase(mappingFormType)) {
								String value = preMapping.getFieldName();
								value = StringUtils.replace(value, "'", "");
								newRec.setDataFieldValue(fieldId, fieldType, value);
							}
						// 계산식
						} else if ("expression".equalsIgnoreCase(mappingType)) {
							if(editMode.equals("")) {
								String expr = preMapping.getExpression();
								String value = "";
								if (!CommonUtil.isEmpty(expr)) {
									boolean isSelfForm = expr.indexOf("'self_form'") != -1;
									if (isSelfForm)
										hasSelfMapping = true;
									if (isSelfForm || loopCounter == 1)
										value = SmartApi.executeExpression(userId, preMapping.getExpression(), newRec, formLinks);
								}
								newRec.setDataField(fieldId, toDataField(userId, field, value));
							}
						}
					}
				}
				
				newRecStr = newRec.toString(null, null);
			}
			
			buffer.append(newRecStr);
			request.getSession().setAttribute("afterWebService",afterList);
		// 폼 아이디, 레코드 아이디, 폼 필드 아이디로 해당 데이터를 조회
		} else if (method.equals("infoTaskToSend")) {
			String domainId = request.getParameter("domainId");
			String recordId = request.getParameter("recordId");
			String xmlData = CommonUtil.toNotNull(request.getParameter("data"));
			String receiptFormId = CommonUtil.toNotNull(request.getParameter("receiptFormId"));
			String approvalsId = CommonUtil.toNotNull(request.getParameter("approvalsId"));
			String approvalType = CommonUtil.toNotNull(request.getParameter("approvalType"));
			String approvalName = CommonUtil.toNotNull(request.getParameter("approvalName"));
			String receiptTitle = CommonUtil.toNull(request.getParameter("receiptTitle"));
			
			String[] approvalsIds = null;
			String[] approvalTypes = null;
			String[] approvalNames = null;
			
			AprApproval[] approvals = null;
			if(!approvalsId.equals("")) {
				approvalsIds = StringUtils.tokenizeToStringArray(approvalsId, ";");
				approvalTypes = StringUtils.tokenizeToStringArray(approvalType, ";");
				approvalNames = StringUtils.tokenizeToStringArray(approvalName, ";");
				
				approvals = new AprApproval[approvalsIds.length];
				for(int i=0; i<approvalsIds.length; i++) {
					approvals[i] = new AprApproval();
					approvals[i].setApprover(approvalsIds[i]);
					approvals[i].setType(approvalTypes[i]);
					approvals[i].setName(approvalNames[i]);
				}
			}

			SwdRecord record = (SwdRecord)SwdRecord.toObject(xmlData);
			record.setDomainId(domainId);
			record.setRecordId(recordId);

			record.setModificationUser(userId);

			String receiptUser = CommonUtil.toNull(request.getParameter("receiptUser"));
			String referenceUser = CommonUtil.toNull(request.getParameter("referenceUser"));
			
			//전자결재, 업무전달
			String isPublic  = CommonUtil.toNull(request.getParameter("isPublic"));
			String preservation = CommonUtil.toNull(request.getParameter("preservation"));
			String comment 		    = CommonUtil.toNull(request.getParameter("comment"));
			String priority		    = CommonUtil.toNull(request.getParameter("priority"));

			//제목
			if(!CommonUtil.isEqual(receiptTitle, ""))
				record.setExtendedAttributeValue("receiptTitle", receiptTitle);	   
							
			//수신자
			if(!CommonUtil.isEqual("", receiptUser))
				record.setExtendedAttributeValue("receiptUser", receiptUser);

			//중요도
			if(!CommonUtil.isEqual("", priority))
				record.setExtendedAttributeValue("receiptPriority", priority);

			//수신자 업무
			if(!CommonUtil.isEqual("", receiptFormId))
				record.setExtendedAttributeValue("receiptForm", receiptFormId);
			
			//참조자
			if(!CommonUtil.isEqual("", referenceUser))
				record.setExtendedAttributeValue("referenceUser", referenceUser);

		     //전달자의견, 전자결재 내용		
			if(!CommonUtil.isEqual("", comment))
				record.setExtendedAttributeValue("receiptDescription", comment);

			 //공개여부
			if(!CommonUtil.isEqual("", isPublic))
				record.setExtendedAttributeValue("isPublic", isPublic);     
			
			//보존년한
			if(!CommonUtil.isEqual("", preservation))
				record.setExtendedAttributeValue("preservation", preservation);    			

			SmartApi.setRecord(userId, record, approvals);
			buffer.append("<Result status=\"OK\"/>");
			
		// 프로세스 삭제
		} else if (method.equals("removeProcessInst")) {
			String processInstId = request.getParameter("processInstId");
			MisServiceFactory.getInstance().getPrcAdminService().removeProcessInst(userId, processInstId);
			buffer.append("<Result status=\"OK\"/>");
			
		// 에러 - 지원하지 않는 메소드
		}else if(method.equals("externalFormTaskExecute")){
			String taskId = CommonUtil.toNotNull(request.getParameter("taskId"));
			TskTask task = SmartApi.getTask(userId, taskId);
			SmartApi.executeTask(userId, task, "execute");
//return getTskService().executeTask(user, obj, action);
		}else {
			buffer.append("<Result status=\"Failed\"><message>Invalid method! Not found method parameter</message><trace/></Result>");
		}
		
	} catch (Throwable e) {
		buffer.append("<Result status=\"Failed\">");
		buffer.append("<eString>"+e.toString()+"</eString>");
		buffer.append("<message>");
		buffer.append("Failed to execute method (" + method + ") - " + e.getMessage());
		buffer.append("</message>");
		buffer.append("<trace><![CDATA[");
		buffer.append(ExceptionUtil.getTraceMessage("", e));
		buffer.append("]]></trace>");
		buffer.append("</Result>");
		LogFactory.getLog("executionService").error(buffer.toString());
	}
	System.out.println(buffer.toString());
%><%= buffer.toString() %>