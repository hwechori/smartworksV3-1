/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.DocFile;
import net.smartworks.server.engine.docfile.model.DocFileCond;

import org.hibernate.Query;

public class DocFileManagerImpl extends AbstractManager implements IDocFileManager {

	public DocFileManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public DocFile getDocFile(String user, String id, String level) throws DocFileException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				DocFile obj = (DocFile)this.get(DocFile.class, id);
				return obj;
			} else {
				DocFileCond cond = new DocFileCond();
				cond.setId(id);
				DocFile[] objs = this.getDocFiles(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new DocFileException(e);
		}
	}

	public DocFile getDocFile(String user, DocFileCond cond, String level) throws DocFileException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		DocFile[] DocFiles = getDocFiles(user, cond, level);
		if (CommonUtil.isEmpty(DocFiles))
			return null;
		try {
			if (DocFiles.length != 1)
				throw new DocFileException("More than 1 Object");
		} catch (DocFileException e) {
			logger.error(e, e);
			throw e;
		}
		return DocFiles[0];
	}
	public void setDocFile(String user, DocFile obj, String level) throws DocFileException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update DocFile set");
				buf.append(" companyId=:companyId, type=:type, fileName=:fileName, filePath=:filePath, fileSize=:fileSize, writtenTime=:writtenTime");
				buf.append(" where id=:id");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(DocFile.A_COMPANYID, obj.getCompanyId());
				query.setString(DocFile.A_TYPE, obj.getType());
				query.setString(DocFile.A_FILENAME, obj.getFileName());
				query.setString(DocFile.A_FILEPATH, obj.getFilePath());
				query.setLong(DocFile.A_FILESIZE, obj.getFileSize());
				query.setTimestamp(DocFile.A_WRITTENTIME,obj.getWrittenTime());
				query.setString(DocFile.A_ID, obj.getId());
				
			}				
		} catch (Exception e) {
			logger.error(e, e);
			throw new DocFileException(e);
		}
	}
	public void createDocFile(String user, DocFile obj) throws DocFileException {
		try {
	
			create(obj);
		} catch (Exception e) {
			logger.error(e,e);
			throw new DocFileException(e);
		}
	}
	public void removeDocFile(String user, String id) throws DocFileException {
		try {
			remove(DocFile.class, id);
		} catch (Exception e) {
			logger.error(e, e);
			throw new DocFileException(e);
		}
	}
	public void removeDocFile(String user, DocFileCond cond) throws DocFileException {
		DocFile obj = getDocFile(user, cond, null);
		if (obj == null)
			return;
		removeDocFile(user, obj.getId());
	}
	private Query appendQuery(StringBuffer buf, DocFileCond cond) throws Exception {
		String id = null;
		String companyId = null;
		String type = null;
		String fileName = null;
		String filePath = null;
		long fileSize = 0;
		Date writtenTime = null;
				
		if (cond != null) {
			id = cond.getId();
			companyId = cond.getCompanyId();
			type = cond.getType();
			fileName = cond.getFileName();
			filePath = cond.getFilePath();
			fileSize = cond.getFileSize();
			writtenTime = cond.getWrittenTime();

		}
		buf.append(" from DocFile obj");
		buf.append(" where obj.id is not null");
		//TODO 시간 검색에 대한 확인 필요
		if (cond != null) {
			if (id != null)
				buf.append(" and obj.id = :id");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (fileName != null)
				buf.append(" and obj.fileName = :fileName");
			if (filePath != null)
				buf.append(" and obj.filePath = :filePath");
			if (fileSize != 0)
				buf.append(" and obj.fileSize = :fileSize");
			if (writtenTime != null)
				buf.append(" and obj.writtenTime = :writtenTime");
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (id != null)
				query.setString("id", id);
			if (companyId != null)
				query.setString("companyId", companyId);
			if (type != null)
				query.setString("type", type);
			if (fileName != null)
				query.setString("fileName", fileName);
			if (filePath != null)
				query.setString("filePath", filePath);
			if (fileSize != 0)
				query.setLong("fileSize", fileSize);
			if (writtenTime != null)
				query.setTimestamp("writtenTime", writtenTime);
		}
		return query;
	}
	public long getDocFileSize(String user, DocFileCond cond) throws DocFileException {
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
			throw new DocFileException(e);
		}
	}
	public DocFile[] getDocFiles(String user, DocFileCond cond, String level) throws DocFileException {
		// TODO Auto-generated method stub
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.Id, obj.CompanyId, obj.Type, obj.FileName, obj.FilePath, obj.WrtittenTime");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					DocFile obj = new DocFile();
					int j = 0;
					obj.setId((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setType((String)fields[j++]);
					obj.setFileName((String)fields[j++]);
					obj.setFilePath((String)fields[j++]);
					obj.setFileSize(CommonUtil.toLong(fields[j++]));
					obj.setWrittenTime((Date)fields[j++]);
					objList.add(obj);
				}
				list = objList;
			}
			DocFile[] objs = new DocFile[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e,e);
			throw new DocFileException(e);
		}
	}

}