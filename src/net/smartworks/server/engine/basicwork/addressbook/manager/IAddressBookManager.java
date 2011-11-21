/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 18.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.addressbook.manager;

import net.smartworks.server.engine.basicwork.addressbook.exception.AddressBookException;
import net.smartworks.server.engine.basicwork.addressbook.model.AddressBook;
import net.smartworks.server.engine.basicwork.addressbook.model.AddressBookCond;
import net.smartworks.server.engine.common.manager.IManager;

public interface IAddressBookManager extends IManager {

	public AddressBook getAddressBook(String user, String id, String level) throws AddressBookException;
	public AddressBook getAddressBook(String user, AddressBookCond cond, String level) throws AddressBookException;
	public void setAddressBook(String user, AddressBook obj, String level) throws AddressBookException;
	public void createAddressBook(String user, AddressBook obj) throws AddressBookException;
	public void removeAddressBook(String user, String id) throws AddressBookException;
	public void removeAddressBook(String user, AddressBookCond cond) throws AddressBookException;
	public long getAddressBookSize(String user, AddressBookCond cond) throws AddressBookException;
	public AddressBook[] getAddressBooks(String user, AddressBookCond cond, String level) throws AddressBookException;

}