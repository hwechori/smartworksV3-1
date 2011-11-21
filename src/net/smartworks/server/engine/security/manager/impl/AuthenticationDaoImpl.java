/*
 * $Id: AuthenticationDaoImpl.java,v 1.1 2009/12/16 05:43:00 kmyu Exp $
 * created by    : jiwoongLee
 * creation-date : 2005. 10. 11.
 * =========================================================
 * Copyright (c) 2008 Maninsoft, Inc. All rights reserved.
 */
package net.smartworks.server.engine.security.manager.impl;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.security.manager.LoginDao;
import net.smartworks.server.engine.security.model.Login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationDaoImpl implements UserDetailsService {
	private static final Log logger = LogFactory.getLog(AuthenticationDaoImpl.class);

	private LoginDao loginDao;

	/**
	 * @return Returns the loginDao.
	 */
	public LoginDao getLoginDao() {
		return loginDao;
	}
	/**
	 * @param loginDao The loginDao to set.
	 */
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		Login user = null;

		try {
			user = this.loginDao.retrieve(username);
		} catch (ObjectRetrievalFailureException e) {
			logger.info(e);
			throw new UsernameNotFoundException("User not found", e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List dbAuths = new ArrayList();
		try {
			GrantedAuthorityImpl authority = new GrantedAuthorityImpl(user.getAuthId());
			dbAuths.add(authority);
		} catch (NullPointerException e1) {
			logger.error(e1);
			throw new UsernameNotFoundException("User not found", e1);
		}

		((Login) user).setAuthorities(dbAuths);
		return user;
	}
}
