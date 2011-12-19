/*	
 * $Id: SmartConfUtil.java,v 1.1 2011/10/20 04:06:06 ysjung Exp $
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 10. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.util;

public class SmartConfUtil {

	private static SmartConfUtil util;

	private String imageServer;
	private String imageServerDirectory;

	public String getImageServerDirectory() {
		return imageServerDirectory;
	}

	public void setImageServerDirectory(String imageServerDirectory) {
		this.imageServerDirectory = imageServerDirectory;
	}

	public static SmartConfUtil getInstance() {
		if(util == null)
			util = new SmartConfUtil();
		return util;
	}

	public static synchronized SmartConfUtil createInstance() {
		if(util == null)
			util = new SmartConfUtil();
		return util;
	}

	public String getImageServer() {
		return imageServer;
	}

	public void setImageServer(String imageServer) {
		this.imageServer = imageServer;
	}

}