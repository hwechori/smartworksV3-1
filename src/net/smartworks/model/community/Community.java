package net.smartworks.model.community;

import net.smartworks.model.BaseObject;
import net.smartworks.server.engine.security.model.Login;
import net.smartworks.util.SmartConfUtil;
import net.smartworks.util.SmartUtil;

public class Community extends BaseObject {

	public static final String PICTURE_PATH = SmartConfUtil.getInstance().getImageServer();
	public static final String NO_PICTURE_PATH = "images/";
	public static final String PROFILES_DIR = "Profiles";
	public static final String COMMUNITY_USER = "User";
	public static final String COMMUNITY_DEPARTMENT = "Department";
	public static final String COMMUNITY_GROUP = "Group";
	private String  bigPictureName = null;
	private String  smallPictureName = null;

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
		if(this.getOrgPictureName() == null || this.getOrgPictureName().equals("")) {
			if(this.getClass().equals(Login.class) || this.getClass().equals(User.class))
				return NO_PICTURE_PATH + User.NO_USER_PICTURE + ".jpg";
			else if(this.getClass().equals(Department.class))
				return NO_PICTURE_PATH + Department.DEFAULT_DEPART_PICTURE + ".gif";
			else if(this.getClass().equals(Group.class))
				return NO_PICTURE_PATH + Group.DEFAULT_GROUP_PICTURE + ".gif";
		}
		return getPath() + this.getOrgPictureName();
	}

	public String getMidPicture() {
		if(this.getMidPictureName() == null || this.getMidPictureName().equals("")) {
			if(this.getClass().equals(Login.class) || this.getClass().equals(User.class))
				return NO_PICTURE_PATH + User.NO_USER_PICTURE + "_mid.jpg";
			else if(this.getClass().equals(Department.class))
				return NO_PICTURE_PATH + Department.DEFAULT_DEPART_PICTURE + "_mid.gif";
			else if(this.getClass().equals(Group.class))
				return NO_PICTURE_PATH + Group.DEFAULT_GROUP_PICTURE + "_mid.gif";
		}
		return getPath() + this.getMidPictureName();
	}

	public String getMinPicture() {
		if(this.getMinPictureName() == null || this.getMinPictureName().equals("")) {
			if(this.getClass().equals(Login.class) || this.getClass().equals(User.class))
				return NO_PICTURE_PATH + User.NO_USER_PICTURE + "_min.jpg";
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
		return PICTURE_PATH + SmartUtil.getCurrentUser().getCompanyId() + "/" + PROFILES_DIR + "/";
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