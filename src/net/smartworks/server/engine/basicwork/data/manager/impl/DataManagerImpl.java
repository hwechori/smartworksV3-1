/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.data.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.basicwork.data.exception.DataException;
import net.smartworks.server.engine.basicwork.data.manager.IDataManager;
import net.smartworks.server.engine.basicwork.data.model.Data;
import net.smartworks.server.engine.basicwork.data.model.DataCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class DataManagerImpl extends AbstractManager implements IDataManager {

	public DataManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public Data getData(String user, String objId, String level) throws DataException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				Data obj = (Data)get(Data.class, objId);
				return obj;
			} catch (Exception e) {
				throw new DataException(e);
			}
		} else {
			DataCond cond = new DataCond();
			cond.setObjId(objId);
			Data[] objs = this.getDatas(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public Data getData(String user, DataCond cond, String level)throws DataException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		Data[] senders = getDatas(user, cond, level);
		if (CommonUtil.isEmpty(senders))
			return null;
		if (senders.length > 1)
			throw new DataException("More than 1 sender. ");
		return senders[0];
	}
	public void setData(String user, Data obj, String level) throws DataException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update SWBData set ");
				buf.append(" title=:title, content=:content, fileGroupId=:fileGroupId, manager:manager, manageDept:manageDept, ");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(Data.A_TITLE, obj.getTitle());
				query.setString(Data.A_CONTENT, obj.getContent());
				query.setString(Data.A_FILEGROUPID, obj.getFileGroupId());
				query.setString(Data.A_MANAGER, obj.getManager());
				query.setString(Data.A_MANAGEDEPT, obj.getManageDept());
				query.setTimestamp(Data.A_CREATIONDATE, obj.getCreationDate());
				query.setString(Data.A_CREATIONUSER, obj.getCreationUser());
				query.setString(Data.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(Data.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(Data.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new DataException(e);
		}
	}

	public void createData(String user, Data obj) throws DataException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new DataException(e);
		}
	}
	public void removeData(String user, String objId) throws DataException {
		try {
			remove(Data.class, objId);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}
	public void removeData(String user, DataCond cond) throws DataException {
		Data obj = getData(user, cond, null);
		if (obj == null)
			return;
		removeData(user, obj.getObjId());

	}
	private Query appendQuery(StringBuffer buf, DataCond cond) throws Exception {
		String objId = null;
		String title = null;
		String content = null;
		String fileGroupId = null;
		String manager = null;
		String manageDept = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		
			if (cond != null) {
				objId = cond.getObjId();
				title = cond.getTitle();
				content = cond.getContent();
				fileGroupId = cond.getFileGroupId();
				manager = cond.getManager();
				manageDept = cond.getManageDept();
				creationUser = cond.getCreationUser();
				creationDate = cond.getCreationDate();
				modificationUser = cond.getModificationUser();
				modificationDate = cond.getModificationDate();
			}
			buf.append(" from SWBData obj");
			buf.append(" where obj.objId is not null");
			//TODO 시간 검색에 대한 확인 필요
			if (cond != null) {
				if (objId != null) 
					buf.append(" and obj.objId = :objId");
				if (title != null) 
					buf.append(" and obj.title = :title");
				if (content != null) 
					buf.append(" and obj.content = :content");
				if (fileGroupId != null) 
					buf.append(" and obj.fileGroupId = :fileGroupId");
				if (manager != null) 
					buf.append(" and obj.manager = :manager");
				if (manageDept != null) 
					buf.append(" and obj.manageDept = :manageDept");
				if (creationUser != null)
					buf.append(" and obj.creationUser = :creationUser");
				if (creationDate != null)
					buf.append(" and obj.creationDate = :creationDate");
				if (modificationUser != null)
					buf.append(" and obj.modificationUser = :modificationUser");
				if (modificationDate != null)
					buf.append(" and obj.modificationDate = :modificationDate");
				}
				this.appendOrderQuery(buf, "obj", cond);
				
				Query query = this.createQuery(buf.toString(), cond);
				if (cond != null) {
					if (objId != null)
						query.setString("objId", objId);
					if (title != null)
						query.setString("title", title);
					if (content != null)
						query.setString("content", content);
					if (fileGroupId != null)
						query.setString("fileGroupId", fileGroupId);
					if (manager != null)
						query.setString("manager", manager);
					if (manageDept != null)
						query.setString("manageDept", manageDept);
					if (creationUser != null)
						query.setString("creationUser", creationUser);
					if (creationDate != null)
						query.setTimestamp("creationDate", creationDate);
					if (modificationUser != null)
						query.setString("modificationUser", modificationUser);
					if (modificationDate != null)
						query.setTimestamp("modificationDate", modificationDate);
				}
			return query;
			
	}
	public long getDataSize(String user, DataCond cond) throws DataException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new DataException(e);
		}
	
	}
	public Data[] getDatas(String user, DataCond cond, String level) throws DataException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.title, obj.content, obj.fileGroupId, obj.manager, obj.manageDept,");
				buf.append(" obj.creationUser, obj.creationDate, obj.modificationUser, obj.modificationDate");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					Data obj = new Data();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setTitle((String)fields[j++]);
					obj.setContent((String)fields[j++]);
					obj.setFileGroupId((String)fields[j++]);
					obj.setManager((String)fields[j++]);
					obj.setManageDept((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			Data[] objs = new Data[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new DataException(e);
		}
	}

}