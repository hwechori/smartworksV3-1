/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 14.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.groupware.message.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.groupware.message.exception.MessageException;
import net.smartworks.server.engine.groupware.message.model.Message;
import net.smartworks.server.engine.groupware.message.model.MessageCond;

public interface IMessageManager extends IManager {

	public Message getMessage(String user, String id, String level) throws MessageException;
	public Message getMessage(String user, MessageCond cond, String level) throws MessageException;
	public void setMessage(String user, Message obj, String level) throws MessageException;
	public void createMessage(String user, Message obj) throws MessageException;
	public void removeMessage(String user, String id) throws MessageException;
	public void removeMessage(String user, MessageCond cond) throws MessageException;
	public long getMessageSize(String user, MessageCond cond) throws MessageException;
	public Message[] getMessages(String user, MessageCond cond, String level) throws MessageException;

}