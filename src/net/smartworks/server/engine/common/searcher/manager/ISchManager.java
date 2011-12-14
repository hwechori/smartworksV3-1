/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 6.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.searcher.manager;

import net.smartworks.server.engine.common.searcher.exception.SchException;
import net.smartworks.server.engine.common.searcher.model.SchWorkspace;

public interface ISchManager {

	public SchWorkspace[] getSchWorkspace(String companyId, String userid, String key) throws SchException;
	
}