/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.model;

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InstanceVariables extends MisObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(InstanceVariables.class);
	protected static final String PREFIX = "Acp";
	
	private static final String NAME = CommonUtil.toName(InstanceVariables.class, PREFIX);
	
	public static final String A_INSTANCEVARIABLE = "instanceVariable";
	public static final String A_INSTANCEVARIABLES = "instanceVariables";
	
	private InstanceVariable[] instanceVariables = null;
	
	public InstanceVariables() {
		super();
	}
	
	public String toString(String name, String tab){
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	
	public String toLiteString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	} 
	
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementsString(null, A_INSTANCEVARIABLE, getInstanceVariables(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		InstanceVariables obj = null;
		if (baseObj == null || !(baseObj instanceof InstanceVariables))
			obj = new InstanceVariables();
		else
			obj = (InstanceVariables)baseObj;
		
		MisObject.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_INSTANCEVARIABLES)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				InstanceVariable[] objs = new InstanceVariable[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (InstanceVariable)InstanceVariable.toObject(nodes[j], null);
				obj.setInstanceVariables(objs);
			} else if (childNode.getNodeName().equals(A_INSTANCEVARIABLE)) {
				obj.addInstanceVariable((InstanceVariable)InstanceVariable.toObject(childNode, null));
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
	public static InstanceVariables[] add(InstanceVariables[] objs, InstanceVariables obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		InstanceVariables[] newObjs = new InstanceVariables[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static InstanceVariables[] remove(InstanceVariables[] objs, InstanceVariables obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		InstanceVariables[] newObjs = new InstanceVariables[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static InstanceVariables[] left(InstanceVariables[] objs, InstanceVariables obj) {
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
		InstanceVariables[] newObjs = new InstanceVariables[objs.length];
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
	public static InstanceVariables[] right(InstanceVariables[] objs, InstanceVariables obj) {
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
		InstanceVariables[] newObjs = new InstanceVariables[objs.length];
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
	public void addInstanceVariable(InstanceVariable instanceVariable) {
		if (instanceVariable == null)
			return;
		this.setInstanceVariables(InstanceVariable.add(this.getInstanceVariables(), instanceVariable));
	}

	public InstanceVariable[] getInstanceVariables() {
		return instanceVariables;
	}

	public void setInstanceVariables(InstanceVariable[] instanceVariables) {
		this.instanceVariables = instanceVariables;
	}
	public InstanceVariable getInstanceVariableById(String id) {
		for (int i = 0; i < this.instanceVariables.length; i++) {
			InstanceVariable instVar = this.instanceVariables[i];
			if (instVar.getId().equalsIgnoreCase(id))
				return instVar;
		}
		return null;
	}

}