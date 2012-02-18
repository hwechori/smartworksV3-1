/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.manager;

import java.util.List;

import net.smartworks.server.engine.organization.exception.SwoException;
import net.smartworks.server.engine.organization.model.SwoAuthority;
import net.smartworks.server.engine.organization.model.SwoAuthorityCond;
import net.smartworks.server.engine.organization.model.SwoCompany;
import net.smartworks.server.engine.organization.model.SwoCompanyCond;
import net.smartworks.server.engine.organization.model.SwoConfig;
import net.smartworks.server.engine.organization.model.SwoConfigCond;
import net.smartworks.server.engine.organization.model.SwoContact;
import net.smartworks.server.engine.organization.model.SwoContactCond;
import net.smartworks.server.engine.organization.model.SwoDepartment;
import net.smartworks.server.engine.organization.model.SwoDepartmentCond;
import net.smartworks.server.engine.organization.model.SwoDepartmentExtend;
import net.smartworks.server.engine.organization.model.SwoGroup;
import net.smartworks.server.engine.organization.model.SwoGroupCond;
import net.smartworks.server.engine.organization.model.SwoTeam;
import net.smartworks.server.engine.organization.model.SwoTeamCond;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.organization.model.SwoUserCond;
import net.smartworks.server.engine.organization.model.SwoUserExtend;

public interface ISwoManager {

	public SwoContact getContact(String userId, String id, String level) throws SwoException;

	public SwoContact getContact(String userId, SwoContactCond cond, String level) throws SwoException;

	public void setContact(String userId, SwoContact obj, String level) throws SwoException;

	public void createContact(String userId, SwoContact obj) throws SwoException;

	public void removeContact(String userId, String id) throws SwoException;

	public void removeContact(String userId, SwoContactCond cond) throws SwoException;

	public long getContactSize(String userId, SwoContactCond cond) throws SwoException;

	public SwoContact[] getContacts(String userId, SwoContactCond cond, String level) throws SwoException;

	public SwoCompany getCompany(String userId, String id, String level) throws SwoException;

	public SwoCompany getCompany(String userId, SwoCompanyCond cond, String level) throws SwoException;

	public void setCompany(String userId, SwoCompany obj, String level) throws SwoException;

	public void createCompany(String userId, SwoCompany obj) throws SwoException;

	public void removeCompany(String userId, String id) throws SwoException;

	public void removeCompany(String userId, SwoCompanyCond cond) throws SwoException;

	public long getCompanySize(String userId, SwoCompanyCond cond) throws SwoException;

	public SwoCompany[] getCompanys(String userId, SwoCompanyCond cond, String level) throws SwoException;

	public SwoAuthority getAuthority(String userId, String id, String level) throws SwoException;

	public SwoAuthority getAuthority(String userId, SwoAuthorityCond cond, String level) throws SwoException;

	public void setAuthority(String userId, SwoAuthority obj, String level) throws SwoException;

	public void createAuthority(String userId, SwoAuthority obj) throws SwoException;

	public void removeAuthority(String userId, String id) throws SwoException;

	public void removeAuthority(String userId, SwoAuthorityCond cond) throws SwoException;

	public long getAuthoritySize(String userId, SwoAuthorityCond cond) throws SwoException;

	public SwoAuthority[] getAuthoritys(String userId, SwoAuthorityCond cond, String level) throws SwoException;

	public SwoDepartment getDepartment(String userId, String id, String level) throws SwoException;

	public SwoDepartment getDepartment(String userId, SwoDepartmentCond cond, String level) throws SwoException;

	public void setDepartment(String userId, SwoDepartment obj, String level) throws SwoException;

	public void createDepartment(String userId, SwoDepartment obj) throws SwoException;

	public void removeDepartment(String userId, String id) throws SwoException;

	public void removeDepartment(String userId, SwoDepartmentCond cond) throws SwoException;

	public long getDepartmentSize(String userId, SwoDepartmentCond cond) throws SwoException;

	public SwoDepartment[] getDepartments(String userId, SwoDepartmentCond cond, String level) throws SwoException;

	public SwoUser getUser(String userId, String id, String level) throws SwoException;

	public SwoUser getUser(String userId, SwoUserCond cond, String level) throws SwoException;

	public void setUser(String userId, SwoUser obj, String level) throws SwoException;

	public void createUser(String userId, SwoUser obj) throws SwoException;

	public void removeUser(String userId, String id) throws SwoException;

	public void removeUser(String userId, SwoUserCond cond) throws SwoException;

	public long getUserSize(String userId, SwoUserCond cond) throws SwoException;

	public boolean isExistId(String userId) throws SwoException;

	//사원찾기
	public SwoUser[] getSearchUsers(String userId, SwoUserCond cond, String level) throws SwoException;

	public SwoUser[] getUsers(String userId, SwoUserCond cond, String level) throws SwoException;
	
	public SwoUserExtend getUserExtend(String userId, String id, boolean inMemory) throws SwoException;
	
	public SwoUserExtend[] getUsersExtend(String userId, String[] ids) throws SwoException;

	public SwoDepartmentExtend getDepartmentExtend(String userId, String departmentId, boolean inMemory) throws SwoException;

	public SwoUserExtend[] getUsersOfDepartment(String userId, String departmentId) throws SwoException;

	public SwoDepartmentExtend[] getChildrenOfDepartment(String userId, String departmentId) throws SwoException;

	public String getDefaultLogo() throws SwoException;

	public String getLogo(String user, String companyId) throws SwoException;

	public void setLogo(String user, String companyId, String pictureName) throws SwoException;

	public void createLogo(String user, String companyId, String pictureName) throws SwoException;

	public SwoConfig getConfig(String user, String id, String level) throws SwoException;

	public SwoConfig getConfig(String user, SwoConfigCond cond, String level) throws SwoException;

	public void setConfig(String user, SwoConfig obj, String level) throws SwoException;

	public void createConfig(String user, SwoConfig obj) throws SwoException;

	public void removeConfig(String user, String id) throws SwoException;

	public void removeConfig(String user, SwoConfigCond cond) throws SwoException;

	public long getConfigSize(String user, SwoConfigCond cond) throws SwoException;

	public SwoConfig[] getConfigs(String user, SwoConfigCond cond, String level) throws SwoException;

	public SwoTeam getTeam(String user, String id, String level) throws SwoException;

	public SwoTeam getTeam(String user, SwoTeamCond cond, String level) throws SwoException;

	public void setTeam(String user, SwoTeam obj, String level) throws SwoException;

	public void createTeam(String user, SwoTeam obj) throws SwoException;

	public void removeTeam(String user, String id) throws SwoException;

	public void removeTeam(String user, SwoTeamCond cond) throws SwoException;

	public long getTeamSize(String user, SwoTeamCond cond) throws SwoException;

	public SwoTeam[] getTeams(String user, SwoTeamCond cond, String level) throws SwoException;

	public List getOrganization(String deptId) throws SwoException;

	public String getUserDispName(String userId) throws SwoException;

	public SwoUserExtend[] getAllComsByDepartmentId(String departmentId, boolean departmentOnly) throws SwoException;

	public String getTypeByWorkspaceId(String workspaceId) throws SwoException;

	public SwoGroup getGroup(String user, String id, String level) throws SwoException;

	public SwoGroup getGroup(String user, SwoGroupCond cond, String level) throws SwoException;

	public void setGroup(String user, SwoGroup obj, String level) throws SwoException;

	public void createGroup(String user, SwoGroup obj) throws SwoException;

	public void removeGroup(String user, String id) throws SwoException;

	public void removeGroup(String user, SwoGroupCond cond) throws SwoException;

	public long getGroupSize(String user, SwoGroupCond cond) throws SwoException;

	public SwoGroup[] getGroups(String user, SwoGroupCond cond, String level) throws SwoException;

	public void createGroupMember(String user, String groupId, String userId, String joinType) throws SwoException;

	public void setGroupMember(String user, String groupId, String userId) throws SwoException;

}