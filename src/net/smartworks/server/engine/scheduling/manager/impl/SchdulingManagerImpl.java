/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 12. 20.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.scheduling.manager.impl;

import net.smartworks.server.engine.docfile.exception.DocFileException;
import net.smartworks.server.engine.docfile.manager.IDocFileManager;
import net.smartworks.server.engine.factory.SwManagerFactory;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SchdulingManagerImpl implements Job {

	private IDocFileManager getDocManager() {
		return SwManagerFactory.getInstance().getDocManager();
	}
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String name = context.getJobDetail().getName();
		String returnValue = "";
		if(name.equals("tempFileDelete")) {
			try {
				returnValue = getDocManager().deleteTempFile();
			} catch (DocFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("returnValue = ++++++++++++++++++++++++++++++++++++++++++ " + returnValue);

	}

} 