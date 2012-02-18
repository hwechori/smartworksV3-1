package net.smartworks.server.engine.resource.model;


/**
 * 도메인 필드 매핑 정의
 * 테이블 : SWDomainField
 * 
 * @author jhnam
 * @version $Id: IDBDomainField.java,v 1.1 2011/11/08 00:41:09 kmyu Exp $
 */
public interface IDBDomainField extends IDomainField {

	/**
	 * 칼럼 이름 접두어
	 */
	public static final String COLUMN_NAME_PREFIX = "C";	
	/**
	 * 불리언 테이블 필드 타입 - boolean 
	 */
	public static final String COLUMN_TYPE_BOOLEAN = "boolean";
	/**
	 * 비트 테이블 필드 타입 - bit
	 */
	public static final String COLUMN_TYPE_BIT = "bit";	
	/**
	 * 스트링 테이블 필드 타입 - string
	 */
	public static final String COLUMN_TYPE_STRING = "varchar(255)";
	/**
	 * 숫자형 테이블 필드 타입 - number
	 */
	public static final String COLUMN_TYPE_NUMBER = "float";
	/**
	 * 날짜 시간 테이블 필드 타입 - timestamp
	 */
	public static final String COLUMN_TYPE_TIMESTAMP = "timestamp";
	/**
	 * 날짜 시간 테이블 필드 타입 - datetime
	 */
	public static final String COLUMN_TYPE_DATETIME = "datetime";	
	/**
	 * 날짜 테이블 필드 타입 - date
	 */
	public static final String COLUMN_TYPE_DATE = "date";	
	/**
	 * 시간 테이블 필드 타입 - time
	 */
	public static final String COLUMN_TYPE_TIME = "time";
	/**
	 * 장문 입력 필드 타입 - text
	 */
	public static final String COLUMN_TYPE_TEXT = "text";
	
	/**
	 * 복잡형 테이블 필드 타입 : 데이터가 들어가지 않을 것이므로 의미가 없다. - complex
	 */
	public static final String COLUMN_TYPE_COMPLEX = "char(1)";
	
	/**
	 * 도메인 필드 아이디
	 * 
	 * @return
	 */
	public String getId();
	/**
	 * @param id
	 */
	public void setId(String id);
	
	/**
	 * 도메인 매핑 아이디
	 * 
	 * @return
	 */
	public String getDomainId();
	/**
	 * @param domainId
	 */
	public void setDomainId(String domainId);
	
	/**
	 * 폼 필드 경로 - 다른 단위업무를 참조하는 경우 참조 폼 아이디와 폼 필드가 폼 필드 경로가 된다. 형식은 formId.formFieldId
	 * 
	 * @return
	 */
	public String getFormFieldPath();
	/**
	 * @param formFieldPath
	 */
	public void setFormFieldPath(String formFieldPath);
	
	/**
	 * 폼 필드 아이디
	 * 
	 * @return
	 */
	public String getFormFieldId();
	/**
	 * @param formFieldId
	 */
	public void setFormFieldId(String formFieldId);
	
	/**
	 * 폼 필드 이름
	 * 
	 * @return
	 */
	public String getFormFieldName();
	/**
	 * @param formFieldName
	 */
	public void setFormFieldName(String formFieldName);
	
	/**
	 * 폼 필드 데이터 타입
	 * 
	 * @return
	 */
	public String getFormFieldType();
	/**
	 * @param formFieldType
	 */
	public void setFormFieldType(String formFieldType);
	
	/**
	 * 칼럼 이름
	 * 
	 * @return
	 */
	public String getTableColName();
	/**
	 * @param colName
	 */
	public void setTableColName(String colName);
	
	/**
	 * 배열 여부
	 * 
	 * @return
	 */
	public String getArrayYn();
	/**
	 * @param arrayYn
	 */
	public void setArrayYn(String arrayYn);
	
	/**
	 * 레퍼런스 테이블 이름
	 * 
	 * @return
	 */
	public String getRefTblName();
	/**
	 * @param refTblName
	 */
	public void setRefTblName(String refTblName);
	
	/**
	 * 시스템 필드 여부
	 * 
	 * @return
	 */
	public String getSystemFieldYn();
	/**
	 * @param systemFieldYn
	 */
	public void setSystemFieldYn(String systemFieldYn);
	
	/**
	 * 단위업무 목록에 표시될 순서
	 * 
	 * @return the dispOrder
	 */
	public int getDispOrder();

	/**
	 * @param dispOrder the dispOrder to set
	 */
	public void setDispOrder(int dispOrder);

	/**
	 * 단위업무 목록 테이블의 칼럼 너비
	 * 
	 * @return the tableWidth
	 */
	public float getTableWidth();

	/**
	 * @param tableWidth the tableWidth to set
	 */
	public void setTableWidth(float tableWidth);
	
}
