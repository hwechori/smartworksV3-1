/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.data.manager;

import net.smartworks.server.engine.basicwork.data.exception.DataException;
import net.smartworks.server.engine.basicwork.data.model.Data;
import net.smartworks.server.engine.basicwork.data.model.DataCond;
import net.smartworks.server.engine.common.manager.IManager;

public interface IDataManager extends IManager {

	public Data getData(String user, String id, String level) throws DataException;
	public Data getData(String user, DataCond cond, String level) throws DataException;
	public void setData(String user, Data obj, String level) throws DataException;
	public void createData(String user, Data obj) throws DataException;
	public void removeData(String user, String id) throws DataException;
	public void removeData(String user, DataCond cond) throws DataException;
	public long getDataSize(String user, DataCond cond) throws DataException;
	public Data[] getDatas(String user, DataCond cond, String level) throws DataException;

}