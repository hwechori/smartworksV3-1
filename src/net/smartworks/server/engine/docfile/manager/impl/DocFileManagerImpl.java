/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.manager.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.SmartServerConstant;
import net.smartworks.server.engine.common.util.id.IDCreator;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.HbDocumentModel;
import net.smartworks.server.engine.docfile.model.HbFileModel;
import net.smartworks.server.engine.docfile.model.IDocumentModel;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartConfUtil;
import net.smartworks.util.SmartUtil;

import org.apache.commons.io.IOUtils;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.multipart.MultipartFile;

public class DocFileManagerImpl extends AbstractManager implements IDocFileManager {

	public DocFileManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}

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
	 * @param fileDirectory
	 *            the fileDirectory to set
	 */
	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	/**
	 * 파일 저장 디렉토리 - 기본 파일 저장 디렉토리에 현재 년, 현재 월로 카테고라이즈 하여 저장한다.
	 * 
	 * @return
	 */
	private File getFileRepository(String companyId, String fileDivision) throws DocFileException {

		if (this.fileDirectory == null)
			throw new DocFileException("Attachment directory is not specified!");

		// 사용자의 회사아이디의 디렉토리 선택
		String storageDir = this.fileDirectory + File.separator + companyId;
		File storage = new File(storageDir);

		if (!storage.exists())
			storage.mkdir();

		// 파일 형태 구분에 따른 디렉토리 선택
		storageDir = storageDir + File.separator + fileDivision;
		storage = new File(storageDir);

		// 없다면 생성한다.
		if (!storage.exists())
			storage.mkdir();

		if(!fileDivision.equals("Temps")) {
			// 현재 년, 월 정보를 얻는다.
			Calendar currentDate = Calendar.getInstance();
			int year = currentDate.get(Calendar.YEAR);
			int month = currentDate.get(Calendar.MONTH) + 1;
	
			// 기본 파일 저장 디렉토리와 현재 년 정보로 파일 디렉토리를 설정한다.
			storageDir = storageDir + File.separator + "Y" + year;
			storage = new File(storageDir);
	
			// 없다면 생성한다.
			if (!storage.exists())
				storage.mkdir();

			// 기본 파일 저장 디렉토리와 현재 월 정보로 파일 디렉토리를 설정한다.
			storageDir = storageDir + File.separator + "M" + month;
	
			// 만일 디렉토리가 없다면 생성한다.
			storage = new File(storageDir);
	
			if (!storage.exists())
				storage.mkdir();
		}

		return storage;
	}

	/**
	 * 파일을 저장한다.
	 * 
	 * @param filePath
	 * @param fileItem
	 * @throws Exception
	 */
	private void writeFile(String filePath, MultipartFile multipartFile) throws DocFileException {
		if (multipartFile.getSize() > 0) {
			try {
				File uploadedFile = new File(filePath);
				FileOutputStream os = new FileOutputStream(uploadedFile);
				InputStream is = multipartFile.getInputStream();
				
				byte[] buf = new byte[1024];

				int len;

				while ((len = is.read(buf)) > 0) {
					os.write(buf, 0, len);
				}
				is.close();
				os.close();
			} catch (Exception e) {
				throw new DocFileException("Failed to write file [" + filePath + "]!");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#createFile(java.lang.String,
	 * java.lang.String, com.maninsoft.smart.server.model.IFileModel)
	 */
	public String createFile(String userId, String groupId, IFileModel file, HttpServletRequest request) throws DocFileException {

		String fileId = request.getParameter("fileId");
		file.setId(fileId);
		file.setWrittenTime(new Date(new LocalDate().getGMTDate()));
		this.setFileDirectory(SmartConfUtil.getInstance().getFileDirectory());

		//File repository = this.getFileRepository();
		MultipartFile multipartFile = file.getMultipartFile();
		String filePath = null;
		if (file != null) {
			String fileName = request.getParameter("fileName");
			if (fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

			String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			//filePath = repository.getAbsolutePath() + File.separator + (String) fileId;

			if (extension != null) {
				filePath = filePath + "." + extension;
				file.setType(extension);
			}

			file.setFilePath(filePath);
			file.setFileSize(multipartFile.getSize());
			file.setFileName(fileName);

		}

		this.getHibernateTemplate().save(file);
		this.writeFile(file.getFilePath(), file.getMultipartFile());
		// String path = file.getFilePath();

		// 그룹 아이디가 넘어 오지 않았다면 그룹아이디 설정
		if (groupId == null)
			// 그룹아이디를 생성하여 문서 아이디와 매핑
			groupId = IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR);

		// 그룹아이디, 문서 아이디 쌍 저장
		Query query = this.getSession().createSQLQuery("insert into SWDocGroup(groupId, docId) values ('" + groupId + "', '" + fileId + "')");
		query.executeUpdate();
		return groupId;
	}

	public String createFileList(String userId, String groupId, List<IFileModel> fileList, HttpServletRequest request) throws DocFileException {

		if (fileList == null)
			return null;

		if (groupId == null)
			groupId = IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR);

		for (IFileModel file : fileList) {
			if(!(file.getMultipartFile().getOriginalFilename().equals(""))) {
				if(request.getParameter("fileId").startsWith("temp_"))
					this.createFile(userId, groupId, file, request);
			}
		}
		return groupId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#deleteFile(java.lang.String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#deleteFileGroup(java.lang
	 * .String)
	 */
	public void deleteFileGroup(String groupId) throws DocFileException {

		if (groupId == null)
			return;

		String sql = "select docId from SWDocGroup where groupId = '" + groupId + "'";
		Query query = this.getSession().createSQLQuery(sql);
		List fileIdList = query.list();

		if (fileIdList == null || fileIdList.isEmpty())
			return;

		HibernateTemplate ht = this.getHibernateTemplate();

		// 파일 및 문서 모델 삭제
		for (Object fileId : fileIdList) {
			IFileModel fileModel = this.retrieveFile((String) fileId);
			String filePath = fileModel.getFilePath();
			File file = new File(filePath);
			file.delete();
			ht.delete(fileModel);
		}

		// 문서 그룹 삭제
		query = this.getSession().createSQLQuery("delete from SWDocGroup where groupId = '" + groupId + "'");
		query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#findFileGroup(java.lang.String
	 * )
	 */
	public List<IFileModel> findFileGroup(String groupId) throws DocFileException {

		if (groupId == null)
			return new ArrayList<IFileModel>();

		String sql = "select docId from SWDocGroup where groupId = '" + groupId + "'";
		Query query = this.getSession().createSQLQuery(sql);
		List fileIdList = query.list();

		if (fileIdList == null || fileIdList.isEmpty())
			return new ArrayList<IFileModel>();

		String hql = "from HbFileModel where id in (";
		int index = 0;

		for (Object fileId : fileIdList) {
			if (index > 0)
				hql += ",";

			hql += "'" + fileId + "'";
			index++;
		}

		hql += ")";
		query = this.getSession().createQuery(hql);
		List<IFileModel> docList = query.list();
		return docList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#retrieveFile(java.lang.String
	 * )
	 */
	public IFileModel retrieveFile(String fileId) throws DocFileException {

		return (IFileModel) this.getHibernateTemplate().get(HbFileModel.class, fileId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#updateFile(java.lang.String,
	 * com.maninsoft.smart.server.model.IFileModel)
	 */
	public void updateFile(String userId, IFileModel file) throws DocFileException {

		this.getHibernateTemplate().update(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#findFileIdListByGroup(java
	 * .lang.String)
	 */
	public List<String> findFileIdListByGroup(String groupId) throws DocFileException {

		Query query = this.getSession().createSQLQuery("select docId from SWDocGroup where groupId = '" + groupId + "'");
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#deleteDocument(java.lang.
	 * String)
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
		for (IFileModel fileModel : fileList) {
			String filePath = fileModel.getFilePath();
			File file = new File(filePath);
			file.delete();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#findDocIdByGroupId(java.lang
	 * .String)
	 */
	public List<String> findDocIdByGroupId(String fileGroupId) throws DocFileException {

		Query query = this.getSession().createSQLQuery("select docId from SWDocGroup where groupId = '" + fileGroupId + "'");
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#retrieveDocument(java.lang
	 * .String)
	 */
	public IDocumentModel retrieveDocument(String documentId) throws DocFileException {

		return (IDocumentModel) this.getHibernateTemplate().get(HbDocumentModel.class, documentId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#retrieveDocumentByGroupId
	 * (java.lang.String)
	 */
	public IDocumentModel retrieveDocumentByGroupId(String fileGroupId) throws DocFileException {

		Query query = this.getSession().createQuery("from HbDocumentModel where fileGroupId = '" + fileGroupId + "'");
		IDocumentModel doc = (IDocumentModel) query.uniqueResult();
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#updateDocument(java.lang.
	 * String, com.maninsoft.smart.server.model.IDocumentModel)
	 */
	public void updateDocument(String userId, IDocumentModel document) throws DocFileException {

		this.getHibernateTemplate().update(document);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maninsoft.smart.server.dao.IDocumentDao#retrieveDocumentByRef(int,
	 * java.lang.String)
	 */
	public IDocumentModel retrieveDocumentByRef(int refType, String refId) throws DocFileException {

		Query query = this.getSession().createQuery("from HbDocumentModel where refType = " + refType + " and refId = '" + refId + "'");
		IDocumentModel doc = (IDocumentModel) query.uniqueResult();
		return doc;
	}

	private void writeAjaxFile(HttpServletRequest request, HttpServletResponse response, IFileModel formFile) throws DocFileException {

		PrintWriter writer = null;
        InputStream is = null;
        FileOutputStream fos = null;

        try {
            writer = response.getWriter();
        } catch (IOException ex) {
            throw new DocFileException(ex.getMessage());
        }

        try {
            is = request.getInputStream();
            fos = new FileOutputStream(new File(formFile.getFilePath()));
            IOUtils.copy(is, fos);
            response.setStatus(HttpServletResponse.SC_OK);
            writer.print("{success: true, fileId: \"" + formFile.getId() + "\"}");
        } catch (FileNotFoundException ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.print("{success: false}");
            throw new DocFileException(ex.getMessage());
        } catch (IOException ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.print("{success: false}");
            throw new DocFileException(ex.getMessage());
        } finally {
            try {
                fos.close();
                is.close();
            } catch (IOException ignored) {
                throw new DocFileException(ignored.getMessage());
            }
        }

        writer.flush();
        writer.close();
    }

	@Override
	public void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws DocFileException {

		IFileModel formFile = new HbFileModel();
		String fileId = IDCreator.createId(SmartServerConstant.FILE_ABBR);
		
		formFile.setId(fileId);
		formFile.setWrittenTime(new Date(new LocalDate().getGMTDate()));
		this.setFileDirectory(SmartConfUtil.getInstance().getFileDirectory());

		String companyId = SmartUtil.getCurrentUser().getCompanyId();

		String fileDivision = "Files";

		File repository = this.getFileRepository(companyId, fileDivision);
		String filePath = "";
		if (formFile != null) {
			String fileName = "";
			try {
				fileName = URLDecoder.decode(request.getHeader("X-File-Name"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

			String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			filePath = repository.getAbsolutePath() + File.separator + (String) fileId;

			if (extension != null) {
				filePath = filePath + "." + extension;
				formFile.setType(extension);
			}

			formFile.setFilePath(filePath);
			formFile.setFileSize(Long.parseLong(request.getHeader("Content-Length")));
			formFile.setFileName(fileName);

		}

		this.getHibernateTemplate().save(formFile);
		this.writeAjaxFile(request, response, formFile);
		// String path = file.getFilePath();

		String groupId = request.getParameter("groupId");
		// 그룹 아이디가 넘어 오지 않았다면 그룹아이디 설정
		if (groupId == null)
			// 그룹아이디를 생성하여 문서 아이디와 매핑
			groupId = IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR);

		// 그룹아이디, 문서 아이디 쌍 저장
		Query query = this.getSession().createSQLQuery("insert into SWDocGroup(groupId, docId) values ('" + groupId + "', '" + fileId + "')");
		query.executeUpdate();
	}


	public void ajaxUploadTempFile(HttpServletRequest request, HttpServletResponse response) throws DocFileException {

		IFileModel formFile = new HbFileModel();
		String fileId = IDCreator.createId(SmartServerConstant.TEMP_ABBR);
		formFile.setId(fileId);
		this.setFileDirectory(SmartConfUtil.getInstance().getFileDirectory());

		String companyId = SmartUtil.getCurrentUser().getCompanyId();

		String fileDivision = "Temps";

		File repository = this.getFileRepository(companyId, fileDivision);
		String filePath = "";
		String extension = "";
		if (formFile != null) {
			String fileName = "";
			try {
				fileName = URLDecoder.decode(request.getHeader("X-File-Name"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

			extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			filePath = repository.getAbsolutePath() + File.separator + (String) fileId;

			if (extension != null) {
				filePath = filePath + "." + extension;
			}

			formFile.setFilePath(filePath);

		}

		this.writeAjaxFile(request, response, formFile);

	}

	@Override
	public String uploadTempFile(HttpServletRequest request, HttpServletResponse response) throws DocFileException {
		IFileModel formFile = new HbFileModel();
		String fileId = IDCreator.createId(SmartServerConstant.TEMP_ABBR);
		formFile.setId(fileId);
		this.setFileDirectory(SmartConfUtil.getInstance().getFileDirectory());

		String companyId = SmartUtil.getCurrentUser().getCompanyId();

		String fileDivision = "Temps";

		File repository = this.getFileRepository(companyId, fileDivision);
		String filePath = "";
		String extension = "";
		if (formFile != null) {
			String fileName = "";
			try {
				fileName = URLDecoder.decode(request.getHeader("X-File-Name"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

			extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			filePath = repository.getAbsolutePath() + File.separator + (String) fileId;

			if (extension != null) {
				filePath = filePath + "." + extension;
			}

			formFile.setFilePath(filePath);

		}

		this.writeAjaxFile(request, response, formFile);

		return filePath;

	}

}