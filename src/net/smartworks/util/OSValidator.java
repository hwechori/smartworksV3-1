package net.smartworks.util;

public class OSValidator {

	public static String getImageDirectory() {
		String imageDirectory = "";
		if(isWindows())
			imageDirectory = SmartConfUtil.getInstance().getWindowsImageDirectory();
		else if(isMac())
			imageDirectory = SmartConfUtil.getInstance().getMacImageDirectory();
		else if(isUnix())
			imageDirectory = SmartConfUtil.getInstance().getUnixImageDirectory();
		else if(isSolaris())
			imageDirectory = SmartConfUtil.getInstance().getSolarisImageDirectory();

		return imageDirectory;
	}

	public static boolean isWindows() {
		 
		String os = System.getProperty("os.name").toLowerCase();
		// windows
		return (os.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Mac
		return (os.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// linux or unix
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
 
	}
 
	public static boolean isSolaris() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Solaris
		return (os.indexOf("sunos") >= 0);
 
	}

}