/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 7.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.folder.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.folder.exception.FdrException;
import net.smartworks.server.engine.folder.manager.IFdrManager;
import net.smartworks.server.engine.folder.model.FdrFolder;
import net.smartworks.server.engine.folder.model.FdrFolderCond;
import net.smartworks.server.engine.folder.model.FdrFolderFile;

import org.hibernate.Query;

public class FdrManagerImpl extends AbstractManager implements IFdrManager {

	public FdrManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	
	public FdrFolder getFolder(String user, String objId, String level) throws FdrException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				FdrFolder obj = (FdrFolder)get(FdrFolder.class, objId);
				return obj;
			} catch (Exception e) {
				throw new FdrException(e);
			}
		} else {
			FdrFolderCond cond = new FdrFolderCond();
			cond.setObjId(objId);
			FdrFolder[] objs = this.getFolders(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}

	public FdrFolder getFolder(String user, FdrFolderCond cond, String level) throws FdrException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		FdrFolder[] folders = getFolders(user, cond, level);
		if (CommonUtil.isEmpty(folders))
			return null;
		if (folders.length > 1)
			throw new FdrException("More than 1 folder.");
		return folders[0];
	}

	public FdrFolder setFolder(String user, FdrFolder obj, String level) throws FdrException {
		try {
			fill(user, obj);
			set(obj);
			return obj;
		} catch (Exception e) {
			throw new FdrException(e);
		}
	}

	public FdrFolder createFolder(String userId, FdrFolder obj) throws FdrException {
		try {
			fill(userId, obj);
			create(obj);
			return obj;
		} catch (Exception e) {
			logger.error(e, e);
			throw new FdrException(e);
		}
	}
	public void removeFolder(String user, String objId) throws FdrException {
		try {
			remove(FdrFolder.class, objId);
		} catch (Exception e) {
			throw new FdrException(e);
		}
	}

	@Override
	public void removeFolder(String user, FdrFolderCond cond) throws FdrException {
		FdrFolder obj = getFolder(user, cond, null);
		if (obj == null)
			return;
		removeFolder(user, obj.getObjId());
	}

	private Query appendQuery(StringBuffer buf, FdrFolderCond cond) throws Exception {
		String objId = null;
		String companyId = null;
		String parentId = null;
		String name = null;
		String nameLike = null;
		int displayOrder = -1;
		Filter[] filters = null;
		String logicalOperator = null;
		FdrFolderFile[] folderFiles = null;
		String[] objIdNotIns = null;
		String workspaceId = null;
		String refType = null;

		if (cond != null) {
			objId = cond.getObjId();
			companyId = cond.getCompanyId();
			parentId = cond.getParentId();
			name = cond.getName();
			nameLike = cond.getNameLike();
			displayOrder = cond.getDisplayOrder();
			filters = cond.getFilter();
			logicalOperator = cond.getOperator();
			folderFiles = cond.getFolderFiles();
			objIdNotIns = cond.getObjIdNotIns();
			workspaceId = cond.getWorkspaceId();
			refType = cond.getRefType();
		}
		buf.append(" from FdrFolder obj");
		if (folderFiles != null && folderFiles.length != 0) {
			for (int i=0; i<folderFiles.length; i++) {
				buf.append(" left join obj.folderFiles as folderFile").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		Map filterMap = new HashMap();
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (parentId != null)
				buf.append(" and obj.parentId = :parentId");
			if (name != null)
				buf.append(" and obj.name = :name");
			if (nameLike != null)
				buf.append(" and obj.name like :nameLike");
			if (displayOrder != -1)
				buf.append(" and obj.displayOrder = :displayOrder");
			if (workspaceId != null)
				buf.append(" and obj.workspaceId = :workspaceId");
			if (refType != null)
				buf.append(" and obj.refType = :refType");
			if (objIdNotIns != null && objIdNotIns.length != 0) {
				buf.append(" and obj.objId not in (");
				for (int i=0; i<objIdNotIns.length; i++) {
					if( i != 0)
						buf.append(", ");
						buf.append(":objIdNotIn").append(i);
				}
				buf.append(")");
			}
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
			if (folderFiles != null && folderFiles.length != 0) {
				for (int i=0; i<folderFiles.length; i++) {
					FdrFolderFile fdrFolderFile = folderFiles[i];
					String folderId = fdrFolderFile.getFolderId();
					String fileId = fdrFolderFile.getFileId();
					if (folderId != null)
						buf.append(" and folderFile").append(i).append(".folderId = :folderId").append(i);
					if (fileId != null)
						buf.append(" and folderFile").append(i).append(".fileId = :fileId").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (companyId != null)
				query.setString("companyId", companyId);
			if (parentId != null)
				query.setString("parentId", parentId);
			if (name != null)
				query.setString("name", name);
			if (nameLike != null)
				query.setString("nameLike", CommonUtil.toLikeString(nameLike));
			if (displayOrder != -1)
				query.setInteger("displayOrder", displayOrder);
			if (workspaceId != null)
				query.setString("workspaceId", workspaceId);
			if (refType != null)
				query.setString("refType", refType);
			if (objIdNotIns != null && objIdNotIns.length !=0) {
				for (int i=0; i<objIdNotIns.length; i++) {
					query.setString("objIdNotIn"+i, objIdNotIns[i]);
				}
			}
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
							query.setTimestamp(param, DateUtil.toDate(operValue));
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
			if (folderFiles != null && folderFiles.length != 0) {
				for (int i=0; i<folderFiles.length; i++) {
					FdrFolderFile fdrFolderFile = folderFiles[i];
					String folderId = fdrFolderFile.getFolderId();
					String fileId = fdrFolderFile.getFileId();
					if (folderId != null)
						query.setString("folderId"+i, folderId);
					if (fileId != null)
						query.setString("fileId"+i, fileId);
				}
			}
		}
		return query;
	}

	public long getFolderSize(String user, FdrFolderCond cond) throws FdrException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			throw new FdrException(e);
		}
	}

	public FdrFolder[] getFolders(String user, FdrFolderCond cond, String level) throws FdrException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.companyId, obj.parentId"); 
				buf.append(", obj.name, obj.displayOrder, obj.description"); 
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					FdrFolder obj = new FdrFolder();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setParentId(((String)fields[j++]));
					obj.setName((String)fields[j++]);
					obj.setDisplayOrder((Integer)fields[j++]);
					obj.setDescription(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			FdrFolder[] objs = new FdrFolder[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new FdrException(e);
		}
	}

	@Override
	public void createFolderFile(String user, String folderId, String fileId) throws FdrException {
		StringBuffer buff = new StringBuffer();

		buff.append(" insert into SWFolderFile ");
		buff.append(" (folderId, fileId) ");
		buff.append(" values(folderId = :folderId, fileId = :fileId) ");

		Query query = this.getSession().createQuery(buff.toString());
		query.setString(FdrFolderFile.A_FOLDERID, folderId);
		query.setString(FdrFolderFile.A_FILEID, fileId);

		query.executeUpdate();
		
	}

	@Override
	public void removeFolderFile(String user, String folderId, String fileId) throws FdrException {
		StringBuffer buff = new StringBuffer();

		buff.append(" delete from SWFolderFile ");
		buff.append(" where folderId = '" + folderId +"' and fileId = '" + fileId + "'");

		Query query = this.getSession().createQuery(buff.toString());
		query.setString(FdrFolderFile.A_FOLDERID, folderId);
		query.setString(FdrFolderFile.A_FILEID, fileId);

		query.executeUpdate();
	}

}