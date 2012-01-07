/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 12. 6.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.searcher.manager.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.smartworks.model.community.User;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.searcher.exception.SchException;
import net.smartworks.server.engine.common.searcher.manager.ISchManager;
import net.smartworks.server.engine.common.searcher.model.SchDepartment;
import net.smartworks.server.engine.common.searcher.model.SchUser;
import net.smartworks.server.engine.common.searcher.model.SchWorkspace;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class SchManagerImpl extends AbstractManager implements ISchManager {

	public SchWorkspace[] getSchWorkspace(String companyId, String userid, String key) throws SchException {

		if (CommonUtil.isEmpty(key)) 
			return null;
		
		StringBuffer queryBuffer = new StringBuffer();
		
		queryBuffer.append(" select *  ");
		queryBuffer.append(" from  ");
		queryBuffer.append(" ( ");
		queryBuffer.append(" 	select 'user' as type ");
		queryBuffer.append(" 		, usr.id, usr.name ");
		queryBuffer.append(" 		, '' as description ");
		queryBuffer.append(" 		, usr.pos as userPosition ");
		queryBuffer.append(" 		, usr.picture as userPicture ");
		queryBuffer.append(" 		, dept.id as userDeptId ");
		queryBuffer.append(" 		, dept.name as userDeptName ");
		queryBuffer.append(" 		, dept.description as userDeptDesc ");
		queryBuffer.append(" 	From sworguser usr, sworgdept dept ");
		queryBuffer.append(" 	where usr.deptId = dept.id ");
		queryBuffer.append(" 	union ");
		queryBuffer.append(" 	select 'department' as type ");
		queryBuffer.append(" 		, dept.id, dept.name ");
		queryBuffer.append(" 		, dept.description as description ");
		queryBuffer.append(" 		, '' as userPosition ");
		queryBuffer.append(" 		, '' as userPicture ");
		queryBuffer.append(" 		, '' as userDeptId ");
		queryBuffer.append(" 		, '' as userDeptName ");
		queryBuffer.append(" 		, '' as userDeptDesc  ");
		queryBuffer.append(" 	from sworgdept dept ");
		queryBuffer.append(" ) workspaceinfo ");
		queryBuffer.append(" where workspaceinfo.name like :key ");
		
		Query query = this.getSession().createSQLQuery(queryBuffer.toString());

		query.setString("key", CommonUtil.toLikeString(key));
		
		List list = query.list();
		if (list == null || list.isEmpty())
			return null;
		List objList = new ArrayList();
		for (Iterator itr = list.iterator(); itr.hasNext();) {
			Object[] fields = (Object[]) itr.next();
			SchWorkspace obj = new SchWorkspace();
			int j = 0;
	
			obj.setType((String)fields[j++]);    
			obj.setId((String)fields[j++]);    
			obj.setName((String)fields[j++]);     
			obj.setDescription((String)fields[j++]);
			obj.setUserPosition((String)fields[j++]);   
			obj.setUserPicture((String)fields[j++]); 
			obj.setUserDeptId((String)fields[j++]);
			obj.setUserDeptName((String)fields[j++]);
			obj.setUserDeptDesc((String)fields[j++]);
			
			objList.add(obj);
		}
		list = objList;
		SchWorkspace[] objs = new SchWorkspace[list.size()];
		list.toArray(objs);
		return objs;
	}

	@Override
	public SchUser[] getSchUser(String companyId, String userId, String key) throws SchException {
		if (CommonUtil.isEmpty(key)) 
			return null;
		
		StringBuffer queryBuffer = new StringBuffer();
		
		queryBuffer.append(" select usr.id, usr.name ");
		queryBuffer.append(" 		, usr.pos as position ");
		queryBuffer.append(" 		, usr.roleId as roleId ");
		queryBuffer.append(" 		, dept.id as deptId ");
		queryBuffer.append(" 		, dept.name as deptName ");
		queryBuffer.append(" 		, dept.description as deptDesc ");
		queryBuffer.append("  from sworguser usr, sworgdept dept ");
		queryBuffer.append(" where usr.deptId = dept.id ");
		queryBuffer.append("   and usr.name like :key ");

		Query query = this.getSession().createSQLQuery(queryBuffer.toString());

		query.setString("key", CommonUtil.toLikeString(key));

		List list = query.list();
		if (list == null || list.isEmpty())
			return null;
		List objList = new ArrayList();
		for (Iterator itr = list.iterator(); itr.hasNext();) {
			Object[] fields = (Object[]) itr.next();
			SchUser obj = new SchUser();
			int j = 0;
			obj.setId((String)fields[j++]);
			obj.setName((String)fields[j++]);
			obj.setUserPosition((String)fields[j++]);
			obj.setUserRole(((String)fields[j++]).equals("DEPT LEADER") ? User.USER_ROLE_LEADER : User.USER_ROLE_MEMBER);
			obj.setUserDeptId((String)fields[j++]);
			obj.setUserDeptName((String)fields[j++]);
			obj.setUserDeptDesc((String)fields[j++]);

			objList.add(obj);
		}
		list = objList;
		SchUser[] objs = new SchUser[list.size()];
		list.toArray(objs);
		return objs;

	}

	@Override
	public SchWorkspace getWorkspaceById(String companyId, String userid, String workSpaceId) throws SchException {
		if (CommonUtil.isEmpty(workSpaceId)) 
			return null;

		StringBuffer queryBuffer = new StringBuffer();
		
		queryBuffer.append(" select *  ");
		queryBuffer.append(" from  ");
		queryBuffer.append(" ( ");
		queryBuffer.append(" 	select 'user' as type ");
		queryBuffer.append(" 		, usr.id, usr.name ");
		queryBuffer.append(" 		, '' as description ");
		queryBuffer.append(" 		, usr.pos as userPosition ");
		queryBuffer.append(" 		, usr.roleId as userRoleId ");
		queryBuffer.append(" 		, usr.picture as userPicture ");
		queryBuffer.append(" 		, usr.authId as userLevel ");
		queryBuffer.append(" 		, usr.locale as userLocale ");
		queryBuffer.append(" 		, usr.timeZone as userTimeZone ");
		queryBuffer.append(" 		, usr.empNo as userEmployeeId ");
		queryBuffer.append(" 		, usr.internalNo as userPhoneNo ");
		queryBuffer.append(" 		, usr.mobileNo as userCellPhoneNo ");
		queryBuffer.append(" 		, company.id as userCompanyId ");
		queryBuffer.append(" 		, company.name as userCompanyName ");
		queryBuffer.append(" 		, dept.id as userDeptId ");
		queryBuffer.append(" 		, dept.name as userDeptName ");
		queryBuffer.append(" 		, dept.description as userDeptDesc ");
		queryBuffer.append(" 	From sworguser usr, sworgdept dept, sworgcompany company ");
		queryBuffer.append(" 	where usr.deptId = dept.id ");
		queryBuffer.append(" 	  and usr.companyId = company.id ");
		queryBuffer.append(" 	union ");
		queryBuffer.append(" 	select 'department' as type ");
		queryBuffer.append(" 		, dept.id, dept.name ");
		queryBuffer.append(" 		, dept.description as description ");
		queryBuffer.append(" 		, '' as userPosition ");
		queryBuffer.append(" 		, '' as userRoleId ");
		queryBuffer.append(" 		, '' as userPicture ");
		queryBuffer.append(" 		, '' as userLevel ");
		queryBuffer.append(" 		, '' as userLocale ");
		queryBuffer.append(" 		, '' as userTimeZone ");
		queryBuffer.append(" 		, '' as userEmployeeId ");
		queryBuffer.append(" 		, '' as userPhoneNo ");
		queryBuffer.append(" 		, '' as userCellPhoneNo ");
		queryBuffer.append(" 		, '' as userCompanyId ");
		queryBuffer.append(" 		, '' as userCompanyName ");
		queryBuffer.append(" 		, '' as userDeptId ");
		queryBuffer.append(" 		, '' as userDeptName ");
		queryBuffer.append(" 		, '' as userDeptDesc  ");
		queryBuffer.append(" 	from sworgdept dept ");
		queryBuffer.append(" ) workspaceinfo ");
		queryBuffer.append(" where workspaceinfo.id = :workspaceId ");

		Query query = this.getSession().createSQLQuery(queryBuffer.toString());

		query.setString("workspaceId", workSpaceId);

		Object[] fields = (Object[])query.uniqueResult();

		SchWorkspace obj = new SchWorkspace();
		int j = 0;
		obj.setType((String)fields[j++]);
		obj.setId((String)fields[j++]);
		obj.setName((String)fields[j++]);
		obj.setDescription((String)fields[j++]);
		obj.setUserPosition((String)fields[j++]);   
		obj.setUserRole(((String)fields[j++]).equals("DEPT LEADER") ? User.USER_ROLE_LEADER : User.USER_ROLE_MEMBER);
		obj.setUserPicture((String)fields[j++]);
		obj.setUserLevel(((String)fields[j++]).equals("ADMINISTRATOR") ? User.USER_LEVEL_AMINISTRATOR : User.USER_LEVEL_DEFAULT);
		obj.setUserLocale((String)fields[j++]);
		obj.setUserTimeZone((String)fields[j++]);
		obj.setUserEmployeeId((String)fields[j++]);
		obj.setUserPhoneNo((String)fields[j++]);
		obj.setUserCellPhoneNo((String)fields[j++]);
		obj.setUserCompanyId((String)fields[j++]);
		obj.setUserCompanyName((String)fields[j++]);
		obj.setUserDeptId((String)fields[j++]);
		obj.setUserDeptName((String)fields[j++]);
		obj.setUserDeptDesc((String)fields[j++]);

		return obj;

	}

	@Override
	public SchDepartment getDepartmentById(String companyId, String cUserId, String departId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SchUser getUserById(String companyId, String cUserId, String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}