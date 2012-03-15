/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.manager.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.community.User;
import net.smartworks.model.work.FileCategory;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.Filters;
import net.smartworks.server.engine.common.model.SmartServerConstant;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.id.IDCreator;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.FileWork;
import net.smartworks.server.engine.docfile.model.FileWorkCond;
import net.smartworks.server.engine.docfile.model.HbDocumentModel;
import net.smartworks.server.engine.docfile.model.HbFileModel;
import net.smartworks.server.engine.docfile.model.IDocumentModel;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.engine.process.process.exception.PrcException;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.util.LocalDate;
import net.smartworks.util.OSValidator;
import net.smartworks.util.SmartConfUtil;
import net.smartworks.util.SmartUtil;
import net.smartworks.util.Thumbnail;

import org.apache.commons.io.IOUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.engine.SessionFactoryImplementor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.multipart.MultipartFile;

public class DocFileManagerImpl extends AbstractManager implements IDocFileManager {

	public DocFileManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}

	private String dbType;

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
		// 파일 홈 디렉토리 선택
		String storageDir = this.fileDirectory + File.separator + "SmartFiles";
		File storage = new File(storageDir);

		// 없다면 생성한다.
		if (!storage.exists())
			storage.mkdir();

		// 사용자의 회사아이디의 디렉토리 선택
		storageDir =  storageDir + File.separator + companyId;
		storage = new File(storageDir);

		if (!storage.exists())
			storage.mkdir();

		// 파일 형태 구분에 따른 디렉토리 선택
		storageDir = storageDir + File.separator + fileDivision;
		storage = new File(storageDir);

		// 없다면 생성한다.
		if (!storage.exists())
			storage.mkdir();

		if(!fileDivision.equals("Temps") && !fileDivision.equals("Profiles") && !fileDivision.equals("WorkImages")) {
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
		this.setFileDirectory(SmartConfUtil.getInstance().getImageServer());

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
		if(file.exists())
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
            writer.print("{success: true, fileId: \"" + formFile.getId() + "\", pullPathName: \"" + formFile.getImageServerPath() + "\", fileSize: \"" + formFile.getFileSize() + "\"}");
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
		this.setFileDirectory(SmartConfUtil.getInstance().getImageServer());

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
		//this.setFileDirectory(SmartConfUtil.getInstance().getFileDirectory());
		this.setFileDirectory(System.getenv("SMARTWORKS_FILE_HOME") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_HOME"));

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
	public void uploadTempFile(HttpServletRequest request, HttpServletResponse response) throws DocFileException {
		IFileModel formFile = new HbFileModel();
		String fileId = IDCreator.createId(SmartServerConstant.TEMP_ABBR);
		formFile.setId(fileId);

		//this.setFileDirectory(System.getenv("SMARTWORKS_FILE_DIRECTORY") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_DIRECTORY"));
		this.setFileDirectory(OSValidator.getImageDirectory());
		String companyId = SmartUtil.getCurrentUser().getCompanyId();

		String fileDivision = "Temps";
		File repository = this.getFileRepository(companyId, fileDivision);
		String filePath = "";
		String imagerServerPath = "";
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

			imagerServerPath = SmartConfUtil.getInstance().getImageServer() + companyId + "/" + "Temps" + "/" + fileId + "." + extension;
			formFile.setImageServerPath(imagerServerPath);

			if (extension != null) {
				filePath = filePath + "." + extension;
			}
			formFile.setFileSize(Long.parseLong(request.getHeader("Content-Length")));

			formFile.setFilePath(filePath);

		}

		this.writeAjaxFile(request, response, formFile);

	}

	public String insertProfilesFile(String fileId, String fileName, String communityId) throws DocFileException {

		try {
			//this.setFileDirectory(SmartConfUtil.getInstance().getImageServerDirectory());
			//this.setFileDirectory(System.getenv("SMARTWORKS_FILE_DIRECTORY") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_DIRECTORY"));
			this.setFileDirectory(OSValidator.getImageDirectory());
			
			if (fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
	
			String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			if(!CommonUtil.isEmpty(extension))
				extension = extension.toLowerCase();

			User user = SmartUtil.getCurrentUser();
	
			File repository = this.getFileRepository(user.getCompanyId(), "Profiles");
	
			String communityPictureId = communityId + "." + extension;
			//String bigId = null;
			String thumbId = null;
			String originId = null;
			//String realFile1 = null;
			String realFile2 = null;
			String tempFile = this.getFileDirectory() + "/SmartFiles/" + user.getCompanyId() + "/" + "Temps" + "/" + fileId + "." + extension;

			if(communityId.equals(user.getCompanyId())) {
				originId = communityId;
			} else {
				//bigId = communityId + "_big";
				thumbId = communityId + "_thumb";
				originId = communityId + "_origin";
				//realFile1 = repository.getAbsolutePath() + "/" + bigId + "." + extension;
				realFile2 = repository.getAbsolutePath() + "/" + thumbId + "." + extension;
				//Thumbnail.createImage(tempFile, realFile1, "big", extension);
				Thumbnail.createImage(tempFile, realFile2, "thumb", extension);
			}
			String realFile = repository.getAbsolutePath() + "/" + originId + "." + extension;

			FileInputStream is = new FileInputStream(new File(tempFile));
			FileOutputStream os = new FileOutputStream(new File(realFile));
			IOUtils.copy(is, os);
			is.close();
			os.close();

			return communityPictureId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void insertFiles(String workType, String taskInstId, String groupId, String tempFileId, String fileName, String fileSize) throws DocFileException {

		try {
			//this.setFileDirectory(System.getenv("SMARTWORKS_FILE_DIRECTORY") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_DIRECTORY"));
			this.setFileDirectory(OSValidator.getImageDirectory());

			if (fileName.indexOf(File.separator) > 1)
				fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

			String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;

			User user = SmartUtil.getCurrentUser();

			File repository = this.getFileRepository(user.getCompanyId(), workType);
			String fileId = tempFileId.split("temp_")[tempFileId.split("temp_").length-1];
			if(workType.equals("Pictures")) fileId = "pic_" + fileId;
			else fileId = "file_" + fileId;

			String tempFile = this.getFileDirectory() + "/SmartFiles/" + user.getCompanyId() + "/" + "Temps" + "/" + tempFileId + "." + extension;
			String realFile = repository.getAbsolutePath() + File.separator + fileId + "." + extension;
			if(workType.equals("Pictures")) {
				String thumbFile = repository.getAbsolutePath() + File.separator + fileId + "_thumb." + extension;
				Thumbnail.createImage(tempFile, thumbFile, "thumb", extension);
			}

			try {
				FileInputStream is = new FileInputStream(new File(tempFile));
				FileOutputStream os = new FileOutputStream(new File(realFile));
				IOUtils.copy(is, os);
				is.close();
				os.close();
			} catch (Exception e) {
				throw new DocFileException("Failed to copy file [" + tempFile + "]!");
			}


			// 그룹 아이디가 넘어 오지 않았다면 그룹아이디 설정
			if (groupId == null)
				groupId = IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR);

			// 그룹아이디, 파일 아이디 쌍 저장
			Query query = this.getSession().createSQLQuery("insert into SWDocGroup(tskInstanceId, groupId, docId) values ('" + taskInstId + "', '" + groupId + "', '" + fileId + "')");
			query.executeUpdate();

			// 파일 정보 저장
			IFileModel formFile = new HbFileModel();
			formFile.setId(fileId);
			formFile.setFileName(fileName);
			formFile.setWrittenTime(new Date(new LocalDate().getGMTDate()));
			formFile.setFilePath(realFile);
			formFile.setFileSize(Long.parseLong(fileSize, 16));
			formFile.setType(extension);
			this.getHibernateTemplate().save(formFile);

			File deleteFile = new File(tempFile);
			if(deleteFile.exists())
				deleteFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

	@Override
	public String deleteTempFile() throws DocFileException {

		String returnValue = "";
		//this.setFileDirectory(System.getenv("SMARTWORKS_FILE_DIRECTORY") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_DIRECTORY"));
		this.setFileDirectory(OSValidator.getImageDirectory());

		User user = SmartUtil.getCurrentUser();
		String tempFilePath = this.getFileDirectory() + "/SmartFiles/" + user.getCompanyId() + "/" + "Temps" + "/";

		try {
			File tempFileDir = new File(tempFilePath);
			String[] tempFiles = tempFileDir.list();
			for(int i=0; i<tempFiles.length; i++) {
				File tempFile = new File(tempFiles[i]);
				if(tempFile.exists()) {
					returnValue += tempFile.getName();
					tempFile.delete();
				} else {
					returnValue = "tempFile not exists...";
				}
			}
			returnValue += " : delete tempFile success...";
		} catch (Exception e) {
			returnValue = "delete tempFile fail... : " + e.getMessage();
			return returnValue;
		}

		return returnValue;
	}

	public IFileModel[] getFilesByTaskInstId(String taskInstId) throws DocFileException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select doc.tskinstanceid, docfile.id, docfile.type, docfile.fileName, docfile.filePath, docfile.fileSize, docfile.writtentime");
		stringBuffer.append("  from swdocgroup doc, swfile docfile");
		stringBuffer.append(" where doc.docid = docfile.id");
		stringBuffer.append("   and doc.tskinstanceid = :taskInstId");
		stringBuffer.append(" order by docfile.writtenTime desc");

		Query query = this.getSession().createSQLQuery(stringBuffer.toString());
		if (!CommonUtil.isEmpty(taskInstId))
			query.setString("taskInstId", taskInstId);

		List list = query.list();

		if (CommonUtil.isEmpty(list))
			return null;
		List<IFileModel> objList = new ArrayList<IFileModel>();
		for (Iterator itr = list.iterator(); itr.hasNext();) {
			Object[] fields = (Object[]) itr.next();
			IFileModel obj = new HbFileModel();
			int j = 0;
			obj.setTskInstanceId((String)fields[j++]);
			obj.setId((String)fields[j++]);
			obj.setType((String)fields[j++]);
			obj.setFileName((String)fields[j++]);
			obj.setFilePath((String)fields[j++]);
			obj.setFileSize(Long.parseLong(String.valueOf(fields[j++])));
			obj.setWrittenTime((Timestamp)fields[j++]);
			objList.add(obj);
		}
		IFileModel[] fileModels = new HbFileModel[objList.size()];
		objList.toArray(fileModels);

		return fileModels;
	}

	public IFileModel getFileById(String fileId) throws DocFileException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select id, type, fileName, filePath, fileSize, writtenTime");
		stringBuffer.append("  from SwFile");
		stringBuffer.append(" where id = :fileId");

		Query query = this.getSession().createSQLQuery(stringBuffer.toString());
		if (!CommonUtil.isEmpty(fileId))
			query.setString("fileId", fileId);

		List list = query.list();
		if (CommonUtil.isEmpty(list))
			return null;

		List<IFileModel> objList = new ArrayList<IFileModel>();
		for (Iterator itr = list.iterator(); itr.hasNext();) {
			Object[] fields = (Object[]) itr.next();
			IFileModel obj = new HbFileModel();
			int j = 0;
			obj.setId((String)fields[j++]);
			obj.setType((String)fields[j++]);
			obj.setFileName((String)fields[j++]);
			obj.setFilePath((String)fields[j++]);
			obj.setFileSize(Long.parseLong(String.valueOf(fields[j++])));
			obj.setWrittenTime((Timestamp)fields[j++]);
			objList.add(obj);
		}
		IFileModel[] fileModels = new HbFileModel[objList.size()];
		objList.toArray(fileModels);

		return fileModels[0];
	}

	private Query appendQuery(StringBuffer queryBuffer, FileWorkCond cond) throws Exception {

		String tskAssignee = cond.getTskAssignee();
		String tskAssigneeOrTskSpaceId = cond.getTskAssigneeOrSpaceId();
		//assingnedOnly 값이 true 라면 실행중인(11) 태스크만 조회를 한다.
		String tskStatus =  cond.getTskStatus();
		String prcStatus = cond.getPrcStatus();
		Date lastInstanceDate = cond.getLastInstanceDate();
		String tskRefType = cond.getTskRefType();
		String folderId = cond.getFolderId();
		String writtenTimeMonthString = cond.getWrittenTimeMonthString();
		String packageId = cond.getPackageId();
		String fileType = cond.getFileType();
		int pageNo = cond.getPageNo();
		int pageSize = cond.getPageSize();

		String worksSpaceId = cond.getTskWorkSpaceId();
		Date executionDateFrom = cond.getTskExecuteDateFrom();
		Date executionDateTo = cond.getTskExecuteDateTo();
		Filters[] filtersArray = cond.getFilters();

		queryBuffer.append("from ");
		queryBuffer.append("( ");
		queryBuffer.append("  select docfile.id as fileId ");
		queryBuffer.append("	    , docfile.type as fileType ");
		queryBuffer.append("	    , docfile.fileName ");
		queryBuffer.append("	    , docfile.filePath ");
		queryBuffer.append("	    , docfile.fileSize ");
		queryBuffer.append("	    , docfile.writtenTime ");
		queryBuffer.append("	    , docgroup.groupId ");
		queryBuffer.append("	    , folder.id as folderId ");
		queryBuffer.append("	    , folder.name as folderName ");
		queryBuffer.append("	    , task.tskobjId ");
		queryBuffer.append("		, task.tsktitle ");
		queryBuffer.append("		, task.tskDoc ");
		queryBuffer.append("		, task.tsktype ");
		queryBuffer.append("		, task.tskReftype ");
		queryBuffer.append("		, task.tskstatus ");
		queryBuffer.append("		, task.tskassignee ");
		queryBuffer.append("		, case when task.tskstatus='11' then task.tskassigndate else task.tskexecuteDate end as taskLastModifyDate ");
		queryBuffer.append("		, task.tskcreatedate ");
		queryBuffer.append("		, task.tskname ");
		queryBuffer.append("		, task.tskprcinstid ");
		queryBuffer.append("		, task.tskform ");
		queryBuffer.append("		, task.isStartActivity ");
		queryBuffer.append("		, task.tskWorkSpaceId ");//workSpaceId
		queryBuffer.append("		, task.tskDef ");//workSpaceId
		queryBuffer.append("		, form.packageId ");
		queryBuffer.append("		, pkg.name as packageName ");
		queryBuffer.append("		, ctg.id as childCtgId ");
		queryBuffer.append("		, ctg.name as childCtgName ");
		queryBuffer.append("		, case when ctg.parentId = '_PKG_ROOT_' then null else ctg2.id end as parentCtgId ");
		queryBuffer.append("		, case when ctg.parentId = '_PKG_ROOT_' then null else ctg2.name end as parentCtgName ");
		queryBuffer.append("	from tsktask task ");
		queryBuffer.append("		right outer join ");
		queryBuffer.append("		swdocgroup docgroup ");
		queryBuffer.append("		on task.tskobjid = docgroup.tskinstanceId ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swfile docfile ");
		queryBuffer.append("		on docgroup.docId = docfile.id ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swfolderfile folderfile ");
		queryBuffer.append("		on folderfile.fileid = docfile.id ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swfolder folder ");
		queryBuffer.append("		on folder.id = folderfile.folderid ");
		queryBuffer.append("		, swform form ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swpackage pkg ");
		queryBuffer.append("		on form.packageId = pkg.packageId ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swcategory ctg ");
		queryBuffer.append("		on ctg.id = pkg.categoryId ");
		queryBuffer.append("		left outer join ");
		queryBuffer.append("		swcategory ctg2 ");
		queryBuffer.append("		on ctg.parentId = ctg2.id ");
		queryBuffer.append("	where tsktype not in ('and','route','SUBFLOW','xor') ");
		queryBuffer.append("	and task.tskform = form.formid ");
		/*if (!CommonUtil.isEmpty(filtersArray)) {
			for(Filters filters : filtersArray) {
				Filter[] filterArray = filters.getFilter();
				if (!CommonUtil.isEmpty(filterArray)) {
					for(Filter filter : filterArray) {
						String leftOperandValue = filter.getLeftOperandValue();
						String operator = filter.getOperator();
						String rightOperandValue = filter.getRightOperandValue();
						if(rightOperandValue.equals(FileCategory.ID_UNCATEGORIZED)) {
							queryBuffer.append("and ").append(leftOperandValue).append(" is null ");
						} else {
							if(!leftOperandValue.equals("writtenTime"))
								queryBuffer.append("and ").append(leftOperandValue).append(" ").append(operator).append(" :").append(leftOperandValue).append(" ");
						}
					}
				}
			}
		}*/
		if (!CommonUtil.isEmpty(folderId)) {
			if(folderId.equals(FileCategory.ID_UNCATEGORIZED)) queryBuffer.append("	and folder.id is null ");
			else queryBuffer.append("	and folder.id = :folderId ");
		}
		if (!CommonUtil.isEmpty(packageId)) {
			queryBuffer.append("	and form.packageId = :packageId ");
		}
		if (!CommonUtil.isEmpty(writtenTimeMonthString)) {
			if(this.getDbType().equalsIgnoreCase("sqlserver"))
				queryBuffer.append("	and datename(yy, docfile.writtenTime) + '.' + datename(mm, docfile.writtenTime) = :writtenTimeMonthString ");
			else if(this.getDbType().equalsIgnoreCase("oracle"))
				queryBuffer.append("	and to_char(docfile.writtenTime, 'YYYY') || '.' || to_char(docfile.writtenTime, 'MM') = :writtenTimeMonthString ");
		}
		if (!CommonUtil.isEmpty(fileType))
			queryBuffer.append("	and docfile.type = :fileType ");
		if (!CommonUtil.isEmpty(tskAssignee))
			queryBuffer.append("	and task.tskassignee = :tskAssignee ");
		if (!CommonUtil.isEmpty(tskAssigneeOrTskSpaceId))
			queryBuffer.append("	and (task.tskassignee = :tskAssigneeOrTskSpaceId or task.tskWorkSpaceId = :tskAssigneeOrTskSpaceId) ");
		if (!CommonUtil.isEmpty(tskStatus))
			queryBuffer.append("	and task.tskstatus = :tskStatus ");
		if (!CommonUtil.isEmpty(worksSpaceId))
			queryBuffer.append("	and task.tskWorkSpaceId = :worksSpaceId ");
		if (executionDateFrom != null)
			queryBuffer.append("	and task.tskExecuteDate > :executionDateFrom ");
		if (executionDateTo != null)
			queryBuffer.append("	and task.tskExecuteDate < :executionDateTo ");
		queryBuffer.append(") taskInfo ");
		//queryBuffer.append("left outer join ");
		queryBuffer.append("join ");
		queryBuffer.append("( ");
		queryBuffer.append("	select ");
		queryBuffer.append("		 prcInst.prcObjId ");
		queryBuffer.append("		, prcInst.prcTitle ");
		queryBuffer.append("		, prcInst.prcType ");
		queryBuffer.append("		, prcInst.prcStatus ");
		queryBuffer.append("		, prcInst.prcCreateUser ");
		queryBuffer.append("		, prcInst.prcDid ");
		queryBuffer.append("		, prcInst.prcPrcId ");
		queryBuffer.append("		, prcInst.prcCreateDate ");
		queryBuffer.append("		, prcInst.prcWorkSpaceId "); //workSpaceId
		queryBuffer.append("		, prcInstInfo.lastTask_tskobjid ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskname ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskcreateuser ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskcreateDate ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskstatus ");
		queryBuffer.append("		, prcInstInfo.lastTask_tsktype ");
		queryBuffer.append("		, prcInstInfo.lastTask_tsktitle ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskassignee ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskexecuteDate ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskduedate ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskform ");
		queryBuffer.append("		, prcInstInfo.lastTask_tskWorkSpaceId "); //workSpaceId
		queryBuffer.append("		, (select count(*) from tsktask where tskstatus='11' and tsktype='common' and tskprcInstId = prcInst.prcObjid) as lastTaskCount ");
		queryBuffer.append("	from  ");
		queryBuffer.append("		prcprcinst prcInst,  ");
		queryBuffer.append("		( ");
		queryBuffer.append("			select a.tskprcinstid as lastTask_tskprcinstid ");
		queryBuffer.append("					, task.tskobjid as lastTask_tskobjid ");
		queryBuffer.append("					, task.tskname as lastTask_tskname ");
		queryBuffer.append("					, task.tskcreateuser as lastTask_tskcreateuser ");
		queryBuffer.append("					, task.tskcreateDate as lastTask_tskcreateDate ");
		queryBuffer.append("					, task.tskstatus as lastTask_tskstatus ");
		queryBuffer.append("					, task.tsktype as lastTask_tsktype ");
		queryBuffer.append("					, task.tsktitle as lastTask_tsktitle ");
		queryBuffer.append("					, task.tskassignee as lastTask_tskassignee ");
		queryBuffer.append("					, task.tskexecuteDate as lastTask_tskexecuteDate ");
		queryBuffer.append("					, task.tskduedate as lastTask_tskduedate ");
		queryBuffer.append("					, task.tskform as lastTask_tskform ");
		queryBuffer.append("					, task.tskWorkSpaceId as lastTask_tskWorkSpaceId "); //workSpaceId
		queryBuffer.append("			from ( ");
		queryBuffer.append("					select tskprcinstId , max(tskCreatedate) as createDate  ");
		queryBuffer.append("					from tsktask  ");
		queryBuffer.append("					where tsktype not in ('and','route','SUBFLOW','xor') ");
		queryBuffer.append("					group by tskprcinstid ");
		queryBuffer.append("				  ) a,	 ");
		queryBuffer.append("				  TskTask task		 ");
		queryBuffer.append("			where  ");
		queryBuffer.append("				a.createDate = task.tskcreatedate ");
		queryBuffer.append("		) prcInstInfo	 ");
		queryBuffer.append("	where ");
		queryBuffer.append("		prcInst.prcobjid=prcInstInfo.lastTask_tskprcinstid ");
		if (!CommonUtil.isEmpty(prcStatus))
			queryBuffer.append("		and prcInst.prcStatus = :prcStatus ");
		queryBuffer.append(") prcInstInfo ");
		queryBuffer.append("on taskInfo.tskPrcInstId = prcInstInfo.prcObjId ");
		if (lastInstanceDate != null) {
			queryBuffer.append("where taskInfo.tskCreateDate < :lastInstanceDate ");
			if (tskRefType != null) {
				if(tskRefType.equals(TskTask.TASKREFTYPE_NOTHING))
					queryBuffer.append("and taskInfo.tskReftype is null ");
				else 
					queryBuffer.append("and taskInfo.tskReftype = :tskRefType ");
			}
		} else {
			if (tskRefType != null) {
				if(tskRefType.equals(TskTask.TASKREFTYPE_NOTHING))
					queryBuffer.append("where taskInfo.tskReftype is null ");
				else 
					queryBuffer.append("where taskInfo.tskReftype = :tskRefType ");
			}
		}

		this.appendOrderQuery(queryBuffer, "taskInfo", cond);
		//queryBuffer.append("order by taskInfo.tskCreatedate desc ");

		Query query = this.getSession().createSQLQuery(queryBuffer.toString());

		if (pageSize > 0 || pageNo >= 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		/*if (!CommonUtil.isEmpty(filtersArray)) {
			for(Filters filters : filtersArray) {
				Filter[] filterArray = filters.getFilter();
				if (!CommonUtil.isEmpty(filterArray)) {
					for(Filter filter : filterArray) {
						String leftOperandValue = filter.getLeftOperandValue();
						String rightOperandValue = filter.getRightOperandValue();
						if(!rightOperandValue.equals(FileCategory.ID_UNCATEGORIZED)) {
							if(!leftOperandValue.equals("writtenTime"))
								query.setString(leftOperandValue, rightOperandValue);
						}
					}
				}
			}
		}*/
		if (!CommonUtil.isEmpty(folderId) && !folderId.equals(FileCategory.ID_UNCATEGORIZED))
			query.setString("folderId", folderId);
		if (!CommonUtil.isEmpty(packageId))
			query.setString("packageId", packageId);
		if (!CommonUtil.isEmpty(writtenTimeMonthString))
			query.setString("writtenTimeMonthString", writtenTimeMonthString);
		if (!CommonUtil.isEmpty(fileType))
			query.setString("fileType", fileType);
		if (!CommonUtil.isEmpty(tskAssignee))
			query.setString("tskAssignee", tskAssignee);
		if (!CommonUtil.isEmpty(tskAssigneeOrTskSpaceId))
			query.setString("tskAssigneeOrTskSpaceId", tskAssigneeOrTskSpaceId);
		if (!CommonUtil.isEmpty(tskStatus))
			query.setString("tskStatus", tskStatus);
		if (lastInstanceDate != null)
			query.setTimestamp("lastInstanceDate", lastInstanceDate);
		if (!CommonUtil.isEmpty(worksSpaceId))
			query.setString("worksSpaceId", worksSpaceId);
		if (executionDateFrom != null)
			query.setTimestamp("executionDateFrom", executionDateFrom);
		if (executionDateTo != null)
			query.setTimestamp("executionDateTo", executionDateTo);
		if (!CommonUtil.isEmpty(prcStatus)) 
			query.setString("prcStatus", prcStatus);
		if (!CommonUtil.isEmpty(tskRefType) && !tskRefType.equals(TskTask.TASKREFTYPE_NOTHING)) 
			query.setString("tskRefType", tskRefType);

		return query;
	}

	@Override
	public long getFileWorkListSize(String user, FileWorkCond cond) throws Exception {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(*) ");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			
			long count =((Integer)list.get(0)).longValue();
			return count;
		} catch (PrcException e) {
			throw e;
		} catch (Exception e) {
			throw new PrcException(e);
		}
	}

	@Override
	public FileWork[] getFileWorkList(String user, FileWorkCond cond) throws Exception {
		try {
			StringBuffer queryBuffer = new StringBuffer();
			queryBuffer.append(" select taskInfo.*, ");
			queryBuffer.append(" prcInstInfo.* ");
			
			Query query = this.appendQuery(queryBuffer, cond);

			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			List objList = new ArrayList();
			for (Iterator itr = list.iterator(); itr.hasNext();) {
				Object[] fields = (Object[]) itr.next();
				FileWork obj = new FileWork();
				int j = 0;

				obj.setFileId((String)fields[j++]);
				obj.setFileType((String)fields[j++]);
				obj.setFileName((String)fields[j++]);
				obj.setFilePath((String)fields[j++]);
				obj.setFileSize(Long.parseLong(String.valueOf(fields[j++])));
				obj.setWrittenTime((Timestamp)fields[j++]);
				obj.setGroupId((String)fields[j++]);
				obj.setFolderId((String)fields[j++]);
				obj.setFolderName((String)fields[j++]);
				obj.setTskObjId((String)fields[j++]);
				obj.setTskTitle((String)fields[j++]);
				Clob varData = (Clob)fields[j++];
				long length = 0;
				String tempCountStr = "";
				if(varData != null) {
					length = varData.length();
					tempCountStr = varData.getSubString(1, (int)length);
				}
				obj.setTskDoc(tempCountStr);
				obj.setTskType((String)fields[j++]);     
				obj.setTskRefType((String)fields[j++]);     
				obj.setTskStatus((String)fields[j++]);   
				obj.setTskAssignee((String)fields[j++]); 
				obj.setTaskLastModifyDate((Timestamp)fields[j++]);
				obj.setTskCreateDate((Timestamp)fields[j++]);
				obj.setTskName((String)fields[j++]);     
				obj.setTskPrcInstId((String)fields[j++]);
				obj.setTskForm((String)fields[j++]);     
				obj.setIsStartActivity((String)fields[j++]); 
				obj.setTskWorkSpaceId((String)fields[j++]);     
				obj.setTskDef((String)fields[j++]);     
				obj.setPackageId((String)fields[j++]);     
				obj.setPackageName((String)fields[j++]);   
				obj.setChildCtgId((String)fields[j++]);  
				obj.setChildCtgName((String)fields[j++]);
				obj.setParentCtgId((String)fields[j++]); 
				obj.setParentCtgName((String)fields[j++]);
				obj.setPrcObjId((String)fields[j++]);                           
				obj.setPrcTitle((String)fields[j++]);                           
				obj.setPrcType((String)fields[j++]);                            
				obj.setPrcStatus((String)fields[j++]);                          
				obj.setPrcCreateUser((String)fields[j++]);                      
				obj.setPrcDid((String)fields[j++]);                             
				obj.setPrcPrcId((String)fields[j++]); 
				obj.setPrcCreateDate((Timestamp)fields[j++]);                    
				obj.setPrcWorkSpaceId((String)fields[j++]); 
				obj.setLastTskObjId((String)fields[j++]);                       
				obj.setLastTskName((String)fields[j++]);                        
				obj.setLastTskCreateUser((String)fields[j++]);                  
				obj.setLastTskCreateDate((Timestamp)fields[j++]);                  
				obj.setLastTskStatus((String)fields[j++]);                      
				obj.setLastTskType((String)fields[j++]);                        
				obj.setLastTskTitle((String)fields[j++]);                       
				obj.setLastTskAssignee((String)fields[j++]);                    
				obj.setLastTskExecuteDate((Timestamp)fields[j++]);                 
				obj.setLastTskDueDate((Timestamp)fields[j++]); 
				obj.setLastTskForm((String)fields[j++]);    
				obj.setLastTskWorkSpaceId((String)fields[j++]);                    
				int lastTaskCount = (Integer)fields[j] == null ? -1 : (Integer)fields[j];
				obj.setLastTskCount(lastTaskCount == 0 ? 1 : lastTaskCount);
				objList.add(obj);
			}
			list = objList;
			FileWork[] objs = new FileWork[list.size()];
			list.toArray(objs);
			return objs;
				
		} catch (Exception e) {
			throw new DocFileException(e);
		}
	}
	public String getDbType() {
		if (dbType == null) {
			SessionFactory sf = getSessionFactory();
			SessionFactoryImplementor sfi = (SessionFactoryImplementor)sf;
			Dialect dialect = sfi.getDialect();
			if (dialect instanceof PostgreSQLDialect) {
				dbType = "postgresql";
			} else if (dialect instanceof SQLServerDialect) {
				dbType = "sqlserver";
			} else {
				dbType = "oracle";
			}
		}
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

}