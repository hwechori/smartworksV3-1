/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MisUtil implements BeanFactoryAware {

	private static BeanFactory beanFactory;
	private static MisUtil misUtil = null;
	private Map processInstStatusMap = new HashMap();
	private Set processInstExecutedStatusSet = new HashSet();
	private Map taskDefTypeMap = new HashMap();
	private Map taskStatusMap = new HashMap();
	private Set taskExecutedStatusSet = new HashSet();
	private String dbDialect;
	private String defaultForm;
	public MisUtil() {
		super();
	}  
	public static String dbDialect() {
		return getMisUtil().getDbDialect();
	}
	public static String defaultForm() {
		return getMisUtil().getDefaultForm();
	} 
	public static Map taskDefTypeMap() {
		return getMisUtil().getTaskDefTypeMap();
	}
	public static Map taskStatusMap() {
		return getMisUtil().getTaskStatusMap();
	}
	public static Map processInstStatusMap() {
		return getMisUtil().getProcessInstStatusMap();
	}
	public static Set processInstExecutedStatusSet() {
		return getMisUtil().getProcessInstExecutedStatusSet();
	}
	public static Set taskExecutedStatusSet() {
		return getMisUtil().getTaskExecutedStatusSet();
	}
	public static MisUtil getMisUtil() {
		if (misUtil == null) {
			misUtil = (MisUtil)beanFactory.getBean("misUtil");
		}
		return misUtil;
	}
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		beanFactory = bf;
	}
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}
	public Map getTaskStatusMap() {
		return taskStatusMap;
	}
	public void setTaskStatusMap(Map taskStatusMap) {
		this.taskStatusMap = taskStatusMap;
	}
	public Map getProcessInstStatusMap() {
		return processInstStatusMap;
	}
	public void setProcessInstStatusMap(Map processInstStatusMap) {
		this.processInstStatusMap = processInstStatusMap;
	}
	public Set getTaskExecutedStatusSet() {
		return taskExecutedStatusSet;
	}
	public void setTaskExecutedStatusSet(Set taskExecutedStatusSet) {
		this.taskExecutedStatusSet = taskExecutedStatusSet;
	}
	public Map getTaskDefTypeMap() {
		return taskDefTypeMap;
	}
	public void setTaskDefTypeMap(Map taskDefTypeMap) {
		this.taskDefTypeMap = taskDefTypeMap;
	}
	public Set getProcessInstExecutedStatusSet() {
		return processInstExecutedStatusSet;
	}
	public void setProcessInstExecutedStatusSet(Set processInstExecutedStatusSet) {
		this.processInstExecutedStatusSet = processInstExecutedStatusSet;
	}
	public String getDefaultForm() {
		return defaultForm;
	}
	public void setDefaultForm(String defaultForm) {
		this.defaultForm = defaultForm;
	}
	public String getDbDialect() {
		return dbDialect;
	}
	public void setDbDialect(String dbDialect) {
		this.dbDialect = dbDialect;
	}

}