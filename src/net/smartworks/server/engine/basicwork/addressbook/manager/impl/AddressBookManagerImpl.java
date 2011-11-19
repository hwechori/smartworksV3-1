/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 18.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.addressbook.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.basicwork.addressbook.exception.AddressBookException;
import net.smartworks.server.engine.basicwork.addressbook.manager.IAddressBookManager;
import net.smartworks.server.engine.basicwork.addressbook.model.AddressBook;
import net.smartworks.server.engine.basicwork.addressbook.model.AddressBookCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class AddressBookManagerImpl extends AbstractManager implements IAddressBookManager {

	public AddressBookManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public AddressBook getAddressBook(String user, String objId, String level) throws AddressBookException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				AddressBook obj = (AddressBook)get(AddressBook.class, objId);
				return obj;
			} catch (Exception e) {
				throw new AddressBookException(e);
			}
		} else {
			AddressBookCond cond = new AddressBookCond();
			cond.setObjId(objId);
			AddressBook[] objs = this.getAddressBooks(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}
	public AddressBook getAddressBook(String user, AddressBookCond cond, String level)throws AddressBookException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		AddressBook[] senders = getAddressBooks(user, cond, level);
		if (CommonUtil.isEmpty(senders))
			return null;
		if (senders.length > 1)
			throw new AddressBookException("More than 1 sender. ");
		return senders[0];
	}
	public void setAddressBook(String user, AddressBook obj, String level) throws AddressBookException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update AddressBook set ");
				buf.append(" name=:name, companyId=:companyId, deptId=:deptId, position=:position, mobile=:mobile,");
				buf.append(" telephone=:telephone, fax=:fax, email=:email, messenger=:messenger, address=:address, ");
				buf.append(" country=:country, relation=:relation, description=:description, ");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(AddressBook.A_NAME, obj.getName());
				query.setString(AddressBook.A_COMPANYID, obj.getCompanyId());
				query.setString(AddressBook.A_DEPTID, obj.getDeptId());
				query.setString(AddressBook.A_POSITION, obj.getPosition());
				query.setString(AddressBook.A_MOBILE, obj.getMobile());
				query.setString(AddressBook.A_TELEPHONE, obj.getTelephone());
				query.setString(AddressBook.A_FAX, obj.getFax());
				query.setString(AddressBook.A_EMAIL, obj.getEmail());
				query.setString(AddressBook.A_MESSENGER, obj.getMessenger());
				query.setString(AddressBook.A_ADDRESS, obj.getAddress());
				query.setString(AddressBook.A_COUNTRY, obj.getCountry());
				query.setString(AddressBook.A_RELATION, obj.getRelation());
				query.setString(AddressBook.A_DESCRIPTION, obj.getDescription());
				query.setTimestamp(AddressBook.A_CREATIONDATE, obj.getCreationDate());
				query.setString(AddressBook.A_CREATIONUSER, obj.getCreationUser());
				query.setString(AddressBook.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(AddressBook.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(AddressBook.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new AddressBookException(e);
		}
	}

	public void createAddressBook(String user, AddressBook obj) throws AddressBookException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new AddressBookException(e);
		}
	}
	public void removeAddressBook(String user, String objId) throws AddressBookException {
		try {
			remove(AddressBook.class, objId);
		} catch (Exception e) {
			throw new AddressBookException(e);
		}
	}
	public void removeAddressBook(String user, AddressBookCond cond) throws AddressBookException {
		AddressBook obj = getAddressBook(user, cond, null);
		if (obj == null)
			return;
		removeAddressBook(user, obj.getObjId());

	}
	private Query appendQuery(StringBuffer buf, AddressBookCond cond) throws Exception {
		String objId = null;
		String name = null;
		String companyId = null;
		String deptId = null;
		String position = null;
		String mobile = null;
		String telephone = null;
		String fax = null;
		String email = null;
		String messenger = null;
		String address = null;
		String country = null;
		String relation = null;
		String description = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;

			if (cond != null) {
				objId = cond.getObjId();
				name = cond.getName();
				companyId = cond.getCompanyId();
				deptId = cond.getDeptId();
				position = cond.getPosition();
				mobile = cond.getMobile();
				telephone = cond.getTelephone();
				fax = cond.getFax();
				email = cond.getEmail();
				messenger = cond.getMessenger();
				address = cond.getAddress();
				country = cond.getCountry();
				relation = cond.getRelation();
				description = cond.getDescription();
				creationUser = cond.getCreationUser();
				creationDate = cond.getCreationDate();
				modificationUser = cond.getModificationUser();
				modificationDate = cond.getModificationDate();
			}
			buf.append(" from AddressBook obj");
			buf.append(" where obj.objId is not null");
			//TODO 시간 검색에 대한 확인 필요
			if (cond != null) {
				if (objId != null) 
					buf.append(" and obj.objId = :objId");
				if (name != null) 
					buf.append(" and obj.name = :name");
				if (companyId != null) 
					buf.append(" and obj.companyId = :companyId");
				if (deptId != null) 
					buf.append(" and obj.deptId = :deptId");
				if (position != null) 
					buf.append(" and obj.position = :position");
				if (mobile != null) 
					buf.append(" and obj.mobile = :mobile");
				if (telephone != null) 
					buf.append(" and obj.telephone = :telephone");
				if (fax != null) 
					buf.append(" and obj.fax = :fax");
				if (email != null) 
					buf.append(" and obj.email = :email");
				if (messenger != null) 
					buf.append(" and obj.messenger = :messenger");
				if (address != null) 
					buf.append(" and obj.address = :address");
				if (country != null) 
					buf.append(" and obj.country = :country");
				if (relation != null) 
					buf.append(" and obj.relation = :relation");
				if (description != null) 
					buf.append(" and obj.description = :description");
				if (creationUser != null)
					buf.append(" and obj.creationUser = :creationUser");
				if (creationDate != null)
					buf.append(" and obj.creationDate = :creationDate");
				if (modificationUser != null)
					buf.append(" and obj.modificationUser = :modificationUser");
				if (modificationDate != null)
					buf.append(" and obj.modificationDate = :modificationDate");
				}
				this.appendOrderQuery(buf, "obj", cond);
				
				Query query = this.createQuery(buf.toString(), cond);
				if (cond != null) {
					if (objId != null)
						query.setString("objId", objId);
					if (name != null)
						query.setString("name", name);
					if (companyId != null)
						query.setString("companyId", companyId);
					if (deptId != null)
						query.setString("deptId", deptId);
					if (position != null)
						query.setString("position",position);
					if (mobile != null)
						query.setString("mobile", mobile);
					if (telephone != null)
						query.setString("telephone", telephone);
					if (fax != null)
						query.setString("fax", fax);
					if (email != null)
						query.setString("email", email);
					if (messenger != null)
						query.setString("messenger", messenger);
					if (address != null)
						query.setString("address", address);
					if (country != null)
						query.setString("country", country);
					if (relation != null)
						query.setString("relation", relation);
					if (description != null)
						query.setString("description", description);
					if (creationUser != null)
						query.setString("creationUser", creationUser);
					if (creationDate != null)
						query.setTimestamp("creationDate", creationDate);
					if (modificationUser != null)
						query.setString("modificationUser", modificationUser);
					if (modificationDate != null)
						query.setTimestamp("modificationDate", modificationDate);
				}
			return query;
			
	}
	public long getAddressBookSize(String user, AddressBookCond cond) throws AddressBookException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new AddressBookException(e);
		}
	
	}
	public AddressBook[] getAddressBooks(String user, AddressBookCond cond, String level) throws AddressBookException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.companyId, obj.deptId, obj.position,");
				buf.append(" obj.mobile, obj.telephone, obj.fax, obj.email, obj.messenger,");
				buf.append(" obj.address, obj.country, obj.relation, obj.description,");
				buf.append(" obj.creationUser, obj.creationDate, obj.modificationUser, obj.modificationDate");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					AddressBook obj = new AddressBook();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setDeptId((String)fields[j++]);
					obj.setPosition((String)fields[j++]);
					obj.setMobile((String)fields[j++]);
					obj.setTelephone((String)fields[j++]);
					obj.setFax((String)fields[j++]);
					obj.setEmail((String)fields[j++]);
					obj.setMessenger((String)fields[j++]);
					obj.setAddress((String)fields[j++]);
					obj.setCountry((String)fields[j++]);
					obj.setRelation((String)fields[j++]);
					obj.setDescription((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			AddressBook[] objs = new AddressBook[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new AddressBookException(e);
		}
	}

}