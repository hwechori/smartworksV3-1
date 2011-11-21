/*	
 * $Id$
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 10. 31.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.impl;

import net.smartworks.model.notice.Notice;
import net.smartworks.model.notice.NoticeBox;
import net.smartworks.server.service.INoticeService;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;

import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements INoticeService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getNoticesForMe(java.lang.String)
	 */
	@Override
	public Notice[] getNoticesForMe(String companyId, String userId) throws Exception {
		return SmartTest.getNoticesForMe();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getNoticeBoxForMe10(int,
	 * net.smartworks.util.LocalDate)
	 */
	@Override
	public NoticeBox getNoticeBoxForMe10(String companyId, String userId, int noticeType, LocalDate lastNotice) throws Exception {
		return SmartTest.getNoticeBoxForMe10(noticeType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getBroadcastingMessages()
	 */
	@Override
	public String[] getBroadcastingMessages(String companyId) throws Exception {
		return SmartTest.getBroadcastingMessages();
	}
}
