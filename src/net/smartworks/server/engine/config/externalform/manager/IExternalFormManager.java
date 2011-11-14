/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 9.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.config.externalform.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.config.externalform.exception.ExternalFormException;
import net.smartworks.server.engine.config.externalform.model.ExternalForm;
import net.smartworks.server.engine.config.externalform.model.ExternalFormCond;

public interface IExternalFormManager extends IManager {

	public ExternalForm getExternalForm(String userId, String objId, String level) throws ExternalFormException;
	public ExternalForm getExternalForm(String userId, ExternalFormCond cond, String level) throws ExternalFormException;
	public void setExternalForm(String userId, ExternalForm obj, String level) throws ExternalFormException;
	public void createExternalForm(String userId, ExternalForm obj) throws ExternalFormException;
	public void removeExternalForm(String userId, String objId) throws ExternalFormException;
	public void removeExternalForm(String userId, ExternalFormCond cond) throws ExternalFormException;
	public long getExternalFormSize(String userId, ExternalFormCond cond) throws ExternalFormException;
	public ExternalForm[] getExternalForms(String userId, ExternalFormCond cond, String level) throws ExternalFormException;
	public void removeExternalForms(String userId, String packageId) throws ExternalFormException;

}