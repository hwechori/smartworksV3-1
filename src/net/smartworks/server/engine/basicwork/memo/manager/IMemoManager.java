/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.memo.manager;

import net.smartworks.server.engine.basicwork.memo.exception.MemoException;
import net.smartworks.server.engine.basicwork.memo.model.Memo;
import net.smartworks.server.engine.basicwork.memo.model.MemoCond;
import net.smartworks.server.engine.common.manager.IManager;

public interface IMemoManager extends IManager {

	public Memo getMemo(String user, String id, String level) throws MemoException;
	public Memo getMemo(String user, MemoCond cond, String level) throws MemoException;
	public void setMemo(String user, Memo obj, String level) throws MemoException;
	public void createMemo(String user, Memo obj) throws MemoException;
	public void removeMemo(String user, String id) throws MemoException;
	public void removeMemo(String user, MemoCond cond) throws MemoException;
	public long getMemoSize(String user, MemoCond cond) throws MemoException;
	public Memo[] getMemos(String user, MemoCond cond, String level) throws MemoException;

}