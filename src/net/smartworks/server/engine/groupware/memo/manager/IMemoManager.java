/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.groupware.memo.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.groupware.memo.exception.MemoException;
import net.smartworks.server.engine.groupware.memo.model.Memo;
import net.smartworks.server.engine.groupware.memo.model.MemoCond;

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