package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.model.work.AccessPolicy;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.server.engine.authority.manager.ISwaManager;
import net.smartworks.server.engine.authority.model.SwaResource;
import net.smartworks.server.engine.authority.model.SwaResourceCond;
import net.smartworks.server.engine.authority.model.SwaUser;
import net.smartworks.server.engine.authority.model.SwaUserCond;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.service.IWorkService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.server.service.util.SmartCommonConstants;
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
	private ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyFavoriteWorks(java.lang.
	 * String)
	 */
	@Override
	public SmartWork[] getMyFavoriteWorks() throws Exception {

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
			
			Work[] resultWork = new Work[workCtgsSize + pkgPkgsSize];
			
			//System.arraycopy(workCtgs, 0, resultWork, 0, workCtgsSize);  
			//System.arraycopy(pkgPkgs, 0, resultWork, workCtgsSize, pkgPkgsSize);
			
			List<Work> workList = new ArrayList<Work>();
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
	public SmartWork[] searchWork(String key) throws Exception {

		return getMyFavoriteWorks();
	}

	@Override
	public Work getWorkById(String companyId, String userId, String workId) throws Exception {
/*		Work[] works = new Work[] { SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork4(),
				SmartTest.getSmartWork5(), SmartTest.getSmartWork6(), SmartTest.getSmartWork7(), SmartTest.getSmartWork8(), SmartTest.getSmartWork9() };
		for (Work work : works) {
			if (work.getId().equals(workId))
				return work;
		}
		return null;*/
		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setCompanyId(companyId);
		pkgCond.setPackageId(workId);

		SwfFormCond swfCond = new SwfFormCond();
		swfCond.setPackageId(workId);
		SwfForm[] swfForms = getSwfManager().getForms(userId, swfCond, null);
		SwfForm swfForm = swfForms[0];
		String formId = swfForm.getId();

		SwaResourceCond swaResourceCond = new SwaResourceCond();
		swaResourceCond.setResourceId(formId);
		SwaResource[] swaResources = getSwaManager().getResources(userId, swaResourceCond, null);
		
		
/*		SwaUserCond swaUserCond = null;
		SwaUser[] swaUsers = null;

		if(swaResource.getPermission().equals("PUB_SELECT")) {
			swaUserCond = new SwaUserCond();
			swaUserCond.setResourceId(formId);
			swaUsers = getSwaManager().getUsers(userId, swaUserCond, null);
			for(SwaUser swaUser : swaUsers) {
				System.out.println(swaUser.getUserId());
			}
		}*/

		String userMode = CommonUtil.toNotNull(getSwaManager().getUserMode(userId, formId, SmartCommonConstants.TYPE_REF_SINGLE_WORK, null, companyId));

		/* -- 공개여부 --
		 공개 / 비공개*/

/*		 -- 형태 --
		 블로그형 : v2.0 구조
		 위키형 : 누구나 수정 가능*/

		 /*-- 작성권한 --
		 전체 / 선택사용자*/

		System.out.println("userMode>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userMode);
		PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_ALL);
		String id = pkg.getPackageId();
		String name = pkg.getName();
		String typeStr = pkg.getType();
		int type = typeStr.equals("PROCESS") ? SmartWork.TYPE_PROCESS : typeStr.equals("SINGLE") ? SmartWork.TYPE_INFORMATION : SmartWork.TYPE_SCHEDULE;
		String description = pkg.getDescription();

		Work work = new Work(id, name, type, description);
		AccessPolicy accessPolicy = new AccessPolicy();
		accessPolicy.setLevel(AccessPolicy.LEVEL_DEFAULT);
		work.setAccessPolicy(accessPolicy);
		return work;

	}

}
