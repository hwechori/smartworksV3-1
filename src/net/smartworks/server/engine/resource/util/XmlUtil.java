package net.smartworks.server.engine.resource.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.org.apache.xml.internal.serializer.Method;
import com.sun.org.apache.xpath.internal.XPathAPI;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Xml 데이터 핸들링 유틸
 * 
 * @author jhnam
 * @version $Id: XmlUtil.java,v 1.1 2011/11/08 03:15:29 kmyu Exp $
 */
public class XmlUtil {

	/**
	 * namespaceAware에 따라 DocumentBuilder를 생성한다.
	 * 
	 * @param namsepaceAware
	 * @return
	 * @throws Exception
	 */
	public static DocumentBuilder getDocumentBuilder(boolean namsepaceAware) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(namsepaceAware);
		return factory.newDocumentBuilder();
	}
	
	/**
	 * 파일을 파싱하여 Xml Document를 생성한다.
	 * 
	 * @param xmlFile
	 * @param namsepaceAware
	 * @return
	 * @throws Exception
	 */
	public static Document parse(File xmlFile, boolean namsepaceAware) throws Exception {
		return getDocumentBuilder(namsepaceAware).parse(xmlFile);
	}
	
	/**
	 * InputStream을 파싱하여 Xml Document를 생성한다.
	 * 
	 * @param is
	 * @param namsepaceAware
	 * @return
	 * @throws Exception
	 */
	public static Document parse(InputStream is, boolean namsepaceAware) throws Exception {
		return getDocumentBuilder(namsepaceAware).parse(is);
	}
	
	/**
	 * xml 데이터를 파싱하여 Xml Document를 생성한다.
	 * 
	 * @param xmlContent
	 * @param namespaceAware
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static Document parse(String xmlContent, boolean namespaceAware, String encoding) throws Exception {
		
		DocumentBuilder builder = getDocumentBuilder(namespaceAware);
		return builder.parse(new ByteArrayInputStream(xmlContent.getBytes(encoding)));
	}
	public static Document parse(String xmlContent) throws Exception {
		return parse(xmlContent, false, "UTF-8");
	}
	
	/**
	 * node의 xpath에 해당하는 경로에 있는 NodeList를 찾아 리턴한다. 
	 * 
	 * @param node
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static NodeList getXpathNodeList(Node node, String xpath) throws Exception {
		return XPathAPI.selectNodeList(node, xpath);
	}
	
	/**
	 * node로 부터 xpath 노드를 얻어온다.
	 * 
	 * @param node
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static Node getXpathNode(Node node, String xpath) throws Exception {
		return XPathAPI.selectSingleNode(node, xpath);
	}
	
	/**
	 * node로 부터 xpath에 해당하는 실제 데이터를 찾아 리턴한다.
	 * 
	 * @param node
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static String getXpathData(Node node, String xpath) throws Exception {
		
		Node xpathNode = getXpathNode(node, xpath);
		
		if(xpathNode == null)
			return null;
		
		if(xpathNode.getNodeType() == Node.ELEMENT_NODE) {
			Node textNode = xpathNode.getFirstChild();
			return textNode != null ? textNode.getNodeValue() : null;
			
		} else if(xpathNode.getNodeType() == Node.ATTRIBUTE_NODE) {
			return xpathNode.getNodeValue();
			
		} else if(xpathNode.getNodeType() == Node.TEXT_NODE) {
			return xpathNode.getNodeValue();
			
		} else if(xpathNode.getNodeType() == Node.CDATA_SECTION_NODE) {
			return xpathNode.getNodeValue();
			
		} else {
			return xpathNode.getNodeValue();
		}
	}
	
	/**
	 * node의 xpath 경로에 data를 설정한다.
	 *  
	 * @param node
	 * @param xpath
	 * @param data
	 * @throws Exception
	 */
	public static void setXpathData(Node node, String xpath, String nodeValue) throws Exception {
		
		Node xpathNode = getXpathNode(node, xpath);
		
		if(xpathNode == null)
			throw new Exception("Node has no element this path [" + xpath + "]!");
		
		if(xpathNode.getNodeType() == Node.ELEMENT_NODE) {
			Node textNode = xpathNode.getFirstChild();

			if(textNode == null) 
				throw new Exception("Text node not found!");
			else
				textNode.setNodeValue(nodeValue);
			
		} else if(xpathNode.getNodeType() == Node.ATTRIBUTE_NODE) {
			xpathNode.setNodeValue(nodeValue);
			
		} else if(xpathNode.getNodeType() == Node.TEXT_NODE) {
			xpathNode.setNodeValue(nodeValue);
			
		} else if(xpathNode.getNodeType() == Node.CDATA_SECTION_NODE) {
			xpathNode.setNodeValue(nodeValue);
			
		} else {
			xpathNode.setNodeValue(nodeValue);
		}
	}
	
	/**
	 * element를 string으로 변환한다. encoding, xml declaration, indent등의 옵션을 줄 수 있다.
	 * 
	 * @param element
	 * @param encoding
	 * @param omitXmlDecl
	 * @param setIndent
	 * @return
	 * @throws Exception
	 */
	public static String elementToString(Element element, String encoding, boolean omitXmlDecl, boolean setIndent) throws Exception {
		
		Writer sw = new StringWriter();
		OutputFormat of = new OutputFormat(Method.XML, encoding, false);
		of.setOmitXMLDeclaration(omitXmlDecl);
		of.setIndenting(setIndent);
		XMLSerializer serializer = new XMLSerializer(sw, of);
		serializer.serialize(element);
		return sw.toString();
	}
	
	/**
	 * primitive type getter/setter로 이루어진 bean 객체를 xmlString으로 변환하여 리턴한다. 
	 * 
	 * @param rootNodeName
	 * @param obj
	 * @param clazz 
	 * @return
	 * @throws Exception
	 */
	public static String beanToXmlString(String rootNodeName, Object bean, Class clazz) throws Exception {
		
		XStream nodeXs = new XStream(new DomDriver());
		nodeXs.alias(rootNodeName, clazz);
		StringWriter writer = new StringWriter();
		nodeXs.toXML(bean, writer);
		return writer.toString();
	}
	
	public static Object xmlToBean(String xml, String alias, Class cls) throws Exception {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias(alias, cls);
		Object obj = xstream.fromXML(xml);
		return obj;
	}
	
	public static Object xmlToBeanList(String xml, String listAlias, String alias, Class cls) throws Exception {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias(alias, cls);
		xstream.alias(listAlias, List.class);
		Object obj = xstream.fromXML(xml);
		return obj;
	}
		
}
