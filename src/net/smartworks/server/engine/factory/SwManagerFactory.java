/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 

package net.smartworks.server.engine.factory;

import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.task.manager.ITskManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SwManagerFactory {

	protected final Log logger = LogFactory.getLog(getClass());
	private ILnkManager lnkManager;
	private ITskManager tskManager;
//	private IChtManager chtManager;
//	private IPrcManager prcManager;
//	private IMdlManager mdlManager;
//	private ILcsManager lcsManager;
//	private IUpdManager updManager;
//	private IAprManager aprManager;
	//private IRepManager repManager;
	private ISwdManager swdManager;
	private ISwfManager swfManager;
	private ISwoManager swoManager;

	public ISwdManager getSwdManager() {
		return swdManager;
	}
	public void setSwdManager(ISwdManager swdManager) {
		this.swdManager = swdManager;
	}

	public ISwfManager getSwfManager() {
		return swfManager;
	}
	public void setSwfManager(ISwfManager swfManager) {
		this.swfManager = swfManager;
	}
	public SwManagerFactory() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	private static SwManagerFactory factory;
	
	public synchronized static SwManagerFactory createInstance() {
		if(factory == null) 
			factory = new SwManagerFactory();
		return factory;
	}
	public static SwManagerFactory getInstance() {
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
	public ISwoManager getSwoManager() {
		return swoManager;
	}
	public void setSwoManager(ISwoManager swoManager) {
		this.swoManager = swoManager;
	}
}
*/