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
	private String windowsImageDirectory;
	private String macImageDirectory;
	private String unixImageDirectory;
	private String solarisImageDirectory;

	public String getWindowsImageDirectory() {
		return windowsImageDirectory;
	}

	public void setWindowsImageDirectory(String windowsImageDirectory) {
		this.windowsImageDirectory = windowsImageDirectory;
	}

	public String getMacImageDirectory() {
		return macImageDirectory;
	}

	public void setMacImageDirectory(String macImageDirectory) {
		this.macImageDirectory = macImageDirectory;
	}

	public String getUnixImageDirectory() {
		return unixImageDirectory;
	}

	public void setUnixImageDirectory(String unixImageDirectory) {
		this.unixImageDirectory = unixImageDirectory;
	}

	public String getSolarisImageDirectory() {
		return solarisImageDirectory;
	}

	public void setSolarisImageDirectory(String solarisImageDirectory) {
		this.solarisImageDirectory = solarisImageDirectory;
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