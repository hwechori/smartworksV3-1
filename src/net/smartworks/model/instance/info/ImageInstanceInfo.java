package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;

public class ImageInstanceInfo extends WorkInstanceInfo {

	private String imgSource;
	private String content;
	
	public String getImgSource() {
		return imgSource;
	}
	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public ImageInstanceInfo(){
		super();
		super.setType(Instance.TYPE_IMAGE);
	}

	public ImageInstanceInfo(String id, String subject, WorkInfo work, UserInfo owner, LocalDate lastModifiedDate){
		super(id, subject, owner, owner, lastModifiedDate);
		super.setType(Instance.TYPE_IMAGE);
	}

}
