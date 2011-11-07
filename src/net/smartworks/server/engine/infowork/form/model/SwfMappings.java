/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwfMappings extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfMappings.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfMappings.class, PREFIX);
	
	public static final String A_PREMAPPINGS = "pre";
	public static final String A_PREMAPPING = "mapping";
	public static final String A_POSTMAPPINGS = "post";
	public static final String A_POSTMAPPING = "mapping";
	
	private SwfMapping[] preMappings;
	private SwfMapping[] postMappings;
	public SwfMappings() {
		super();
	}
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
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementsString(A_PREMAPPINGS, A_PREMAPPING, getPreMappings(), tab, lite, buf);
		appendElementsString(A_POSTMAPPINGS, A_POSTMAPPING, getPostMappings(), tab, lite, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfMappings obj = null;
		if (baseObj == null || !(baseObj instanceof SwfMappings))
			obj = new SwfMappings();
		else
			obj = (SwfMappings)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_PREMAPPINGS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				SwfMapping[] objs = new SwfMapping[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (SwfMapping)SwfMapping.toObject(nodes[j], null);
				obj.setPreMappings(objs);
			} else if (childNode.getNodeName().equals(A_POSTMAPPINGS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				SwfMapping[] objs = new SwfMapping[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (SwfMapping)SwfMapping.toObject(nodes[j], null);
				obj.setPostMappings(objs);
			}
		}
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
	public static SwfMappings[] add(SwfMappings[] objs, SwfMappings obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfMappings[] newObjs = new SwfMappings[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfMappings[] remove(SwfMappings[] objs, SwfMappings obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfMappings[] newObjs = new SwfMappings[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfMappings[] left(SwfMappings[] objs, SwfMappings obj) {
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
		SwfMappings[] newObjs = new SwfMappings[objs.length];
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
	public static SwfMappings[] right(SwfMappings[] objs, SwfMappings obj) {
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
		SwfMappings[] newObjs = new SwfMappings[objs.length];
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
	public SwfMapping[] getPostMappings() {
		return postMappings;
	}
	public void setPostMappings(SwfMapping[] postMappings) {
		this.postMappings = postMappings;
	}
	public SwfMapping[] getPreMappings() {
		return preMappings;
	}
	public void setPreMappings(SwfMapping[] preMappings) {
		this.preMappings = preMappings;
	}

}