/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.model;

import java.util.Date;

public interface IDocumentModel {

	/**
	 * @return the id
	 */
	public String getId();

	/**
	 * @param id the id to set
	 */
	public void setId(String id);

	/**
	 * @return the title
	 */
	public String getTitle();

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title);

	/**
	 * @return the code
	 */
	public String getCode();

	/**
	 * @param code the code to set
	 */
	public void setCode(String code);

	/**
	 * @return the ownerDept
	 */
	public String getOwnerDept();

	/**
	 * @param ownerDept the ownerDept to set
	 */
	public void setOwnerDept(String ownerDept);

	/**
	 * @return the ownerUser
	 */
	public String getOwnerUser();

	/**
	 * @param ownerUser the ownerUser to set
	 */
	public void setOwnerUser(String ownerUser);

	/**
	 * @return the fileGroupId
	 */
	public String getFileGroupId();

	/**
	 * @param fileGroupId the fileGroupId to set
	 */
	public void setFileGroupId(String fileGroupId);

	/**
	 * @return the refType
	 */
	public int getRefType();

	/**
	 * @param refType the refType to set
	 */
	public void setRefType(int refType);

	/**
	 * @return the refId
	 */
	public String getRefId();

	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId);

	/**
	 * @return the creator
	 */
	public String getCreator();

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator);

	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime();

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime);

}