package net.smartworks.model.community;

import java.io.File;

import net.smartworks.model.BaseObject;
import net.smartworks.util.SmartUtil;

public class Community extends BaseObject {

	public static final String PICTURE_PATH = System.getenv("SMARTWORKS_FILE_HOME") == null ? System.getProperty("user.home") : System.getenv("SMARTWORKS_FILE_HOME");
	public static final String NO_PICTURE_PATH = "images/";
	public static final String PROFILES_DIR = "Profiles";
	private String  bigPictureName = null;
	private String  smallPictureName = null;
	private String  companyId = null;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getOrgPictureName() {
		return this.bigPictureName;
	}
	public String getMidPictureName() {
		return this.smallPictureName;
	}
	public String getMinPictureName() {
		return this.smallPictureName;
	}

	public String getOrgPicture() {
		if(this.getOrgPictureName() == null) {
			if(this.getClass().equals(User.class))
				return NO_PICTURE_PATH + User.NO_USER_PICTURE + ".gif";
			else if(this.getClass().equals(Department.class))
				return NO_PICTURE_PATH + Department.DEFAULT_DEPART_PICTURE + ".gif";
			else if(this.getClass().equals(Group.class))
				return NO_PICTURE_PATH + Group.DEFAULT_GROUP_PICTURE + ".gif";
		}
		return getPath() + this.getOrgPictureName();
	}

	public String getMidPicture() {
		if(this.getMidPictureName() == null) {
			if(this.getClass().equals(User.class))
				return NO_PICTURE_PATH + User.NO_USER_PICTURE + "_mid.gif";
			else if(this.getClass().equals(Department.class))
				return NO_PICTURE_PATH + Department.DEFAULT_DEPART_PICTURE + "_mid.gif";
			else if(this.getClass().equals(Group.class))
				return NO_PICTURE_PATH + Group.DEFAULT_GROUP_PICTURE + "_mid.gif";
		}
		return getPath() + this.getMidPictureName();
	}

	public String getMinPicture() {
		if(this.getMinPictureName() == null) {
			if(this.getClass().equals(User.class))
				return NO_PICTURE_PATH + User.NO_USER_PICTURE + "_min.gif";
			else if(this.getClass().equals(Department.class))
				return NO_PICTURE_PATH + Department.DEFAULT_DEPART_PICTURE + "_min.gif";
			else if(this.getClass().equals(Group.class))
				return NO_PICTURE_PATH + Group.DEFAULT_GROUP_PICTURE + "_min.gif";
		}
		return getPath() + this.getMinPictureName();
	}

	public String getPath(){
		if(SmartUtil.getCurrentUser() == null)
			return null;
		return PICTURE_PATH + File.separator + SmartUtil.getCurrentUser().getCompanyId() + File.separator + PROFILES_DIR + File.separator;
	}
	public void setBigPictureName(String bigPictureName) {
		this.bigPictureName = bigPictureName;
	}
	public void setSmallPictureName(String smallPictureName) {
		this.smallPictureName = smallPictureName;
	}
	public Community(){
		super();
	}
	public Community(String id, String name){
		super(id, name);
	}

}