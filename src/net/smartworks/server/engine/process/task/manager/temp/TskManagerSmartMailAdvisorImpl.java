package net.smartworks.server.engine.process.task.manager.temp;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoConfig;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.process.task.manager.impl.TskManagerMailAdvisorImpl;
import net.smartworks.server.engine.process.task.model.TskTask;

public class TskManagerSmartMailAdvisorImpl extends TskManagerMailAdvisorImpl {
	public TskManagerSmartMailAdvisorImpl() {
		super();
	}
	public static ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}
	
	public String toMailFrom(String user, TskTask obj) throws Exception {
		String assigner = obj.getAssigner();
		if (assigner == null)
			return null;
		SwoUser userObj = getSwoManager().getUser(user, assigner, null);
		if (userObj == null)
			return null;
		return userObj.getEmail();
	}
	public String toMailTo(String user, TskTask obj) throws Exception {
		String assignee = obj.getAssignee();
		if (assignee == null)
			return null;
		SwoUser userObj = getSwoManager().getUser(user, assignee, null);
		if (userObj == null)
			return null;
		return userObj.getEmail();
	}

	public void sendMailByUserInfo(String user, String from, String to, String title, String content) throws Exception {
		SwoUser userObj = getSwoManager().getUser(user, user, null);
		
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
