package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.searcher.model.SchUser;
import net.smartworks.server.engine.common.searcher.model.SchWorkspace;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.organization.model.SwoDepartment;
import net.smartworks.server.engine.organization.model.SwoUserExtend;
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
	public DepartmentInfo[] getMyDepartments() throws Exception {

		User user = SmartUtil.getCurrentUser();

		SwoUserExtend userExtend = SwManagerFactory.getInstance().getSwoManager().getUserExtend(user.getId(), user.getId());
		String myDeptId = userExtend.getDepartmentId();
		List<SwoDepartment> deptList = new ArrayList<SwoDepartment>();
		getDeptTreeByDeptId(deptList, myDeptId);
		DepartmentInfo[] deptInfos = new DepartmentInfo[deptList.size()];
		int index = deptList.size() - 1;
		for (int i = 0; i < deptList.size(); i++) {
			DepartmentInfo deptInfo = new DepartmentInfo();
			SwoDepartment swDept = deptList.get(i);
			deptInfo.setId(swDept.getId());
			deptInfo.setName(swDept.getName());
			deptInfo.setDesc(swDept.getDescription());
			deptInfos[index--] = deptInfo;
		}
		return deptInfos;
		
	}
	private void getDeptTreeByDeptId(List<SwoDepartment> deptList, String deptId) throws Exception {
		
		SwoDepartment dept = SwManagerFactory.getInstance().getSwoManager().getDepartment("", deptId, IManager.LEVEL_LITE);
		if (dept == null)
			return;
		deptList.add(dept);
		if (!dept.getParentId().equalsIgnoreCase("root")) {
			getDeptTreeByDeptId(deptList, dept.getParentId());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getDepartmentById(java.lang.String
	 * )
	 */
	@Override
	public Department getDepartmentById(String departId) throws Exception {
		return SmartTest.getDepartmentById(departId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyGroups(java.lang.String)
	 */
	@Override
	public GroupInfo[] getMyGroups() throws Exception {
		return SmartTest.getMyGroups();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getGroupById(java.lang.String)
	 */
	@Override
	public Group getGroupById(String groupId) throws Exception {
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
	public User getUserById(String userId) throws Exception {
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
	public WorkSpaceInfo[] searchCommunity(String key) throws Exception {
		
		if (CommonUtil.isEmpty(key))
			return null;

		User cUser = SmartUtil.getCurrentUser();

		SchWorkspace[] workSpaceInfos = SwManagerFactory.getInstance().getSchManager().getSchWorkspace(cUser.getCompanyId(), cUser.getId(), key);
		
		if (CommonUtil.isEmpty(workSpaceInfos))
			return null;
		
		List<DepartmentInfo> deptList = new ArrayList<DepartmentInfo>();
		List<GroupInfo> groupList = new ArrayList<GroupInfo>();
		List<UserInfo> userList = new ArrayList<UserInfo>();
		
		
		for (int i=0; i < workSpaceInfos.length; i++) {
			SchWorkspace workSpaceInfo = workSpaceInfos[i];
			
			String type = workSpaceInfo.getType();
			
			if (type.equalsIgnoreCase("user")) {
				UserInfo userInfo = new UserInfo();
				userInfo.setId(workSpaceInfo.getId());
				userInfo.setName(workSpaceInfo.getName());
				userInfo.setPosition(workSpaceInfo.getUserPosition());
				
				DepartmentInfo userDeptInfo = new DepartmentInfo();
				userDeptInfo.setId(workSpaceInfo.getUserDeptId());
				userDeptInfo.setName(workSpaceInfo.getUserDeptName());
				userDeptInfo.setDesc(workSpaceInfo.getUserDeptDesc());
				
				userInfo.setDepartment(userDeptInfo);
				
				userList.add(userInfo);
			} else if (type.equalsIgnoreCase("department")) {
				DepartmentInfo deptInfo = new DepartmentInfo();

				deptInfo.setId(workSpaceInfo.getId());
				deptInfo.setName(workSpaceInfo.getName());
				deptInfo.setDesc(workSpaceInfo.getDescription());
				
				deptList.add(deptInfo);
			} else if (type.equalsIgnoreCase("group")) {
				GroupInfo groupInfo = new GroupInfo();
				
				groupInfo.setId(workSpaceInfo.getId());
				groupInfo.setName(workSpaceInfo.getName());
				groupInfo.setDesc(workSpaceInfo.getDescription());
				
				groupList.add(groupInfo);
			}
		}
		
		WorkSpaceInfo[] schWorkspaces = new WorkSpaceInfo[deptList.size() + groupList.size() + userList.size()];
		
		int j = 0;
		
		for (int i = 0; i < deptList.size(); i++) {
			DepartmentInfo dept = deptList.get(i);
			schWorkspaces[j++] = dept;
		}
		for (int i = 0; i < groupList.size(); i++) {
			GroupInfo group = groupList.get(i);
			schWorkspaces[j++] = group;
		}
		for (int i = 0; i < userList.size(); i++) {
			UserInfo user = userList.get(i);
			schWorkspaces[j++] = user;
		}
		
		return schWorkspaces;
		
//		return SmartTest.searchCommunity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#searchCommunityMemberList(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public UserInfo[] searchCommunityMember(String communityId, String key) throws Exception {
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
	public WorkSpace getWorkSpaceById(String workSpaceId) throws Exception {
		return SmartTest.getWorkSpaceById(workSpaceId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getAvailableChatter()
	 */
	@Override
	public UserInfo[] getAvailableChatter() throws Exception {
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
	public UserInfo[] searchAvailableChatter(String key) throws Exception {
		return SmartTest.getAvailableChatter();
	}

	@Override
	public UserInfo[] searchUser(String key) throws Exception {
		if (CommonUtil.isEmpty(key))
			return null;

		User cUser = SmartUtil.getCurrentUser();

		SchUser[] schUsers = SwManagerFactory.getInstance().getSchManager().getSchUser(cUser.getCompanyId(), cUser.getId(), key);

		if (CommonUtil.isEmpty(schUsers))
			return null;

		List<UserInfo> userList = new ArrayList<UserInfo>();

		for(SchUser schUser : schUsers) {
			UserInfo userInfo = new UserInfo();
			userInfo.setId(schUser.getId());
			userInfo.setName(schUser.getName());
			userInfo.setPosition(schUser.getPosition());
			userInfo.setRole(schUser.getRoleId().equals("DEPT LEADER") ? User.USER_ROLE_LEADER : User.USER_ROLE_MEMBER);
			DepartmentInfo departmentInfo = new DepartmentInfo();
			departmentInfo.setId(schUser.getUserDeptId());
			departmentInfo.setName(schUser.getUserDeptName());
			departmentInfo.setDesc(schUser.getUserDeptDesc());
			userInfo.setDepartment(departmentInfo);
			userList.add(userInfo);
		}

		UserInfo[] userInfos = new UserInfo[userList.size()];
		userList.toArray(userInfos);

		return userInfos;

	}

	@Override
	public CommunityInfo[] getMyCommunities() throws Exception {
		return SmartTest.getMyCommunities();
	}

	@Override
	public String setMyProfile(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}