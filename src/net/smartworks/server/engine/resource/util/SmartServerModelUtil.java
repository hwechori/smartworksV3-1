package net.smartworks.server.engine.resource.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.model.SmartServerConstant;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.id.IDCreator;
import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.IChartConditionDef;
import net.smartworks.server.engine.resource.model.IDomainFieldData;
import net.smartworks.server.engine.resource.model.IDomainRecordData;
import net.smartworks.server.engine.resource.model.IFieldMappingDef;
import net.smartworks.server.engine.resource.model.IFormDef;
import net.smartworks.server.engine.resource.model.IFormFieldDef;
import net.smartworks.server.engine.resource.model.IFormMappingDef;
import net.smartworks.server.engine.resource.model.IGadgetDef;
import net.smartworks.server.engine.resource.model.IMappingFilterDef;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.hb.HbChartConditionDef;
import net.smartworks.server.engine.resource.model.hb.HbDomainFieldData;
import net.smartworks.server.engine.resource.model.hb.HbDomainRecordData;
import net.smartworks.server.engine.resource.model.hb.HbFieldMappingDef;
import net.smartworks.server.engine.resource.model.hb.HbFormDef;
import net.smartworks.server.engine.resource.model.hb.HbFormFieldDef;
import net.smartworks.server.engine.resource.model.hb.HbFormMappingDef;
import net.smartworks.server.engine.resource.model.hb.HbGadgetDef;
import net.smartworks.server.engine.resource.model.hb.HbMappingFilterDef;
import net.smartworks.server.engine.resource.model.hb.HbPackageModel;
import net.smartworks.server.engine.resource.util.convert.Xml2Obj;
import net.smartworks.server.engine.resource.util.lang.StringUtil;

import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 서버 모델로 부터 xml, xml로 부터 서버 모델로 변환
 * 
 * @author jhnam
 * @version $Id: SmartServerModelUtil.java,v 1.1 2011/11/08 03:15:20 kmyu Exp $
 */
public class SmartServerModelUtil {
	
	public static IPackageModel clonePackage(IPackageModel obj) throws SmartServerRuntimeException {
		return clonePackage(obj.toString());
	}
	public static IPackageModel clonePackage(String str) throws SmartServerRuntimeException {
		IPackageModel obj = (IPackageModel)Xml2Obj.convert(str, "Package", HbPackageModel.class);
		
		obj.setId(null);
		obj.setPackageId(null);
		obj.setVersion(SmartServerConstant.START_VERSION);
		obj.setStatus(IPackageModel.STATUS_CHECKED_IN);
		
		String pkgId = obj.getPackageId();
		String pkgType = obj.getType();
		int version = obj.getVersion();
		String name = obj.getName();
		String ctt = obj.getContent();
		List<String> frmCttList = obj.getFormContentList();
		
		Map<String, String> frmIdMap = new HashMap<String, String>();
		if (frmCttList != null && !frmCttList.isEmpty()) {
			String frmCtt = null;
			Element frmElem = null;
			String oldFrmId = null;
			String newFrmId = null;
			for (int i=0; i<frmCttList.size(); i++) {
				frmCtt = frmCttList.get(i);
				try {
					frmElem = XmlUtil.parse(frmCtt).getDocumentElement();
				} catch (Exception e) {
					throw new SmartServerRuntimeException(e);
				}
				oldFrmId = frmElem.getAttribute("id");
				if (oldFrmId == null || oldFrmId.length() == 0)
					continue;
				newFrmId = IDCreator.createId(SmartServerConstant.FORM_ABBR);
				frmElem.setAttribute("id", newFrmId);
				frmElem.setAttribute("version", version+CommonUtil.EMPTY);
				frmIdMap.put(oldFrmId, newFrmId);
				
				try {
					frmCtt = XmlUtil.elementToString(frmElem, "UTF-8", true, true);
				} catch (Exception e) {
					throw new SmartServerRuntimeException(e);
				}
				frmCttList.remove(i);
				frmCttList.add(i, frmCtt);
			}
			if (frmIdMap != null && !frmIdMap.isEmpty()) {
				for (int i=0; i<frmCttList.size(); i++) {
					frmCtt = frmCttList.get(i);
					for (Iterator<String> frmIdItr = frmIdMap.keySet().iterator(); frmIdItr.hasNext();) {
						oldFrmId = frmIdItr.next();
						newFrmId = frmIdMap.get(oldFrmId);
						frmCtt = StringUtils.replace(frmCtt, oldFrmId, newFrmId);
					}
					frmCttList.remove(i);
					frmCttList.add(i, frmCtt);
				}
			}
		}
		
		if (pkgType != null && ctt != null) {
			if (pkgType.equals(IPackageModel.TYPE_PROCESS)) {
				if (frmIdMap != null && !frmIdMap.isEmpty()) {
					String oldFrmId = null;
					String newFrmId = null;
					for (Iterator<String> frmIdItr = frmIdMap.keySet().iterator(); frmIdItr.hasNext();) {
						oldFrmId = frmIdItr.next();
						newFrmId = frmIdMap.get(oldFrmId);
						ctt = StringUtils.replace(ctt, oldFrmId, newFrmId);
					}
				}
				String prcId = IDCreator.createId(SmartServerConstant.PROCESS_ABBR);
				PackageType xpdl;
				try {
					xpdl = ProcessModelHelper.load(ctt);
				} catch (Exception e) {
					throw new SmartServerRuntimeException(e);
				}
				try {
					ctt = SmartServerUtil.createProcessByTemplate(xpdl, null, pkgId, prcId, version, name);
				} catch (Exception e) {
					throw new SmartServerRuntimeException(e);
				}
			} else if (pkgType.equals(IPackageModel.TYPE_SINGLE)) {
				String frmId = IDCreator.createId(SmartServerConstant.FORM_ABBR);
				Element frmElem;
				try {
					frmElem = XmlUtil.parse(ctt).getDocumentElement();
				} catch (Exception e) {
					throw new SmartServerRuntimeException(e);
				}
				frmElem.setAttribute("id", frmId);
				try {
					ctt = XmlUtil.elementToString(frmElem, "UTF-8", true, true);
				} catch (Exception e) {
					throw new SmartServerRuntimeException(e);
				}
			}
			
			obj.setContent(ctt);
		}
		return obj;
	}
	
	/**
	 * formContent로 부터 모든 Form의 요소들을 파싱한다. 
	 * 
	 * @param formContent
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public static IFormDef xmlToTotalForm(String formContent) throws SmartServerRuntimeException {
		IFormDef form = xmlToForm(formContent);
		List<IFormMappingDef> formMappingList = xmlToMapping(formContent);
		if(formMappingList != null) {
			for(IFormMappingDef mapping : formMappingList)
				form.addFormMapping(mapping);
		}
		return form;
	}

	/**
	 * 폼 xml을 IFormMeta 객체로 변환한다.
	 * 
	 * @param formContent
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public static IFormDef xmlToForm(String formContent) throws SmartServerRuntimeException {
		IFormDef form = new HbFormDef();
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
				IFormFieldDef field = toFormField(formId, entity);
				form.addFormField(field);
			}
			return form;
			
		} catch (Throwable e) {
			throw new SmartServerRuntimeException("Failed to convert form xml to form model!", e);
		}
	}
	private static IFormFieldDef toFormField(String formId, Element entity) throws Exception {
		IFormFieldDef field = new HbFormFieldDef();
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
	private static void populateFormFieldChildren(String formId, Element entity, IFormFieldDef field) throws Exception {
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
			IFormFieldDef childField = toFormField(formId, childEntity);
			field.addChildField(childField);
		}
	}
	
	/**
	 * 
	 * @param formContent
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static String getFormFieldFormatXml(String formContent, String id) throws Exception {
		Document doc = XmlUtil.parse(formContent, false, "UTF-8");
		Element root = doc.getDocumentElement();
		
		Node childrenNode = XmlUtil.getXpathNode(root, "./children");
		if (childrenNode == null)
			return null;
		NodeList entityNodeList = XmlUtil.getXpathNodeList(childrenNode, "./formEntity");
		if (CommonUtil.isEmpty(entityNodeList))
			return null;
		
		for(int i = 0 ; i < entityNodeList.getLength() ; i++) {
			Element entity = (Element)entityNodeList.item(i);
			if (!CommonUtil.isEqual(id, entity.getAttribute("id")))
				continue;
			
			Element format = (Element)XmlUtil.getXpathNode(entity, "./format");
			if (format == null)
				return null;
			return XmlUtil.elementToString(format, "UTF-8", true, true);
		}
		return null;
	}
	
	/**
	 * form definition을 xml로 변환한다.
	 * 
	 * @param form
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public static String formToXml(IFormDef form) throws SmartServerRuntimeException {
		// <form id="frm_6c224445b5ab4a02be7131bcf1db88a3" version="1" name="이력서" title="이력서" systemName="">
		StringBuffer buf = new StringBuffer("<form");
		buf.append(" id=\"").append(StringUtil.toNotNull(form.getId()));
		buf.append("\" veresion=\"").append(form.getVersion());
		buf.append("\" name=\"").append(StringUtil.toNotNull(form.getName()));
		buf.append("\" title=\"").append(StringUtil.toNotNull(form.getTitle()));
		buf.append("\" systemName=\"").append(StringUtil.toNotNull(form.getSystemName()));		
		buf.append("\">");
		
		Collection<IFormFieldDef> fieldCol = form.getFormFieldMap().values();
		populateChildrenXml(fieldCol, buf);
		
		buf.append("</form>");
		return buf.toString();
	}
	private static void populateChildrenXml(Collection<IFormFieldDef> fieldCol, StringBuffer buf) {
		if (CommonUtil.isEmpty(fieldCol)) {
			buf.append("<children/>");
			return;
		}
		
		buf.append("<children>");
		
		IFormFieldDef field = null;
		String refForm = null;
		for (Iterator<IFormFieldDef> fieldItr = fieldCol.iterator(); fieldItr.hasNext();) {
			field = fieldItr.next();
			
			//<formEntity id="0" name="이름" title="이름" systemType="string" array="false">
			buf.append("<formEntity");
			buf.append(" id=\"").append(StringUtil.toNotNull(field.getId()));
			buf.append("\" systemType=\"").append(StringUtil.toNotNull(field.getType()));
			buf.append("\" name=\"").append(StringUtil.toNotNull(field.getName()));
			buf.append("\" title=\"").append(StringUtil.toNotNull(field.getTitle()));
			buf.append("\" array=\"").append(field.isArray());
			buf.append("\" system=\"").append(field.isSystem());
			buf.append("\" systemName=\"").append(field.getSystemName());
			buf.append("\">");
			
			if(field.isArray())
				populateChildrenXml(field.getChildren(), buf);

			buf.append("<format type=\"").append(StringUtil.toNotNull(field.getFormatType())).append("\">");
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
	
	/**
	 * xml을 도메인 데이터 레코드로 변환한다.
	 * 
	 * @param formDataXml
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public static IDomainRecordData xmlToDataRecord(String formDataXml) throws SmartServerRuntimeException {
		
		IDomainRecordData record = new HbDomainRecordData();

		try {
			Document doc = XmlUtil.parse(formDataXml, false, "UTF-8");
			Element root = doc.getDocumentElement();
						
			String formId = root.getAttribute("formId");
			String formVersion = root.getAttribute("formVersion");
			String workItemId = root.getAttribute("workItemId");
			String recordId = root.getAttribute("recordId");
			
			record.setFormId(formId);
			record.setFormVersion((formVersion == null || formVersion.trim().equals("")) ? 0 : Integer.parseInt(formVersion));
			
			if(workItemId != null)
				record.setWorkItemId(workItemId);
			
			if(recordId != null)
				record.setRecordId(recordId);
			
			NodeList children = XmlUtil.getXpathNodeList(root, "/DataRecord/DataField");
			for(int i = 0 ; i < children.getLength() ; i++) {
				
				Node child = children.item(i);
				if(child.getNodeType() != Node.ELEMENT_NODE)
					continue;
				
				Element element = (Element)child;
				String name = element.getAttribute("name");
				String id = element.getAttribute("id");
				String type = element.getAttribute("type");				
				String refForm = element.getAttribute("refForm");
				String refFormField = element.getAttribute("refFormField");
				String refRecordId = element.getAttribute("refRecordId");
				
				String data = null;

				IDomainFieldData field = new HbDomainFieldData();
				field.setId(id);
				field.setName(name);
				field.setRefForm(refForm);
				field.setRefFormField(refFormField);
				field.setRefRecordId(refRecordId);
				
				NodeList grandChildren = XmlUtil.getXpathNodeList(element, "./DataField");

				// leaf node 일 경우
				if(grandChildren == null || grandChildren.getLength() == 0) {
					Node dataNode = element.getFirstChild();
					if(dataNode != null)
						data = dataNode.getNodeValue();
				
					if(type != null && type.equals(""))
						field.setType(type);
					
					field.setData(data);
					
				// 하위 노드가 있을 경우
				} else {
					// 이미 배열의 대표 데이터가 있다면 찾아서 사용
					if(record.getDataField(id) != null)
						field = record.getDataField(id);
					// 없다면 새로 생성
					else {
						field.setType(IFormFieldDef.TYPE_COMPLEX);
						field.setArray(true);
					}
					
					IDomainFieldData containerData = new HbDomainFieldData();
					containerData.setId(id);
					containerData.setName(name);
					containerData.setType(IFormFieldDef.TYPE_COMPLEX);
					containerData.setArray(true);
					field.addChild(containerData);
															
					for(int j = 0 ; j < grandChildren.getLength() ; j++) {
						
						Node grandChild = grandChildren.item(j);
						if(grandChild.getNodeType() != Node.ELEMENT_NODE)
							continue;
						
						Element grandChildElement = (Element)grandChild;
						String gName = grandChildElement.getAttribute("name");
						String gId = grandChildElement.getAttribute("id");
						String gType = grandChildElement.getAttribute("type");
						String gRefForm = grandChildElement.getAttribute("refForm");
						String gRefFormField = grandChildElement.getAttribute("refFormField");
						String gRefRecordId = grandChildElement.getAttribute("refRecordId");						
						
						String gData = null;
						
						Node dataNode = grandChildElement.getFirstChild();
						if(dataNode != null)
							gData = dataNode.getNodeValue();
						
						IDomainFieldData gField = new HbDomainFieldData();
						if(type != null && type.equals(""))
							gField.setType(gType);
						
						gField.setId(gId);
						gField.setName(gName);
						gField.setData(gData);
						gField.setRefForm(gRefForm);
						gField.setRefFormField(gRefFormField);
						gField.setRefRecordId(gRefRecordId);
						containerData.addChild(gField);
					}
				}
				
				record.addDataField(field);
			}
			
		} catch (Throwable e) {
			throw new SmartServerRuntimeException("Failed to convert from xml to data record!", e);
		}
		
		return record;
	}
	
	/**
	 * formXml을 파싱하여 폼 매핑 모델을 생성하여 리턴한다.
	 * 
	 * @param formContent
	 * @return
	 */
	public static List<IFormMappingDef> xmlToMapping(String formContent) {
		
		/**
		 *   
		 <mappings>
			<mapping id="1" type="PROCESS">
				<target id="frm_addf" version="1">폼이름1</target>
				<conditions>
					<cond connect="and" operator="=">
						<first id="1">from 필드1</first>
						<second id="1">to 필드1</second>
					</cond>
				</conditions>
				<fragments>
					<frag actionType="import">
						<fromField id="10">필드10</fromField>
						<toField id="10">필드10</toField>
					</frag>
				</fragments>
			</mapping>
  		</mappings>
		 */
		
		List<IFormMappingDef> formMapping = new ArrayList<IFormMappingDef>();
		
		try {
			Document doc = XmlUtil.parse(formContent, false, "UTF-8");
			Element root = doc.getDocumentElement();
			String formId = root.getAttribute("id");
			String formVersionStr = root.getAttribute("version");
			int formVersion = Integer.parseInt(formVersionStr);
			
			NodeList mappingNodeList = XmlUtil.getXpathNodeList(root, "//mappings/mapping");
			for(int i = 0 ; i < mappingNodeList.getLength() ; i++) {
				IFormMappingDef mappingModel = new HbFormMappingDef();
				
				Node mappingNode = mappingNodeList.item(i);
				if(mappingNode.getNodeType() != Node.ELEMENT_NODE)
					continue;
				
				// mapping
				Element mappingElement = (Element)mappingNode;
				String mappingId = mappingElement.getAttribute("id");
				String type = mappingElement.getAttribute("type");
				mappingModel.setFormId(formId);
				mappingModel.setFormVersion(formVersion);
				mappingModel.setId(mappingId);
				mappingModel.setType(type);
				
				// target --> IFormMappingModel
				Node targetNode = XmlUtil.getXpathNode(mappingElement, "./target");
				if(targetNode != null) {
					String refFormId = ((Element)targetNode).getAttribute("id");
					String refFormVersion = ((Element)targetNode).getAttribute("version");
					mappingModel.setRefFormId(refFormId);
					mappingModel.setRefFormVersion(Integer.parseInt(refFormVersion));
				}
				
				// conditions --> IFormMappingFilter
				NodeList conditionNodeList = XmlUtil.getXpathNodeList(mappingElement, "./conditions/cond");
				if(conditionNodeList != null && conditionNodeList.getLength() > 0) {
					
					for(int j = 0 ; j < conditionNodeList.getLength() ; j++) {
						Node conditionNode = conditionNodeList.item(j);
						
						if(conditionNode.getNodeType() != Node.ELEMENT_NODE)
							continue;
						
						IMappingFilterDef filterModel = new HbMappingFilterDef();
						Element conditionElement = (Element)conditionNode;
						Node firstNode = XmlUtil.getXpathNode(conditionElement, "./first");
						Node secondNode = XmlUtil.getXpathNode(conditionElement, "./second");
						
						if(firstNode != null) {
							String firstNodeId = ((Element)firstNode).getAttribute("id");
							filterModel.setOperand1(firstNodeId);
						}
							
						if(secondNode != null) {
							String secondNodeId = ((Element)secondNode).getAttribute("id");
							filterModel.setOperand2(secondNodeId);
						}
						
						String filterConnect = conditionElement.getAttribute("connect"); 
						String filterOperator = conditionElement.getAttribute("operator");
						filterModel.setCondition(filterConnect);
						filterModel.setOperator(filterOperator);
						filterModel.setMappingId(mappingId);
						mappingModel.addMappingFilter(filterModel);
					}
				}
				
				// fragments --> IFormFieldMapping
				NodeList fragmentNodeList = XmlUtil.getXpathNodeList(mappingElement, "./fragments/frag");
				if(fragmentNodeList != null && fragmentNodeList.getLength() > 0) {
						
					for(int j = 0 ; j < fragmentNodeList.getLength() ; j++) {						
						Node fragNode = fragmentNodeList.item(j);
						
						if(fragNode.getNodeType() != Node.ELEMENT_NODE)
							continue;
						
						IFieldMappingDef fieldMappingModel = new HbFieldMappingDef();
						Element fragElement = (Element)fragNode;
						Node fromNode = XmlUtil.getXpathNode(fragElement, "./fromField");
						Node toNode = XmlUtil.getXpathNode(fragElement, "./toField");
						
						if(fromNode != null) {
							String fromFieldId = ((Element)fromNode).getAttribute("id");
							fieldMappingModel.setFromFieldId(fromFieldId);
						}
							
						if(toNode != null) {
							String toFieldId = ((Element)toNode).getAttribute("id");
							fieldMappingModel.setToFieldId(toFieldId);
						}
						
						String actionType = fragElement.getAttribute("actionType"); 
						fieldMappingModel.setAction(actionType);
						fieldMappingModel.setMappingId(mappingId);
						mappingModel.addFieldMapping(fieldMappingModel);
					}
				}
				
				formMapping.add(mappingModel);
			}
			
		} catch (Throwable th) {
			throw new SmartServerRuntimeException("Failed to convert from xml to mapping model!", th);
		}
		
		return formMapping;
	}
	
	/**
	 * 가젯 차트 모델로 부터 스트링을 생성
	 * 
	 * @param gadget
	 * @return
	 */
	public static String gadgetToXml(IGadgetDef gadget) {
		
		StringBuffer buffer = new StringBuffer("<Gadget");
		buffer.append(" formId=\"");
		buffer.append(StringUtil.toNotNull(gadget.getFormId()));
		buffer.append("\" type=\"");
		buffer.append(StringUtil.toNotNull(gadget.getType()));		
		buffer.append("\">");
		
		buffer.append("<name><![CDATA[").append(gadget.getName()).append("]]></name>");
		
		buffer.append("<remark id=\"" + gadget.getRemarkId() + "\">");
		buffer.append("<name><![CDATA[").append(gadget.getRemarkName()).append("]]></name>");
		buffer.append("</remark>");
		
		buffer.append("<valueInfo id=\"").append(gadget.getValueId()).append("\">");
		buffer.append("<name><![CDATA[").append(gadget.getValueName()).append("]]></name>");
		buffer.append("<filter functionType=\"" + gadget.getValueFilterFunction() + "\">").append(gadget.getValueName()).append("\" minValue=\"").append(gadget.getMinValue()).append("\" maxValue=\"").append(gadget.getMaxValue()).append("\" dataType=\"").append(gadget.getValueType()).append("\" />");
		buffer.append("</valueInfo>");
		
		buffer.append("<groupInfo id=\"").append(gadget.getGroupingId()).append("\">");
		buffer.append("<name><![CDATA[").append(gadget.getGroupingName()).append("]]></name>");
		buffer.append("<filter inclusion=\"" + gadget.getGroupingFilterType() + "\">");
		buffer.append("<elements><![CDATA[").append(gadget.getGroupingFilterValue()).append("]]></elements>");		
		buffer.append("</filter>");		
		buffer.append("</groupInfo>");
		
		List<String[]> columns = gadget.getColumns();
		if(columns != null && !columns.isEmpty()) {
			buffer.append("<columns>");
			
			for(String[] columnInfo : columns) {
				buffer.append("<column id=\"").append(columnInfo[0]).append("\">");
				buffer.append("<name><![CDATA[").append(columnInfo[1]).append("]]></name>");
				buffer.append("</column>");
			}
			
			buffer.append("</columns>");
		}
		
		List<IChartConditionDef> conditions = gadget.getConditions();
		if(conditions != null && !conditions.isEmpty()) {
			buffer.append("<conditions>");
			
			for(IChartConditionDef condition : conditions) {
				buffer.append("<condition name=\"").append(condition.getName()).append("\" id=\"").append(condition.getId()).append("\">");
				buffer.append("<columnId>").append(condition.getColumnId()).append("</columnId>");
				buffer.append("<columnName><![CDATA[").append(condition.getColumnName()).append("]]></columnName>");
				buffer.append("<condtionValue>").append(condition.getConditionValue()).append("</condtionValue>");
				buffer.append("<comparison><![CDATA[").append(condition.getComparison()).append("]]></comparison>");
				buffer.append("</condition>");
			}
			
			buffer.append("<conditionRelation><![CDATA[").append(gadget.getConditionsRelation()).append("]]></conditionRelation>");
			buffer.append("</conditions>");
		}
		
		buffer.append("</Gadget>");
		return buffer.toString();		
	}
	
	/**
	 * xml 문자열로 부터 가젯 모델을 파싱하여 리턴
	 * 
	 * @return
	 */
	public static IGadgetDef xmlToGadget(String gadgetXml) {
		
		IGadgetDef gadgetChart = new HbGadgetDef();
		
		try {
			Document doc = XmlUtil.parse(gadgetXml, false, "UTF-8");
			Element root = doc.getDocumentElement();
			
			String type = root.getAttribute("type");
			String formId = root.getAttribute("id");
			
			gadgetChart.setType(type);
			gadgetChart.setFormId(formId);
			
			Node nameNode = XmlUtil.getXpathNode(root, "./name");
			String name = getNodeValue(nameNode);
			gadgetChart.setName(name);
			
			Node remarkNode = XmlUtil.getXpathNode(root, "./remark");
			Node remarkNameNode = XmlUtil.getXpathNode(remarkNode, "./name");
			String remarkName = getNodeValue(remarkNameNode);
			String remarkId = getAttribute(remarkNode, "id");
			gadgetChart.setRemarkId(remarkId);
			gadgetChart.setRemarkName(remarkName);
			
			Node valueInfoNode = XmlUtil.getXpathNode(root, "./valueInfo");
			String valueId = getAttribute(valueInfoNode, "id");
			gadgetChart.setValueId(valueId);
			
			Node valueNameNode = XmlUtil.getXpathNode(valueInfoNode, "./name");
			String valueName = getNodeValue(valueNameNode);
			gadgetChart.setValueName(valueName);
			Node valueUnitNode = XmlUtil.getXpathNode(valueInfoNode, "./unit");
			String valueUnit = getNodeValue(valueUnitNode);
			gadgetChart.setValueUnit(valueUnit);
			
			Node filterNode = XmlUtil.getXpathNode(valueInfoNode, "./filter");
			String valueFilterFunction = getAttribute(filterNode, "functionType");
			String minValue = getAttribute(filterNode, "minValue");
			String maxValue = getAttribute(filterNode, "maxValue");
			String valueType = getAttribute(filterNode, "dataType");
			gadgetChart.setValueFilterFunction(valueFilterFunction);
			gadgetChart.setMinValue(minValue);
			gadgetChart.setMaxValue(maxValue);
			gadgetChart.setValueType(valueType);
			
			Node groupInfoNode = XmlUtil.getXpathNode(root, "./groupInfo");
			String groupInfoId = getAttribute(groupInfoNode, "id");
			gadgetChart.setGroupingId(groupInfoId);
			
			Node groupInfoNameNode = XmlUtil.getXpathNode(groupInfoNode, "name");
			String groupInfoName = getNodeValue(groupInfoNameNode);
			gadgetChart.setGroupingName(groupInfoName);
			
			Node groupInfofilterNode = XmlUtil.getXpathNode(groupInfoNode, "filter");
			String groupInfoFilterType = getAttribute(groupInfofilterNode, "inclusion");
			gadgetChart.setGroupingFilterType(groupInfoFilterType);
			Node groupElementsNode = XmlUtil.getXpathNode(groupInfofilterNode, "elements");
			String groupingFilterValue = getNodeValue(groupElementsNode);
			gadgetChart.setGroupingFilterValue(groupingFilterValue);
			
			Node columnsNode = XmlUtil.getXpathNode(root, "./columns");
			if(columnsNode != null) {
				NodeList columnNodeList = XmlUtil.getXpathNodeList(columnsNode, "./column");
				for(int i = 0 ; i < columnNodeList.getLength() ; i++) {					
					Node columnNode = columnNodeList.item(i);	
					String columnId = getAttribute(columnNode, "id");
					String columnName = null;
					
					Node columnNameNode = XmlUtil.getXpathNode(columnNode, "./name");
					if(columnNameNode != null)
						columnName = getNodeValue(columnNameNode);
					
					gadgetChart.addColumn(columnId, columnName);
				}
			}
			
			Node conditionsNode = XmlUtil.getXpathNode(root, "./conditions");			
			if(conditionsNode != null) {
				NodeList conditionNodeList = XmlUtil.getXpathNodeList(conditionsNode, "./condition");
				for(int i = 0 ; i < conditionNodeList.getLength() ; i++) {
					
					Node condNode = conditionNodeList.item(i);
					IChartConditionDef condition = new HbChartConditionDef();
					String condName = getAttribute(condNode, "name");
					String condId = getAttribute(condNode, "id");
					condition.setId(condId);
					condition.setName(condName);
					
					Node columnIdNode = XmlUtil.getXpathNode(condNode, "./columnId");
					String columnId = getNodeValue(columnIdNode);
					condition.setColumnId(columnId);
					
					Node columnNameNode = XmlUtil.getXpathNode(condNode, "./columnName");
					String columnName = getNodeValue(columnNameNode);
					condition.setColumnName(columnName);
					
					Node conditionValueNode = XmlUtil.getXpathNode(condNode, "./conditionValue");
					String conditionValue = getNodeValue(conditionValueNode);
					condition.setConditionValue(conditionValue);
					
					Node comparisonNode = XmlUtil.getXpathNode(condNode, "./comparison");
					String comparisonValue = getNodeValue(comparisonNode);
					condition.setComparison(comparisonValue);					
					
					gadgetChart.addCondition(condition);
				}
			}
			
			Node conditionsRelationNode = XmlUtil.getXpathNode(conditionsNode, "./conditionsRelation");
			String conditionsRelation = getNodeValue(conditionsRelationNode);
			gadgetChart.setConditionsRelation(conditionsRelation);
			
		} catch (Throwable th) {
			throw new SmartServerRuntimeException("Failed to convert from xml to gadget!", th);
		}
		
		return gadgetChart;
	}
	
	public static String getAttribute(Node node, String attrName) {
		
		if(node == null)
			return null;
		
		Element element = (Element)node;
		return element.getAttribute(attrName);
	}
	
	public static String getNodeValue(Node node) {
		
		if(node == null)
			return null;
		
		if(node.getFirstChild() != null) {
			Node childNode = node.getFirstChild();
			if(childNode == null)
				return null;
			
			if(childNode.getNodeType() == Node.ELEMENT_NODE) {
				return null;
				
			} else if(childNode.getNodeType() == Node.TEXT_NODE) {
				return childNode.getNodeValue();
				
			} else if(childNode.getNodeType() == Node.CDATA_SECTION_NODE) {
				return childNode.getNodeValue();
			}
		}
		
		return null;
	}
	
	public static void main(String[] agrs) {
		
		String buffer = "";
		buffer += "<DataRecord workItemId=\"\" formId=\"frm_6c224445b5ab4a02be7131bcf1db88a3\" formVersion=\"1\">";
		buffer += "	<DataField id=\"0\" name=\"이름\">김대중</DataField>";
		buffer += "	<DataField id=\"1\" name=\"주민번호\">700201-1234567</DataField>";
		buffer += "	<DataField id=\"2\" name=\"학력\">고졸</DataField>";
		buffer += "	<DataField id=\"3\" name=\"프로젝트경력\">";
		buffer += "		<DataField id=\"4\" name=\"프로젝트명\">하이닉스 법제</DataField>";
		buffer += "		<DataField id=\"5\" name=\"역할\">개발자</DataField>";
		buffer += "		<DataField id=\"6\" name=\"사용기술\">자바</DataField>";
		buffer += "		<DataField id=\"7\" name=\"참여기간\">3개월</DataField>";
		buffer += "		<DataField id=\"8\" name=\"시작일\">2007-12-01</DataField>";
		buffer += "		<DataField id=\"9\" name=\"종료일\">2008-03-01</DataField>";
		buffer += "		<DataField id=\"10\" name=\"발주사\">하이닉스</DataField>";
		buffer += "	</DataField>";
		buffer += "	<DataField id=\"3\" name=\"프로젝트경력\">";
		buffer += "		<DataField id=\"4\" name=\"프로젝트명\">한라공조 IMCS</DataField>";
		buffer += "		<DataField id=\"5\" name=\"역할\">PM</DataField>";
		buffer += "		<DataField id=\"6\" name=\"사용기술\">JBOSS</DataField>";
		buffer += "		<DataField id=\"7\" name=\"참여기간\">6개월</DataField>";
		buffer += "		<DataField id=\"8\" name=\"시작일\">2007-11-01</DataField>";
		buffer += "		<DataField id=\"9\" name=\"종료일\">2008-04-01</DataField>";
		buffer += "		<DataField id=\"10\" name=\"발주사\">한라공조</DataField>";
		buffer += "	</DataField>";
		buffer += "</DataRecord>";
		
		//IDomainRecordData record = SmartServerModelUtil.xmlToDataRecord(buffer);
		//System.out.println(record);
	
		//String formContent = "<form id=\"frm_6c224445b5ab4a02be7131bcf1db88a3\" formVersion=\"1\" name=\"이력서\" title=\"이력서\"><children><formEntity id=\"3\" systemType=\"COMPLEX\" name=\"프로젝트경력\" title=\"프로젝트경력\" array=\"true\"><children><formEntity id=\"4\" systemType=\"STRING\" name=\"프로젝트명\" title=\"프로젝트명\" array=\"false\"/><formEntity id=\"5\" systemType=\"STRING\" name=\"역할\" title=\"역할\" array=\"false\"/><formEntity id=\"6\" systemType=\"STRING\" name=\"사용기술\" title=\"사용기술\" array=\"false\"/><formEntity id=\"7\" systemType=\"STRING\" name=\"참여기간\" title=\"참여기간\" array=\"false\"/><formEntity id=\"8\" systemType=\"DATETIME\" name=\"시작일\" title=\"시작일\" array=\"false\"/><formEntity id=\"9\" systemType=\"DATETIME\" name=\"종료일\" title=\"종료일\" array=\"false\"/><formEntity id=\"10\" systemType=\"STRING\" name=\"발주사\" title=\"발주사\" array=\"false\"/></children></formEntity><formEntity id=\"2\" systemType=\"STRING\" name=\"학력\" title=\"학력\" array=\"false\"></formEntity><formEntity id=\"0\" systemType=\"STRING\" name=\"이름\" title=\"이름\" array=\"false\"></formEntity><formEntity id=\"1\" systemType=\"STRING\" name=\"주민번호\" title=\"주민번호\" array=\"false\"></formEntity></children></form>";
		//IFormDef form = SmartServerModelUtil.xmlToForm(formContent);
		//System.out.println(form);
		
		String formContent = "";
		formContent += "<form id=\"frm_6c224445b5ab4a02be7131bcf1db88a3\" version=\"1\" name=\"이력서\" title=\"이력서\">";
		formContent += "	<mappings>";
		formContent += "		<mapping id=\"1\" type=\"PROCESS\">";
		formContent += "			<target id=\"frm_addf\" version=\"1\">폼이름1</target>";
		formContent += "			<conditions>";
		formContent += "				<cond connect=\"and\" operator=\"=\">";
		formContent += "					<first id=\"1\">from 필드1</first>";
		formContent += "					<second id=\"1\">to 필드1</second>";
		formContent += "				</cond>";
		formContent += "			</conditions>";
		formContent += "			<fragments>";
		formContent += "				<frag actionType=\"import\">";
		formContent += "					<fromField id=\"10\">필드10</fromField>";
		formContent += "					<toField id=\"10\">필드10</toField>";
		formContent += "				</frag>";
		formContent += "			</fragments>";
		formContent += "		</mapping>";
		formContent += "	</mappings>";
		formContent += "</form>";
		
		List<IFormMappingDef> formMapping = SmartServerModelUtil.xmlToMapping(formContent);
		System.out.print(formMapping);
	}
	
}
