package net.smartworks.server.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.GroupInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;

public interface ICommunityService {

	public abstract UserInfo[] searchCommunityMember(String communityId, String key) throws Exception;

	public abstract WorkSpaceInfo[] searchCommunity(String key) throws Exception;

	public abstract User getUserById(String userId) throws Exception;

	public abstract Group getGroupById(String groupId) throws Exception;

	public abstract GroupInfo[] getMyGroups() throws Exception;

	public abstract Group setGroup(HttpServletRequest request) throws Exception;

	public abstract Department getDepartmentById(String departmentId) throws Exception;

	public abstract DepartmentInfo[] getMyDepartments() throws Exception;

	public abstract WorkSpace getWorkSpaceById(String workSpaceId) throws Exception;

	public abstract UserInfo[] getAvailableChatter() throws Exception;

	public abstract UserInfo[] searchAvailableChatter(String key) throws Exception;

	public abstract UserInfo[] searchUser(String key) throws Exception;

	public abstract CommunityInfo[] getMyCommunities() throws Exception;

	public abstract String setMyProfile(HttpServletRequest request) throws Exception;
	
}