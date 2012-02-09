package net.smartworks.server.engine.process.process.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.ClassObject;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.process.process.exception.PrcException;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInstExtend;
import net.smartworks.server.engine.process.process.model.PrcProcessInstRel;
import net.smartworks.server.engine.process.process.model.PrcProcessInstRelCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInstVariable;
import net.smartworks.server.engine.process.process.model.PrcProcessInstVariableCond;
import net.smartworks.server.engine.process.process.model.PrcProcessVariable;
import net.smartworks.server.engine.process.process.model.PrcProcessVariableCond;
import net.smartworks.server.engine.process.process.model.PrcSwProcess;
import net.smartworks.server.engine.process.process.model.PrcSwProcessCond;

import org.hibernate.Query;

public class PrcManagerImpl extends AbstractManager implements IPrcManager {

	public PrcManagerImpl() {
		super();
	}
	public PrcProcessInst getProcessInst(String user, String id, String level)	throws PrcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				PrcProcessInst obj = (PrcProcessInst)get(PrcProcessInst.class, id);
				return obj;
			} else {
				PrcProcessInstCond cond = new PrcProcessInstCond();
				cond.setObjId(id);
				PrcProcessInst[] objs = this.getProcessInsts(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public PrcProcessInst getProcessInst(String user, PrcProcessInstCond cond, String level) throws PrcException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		PrcProcessInst[] objs = getProcessInsts(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		if (objs.length > 1)
			throw new PrcException("More than 1 Process Instance.");
		return objs[0];
	}
	public void setProcessInst(String user, PrcProcessInst obj, String level) throws PrcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				fill(user, obj);
				StringBuffer buf = new StringBuffer();
				buf.append("update PrcProcessInst set");
				buf.append(" name=:name, creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", description=:description");
				buf.append(", status=:status, title=:title, type=:type, packageId=:packageId, priority=:priority");
				buf.append(", diagramId=:diagramId, diagramVersion=:diagramVersion");
				buf.append(", processId=:processId, diagram=:diagram, isSubInstance=:isSubInstance");
				buf.append(", instVariable=:instVariable, workSpaceId=:workSpaceId, workSpaceType=:workSpaceType ");
				//buf.append(", companyId=:companyId");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(MisObject.A_NAME, obj.getName());
				query.setString(MisObject.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(MisObject.A_CREATIONDATE, obj.getCreationDate());
				query.setString(MisObject.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(MisObject.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(MisObject.A_DESCRIPTION, obj.getDescription());
				query.setString(MisObject.A_STATUS, obj.getStatus());
				query.setString(PrcProcessInst.A_TITLE, obj.getTitle());
				query.setString(PrcProcessInst.A_TYPE, obj.getType());
				query.setString(PrcProcessInst.A_PACKAGEID, obj.getPackageId());
				query.setString(PrcProcessInst.A_PRIORITY, obj.getPriority());
				query.setString(PrcProcessInst.A_DIAGRAMID, obj.getDiagramId());
				query.setString(PrcProcessInst.A_DIAGRAMVERSION, obj.getDiagramVersion());
				query.setString(PrcProcessInst.A_PROCESSID, obj.getProcessId());
				query.setString(PrcProcessInst.A_DIAGRAM, obj.getDiagram());
				query.setString(PrcProcessInst.A_ISSUBINSTANCE, obj.getIsSubInstance());
				query.setString(PrcProcessInst.A_INSTVARIABLE, obj.getInstVariable());
				query.setString(PrcProcessInst.A_WORKSPACEID, obj.getWorkSpaceId());
				query.setString(PrcProcessInst.A_WORKSPACETYPE, obj.getWorkSpaceType());
				//query.setString(PrcProcessInst.A_COMPANYID, obj.getCompanyId());
				query.setString(ClassObject.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void removeProcessInst(String user, String id) throws PrcException {
		try {
			remove(PrcProcessInst.class, id);
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	private Query appendQuery(StringBuffer buf, PrcProcessInstCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		Date creationDateFrom = null;
		Date creationDateTo = null;
		String modificationUser = null;
		Date modificationDateFrom = null;
		Date modificationDateTo = null;
		String status = null;
		String title = null;
		String titleLike = null;
		String type = null;
		String packageId = null;
		String priority = null;
		String diagramId = null;
		String diagramVersion = null;
		String processId = null;
		String diagram = null;
		String workSpaceId = null;
		String workSpaceType = null;
		//String companyId = null;
		Property[] extProps = null;
		String[] priorityIns = null;
		String[] priorityNotIns = null;
		String[] objIdIns = null;
		String searchKey = null;
		Filter[] filters = null;
		String logicalOperator = null;
		if (cond != null) {
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			creationDateFrom = cond.getCreationDateFrom();
			creationDateTo = cond.getCreationDateTo();
			modificationUser = cond.getModificationUser();
			modificationDateFrom = cond.getModificationDateFrom();
			modificationDateTo = cond.getModificationDateTo();
			status = cond.getStatus();
			title = cond.getTitle();
			titleLike = cond.getTitleLike();
			type = cond.getType();
			packageId = cond.getPackageId();
			priority = cond.getPriority();
			diagramId = cond.getDiagramId();
			diagramVersion = cond.getDiagramVersion();
			processId = cond.getProcessId();
			diagram = cond.getDiagram();
			workSpaceId = cond.getWorkSpaceId();
			workSpaceType = cond.getWorkSpaceType();
			//companyId = cond.getCompanyId();
			extProps = cond.getExtendedProperties();
			priorityIns = cond.getPriorityIns();
			priorityNotIns = cond.getPriorityNotIns();
			objIdIns = cond.getObjIdIns();
			searchKey = cond.getSearchKey();
			filters = cond.getFilter();
			logicalOperator = cond.getOperator();
		}
		buf.append(" from PrcProcessInst obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		Map filterMap = new HashMap();
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (creationDateFrom != null)
				buf.append(" and obj.creationDate >= :creationDateFrom");
			if (creationDateTo != null)
				buf.append(" and obj.creationDate <= :creationDateTo");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (modificationDateFrom != null)
				buf.append(" and obj.modificationDate >= :modificationDateFrom");
			if (modificationDateTo != null)
				buf.append(" and obj.modificationDate <= :modificationDateTo");
			if (status != null)
				buf.append(" and obj.status = :status");
			if (title != null)
				buf.append(" and obj.title = :title");
			if (titleLike != null)
				buf.append(" and obj.title like :titleLike");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (packageId != null)
				buf.append(" and obj.packageId = :packageId");
			if (priority != null)
				buf.append(" and obj.priority = :priority");
			if (diagramId != null)
				buf.append(" and obj.diagramId = :diagramId");
			if (diagramVersion != null)
				buf.append(" and obj.diagramVersion = :diagramVersion");
			if (processId != null)
				buf.append(" and obj.processId = :processId");
			if (diagram != null)
				buf.append(" and obj.diagram = :diagram");
			if (workSpaceId != null)
				buf.append(" and obj.workSpaceId = :workSpaceId");
			if (workSpaceType != null)
				buf.append(" and obj.workSpaceType = :workSpaceType");
			//if (companyId != null)
			//	buf.append(" and obj.companyId = :companyId");
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						buf.append(" and extProp").append(i).append(".name = :extName").append(i);
					if (extValue != null)
						buf.append(" and extProp").append(i).append(".value = :extValue").append(i);
				}
			}
			if (priorityIns != null && priorityIns.length != 0) {
				buf.append(" and obj.priority in (");
				for (int i=0; i<priorityIns.length; i++) {
					if (i != 0)
						buf.append(", ");
					buf.append(":priorityIn").append(i);
				}
				buf.append(")");
			}
			if (objIdIns != null && objIdIns.length != 0) {
				buf.append(" and obj.objId in (");
				for (int i=0; i<objIdIns.length; i++) {
					if (i != 0)
						buf.append(", ");
					buf.append(":objIdIn").append(i);
				}
				buf.append(")");
			}
			if (priorityNotIns != null && priorityNotIns.length != 0) {
				buf.append(" and obj.priority not in (");
				for (int i=0; i<priorityNotIns.length; i++) {
					if (i != 0)
						buf.append(", ");
					buf.append(":priorityNotIn").append(i);
				}
				buf.append(")");
			}
			if (searchKey != null)
				buf.append(" and (obj.title like :orScanKey)"); // append OR-conditions inside parentheses..
			if (filters != null) {
				if (!CommonUtil.isEmpty(filters)) {
					if (CommonUtil.isEmpty(logicalOperator))
						logicalOperator = "and";
					String operator;
					String left;
					String right;
					String rightType;
					int i = 0;
					
					for (int j = 0; j < filters.length; j++) {
						Filter f = filters[j];
						operator = f.getOperator();
						left = f.getLeftOperandValue();
						right = f.getRightOperandValue();
						rightType = f.getRightOperandType();
						if (left == null)
							throw new Exception("left operand of filter condition is null.");
						if (operator == null) {
							operator = "=";
						} else {
							operator = operator.trim();
						}
						//left = CommonUtil.toDefault(fieldColumnMap.get(left), left);
						buf.append(CommonUtil.SPACE).append(logicalOperator);
						
						String oper1;
						String oper2;
						if (operator.equalsIgnoreCase("datein")) {
							oper1 = ">=";
							oper2 = "<=";
							right = "a" + i++;
							filterMap.put(right, f);
							buf.append(CommonUtil.SPACE).append("(" + left);
							buf.append(CommonUtil.SPACE).append(oper1);
							buf.append(CommonUtil.SPACE).append(CommonUtil.COLON).append(right);
							buf.append(CommonUtil.SPACE).append("and");
							buf.append(CommonUtil.SPACE).append(left);
							buf.append(CommonUtil.SPACE).append(oper2);
							buf.append(CommonUtil.SPACE).append(CommonUtil.COLON).append("_" + right).append(")");
						} else if (operator.equalsIgnoreCase("datenotin")) {
							oper1 = "<";
							oper2 = ">";
							right = "a" + i++;
							filterMap.put(right, f);
							buf.append(CommonUtil.SPACE).append("(" + left);
							buf.append(CommonUtil.SPACE).append(oper1);
							buf.append(CommonUtil.SPACE).append(CommonUtil.COLON).append(right);
							buf.append(CommonUtil.SPACE).append("or");
							buf.append(CommonUtil.SPACE).append(left);
							buf.append(CommonUtil.SPACE).append(oper2);
							buf.append(CommonUtil.SPACE).append(CommonUtil.COLON).append("_" + right).append(")");
						} else {
							buf.append(CommonUtil.SPACE).append(left);
							if (right == null) {
								if (operator.equals("!=") || 
										(operator.indexOf("=") == -1 && !operator.equalsIgnoreCase("is"))) {
									buf.append(" is not null");
								} else {
									buf.append(" is null");
								}
							} else {
								if (rightType == null || !rightType.equalsIgnoreCase(Filter.OPERANDTYPE_FIELD)) {
									right = "a" + i++;
									filterMap.put(right, f);
								}
								buf.append(CommonUtil.SPACE).append(operator);
								buf.append(CommonUtil.SPACE).append(CommonUtil.COLON).append(right);
							}
							
						}
					}
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (creationDateFrom != null)
				query.setTimestamp("creationDateFrom", creationDateFrom);
			if (creationDateTo != null)
				query.setTimestamp("creationDateTo", creationDateTo);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (modificationDateFrom != null)
				query.setTimestamp("modificationDateFrom", modificationDateFrom);
			if (modificationDateTo != null)
				query.setTimestamp("modificationDateTo", modificationDateTo);
			if (status != null)
				query.setString("status", status);
			if (title != null)
				query.setString("title", title);
			if (type != null)
				query.setString("type", type);
			if (packageId != null)
				query.setString("packageId", packageId);
			if (titleLike != null)
				query.setString("titleLike", CommonUtil.toLikeString(titleLike));
			if (priority != null)
				query.setString("priority", priority);
			if (diagramId != null)
				query.setString("diagramId", diagramId);
			if (diagramVersion != null)
				query.setString("diagramVersion", diagramVersion);
			if (processId != null)
				query.setString("processId", processId);
			if (diagram != null)
				query.setString("diagram", diagram);
			if (workSpaceId != null)
				query.setString("workSpaceId", workSpaceId);
			if (workSpaceType != null)
				query.setString("workSpaceType", workSpaceType);
			//if (companyId != null)
			//	query.setString("companyId", companyId);
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						query.setString("extName"+i, extName);
					if (extValue != null)
						query.setString("extValue"+i, extValue);
				}
			}
			if (priorityIns != null && priorityIns.length != 0) {
				for (int i=0; i<priorityIns.length; i++) {
					query.setString("priorityIn"+i, priorityIns[i]);
				}
			}
			if (objIdIns != null && objIdIns.length != 0) {
				for (int i=0; i<objIdIns.length; i++) {
					query.setString("objIdIn"+i, objIdIns[i]);
				}
			}
			if (priorityNotIns != null && priorityNotIns.length != 0) {
				for (int i=0; i<priorityNotIns.length; i++) {
					query.setString("priorityNotIn"+i, priorityNotIns[i]);
				}
			}
			if (searchKey != null)
				query.setString("orScanKey", CommonUtil.toLikeString(searchKey));
			if (filters != null) {
				if (!CommonUtil.isEmpty(filterMap)) {
					Filter f;
					String operType;
					String operValue;
					String operator;
					
					Iterator keyItr = filterMap.keySet().iterator();
					String param = null;
					while (keyItr.hasNext()) {
						param = (String)keyItr.next();
						f = (Filter)filterMap.get(param);
						operType = f.getRightOperandType();
						operator = f.getOperator();
						if (operator.equalsIgnoreCase("like")) {
							operValue = CommonUtil.toLikeString(f.getRightOperandValue());
						} else {
							operValue = f.getRightOperandValue();
						}	
						if (operType == null || operType.equalsIgnoreCase(Filter.OPERANDTYPE_STRING)) {
							query.setString(param, operValue);
						} else if (operType.equalsIgnoreCase(Filter.OPERANDTYPE_INT)) {
							query.setInteger(param, CommonUtil.toInt(operValue));
						} else if (operType.equalsIgnoreCase(Filter.OPERANDTYPE_FLOAT)) {
							query.setFloat(param, CommonUtil.toFloat(operValue));
						} else if (operType.equalsIgnoreCase(Filter.OPERANDTYPE_DATE)) {
							 if (operator.equalsIgnoreCase("datein") || operator.equalsIgnoreCase("datenotin")) {
									query.setTimestamp(param, DateUtil.toFromDate(DateUtil.toDate(operValue), DateUtil.CYCLE_DAY));
									query.setTimestamp("_" + param, DateUtil.toToDate(DateUtil.toDate(operValue), DateUtil.CYCLE_DAY));
								 } else {
									query.setTimestamp(param, DateUtil.toDate(operValue));
								 }		
							} else if (operType.equalsIgnoreCase("number")) {
							query.setDouble(param, Double.parseDouble(operValue));
						} else if (operType.equalsIgnoreCase("boolean")) {
							query.setBoolean(param, CommonUtil.toBoolean(operValue));
						} else {
							query.setParameter(param, operValue);
						}
					}
				}
			}
		}
		return query;
	}
	
	public long getProcessInstSize(String user, PrcProcessInstCond cond) throws PrcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public PrcProcessInst[] getProcessInsts(String user, PrcProcessInstCond cond, String level) throws PrcException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser, obj.modificationDate");
				buf.append(", obj.status, obj.title, obj.type, obj.packageId, obj.priority");
				buf.append(", obj.diagramId, obj.diagramVersion, obj.processId, obj.diagram, obj.isSubInstance");
				buf.append(", obj.instVariable, obj.workSpaceId, obj.workSpaceType ");
				//buf.append(", obj.companyId");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					PrcProcessInst obj = new PrcProcessInst();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setStatus(((String)fields[j++]));
					obj.setTitle(((String)fields[j++]));
					obj.setType(((String)fields[j++]));
					obj.setPackageId(((String)fields[j++]));
					obj.setPriority(((String)fields[j++]));
					obj.setDiagramId(((String)fields[j++]));
					obj.setDiagramVersion(((String)fields[j++]));
					obj.setProcessId(((String)fields[j++]));
					obj.setDiagram(((String)fields[j++]));
					obj.setIsSubInstance((String)fields[j++]);
					obj.setInstVariable((String)fields[j++]);
					obj.setWorkSpaceId((String)fields[j++]);
					obj.setWorkSpaceType((String)fields[j++]);
					//obj.setCompanyId(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			PrcProcessInst[] objs = new PrcProcessInst[list.size()];
			list.toArray(objs);
			return objs;
		} catch (PrcException e) {
			throw e;
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
		queryBuffer.append(" 			, prcInst.prcWorkSpaceId ");
		queryBuffer.append(" 			, prcInst.prcWorkSpaceType ");
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
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskWorkSpaceId ");
		queryBuffer.append(" 			, prcInstInfo.lastTask_tskWorkSpaceType ");
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
		queryBuffer.append(" 						, task.tskWorkSpaceId as lastTask_tskWorkSpaceId ");
		queryBuffer.append(" 						, task.tskWorkSpaceType as lastTask_tskWorkSpaceType ");
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
		
		this.appendOrderQuery(queryBuffer, "info", cond);
		
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
			obj.setPrcWorkSpaceId((String)fields[j++]);
			obj.setPrcWorkSpaceType((String)fields[j++]);
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
			obj.setLastTask_tskWorkSpaceId((String)fields[j++]);
			obj.setLastTask_tskWorkSpaceType((String)fields[j++]);
			int lastTaskCount = (Integer)fields[j++];
			obj.setLastTask_tskCount(lastTaskCount == 0 ? 1 : lastTaskCount);
			objList.add(obj);
		}
		list = objList;
		PrcProcessInstExtend[] objs = new PrcProcessInstExtend[list.size()];
		list.toArray(objs);
		return objs;
	}

	public PrcProcess getProcess(String user, String id, String level)	throws PrcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				PrcProcess obj = (PrcProcess)get(PrcProcess.class, id);
				return obj;
			} else {
				PrcProcessCond cond = new PrcProcessCond();
				cond.setObjId(id);
				PrcProcess[] objs = this.getProcesses(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void setProcess(String user, PrcProcess obj, String level) throws PrcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update PrcProcess set");
				buf.append(" name=:name, creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", description=:description");
				buf.append(", diagramId=:diagramId, diagramVersion=:diagramVersion");
				buf.append(", processId=:processId, diagram=:diagram");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(MisObject.A_NAME, obj.getName());
				query.setString(MisObject.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(MisObject.A_CREATIONDATE, obj.getCreationDate());
				query.setString(MisObject.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(MisObject.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(MisObject.A_DESCRIPTION, obj.getDescription());
				query.setString(PrcProcess.A_DIAGRAMID, obj.getDiagramId());
				query.setString(PrcProcess.A_DIAGRAMVERSION, obj.getDiagramVersion());
				query.setString(PrcProcess.A_PROCESSID, obj.getProcessId());
				query.setString(PrcProcess.A_DIAGRAM, obj.getDiagram());
				query.setString(ClassObject.A_OBJID, obj.getObjId());
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void removeProcess(String user, String id) throws PrcException {
		try {
			remove(PrcProcess.class, id);
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	private Query appendQuery(StringBuffer buf, PrcProcessCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		String modificationUser = null;
		String diagramId = null;
		String diagramVersion = null;
		String processId = null;
		String diagram = null;
		Property[] extProps = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			modificationUser = cond.getModificationUser();
			diagramId = cond.getDiagramId();
			diagramVersion = cond.getDiagramVersion();
			processId = cond.getProcessId();
			diagram = cond.getDiagram();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from PrcProcess obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (diagramId != null)
				buf.append(" and obj.diagramId = :diagramId");
			if (diagramVersion != null)
				buf.append(" and obj.diagramVersion = :diagramVersion");
			if (processId != null)
				buf.append(" and obj.processId = :processId");
			if (diagram != null)
				buf.append(" and obj.diagram = :diagram");
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						buf.append(" and extProp").append(i).append(".name = :extName").append(i);
					if (extValue != null)
						buf.append(" and extProp").append(i).append(".value = :extValue").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (diagramId != null)
				query.setString("diagramId", diagramId);
			if (diagramVersion != null)
				query.setString("diagramVersion", diagramVersion);
			if (processId != null)
				query.setString("processId", processId);
			if (diagram != null)
				query.setString("diagram", diagram);
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						query.setString("extName"+i, extName);
					if (extValue != null)
						query.setString("extValue"+i, extValue);
				}
			}
		}
		return query;
	}
	public long getProcessSize(String user, PrcProcessCond cond) throws PrcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public PrcProcess[] getProcesses(String user, PrcProcessCond cond, String level) throws PrcException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.modificationDate, obj.diagramId, obj.diagramVersion, obj.processId, obj.diagram");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					PrcProcess obj = new PrcProcess();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setDiagramId(((String)fields[j++]));
					obj.setDiagramVersion(((String)fields[j++]));
					obj.setProcessId(((String)fields[j++]));
					obj.setDiagram(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			PrcProcess[] objs = new PrcProcess[list.size()];
			list.toArray(objs);
			return objs;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	
	public PrcProcessInstRel getProcessInstRel(String user, String id, String level)	throws PrcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				PrcProcessInstRel obj = (PrcProcessInstRel)get(PrcProcessInstRel.class, id);
				return obj;
			} else {
				PrcProcessInstRelCond cond = new PrcProcessInstRelCond();
				cond.setObjId(id);
				PrcProcessInstRel[] objs = this.getProcessInstRels(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void setProcessInstRel(String user, PrcProcessInstRel obj, String level) throws PrcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update PrcProcessInstRel set");
				buf.append(" creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", type=:type");
				buf.append(", instanceId=:instanceId, pInstanceId=:pInstanceId");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(MisObject.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(MisObject.A_CREATIONDATE, obj.getCreationDate());
				query.setString(MisObject.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(MisObject.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(PrcProcessInstRel.A_TYPE, obj.getType());
				query.setString(PrcProcessInstRel.A_INSTANCEID, obj.getInstanceId());
				query.setString(PrcProcessInstRel.A_PINSTANCEID, obj.getPinstanceId());
				query.setString(ClassObject.A_OBJID, obj.getObjId());
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void removeProcessInstRel(String user, String id) throws PrcException {
		try {
			remove(PrcProcessInstRel.class, id);
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	private Query appendQuery(StringBuffer buf, PrcProcessInstRelCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		String modificationUser = null;
		String type = null;
		String instanceId = null;
		String pInstanceId = null;
		Property[] extProps = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			modificationUser = cond.getModificationUser();
			type = cond.getType();
			instanceId = cond.getInstanceId();
			pInstanceId = cond.getPInstanceId();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from PrcProcessInstRel obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (instanceId != null)
				buf.append(" and obj.instanceId = :instanceId");
			if (pInstanceId != null)
				buf.append(" and obj.pInstanceId = :pInstanceId");
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						buf.append(" and extProp").append(i).append(".name = :extName").append(i);
					if (extValue != null)
						buf.append(" and extProp").append(i).append(".value = :extValue").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (type != null)
				query.setString("type", type);
			if (instanceId != null)
				query.setString("instanceId", instanceId);
			if (pInstanceId != null)
				query.setString("pInstanceId", pInstanceId);
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						query.setString("extName"+i, extName);
					if (extValue != null)
						query.setString("extValue"+i, extValue);
				}
			}
		}
		return query;
	}
	public long getProcessInstRelSize(String user, PrcProcessInstRelCond cond) throws PrcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public PrcProcessInstRel[] getProcessInstRels(String user, PrcProcessInstRelCond cond, String level) throws PrcException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.modificationDate, obj.type, obj.instanceId, obj.pInstanceId");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					PrcProcessInstRel obj = new PrcProcessInstRel();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setType(((String)fields[j++]));
					obj.setInstanceId(((String)fields[j++]));
					obj.setPinstanceId(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			PrcProcessInstRel[] objs = new PrcProcessInstRel[list.size()];
			list.toArray(objs);
			return objs;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	
	public PrcProcessVariable getProcessVariable(String user, String id, String level)	throws PrcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				PrcProcessVariable obj = (PrcProcessVariable)get(PrcProcessVariable.class, id);
				return obj;
			} else {
				PrcProcessVariableCond cond = new PrcProcessVariableCond();
				cond.setObjId(id);
				PrcProcessVariable[] objs = this.getProcessVariables(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void setProcessVariable(String user, PrcProcessVariable obj, String level) throws PrcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update PrcProcessVariable set");
				buf.append(" name=:name, creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", processId=:processId, type=:type");
				buf.append(", initialValue=:initialValue, required=:required");
				buf.append(", mode=:mode");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(MisObject.A_NAME, obj.getName());
				query.setString(MisObject.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(MisObject.A_CREATIONDATE, obj.getCreationDate());
				query.setString(MisObject.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(MisObject.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(PrcProcessVariable.A_PROCESSID, obj.getProcessId());
				query.setString(PrcProcessVariable.A_TYPE, obj.getType());
				query.setString(PrcProcessVariable.A_INITIALVALUE, obj.getInitialValue());
				query.setBoolean(PrcProcessVariable.A_REQUIRED, obj.isRequired());
				query.setString(PrcProcessVariable.A_MODE, obj.getMode());
				query.setString(ClassObject.A_OBJID, obj.getObjId());
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void removeProcessVariable(String user, String id) throws PrcException {
		try {
			remove(PrcProcessVariable.class, id);
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	private Query appendQuery(StringBuffer buf, PrcProcessVariableCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		String modificationUser = null;
		String processId = null;
		String type = null;
		String mode = null;
		Property[] extProps = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			modificationUser = cond.getModificationUser();
			processId = cond.getProcessId();
			type = cond.getType();
			mode = cond.getMode();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from PrcProcessVariable obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (processId != null)
				buf.append(" and obj.processId = :processId");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (mode != null)
				buf.append(" and obj.mode = :mode");
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						buf.append(" and extProp").append(i).append(".name = :extName").append(i);
					if (extValue != null)
						buf.append(" and extProp").append(i).append(".value = :extValue").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (processId != null)
				query.setString("processId", processId);
			if (type != null)
				query.setString("type", type);
			if (mode != null)
				query.setString("mode", mode);
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						query.setString("extName"+i, extName);
					if (extValue != null)
						query.setString("extValue"+i, extValue);
				}
			}
		}
		return query;
	}
	public long getProcessVariableSize(String user, PrcProcessVariableCond cond) throws PrcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public PrcProcessVariable[] getProcessVariables(String user, PrcProcessVariableCond cond, String level) throws PrcException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.processId, obj.type, obj.initialValue, obj.required, obj.mode");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					PrcProcessVariable obj = new PrcProcessVariable();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setProcessId(((String)fields[j++]));
					obj.setType(((String)fields[j++]));
					obj.setInitialValue(((String)fields[j++]));
					obj.setRequired(CommonUtil.toBoolean(fields[j++]));
					obj.setMode(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			PrcProcessVariable[] objs = new PrcProcessVariable[list.size()];
			list.toArray(objs);
			return objs;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	public PrcProcessInstVariable getProcessInstVariable(String user, String id, String level)	throws PrcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				PrcProcessInstVariable obj = (PrcProcessInstVariable)get(PrcProcessInstVariable.class, id);
				return obj;
			} else {
				PrcProcessInstVariableCond cond = new PrcProcessInstVariableCond();
				cond.setObjId(id);
				PrcProcessInstVariable[] objs = this.getProcessInstVariables(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void setProcessInstVariable(String user, PrcProcessInstVariable obj, String level) throws PrcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update PrcProcessInstVariable set");
				buf.append(" name=:name, creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", type=:type, prcInstId=:prcInstId");
				buf.append(", prcVariableId=:prcVariableId, required=:required");
				buf.append(", mode=:mode, value=:value");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(MisObject.A_NAME, obj.getName());
				query.setString(MisObject.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(MisObject.A_CREATIONDATE, obj.getCreationDate());
				query.setString(MisObject.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(MisObject.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(PrcProcessInstVariable.A_TYPE, obj.getType());
				query.setString(PrcProcessInstVariable.A_PRCINSTID, obj.getPrcInstId());
				query.setString(PrcProcessInstVariable.A_PRCVARIABLEID, obj.getPrcVariableId());
				query.setBoolean(PrcProcessInstVariable.A_REQUIRED, obj.isRequired());
				query.setString(PrcProcessInstVariable.A_MODE, obj.getMode());
				query.setString(PrcProcessInstVariable.A_VALUE, obj.getValue());
				query.setString(ClassObject.A_OBJID, obj.getObjId());
			}
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public void removeProcessInstVariable(String user, String id) throws PrcException {
		try {
			remove(PrcProcessInstVariable.class, id);
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	private Query appendQuery(StringBuffer buf, PrcProcessInstVariableCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		String modificationUser = null;
		String prcInstId = null;
		String prcVariableId = null;
		String type = null;
		String mode = null;
		Property[] extProps = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			modificationUser = cond.getModificationUser();
			prcInstId = cond.getPrcInstId();
			prcVariableId = cond.getPrcVariableId();
			type = cond.getType();
			mode = cond.getMode();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from PrcProcessInstVariable obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (prcInstId != null)
				buf.append(" and obj.prcInstId = :prcInstId");
			if (prcVariableId != null)
				buf.append(" and obj.prcVariableId = :prcVariableId");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (mode != null)
				buf.append(" and obj.mode = :mode");
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						buf.append(" and extProp").append(i).append(".name = :extName").append(i);
					if (extValue != null)
						buf.append(" and extProp").append(i).append(".value = :extValue").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (prcInstId != null)
				query.setString("prcInstId", prcInstId);
			if (prcVariableId != null)
				query.setString("prcVariableId", prcVariableId);
			if (type != null)
				query.setString("type", type);
			if (mode != null)
				query.setString("mode", mode);
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						query.setString("extName"+i, extName);
					if (extValue != null)
						query.setString("extValue"+i, extValue);
				}
			}
		}
		return query;
	}
	public long getProcessInstVariableSize(String user, PrcProcessInstVariableCond cond) throws PrcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	public PrcProcessInstVariable[] getProcessInstVariables(String user, PrcProcessInstVariableCond cond, String level) throws PrcException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.type, obj.prcInstId, obj.prcVariableId, obj.required, obj.mode, obj.value");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					PrcProcessInstVariable obj = new PrcProcessInstVariable();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setType(((String)fields[j++]));
					obj.setPrcInstId(((String)fields[j++]));
					obj.setPrcVariableId(((String)fields[j++]));
					obj.setRequired(CommonUtil.toBoolean(fields[j++]));
					obj.setMode(((String)fields[j++]));
					obj.setValue(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			PrcProcessInstVariable[] objs = new PrcProcessInstVariable[list.size()];
			list.toArray(objs);
			return objs;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
	private Query appendQuery(StringBuffer buf, PrcSwProcessCond cond) throws Exception {
		String id = null;
		String packageId = null;
		int version = -1;
		String processId = null;
		String status = null;
		
		if (cond != null) {
			id = cond.getId();
			packageId = cond.getPackageId();
			version = cond.getVersion();
			processId = cond.getProcessId();
			status = cond.getStatus();
		}
		buf.append(" from PrcSwProcess obj");
		buf.append(" where obj.id is not null");
		if (cond != null) {
			if (id != null)
				buf.append(" and obj.id = :id");
			if (packageId != null)
				buf.append(" and obj.packageId = :packageId");
			if (version != -1)
				buf.append(" and obj.version = :version");
			if (processId != null)
				buf.append(" and obj.processId = :processId");
			if (status != null)
				buf.append(" and obj.status = :status");
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (id != null)
				query.setString("id", id);
			if (packageId != null)
				query.setString("packageId", packageId);
			if (version != -1)
				query.setInteger("version", version);
			if (processId != null)
				query.setString("processId", processId);
			if (status != null)
				query.setString("status", status);
		}
		return query;
	}
	public PrcSwProcess[] getSwProcesses(String user, PrcSwProcessCond cond) throws PrcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" obj");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			PrcSwProcess[] objs = new PrcSwProcess[list.size()];
			list.toArray(objs);
			return objs;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}
}
