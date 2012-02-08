package net.smartworks.server.engine.resource.model;

import java.util.Map;

/**
 * 폼 정의
 * 
 * @author jhnam
 * @version $Id: IFormDef.java,v 1.1 2011/11/08 03:15:08 kmyu Exp $
 */
public interface IFormDef {
	/**
	 * 폼 아이디
	 */
	public String getId();
	public void setId(String id);
	
	/**
	 * 버전
	 */
	public int getVersion();
	public void setVersion(int version);
	
	/**
	 * 폼 이름
	 */
	public String getName();
	public void setName(String name);
	
	/**
	 * 폼 타이틀
	 */
	public String getTitle();
	public void setTitle(String title);
	
	/**
	 * 시스템 이름 - 정보관리에서 테이블 이름으로 사용된다.
	 */
	public String getSystemName();
	public void setSystemName(String systemName);
	
	/**
	 * 폼 필드 맵. 키 - 필드 이름, 값 - 폼 필드 정보
	 */
	public Map<String, IFormFieldDef> getFormFieldMap();
	public void addFormField(IFormFieldDef formField);
	
	/**
	 * 폼 매핑 맵, 키 - 폼 매핑 아이디, 값 - 폼 매핑 모델
	 */
	public Map<String, IFormMappingDef> getFormMappingMap();
	public void addFormMapping(IFormMappingDef mappingModel);
	
}
