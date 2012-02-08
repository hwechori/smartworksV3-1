package net.smartworks.server.engine.resource.model;

/**
 * 폼 필드 매핑 모델
 * <li> 매핑 테이블 : SWFieldMapping
 * 
 * @author jhnam
 * @version $Id: IFieldMappingDef.java,v 1.1 2011/11/08 03:15:10 kmyu Exp $
 */
public interface IFieldMappingDef {

	/**
	 * 매핑 액션 - 임포트 - import
	 */
	public static final String MAPPING_ACTION_IMPORT = "import";
	/**
	 * 매핑 액션 - 익스포트 - export
	 */
	public static final String MAPPING_ACTION_EXPORT = "export";
	
	/**
	 * @return the mappingId
	 */
	public String getMappingId();
	
	/**
	 * @param mappingId the mappingId to set
	 */
	public void setMappingId(String mappingId);
		
	/**
	 * @return the action
	 */
	public String getAction();
	
	/**
	 * @param action the action to set
	 */
	public void setAction(String action);
	
	/**
	 * @return the fromFieldId
	 */
	public String getFromFieldId();
	
	/**
	 * @param fromFieldId the fromFieldId to set
	 */
	public void setFromFieldId(String fromFieldId);
	
	/**
	 * @return the toFieldId
	 */
	public String getToFieldId();
	
	/**
	 * @param toFieldId the toFieldId to set
	 */
	public void setToFieldId(String toFieldId);
	
}
