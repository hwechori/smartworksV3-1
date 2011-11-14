/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.webservice.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.config.webservice.exception.WebServiceException;
import net.smartworks.server.engine.config.webservice.model.WebService;
import net.smartworks.server.engine.config.webservice.model.WebServiceCond;

public interface IWebServiceManager extends IManager {

	public WebService getWebService(String userId, String objId, String level) throws WebServiceException;
	public WebService getWebService(String userId, WebServiceCond cond, String level) throws WebServiceException;
	public void setWebService(String userId, WebService obj, String level) throws WebServiceException;
	public void createWebService(String userId, WebService obj) throws WebServiceException;
	public void removeWebService(String userId, String objId) throws WebServiceException;
	public void removeWebService(String userId, WebServiceCond cond) throws WebServiceException;
	public long getWebServiceSize(String userId, WebServiceCond cond) throws WebServiceException;
	public WebService[] getWebServices(String userId, WebServiceCond cond, String level) throws WebServiceException;

	public void removeWebServices(String userId, String packageId) throws WebServiceException;

}