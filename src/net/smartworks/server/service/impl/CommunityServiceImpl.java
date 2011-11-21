package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import net.smartworks.server.service.ICommunityService;
import net.smartworks.util.SmartTest;
import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements ICommunityService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyDepartments(java.lang.String
	 * )
	 */
	@Override
	public DepartmentInfo[] getMyDepartments(String companyId, String userId) throws Exception {
		return SmartTest.getMyDepartments();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getDepartmentById(java.lang.String
	 * )
	 */
	@Override
	public Department getDepartmentById(String companyId, String departId) throws Exception {
		return SmartTest.getDepartmentById(departId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyGroups(java.lang.String)
	 */
	@Override
	public GroupInfo[] getMyGroups(String companyId, String userId) throws Exception {
		return SmartTest.getMyGroups();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getGroupById(java.lang.String)
	 */
	@Override
	public Group getGroupById(String companyId, String groupId) throws Exception {
		return SmartTest.getGroupById(groupId);
	}

	public Group setGroup(HttpServletRequest request) throws Exception {
		String groupName = request.getParameter("groupName");
		String groupDesc = request.getParameter("groupDesc");
		String groupLeader = request.getParameter("groupLeader");
		String groupOwner = request.getParameter("groupOwner");
		String[] groupMembers = request.getParameterValues("groupMembers");
		
		boolean isPublic = Boolean.getBoolean(request.getParameter("isPublic"));
		Group group = new Group();
		group.setName(groupName);
		group.setDesc(groupDesc);
		User leader = new User();
		leader.setId(groupLeader);
		group.setLeader(leader);
		User owner = new User();
		owner.setId(groupOwner);
		group.setOwner(owner);
		group.setPublic(isPublic);

		List list = new ArrayList();
		for(String str : groupMembers) {
			System.out.println(str);
			list.add(str);
		}

		return new Group("group1", groupName, new UserInfo[]{ SmartTest.getUserInfo1(), SmartTest.getUserInfo2(), SmartTest.getUserInfo3() }, leader);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getUserById(java.lang.String)
	 */
	@Override
	public User getUserById(String companyId, String userId) throws Exception {
		return SmartTest.getUserById(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#searchCommunityList(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public WorkSpaceInfo[] searchCommunity(String companyId, String userId, String key) throws Exception {
		return SmartTest.searchCommunity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#searchCommunityMemberList(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public UserInfo[] searchCommunityMember(String companyId, String communityId, String key) throws Exception {
		return SmartTest.searchCommunityMember();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getWorkSpaceById(java.lang.String
	 * )
	 */
	@Override
	public WorkSpace getWorkSpaceById(String companyId, String workSpaceId) throws Exception {
		return SmartTest.getWorkSpaceById(workSpaceId);
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getAvailableChatter()
	 */
	@Override
	public UserInfo[] getAvailableChatter(String companyId, String userId) throws Exception {
		return SmartTest.getAvailableChatter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#searchAvailableChatterList(java
	 * .lang.String)
	 */
	@Override
	public UserInfo[] searchAvailableChatter(String companyId, String userId, String key) throws Exception {
		return SmartTest.getAvailableChatter();
	}

	@Override
	public UserInfo[] searchUser(String companyId, String key) throws Exception {
		return SmartTest.getAvailableChatter();
	}

	@Override
	public CommunityInfo[] getMyCommunities(String companyId, String userId) throws Exception {
		return SmartTest.getMyCommunities();
	}

}
