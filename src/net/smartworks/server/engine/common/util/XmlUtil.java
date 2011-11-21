package net.smartworks.server.engine.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.smartworks.server.engine.infowork.form.model.SwfFormDef;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;

import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xpath.internal.XPathAPI;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlUtil {
	public static final String ENCODING_UTF8 = "UTF-8";
	public static final String ENCODING_EUCKR = "EUC-KR";
	public static final String XS_NAMESPACE = "http://www.w3.org/2001/XMLSchema";
	public static final String XMLNS = "xmlns";
	public static final String CDATA_OPEN = "<![CDATA[";
	public static final String CDATA_CLOSE = "]]>";
	private static final String EMPTY = CommonUtil.EMPTY;
	private static final String RN = CommonUtil.RN;

	public XmlUtil() {
		super();
	}
	//아래 method를 사용하고 있는 곳에 exception을 주기 위한 kmyu
	public static String toWrappedString(String name, Object[] objs, boolean kmyu) throws Exception {
		StringBuffer buf = new StringBuffer();
		buf.append("<").append(name).append(">");
		if (objs != null && objs.length != 0) {
			for (int i=0; i<objs.length; i++) {
				Object obj = objs[i];
				buf.append(RN);
				buf.append(obj.toString());
			}
			buf.append(RN);
		}
		buf.append("</").append(name).append(">");
		return buf.toString();
	}
//	public static String toWrappedString(String name, BaseObject[] objs) throws Exception {
//		StringBuffer buf = new StringBuffer();
//		buf.append("<").append(name).append(">");
//		if (objs != null && objs.length != 0) {
//			for (int i=0; i<objs.length; i++) {
//				BaseObject obj = objs[i];
//				buf.append(RN);
//				buf.append(obj.toString(null, "\t"));
//			}
//			buf.append(RN);
//		}
//		buf.append("</").append(name).append(">");
//		return buf.toString();
//	}
	public static String toXmlString(Document doc) throws Exception {
		return toXmlString((Node)doc);
	}
	public static String toXmlString(Node doc) throws Exception {
		if (doc == null)
			return null;
		TransformerFactory transFac = TransformerFactory.newInstance();
		Transformer trans = transFac.newTransformer();
		trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		Source src = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult res = new StreamResult(writer);
		trans.transform(src, res);
		String xmlString = writer.toString();
		return xmlString;
	}
	public static String toXmlString(String str) {
		return toXmlString(str, null);
	}
	public static String toXmlString(String str, String encoding) {
		if (str == null)
			str = "<null/>";
		if (encoding == null || encoding.trim().length() == 0)
			encoding = ENCODING_UTF8;
		str = str.trim();
		while (str.startsWith(RN)) {
			str.replaceFirst(RN, EMPTY);
			str.trim();
		}
		if (!str.startsWith("<?xml")) {
			str = new StringBuffer("<?xml version=\"1.0\" encoding=\"").append(encoding).append("\"?>\r\n").append(str).toString();
		}
		return str;
	}
	public static String toCDataString(String str) {
		return toCDataString(str, false);
	}
	public static String toCDataString(String str, boolean hasXml) {
		if (str == null || str.startsWith(CDATA_OPEN))
			return str;
		if (hasXml && str.indexOf(CDATA_CLOSE) != -1)
			str = StringUtils.replace(str, CDATA_CLOSE, "]]&gt;");
		return new StringBuffer().append(CDATA_OPEN).append(str).append(CDATA_CLOSE).toString();
	}
	public static String encode(String str) {
		str = StringUtils.replace(str, "&", "&amp;");
		str = StringUtils.replace(str, "<", "&lt;");
		str = StringUtils.replace(str, ">", "&gt;");
		str = StringUtils.replace(str, "\"", "&quot;");
		str = StringUtils.replace(str, "'", "&apos;");
		return str;
	}
	public static String decode(String str) {
		str = StringUtils.replace(str, "&apos;", "'");
		str = StringUtils.replace(str, "&quot;", "\"");
		str = StringUtils.replace(str, "&gt;", ">");
		str = StringUtils.replace(str, "&lt;", "<");
		str = StringUtils.replace(str, "&amp;", "&");
		return str;
	}
	public static Node toNode(String str) throws Exception {
		return toDocument(str).getDocumentElement();
	}
	public static Document toDocument(String str) throws Exception {
		return toDocument(str, null);
	}
	public static Document toDocument(String str, String encoding) throws Exception {
		if (str == null)
			return null;
		str = str.trim();
		if (str.startsWith("<?xml")) {
			if (str.indexOf("encoding=\"UTF-8\"") != -1 || str.indexOf("encoding=\"utf-8\"") != -1) {
				encoding = ENCODING_UTF8;
			} else if (str.indexOf("encoding=\"EUC-KR\"") != -1 || str.indexOf("encoding=\"euc-kr\"") != -1) {
				encoding = ENCODING_EUCKR;
			} else if (CommonUtil.isEmpty(encoding)) {
				encoding = ENCODING_UTF8;
			}
		} else {
			if (CommonUtil.isEmpty(encoding))
				encoding = ENCODING_UTF8;
		}
		str = toXmlString(str, encoding);
		byte[] bytes = str.getBytes(encoding);
		InputStream is = new ByteArrayInputStream(bytes);
		Document doc = toDocument(is);
		return doc;
	}
	public static Document toDocument(URL url) throws Exception {
		if (url == null)
			return null;
		InputStream is = url.openStream();
		Document doc = toDocument(is);
		return doc;
	}
	public static Document toDocument(InputStream is) throws Exception {
		if (is == null)
			return null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(is);
		return doc;
	}

	public static String beanToXmlString(String rootNodeName, Object bean, Class clazz) throws Exception {
		XStream nodeXs = new XStream(new DomDriver());
		nodeXs.alias(rootNodeName, clazz);
		StringWriter writer = new StringWriter();
		nodeXs.toXML(bean, writer);
		return writer.toString();
	}

	public static Node getXpathNode(Node node, String xpath) throws Exception {
		return XPathAPI.selectSingleNode(node, xpath);
	}

	public static String formToXml(SwfFormDef form) throws Exception {
		// <form id="frm_6c224445b5ab4a02be7131bcf1db88a3" version="1" name="이력서" title="이력서" systemName="">
		StringBuffer buf = new StringBuffer("<form");
		buf.append(" id=\"").append(CommonUtil.toNotNull(form.getId()));
		buf.append("\" veresion=\"").append(form.getVersion());
		buf.append("\" name=\"").append(CommonUtil.toNotNull(form.getName()));
		buf.append("\" title=\"").append(CommonUtil.toNotNull(form.getTitle()));
		buf.append("\" systemName=\"").append(CommonUtil.toNotNull(form.getSystemName()));		
		buf.append("\">");
		
		Collection<SwfFormFieldDef> fieldCol = form.getFormFieldMap().values();
		populateChildrenXml(fieldCol, buf);
		
		buf.append("</form>");
		return buf.toString();
	}
	private static void populateChildrenXml(Collection<SwfFormFieldDef> fieldCol, StringBuffer buf) {
		if (CommonUtil.isEmpty(fieldCol)) {
			buf.append("<children/>");
			return;
		}
		
		buf.append("<children>");
		
		SwfFormFieldDef field = null;
		String refForm = null;
		for (Iterator<SwfFormFieldDef> fieldItr = fieldCol.iterator(); fieldItr.hasNext();) {
			field = fieldItr.next();
			
			//<formEntity id="0" name="이름" title="이름" systemType="string" array="false">
			buf.append("<formEntity");
			buf.append(" id=\"").append(CommonUtil.toNotNull(field.getId()));
			buf.append("\" systemType=\"").append(CommonUtil.toNotNull(field.getType()));
			buf.append("\" name=\"").append(CommonUtil.toNotNull(field.getName()));
			buf.append("\" title=\"").append(CommonUtil.toNotNull(field.getTitle()));
			buf.append("\" array=\"").append(field.isArray());
			buf.append("\" system=\"").append(field.isSystem());
			buf.append("\" systemName=\"").append(field.getSystemName());
			buf.append("\">");

			if(field.isArray())
				populateChildrenXml(field.getChildren(), buf);

			buf.append("<format type=\"").append(CommonUtil.toNotNull(field.getFormatType())).append("\">");
			refForm = field.getRefForm();
			if(!CommonUtil.isEmpty(refForm)) {
				buf.append("<refForm id=\"").append(field.getRefForm()).append("\" ver=\"1\">");
				buf.append("<field id=\"").append(field.getRefFormField()).append("\"/>");
				buf.append("</refForm>");
			}
			buf.append("</format>");
			
			buf.append("</formEntity>");
		}
		
		buf.append("</children>");
	}

	public static NodeList getXpathNodeList(Node node, String xpath) throws Exception {
		return XPathAPI.selectNodeList(node, xpath);
	}

	public static DocumentBuilder getDocumentBuilder(boolean namsepaceAware) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(namsepaceAware);
		return factory.newDocumentBuilder();
	}

	public static SwfFormDef xmlToForm(String formContent) throws Exception {
		SwfFormDef form = new SwfFormDef();
		try {
			Document doc = XmlUtil.parse(formContent, false, "UTF-8");
			Element root = doc.getDocumentElement();
			
			String formId = root.getAttribute("id");
			String version = root.getAttribute("version");
			String formName = root.getAttribute("name");
			String formTitle = root.getAttribute("title");
			String formSystemName = root.getAttribute("systemName");
			
			form.setId(formId);
			form.setVersion((version == null || version.trim().equals("")) ? 0 : Integer.parseInt(version));
			form.setName(formName);
			form.setTitle(formTitle);
			form.setSystemName(formSystemName);
			
			Node childrenNode = XmlUtil.getXpathNode(root, "./children");
			if (childrenNode == null)
				return form;
			NodeList entityNodeList = XmlUtil.getXpathNodeList(childrenNode, "./formEntity");
			if (CommonUtil.isEmpty(entityNodeList))
				return form;
			
			for(int i = 0 ; i < entityNodeList.getLength() ; i++) {
				Element entity = (Element)entityNodeList.item(i);
				SwfFormFieldDef field = toFormField(formId, entity);
				form.addFormField(field);
			}
			return form;
			
		} catch (Throwable e) {
			throw new Exception("Failed to convert form xml to form model!", e);
		}
	}

	public static Document parse(String xmlContent) throws Exception {
		return parse(xmlContent, false, "UTF-8");
	}

	public static Document parse(String xmlContent, boolean namespaceAware, String encoding) throws Exception {
		
		DocumentBuilder builder = getDocumentBuilder(namespaceAware);
		return builder.parse(new ByteArrayInputStream(xmlContent.getBytes(encoding)));
	}

	public static SwfFormFieldDef toFormField(String formId, Element entity) throws Exception {
		SwfFormFieldDef field = new SwfFormFieldDef();
		String id = entity.getAttribute("id");
		String name = entity.getAttribute("name");
		String title = entity.getAttribute("title");
		String type = entity.getAttribute("systemType");
		boolean isArray = CommonUtil.toBoolean(entity.getAttribute("array"));
		String system = entity.getAttribute("system");
		String systemName = entity.getAttribute("systemName");
		String formatType = null;
		String viewingType = null;
		String refFormId = null;
		String refFormFieldId = null;
		Element format = (Element)XmlUtil.getXpathNode(entity, "./format");
		if (format != null) {
			formatType = format.getAttribute("type");
			viewingType = format.getAttribute("viewingType");
			Element refForm = (Element)XmlUtil.getXpathNode(format, "./refForm");
			if (refForm != null) {
				refFormId = refForm.getAttribute("id");
				Element refFormField = (Element)XmlUtil.getXpathNode(refForm, "./field");
				if (refFormField != null)
					refFormFieldId = refFormField.getAttribute("id");
			}
		}
		
		field.setId(id);
		field.setName(name);
		field.setTitle(title);
		field.setType(type);
		field.setArray(isArray);
		field.setSystem(CommonUtil.toBoolean(system));
		field.setFormId(formId);
		field.setSystemName(systemName);
		field.setViewingType(viewingType);
		field.setFormatType(formatType);
		field.setRefForm(refFormId);
		field.setRefFormField(refFormFieldId);
		
		if (isArray)
			populateFormFieldChildren(formId, entity, field);
		
		return field;
	}

	private static void populateFormFieldChildren(String formId, Element entity, SwfFormFieldDef field) throws Exception {
		if (entity == null)
			return;
		Node children = XmlUtil.getXpathNode(entity, "./children");
		if (children == null)
			return;
		NodeList childrenEntity = XmlUtil.getXpathNodeList(children, "./formEntity");
		if (CommonUtil.isEmpty(childrenEntity))
			return;
		Element childEntity = null;
		for(int i=0 ; i<childrenEntity.getLength(); i++) {
			childEntity = (Element)childrenEntity.item(i);
			SwfFormFieldDef childField = toFormField(formId, childEntity);
			field.addChildField(childField);
		}
	}

}