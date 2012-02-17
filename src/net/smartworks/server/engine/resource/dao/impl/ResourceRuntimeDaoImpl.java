package net.smartworks.server.engine.resource.dao.impl;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.task.exception.TskException;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.process.task.model.TskTaskDefCond;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.hb.HbWorkTypeModel;
import net.smartworks.server.engine.resource.util.ModelUtil;

public class ResourceRuntimeDaoImpl extends HbResourceRuntimeDaoImpl {

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.hb.HbResourceRuntimeDaoImpl#retrieveWorkType(java.lang.String)
	 */
	@Override
	public IWorkTypeModel retrieveWorkType(String workTypeId) throws SmartServerRuntimeException {
		ITskManager tskSvc = SwManagerFactory.getInstance().getTskManager();
		try {
			TskTaskDef taskDef = tskSvc.getTaskDef(null, workTypeId, IManager.LEVEL_ALL);
			//TODO def 가 없다는 것은 배치해제 되었다고 판단하고 해당 인스턴스에서 정보를 조회하여 리턴한다.
			if (taskDef == null) {
				TskTaskCond cond = new TskTaskCond();
				cond.setDef(workTypeId);
				cond.setPageSize(1);
				TskTask[] tskObjs = tskSvc.getTasks(null, cond, IManager.LEVEL_ALL);
				if (tskObjs == null)
					return null;
				TskTask tskObj = tskObjs[0];
				IWorkTypeModel workTypeModel = new HbWorkTypeModel();
				//TODO 배치해제된 뒤 필요한 정보가 현재 까지는 formUid 뿐이라서 해당 정보만 리턴 , 차후 필요한 정보가 있다면 추가
				workTypeModel.setId(tskObj.getObjId());
				workTypeModel.setFormUid(tskObj.getForm());
				return workTypeModel;
			} else {
				return ModelUtil.toWorkTypeModel(taskDef);
			}	
		} catch (TskException e) {
			throw new SmartServerRuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.hb.HbResourceRuntimeDaoImpl#retrieveWorkTypeByForm(java.lang.String, int)
	 */
	@Override
	public IWorkTypeModel retrieveWorkTypeByForm(String formId, int version) throws SmartServerRuntimeException {
		TskTaskDefCond cond = new TskTaskDefCond();
		cond.setForm(formId);
		if (version != 0) {
			Property[] extProps = new Property[1];
			extProps[0] = new Property("diagramVersion", String.valueOf(version));
			cond.setExtendedProperties(extProps);
		}
		try {
			TskTaskDef[] taskDefs = SwManagerFactory.getInstance().getTskManager().getTaskDefs(null, cond, IManager.LEVEL_ALL);
			return ModelUtil.toWorkTypeModel(taskDefs[0]);
		} catch (TskException te) {
			throw new SmartServerRuntimeException(te);
		}
	}
	
}
