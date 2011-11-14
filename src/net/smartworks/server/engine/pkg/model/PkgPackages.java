package net.smartworks.server.engine.pkg.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.ProcessUtil;
import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PkgPackages extends BaseObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PkgPackages.class);
	
	protected static final String PREFIX = "Swp";
	private static final String NAME = CommonUtil.toName(PkgPackages.class, PREFIX);

	public static final String A_PACKAGE = "package";
	
	private PkgPackage[] pkg;
	
	public PkgPackages() {
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
		buf.append(super.toElementsString(tab));
		appendElementsString(null, A_PACKAGE, getPackage(), tab, lite, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		PkgPackages obj = null;
		if (baseObj == null || !(baseObj instanceof PkgPackages))
			obj = new PkgPackages();
		else
			obj = (PkgPackages)baseObj;
		
		MisObject.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_PACKAGE)) {
				obj.addPackage((PkgPackage)PkgPackage.toObject(childNode, null));
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
	public static PkgPackages[] add(PkgPackages[] objs, PkgPackages obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		PkgPackages[] newObjs = new PkgPackages[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static PkgPackages[] remove(PkgPackages[] objs, PkgPackages obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		PkgPackages[] newObjs = new PkgPackages[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static PkgPackages[] left(PkgPackages[] objs, PkgPackages obj) {
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
		PkgPackages[] newObjs = new PkgPackages[objs.length];
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
	public static PkgPackages[] right(PkgPackages[] objs, PkgPackages obj) {
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
		PkgPackages[] newObjs = new PkgPackages[objs.length];
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
	/*
	 * 사용여부를 판단하기 위하여 언더바(__)사용함 , 해당 메소드를 사용하지 않는다면 삭제 필요
	 */
	public Object cloneNew__() throws CloneNotSupportedException {
		try {
			PkgPackages obj = (PkgPackages)clone();
			PkgPackage[] pkgs = obj.getPackage();
			if (CommonUtil.isEmpty(pkgs))
				return obj;
			
			String ctt;
			String[] frmCtts;
			SwfForm frm;
			Map<String, String> frmIdMap = new HashMap<String, String>();
			String oldFrmId;
			String newFrmId;
			String name;
			String type;
			for (PkgPackage pkg : pkgs) {
				name = pkg.getName();
				type = pkg.getType();
				ctt = pkg.getContent();
				if (!CommonUtil.isEmpty(ctt)) {
					if (type == null)
						continue;
					if (type.equalsIgnoreCase("PROCESS")) {
						String prcId = "prc_" + CommonUtil.newId();
						PackageType xpdl;
						xpdl = ProcessModelHelper.load(ctt);
						ctt = ProcessUtil.createProcessByTemplate(xpdl, null, null, prcId, 1, name);
					} else if (type.equalsIgnoreCase("SINGLE")) {
						frm = (SwfForm)SwfForm.toObject(ctt);
						oldFrmId = frm.getId();
						if (CommonUtil.isEmpty(oldFrmId))
							continue;
						if (oldFrmId.equalsIgnoreCase("frm_board_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_board_SYSTEM");
							continue;
						} else if (oldFrmId.equalsIgnoreCase("frm_document_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_document_SYSTEM");
							continue;
						} else if (oldFrmId.equalsIgnoreCase("frm_schedule_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_schedule_SYSTEM");
							continue;
						} else if (oldFrmId.equalsIgnoreCase("frm_company_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_company_SYSTEM");
							continue;
						} else if (oldFrmId.equalsIgnoreCase("frm_dept_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_dept_SYSTEM");
							continue;
						} else if (oldFrmId.equalsIgnoreCase("frm_role_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_role_SYSTEM");
							continue;
						} else if (oldFrmId.equalsIgnoreCase("frm_contact_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_contact_SYSTEM");
							continue;
						} else if (oldFrmId.equalsIgnoreCase("frm_user_SYSTEM")) {
							pkg.setExtendedAttributeValue("formId", "frm_user_SYSTEM");
							continue;
						}
						
						newFrmId = "frm_" + CommonUtil.newId();
						frmIdMap.put(oldFrmId, newFrmId);
						ctt = StringUtils.replace(ctt, oldFrmId, newFrmId);
					} else {
						continue;
					}
					pkg.setContent(ctt);
				}

				pkg.setObjId(null);
				pkg.setPackageId(null);
				pkg.setVersion(1);
				pkg.setStatus("CHECKED-IN");
				pkg.setCreationUser(null);
				pkg.setCreationDate(null);
				pkg.setModificationUser(null);
				pkg.setModificationDate(null);
				
				frmCtts = pkg.getFormContents();
				if (!CommonUtil.isEmpty(frmCtts)) {
					String frmCtt;
					for (int i=0; i<frmCtts.length; i++) {
						frmCtt = frmCtts[i];
						frm = (SwfForm)SwfForm.toObject(frmCtt);
						oldFrmId = frm.getId();
						if (CommonUtil.isEmpty(oldFrmId))
							continue;
						newFrmId = "frm_" + CommonUtil.newId();
						frmIdMap.put(oldFrmId, newFrmId);
						frmCtt = StringUtils.replace(frmCtt, oldFrmId, newFrmId);
						frmCtts[i] = frmCtt;
					}
				}
			}
			
			if (!CommonUtil.isEmpty(frmIdMap)) {
				for (PkgPackage pkg : pkgs) {
					ctt = pkg.getContent();
					if (!CommonUtil.isEmpty(ctt)) {
						for (Iterator frmIdItr = frmIdMap.keySet().iterator(); frmIdItr.hasNext();) {
							oldFrmId = (String)frmIdItr.next();
							if (ctt.indexOf(oldFrmId) == -1)
								continue;
							newFrmId = frmIdMap.get(oldFrmId);
							ctt = StringUtils.replace(ctt, oldFrmId, newFrmId);
						}
						pkg.setContent(ctt);
					}
					
					frmCtts = pkg.getFormContents();
					if (!CommonUtil.isEmpty(frmCtts)) {
						String frmCtt;
						for (int i=0; i<frmCtts.length; i++) {
							frmCtt = frmCtts[i];
							for (Iterator frmIdItr = frmIdMap.keySet().iterator(); frmIdItr.hasNext();) {
								oldFrmId = (String)frmIdItr.next();
								if (frmCtt.indexOf(oldFrmId) == -1)
									continue;
								newFrmId = frmIdMap.get(oldFrmId);
								frmCtt = StringUtils.replace(frmCtt, oldFrmId, newFrmId);
							}
							frmCtts[i] = frmCtt;
						}
					}
				}
			}
			
			return obj;
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public void addPackage(PkgPackage pkg) {
		if (pkg == null)
			return;
		this.setPackage(PkgPackage.add(this.getPackage(), pkg));
	}
	public PkgPackage[] getPackage() {
		return pkg;
	}
	public void setPackage(PkgPackage[] pkg) {
		this.pkg = pkg;
	}

}
