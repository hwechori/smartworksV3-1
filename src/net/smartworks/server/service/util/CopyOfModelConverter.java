/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 23.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.filter.Condition;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.filter.info.SearchFilterInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.ProcessWorkInstance;
import net.smartworks.model.instance.TaskInstance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.IWInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.PWInstanceInfo;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.instance.info.WorkInstanceInfo;
import net.smartworks.model.security.AccessPolicy;
import net.smartworks.model.security.EditPolicy;
import net.smartworks.model.security.WritePolicy;
import net.smartworks.model.work.FormField;
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
import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.common.collection.model.ColList;
import net.smartworks.server.engine.common.collection.model.ColListCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.SizeMap;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormat;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoUserExtend;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.process.link.model.LnkObject;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.worklist.model.TaskWork;
import net.smartworks.util.LocalDate;

public class CopyOfModelConverter {
	
	private static ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}
	private static IPkgManager getPkgManager() {
		return SwManagerFactory.getInstance().getPkgManager();
	}
	private static IPrcManager getPrcManager() {
		return SwManagerFactory.getInstance().getPrcManager();
	}
	private static ICtgManager getCtgManager() {
		return SwManagerFactory.getInstance().getCtgManager();
	}
	private static ISwaManager getSwaManager() {
		return SwManagerFactory.getInstance().getSwaManager();
	}
	private static ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}
	private static IColManager getColManager() {
		return SwManagerFactory.getInstance().getColManager();
	}
	private static ITskManager getTskManager() {
		return SwManagerFactory.getInstance().getTskManager();
	}
	private static PkgPackage getPkgPackageByPackageId(String packageId) throws Exception {
		if (CommonUtil.isEmpty(packageId))
			return null;
		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setPackageId(packageId);
		PkgPackage pkg = getPkgManager().getPackage("", pkgCond, IManager.LEVEL_LITE);
		return pkg;
	}
	private static CtgCategory getCtgCategoryByCategoryId(String categoryId) throws Exception {
		if (CommonUtil.isEmpty(categoryId))
			return null;
		return getCtgManager().getCategory("", categoryId, IManager.LEVEL_LITE);
	}
	private static PrcProcessInst getPrcProcessInstByProcessInst(String prcInstanceId) throws Exception {
		if (CommonUtil.isEmpty(prcInstanceId))
			return null;
		return getPrcManager().getProcessInst("", prcInstanceId, IManager.LEVEL_LITE);
	}
	
	// #########################################  INFO  ########################################################################
	
	
	public static InstanceInfo[] getInstanceInfoArrayByTaskWorkArray(String userId, TaskWork[] tasks) throws  Exception {
		
		List<InstanceInfo> resultInfoList = new ArrayList<InstanceInfo>();
		
		for (int i = 0; i < tasks.length; i++) {
			TaskWork task = tasks[i];
			if (task.getPrcObjId() == null)
				continue;
			
			if (task.getTskType().equalsIgnoreCase(TskTask.TASKTYPE_COMMON)) {
				if (task.getIsStartActivity() != null && task.getIsStartActivity().equalsIgnoreCase("true")) {
					PWInstanceInfo instInfo = new PWInstanceInfo();
					
					instInfo.setId(task.getPrcObjId());
					instInfo.setSubject(task.getPrcTitle());
					instInfo.setType(Instance.TYPE_WORK);
					
					SmartWorkInfo workInfo = new SmartWorkInfo();
					workInfo.setId(task.getPackageId());
					workInfo.setName(task.getPackageName());
					if (task.getParentCtgId() != null) {
						workInfo.setMyCategory(new WorkCategoryInfo(task.getParentCtgId(), task.getParentCtgName()));
						workInfo.setMyGroup(new WorkCategoryInfo(task.getChildCtgId(), task.getChildCtgName()));
					} else {
						workInfo.setMyCategory(new WorkCategoryInfo(task.getChildCtgId(), task.getChildCtgName()));
					}
					
					instInfo.setWork(workInfo);
					instInfo.setWorkSpace(null);
					instInfo.setStatus(task.getPrcStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? Instance.STATUS_RUNNING : Instance.STATUS_COMPLETED);
					instInfo.setOwner(getUserInfoByUserId(task.getPrcCreateUser()));
					instInfo.setLastModifiedDate(new LocalDate( task.getLastTskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN) ? task.getLastTskCreateDate().getTime() : task.getLastTskExecuteDate().getTime()));
					instInfo.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));
					
					
					TaskInstanceInfo lastTask = new TaskInstanceInfo();
					lastTask.setId(task.getLastTskObjId());
					lastTask.setName(task.getLastTskName());
					
					if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_APPROVAL)) {
						lastTask.setTaskType(TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_COMMON)) {
						lastTask.setTaskType(TaskInstance.TYPE_PROCESS_TASK_ASSIGNED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_REFERENCE)) {
						lastTask.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_FORWARDED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_SINGLE)) {
						lastTask.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED);
					}
					
					
					lastTask.setWorkInstance(instInfo);
					lastTask.setAssignee(getUserInfoByUserId(task.getLastTskAssignee()));
					lastTask.setPerformer(getUserInfoByUserId(task.getLastTskAssignee()));
					lastTask.setSubject(task.getPrcTitle());
					lastTask.setWork(workInfo);
					lastTask.setWorkSpace(null);
					lastTask.setStatus(task.getLastTskStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? TaskInstance.STATUS_RUNNING : TaskInstance.STATUS_COMPLETED);
					lastTask.setOwner(getUserInfoByUserId(task.getLastTskAssignee()));
					lastTask.setLastModifiedDate(new LocalDate( task.getLastTskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN) ? task.getLastTskCreateDate().getTime() : task.getLastTskExecuteDate().getTime()));
					lastTask.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));

					
					instInfo.setLastTask(lastTask);
					instInfo.setLastTaskCount(task.getLastTskCount());

					resultInfoList.add(instInfo);
					
				} else {
					////////////////////////////////////////////
					PWInstanceInfo instInfo = new PWInstanceInfo();
					instInfo.setId(task.getPrcObjId());
					instInfo.setSubject(task.getPrcTitle());
					instInfo.setType(Instance.TYPE_WORK);
					
					SmartWorkInfo workInfo = new SmartWorkInfo();
					workInfo.setId(task.getPackageId());
					workInfo.setName(task.getPackageName());
					if (task.getParentCtgId() != null) {
						workInfo.setMyCategory(new WorkCategoryInfo(task.getParentCtgId(), task.getParentCtgName()));
						workInfo.setMyGroup(new WorkCategoryInfo(task.getChildCtgId(), task.getChildCtgName()));
					} else {
						workInfo.setMyCategory(new WorkCategoryInfo(task.getChildCtgId(), task.getChildCtgName()));
					}
					
					instInfo.setWork(workInfo);
					instInfo.setWorkSpace(null);
					instInfo.setStatus(task.getPrcStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? Instance.STATUS_RUNNING : Instance.STATUS_COMPLETED);
					instInfo.setOwner(getUserInfoByUserId(task.getPrcCreateUser()));
					instInfo.setLastModifiedDate(new LocalDate( task.getLastTskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN) ? task.getLastTskCreateDate().getTime() : task.getLastTskExecuteDate().getTime()));
					instInfo.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));
					
					TaskInstanceInfo lastTask = new TaskInstanceInfo();
					lastTask.setId(task.getLastTskObjId());
					lastTask.setName(task.getLastTskName());

					if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_APPROVAL)) {
						lastTask.setTaskType(TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_COMMON)) {
						lastTask.setTaskType(TaskInstance.TYPE_PROCESS_TASK_ASSIGNED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_REFERENCE)) {
						lastTask.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_FORWARDED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_SINGLE)) {
						lastTask.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED);
					}
					
					lastTask.setWorkInstance(instInfo);
					lastTask.setAssignee(getUserInfoByUserId(task.getLastTskAssignee()));
					lastTask.setPerformer(getUserInfoByUserId(task.getLastTskAssignee()));
					lastTask.setSubject(task.getPrcTitle());
					lastTask.setWork(workInfo);
					lastTask.setWorkSpace(null);
					lastTask.setStatus(task.getLastTskStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? TaskInstance.STATUS_RUNNING : TaskInstance.STATUS_COMPLETED);
					lastTask.setOwner(getUserInfoByUserId(task.getLastTskAssignee()));
					lastTask.setLastModifiedDate(new LocalDate( task.getLastTskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN) ? task.getLastTskCreateDate().getTime() : task.getLastTskExecuteDate().getTime()));
					lastTask.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));

					
					instInfo.setLastTask(lastTask);
					instInfo.setLastTaskCount(task.getLastTskCount());
					
					/////////////////////////////////////////
					
					TaskInstanceInfo tskInfo = new TaskInstanceInfo();
					tskInfo.setId(task.getTskObjId());
					tskInfo.setName(task.getTskName());

					if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_APPROVAL)) {
						tskInfo.setTaskType(TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_COMMON)) {
						tskInfo.setTaskType(TaskInstance.TYPE_PROCESS_TASK_ASSIGNED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_REFERENCE)) {
						tskInfo.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_FORWARDED);
					} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_SINGLE)) {
						tskInfo.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED);
					}
					
					tskInfo.setWorkInstance(instInfo);
					tskInfo.setAssignee(getUserInfoByUserId(task.getTskAssignee()));
					tskInfo.setPerformer(getUserInfoByUserId(task.getTskAssignee()));
					tskInfo.setSubject(task.getPrcTitle());
					tskInfo.setWork(workInfo);
					tskInfo.setWorkSpace(null);
					tskInfo.setStatus(task.getPrcStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? TaskInstance.STATUS_RUNNING : TaskInstance.STATUS_COMPLETED);
					tskInfo.setOwner(getUserInfoByUserId(task.getPrcCreateUser()));
					tskInfo.setLastModifiedDate(new LocalDate(task.getTaskLastModifyDate().getTime()));
					tskInfo.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));

					resultInfoList.add(instInfo);
				}
			} else {
				////////////////////////////////////////////
				IWInstanceInfo instInfo = new IWInstanceInfo();
				instInfo.setId(task.getPrcObjId());
				instInfo.setSubject(task.getPrcTitle());
				instInfo.setType(Instance.TYPE_WORK);
				
				SmartWorkInfo workInfo = new SmartWorkInfo();
				workInfo.setId(task.getPackageId());
				workInfo.setName(task.getPackageName());
				if (task.getParentCtgId() != null) {
				workInfo.setMyCategory(new WorkCategoryInfo(task.getParentCtgId(), task.getParentCtgName()));
				workInfo.setMyGroup(new WorkCategoryInfo(task.getChildCtgId(), task.getChildCtgName()));
				} else {
				workInfo.setMyCategory(new WorkCategoryInfo(task.getChildCtgId(), task.getChildCtgName()));
				}
				
				instInfo.setWork(workInfo);
				instInfo.setWorkSpace(null);
				instInfo.setStatus(task.getPrcStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? Instance.STATUS_RUNNING : Instance.STATUS_COMPLETED);
				instInfo.setOwner(getUserInfoByUserId(task.getPrcCreateUser()));
				instInfo.setLastModifiedDate(new LocalDate( task.getLastTskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN) ? task.getLastTskCreateDate().getTime() : task.getLastTskExecuteDate().getTime()));
				instInfo.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));
				
				TaskInstanceInfo lastTask = new TaskInstanceInfo();
				lastTask.setId(task.getLastTskObjId());
				lastTask.setName(task.getLastTskName());

				if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_APPROVAL)) {
					lastTask.setTaskType(TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED);
				} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_COMMON)) {
					lastTask.setTaskType(TaskInstance.TYPE_PROCESS_TASK_ASSIGNED);
				} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_REFERENCE)) {
					lastTask.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_FORWARDED);
				} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_SINGLE)) {
					lastTask.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED);
				}
				
				lastTask.setWorkInstance(instInfo);
				lastTask.setAssignee(getUserInfoByUserId(task.getLastTskAssignee()));
				lastTask.setPerformer(getUserInfoByUserId(task.getLastTskAssignee()));
				lastTask.setSubject(task.getPrcTitle());
				lastTask.setWork(workInfo);
				lastTask.setWorkSpace(null);
				lastTask.setStatus(task.getLastTskStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? TaskInstance.STATUS_RUNNING : TaskInstance.STATUS_COMPLETED);
				lastTask.setOwner(getUserInfoByUserId(task.getLastTskAssignee()));
				lastTask.setLastModifiedDate(new LocalDate( task.getLastTskStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN) ? task.getLastTskCreateDate().getTime() : task.getLastTskExecuteDate().getTime()));
				lastTask.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));

				
				instInfo.setLastTask(lastTask);
				instInfo.setLastTaskCount(task.getLastTskCount());
				
				//TODO KM 할당 업무 (프로세스 업무제외, 참조 태스크, 승인태스크) 도 TaskInstanceInfo 로 객체를 생성해서 넘겨야 한다
				
				TaskInstanceInfo tskInfo = new TaskInstanceInfo();
				tskInfo.setId(task.getTskObjId());
				tskInfo.setName(task.getTskName());

				if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_APPROVAL)) {
					tskInfo.setTaskType(TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED);
				} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_COMMON)) {
					tskInfo.setTaskType(TaskInstance.TYPE_PROCESS_TASK_ASSIGNED);
				} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_REFERENCE)) {
					tskInfo.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_FORWARDED);
				} else if (task.getLastTskType().equalsIgnoreCase(TskTask.TASKTYPE_SINGLE)) {
					tskInfo.setTaskType(TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED);
				}
				
				tskInfo.setWorkInstance(instInfo);
				tskInfo.setAssignee(getUserInfoByUserId(task.getTskAssignee()));
				tskInfo.setPerformer(getUserInfoByUserId(task.getTskAssignee()));
				tskInfo.setSubject(task.getPrcTitle());
				tskInfo.setWork(workInfo);
				tskInfo.setWorkSpace(null);
				tskInfo.setStatus(task.getPrcStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING) ? TaskInstance.STATUS_RUNNING : TaskInstance.STATUS_COMPLETED);
				tskInfo.setOwner(getUserInfoByUserId(task.getPrcCreateUser()));
				tskInfo.setLastModifiedDate(new LocalDate(task.getTaskLastModifyDate().getTime()));
				tskInfo.setLastModifier(getUserInfoByUserId(task.getLastTskAssignee()));
				
				resultInfoList.add(tskInfo);
				// KM 할당 업무 (프로세스 업무제외, 참조 태스크, 승인태스크) 도 TaskInstanceInfo 로 객체를 생성해서 넘겨야 한다
			}
		}

		InstanceInfo[] resultInfo = new InstanceInfo[resultInfoList.size()];
		resultInfoList.toArray(resultInfo);
		return resultInfo;
	}
	
	public static InstanceInfo getInstanceInfoByProcessInstId(String processInstId) throws Exception {
		PrcProcessInst prcInst = getPrcProcessInstByProcessInst(processInstId);
		return getInstanceInfoByPrcInst(null, prcInst);
	}
	public static InstanceInfo[] getInstanceInfoArrayByPrcInstArray(PrcProcessInst[] prcInsts) throws Exception {
		if (CommonUtil.isEmpty(prcInsts))
			return null;
		InstanceInfo[] instanceInfos = new InstanceInfo[prcInsts.length];
		for (int i = 0; i < prcInsts.length; i++) {
			PrcProcessInst prcInst = prcInsts[i];
			instanceInfos[i] = getInstanceInfoByPrcInst(null, prcInst);
		}
		return instanceInfos;
	}
	public static void setPolicyToWork(SmartWork work, String resourceId) throws Exception {
		/* -- 공개여부 --
		 공개 / 비공개*/

		/* -- 형태 --
		 블로그형 : v2.0 구조
		 위키형 : 누구나 수정 가능*/

		 /*-- 작성권한 --
		 전체 / 선택사용자*/
		//resourceId = formId , processId;
		AccessPolicy accessPolicy = new AccessPolicy();
		WritePolicy writePolicy = new WritePolicy();
		EditPolicy editPolicy = new EditPolicy();

		SwaResourceCond swaResourceCond = new SwaResourceCond();
		swaResourceCond.setResourceId(resourceId);//formid
		SwaResource[] swaResources = getSwaManager().getResources("", swaResourceCond, IManager.LEVEL_LITE);
		
		if (CommonUtil.isEmpty(swaResources)) {
			accessPolicy.setLevel(AccessPolicy.LEVEL_DEFAULT);
			writePolicy.setLevel(WritePolicy.LEVEL_DEFAULT);
			editPolicy.setLevel(EditPolicy.LEVEL_BLOG);
		} else {
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
		}
		
		work.setAccessPolicy(accessPolicy);
		work.setWritePolicy(writePolicy);
		work.setEditPolicy(editPolicy);
			
	}
	
	public static TskTask getLastExecutedTskTaskByPrcInstId(String processInstId) throws Exception {
		TskTaskCond tskCond = new TskTaskCond();
		tskCond.setProcessInstId(processInstId);
		String fieldName = "creationDate";
		boolean isAsc = false;
		tskCond.setOrders(new Order[]{new Order(fieldName, isAsc)});
		tskCond.setPageNo(0);
		tskCond.setPageSize(1);
		tskCond.setStatus(TskTask.TASKSTATUS_COMPLETE);
		tskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
		
		TskTask[] lastSwTask = getTskManager().getTasks("", tskCond, IManager.LEVEL_LITE);
		if (lastSwTask == null)
			return null;
		return lastSwTask[0];
	}
	public static TskTask getLastTskTaskByInstanceId(String processInstId) throws Exception {
		TskTaskCond tskCond = new TskTaskCond();
		tskCond.setProcessInstId(processInstId);
		String fieldName = "creationDate";
		boolean isAsc = false;
		tskCond.setOrders(new Order[]{new Order(fieldName, isAsc)});
		tskCond.setPageNo(0);
		tskCond.setPageSize(1);
		tskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
		
		TskTask[] lastSwTask = getTskManager().getTasks("", tskCond, IManager.LEVEL_LITE);
		if (lastSwTask == null)
			return null;
		return lastSwTask[0];
	}
	
	
	
	public static InstanceInfo getInstanceInfoByPrcInst(InstanceInfo instInfo, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (instInfo == null) 
			instInfo = new InstanceInfo();

		instInfo.setId(prcInst.getObjId());//processInstanceId
		instInfo.setSubject(prcInst.getTitle());
		
		TskTask lastTask = getLastExecutedTskTaskByPrcInstId(prcInst.getObjId());
		if (lastTask == null) {
			instInfo.setLastModifier(new UserInfo());
			instInfo.setLastModifiedDate(new LocalDate(1)); //TODO LastModifiedDate now
		} else {
			instInfo.setLastModifier(getUserInfoByUserId(lastTask.getAssignee()));
			instInfo.setLastModifiedDate(new LocalDate(lastTask.getExecutionDate().getTime())); //TODO LastModifiedDate now
		}
		
		instInfo.setOwner(getUserInfoByUserId(prcInst.getCreationUser()));
		if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
			instInfo.setStatus(Instance.STATUS_COMPLETED);
		} else if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
			instInfo.setStatus(Instance.STATUS_RUNNING);
		}
		if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_PROCESS)) {
			instInfo.setType(WorkInstance.TYPE_PROCESS);
		} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_INFORMATION)) {
			instInfo.setType(WorkInstance.TYPE_INFORMATION);
		} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_SCHEDULE)) {
			instInfo.setType(WorkInstance.TYPE_SCHEDULE);
		}
		instInfo.setWork(getSmartWorkInfoByPackageId(prcInst.getPackageId()));
		//TODO workspaceid > ??
		instInfo.setWorkSpace(new WorkSpaceInfo());
		
		return instInfo;
	}
	
	public static WorkInfo getWorkInfoByTask(TskTask task) throws Exception {
		String formId = task.getForm();
		SwfForm form = getSwfManager().getForm("", formId);
		if (form == null)
			return null;
		String packageId = form.getPackageId();
		return getWorkInfoByPackageId(packageId);
	}
	public static WorkInfo getWorkInfoByPackageId(String packageId) throws Exception {
		PkgPackage pkg = getPkgPackageByPackageId(packageId);
		return getSmartWorkInfoByPkgPackage(null, pkg);
	}
	public static WorkInfo[] getWorkInfoArrayByPkgPackageArray(PkgPackage[] pkgs) throws Exception {
		if (CommonUtil.isEmpty(pkgs))
			return null;
		WorkInfo[] workInfos = new WorkInfo[pkgs.length];
		for (int i = 0; i < pkgs.length; i++) {
			PkgPackage pkg = pkgs[i];
			workInfos[i] = getWorkInfoByPkgPackage(null, pkg);
		}
		return workInfos;
	}
	public static WorkInfo getWorkInfoByPkgPackage(WorkInfo workInfo, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (workInfo == null) 
			workInfo = new WorkInfo();

		workInfo.setId(pkg.getPackageId());
		workInfo.setName(pkg.getName());
		if (pkg.getType().equalsIgnoreCase("PROCESS")) {
			workInfo.setType(SmartWork.TYPE_PROCESS);	
		} else if (pkg.getType().equalsIgnoreCase("SINGLE")) {
			workInfo.setType(SmartWork.TYPE_INFORMATION);	
		} else if (pkg.getType().equalsIgnoreCase("GANTT")) {
			workInfo.setType(SmartWork.TYPE_SCHEDULE);	
		}
		return workInfo;
	}

	public static SmartWorkInfo getSmartWorkInfoByPackageId(String packageId) throws Exception {
		PkgPackage pkg = getPkgPackageByPackageId(packageId);
		return getSmartWorkInfoByPkgPackage(null, pkg);
	}
	public static SmartWorkInfo[] getSmartWorkInfoArrayByPkgPackageArray(PkgPackage[] pkgs) throws Exception {
		if (CommonUtil.isEmpty(pkgs))
			return null;
		SmartWorkInfo[] smartWorkInfos = new SmartWorkInfo[pkgs.length];
		for (int i = 0; i < pkgs.length; i++) {
			PkgPackage pkg = pkgs[i];
			smartWorkInfos[i] = getSmartWorkInfoByPkgPackage(null, pkg);
		}
		return smartWorkInfos;
	}
	public static SmartWorkInfo getSmartWorkInfoByPkgPackage(SmartWorkInfo workInfo, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (workInfo == null) 
			workInfo = new SmartWorkInfo();

		getWorkInfoByPkgPackage(workInfo, pkg);

		Map<String, WorkCategoryInfo> pkgCtgPathMap = getPkgCtgInfoMapByPackage(pkg);
		workInfo.setMyCategory(pkgCtgPathMap.get("category"));
		workInfo.setMyGroup(pkgCtgPathMap.get("group"));

		return workInfo;
	}	
	
	public static WorkCategoryInfo[] getWorkCategoryInfoArrayByCtgCategoryArray(CtgCategory[] argCtgs) throws Exception {
		if (CommonUtil.isEmpty(argCtgs))
			return null;
		
		WorkCategoryInfo[] workCtgs = new WorkCategoryInfo[argCtgs.length];
		for (int i =0; i < argCtgs.length; i ++) {
			CtgCategory ctg = argCtgs[i];
			WorkCategoryInfo workCtg = (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, ctg);
			workCtgs[i] = workCtg; 
		}
		return workCtgs;
	}
	public static WorkCategoryInfo getWorkCategoryInfoByCtgCategory(WorkCategoryInfo workCtgInfo, CtgCategory argCtg) throws Exception {
		if (argCtg == null)
			return null;
		if (workCtgInfo == null) 
			workCtgInfo = new WorkCategoryInfo();
		
		CtgCategory ctg = (CtgCategory)argCtg;
		String ctgId = ctg.getObjId();
		String ctgName = ctg.getName();
		WorkCategoryInfo workCtg = new WorkCategoryInfo(ctgId, ctgName);
		return workCtg;
	}
	
	public static UserInfo getUserInfoByUserId(String userId) throws Exception {
		if (CommonUtil.isEmpty(userId))
			return null;
		SwoUserExtend userExtend = getSwoManager().getUserExtend(userId, userId);
		return getUserInfoBySwoUserExtend(null, userExtend);
	}
	public static UserInfo getUserInfoBySwoUserExtend(UserInfo userInfo, SwoUserExtend userExtend) throws Exception {
		if (userExtend == null)
			return null;
		if (userInfo == null) 
			userInfo = new UserInfo();
		
		userInfo.setId(userExtend.getId());
		userInfo.setName(userExtend.getName());
		userInfo.setDepartment(new DepartmentInfo(userExtend.getDepartmentId(), userExtend.getDepartmentName()));
		userInfo.setMidPictureName(userExtend.getPictureName());
		userInfo.setMinPictureName(userExtend.getPictureName());
		//userInfo.setPicturePath(picturePath);
		userInfo.setPosition(userExtend.getPosition());
		return userInfo;
	}
	public static Map<String, WorkCategoryInfo> getPkgCtgInfoMapByPackage(PkgPackage pkg) throws Exception {
		
		String categoryId = pkg.getCategoryId();
		if (CommonUtil.isEmpty(categoryId) || categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
			return null;

		CtgCategory ctg = getCtgCategoryByCategoryId(categoryId);
		CtgCategory parentCtg = getCtgCategoryByCategoryId(ctg.getParentId());
		
		Map<String, WorkCategoryInfo> resultMap = new HashMap<String, WorkCategoryInfo>();
		if (parentCtg == null || parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
			resultMap.put("category", (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, ctg));
			resultMap.put("group", null);
		} else {
			resultMap.put("category", (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, parentCtg));
			resultMap.put("group", (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, ctg));
		}
		return resultMap;
	}
	
	public static InstanceInfo[] getInstanceInfoArrayByPrcProcessInstArray(PrcProcessInst[] prcInsts) throws Exception {
		if (CommonUtil.isEmpty(prcInsts))
			return null;
		
		InstanceInfo[] instanceInfos = new InstanceInfo[prcInsts.length];
		for (int i =0; i < prcInsts.length; i ++) {
			PrcProcessInst prcInst = prcInsts[i];
			InstanceInfo instanceInfo = (InstanceInfo)getInstanceInfoByPrcProcessInst(null, prcInst);
			instanceInfos[i] = instanceInfo; 
		}
		return instanceInfos;
	}
	public static InstanceInfo getInstanceInfoByPrcProcessInst(InstanceInfo instanceInfo, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (instanceInfo == null) 
			instanceInfo = new InstanceInfo();
		
		String id = prcInst.getObjId();
		String subject = prcInst.getTitle();
		int type = WorkInstance.TYPE_PROCESS;
		WorkInfo work = getWorkInfoByPackageId(prcInst.getDiagramId());//TODO prcInst.getPackageId 로 변경 해야함 현재(개발기간)에는 컬럼에 데이터가 없음
		WorkSpaceInfo workSpace = null;
		
		int status = -1;
		if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
			status = Instance.STATUS_COMPLETED;
		} else if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
			status = Instance.STATUS_COMPLETED;
		}
		UserInfo owner = CopyOfModelConverter.getUserInfoByUserId(prcInst.getCreationUser());
		
		TskTask lastTask = getLastExecutedTskTaskByPrcInstId(prcInst.getObjId());
		if (lastTask == null) {
			instanceInfo.setLastModifier(new UserInfo());
			instanceInfo.setLastModifiedDate(new LocalDate(1)); //TODO LastModifiedDate now
		} else {
			instanceInfo.setLastModifier(getUserInfoByUserId(lastTask.getAssignee()));
			instanceInfo.setLastModifiedDate(new LocalDate(lastTask.getExecutionDate().getTime())); //TODO LastModifiedDate now
		}
		
		instanceInfo.setId(id);
		instanceInfo.setOwner(owner);
		instanceInfo.setStatus(status);
		instanceInfo.setSubject(subject);
		instanceInfo.setType(type);
		instanceInfo.setWork(work);
		instanceInfo.setWorkSpace(workSpace);
		
		return instanceInfo;
	}
	public static WorkInstanceInfo getWorkInstanceInfoByPrcProcessInstId(String prcInstId) throws Exception {
		if (CommonUtil.isEmpty(prcInstId))
			return null;
		PrcProcessInst prcInst = getPrcManager().getProcessInst("", prcInstId, IManager.LEVEL_LITE);
		return getWorkInstanceInfoByPrcProcessInst(null, prcInst);
	}
	public static WorkInstanceInfo getWorkInstanceInfoByPrcProcessInst(WorkInstanceInfo workInstanceInfo, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (workInstanceInfo == null) 
			workInstanceInfo = new WorkInstanceInfo();
		
		getInstanceInfoByPrcProcessInst(workInstanceInfo, prcInst);
		
		TskTaskCond tskCond = new TskTaskCond();
		tskCond.setProcessInstId(prcInst.getObjId());
		String fieldName = "creationDate";
		tskCond.setStatus(TskTask.TASKSTATUS_ASSIGN);
		
		//TskTask[] runningTask = getTskManager().getTasks("", tskCond, IManager.LEVEL_LITE);
		
		//TaskInstanceInfo[] runningTasks = getTaskInstanceInfoArrayByTskTaskArray(workInstanceInfo, runningTask);
		
		//workInstanceInfo.setRunningTasks(runningTasks);
		
		return workInstanceInfo;
	}
	public static PWInstanceInfo[] getPWInstanceInfoArrayByPrcProcessInstArray(PrcProcessInst[] prcInsts) throws Exception {
		if (CommonUtil.isEmpty(prcInsts))
			return null;
		
		PWInstanceInfo[] pWInstanceInfos = new PWInstanceInfo[prcInsts.length];
		for (int i =0; i < prcInsts.length; i ++) {
			PrcProcessInst prcInst = prcInsts[i];
			PWInstanceInfo pWInstanceInfo = (PWInstanceInfo)getPWInstanceInfoByPrcProcessInst(null, prcInst);
			pWInstanceInfos[i] = pWInstanceInfo; 
		}
		return pWInstanceInfos;
	}
	public static PWInstanceInfo getPWInstanceInfoByPrcProcessInst(PWInstanceInfo pWInstanceInfo, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (pWInstanceInfo == null) 
			pWInstanceInfo = new PWInstanceInfo();
		
		getWorkInstanceInfoByPrcProcessInst(pWInstanceInfo, prcInst);
		
		TskTaskCond tskCond = new TskTaskCond();
		tskCond.setProcessInstId(prcInst.getObjId());
		String fieldName = "creationDate";
		boolean isAsc = false;
		tskCond.setOrders(new Order[]{new Order(fieldName, isAsc)});
		tskCond.setPageNo(0);
		tskCond.setPageSize(1);
		
//		TskTask[] lastSwTask = getTskManager().getTasks("", tskCond, IManager.LEVEL_LITE);
		TskTask lastSwTask = getLastTskTaskByInstanceId(prcInst.getObjId());
		
		TaskInstanceInfo lastTask = getTaskInstanceInfoByTskTask(pWInstanceInfo, null, lastSwTask);
		pWInstanceInfo.setLastTask(lastTask); 
		
		return pWInstanceInfo;
	}
	
	public static InstanceInfo getInstanceInfoByTskTask(InstanceInfo instanceInfo, TskTask task) throws Exception {
		if (task == null)
			return null;
		if (instanceInfo == null) 
			instanceInfo = new InstanceInfo();
		
		String id = task.getObjId();
		String subject = task.getTitle();
		int type = WorkInstance.TYPE_TASK;
		WorkInfo work = getWorkInfoByTask(task);
		WorkSpaceInfo workSpace = null; //TODO
		
		int status = -1;
		if (task.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_ASSIGN)) {
			status = Instance.STATUS_COMPLETED;
		} else if (task.getStatus().equalsIgnoreCase(TskTask.TASKSTATUS_COMPLETE)) {
			status = Instance.STATUS_COMPLETED;
		}
		UserInfo owner = CopyOfModelConverter.getUserInfoByUserId(task.getCreationUser());
		UserInfo lastModifier = CopyOfModelConverter.getUserInfoByUserId(task.getModificationUser()); 
		LocalDate lastModifiedDate = new LocalDate(task.getModificationDate().getTime());
		
		instanceInfo.setId(id);
		instanceInfo.setLastModifiedDate(lastModifiedDate);
		instanceInfo.setLastModifier(lastModifier);
		instanceInfo.setOwner(owner);
		instanceInfo.setStatus(status);
		instanceInfo.setSubject(subject);
		instanceInfo.setType(type);
		instanceInfo.setWork(work);
		instanceInfo.setWorkSpace(workSpace);
		
		return instanceInfo;
	}
	public static TaskInstanceInfo[] getTaskInstanceInfoArrayByTskTaskArray(WorkInstanceInfo paretProcessInstObj, TskTask[] swTasks) throws Exception {
		if (CommonUtil.isEmpty(swTasks))
			return null;
		
		TaskInstanceInfo[] taskInstanceInfos = new TaskInstanceInfo[swTasks.length];
		for (int i =0; i < swTasks.length; i ++) {
			TskTask task = swTasks[i];
			TaskInstanceInfo taskInstanceInfo = (TaskInstanceInfo)getTaskInstanceInfoByTskTask(paretProcessInstObj, null, task);
			taskInstanceInfos[i] = taskInstanceInfo; 
		}
		return taskInstanceInfos;
	}
	
	public static TaskInstanceInfo getTaskInstanceInfoByTskTask (WorkInstanceInfo paretProcessInstObj, TaskInstanceInfo taskInstInfo , TskTask swTask) throws Exception {
		if (swTask == null)
			return null;
		if (taskInstInfo == null)
			taskInstInfo = new TaskInstanceInfo();
		
		getInstanceInfoByTskTask (taskInstInfo, swTask);
		
		String name = swTask.getName();
		int taskType = WorkInstance.TYPE_TASK;
		String assignee = swTask.getAssignee();
		String performer = swTask.getAssignee();
// 프로세스인스턴스가 태스크인스턴스를 포함하고 태스크인스턴스는 프로세스 인스턴스를 포함하기 때문에 무한 루프가 발생한다
// 하여 태스크 인스턴스를 만들때는 부모 프로세스 인스턴스의 객체 래퍼런스를 가져와서 태스크에다가 주입한다
//		WorkInstanceInfo workInstanceInfo = getWorkInstanceInfoByPrcProcessInstId(swTask.getProcessInstId());
		WorkInstanceInfo workInstanceInfo = paretProcessInstObj;
		
		taskInstInfo.setName(name);
		taskInstInfo.setTaskType(taskType);
		taskInstInfo.setAssignee(getUserInfoByUserId(assignee));
		taskInstInfo.setPerformer(getUserInfoByUserId(performer));
		taskInstInfo.setWorkInstance(workInstanceInfo);
		
		return taskInstInfo;
	}

	
	// #########################################  specific class  ########################################################################
	
	
	public static User[] getUserArrayBySwoUserExtendArray(SwoUserExtend[] userExtends) throws Exception {
		if (CommonUtil.isEmpty(userExtends))
			return null;
		User[] users = new User[userExtends.length];
		for (int i =0; i < userExtends.length; i++) {
			SwoUserExtend userExtend = userExtends[i];
			users[i] = getUserBySwoUserExtend(null, userExtend);
		}
		return users;
	}
	public static User getUserByUserId(String userId) throws Exception {
		if (CommonUtil.isEmpty(userId))
			return null;
		SwoUserExtend userExtend = getSwoManager().getUserExtend(userId, userId);
		return getUserBySwoUserExtend(null, userExtend);
	}
	public static User getUserBySwoUserExtend(User user, SwoUserExtend userExtend) throws Exception {
		if (userExtend == null)
			return null;
		if (user == null)
			user = new User();
		
		user.setId(userExtend.getId());
		user.setName(userExtend.getName());
		user.setDepartment(userExtend.getDepartmentName());
		user.setMidPictureName(userExtend.getPictureName());
		user.setMinPictureName(userExtend.getPictureName());
		user.setPosition(userExtend.getPosition());
		String locale = userExtend.getLocale();
		if (locale == null)
			locale = "ko";
		if (locale.equalsIgnoreCase("kor"))
			locale = "ko";
		if (locale.equalsIgnoreCase("eng"))
			locale = "en";
		user.setLocale(locale);
		user.setOrgPictureName(userExtend.getPictureName());
		user.setCompany(userExtend.getCompanyName());
		user.setTimeZone(userExtend.getTimeZone());
		user.setUserLevel(-1);//userExtend.getUserLevel();
		return user;
	}

	public static Work getWorkByCtgCategory(Work work, CtgCategory ctg) throws Exception {
		if (ctg == null)
			return null;
		if (work == null)
			work = new Work();
			
		String ctgId = ctg.getObjId();
		String ctgName = ctg.getName();
		String ctgDesc = ctg.getDescription();
		int ctgType = -1;
		work.setId(ctgId);
		work.setName(ctgName);
		work.setDesc(ctgDesc);
		work.setType(-1);
		
		return work;
	}
	public static WorkCategory getWorkCategoryByCtgCategory(WorkCategory workCategory, CtgCategory ctg) throws Exception {
		if (ctg == null)
			return null;
		if (workCategory == null)
			workCategory = new WorkCategory();
		
		getWorkByCtgCategory(workCategory, ctg);
		
		return workCategory;
	}
	
	
	public static Work getWorkByPkgPackage(Work work, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (work == null)
			work = new Work();
			
		String ctgId = pkg.getObjId();
		String ctgName = pkg.getName();
		String ctgDesc = pkg.getDescription();
		//TODO
		int ctgType = -1;
		work.setId(ctgId);
		work.setName(ctgName);
		work.setDesc(ctgDesc);
		work.setType(-1);
		
		return work;
	}
	public static SmartWork getSmartWorkByPkgPackage(String userId, SmartWork smartWork, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (smartWork == null)
			smartWork = new SmartWork();
		
		getWorkByPkgPackage(smartWork, pkg);
		
		setPolicyToWork(smartWork, getResourceIdByPkgPackage(pkg));
		
		smartWork.setLastModifier(getUserByUserId(pkg.getModificationUser()));
		smartWork.setLastModifiedDate(new LocalDate(pkg.getModificationDate().getTime()));
		
		smartWork.setSearchFilters(getSearchFilterInfoByPkgPackage(userId, pkg));
		
		Map<String, WorkCategory> pkgCtgPathMap = getPkgCtgMapByPackage(pkg);
		smartWork.setMyCategory(pkgCtgPathMap.get("category"));
		smartWork.setMyGroup(pkgCtgPathMap.get("group"));
		
		return smartWork;
	}
	public static ProcessWork getProcessWorkByPkgPackageId(String userId,String packageId) throws Exception {
		return getProcessWorkByPkgPackage(userId, null, getPkgPackageByPackageId(packageId));
	}
	public static ProcessWork getProcessWorkByPkgPackage(String userId, ProcessWork processWork, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (processWork == null)
			processWork = new ProcessWork();
		
		getSmartWorkByPkgPackage(userId, processWork, pkg);
		
		processWork.setHelpUrl("HELP URL");
		processWork.setManualFileName("MANUAL FILE NAME");
		processWork.setManualFilePath("MANUAL FILE PATH");
		
		return processWork;
	}
	
	public static SearchFilterInfo[] getSearchFilterInfoByPkgPackage(String userId, PkgPackage pkg) throws Exception {
		
		return new SearchFilterInfo[]{new SearchFilterInfo("","")};
	}
	
	public static SearchFilter[] getSearchFilterArrayByPkgPackage(String userId, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		
		ColListCond listCond = new ColListCond();
		String pkgType = pkg.getType();
		if (pkgType.equalsIgnoreCase("PROCESS") || pkgType.equalsIgnoreCase("GANTT")) {
			//processinst.cond.admin@maninsoft.co.kr
			listCond.setType("processinst.cond." + userId);
		} else {
			//record.cond.admin@maninsoft.co.kr
			listCond.setType("record.cond." + userId);
		}
		String resourceId = getResourceIdByPkgPackage(pkg);
		if (CommonUtil.isEmpty(resourceId))
			return null;
		listCond.setCorrelation(resourceId);
		
		ColList filterList = getColManager().getList(userId, listCond, IManager.LEVEL_ALL);
		
		return getSearchFilterArrayByColList(pkgType, filterList);
	}
	public static SearchFilter[] getSearchFilterArrayByColList(String type, ColList list) throws Exception {
		if (list == null)
			return null;
		
		LnkObject[] filterItemArray = list.getItems();
		
		if (CommonUtil.isEmpty(filterItemArray))
			return null;
		
		List<SearchFilter> filterList = new ArrayList<SearchFilter>();
		for (int i = 0; i < filterItemArray.length; i++) {

			LnkObject filterItem = filterItemArray[i];
			
			String name = filterItem.getLabel();
			String conditionStr = filterItem.getExpression();
			Condition[] conditions = null;
			if (!CommonUtil.isEmpty(conditionStr)) {
				Filter[] filters = null;
				if (type.equalsIgnoreCase("PROCESS") || type.equalsIgnoreCase("GANTT")) {
					PrcProcessInstCond prcCond = (PrcProcessInstCond)PrcProcessInstCond.toObject(conditionStr);
					if (prcCond == null)
						continue;
					filters = prcCond.getFilter();
				} else {
					SwdRecordCond recCond = (SwdRecordCond)SwdRecordCond.toObject(conditionStr);
					if (recCond == null)
						continue;
					filters = recCond.getFilter();
				}
				if (filters == null)
					continue;
				Condition[] condArray = new Condition[filters.length];
				for (int j = 0; j < filters.length; j++) {
					Filter filter = filters[i];
					String leftOperType = filter.getLeftOperandType();
					String leftOperValue = filter.getLeftOperandValue();
					String rightOperType = filter.getRightOperandType();
					String rightOperValue = filter.getRightOperandValue();
					String operator = filter.getOperator();
					
					Condition cond = new Condition(new FormField(leftOperValue, leftOperValue, leftOperType) , operator, new FormField(rightOperValue, rightOperValue, rightOperType));
					condArray[i] = cond;
				}
				conditions = condArray;
			}
			
			SearchFilter searchFilter = new SearchFilter();
			searchFilter.setId(name);
			searchFilter.setName(name);
			searchFilter.setConditions(conditions);
			
			filterList.add(searchFilter);
		}
		SearchFilter[] searchFilter = new SearchFilter[filterList.size()];
		filterList.toArray(searchFilter);
		
		return searchFilter;
	}
	
	public static String getResourceIdByPkgPackage(PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		
		String type = pkg.getType();
		String packageId = pkg.getPackageId();
		
		if (type.equalsIgnoreCase("PROCESS") || type.equalsIgnoreCase("GANTT")) {
			PrcProcessCond prcCond = new PrcProcessCond();
			prcCond.setDiagramId(packageId);
			PrcProcess[] prc = getPrcManager().getProcesses("", prcCond, IManager.LEVEL_LITE);
			if (CommonUtil.isEmpty(prc)) {
				return null;
			} else {
				return prc[0].getProcessId();
			}
		} else if (type.equalsIgnoreCase("SINGLE")) {
			SwfFormCond formCond = new SwfFormCond();
			formCond.setPackageId(packageId);
			
			SwfForm[] form = getSwfManager().getForms("", formCond, IManager.LEVEL_LITE);
			if (CommonUtil.isEmpty(form)) {
				return null;
			} else {
				return form[0].getId();
			}
		} 
		return null;
	}
	
	public static Map<String, WorkCategory> getPkgCtgMapByPackage(PkgPackage pkg) throws Exception {
		
		String categoryId = pkg.getCategoryId();
		if (CommonUtil.isEmpty(categoryId) || categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
			return null;
		
		CtgCategory ctg = getCtgCategoryByCategoryId(categoryId);
		CtgCategory parentCtg = getCtgCategoryByCategoryId(ctg.getParentId());
		
		Map<String, WorkCategory> resultMap = new HashMap<String, WorkCategory>();
		if (parentCtg == null || parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
			resultMap.put("category", (WorkCategory)getWorkCategoryByCtgCategory(null, ctg));
			resultMap.put("group", null);
		} else {
			resultMap.put("category", (WorkCategory)getWorkCategoryByCtgCategory(null, parentCtg));
			resultMap.put("group", (WorkCategory)getWorkCategoryByCtgCategory(null, ctg));
		}
		return resultMap;
	}
	public static FormField[] getFormFieldArrayBySwfFieldArray(SwfField[] fields) throws Exception {
		if (CommonUtil.isEmpty(fields))
			return null;
		
		FormField[] formFields = new FormField[fields.length];
		for (int i = 0; i < fields.length; i++) {
			SwfField field = fields[i];
			formFields[i] = getFormFieldBySwfField(null, field);
		}
		return formFields;
	}
	public static FormField getFormFieldBySwfField(FormField formField, SwfField swField) throws Exception {
		if (swField == null)
			return null;
		if (formField == null)
			formField = new FormField();
		
		/*<field id="4" name="내용" systemType="text" array="false" required="true" system="false">
			<format type="richEditor" viewingType="richEditor"/>
		</field>*/
		String id = swField.getId();
		String name = swField.getName();
		SwfFormat format = swField.getFormat();
		String type = format.getType();
		
		formField.setId(id);
		formField.setName(name);
		formField.setType(type);
		
		return formField;
	}
	public static SmartForm getSmartFormBySwfFrom(SmartForm smartForm, SwfForm swForm) throws Exception {
		if (swForm == null)
			return null;
		if (smartForm == null)
			smartForm = new SmartForm();
		
		String description = swForm.getDescription();
		String id = swForm.getId();
		String minImageName = "";
		String orgImageName = "";
		String name = swForm.getName();
		SwfField[] swFields = swForm.getFields();
		
		smartForm.setDescription(description);
		smartForm.setFields(getFormFieldArrayBySwfFieldArray(swFields));
		smartForm.setId(id);
		smartForm.setMinImageName(minImageName);
		smartForm.setName(name);
		smartForm.setOrgImageName(orgImageName);
		
		return smartForm;
	}
	public static Instance getInstanceByPrcProcessInst(String userId, Instance instance, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (instance == null)
			instance = new Instance();
		
		instance.setId(prcInst.getObjId());//processInstanceId
		instance.setSubject(prcInst.getTitle());
		instance.setCreatedDate(new LocalDate(prcInst.getCreationDate().getTime()));
		
		TskTask lastTask = getLastExecutedTskTaskByPrcInstId(prcInst.getObjId());
		if (lastTask == null) {
			instance.setLastModifier(new User());
			instance.setLastModifiedDate(new LocalDate(1)); //TODO LastModifiedDate now
		} else {
			instance.setLastModifier(getUserByUserId(lastTask.getAssignee()));
			instance.setLastModifiedDate(new LocalDate(lastTask.getExecutionDate().getTime())); //TODO LastModifiedDate now
		}
		
		instance.setOwner(getUserByUserId(prcInst.getCreationUser()));
		if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
			instance.setStatus(Instance.STATUS_COMPLETED);
		} else if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
			instance.setStatus(Instance.STATUS_RUNNING);
		}
		if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_PROCESS)) {
			instance.setType(WorkInstance.TYPE_PROCESS);
		} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_INFORMATION)) {
			instance.setType(WorkInstance.TYPE_INFORMATION);
		} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_SCHEDULE)) {
			instance.setType(WorkInstance.TYPE_SCHEDULE);
		}
		
		String packageId = prcInst.getDiagramId();
		
		instance.setWork(getProcessWorkByPkgPackageId(userId, packageId));
		//TODO workspaceid > ??
		instance.setWorkSpace(new WorkSpace());
		
		return instance;
	}
	public static WorkInstance getWorkInstanceByPrcProcessInst(String userId, WorkInstance workInstance, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (workInstance == null)
			workInstance = new WorkInstance();
		
		getInstanceByPrcProcessInst(userId, workInstance, prcInst);
		
		PWInstanceInfo pwInstInfo = getPWInstanceInfoByPrcProcessInst(null, prcInst);
		
		TskTaskCond tskCond = new TskTaskCond();
		tskCond.setProcessInstId(prcInst.getObjId());
		tskCond.setTypeNotIns(TskTask.NOTUSERTASKTYPES);
		
		TskTask[] tasks = getTskManager().getTasks("", tskCond, IManager.LEVEL_LITE);
		
		workInstance.setTasks(getTaskInstanceInfoArrayByTskTaskArray(pwInstInfo, tasks));
		workInstance.setNumberOfSubInstances(-1);
		
		return workInstance;
	}
	public static ProcessWorkInstance getProcessWorkInstanceByPrcProcessInst(String userId, ProcessWorkInstance processWorkInstance, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (processWorkInstance == null)
			processWorkInstance = new ProcessWorkInstance();
		
		getWorkInstanceByPrcProcessInst(userId, processWorkInstance, prcInst);
		
		return processWorkInstance;
	}
	
}
