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
		return new Notice[] { new Notice(Notice.TYPE_NOTIFICATION, 1), new Notice(Notice.TYPE_MESSAGE, 0), new Notice(Notice.TYPE_COMMENTS, 29),
				new Notice(Notice.TYPE_ASSIGNED, 0), new Notice(Notice.TYPE_MAILBOX, 420), new Notice(Notice.TYPE_SAVEDBOX, 7) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getNoticeBoxForMe10(int,
	 * net.smartworks.util.LocalDate)
	 */
	@Override
	public NoticeBox getNoticeBoxForMe10(String companyId, String userId, int noticeType, LocalDate lastNotice) throws Exception {
		if (noticeType == Notice.TYPE_NOTIFICATION) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getNotificationMessages());
			noticeBox.setNoticeType(Notice.TYPE_NOTIFICATION);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_MESSAGE) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getMessageMessages());
			noticeBox.setNoticeType(Notice.TYPE_MESSAGE);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_COMMENTS) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getCommentsMessages());
			noticeBox.setNoticeType(Notice.TYPE_COMMENTS);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_ASSIGNED) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getAssignedMessages());
			noticeBox.setNoticeType(Notice.TYPE_ASSIGNED);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_MAILBOX) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getMailboxMessages());
			noticeBox.setNoticeType(Notice.TYPE_MAILBOX);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_SAVEDBOX) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getSavedboxMessages());
			noticeBox.setNoticeType(Notice.TYPE_SAVEDBOX);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.smartworks.service.impl.ISmartWorks#getBroadcastingMessages()
	 */
	@Override
	public String[] getBroadcastingMessages(String companyId) throws Exception {
		return new String[] { "오늘 시스템 작업예정으로 오후 5시부터 한시간 동안 시스템을 사용할 수 없으니, 업무진행에 착오없으시길 바랍니다. -- 기술연구소 ---",
				"금일 전체회식에 전원참석하여 좋은 친목의 시간이 되기를 바랍니다. --- 경영 기획팀 ----" };
	}

}
