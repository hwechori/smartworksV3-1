package net.smartworks.server.engine.pkg.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.pkg.exception.SwpException;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;

public interface IPkgManager extends IManager {
	public PkgPackage getPackage(String userId, String id, String level) throws SwpException;
	public PkgPackage getPackage(String userId, PkgPackageCond cond, String level) throws SwpException;
	public void setPackage(String userId, PkgPackage obj, String level) throws SwpException;
	public void createPackage(String userId, PkgPackage obj) throws SwpException;
	public void removePackage(String userId, String id) throws SwpException;
	public void removePackage(String userId, PkgPackageCond cond) throws SwpException;
	public long getPackageSize(String userId, PkgPackageCond cond) throws SwpException;
	public PkgPackage[] getPackages(String userId, PkgPackageCond cond, String level) throws SwpException;
}
