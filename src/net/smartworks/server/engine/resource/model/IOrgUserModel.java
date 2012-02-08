package net.smartworks.server.engine.resource.model;

/**
 * 사용자 (조직) 모델
 * <li> 매핑 테이블 : SWOrgUser
 * 
 * @author jhnam
 * @version $Id: IOrgUserModel.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IOrgUserModel {

	/**
	 * 타입 일반 - BASIC
	 */
	public static final String TYPE_BASIC = "BASIC";
	
	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the companyId
	 */
	public String getCompanyId();
	
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId);
	
	/**
	 * @return the deptId
	 */
	public String getDeptId();
	
	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId);
	
	/**
	 * @return the roleId
	 */
	public String getRoleId();

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId);
	
	/**
	 * @return the authId
	 */
	public String getAuthId();

	/**
	 * @param authId the authId to set
	 */
	public void setAuthId(String authId);
	
	/**
	 * @return the empNo
	 */
	public String getEmpNo();
	
	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo);	
	
	/**
	 * @return the passwd
	 */
	public String getPasswd();

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd);
	
	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name);
	
	/**
	 * @return the type
	 */
	public String getType();
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type);
	
	/**
	 * @return the position
	 */
	public String getPosition();
	
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position);
	
	/**
	 * @return the email
	 */
	public String getEmail();
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email);
	
	/**
	 * @return the lang
	 */
	public String getLang();
	
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang);
	
	/**
	 * @return the stdTime
	 */
	public String getStdTime();
	
	/**
	 * @param stdTime the stdTime to set
	 */
	public void setStdTime(String stdTime);

	/**
	 * @return the picture
	 */
	public String getPicture();

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture);
	
}
