package net.smartworks.model.mail;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

public class MailAttachment extends BaseObject {

	String mimeType;
	long size;

	
	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public MailAttachment() {
		super();
	}

	public MailAttachment(String id, String name) {
		super(id, name);
	}

	public MailAttachment(String id, String name, String mimeType, long size) {
		super(id, name);
		this.mimeType = mimeType;
		this.size = size;
	}
}
