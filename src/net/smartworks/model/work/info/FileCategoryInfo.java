package net.smartworks.model.work.info;

import net.smartworks.model.work.FileCategory;
import net.smartworks.util.SmartUtil;

public class FileCategoryInfo extends WorkInfo implements Comparable<FileCategoryInfo> {

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
		
	public FileCategoryInfo(){
		super();
		super.setType(FileCategory.TYPE_FILE_CATEGORY);
	}
	public FileCategoryInfo(String id, String name){
		super(id, name, FileCategory.TYPE_FILE_CATEGORY);
	}
	
	public String getFullPathName(){
		String fullPathName = "";
		FileCategoryInfo parent = this.parent;
		while(!SmartUtil.isBlankObject(parent)){
			fullPathName = fullPathName + parent.getName() + ">";
		}
		return fullPathName + getName();
	}
	@Override
	public int compareTo(FileCategoryInfo o) {
		return String.valueOf(super.getId()).compareTo(String.valueOf(((FileCategoryInfo)o).getId()));
	}

}