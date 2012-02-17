package net.smartworks.server.engine.process.approval.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.approval.exception.AprException;
import net.smartworks.server.engine.process.approval.manager.IAprManager;
import net.smartworks.server.engine.process.approval.model.AprApproval;
import net.smartworks.server.engine.process.approval.model.AprApprovalCond;
import net.smartworks.server.engine.process.approval.model.AprApprovalDef;
import net.smartworks.server.engine.process.approval.model.AprApprovalLine;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineCond;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineDef;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineDefCond;
import net.smartworks.server.engine.process.link.manager.ILnkManager;

import org.hibernate.Query;

public class AprManagerImpl extends AbstractManager implements IAprManager {
	private ILnkManager lnkManager;
	public ILnkManager getLnkManager() {
		if(lnkManager == null)
			lnkManager = SwManagerFactory.getInstance().getLnkManager();
		return lnkManager;
	}
	public void setLnkManager(ILnkManager lnkManager) {
		this.lnkManager = lnkManager;
	}

	public AprManagerImpl() {
		super();
	}
	
	public AprApproval getApproval(String user, String objId, String level) throws AprException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				AprApproval obj = (AprApproval)get(AprApproval.class, objId);
				return obj;
			} else {
				AprApprovalCond cond = new AprApprovalCond();
				cond.setObjId(objId);
				AprApproval[] objs = this.getApprovals(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public AprApproval getApproval(String user, AprApprovalCond cond, String level) throws AprException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		AprApproval[] objs = getApprovals(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		if (objs.length != 1)
			throw new AprException("More than 1 Object");
		return objs[0];
	}
	public void setApproval(String user, AprApproval obj, String level) throws AprException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update AprApproval set");
				buf.append(" name=:name, creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", description=:description, status=:status");
				buf.append(", type=:type, approver=:approver, isMandatory=:isMandatory, isModifiable=:isModifiable");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(AprApproval.A_NAME, obj.getName());
				query.setString(AprApproval.A_DESCRIPTION, obj.getDescription());
				query.setString(AprApproval.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(AprApproval.A_CREATIONDATE, obj.getCreationDate());
				query.setString(AprApproval.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(AprApproval.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(AprApproval.A_DESCRIPTION, obj.getDescription());
				query.setString(AprApproval.A_STATUS, obj.getStatus());
				query.setString(AprApproval.A_TYPE, obj.getType());
				query.setString(AprApproval.A_APPROVER, obj.getApprover());
				query.setBoolean(AprApproval.A_ISMANDATORY, obj.isMandatory());
				query.setBoolean(AprApproval.A_ISMODIFIABLE, obj.isModifiable());
				query.setString(AprApproval.A_OBJID, obj.getObjId());
			}
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public void createApproval(String user, AprApproval obj) throws AprException {
		try {
			fill(user, obj);
			create(obj);
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public void removeApproval(String user, String objId) throws AprException {
		try {
			remove(AprApproval.class, objId);
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public void removeApproval(String user, AprApprovalCond cond) throws AprException {
		AprApproval obj = getApproval(user, cond, null);
		if (obj == null)
			return;
		removeApproval(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, AprApprovalCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		Date creationDateFrom = null;
		Date creationDateTo = null;
		String modificationUser = null;
		Date modificationDateFrom = null;
		Date modificationDateTo = null;
		String status = null;
		String type = null;
		String approver = null;
		boolean isApprovalLineNull = false;
		Property[] extProps = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			creationDateFrom = cond.getCreationDateFrom();
			creationDateTo = cond.getCreationDateTo();
			modificationUser = cond.getModificationUser();
			modificationDateFrom = cond.getModificationDateFrom();
			modificationDateTo = cond.getModificationDateTo();
			status = cond.getStatus();
			type = cond.getType();
			approver = cond.getApprover();
			isApprovalLineNull = cond.isApprovalLineNull();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from AprApproval obj");
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
			if (type != null)
				buf.append(" and obj.type = :type");
			if (approver != null)
				buf.append(" and obj.approver = :approver");
			if (isApprovalLineNull)
				buf.append(" and obj.approvalLine is null");
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
			if (type != null)
				query.setString("type", type);
			if (approver != null)
				query.setString("approver", approver);
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
	public long getApprovalSize(String user, AprApprovalCond cond) throws AprException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public AprApproval[] getApprovals(String user, AprApprovalCond cond, String level) throws AprException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser, obj.modificationDate");
				buf.append(", obj.status, obj.description");
				buf.append(", obj.type, obj.approver, obj.isMandatory, obj.isModifiable");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					AprApproval obj = new AprApproval();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setStatus(((String)fields[j++]));
					obj.setDescription(((String)fields[j++]));
					obj.setType((String)fields[j++]);
					obj.setApprover((String)fields[j++]);
					obj.setMandatory(CommonUtil.toBoolean(fields[j++]));
					obj.setModifiable(CommonUtil.toBoolean(fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			AprApproval[] objs = new AprApproval[list.size()];
			list.toArray(objs);
			return objs;
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}

	public AprApprovalLine getApprovalLine(String user, String objId, String level) throws AprException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				AprApprovalLine obj = (AprApprovalLine)get(AprApprovalLine.class, objId);
				return obj;
			} else {
				AprApprovalLineCond cond = new AprApprovalLineCond();
				cond.setObjId(objId);
				AprApprovalLine[] objs = this.getApprovalLines(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public AprApprovalLine getApprovalLine(String user, AprApprovalLineCond cond, String level) throws AprException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		AprApprovalLine[] objs = getApprovalLines(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		if (objs.length != 1)
			throw new AprException("More than 1 Object");
		return objs[0];
	}
	public void setApprovalLine(String user, AprApprovalLine obj, String level) throws AprException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
				AprApprovalCond cond = new AprApprovalCond();
				cond.setApprovalLineNull(true);
				AprApproval[] aprs = getApprovals(user, cond, null);
				if (!CommonUtil.isEmpty(aprs)) {
					int aprSize = aprs.length;
					for (int i=0; i<aprSize; i++)
						removeApproval(user, aprs[i].getObjId());
				}
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update AprApprovalLine set");
				buf.append(" name=:name, creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", description=:description, status=:status");
				buf.append(", correlation=:correlation");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(AprApprovalLine.A_NAME, obj.getName());
				query.setString(AprApprovalLine.A_DESCRIPTION, obj.getDescription());
				query.setString(AprApprovalLine.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(AprApprovalLine.A_CREATIONDATE, obj.getCreationDate());
				query.setString(AprApprovalLine.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(AprApprovalLine.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(AprApprovalLine.A_DESCRIPTION, obj.getDescription());
				query.setString(AprApprovalLine.A_STATUS, obj.getStatus());
				query.setString(AprApprovalLine.A_CORRELATION, obj.getCorrelation());
				query.setString(AprApprovalLine.A_OBJID, obj.getObjId());
			}
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public void createApprovalLine(String user, AprApprovalLine obj) throws AprException {
		try {
			fill(user, obj);
			create(obj);
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public void removeApprovalLine(String user, String objId) throws AprException {
		try {
			remove(AprApprovalLine.class, objId);
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public void removeApprovalLine(String user, AprApprovalLineCond cond) throws AprException {
		AprApprovalLine obj = getApprovalLine(user, cond, null);
		if (obj == null)
			return;
		removeApproval(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, AprApprovalLineCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		Date creationDateFrom = null;
		Date creationDateTo = null;
		String modificationUser = null;
		Date modificationDateFrom = null;
		Date modificationDateTo = null;
		String status = null;
		String correlation = null;
		Property[] extProps = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			creationDateFrom = cond.getCreationDateFrom();
			creationDateTo = cond.getCreationDateTo();
			modificationUser = cond.getModificationUser();
			modificationDateFrom = cond.getModificationDateFrom();
			modificationDateTo = cond.getModificationDateTo();
			status = cond.getStatus();
			correlation = cond.getCorrelation();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from AprApprovalLine obj");
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
			if (correlation != null)
				buf.append(" and obj.correlation = :correlation");
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
			if (correlation != null)
				query.setString("correlation", correlation);
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
	public long getApprovalLineSize(String user, AprApprovalLineCond cond) throws AprException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public AprApprovalLine[] getApprovalLines(String user, AprApprovalLineCond cond, String level) throws AprException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser, obj.modificationDate");
				buf.append(", obj.status, obj.description");
				buf.append(", obj.correlation");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					AprApprovalLine obj = new AprApprovalLine();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setStatus(((String)fields[j++]));
					obj.setDescription(((String)fields[j++]));
					obj.setCorrelation((String)fields[j++]);
					objList.add(obj);
				}
				list = objList;
			}
			AprApprovalLine[] objs = new AprApprovalLine[list.size()];
			list.toArray(objs);
			return objs;
		} catch (AprException e) {
			throw e;
		} catch (Exception e) {
			throw new AprException(e);
		}
	}
	public AprApprovalLineDef getApprovalLineDef(String userId, String objId, String level) throws AprException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				AprApprovalLineDef obj = (AprApprovalLineDef)this.get(AprApprovalLineDef.class, objId);
				return obj;
			} else {
				AprApprovalLineDefCond cond = new AprApprovalLineDefCond();
				cond.setObjId(objId);
				return getApprovalLineDef(userId, cond, level);
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new AprException(e);
		}
	}
	public AprApprovalLineDef getApprovalLineDef(String userId, AprApprovalLineDefCond cond, String level) throws AprException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		AprApprovalLineDef[] approvalLineDef = getApprovalLineDefs(userId, cond, level);
		if (CommonUtil.isEmpty(approvalLineDef))
			return null;
		try {
			if (approvalLineDef.length != 1)
				throw new AprException("More than 1 Object");
		} catch (AprException e) {
			logger.error(e, e);
			throw e;
		}
		return approvalLineDef[0];
	}
	public void setApprovalLineDef(String userId, AprApprovalLineDef obj, String level) throws AprException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(userId, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update ItmMenuItemList set");
				buf.append(" name=:name, companyId=:companyId");
				buf.append(", creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(", aprLineName=:aprLineName, aprDescription=:aprDescription, aprLevel=:aprLevel ");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(AprApprovalLineDef.A_NAME, obj.getName());
				query.setString(AprApprovalLineDef.A_COMPANYID, obj.getCompanyId());
				query.setString(AprApprovalLineDef.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(AprApprovalLineDef.A_CREATIONDATE, obj.getCreationDate());
				query.setString(AprApprovalLineDef.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(AprApprovalLineDef.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(AprApprovalLineDef.A_APRLINENAME, obj.getAprLineName());
				query.setString(AprApprovalLineDef.A_APRDESCRIPTION, obj.getAprDescription());
				query.setString(AprApprovalLineDef.A_APRLEVEL, obj.getAprLevel());
				query.setString(AprApprovalLineDef.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new AprException(e);
		}
	}
	public void createApprovalLineDef(String userId, AprApprovalLineDef obj) throws AprException {
		try {
			fill(userId, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new AprException(e);
		}
	}
	public void removeApprovalLineDef(String userId, String objId) throws AprException {
		try {
			remove(AprApprovalLineDef.class, objId);
		} catch (Exception e) {
			logger.error(e, e);
			throw new AprException(e);
		}
	}
	public void removeApprovalLineDef(String userId, AprApprovalLineDefCond cond) throws AprException {
		AprApprovalLineDef obj = getApprovalLineDef(userId, cond, null);
		if (obj == null)
			return;
		removeApprovalLineDef(userId, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, AprApprovalLineDefCond cond) throws Exception {
		String objId = null;
		String name = null;
		String nameLike = null;
		String companyId = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		String aprLineName = null;
		String aprDescription = null;
		String aprLevel = null;
		AprApprovalDef[] approvalDefs = null;
		
		
		if (cond != null) {
			objId = cond.getObjId();
			name = cond.getName();
			companyId = cond.getCompanyId();
			creationUser = cond.getCreationUser();
			creationDate = cond.getCreationDate();
			modificationUser = cond.getModificationUser();
			modificationDate = cond.getModificationDate();
			aprLineName = cond.getAprLineName();
			aprDescription = cond.getAprDescription();
			aprLevel = cond.getAprLevel();
			nameLike = cond.getNameLike();
		}
		buf.append(" from AprApprovalLineDef obj");
		if (approvalDefs != null && approvalDefs.length != 0) {
			for (int i=0; i<approvalDefs.length; i++) {
				buf.append(" left join obj.approvalDefs as approvalDef").append(i);
			}
		}
		
		buf.append(" where obj.id is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (name != null)
				buf.append(" and obj.name = :name");
			if (nameLike != null)
				buf.append(" and obj.aprLineName like :nameLike");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (creationDate != null)
				buf.append(" and obj.creationDate = :creationDate");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (modificationDate != null)
				buf.append(" and obj.modificationDate = :modificationDate");
			if (aprLineName != null)
				buf.append(" and obj.aprLineName = :aprLineName");
			if (aprDescription != null)
				buf.append(" and obj.aprDescription = :aprDescription");
			if (aprLevel != null)
				buf.append(" and obj.aprLevel = :aprLevel");

			if (approvalDefs != null && approvalDefs.length != 0) {
				for (int i=0; i<approvalDefs.length; i++) {
					AprApprovalDef approvalDef = approvalDefs[i];
					String type = approvalDef.getType();
					String aprName = approvalDef.getAprName();
					String aprPerson = approvalDef.getAprPerson();
					String dueDate = approvalDef.getDueDate();
					String level = approvalDef.getLevel();
					if (type != null)
						buf.append(" and approvalDef").append(i).append(".type = :type").append(i);
					if (aprName != null)
						buf.append(" and approvalDef").append(i).append(".aprName = :aprName").append(i);
					if (aprPerson != null)
						buf.append(" and approvalDef").append(i).append(".aprPerson = :aprPerson").append(i);
					if (dueDate != null)
						buf.append(" and approvalDef").append(i).append(".dueDate = :dueDate").append(i);
					if (level != null)
						buf.append(" and approvalDef").append(i).append(".level = :level").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (name != null)
				query.setString("name", name);
			if (nameLike != null)
				query.setString("nameLike", CommonUtil.toLikeString(nameLike));
			if (companyId != null)
				query.setString("companyId", companyId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (creationDate != null)
				query.setTimestamp("creationDate", creationDate);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (modificationDate != null)
				query.setTimestamp("modificationDate", modificationDate);
			if (aprLineName != null)
				query.setString("aprName", aprLineName);
			if (aprDescription != null)
				query.setString("aprDescription", aprDescription);
			if (aprLevel != null)
				query.setString("aprLevel", aprLevel);
			if (approvalDefs != null && approvalDefs.length != 0) {
				for (int i=0; i<approvalDefs.length; i++) {
					AprApprovalDef aprApprovalDef = approvalDefs[i];
					String type = aprApprovalDef.getType();
					String aprName = aprApprovalDef.getAprName();
					String aprPerson = aprApprovalDef.getAprPerson();
					String dueDate = aprApprovalDef.getDueDate();
					String level = aprApprovalDef.getLevel();

					if (type != null)
						query.setString("type"+i, type);
					if (aprName != null)
						query.setString("aprName"+i, aprName);
					if (aprPerson != null)
						query.setString("aprPerson"+i, aprPerson);
					if (dueDate != null)
						query.setString("dueDate"+i, dueDate);
					if (level != null)
						query.setString("level"+i, level);
				}
			}
		}
		return query;
	}
	public long getApprovalLineDefSize(String userId, AprApprovalLineDefCond cond) throws AprException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf,cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new AprException(e);
		}
	}
	public AprApprovalLineDef[] getApprovalLineDefs(String userId, AprApprovalLineDefCond cond, String level) throws AprException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.companyId"); 
				buf.append(", obj.creationUser, obj.creationDate");
				buf.append(", obj.modificationUser, obj.modificationDate");
				buf.append(", obj.aprLineName, obj.aprDescription,  obj.aprLevel");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					AprApprovalLineDef obj = new AprApprovalLineDef();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Date)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Date)fields[j++]));
					obj.setAprLineName(((String)fields[j++]));
					obj.setAprDescription(((String)fields[j++]));
					obj.setAprLevel(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			AprApprovalLineDef[] objs = new AprApprovalLineDef[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new AprException(e);
		}
	}
}