package net.smartworks.model.work;

import net.smartworks.model.work.info.FileCategoryInfo;
import net.smartworks.util.SmartMessage;

public class FileCategory extends Work {

	public final static int	TYPE_FILE_CATEGORY	= 21;
	
	public final static String ID_UNCATEGORIZED = "Uncategorized";
	public final static String NAME_UNCATEGORIZED = SmartMessage.getString("common.title.uncategorized");
	
	public final static int DISPLAY_ALL = 0;
	public final static int DISPLAY_BY_CATEGORY = 1;
	public final static int DISPLAY_BY_YEAR = 2;
	public final static int DISPLAY_BY_OWNER = 3;
	public final static int DISPLAY_BY_COMMUNITY = 4;
	public final static int DISPLAY_BY_WORK = 5;
	public final static int DISPLAY_BY_FILE_TYPE = 6;
	
	private int length;
	private FileCategoryInfo parent;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public FileCategoryInfo getParent() {
		return parent;
	}
	public void setParent(FileCategoryInfo parent) {
		this.parent = parent;
	}
	public FileCategory(){
		super();
		super.setType(TYPE_FILE_CATEGORY);
	}
	public FileCategory(String id, String name){
		super(id, name);
		super.setType(TYPE_FILE_CATEGORY);
	}
	public FileCategory(String id, String name, String desc){
		super(id, name, TYPE_FILE_CATEGORY, desc);
	}
}
