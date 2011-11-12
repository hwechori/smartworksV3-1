package net.smartworks.server.engine.process.script.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.SizeMap;
import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class F2SUtil {
	public static Map<String, SwfForm> formMap = new SizeMap();
	public static SwfForm getForm(String formId) throws Exception {
		if (formMap.containsKey(formId))
			return formMap.get(formId);
		SwfFormCond cond = new SwfFormCond();
		cond.setId(formId);
		cond.setStatus("DEPLOYED");
		cond.setOrders(new Order[] {new Order("modificationDate", false)});
		SwfForm[] forms = SwManagerFactory.getInstance().getSwfManager().getForms(null, cond, IManager.LEVEL_ALL);
		if (CommonUtil.isEmpty(forms))
			return null;
		formMap.put(formId, forms[0]);
		return forms[0];
	}
	public static String[] getDataFieldValues(String taskDoc, String dfId) throws Exception {
		Node taskDocNode = XmlUtil.toDocument(taskDoc, "EUC-KR").getChildNodes().item(0);
		NodeList dfNodeList = taskDocNode.getChildNodes();
		if (dfNodeList == null || dfNodeList.getLength() == 0)
			return null;
		List retList = null;
		String data = null;
		Node dfNode = null;
		String dfName = null;
		NamedNodeMap attrMap = null;
		Node idAttr = null;
		String id = null;
		Node refRecordIdAttr = null;
		NodeList valueNodeList = null;
		for (int i=0; i<dfNodeList.getLength(); i++) {
			dfNode = dfNodeList.item(i);
			dfName = dfNode.getNodeName();
			if (dfName == null || !dfName.equals("DataField"))
				continue;
			attrMap = dfNode.getAttributes();
			idAttr = attrMap.getNamedItem("id");
			if (idAttr == null)
				continue;
			id = idAttr.getNodeValue();
			if (id == null || !id.equals(dfId)) {
				if (retList == null)
					continue;
				break;
			}
			refRecordIdAttr = attrMap.getNamedItem("refRecordId");
			if (refRecordIdAttr != null)
				data = refRecordIdAttr.getNodeValue();
			if (data != null && data.length() != 0) {
				if (retList == null)
					retList = new ArrayList();
				retList.add(data);
				continue;
			}
			valueNodeList = dfNode.getChildNodes();
			if (valueNodeList == null || valueNodeList.getLength() == 0)
				continue;
			Node valueNode = valueNodeList.item(0);
			if (valueNode != null) {
				data = valueNode.getNodeValue();
				if (data != null && data.length() != 0) {
					if (retList == null)
						retList = new ArrayList();
					retList.add(data);
					continue;
				}
			}
		}
		if (retList == null)
			return null;
		String[] res = new String[retList.size()];
		retList.toArray(res);
		return res;
	}
}
