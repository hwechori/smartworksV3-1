package net.smartworks.model.community;

public class User extends WorkSpace {

	private String 	position;
	private String 	locale;
	private String 	timeZone;
	private String 	department;
	private String 	company;
	
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
