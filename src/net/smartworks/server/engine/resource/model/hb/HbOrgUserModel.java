package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IOrgUserModel;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * IOrgUserModel 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbOrgUserModel.java,v 1.1 2011/11/08 03:15:01 kmyu Exp $
 */
public class HbOrgUserModel implements IOrgUserModel, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 사용자 아이디
	 */
	private String id;
	/**
	 * 회사 아이디
	 */
	private String companyId;
	/**
	 * 부서 아이디
	 */
	private String deptId;
	/**
	 * 역할 아이디
	 */
	private String roleId;
	/**
	 * 권한 아이디
	 */
	private String authId;
	/**
	 * 직원번호
	 */
	private String empNo;
	/**
	 * 암호
	 */
	private String passwd;
	/**
	 * 사용자 이름
	 */
	private String name;
	/**
	 * 타입 - 정의 필요
	 */
	private String type;
	/**
	 * 직책
	 */
	private String position;
	/**
	 * 이메일
	 */
	private String email;	
	/**
	 * 언어
	 */
	private String lang;
	/**
	 * 표준시간대
	 */
	private String stdTime;
	/**
	 * 사용자 사진 이름
	 */
	private String picture;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}
	
	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * @return the authId
	 */
	public String getAuthId() {
		return authId;
	}

	/**
	 * @param authId the authId to set
	 */
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IOrgUserModel#getLang()
	 */
	public String getLang() {
		return this.lang;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IOrgUserModel#getStdTime()
	 */
	public String getStdTime() {
		return this.stdTime;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IOrgUserModel#setLang(java.lang.String)
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IOrgUserModel#setStdTime(int)
	 */
	public void setStdTime(String stdTime) {
		this.stdTime = stdTime;
	}
	
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbOrgUserModel))
			return false;
		
		HbOrgUserModel model = (HbOrgUserModel)obj;
		
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
			return XmlUtil.beanToXmlString("User", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
	
}
