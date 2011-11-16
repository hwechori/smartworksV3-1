/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.notice.manager;

import net.smartworks.server.engine.basicwork.notice.exception.NoticeException;
import net.smartworks.server.engine.basicwork.notice.model.Notice;
import net.smartworks.server.engine.basicwork.notice.model.NoticeCond;
import net.smartworks.server.engine.common.manager.IManager;

public interface INoticeManager extends IManager {

	public Notice getNotice(String user, String id, String level) throws NoticeException;
	public Notice getNotice(String user, NoticeCond cond, String level) throws NoticeException;
	public void setNotice(String user, Notice obj, String level) throws NoticeException;
	public void createNotice(String user, Notice obj) throws NoticeException;
	public void removeNotice(String user, String id) throws NoticeException;
	public void removeNotice(String user, NoticeCond cond) throws NoticeException;
	public long getNoticeSize(String user, NoticeCond cond) throws NoticeException;
	public Notice[] getNotices(String user, NoticeCond cond, String level) throws NoticeException;

}