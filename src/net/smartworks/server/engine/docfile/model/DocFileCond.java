/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.docfile.model;

import java.util.Date;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.SmartObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class DocFileCond extends SmartObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(DocFile.class);
	
	protected static final String PREFIX = "DocFile";
	private static final String NAME = CommonUtil.toName(DocFile.class, PREFIX);

	public DocFileCond() {
		super();
	}
	
	public static final String A_ID = "id";
	public static final String A_TYPE = "type";
	public static final String A_FILENAME = "fileName";
	public static final String A_FILEPATH = "filePath";
	public static final String A_FILESIZE = "fileSize";
	public static final String A_WRITTENTIME = "writtenTime";

	private String id;
	private String type;
	private String fileName;
	private String filePath;
	private long fileSize;
	private Date writtenTime;
	//private String companyId <- 상위 객체에 포함되어 있음, 매니져 구현시 포함
	
	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_ID, id, buf);
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_FILENAME, fileName, buf);
		appendAttributeString(A_FILEPATH, filePath, buf);
		appendAttributeString(A_FILESIZE, fileSize, buf);
		appendAttributeString(A_WRITTENTIME, writtenTime, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		DocFileCond obj = null;
		if (baseObj == null || !(baseObj instanceof DocFileCond))
			obj = new DocFileCond();
		else
			obj = (DocFileCond)baseObj;
		
		// 부모 attributes, elements 값 설정
		DocFileCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			Node type = attrMap.getNamedItem(A_TYPE);
			Node fileName = attrMap.getNamedItem(A_FILENAME);
			Node filePath = attrMap.getNamedItem(A_FILEPATH);
			Node fileSize = attrMap.getNamedItem(A_FILESIZE);
			Node writtenTime = attrMap.getNamedItem(A_WRITTENTIME);
			if (id != null)
				obj.setId(id.getNodeValue());
			if (type != null)
				obj.setType(type.getNodeValue());
			if (fileName != null)
				obj.setFileName(fileName.getNodeValue());
			if (filePath != null)
				obj.setFilePath(filePath.getNodeValue());
			if (fileSize != null)
				obj.setFileSize(CommonUtil.toLong(fileSize.getNodeValue()));
			if (writtenTime != null)
				obj.setWrittenTime(DateUtil.toDate((writtenTime.getNodeValue())));
		}
		
		// elements 값 설정
		
		return obj;
	}
	public static BaseObject toObject(String str) throws Exception {
		if (str == null)
			return null;
		Document doc = XmlUtil.toDocument(str);
		if (doc == null)
			return null;
		return toObject(doc.getDocumentElement(), null);
	}
	public static DocFileCond[] add(DocFileCond[] objs, DocFileCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		DocFileCond[] newObjs = new DocFileCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static DocFileCond[] remove(DocFileCond[] objs, DocFileCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		DocFileCond[] newObjs = new DocFileCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static DocFileCond[] left(DocFileCond[] objs, DocFileCond obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		DocFileCond[] newObjs = new DocFileCond[objs.length];
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
	public static DocFileCond[] right(DocFileCond[] objs, DocFileCond obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		DocFileCond[] newObjs = new DocFileCond[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx+1];
				continue;
			} else if (i == idx+1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public Object clone() throws CloneNotSupportedException {
		try {
			return toObject(this.toString());
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public Date getWrittenTime() {
		return writtenTime;
	}
	public void setWrittenTime(Date writtenTime) {
		this.writtenTime = writtenTime;
	}

}