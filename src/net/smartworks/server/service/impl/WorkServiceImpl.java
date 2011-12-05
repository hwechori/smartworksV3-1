package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.filter.SearchFilter;
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
import net.smartworks.server.engine.authority.manager.ISwaManager;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.menuitem.manager.IItmManager;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItem;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemList;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemListCond;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdField;
import net.smartworks.server.engine.infowork.domain.model.SwdFieldCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.service.IWorkService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;

import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements IWorkService {

	private ICtgManager getCtgManager() {
		return SwManagerFactory.getInstance().getCtgManager();
	}
	private IPkgManager getPkgManager() {
		return SwManagerFactory.getInstance().getPkgManager();
	}
	private ISwaManager getSwaManager() {
		return SwManagerFactory.getInstance().getSwaManager();
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
	private ITskManager getTskManager() {
		return SwManagerFactory.getInstance().getTskManager();
	}
	private ISwoManager getSwokManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}

	/*
	 * (non-Javadoc)
	 * @see net.smartworks.server.service.IWorkService#getMyFavoriteWorks(java.lang.String, java.lang.String)
	 * 사용자가 등록한 즐겨 찾기 업무를 리턴한다
	 */
	@Override
	public SmartWorkInfo[] getMyFavoriteWorks(String companyId, String userId) throws Exception {
		if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(userId))
			return null;
		
		ItmMenuItemListCond itemListCond = new ItmMenuItemListCond();
		itemListCond.setCompanyId(companyId);
		itemListCond.setUserId(userId);
		ItmMenuItemList itmList = getItmManager().getMenuItemList(userId, itemListCond, IManager.LEVEL_ALL);
		if (itmList == null)
			return null;

		ItmMenuItem[] items = itmList.getMenuItems();
		
		if (CommonUtil.isEmpty(items)) 
			return null;
		
		String[] packageIdArray = new String[items.length];
		for (int i = 0; i < items.length; i++) {
			ItmMenuItem item = items[i];
			String packageId = item.getPackageId();
			packageIdArray[i] = packageId;
		}
		
		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setCompanyId(companyId);
		pkgCond.setPackageIdIns(packageIdArray);
		PkgPackage[] pkgs = getPkgManager().getPackages(userId, pkgCond, IManager.LEVEL_ALL);
		
		SmartWorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.getSmartWorkInfoArrayByPkgPackageArray(pkgs);
		
		return workPkgs;
	}

	@Override
	public WorkInfo[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception {

		//categoryId 가 null 이라면 root 카테고리 밑의 1 level 의 카테고리를 리턴한다
		//categoryId 가 넘어오면 카테고리안에 속한 2 level 카테고리(group) 와 work(package)를 리턴한다

		CtgCategoryCond ctgCond = new CtgCategoryCond();
		ctgCond.setCompanyId(companyId);
		
		if (CommonUtil.isEmpty(categoryId)) {
			//1 level category
			ctgCond.setParentId(CtgCategory.ROOTCTGID);
			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_LITE);
			return (WorkCategoryInfo[])ModelConverter.getWorkCategoryInfoArrayByCtgCategoryArray(ctgs);
		
		} else {
			ctgCond.setParentId(categoryId);
			
			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setCompanyId(companyId);
			pkgCond.setCategoryId(categoryId);
			pkgCond.setStatus("DEPLOYED");

			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_LITE);
			WorkInfo[] workCtgs = (WorkCategoryInfo[])ModelConverter.getWorkCategoryInfoArrayByCtgCategoryArray(ctgs);
			
			PkgPackage[] pkgs = getPkgManager().getPackages(userId, pkgCond, IManager.LEVEL_LITE);
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

	}

	@Override
	public SmartWorkInfo[] searchWork(String companyId, String userId, String key) throws Exception {

		return getMyFavoriteWorks(companyId, userId);
	}

	public Work getWorkById(String companyId, String userId, String workId) throws Exception {
		if (CommonUtil.isEmpty(workId))
			return null;

		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setCompanyId(companyId);
		pkgCond.setPackageId(workId);

		PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_LITE);
		
		if (pkg.getType().equalsIgnoreCase("PROCESS") || pkg.getType().equalsIgnoreCase("GANTT")) {
			return getProcessWorkById(companyId, userId, workId);
		} else {
			return getInfortmationWorkById(companyId, userId, workId);
		}
	}
	
	public Work getProcessWorkById(String companyId, String userId, String workId) throws Exception {
		
		if (CommonUtil.isEmpty(workId))
			return null;

		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setCompanyId(companyId);
		pkgCond.setPackageId(workId);

		PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_LITE);
		
		return ModelConverter.getProcessWorkByPkgPackage(userId, null, pkg);

	}
	public Work getInfortmationWorkById(String companyId, String userId, String workId) throws Exception {
		
		SwfFormCond swfCond = new SwfFormCond();
		swfCond.setPackageId(workId);
		SwfForm[] swfForms = getSwfManager().getForms(userId, swfCond, IManager.LEVEL_LITE);
		if (CommonUtil.isEmpty(swfForms))
			return null;
		
		String formId = swfForms[0].getId();

/*		List<SwdDomainFieldView> fieldViewList = getSwdManager().findDomainFieldViewList(formId);
		List<SwfFormFieldDef> formFieldDefList = getSwfManager().findFormFieldByForm(formId, true);
		
		List<String> fieldIdList = new ArrayList<String>();
		for (int i = 0; i < fieldViewList.size(); i++) {
			SwdDomainFieldView dfv = fieldViewList.get(i);
			if (dfv.getDispOrder() > -1)
				fieldIdList.add(dfv.getFormFieldId());
		}
		List<FormField> resultList = new ArrayList<FormField>();
		for (int i = 0; i < formFieldDefList.size(); i++) {
			SwfFormFieldDef sfd = formFieldDefList.get(i);
			String formFieldId = sfd.getId();
			String viewingType = sfd.getViewingType();
			
			if (fieldIdList.contains(formFieldId) && !viewingType.equals("richEditor") && !viewingType.equals("textArea") && !viewingType.equals("dataGrid")) {
				FormField formField = new FormField();
				formField.setId(formFieldId);
				formField.setName(sfd.getName());
				formField.setType(sfd.getType());
				resultList.add(formField);
			}
		}*/

		List<FormField> resultList = new ArrayList<FormField>();
		SwdField[] swdViewFields = getSwdManager().getViewFieldList(workId, formId);
		for(SwdField swdViewField : swdViewFields) {
			if(swdViewField.getDisplayOrder() > -1) {
				FormField formField = new FormField();
				formField.setId(swdViewField.getFormFieldId());
				formField.setName(swdViewField.getFormFieldName());
				formField.setType(swdViewField.getFormFieldType());
				formField.setDisplayOrder(swdViewField.getDisplayOrder());
				resultList.add(formField);
			}
		}

		FormField[] formFields = new FormField[resultList.size()];
		resultList.toArray(formFields);

		InformationWork resultwork = new InformationWork();
		resultwork.setDisplayFields(formFields);

		//권한설정
		ModelConverter.setPolicyToWork(resultwork, formId);

		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setCompanyId(companyId);
		pkgCond.setPackageId(workId);

		PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_LITE);

		//상세필터
		resultwork.setSearchFilters(ModelConverter.getSearchFilterInfoByPkgPackage(userId, pkg));
		
		String name = pkg.getName();
		String typeStr = pkg.getType();
		int type = typeStr.equals("PROCESS") ? SmartWork.TYPE_PROCESS : typeStr.equals("SINGLE") ? SmartWork.TYPE_INFORMATION : SmartWork.TYPE_SCHEDULE;
		String description = pkg.getDescription();

		resultwork.setId(workId);
		resultwork.setName(name);
		resultwork.setType(type);
		resultwork.setDesc(description);
		resultwork.setLastModifier(ModelConverter.getUserByUserId(pkg.getModificationUser()));
		resultwork.setLastModifiedDate(new LocalDate(pkg.getModificationDate().getTime()));

		Map<String, WorkCategory> pkgCtgInfoMap = ModelConverter.getPkgCtgMapByPackage(pkg);

		resultwork.setMyCategory(pkgCtgInfoMap.get("category"));
		resultwork.setMyGroup(pkgCtgInfoMap.get("group"));

		SwdDomainCond swdDomainCond = new SwdDomainCond();
		swdDomainCond.setFormId(formId);
		SwdDomain swdDomain = getSwdManager().getDomain(userId, swdDomainCond, IManager.LEVEL_LITE); 

		SwdFieldCond swdFieldCond = new SwdFieldCond();
		swdFieldCond.setDomainObjId(swdDomain.getObjId());
		Order[] order = new Order[1];
		order[0] = new Order();
		order[0].setField("displayOrder");
		order[0].setAsc(true);
		swdFieldCond.setOrders(order);
		SwdField[] swdFields = getSwdManager().getFields("", swdFieldCond, IManager.LEVEL_LITE);

		List<FormField> formFieldList = new ArrayList<FormField>();
		for(SwdField swdField : swdFields) {
			FormField formField = new FormField();
			formField.setId(swdField.getFormFieldId());
			formField.setName(swdField.getFormFieldName());
			formField.setType(swdField.getFormFieldType());
			formField.setDisplayOrder(swdField.getDisplayOrder());
			formFieldList.add(formField);
		}

		FormField[] resultFormFields = new FormField[formFieldList.size()];
		formFieldList.toArray(resultFormFields);

		SmartForm smFrom = ModelConverter.getSmartFormBySwfFrom(null, swfForms[0]);
		smFrom.setFields(resultFormFields);
		resultwork.setForm(smFrom);

		return resultwork;
	}	

	@Override
	public Report getReportById(String companyId, String userId, String reportId) throws Exception {
		// TODO Auto-generated method stub
		ChartReport[] defaultInformationCharts = ChartReport.DEFAULT_CHARTS_INFORMATION;
		for(ChartReport report : defaultInformationCharts){
			if(report.getId().equals(reportId)) return report;
		}
		ChartReport[] defaultProcessCharts = ChartReport.DEFAULT_CHARTS_PROCESS;
		for(ChartReport report : defaultProcessCharts){
			if(report.getId().equals(reportId)) return report;
		}		
		return SmartTest.getReportById();
	}

	@Override
	public SearchFilter getSearchFilterById(String companyId, String userId, String filterId) throws Exception {
		if(filterId.equals(SearchFilter.FILTER_ALL_INSTANCES)) return null;
		if(filterId.equals(SearchFilter.FILTER_MY_INSTANCES)) return SearchFilter.getMyInstancesFilter(ModelConverter.getUserByUserId(userId));
		if(filterId.equals(SearchFilter.FILTER_RECENT_INSTANCES)) return SearchFilter.getRecentInstancesFilter();
		if(filterId.equals(SearchFilter.FILTER_MY_RECENT_INSTANCES)) return SearchFilter.getMyRecentInstancesFilter(ModelConverter.getUserByUserId(userId));
		if(filterId.equals(SearchFilter.FILTER_MY_RUNNING_INSTANCES)) return SearchFilter.getMyRunningInstancesFilter(ModelConverter.getUserByUserId(userId));

		return SmartTest.getSearchFilterById();
	}

	public List<SwfFormFieldDef> findFormFieldByForm(String formId, boolean deployedCondition) throws Exception {
		return getSwfManager().findFormFieldByForm(formId, deployedCondition);
	}

	@Override
	public Data getReportData(HttpServletRequest request) throws Exception {
		return SmartTest.getReportData();
	}
}
