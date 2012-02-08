package net.smartworks.server.engine.resource.util.convert;

import java.lang.reflect.Field;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * xml을 Object로 변환한다.
 * 
 * @author jhnam
 * @version $Id: Xml2Obj.java,v 1.1 2011/11/08 03:15:28 kmyu Exp $
 */
public class Xml2Obj {

	public static Object convert(String xml, String rootName, Class clazz) {
		
		XStream xstream = new XStream(new DomDriver());
		Annotations.configureAliases(xstream, clazz);
		xstream.alias(rootName, clazz);
		
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field f : fields) {
			Annotations.configureAliases(xstream, f.getType());
		}
		
		return xstream.fromXML(xml);
	}
}
