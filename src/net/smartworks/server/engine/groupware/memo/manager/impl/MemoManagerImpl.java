/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.groupware.memo.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.groupware.memo.exception.MemoException;
import net.smartworks.server.engine.groupware.memo.manager.IMemoManager;
import net.smartworks.server.engine.groupware.memo.model.Memo;
import net.smartworks.server.engine.groupware.memo.model.MemoCond;

import org.hibernate.Query;

public class MemoManagerImpl extends AbstractManager implements IMemoManager {

	public MemoManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public Memo getMemo(String user, String objId, String level) throws MemoException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				Memo obj = (Memo)get(Memo.class, objId);
				return obj;
			} catch (Exception e) {
				throw new MemoException(e);
			}
		} else {
			MemoCond cond = new MemoCond();
			cond.setObjId(objId);
			Memo[] objs = this.getMemos(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public Memo getMemo(String user, MemoCond cond, String level)throws MemoException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		Memo[] senders = getMemos(user, cond, level);
		if (CommonUtil.isEmpty(senders))
			return null;
		if (senders.length > 1)
			throw new MemoException("More than 1 sender. ");
		return senders[0];
	}
	public void setMemo(String user, Memo obj, String level) throws MemoException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update Memo set ");
				buf.append(" title=:title, content=:content,");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(Memo.A_TITLE, obj.getTitle());
				query.setString(Memo.A_CONTENT, obj.getContent());
				query.setTimestamp(Memo.A_CREATIONDATE, obj.getCreationDate());
				query.setString(Memo.A_CREATIONUSER, obj.getCreationUser());
				query.setString(Memo.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(Memo.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(Memo.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new MemoException(e);
		}
	}

	public void createMemo(String user, Memo obj) throws MemoException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new MemoException(e);
		}
	}
	public void removeMemo(String user, String objId) throws MemoException {
		try {
			remove(Memo.class, objId);
		} catch (Exception e) {
			throw new MemoException(e);
		}
	}
	public void removeMemo(String user, MemoCond cond) throws MemoException {
		Memo obj = getMemo(user, cond, null);
		if (obj == null)
			return;
		removeMemo(user, obj.getObjId());

	}
	private Query appendQuery(StringBuffer buf, MemoCond cond) throws Exception {
		String objId = null;
		String title = null;
		String content = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		
			if (cond != null) {
				objId = cond.getObjId();
				title = cond.getTitle();
				content = cond.getContent();
				creationUser = cond.getCreationUser();
				creationDate = cond.getCreationDate();
				modificationUser = cond.getModificationUser();
				modificationDate = cond.getModificationDate();
			}
			buf.append(" from Memo obj");
			buf.append(" where obj.objId is not null");
			//TODO 시간 검색에 대한 확인 필요
			if (cond != null) {
				if (objId != null) 
					buf.append(" and obj.objId = :objId");
				if (title != null) 
					buf.append(" and obj.title = :title");
				if (content != null) 
					buf.append(" and obj.content = :content");
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
	public long getMemoSize(String user, MemoCond cond) throws MemoException {
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
			throw new MemoException(e);
		}
	
	}
	public Memo[] getMemos(String user, MemoCond cond, String level) throws MemoException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.title, obj.content,");
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
					Memo obj = new Memo();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setTitle((String)fields[j++]);
					obj.setContent((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			Memo[] objs = new Memo[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new MemoException(e);
		}
	}

}