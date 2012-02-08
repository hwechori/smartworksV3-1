package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 폼 필드 정의
 * 폼 필드는 SimpleType, ComplexType으로 나뉜다.
 * SimpleType은 기본 타입과 배열 타입으로 나뉜다.
 * ComplexType은 기본 복합 타입과 배열 복합 타입으로 나뉜다.
 * 기본적으로 배열 타입은 도메인 테이블 관리시에 별도의 디테일 테이블로 관리되어야 한다.
 * 
 * @author jhnam
 * @version $Id: IFormFieldDef.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IFormFieldDef {
	/**
	 *
	<formEntity id="8" name="부서" title="부서" systemName="" systemType="string" system="true" array="false" required="false">
      <graphic hidden="false" readOnly="false" cellSize="1" contentsSize="-1" height="-1" bgColor="16777215">
        <label visible="true" size="-1" loc="left">
          <textStyle size="14" color="NaN" align="left" bold="false" italic="false" underline="false">
            <font>Arial</font>
          </textStyle>
        </label>
        <textStyle size="12" color="NaN" align="left" bold="false" italic="false" underline="false">
          <font>Arial</font>
        </textStyle>
      </graphic>
      <expression/>
      <children/>
      <format type="refFormField">
        <numeric minUse="" minNum="0" maxUse="" maxNum="10" stepSize="1" maxNumUse="false" minNumUse="false"/>
        <date yearUse="false" sunNotUse="false" monNotUse="false" tueNotUse="false" wedNotUse="false" thuNotUse="false" friNotUse="false" satNotUse="false"/>
        <list type="" refCodeCategoryId="null" refCodeCategoryName="null" listType="static">
          <staticItems/>
        </list>
        <refForm id="frm_6e4267681335413c96df8758ddf0a830" ver="1">
          <name>부서관리</name>
          <field id="10">부서이름</field>
        </refForm>
      </format>
    </formEntity>
	 */
	
	public static final String TYPE_BOOLEAN = "boolean";
	public static final String TYPE_STRING = "string";
	public static final String TYPE_NUMBER = "number";
	public static final String TYPE_DATE = "date";
	public static final String TYPE_DATETIME = "datetime";
	public static final String TYPE_TIME = "time";
	public static final String TYPE_TEXT = "text";
	public static final String TYPE_COMPLEX = "complex";
	
	/**
	 * 폼 아이디
	 */
	public String getFormId();
	public void setFormId(String formId);
	
	/**
	 * 폼 필드 아이디
	 */
	public String getId();
	public void setId(String id);
	
	/**
	 * 폼 필드 이름 
	 */
	public String getName();
	public void setName(String name);
	
	/**
	 * 폼 필드 제목
	 */
	public String getTitle();
	public void setTitle(String title);
	
	/**
	 * 시스템 이름
	 */
	public String getSystemName();
	public void setSystemName(String systemName);
	
	/**
	 * 데이터형식
	 */
	public String getType();
	public void setType(String type);
	
	/**
	 * 포맷 타입
	 */
	public String getFormatType();
	public void setFormatType(String formatType);
	
	/**
	 * 표시형식
	 */
	public String getViewingType();
	public void setViewingType(String viewingType);
	
	/**
	 * 배열인지 여부
	 */
	public boolean isArray();
	public void setArray(boolean isArray);
	
	/**
	 * 시스템 필드 여부
	 */
	public boolean isSystem();
	public void setSystem(boolean isSystem);
	
	/**
	 * 참조 폼 아이디
	 */
	public String getRefForm();
	public void setRefForm(String formId);
	
	/**
	 * 참조 폼 필드 아이디
	 */
	public String getRefFormField();
	public void setRefFormField(String refFormFieldId);
	
	/**
	 * 자식 필드를 리턴한다. - 자식 필드가 존재하면 복합 타입이고, isArray가 true이면 복합 타입의 배열이다.
	 */
	public List<IFormFieldDef> getChildren();
	public void addChildField(IFormFieldDef fieldDef);
	
}
