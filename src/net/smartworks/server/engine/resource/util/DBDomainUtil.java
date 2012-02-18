package net.smartworks.server.engine.resource.util;

import net.smartworks.server.engine.resource.util.id.IDCreator;

/**
 * 도메인 유틸리티
 *  
 * @author jhnam
 * @version $Id: DBDomainUtil.java,v 1.1 2011/11/08 00:41:10 kmyu Exp $
 */
public class DBDomainUtil {

	/**
	 * 다음 도메인 테이블 이름을 생성하여 리턴한다.
	 * 
	 * @return
	 */
	public static String getNextDomainTableName() {		
		// 테이블 이름을 UUID로 생성
		return IDCreator.createId("dt_");		
	}
		
	/**
	 * 폼 필드 아이디로 칼럼 이름을 생성한다.
	 * 
	 * @param formFieldId
	 * @return
	 */
	public static String createColumnNameByFormField(String formFieldId) {
		return "c" + formFieldId;
	}
		
}
