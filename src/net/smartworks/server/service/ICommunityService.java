package net.smartworks.server.service;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.Community;
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

	public abstract UserInfo[] searchCommunityMember(String companyId, String communityId, String key) throws Exception;

	public abstract WorkSpaceInfo[] searchCommunity(String companyId, String userId, String key) throws Exception;

	public abstract User getUserById(String companyId, String userId) throws Exception;

	public abstract Group getGroupById(String companyId, String groupId) throws Exception;

	public abstract GroupInfo[] getMyGroups(String companyId, String userId) throws Exception;

	public abstract Group setGroup(HttpServletRequest request) throws Exception;

	public abstract Department getDepartmentById(String companyId, String departId) throws Exception;

	public abstract DepartmentInfo[] getMyDepartments(String companyId, String userId) throws Exception;

	public abstract WorkSpace getWorkSpaceById(String companyId, String workSpaceId) throws Exception;

	public abstract UserInfo[] getAvailableChatter(String companyId, String userId) throws Exception;

	public abstract UserInfo[] searchAvailableChatter(String companyId, String userId, String key) throws Exception;

	public abstract UserInfo[] searchUser(String companyId, String key) throws Exception;

	public abstract CommunityInfo[] getMyCommunities(String companyId, String userId) throws Exception;	

	public abstract String setMyProfile(HttpServletRequest request) throws Exception;
	
}
