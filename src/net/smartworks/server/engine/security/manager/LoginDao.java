/*
 * $Id: LoginDao.java,v 1.1 2009/12/16 05:42:42 kmyu Exp $
 * created by    : jiwoongLee
 * creation-date : 2006. 12. 20.
 * =========================================================
 * Copyright (c) 2006 Miracom, Inc. All rights reserved.
 */
package net.smartworks.server.engine.security.manager;

import net.smartworks.server.engine.security.model.Login;

import org.springframework.dao.DataAccessException;

public interface LoginDao {
	
	public boolean isExistUserId(String userId) throws DataAccessException;
	
	public Login retrieve(String userName) throws DataAccessException;

	public Login retrieveUserId(String userId) throws DataAccessException;

}
