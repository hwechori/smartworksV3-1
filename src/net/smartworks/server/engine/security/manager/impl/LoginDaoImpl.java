/*
 * $Id: LoginDaoImpl.java,v 1.1 2009/12/16 05:43:00 kmyu Exp $
 * created by    : jiwoongLee
 * creation-date : Apr 5, 2008
 * =========================================================
 * Copyright (c) 2008 ManInSoft, Inc. All rights reserved.
 */
package net.smartworks.server.engine.security.manager.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import net.smartworks.server.engine.security.manager.LoginDao;
import net.smartworks.server.engine.security.model.Login;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.orm.ObjectRetrievalFailureException;

/**
 * @spring.bean id= "loginDao"
 * @spring.property name="dataSource" ref="dataSource"
 */
public class LoginDaoImpl extends JdbcDaoSupport implements LoginDao {

	private static String RETRIVE_USER = "select * from sworguser where id=?";
	protected SelectQuery00 selectQuery00;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.dao.support.DaoSupport#initDao()
	 */
	protected void initDao() throws Exception {
		super.initDao();
		this.selectQuery00 = new SelectQuery00(getDataSource());
	}

	/*
	 * (non-Javadoc)
	 * @see com.maninsoft.smart.portal.webapp.common.dao.LoginDao#isExistUserId(java.lang.String)
	 */
	public boolean isExistUserId(String userId) throws DataAccessException {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see com.maninsoft.smart.portal.webapp.common.dao.LoginDao#retrieve(java.lang.String)
	 */
	public Login retrieve(String userName) throws DataAccessException {
		return this.retrieveUserId(userName);
	}

	/*
	 * (non-Javadoc)
	 * @see com.maninsoft.smart.portal.webapp.common.dao.LoginDao#retrieveUserId(java.lang.String)
	 */
	public Login retrieveUserId(String userId) throws DataAccessException, ObjectRetrievalFailureException {
		Login login = (Login) selectQuery00.findObject(userId);
		if(login == null){
			throw new ObjectRetrievalFailureException("tried Login Id: "+userId+" ", login);
		}
		return login; 
	}

	protected class SelectQuery00 extends MappingSqlQuery {
		protected SelectQuery00(DataSource ds) {
			super(ds, RETRIVE_USER);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}
		protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Login login = new Login();
			login.setId(rs.getString("id"));
			login.setName(rs.getString("name"));
			login.setCompanyId(rs.getString("companyId"));
			login.setType(rs.getString("type"));
			login.setDeptId(rs.getString("deptId"));
			login.setEmpNo(rs.getString("empNo"));
			login.setPos(rs.getString("pos"));
			login.setEmail(rs.getString("email"));
			login.setPassword(rs.getString("passwd"));
			login.setAuthId(rs.getString("authId"));
			login.setLocale(rs.getString("lang"));
			return login;
		}
	}

}
