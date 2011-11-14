/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.webservice.manager.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.config.webservice.exception.WebServiceException;
import net.smartworks.server.engine.config.webservice.manager.IWebServiceManager;
import net.smartworks.server.engine.config.webservice.model.WebService;
import net.smartworks.server.engine.config.webservice.model.WebServiceCond;
import net.smartworks.server.engine.config.webservice.model.WebServiceParameter;

import org.hibernate.Query;

public class WebServiceManagerImpl extends AbstractManager implements IWebServiceManager {

	public WebService getWebService(String userId, String objId, String level) throws WebServiceException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				WebService obj = (WebService)this.get(WebService.class, objId);
				return obj;
			} else {
				WebServiceCond cond = new WebServiceCond();
				cond.setObjId(objId);
				return getWebService(userId, cond, level);
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new WebServiceException(e);
		}
	}
	public WebService getWebService(String userId, WebServiceCond cond, String level) throws WebServiceException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		WebService[] webServiceLists = getWebServices(userId, cond, level);
		if (CommonUtil.isEmpty(webServiceLists))
			return null;
		try {
			if (webServiceLists.length != 1)
				throw new WebServiceException("More than 1 Object");
		} catch (WebServiceException e) {
			logger.error(e, e);
			throw e;
		}
		return webServiceLists[0];
	}
	public void setWebService(String userId, WebService obj, String level) throws WebServiceException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)){
				fill(userId, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append(" update WebWebService set ");
				buf.append(" webServiceName=:webServiceName, webServiceAddress=:webServiceAddress, wsdlAddress=:wsdlAddress ");
				buf.append(", portName=:portName, A_OPERATIONNAME=:A_OPERATIONNAME, A_DESCRIPTION=:A_DESCRIPTION, ");
				buf.append(" where objId=:objId ");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(WebService.A_WEBSERVICENAME, obj.getWebServiceName());
				query.setString(WebService.A_WEBSERVICEADDRESS, obj.getWebServiceAddress());
				query.setString(WebService.A_WSDLADDRESS, obj.getWsdlAddress());
				query.setString(WebService.A_PORTNAME, obj.getPortName());
				query.setString(WebService.A_OPERATIONNAME, obj.getOperationName());
				query.setString(WebService.A_DESCRIPTION, obj.getDescription());
				query.setString(WebService.A_OBJID, obj.getObjId());
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new WebServiceException(e);
		}
	}
	public void createWebService(String userId, WebService obj) throws WebServiceException {
		try {
			fill(userId, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new WebServiceException(e);
		}
	}
	public void removeWebService(String userId, String objId) throws WebServiceException {
		try {
			remove(WebService.class, objId);
		} catch (Exception e) {
			logger.error(e, e);
			throw new WebServiceException(e);
		}
	}
	public void removeWebService(String userId, WebServiceCond cond) throws WebServiceException {
		WebService obj = getWebService(userId, cond, null);
		if (obj == null)
			return;
		removeWebService(userId, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, WebServiceCond cond) throws Exception {
		String objId = null;
		String webServiceName = null;
		String webServiceAddress = null;
		String wsdlAddress = null;
		String portName = null;
		String operationName = null;
		String description = null;
		WebServiceParameter[] webServices =null;
		
		if (cond != null) {
			objId = cond.getObjId();
			webServiceName = cond.getWebServiceName();
			webServiceAddress = cond.getWebServiceAddress();
			wsdlAddress = cond.getWsdlAddress();
			portName = cond.getPortName();
			operationName = cond.getOperationName();
			description = cond.getDescription();
		}
		buf.append(" from WebWebService obj");
		if (webServices != null && webServices.length != 0) {
			for (int i=0; i<webServices.length; i++) {
				buf.append(" left join obj.webServiceParameters as webserviceParameter").append(i);
			}
		}
		buf.append(" where obj.id is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (webServiceName != null)
				buf.append(" and obj.webServiceName = :webServiceName");
			if (webServiceAddress != null)
				buf.append(" and obj.webServiceAddress = :webServiceAddress");
			if (wsdlAddress != null)
				buf.append(" and obj.wsdlAddress = :wsdlAddress");
			if (portName != null)
				buf.append(" and obj.portName = :portName");
			if (operationName != null)
				buf.append(" and obj.operationName = :operationName");
			if (description != null)
				buf.append(" and obj.description = :description");
			if (webServices != null && webServices.length != 0) {
				for (int i=0; i<webServices.length; i++) {
					WebServiceParameter webservice = webServices[i];
					String parameterName = webservice.getParameterName();
					String parameterType = webservice.getParameterType();
					String variableName = webservice.getVariableName();
					String type = webservice.getType();
					if (variableName != null)
						buf.append(" and webservice").append(i).append(".variableName = :variableName").append(i);
					if (parameterName != null)
						buf.append(" and webservice").append(i).append(".parameterName = :parameterName").append(i);
					if (parameterType != null)
						buf.append(" and webservice").append(i).append(".parameterType = :parameterType").append(i);
					if (type != null)
						buf.append(" and webservice").append(i).append(".type = :type").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (webServiceName != null)
				query.setString("webServiceName", webServiceName);
			if (webServiceAddress != null)
				query.setString("webServiceAddress", webServiceAddress);
			if (wsdlAddress != null)
				query.setString("wsdlAddress", wsdlAddress);
			if (portName != null)
				query.setString("portName", portName);
			if (operationName != null)
				query.setString("operationName", operationName);
			if (description != null)
				query.setString("description", description);
			if (webServices != null && webServices.length != 0) {
				for (int i=0; i<webServices.length; i++) {
					WebServiceParameter webService = webServices[i];
					String parameterName = webService.getParameterName();
					String parameterType = webService.getParameterType();
					String variableName = webService.getVariableName();
					String type = webService.getType();
					
					if (parameterName != null)
						query.setString("parameterName"+i, parameterName);
					if (parameterType != null)
						query.setString("parameterType"+i, parameterType);
					if (variableName != null)
						query.setString("variableName"+i, variableName);
					if (type != null)
						query.setString("type"+i, type);
				}
			}
		}
		return query;
	}
	public long getWebServiceSize(String userId, WebServiceCond cond) throws WebServiceException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj) ");
			Query query = this.appendQuery(buf, cond);
			List  list = query.list();

			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new WebServiceException(e);
		}
	}
	public WebService[] getWebServices(String userId, WebServiceCond cond, String level) throws WebServiceException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			StringBuffer buf = new StringBuffer();
			buf.append(" select ");
			if(level.equals(LEVEL_ALL)) {
				buf.append(" obj ");
			} else {
				buf.append(" obj.objId, obj.webServiceName, obj.webServiceAddress, obj.wsdlAddress, obj.portName ");
				buf.append(", obj.operationName,  obj.description ");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					WebService obj = new WebService();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setWebServiceName((String)fields[j++]);
					obj.setWebServiceAddress((String)fields[j++]);
					obj.setWsdlAddress((String)fields[j++]);
					obj.setPortName(((String)fields[j++]));	
					obj.setOperationName((String)fields[j++]);
					obj.setDescription(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			WebService[] objs = new WebService[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new WebServiceException(e);
		}
	}
	
	public void removeWebServices(String userId, String packageId) throws WebServiceException {
		if (CommonUtil.isEmpty(packageId))
			return;
		String hql = "delete from WebWebServiceParameter where objId = '" + packageId + "'";
		Query query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}

}