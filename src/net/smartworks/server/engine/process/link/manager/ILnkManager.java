package net.smartworks.server.engine.process.link.manager;

import org.springframework.stereotype.Service;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.process.link.exception.LnkException;
import net.smartworks.server.engine.process.link.model.LnkLink;
import net.smartworks.server.engine.process.link.model.LnkLinkCond;

public interface ILnkManager extends IManager {
	public LnkLink getLink(String user, String objId, String level) throws LnkException;
	public LnkLink getLink(String user, LnkLinkCond cond, String level) throws LnkException;
	public void setLink(String user, LnkLink obj, String level) throws LnkException;
	public void createLink(String user, LnkLink obj) throws LnkException;
	public void removeLink(String user, String objId) throws LnkException;
	public void removeLink(String user, LnkLinkCond cond) throws LnkException;
	public long getLinkSize(String user, LnkLinkCond cond) throws LnkException;
	public LnkLink[] getLinks(String user, LnkLinkCond cond, String level) throws LnkException;
	public void removeLinks(String user, LnkLinkCond cond) throws LnkException;
	
}
