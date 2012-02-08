package net.smartworks.server.engine.resource.model.enums;

/**
 * 워크타입 필드 항목
 * 
 * @author jhnam
 * @version $Id: WorkTypeFieldEnum.java,v 1.1 2011/11/08 03:15:06 kmyu Exp $
 */
public enum WorkTypeFieldEnum {

	/**
	 * 유니크 아이디
	 */
	id,
	/**
	 * 워크 타입 이름
	 */
	name,
	/**
	 * 폼 유니크 아이디
	 */
	formUid,
	/**
	 * 업무 수행 스텝 카운트
	 */
	stepCount,
	/**
	 * 타입 - GENERAL, SINGLE
	 */
	type,
	/**
	 * 기한
	 */
	duration
}
