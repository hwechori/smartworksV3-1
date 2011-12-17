package net.smartworks.model.community;

import java.io.File;

import net.smartworks.model.BaseObject;
import net.smartworks.util.SmartUtil;

public class Community extends BaseObject {

	public static final String PICTURE_PATH = System.getenv("SMARTWORKS_FILE_HOME") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_HOME");
	public static final String IMAGE_PATH = "images/";
	public static final String PROFILES_DIR = "Profiles";
	private String 	orgPictureName = null;
	private String 	midPictureName = null;
	private String 	minPictureName = null;
	private String  companyId = null;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getOrgPictureName() {
		return orgPictureName;
	}
	public void setOrgPictureName(String orgPictureName) {
		this.orgPictureName = orgPictureName;
	}
	public String getMidPictureName() {
		return midPictureName;
	}
	public void setMidPictureName(String midPictureName) {
		this.midPictureName = midPictureName;
	}
	public String getMinPictureName() {
		return minPictureName;
	}
	public void setMinPictureName(String minPictureName) {
		this.minPictureName = minPictureName;
	}
	public String getOrgPicture(){
		return getOrgPictureName().equals(User.NO_USER_PICTURE + ".jpg") ? IMAGE_PATH + getOrgPictureName() : getPath() + getOrgPictureName();
	}
	public String getMidPicture(){
		return getPath() + getMidPictureName();
	}
	public String getMinPicture(){
		return getPath() + getMinPictureName();
	}
	public String getPath(){
		if(SmartUtil.getCurrentUser() == null)
			return null;
		return PICTURE_PATH + File.separator + SmartUtil.getCurrentUser().getCompanyId() + File.separator + PROFILES_DIR + File.separator;
	}
	public Community(){
		super();
	}
	public Community(String id, String name){
		super(id, name);
	}

}