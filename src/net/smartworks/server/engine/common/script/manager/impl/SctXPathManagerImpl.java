/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.script.manager.impl;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.script.exception.SctException;
import net.smartworks.server.engine.common.script.manager.ISctManager;

import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class SctXPathManagerImpl implements ISctManager {

	protected final Log logger = LogFactory.getLog(getClass());
	private FunctionLibrary functionLibrary;

	public SctXPathManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.script.manager.ISctManager#execute(java.lang.String, java.lang.Object)
	 */
	public Object execute(String script, Object context) throws SctException {
		try {
			JXPathContext _context = this.getJXpathContext(context);
			Object result = _context.getValue(script);
			if (result instanceof Double) {
				result = DecimalFormat.getInstance().format(result);
				result = StringUtils.replace((String)result, ",", "");
			}
			return result;
		} catch (Exception e) {
			throw new SctException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.script.manager.ISctManager#executeBoolean(java.lang.String, java.lang.Object)
	 */
	public boolean executeBoolean(String script, Object context) throws SctException {
		Object value = execute(script, context);
		if (value instanceof Boolean) {
			return ((Boolean) value).booleanValue();
		} else {
			return false;
		}
	}

	/**
	 * Functions 설정
	 * @param functionsList
	 */
	public void setFunctionsList(List functionsList) {
		this.functionLibrary = new FunctionLibrary();
		for (Iterator iter = functionsList.iterator(); iter.hasNext();) {
			this.functionLibrary.addFunctions((Functions) iter.next());
		}
	}

	/**
	 * JXPathContext 생성
	 * @param context
	 * @return
	 */
	private JXPathContext getJXpathContext(Object context) {
		JXPathContext jxPathContext = JXPathContext.newContext(context);
		jxPathContext.setFunctions(this.functionLibrary);
		return jxPathContext;
	}

}