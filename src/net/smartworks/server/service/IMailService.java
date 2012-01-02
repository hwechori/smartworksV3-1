package net.smartworks.server.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.mail.MailFolder;
import net.smartworks.model.report.Data;
import net.smartworks.model.report.Report;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.form.exception.SwfException;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;

public interface IMailService {

	public MailFolder[] getMailFoldersById(String folderId) throws Exception;

}