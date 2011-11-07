/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.manager;

import java.util.List;

import net.smartworks.server.engine.common.manager.IManager;
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

public interface ISwoManager extends IManager {

	//연락처 "md_802be6e0b5f6484ea9c1ed57700c5b5e"
	public SwoContact getContact(String user, String id, String level) throws SwoException;
	public SwoContact getContact(String user, SwoContactCond cond, String level) throws SwoException;
	public void setContact(String user, SwoContact obj, String level) throws SwoException;
	public void createContact(String user, SwoContact obj) throws SwoException;
	public void removeContact(String user, String id) throws SwoException;
	public void removeContact(String user, SwoContactCond cond) throws SwoException;
	public long getContactSize(String user, SwoContactCond cond) throws SwoException;
	public SwoContact[] getContacts(String user, SwoContactCond cond, String level) throws SwoException;
	
	//회사 "md_a55ee2455d55444b96e5730e4ed9e6b1"
	public SwoCompany getCompany(String user, String id, String level) throws SwoException;
	public SwoCompany getCompany(String user, SwoCompanyCond cond, String level) throws SwoException;
	public void setCompany(String user, SwoCompany obj, String level) throws SwoException;
	public void createCompany(String user, SwoCompany obj) throws SwoException;
	public void removeCompany(String user, String id) throws SwoException;
	public void removeCompany(String user, SwoCompanyCond cond) throws SwoException;
	public long getCompanySize(String user, SwoCompanyCond cond) throws SwoException;
	public SwoCompany[] getCompanys(String user, SwoCompanyCond cond, String level) throws SwoException;
	
	//역할 "md_6587facdd4de4f94beebfa61f7c3cd93"
	public SwoAuthority getAuthority(String user, String id, String level) throws SwoException;
	public SwoAuthority getAuthority(String user, SwoAuthorityCond cond, String level) throws SwoException;
	public void setAuthority(String user, SwoAuthority obj, String level) throws SwoException;
	public void createAuthority(String user, SwoAuthority obj) throws SwoException;
	public void removeAuthority(String user, String id) throws SwoException;
	public void removeAuthority(String user, SwoAuthorityCond cond) throws SwoException;
	public long getAuthoritySize(String user, SwoAuthorityCond cond) throws SwoException;
	public SwoAuthority[] getAuthoritys(String user, SwoAuthorityCond cond, String level) throws SwoException;

	//부서 "md_6404fb24f1ba47f4a535996426c2186a"
	public SwoDepartment getDepartment(String user, String id, String level) throws SwoException;
	public SwoDepartment getDepartment(String user, SwoDepartmentCond cond, String level) throws SwoException;
	public void setDepartment(String user, SwoDepartment obj, String level) throws SwoException;
	public void createDepartment(String user, SwoDepartment obj) throws SwoException;
	public void removeDepartment(String user, String id) throws SwoException;
	public void removeDepartment(String user, SwoDepartmentCond cond) throws SwoException;
	public long getDepartmentSize(String user, SwoDepartmentCond cond) throws SwoException;
	public SwoDepartment[] getDepartments(String user, SwoDepartmentCond cond, String level) throws SwoException;
	
	//사용자 "md_87fce51a61d04e779d4d946c72b7a815"
	public SwoUser getUser(String user, String id, String level) throws SwoException;
	public SwoUser getUser(String user, SwoUserCond cond, String level) throws SwoException;
	public void setUser(String userId, SwoUser obj, String level) throws SwoException;
	public void createUser(String userId, SwoUser obj) throws SwoException;
	public void removeUser(String user, String id) throws SwoException;
	public void removeUser(String user, SwoUserCond cond) throws SwoException;
	public long getUserSize(String user, SwoUserCond cond) throws SwoException;
	public SwoUser[] getUsers(String user, SwoUserCond cond, String level) throws SwoException;
	public SwoUser[] getSearchUsers(String user, SwoUserCond cond, String level) throws SwoException;
	
	public String getDefaultLogo() throws SwoException;
	public String getLogo(String user, String companyId) throws SwoException;
	public void setLogo(String user, String companyId, String pictureName) throws SwoException;
	public void createLogo(String user, String companyId, String pictureName) throws SwoException;
	
	//메일 설정
	public SwoConfig getConfig(String user, String id, String level) throws SwoException;
	public SwoConfig getConfig(String user, SwoConfigCond cond, String level) throws SwoException;
	public void setConfig(String user, SwoConfig obj, String level) throws SwoException;
	public void removeConfig(String user, String id) throws SwoException;
	public void removeConfig(String user, SwoConfigCond cond) throws SwoException;
	public long getConfigSize(String user, SwoConfigCond cond) throws SwoException;
	public SwoConfig[] getConfigs(String user, SwoConfigCond cond, String level) throws SwoException;

	//팀
	public SwoTeam getTeam(String user, String id, String level) throws SwoException;
	public SwoTeam getTeam(String user, SwoTeamCond cond, String level) throws SwoException;
	public void createTeam(String user, SwoTeam obj) throws SwoException;
	public void setTeam(String user, SwoTeam obj, String level) throws SwoException;
	public void removeTeam(String user, String id) throws SwoException;
	public void removeTeam(String user, SwoTeamCond cond) throws SwoException;
	public long getTeamSize(String user, SwoTeamCond cond) throws SwoException;
	public SwoTeam[] getTeams(String user, SwoTeamCond cond, String level) throws SwoException;
	
	//조직도
	public List getOrganization(String deptId) throws SwoException;

}