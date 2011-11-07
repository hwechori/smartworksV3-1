package net.smartworks.server.engine.common.exception;

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.w3c.dom.Node;

public class SwException extends Exception {
	private static final long serialVersionUID = 1L;
	protected static final String PREFIX = "Mis";
	private static final String NAME = CommonUtil.toName(SwException.class, PREFIX);
	private String errorCode;
	public SwException() {
		super();
	}
	public SwException(String message) {
		super(message);
	}
	public SwException(String errorCode, String message) {
		super(message);
		setErrorCode(errorCode);
	}
	public SwException(SwException e) {
		super(e);
		setErrorCode(e.getErrorCode());
	}
	public SwException(Throwable t) {
		super(t);
	}
	public SwException(String message, Throwable t) {
		super(message, t);
	}
	public SwException(String errorCode, String message, Throwable t) {
		super(message, t);
		setErrorCode(errorCode);
	}
	public Node toNode() throws Exception {
		StringBuffer buf = new StringBuffer("<").append(NAME);
		if (!CommonUtil.isEmpty(getErrorCode()))
			buf.append(" errorCode=\"").append(getErrorCode()).append("\"");
		buf.append(">");
		buf.append(XmlUtil.toCDataString(CommonUtil.toStackTraceString(this)));
		buf.append("</").append(NAME).append(">");
		return XmlUtil.toDocument(buf.toString()).getDocumentElement();
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String toString() {
		String superStr = super.toString();
		if (CommonUtil.isEmpty(errorCode))
			return superStr;
		
		StringBuffer buf = new StringBuffer();
		buf.append("errorCode: ").append(errorCode);
		if (CommonUtil.isEmpty(superStr))
			return buf.toString();
		
		buf.append("\r\n");
		buf.append(superStr);
		return buf.toString();
	}
	public static String getErrorCode(Node node) {
		return toObject(node).getErrorCode();
	}
	public static String getErrorCode(String str) {
		return toObject(str).getErrorCode();
	}
	protected static SwException toObject(Node node) {
		SwException e = new SwException();
		if (node == null)
			return e;
		try {
			return toObject(XmlUtil.toXmlString(node));
		} catch (Exception e1) {
			return null;
		}
	}
	protected static SwException toObject(String str) {
		SwException e = new SwException();
		if (str == null)
			return e;
		if (str.startsWith("errorCode: ")) {
			String errorCode = null;
			int rnIdx = str.indexOf("\r\n");
			if (rnIdx == -1) {
				errorCode = str.substring(11);
			} else {
				errorCode = str.substring(11, rnIdx);
			}
			e.setErrorCode(errorCode);
		}
		return e;
	}
}
