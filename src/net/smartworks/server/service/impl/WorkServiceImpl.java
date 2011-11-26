package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.smartworks.model.community.User;
import net.smartworks.model.report.Report;
import net.smartworks.model.security.AccessPolicy;
import net.smartworks.model.security.EditPolicy;
import net.smartworks.model.security.WritePolicy;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.InformationWork;
import net.smartworks.model.work.ProcessWork;
import net.smartworks.model.work.SmartForm;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.authority.manager.ISwaManager;
import net.smartworks.server.engine.authority.model.SwaResource;
import net.smartworks.server.engine.authority.model.SwaResourceCond;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.menuitem.manager.IItmManager;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItem;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemList;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemListCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainFieldView;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.organization.model.SwoUserCond;
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

		List<SwdDomainFieldView> fieldViewList = getSwdManager().findDomainFieldViewList(formId);
		List<SwfFormFieldDef> formFieldDefList = getSwfManager().findFormFieldByForm(formId, true);
		
		Set<String> fieldIdSet = new HashSet<String>();
		for (int i = 0; i < fieldViewList.size(); i++) {
			SwdDomainFieldView dfv = fieldViewList.get(i);
			if (dfv.getDispOrder() > -1)
				fieldIdSet.add(dfv.getFormFieldId());
		}
		List<FormField> resultList = new ArrayList<FormField>();
		for (int i = 0; i < formFieldDefList.size(); i++) {
			SwfFormFieldDef sfd = formFieldDefList.get(i);
			String formFieldId = sfd.getId();
			String viewingType = sfd.getViewingType();
			
			if (fieldIdSet.contains(formFieldId) && !viewingType.equals("richEditor") && !viewingType.equals("textArea") && !viewingType.equals("dataGrid")) {
				FormField formField = new FormField();
				formField.setId(formFieldId);
				formField.setName(sfd.getName());
				formField.setType(sfd.getType());
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
		resultwork.setSearchFilters(ModelConverter.getSearchFilterArrayByPkgPackage(userId, pkg));
		
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
		
		//set form
		SmartForm smFrom = ModelConverter.getSmartFormBySwfFrom(null, swfForms[0]);
		resultwork.setForm(smFrom);
		
		pkg.getModificationUser();
		
		return resultwork;
	}	
	@Override
	public Report[] getReportsByWorkId(String companyId, String userId, String workId) throws Exception {
		return SmartTest.getReportsByWorkId();
	}
}
