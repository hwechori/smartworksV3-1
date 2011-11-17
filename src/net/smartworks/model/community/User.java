package net.smartworks.model.community;

public class User extends WorkSpace {

	public static final int USER_LEVEL_EXTERNAL_USER = 0;
	public static final int USER_LEVEL_INTERNAL_USER = 1;
	public static final int USER_LEVEL_AMINISTRATOR = 2;
	public static final int USER_LEVEL_SYSMANAGER = 3;
	public static final int USER_LEVEL_DEFAULT = USER_LEVEL_INTERNAL_USER;
	
	private int	userLevel = USER_LEVEL_DEFAULT;
	private String 	position;
	private String 	locale;
	private String 	timeZone;
	private String 	department;
	private String 	company;
	
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public String getLongName() {
		return position + " " + super.getName();
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public User(){
		super();
	}
	public User(String id, String name){
		super(id, name);
	}
}
