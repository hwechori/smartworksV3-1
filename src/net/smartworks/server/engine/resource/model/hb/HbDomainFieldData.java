package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.resource.model.IDomainFieldData;

/**
 * IDomainDataField 구현
 * 
 * @author jhnam
 * @version $Id: HbDomainFieldData.java,v 1.1 2011/11/08 03:15:03 kmyu Exp $
 */
public class HbDomainFieldData implements IDomainFieldData, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 도메인 데이터 필드(폼 필드) 아이디
	 */
	private String id;
	/**
	 * 도메인 데이터 필드(폼 필드) 이름
	 */
	private String name;
	/**
	 * 도메인 데이터 필드(폼 필드) 타입
	 */
	private String type;
	/**
	 * 도메인 데이터 필드(폼 필드) 값
	 */
	private String data;
	/**
	 * 도메인 데이터 필드가 배열인지 여부 - 배열이라면 저장시 디테일 도메인에 추가할 데이터 셋을 갖는다. 
	 */
	private boolean isArray;
	/**
	 * 참조 폼 레코드 아이디
	 */
	private String refRecordId;
	/**
	 * 참조 폼 아이디
	 */
	private String refForm;
	/**
	 * 참조 폼 필드 아이디
	 */
	private String refFormField;
	/**
	 * 자식 데이터 리스트
	 */
	private List<IDomainFieldData> children;
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#getData()
	 */
	public String getData() {
		return this.data;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#getId()
	 */
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#getName()
	 */
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#getType()
	 */
	public String getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#setData(java.lang.String)
	 */
	public void setData(String data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataField#setType(java.lang.String)
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#isArray()
	 */
	public boolean isArray() {
		return this.isArray;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#setArray(boolean)
	 */
	public void setArray(boolean isArray) {
		this.isArray = isArray;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#getRefForm()
	 */
	public String getRefForm() {
		return this.refForm;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#getRefFormField()
	 */
	public String getRefFormField() {
		return this.refFormField;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#getRefRecordId()
	 */
	public String getRefRecordId() {
		return this.refRecordId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#setRefForm(java.lang.String)
	 */
	public void setRefForm(String refForm) {
		this.refForm = refForm;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#setRefFormField(java.lang.String)
	 */
	public void setRefFormField(String refFormField) {
		this.refFormField = refFormField;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#setRefRecordId(java.lang.String)
	 */
	public void setRefRecordId(String refRecordId) {
		this.refRecordId = refRecordId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#addChild(com.maninsoft.smart.server.model.IDomainFieldData)
	 */
	public void addChild(IDomainFieldData data) {
		
		if(this.children == null) 
			this.children = new ArrayList<IDomainFieldData>();
		
		this.children.add(data);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#getChildren()
	 */
	public List<IDomainFieldData> getChildren() {
		return this.children;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainFieldData#removeChildData(com.maninsoft.smart.server.model.IDomainFieldData)
	 */
	public void removeChild(IDomainFieldData data) {
		this.children.remove(data);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.toString()#toString()
	 */
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		if(!this.isArray)
			buffer.append("<DataField name=\"").append(this.name).append("\" id=\"").append(this.id).append("\" type=\"").append(this.type).append("\" refForm=\"").append(this.refForm != null ? this.refForm : "").append("\" refFormField=\"").append(this.refFormField != null ? this.refFormField : "").append("\" refRecordId=\"").append(this.refRecordId != null ? this.refRecordId : "").append("\">");
		
		if(this.children != null) {
			for(IDomainFieldData fieldData : this.children)
				buffer.append(fieldData);
		} else {
			if(this.data != null)
				buffer.append("<![CDATA[" + this.data + "]]>");
		}
		
		if(!this.isArray)
			buffer.append("</DataField>");
		
		return buffer.toString();
	}
	
}
