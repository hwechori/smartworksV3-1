package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.smartworks.server.engine.resource.manager.SmartServerManager;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * IPackageModel 하이버네이트 타입 구현
 * 
 * @author jhnam
 * @version $Id: HbPackageModel.java,v 1.1 2011/11/08 03:15:01 kmyu Exp $
 */
public class HbPackageModel implements IPackageModel, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 패키지 유니크 아이디
	 */
	private String id;
	/**
	 * 패키지 아이디
	 */
	private String packageId;
	/**
	 * 패키지 버전
	 */
	private int version;
	/**
	 * 패키지 상태
	 */
	private String status;
	/**
	 * 최종 배치 여부 = Y/N
	 */
	private String latestDeployedYn;
	/**
	 * 패키지가 소속된 카테고리 아이디
	 */
	private String categoryId;
	/**
	 * 패키지 이름
	 */
	private String name;
	/**
	 * 패키지 종류
	 */
	private String type;
	/**
	 * 생성된 시간
	 */
	private Date createdTime;
	/**
	 * 생성자
	 */
	private String creator;
	/**
	 * 생성자 이름
	 */
	private String creatorName;
	/**
	 * 변경된 시간
	 */
	private Date modifiedTime;
	/**
	 * 변경자
	 */
	private String modifier;
	/**
	 * 변경자 이름
	 */
	private String modifierName;
	/**
	 * 설명
	 */
	private String description;
	/**
	 * 객체의 스트링
	 */
	private String content;
	/**
	 * 
	 */
	private List<String> formContentList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getLatestDeployedYn() {
		return latestDeployedYn;
	}
	public void setLatestDeployedYn(String latestDeployedYn) {
		this.latestDeployedYn = latestDeployedYn;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
		
		creatorName = null;
		if(this.creator != null)
			this.creatorName = SmartServerManager.getInstance().getOrganManager().getUserDispName(this.creator);
	}
	public String getCreatorName() {		
		return this.creatorName;
	}
	
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
		
		modifierName = null;
		if(this.modifier != null)
			this.modifierName = SmartServerManager.getInstance().getOrganManager().getUserDispName(this.modifier);
	}
	public String getModifierName() {
		return modifierName;
	}
	
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbPackageModel))
			return false;
		
		HbPackageModel model = (HbPackageModel)obj;
		
		if(this.id == null || model.getId() == null)
			return false;
		
		if(this.id.equals(model.getId()))
			return true;
		else
			return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("Package", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getFormContentList() {
		return formContentList;
	}
	public void setFormContentList(List<String> formContentList) {
		this.formContentList = formContentList;
	}

}
