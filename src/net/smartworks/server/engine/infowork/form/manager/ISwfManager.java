/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.infowork.form.exception.SwfException;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;

public interface ISwfManager extends IManager {

	public SwfForm getForm(String user, String id) throws SwfException;

	public long getFormSize(String user, SwfFormCond cond) throws SwfException;

	public SwfForm[] getForms(String user, SwfFormCond cond, String level) throws SwfException;

}