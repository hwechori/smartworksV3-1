package net.smartworks.model.mail;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

public class MailFolder extends BaseObject {

	public static final int TYPE_SYSTEM_INBOX 	= 1;
	public static final int TYPE_SYSTEM_DRAFTS 	= 2;
	public static final int TYPE_SYSTEM_SENT 	= 3;
	public static final int TYPE_SYSTEM_TRASH 	= 4;
	public static final int TYPE_SYSTEM_JUNK 	= 5;
	public static final int TYPE_USER 			= 6;

	public static final String ID_ROOT 		= "0";
	
	public static final String ID_INBOX 	= "1";
	public static final String ID_JUNK 		= "2";
	public static final String ID_SENT 		= "3";
	public static final String ID_TRASH 	= "4";
	public static final String ID_DRAFTS 	= "5";
	
	public static final String NAME_INBOX 	= "INBOX";
	public static final String NAME_SENT 	= "Sent";
	public static final String NAME_TRASH 	= "Trash";
	public static final String NAME_DRAFTS 	= "Drafts";
	public static final String NAME_JUNK 	= "Junk";
	
	public static final MailFolder[] SYSTEM_FOLDERS = {
		new MailFolder( ID_INBOX, NAME_INBOX, TYPE_SYSTEM_INBOX),
		new MailFolder( ID_SENT, NAME_SENT, TYPE_SYSTEM_SENT),
		new MailFolder( ID_TRASH, NAME_TRASH, TYPE_SYSTEM_TRASH),
		new MailFolder( ID_DRAFTS, NAME_DRAFTS, TYPE_SYSTEM_DRAFTS),
		new MailFolder( ID_JUNK, NAME_JUNK, TYPE_SYSTEM_JUNK)
	};

	private int type = TYPE_USER;
	private String desc;
	private int unreadItemCount = 0;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getUnreadItemCount() {
		return unreadItemCount;
	}
	public void setUnreadItemCount(int unreadItemCount) {
		this.unreadItemCount = unreadItemCount;
	}

	public MailFolder() {
		super();
	}

	public MailFolder(String id, String name) {
		super(id, name);
	}

	public MailFolder(String id, String name, int type) {
		super(id, name);
		this.type = type;
	}
	
	public static String getFolderNameById(String folderId){
		if(SmartUtil.isBlankObject(folderId)) return null;
		
		int folderInt = Integer.parseInt(folderId);
		switch(folderInt){
		case 1:
			return NAME_INBOX;
		case 2:
			return NAME_JUNK;
		case 3:
			return NAME_SENT;
		case 4:
			return NAME_TRASH;
		case 5:
			return NAME_DRAFTS;
		}
		return null;
	}
}
