/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.model.DocFile;
import net.smartworks.server.engine.docfile.model.DocFileCond;

public interface IDocFileManager extends IManager {

	public DocFile getDocFile(String user, String objId, String level) throws DocFileException;
	public DocFile getDocFile(String user, DocFileCond cond, String level) throws DocFileException;
	public void setDocFile(String user, DocFile obj, String level) throws DocFileException;
	public void removeDocFile(String user, String objId) throws DocFileException;
	public void removeDocFile(String user, DocFileCond cond) throws DocFileException;
	public long getDocFileSize(String user, DocFileCond cond) throws DocFileException;
	public DocFile[] getDocFiles(String user, DocFileCond cond, String level) throws DocFileException;

}