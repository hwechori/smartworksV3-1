package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.MailInstance;
import net.smartworks.model.instance.SortingField;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.MailInstanceInfo;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.mail.MailAttachment;
import net.smartworks.model.mail.MailFolder;
import net.smartworks.server.service.IMailService;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

import org.claros.commons.auth.MailAuth;
import org.claros.commons.auth.exception.LoginInvalidException;
import org.claros.commons.auth.models.AuthProfile;
import org.claros.commons.configuration.PropertyFile;
import org.claros.commons.exception.SystemException;
import org.claros.commons.mail.comparator.ComparatorDate;
import org.claros.commons.mail.comparator.ComparatorFrom;
import org.claros.commons.mail.comparator.ComparatorSize;
import org.claros.commons.mail.comparator.ComparatorSubject;
import org.claros.commons.mail.comparator.ComparatorTo;
import org.claros.commons.mail.exception.ProtocolNotAvailableException;
import org.claros.commons.mail.exception.ServerDownException;
import org.claros.commons.mail.models.ConnectionMetaHandler;
import org.claros.commons.mail.models.ConnectionProfile;
import org.claros.commons.mail.models.ConnectionProfileList;
import org.claros.commons.mail.models.Email;
import org.claros.commons.mail.models.EmailHeader;
import org.claros.commons.mail.models.EmailPart;
import org.claros.commons.mail.protocols.Protocol;
import org.claros.commons.mail.protocols.ProtocolFactory;
import org.claros.commons.mail.utility.Constants;
import org.claros.commons.mail.utility.Utility;
import org.claros.intouch.common.services.BaseService;
import org.claros.intouch.webmail.controllers.FolderController;
import org.claros.intouch.webmail.controllers.InboxController;
import org.claros.intouch.webmail.controllers.MailController;
import org.claros.intouch.webmail.factory.FolderControllerFactory;
import org.claros.intouch.webmail.factory.InboxControllerFactory;
import org.claros.intouch.webmail.factory.MailControllerFactory;
import org.claros.intouch.webmail.models.FolderDbObject;
import org.claros.intouch.webmail.models.FolderDbObjectWrapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class MailServiceImpl extends BaseService implements IMailService {

	@Override
	public MailFolder[] getMailFoldersById(String folderId) throws Exception {
		MailFolder[] mailFolders = null;

	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpServletRequest request = attr.getRequest();

		try {
			HashMap map = ConnectionProfileList.getConList();
			if (map != null) {
				Set set = map.keySet();
				if (set == null) {
					throw new SystemException();
				}
				Object arr[] = set.toArray();
				if (arr == null || arr.length <= 0) {
					throw new SystemException();
				}
				ConnectionProfile profile = ConnectionProfileList.getProfileByShortName((String)arr[0]);
				if (profile == null) {
					throw new SystemException();
				}
				String username = SmartUtil.getCurrentUser().getId();
				String password = SmartUtil.getCurrentUser().getPassword();

				if (username != null && password != null) {
					AuthProfile auth = new AuthProfile();
					auth.setUsername(username);
					auth.setPassword(password);
					ConnectionMetaHandler handler = (ConnectionMetaHandler)request.getSession().getAttribute("handler");

					try {
						handler = MailAuth.authenticate(profile, auth, handler);
						if (handler != null) {
							
							request.getSession().setAttribute("handler", handler);
							request.getSession().setAttribute("auth", auth);
							request.getSession().setAttribute("profile", profile);

							// create default mailboxes if not exists
							try {

								FolderControllerFactory factory = new FolderControllerFactory(auth, profile, handler);
								FolderController foldCont = factory.getFolderController();
								foldCont.createDefaultFolders();
							} catch (Exception e) {
							}

						} else {
						}
					} catch (LoginInvalidException e) {
						return null;
					} catch (ServerDownException e) {
						return null;
					}
				} else {
				}
			} else {
				return null;
			}
		} catch (SystemException e) {
			return null;
		} catch (Throwable e) {
			return null;
		}
	    	    
	    ConnectionMetaHandler handler = (ConnectionMetaHandler)request.getSession().getAttribute("handler");
		ConnectionProfile profile = getConnectionProfile(request);
		
		String sFolder = null;
		if (sFolder == null || sFolder.equals("")) {
			sFolder = org.claros.commons.mail.utility.Constants.FOLDER_INBOX(profile);
		}

		FolderControllerFactory foldFact = new FolderControllerFactory(getAuthProfile(request), profile, handler);
		FolderController folderCont = foldFact.getFolderController();
		if (profile.getProtocol().equals(Constants.POP3)) {
			if (sFolder == null || sFolder.equals("INBOX")) {
				FolderDbObject foldObj = folderCont.getInboxFolder();
				sFolder = foldObj.getId().toString();
			}
		}
		
		List folders = folderCont.getFolders();
		if (folders != null) {
			FolderDbObjectWrapper tmp = null;
			mailFolders = new MailFolder[folders.size()];
			for(int i=0; i<mailFolders.length; i++){
				tmp = (FolderDbObjectWrapper)folders.get(i);
				mailFolders[i] = new MailFolder(tmp.getId().toString(), tmp.getFolderName(), tmp.getFolderType());
				mailFolders[i].setUnreadItemCount(tmp.getUnreadItemCount().intValue());
			}
		}
		return mailFolders;
	}

	@Override
	public InstanceInfoList getMailInstanceList(String folderId, RequestParams params) throws Exception {

		InstanceInfoList instanceInfoList = new InstanceInfoList();

	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpServletRequest request = attr.getRequest();

		AuthProfile auth = getAuthProfile(request);
		// get folder and set it into sesssion
		String sFolder = MailFolder.getFolderNameById(folderId);

		// prepare variables
		List headers = null;
		ConnectionMetaHandler handler = getConnectionHandler(request);
		ConnectionProfile profile = getConnectionProfile(request);

		FolderControllerFactory foldFact = null;
		FolderController folderCont = null;
		String currFolder = org.claros.commons.mail.utility.Constants.FOLDER_INBOX(profile);

		try {
			if (auth == null) {
				throw new org.claros.commons.exception.NoPermissionException();
			}
			// if folder name is empty or it is inbox then do mail filtering. It is done by inbox controller
			if (sFolder == null || sFolder.equals("") || sFolder.equals(currFolder)) {
				try {
					InboxControllerFactory inFact = new InboxControllerFactory(auth, profile, handler);
					InboxController inCont = inFact.getInboxController();
					handler = inCont.checkEmail();
					request.getSession().setAttribute("handler", handler);
					foldFact = new FolderControllerFactory(auth, profile, handler);
					folderCont = foldFact.getFolderController();
				} catch (Exception e) {
				}

				// get the id(pop3) or the mail folder name (imap)
				if (profile.getProtocol().equals(org.claros.commons.mail.utility.Constants.POP3)) {
					currFolder = folderCont.getInboxFolder().getId().toString();
				} else {
					currFolder = folderCont.getInboxFolder().getFolderName();
				}
			} else {
				currFolder = sFolder;
				handler = (ConnectionMetaHandler)request.getSession().getAttribute("handler");
				foldFact = new FolderControllerFactory(auth, profile, handler);
				folderCont = foldFact.getFolderController();
			}
			request.getSession().setAttribute("folder", currFolder);

			// get info about the current folder
			FolderDbObject myFolder = folderCont.getFolder(currFolder);

			// time to fetch the headers
			if (profile.getProtocol().equals(org.claros.commons.mail.utility.Constants.POP3) && myFolder.getFolderType().equals(org.claros.intouch.common.utility.Constants.FOLDER_TYPE_INBOX)) {
				currFolder = org.claros.commons.mail.utility.Constants.FOLDER_INBOX(null);
			}

			// get and set sort parameters
			String mailSort = params.getSortingField().getFieldId();
			if(null==mailSort) mailSort = "date";
			String mailSortDirection = params.getSortingField().isAscending() ? "asc" : "desc";
			request.getSession().setAttribute("mailSort", mailSort);
			request.getSession().setAttribute("mailSortDirection", mailSortDirection);

			// first check to see if the server supports server side sorting or not. 
			// if it supports server side sorting it is a big performance enhancement.
			ArrayList sortedHeaders = null;
			boolean supportsServerSorting = false;
			try {
				// if the user doesn't want server side sorting for any reason(????) do not to server
				// side imap sorting.
				String disableImapSort = PropertyFile.getConfiguration("/config/config.xml").getString("common-params.disable-imap-sort");
				if (disableImapSort != null && (disableImapSort.toLowerCase().equals("yes") || disableImapSort.toLowerCase().equals("true"))) {
					sortedHeaders = null;
					supportsServerSorting = false;
				} else {
					// the user agrees on the performance enhancement imap sort offers. So go on.
					// let's give a try if the user supports it or not.
					ProtocolFactory pFact = new ProtocolFactory(profile, auth, handler);
					Protocol protocol = pFact.getProtocol(currFolder);
					
					sortedHeaders = protocol.getHeadersSortedList(mailSort, mailSortDirection);
					
					// profile has the boolean variable of it supports server side sorting or not!!!
					// so set it to the session for future references. 
					profile = protocol.getProfile();
					request.getSession().setAttribute("profile", profile);
					
					supportsServerSorting = true;
				}
			} catch (ProtocolNotAvailableException p) {
				sortedHeaders = null;
				supportsServerSorting = false;
			}
			
			// it is pop3 mode or the imap server doesn't support server side sorting. 
			if (!supportsServerSorting) {
				headers = folderCont.getHeadersByFolder(currFolder);
			}
			// if server side sorting is supported, do not fetch the messages yet. they will be fetched
			// when paging variables are set below. 

			
			// get and set pageNo
			int pageNo = 1;
			pageNo = params.getCurrentPage();
			
			boolean isAscending = false;
			if (mailSortDirection != null && mailSortDirection.equals("asc")) {
				isAscending = true;
			}
			
			// organize em
			String fromSort = "";
			String dateSort = "";
			String sizeSort = "";
			String subjectSort = "";
			
			if (mailSort == null || mailSort.equals("date")) {
				if (isAscending) dateSort = "asc"; else dateSort = "desc";
			} else if (mailSort.equals("from")) {
				if (isAscending) fromSort = "asc"; else fromSort = "desc";
			} else if (mailSort.equals("subject")) {
				if (isAscending) subjectSort = "asc"; else subjectSort = "desc";
			} else if (mailSort.equals("to")) {
				if (isAscending) fromSort = "asc"; else fromSort = "desc";
			} else if (mailSort.equals("size")) {
				if (isAscending) sizeSort = "asc"; else sizeSort = "desc";
			}
			
			if (myFolder.getFolderType().equals(org.claros.intouch.common.utility.Constants.FOLDER_TYPE_SENT)) {
				  if (mailSort != null && mailSort.equals("from")) {
					  mailSort = "to";
				  }
			} else {
				  if (mailSort != null && mailSort.equals("to")) {
					  mailSort = "from";
				  }
			}
			
			if (!supportsServerSorting) {
				// sort the headers
				Locale loc = new Locale(SmartUtil.getCurrentUser().getLocale());
				if (mailSort == null || mailSort.equals("date")) {
					Collections.sort(headers, new ComparatorDate(isAscending));
				} else if (mailSort.equals("from")) {
					Collections.sort(headers, new ComparatorFrom(isAscending, loc));
				} else if (mailSort.equals("subject")) {
					Collections.sort(headers, new ComparatorSubject(isAscending, loc));
				} else if (mailSort.equals("to")) {
					Collections.sort(headers, new ComparatorTo(isAscending, loc));
				} else if (mailSort.equals("size")) {
					Collections.sort(headers, new ComparatorSize(isAscending));
				}
			}
			
			// organize and generate XML from the headers.
			if (headers != null || supportsServerSorting) {
				EmailHeader tmp = null;
				int pageSize = params.getPageSize();
				
				// determine the message count. the method varies if server side or client side 
				// sorting is used. 
				int messageCount = -1;
				if (!supportsServerSorting) {
					messageCount = headers.size();
				} else {
					messageCount = sortedHeaders.size();
				}
				int pageCount = messageCount/pageSize;
				if((messageCount%pageSize)>0) pageCount++;
				if(pageNo > pageCount) pageNo = pageCount;
				int startIdx = (pageNo-1)*pageSize;
				if (startIdx < 0) startIdx = 0;
				int endIdx = startIdx+pageSize;
				if(endIdx > messageCount) endIdx = messageCount;
				
				instanceInfoList.setPageSize(pageSize);
				instanceInfoList.setCurrentPage(pageNo);
				instanceInfoList.setTotalPages(pageCount);
				instanceInfoList.setSortedField(new SortingField(mailSort, isAscending));
				
				MailInstanceInfo[] instanceInfos = null;
				// If server side sorting is supported, it is time to fetch the message headers. 
				// not all of the headers are fetched.
				if (supportsServerSorting) {
					int msgs[] = new int[endIdx - startIdx];
					int counter = 0;
					for (int y=startIdx;y<endIdx;y++) {
						msgs[counter] = ((Integer)sortedHeaders.get(y)).intValue();
						counter++;
					}
					headers = folderCont.getHeadersByFolder(currFolder, msgs);
					
					instanceInfos = new MailInstanceInfo[headers.size()];
					// we only have the headers to be displayed in the headers arraylist. 
					for (int i=0;i<headers.size();i++) {
						tmp = (EmailHeader)headers.get(i);
						InternetAddress from = (InternetAddress)tmp.getFrom()[0];
						MailInstanceInfo mailInstance = new MailInstanceInfo(Integer.toString(tmp.getMessageId()),
								tmp.getSubject(), new UserInfo(from.getAddress(), from.getPersonal()), new LocalDate(tmp.getDate().getTime()));						
						mailInstance.setSize(tmp.getSize());
						instanceInfos[i] = mailInstance;
					}
				} else {

					instanceInfos = new MailInstanceInfo[endIdx-startIdx];
					// with the client side sorting method the headers array has all the message headers
					// so with a for statement display them. 
					for (int i=startIdx;i<endIdx;i++) {
						tmp = (EmailHeader)headers.get(i);
						InternetAddress from = (InternetAddress)tmp.getFrom()[0];
						MailInstanceInfo mailInstance = new MailInstanceInfo(Integer.toString(tmp.getMessageId()),
								tmp.getSubject(), new UserInfo(from.getAddress(), from.getPersonal()), new LocalDate(tmp.getDate().getTime()));						
						mailInstance.setSize(tmp.getSize());
						instanceInfos[i-startIdx] = mailInstance;
					}
				}
				instanceInfoList.setInstanceDatas(instanceInfos);
			}
		} catch (Exception e) {
		}
		
		return instanceInfoList;
	}
	
	private int findHtmlBody(ArrayList parts) {
		for (int i=0;i<parts.size();i++) {
			EmailPart body = (EmailPart)parts.get(i);
			String cType = body.getContentType();
			if (cType.toLowerCase().startsWith("text/html")) {
				return i;
			}
		}
		return -1;
	}

	private int findTextBody(ArrayList parts) {
		for (int i=0;i<parts.size();i++) {
			EmailPart body = (EmailPart)parts.get(i);
			String cType = body.getContentType();
			if (cType.toLowerCase().startsWith("text/plain")) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public MailInstance getMailInstanceById(String folderId, String msgId) throws Exception {

		MailInstance instance = null;
		
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpServletRequest request = attr.getRequest();


		AuthProfile auth = getAuthProfile(request);

		ConnectionMetaHandler handler = (ConnectionMetaHandler)request.getSession().getAttribute("handler");
		ConnectionProfile profile = (ConnectionProfile)request.getSession().getAttribute("profile");

		MailControllerFactory factory = new MailControllerFactory(auth, profile, handler, folderId);
		MailController mailCont = factory.getMailController();
		
		try {
			Email email = mailCont.getEmailById(new Long(msgId));
			request.getSession().setAttribute("email", email);

			String format = "html";
			int i = -1;
			if (format == null || format.equals("html")) {
				i = findHtmlBody(email.getParts());
			}
			if (i == -1) {
				i = findTextBody(email.getParts());
			}

			String from = org.claros.intouch.common.utility.Utility.htmlCheck(org.claros.commons.utility.Utility.updateTRChars(email.getBaseHeader().getFromShown()));
			String to = org.claros.intouch.common.utility.Utility.htmlCheck(org.claros.commons.utility.Utility.updateTRChars(email.getBaseHeader().getToShown()));
			String cc = org.claros.intouch.common.utility.Utility.htmlCheck(org.claros.commons.utility.Utility.updateTRChars(email.getBaseHeader().getCcShown()));
			String date = org.claros.intouch.common.utility.Utility.htmlCheck(email.getBaseHeader().getDateShown());
			String subject = org.claros.intouch.common.utility.Utility.htmlCheck(org.claros.commons.utility.Utility.updateTRChars(email.getBaseHeader().getSubject()));
			Boolean sendReceiptNotification = email.getBaseHeader().getRequestReceiptNotification();
			String sendReceiptNotificationEmail = email.getBaseHeader().getReceiptNotificationEmail();
			String notificationEmail = "";
		
			if(sendReceiptNotification != null && sendReceiptNotification.booleanValue() && sendReceiptNotificationEmail !=null && email.getBaseHeader().getUnread().booleanValue()){
				notificationEmail = org.claros.commons.utility.Utility.convertTRCharsToHtmlSafe(sendReceiptNotificationEmail);
			}
			
			if (profile.getProtocol().equals(Constants.POP3)) {
				mailCont.markAsRead(new Long(msgId));
			}
			
			if (from == null || from.equals("")) {
				from = getText(request, "unknown.sender");
			}
			if (subject == null || subject.equals("")) {
				subject = getText(request, "no.subject");
			}
			
			InternetAddress addrFrom = (InternetAddress)email.getBaseHeader().getFrom()[0];
			InternetAddress[] addrTo = (InternetAddress[])email.getBaseHeader().getTo();			
			InternetAddress[] addrCc = (InternetAddress[])email.getBaseHeader().getCc();
			InternetAddress[] addrBcc = (InternetAddress[])email.getBaseHeader().getBcc();
			User sender = new User(addrFrom.getAddress(), addrFrom.getPersonal());
			User[] receivers = null;
			if(addrTo != null){
				receivers = new User[addrTo.length];
				for(int k=0; k<addrTo.length; k++)
					receivers[k] = new User(addrTo[k].getAddress(), addrTo[k].getPersonal());
			}
			User[] ccReceivers = null;
			if(addrCc != null){
				ccReceivers = new User[addrCc.length];
				for(int k=0; k<addrCc.length; k++)
					ccReceivers[k] = new User(addrCc[k].getAddress(), addrCc[k].getPersonal());
			}
			User[] bccReceivers = null;
			if(addrBcc != null){
				bccReceivers = new User[addrBcc.length];
				for(int k=0; addrBcc!=null && k<addrBcc.length; k++)
					bccReceivers[k] = new User(addrBcc[k].getAddress(), addrBcc[k].getPersonal());
			}
			
			instance = new MailInstance(msgId, subject, sender, new LocalDate(email.getBaseHeader().getDate().getTime()));
			instance.setCreatedDate(new LocalDate(email.getBaseHeader().getDate().getTime()));
			instance.setReceivers(receivers);
			instance.setCcReceivers(ccReceivers);
			instance.setBcccReceivers(bccReceivers);
			
			MailAttachment[] attachments = null;
			// parts begin
			List parts = email.getParts();
			if (parts != null) {
				if (parts.size() > 1 || i == -1) {
					EmailPart tmp = null;
					String mime = null;
					attachments = new MailAttachment[parts.size()];
					for (int j=0;j<parts.size();j++) {
						tmp = (EmailPart)parts.get(j);

						mime = tmp.getContentType();
						mime = mime.toLowerCase(new Locale(SmartUtil.getCurrentUser().getLocale())).trim();
						if (mime.indexOf(";") > 0) {
							mime = mime.substring(0, mime.indexOf(";"));
						}
						if (mime.indexOf(" ") > 0) {
							mime = mime.substring(0, mime.indexOf(" "));
						}
						String fileName = org.claros.commons.utility.Utility.updateTRChars(tmp.getFilename());
						attachments[j] = new MailAttachment(Integer.toString(j), fileName, mime, tmp.getSize());
					}
				}
			}
			instance.setPartId(i);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}

}