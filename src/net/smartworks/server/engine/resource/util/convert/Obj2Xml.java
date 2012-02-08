package net.smartworks.server.engine.resource.util.convert;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Object를 xml로 변환한다.
 * 
 * @author jhnam
 * @version $Id: Obj2Xml.java,v 1.1 2011/11/08 03:15:28 kmyu Exp $
 */
public class Obj2Xml {

	public String convert(Object obj, String rootName, Class clazz) {
		
		XStream nodeXs = new XStream(new DomDriver());
		nodeXs.alias(rootName, clazz);
		return nodeXs.toXML(obj);
	}
}
