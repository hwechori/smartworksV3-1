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
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.exception.SwdException;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.organization.exception.SwoException;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoCompanyCond;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.process.process.exception.PrcException;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;

import org.hibernate.Query;

public class SwaManagerImpl extends AbstractManager implements ISwaManager {

	private static ISwoManager getSwoManager() throws SwoException {
		return SwManagerFactory.getInstance().getSwoManager();
	}
	private static IPrcManager getPrcManager() throws PrcException {
		return SwManagerFactory.getInstance().getPrcManager();
	}
	private static ISwdManager getSwdManager() throws SwdException {
		return SwManagerFactory.getInstance().getSwdManager();
	}

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

	public String getUserMode(String user, String rscId, int type, String instId, String companyId) throws SwaException, SwoException, SwdException, PrcException {
		//saas 코드 수정
		if (CommonUtil.isEmpty(rscId))
			throw new SwaException("resourcId is null.");

		if (CommonUtil.isEmpty(companyId))
			throw new SwaException("SmartApi_getUserMode CompanyId is Null.");
		
		SwoCompanyCond companyCond = new SwoCompanyCond();
		companyCond.setId(companyId);
		if (getSwoManager().getCompanySize(user, companyCond) == 0)
			throw new SwaException("not exist companyId : " + companyId);

		// 리소스 권한 검토
		SwaResourceCond cond = new SwaResourceCond();
		cond.setResourceId(rscId);
		cond.setCompanyId(companyId);
		SwaResource[] rscs = getResources(user, cond, null);
		
		int modeInt = 0;
		int maxModeInt = 0;
		
		boolean readPms = true;
		
		String dept = null;
		SwoUser userObj = getSwoManager().getUser(user, user, null);
		if (userObj != null)
			dept = userObj.getDeptId();
		
		if (CommonUtil.isEmpty(rscs)) {
			SwaUserCond userCond = new SwaUserCond();
			userCond.setResourceId(rscId);
			userCond.setCompanyId(companyId);
			userCond.setMode(SwaResource.MODE_DELETE);
			if (getUserSize(user, userCond) != 0) {
				maxModeInt = 4;
			} else {
				userCond.setMode(SwaResource.MODE_MODIFY);
				if (getUserSize(user, userCond) != 0) {
					maxModeInt = 3;
				} else {
					userCond.setMode(SwaResource.MODE_WRITE);
					if (getUserSize(user, userCond) != 0) {
						maxModeInt = 2;
					} else {
						userCond.setMode(SwaResource.MODE_READ);
						if (getUserSize(user, userCond) != 0) {
							maxModeInt = 1;
						}
					}
				}
			}

			if (maxModeInt == 4 && isMode(user, dept, rscId, type, instId, SwaResource.MODE_DELETE, SwaResource.PERMISSION_SELECT, companyId)) {
				return SwaResource.MODE_DELETE;
			} else if (maxModeInt >= 3 && isMode(user, dept, rscId, type, instId, SwaResource.MODE_MODIFY, SwaResource.PERMISSION_SELECT, companyId)) {
				modeInt = 3;
			} else if (maxModeInt >= 2 && isMode(user, dept, rscId, type, instId, SwaResource.MODE_WRITE, SwaResource.PERMISSION_SELECT, companyId)) {
				modeInt = 2;
			} else if (maxModeInt >= 1 && isMode(user, dept, rscId, type, instId, SwaResource.MODE_READ, SwaResource.PERMISSION_SELECT, companyId)) {
				modeInt = 1;
			}
		} else {
			
			for (SwaResource rsc : rscs) {
				String mode = rsc.getMode();
				String pms = rsc.getPermission();
				if (CommonUtil.isEmpty(mode) || CommonUtil.isEmpty(pms))
					continue;
				if (mode.equalsIgnoreCase(SwaResource.MODE_READ)) {
					if (maxModeInt < 1)
						maxModeInt = 1;
					readPms = isMode(user, dept, rscId, type, instId, SwaResource.MODE_READ, pms, companyId);
					if (modeInt > 1 || !readPms)
						continue;
					modeInt = 1;
				} else if (mode.equalsIgnoreCase(SwaResource.MODE_WRITE)) {
					if (maxModeInt < 2)
						maxModeInt = 2;
					if (modeInt > 2 || !isMode(user, dept, rscId, type, instId, SwaResource.MODE_WRITE, pms, companyId))
						continue;
					modeInt = 2;
				} else if (mode.equalsIgnoreCase(SwaResource.MODE_MODIFY)) {
					if (maxModeInt < 3)
						maxModeInt = 3;
					if (modeInt > 3 || !isMode(user, dept, rscId, type, instId, SwaResource.MODE_MODIFY, pms, companyId))
						continue;
					modeInt = 3;
				} else if (mode.equalsIgnoreCase(SwaResource.MODE_DELETE)) {
					if (maxModeInt < 4)
						maxModeInt = 4;
					if (modeInt == 4 || isMode(user, dept, rscId, type, instId, SwaResource.MODE_DELETE, pms, companyId))
						return SwaResource.MODE_DELETE;
				}
			}
		}
		
		// 정의되지 않은 Mode에 대해서는 기본값 적용하여 결과 확인
		if (maxModeInt < 4) {
			if (isMode(user, dept, rscId, type, instId, SwaResource.MODE_DELETE, SwaResource.PERMISSION_NO, companyId))
				return SwaResource.MODE_DELETE;
			if (maxModeInt < 3) {
				if (isMode(user, dept, rscId, type, instId, SwaResource.MODE_MODIFY, SwaResource.PERMISSION_NO, companyId))
					return SwaResource.MODE_MODIFY;
				if (CommonUtil.isEmpty(instId) && modeInt == 2 && !readPms)
					return SwaResource.MODE_WRITEREAD;
				if (maxModeInt < 2) {
					if (isMode(user, dept, rscId, type, instId, SwaResource.MODE_WRITE, SwaResource.PERMISSION_ALL, companyId))
						return SwaResource.MODE_WRITE;
					if (maxModeInt < 1) {
						if (isMode(user, dept, rscId, type, instId, SwaResource.MODE_READ, SwaResource.PERMISSION_ALL, companyId))
							return SwaResource.MODE_READ;
					}
				}
			}
		}
		
		if (CommonUtil.isEmpty(instId) && modeInt == 2 && !readPms)
			return SwaResource.MODE_WRITEREAD;
		
		switch (modeInt) {
			case 0: return SwaResource.MODE_READONLY; 
			case 1: return SwaResource.MODE_READ;
			case 2: return SwaResource.MODE_WRITE;
			case 3: return SwaResource.MODE_MODIFY;
			case 4: return SwaResource.MODE_DELETE;
		}
		return null;
	}

	private boolean isMode(String user, String dept, String rscId, int type, String instId, String mode, String pms, String companyId) throws SwaException, SwdException, PrcException {
		// 전체공개 (모든 사용자에게 공개)
		if (pms.equalsIgnoreCase(SwaResource.PERMISSION_ALL))
			return true;
		
		// 선택공개 (선택된 사용자의 경우에만 공개)
		if (pms.equalsIgnoreCase(SwaResource.PERMISSION_SELECT)) {
			SwaUserCond userCond = new SwaUserCond();
			userCond.setMode(mode);
			userCond.setResourceId(rscId);
			userCond.setUserId(user);
			userCond.setCompanyId(companyId);
			if (getUserSize(user, userCond) != 0)
				return true;
			
			// 선택된 조직에 해당되는지 확인
			if (!CommonUtil.isEmpty(dept)) {
				userCond.setUserId(dept);
				if (getUserSize(user, userCond) != 0)
					return true;
			}

			if (CommonUtil.isEmpty(instId))
				return false;
			
			// 수정권한설정의 경우는 선택되지 않았더라도 작성자인 경우 수정 가능
			if (mode.equalsIgnoreCase(SwaResource.MODE_MODIFY)) {
				if (type ==1 || type == 2) {
					PrcProcessInstCond prcInstCond = new PrcProcessInstCond();
					prcInstCond.setObjId(instId);
					prcInstCond.setCompanyId(companyId);
					PrcProcessInst obj = getPrcManager().getProcessInst(user, prcInstCond, null);
					if (obj != null) {
						String prcInstCreator = obj.getCreationUser();
						if (prcInstCreator.equalsIgnoreCase(user)) {
							return true;
						}
					}
				} else {
					SwdRecordCond recCond = new SwdRecordCond();
					recCond.setCompanyId(companyId);
					recCond.setFormId(rscId);
					recCond.setRecordId(instId);
					recCond.setCreationUser(user);
					if (getSwdManager().getRecordSize(user, recCond) != 0)
						return true;
				}
			}
			return false;
		}
		
		// 비공개 (작성자에게만 공개)
		if (pms.equalsIgnoreCase(SwaResource.PERMISSION_NO)) {
			if (CommonUtil.isEmpty(instId))
				return false;
			if (type == SwaResource.TYPE_SINGLE) {
				SwdRecordCond recCond = new SwdRecordCond();
				recCond.setCompanyId(companyId);
				recCond.setFormId(rscId);
				recCond.setRecordId(instId);
				recCond.setCreationUser(user);
				if (getSwdManager().getRecordSize(user, recCond) == 0)
					return false;
				return true;
			} else if (type == SwaResource.TYPE_PROCESS) {
				PrcProcessInstCond prcCond = new PrcProcessInstCond();
				prcCond.setCompanyId(companyId);
				prcCond.setObjId(instId);
				prcCond.setCreationUser(user);
				if (getPrcManager().getProcessInstSize(user, prcCond) ==0)
					return false;
				return true;
			}
		}
		return false;
	}

}