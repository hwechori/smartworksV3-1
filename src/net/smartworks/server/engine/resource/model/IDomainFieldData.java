package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 도메인 데이터 필드 인터페이스를 정의한다. 도메인 데이터 필드에 대한 메타 정보와 값을 정의한다.
 * 
 * @author jhnam
 * @version $Id: IDomainFieldData.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IDomainFieldData {

	/**
	 * 폼 필드 아이디, 폼에서 데이터 매칭하는데 사용된다.
	 * 도메인 메타 데이터 관리자에서 각 테이블 필드마다 아이디를 관리한다.
	 * 
	 * @return
	 */
	public String getId();
	
	/**
	 * 폼 필드 아이디
	 * 
	 * @param id
	 */
	public void setId(String id);
	
	/**
	 * 폼 필드 이름
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * 폼 필드 이름
	 * 
	 * @param Name
	 */
	public void setName(String name);
	
	/**
	 * 폼 필드 값
	 * 
	 * @return
	 */
	public String getData();
	
	/**
	 * 폼 필드 값
	 * 
	 * @param data
	 */
	public void setData(String data);
	
	/**
	 * 폼 필드 타입
	 * 
	 * @return
	 */
	public String getType();
	
	/**
	 * 폼 필드 타입
	 * 
	 * @param type
	 */
	public void setType(String type);
	
	/**
	 * 배열인지 여부
	 * 
	 * @return
	 */
	public boolean isArray();
	
	/**
	 * 배열인지 여부
	 * 
	 * @param isArray
	 */
	public void setArray(boolean isArray);
	
	/**
	 * 참조 폼 레코드 아이디
	 * 
	 * @return
	 */
	public String getRefRecordId();
	
	/**
	 * 참조 폼 레코드 아이디
	 * 
	 * @param refRecordId
	 */
	public void setRefRecordId(String refRecordId);
	
	/**
	 * 참조 폼 아이디
	 * 
	 * @return
	 */
	public String getRefForm();
	
	/**
	 * 참조 폼 아이디
	 * 
	 * @param refForm
	 */
	public void setRefForm(String refForm);
	
	/**
	 * 참조 폼 필드 아이디
	 * 
	 * @return
	 */
	public String getRefFormField();
	/**
	 * 참조 폼 필드 아이디
	 * 
	 * @param refFormField
	 */
	public void setRefFormField(String refFormField);
	
	/**
	 * 자식 데이터 리스트
	 * 
	 * @return
	 */
	public List<IDomainFieldData> getChildren();
	
	/**
	 * 자식 데이터 추가
	 * 
	 * @param data
	 */
	public void addChild(IDomainFieldData data);
	
	/**
	 * 필드 데이터를 삭제한다.
	 * 
	 * @param data
	 */
	public void removeChild(IDomainFieldData data);
	
	/**
	 * 데이터 필드 아이디로 데이터를 찾는다.
	 * 
	 * @param fieldId
	 * @return
	 */
	//public IDomainFieldData getChild(String fieldId);
	
}
