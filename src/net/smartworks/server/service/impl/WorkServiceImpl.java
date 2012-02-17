package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.filter.Condition;
import net.smartworks.model.filter.ConditionOperator;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.SortingField;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.report.ChartReport;
import net.smartworks.model.report.Data;
import net.smartworks.model.report.Report;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.InformationWork;
import net.smartworks.model.work.SmartForm;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.menuitem.manager.IItmManager;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItem;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemList;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemListCond;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdField;
import net.smartworks.server.engine.infowork.domain.model.SwdFieldCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.organization.model.SwoUserExtend;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.service.IWorkService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;
import net.smartworks.util.SmartUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements IWorkService {

	private ICtgManager getCtgManager() {
		return SwManagerFactory.getInstance().getCtgManager();
	}
	private IPkgManager getPkgManager() {
		return SwManagerFactory.getInstance().getPkgManager();
	}
	private ISwdManager getSwdManager() {
		return SwManagerFactory.getInstance().getSwdManager();
	}
	private ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}
	private IItmManager getItmManager() {
		return SwManagerFactory.getInstance().getItmManager();
	}
	private ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}
	private IDocFileManager getDocManager() {
		return SwManagerFactory.getInstance().getDocManager();
	}
	private ITskManager getTskManager() {
		return SwManagerFactory.getInstance().getTskManager();
	}

	private AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

	/*
	 * (non-Javadoc)
	 * @see net.smartworks.server.service.IWorkService#getMyFavoriteWorks(java.lang.String, java.lang.String)
	 * 사용자가 등록한 즐겨 찾기 업무를 리턴한다
	 */
	@Override
	public SmartWorkInfo[] getMyFavoriteWorks() throws Exception {

		try{
			User user = SmartUtil.getCurrentUser();
			if (CommonUtil.isEmpty(user.getCompanyId()) || CommonUtil.isEmpty(user.getId()))
				return null;
			
			ItmMenuItemListCond itemListCond = new ItmMenuItemListCond();
			itemListCond.setCompanyId(user.getCompanyId());
			itemListCond.setUserId(user.getId());
			ItmMenuItemList itmList = getItmManager().getMenuItemList(user.getId(), itemListCond, IManager.LEVEL_ALL);
	
			String[] packageIdArray = null;
			if(itmList != null) {
				ItmMenuItem[] items = itmList.getMenuItems();
				if(items != null) {
					packageIdArray = new String[items.length];
					for (int i = 0; i < items.length; i++) {
						ItmMenuItem item = items[i];
						if(item != null) {
							String packageId = item.getPackageId();
							packageIdArray[i] = packageId;
						}
					}
				}
	
				PkgPackageCond pkgCond = new PkgPackageCond();
				pkgCond.setCompanyId(user.getCompanyId());
				pkgCond.setPackageIdIns(packageIdArray);
				PkgPackage[] pkgs = getPkgManager().getPackages(user.getId(), pkgCond, IManager.LEVEL_ALL);
	
				SmartWorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.getSmartWorkInfoArrayByPkgPackageArray(pkgs);
				
				return workPkgs;
			}
			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public WorkInfo[] getMyAllWorksByCategoryId(String categoryId) throws Exception {

		try{
			//categoryId 가 null 이라면 root 카테고리 밑의 1 level 의 카테고리를 리턴한다
			//categoryId 가 넘어오면 카테고리안에 속한 2 level 카테고리(group) 와 work(package)를 리턴한다
	
			User user = SmartUtil.getCurrentUser();
			CtgCategoryCond ctgCond = new CtgCategoryCond();
			ctgCond.setCompanyId(user.getCompanyId());
			
			if (CommonUtil.isEmpty(categoryId)) {
				//1 level category
				ctgCond.setParentId(CtgCategory.ROOTCTGID);
				CtgCategory[] ctgs = getCtgManager().getCategorys(user.getId(), ctgCond, IManager.LEVEL_LITE);
				return (WorkCategoryInfo[])ModelConverter.getWorkCategoryInfoArrayByCtgCategoryArray(ctgs);
			
			} else {
				ctgCond.setParentId(categoryId);
				
				PkgPackageCond pkgCond = new PkgPackageCond();
				pkgCond.setCompanyId(user.getCompanyId());
				pkgCond.setCategoryId(categoryId);
				pkgCond.setStatus("DEPLOYED");
	
				CtgCategory[] ctgs = getCtgManager().getCategorys(user.getId(), ctgCond, IManager.LEVEL_LITE);
				WorkInfo[] workCtgs = (WorkCategoryInfo[])ModelConverter.getWorkCategoryInfoArrayByCtgCategoryArray(ctgs);
				
				PkgPackage[] pkgs = getPkgManager().getPackages(user.getId(), pkgCond, IManager.LEVEL_LITE);
				WorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.getSmartWorkInfoArrayByPkgPackageArray(pkgs);
	
				int workCtgsSize = workCtgs == null? 0 : workCtgs.length;
				int pkgPkgsSize = workPkgs == null? 0 : workPkgs.length;
				
				WorkInfo[] resultWork = new WorkInfo[workCtgsSize + pkgPkgsSize];
				
				//System.arraycopy(workCtgs, 0, resultWork, 0, workCtgsSize);  
				//System.arraycopy(pkgPkgs, 0, resultWork, workCtgsSize, pkgPkgsSize);
				
				List<WorkInfo> workList = new ArrayList<WorkInfo>();
				for (int i = 0; i < workCtgsSize; i++) {
					workList.add(workCtgs[i]);
				}
				for (int i = 0; i < pkgPkgsSize; i++) {
					workList.add(workPkgs[i]);
				}
	
				workList.toArray(resultWork);
	
				return resultWork;
			}
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public WorkInfo[] getAllWorksByCategoryId(String categoryId) throws Exception {

		try{
			//categoryId 가 null 이라면 root 카테고리 밑의 1 level 의 카테고리를 리턴한다
			//categoryId 가 넘어오면 카테고리안에 속한 2 level 카테고리(group) 와 work(package)를 리턴한다
	
			User user = SmartUtil.getCurrentUser();
			CtgCategoryCond ctgCond = new CtgCategoryCond();
			ctgCond.setCompanyId(user.getCompanyId());
			
			if (CommonUtil.isEmpty(categoryId)) {
				//1 level category
				ctgCond.setParentId(CtgCategory.ROOTCTGID);
				CtgCategory[] ctgs = getCtgManager().getCategorys(user.getId(), ctgCond, IManager.LEVEL_LITE);
				return (WorkCategoryInfo[])ModelConverter.getWorkCategoryInfoArrayByCtgCategoryArray(ctgs);
			
			} else {
				ctgCond.setParentId(categoryId);
				
				PkgPackageCond pkgCond = new PkgPackageCond();
				pkgCond.setCompanyId(user.getCompanyId());
				pkgCond.setCategoryId(categoryId);
				//pkgCond.setStatus("DEPLOYED");
	
				CtgCategory[] ctgs = getCtgManager().getCategorys(user.getId(), ctgCond, IManager.LEVEL_LITE);
				WorkInfo[] workCtgs = (WorkCategoryInfo[])ModelConverter.getWorkCategoryInfoArrayByCtgCategoryArray(ctgs);
				
				PkgPackage[] pkgs = getPkgManager().getPackages(user.getId(), pkgCond, IManager.LEVEL_LITE);
				WorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.getSmartWorkInfoArrayByPkgPackageArray(pkgs);
	
				int workCtgsSize = workCtgs == null? 0 : workCtgs.length;
				int pkgPkgsSize = workPkgs == null? 0 : workPkgs.length;
				
				WorkInfo[] resultWork = new WorkInfo[workCtgsSize + pkgPkgsSize];
				
				//System.arraycopy(workCtgs, 0, resultWork, 0, workCtgsSize);  
				//System.arraycopy(pkgPkgs, 0, resultWork, workCtgsSize, pkgPkgsSize);
				
				List<WorkInfo> workList = new ArrayList<WorkInfo>();
				for (int i = 0; i < workCtgsSize; i++) {
					workList.add(workCtgs[i]);
				}
				for (int i = 0; i < pkgPkgsSize; i++) {
					workList.add(workPkgs[i]);
				}
	
				workList.toArray(resultWork);
	
				return resultWork;
			}
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public SmartWorkInfo[] searchWork(String key) throws Exception {

		try{
			if (CommonUtil.isEmpty(key))
				return null;
	
			User user = SmartUtil.getCurrentUser();
			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setCompanyId(user.getCompanyId());
			pkgCond.setNameLike(key);
			PkgPackage[] pkgs = getPkgManager().getPackages(user.getId(), pkgCond, IManager.LEVEL_ALL);
			if (pkgs == null)
				return null;
			SmartWorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.getSmartWorkInfoArrayByPkgPackageArray(pkgs);
			
			return workPkgs;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	public String getWorkIdByFormId(String formId) throws Exception {

		try{
			String workId = "";
			User user = SmartUtil.getCurrentUser();
	
			SwfFormCond swfCond = new SwfFormCond();
			swfCond.setCompanyId(user.getCompanyId());
			swfCond.setId(formId);
	
			SwfForm swfForm = getSwfManager().getForms(user.getId(), swfCond, IManager.LEVEL_LITE)[0];
	
			workId = swfForm.getPackageId();
	
			return workId;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	public Work getWorkById(String workId) throws Exception {

		try{
			if (CommonUtil.isEmpty(workId))
				return null;
	
			User user = SmartUtil.getCurrentUser();
			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setCompanyId(user.getCompanyId());
			pkgCond.setPackageId(workId);
	
			PkgPackage pkg = getPkgManager().getPackage(user.getId(), pkgCond, IManager.LEVEL_LITE);
			
			if (pkg.getType().equalsIgnoreCase("PROCESS") || pkg.getType().equalsIgnoreCase("GANTT")) {
				return getProcessWorkById(user.getCompanyId(), user.getId(), workId);
			} else {
				return getInfortmationWorkById(user.getCompanyId(), user.getId(), workId);
			}
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;
			// Exception Handling Required			
		}
	}

	public Work getProcessWorkById(String companyId, String userId, String workId) throws Exception {

		try{
			if (CommonUtil.isEmpty(workId))
				return null;
	
			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setCompanyId(companyId);
			pkgCond.setPackageId(workId);
	
			PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_LITE);
			
			return ModelConverter.getProcessWorkByPkgPackage(userId, null, pkg);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	public Work getInfortmationWorkById(String companyId, String userId, String workId) throws Exception {

		try {
			InformationWork resultwork = new InformationWork();

			SwfFormCond swfCond = new SwfFormCond();
			swfCond.setPackageId(workId);
			SwfForm[] swfForms = getSwfManager().getForms(userId, swfCond, IManager.LEVEL_ALL);
			if (CommonUtil.isEmpty(swfForms))
				return null;
	
			String formId = swfForms[0].getId();
	
			SwfField[] swfFields = swfForms[0].getFields();
	
			List<FormField> resultList = new ArrayList<FormField>();
			SwdField[] swdViewFields = getSwdManager().getViewFieldList(workId, formId);

			if(swdViewFields != null) {
				for(SwdField swdViewField : swdViewFields) {
					for(SwfField swfField : swfFields) {
						String formatType = swfField.getFormat().getType();
						if(swdViewField.getDisplayOrder() > -1 && !formatType.equals("richEditor") && !formatType.equals("imageBox") && !formatType.equals("dataGrid")) {
							if(swdViewField.getFormFieldId().equals(swfField.getId())) {
								FormField formField = new FormField();
								formField.setId(swdViewField.getFormFieldId());
								formField.setName(swdViewField.getFormFieldName());
								formField.setType(formatType);
								formField.setDisplayOrder(swdViewField.getDisplayOrder());
								resultList.add(formField);
							}
						}
					}
				}
	
				FormField[] formFields = new FormField[resultList.size()];
				resultList.toArray(formFields);
	

				resultwork.setDisplayFields(formFields);
			}
	
			//권한설정
			ModelConverter.setPolicyToWork(resultwork, formId);

			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setCompanyId(companyId);
			pkgCond.setPackageId(workId);

			PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_LITE);

			//상세필터
			resultwork.setSearchFilters(ModelConverter.getSearchFilterInfoByPkgPackage(userId, pkg));

			if(pkg != null) {
				String name = pkg.getName();
				String typeStr = pkg.getType();
				int type = typeStr.equals("PROCESS") ? SmartWork.TYPE_PROCESS : typeStr.equals("SINGLE") ? SmartWork.TYPE_INFORMATION : SmartWork.TYPE_SCHEDULE;
				String description = pkg.getDescription();

				resultwork.setId(workId);
				resultwork.setName(name);
				resultwork.setType(type);
				resultwork.setDesc(description);
				resultwork.setCreater(ModelConverter.getUserByUserId(pkg.getCreationUser()));
				resultwork.setCreatedDate(new LocalDate(pkg.getCreationDate().getTime()));
				resultwork.setLastModifier(ModelConverter.getUserByUserId(pkg.getModificationUser()));
				resultwork.setLastModifiedDate(new LocalDate(pkg.getModificationDate().getTime()));

				String packageStatus = pkg.getStatus();
				boolean isRunningPackage = false;
				boolean isEditingPackage = false;
				User editingUser = null;
				LocalDate editingStartDate = null;
				if(packageStatus.equalsIgnoreCase("DEPLOYED")) {
					isRunningPackage = true;
					isEditingPackage = false; 
				} else if(packageStatus.equalsIgnoreCase("CHECKED-OUT")) {
					isRunningPackage = false;
					isEditingPackage = true;
					editingUser = ModelConverter.getUserByUserId(pkg.getModificationUser());
					editingStartDate = new LocalDate(pkg.getModificationDate().getTime());
				} else if(packageStatus.equalsIgnoreCase("CHECKED-IN")) {
					isRunningPackage = false;
					isEditingPackage = false;
				}
				resultwork.setRunning(isRunningPackage);
				resultwork.setEditing(isEditingPackage);
				resultwork.setEditingUser(editingUser);
				resultwork.setEditingStartDate(editingStartDate);

				Map<String, WorkCategory> pkgCtgInfoMap = ModelConverter.getPkgCtgMapByPackage(pkg);

				if(pkgCtgInfoMap != null) {
					resultwork.setMyCategory(pkgCtgInfoMap.get("category"));
					resultwork.setMyGroup(pkgCtgInfoMap.get("group"));
				}
			}

			SwdDomainCond swdDomainCond = new SwdDomainCond();
			swdDomainCond.setFormId(formId);
			SwdDomain swdDomain = getSwdManager().getDomain(userId, swdDomainCond, IManager.LEVEL_LITE); 

			if(swdDomain != null) {
				SwdFieldCond swdFieldCond = new SwdFieldCond();
				swdFieldCond.setDomainObjId(swdDomain.getObjId());
				Order[] order = new Order[1];
				order[0] = new Order();
				order[0].setField("displayOrder");
				order[0].setAsc(true);
				swdFieldCond.setOrders(order);
				SwdField[] swdFields = getSwdManager().getFields("", swdFieldCond, IManager.LEVEL_LITE);

				if(swdFields != null) {
					List<FormField> formFieldList = new ArrayList<FormField>();
					for(SwdField swdField : swdFields) {
						for(SwfField swfField : swfFields) {
							String formatType = swfField.getFormat().getType();
							if(swdField.getFormFieldId().equals(swfField.getId())) {
								FormField formField = new FormField();
								formField.setId(swdField.getFormFieldId());
								formField.setName(swdField.getFormFieldName());
								formField.setType(formatType);
								formField.setDisplayOrder(swdField.getDisplayOrder());
								formFieldList.add(formField);
							}
						}
					}

					FormField[] resultFormFields = new FormField[formFieldList.size()];
					formFieldList.toArray(resultFormFields);

					SmartForm smFrom = ModelConverter.getSmartFormBySwfFrom(null, swfForms[0]);
					if(smFrom != null) {
						smFrom.setFields(resultFormFields);
						resultwork.setForm(smFrom);
					}
				}
			}
			return resultwork;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}	

	@Override
	public Report getReportById(String reportId) throws Exception {

		try{
			ChartReport[] defaultInformationCharts = ChartReport.DEFAULT_CHARTS_INFORMATION;
			for(ChartReport report : defaultInformationCharts){
				if(report.getId().equals(reportId)) return report;
			}
			ChartReport[] defaultProcessCharts = ChartReport.DEFAULT_CHARTS_PROCESS;
			for(ChartReport report : defaultProcessCharts){
				if(report.getId().equals(reportId)) return report;
			}		
			return SmartTest.getReportById();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public SearchFilter getSearchFilterById(String filterId) throws Exception {

		try{
			User user = SmartUtil.getCurrentUser();
			if(filterId.equals(SearchFilter.FILTER_ALL_INSTANCES)) return SearchFilter.getAllInstancesFilter();
			if(filterId.equals(SearchFilter.FILTER_MY_INSTANCES)) return SearchFilter.getMyInstancesFilter(ModelConverter.getUserByUserId(user.getId()));
			if(filterId.equals(SearchFilter.FILTER_RECENT_INSTANCES)) return SearchFilter.getRecentInstancesFilter();
			if(filterId.equals(SearchFilter.FILTER_MY_RECENT_INSTANCES)) return SearchFilter.getMyRecentInstancesFilter(ModelConverter.getUserByUserId(user.getId()));
			if(filterId.equals(SearchFilter.FILTER_MY_RUNNING_INSTANCES)) return SearchFilter.getMyRunningInstancesFilter(ModelConverter.getUserByUserId(user.getId()));
	
			return SmartTest.getSearchFilterById();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	public List<SwfFormFieldDef> findFormFieldByForm(String formId, boolean deployedCondition) throws Exception {
		try{
			return getSwfManager().findFormFieldByForm(formId, deployedCondition);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public Data getReportData(HttpServletRequest request) throws Exception {
		try{
			return SmartTest.getReportData();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public String getFormXml(String formId, String workId) throws Exception {

		try{
			User user = SmartUtil.getCurrentUser();
			SwfFormCond swfFormCond = new SwfFormCond();
			swfFormCond.setCompanyId(user.getCompanyId());
	
			if(!CommonUtil.isEmpty(formId))
				swfFormCond.setId(formId);
			else
				swfFormCond.setPackageId(workId);
	
			SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_ALL);
			if(swfForms != null)
				return swfForms[0].getObjString();
			else
				return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public void setMyProfile(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try {
			Map<String, Object> frmMyProfileSetting = (Map<String, Object>)requestBody.get("frmMyProfileSetting");
	
			Set<String> keySet = frmMyProfileSetting.keySet();
			Iterator<String> itr = keySet.iterator();
	
			List<Map<String, String>> files = null;
			String groupId = null;
			String txtUserProfileUserId = null;
			String pwUserProfilePW = null;
			String selUserProfileLocale = null;
			String selUserProfileTimeZone = null;
			String txtUserProfileEmail = null;
			String txtUserProfilePhoneNo = null;
			String txtUserProfileCellNo = null;
			String profileFileId = null;
			String profileFileName = null;
			String txtUserProfilePicture = null;
			
			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				Object fieldValue = frmMyProfileSetting.get(fieldId);
				if (fieldValue instanceof LinkedHashMap) {
					Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
					groupId = (String)valueMap.get("groupId");
					if(!CommonUtil.isEmpty(groupId)) {
						files = (ArrayList<Map<String,String>>)valueMap.get("files");
					}
				} else if(fieldValue instanceof String) {
					if(fieldId.equals("txtUserProfileUserId"))
						txtUserProfileUserId = (String)frmMyProfileSetting.get("txtUserProfileUserId");
					else if(fieldId.equals("pwUserProfilePW"))
						pwUserProfilePW = (String)frmMyProfileSetting.get("pwUserProfilePW");
						//pwUserProfilePW = DigestUtils.md5Hex(pwUserProfilePW);
					else if(fieldId.equals("selUserProfileLocale"))
						selUserProfileLocale = (String)frmMyProfileSetting.get("selUserProfileLocale");
					else if(fieldId.equals("selUserProfileTimeZone"))
						selUserProfileTimeZone = (String)frmMyProfileSetting.get("selUserProfileTimeZone");
					else if(fieldId.equals("txtUserProfileEmail"))
						txtUserProfileEmail = (String)frmMyProfileSetting.get("txtUserProfileEmail");
					else if(fieldId.equals("txtUserProfilePhoneNo"))
						txtUserProfilePhoneNo = (String)frmMyProfileSetting.get("txtUserProfilePhoneNo");
					else if(fieldId.equals("txtUserProfileCellNo"))
						txtUserProfileCellNo = (String)frmMyProfileSetting.get("txtUserProfileCellNo");
				}
			}
	
			SwoUser user = getSwoManager().getUser(txtUserProfileUserId, txtUserProfileUserId, null);
	
			if(!files.isEmpty()) {
				for(int i=0; i < files.subList(0, files.size()).size(); i++) {
					Map<String, String> file = files.get(i);
					profileFileId = file.get("fileId");
					profileFileName = file.get("fileName");
					txtUserProfilePicture = getDocManager().insertProfilesFile(profileFileId, profileFileName, txtUserProfileUserId);
					user.setPicture(txtUserProfilePicture);
				}
			}
	
			//pwUserProfilePW = DigestUtils.md5Hex(pwUserProfilePW); -- md5 password 암호화
			user.setPassword(pwUserProfilePW);
			user.setLocale(selUserProfileLocale);
			user.setTimeZone(selUserProfileTimeZone);
			user.setEmail(txtUserProfileEmail);
			user.setExtensionNo(txtUserProfilePhoneNo);
			user.setMobileNo(txtUserProfileCellNo);
			try {
				getSwoManager().setUser(txtUserProfileUserId, user, null);
				UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getId(), user.getPassword());
		        Authentication authentication = authenticationManager.authenticate(authRequest);
		        SecurityContext securityContext = new SecurityContextImpl();
		        securityContext.setAuthentication(authentication);
		        SecurityContextHolder.setContext(securityContext);
		        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
		        getSwoManager().getUserExtend(txtUserProfileUserId, txtUserProfileUserId, false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public CommunityInfo[] getAllComsByDepartmentId(String departmentId, boolean departmentOnly) throws Exception {

		try{
			User cUser = SmartUtil.getCurrentUser();
			if(CommonUtil.isEmpty(departmentId)) {
				departmentId = cUser.getCompanyId();
			}
	
			SwoUserExtend[] swoUserExtends = getSwoManager().getAllComsByDepartmentId(departmentId, departmentOnly);
	
			List<CommunityInfo> resultList = new ArrayList<CommunityInfo>();
			for(SwoUserExtend swoUserExtend : swoUserExtends) {
				String type = swoUserExtend.getType();
				if(!departmentOnly) {
					if(type.equals("u")) {
						UserInfo userInfo = new UserInfo();
						userInfo.setId(swoUserExtend.getId());
						userInfo.setName(swoUserExtend.getName());
						userInfo.setPosition(swoUserExtend.getPosition());
						userInfo.setRole(swoUserExtend.getRoleId().equals("DEPT LEADER") ? User.USER_ROLE_LEADER : User.USER_ROLE_MEMBER);
						userInfo.setSmallPictureName(swoUserExtend.getPictureName());
						resultList.add(userInfo);
					} else {
						DepartmentInfo departmentInfo = new DepartmentInfo();
						departmentInfo.setId(swoUserExtend.getId());
						departmentInfo.setName(swoUserExtend.getName());
						departmentInfo.setDesc(swoUserExtend.getDescription());
						resultList.add(departmentInfo);
					}
				} else {
					DepartmentInfo departmentInfo = new DepartmentInfo();
					departmentInfo.setId(swoUserExtend.getId());
					departmentInfo.setName(swoUserExtend.getName());
					departmentInfo.setDesc(swoUserExtend.getDescription());
					resultList.add(departmentInfo);
				}
			}
			CommunityInfo[] communityInfos = new CommunityInfo[resultList.size()];
			resultList.toArray(communityInfos);
	
			return communityInfos;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public SwdRecord getRecord(HttpServletRequest request) throws Exception {

		try {
			String workId = request.getParameter("workId");
			String recordId = request.getParameter("recordId");
			String taskInstId = request.getParameter("taskInstId");

			SwdRecord swdRecord = null;
			SwfFormCond swfFormCond = new SwfFormCond();
			swfFormCond.setPackageId(workId);
			SwfForm[] swfForms = null;
			String formId = null;

			if(recordId != null) {
				swfForms = getSwfManager().getForms("", swfFormCond, IManager.LEVEL_ALL);
				formId = swfForms[0].getId();
				SwdRecordCond swdRecordCond = new SwdRecordCond();
				swdRecordCond.setRecordId(recordId);
				swdRecordCond.setFormId(formId);
				swdRecord = getSwdManager().getRecord("", swdRecordCond, IManager.LEVEL_ALL);
			} else if(taskInstId != null) {
				TskTaskCond tskTaskCond = new TskTaskCond();
				tskTaskCond.setObjId(taskInstId);
				TskTask[] tskTasks = getTskManager().getTasks("", tskTaskCond, null);
				formId = tskTasks[0].getForm();
				String tskDocument = tskTasks[0].getDocument();
				swdRecord = (SwdRecord)SwdRecord.toObject(tskDocument);
				swfFormCond.setId(formId);
				swfForms = getSwfManager().getForms("", swfFormCond, IManager.LEVEL_ALL);
			}

			SwfField[] swfFields = swfForms[0].getFields();

			SwdDataField[] swdDataFields = swdRecord.getDataFields();
			for(SwdDataField swdDataField : swdDataFields) {
				for(SwfField swfField : swfFields) {
					if(swdDataField.getId().equals(swfField.getId())) {
						String formatType = swfField.getFormat().getType();
						String value = swdDataField.getValue();
						String refRecordId = swdDataField.getRefRecordId();
						List<Map<String, String>> resultUsers = null;
						if(formatType.equals(FormField.TYPE_USER)) {
							if(value != null && refRecordId != null) {
								String[] values = value.split(";");
								String[] refRecordIds = refRecordId.split(";");
								resultUsers = new ArrayList<Map<String,String>>();
								if(values.length > 0 && refRecordIds.length > 0) {
									for(int j=0; j<values.length; j++) {
										Map<String, String> map = new LinkedHashMap<String, String>();
										map.put("userId", refRecordIds[j]);
										map.put("longName", values[j]);
										resultUsers.add(map);
									}
								} else {
									Map<String, String> map = new LinkedHashMap<String, String>();
									map.put("userId", refRecordId);
									map.put("longName", value);
									resultUsers.add(map);
								}
							}
							swdDataField.setUsers(resultUsers);
						} else if(formatType.equals(FormField.TYPE_DATE)) {
							if(value != null) {
								try {
									LocalDate localDate = LocalDate.convertGMTSimpleStringToLocalDate(value);
									if(localDate != null)
										value = LocalDate.convertGMTSimpleStringToLocalDate(value).toLocalDateSimpleString();
								} catch (Exception e) {
								}
							}
						} else if(formatType.equals(FormField.TYPE_TIME)) {
							if(value != null) {
								try {
									LocalDate localDate = LocalDate.convertGMTTimeStringToLocalDate(value);
									if(localDate != null)
										value = LocalDate.convertGMTTimeStringToLocalDate(value).toLocalTimeShortString();
								} catch (Exception e) {
								}
							}
						} else if(formatType.equals(FormField.TYPE_DATETIME)) {
							if(value != null) {
								try {
									LocalDate localDate = LocalDate.convertGMTStringToLocalDate(value);
									if(localDate != null)
										value = LocalDate.convertGMTStringToLocalDate(value).toLocalDateTimeSimpleString();
								} catch (Exception e) {
								}
							}
						}
						swdDataField.setValue(value);
					}
				}
			}
	
			return swdRecord;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RequestParams setInstanceListParams(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
			RequestParams requestParams = new RequestParams();
	
			Map<String, Object> frmSearchInstance = (Map<String, Object>)requestBody.get("frmSearchInstance");
			if(frmSearchInstance != null) {
				String txtSearchInstance = (String)frmSearchInstance.get("txtSearchInstance");
				requestParams.setSearchKey(txtSearchInstance);
			}
	
			Map<String, Object> frmIworkFilterName = (Map<String, Object>)requestBody.get("frmIworkFilterName");
			if(frmIworkFilterName != null){
				String selFilterName = (String)frmIworkFilterName.get("selFilterName");
				requestParams.setFilterId(selFilterName);
			}
	
			Map<String, Object> frmSortingField = (Map<String, Object>)requestBody.get("frmSortingField");
			if(frmSortingField != null){
				String hdnSortingFieldId = (String)frmSortingField.get("hdnSortingFieldId");
				String hdnSortingIsAscending = (String)frmSortingField.get("hdnSortingIsAscending");
				SortingField sortingField = new SortingField();
				sortingField.setFieldId(hdnSortingFieldId);
				sortingField.setAscending(Boolean.parseBoolean(hdnSortingIsAscending));
				requestParams.setSortingField(sortingField);
			}

			Map<String, Object> frmInstanceListPaging = (Map<String, Object>)requestBody.get("frmInstanceListPaging");
			Map<String, Object> frmWorkHourListPaging = (Map<String, Object>)requestBody.get("frmWorkHourListPaging");
			Map<String, Object> frmCompanyEventListPaging = (Map<String, Object>)requestBody.get("frmCompanyEventListPaging");
			Map<String, Object> frmApprovalLineListPaging = (Map<String, Object>)requestBody.get("frmApprovalLineListPaging");
			Map<String, Object> frmWebServiceListPaging = (Map<String, Object>)requestBody.get("frmWebServiceListPaging");
			Map<String, Object> frmExternalFormListPaging = (Map<String, Object>)requestBody.get("frmExternalFormListPaging");

			Map<String, Object> existListPaging = new LinkedHashMap<String, Object>();

			if(frmInstanceListPaging != null)
				existListPaging = frmInstanceListPaging;
			else if(frmWorkHourListPaging != null)
				existListPaging = frmWorkHourListPaging;
			else if(frmCompanyEventListPaging != null)
				existListPaging = frmCompanyEventListPaging;
			else if(frmApprovalLineListPaging != null)
				existListPaging = frmApprovalLineListPaging;
			else if(frmWebServiceListPaging != null)
				existListPaging = frmWebServiceListPaging;
			else if(frmExternalFormListPaging != null)
				existListPaging = frmExternalFormListPaging;

			String hdnCurrentPage = (String)existListPaging.get("hdnCurrentPage");
			String selPageSize = (String)existListPaging.get("selPageSize");
			boolean hdnNext10 = Boolean.parseBoolean((String)existListPaging.get("hdnNext10"));
			boolean hdnNextEnd = Boolean.parseBoolean((String)existListPaging.get("hdnNextEnd"));
			boolean hdnPrev10 = Boolean.parseBoolean((String)existListPaging.get("hdnPrev10"));
			boolean hdnPrevEnd = Boolean.parseBoolean((String)existListPaging.get("hdnPrevEnd"));
			if(hdnCurrentPage != null)
				requestParams.setCurrentPage(Integer.parseInt(hdnCurrentPage));
			if(selPageSize != null)
				requestParams.setPageSize(Integer.parseInt(selPageSize));
			if(hdnNext10)
				requestParams.setPagingAction(RequestParams.PAGING_ACTION_NEXT10);
			else if(hdnNextEnd)
				requestParams.setPagingAction(RequestParams.PAGING_ACTION_NEXTEND);
			else if(hdnPrev10)
				requestParams.setPagingAction(RequestParams.PAGING_ACTION_PREV10);
			else if(hdnPrevEnd)
				requestParams.setPagingAction(RequestParams.PAGING_ACTION_PREVEND);

			/*Map<String, Object> frmWorkHourListPaging = (Map<String, Object>)requestBody.get("frmWorkHourListPaging");
			if(frmWorkHourListPaging != null) {
				String hdnCurrentPage = (String)frmWorkHourListPaging.get("hdnCurrentPage");
				String selPageSize = (String)frmWorkHourListPaging.get("selPageSize");
				boolean hdnNext10 = Boolean.parseBoolean((String)frmWorkHourListPaging.get("hdnNext10"));
				boolean hdnNextEnd = Boolean.parseBoolean((String)frmWorkHourListPaging.get("hdnNextEnd"));
				boolean hdnPrev10 = Boolean.parseBoolean((String)frmWorkHourListPaging.get("hdnPrev10"));
				boolean hdnPrevEnd = Boolean.parseBoolean((String)frmWorkHourListPaging.get("hdnPrevEnd"));
				if(hdnCurrentPage != null)
					requestParams.setCurrentPage(Integer.parseInt(hdnCurrentPage));
				if(selPageSize != null)
					requestParams.setPageSize(Integer.parseInt(selPageSize));
				if(hdnNext10)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_NEXT10);
				else if(hdnNextEnd)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_NEXTEND);
				else if(hdnPrev10)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_PREV10);
				else if(hdnPrevEnd)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_PREVEND);
			}

			Map<String, Object> frmCompanyEventListPaging = (Map<String, Object>)requestBody.get("frmCompanyEventListPaging");
			if(frmCompanyEventListPaging != null) {
				String hdnCurrentPage = (String)frmCompanyEventListPaging.get("hdnCurrentPage");
				String selPageSize = (String)frmCompanyEventListPaging.get("selPageSize");
				boolean hdnNext10 = Boolean.parseBoolean((String)frmCompanyEventListPaging.get("hdnNext10"));
				boolean hdnNextEnd = Boolean.parseBoolean((String)frmCompanyEventListPaging.get("hdnNextEnd"));
				boolean hdnPrev10 = Boolean.parseBoolean((String)frmCompanyEventListPaging.get("hdnPrev10"));
				boolean hdnPrevEnd = Boolean.parseBoolean((String)frmCompanyEventListPaging.get("hdnPrevEnd"));
				if(hdnCurrentPage != null)
					requestParams.setCurrentPage(Integer.parseInt(hdnCurrentPage));
				if(selPageSize != null)
					requestParams.setPageSize(Integer.parseInt(selPageSize));
				if(hdnNext10)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_NEXT10);
				else if(hdnNextEnd)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_NEXTEND);
				else if(hdnPrev10)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_PREV10);
				else if(hdnPrevEnd)
					requestParams.setPagingAction(RequestParams.PAGING_ACTION_PREVEND);
			}*/

			List<Map<String, Object>> frmSearchFilters = (ArrayList<Map<String, Object>>)requestBody.get("frmSearchFilters");
	
			if(frmSearchFilters != null)
				requestParams.setFilterId(null);
	
			String selFilterLeftOperand = null;
			String selFilterOperator = null;
			String txtFilterStringOperand = null;
			String txtFilterDateOperand = null;
			String txtFilterTimeOperand = null;
			String txtFiltetRightOperandType = null;
			String rightOperand = null;
	
			List<Condition> conditionList = new ArrayList<Condition>();
	
			if(frmSearchFilters != null) {
				for(int i = 0; i <  frmSearchFilters.subList(0, frmSearchFilters.size()).size(); i++) {
					Map<String, Object> valueMap = frmSearchFilters.get(i);
					Condition condition = new Condition();
					selFilterLeftOperand = (String)valueMap.get("selFilterLeftOperand");
					selFilterOperator = (String)valueMap.get("selFilterOperator");
					txtFilterStringOperand = (String)valueMap.get("txtFilterStringOperand");
					txtFilterDateOperand = (String)valueMap.get("txtFilterDateOperand");
					txtFilterTimeOperand = (String)valueMap.get("txtFilterTimeOperand");

	
					if(selFilterOperator.equals(ConditionOperator.RECENT_DAYS.getId())) {
						rightOperand = this.getRecentSomeDays(5);
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.TODAY.getId())) {
						rightOperand = this.getRecentSomeDays(1);
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.THIS_WEEK.getId())) {
						rightOperand = this.getThisWeek();
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.THIS_MONTH.getId())) {
						rightOperand = this.getRecentSomeMonths(1);
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.THIS_QUARTER.getId())) {
						rightOperand = this.getThisQuarter();
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.THIS_HALF_YEAR.getId())) {
						rightOperand = this.getThisHalfYear();
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.THIS_YEAR.getId())) {
						rightOperand = this.getThisYear();
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.RECENT_SOME_DAYS.getId())) {
						rightOperand = this.getRecentSomeDays(Integer.parseInt(txtFilterTimeOperand));
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(selFilterOperator.equals(ConditionOperator.RECENT_SOME_MONTHS.getId())) {
						rightOperand = this.getRecentSomeMonths(Integer.parseInt(txtFilterTimeOperand));
						selFilterOperator = ConditionOperator.GREATER_EQUAL.getId();
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					} else if(txtFilterStringOperand != null) {
						rightOperand = txtFilterStringOperand;
						txtFiltetRightOperandType = Filter.OPERANDTYPE_STRING;
					} else if(txtFilterDateOperand != null){
						rightOperand = txtFilterDateOperand;
						txtFiltetRightOperandType = Filter.OPERANDTYPE_DATE;
					}

					condition.setRightOperand(rightOperand);
					condition.setLeftOperand(new FormField(selFilterLeftOperand, null, txtFiltetRightOperandType));
					condition.setOperator(selFilterOperator);
					conditionList.add(condition);
				}
	
				Condition[] conditions = new Condition[conditionList.size()];
				conditionList.toArray(conditions);
	
				SearchFilter searchFilter = new SearchFilter();
				searchFilter.setConditions(conditions);
				requestParams.setSearchFilter(searchFilter);
			}
	
			return requestParams;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}
	@Override
	public void addAFavoriteWork(String workId) throws Exception {

		try{
			User cUser = SmartUtil.getCurrentUser();
			String companyId = cUser.getCompanyId();
			String userId = cUser.getId();
	
			ItmMenuItemListCond menuItemListCond = new ItmMenuItemListCond();
			menuItemListCond.setUserId(userId);
	
			ItmMenuItemList menuItemList = getItmManager().getMenuItemList(userId, menuItemListCond, IManager.LEVEL_LITE);
	
			PkgPackageCond packageCond = new PkgPackageCond();
			packageCond.setPackageId(workId);
			packageCond.setCompanyId(companyId);
			PkgPackage pkg = getPkgManager().getPackage(userId, packageCond, IManager.LEVEL_LITE);
			String groupId = "";
			String categoryId = "";
			String packageType = "";
			String packageName = "";
			if(pkg != null) {
				groupId = pkg.getObjId();
				categoryId = pkg.getCategoryId();
				packageType = pkg.getType();
				packageName = pkg.getName();
			}
	
			SwfFormCond formCond = new SwfFormCond();
			formCond.setCompanyId(companyId);
			formCond.setPackageId(workId);
			SwfForm[] forms = getSwfManager().getForms(userId, formCond, IManager.LEVEL_LITE);
			String formId = "";
			if(forms != null) {
				formId = forms[0].getId();
			}
	
			ItmMenuItemList newMenuItemList = new ItmMenuItemList();
			newMenuItemList.setCompanyId(companyId);
			newMenuItemList.setUserId(userId);
	
			List<ItmMenuItem> itmMenuItemList = new ArrayList<ItmMenuItem>();
			ItmMenuItem menuItem = new ItmMenuItem();
			menuItem.setCompanyId(companyId);
			menuItem.setPackageId(workId);
			menuItem.setName(packageName);
			menuItem.setGroupId(groupId);
			menuItem.setCategoryId(categoryId);
			menuItem.setPackageType(packageType);
			menuItem.setFormId(formId);
			String objId = "";
			int itmSeq = 0;
			if(menuItemList != null) {
				objId = menuItemList.getObjId();
				itmSeq = getItmManager().getMaxItmSeq(userId) + 1;
			}
			menuItem.setObjId(objId);
	
			itmMenuItemList.add(menuItem);
	
			ItmMenuItem[] menuItems = new ItmMenuItem[itmMenuItemList.size()];
			itmMenuItemList.toArray(menuItems);
	
			newMenuItemList.setMenuItems(menuItems);
	
			if(menuItemList == null) {
				getItmManager().createMenuItemList(userId, newMenuItemList);
			} else {
				menuItem.setObjId(objId);
				menuItem.setItmSeq(itmSeq);
				getItmManager().addMenuItem(userId, menuItem);
			}
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void removeAFavoriteWork(String workId) throws Exception {

		try{
			User cUser = SmartUtil.getCurrentUser();
			String userId = cUser.getId();
			getItmManager().removeMenuItem(userId, workId);
	
	/*		ItmMenuItemListCond itmMenuItemListCond = new ItmMenuItemListCond();
			itmMenuItemListCond.setUserId(userId);
			ItmMenuItem itmMenuItem = new ItmMenuItem();
			itmMenuItem.setPackageId(workId);
			itmMenuItemListCond.setMenuItems(new ItmMenuItem[]{itmMenuItem});
	
			getItmManager().removeMenuItemList(userId, itmMenuItemListCond);*/
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	public String getRecentSomeDays(int someDays) throws Exception {
		return new LocalDate(new LocalDate().getTime() - LocalDate.ONE_DAY*(someDays-1)).toGMTSimpleDateString();
	}

	public String getRecentSomeMonths(int someMonths) throws Exception {
		Calendar calendar = Calendar.getInstance();
		int thisMonth = new LocalDate().getMonth();
		calendar.set(Calendar.MONTH, thisMonth - (someMonths-1));
		return new LocalDate(calendar.getTime().getTime()).toGMTSimpleDateString(); 
	}

	public String getThisWeek() throws Exception {
		Calendar calendar = Calendar.getInstance();
		int thisDayOfWeek = new LocalDate().getFirstDayOfWeek();
		calendar.set(Calendar.DAY_OF_WEEK, thisDayOfWeek-1);
		return new LocalDate(calendar.getTime().getTime()).toGMTSimpleDateString(); 	
	}

	public String getThisYear() throws Exception {
		Calendar calendar = Calendar.getInstance();
		int thisYear = new LocalDate().getYear();
		calendar.set(Calendar.YEAR, thisYear);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return new LocalDate(calendar.getTime().getTime()).toGMTSimpleDateString(); 	
	}

	public String getThisQuarter() throws Exception {
		Calendar calendar = Calendar.getInstance();
		int thisMonth = new LocalDate().getMonth();
		int thisQuarter = thisMonth / 3;
		if(thisQuarter == 0)
			thisMonth = 0;
		else if(thisQuarter == 1)
			thisMonth = 3;
		else if(thisQuarter == 2)
			thisMonth = 6;
		else if(thisQuarter == 3)
			thisMonth = 9;

		calendar.set(Calendar.MONTH, thisMonth);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		return new LocalDate(calendar.getTime().getTime()).toGMTSimpleDateString(); 
	}

	public String getThisHalfYear() throws Exception {
		Calendar calendar = Calendar.getInstance();
		int thisMonth = new LocalDate().getMonth();
		int thisHalfYear = thisMonth / 6;
		if(thisHalfYear == 0)
			thisMonth = 0;
		else if(thisHalfYear == 1)
			thisMonth = 6;

		calendar.set(Calendar.MONTH, thisMonth);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return new LocalDate(calendar.getTime().getTime()).toGMTSimpleDateString(); 

	}

}
