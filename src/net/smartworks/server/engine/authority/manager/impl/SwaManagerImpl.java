/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.authority.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.authority.exception.SwaException;
import net.smartworks.server.engine.authority.manager.ISwaManager;
import net.smartworks.server.engine.authority.model.SwaResource;
import net.smartworks.server.engine.authority.model.SwaResourceCond;
import net.smartworks.server.engine.authority.model.SwaUser;
import net.smartworks.server.engine.authority.model.SwaUserCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class SwaManagerImpl extends AbstractManager implements ISwaManager {
	public SwaManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}

	public SwaResource getResource(String user, String objId, String level) throws SwaException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				SwaResource obj = (SwaResource)get(SwaResource.class, objId);
				return obj;
			} catch (Exception e) {
				throw new SwaException(e);
			}
		} else {
			SwaResourceCond cond = new SwaResourceCond();
			cond.setObjId(objId);
			SwaResource[] objs = this.getResources(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public SwaResource getResource(String user, SwaResourceCond cond, String level) throws SwaException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		SwaResource[] objs = getResources(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		if (objs.length > 1)
			throw new SwaException("More than 1 resource authority.");
		return objs[0];
	}
	public void setResource(String user, SwaResource obj, String level) throws SwaException {
		try {
			set(obj);
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}
	public void removeResource(String user, String objId) throws SwaException {
		try {
			remove(SwaResource.class, objId);
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}
	public void removeResource(String user, SwaResourceCond cond) throws SwaException {
		SwaResource obj = getResource(user, cond, null);
		if (obj == null)
			return;
		removeResource(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, SwaResourceCond cond) throws Exception {
		String objId = null;
		String resourceId = null;
		int type = -1;
		String mode = null;
		String permission = null;
		String companyId = null;
		String creationUser = null;
		String modificationUser = null;

		if (cond != null) {
			objId = cond.getObjId();
			resourceId = cond.getResourceId();
			type = cond.getType();
			mode = cond.getMode();
			permission = cond.getPermission();
			companyId = cond.getCompanyId();
			creationUser = cond.getCreationUser();
			modificationUser = cond.getModificationUser();
		}
		buf.append(" from SwaResource obj");
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (resourceId != null)
				buf.append(" and obj.resourceId = :resourceId");
			if (type != -1)
				buf.append(" and obj.type = :type");
			if (mode != null)
				buf.append(" and obj.mode like :mode");
			if (permission != null)
				buf.append(" and obj.permission = :permission");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (resourceId != null)
				query.setString("resourceId", resourceId);
			if (type != -1)
				query.setInteger("type", type);
			if (mode != null)
				query.setString("mode", mode);
			if (permission != null)
				query.setString("permission", permission);
			if (companyId != null)
				query.setString("companyId", companyId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
		}
		return query;
	}
	public long getResourceSize(String user, SwaResourceCond cond) throws SwaException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}
	public SwaResource[] getResources(String user, SwaResourceCond cond, String level) throws SwaException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.resourceId, obj.type, obj.mode, obj.permission");
				buf.append(", obj.companyId, obj.creationUser, obj.creationDate, obj.modificationUser, obj.modificationDate");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List<SwaResource> objList = new ArrayList<SwaResource>();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					SwaResource obj = new SwaResource();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setResourceId((String)fields[j++]);
					obj.setType(CommonUtil.toInt(fields[j++]));
					obj.setMode((String)fields[j++]);
					obj.setPermission((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate((Timestamp)fields[j++]);
					obj.setModificationUser((String)fields[j++]);
					obj.setModificationDate((Timestamp)fields[j++]);
					objList.add(obj);
				}
				list = objList;
			}
			SwaResource[] objs = new SwaResource[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}

	public SwaUser getUser(String user, String objId, String level) throws SwaException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				SwaUser obj = (SwaUser)get(SwaUser.class, objId);
				return obj;
			} catch (Exception e) {
				throw new SwaException(e);
			}
		} else {
			SwaUserCond cond = new SwaUserCond();
			cond.setObjId(objId);
			SwaUser[] objs = this.getUsers(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public SwaUser getUser(String user, SwaUserCond cond, String level) throws SwaException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		SwaUser[] objs = getUsers(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		if (objs.length > 1)
			throw new SwaException("More than 1 user athority.");
		return objs[0];
	}
	public void setUser(String user, SwaUser obj, String level) throws SwaException {
		try {
			set(obj);
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}
	public void removeUser(String user, String objId) throws SwaException {
		try {
			remove(SwaUser.class, objId);
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}
	public void removeUser(String user, SwaUserCond cond) throws SwaException {
		SwaUser obj = getUser(user, cond, null);
		if (obj == null)
			return;
		removeUser(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, SwaUserCond cond) throws Exception {
		String objId = null;
		String resourceId = null;
		String type = null;
		String mode = null;
		String userId = null;
		String companyId = null;

		if (cond != null) {
			objId = cond.getObjId();
			resourceId = cond.getResourceId();
			type = cond.getType();
			mode = cond.getMode();
			userId = cond.getUserId();
			companyId = cond.getCompanyId();
		}
		buf.append(" from SwaUser obj");
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (resourceId != null)
				buf.append(" and obj.resourceId = :resourceId");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (mode != null)
				buf.append(" and obj.mode like :mode");
			if (userId != null)
				buf.append(" and obj.userId = :userId");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (resourceId != null)
				query.setString("resourceId", resourceId);
			if (type != null)
				query.setString("type", type);
			if (mode != null)
				query.setString("mode", mode);
			if (userId != null)
				query.setString("userId", userId);
			if (companyId != null)
				query.setString("companyId", companyId);
		}
		return query;
	}
	public long getUserSize(String user, SwaUserCond cond) throws SwaException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}
	public SwaUser[] getUsers(String user, SwaUserCond cond, String level) throws SwaException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.resourceId, obj.type, obj.mode, obj.userId, obj.companyId");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List<SwaUser> objList = new ArrayList<SwaUser>();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					SwaUser obj = new SwaUser();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setResourceId((String)fields[j++]);
					obj.setType((String)fields[j++]);
					obj.setMode((String)fields[j++]);
					obj.setUserId((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					objList.add(obj);
				}
				list = objList;
			}
			SwaUser[] objs = new SwaUser[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			throw new SwaException(e);
		}
	}

}