/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 7.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.folder.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class FdrFolderFile extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(FdrFolderFile.class);

	protected static final String PREFIX = "Fdr";
	private static final String NAME = CommonUtil.toName(FdrFolderFile.class, PREFIX);

	public static final String A_FOLDERID = "folderId";
	public static final String A_FILEID = "fileId";

	private String folderId;
	private String fileId;

	public FdrFolderFile() {
		super();
	}
	public String toString(String name, String tab) {
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteString(String name, String tab) {
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_FOLDERID, folderId, buf);
		appendAttributeString(A_FILEID, fileId, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node,BaseObject baseObj)throws Exception {
		if(node == null)
			return null;
		FdrFolderFile obj = null;
		if (baseObj == null || !(baseObj instanceof FdrFolderFile))
			obj = new FdrFolderFile();
		else
			obj = (FdrFolderFile)baseObj;
	
		//부모 attributes, elements 값 설정
		MisObject.toObject(node, obj);
	
		NamedNodeMap attrMap = node.getAttributes();
		if(attrMap != null) {
			Node folderId = attrMap.getNamedItem(A_FOLDERID);
			Node fileId = attrMap.getNamedItem(A_FILEID);
			if(folderId != null)
				obj.setFolderId(folderId.getNodeValue());
			if(fileId !=null)
				obj.setFileId(fileId.getNodeValue());	
		}
		return obj;
	}
	public static BaseObject toObject(String str)throws Exception {
		if(str == null)
			return null;
		Document doc = XmlUtil.toDocument(str);
		if(doc == null)
			return null;
		return toObject(doc.getDocumentElement(), null);
	}
	public static FdrFolderFile[] add(FdrFolderFile[] objs, FdrFolderFile obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if(objs != null)
			size = objs.length;
		FdrFolderFile[] newObjs = new FdrFolderFile[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i]= objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static FdrFolderFile[] remove(FdrFolderFile[] objs, FdrFolderFile obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		FdrFolderFile[] newObjs = new FdrFolderFile[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static FdrFolderFile[] left(FdrFolderFile[]objs,FdrFolderFile obj) {
		if (objs == null || objs.length == 0 || obj ==null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if(!objs[i].equals(obj))
				continue;
				idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		FdrFolderFile[] newObjs = new FdrFolderFile[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx-1];
				continue;
			} else if (i == idx-1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public static FdrFolderFile[] right(FdrFolderFile[]objs, FdrFolderFile obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if( !objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		FdrFolderFile[] newObjs = new FdrFolderFile[objs.length];
		for (int i=0; i<objs.length; i++) {
			if(i == idx) {
				newObjs[i] = objs[idx+1];
				continue;
			}else if (i== idx+1) {
				newObjs[i] = objs[idx+1];
				continue;
				
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public Object clone() throws CloneNotSupportedException {
		try{
			return toObject(this.toString());
		}catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public String getFolderId() {
		return folderId;
	}
	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}