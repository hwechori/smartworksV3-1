/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 3. 19.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.opinion.manager;

import net.smartworks.server.engine.opinion.exception.OpinionException;
import net.smartworks.server.engine.opinion.model.Opinion;
import net.smartworks.server.engine.opinion.model.OpinionCond;

public interface IOpinionManager {

	public Opinion getOpinion(String user, String objId, String level) throws OpinionException;
	public Opinion getOpinion(String user, OpinionCond cond, String level) throws OpinionException;
	public void setOpinion(String user, Opinion obj, String level) throws OpinionException;
	public void createOpinion(String user, Opinion obj) throws OpinionException;
	public void removeOpinion(String user, String objId) throws OpinionException;
	public void removeOpinion(String user, OpinionCond cond) throws OpinionException;
	public long getOpinionSize(String user, OpinionCond cond) throws OpinionException;
	public Opinion[] getOpinions(String user, OpinionCond cond, String level) throws OpinionException;

}