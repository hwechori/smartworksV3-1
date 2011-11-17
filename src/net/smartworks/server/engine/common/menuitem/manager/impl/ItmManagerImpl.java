package net.smartworks.server.engine.common.menuitem.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.menuitem.exception.ItmException;
import net.smartworks.server.engine.common.menuitem.manager.IItmManager;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItem;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemList;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemListCond;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.hibernate.Query;

public class ItmManagerImpl extends AbstractManager implements IItmManager {

	public ItmMenuItemList getMenuItemList(String userId, String objId, String level) throws ItmException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				ItmMenuItemList obj = (ItmMenuItemList)this.get(ItmMenuItemList.class, objId);
				return obj;
			} else {
				ItmMenuItemListCond cond = new ItmMenuItemListCond();
				cond.setObjId(objId);
				return getMenuItemList(userId, cond, level);
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new ItmException(e);
		}
	}
	public ItmMenuItemList getMenuItemList(String userId, ItmMenuItemListCond cond, String level) throws ItmException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		ItmMenuItemList[] menuItemLists = getMenuItemLists(userId, cond, level);
		if (CommonUtil.isEmpty(menuItemLists))
			return null;
		try {
			if (menuItemLists.length != 1)
				throw new ItmException("More than 1 Object");
		} catch (ItmException e) {
			logger.error(e, e);
			throw e;
		}
		return menuItemLists[0];
	}
	public void setMenuItemList(String userId, ItmMenuItemList obj, String level) throws ItmException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(userId, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update ItmMenuItemList set");
				buf.append(" name=:name, companyId=:companyId, userId=:userId");
				buf.append(", creationUser=:creationUser, creationDate=:creationDate");
				buf.append(", modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(ItmMenuItemList.A_NAME, obj.getName());
				query.setString(ItmMenuItemList.A_COMPANYID, obj.getCompanyId());
				query.setString(ItmMenuItemList.A_USERID, obj.getUserId());
				query.setString(ItmMenuItemList.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(ItmMenuItemList.A_CREATIONDATE, obj.getCreationDate());
				query.setString(ItmMenuItemList.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(ItmMenuItemList.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(ItmMenuItemList.A_OBJID, obj.getObjId());
				query.executeUpdate();
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new ItmException(e);
		}
	}
	public void createMenuItemList(String userId, ItmMenuItemList obj) throws ItmException {
		try {
			fill(userId, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new ItmException(e);
		}
	}
	public void removeMenuItemList(String userId, String objId) throws ItmException {
		try {
			remove(ItmMenuItemList.class, objId);
		} catch (Exception e) {
			logger.error(e, e);
			throw new ItmException(e);
		}
	}
	public void removeMenuItemList(String userId, ItmMenuItemListCond cond) throws ItmException {
		ItmMenuItemList obj = getMenuItemList(userId, cond, null);
		if (obj == null)
			return;
		removeMenuItemList(userId, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, ItmMenuItemListCond cond) throws Exception {
		String objId = null;
		String name = null;
		String companyId = null;
		String userId = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		ItmMenuItem[] menuItems = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			name = cond.getName();
			companyId = cond.getCompanyId();
			userId = cond.getUserId();
			creationUser = cond.getCreationUser();
			creationDate = cond.getCreationDate();
			modificationUser = cond.getModificationUser();
			modificationDate = cond.getModificationDate();
		}
		buf.append(" from ItmMenuItemList obj");
		if (menuItems != null && menuItems.length != 0) {
			for (int i=0; i<menuItems.length; i++) {
				buf.append(" left join obj.menuItems as menuItem").append(i);
			}
		}
		buf.append(" where obj.id is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (name != null)
				buf.append(" and obj.name = :name");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (userId != null)
				buf.append(" and obj.userId = :userId");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (creationDate != null)
				buf.append(" and obj.creationDate = :creationDate");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (modificationDate != null)
				buf.append(" and obj.modificationDate = :modificationDate");
			if (menuItems != null && menuItems.length != 0) {
				for (int i=0; i<menuItems.length; i++) {
					ItmMenuItem menuItem = menuItems[i];
					int menuSeqNo = menuItem.getMenuSeqNo();
					String groupId = menuItem.getGroupId();
					String imgPath = menuItem.getImgPath();
					String categoryId = menuItem.getCategoryId();
					String packageId = menuItem.getPackageId();
					String packageType = menuItem.getPackageType();
					String formId = menuItem.getFormId();
					String item_name = menuItem.getName();
					if (groupId != null)
						buf.append(" and menuItem").append(i).append(".groupId = :groupId").append(i);
					if (menuSeqNo != -1)
						buf.append(" and menuItem").append(i).append(".menuSeqNo = :menuSeqNo").append(i);
					if (imgPath != null)
						buf.append(" and menuItem").append(i).append(".imgPath = :imgPath").append(i);
					if (item_name != null)
						buf.append(" and menuItem").append(i).append(".name = :item_name").append(i);
					if (categoryId != null)
						buf.append(" and menuItem").append(i).append(".categoryId = :categoryId").append(i);
					if (packageId != null)
						buf.append(" and menuItem").append(i).append(".packageId = :packageId").append(i);
					if (packageType != null)
						buf.append(" and menuItem").append(i).append(".packageType = :packageType").append(i);
					if (formId != null)
						buf.append(" and menuItem").append(i).append(".formId = :formId").append(i);
				}
			}
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
			if (userId != null)
				query.setString("userId", userId);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (creationDate != null)
				query.setTimestamp("creationDate", creationDate);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (modificationDate != null)
				query.setTimestamp("modificationDate", modificationDate);
			if (menuItems != null && menuItems.length != 0) {
				for (int i=0; i<menuItems.length; i++) {
					ItmMenuItem menuItem = menuItems[i];
					int menuSeqNo = menuItem.getMenuSeqNo();
					String groupId = menuItem.getGroupId();
					String imgPath = menuItem.getImgPath();
					String categoryId = menuItem.getCategoryId();
					String packageId = menuItem.getPackageId();
					String packageType = menuItem.getPackageType();
					String formId = menuItem.getFormId();
					String item_name = menuItem.getName();
					
					if (groupId != null)
						query.setString("groupId"+i, groupId);
					if (menuSeqNo != -1)
						query.setInteger("menuSeqNo"+i, menuSeqNo);
					if (imgPath != null)
						query.setString("imgPath"+i, imgPath);
					if (categoryId != null)
						query.setString("categoryId"+i, categoryId);
					if (packageId != null)
						query.setString("packageId"+i, packageId);
					if (packageType != null)
						query.setString("packageType"+i, packageType);
					if (formId != null)
						query.setString("formId"+i, formId);
					if (item_name != null)
						query.setString("item_name"+i, item_name);
				}
			}
		}
		return query;
	}
	public long getMenuItemListSize(String userId, ItmMenuItemListCond cond) throws ItmException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf,cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new ItmException(e);
		}
	}
	public ItmMenuItemList[] getMenuItemLists(String userId, ItmMenuItemListCond cond, String level) throws ItmException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.companyId, obj.userId"); 
				buf.append(", obj.creationUser, obj.creationDate");
				buf.append(", obj.modificationUser, obj.modificationDate");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					ItmMenuItemList obj = new ItmMenuItemList();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setUserId((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Date)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Date)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			ItmMenuItemList[] objs = new ItmMenuItemList[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new ItmException(e);
		}
	}
	
	public void removeMenuItems(String userId, String packageId) throws ItmException {
		if (CommonUtil.isEmpty(packageId))
			return;
		String hql = "delete ItmMenuItem where packageId = '" + packageId + "'";
		Query query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}
}
