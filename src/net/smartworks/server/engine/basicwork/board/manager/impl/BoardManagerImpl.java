/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.board.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.basicwork.board.exception.BoardException;
import net.smartworks.server.engine.basicwork.board.manager.IBoardManager;
import net.smartworks.server.engine.basicwork.board.model.Board;
import net.smartworks.server.engine.basicwork.board.model.BoardCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class BoardManagerImpl extends AbstractManager implements IBoardManager {

	public BoardManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public Board getBoard(String user, String objId, String level) throws BoardException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				Board obj = (Board)get(Board.class, objId);
				return obj;
			} catch (Exception e) {
				throw new BoardException(e);
			}
		} else {
			BoardCond cond = new BoardCond();
			cond.setObjId(objId);
			Board[] objs = this.getBoards(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public Board getBoard(String user, BoardCond cond, String level)throws BoardException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		Board[] senders = getBoards(user, cond, level);
		if (CommonUtil.isEmpty(senders))
			return null;
		if (senders.length > 1)
			throw new BoardException("More than 1 sender. ");
		return senders[0];
	}
	public void setBoard(String user, Board obj, String level) throws BoardException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update Board set ");
				buf.append(" title=:title, content=:content, fileGroupId=:fileGroupId,");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(Board.A_TITLE, obj.getTitle());
				query.setString(Board.A_CONTENT, obj.getContent());
				query.setString(Board.A_FILEGROUPID, obj.getFileGroupId());
				query.setTimestamp(Board.A_CREATIONDATE, obj.getCreationDate());
				query.setString(Board.A_CREATIONUSER, obj.getCreationUser());
				query.setString(Board.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(Board.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(Board.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new BoardException(e);
		}
	}

	public void createBoard(String user, Board obj) throws BoardException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new BoardException(e);
		}
	}
	public void removeBoard(String user, String objId) throws BoardException {
		try {
			remove(Board.class, objId);
		} catch (Exception e) {
			throw new BoardException(e);
		}
	}
	public void removeBoard(String user, BoardCond cond) throws BoardException {
		Board obj = getBoard(user, cond, null);
		if (obj == null)
			return;
		removeBoard(user, obj.getObjId());

	}
	private Query appendQuery(StringBuffer buf, BoardCond cond) throws Exception {
		String objId = null;
		String title = null;
		String content = null;
		String fileGroupId = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;

		if (cond != null) {
			objId = cond.getObjId();
			title = cond.getTitle();
			content = cond.getContent();
			fileGroupId = cond.getFileGroupId();
			creationUser = cond.getCreationUser();
			creationDate = cond.getCreationDate();
			modificationUser = cond.getModificationUser();
			modificationDate = cond.getModificationDate();
		}
		buf.append(" from Board obj");
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
	public long getBoardSize(String user, BoardCond cond) throws BoardException {
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
			throw new BoardException(e);
		}
	
	}
	public Board[] getBoards(String user, BoardCond cond, String level) throws BoardException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.title, obj.content, obj.fileGroupId,");
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
					Board obj = new Board();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setTitle((String)fields[j++]);
					obj.setContent((String)fields[j++]);
					obj.setFileGroupId((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			Board[] objs = new Board[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new BoardException(e);
		}
	}

}