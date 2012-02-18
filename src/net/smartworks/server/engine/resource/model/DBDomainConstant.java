package net.smartworks.server.engine.resource.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 상수 정의
 * 
 * @author jhnam
 * @version $Id: DBDomainConstant.java,v 1.1 2011/11/08 00:41:10 kmyu Exp $
 */
public class DBDomainConstant {

	/**
	 * 시스템 도메인과 매핑 테이블 맵
	 */
	private static Map<String, String> systemFormTableInfo = new HashMap<String, String>();
	
	static {
		systemFormTableInfo.put("frm_company_SYSTEM", 	"SWOrgCompany");
		systemFormTableInfo.put("frm_role_SYSTEM", 		"SWOrgRole");
		systemFormTableInfo.put("frm_dept_SYSTEM", 		"SWOrgDept");
		systemFormTableInfo.put("frm_user_SYSTEM", 		"SWOrgUser");
		systemFormTableInfo.put("frm_contact_SYSTEM", 	"SWOrgContact");
		systemFormTableInfo.put("frm_schedule_SYSTEM", 	"SWSchedule");
		systemFormTableInfo.put("frm_board_SYSTEM", 	"SWBoard");
		systemFormTableInfo.put("frm_document_SYSTEM", 	"SWDocument");
	};
	
	// 기본 테이블 필드 - id, domainId, workItemId, masterRecordId
	/**
	 * 생성된 도메인 테이블의 아이디 컬럼 이름
	 */
	public static final String COLUMNNAME_RECORDID = "id";
	/**
	 * 생성된 도메인 테이블의 아이디 컬럼 이름
	 */
	public static final String COLUMNNAME_WORKITEMID = "workItemId";
	/**
	 * 생성된 도메인 테이블의 아이디 컬럼 이름
	 */
	public static final String COLUMNNAME_DOMAINID = "domainId";
	/**
	 * 생성된 도메인 테이블의 마스터 레코드 아이디 컬럼 이름
	 */
	public static final String COLUMNNAME_MASTERRECORDID = "masterRecordId";
	/**
	 * 생성된 도메인 테이블의 생성시간 컬럼 이름
	 */
	public static final String COLUMNNAME_CREATEDTIME = "createdTime";
	/**
	 * 생성된 도메인 테이블의 생성자 컬럼 이름
	 */
	public static final String COLUMNNAME_CREATOR = "creator";
	/**
	 * 생성된 도메인 테이블의 변경시간 컬럼 이름
	 */
	public static final String COLUMNNAME_MODIFIEDTIME = "modifiedTime";
	/**
	 * 생성된 도메인 테이블의 변경 컬럼 이름
	 */
	public static final String COLUMNNAME_MODIFIER = "modifier";
	
	public static final String COLUMNNAME_WORKSPACEID = "workSpaceId";
	
	public static final String COLUMNNAME_WORKSPACETYPE = "workSpaceType";
	
	public static final String COLUMNNAME_ACCESSLEVEL = "accessLevel";//1
	
	public static final String COLUMNNAME_ACCESSVALUE = "accessValue";//4000
	
	/**
	 * 도메인 정의의 테이블 이름
	 */
	public static final String TABLE_NAME_FIELD_NAME_IN_DOMAIN_DEF = "tblName";
	/**
	 * 도메인 정의의 컬럼 이름
	 */
	public static final String COLUMN_NAME_FIELD_NAME_IN_DOMAIN_DEF = "tableColName";
	/**
	 * 도메인 정의의 도메인 아이디
	 */
	public static final String DOMAIN_ID_FIELD_NAME_IN_DOMAIN_DEF = "domainId";
	
	/**
	 * 기본 필드 RecordId의 아이디
	 */
	public static final String FIELDID_RECORDID = "__RECORD_ID";
	/**
	 * 기본 필드 WorkItemId의 아이디
	 */
	public static final String FIELDID_WORKITEMID = "__WORK_ITEM_ID";
	/**
	 * 기본 필드 DOMAIN의 아이디
	 */
	public static final String FIELDID_DOMAINID = "__DOMAIN_ID";
	/**
	 * 기본 필드 masterRecordId의 아이디
	 */
	public static final String FIELDID_MASTERRECORDID = "__MASTER_RECORD_ID";
	/**
	 * 기본 필드 createdTime 아이디
	 */
	public static final String FIELDID_CREATEDTIME = "__CREATED_TIME";
	
	/**
	 * 기본 필드 RecordId의 이름
	 */
	public static final String FIELDNAME_RECORDID = "__RECORD_ID";
	/**
	 * 기본 필드 WorkItemId의 이름
	 */
	public static final String FIELDNAME_WORKITEMID = "__WORK_ITEM_ID";
	/**
	 * 기본 필드 DOMAIN의 이름
	 */
	public static final String FIELDNAME_DOMAINID = "__DOMAIN_ID";
	/**
	 * 기본 필드 masterRecordId의 이름
	 */
	public static final String FIELDNAME_MASTERRECORDID = "__MASTER_RECORD_ID";
	/**
	 * 기본 필드 createdTime 이름
	 */
	public static final String FIELDNAME_CREATEDTIME = "__CREATED_TIME";
	
	/**
	 * 기본 필드 RecordId의 타입
	 */
	public static final String FIELDTYPE_RECORDID = "__RECORD_ID";
	/**
	 * 기본 필드 WorkItemId의 타입
	 */
	public static final String FIELDTYPE_WORKITEMID = "__WORK_ITEM_ID";
	/**
	 * 기본 필드 DOMAIN의 타입
	 */
	public static final String FIELDTYPE_DOMAINID = "__DOMAIN_ID";
	/**
	 * 기본 필드 masterRecordId의 타입
	 */
	public static final String FIELDTYPE_MASTERRECORDID = "__MASTER_RECORD_ID";
	/**
	 * 기본 필드 createdTime 타입
	 */
	public static final String FIELDTYPE_CREATEDTIME = "__CREATED_TIME";
	
	/**
	 * 테이블 칼럼의 기본 사이즈
	 */
	public static final int COLUMNSIZE_DEFAULT = 255;
	/**
	 * 아이디 칼럼의 기본 사이즈
	 */
	public static final int COLUMNSIZE_ID = 50;	
	
	public static final int COLUMNSIZE_1 = 1;
	
	public static final int COLUMNSIZE_4000 = 4000;
	
	public static final int COLUMNSIZE_100 = 100;	
	/**
	 * 테이블 칼럼의 기본 컬럼 데이터 타입
	 */
	public static final String COLUMNDATATYPE_DEFAULT = new StringBuffer("VARCHAR(").append(String.valueOf(COLUMNSIZE_DEFAULT)).append(")").toString();
	
	public static final String COLUMNDATATYPE_1 = new StringBuffer("VARCHAR(").append(String.valueOf(COLUMNSIZE_1)).append(")").toString();
	
	public static final String COLUMNDATATYPE_100 = new StringBuffer("VARCHAR(").append(String.valueOf(COLUMNSIZE_100)).append(")").toString();
	
	public static final String COLUMNDATATYPE_4000 = new StringBuffer("VARCHAR(").append(String.valueOf(COLUMNSIZE_4000)).append(")").toString();
	/**
	 * 테이블 아이디 칼럼 타입
	 */
	public static final String COLUMNDATATYPE_ID = new StringBuffer("VARCHAR(").append(String.valueOf(COLUMNSIZE_ID)).append(")").toString();
	/**
	 * 테이블 아이디 칼럼 날짜 시간 타입
	 */
	public static final String COLUMNDATATYPE_TIMESTAMP = "TIMESTAMP";
	/**
	 * 테이블 아이디 칼럼 날짜 시간 타입2
	 */
	public static final String COLUMNDATATYPE_DATETIME = "DATETIME";	
	/**
	 * 폼 버전 데이터 타입
	 */
	public static final String COLUMNDATATYPE_FORMVERSION = "INT";	
	/**
	 * 기본 인덱스 접두어
	 */
	public static final String PREFIX_DEFAULTINDEXNAME = "IDX";
	/**
	 * 마스터 도메인 아이디 접두어
	 */
	public static final String PREFIX_MASTERDOMAINID = "md";
	/**
	 * 디테일 도메인 아이디 접두어
	 */
	public static final String PREFIX_DETAILDOMAINID = "dd";
	/**
	 * 도메인 필드 아이디 접두어
	 */
	public static final String PREFIX_DOMAINFIELDID = "df";	
	/**
	 * 테이블 이름 접두어
	 */
	public static final String PREFIX_TABLENAME = "dt";
	/**
	 * 도메인 레코드 접두어
	 */
	public static final String PREFIX_DOMAINRECORDNAME = "dr";	
	/**
	 * 시스템 도메인 접미사
	 */
	public static final String SUFFIX_SYSTEMDOMAIN = "SYSTEM";
	
	/**
	 * 시스템 폼과 테이블 매핑 정보를 리턴
	 * 
	 * @return
	 */
	public static Map<String, String> getSystemFormTableMap() {
		return systemFormTableInfo;
	}
	
}
