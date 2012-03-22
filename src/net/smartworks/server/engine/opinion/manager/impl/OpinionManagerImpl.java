/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 19.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.opinion.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.basicwork.board.model.Board;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.opinion.exception.OpinionException;
import net.smartworks.server.engine.opinion.manager.IOpinionManager;
import net.smartworks.server.engine.opinion.model.Opinion;
import net.smartworks.server.engine.opinion.model.OpinionCond;

import org.hibernate.Query;

public class OpinionManagerImpl extends AbstractManager implements IOpinionManager {

	public OpinionManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}

	@Override
	public Opinion getOpinion(String user, String objId, String level) throws OpinionException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				Opinion obj = (Opinion)get(Opinion.class, objId);
				return obj;
			} catch (Exception e) {
				throw new OpinionException(e);
			}
		} else {
			OpinionCond cond = new OpinionCond();
			cond.setObjId(objId);
			Opinion[] objs = this.getOpinions(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}

	@Override
	public Opinion getOpinion(String user, OpinionCond cond, String level) throws OpinionException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		Opinion[] opinions = getOpinions(user, cond, level);
		if (CommonUtil.isEmpty(opinions))
			return null;
		if (opinions.length > 1)
			throw new OpinionException("More than 1 opinion. ");
		return opinions[0];
	}

	@Override
	public void setOpinion(String user, Opinion obj, String level) throws OpinionException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update Opinion set ");
				buf.append(" title=:title, opinion=:opinion, modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(Opinion.A_TITLE, obj.getTitle());
				query.setString(Opinion.A_OPINION, obj.getOpinion());
				query.setString(Opinion.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(Opinion.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(Opinion.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new OpinionException(e);
		}
	}

	@Override
	public void createOpinion(String user, Opinion obj) throws OpinionException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new OpinionException(e);
		}
	}

	@Override
	public void removeOpinion(String user, String objId) throws OpinionException {
		try {
			remove(Board.class, objId);
		} catch (Exception e) {
			throw new OpinionException(e);
		}
	}

	@Override
	public void removeOpinion(String user, OpinionCond cond) throws OpinionException {
		Opinion obj = getOpinion(user, cond, null);
		if (obj == null)
			return;
		removeOpinion(user, obj.getObjId());
	}

	private Query appendQuery(StringBuffer buf, OpinionCond cond) throws Exception {
		String objId = null;
		int refType = 0;
		String refId = null;
		String groupId = null;
		String title = null;
		String opinion = null;
		String refDomainId = null;
		String refFormId = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		Date writtenDateFrom = null;
		Date writtenDateTo = null;

		if (cond != null) {
			objId = cond.getObjId();
			refType = cond.getRefType();
			groupId = cond.getGroupId();
			refId = cond.getRefId();
			refDomainId = cond.getRefDomainId();
			refFormId = cond.getRefFormId();
			title = cond.getTitle();
			opinion = cond.getOpinion();
			creationUser = cond.getCreationUser();
			creationDate = cond.getCreationDate();
			modificationUser = cond.getModificationUser();
			modificationDate = cond.getModificationDate();
			writtenDateFrom = cond.getWrittenDateFrom();
			writtenDateTo = cond.getWrittenDateTo();
		}
		buf.append(" from Opinion obj");
		buf.append(" where obj.objId is not null");
		//TODO 시간 검색에 대한 확인 필요
		if (cond != null) {
			if (objId != null) 
				buf.append(" and obj.objId = :objId");
			if (refType != 0)
				buf.append(" and obj.refType = :refType");
			if (groupId != null) 
				buf.append(" and obj.groupId = :groupId");
			if (refId != null) 
				buf.append(" and obj.refId = :refId");
			if (refDomainId != null) 
				buf.append(" and obj.refDomainId = :refDomainId");
			if (refFormId != null)
				buf.append(" and obj.refFormId = :refFormId");
			if (title != null) 
				buf.append(" and obj.title = :title");
			if (opinion != null) 
				buf.append(" and obj.opinion = :opinion");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (creationDate != null)
				buf.append(" and obj.creationDate = :creationDate");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (modificationDate != null)
				buf.append(" and obj.modificationDate = :modificationDate");
			if (writtenDateFrom != null)
				buf.append(" and obj.creationDate > :writtenDateFrom ");
			if (writtenDateTo != null)
				buf.append(" and obj.creationDate < :writtenDateTo ");
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (refType != 0)
				query.setInteger("refType", refType);
			if (groupId != null)
				query.setString("groupId", groupId);
			if (refId != null)
				query.setString("refId", refId);
			if (refDomainId != null)
				query.setString("refDomainId", refDomainId);
			if (refFormId != null)
				query.setString("refFormId", refFormId);
			if (title != null)
				query.setString("title", title);
			if (opinion != null)
				query.setString("opinion", opinion);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (creationDate != null)
				query.setTimestamp("creationDate", creationDate);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (modificationDate != null)
				query.setTimestamp("modificationDate", modificationDate);
			if (writtenDateFrom != null)
				query.setTimestamp("writtenDateFrom", writtenDateFrom);
			if (writtenDateTo != null)
				query.setTimestamp("writtenDateTo", writtenDateTo);
		}

		return query;

	}

	@Override
	public long getOpinionSize(String user, OpinionCond cond) throws OpinionException {
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
			throw new OpinionException(e);
		}
	}

	@Override
	public Opinion[] getOpinions(String user, OpinionCond cond, String level) throws OpinionException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.refType, obj.groupId, obj.refId,");
				buf.append(" obj.refDomainId, obj.refFormId, obj.title, obj.opinion,");
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
					Opinion obj = new Opinion();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setRefType((Integer)fields[j++]);
					obj.setGroupId((String)fields[j++]);
					obj.setRefId((String)fields[j++]);
					obj.setRefDomainId((String)fields[j++]);
					obj.setRefFormId((String)fields[j++]);
					obj.setTitle((String)fields[j++]);
					obj.setOpinion((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			Opinion[] objs = new Opinion[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new OpinionException(e);
		}
	}

}