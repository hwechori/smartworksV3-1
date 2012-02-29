package net.smartworks.model.instance;

import net.smartworks.model.community.User;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class ImageInstance extends WorkInstance {

	private String groupId;
	private String imgSource;
	private	String originImgSource;

	private String content;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getImgSource() {
		return imgSource;
	}
	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	public String getOriginImgSource() {
		return originImgSource;
	}
	public void setOriginImgSource(String originImgSource) {
		this.originImgSource = originImgSource;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ImageInstance(){
		super();
		super.setType(Instance.TYPE_IMAGE);
	}

	public ImageInstance(String id, String subject, Work work, User owner, LocalDate lastModifiedDate){
			super(id, subject, work, owner, owner, lastModifiedDate);
			super.setType(Instance.TYPE_IMAGE);
	}

	
}
