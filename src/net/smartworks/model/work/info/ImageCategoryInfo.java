package net.smartworks.model.work.info;

import net.smartworks.model.instance.info.ImageInstanceInfo;
import net.smartworks.model.work.ImageCategory;
import net.smartworks.util.SmartUtil;

public class ImageCategoryInfo extends FileCategoryInfo {

	private ImageInstanceInfo firstImage;
			
	public ImageInstanceInfo getFirstImage() {
		return firstImage;
	}
	public void setFirstImage(ImageInstanceInfo firstImage) {
		this.firstImage = firstImage;
	}
	public ImageCategoryInfo(){
		super();
		super.setType(ImageCategory.TYPE_IMAGE_CATEGORY);
	}
	public ImageCategoryInfo(String id, String name){
		super(id, name);
		super.setType(ImageCategory.TYPE_IMAGE_CATEGORY);		
	}
	
	public String getFullPathName(){
		String fullPathName = "";
		ImageCategoryInfo parent = (ImageCategoryInfo)getParent();
		while(!SmartUtil.isBlankObject(parent)){
			fullPathName = fullPathName + parent.getName() + ">";
		}
		return fullPathName + getName();
	}

}