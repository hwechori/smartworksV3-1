package net.smartworks.model.company;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.server.engine.security.model.Login;
import net.smartworks.util.SmartConfUtil;
import net.smartworks.util.SmartUtil;

public class CompanyGeneral extends BaseObject {

	public static final String PICTURE_PATH = SmartConfUtil.getInstance().getImageServer();
	public static final String NO_LOGO_PATH = "images/";
	public static final String DEFAULT_COMPANY_LOGO = "default_company_logo.jpg";
	public static final String PROFILES_DIR = "Profiles";

	private String logoName;
	private String sendMailHost;
	private String sendMailAccount;
	private String sendMailPassword;
	private boolean sendMailNotification;
	private boolean testAfterSaving;
	
	public String getLogoName() {
		return logoName;
	}
	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}
	public String getSendMailHost() {
		return sendMailHost;
	}
	public void setSendMailHost(String sendMailHost) {
		this.sendMailHost = sendMailHost;
	}
	public String getSendMailAccount() {
		return sendMailAccount;
	}
	public void setSendMailAccount(String sendMailAccount) {
		this.sendMailAccount = sendMailAccount;
	}
	public String getSendMailPassword() {
		return sendMailPassword;
	}
	public void setSendMailPassword(String sendMailPassword) {
		this.sendMailPassword = sendMailPassword;
	}
	public boolean isSendMailNotification() {
		return sendMailNotification;
	}
	public void setSendMailNotification(boolean sendMailNotification) {
		this.sendMailNotification = sendMailNotification;
	}
	public boolean isTestAfterSaving() {
		return testAfterSaving;
	}
	public void setTestAfterSaving(boolean testAfterSaving) {
		this.testAfterSaving = testAfterSaving;
	}

	public String getCompanyLogo() {
		if(this.getLogoName() == null || this.getLogoName().equals("")) {
			return NO_LOGO_PATH + DEFAULT_COMPANY_LOGO;
		}
		return getPath() + this.getLogoName();
	}

	public String getPath(){
		return PICTURE_PATH + SmartUtil.getCurrentUser().getCompanyId() + "/" + PROFILES_DIR + "/";
	}

	public CompanyGeneral(){
		super();
	}

	public CompanyGeneral(String id, String name){
		super(id, name);
	}
}
