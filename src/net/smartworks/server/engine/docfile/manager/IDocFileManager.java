/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.model.IDocumentModel;
import net.smartworks.server.engine.docfile.model.IFileModel;

public interface IDocFileManager extends IManager {

/*	public DocFile getDocFile(String user, String objId, String level) throws DocFileException;
	public DocFile getDocFile(String user, DocFileCond cond, String level) throws DocFileException;
	public void setDocFile(String user, DocFile obj, String level) throws DocFileException;
	public void removeDocFile(String user, String objId) throws DocFileException;
	public void removeDocFile(String user, DocFileCond cond) throws DocFileException;
	public long getDocFileSize(String user, DocFileCond cond) throws DocFileException;
	public DocFile[] getDocFiles(String user, DocFileCond cond, String level) throws DocFileException;*/

//	public String createFile(String userId, String groupId, IFileModel file) throws DocFileException;
	public String createFileList(String userId, String groupId, List<IFileModel> fileList, HttpServletRequest request) throws DocFileException;
	public void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws DocFileException;
	public void ajaxUploadTempFile(HttpServletRequest request, HttpServletResponse response) throws DocFileException;
	public void uploadTempFile(HttpServletRequest request, HttpServletResponse response) throws DocFileException;
	public IFileModel retrieveFile(String fileId) throws DocFileException;
	public void updateFile(String userId, IFileModel file) throws DocFileException;
	public void deleteFile(String fileId) throws DocFileException;
	public void deleteFileGroup(String groupId) throws DocFileException;
	public List<IFileModel> findFileGroup(String groupId) throws DocFileException;
	public List<String> findFileIdListByGroup(String groupId) throws DocFileException;
	public String insertProfilesFile(String fileId, String fileName, String communityId) throws DocFileException;
	public void updateDocument(String userId, IDocumentModel document) throws DocFileException;
	public IDocumentModel retrieveDocument(String documentId) throws DocFileException;
	public IDocumentModel retrieveDocumentByGroupId(String fileGroupId) throws DocFileException;
	public List<String> findDocIdByGroupId(String fileGroupId) throws DocFileException;
	public void deleteDocument(String documentId) throws DocFileException;
	public IDocumentModel retrieveDocumentByRef(int refType, String refId) throws DocFileException;

}