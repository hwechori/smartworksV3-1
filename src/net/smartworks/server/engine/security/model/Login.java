/*
 * $Id: Login.java,v 1.1 2009/12/16 05:42:52 kmyu Exp $
 * created by    : CHO DAE HYON
 * creation-date : 2007. 1. 6.
 * =========================================================
 * Copyright (c) 2007 Miracom, Inc. All rights reserved.
 */
package net.smartworks.server.engine.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class Login implements UserDetails {

	private static final long serialVersionUID = 109756771178872916L;
	private String id;
	private String name;
	private String type;
	private String deptid;
	private String pos;
	private String email;
	private String password;
	private String authid;

	private Collection<GrantedAuthority> authorities;

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

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
	 * @return Returns the deptid.
	 */
	public String getDeptid() {
		return deptid;
	}

	/**
	 * @param deptid The deptid to set.
	 */
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	/**
	 * @return Returns the pos.
	 */
	public String getPos() {
		return pos;
	}

	/**
	 * @param pos The pos to set.
	 */
	public void setPos(String pos) {
		this.pos = pos;
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
		return id;
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
	public String getAuthid() {
		return authid;
	}

	public void setAuthid(String authid) {
		this.authid = authid;
	}

}