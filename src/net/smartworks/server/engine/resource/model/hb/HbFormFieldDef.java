package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.resource.model.IFormFieldDef;

/**
 * IFormFieldDef 구현
 * 
 * @author jhnam
 * @version $Id: HbFormFieldDef.java,v 1.1 2011/11/08 03:15:02 kmyu Exp $
 */
public class HbFormFieldDef implements IFormFieldDef, Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String formId;
	private String id;
	private String name;
	private String title;
	/**
	 * 시스템 이름
	 */
	private String systemName;
	/**
	 * 데이터형식
	 */
	private String type;
	/**
	 * 포맷형식
	 */
	private String formatType;
	/**
	 * 표시형식
	 */
	private String viewingType;
	/**
	 * 참조 폼 아이디
	 */
	private String refForm;
	/**
	 * 참조 폼 필드 아이디
	 */
	private String refFormField;
	private boolean isArray;
	/**
	 * 시스템 필드 여부
	 */
	private boolean isSystem;
	/**
	 * 자식 폼 필드 리스트
	 */
	private List<IFormFieldDef> children;

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormId() {
		return this.formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSystemName() {
		return this.systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isArray() {
		return this.isArray;
	}
	public void setArray(boolean isArray) {
		this.isArray = isArray;
	}
	public boolean isSystem() {
		return this.isSystem;
	}
	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	public String getFormatType() {
		return formatType;
	}
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
	public String getRefForm() {
		return this.refForm;
	}
	public void setRefForm(String refForm) {
		this.refForm = refForm;
	}
	public String getRefFormField() {
		return this.refFormField;
	}
	public void setRefFormField(String refFormFieldId) {
		this.refFormField = refFormFieldId;
	}
	public void addChildField(IFormFieldDef fieldDef) {
		if(this.children == null)
			this.children = new ArrayList<IFormFieldDef>();
		this.children.add(fieldDef);
	}
	public List<IFormFieldDef> getChildren() {
		return this.children;
	}
	public String getViewingType() {
		return viewingType;
	}
	public void setViewingType(String viewingType) {
		this.viewingType = viewingType;
	}
}
