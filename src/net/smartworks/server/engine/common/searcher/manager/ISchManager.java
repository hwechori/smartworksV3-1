/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 6.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.searcher.manager;

import net.smartworks.server.engine.common.searcher.exception.SchException;
import net.smartworks.server.engine.common.searcher.model.SchDepartment;
import net.smartworks.server.engine.common.searcher.model.SchUser;
import net.smartworks.server.engine.common.searcher.model.SchWorkspace;

public interface ISchManager {

	public SchWorkspace[] getSchWorkspace(String companyId, String userid, String key) throws SchException;

	public SchUser[] getSchUser(String companyId, String cUserId, String key) throws SchException;

	public SchWorkspace getWorkspaceById(String companyId, String cUserId, String workSpaceId) throws SchException;

	public SchDepartment getDepartmentById(String companyId, String cUserId, String departId) throws Exception;

	public SchUser getUserById(String companyId, String cUserId, String userId) throws Exception;

}