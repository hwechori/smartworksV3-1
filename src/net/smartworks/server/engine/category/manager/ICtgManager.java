package net.smartworks.server.engine.category.manager;

import net.smartworks.server.engine.category.exception.CtgException;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.IManager;

public interface ICtgManager extends IManager {
	
	public CtgCategory getCategory(String user, String objId, String level) throws CtgException;
	public CtgCategory getCategory(String user, CtgCategoryCond cond, String level) throws CtgException;
	public CtgCategory createCategory(String user, CtgCategory obj) throws CtgException;
	public CtgCategory setCategory(String user, CtgCategory obj, String level) throws CtgException;
	public void removeCategory(String user, String objId) throws CtgException;
	public long getCategorySize(String user, CtgCategoryCond cond) throws CtgException;
	public CtgCategory[] getCategorys(String user, CtgCategoryCond cond, String level) throws CtgException;

}
