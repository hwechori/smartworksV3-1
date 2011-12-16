/*
 * $Id: AbstractSwdManagerAdvisor.java,v 1.1 2011/11/08 03:15:24 kmyu Exp $
 * created by    : myjung
 * creation-date : 2008. 2. 24.
 * =========================================================
 * Copyright (c) 2008 Miracom, Inc. All rights reserved.
 */
package net.smartworks.server.engine.infowork.domain.manager;

import net.smartworks.server.engine.infowork.domain.exception.SwdException;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormLink;
import net.smartworks.server.engine.process.task.exception.TskException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AbstractSwdManagerAdvisor implements ISwdManagerRecordAdvisor {
	protected final Log logger = LogFactory.getLog(getClass());
	private static String M_GETRECORD = "getRecord";
	private static String M_SETRECORD = "setRecord";
	private static String M_REMOVERECORD = "removeRecord";
	private static String M_GETRECORDSIZE = "getRecordSize";
	private static String M_GETRECORDS= "getRecords";
	private static String M_EXECUTEEXPRESSION = "executeExpression";

	public AbstractSwdManagerAdvisor() {
		super();
	}

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		String methodName = joinPoint.getSignature().getName();
		
		try {
			if (methodName.equals(M_GETRECORD)) {
				if (args[1] instanceof String) {
					this.preGetRecord((String)args[0], (String)args[1], (String)args[2], (String)args[3]);
				} else if (args[1] instanceof SwdRecordCond) {
					this.preGetRecord((String)args[0], (SwdRecordCond)args[1], (String)args[2]);
				}
			} else if (methodName.equals(M_SETRECORD)) {
				this.preSetRecord((String)args[0], (SwdRecord)args[1], (String)args[2]);
			} else if (methodName.equals(M_REMOVERECORD)) {
				if (args[1] instanceof String) {
					this.preRemoveRecord((String)args[0], (String)args[1], (String)args[2]);
				} else if (args[1] instanceof SwdRecordCond) {
					this.preRemoveRecord((String)args[0], (SwdRecordCond)args[1]);
				}
			} else if (methodName.equals(M_GETRECORDSIZE)) {
				this.preGetRecordSize((String)args[0], (SwdRecordCond)args[1]);
			} else if (methodName.equals(M_GETRECORDS)) {
				this.preGetRecords((String)args[0], (SwdRecordCond)args[1], (String)args[2]);
			} else if (methodName.equals(M_EXECUTEEXPRESSION)) {
				this.preExecuteExpression((String)args[0], (String)args[1], (SwdRecord)args[2], (SwfFormLink[])args[3]);
			}

			Object res = joinPoint.proceed();
			
			if (methodName.equals(M_GETRECORD)) {
				if (args[1] instanceof String) {
					this.postGetRecord((String)args[0], (String)args[1], (String)args[2], (String)args[3], (SwdRecord)res);
				} else if (args[1] instanceof SwdRecordCond) {
					this.postGetRecord((String)args[0], (SwdRecordCond)args[1], (String)args[2], (SwdRecord)res);
				}
			} else if (methodName.equals(M_SETRECORD)) {
				this.postSetRecord((String)args[0], (SwdRecord)args[1], (String)args[2]);
			} else if (methodName.equals(M_REMOVERECORD)) {
				if (args[1] instanceof String) {
					this.postRemoveRecord((String)args[0], (String)args[1], (String)args[2]);
				} else if (args[1] instanceof SwdRecordCond) {
					this.postRemoveRecord((String)args[0], (SwdRecordCond)args[1]);
				}
			} else if (methodName.equals(M_GETRECORDSIZE)) {
				this.postGetRecordSize((String)args[0], (SwdRecordCond)args[1], ((Long)res).longValue());
			} else if (methodName.equals(M_GETRECORDS)) {
				this.postGetRecords((String)args[0], (SwdRecordCond)args[1], (String)args[2], (SwdRecord[])res);
			} else if (methodName.equals(M_EXECUTEEXPRESSION)) {
				this.postExecuteExpression((String)args[0], (String)args[1], (SwdRecord)args[2], (SwfFormLink[])args[3], (String)res);
			}
			
			return res;
			
		} catch (SwdException e) {
			throw e;
		} catch (Throwable t) {
			logger.error(t, t);
			throw new TskException(t);
		}
	}
	
	public void preGetRecord(String user, String domainId, String recordId, String level) throws Exception {
	}
	public void preGetRecord(String user, SwdRecordCond cond, String level) throws Exception {
	}
	public void preSetRecord(String user, SwdRecord obj, String level) throws Exception {
	}
	public void preRemoveRecord(String user, String domainId, String recordId) throws Exception {
	}
	public void preRemoveRecord(String user, SwdRecordCond cond) throws Exception {
	}
	public void preGetRecordSize(String user, SwdRecordCond cond) throws Exception {
	}
	public void preGetRecords(String user, SwdRecordCond cond, String level) throws Exception {
	}
	
	public void preExecuteExpression(String user, String expression, SwdRecord self, SwfFormLink[] mappingForms) throws Exception {
	}
	
	public void postGetRecord(String user, String domainId, String recordId, String level, SwdRecord res) throws Exception {
	}
	public void postGetRecord(String user, SwdRecordCond cond, String level, SwdRecord res) throws Exception {
	}
	public void postSetRecord(String user, SwdRecord obj, String level) throws Exception {
	}
	public void postRemoveRecord(String user, String domainId, String recordId) throws Exception {
	}
	public void postRemoveRecord(String user, SwdRecordCond cond) throws Exception {
	}
	public void postGetRecordSize(String user, SwdRecordCond cond, long res) throws Exception {
	}
	public void postGetRecords(String user, SwdRecordCond cond, String level, SwdRecord[] res) throws Exception {
	}
	
	public void postExecuteExpression(String user, String expression, SwdRecord self, SwfFormLink[] mappingForms, String res) throws Exception {
	}
}
