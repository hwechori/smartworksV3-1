package net.smartworks.server.engine.config.model;

import java.util.Date;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwcEventDay extends MisObject {

	public SwcEventDay() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	protected static final String PREFIX = "Swc";

	private static Log logger = LogFactory.getLog(SwcEventDay.class);
	private static final String NAME = CommonUtil.toName(SwcEventDay.class, PREFIX);

	public static final String A_TYPE = "type";
	public static final String A_STARTDAY = "startDay";
	public static final String A_ENDDAY = "endDay";
	public static final String A_RELTDPERSON = "reltdPerson";

	private String type;
	private Date startDay;	
	private Date endDay;
	private String reltdPerson;
	
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
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_STARTDAY, startDay, buf);
		appendAttributeString(A_ENDDAY, endDay, buf);
		appendAttributeString(A_RELTDPERSON, reltdPerson, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj)throws Exception {
		if (node == null)
			return null;
		SwcEventDay obj = null;
		if (baseObj == null || !(baseObj instanceof SwcEventDay))
			obj = new SwcEventDay();
		else
			obj = (SwcEventDay)baseObj;
		
			//부모 attributes, elements값 설정
			MisObject.toObject(node, obj);

			NamedNodeMap attrMap = node.getAttributes();
			if (attrMap != null) {
				Node type = attrMap.getNamedItem(A_TYPE);
				Node startDay = attrMap.getNamedItem(A_STARTDAY);
				Node endDay = attrMap.getNamedItem(A_ENDDAY);
				Node reltdPerson = attrMap.getNamedItem(A_RELTDPERSON);
				if(type != null)
					obj.setType(type.getNodeValue());
				if(startDay != null)
					obj.setStartDay(DateUtil.toDate(startDay.getNodeValue()));
				if(endDay != null)
					obj.setEndDay(DateUtil.toDate(endDay.getNodeValue()));
				if(reltdPerson != null)
					obj.setReltdPerson(reltdPerson.getNodeValue());
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
	public static SwcEventDay[] add(SwcEventDay[] objs, SwcEventDay obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if(objs != null)
			size = objs.length;
		SwcEventDay[] newObjs = new SwcEventDay[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwcEventDay[] remove(SwcEventDay[] objs, SwcEventDay obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwcEventDay[] newObjs = new SwcEventDay[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (!objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
		
	}
	public static SwcEventDay[] left(SwcEventDay[] objs, SwcEventDay obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int  idx = -1;
		for(int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		SwcEventDay[] newObjs = new SwcEventDay[objs.length];
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
	public static SwcEventDay[] right(SwcEventDay[] objs, SwcEventDay obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for(int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		SwcEventDay[] newObjs = new SwcEventDay[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx+1];
				continue;
			}else if (i == idx+1) {
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
	
	public String getReltdPerson() {
		return reltdPerson;
	}
	public void setReltdPerson(String reltdPerson) {
		this.reltdPerson = reltdPerson;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

}
