<%@page import="net.smartworks.server.engine.config.model.SwcWebServiceParameter"%>
<%@page import="net.smartworks.server.engine.config.model.SwcWebService"%>
<%@page import="net.smartworks.server.engine.config.model.SwcWebServiceCond"%>
<%@page import="net.smartworks.server.engine.config.manager.ISwcManager"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@page import="net.smartworks.server.engine.resource.util.lang.ExceptionUtil"%>
<%@page import="net.smartworks.server.engine.resource.model.IFormModelList"%>
<%@page import="net.smartworks.server.engine.resource.model.enums.FormFieldEnum"%>
<%@page import="net.smartworks.server.engine.authority.model.SwaResource"%>
<%@page import="net.smartworks.server.engine.authority.model.SwaResourceCond"%>
<%@page import="net.smartworks.server.engine.authority.manager.ISwaManager"%>
<%@page import="net.smartworks.server.engine.infowork.form.manager.ISwfManager"%>
<%@page import="net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper"%>
<%@page import="net.smartworks.server.engine.resource.model.hb.HbPackageModelList"%>
<%@page import="net.smartworks.server.engine.common.model.Order"%>
<%@page import="net.smartworks.server.engine.category.model.CtgCategoryCond"%>
<%@page import="net.smartworks.server.engine.resource.model.enums.PackageFieldEnum"%>
<%@page import="net.smartworks.server.engine.resource.model.IPackageModelList"%>
<%@page import="net.smartworks.server.engine.common.model.BaseObjects"%>
<%@page import="net.smartworks.server.engine.common.manager.IManager"%>
<%@page import="net.smartworks.server.engine.factory.SwManagerFactory"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfForm"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfFormCond"%>
<%@page import="net.smartworks.server.engine.pkg.model.PkgPackageCond"%>
<%@page import="net.smartworks.server.engine.common.model.Result"%>
<%@page import="net.smartworks.server.engine.resource.manager.SmartServerManager"%>
<%@page import="net.smartworks.server.engine.resource.manager.IResourceDesigntimeManager"%>
<%@page import="net.smartworks.server.engine.resource.util.lang.StringUtil"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.server.engine.common.util.DateUtil"%>
<%@page import="net.smartworks.server.engine.pkg.model.PkgPackage"%>
<%@page import="net.smartworks.server.engine.process.approval.model.AprApprovalLineDef"%>
<%@page import="net.smartworks.server.engine.resource.model.IWorkItem"%>
<%@page import="net.smartworks.server.engine.resource.model.hb.HbWorkTypePerformerLineModel"%>
<%@page import="net.smartworks.server.engine.resource.model.IWorkTypePerformerLineModel"%>
<%@page import="net.smartworks.server.engine.resource.model.IWorkTypeModel"%>
<%@page import="net.smartworks.server.engine.resource.model.IOrgUserModel"%>
<%@page import="net.smartworks.server.engine.resource.model.IPackageModel"%>
<%@page import="net.smartworks.server.engine.resource.model.IProcessModel"%>
<%@page import="net.smartworks.server.engine.category.model.CtgCategory"%>
<%@page import="net.smartworks.server.engine.resource.model.IFormModel"%>
<%@page import="net.smartworks.server.engine.resource.model.IFormFieldDef"%>
<%@page import="net.smartworks.server.engine.resource.model.IFormDef"%>
<%@page import="java.util.Date"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.util.Iterator"%>
<%@page import="org.springframework.util.StringUtils"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%!public int getCount(String pageCountStr) {
		if(pageCountStr == null || pageCountStr.equals("") || pageCountStr.equals("null"))
			return 1;
		return Integer.parseInt(pageCountStr);
	}

	public String convertField(List<IFormDef> formList) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		for(IFormDef form : formList) {
			Iterator<IFormFieldDef> fieldIt = form.getFormFieldMap().values().iterator();
			while(fieldIt.hasNext()) {
				IFormFieldDef field = fieldIt.next();
				buf.append("<formField>");
				buf.append("<formId>").append(form.getId()).append("</formId>");
				buf.append("<id>").append(field.getId()).append("</id>");
				buf.append("<name><![CDATA[").append(field.getName()).append("]]></name>");
				//buf.append("<type>").append(field.getType()).append("</type>");
				buf.append("<type>").append(field.getFormatType()).append("</type>");
				buf.append("</formField>");
			}
		}
		buf.append("</Result>");
		return buf.toString();
	}

	public String convertFormList(List formList) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		if(formList != null && !formList.isEmpty()) {
			for (Iterator itrForm = formList.iterator(); itrForm.hasNext();) {
				IFormModel obj = (IFormModel)itrForm.next();
				buf.append(obj.toString());
			}
		}
		buf.append("</Result>");
		return buf.toString();
	}

	public String convertGroupList(CtgCategory[] groupList) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		if(groupList != null && groupList.length > 0) {
			for (int i = 0; i < groupList.length; i++) {
				CtgCategory obj = (CtgCategory) groupList[i];
				buf.append(obj.toString());
			}
		}
		buf.append("</Result>");
		return buf.toString();
	}

	public String convert(List<IFormModel> formList) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		if(formList != null && !formList.isEmpty()) {
			for(IFormModel form : formList)
				buf.append(form.toString());
		}
		buf.append("</Result>");
		return buf.toString();
	}

	public String convert(IProcessModel process) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		buf.append((process != null ? process.toString() : ""));	
		buf.append("</Result>");
		return buf.toString();
	}
	
	public String convert(IFormModel form) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		buf.append(form.toString());
		buf.append("</Result>");
		return buf.toString();
	}

	public String convert(int pkgCount, List<IPackageModel> pkgList) {
		StringBuffer buf = new StringBuffer();
		buf.append("<Result status=\"OK\" totalCount=\"").append(pkgCount).append("\">");
		if(pkgList != null && !pkgList.isEmpty()) {
			for(IPackageModel pkg : pkgList)
				buf.append(pkg.toString());
		}
		buf.append("</Result>");
		return buf.toString();
	}
	
	public String convert(IPackageModel pkg) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		buf.append(pkg.toString());
		buf.append("</Result>");
		return buf.toString();
	}
	
	public String convertUser(List<IOrgUserModel> userList) {
		StringBuffer buf = new StringBuffer("<Result status=\"OK\">");
		for (IOrgUserModel user : userList)
			buf.append(user.toString());
		buf.append("</Result>");
		return buf.toString();
	}
	
	public void setPerformers(IWorkTypeModel workType, String performers) {
		
		Set<IWorkTypePerformerLineModel> performerLine = workType.getPerformerLineSet();
		
		// 기존에 performerLine이 없을 경우
		if(performerLine == null || performerLine.isEmpty()) {
			// 새로운 performers가 설정되지 않았을 경우
			if(performers == null || performers.equals("") || performers.equals("")) {
								
			// 새로운  performerLine이 하나 일 경우
			} else if(performers.indexOf("|") < 1) {
				IWorkTypePerformerLineModel performerLineModel = new HbWorkTypePerformerLineModel();
				performerLineModel.setPerformerType(IWorkItem.ASSING_TYPE_USER);
				performerLineModel.setPerformer(performers);
				performerLineModel.setStep(1);
				performerLineModel.setWorkTypeId(workType.getId());
				
			// 새로운 performerLine이 여럿 일 경우
			} else {
				// performers 추가
				StringTokenizer st = new StringTokenizer(performers);
				int step = 1;
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					IWorkTypePerformerLineModel line = new HbWorkTypePerformerLineModel();
					line.setPerformer(token);
					line.setWorkTypeId(workType.getId());
					line.setPerformerType(IWorkItem.ASSING_TYPE_USER);
					line.setStep(step++);
					workType.addPerformerLine(line);
				}
			}
			
		// 기존에 performerLine이 있을 경우
		} else {
			// 새로운 performers가 설정되지 않았을 경우
			if(performers == null || performers.equals("") || performers.equals("")) {
				workType.clearPerformerLine();
				
			// 새로운 performerLine이 하나 일 경우
			} else if(performers.indexOf("|") < 1) {
				// 수행자 라인을 클리어 하고 --> plLine에 수행자를 채워서 workType에 다시 설정 				
				IWorkTypePerformerLineModel plLine = performerLine.iterator().next();
				plLine.setPerformer(performers);
				workType.clearPerformerLine();
				workType.addPerformerLine(plLine);
				
			// 새로운 performerLine이 여럿 일 경우
			} else {
				// 기존 수행자라인을 performers 정보로 교체
				workType.clearPerformerLine();
				
				StringTokenizer st = new StringTokenizer(performers);
				int step = 1;
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					IWorkTypePerformerLineModel line = new HbWorkTypePerformerLineModel();
					line.setPerformer(token);
					line.setPerformerType(IWorkItem.ASSING_TYPE_USER);
					line.setWorkTypeId(workType.getId());
					line.setStep(step++);
					workType.addPerformerLine(line);
				}
			}
		}
	}	
	public String toXmlWithOutHeader(String xml) {
		return StringUtils.replace(xml, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");		
	}
	
	public String convertApprovalLineDef(AprApprovalLineDef[] lineDefs) {
		StringBuffer strBuf = new StringBuffer("<Result status=\"OK\">");
		if (lineDefs != null) {
			strBuf.append("<approvalLineDefs size='").append(lineDefs.length).append("'>");
			for (int j = 0; j < lineDefs.length; j++) {
				strBuf.append(toXmlWithOutHeader(lineDefs[j].toString()));
			}
			strBuf.append("</approvalLineDefs>");
		}	
		strBuf.append("</Result>");
		return strBuf.toString();
	}
	
	public String convert(PkgPackage[] packagesList) {
		StringBuffer str = new StringBuffer("<Result status=\"OK\">");
		
		//for(ICategoryModel cat : categoryList)
		//	str += cat.toString();
		if (packagesList != null) {
			for (int i = 0; i < packagesList.length; i++) {
				PkgPackage pkg = (PkgPackage) packagesList[i];
				str.append(StringUtils.replace(StringUtils.replace(pkg.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", ""), "<package ", "<workPackage "));
			}
		}
		
		str.append("</Result>");
		return str.toString();
	}

	public String convert(CtgCategory[] categoryList) {
		String str = "<Result status=\"OK\">";
		
		//for(ICategoryModel cat : categoryList)
		//	str += cat.toString();
		if (categoryList != null) {
			for (int i = 0; i < categoryList.length; i++) {
				CtgCategory cat = (CtgCategory) categoryList[i];
				str += StringUtils.replace(cat.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
			}
		}
		str += "</Result>";
		return str;
	}
	
	public String convert(CtgCategory category) {
		String str = "<Result status=\"OK\">";
		//str += category.toString();
		str += StringUtils.replace(category.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		str += "</Result>";
		return str;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	//TODO builderService 에서 사용하는 SmartApi 기능을 이리로 옮김 정리 필요
	public static PkgPackage[] getPackagesWithCategoryInfo(String companyId, String user, PkgPackageCond cond) throws Exception {
		PkgPackage[] pkgs = SwManagerFactory.getInstance().getPkgManager().getPackages(user, cond, null);
		if (CommonUtil.isEmpty(pkgs))
			return null;
		for (PkgPackage pkg : pkgs) {
			if ("SINGLE".equals(pkg.getType()) && CommonUtil.isEmpty(pkg.getExtendedAttributeValue("formId"))) {
				SwfFormCond formCond = new SwfFormCond();
				formCond.setPackageId(pkg.getPackageId());
				SwfForm[] forms = SwManagerFactory.getInstance().getSwfManager().getForms(user, formCond, null);
				if (!CommonUtil.isEmpty(forms))
					pkg.setExtendedAttributeValue("formId", forms[forms.length-1].getId());
			}
			
			// 카테고리 정보
			String catId = pkg.getCategoryId();
			if (catId == null)
				continue;
			CtgCategory cat = SwManagerFactory.getInstance().getCtgManager().getCategory(companyId, user, catId);
			if (cat == null)
				continue;
			CtgCategory superCat = getParentCategory(companyId, user, catId);
			if (superCat == null || superCat.getObjId().equals("_PKG_ROOT_")) {
				pkg.setExtendedAttributeValue("categoryName", cat.getName());
				continue;
			}
			pkg.setExtendedAttributeValue("categoryName", superCat.getName());
			pkg.setExtendedAttributeValue("groupName", cat.getName());
		}
		return pkgs;
	}
	//부모 카테고리를 찾는다.
	public static CtgCategory getParentCategory(String companyId, String user, String categoryId) throws Exception {
		CtgCategory category = SwManagerFactory.getInstance().getCtgManager().getCategory(user, categoryId, IManager.LEVEL_LITE);
		if (category == null)
			return null;
		String parentPkgId = category.getParentId();
		return SwManagerFactory.getInstance().getCtgManager().getCategory(user, parentPkgId, IManager.LEVEL_LITE);
	}
	public static CtgCategory[] findChildren(String companyId, String user, String categoryId, String disableCategoryId) throws Exception {
		String[] typeNotIns = new String[1];
		typeNotIns[0] = disableCategoryId;
		return findChildren(companyId, user, categoryId, typeNotIns);
	}
	//카테고리 아이디로 자식 카테고리 리스트를 검색한다.
	//disableCategoryId UI에서 비활성 시킬 카테고리 아이디(없다면 null)
	
	public static CtgCategory[] findChildren(String companyId, String user, String categoryId, String[] disableCategoryIds) throws Exception {
		CtgCategoryCond cond = new CtgCategoryCond();
		if (CommonUtil.isEmpty(companyId))
			throw new Exception("SmartApi_companyId is null.");
		cond.setCompanyId(companyId);
		cond.setParentId(categoryId);

		cond.setObjIdNotIns(disableCategoryIds);
		
		Order orderObj = new Order();
		orderObj.setField("displayOrder");
		orderObj.setAsc(true);
		
		Order orderObj2 = new Order();
		orderObj2.setField("name");
		orderObj2.setAsc(true);
		
		Order[] orders = new Order[2];
		orders[0] = orderObj;
		orders[1] = orderObj2;
		cond.setOrders(orders);
		
		CtgCategory[] results = SwManagerFactory.getInstance().getCtgManager().getCategorys(user, cond, IManager.LEVEL_LITE);
		
	/*	//TODO 쿼리에서 objIdNotIns 수정 필요
		if (!CommonUtil.isEmpty(disableCategoryId) && !CommonUtil.isEmpty(results)) {
			CtgCategory tempCtg = null;
			for (int i = 0; i < results.length; i++) {
				if (disableCategoryId.equalsIgnoreCase(results[i].getObjId())) {
					tempCtg = results[i];
					break;
				}
			}
			if (tempCtg != null)
				results = CtgCategory.remove(results, tempCtg);
		}*/
		return results;
	}
	//카테고리 아이디로 자식 카테고리 리스트를 검색한다.
	public static CtgCategory[] findChildren(String companyId, String user, String categoryId) throws Exception {
		CtgCategoryCond cond = new CtgCategoryCond();
		if (CommonUtil.isEmpty(companyId))
			throw new Exception("SmartApi_companyId is null.");
		cond.setCompanyId(companyId);
		cond.setParentId(categoryId);

		Order orderObj = new Order();
		orderObj.setField("displayOrder");
		orderObj.setAsc(true);
		
		Order orderObj2 = new Order();
		orderObj2.setField("name");
		orderObj2.setAsc(true);
		
		Order[] orders = new Order[2];
		orders[0] = orderObj;
		orders[1] = orderObj2;
		cond.setOrders(orders);
		
		return SwManagerFactory.getInstance().getCtgManager().getCategorys(user, cond, IManager.LEVEL_LITE);
	}
	public static void removeMenuItemsByPackageId(String userId, String packageId) throws Exception {
		if (CommonUtil.isEmpty(packageId))
			return;
		SwManagerFactory.getInstance().getItmManager().removeMenuItem(userId, packageId);
	}
	
	
	
%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	
	String userId = CommonUtil.toNull(request.getParameter("userId"));
	if (userId == null) {
		User user = SmartUtil.getCurrentUser();
		userId = user.getId();
	}
	String method = StringUtil.toNotNull(request.getParameter("method"));
	String compId = StringUtil.toNotNull(request.getParameter("compId"));
	
	StringBuffer buffer = new StringBuffer();
	//IResourceDesigntimeManager rscMgr = SmartServerManager.getInstance().getResourceDesigntimeManager();
	IResourceDesigntimeManager rscMgr = SwManagerFactory.getInstance().getDesigntimeManager();
	
	try {
		// 에러 - 메소드 이름이 없음
		if(method.equals("")) {
			buffer.append("<Result status=\"Failed\"><message>Invalid method! Not found method parameter</message><trace/></Result>");
		
		} else if (method.equals("getPackageByFormId")) {
			// 카테고리 아이디로 패키지 리스트를 가져온다.
			String formId = CommonUtil.toNull(request.getParameter("formId"));
			IFormModel formModel = rscMgr.retrieveForm(userId, formId, 1);
		
			Result res = new Result();
			res.setStatus("OK");
			if (formModel != null) {
				String packageId = formModel.getPackageId();
				PkgPackageCond cond = new PkgPackageCond();
				cond.setPackageId(packageId);
				PkgPackage[] pkgs = getPackagesWithCategoryInfo(compId, userId, cond);
				if (!CommonUtil.isEmpty(pkgs))
			res.setObjString(pkgs[0].toString(null, null));
			}
			buffer.append(res.toString("Result", null));
			
		} else if (method.equals("getPackages")) {
			PkgPackageCond cond = new PkgPackageCond();
			String nameLike = CommonUtil.toNull(request.getParameter("nameLike"));
			String type = CommonUtil.toNull(request.getParameter("type"));
			cond.setNameLike(nameLike);
			cond.setType(type);
			
			long size = SwManagerFactory.getInstance().getPkgManager().getPackageSize(userId, cond);
			
			int pageSize = CommonUtil.toInt(CommonUtil.toDefault(request.getParameter("pageSize"), "-1"));
			int pageNo = CommonUtil.toInt(CommonUtil.toDefault(request.getParameter("pageNo"), "-1"));
			cond.setPageSize(pageSize);
			cond.setPageNo(pageNo);
			
			PkgPackage[] pkgs = getPackagesWithCategoryInfo(compId, userId, cond);
			
			Result res = new Result();
			res.setStatus("OK");
			res.setTotalSize(size);
			if (!CommonUtil.isEmpty(pkgs)) {
				BaseObjects objs = new BaseObjects();
				objs.setObjects(pkgs);
				res.setObjString(objs.toString("packages", "\t"));
			}
			buffer.append(res.toString("Result", null));
			
		} else if (method.equals("getPackageListByCategory")) {
			// listType = 0 : 전체 보기, 1: 배치된 것만 보기, 2 : 최신 버전만 보기
			String listType = StringUtil.toNotNull(request.getParameter("listType"));
			String categoryId = CommonUtil.toNull(request.getParameter("categoryId"));
			String packageName = StringUtil.toNotNull(request.getParameter("packageName"));
			String pageCountStr = StringUtil.toNotNull(request.getParameter("pageCount"));
			String recordCountStr = StringUtil.toNotNull(request.getParameter("recordCount"));
			
			int pageCount = this.getCount(pageCountStr);
			int recordCount = this.getCount(recordCountStr);
			int showType = this.getCount(listType);
			
			IPackageModelList pkgList = null;
			StringBuffer workGroupStr = new StringBuffer();
		
			if (categoryId != null) {
				if(showType == 2) {
					pkgList = rscMgr.searchLatestPackageList(userId, categoryId);
				} else {
					if(!"".equals(packageName)) {
						Map<String, Object> condition = new HashMap<String, Object>();
						condition.put(PackageFieldEnum.categoryId.name(), categoryId);
						
						// 패키지 이름이 검색 조건에 포함
						if(!"".equals(packageName))
							condition.put(PackageFieldEnum.name.name(), packageName);
						
						// 배치된 것만 보기
						if (showType == 1)
							condition.put(PackageFieldEnum.status.name(), IPackageModel.STATUS_DEPLOYED);
						
						pkgList = rscMgr.searchPackageByCondition(userId, condition, null, pageCount, recordCount);
					} else {
						//pkgList = rscMgr.searchLatestPackageList(userId, categoryId);
						Map<String, Object> searchCond = new HashMap<String, Object>();
						searchCond.put(PackageFieldEnum.categoryId.name(), categoryId);
				
						Map<String, String> ordCond = new HashMap<String, String>();
						ordCond.put(PackageFieldEnum.name.name(), "asc");
				
						pkgList = rscMgr.searchPackageByCondition(userId, searchCond, ordCond, pageCount, recordCount);
						
						//List workGroupList = SmartServerManager.getInstance().getCategoryManager().findChildren(userId, categoryId);
						CtgCategory[] workGroupList = findChildren(compId, userId, categoryId);
						
						if (workGroupList != null && workGroupList.length > 0) {
							for (int i = 0; i < workGroupList.length; i++) {
								CtgCategory obj = (CtgCategory) workGroupList[i];
								// 배치된 것만 보기
								if (showType == 1) {
									Map<String, Object> condition = new HashMap<String, Object>();
									condition.put(PackageFieldEnum.status.name(), IPackageModel.STATUS_DEPLOYED);
									condition.put(PackageFieldEnum.categoryId.name(), obj.getObjId());
									pkgList = rscMgr.searchPackageByCondition(userId, condition, null, pageCount, recordCount);
									if(pkgList.getTotalCount() >0) {
										String temp = StringUtils.replace(obj.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
										workGroupStr.append(temp);
									}
								} else {
									String temp = StringUtils.replace(obj.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
									workGroupStr.append(temp);
								}
							}
						} 
					}
				}
			}
			
			if (pkgList == null)
				pkgList = new HbPackageModelList();
			
			buffer.append(pkgList);
		
			buffer.replace(buffer.indexOf("</Result>"), buffer.indexOf("</Result>")+9, workGroupStr.toString());
			buffer.append("</Result>");
			
		// 카테고리 아이디로 패키지 리스트를 가져온다.
		} else if(method.equals("getGroupPackageList")) {
			String parentCatId = CommonUtil.toNull(request.getParameter("parentCatId"));
			//List workGroupList = SmartServerManager.getInstance().getCategoryManager().findChildren(userId, parentCatId);
			CtgCategory[] workGroupList = findChildren(compId, userId, parentCatId);
			buffer.append(this.convertGroupList(workGroupList));
		// 카테고리 아이디로 패키지 리스트를 가져온다.
		} else if(method.equals("getFormListByCategory")) {
			String categoryId = CommonUtil.toNull(request.getParameter("categoryId"));
			List frmList = SmartServerManager.getInstance().getResourceRuntimeManager().findLatestFormByCategory(userId, categoryId, IFormModel.TYPE_SINGLE);
			buffer.append(this.convertFormList(frmList));
				// 패키지 아이디, 버전으로 패키지 정보를 조회
		} else if(method.equals("getPackage")) {
			String packageId = request.getParameter("packageId");
			IPackageModel pkg = rscMgr.retrievePackage(userId, packageId, 1);
			buffer.append("<Result status=\"OK\">");
			if(pkg != null)
				buffer.append(pkg.toString());
			buffer.append("</Result>");

		// 프로세스가 체크인 상태이면 무조건 마지막 버전을 찾는다. 프로세스가 체크아웃 상태이고 체크아웃 사용자가 userId와 동일하면 체크아웃된 버전 (즉 최종 버전)을 찾고 그렇지 않다면 체크인된 버전 중 최신버전을 찾는다.
		} else if(method.equals("loadProcess")) {
			String processId = request.getParameter("processId");
			String diagramStr = rscMgr.retrieveProcessContent(userId, processId, 1);
			buffer.append(diagramStr);
	
		// 프로세스 인스턴스 맵 정보
		} else if(method.equals("loadPrcInstMap")) {
			String prcInstId = StringUtil.toNotNull(request.getParameter("prcInstId"));
			String instMapStr = SwManagerFactory.getInstance().getMonManager().monitor(null, prcInstId, null);
			buffer.append(instMapStr);
	
		// 패키지 아이디로 프로세스 아이디, 버전, 이름등 메타정보를 찾는다.
		} else if(method.equals("getProcessInfoByPackage")) {
			String packageId = request.getParameter("packageId");
			IProcessModel prcModel = rscMgr.retrieveProcessByPackage(userId, packageId, 1);			
			buffer.append(this.convert(prcModel));
	
		// 패키지 아이디로 프로세스(XML)를 찾는다.
		} else if(method.equals("loadProcessByPackage")) {
			String packageId = request.getParameter("packageId");
			IProcessModel prcModel = rscMgr.retrieveProcessByPackage(userId, packageId, 1);
			String diagramStr = rscMgr.retrieveProcessContent(userId, prcModel.getProcessId());
			buffer.append(diagramStr);
	
		// 프로세스 XML 저장
		} else if(method.equals("saveProcessContent")) {
			String processId = request.getParameter("processId");
			//String processContent = request.getParameter("processContent");
			String processContent = new String(request.getParameter("processContent").getBytes("ISO-8859-1"), "UTF-8");

			// 프로세스 validation 체크
			ProcessModelHelper.load(processContent);
			rscMgr.updateProcessContent(userId, processId, 1, processContent);
			buffer.append("<Result status=\"OK\"/>");
			
				// 프로세스 메타 정보 저장
		} else if(method.equals("saveProcessMeta")) {
			String processId = request.getParameter("processId");
			String name = request.getParameter("name");			
			String keyword = request.getParameter("keyword");
			String ownerDept = request.getParameter("ownerDept");
			String owner = request.getParameter("owner");
			String description = request.getParameter("description");
		
			IProcessModel prc = rscMgr.retrieveProcess(userId, processId, 1);
			if(name != null && !name.equals("null")) 
				prc.setName(name);
			
			if(keyword != null && !keyword.equals("null")) 
				prc.setKeyword(keyword);
			
			if(ownerDept != null && !ownerDept.equals("null")) 
				prc.setOwnerDept(ownerDept);			
		
			if(owner != null && !owner.equals("null")) 
				prc.setOwner(owner);
			
			if(description != null && !description.equals("null")) 
				prc.setDescription(description);
			
			rscMgr.updateProcess(userId, prc);
			buffer.append("<Result status=\"OK\"/>");
		
		// 패키지 아이디, 버전으로  패키지에 소속된 모든 폼을 찾는다.
		} else if(method.equals("getFormList")) {
			String packageId = request.getParameter("packageId");
			List<IFormModel> formList = rscMgr.findFormByPackage(userId, packageId, 1);
			buffer.append(this.convert(formList));
			
		// 패키지 아이디, 버전으로  패키지에 소속된 모든 단위업무 폼을 찾는다.
		} else if(method.equals("getSingleFormList")) {
			String packageId = request.getParameter("packageId");
			List<IFormModel> formList = rscMgr.findSingleFormByPackage(userId, packageId, 1);
			buffer.append(this.convert(formList));
		// 패키지 아이디, 버전으로  패키지에 소속된 모든 단위업무 폼을 찾는다.
		} else if(method.equals("getSingleFormListByCategory")) {
			String categoryId = request.getParameter("categoryId");
			List frmList = SmartServerManager.getInstance().getResourceDesigntimeManager().findLatestFormByCategory(categoryId, IFormModel.TYPE_SINGLE);
			buffer.append(this.convert(frmList));			
		// 프로세스 아이디, 버전으로 프로세스에 소속된 모든 프로세스 업무 폼을 찾는다.
		} else if(method.equals("getProcessFormList")) {
			String processId = request.getParameter("processId");
			List<IFormModel> formList = rscMgr.findFormByProcess(userId, processId, 1);
			buffer.append(this.convert(formList));
	
		// 프로세스 아이디, 버전으로 프로세스에 소속된 모든 프로세스 업무 폼을 찾는다.
		} else if(method.equals("getProcessFormListByForm")) {
			String formId = request.getParameter("formId");
			IFormModel frm = rscMgr.retrieveLatestForm(userId, formId);
			if (frm != null) {
				List<IFormModel> formList = rscMgr.findFormByPackage(userId, frm.getPackageId(), 1);
				if (formList.size() > 1)
			buffer.append(this.convert(formList));
			}
	
		// 워크타입 아이디로 연결된 업무 폼을 찾는다.
		} else if(method.equals("getFormByWorkType")) {
			String workTypeId = request.getParameter("workTypeId");
			IWorkTypeModel workType = rscMgr.retrieveWorkType(userId, workTypeId);
			String formContents = rscMgr.retrieveFormContent(userId, workType.getFormUid());
			buffer.append(formContents == null ? "<Form/>" : formContents);
	
		// 특정 폼의 필드 리스트를 찾는다.
		} else if(method.equals("getFormFieldList")) {
			String packageId = request.getParameter("packageId");
			List<IFormDef> formList = rscMgr.findFormFieldByPackage(userId, packageId, 1);
			buffer.append(this.convertField(formList));
		// 폼 컨텐츠 로딩
		} else if(method.equals("loadFormContent")) {
			String formId = request.getParameter("formId");
			String formContent = rscMgr.retrieveFormContent(userId, formId, 1);
			if (formContent == null || formContent.length() == 0) {
				buffer.append("<Result status=\"OK\">").append("</Result>");
			} else {
				buffer.append(CommonUtil.toNotNull(formContent));
			}
		} else if(method.equals("getPackage")) {
			String packageId = request.getParameter("packageId");
			IPackageModel pkg = rscMgr.retrievePackage(userId, packageId, 1);
			buffer.append("<Result status=\"OK\">");
			if(pkg != null)
				buffer.append(pkg.toString());
			buffer.append("</Result>");

		// 폼 조회
		} else if (method.equals("getForm")) {
			String formId = request.getParameter("formId");
			IFormModel formModel = rscMgr.retrieveForm(userId, formId, 1);
			buffer.append("<Result status=\"OK\">");
			if(formModel != null)
				buffer.append(formModel.toString());
			buffer.append("</Result>");
			
		// 폼 로딩
		} else if (method.equals("loadForm")) {
			String formId = request.getParameter("formId");
			IFormModel formModel = rscMgr.retrieveForm(userId, formId, 1);
			buffer.append(formModel);
			
		// 폼 저장
		} else if(method.equals("saveFormContent")) {
			String formId = request.getParameter("formId");
			//String formContent = request.getParameter("formContent");
			String formContent = new String(request.getParameter("formContent").getBytes("ISO-8859-1"), "UTF-8");
			rscMgr.updateFormContent(userId, formId, 1, formContent);
			buffer.append("<Result status=\"OK\"/>");

		// 폼 이름 변경
		} else if(method.equals("renameForm")) {
			String formId = request.getParameter("formId");
			String formName = request.getParameter("formName");
			rscMgr.updateFormName(userId, formId, 1, formName);
			buffer.append("<Result status=\"OK\"/>");
			
		// 프로세스 이름 변경
		} else if(method.equals("renameProcess")) {
			String processId = request.getParameter("processId");
			String processName = request.getParameter("processName");
			rscMgr.updateProcessName(userId, processId, 1, processName);
			buffer.append("<Result status=\"OK\"/>");
			
		// 폼 타입을 변경
		} else if(method.equals("changeFormType")) {
			String formId = request.getParameter("formId");
			String type = request.getParameter("type");
			IFormModel form = rscMgr.retrieveForm(userId, formId, 1);
			form.setType(type);
			rscMgr.updateForm(userId, form);
	
		// 폼 메타 정보 저장
		} else if(method.equals("saveForm")) {
			// TODO 수정 필요
			String formId = request.getParameter("formId");
			
			String name = StringUtil.toNotNull(request.getParameter("name"));
			String keyword = StringUtil.toNotNull(request.getParameter("keyword"));
			String ownerDept = StringUtil.toNotNull(request.getParameter("ownerDept"));
			String owner = StringUtil.toNotNull(request.getParameter("owner"));
			String description = StringUtil.toNotNull(request.getParameter("description"));
			String type = StringUtil.toNotNull(request.getParameter("type"));
			
			IFormModel form = rscMgr.retrieveForm(userId, formId, 1);
			if(!name.equals("")) 
				form.setName(name);
			
			if(!keyword.equals("")) 
				form.setKeyword(keyword);
			
			if(!ownerDept.equals("")) 
				form.setOwnerDept(ownerDept);			
		
			if(!owner.equals("")) 
				form.setOwner(owner);
			
			if(!description.equals("")) 
				form.setDescription(description);
		
			if(!type.equals("")) 
				form.setType(type);
			
			rscMgr.updateForm(userId, form);			
			buffer.append("<Result status=\"OK\"/>");
			
		// 워크 타입 정보 로드
		} else if(method.equals("loadWorkType")) {
			String formId = request.getParameter("formId");
			
			IWorkTypeModel workType = rscMgr.retrieveWorkTypeByForm(userId, formId, 1);
			
			buffer.append("<Result status=\"OK\">");
			if(workType != null)
				buffer.append(workType.toString());
			buffer.append("</Result>");
				
		// 워크 타입 정보 저장
		} else if(method.equals("saveWorkType")) {
			String formId = request.getParameter("formId");
			
			IWorkTypeModel workType = rscMgr.retrieveWorkTypeByForm(userId, formId, 1);
			String stepCountStr = request.getParameter("stepCount");			
			String typeStr = request.getParameter("type");
			String durationStr = request.getParameter("duration");
			// 사용자는 '|'로 구분, userId1|userId2|userId3
			String performers = request.getParameter("performers");
			
			int stepCount = 1;
			
			if(stepCountStr != null && !stepCountStr.equals("null"))
				stepCount = Integer.parseInt(stepCountStr);
			
			workType.setStepCount(stepCount);
			
			if(typeStr != null && !typeStr.equals("null"))
				workType.setType(typeStr);
			
			if(durationStr != null && !durationStr.equals("null")) 
				workType.setDuration(Integer.parseInt(durationStr));
			
			if(performers != null && !performers.equals("null"))
				this.setPerformers(workType, performers);
			
			rscMgr.updateWorkType(userId, workType);
	
		// 패키지 체크아웃
		} else if(method.equals("checkOutPackage")) {
			String packageId = request.getParameter("packageId");
			rscMgr.checkOutPackage(userId, packageId, 1);
			buffer.append("<Result status=\"OK\"/>");
		
		// 패키지 체크인
		} else if(method.equals("checkInPackage")) {
			String packageId = request.getParameter("packageId");
			rscMgr.checkInPackage(userId, packageId, 1);
			buffer.append("<Result status=\"OK\"/>");
			
		// 패키지 배치
		} else if(method.equals("deployPackage")) {
			
			String packageId = request.getParameter("packageId");
			String type = CommonUtil.toNotNull(request.getParameter("type"));
			//default 권한
			String receId = null;
			Date date = new Date();
			if (packageId != null) {
				if (type.equals("SINGLE")){
					ISwfManager swfMgr = SwManagerFactory.getInstance().getSwfManager();
					SwfFormCond swfCond = new SwfFormCond();
					swfCond.setPackageId(packageId);
					SwfForm[] swfObj = swfMgr.getForms(userId, swfCond, "all");
					if (swfObj != null) {
					receId = swfObj[0].getId();
					}
				} else {
					IResourceDesigntimeManager rscMgr1 = SmartServerManager.getInstance().getResourceDesigntimeManager();
					IProcessModel prcModel = rscMgr1.retrieveProcessByPackage(userId, packageId, 1);
					if (prcModel != null) {
					receId = prcModel.getProcessId();
					}
				}
				if (receId != null) {
					ISwaManager swaMgr = SwManagerFactory.getInstance().getSwaManager();
					SwaResourceCond swaCond = new SwaResourceCond();
					swaCond.setResourceId(receId);
					SwaResource[] swaObj = swaMgr.getResources(userId, swaCond, "all");
					if (swaObj == null){
						SwaResource swaobjs = new SwaResource();
						//R
						swaobjs.setResourceId(receId);
						swaobjs.setType(0);
						swaobjs.setMode("R");
						swaobjs.setPermission("PUB_ALL");
						swaobjs.setCreationUser(userId);
						swaobjs.setModificationUser(userId);
						swaobjs.setCompanyId(compId);
						swaobjs.setCreationDate(date);
						swaobjs.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs, null);
						//W
						SwaResource swaobjs1 = new SwaResource();
						swaobjs1.setResourceId(receId);
						swaobjs1.setType(0);
						swaobjs1.setMode("W");
						swaobjs1.setPermission("PUB_ALL");
						swaobjs1.setCreationUser(userId);
						swaobjs1.setModificationUser(userId);
						swaobjs1.setCompanyId(compId);
						swaobjs1.setCreationDate(date);
						swaobjs1.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs1, null);
						//M
						SwaResource swaobjs2 = new SwaResource();
						swaobjs2.setResourceId(receId);
						swaobjs2.setType(0);
						swaobjs2.setMode("M");
						swaobjs2.setPermission("PUB_NO");
						swaobjs2.setCreationUser(userId);
						swaobjs2.setModificationUser(userId);
						swaobjs2.setCompanyId(compId);
						swaobjs2.setCreationDate(date);
						swaobjs2.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs2, null);
						//D
						SwaResource swaobjs3 = new SwaResource();
						swaobjs3.setResourceId(receId);
						swaobjs3.setType(0);
						swaobjs3.setMode("D");
						swaobjs3.setPermission("PUB_NO");
						swaobjs3.setCreationUser(userId);
						swaobjs3.setModificationUser(userId);
						swaobjs3.setCompanyId(compId);
						swaobjs3.setCreationDate(date);
						swaobjs3.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs3, null);
					}
				}
			}
			try{
				SwManagerFactory.getInstance().getDesigntimeManager().deployPackage(userId, compId, packageId, 1);
				//SmartBpmsEngine.getInstance().getDeploymentManager().deployPackage(userId, compId, packageId, 1);
				buffer.append("<Result status=\"OK\"/>");
			}catch(Exception e){
				buffer.append("<Result status=\"OK\" deployCheck=\"FAIL\" />");
			}
	
		// 패키지 배치 해제
		} else if(method.equals("undeployPackage")) {
			String packageId = request.getParameter("packageId");
			SwManagerFactory.getInstance().getDesigntimeManager().undeployPackage(userId, packageId, 1);
			//SmartBpmsEngine.getInstance().getDeploymentManager().undeployPackage(userId, packageId, 1);
			buffer.append("<Result status=\"OK\"/>");
	
		// 패키지 로드
		} else if(method.equals("loadPackage")) {
			String packageId = request.getParameter("packageId");
			IPackageModel packageModel = rscMgr.retrievePackage(userId, packageId, 1);
			buffer.append(convert(packageModel));
	
		// 풀 패키지(프로세스, 폼 메타정보 포함) 로드
		} else if(method.equals("loadFullPackage")) {
			String packageId = request.getParameter("packageId");
			
			IPackageModel packageModel = rscMgr.retrievePackage(userId, packageId, 1);
			IProcessModel processModel = rscMgr.retrieveProcessByPackage(userId, packageId, 1);
			
			buffer.append("<Result status=\"OK\">");
			buffer.append("<fullPackage>");
			buffer.append(packageModel);
			
			if(processModel != null)
				buffer.append(processModel.toString());
			else
				buffer.append("<Process/>");
			buffer.append("<forms>");
			
			for(IFormModel form : rscMgr.findFormByPackage(userId, packageId, 1))
				buffer.append(form.toString());
			
			buffer.append("</forms>");
			buffer.append("</fullPackage>");
			buffer.append("</Result>");
			
		// 패키지에 폼 생성
		} else if(method.equals("createForm")) {
			String packageId = request.getParameter("packageId");
			String type = CommonUtil.toNull(request.getParameter("type"));
			if (type == null)
				type = IFormModel.TYPE_NONE;
			//String formName = request.getParameter("formName");
			String formName = new String(request.getParameter("formName").getBytes("ISO-8859-1"), "UTF-8");
			
			IFormModel formModel = rscMgr.createForm(userId, packageId, 1, type, formName);
			buffer.append(convert(formModel));
			
				// 패키지에 폼 복사
				} else if (method.equals("cloneForm")) {
			String formId = request.getParameter("formId");
			String toPkgId = request.getParameter("toPackageId");
			String newFormName = request.getParameter("newFormName");
			IFormModel form = rscMgr.cloneForm(userId, formId, 1, toPkgId, 1, newFormName);
			buffer.append(convert(form));
	
		// 패키지 복사
		} else if (method.equals("clonePackage")) {
			String categoryId = CommonUtil.toNull(request.getParameter("categoryId"));
			String packageId = CommonUtil.toNull(request.getParameter("packageId"));
			
			IPackageModel pkg = rscMgr.clonePackage(userId, categoryId, packageId, 1);
			
			buffer.append("<Result status=\"OK\">");
			buffer.append(pkg);
			buffer.append("</Result>");
			
		// 패키지에 프로세스 생성
		} else if (method.equals("createProcess")) {
			String packageId = request.getParameter("packageId");
			String prcName = request.getParameter("processName");
			IProcessModel prcModel = rscMgr.createProcess(userId, packageId, 1, prcName);
			buffer.append(convert(prcModel));
			
		// 패키지에 폼 생성
		} else if(method.equals("deleteForm")) {
			String formId = request.getParameter("formId");
			rscMgr.deleteForm(userId, formId, 1);			
			buffer.append("<Result status=\"OK\"/>");
			
		// 프로세스 삭제
		} else if(method.equals("deleteProcess")) {
			String prcId = request.getParameter("processId");
			rscMgr.deleteProcess(userId, prcId, 1);
			buffer.append("<Result status=\"OK\"/>");
	
		// 패키지 삭제
		} else if(method.equals("deletePackage")) {
			String packageId = request.getParameter("packageId");
			IPackageModel pkgInfo = SmartServerManager.getInstance().getResourceDesigntimeManager().retrieveLatestPackage(userId, packageId);
			String status = CommonUtil.toNull(pkgInfo.getStatus());
			if(status.equals(IPackageModel.STATUS_DEPLOYED)) {
				buffer.append("<Result status=\"DEPLOYED\"/>");
			} else {
				rscMgr.deletePackage(userId, packageId, 1);
				removeMenuItemsByPackageId(userId, packageId);
				buffer.append("<Result status=\"OK\"/>");
			}
			try {
				//StringBuffer filePath = new StringBuffer(SmartApi.swSystemImagesPath()).append("/workDef/").append(packageId);
				//FileUtil.deleteAll(filePath.toString());
			} catch (Exception e) {
				
			}
			
		// 패키지 생성
		} else if (method.equals("createPackage")) {
			String categoryId = request.getParameter("categoryId");
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			String desc = request.getParameter("desc");
			
			IPackageModel pkg = null;
			if (CommonUtil.isEmpty(type))
				pkg = rscMgr.createPackage(userId, categoryId, name, desc);
			else {
				pkg = rscMgr.createPackage(userId, categoryId, type, name, desc);
				pkg.setType(type);
			}
			
			buffer.append("<Result status=\"OK\">");
			buffer.append(pkg);
			buffer.append("</Result>");
			
		// 패키지 이름 및 설명 변경
		} else if(method.equals("renamePackage")) {
			String packageId = request.getParameter("packageId");
			String categoryId = CommonUtil.toNull(request.getParameter("categoryId"));
			String name = CommonUtil.toNull(request.getParameter("name"));
			String desc = CommonUtil.toNull(request.getParameter("desc"));
			String objId = CommonUtil.toNull(request.getParameter("objId"));
			
			IPackageModel pkg = rscMgr.retrievePackage(userId, packageId, 1);
			if (name != null)
				pkg.setName(name);
			if (desc != null)
				pkg.setDescription(desc);
			if (!CommonUtil.isEmpty(categoryId))
				pkg.setCategoryId(categoryId);
			rscMgr.updatePackage(userId, pkg);
			
			buffer.append("<Result status=\"OK\">");
			buffer.append(pkg);
			buffer.append("</Result>");
			
		// 모든 사용자를 찾는다.
		} else if(method.equals("findAllUsers")) {
			List<IOrgUserModel> userList = SmartServerManager.getInstance().getOrganManager().findUserByDept(userId, null);
			buffer.append(this.convertUser(userList));
			
		// 폼 매핑시 프로세스에 소속된 모든 폼 리스트
		} else if(method.equals("getProcessFormList")) {
			String processId = request.getParameter("processId");
			List<IFormModel> formList = SmartServerManager.getInstance().getResourceDesigntimeManager().findFormByProcess(userId, processId, 1);
			buffer.append(this.convert(formList));
			
		// 단위 업무 검색
		} else if(method.equals("searchSingleFormList")) {
			int pageCount = StringUtil.getIntValue(request.getParameter("pageCount"), 0);
			int recordCount = StringUtil.getIntValue(request.getParameter("recordCount"), 0);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put(FormFieldEnum.type.name(), IFormModel.TYPE_SINGLE);
			IFormModelList list = SmartServerManager.getInstance().getResourceDesigntimeManager().searchFormByCondition(userId, condition, pageCount, recordCount);
			buffer.append(list);
			
		// 패키지의 카테고리를 이동한다.
		} else if(method.equals("movePackageCategory")) {
			String toCategoryId = request.getParameter("toCategoryId");
			String packageId = request.getParameter("packageId");
			SmartServerManager.getInstance().getResourceRuntimeManager().doMovePackageCategory(userId, packageId, toCategoryId);
			buffer.append("<Result status=\"OK\"/>");
		// 최근 작업 패키지 목록
		} else if(method.equals("getRecentPackageList")) {
			Map lastPkgCond = new HashMap();
			lastPkgCond.put("modifier", userId);
			Map lastPkgOrder = new HashMap();
			lastPkgOrder.put("modifiedTime", "desc");
			IPackageModelList lastPkgModelList = SmartServerManager.getInstance().getResourceDesigntimeManager().searchPackageByCondition(userId, lastPkgCond, lastPkgOrder, 0, 10);
			buffer.append("<Result status=\"OK\">");
			if (lastPkgModelList != null)
			{
				List lastPkgList = lastPkgModelList.getPackageModelList();
				if (lastPkgList != null && !lastPkgList.isEmpty()) {
			for (Iterator lastPkgItr = lastPkgList.iterator(); lastPkgItr.hasNext();)
			{
				IPackageModel lastPkg = (IPackageModel)lastPkgItr.next();
				buffer.append(lastPkg);
			}
				}
			}
			buffer.append("</Result>");
		} else if(method.equals("getEventDays")) {
			throw new Exception("method : getEventDays - Not Include From V2");
		} else if(method.equals("getWorkCalendar")) {
			throw new Exception("method : getWorkCalendar - Not Include From V2");
		} else if(method.equals("getApprovalLineDefs")) {
			throw new Exception("method : getApprovalLineDefs - Not Include From V2");
		} else if(method.equals("retrieveRootCategory")) {
			CtgCategory category = SwManagerFactory.getInstance().getCtgManager().getCategory(userId, CtgCategory.CATEGORY_ROOT_NAME_PKG, IManager.LEVEL_LITE);
			buffer.append(convert(category));
		} else if(method.equals("retrieveParentCategory")) {
			throw new Exception("method : retrieveParentCategory - Not Include From V2");
		} else if(method.equals("retrieveCategory")) {
			throw new Exception("method : retrieveCategory - Not Include From V2");
		} else if(method.equals("retrieveChildrenByCategoryId")) {
			String categoryId = request.getParameter("categoryId");
			
			CtgCategoryCond cond = new CtgCategoryCond();
			if (CommonUtil.isEmpty(compId))
				throw new Exception("SmartApi_companyId is null.");
			cond.setCompanyId(compId);
			cond.setParentId(categoryId);

			Order orderObj = new Order();
			orderObj.setField("displayOrder");
			orderObj.setAsc(true);
			
			Order orderObj2 = new Order();
			orderObj2.setField("name");
			orderObj2.setAsc(true);
			
			Order[] orders = new Order[2];
			orders[0] = orderObj;
			orders[1] = orderObj2;
			cond.setOrders(orders);
			
			CtgCategory[] categoryList = SwManagerFactory.getInstance().getCtgManager().getCategorys(userId, cond, IManager.LEVEL_LITE);
			buffer.append(convert(categoryList));
		} else if(method.equals("retrievePackageByCategoryId")) {

			String categoryId = request.getParameter("categoryId");

			PkgPackageCond packageCond = new PkgPackageCond();
			//packageCond.setStatus("DEPLOYED");
			packageCond.setCategoryId(categoryId);
			packageCond.setOrders(new Order[] {new Order("name", true)});
			
			PkgPackage[] pkgs = SwManagerFactory.getInstance().getPkgManager().getPackages(userId, packageCond, null);
			for (PkgPackage pkg : pkgs) {
				if ("SINGLE".equals(pkg.getType()) && CommonUtil.isEmpty(pkg.getExtendedAttributeValue("formId"))) {
					SwfFormCond formCond = new SwfFormCond();
					formCond.setPackageId(pkg.getPackageId());
					SwfForm[] forms = SwManagerFactory.getInstance().getSwfManager().getForms(userId, formCond, null);
					if (!CommonUtil.isEmpty(forms))
						pkg.setExtendedAttributeValue("formId", forms[forms.length-1].getId());
				}
				
				// 카테고리 정보
				String catId = pkg.getCategoryId();
				if (catId == null)
					continue;
				CtgCategory cat = SwManagerFactory.getInstance().getCtgManager().getCategory(compId, userId, catId);
				if (cat == null)
					continue;
				CtgCategory superCat = getParentCategory(compId, userId, catId);
				if (superCat == null || superCat.getObjId().equals("_PKG_ROOT_")) {
					pkg.setExtendedAttributeValue("categoryName", cat.getName());
					continue;
				}
				pkg.setExtendedAttributeValue("categoryName", superCat.getName());
				pkg.setExtendedAttributeValue("groupName", cat.getName());
			}
			buffer.append(convert(pkgs));
			
			
		} else if(method.equals("deployGanttProcessContent")) {
			throw new Exception("method : deployGanttProcessContent - Not Include From V2");
		} else if(method.equals("webServiceList")) {

			
			
			
			String objId = request.getParameter("objId");
			String companyId = request.getParameter("companyId");
			
			SwManagerFactory factory = SwManagerFactory.getInstance();
			ISwcManager webMgr = factory.getSwcManager();
			SwcWebServiceCond cond = new SwcWebServiceCond();
			SwcWebService[] webService = null;
			
			if(objId != null) {
				cond.setObjId(objId);
				webService = webMgr.getWebServices(userId, cond, "all");	
			} else if(compId != null) {
				cond.setCompanyId(compId);
				webService = webMgr.getWebServices(userId, cond, "all");
			}
			
			StringBuffer buffers = new StringBuffer();
			StringBuffer inparmeter = new StringBuffer();
			StringBuffer outparmeter = new StringBuffer();
			
			if(webService != null) {
				
				buffer.append(" <Result status=\"OK\">");
				buffer.append(" <webServiceList size=\""+webService.length+"\"> ");
				
				for (int j=0; j<webService.length; j++) {
					String webcompanyId = webService[j].getCompanyId();
					String serviceAddress = webService[j].getWebServiceAddress();
					String serviceName = webService[j].getWebServiceName();
					String wsdlAddress = webService[j].getWsdlAddress();
					String portName = webService[j].getPortName();
					String webobjId = webService[j].getObjId();
					String opName = webService[j].getOperationName();
					String description = webService[j].getDescription();
					
					buffers.append(" <webService compId=\""+ webcompanyId +"\" objId=\""+webobjId+"\" webServiceName=\""+serviceName+"\" webServiceAddress=\""+serviceAddress+"\" wsdlAddress=\""+wsdlAddress+"\" portName=\""+portName+"\" operationName=\""+opName+"\"> ");
					buffers.append(" <description><![CDATA[ ");
					buffers.append(description);
					buffers.append(" ]]></description> ");	
					
					SwcWebServiceParameter[] params = webService[j].getSwcWebServiceParameters();
					
					int incount=0;
					int outcount=0;
					
					List count = new ArrayList();
					for(int u=0; u<params.length; u++) {
						String type = params[u].getType();
						if(type.equals("I")) {
							count.add(type);
						incount = count.size();
						}
					}			
					if(params != null) {					
						boolean inFirst = true;
						boolean outFirst = true;
						for(int i=0; i<params.length; i++) {
						String type = params[i].getType();
						
						if(type.equalsIgnoreCase("I")){
							String inputName = params[i].getParameterName();
							String inputType = params[i].getParameterType();
							String variable = params[i].getVariableName();
							if(inFirst){
								buffers.append("<webServiceInputParameters>");
							}
								buffers.append("<webServiceInputParameter inputName=\"" +inputName+"\" inputType=\""+inputType+"\" inputVariableName=\""+variable+"\">");
								buffers.append("</webServiceInputParameter>");
							
							if((incount-1) == i) {//0:1 //1:1
								buffers.append("</webServiceInputParameters>");
							}
							inFirst = false;	
						} else if(type.equalsIgnoreCase("O")) {
							String outputName = params[i].getParameterName();
							String outputType = params[i].getParameterType();
							String variable = params[i].getVariableName();
							if(outFirst){
								buffers.append("<webServiceOutputParameters>");
							}	
								buffers.append("<webServiceOutputParameter outputName=\"" +outputName+"\" outputType=\""+outputType+"\" outputVariableName=\""+variable+"\">");
								buffers.append("</webServiceOutputParameter>");	
							if(params.length-1 == i) {//4-1:3
								buffers.append("</webServiceOutputParameters>");
							}
							outFirst = false;
						}
							}
							buffers.append("</webService>");
						}
					}
				buffer.append(buffers.toString());
				buffer.append("</webServiceList>");
				buffer.append("</Result>");
			
			
			
			}
			
			
			
			
			
			
		} else if(method.equals("webAppServiceList") ) {
			throw new Exception("method : webAppServiceList - Not Include From V2");
		} else {
			// 에러 - 지원하지 않는 메소드
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
		LogFactory.getLog("builderService").error(buffer.toString());
	}
%><%= buffer.toString() %>