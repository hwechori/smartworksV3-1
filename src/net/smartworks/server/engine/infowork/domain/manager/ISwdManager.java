/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.domain.manager;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Cond;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.infowork.domain.exception.SwdException;
import net.smartworks.server.engine.infowork.domain.model.SwdDataRef;
import net.smartworks.server.engine.infowork.domain.model.SwdDataRefCond;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdField;
import net.smartworks.server.engine.infowork.domain.model.SwdFieldCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormLink;

public interface ISwdManager extends IManager {

	public List executeSqlQuery(String qStr, Property[] params, Cond cond) throws SwdException;

	public SwdDomain getDomain(String user, String objId, String level) throws SwdException;
	public SwdDomain getDomain(String user, SwdDomainCond cond, String level) throws SwdException;
	public void setDomain(String user, SwdDomain obj, String level) throws SwdException;
	public void removeDomain(String user, String objId) throws SwdException;
	public long getDomainSize(String user, SwdDomainCond cond) throws SwdException;
	public SwdDomain[] getDomains(String user, SwdDomainCond cond, String level) throws SwdException;
	
	public long getFieldSize(String user, SwdFieldCond cond) throws SwdException;
	public SwdField[] getFields(String user, SwdFieldCond cond, String level) throws SwdException;

	public SwdRecord getRecord(String user, String domainId, String recordId, String level) throws SwdException;
	public SwdRecord getRecord(String user, SwdRecordCond cond, String level) throws SwdException;
	public void setRecord(String user, SwdRecord obj, String level) throws SwdException;
	public void removeRecord(String user, String domainId, String recordId) throws SwdException;
	public void removeRecord(String user, SwdRecordCond cond) throws SwdException;
	public long getRecordSize(String user, SwdRecordCond cond) throws SwdException;
	public double getRecordValue(String user, String field, String func, SwdRecordCond cond) throws SwdException;
	public SwdRecord[] getRecords(String user, SwdRecordCond cond, String level) throws SwdException;

	public SwdDataRef getDataRef(String user, String objId, String level) throws SwdException;
	public void setDataRef(String user, SwdDataRef obj, String level) throws SwdException;
	public void removeDataRef(String user, String objId) throws SwdException;
	public long getDataRefSize(String user, SwdDataRefCond cond) throws SwdException;
	public SwdDataRef[] getDataRefs(String user, SwdDataRefCond cond, String level) throws SwdException;

	/**
	 * 이전 매핑을 처리합니다.
	 * @param user
	 * @param form
	 * @param self
	 * @param context
	 * @throws SwdException
	 */
	public void preFieldMapping(String user, SwfForm form, SwdRecord self, Map context) throws SwdException;
	public void preFieldMapping(String user, SwfForm form, SwdRecord[] selfs, Map context) throws SwdException;
	/**
	 * 이후 매핑을 처리합니다.
	 * @param user
	 * @param form
	 * @param self
	 * @param context
	 * @throws SwdException
	 */
	public void postFieldMapping(String user, SwfForm form, SwdRecord self, Map context) throws SwdException;
	/**
	 * 매핑 폼 조건에 맞는 레코드를 반환합니다.
	 * @param user
	 * @param self
	 * @param mappingForm
	 * @return
	 * @throws SwdException
	 */
	public SwdRecord getRecordByMappingForm(String user, SwdRecord self, SwfFormLink mappingForm) throws SwdException;
	public double getRecordValueByMappingForm(String user, SwdRecord self, SwfFormLink mappingForm, String field, String func) throws SwdException;
	public SwdRecord[] getRecordsByMappingForm(String user, SwdRecord self, SwfFormLink mappingForm) throws SwdException;
	public String executeExpression(String user, String expression, SwdRecord self, SwfFormLink[] mappingForms) throws SwdException;
	
	public List<String> getDomainTableColumnNameList(String user, String table) throws SwdException;
	public void addTableColumn(String user, String table, String columnName, String type) throws SwdException;

}
