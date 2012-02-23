/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 4.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.worklist.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.process.process.exception.PrcException;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInstExtend;
import net.smartworks.server.engine.worklist.manager.IWorkListManager;
import net.smartworks.server.engine.worklist.model.TaskWork;
import net.smartworks.server.engine.worklist.model.TaskWorkCond;
import net.smartworks.util.LocalDate;

import org.hibernate.Query;

public class WorkListManagerImpl extends AbstractManager implements IWorkListManager {
	
	
	private Query appendQuery(StringBuffer queryBuffer , TaskWorkCond cond) throws Exception {
		
		String tskAssignee = cond.getTskAssignee();
		//assingnedOnly 값이 true 라면 실행중인(11) 태스크만 조회를 한다.
		String tskStatus =  cond.getTskStatus();
		String prcStatus = cond.getPrcStatus();
		Date lastInstanceDate = cond.getLastInstanceDate();
		String tskRefType = cond.getTskRefType();
		int pageNo = cond.getPageNo();
		int pageSize = cond.getPageSize();
		
		String worksSpaceId = cond.getTskWorkSpaceId();
		Date executionDateFrom = cond.getTskExecuteDateFrom();
		Date executionDateTo = cond.getTskExecuteDateTo();
		
		queryBuffer.append("from ");
		queryBuffer.append("( ");
		queryBuffer.append("	select task.tskobjId ");
		queryBuffer.append("		, task.tsktitle ");
		queryBuffer.append("		, task.tsktype ");
		queryBuffer.append("		, task.tskReftype ");
		queryBuffer.append("		, task.tskstatus ");
		queryBuffer.append("		, task.tskassignee ");
		queryBuffer.append("		, case when task.tskstatus='11' then task.tskassigndate else task.tskexecuteDate end as taskLastModifyDate ");
		queryBuffer.append("		, task.tskcreatedate ");
		queryBuffer.append("		, task.tskname ");
		queryBuffer.append("		, task.tskprcinstid ");
		queryBuffer.append("		, task.tskform ");
		queryBuffer.append("		, task.isStartActivity ");
		queryBuffer.append("		, task.tskWorkSpaceId ");//workSpaceId
		queryBuffer.append("		, task.tskDef ");//workSpaceId
		queryBuffer.append("		, form.packageId ");
		queryBuffer.append("		, pkg.name as packageName ");
		queryBuffer.append("		, ctg.id as childCtgId ");
		queryBuffer.append("		, ctg.name as childCtgName ");
		queryBuffer.append("		, case when ctg.parentId = '_PKG_ROOT_' then null else ctg2.id end as parentCtgId ");
		queryBuffer.append("		, case when ctg.parentId = '_PKG_ROOT_' then null else ctg2.name end as parentCtgName ");
		queryBuffer.append("	from tsktask task, ");
		queryBuffer.append("		swform form ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swpackage pkg ");
		queryBuffer.append("		on form.packageId = pkg.packageId ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swcategory ctg ");
		queryBuffer.append("		on ctg.id = pkg.categoryId ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swcategory ctg2 ");
		queryBuffer.append("		on ctg.parentId = ctg2.id ");
		queryBuffer.append("	where tsktype not in ('and','route','SUBFLOW','xor') ");
		queryBuffer.append("	and task.tskform = form.formid ");
		if (!CommonUtil.isEmpty(tskAssignee))
			queryBuffer.append("	and task.tskassignee = :tskAssignee ");
		if (!CommonUtil.isEmpty(tskStatus))
			queryBuffer.append("	and task.tskstatus = :tskStatus ");
		if (!CommonUtil.isEmpty(worksSpaceId))
			queryBuffer.append("	and task.tskWorkSpaceId = :worksSpaceId ");
		if (executionDateFrom != null)
			queryBuffer.append("	and task.tskExecuteDate >= :executionDateFrom ");
		if (executionDateTo != null)
			queryBuffer.append("	and task.tskExecuteDate <= :executionDateTo ");
		queryBuffer.append(") taskInfo ");
		//queryBuffer.append("left outer join ");
		queryBuffer.append("join ");
		queryBuffer.append("( ");
		queryBuffer.append("	select ");
		queryBuffer.append("		 prcInst.prcObjId ");
		queryBuffer.append("		, prcInst.prcTitle ");
		queryBuffer.append("		, prcInst.prcType ");
		queryBuffer.append("		, prcInst.prcStatus ");
		queryBuffer.append("		, prcInst.prcCreateUser ");
		queryBuffer.append("		, prcInst.prcDid ");
		queryBuffer.append("		, prcInst.prcPrcId ");
		queryBuffer.append("		, prcInst.prcCreateDate ");
		queryBuffer.append("		, prcInst.prcWorkSpaceId "); //workSpaceId
		queryBuffer.append("		, prcInstInfo.lastTask_tskobjid ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskname ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskcreateuser ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskcreateDate ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskstatus ");
		queryBuffer.append("		, prcInstInfo.lastTask_tsktype ");
		queryBuffer.append("		, prcInstInfo.lastTask_tsktitle ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskassignee ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskexecuteDate ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskduedate ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskform ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskWorkSpaceId "); //workSpaceId
		queryBuffer.append("		, (select count(*) from tsktask where tskstatus='11' and tsktype='common' and tskprcInstId = prcInst.prcObjid) as lastTaskCount ");
		queryBuffer.append("	from  ");
		queryBuffer.append("		prcprcinst prcInst,  ");
		queryBuffer.append("		( ");
		queryBuffer.append("			select a.tskprcinstid as lastTask_tskprcinstid ");
		queryBuffer.append("					, task.tskobjid as lastTask_tskobjid ");
		queryBuffer.append("					, task.tskname as lastTask_tskname ");
		queryBuffer.append("					, task.tskcreateuser as lastTask_tskcreateuser ");
		queryBuffer.append("					, task.tskcreateDate as lastTask_tskcreateDate ");
		queryBuffer.append("					, task.tskstatus as lastTask_tskstatus ");
		queryBuffer.append("					, task.tsktype as lastTask_tsktype ");
		queryBuffer.append("					, task.tsktitle as lastTask_tsktitle ");
		queryBuffer.append("					, task.tskassignee as lastTask_tskassignee ");
		queryBuffer.append("					, task.tskexecuteDate as lastTask_tskexecuteDate ");
		queryBuffer.append("					, task.tskduedate as lastTask_tskduedate ");
		queryBuffer.append("					, task.tskform as lastTask_tskform ");
		queryBuffer.append("					, task.tskWorkSpaceId as lastTask_tskWorkSpaceId "); //workSpaceId
		queryBuffer.append("			from ( ");
		queryBuffer.append("					select tskprcinstId , max(tskCreatedate) as createDate  ");
		queryBuffer.append("					from tsktask  ");
		queryBuffer.append("					where tsktype not in ('and','route','SUBFLOW','xor') ");
		queryBuffer.append("					group by tskprcinstid ");
		queryBuffer.append("				  ) a,	 ");
		queryBuffer.append("				  TskTask task		 ");
		queryBuffer.append("			where  ");
		queryBuffer.append("				a.createDate = task.tskcreatedate ");
		queryBuffer.append("		) prcInstInfo	 ");
		queryBuffer.append("	where ");
		queryBuffer.append("		prcInst.prcobjid=prcInstInfo.lastTask_tskprcinstid ");
		if (!CommonUtil.isEmpty(prcStatus))
			queryBuffer.append("		and prcInst.prcStatus = :prcStatus ");
		queryBuffer.append(") prcInstInfo ");
		queryBuffer.append("on taskInfo.tskPrcInstId = prcInstInfo.prcObjId ");
		if (lastInstanceDate != null)
			queryBuffer.append("where taskInfo.tskCreateDate < :lastInstanceDate ");
		if (tskRefType != null)
			queryBuffer.append("where taskInfo.tskRefType = :tskRefType ");
		
		this.appendOrderQuery(queryBuffer, "taskInfo", cond);
		//queryBuffer.append("order by taskInfo.tskCreatedate desc ");

		Query query = this.getSession().createSQLQuery(queryBuffer.toString());

		if (pageSize > 0|| pageNo >= 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}
		if (!CommonUtil.isEmpty(tskAssignee))
			query.setString("tskAssignee", tskAssignee);
		if (!CommonUtil.isEmpty(tskStatus))
			query.setString("tskStatus", tskStatus);
		if (lastInstanceDate != null)
			query.setTimestamp("lastInstanceDate", lastInstanceDate);
		if (!CommonUtil.isEmpty(worksSpaceId))
			query.setString("worksSpaceId", worksSpaceId);
		if (executionDateFrom != null)
			query.setTimestamp("executionDateFrom", executionDateFrom);
		if (executionDateTo != null)
			query.setTimestamp("executionDateTo", executionDateTo);
		if (!CommonUtil.isEmpty(prcStatus)) 
			query.setString("prcStatus", prcStatus);
		if (!CommonUtil.isEmpty(tskRefType)) 
			query.setString("tskRefType", tskRefType);
		
		return query;
	}
	public long getTaskWorkListSize(String user, TaskWorkCond cond) throws Exception {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(*) ");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			
			long count =((Integer)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public TaskWork[] getTaskWorkList(String user, TaskWorkCond cond) throws Exception {
		try {

			StringBuffer queryBuffer = new StringBuffer();
			queryBuffer.append(" select taskInfo.*, ");
			queryBuffer.append(" prcInstInfo.* ");
			
			Query query = this.appendQuery(queryBuffer, cond);
		
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			List objList = new ArrayList();
			for (Iterator itr = list.iterator(); itr.hasNext();) {
				Object[] fields = (Object[]) itr.next();
				TaskWork obj = new TaskWork();
				int j = 0;
		
				obj.setTskObjId((String)fields[j++]);    
				obj.setTskTitle((String)fields[j++]);    
				obj.setTskType((String)fields[j++]);     
				obj.setTskRefType((String)fields[j++]);     
				obj.setTskStatus((String)fields[j++]);   
				obj.setTskAssignee((String)fields[j++]); 
				obj.setTaskLastModifyDate((Timestamp)fields[j++]);
				obj.setTskCreateDate((Timestamp)fields[j++]);
				obj.setTskName((String)fields[j++]);     
				obj.setTskPrcInstId((String)fields[j++]);
				obj.setTskForm((String)fields[j++]);     
				obj.setIsStartActivity((String)fields[j++]); 
				obj.setTskWorkSpaceId((String)fields[j++]);     
				obj.setTskDef((String)fields[j++]);     
				obj.setPackageId((String)fields[j++]);     
				obj.setPackageName((String)fields[j++]);   
				obj.setChildCtgId((String)fields[j++]);  
				obj.setChildCtgName((String)fields[j++]);
				obj.setParentCtgId((String)fields[j++]); 
				obj.setParentCtgName((String)fields[j++]);
				obj.setPrcObjId((String)fields[j++]);                           
				obj.setPrcTitle((String)fields[j++]);                           
				obj.setPrcType((String)fields[j++]);                            
				obj.setPrcStatus((String)fields[j++]);                          
				obj.setPrcCreateUser((String)fields[j++]);                      
				obj.setPrcDid((String)fields[j++]);                             
				obj.setPrcPrcId((String)fields[j++]); 
				obj.setPrcCreateDate((Timestamp)fields[j++]);                    
				obj.setPrcWorkSpaceId((String)fields[j++]); 
				obj.setLastTskObjId((String)fields[j++]);                       
				obj.setLastTskName((String)fields[j++]);                        
				obj.setLastTskCreateUser((String)fields[j++]);                  
				obj.setLastTskCreateDate((Timestamp)fields[j++]);                  
				obj.setLastTskStatus((String)fields[j++]);                      
				obj.setLastTskType((String)fields[j++]);                        
				obj.setLastTskTitle((String)fields[j++]);                       
				obj.setLastTskAssignee((String)fields[j++]);                    
				obj.setLastTskExecuteDate((Timestamp)fields[j++]);                 
				obj.setLastTskDueDate((Timestamp)fields[j++]); 
				obj.setLastTskForm((String)fields[j++]);    
				obj.setLastTskWorkSpaceId((String)fields[j++]);                    
				int lastTaskCount = (Integer)fields[j] == null ? -1 : (Integer)fields[j];
				obj.setLastTskCount(lastTaskCount == 0 ? 1 : lastTaskCount);
				objList.add(obj);
			}
			list = objList;
			TaskWork[] objs = new TaskWork[list.size()];
			list.toArray(objs);
			return objs;
				
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	
	private Query appendExtendQuery(StringBuffer queryBuffer, PrcProcessInstCond cond) throws PrcException {
		
		String packageId = cond.getPackageId();
		String[] objIdIns = cond.getObjIdIns();
		String createUser = cond.getCreationUser();
		String prcStatus = cond.getStatus();
		Date creationDateFrom = cond.getCreationDateFrom();
		Date creationDateTo = cond.getCreationDateTo();
		
		int pageNo = cond.getPageNo();
		int pageSize = cond.getPageSize();
		
		queryBuffer.append(" from ( ");
		queryBuffer.append(" 		select ");
		queryBuffer.append(" 			 prcInst.prcObjId ");
		queryBuffer.append(" 			, prcInst.prcName ");
		queryBuffer.append(" 			, prcInst.prcCreateUser ");
		queryBuffer.append(" 			, prcInst.prcCreateDate ");
		queryBuffer.append(" 			, prcInst.prcModifyUser ");
		queryBuffer.append(" 			, prcInst.prcModifyDate ");
		queryBuffer.append(" 			, prcInst.prcStatus ");
		queryBuffer.append(" 			, prcInst.prcTitle ");
		queryBuffer.append(" 			, prcInst.prcDid ");
		queryBuffer.append(" 			, prcInst.prcPrcId ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskobjid ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskname ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskcreateuser ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskcreateDate ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskstatus ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tsktype ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tsktitle ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskassignee ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskexecuteDate ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskduedate ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskform ");
		queryBuffer.append(" 			, (select count(*) from tsktask where tskstatus='11' and tsktype='common' and tskprcInstId = prcInst.prcObjid) as lastTaskCount ");
		queryBuffer.append(" 		from  ");
		queryBuffer.append(" 			prcprcinst prcInst,  ");
		queryBuffer.append(" 			( ");
		queryBuffer.append(" 				select a.tskprcinstid as lastTask_tskprcinstid ");
		queryBuffer.append(" 						, task.tskobjid as lastTask_tskobjid ");
		queryBuffer.append(" 						, task.tskname as lastTask_tskname ");
		queryBuffer.append(" 						, task.tskcreateuser as lastTask_tskcreateuser ");
		queryBuffer.append(" 						, task.tskcreateDate as lastTask_tskcreateDate ");
		queryBuffer.append(" 						, task.tskstatus as lastTask_tskstatus ");
		queryBuffer.append(" 						, task.tsktype as lastTask_tsktype ");
		queryBuffer.append(" 						, task.tsktitle as lastTask_tsktitle ");
		queryBuffer.append(" 						, task.tskassignee as lastTask_tskassignee ");
		queryBuffer.append(" 						, task.tskexecuteDate as lastTask_tskexecuteDate ");
		queryBuffer.append(" 						, task.tskduedate as lastTask_tskduedate ");
		queryBuffer.append(" 						, task.tskform as lastTask_tskform ");
		queryBuffer.append(" 				from ( ");
		queryBuffer.append(" 						select tskprcinstId , max(tskCreatedate) as createDate  ");
		queryBuffer.append(" 						from tsktask  ");
		queryBuffer.append(" 						where tsktype='common'  ");
		queryBuffer.append(" 						group by tskprcinstid ");
		queryBuffer.append(" 					  ) a,	 ");
		queryBuffer.append(" 					  TskTask task		 ");
		queryBuffer.append(" 				where  ");
		queryBuffer.append(" 					a.createDate = task.tskcreatedate ");
		queryBuffer.append(" 			) prcInstInfo	 ");
		queryBuffer.append(" 		where ");
		queryBuffer.append(" 			prcInst.prcobjid=prcInstInfo.lastTask_tskprcinstid ");
		if (!CommonUtil.isEmpty(prcStatus))
			queryBuffer.append(" 			and prcInst.prcStatus = :prcStatus ");
		if (!CommonUtil.isEmpty(packageId))
			queryBuffer.append(" 			and prcInst.prcDid = :prcDid ");
		if (!CommonUtil.isEmpty(createUser))
			queryBuffer.append(" 			and prcInst.prcCreateUser = :createUser ");
		if (creationDateFrom != null)
			queryBuffer.append(" 			and prcInst.prcCreateDate > :creationDateFrom");
		if (creationDateTo != null)
			queryBuffer.append(" 			and prcInst.prcCreateDate < :creationDateTo");
		if (objIdIns != null && objIdIns.length != 0) {
			queryBuffer.append(" 			and prcInst.prcObjId in (");
			for (int i=0; i<objIdIns.length; i++) {
				if (i != 0)
					queryBuffer.append(", ");
				queryBuffer.append(":objIdIn").append(i);
			}
			queryBuffer.append(")");
		}
		queryBuffer.append(" 	)info ");
		queryBuffer.append(" 	left outer join ");
		queryBuffer.append(" 	( ");
		queryBuffer.append(" 		select prcinst.prcobjid as prcinstid ");
		queryBuffer.append(" 				, parentCtg.id as parentCtgId ");
		queryBuffer.append(" 				, parentCtg.name as parentCtg ");
		queryBuffer.append(" 				, ctg.id as subCtgId ");
		queryBuffer.append(" 				, ctg.name as subCtg ");
		queryBuffer.append(" 		from prcprcinst prcinst, swpackage pkg , swcategory ctg, swcategory parentCtg ");
		queryBuffer.append(" 		where prcinst.prcdid = pkg.packageid ");
		queryBuffer.append(" 			and pkg.categoryid = ctg.id ");
		queryBuffer.append(" 			and ctg.parentid = parentCtg.id ");
		queryBuffer.append(" 	) ctgInfo ");
		queryBuffer.append(" 	on info.prcobjid = ctginfo.prcinstid ");
		
		Query query = this.getSession().createSQLQuery(queryBuffer.toString());
		
		if (pageSize > 0|| pageNo >= 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}
		if (!CommonUtil.isEmpty(prcStatus))
			query.setString("prcStatus", prcStatus);
		if (!CommonUtil.isEmpty(packageId))
			query.setString("prcDid", packageId);
		if (!CommonUtil.isEmpty(createUser))
			query.setString("createUser", createUser);	
		if (creationDateFrom != null)
			query.setTimestamp("creationDateFrom", creationDateFrom);
		if (creationDateTo != null)
			query.setTimestamp("creationDateTo", creationDateTo);	
		if (objIdIns != null && objIdIns.length != 0) {
			for (int i=0; i<objIdIns.length; i++) {
				query.setString("objIdIn"+i, objIdIns[i]);
			}
		}
		return query;
	}

	public long getProcessInstExtendsSize(String user, PrcProcessInstCond cond) throws PrcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(*) ");
			Query query = this.appendExtendQuery(buf, cond);
			List list = query.list();
			
			long count =((Integer)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public PrcProcessInstExtend[] getProcessInstExtends(String user, PrcProcessInstCond cond) throws PrcException {
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append(" select  ctgInfo.parentCtgId ");
		queryBuffer.append(" 			, ctgInfo.parentCtg ");
		queryBuffer.append(" 			, ctgInfo.subCtgId ");
		queryBuffer.append(" 			, ctgInfo.subCtg  ");
		queryBuffer.append(" 			, info.* ");
		
		Query query = this.appendExtendQuery(queryBuffer, cond);
	
		List list = query.list();
		if (list == null || list.isEmpty())
			return null;
		List objList = new ArrayList();
		for (Iterator itr = list.iterator(); itr.hasNext();) {
			Object[] fields = (Object[]) itr.next();
			PrcProcessInstExtend obj = new PrcProcessInstExtend();
			int j = 0;
	
			obj.setParentCtgId((String)fields[j++]); 
			obj.setParentCtg((String)fields[j++]);
			obj.setSubCtgId((String)fields[j++]);
			obj.setSubCtg((String)fields[j++]);
			obj.setPrcObjId((String)fields[j++]);
			obj.setPrcName((String)fields[j++]);
			obj.setPrcCreateUser((String)fields[j++]);
			obj.setPrcCreateDate((Timestamp)fields[j++]);
			obj.setPrcModifyUser((String)fields[j++]);
			obj.setPrcModifyDate((Timestamp)fields[j++]);
			obj.setPrcStatus((String)fields[j++]);
			obj.setPrcTitle((String)fields[j++]);
			obj.setPrcDid((String)fields[j++]);
			obj.setPrcPrcId((String)fields[j++]);
			obj.setLastTask_tskObjId((String)fields[j++]);
			obj.setLastTask_tskName((String)fields[j++]);
			obj.setLastTask_tskCreateUser((String)fields[j++]);
			obj.setLastTask_tskCreateDate((Timestamp)fields[j++]);
			obj.setLastTask_tskStatus((String)fields[j++]);
			obj.setLastTask_tskType((String)fields[j++]);
			obj.setLastTask_tskTitle((String)fields[j++]);
			obj.setLastTask_tskAssignee((String)fields[j++]);
			obj.setLastTask_tskExecuteDate((Timestamp)fields[j++]);
			obj.setLastTask_tskDueDate((Timestamp)fields[j++]);
			obj.setLastTask_tskForm((String)fields[j++]);
			int lastTaskCount = (Integer)fields[j++];
			obj.setLastTask_tskCount(lastTaskCount == 0 ? 1 : lastTaskCount);
			objList.add(obj);
		}
		list = objList;
		PrcProcessInstExtend[] objs = new PrcProcessInstExtend[list.size()];
		list.toArray(objs);
		return objs;
	}
}
