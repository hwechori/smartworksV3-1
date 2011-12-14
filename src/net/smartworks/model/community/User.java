package net.smartworks.model.community;

public class User extends WorkSpace {

	public static final int USER_LEVEL_EXTERNAL_USER = 0;
	public static final int USER_LEVEL_INTERNAL_USER = 1;
	public static final int USER_LEVEL_AMINISTRATOR = 2;
	public static final int USER_LEVEL_SYSMANAGER = 3;
	public static final int USER_LEVEL_DEFAULT = USER_LEVEL_INTERNAL_USER;
	
	private static final String NO_USER_PRICTURE_NAME = "pic_no_userpicture";
	
	private int	userLevel = USER_LEVEL_DEFAULT;
	private String position;
	private String locale;
	private String timeZone;
	private String deptId;
	private String department;
	private String employeeId;
	private String password;
	private String phoneNo;
	private String cellPhoneNo;
	private String company;
	private String companyId;

	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCellPhoneNo() {
		return cellPhoneNo;
	}
	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
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

	public static String getOrgNoPicture(){
		return Community.PICTURE_PATH + NO_USER_PRICTURE_NAME + ".jpg";
	}
	public static String getMidNoPicture(){
		return Community.PICTURE_PATH + NO_USER_PRICTURE_NAME + "_mid.jpg";
	}
	public static String getMinNoPicture(){
		return Community.PICTURE_PATH + NO_USER_PRICTURE_NAME + "_min.jpg";		
	}
}
