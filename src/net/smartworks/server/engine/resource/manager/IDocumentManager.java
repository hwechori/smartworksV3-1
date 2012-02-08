package net.smartworks.server.engine.resource.manager;

import java.util.List;

import net.smartworks.server.engine.docfile.model.IDocumentModel;
import net.smartworks.server.engine.docfile.model.IFileModel;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;

import org.apache.commons.fileupload.FileItem;

/**
 * 문서를 관리하는 매니저
 * 
 * @author jhnam
 * @version $Id: IDocumentManager.java,v 1.1 2011/11/08 03:15:13 kmyu Exp $
 */
public interface IDocumentManager {

	/**
	 * 첨부 파일을 생성한다.
	 * 
	 * @param userId
	 * @param groupId
	 * @param file
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String createFile(String userId, String groupId, IFileModel file) throws SmartServerRuntimeException;
	
	/**
	 * 첨부 파일 리스트를 생성한다.
	 * 
	 * @param userId
	 * @param groupId
	 * @param fileList
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String createFileList(String userId, String groupId, List<IFileModel> fileList) throws SmartServerRuntimeException;
	
	/**
	 * 첨부 파일을 조회
	 * 
	 * @param userId
	 * @param fileId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFileModel retrieveFile(String userId, String fileId) throws SmartServerRuntimeException;
	
	/**
	 * 첨부 파일 업데이트
	 * 
	 * @param userId
	 * @param file
	 * @throws SmartServerRuntimeException
	 */
	public void updateFile(String userId, IFileModel file) throws SmartServerRuntimeException;
	
	/**
	 * 첨부 파일 삭제
	 * 
	 * @param userId
	 * @param fileId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteFile(String userId, String fileId) throws SmartServerRuntimeException;
	
	/**
	 * 그룹 아이디로 파일 그룹을 삭제한다.
	 * 
	 * @param userId
	 * @param groupId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteFileGroup(String userId, String groupId) throws SmartServerRuntimeException;
	
	/**
	 * 그룹 아이디로 파일 그룹에 속한 파일 리스트를 검색
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFileModel> findFileGroup(String userId, String groupId) throws SmartServerRuntimeException;
	
	/**
	 * 그룹 아이디로 파일 그룹에 속한 파일 아이디 리스트를 검색
	 * 
	 * @param groupId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<String> findFileIdListByGroup(String groupId) throws SmartServerRuntimeException;
	
	/**
	 * 문서를 생성한 후 문서 그룹아이디를 리턴한다.
	 * 만일 그룹아이디가 null이면 그룹아이디를 생성하고 null이 아니면 해당 그룹아이디와 새로 생성된 문서 아이디를 묶는다.
	 * 
	 * @param userId
	 * @param groupId
	 * @param document
	 * @param fileList
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String createDocument(String userId, String groupId, IDocumentModel document, List<FileItem> fileList) throws SmartServerRuntimeException;

	/**
	 * 문서정보를 업데이트
	 * 
	 * @param userId
	 * @param document
	 * @throws SmartServerRuntimeException
	 */
	public void updateDocument(String userId, IDocumentModel document) throws SmartServerRuntimeException;
	
	/**
	 * documentId로 문서를 조회
	 * 
	 * @param userId
	 * @param documentId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDocumentModel retrieveDocument(String userId, String documentId) throws SmartServerRuntimeException;
	
	/**
	 * 파일 그룹 아이디로 문서를 검색
	 * 
	 * @param userId
	 * @param fileGroupId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDocumentModel retrieveDocumentByGroupId(String userId, String fileGroupId) throws SmartServerRuntimeException;
	
	/**
	 * 참조 정보로 문서를 검색
	 * 
	 * @param userId
	 * @param refType
	 * @param refId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDocumentModel retrieveDocumentByRef(String userId, int refType, String refId) throws SmartServerRuntimeException;
	
	/**
	 * 파일 그룹 아이디로 문서 아이디 리스트를 검색
	 * 
	 * @param userId
	 * @param fileGroupId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<String> findDocIdByGroupId(String userId, String fileGroupId) throws SmartServerRuntimeException;
	
	/**
	 * documentId로 문서 삭제
	 * 
	 * @param userId
	 * @param documentId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteDocument(String userId, String documentId) throws SmartServerRuntimeException;
	
}
