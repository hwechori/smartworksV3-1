/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.model;

import java.util.Date;

import org.apache.commons.fileupload.FileItem;

public interface IFileModel {

	public String getId();
	public void setId(String id);
	public String getFileName();
	public void setFileName(String fileName);
	public String getFilePath();
	public void setFilePath(String filePath);
	public String getType();
	public void setType(String type);
	public long getFileSize();
	public void setFileSize(long fileSize);
	public Date getWrittenTime();
	public void setWrittenTime(Date writtenTime);
	public FileItem getFileItem();
	public void setFileItem(FileItem fileItem);

}