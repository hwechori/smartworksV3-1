/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.script.manager.impl;

import net.smartworks.server.engine.common.script.exception.SctException;
import net.smartworks.server.engine.common.script.manager.ISctManager;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class SctJsManagerImpl implements ISctManager {

	protected final Log logger = LogFactory.getLog(getClass());
	private String extendedFunctionClass;
	private Class extFuncClass;
	
	public SctJsManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public Object execute(String script, Object context) throws SctException {
		Context ctx = null;
		try {
			Class extFuncClass = getExtFuncClass();
			
			ctx = Context.enter();
			ctx.setLanguageVersion(Context.VERSION_1_6);
			ctx.setOptimizationLevel(-1);
			ctx.setCompileFunctionsWithDynamicScope(true);
			ctx.hasFeature(Context.FEATURE_DYNAMIC_SCOPE);
			ctx.hasFeature(Context.FEATURE_E4X);
			
			Scriptable scriptable = ctx.initStandardObjects(null);
			script = "function fn() {" + script + "}";
			if (extFuncClass != null)
				ScriptableObject.defineClass(scriptable, extFuncClass);
			Function function = ctx.compileFunction(scriptable, script, CommonUtil.newId(), 0, null);
			
			Object[] contexts = null;
			if (context != null)
				contexts = new Object[] {context};
			String extFuncClassName = null;
			if (extFuncClass != null)
				extFuncClassName = CommonUtil.toClassName(extFuncClass);
			
			Scriptable local = null;
			if (extFuncClassName != null || (contexts != null && contexts.length != 0)) {
				local = ctx.newObject(scriptable, extFuncClassName, contexts);
			} else {
				local = ctx.newObject(scriptable);
			}
			
			Object res = function.call(ctx, local, local, new Object[0]);
			return res;
			
		} catch (SctException e) {
			throw e;
		} catch (Exception e) {
			throw new SctException(e);
		} finally {
			try {
				Context.exit();
			} catch (Exception e1) {
				logger.warn(e1, e1);
			}
		}
	}
	public boolean executeBoolean(String script, Object context) throws SctException {
		Object obj = execute(script, context);
		boolean bool = false;
		if (obj instanceof NativeJavaObject)
			obj = ((NativeJavaObject)obj).unwrap();
		bool = CommonUtil.toBoolean(obj);
		return bool;
	}
	private Class getExtFuncClass() throws Exception {
		if (extendedFunctionClass == null)
			return null;
		if (extFuncClass == null)
			extFuncClass = Class.forName(extendedFunctionClass);
		return extFuncClass;
	}
	public String getExtendedFunctionClass() {
		return extendedFunctionClass;
	}
	public void setExtendedFunctionClass(String extendedFunctionClassName) {
		this.extendedFunctionClass = extendedFunctionClassName;
	}

}