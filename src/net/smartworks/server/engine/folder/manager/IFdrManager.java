/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 7.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.folder.manager;

import net.smartworks.server.engine.folder.exception.FdrException;
import net.smartworks.server.engine.folder.model.FdrFolder;
import net.smartworks.server.engine.folder.model.FdrFolderCond;

public interface IFdrManager {

	public FdrFolder getFolder(String user, String id, String level) throws FdrException;

	public FdrFolder getFolder(String user, FdrFolderCond cond, String level) throws FdrException;

	public FdrFolder setFolder(String user, FdrFolder obj, String level) throws FdrException;

	public FdrFolder createFolder(String user, FdrFolder obj) throws FdrException;

	public void removeFolder(String user, String id) throws FdrException;

	public void removeFolder(String user, FdrFolderCond cond) throws FdrException;

	public long getFolderSize(String user, FdrFolderCond cond) throws FdrException;

	public FdrFolder[] getFolders(String user, FdrFolderCond cond, String level) throws FdrException;

	public void createFolderFile(String user, String folderId, String fileId) throws FdrException;

	public void removeFolderFile(String user, String folderId, String fileId) throws FdrException;

}