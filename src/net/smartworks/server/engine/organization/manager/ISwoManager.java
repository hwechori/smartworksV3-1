/*	
 * $Id$
 * created by    : hsshin
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
import net.smartworks.server.engine.organization.model.SwoTeam;
import net.smartworks.server.engine.organization.model.SwoTeamCond;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.organization.model.SwoUserCond;

public interface ISwoManager {

	public abstract SwoContact getContact(String userId, String id, String level) throws SwoException;

	public abstract SwoContact getContact(String userId, SwoContactCond cond, String level) throws SwoException;

	public abstract void setContact(String userId, SwoContact obj, String level) throws SwoException;

	public abstract void createContact(String userId, SwoContact obj) throws SwoException;

	public abstract void removeContact(String userId, String id) throws SwoException;

	public abstract void removeContact(String userId, SwoContactCond cond) throws SwoException;

	public abstract long getContactSize(String userId, SwoContactCond cond) throws SwoException;

	public abstract SwoContact[] getContacts(String userId, SwoContactCond cond, String level) throws SwoException;

	public abstract SwoCompany getCompany(String userId, String id, String level) throws SwoException;

	public abstract SwoCompany getCompany(String userId, SwoCompanyCond cond, String level) throws SwoException;

	public abstract void setCompany(String userId, SwoCompany obj, String level) throws SwoException;

	public abstract void createCompany(String userId, SwoCompany obj) throws SwoException;

	public abstract void removeCompany(String userId, String id) throws SwoException;

	public abstract void removeCompany(String userId, SwoCompanyCond cond) throws SwoException;

	public abstract long getCompanySize(String userId, SwoCompanyCond cond) throws SwoException;

	public abstract SwoCompany[] getCompanys(String userId, SwoCompanyCond cond, String level) throws SwoException;

	public abstract SwoAuthority getAuthority(String userId, String id, String level) throws SwoException;

	public abstract SwoAuthority getAuthority(String userId, SwoAuthorityCond cond, String level) throws SwoException;

	public abstract void setAuthority(String userId, SwoAuthority obj, String level) throws SwoException;

	public abstract void createAuthority(String userId, SwoAuthority obj) throws SwoException;

	public abstract void removeAuthority(String userId, String id) throws SwoException;

	public abstract void removeAuthority(String userId, SwoAuthorityCond cond) throws SwoException;

	public abstract long getAuthoritySize(String userId, SwoAuthorityCond cond) throws SwoException;

	public abstract SwoAuthority[] getAuthoritys(String userId, SwoAuthorityCond cond, String level) throws SwoException;

	public abstract SwoDepartment getDepartment(String userId, String id, String level) throws SwoException;

	public abstract SwoDepartment getDepartment(String userId, SwoDepartmentCond cond, String level) throws SwoException;

	public abstract void setDepartment(String userId, SwoDepartment obj, String level) throws SwoException;

	public abstract void createDepartment(String userId, SwoDepartment obj) throws SwoException;

	public abstract void removeDepartment(String userId, String id) throws SwoException;

	public abstract void removeDepartment(String userId, SwoDepartmentCond cond) throws SwoException;

	public abstract long getDepartmentSize(String userId, SwoDepartmentCond cond) throws SwoException;

	public abstract SwoDepartment[] getDepartments(String userId, SwoDepartmentCond cond, String level) throws SwoException;

	public abstract SwoUser getUser(String userId, String id, String level) throws SwoException;

	public abstract SwoUser getUser(String userId, SwoUserCond cond, String level) throws SwoException;

	public abstract void setUser(String userId, SwoUser obj, String level) throws SwoException;

	public abstract void createUser(String userId, SwoUser obj) throws SwoException;

	public abstract void removeUser(String userId, String id) throws SwoException;

	public abstract void removeUser(String userId, SwoUserCond cond) throws SwoException;

	public abstract long getUserSize(String userId, SwoUserCond cond) throws SwoException;

	//사원찾기
	public abstract SwoUser[] getSearchUsers(String userId, SwoUserCond cond, String level) throws SwoException;

	public abstract SwoUser[] getUsers(String userId, SwoUserCond cond, String level) throws SwoException;

	public abstract String getDefaultLogo() throws SwoException;

	public abstract String getLogo(String user, String companyId) throws SwoException;

	public abstract void setLogo(String user, String companyId, String pictureName) throws SwoException;

	public abstract void createLogo(String user, String companyId, String pictureName) throws SwoException;

	public abstract SwoConfig getConfig(String user, String id, String level) throws SwoException;

	public abstract SwoConfig getConfig(String user, SwoConfigCond cond, String level) throws SwoException;

	public abstract void setConfig(String user, SwoConfig obj, String level) throws SwoException;

	public abstract void createConfig(String user, SwoConfig obj) throws SwoException;

	public abstract void removeConfig(String user, String id) throws SwoException;

	public abstract void removeConfig(String user, SwoConfigCond cond) throws SwoException;

	public abstract long getConfigSize(String user, SwoConfigCond cond) throws SwoException;

	public abstract SwoConfig[] getConfigs(String user, SwoConfigCond cond, String level) throws SwoException;

	public abstract SwoTeam getTeam(String user, String id, String level) throws SwoException;

	public abstract SwoTeam getTeam(String user, SwoTeamCond cond, String level) throws SwoException;

	public abstract void setTeam(String user, SwoTeam obj, String level) throws SwoException;

	public abstract void createTeam(String user, SwoTeam obj) throws SwoException;

	public abstract void removeTeam(String user, String id) throws SwoException;

	public abstract void removeTeam(String user, SwoTeamCond cond) throws SwoException;

	public abstract long getTeamSize(String user, SwoTeamCond cond) throws SwoException;

	public abstract SwoTeam[] getTeams(String user, SwoTeamCond cond, String level) throws SwoException;

	public abstract List getOrganization(String deptId) throws SwoException;

}