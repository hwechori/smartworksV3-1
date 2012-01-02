package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.mail.MailAttachment;
import net.smartworks.model.mail.MailFolder;
import net.smartworks.util.LocalDate;

public class MailInstanceInfo extends InstanceInfo {

	private UserInfo sender;
	private LocalDate sendDate;
	private UserInfo[] receivers;
	private UserInfo[] ccReceivers;
	private int priority;
	private long size;
	private MailAttachment[] attachments;
	private boolean unread;
	private MailFolder mailFolder;
	private MailFolder parentMailFolder;

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
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

	public UserInfo getSender() {
		return sender;
	}

	public void setSender(UserInfo sender) {
		this.sender = sender;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public UserInfo[] getReceivers() {
		return receivers;
	}

	public void setReceivers(UserInfo[] receivers) {
		this.receivers = receivers;
	}

	public UserInfo[] getCcReceivers() {
		return ccReceivers;
	}

	public void setCcReceivers(UserInfo[] ccReceivers) {
		this.ccReceivers = ccReceivers;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public MailAttachment[] getAttachments() {
		return attachments;
	}

	public void setAttachments(MailAttachment[] attachments) {
		this.attachments = attachments;
	}

	public boolean isUnread() {
		return unread;
	}

	public void setUnread(boolean unread) {
		this.unread = unread;
	}

	public MailInstanceInfo() {
		super();
	}

	public MailInstanceInfo(String id, String subject, UserInfo sender,
			LocalDate sendDate) {
		super(id, subject, Instance.TYPE_MAIL, sender, sender, sendDate);
		this.sender = sender;
		this.sendDate = sendDate;
	}

}
