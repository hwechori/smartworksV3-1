/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.SmartUtil;
import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.form.exception.SwfException;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormContent;
import net.smartworks.server.engine.infowork.form.model.SwfFormDef;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;
import net.smartworks.server.engine.infowork.form.model.SwfFormModel;

import org.hibernate.Query;
import org.hibernate.Session;

public class SwfManagerImpl extends AbstractManager implements ISwfManager {

	public SwfManagerImpl() {
		super();
	}

	public SwfForm getForm(String user, String id) throws SwfException {
		if (id == null)
			return null;
		if (SmartUtil.formMap.containsKey(id))
			return SmartUtil.formMap.get(id);
		SwfFormCond cond = new SwfFormCond();
		cond.setId(id);
		SwfForm[] forms = SwManagerFactory.getInstance().getSwfManager().getForms(null, cond, IManager.LEVEL_ALL);
		if (CommonUtil.isEmpty(forms))
			return null;
		SwfForm form = forms[0];
		SmartUtil.formMap.put(id, form);
		return form;
	}

	private Query appendQuery(StringBuffer buf, SwfFormCond cond) throws Exception {
		String objId = null;
		String status = null;
		String id = null;
		int version = -1;
		String packageId = null;
		if (cond != null) {
			objId = cond.getObjId();
			status = cond.getStatus();
			id = cond.getId();
			version = cond.getVersion();
			packageId = cond.getPackageId();
		}
		buf.append(" from SwfForm obj");
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (status != null)
				buf.append(" and obj.status = :status");
			if (id != null)
				buf.append(" and obj.id = :id");
			if (version != -1)
				buf.append(" and version = :version");
			if (packageId != null)
				buf.append(" and obj.packageId = :packageId");
		}
		this.appendOrderQuery(buf, "obj", cond);

		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (status != null)
				query.setString("status", status);
			if (id != null)
				query.setString("id", id);
			if (version != -1)
				query.setInteger("version", version);
			if (packageId != null)
				query.setString("packageId", packageId);
		}
		return query;
	}

	public long getFormSize(String user, SwfFormCond cond) throws SwfException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj.objId)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count = ((Long) list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			throw new SwfException(e);
		}
	}

	public SwfForm[] getForms(String user, SwfFormCond cond, String level) throws SwfException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate");
				buf.append(", obj.modificationUser, obj.modificationDate, obj.status");
				buf.append(", obj.id, obj.version, obj.packageId, obj.formType, obj.keyword");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			List<SwfForm> formList = new ArrayList<SwfForm>();
			for (Iterator itr = list.iterator(); itr.hasNext();) {
				SwfForm obj = null;
				if (!level.equals(LEVEL_ALL)) {
					Object[] fields = (Object[]) itr.next();
					obj = new SwfForm();
					int j = 0;
					obj.setObjId((String) fields[j++]);
					obj.setName((String) fields[j++]);
					obj.setCreationUser((String) fields[j++]);
					obj.setCreationDate((Timestamp) fields[j++]);
					obj.setModificationUser((String) fields[j++]);
					obj.setModificationDate((Timestamp) fields[j++]);
					obj.setStatus((String) fields[j++]);
					obj.setId((String) fields[j++]);
					obj.setVersion((Integer) fields[j++]);
					obj.setPackageId((String) fields[j++]);
					obj.setFormType((String) fields[j++]);
					obj.setKeyword((String) fields[j++]);
				} else {
					obj = (SwfForm) itr.next();
					String pkgId = obj.getPackageId();
					String objId = obj.getObjId();
					String objStr = obj.getObjString();
					if (objStr != null) {
						obj = (SwfForm) SwfForm.toObject(objStr);
						obj.setPackageId(pkgId);
						obj.setObjString(objStr);
						if (obj.getObjId() == null)
							obj.setObjId(objId);
					}
				}
				formList.add(obj);
			}
			SwfForm[] objs = new SwfForm[formList.size()];
			formList.toArray(objs);
			return objs;
		} catch (Exception e) {
			throw new SwfException(e);
		}
	}

	public List<SwfFormFieldDef> findFormFieldByForm(String formId, boolean deployedCondition) throws SwfException, Exception {

		// 폼 아이디로 가장 최근 버전의
		Session session = this.getSession();
		StringBuffer hql = new StringBuffer("from SwfFormContent where formId = :formId and version = (");
		hql.append("select max(version) from SwfFormContent where formId = :formId");
		// 배포된 폼만 검색하기를 원할 경우
		if (deployedCondition)
			hql.append(" and status = '").append(SwfFormModel.STATUS_DEPLOYED).append("'");
		hql.append(")");

		Query query = session.createQuery(hql.toString());
		query.setString("formId", formId);
		SwfFormContent formContent = (SwfFormContent) query.uniqueResult();
		if (formContent == null || formContent.getContent() == null)
			return new ArrayList<SwfFormFieldDef>();

		List<SwfFormFieldDef> result = new ArrayList<SwfFormFieldDef>();
		SwfFormDef formDef = new SwfFormDef();
		formDef = XmlUtil.xmlToForm(formContent.getContent());
		for (Iterator<SwfFormFieldDef> fieldDefIt = formDef.getFormFieldMap().values().iterator(); fieldDefIt.hasNext();)
			result.add(fieldDefIt.next());
		return result;
	}

}