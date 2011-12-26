/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import net.smartworks.server.engine.common.util.XmlUtil;

import org.springframework.web.multipart.MultipartFile;

public class HbFileModel implements IFileModel, Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 파일 아이디
	 */
  	private String id;
  	/**
  	 * 파일 이름
  	 */
  	private String fileName;
  	/**
  	 * 파일 경로
  	 */
  	private String filePath;
  	/**
  	 * 이미지 서버 경로
  	 */
  	private String imageServerPath;
	/**
  	 * 파일 확장자 타입
  	 */
  	private String type;
  	/**
  	 * 파일 사이즈
  	 */
  	private long fileSize;
  	/**
  	 * 생성시간
  	 */
  	private Date writtenTime;
  	/**
  	 * 파일 아이템
  	 */
  	private MultipartFile multipartFile;

  	/**
	 * @return the multipartFile
	 */
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	/**
	 * @param multipartFile the multipartFile to set
	 */
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	private InputStream inputStream;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

  	/**
	 * @return the imageServerPath
	 */
	public String getImageServerPath() {
		return imageServerPath;
	}

	/**
	 * @param imageServerPath the imageServerPath to set
	 */
	public void setImageServerPath(String imageServerPath) {
		this.imageServerPath = imageServerPath;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the fileSize
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the writtenTime
	 */
	public Date getWrittenTime() {
		return writtenTime;
	}

	/**
	 * @param writtenTime the writtenTime to set
	 */
	public void setWrittenTime(Date writtenTime) {
		this.writtenTime = writtenTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbFileModel))
			return false;
		
		HbFileModel model = (HbFileModel)obj;
		
		if(this.id == null || model.getId() == null)
			return false;
		
		if(this.id.equals(model.getId()))
			return true;
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("File", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public void setMultiPartInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public InputStream getMultiPartInputStream() {
		return inputStream;
	}

}