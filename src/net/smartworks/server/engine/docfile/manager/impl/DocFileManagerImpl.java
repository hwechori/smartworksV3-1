/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.manager.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.SmartServerConstant;
import net.smartworks.server.engine.common.util.id.IDCreator;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.HbDocumentModel;
import net.smartworks.server.engine.docfile.model.HbFileModel;
import net.smartworks.server.engine.docfile.model.IDocumentModel;
import net.smartworks.server.engine.docfile.model.IFileModel;

import org.apache.commons.fileupload.FileItem;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DocFileManagerImpl extends AbstractManager implements IDocFileManager {

	public DocFileManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
/*	public DocFile getDocFile(String user, String id, String level) throws DocFileException {
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
	}*/

	/**
	 * 파일 저장 위치
	 */
	private String fileDirectory;
	
	/**
	 * @return the fileDirectory
	 */
	public String getFileDirectory() {
		return fileDirectory;
	}

	/**
	 * @param fileDirectory the fileDirectory to set
	 */
	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}
	
	/**
	 * 파일 저장 디렉토리 - 기본 파일 저장 디렉토리에 현재 년, 현재 월로 카테고라이즈 하여 저장한다.
	 * 
	 * @return
	 */
	private File getFileRepository() throws DocFileException {
		
		if(this.fileDirectory == null)
			throw new DocFileException("Attachment directory is not specified!");
		
		// 현재 년, 월 정보를 얻는다.
		Calendar currentDate = Calendar.getInstance();
		int year = currentDate.get(Calendar.YEAR);
		int month = currentDate.get(Calendar.MONTH) + 1;

		// 기본 파일 저장 디렉토리와 현재 년 정보로 파일 디렉토리를 설정한다.
		String storageDir = this.fileDirectory + File.separator + "Y" + year;
		File storage = new File(storageDir);
		
		// 없다면 생성한다.
		if(!storage.exists())
			storage.mkdir();
		
		// 기본 파일 저장 디렉토리와 현재 월 정보로 파일 디렉토리를 설정한다.		
		storageDir = storageDir + File.separator + "M" + month;
		
		// 만일 디렉토리가 없다면 생성한다.
		storage = new File(storageDir);
		
		if(!storage.exists())
			storage.mkdir();
		
		return storage;
	}

	/**
	 * 파일을 저장한다.
	 * 
	 * @param filePath
	 * @param fileItem
	 * @throws Exception
	 */
	private void writeFile(String filePath, FileItem fileItem) throws DocFileException {
		if (fileItem.getSize() > 0) {
           try {     
               File uploadedFile = new File(filePath);
               fileItem.write(uploadedFile);
             //  int nRet2 = JNICipher.DecipherFile(filePath);
              // System.out.println("nRet2++++++++"+nRet2);
           } catch (Exception e) {
               throw new DocFileException("Failed to write file [" + filePath + "]!");
           }
       }
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#createFile(java.lang.String, java.lang.String, com.maninsoft.smart.server.model.IFileModel)
	 */
	public String createFile(String userId, String groupId, IFileModel file) throws DocFileException {

		String fileId = IDCreator.createId(SmartServerConstant.FILE_ABBR);
		file.setId(fileId);
		file.setWrittenTime(new Date());
		File repository = this.getFileRepository();
		FileItem fileItem = file.getFileItem();
		String filePath = null;
		if(fileItem != null) {
			String fileName = fileItem.getName();
			if(fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
			
			String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			filePath = repository.getAbsolutePath() + File.separator + (String)fileId;
			
			if(extension != null) {
				filePath = filePath + "." + extension;
				file.setType(extension);
			}
			
			file.setFilePath(filePath);
			file.setFileSize(fileItem.getSize());
			file.setFileName(fileName);
			
		}

		this.getHibernateTemplate().save(file);
		this.writeFile(file.getFilePath(), file.getFileItem());
		
		//String path = file.getFilePath();
		
		// 그룹 아이디가 넘어 오지 않았다면 그룹아이디 설정
		if(groupId == null)
			// 그룹아이디를 생성하여 문서 아이디와 매핑
			groupId = IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR);
		
		// 그룹아이디, 문서 아이디 쌍 저장
		Query query = this.getSession().createSQLQuery("insert into SWDocGroup(groupId, docId) values ('" + groupId + "', '" + fileId + "')");
		query.executeUpdate();
		return groupId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#createFileList(java.lang.String, java.lang.String, java.util.List)
	 */
	public String createFileList(String userId, String groupId, List<IFileModel> fileList) throws DocFileException {
		
		if(fileList == null)
			return null;
		
		if(groupId == null)
			groupId = IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR);
		
		for(IFileModel file : fileList)
			this.createFile(userId, groupId, file);
		return groupId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#deleteFile(java.lang.String)
	 */
	public void deleteFile(String fileId) throws DocFileException {
		
		// 파일 그룹에서 삭제
		Query query = this.getSession().createSQLQuery("delete from SWDocGroup where docId = '" + fileId + "'");
		query.executeUpdate();
		
		// 파일 모델 및 파일 삭제
		IFileModel fileModel = this.retrieveFile(fileId);
		String filePath = fileModel.getFilePath();
		File file = new File(filePath);
		file.delete();
		this.getHibernateTemplate().delete(fileModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#deleteFileGroup(java.lang.String)
	 */
	public void deleteFileGroup(String groupId) throws DocFileException {
		
		if(groupId == null)
			return;
		
		String sql = "select docId from SWDocGroup where groupId = '" + groupId + "'";
		Query query = this.getSession().createSQLQuery(sql);
		List fileIdList = query.list();
		
		if(fileIdList == null || fileIdList.isEmpty())
			return;
		
		HibernateTemplate ht = this.getHibernateTemplate();
		
		// 파일 및 문서 모델 삭제
		for(Object fileId : fileIdList) {
			IFileModel fileModel = this.retrieveFile((String)fileId);
			String filePath = fileModel.getFilePath();
			File file = new File(filePath);
			file.delete();
			ht.delete(fileModel);
		}
		
		// 문서 그룹 삭제
		query = this.getSession().createSQLQuery("delete from SWDocGroup where groupId = '" + groupId + "'");
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#findFileGroup(java.lang.String)
	 */
	public List<IFileModel> findFileGroup(String groupId) throws DocFileException {
		
		if(groupId == null)
			return new ArrayList<IFileModel>();
		
		String sql = "select docId from SWDocGroup where groupId = '" + groupId + "'";
		Query query = this.getSession().createSQLQuery(sql);
		List fileIdList = query.list();
		
		if(fileIdList == null || fileIdList.isEmpty())
			return new ArrayList<IFileModel>();
				
		String hql = "from HbFileModel where id in (";
		int index = 0;

		for(Object fileId : fileIdList) {
			if(index > 0)
				hql += ",";

			hql += "'" + fileId + "'";
			index++;
		}
		
		hql += ")";
		query = this.getSession().createQuery(hql);
		List<IFileModel> docList = query.list();
		return docList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#retrieveFile(java.lang.String)
	 */
	public IFileModel retrieveFile(String fileId) throws DocFileException {
				
		return (IFileModel)this.getHibernateTemplate().get(HbFileModel.class, fileId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#updateFile(java.lang.String, com.maninsoft.smart.server.model.IFileModel)
	 */
	public void updateFile(String userId, IFileModel file) throws DocFileException {
		
		this.getHibernateTemplate().update(file);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#findFileIdListByGroup(java.lang.String)
	 */
	public List<String> findFileIdListByGroup(String groupId) throws DocFileException {
		
		Query query = this.getSession().createSQLQuery("select docId from SWDocGroup where groupId = '" + groupId + "'");
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#createDocument(java.lang.String, java.lang.String, com.maninsoft.smart.server.model.IDocumentModel, java.util.List)
	 */
	public String createDocument(String userId, String groupId, IDocumentModel document, List<FileItem> fileList) throws DocFileException {
		
		// document 생성
		String docId = document.getId() == null ? IDCreator.createId(SmartServerConstant.DOCUMENT_ABBR) : document.getId();		
		document.setId(docId);
		document.setCreatedTime(new Date());
		document.setCreator(userId);

		File repository = this.getFileRepository();
		List<IFileModel> fileModelList = new ArrayList<IFileModel>();
		Date currentTime = new Date();
		String filePath = repository.getAbsolutePath() + (repository.getAbsolutePath().endsWith(File.separator) ? "" : File.separator);
			
		for(FileItem fileItem : fileList) {

			String id = IDCreator.createId(SmartServerConstant.FILE_ABBR);
			String fileName = fileItem.getName();
			
			if(fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
			
			String fileFullPath = filePath + id;
			String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			fileFullPath = fileFullPath + "." + extension;
			
			IFileModel fileModel = new HbFileModel();
			fileModel.setId(id);
			fileModel.setFileName(fileName);
			fileModel.setFilePath(fileFullPath);
			fileModel.setFileSize(fileItem.getSize());
			fileModel.setType(extension);
			fileModel.setWrittenTime(currentTime);
			fileModel.setFileItem(fileItem);
			fileModelList.add(fileModel);
		}
		
		// 그룹 아이디가 넘어 오지 않았다면 그룹아이디 설정
		if(groupId == null) {
			// 그룹아이디를 생성하여 문서 아이디와 매핑
			groupId = IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR);
			document.setFileGroupId(groupId);
		}
		
		// 파일 정보 저장
		this.getHibernateTemplate().saveOrUpdateAll(fileModelList);
		// 문서 정보 저장
		this.getHibernateTemplate().save(document);
		// 파일 저장
		for(IFileModel fileModel : fileModelList)
			this.writeFile(fileModel.getFilePath(), fileModel.getFileItem());
		
		// 그룹아이디, 문서 아이디 쌍 저장
		for(IFileModel fileModel : fileModelList) {
			Query query = this.getSession().createSQLQuery("insert into SWDocGroup(groupId, docId) values ('" + groupId + "', '" + fileModel.getId() + "')");
			query.executeUpdate();
		}
		
		return groupId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#deleteDocument(java.lang.String)
	 */
	public void deleteDocument(String documentId) throws DocFileException {
		
		// 문서 조회
		IDocumentModel document = this.retrieveDocument(documentId);
		List<IFileModel> fileList = this.findFileGroup(document.getFileGroupId());
		
		// 문서 그룹에서 삭제
		Query query = this.getSession().createSQLQuery("delete from SWDocGroup where groupId = '" + document.getFileGroupId() + "'");
		query.executeUpdate();
		
		// 문서 모델 및 파일 삭제
		this.getHibernateTemplate().deleteAll(fileList);
		this.getHibernateTemplate().delete(document);
		
		// 파일 삭제
		for(IFileModel fileModel : fileList) {
			String filePath = fileModel.getFilePath();
			File file = new File(filePath);
			file.delete();
		}
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#findDocIdByGroupId(java.lang.String)
	 */
	public List<String> findDocIdByGroupId(String fileGroupId) throws DocFileException {
		
		Query query = this.getSession().createSQLQuery("select docId from SWDocGroup where groupId = '" + fileGroupId + "'");
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#retrieveDocument(java.lang.String)
	 */
	public IDocumentModel retrieveDocument(String documentId) throws DocFileException {
		
		return (IDocumentModel)this.getHibernateTemplate().get(HbDocumentModel.class, documentId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#retrieveDocumentByGroupId(java.lang.String)
	 */
	public IDocumentModel retrieveDocumentByGroupId(String fileGroupId) throws DocFileException {
		
		Query query = this.getSession().createQuery("from HbDocumentModel where fileGroupId = '" + fileGroupId + "'");
		IDocumentModel doc = (IDocumentModel)query.uniqueResult();
		return doc;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#updateDocument(java.lang.String, com.maninsoft.smart.server.model.IDocumentModel)
	 */
	public void updateDocument(String userId, IDocumentModel document) throws DocFileException {
		
		this.getHibernateTemplate().update(document);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IDocumentDao#retrieveDocumentByRef(int, java.lang.String)
	 */
	public IDocumentModel retrieveDocumentByRef(int refType, String refId) throws DocFileException {
		
		Query query = this.getSession().createQuery("from HbDocumentModel where refType = " + refType + " and refId = '" + refId + "'");
		IDocumentModel doc = (IDocumentModel)query.uniqueResult();
		return doc;
	}

}