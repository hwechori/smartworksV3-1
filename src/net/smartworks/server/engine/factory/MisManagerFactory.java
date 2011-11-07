/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.factory;

import javax.annotation.PostConstruct;

import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.task.manager.ITskManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public class MisManagerFactory {

	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	ILnkManager lnkManager;
	@Autowired
	ITskManager tskManager;
//	private IChtManager chtManager;
//	private IPrcManager prcManager;
//	private IMdlManager mdlManager;
//	private ILcsManager lcsManager;
//	private IUpdManager updManager;
//	private IAprManager aprManager;
	//private IRepManager repManager;

	public MisManagerFactory() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	private static MisManagerFactory factory;
	
	@PostConstruct
	public synchronized static MisManagerFactory createInstance() {
		if(factory == null) 
			factory = new MisManagerFactory();
		return factory;
	}
	public static MisManagerFactory getInstance() {
		return factory;
	}
	public ILnkManager getLnkManager() {
		return lnkManager;
	}
	public void setLnkManager(ILnkManager lnkManager) {
		this.lnkManager = lnkManager;
	}
	public ITskManager getTskManager() {
		return tskManager;
	}
	public void setTskManager(ITskManager tskManager) {
		this.tskManager = tskManager;
	}
//	public IChtManager getChtManager() {
//		return chtManager;
//	}
//	public void setChtManager(IChtManager chtManager) {
//		this.chtManager = chtManager;
//	}
//	public IPrcManager getPrcManager() {
//		return prcManager;
//	}
//	public void setPrcManager(IPrcManager prcManager) {
//		this.prcManager = prcManager;
//	}
//	public IMdlManager getMdlManager() {
//		return mdlManager;
//	}
//	public void setMdlManager(IMdlManager mdlManager) {
//		this.mdlManager = mdlManager;
//	}
////	public IRepManager getRepManager() {
////		return repManager;
////	}
////	public void setRepManager(IRepManager repManager) {
////		this.repManager = repManager;
////	}
//	public ILcsManager getLcsManager() {
//		return lcsManager;
//	}
//	public void setLcsManager(ILcsManager lcsManager) {
//		this.lcsManager = lcsManager;
//	}
//	public IUpdManager getUpdManager() {
//		return updManager;
//	}
//	public void setUpdManager(IUpdManager updManager) {
//		this.updManager = updManager;
//	}
//	public IAprManager getAprManager() {
//		return aprManager;
//	}
//	public void setAprManager(IAprManager aprManager) {
//		this.aprManager = aprManager;
//	}
}
