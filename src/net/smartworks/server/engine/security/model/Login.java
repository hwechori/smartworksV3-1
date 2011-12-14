/*
 * $Id: Login.java,v 1.1 2009/12/16 05:42:52 kmyu Exp $
 * created by    : CHO DAE HYON
 * creation-date : 2007. 1. 6.
 * =========================================================
 * Copyright (c) 2007 Miracom, Inc. All rights reserved.
 */
package net.smartworks.server.engine.security.model;

import java.util.Collection;

import net.smartworks.model.community.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class Login extends User implements UserDetails {

	private static final long serialVersionUID = 109756771178872916L;
	private String type;
	private String empNo;
	private String email;
	private String password;
	private String authId;

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	private Collection<GrantedAuthority> authorities;

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	// -------------------------------------------------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
	 */

	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#getPassword()
	 */
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#getUsername()
	 */
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isAccountNonExpired()
	 */
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isAccountNonLocked()
	 */
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isEnabled()
	 */
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

}