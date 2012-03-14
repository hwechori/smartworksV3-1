package net.smartworks.model.work;

import net.smartworks.model.instance.info.ImageInstanceInfo;

public class ImageCategory extends FileCategory {

	public final static int	TYPE_IMAGE_CATEGORY	= 13;

	private ImageInstanceInfo firstImage;
	
	public ImageInstanceInfo getFirstImage() {
		return firstImage;
	}
	public void setFirstImage(ImageInstanceInfo firstImage) {
		this.firstImage = firstImage;
	}
	public ImageCategory(){
		super();
		super.setType(TYPE_IMAGE_CATEGORY);
	}
	public ImageCategory(String id, String name){
		super(id, name);
		super.setType(TYPE_IMAGE_CATEGORY);
	}
	public ImageCategory(String id, String name, String desc){
		super(id, name, desc);
		super.setType(TYPE_IMAGE_CATEGORY);		
	}
}
