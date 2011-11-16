/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.notice.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.basicwork.notice.exception.NoticeException;
import net.smartworks.server.engine.basicwork.notice.manager.INoticeManager;
import net.smartworks.server.engine.basicwork.notice.model.Notice;
import net.smartworks.server.engine.basicwork.notice.model.NoticeCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class NoticeManagerImpl extends AbstractManager implements INoticeManager {

	public NoticeManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public Notice getNotice(String user, String objId, String level) throws NoticeException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				Notice obj = (Notice)get(Notice.class, objId);
				return obj;
			} catch (Exception e) {
				throw new NoticeException(e);
			}
		} else {
			NoticeCond cond = new NoticeCond();
			cond.setObjId(objId);
			Notice[] objs = this.getNotices(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public Notice getNotice(String user, NoticeCond cond, String level)throws NoticeException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		Notice[] senders = getNotices(user, cond, level);
		if (CommonUtil.isEmpty(senders))
			return null;
		if (senders.length > 1)
			throw new NoticeException("More than 1 sender. ");
		return senders[0];
	}
	public void setNotice(String user, Notice obj, String level) throws NoticeException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update SWBNotice set ");
				buf.append(" title=:title, content=:content, priority=:priority,");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(Notice.A_TITLE, obj.getTitle());
				query.setString(Notice.A_CONTENT, obj.getContent());
				query.setString(Notice.A_PRIORITY, obj.getPriority());
				query.setTimestamp(Notice.A_CREATIONDATE, obj.getCreationDate());
				query.setString(Notice.A_CREATIONUSER, obj.getCreationUser());
				query.setString(Notice.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(Notice.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(Notice.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new NoticeException(e);
		}
	}

	public void createNotice(String user, Notice obj) throws NoticeException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new NoticeException(e);
		}
	}
	public void removeNotice(String user, String objId) throws NoticeException {
		try {
			remove(Notice.class, objId);
		} catch (Exception e) {
			throw new NoticeException(e);
		}
	}
	public void removeNotice(String user, NoticeCond cond) throws NoticeException {
		Notice obj = getNotice(user, cond, null);
		if (obj == null)
			return;
		removeNotice(user, obj.getObjId());

	}
	private Query appendQuery(StringBuffer buf, NoticeCond cond) throws Exception {
		String objId = null;
		String title = null;
		String content = null;
		String priority = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		
			if (cond != null) {
				objId = cond.getObjId();
				title = cond.getTitle();
				content = cond.getContent();
				priority = cond.getPriority();
				creationUser = cond.getCreationUser();
				creationDate = cond.getCreationDate();
				modificationUser = cond.getModificationUser();
				modificationDate = cond.getModificationDate();
			}
			buf.append(" from SWBNotice obj");
			buf.append(" where obj.objId is not null");
			//TODO 시간 검색에 대한 확인 필요
			if (cond != null) {
				if (objId != null) 
					buf.append(" and obj.objId = :objId");
				if (title != null) 
					buf.append(" and obj.title = :title");
				if (content != null) 
					buf.append(" and obj.content = :content");
				if (priority != null) 
					buf.append(" and obj.priority = :priority");
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
					if (priority != null)
						query.setString("priority", priority);
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
	public long getNoticeSize(String user, NoticeCond cond) throws NoticeException {
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
			throw new NoticeException(e);
		}
	
	}
	public Notice[] getNotices(String user, NoticeCond cond, String level) throws NoticeException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.title, obj.content, obj.priority,");
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
					Notice obj = new Notice();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setTitle((String)fields[j++]);
					obj.setContent((String)fields[j++]);
					obj.setPriority((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			Notice[] objs = new Notice[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new NoticeException(e);
		}
	}

}