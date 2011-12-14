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
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.community.User;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.docfile.model.HbFileModel;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.service.IDocFileService;
import net.smartworks.util.SmartUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class DocFileServiceImpl extends HttpServlet implements IDocFileService {

	private static final long serialVersionUID = 1L;

	private IDocFileManager getDocManager() {
		return SwManagerFactory.getInstance().getDocManager();
	}

	private AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

	public String uploadFile(HttpServletRequest request) throws Exception {

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

	@Override
	public void setUserPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = SmartUtil.getCurrentUser(request, response).getId();
		String password = SmartUtil.getCurrentUser(request, response).getPassword();

		try {
			getDocManager().setUserPicture(request, response);
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userId, password);
	        Authentication authentication = authenticationManager.authenticate(authRequest);
	        SecurityContext securityContext = new SecurityContextImpl();
	        securityContext.setAuthentication(authentication);
	        SecurityContextHolder.setContext(securityContext);
	        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		DataInputStream in = null;
    	ServletOutputStream op = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

    	try{
    		
    		Date date = new Date();
    		long mill = date.getTime();
    		String fileId = request.getParameter("fileId");

    		User user = SmartUtil.getCurrentUser(request, response);

    		// 문서 다운로드 사용자 사번: userId
    		String userId = request.getParameter("userId").equals("") ? user.getId() : request.getParameter("userId");
    		IFileModel doc = getDocManager().retrieveFile(fileId);
    		
    		//파일명, UniqValue
    		String file_name = doc.getFileName(); 
    		String uniqName = file_name + mill;
    		
    		String file = "";//사본파일경로
    		String sourceFile = doc.getFilePath();
    		
    		int ins = sourceFile.indexOf("swDocument");
    		file = sourceFile.substring(0, ins);
    		
    		file = file + "temp\\";
    		int inx = sourceFile.indexOf("file_");
    		file = file + sourceFile.substring(inx);
    		
    		//파일 사본 생성
    	    inChannel = new FileInputStream(sourceFile).getChannel();
    	    outChannel = new FileOutputStream(file).getChannel();
    	    
            // magic number for Windows, 64Mb - 32Kb
            int maxCount = (64 * 1024 * 1024) - (32 * 1024);
            long size = inChannel.size();
            long pos = 0;
            while (pos < size) {
            	pos += inChannel.transferTo(pos, maxCount, outChannel);
            }

            inChannel.close();
            outChannel.close();

    		//직급코드:position , 문서소유자, 문서다운로드 사용자 이름 : userName
			String position = user.getPosition();
			String userName = user.getName();
			String deptId = user.getDeptId();
			String empNo = user.getEmployeeId();
			
			//부서코드:dept, 회사:company
			String company = user.getCompanyId();
			String dept = user.getDepartment();

//			//  DRM
//			String FileName = new String(file);	 //	[[[[ 파일 풀경로 ]]]
//			//System.out.println("======="+FileName+"=====");
//			//File ffff = new File(FileName);
//			//System.out.println("======="+ffff.isFile()+"=======");
//			
//			int	 piAclFlag = 0;
//			int piDocLevel	 =	0;
//			String UserID = new String(empNo);	// [[[[ 문서 다운로드 사용자 사번 ]]]]	userId
//			String sFileName = new String(file_name);	// [[[[ 파일명 ]]]]	file_name
//			
//			int plFileSize	=	0;
//			String pstrOwnerId = new String(empNo);	// [[[[ 문서 소유자 ]]]] userId
//			String CompanyID = new String("SEMITEQ-C9FC-910F-7F18");
//			String pstrGroupId = new String(dept);		// [[[[ 부서코드 ]]]]
//			String pstrPositionId =	new String(position);	// [[[[ 직급코드 ]]]]
//			
//			String pstrGrade = new String("-");
//			String  pstrField = new String(uniqName);	// [[[[ 유니크한 파일 값 ]]]]	
//			
//			int CanSave = 1;
//			int CanEdit = 1;
//			int blockCopy	= 0;
//			
//			int piOpenCount	= -99;
//			int nPrintCount = -99;
//			int piValidPeriod	= -99;
//			int piSaveLog	= 1;
//			int piPrintLog = 1;	
//			
//			int piOpenLog = 1;
//			int piVisualPrint	= 1;
//			int piImageSafer	= 0;
//			int piRealTimeAcl = 0;
//			int piUnicodeFlag = 0;
//			String pstrServerAddr = new String("192.168.0.11:40002");	
//			
//			String pstrDocumentTitle	= new String(file_name); 
//			String pstrCompanyName	= new String(company); 
//			String pstrGroupName = new String("-"); 
//			String pstrPositionName = new String(position); 
//			String pstrUserName =	new String(userName);	// [[[[ 문서 다운로드 사용자 이름 ]]]] userId
//			
//			String pstrUserIp = new String("127.0.0.1");	// [[[[ 문서 다운로드 사용자 PC IP ]]]]
//			String pstrServerOrigin	 =	new String("SmartWorks");
//			int piExchangePolicy = 1;
//			int piDrmFlag = 0;
//			
//			//ykm
//			System.out.println(JNICipher.class.getName());
//			
//			int nRet = -1;
//			try 
//			{
//				nRet = JNICipher.EncryptFile(
//				FileName, 
//				piAclFlag, 
//				piDocLevel, 
//				UserID,
//				sFileName, 
//			
//				plFileSize, 
//				pstrOwnerId, 
//				CompanyID, 
//				pstrGroupId, 
//				pstrPositionId, 
//			
//				pstrGrade, 
//				pstrField, 
//				CanSave, 
//				CanEdit,
//				blockCopy, 
//			
//				piOpenCount, 
//				nPrintCount, 
//				piValidPeriod,
//				piSaveLog, 
//				piPrintLog, 
//			
//				piOpenLog, 
//				piVisualPrint, 
//				piImageSafer, 
//				piRealTimeAcl,
//				pstrServerAddr,
//			
//				pstrDocumentTitle,
//				pstrCompanyName,
//				pstrGroupName,
//				pstrPositionName,
//				pstrUserName,
//			
//				pstrUserIp,
//				pstrServerOrigin,
//				piExchangePolicy,
//				piDrmFlag,
//				piUnicodeFlag
//				);
//			} 
//			catch (UnsupportedEncodingException e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			// 1: 암호화 실패
//			// 2: 라이브러리 로드 실패(masdmsjni.dll)ㄹ
//			// 6: 파일명 비었음
//			// 7: 사번 비었음
//			//out.print("EncryptFile Return : " + nRet);
//			
//			
//			//DRM END
			
			
    		File                f        = new File(file);
    		int                 length   = 0;
    							op       = response.getOutputStream();
    		ServletContext      context  = getServletConfig().getServletContext();
    		String              mimetype = context.getMimeType(file);
    		
    		response.setContentType("application/octet-stream" );
    		response.setContentLength( (int)f.length() );
    		file_name = new String(file_name.getBytes(), response.getCharacterEncoding());
    		response.setHeader( "Content-Disposition", "attachment; filename=\"" + file_name + "\"" );

//    		response.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
//    		response.setContentType("application/x-download");
//    		response.setHeader( "Content-Disposition", "attachment; filename=\"" + file_name + "\"" );
    		
    		byte[] bbuf = new byte[4096];
    		in = new DataInputStream(new FileInputStream(f));
    		
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
        }
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