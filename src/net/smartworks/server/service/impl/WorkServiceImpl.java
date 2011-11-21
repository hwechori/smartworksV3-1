package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.smartworks.model.security.AccessPolicy;
import net.smartworks.model.security.EditPolicy;
import net.smartworks.model.security.WritePolicy;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.InformationWork;
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
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.service.IWorkService;
import net.smartworks.server.service.util.ModelConverter;
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
		
		SmartWorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.arrayToArray(pkgs);
		
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
			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_ALL);
			return (WorkCategoryInfo[])ModelConverter.arrayToArray(ctgs);
		
		} else {
			ctgCond.setParentId(categoryId);
			
			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setCompanyId(companyId);
			pkgCond.setCategoryId(categoryId);

			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_ALL);
			WorkInfo[] workCtgs = (WorkCategoryInfo[])ModelConverter.arrayToArray(ctgs);
			
			PkgPackage[] pkgs = getPkgManager().getPackages(userId, pkgCond, IManager.LEVEL_ALL);
			WorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.arrayToArray(pkgs);

			int workCtgsSize = workCtgs == null? 0 : workCtgs.length;
			int pkgPkgsSize = workPkgs == null? 0 : workPkgs.length;
			
			WorkInfo[] resultWork = new WorkInfo[workCtgsSize + pkgPkgsSize +  /*UI test*/ 2];
			
			//System.arraycopy(workCtgs, 0, resultWork, 0, workCtgsSize);  
			//System.arraycopy(pkgPkgs, 0, resultWork, workCtgsSize, pkgPkgsSize);
			
			List<WorkInfo> workList = new ArrayList<WorkInfo>();
			for (int i = 0; i < workCtgsSize; i++) {
				workList.add(workCtgs[i]);
			}
			for (int i = 0; i < pkgPkgsSize; i++) {
				workList.add(workPkgs[i]);
			}

// UI test용 코드
			workList.add(SmartTest.getInformationWorkInfo1());
			workList.add(SmartTest.getProcessWorkInfo1());
// UI test용 코드

			workList.toArray(resultWork);

			return resultWork;
		}

	}

	@Override
	public SmartWorkInfo[] searchWork(String companyId, String userId, String key) throws Exception {

		return getMyFavoriteWorks(companyId, userId);
	}

	@Override
	public Work getWorkById(String companyId, String userId, String workId) throws Exception {

		SwfFormCond swfCond = new SwfFormCond();
		swfCond.setPackageId(workId);
		SwfForm[] swfForms = getSwfManager().getForms(userId, swfCond, IManager.LEVEL_ALL);
		SwfForm swfForm = swfForms[0];
		String formId = swfForm.getId();

		List<SwdDomainFieldView> fieldViewList = getSwdManager().findDomainFieldViewList(formId);
		List<SwfFormFieldDef> formFieldDefList = getSwfManager().findFormFieldByForm(formId, true);
		HashMap<String, SwfFormFieldDef> hash = new HashMap<String, SwfFormFieldDef>();
		for (int idx = 0 ; idx < formFieldDefList.size() ; idx++) {
			SwfFormFieldDef fieldDef = (SwfFormFieldDef)formFieldDefList.get(idx);
			hash.put(fieldDef.getId(), fieldDef);
		}
		FormField[] formFields = null;
		if(fieldViewList != null) {
			int formFieldsSize = 0;
			for(SwdDomainFieldView dfv : fieldViewList) {
				SwfFormFieldDef fieldDef = (SwfFormFieldDef)hash.get(dfv.getFormFieldId());
				String viewingType = "";
				if(fieldDef != null) {
					viewingType = CommonUtil.toNotNull(fieldDef.getViewingType());
				}
				if(dfv.getDispOrder() > -1 && !viewingType.equals("richEditor") && !viewingType.equals("textArea") && !viewingType.equals("dataGrid")) {
					formFieldsSize++;
				}
			}
			formFields = new FormField[formFieldsSize];
			int i = 0;
			for(SwdDomainFieldView dfv : fieldViewList) {
				SwfFormFieldDef fieldDef = (SwfFormFieldDef)hash.get(dfv.getFormFieldId());
				String viewingType = "";
				if(fieldDef != null) {
					viewingType = CommonUtil.toNotNull(fieldDef.getViewingType());
				}
				FormField formField = new FormField();
				if(dfv.getDispOrder() > -1 && !viewingType.equals("richEditor") && !viewingType.equals("textArea") && !viewingType.equals("dataGrid")) {
					formField.setId(fieldDef.getId());
					formField.setName(fieldDef.getName());
					formField.setType(fieldDef.getType());
					formFields[i] = formField;
					i++;
				}
			}
		}

		Work resultwork = new InformationWork();
		((InformationWork)resultwork).setDisplayFields(formFields);

		/* -- 공개여부 --
		 공개 / 비공개*/

		/* -- 형태 --
		 블로그형 : v2.0 구조
		 위키형 : 누구나 수정 가능*/

		 /*-- 작성권한 --
		 전체 / 선택사용자*/

		AccessPolicy accessPolicy = new AccessPolicy();
		WritePolicy writePolicy = new WritePolicy();
		EditPolicy editPolicy = new EditPolicy();

		SwaResourceCond swaResourceCond = new SwaResourceCond();
		swaResourceCond.setResourceId(formId);
		SwaResource[] swaResources = getSwaManager().getResources(userId, swaResourceCond, IManager.LEVEL_ALL);

		for(SwaResource swaResource : swaResources) {
			if(CommonUtil.toNotNull(swaResource.getMode()).equals("R")) {
				if(swaResource.getPermission().equals("PUB_ALL"))
					accessPolicy.setLevel(AccessPolicy.LEVEL_DEFAULT);
				else if(swaResource.getPermission().equals("PUB_SELECT"))
					accessPolicy.setLevel(AccessPolicy.LEVEL_CUSTOM);
				else
					accessPolicy.setLevel(AccessPolicy.LEVEL_PRIVATE);
			} else if(CommonUtil.toNotNull(swaResource.getMode()).equals("W")) {
				if(swaResource.getPermission().equals("PUB_ALL"))
					writePolicy.setLevel(WritePolicy.LEVEL_DEFAULT);
				else
					writePolicy.setLevel(WritePolicy.LEVEL_CUSTOM);
			} else if(CommonUtil.toNotNull(swaResource.getMode()).equals("M")) {
				if(swaResource.getPermission().equals("PUB_ALL"))
					editPolicy.setLevel(EditPolicy.LEVEL_DEFAULT);
				else if(swaResource.getPermission().equals("PUB_SELECT"))
					editPolicy.setLevel(EditPolicy.LEVEL_BLOG);
				else
					editPolicy.setLevel(EditPolicy.LEVEL_BLOG);
			}
		}

		((SmartWork)resultwork).setAccessPolicy(accessPolicy);
		((SmartWork)resultwork).setWritePolicy(writePolicy);
		((SmartWork)resultwork).setEditPolicy(editPolicy);

		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setCompanyId(companyId);
		pkgCond.setPackageId(workId);

		PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_ALL);
		String id = pkg.getPackageId();
		String name = pkg.getName();
		String typeStr = pkg.getType();
		int type = typeStr.equals("PROCESS") ? SmartWork.TYPE_PROCESS : typeStr.equals("SINGLE") ? SmartWork.TYPE_INFORMATION : SmartWork.TYPE_SCHEDULE;
		String description = pkg.getDescription();
		resultwork.setId(id);
		resultwork.setName(name);
		resultwork.setType(type);
		resultwork.setDesc(description);

		String groupName = null;
		String groupId = null;
		String categoryName = null;
		String categoryId = pkg.getCategoryId();
		CtgCategoryCond ctgCond = new CtgCategoryCond();
		ctgCond.setObjId(categoryId);
		CtgCategory ctg = getCtgManager().getCategory(userId, ctgCond, IManager.LEVEL_ALL);
		categoryName = ctg.getName();
		if(!(ctg.getParentId()).equals("_PKG_ROOT_")) {
			CtgCategoryCond ctgCond2 = new CtgCategoryCond();
			ctgCond2.setObjId(ctg.getParentId());
			CtgCategory ctg2 = getCtgManager().getCategory(userId, ctgCond2, IManager.LEVEL_ALL);
			groupId = categoryId;
			groupName = categoryName;
			categoryId = ctg2.getObjId();
			categoryName = ctg2.getName();
		}

		WorkCategory myCategory = new WorkCategory();
		myCategory.setId(categoryId);
		myCategory.setName(categoryName);
		((SmartWork)resultwork).setMyCategory(myCategory);

		WorkCategory myGroup = new WorkCategory();
		myGroup.setId(groupId);
		myGroup.setName(groupName);
		((SmartWork)resultwork).setMyGroup(myGroup);

		return resultwork;
	}
}
