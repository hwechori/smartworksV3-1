package net.smartworks.model.community;

import net.smartworks.model.BaseObject;
import net.smartworks.model.work.SmartWork;
import net.smartworks.server.engine.security.model.Login;
import net.smartworks.service.ISmartWorks;
import net.smartworks.util.SmartConfUtil;
import net.smartworks.util.SmartUtil;

public class Community extends BaseObject {

	public static final String PICTURE_PATH = SmartConfUtil.getInstance().getImageServer();
	public static final String NO_PICTURE_PATH = "images/";
	public static final String PROFILES_DIR = "Profiles";
	public static final String COMMUNITY_USER = "User";
	public static final String COMMUNITY_DEPARTMENT = "Department";
	public static final String COMMUNITY_GROUP = "Group";
	
	public static final String CONTROLLER_USER_LIST = "user_list.sw";
	public static final String CONTROLLER_DEPARTMENT_LIST = "department_list.sw";
	public static final String CONTROLLER_GROUP_LIST = "group_list.sw";

	public static final String ICON_CLASS_DEPARTMENT = "icon_division_s";
	public static final String ICON_CLASS_GROUP = "icon_group_s";

	public static final String CONTROLLER_USER_SPACE = "user_space.sw";
	public static final String CONTROLLER_DEPARTMENT_SPACE = "department_space.sw";
	public static final String CONTROLLER_GROUP_SPACE = "group_space.sw";

	private String bigPictureName;
	private String smallPictureName;

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
	public String getIconClass(){
		if(this.getClass().equals(Department.class))
			return Community.ICON_CLASS_DEPARTMENT;
		else if(this.getClass().equals(Group.class))
			return Community.ICON_CLASS_GROUP;
		return "";
	}
	public String getListController(){
		if(this.getClass().equals(User.class))
			return Community.CONTROLLER_USER_LIST;
		else if(this.getClass().equals(Department.class))
			return Community.CONTROLLER_DEPARTMENT_LIST;
		else if(this.getClass().equals(Group.class))
			return Community.CONTROLLER_GROUP_LIST;
		return "";
	}
	public String getSpaceController(){
		if(this.getClass().equals(User.class))
			return Community.CONTROLLER_USER_SPACE;
		else if(this.getClass().equals(Department.class))
			return Community.CONTROLLER_DEPARTMENT_SPACE;
		else if(this.getClass().equals(Group.class))
			return Community.CONTROLLER_GROUP_SPACE;
		return "";
	}
	public String getListContextId(){
		if(this.getClass().equals(User.class))
			return ISmartWorks.CONTEXT_PREFIX_USER_LIST + SmartWork.ID_USER_MANAGEMENT;
		else if(this.getClass().equals(Department.class))
			return ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_LIST + SmartWork.ID_DEPARTMENT_MANAGEMENT;
		else if(this.getClass().equals(Group.class))
			return ISmartWorks.CONTEXT_PREFIX_GROUP_LIST + SmartWork.ID_GROUP_MANAGEMENT;
		return "";
	}
	public String getSpaceContextId(){
		if(this.getClass().equals(User.class))
			return ISmartWorks.CONTEXT_PREFIX_USER_SPACE + getId();
		else if(this.getClass().equals(Department.class))
			return ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + getId();
		else if(this.getClass().equals(Group.class))
			return ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + getId();
		return "";
	}
	public Community(){
		super();
	}
	public Community(String id, String name){
		super(id, name);
	}

}