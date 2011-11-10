package net.smartworks.server.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.Community;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;

public interface ICommunityService {

	public abstract User[] searchCommunityMember(String communityId, String key) throws Exception;

	public abstract WorkSpace[] searchCommunity(String key) throws Exception;

	public abstract User getUserById(String userId) throws Exception;

	public abstract Group getGroupById(String groupId) throws Exception;

	public abstract Group[] getMyGroups() throws Exception;

	public abstract Group setGroup(HttpServletRequest request) throws Exception;

	public abstract Department getDepartmentById(String departId) throws Exception;

	public abstract Department[] getMyDepartments() throws Exception;

	public abstract WorkSpace getWorkSpaceById(String workSpaceId) throws Exception;

	public abstract User[] getAvailableChatter() throws Exception;

	public abstract User[] searchAvailableChatter(String key) throws Exception;

	public abstract User[] searchUser(String key) throws Exception;

	public abstract Community[] getMyCommunities() throws Exception;	
}
