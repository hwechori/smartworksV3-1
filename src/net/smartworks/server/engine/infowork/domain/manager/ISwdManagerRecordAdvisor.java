/*
 * $Id: ISwdManagerRecordAdvisor.java,v 1.1 2011/11/08 03:15:24 kmyu Exp $
 * created by    : admin
 * creation-date : 2008. 7. 14
 * =========================================================
 * Copyright (c) 2008 Miracom, Inc. All rights reserved.
 */
package net.smartworks.server.engine.infowork.domain.manager;

import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormLink;


public interface ISwdManagerRecordAdvisor {
	public void preGetRecord(String user, String domainId, String recordId, String level) throws Exception;
	public void preGetRecord(String user, SwdRecordCond cond, String level) throws Exception;
	public void preSetRecord(String user, SwdRecord obj, String level) throws Exception;
	public void preRemoveRecord(String user, String domainId, String recordId) throws Exception;
	public void preRemoveRecord(String user, SwdRecordCond cond) throws Exception;
	public void preGetRecordSize(String user, SwdRecordCond cond) throws Exception;
	public void preGetRecords(String user, SwdRecordCond cond, String level) throws Exception;
	
	public void preExecuteExpression(String user, String expression, SwdRecord self, SwfFormLink[] mappingForms) throws Exception;

	public void postGetRecord(String user, String domainId, String recordId, String level, SwdRecord res) throws Exception;
	public void postGetRecord(String user, SwdRecordCond cond, String level, SwdRecord res) throws Exception;
	public void postSetRecord(String user, SwdRecord obj, String level) throws Exception;
	public void postRemoveRecord(String user, String domainId, String recordId) throws Exception;
	public void postRemoveRecord(String user, SwdRecordCond cond) throws Exception;
	public void postGetRecordSize(String user, SwdRecordCond cond, long res) throws Exception;
	public void postGetRecords(String user, SwdRecordCond cond, String level, SwdRecord[] res) throws Exception;
	
	public void postExecuteExpression(String user, String expression, SwdRecord self, SwfFormLink[] mappingForms, String res) throws Exception;
}
