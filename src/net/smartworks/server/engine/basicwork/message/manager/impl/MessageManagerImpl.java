/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.message.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.basicwork.message.exception.MessageException;
import net.smartworks.server.engine.basicwork.message.manager.IMessageManager;
import net.smartworks.server.engine.basicwork.message.model.Message;
import net.smartworks.server.engine.basicwork.message.model.MessageCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class MessageManagerImpl extends AbstractManager implements IMessageManager {

	public MessageManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public Message getMessage(String user, String objId, String level) throws MessageException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				Message obj = (Message)get(Message.class, objId);
				return obj;
			} catch (Exception e) {
				throw new MessageException(e);
			}
		} else {
			MessageCond cond = new MessageCond();
			cond.setObjId(objId);
			Message[] objs = this.getMessages(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public Message getMessage(String user, MessageCond cond, String level)throws MessageException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		Message[] senders = getMessages(user, cond, level);
		if (CommonUtil.isEmpty(senders))
			return null;
		if (senders.length > 1)
			throw new MessageException("More than 1 sender. ");
		return senders[0];
	}
	public void setMessage(String user, Message obj, String level) throws MessageException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update Message set ");
				buf.append(" content=:content, targetUser=:targetUser,");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(Message.A_CONTENT, obj.getContent());
				query.setString(Message.A_TARGETUSER, obj.getTargetUser());
				query.setTimestamp(Message.A_CREATIONDATE, obj.getCreationDate());
				query.setString(Message.A_CREATIONUSER, obj.getCreationUser());
				query.setString(Message.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(Message.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(Message.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new MessageException(e);
		}
	}

	public void createMessage(String user, Message obj) throws MessageException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new MessageException(e);
		}
	}
	public void removeMessage(String user, String objId) throws MessageException {
		try {
			remove(Message.class, objId);
		} catch (Exception e) {
			throw new MessageException(e);
		}
	}
	public void removeMessage(String user, MessageCond cond) throws MessageException {
		Message obj = getMessage(user, cond, null);
		if (obj == null)
			return;
		removeMessage(user, obj.getObjId());

	}
	private Query appendQuery(StringBuffer buf, MessageCond cond) throws Exception {
		String objId = null;
		String content = null;
		String targetUser = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		
			if (cond != null) {
				objId = cond.getObjId();
				content = cond.getContent();
				targetUser = cond.getTargetUser();
				creationUser = cond.getCreationUser();
				creationDate = cond.getCreationDate();
				modificationUser = cond.getModificationUser();
				modificationDate = cond.getModificationDate();
			}
			buf.append(" from Message obj");
			buf.append(" where obj.objId is not null");
			//TODO 시간 검색에 대한 확인 필요
			if (cond != null) {
				if (objId != null) 
					buf.append(" and obj.objId = :objId");
				if (content != null) 
					buf.append(" and obj.content = :content");
				if (targetUser != null) 
					buf.append(" and obj.targetUser = :targetUser");
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
					if (content != null)
						query.setString("content", content);
					if (targetUser != null)
						query.setString("targetUser", targetUser);
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
	public long getMessageSize(String user, MessageCond cond) throws MessageException {
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
			throw new MessageException(e);
		}
	
	}
	public Message[] getMessages(String user, MessageCond cond, String level) throws MessageException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.content, obj.targetUser,");
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
					Message obj = new Message();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setContent((String)fields[j++]);
					obj.setTargetUser((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			Message[] objs = new Message[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new MessageException(e);
		}
	}

}