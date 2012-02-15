package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.mail.MailAttachment;
import net.smartworks.model.mail.MailFolder;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

public class MailInstance extends Instance {

	private User sender;
	private LocalDate sendDate;
	private User[] receivers;
	private User[] ccReceivers;
	private User[] bccReceivers;
	private int priority;
	private long size;
	private int partId;
	private MailAttachment[] attachments;
	private boolean unread;
	private MailFolder mailFolder;
	private MailFolder parentMailFolder;

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public User[] getReceivers() {
		return receivers;
	}

	public void setReceivers(User[] receivers) {
		this.receivers = receivers;
	}

	public User[] getCcReceivers() {
		return ccReceivers;
	}

	public void setCcReceivers(User[] ccReceivers) {
		this.ccReceivers = ccReceivers;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public MailAttachment[] getAttachments() {
		return attachments;
	}

	public void setAttachments(MailAttachment[] attachments) {
		this.attachments = attachments;
	}

	public User[] getBccReceivers() {
		return bccReceivers;
	}

	public void setBcccReceivers(User[] bccReceivers) {
		this.bccReceivers = bccReceivers;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean isUnread() {
		return unread;
	}

	public void setUnread(boolean unread) {
		this.unread = unread;
	}

	public MailFolder getMailFolder() {
		return mailFolder;
	}

	public void setMailFolder(MailFolder mailFolder) {
		this.mailFolder = mailFolder;
	}

	public MailFolder getParentMailFolder() {
		return parentMailFolder;
	}

	public void setParentMailFolder(MailFolder parentMailFolder) {
		this.parentMailFolder = parentMailFolder;
	}

	public MailInstance() {
		super();
		super.setType(Instance.TYPE_MAIL);
	}

	public MailInstance(String id, String subject, User sender,
			LocalDate sendDate) {
		super(id, subject, Instance.TYPE_MAIL, sender, sender, sendDate);
		this.sender = sender;
		this.sendDate = sendDate;
	}
	
	public String getReceiversShown(){
		if(SmartUtil.isBlankObject(this.receivers)) return "";
		String shown = receivers[0].getEmailAddressShown();
		for(int i=1; i<this.receivers.length; i++)
			shown = shown + ", " +  receivers[i].getEmailAddressShown();
		return shown;
	}
	
	public String getCcReceiversShown(){
		if(SmartUtil.isBlankObject(this.ccReceivers)) return "";
		String shown = ccReceivers[0].getEmailAddressShown();
		for(int i=1; i<this.ccReceivers.length; i++)
			shown = shown + ", " +  ccReceivers[i].getEmailAddressShown();
		return shown;		
	}
	
	public String getBccReceiversShown(){
		if(SmartUtil.isBlankObject(this.bccReceivers)) return "";
		String shown = bccReceivers[0].getEmailAddressShown();
		for(int i=1; i<this.bccReceivers.length; i++)
			shown = shown + ", " +  bccReceivers[i].getEmailAddressShown();
		return shown;		
	}

}
