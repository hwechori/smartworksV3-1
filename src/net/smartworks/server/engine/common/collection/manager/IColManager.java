package net.smartworks.server.engine.common.collection.manager;

import net.smartworks.server.engine.common.collection.exception.ColException;
import net.smartworks.server.engine.common.collection.model.ColList;
import net.smartworks.server.engine.common.collection.model.ColListCond;
import net.smartworks.server.engine.common.collection.model.ColMap;
import net.smartworks.server.engine.common.collection.model.ColMapCond;
import net.smartworks.server.engine.common.collection.model.ColValue;
import net.smartworks.server.engine.common.collection.model.ColValueCond;
import net.smartworks.server.engine.common.manager.IManager;

public interface IColManager extends IManager {
	
	public ColMap getMap(String user, String objId, String level) throws ColException;
	public ColMap getMap(String user, ColMapCond cond, String level) throws ColException;
	public void setMap(String user, ColMap obj, String level) throws ColException;
	public void createMap(String user, ColMap obj) throws ColException;
	public void removeMap(String user, String objId) throws ColException;
	public void removeMap(String user, ColMapCond cond) throws ColException;
	public long getMapSize(String user, ColMapCond cond) throws ColException;
	public ColMap[] getMaps(String user, ColMapCond cond, String level) throws ColException;
	
	public ColValue getValue(String user, String objId, String level) throws ColException;
	public ColValue getValue(String user, ColValueCond cond, String level) throws ColException;
	public void setValue(String user, ColValue obj, String level) throws ColException;
	public void createValue(String user, ColValue obj) throws ColException;
	public void removeValue(String user, String objId) throws ColException;
	public void removeValue(String user, ColValueCond cond) throws ColException;
	public long getValueSize(String user, ColValueCond cond) throws ColException;
	public ColValue[] getValues(String user, ColValueCond cond, String level) throws ColException;
	
	public ColList getList(String user, String objId, String level) throws ColException;
	public ColList getList(String user, ColListCond cond, String level) throws ColException;
	public void setList(String user, ColList obj, String level) throws ColException;
	public void createList(String user, ColList obj) throws ColException;
	public void removeList(String user, String objId) throws ColException;
	public void removeList(String user, ColListCond cond) throws ColException;
	public long getListSize(String user, ColListCond cond) throws ColException;
	public ColList[] getLists(String user, ColListCond cond, String level) throws ColException;
}
