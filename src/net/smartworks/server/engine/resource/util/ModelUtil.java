package net.smartworks.server.engine.resource.util;

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.hb.HbWorkTypeModel;

public class ModelUtil {

	public ModelUtil() {
		super();
	}

	public static IWorkTypeModel toWorkTypeModel(TskTaskDef taskDef) {
		HbWorkTypeModel workTypeModel = new HbWorkTypeModel();
		String id = taskDef.getObjId();
		String name = taskDef.getName();
		String form = taskDef.getForm();
		String type = taskDef.getType();
		String dueDate = taskDef.getDueDate();
		//		String assignee = taskDef.getAssignee();
		if (id != null)
			workTypeModel.setId(id);
		if (name != null)
			workTypeModel.setName(name);
		if (form != null)
			workTypeModel.setFormUid(form);
		if (type != null)
			workTypeModel.setType(type);
		if (!CommonUtil.isEmpty(dueDate))
			workTypeModel.setDuration(Integer.parseInt(dueDate));
		//		if (assignee != null){
		//			//TODO performer - assignee 비교 후  수정 필요
		//			IWorkTypePerformerLineModel performerLine = new HbWorkTypePerformerLineModel();
		//			performerLine.setPerformer(assignee);
		//			HashSet<IWorkTypePerformerLineModel> hs = new HashSet<IWorkTypePerformerLineModel>();
		//			hs.add(performerLine);
		//			workTypeModel.setPerformerLineSet(hs);
		//		}
		return workTypeModel;
	}

}
