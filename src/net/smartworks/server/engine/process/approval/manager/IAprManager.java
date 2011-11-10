package net.smartworks.server.engine.process.approval.manager;

import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.process.approval.exception.AprException;
import net.smartworks.server.engine.process.approval.model.AprApproval;
import net.smartworks.server.engine.process.approval.model.AprApprovalCond;
import net.smartworks.server.engine.process.approval.model.AprApprovalLine;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineCond;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineDef;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineDefCond;


public interface IAprManager extends IManager {
	public AprApproval getApproval(String user, String objId, String level) throws AprException;
	public AprApproval getApproval(String user, AprApprovalCond cond, String level) throws AprException;
	public void setApproval(String user, AprApproval obj, String level) throws AprException;
	public void createApproval(String user, AprApproval obj) throws AprException;
	public void removeApproval(String user, String objId) throws AprException;
	public void removeApproval(String user, AprApprovalCond cond) throws AprException;
	public long getApprovalSize(String user, AprApprovalCond cond) throws AprException;
	public AprApproval[] getApprovals(String user, AprApprovalCond cond, String level) throws AprException;

	public AprApprovalLine getApprovalLine(String user, String objId, String level) throws AprException;
	public AprApprovalLine getApprovalLine(String user, AprApprovalLineCond cond, String level) throws AprException;
	public void setApprovalLine(String user, AprApprovalLine obj, String level) throws AprException;
	public void createApprovalLine(String user, AprApprovalLine obj) throws AprException;
	public void removeApprovalLine(String user, String objId) throws AprException;
	public void removeApprovalLine(String user, AprApprovalLineCond cond) throws AprException;
	public long getApprovalLineSize(String user, AprApprovalLineCond cond) throws AprException;
	public AprApprovalLine[] getApprovalLines(String user, AprApprovalLineCond cond, String level) throws AprException;
		
	public AprApprovalLineDef getApprovalLineDef(String userId, String objId, String level) throws AprException;
	public AprApprovalLineDef getApprovalLineDef(String userId, AprApprovalLineDefCond cond, String level) throws AprException;
	public void setApprovalLineDef(String userId, AprApprovalLineDef obj, String level) throws AprException;
	public void createApprovalLineDef(String userId, AprApprovalLineDef obj) throws AprException;
	public void removeApprovalLineDef(String userId, String objId) throws AprException;
	public void removeApprovalLineDef(String userId, AprApprovalLineDefCond cond) throws AprException;
	public long getApprovalLineDefSize(String userId, AprApprovalLineDefCond cond) throws AprException;
	public AprApprovalLineDef[] getApprovalLineDefs(String userId, AprApprovalLineDefCond cond, String level) throws AprException;
}
