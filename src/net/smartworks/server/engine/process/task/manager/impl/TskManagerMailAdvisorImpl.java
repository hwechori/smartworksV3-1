package net.smartworks.server.engine.process.task.manager.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.ServletUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoConfig;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.process.task.manager.AbstractTskManagerAdvisor;
import net.smartworks.server.engine.process.task.model.TskTask;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;

public class TskManagerMailAdvisorImpl extends AbstractTskManagerAdvisor {
	private static final String COUNTER = "counter";
	private JavaMailSender mailSender;
	private TaskExecutor mailExecutor;
	private String mailContent;
	private String mailContentUrl = null;
	private String isEnableReferenceMail = "false";
	private String mailMode;
	
	private ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}
	
	public TaskExecutor getMailExecutor() {
		return mailExecutor;
	}
	public void setMailExecutor(TaskExecutor mailExecutor) {
		this.mailExecutor = mailExecutor;
	}
	public TskManagerMailAdvisorImpl() {
		super();
	}
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
		if (level != null && level.equals(IManager.LEVEL_LITE))
			return;
		try {
			obj.setExtendedPropertyValue(COUNTER, (CommonUtil.toInt(obj.getExtendedPropertyValue(COUNTER), -1) + 1) + CommonUtil.EMPTY);
		} catch (Exception e) {
			logger.warn(e);
		}
	}
	public void postSetTask(String user, TskTask obj, String level) throws Exception {
		if (level != null && level.equals(IManager.LEVEL_LITE))
			return;
		if (CommonUtil.toInt(obj.getExtendedPropertyValue(COUNTER), 0) > 0)
			return;
		String assignee = obj.getAssignee();
		String type = obj.getType();
		
		if (assignee == null ||
				type == null || type.equalsIgnoreCase("route") || type.equalsIgnoreCase("and") 
				|| type.equalsIgnoreCase("or") || type.equalsIgnoreCase("xor") || !CommonUtil.toBoolean(isEnableReferenceMail)) 
			return;
		if (obj.getTitle().indexOf("nomail") != -1 || obj.getTitle().indexOf("NOMAIL") != -1)
			return;
		try {
			this.sendMail(user, obj);
		} catch (Exception e) {
			logger.warn(e);
		}
	}
	public String toMailContent(String user, TskTask obj) throws Exception {
		String content = null;
		String id = obj.getObjId();
		String title = obj.getTitle();
		String name = obj.getName();
		String priority = obj.getPriority();
		String assigner = obj.getAssigner();
		String assignee = obj.getAssignee();
		
		String assignmentDate = DateUtil.toXsdDateString(obj.getAssignmentDate());
		String dueDate = DateUtil.toXsdDateString(obj.getDueDate());
		String processInstId = obj.getProcessInstId();
	//	PrcProcessInst prcObj = MisServiceFactory.getInstance().getPrcAdminService().getProcessInst(user, processInstId);
//		String processName = prcObj.getName();
//		String requester = prcObj.getCreationUser();
		String requester = obj.getExtendedPropertyValue("processInstCreationUser");
		String type = obj.getType();
		
		if (mailContentUrl != null) {
			try {
				List paramList = new ArrayList();
				if (id != null)
					paramList.add(new Property("id", id));
				if (title != null)
					paramList.add(new Property("title", title));
				if (name != null)
					paramList.add(new Property("name", name));
				if (priority != null)
					paramList.add(new Property("priority", priority));
				if (assigner != null)
					paramList.add(new Property("assigner", assigner));
				if (assignee != null)
					paramList.add(new Property("assignee", assignee));
				if (assignmentDate != null)
					paramList.add(new Property("assignmentDate", assignmentDate));
				if (dueDate != null)
					paramList.add(new Property("dueDate", dueDate));
//				if (processName != null)
//					paramList.add(new Property("processName", processName));
				if (requester != null)
					paramList.add(new Property("requester", requester));
				if (type != null)
					paramList.add(new Property("type", type));
				
				Property[] params = null;
				if (!paramList.isEmpty()) {
					params = new Property[paramList.size()];
					paramList.toArray(params);
				}
				content = ServletUtil.request(mailContentUrl, params);
			} catch (Exception e) {
				logger.warn(e, e);
			}
		}
		if (content == null && mailContent != null) {
			content = mailContent;
			content = StringUtils.replace(content, "{$id}", CommonUtil.toNotNull(id));
			content = StringUtils.replace(content, "{$title}", CommonUtil.toNotNull(title));
			content = StringUtils.replace(content, "{$name}", CommonUtil.toNotNull(name));
			content = StringUtils.replace(content, "{$priority}", CommonUtil.toNotNull(priority));
			content = StringUtils.replace(content, "{$assigner}", CommonUtil.toNotNull(assigner));
			content = StringUtils.replace(content, "{$assignee}", CommonUtil.toNotNull(assignee));
		}
		
		return content;
	}
	public String toMailTitle(String user, TskTask obj) throws Exception {
		String title = obj.getTitle();
		return title;
	}
	public String toMailFrom(String user, TskTask obj) throws Exception {
		String assigner = obj.getAssigner();
		if (assigner == null)
			return null;
		SwoUser userObj = getSwoManager().getUser(user, assigner, IManager.LEVEL_LITE);
		if (userObj == null)
			return null;
		return userObj.getEmail();
	}
	public String toMailTo(String user, TskTask obj) throws Exception {
		String assignee = obj.getAssignee();
		if (assignee == null)
			return null;
		SwoUser userObj = getSwoManager().getUser(user, assignee, IManager.LEVEL_LITE);
		if (userObj == null)
			return null;
		return userObj.getEmail();
	}
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String defaultMailContent) {
		this.mailContent = defaultMailContent;
	}
	public String getMailContentUrl() {
		return mailContentUrl;
	}
	public void setMailContentUrl(String contentUrl) {
		this.mailContentUrl = contentUrl;
	}
	public String getIsEnableReferenceMail() {
		return isEnableReferenceMail;
	}
	public void setIsEnableReferenceMail(String isEnableReferenceMail) {
		this.isEnableReferenceMail = isEnableReferenceMail;
	}
	public String getMailMode() {
		return mailMode;
	}
	public void setMailMode(String mode) {
		this.mailMode = mode;
	}
	private void sendMail(String user, TskTask obj) throws Exception {
		if (mailExecutor == null)
			return;
//		if (mailMode == null || mailMode.equalsIgnoreCase("none"))
//			return;
		mailExecutor.execute(new SendMailTask(user, obj));
	}
	/**
	 * 메일을 보내는 업무 클래스입니다.
	 * @author admin
	 * @version $Id: TskManagerMailAdvisorImpl.java,v 1.1 2011/11/08 00:28:30 kmyu Exp $
	 */
	private class SendMailTask implements Runnable {
		private String user;
		private TskTask obj;
		public SendMailTask(String user, TskTask obj) {
			this.user = user;
			this.obj = obj;
		}
		public void run() {
			try {
				String to = toMailTo(user, obj);
				if (to == null || to.indexOf("@") == -1)
					return;
				String from = toMailFrom(user, obj);
				String title = toMailTitle(user, obj);
				String content = toMailContent(user, obj);
				
				//sendMail(from, to, title, content);
				user = obj.getAssignee();
				sendMailByUserInfo(user, from, to, title, content);
			} catch (Exception e) {
				logger.warn(e, e);
			}
		}
	}	
	public void sendMailByUserInfo(String user, String from, String to, String title, String content) throws Exception {
		SwoUser userObj = getSwoManager().getUser(user, user, IManager.LEVEL_LITE);
		
		SwoConfig config = getSwoManager().getConfig(user, userObj.getCompanyId(), null);
		if (!config.isActivity())
			return;
		
		if (config == null || config.getSmtpAddress() == null || config.getUserId() == null || config.getPassword() == null) 
			throw new Exception("Mail info is null");
		
		String host = config.getSmtpAddress();
		String id = config.getUserId();
		String pass = config.getPassword();
		
		sendMail(host, id, pass, title, to, from, content);

		if (logger.isInfoEnabled()) {
			StringBuffer buf = new StringBuffer();
			buf.append("Send mail from:").append(from).append(" to:").append(to).append(" title:").append(title);
			logger.info(buf);
		}
	}
	private static void sendMail(String mailServerName, String id, String pass, String subject, String to, 
			String from, String messageText) throws AddressException, MessagingException, UnsupportedEncodingException {

		Authenticator auth = new PassAuthenticator(id, pass);
		Properties mailProps = new Properties();
		mailProps.put("mail.smtp.host", mailServerName);
		mailProps.put("mail.smtp.auth", "true");

		Session mailSession = Session.getInstance(mailProps, auth);

		InternetAddress toAddrs = new InternetAddress(to);
		InternetAddress fromAddr = new InternetAddress(id, "SmartWorks");

		Message message = new MimeMessage(mailSession);
		message.setFrom(fromAddr);
		message.setRecipient(Message.RecipientType.TO, toAddrs);
		message.setSubject(subject);
		message.setContent(messageText.toString(), "text/html; charset=euc-kr");
		
		try {
			Transport.send(message);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new MessagingException(ex.getMessage());
		}
	}
	private void sendMail(String from, String to, String title, String content) throws Exception {
		MimeMessage mimeMsg = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMsg, true);
		msgHelper.setTo(to);
		msgHelper.setFrom(from);
		msgHelper.setSubject(title);
		mimeMsg.setContent(content, "text/html;charset=UTF-8");
		
		if (logger.isInfoEnabled()) {
			StringBuffer buf = new StringBuffer();
			buf.append("Send mail from:").append(from).append(" to:").append(to).append(" title:").append(title);
			logger.info(buf);
		}
		mailSender.send(mimeMsg);
	}
}
class PassAuthenticator extends Authenticator {
	private String id;
	private String pass;
	public PassAuthenticator(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.id, this.pass);
	}
}
