/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.server.engine.docfile.model.IFileModel;


public interface IDocFileService {

/*	public abstract String createFile(String userId, String groupId, IFileModel file) throws Exception;

	public abstract String createFileList(String userId, String groupId, List<IFileModel> fileList) throws Exception;

	public abstract IFileModel retrieveFile(String fileId) throws Exception;

	public abstract void updateFile(String userId, IFileModel file) throws Exception;

	public abstract void deleteFile(String fileId) throws Exception;

	public abstract void deleteFileGroup(String groupId) throws Exception;

	public abstract List<IFileModel> findFileGroup(String groupId) throws Exception;

	public abstract List<String> findFileIdListByGroup(String groupId) throws Exception;

	public abstract String createDocument(String userId, String groupId, IDocumentModel document, List<FileItem> fileList) throws Exception;

	public abstract void updateDocument(String userId, IDocumentModel document) throws Exception;

	public abstract IDocumentModel retrieveDocument(String documentId) throws Exception;

	public abstract IDocumentModel retrieveDocumentByGroupId(String fileGroupId) throws Exception;

	public abstract List<String> findDocIdByGroupId(String fileGroupId) throws Exception;

	public abstract void deleteDocument(String documentId) throws Exception;

	public abstract IDocumentModel retrieveDocumentByRef(int refType, String refId) throws Exception;*/

	public abstract String uploadFile(HttpServletRequest request) throws Exception;

	public abstract void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public abstract List<IFileModel> findFileGroup(HttpServletRequest request) throws Exception;

	public abstract void deleteFile(HttpServletRequest request) throws Exception;

	public abstract void setUserPicture(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public abstract void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception;

}