/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.HbFileModel;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.service.IDocFileService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class DocFileServiceImpl implements IDocFileService {

	private IDocFileManager getDocManager() {
		return SwManagerFactory.getInstance().getDocManager();
	}

	public String uploadFile(HttpServletRequest request) throws Exception {

		String userId = CommonUtil.toNotNull(request.getParameter("userId"));
		String groupId = CommonUtil.toNotNull(request.getParameter("groupId"));	
		//String fileSaveTempPath = request.getSession().getServletContext().getRealPath("/uploadDataTemp/");

/*		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 10);*/
		//factory.setRepository(new File(fileSaveTempPath));
		//ServletFileUpload upload = new ServletFileUpload(factory);
		//List items = upload.parseRequest(request);
	 	//upload.setSizeMax(1024 * 1024 * 1000);

		List<IFileModel> docList = new ArrayList<IFileModel>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = multipartRequest.getFileMap();

        for(String fileName : files.keySet()) {
        	MultipartFile mf = files.get(fileName);
        	IFileModel doc = new HbFileModel();
        	doc.setMultipartFile(mf);
        	docList.add(doc);
        }
 		// 첨부 파일인 경우에는 첨부 파일 하나당 문서 모델 하나를 생성한다.
/* 		while(itemIter.hasNext()) {
			FileItem item = itemIter.next();

			if(item.isFormField())
				continue;

			IFileModel doc = new HbFileModel();
	    	doc.setFileItem(item);
			docList.add(doc);
 		}*/

		groupId = getDocManager().createFileList(userId, (groupId.equals("") ? null : groupId), docList);

		return groupId;

	}

	@Override
	public void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		getDocManager().ajaxUploadFile(request, response);
	}

	public List<IFileModel> findFileGroup(HttpServletRequest request) throws Exception {

		String groupId = CommonUtil.toNotNull(request.getParameter("groupId"));

		List<IFileModel> fileList = new ArrayList<IFileModel>(); 

		fileList = getDocManager().findFileGroup(groupId);

		return fileList;

	}

	public void deleteFile(HttpServletRequest request) throws Exception {

		String fileId = CommonUtil.toNotNull(request.getParameter("fileId"));
		IFileModel doc = getDocManager().retrieveFile(fileId);
		String filePath = doc.getFilePath();
		getDocManager().deleteFile(fileId);

		File f = new File(filePath);
		f.delete();

	}

/*	@Override
	public String createFile(String userId, String groupId, IFileModel file) throws Exception {
		return getDocManager().createFile(userId, groupId, file);
	}

	@Override
	public String createFileList(String userId, String groupId, List<IFileModel> fileList) throws Exception {
		return getDocManager().createFileList(userId, groupId, fileList);
	}

	@Override
	public IFileModel retrieveFile(String fileId) throws Exception {
		 return getDocManager().retrieveFile(fileId);
	}

	@Override
	public void updateFile(String userId, IFileModel file) throws Exception {
		getDocManager().updateFile(userId, file);
	}

	@Override
	public void deleteFile(String fileId) throws Exception {
		getDocManager().deleteFile(fileId);
	}

	@Override
	public void deleteFileGroup(String groupId) throws Exception {
		getDocManager().deleteFileGroup(groupId);
	}

	@Override
	public List<IFileModel> findFileGroup(String groupId) throws Exception {
		return getDocManager().findFileGroup(groupId);
	}

	@Override
	public List<String> findFileIdListByGroup(String groupId) throws Exception {
		return getDocManager().findFileIdListByGroup(groupId);
	}

	@Override
	public String createDocument(String userId, String groupId, IDocumentModel document, List<FileItem> fileList) throws Exception {
		return getDocManager().createDocument(userId, groupId, document, fileList);
	}

	@Override
	public void updateDocument(String userId, IDocumentModel document) throws Exception {
		getDocManager().updateDocument(userId, document);
	}

	@Override
	public IDocumentModel retrieveDocument(String documentId) throws Exception {
		return getDocManager().retrieveDocument(documentId);
	}

	@Override
	public IDocumentModel retrieveDocumentByGroupId(String fileGroupId) throws Exception {
		return getDocManager().retrieveDocumentByGroupId(fileGroupId);
	}

	@Override
	public List<String> findDocIdByGroupId(String fileGroupId) throws Exception {
		return getDocManager().findDocIdByGroupId(fileGroupId);
	}

	@Override
	public void deleteDocument(String documentId) throws Exception {
		getDocManager().deleteDocument(documentId);
	}

	@Override
	public IDocumentModel retrieveDocumentByRef(int refType, String refId) throws Exception {
		return getDocManager().retrieveDocumentByRef(refType, refId);
	}*/

}