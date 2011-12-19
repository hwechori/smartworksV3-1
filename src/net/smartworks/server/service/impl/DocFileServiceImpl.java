/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.impl;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.community.User;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.HbFileModel;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.service.IDocFileService;
import net.smartworks.util.SmartConfUtil;
import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class DocFileServiceImpl implements IDocFileService {

	private IDocFileManager getDocManager() {
		return SwManagerFactory.getInstance().getDocManager();
	}

	public void uploadFile(HttpServletRequest request) throws Exception {

		String userId = CommonUtil.toNotNull(request.getParameter("userId"));
		String groupId = CommonUtil.toNotNull(request.getParameter("groupId"));

		List<IFileModel> docList = new ArrayList<IFileModel>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = multipartRequest.getFileMap();

        for(String fileName : files.keySet()) {
        	MultipartFile mf = files.get(fileName);
        	IFileModel doc = new HbFileModel();
        	doc.setMultipartFile(mf);
        	docList.add(doc);
        }

		getDocManager().createFileList(userId, (groupId.equals("") ? null : groupId), docList, request);

	}

	public void uploadFiles(HttpServletRequest request) throws Exception {

		List<IFileModel> docList = new ArrayList<IFileModel>();
		Map<String, String> files = new HashMap<String, String>();
		for(String fileId : files.keySet()) {
			String fileName = files.get(fileId);
			IFileModel doc = new HbFileModel();
			doc.setId(fileId);
			doc.setFileName(fileName);
			docList.add(doc);
		}

	}

	@Override
	public void ajaxUploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		getDocManager().ajaxUploadTempFile(request, response);
	}

	public List<IFileModel> findFileGroup(HttpServletRequest request) throws Exception {

		String groupId = CommonUtil.toNotNull(request.getParameter("groupId"));

		List<IFileModel> fileList = new ArrayList<IFileModel>(); 

		fileList = getDocManager().findFileGroup(groupId);

		return fileList;

	}

	public void deleteFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String fileId = CommonUtil.toNotNull(request.getParameter("fileId"));
		String fileName = CommonUtil.toNotNull(request.getParameter("fileName"));
		String filePath = "";
		User user = SmartUtil.getCurrentUser();

		if(fileId.startsWith("temp_")) {
			String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
			filePath = SmartConfUtil.getInstance().getImageServer() + user.getCompanyId() + "\\"+ "Temps" + "\\" + fileId + "." + extension;
		} else {
			IFileModel doc = getDocManager().retrieveFile(fileId);
			filePath = doc.getFilePath();
			getDocManager().deleteFile(fileId);
		}
		File f = new File(filePath);
		f.delete();

	}

	@Override
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		DataInputStream in = null;
    	ServletOutputStream op = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

    	try{

    		String fileId = request.getParameter("fileId");
    		String fileName = request.getParameter("fileName");

    		User user = SmartUtil.getCurrentUser();

    		String sourceFile = "";
    		String file_name = "";

    		int count = fileId.indexOf("temp_");
    		System.out.println(count);
    		String extension = fileName.lastIndexOf(".") > 1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
    		if(fileId.startsWith("temp_")) {
    			file_name = fileName;
    			sourceFile = System.getenv("SMARTWORKS_FILE_DIRECTORY") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_DIRECTORY") + "/" + user.getCompanyId() + "/"+ "Temps" + "/" + fileId + "." + extension;
    			//sourceFile = System.getenv("SMARTWORKS_FILE_HOME") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_HOME") + File.separator + user.getCompanyId() + File.separator + "Temps" + File.separator + fileId + "." + extension;
    		} else {
    			IFileModel doc = getDocManager().retrieveFile(fileId);
	    		//파일명, UniqValue
	    		file_name = doc.getFileName(); 
    			sourceFile = doc.getFilePath();
    		}

    		File file = new File(sourceFile);
    		int length = 0;
    		op = response.getOutputStream();

    		response.setContentType("application/octet-stream" );
    		response.setContentLength((int)file.length());
    		file_name = new String(file_name.getBytes(), response.getCharacterEncoding());
    		response.setHeader( "Content-Disposition", "attachment; filename=\"" + file_name + "\"" );

    		byte[] bbuf = new byte[4096];
    		in = new DataInputStream(new FileInputStream(file));
    		
    		while ((in != null) && ((length = in.read(bbuf)) != -1))
    		{
    			op.write(bbuf,0,length);
    		}
    		
    	}catch(Throwable t){
    		t.printStackTrace();
    		try{
    			if(in != null & op != null){
    				in.close();
    				op.flush();
    				op.close();
    			}			
    		}catch(Throwable th){
    		}
        } finally {
            if (inChannel != null)
                inChannel.close();
            if (outChannel != null)
                outChannel.close();
			op.flush();
        }
    }

	@Override
	public void uploadTempFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		getDocManager().uploadTempFile(request, response);
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
