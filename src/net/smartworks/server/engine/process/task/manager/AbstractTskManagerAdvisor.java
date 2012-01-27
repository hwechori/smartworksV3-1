package net.smartworks.server.engine.process.task.manager;

import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.common.script.manager.ISctManager;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.process.approval.manager.IAprManager;
import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.task.exception.TskException;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.task.model.TskTaskDef;
import net.smartworks.server.engine.process.task.model.TskTaskDefCond;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AbstractTskManagerAdvisor {
	protected final Log logger = LogFactory.getLog(getClass());
	private static String M_GETTASK = "getTask";
	private static String M_SETTASK = "setTask";
	private static String M_REMOVETASK = "removeTask";
	private static String M_GETTASKSIZE = "getTaskSize";
	private static String M_GETTASKS= "getTasks";
	private static String M_EXECUTETASK= "executeTask";
	private static String M_GETTASKDEF = "getTaskDef";
	private static String M_SETTASKDEF = "setTaskDef";
	private static String M_REMOVETASKDEF = "removeTaskDef";
	private static String M_GETTASKDEFSIZE = "getTaskDefSize";
	private static String M_GETTASKDEFS= "getTaskDefs";

	private ITskManager tskManager;
	private ILnkManager lnkManager;
	private IPrcManager prcManager;
	private IColManager colManager;
	private IAprManager aprManager;
	private ISwdManager swdManager;
	private ISwfManager swfManager;
	private ISctManager sctManager;
//	private IPrcManager prcManager;
//	private IChtManager chtManager;
//	private IPrcAdminService prcService;
//	private ITskAdminService tskService;
//	private IMonAdminService monXpdlService;
//	private IChtAdminService chtService;
	public IColManager getColManager() {
		if (colManager == null)
			colManager = SwManagerFactory.getInstance().getColManager();
		return colManager;
	}
	public ITskManager getTskManager() {
		if (tskManager == null)
			tskManager = SwManagerFactory.getInstance().getTskManager();
		return tskManager;
	}
	public ILnkManager getLnkManager() {
		if (lnkManager == null)
			lnkManager = SwManagerFactory.getInstance().getLnkManager();
		return lnkManager;
	}
	public IPrcManager getPrcManager() {
		if (prcManager == null)
			prcManager = SwManagerFactory.getInstance().getPrcManager();
		return prcManager;
	}
	public IAprManager getAprManager() {
		if (aprManager == null)
			aprManager = SwManagerFactory.getInstance().getAprManager();
		return aprManager;
	}

	public ISwdManager getSwdManager() {
		if (swdManager == null)
			swdManager = SwManagerFactory.getInstance().getSwdManager();
		return swdManager;
	}
	public ISwfManager getSwfManager() {
		if (swfManager == null)
			swfManager = SwManagerFactory.getInstance().getSwfManager();
		return swfManager;
	}
	public ISctManager getSctManager() {
		if (sctManager == null)
			sctManager = SwManagerFactory.getInstance().getSctManager();
		return sctManager;
	}
	
	public AbstractTskManagerAdvisor() {
		super();
	}
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();
		String methodName = joinPoint.getSignature().getName();
		
		try {
			if (methodName.equals(M_GETTASK)) {
				this.preGetTask((String)args[0], (String)args[1], (String)args[2]);
			} else if (methodName.equals(M_SETTASK)) {
				this.preSetTask((String)args[0], (TskTask)args[1], (String)args[2]);
			} else if (methodName.equals(M_REMOVETASK)) {
				this.preRemoveTask((String)args[0], (String)args[1]);
			} else if (methodName.equals(M_GETTASKSIZE)) {
				this.preGetTaskSize((String)args[0], (TskTaskCond)args[1]);
			} else if (methodName.equals(M_GETTASKS)) {
				this.preGetTasks((String)args[0], (TskTaskCond)args[1], (String)args[2]);
			} else if (methodName.equals(M_EXECUTETASK)) {
				this.preExecuteTask((String)args[0], (TskTask)args[1], (String)args[2]);
			} else if (methodName.equals(M_GETTASKDEF)) {
				this.preGetTaskDef((String)args[0], (String)args[1], (String)args[2]);
			} else if (methodName.equals(M_SETTASKDEF)) {
				this.preSetTaskDef((String)args[0], (TskTaskDef)args[1], (String)args[2]);
			} else if (methodName.equals(M_REMOVETASKDEF)) {
				this.preRemoveTaskDef((String)args[0], (String)args[1]);
			} else if (methodName.equals(M_GETTASKDEFSIZE)) {
				this.preGetTaskDefSize((String)args[0], (TskTaskDefCond)args[1]);
			} else if (methodName.equals(M_GETTASKDEFS)) {
				this.preGetTaskDefs((String)args[0], (TskTaskDefCond)args[1], (String)args[2]);
			}
			
			Object res = joinPoint.proceed();
			
			if (methodName.equals(M_GETTASK)) {
				this.postGetTask((String)args[0], (String)args[1], (String)args[2], (TskTask)res);
			} else if (methodName.equals(M_SETTASK)) {
				this.postSetTask((String)args[0], (TskTask)args[1], (String)args[2]);
			} else if (methodName.equals(M_REMOVETASK)) {
				this.postRemoveTask((String)args[0], (String)args[1]);
			} else if (methodName.equals(M_GETTASKSIZE)) {
				this.postGetTaskSize((String)args[0], (TskTaskCond)args[1], ((Long)res).longValue());
			} else if (methodName.equals(M_GETTASKS)) {
				this.postGetTasks((String)args[0], (TskTaskCond)args[1], (String)args[2], (TskTask[])res);
			} else if (methodName.equals(M_EXECUTETASK)) {
				this.postExecuteTask((String)args[0], (TskTask)args[1], (String)args[2]);
			} else if (methodName.equals(M_GETTASKDEF)) {
				this.postGetTaskDef((String)args[0], (String)args[1], (String)args[2], (TskTaskDef)res);
			} else if (methodName.equals(M_SETTASKDEF)) {
				this.postSetTaskDef((String)args[0], (TskTaskDef)args[1], (String)args[2]);
			} else if (methodName.equals(M_REMOVETASKDEF)) {
				this.postRemoveTaskDef((String)args[0], (String)args[1]);
			} else if (methodName.equals(M_GETTASKDEFSIZE)) {
				this.postGetTaskDefSize((String)args[0], (TskTaskDefCond)args[1], ((Long)res).longValue());
			} else if (methodName.equals(M_GETTASKDEFS)) {
				this.postGetTaskDefs((String)args[0], (TskTaskDefCond)args[1], (String)args[2], (TskTaskDef[])res);
			}
			
			return res;
			
		} catch (TskException e) {
			throw e;
		} catch (Throwable t) {
			throw new TskException(t);
		}
	}

	public void preGetTask(String user, String id, String level) throws Exception {
	}
	public void preSetTask(String user, TskTask obj, String level) throws Exception {
	}
	public void preRemoveTask(String user, String id) throws Exception {
	}
	public void preGetTaskSize(String user, TskTaskCond cond) throws Exception {
	}
	public void preGetTasks(String user, TskTaskCond cond, String level) throws Exception {
	}
	public void preExecuteTask(String user, TskTask obj, String action) throws Exception {
	}
	public void postGetTask(String user, String id, String level, TskTask res) throws Exception {
	}
	public void postSetTask(String user, TskTask obj, String level) throws Exception {
	}
	public void postRemoveTask(String user, String id) throws Exception {
	}
	public void postGetTaskSize(String user, TskTaskCond cond, long res) throws Exception {
	}
	public void postGetTasks(String user, TskTaskCond cond, String level, TskTask[] res) throws Exception {
	}
	public void postExecuteTask(String user, TskTask obj, String action) throws Exception {
	}

	public void preGetTaskDef(String user, String id, String level) throws Exception {
	}
	public void preSetTaskDef(String user, TskTaskDef obj, String level) throws Exception {
	}
	public void preRemoveTaskDef(String user, String id) throws Exception {
	}
	public void preGetTaskDefSize(String user, TskTaskDefCond cond) throws Exception {
	}
	public void preGetTaskDefs(String user, TskTaskDefCond cond, String level) throws Exception {
	}
	public void preExecuteTaskDef(String user, TskTaskDef obj, String action) throws Exception {
	}
	public void postGetTaskDef(String user, String id, String level, TskTaskDef res) throws Exception {
	}
	public void postSetTaskDef(String user, TskTaskDef obj, String level) throws Exception {
	}
	public void postRemoveTaskDef(String user, String id) throws Exception {
	}
	public void postGetTaskDefSize(String user, TskTaskDefCond cond, long res) throws Exception {
	}
	public void postGetTaskDefs(String user, TskTaskDefCond cond, String level, TskTaskDef[] res) throws Exception {
	}
	public void postExecuteTaskDef(String user, TskTaskDef obj, String action) throws Exception {
	}
}
