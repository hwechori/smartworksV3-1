package net.smartworks.server.engine.pkg.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.pkg.exception.SwpException;
import net.smartworks.server.engine.pkg.model.SwpPackage;
import net.smartworks.server.engine.pkg.model.SwpPackageCond;

public interface ISwpManager extends IManager {
	public SwpPackage getPackage(String userId, String id, String level) throws SwpException;
	public SwpPackage getPackage(String userId, SwpPackageCond cond, String level) throws SwpException;
	public void setPackage(String userId, SwpPackage obj, String level) throws SwpException;
	public void createPackage(String userId, SwpPackage obj) throws SwpException;
	public void removePackage(String userId, String id) throws SwpException;
	public void removePackage(String userId, SwpPackageCond cond) throws SwpException;
	public long getPackageSize(String userId, SwpPackageCond cond) throws SwpException;
	public SwpPackage[] getPackages(String userId, SwpPackageCond cond, String level) throws SwpException;
}
