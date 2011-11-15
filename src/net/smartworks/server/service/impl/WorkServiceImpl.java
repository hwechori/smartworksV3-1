package net.smartworks.server.service.impl;

import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.service.IWorkService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.SmartTest;

import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements IWorkService {

	private ICtgManager getCtgManager() {
		return SwManagerFactory.getInstance().getCtgManager();
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
	public Work[] getMyAllWorksByCategoryId(String categoryId) throws Exception {

		Work[] smartWorks = new SmartWork[] { SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork4(),
				SmartTest.getSmartWork5(), SmartTest.getSmartWork6() };

		return smartWorks;
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
	public Work getWorkById(String workId) throws Exception {
		Work[] works = new Work[] { SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork4(),
				SmartTest.getSmartWork5(), SmartTest.getSmartWork6(), SmartTest.getSmartWork7(), SmartTest.getSmartWork8(), SmartTest.getSmartWork9() };
		for (Work work : works) {
			if (work.getId().equals(workId))
				return work;
		}
		return null;
	}
}
