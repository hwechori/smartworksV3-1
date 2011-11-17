package net.smartworks.server.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.Community;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;

public interface ICommunityService {

	public abstract User[] searchCommunityMember(String companyId, String communityId, String key) throws Exception;

	public abstract WorkSpace[] searchCommunity(String companyId, String userId, String key) throws Exception;

	public abstract User getUserById(String companyId, String userId) throws Exception;

	public abstract Group getGroupById(String companyId, String groupId) throws Exception;

	public abstract Group[] getMyGroups(String companyId, String userId) throws Exception;

	public abstract Group setGroup(HttpServletRequest request) throws Exception;

	public abstract Department getDepartmentById(String companyId, String departId) throws Exception;

	public abstract Department[] getMyDepartments(String companyId, String userId) throws Exception;

	public abstract WorkSpace getWorkSpaceById(String companyId, String workSpaceId) throws Exception;

	public abstract User[] getAvailableChatter(String companyId, String userId) throws Exception;

	public abstract User[] searchAvailableChatter(String companyId, String userId, String key) throws Exception;

	public abstract User[] searchUser(String companyId, String key) throws Exception;

	public abstract Community[] getMyCommunities(String companyId, String userId) throws Exception;	
}
