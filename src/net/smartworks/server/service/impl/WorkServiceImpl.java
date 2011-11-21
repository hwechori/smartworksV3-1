package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
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
	private IItmManager getItmManager() {
		return SwManagerFactory.getInstance().getItmManager();
	}
	private ITskManager getTskManager() {
		return SwManagerFactory.getInstance().getTskManager();
	}
	private ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.smartworks.server.service.IWorkService#getMyRecentlyExecutedWork(java.lang.String, java.lang.String)
	 * 사용자가 최근에 처리한 업무 10개를 리턴한다
	 */
	@Override
	public WorkInfo[] getMyRecentlyExecutedWork(String companyId, String userId) throws Exception {
		if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(userId))
			return null;

		TskTaskCond tskCond = new TskTaskCond();
		tskCond.setAssignee(userId);
		tskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
		tskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
		tskCond.setOrders(new Order[]{new Order("executionDate" , false)});
		tskCond.setPageNo(0);
		tskCond.setPageSize(10);
		
		TskTask[] tsks = getTskManager().getTasks(userId, tskCond, IManager.LEVEL_ALL);
		
		List<String> packageIdList = new ArrayList<String>();
		for (int i = 0; i < tsks.length; i++) {
			
			TskTask tsk = tsks[i];
			String formId = tsk.getForm();
			
			SwfForm form = getSwfManager().getForm(userId, formId);
			if (form == null || form.getPackageId() == null)
				continue;
			packageIdList.add(form.getPackageId());
		}
		String[] packageIdArray = new String[packageIdList.size()];
		
		packageIdList.toArray(packageIdArray);

		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setCompanyId(companyId);
		pkgCond.setPackageIdIns(packageIdArray);
		PkgPackage[] pkgs = getPkgManager().getPackages(userId, pkgCond, IManager.LEVEL_ALL);
		
		SmartWorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.arrayToArray(pkgs);
		
		return workPkgs;
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

		if(categoryId == null || categoryId == ""){
			return SmartTest.getMyWorkCategories();
		}else{
			return SmartTest.getMyWorksByCategory();
		}
		//categoryId 가 null 이라면 root 카테고리 밑의 1 level 의 카테고리를 리턴한다
		//categoryId 가 넘어오면 카테고리안에 속한 2 level 카테고리(group) 와 work(package)를 리턴한다

////		CtgCategoryCond ctgCond = new CtgCategoryCond();
////		ctgCond.setCompanyId(companyId);
////		
////		if (CommonUtil.isEmpty(categoryId)) {
////			//1 level category
////			ctgCond.setParentId(CtgCategory.ROOTCTGID);
////			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_ALL);
////			return (WorkCategoryInfo[])ModelConverter.arrayToArray(ctgs);
////		
////		} else {
////			ctgCond.setParentId(categoryId);
////			
////			PkgPackageCond pkgCond = new PkgPackageCond();
////			pkgCond.setCompanyId(companyId);
////			pkgCond.setCategoryId(categoryId);
////
////			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_ALL);
////			WorkInfo[] workCtgs = (WorkCategoryInfo[])ModelConverter.arrayToArray(ctgs);
////			
////			PkgPackage[] pkgs = getPkgManager().getPackages(userId, pkgCond, IManager.LEVEL_ALL);
////			WorkInfo[] workPkgs = (SmartWorkInfo[])ModelConverter.arrayToArray(pkgs);
////
////			int workCtgsSize = workCtgs == null? 0 : workCtgs.length;
////			int pkgPkgsSize = workPkgs == null? 0 : workPkgs.length;
////			
////			WorkInfo[] resultWork = new WorkInfo[workCtgsSize + pkgPkgsSize + /* UI test*/ 2];
////			
////			//System.arraycopy(workCtgs, 0, resultWork, 0, workCtgsSize);  
////			//System.arraycopy(pkgPkgs, 0, resultWork, workCtgsSize, pkgPkgsSize);
////			
////			List<WorkInfo> workList = new ArrayList<WorkInfo>();
////			for (int i = 0; i < workCtgsSize; i++) {
////				workList.add(workCtgs[i]);
////			}
////			for (int i = 0; i < pkgPkgsSize; i++) {
////				workList.add(workPkgs[i]);
////			}
////
////// UI test용 코드
////			workList.add(SmartTest.getInformationWorkInfo1());
////			workList.add(SmartTest.getProcessWorkInfo1());
////// UI test용 코드
////
////			workList.toArray(resultWork);
////
////			return resultWork;
//		}
	}

	@Override
	public SmartWorkInfo[] searchWork(String companyId, String userId, String key) throws Exception {

		return getMyFavoriteWorks(companyId, userId);
	}

	@Override
	public Work getWorkById(String companyId, String userId, String workId) throws Exception {
		return SmartTest.getWorkById(workId);
	}
}
