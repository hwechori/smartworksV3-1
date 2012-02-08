package net.smartworks.server.engine.resource.model.enums;

/**
 * 프로세스 필드 항목
 * 
 * @author jhnam
 * @version $Id: ProcessFieldEnum.java,v 1.1 2011/11/08 03:15:06 kmyu Exp $
 */
public enum ProcessFieldEnum {

	/**
	 * 프로세스 유니크 아이디
	 */
	id,
	/**
	 * 프로세스가 소속된 패키지 유니크 아이디
	 */
	packageId,
	/**
	 * 프로세스 아이디
	 */
	processId,
	/**
	 * 프로세스 버전
	 */
	version,
	/**
	 * 프로세스 이름
	 */
	name,
	/**
	 * 프로세스 상태
	 */
	status,
	/**
	 * 생성자
	 */
	creator,
	/**
	 * 생성시간
	 */
	createdTime,
	/**
	 * 생성 시간 From
	 */
	createdTimeFrom,
	/**
	 * 생성 시간 To
	 */
	createdTimeTo,		
	/**
	 * 갱신자
	 */
	modifier,
	/**
	 * 갱신시간
	 */
	modifiedTime,
	/**
	 * 갱신 시간 From
	 */
	modifiedTimeFrom,
	/**
	 * 갱신 시간 To
	 */
	modifiedTimeTo,	
	/**
	 * 폼 키워드
	 */
	keyword,
	/**
	 * 주관부서
	 */
	ownerDept,
	/**
	 * 담당자
	 */
	owner,
	/**
	 * 인코딩
	 */
	encoding,
	/**
	 * 설명
	 */
	description
	
}
