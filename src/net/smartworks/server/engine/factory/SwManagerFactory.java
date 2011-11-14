/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.factory;

//import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.process.approval.manager.IAprManager;
import net.smartworks.server.engine.process.deploy.manager.IDepManager;
import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.monitoring.manager.IMonManager;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.task.manager.ITskManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SwManagerFactory {

	private static SwManagerFactory factory;
	
	protected final Log logger = LogFactory.getLog(getClass());
	private ILnkManager lnkManager;
	private IColManager colManager;
	private ITskManager tskManager;
	private IDepManager depManager;
	private IAprManager aprManager;
	private IPrcManager prcManager;
	private ISwfManager swfManager;
	private ISwoManager swoManager;
	private ISwdManager swdManager;
	private IMonManager monManager;
	private IPkgManager pkgManager;
	private ICtgManager ctgManager;
//	private IChtManager chtManager;
//	private IMdlManager mdlManager;
//	private ILcsManager lcsManager;
//	private IUpdManager updManager;
	//private IRepManager repManager;

	public SwManagerFactory() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public synchronized static SwManagerFactory createInstance() {
		if(factory == null) 
			factory = new SwManagerFactory();
		return factory;
	}
	public IDepManager getDepManager() {
		return depManager;
	}
	public void setDepManager(IDepManager depManager) {
		this.depManager = depManager;
	}
	public IColManager getColManager() {
		return colManager;
	}
	public void setColManager(IColManager colManager) {
		this.colManager = colManager;
	}
	public ISwfManager getSwfManager() {
		return swfManager;
	}
	public void setSwfManager(ISwfManager swfManager) {
		this.swfManager = swfManager;
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
	public ISwoManager getSwoManager() {
		return swoManager;
	}
	public void setSwoManager(ISwoManager swoManager) {
		this.swoManager = swoManager;
	}
	public IPrcManager getPrcManager() {
		return prcManager;
	}
	public void setPrcManager(IPrcManager prcManager) {
		this.prcManager = prcManager;
	}
	public IAprManager getAprManager() {
		return aprManager;
	}
	public void setAprManager(IAprManager aprManager) {
		this.aprManager = aprManager;
	}
	public ISwdManager getSwdManager() {
		return swdManager;
	}
	public void setSwdManager(ISwdManager swdManager) {
		this.swdManager = swdManager;
	}
	public IMonManager getMonManager() {
		return monManager;
	}
	public void setMonManager(IMonManager monManager) {
		this.monManager = monManager;
	}
	public IPkgManager getPkgManager() {
		return pkgManager;
	}
	public void setPkgManager(IPkgManager pkgManager) {
		this.pkgManager = pkgManager;
	}
	public ICtgManager getCtgManager() {
		return ctgManager;
	}
	public void setCtgManager(ICtgManager ctgManager) {
		this.ctgManager = ctgManager;
	}
	
//	public IChtManager getChtManager() {
//		return chtManager;
//	}
//	public void setChtManager(IChtManager chtManager) {
//		this.chtManager = chtManager;
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
}
