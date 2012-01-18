package net.smartworks.server.engine.common.menuitem.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.menuitem.exception.ItmException;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItem;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemList;
import net.smartworks.server.engine.common.menuitem.model.ItmMenuItemListCond;

public interface IItmManager extends IManager {
	
	public ItmMenuItemList getMenuItemList(String userId, String objId, String level) throws ItmException;
	public ItmMenuItemList getMenuItemList(String userId, ItmMenuItemListCond cond, String level) throws ItmException;
	public void setMenuItemList(String userId, ItmMenuItemList obj, String level) throws ItmException;
	public void createMenuItemList(String userId, ItmMenuItemList obj) throws ItmException;
	public void addMenuItem(String userId, ItmMenuItem obj) throws ItmException;
	public void removeMenuItemList(String userId, String objId) throws ItmException;
	public void removeMenuItemList(String userId, ItmMenuItemListCond cond) throws ItmException;
	public long getMenuItemListSize(String userId, ItmMenuItemListCond cond) throws ItmException;
	public ItmMenuItemList[] getMenuItemLists(String userId, ItmMenuItemListCond cond, String level) throws ItmException;
	
	public void removeMenuItem(String userId, String packageId) throws ItmException;

	public int getMaxItmSeq(String userId) throws ItmException;

}