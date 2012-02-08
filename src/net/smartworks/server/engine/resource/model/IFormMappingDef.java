package net.smartworks.server.engine.resource.model;

import java.util.Set;

/**
 * 폼 매핑 모델
 * <li> 매핑 테이블 : SWFormMapping
 * 
 * @author jhnam
 * @version $Id: IFormMappingDef.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IFormMappingDef {

	/**
	 * 매핑 타입 - 프로세스 - process
	 */
	public static final String MAPPING_TYPE_PROCESS = "process";
	/**
	 * 매핑 타입 - 단위 업무 - work
	 */
	public static final String MAPPING_TYPE_WORK = "work";
	/**
	 * 매핑 타입 - 단위 업무 - single
	 */
	public static final String MAPPING_TYPE_SINGLE = "single";
	
	public String getId();
	public void setId(String id);
	
	public String getFormId();
	public void setFormId(String formId);
	
	public int getFormVersion();
	public void setFormVersion(int formVersion);
	
	public String getRefFormId();
	public void setRefFormId(String refFormId);
	
	public int getRefFormVersion();
	public void setRefFormVersion(int refFormVersion);
	
	public String getType();
	public void setType(String type);
	
	public Set<IFieldMappingDef> getFieldMappingSet();
	public void setFieldMappingSet(Set<IFieldMappingDef> fieldMappingSet);
	
	public void addFieldMapping(IFieldMappingDef fieldMapping);
	public void removeFieldMapping(IFieldMappingDef fieldMapping);
	
	public Set<IMappingFilterDef> getMappingFilterSet();
	public void setMappingFilterSet(Set<IMappingFilterDef> mappingFilterSet);
	
	public void addMappingFilter(IMappingFilterDef mappingFilter);
	public void removeMappingFilter(IMappingFilterDef mappingFilter);
}
