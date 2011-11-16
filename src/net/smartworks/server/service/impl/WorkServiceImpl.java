package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyFavoriteWorks(java.lang.
	 * String)
	 */
	@Override
	public SmartWork[] getMyFavoriteWorks(String companyId, String userId) throws Exception {

		return new SmartWork[] { SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork1(),
				SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(),
				SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork1(), SmartTest.getSmartWork2(),
				SmartTest.getSmartWork3() };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyWorkCategories(java.lang
	 * .String)
	 */
//	@Override
//	public WorkCategory[] getMyWorkCategories(String companyId, String userId) throws Exception {
//		if (CommonUtil.isEmpty(userId))
//			return null;
//		
//		CtgCategoryCond cond = new CtgCategoryCond();
//		cond.setCompanyId(companyId);
//		
//		CtgCategory[] ctgs = getCtgManager().getCategorys(userId, cond, IManager.LEVEL_ALL);
//		
//		return (WorkCategory[])ModelConverter.arrayToArray(ctgs);
//		
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyAllWorksByCategoryId(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public Work[] getMyAllWorksByCategoryId(String companyId, String userId, String categoryId) throws Exception {

		//categoryId 가 null 이라면 root 카테고리 밑의 1 level 의 카테고리를 리턴한다
		//categoryId 가 넘어오면 카테고리안에 속한 2 level 카테고리(group) 와 work(package)를 리턴한다

		CtgCategoryCond ctgCond = new CtgCategoryCond();
		ctgCond.setCompanyId(companyId);
		
		if (CommonUtil.isEmpty(categoryId)) {
			//1 level category
			ctgCond.setParentId(CtgCategory.ROOTCTGID);
			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_ALL);
			return (WorkCategory[])ModelConverter.arrayToArray(ctgs);
		
		} else {
			ctgCond.setParentId(categoryId);
			
			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setCompanyId(companyId);
			pkgCond.setCategoryId(categoryId);

			CtgCategory[] ctgs = getCtgManager().getCategorys(userId, ctgCond, IManager.LEVEL_ALL);
			Work[] workCtgs = (WorkCategory[])ModelConverter.arrayToArray(ctgs);
			
			PkgPackage[] pkgs = getPkgManager().getPackages(userId, pkgCond, IManager.LEVEL_ALL);
			Work[] workPkgs = (SmartWork[])ModelConverter.arrayToArray(pkgs);

			int workCtgsSize = workCtgs == null? 0 : workCtgs.length;
			int pkgPkgsSize = workPkgs == null? 0 : workPkgs.length;
			
			Work[] resultWork = new Work[workCtgsSize + pkgPkgsSize + /* UI test*/ 1];
			
			//System.arraycopy(workCtgs, 0, resultWork, 0, workCtgsSize);  
			//System.arraycopy(pkgPkgs, 0, resultWork, workCtgsSize, pkgPkgsSize);
			
			List<Work> workList = new ArrayList<Work>();
			for (int i = 0; i < workCtgsSize; i++) {
				workList.add(workCtgs[i]);
			}
			for (int i = 0; i < pkgPkgsSize; i++) {
				workList.add(workPkgs[i]);
			}

// UI test용 코드
workList.add(SmartTest.getInformationWork1());
// UI test용 코드

			workList.toArray(resultWork);

			return resultWork;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyAllWorksByGroupId(java.lang
	 * .String, java.lang.String)
	 */
//	@Override
//	public SmartWork[] getMyAllWorksByGroupId(String groupId) throws Exception {
//
//		return new SmartWork[] { SmartTest.getSmartWork7(), SmartTest.getSmartWork8(), SmartTest.getSmartWork9() };
//	}
//
	@Override
	public SmartWork[] searchWork(String companyId, String userId, String key) throws Exception {

		return getMyFavoriteWorks(companyId, userId);
	}

	@Override
	public Work getWorkById(String companyId, String workId) throws Exception {
		Work[] works = new Work[] { SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork4(),
				SmartTest.getSmartWork5(), SmartTest.getSmartWork6(), SmartTest.getSmartWork7(), SmartTest.getSmartWork8(), SmartTest.getSmartWork9() };
		for (Work work : works) {
			if (work.getId().equals(workId))
				return work;
		}
		return null;
	}
}
