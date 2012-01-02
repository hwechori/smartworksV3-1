package net.smartworks.server.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.mail.MailFolder;
import net.smartworks.server.service.IMailService;

import org.claros.commons.mail.models.ConnectionMetaHandler;
import org.claros.commons.mail.models.ConnectionProfile;
import org.claros.commons.mail.utility.Constants;
import org.claros.intouch.common.services.BaseService;
import org.claros.intouch.webmail.controllers.FolderController;
import org.claros.intouch.webmail.factory.FolderControllerFactory;
import org.claros.intouch.webmail.models.FolderDbObject;
import org.claros.intouch.webmail.models.FolderDbObjectWrapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class MailServiceImpl_org implements IMailService {
	
	@Override
	public MailFolder[] getMailFoldersById(String folderId) throws Exception {
		MailFolder[] mailFolders = null;

//	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//	    HttpServletRequest request = attr.getRequest();
//	    ConnectionMetaHandler handler = (ConnectionMetaHandler)request.getSession().getAttribute("handler");
//		ConnectionProfile profile = getConnectionProfile(request);
//		
//		String sFolder = (String)getVariable(request, "folder");
//		if (sFolder == null || sFolder.equals("")) {
//			sFolder = org.claros.commons.mail.utility.Constants.FOLDER_INBOX(profile);
//		}
//
//		FolderControllerFactory foldFact = new FolderControllerFactory(getAuthProfile(request), profile, handler);
//		FolderController folderCont = foldFact.getFolderController();
//		if (profile.getProtocol().equals(Constants.POP3)) {
//			if (sFolder == null || sFolder.equals("INBOX")) {
//				FolderDbObject foldObj = folderCont.getInboxFolder();
//				sFolder = foldObj.getId().toString();
//			}
//		}
//		
//		List folders = folderCont.getFolders();
//		if (folders != null) {
//			FolderDbObjectWrapper tmp = null;
//			String folderName = null;
//			String folderNameEnc = null;
//			String folderNameLang = null;
////			for (int i=0;i<folders.size();i++) {
////				tmp = (FolderDbObjectWrapper)folders.get(i);
////				folderName = folderNameLang = tmp.getFolderName();
////				folderNameEnc = java.net.URLEncoder.encode(folderName, "utf-8");
////				if(tmp.getFolderType().intValue() < 6) {
////					folderNameLang = getText(request, folderName.replace(' ', '.'));
////				}
////				if (folderNameLang == null || folderNameLang.length() == 0) {
////					folderNameLang = folderName;
////				}
////				
////				folderNameLang = org.claros.intouch.common.utility.Utility.htmlCheck(folderNameLang);
////				if (profile.getProtocol().equals(Constants.IMAP)) {
////					out.print("<li " + ((folderName.equals(sFolder)) ? "class=\"active\"" : "") + " folderType=\"" + tmp.getFolderType() + "\" folderId=\"" + folderNameEnc  + "\" folderName=\"" + folderNameLang + "\" id=\"mailFolder" + folderNameEnc + "\" onclick=\"selectMailFolder('" + folderNameEnc + "')\"><div>"); 
////				} else {
////					out.print("<li " + ((tmp.getId().toString().equals(sFolder)) ? "class=\"active\"" : "") + " folderType=\"" + tmp.getFolderType() + "\" folderId=\"" + tmp.getId()  + "\" folderName=\"" + folderNameLang + "\" id=\"mailFolder" + tmp.getId() + "\" onclick=\"selectMailFolder('" + tmp.getId() + "')\"><div>");
////				}
////				if (tmp.getUnreadItemCount().intValue() > 0) {
////					out.print("<em><i class='left'>&nbsp;</i><b id=\"folderUnreadCount\">" + tmp.getUnreadItemCount() + "</b><i class=\"right\">&nbsp;</i></em>");
////				}
////				
////				String tmpF = folderNameLang;
////				if (folderNameLang.length() > 15) {
////					tmpF = folderNameLang.substring(0, 13) + "...";
////				}
////			}
//			mailFolders = new MailFolder[folders.size()];
//			for(int i=0; i<mailFolders.length; i++){
//				tmp = (FolderDbObjectWrapper)folders.get(i);
//				folderName = folderNameLang = tmp.getFolderName();
//				mailFolders[i] = new MailFolder(tmp.getId().toString(), tmp.getFolderName(), tmp.getFolderType());
//			}
//		}
		return mailFolders;
	}
}