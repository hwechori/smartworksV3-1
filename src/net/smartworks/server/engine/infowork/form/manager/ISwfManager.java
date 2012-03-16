/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.manager;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.infowork.form.exception.SwfException;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;

public interface ISwfManager extends IManager {

	public SwfForm getForm(String user, String id) throws SwfException;

	public long getFormSize(String user, SwfFormCond cond) throws SwfException;

	public SwfForm[] getForms(String user, SwfFormCond cond, String level) throws SwfException;

	public List<SwfFormFieldDef> findFormFieldByForm(String formId, boolean deployedCondition) throws SwfException;

	public int getReferenceFormSize(String user, String recordId) throws SwfException;

	public Map<String, Integer> getReferenceFormIdSizeMap(String user, String recordId) throws SwfException;
	
	public String getFormContent(String userId, String formId) throws SwfException;

}