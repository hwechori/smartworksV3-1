/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.externalform.manager.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.config.externalform.exception.ExternalFormException;
import net.smartworks.server.engine.config.externalform.manager.IExternalFormManager;
import net.smartworks.server.engine.config.externalform.model.ExternalForm;
import net.smartworks.server.engine.config.externalform.model.ExternalFormCond;
import net.smartworks.server.engine.config.externalform.model.ExternalFormParameter;

import org.hibernate.Query;

public class ExternalFormManagerImpl extends AbstractManager implements IExternalFormManager {

	public ExternalForm getExternalForm(String userId, String objId, String level) throws ExternalFormException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				ExternalForm obj = (ExternalForm) this.get(ExternalForm.class, objId);
				return obj;
			} else {
				ExternalFormCond cond = new ExternalFormCond();
				cond.setObjId(objId);
				return getExternalForm(userId, cond, level);
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new ExternalFormException(e);
		}
	}

	public ExternalForm getExternalForm(String userId, ExternalFormCond cond, String level) throws ExternalFormException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		ExternalForm[] webAppServiceLists = getExternalForms(userId, cond, level);
		if (CommonUtil.isEmpty(webAppServiceLists))
			return null;
		try {
			if (webAppServiceLists.length != 1)
				throw new ExternalFormException("More than 1 Object");
		} catch (ExternalFormException e) {
			logger.error(e, e);
			throw e;
		}
		return webAppServiceLists[0];
	}

	public void setExternalForm(String userId, ExternalForm obj, String level) throws ExternalFormException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(userId, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append(" update WebWebAppService set ");
				buf.append(" webAppServiceName=:webAppServiceName, webAppServiceUrl=:webAppServiceUrl, modifyMethod=:modifyMethod ");
				buf.append(", viewMethod=:viewMethod, A_DESCRIPTION=:A_DESCRIPTION, ");
				buf.append(" where objId=:objId ");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(ExternalForm.A_EXTERNALFORMNAME, obj.getExternalFormName());
				query.setString(ExternalForm.A_EXTERNALFORMURL, obj.getExternalFormUrl());
				query.setString(ExternalForm.A_MODIFYMETHOD, obj.getModifyMethod());
				query.setString(ExternalForm.A_VIEWMETHOD, obj.getViewMethod());
				query.setString(ExternalForm.A_DESCRIPTION, obj.getDescription());
				query.setString(ExternalForm.A_OBJID, obj.getObjId());
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new ExternalFormException(e);
		}

	}

	public void createExternalForm(String userId, ExternalForm obj) throws ExternalFormException {
		try {
			fill(userId, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new ExternalFormException(e);
		}
	}

	public void removeExternalForm(String userId, String objId) throws ExternalFormException {
		try {
			remove(ExternalForm.class, objId);
		} catch (Exception e) {
			logger.error(e, e);
			throw new ExternalFormException(e);
		}

	}

	public void removeExternalForm(String userId, ExternalFormCond cond) throws ExternalFormException {
		ExternalForm obj = getExternalForm(userId, cond, null);
		if (obj == null)
			return;
		removeExternalForm(userId, obj.getObjId());

	}

	private Query appendQuery(StringBuffer buf, ExternalFormCond cond) throws Exception {
		String objId = null;
		String webAppServiceName = null;
		String webAppServiceUrl = null;
		String modifyMethod = null;
		String viewMethod = null;
		String description = null;
		ExternalFormParameter[] webAppServiceParameters = null;

		if (cond != null) {
			objId = cond.getObjId();
			webAppServiceName = cond.getExternalFormName();
			webAppServiceUrl = cond.getExternalFormUrl();
			modifyMethod = cond.getModifyMethod();
			viewMethod = cond.getViewMethod();
			description = cond.getDescription();
		}

		buf.append(" from WebWebAppService obj ");
		if (webAppServiceParameters != null && webAppServiceParameters.length != 0) {
			for (int i = 0; i < webAppServiceParameters.length; i++) {
				buf.append(" left join obj.webAppServiceParameters as webappserviceParameter").append(i);
			}
		}
		buf.append(" where obj.id is not null ");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId ");
			if (webAppServiceName != null)
				buf.append(" and obj.webAppServiceName = :webAppServiceName ");
			if (webAppServiceUrl != null)
				buf.append(" and obj.webAppServiceUrl = :webAppServiceUrl ");
			if (modifyMethod != null)
				buf.append(" and obj.modifyMethod = :modifyMethod ");
			if (viewMethod != null)
				buf.append(" and obj.viewMethod = :viewMethod ");
			if (description != null)
				buf.append(" and obj.description = :description ");
			if (webAppServiceParameters != null && webAppServiceParameters.length != 0) {
				for (int i = 0; i < webAppServiceParameters.length; i++) {
					ExternalFormParameter webparameter = webAppServiceParameters[i];
					String parameterName = webparameter.getParameterName();
					String parameterType = webparameter.getParameterType();
					String variableName = webparameter.getVariableName();
					String type = webparameter.getType();
					if (variableName != null)
						buf.append(" and webparameter").append(i).append(".variableName = :variableName").append(i);
					if (parameterName != null)
						buf.append(" and webparameter").append(i).append(".parameterName = :parameterName").append(i);
					if (parameterType != null)
						buf.append(" and webparameter").append(i).append(".parameterType = :parameterType").append(i);
					if (type != null)
						buf.append(" and webparameter").append(i).append(".type = :type").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);

		Query query = this.createQuery(buf.toString(), cond);

		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (webAppServiceName != null)
				query.setString("webAppServiceName", webAppServiceName);
			if (webAppServiceUrl != null)
				query.setString("webAppServiceUrl", webAppServiceUrl);
			if (modifyMethod != null)
				query.setString("modifyMethod", modifyMethod);
			if (viewMethod != null)
				query.setString("viewMethod", viewMethod);
			if (description != null)
				query.setString("description", description);
			if (webAppServiceParameters != null && webAppServiceParameters.length != 0) {
				for (int i = 0; i < webAppServiceParameters.length; i++) {
					ExternalFormParameter webparameter = webAppServiceParameters[i];
					String parameterName = webparameter.getParameterName();
					String parameterType = webparameter.getParameterType();
					String variableName = webparameter.getVariableName();
					String type = webparameter.getType();
					if (parameterName != null)
						query.setString("parameterName" + i, parameterName);
					if (parameterType != null)
						query.setString("parameterType" + i, parameterType);
					if (variableName != null)
						query.setString("variableName" + i, variableName);
					if (type != null)
						query.setString("type" + i, type);
				}
			}
		}
		return query;
	}

	public long getExternalFormSize(String userId, ExternalFormCond cond) throws ExternalFormException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj) ");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();

			long count = ((Long) list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new ExternalFormException(e);
		}
	}

	public ExternalForm[] getExternalForms(String userId, ExternalFormCond cond, String level) throws ExternalFormException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			StringBuffer buf = new StringBuffer();
			buf.append(" select ");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj ");
			} else {
				buf.append(" obj.objId, obj.webAppServiceName, obj.webAppServiceUrl, obj.modifyMethod, obj.viewMethod ");
				buf.append(", obj.description ");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					ExternalForm obj = new ExternalForm();
					int j = 0;
					obj.setObjId((String) fields[j++]);
					obj.setExternalFormName((String) fields[j++]);
					obj.setExternalFormUrl((String) fields[j++]);
					obj.setModifyMethod((String) fields[j++]);
					obj.setViewMethod(((String) fields[j++]));
					obj.setDescription(((String) fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			ExternalForm[] objs = new ExternalForm[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new ExternalFormException(e);
		}
	}

	public void removeExternalForms(String userId, String packageId) throws ExternalFormException {
		if (CommonUtil.isEmpty(packageId))
			return;
		String hql = "delete from WebWebAppServiceParameter where objId = '" + packageId + "'";
		Query query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}

}