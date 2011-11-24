/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 23.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.util;

import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.WorkInstanceInfo;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;

public interface IModelConverter {
	// ##########################  Info Class Converter - Array to Array  ##################################
	
	// --------------------------  Convert By Object  ------------------------------------------------------

	abstract InstanceInfo[] getInstanceInfoArrayByPrcProcessInstArray(InstanceInfo[] instInfo, PrcProcessInst[] prcInsts) throws Exception;
	
	abstract WorkInstanceInfo[] getWorkInstanceInfoArrayByPrcProcessInstArray(InstanceInfo[] instInfo, PrcProcessInst[] prcInsts) throws Exception;
	
	
	// --------------------------  Convert By Id -----------------------------------------------------------

	abstract InstanceInfo[] getInstanceInfoArrayByPrcProcessInstIdArray(String[] ids) throws Exception;
	
	
	// ##########################  Info Class Converter - Object to Object  ################################

	// --------------------------  Convert By Object  ------------------------------------------------------
	
	// --------------------------  Convert By Id -----------------------------------------------------------
	
	// ##########################  Class Converter - Array to Array  #######################################

	// --------------------------  Convert By Object  ------------------------------------------------------
	
	// --------------------------  Convert By Id -----------------------------------------------------------
	
	// ##########################  Class Converter - Object to Object ######################################
	
	// --------------------------  Convert By Object  ------------------------------------------------------
	
	// --------------------------  Convert By Id -----------------------------------------------------------
}
