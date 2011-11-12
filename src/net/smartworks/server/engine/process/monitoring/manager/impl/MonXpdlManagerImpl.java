package net.smartworks.server.engine.process.monitoring.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.common.collection.model.ColValue;
import net.smartworks.server.engine.common.collection.model.ColValueCond;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.MisUtil;
import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.link.model.LnkLink;
import net.smartworks.server.engine.process.link.model.LnkLinkCond;
import net.smartworks.server.engine.process.monitoring.Exception.MonException;
import net.smartworks.server.engine.process.monitoring.manager.IMonManager;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.task.manager.ITskManager;
import net.smartworks.server.engine.process.task.model.TskTask;
import net.smartworks.server.engine.process.task.model.TskTaskCond;
import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;
import net.smartworks.server.engine.process.xpdl.xpdl2.Task;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transition;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl2.WorkflowProcesses;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.org.apache.xpath.internal.XPathAPI;
import commonj.sdo.Sequence;

public class MonXpdlManagerImpl implements IMonManager{
	protected final Log logger = LogFactory.getLog(getClass());
	
	private IPrcManager prcManager;
	private ITskManager tskManager;
	private ILnkManager lnkManager;
	private IColManager colManager;
	public MonXpdlManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	public IPrcManager getPrcManager() {
		if (prcManager == null)
			prcManager = SwManagerFactory.getInstance().getPrcManager();
		return prcManager;
	}
	public ILnkManager getLnkManager() {
		if (lnkManager == null)
			lnkManager = SwManagerFactory.getInstance().getLnkManager();
		return lnkManager;
	}
	public ITskManager getTskManager() {
		if (tskManager == null)
			tskManager = SwManagerFactory.getInstance().getTskManager();
		return tskManager;
	}
	public IColManager getColManager() {
		if (colManager == null)
			colManager = SwManagerFactory.getInstance().getColManager();
		return colManager;
	}
	public String monitor(String user, String str, Property[] opts) throws MonException {
		try {
			String monStr = refresh(user, str);
			return monStr;
		} catch (MonException e) {
			throw e;
		} catch (Exception e) {
			throw new MonException(e);
		}
	}
	private PrcProcess getProcess(String user, String id) throws Exception {
		if (id == null || id.length() == 0)
			return null;
		
		PrcProcessCond cond = new PrcProcessCond();
		cond.setDiagramId(id);
		cond.setPageSize(1);
		PrcProcess[] prcs = getPrcManager().getProcesses(user, cond, LEVEL_LITE);
		if (prcs == null || prcs.length == 0)
			return null;
		return prcs[0];
	}
	private PrcProcessInst getProcessInst(String user, String id, String level) throws Exception {
		PrcProcessInst prcInst = getPrcManager().getProcessInst(user, id, LEVEL_LITE);
		return prcInst;
	}
	private String refresh(String user, String id) throws Exception {
		// 프로세스 인스턴스 조회
		PrcProcessInst prcInst = getProcessInst(user, id, LEVEL_ALL);
		if (prcInst == null)
			return null;
		
		// 다이어그램 스트링 조회
		String str = this.getDiagram(user, prcInst);
		if (str == null || str.length() == 0)
			return null;
		
		// XPDL 로딩
		PackageType pt = ProcessModelHelper.load(str);
		String prcName = pt.getName();
		
		// 태스크 목록 조회
		TskTask[] tasks = getTasksByProcessInstId(user, id);
		if (tasks == null || tasks.length == 0)
			return str;
		// 태스크 맵 구성
		Map taskMap = new HashMap();
		String title = null;
		if (tasks != null && tasks.length != 0) {
			TskTask task = null;
			for (int i = 0; i < tasks.length; i++) {
				task = tasks[i];
				String actId = task.getExtendedPropertyValue("activityId");
				if (actId != null && actId.length() != 0) {
					taskMap.put(actId, task);
					title = task.getTitle();
				}
			}
		}
		
		// 링크 맵 조회
		Map linkMap = this.getLinkMapByProcessInstId(user, id);
		
		// 제목 설정
		prcInst.setTitle(new StringBuffer("[").append(prcName).append("] ").append(CommonUtil.toNotNull(title)).toString());
		// 상태 설정
		List prcList = null;
		WorkflowProcesses prcs = pt.getWorkflowProcesses();
		if (prcs != null)
			prcList = prcs.getWorkflowProcess();
		if (prcList != null && !prcList.isEmpty()) {
			for (Iterator prcIter = prcList.iterator(); prcIter.hasNext();) {
				ProcessType1 prc = (ProcessType1) prcIter.next();
				
				Activities acts = prc.getActivities();
				Transitions trans = prc.getTransitions();

				// 액티비티 상태 설정
				this.setActivitiesStatus(acts, taskMap);
				
				// 트랜지션 상태 설정
				this.setTransitionsStatus(trans, linkMap);
				
			}
		}
		String monStr = ProcessModelHelper.save(pt, "UTF-8");
		
		// 엑티비티의 실행시간정보 설정 //TODO activities 객체에 attribute를 삽입할수 없어 xml DOM 을 컨트롤하여 실제 실행,완료 시간을 삽입한다
		// this.setActivitiesStatus(acts, taskMap); 메소드 안에 객체 컨트롤 부분으로 들어가야합
		monStr = this.setActivitiesInfo(monStr, taskMap);//시간, 서브프로세스 타겟 인스턴스아이디를 셋팅한다
		
		return monStr;
	}
	private String getDiagram(String user, PrcProcessInst prcInst) throws Exception {
		String dId = prcInst.getDiagramId();
		if (dId == null)
			return null;
		String str = null;
		// 간트차트를 위하여 인스턴스에서 처음으로 다이어그램을 조회 한다.

		str = prcInst.getDiagram();
		if (str != null)
			return str;
		
		// 1. 프로세스 조회
		PrcProcess prc = getProcess("monitoringManager", dId);
		if (prc != null)
			str = prc.getDiagram();
		if (str != null)
			return str;

		// 2. 백업 프로세스 조회
		ColValueCond dCond = new ColValueCond();
		dCond.setType("process.diagram");
		dCond.setRef(dId);
		ColValue[] ds = this.getColManager().getValues("monitoringManager", dCond, null);
		if (ds != null && ds.length != 0)
			str = ds[0].getValue();
		if (str != null)
			return str;
		
		// 마지막에 인스턴스에서 조회 하던것을 간트 차트를 위하여 처음으로 올린다.
		// 3. 인스턴스에서 조회
//		str = prcInst.getDiagram();
		return str;
	}
	private TskTask[] getTasksByProcessInstId(String user, String id) throws Exception {
		TskTaskCond taskCond = new TskTaskCond();
		taskCond.setProcessInstId(id);
		taskCond.setOrders(new Order[] {new Order(TskTask.A_CREATIONDATE, true)});
		TskTask[] tasks = getTskManager().getTasks(user, taskCond, LEVEL_ALL);
		return tasks;
	}
	private Map getLinkMapByProcessInstId(String user, String id) throws Exception {
		LnkLinkCond linkCond = new LnkLinkCond();
		linkCond.setType("processinst");
		linkCond.setCorrelation(id);
		linkCond.setOrders(new Order[] {new Order(TskTask.A_CREATIONDATE, true)});
		LnkLink[] links = getLnkManager().getLinks(user, linkCond, LEVEL_ALL);
		
		if (links == null || links.length == 0)
			return null;
		
		Map linkMap = new HashMap();
		LnkLink link = null;
		for (int i=0; i<links.length; i++) {
			link = links[i];
			String tranId = link.getExtendedPropertyValue("transitionId");
			linkMap.put(tranId, link);
		}
		return linkMap;
	}
	private String setActivitiesInfo(String xpdlStr, Map taskMap) throws Exception {

//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		Document doc = builder.parse(new ByteArrayInputStream(xpdlStr.getBytes("UTF-8")));
		
		Document doc = XmlUtil.toDocument(xpdlStr, "utf-8");
		Element ele = doc.getDocumentElement();
		
		Set keySet = taskMap.keySet();
		
		Iterator itr = keySet.iterator();
		
		while (itr.hasNext()) {
			String actId = (String)itr.next();
			TskTask task = (TskTask)taskMap.get(actId);
			String type = task.getType();
			if (type.equalsIgnoreCase("SUBFLOW")) {
				String targetSubPrcInstId = task.getExtendedPropertyValue("targetPrcInstId");
				Node actNode = XPathAPI.selectSingleNode(ele, "//xpdl:Activity[@Id=" + actId + "]//xpdl:Implementation//xpdl:SubFlow");
				Element actElement = (Element)actNode;
				if (actElement != null) {
					actElement.setAttribute("SubProcessInstId", targetSubPrcInstId);
				}
			} else {
				Node actNode = XPathAPI.selectSingleNode(ele, "//xpdl:Activity[@Id=" + actId + "]");
				Element actElement = (Element)actNode;
				if (actElement != null) {
					actElement.setAttribute("PerformerName", task.getAssignee());
				}
				
				Node appNode = XPathAPI.selectSingleNode(ele, "//xpdl:Activity[@Id=" + actId + "]//xpdl:Implementation//xpdl:Task//xpdl:TaskApplication");
				Element appElement = (Element)appNode;
				if (appElement != null) {
					appElement.setAttribute("ExecutionFrom", task.getRealStartDate() != null ? DateUtil.toString(task.getRealStartDate(), "yyyy-MM-dd HH:mm:ss") : "");
					appElement.setAttribute("ExecutionTo", task.getRealEndDate() != null ? DateUtil.toString(task.getRealEndDate(), "yyyy-MM-dd HH:mm:ss") : "");
						
					//경과 시간
					Date realStartDate = task.getRealStartDate();
					if (realStartDate != null) {
						
						long realStartDateLong = realStartDate.getTime();
						long endDateLong = 0;
						if (task.getStatus().equalsIgnoreCase((String)MisUtil.taskStatusMap().get("started"))) {
							endDateLong = new Date().getTime();
						} else if (task.getStatus().equalsIgnoreCase((String)MisUtil.taskStatusMap().get("executed"))) {
							endDateLong = task.getExecutionDate().getTime();
						}
						
						long passedTimeLong = endDateLong - realStartDateLong;
						
						long passedTime = (long)(passedTimeLong / (60 * 1000));
						appElement.setAttribute("PassedTime", passedTime + "");
					}
				}
			}
		}
		return XmlUtil.toXmlString(doc);
	}
	
	
	
	private void setActivitiesStatus(Activities acts, Map taskMap) throws Exception {
		if (acts == null || taskMap == null || taskMap.isEmpty())
			return;
		List actList = acts.getActivity();
		if (actList == null || actList.isEmpty())
			return;
		for (Iterator actIter = actList.iterator(); actIter.hasNext();) {
			Activity act = (Activity) actIter.next();

			// Events - Skip procedure and Continue looping
//			if (act.getEvent() != null)
//				continue;
			
			String actId = act.getId();
			if (actId == null)
				continue;

			TskTask task = (TskTask) taskMap.get(actId);
			if (task == null)
				continue;
			String status = task.getStatus();
			
			
			if (status.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("created"), "created"))) {
//				Date dueDate = task.getDueDate();
//				if (dueDate != null && dueDate.getTime() < new Date().getTime()) {
//					act.setStatus("DELAYED");
//				} else {
//					act.setStatus("READY");
//				}
				act.setStatus("READY");
			} else if (status.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("started"), "started"))){
				
				Date realStartDate = task.getRealStartDate();
				long realStartDateLong = realStartDate.getTime();
				int meanTime = 0;
				
				Task xpdlTask = act.getImplementation().getTask();
				if (xpdlTask != null) {
					Sequence attrs = xpdlTask.getTaskApplication().getAnyAttribute();
					if (attrs != null && attrs.size() > 0) {
						for (int i=0; i<attrs.size(); i++) {
							commonj.sdo.Property attr = attrs.getProperty(i);
							String attrName = attr.getName();
							Object attrValue = attrs.getValue(i);
							if (CommonUtil.isEmpty(attrName) || attrValue == null)
								continue;
							if (attrName.equals("MeanTime")) {
								meanTime = Integer.parseInt((String)attrValue);
							} 
						}
					}
					long ExpectEndDateLong = realStartDateLong + (meanTime * 60 * 1000);
					long now = new Date().getTime();
					
					if (ExpectEndDateLong < now) {
						act.setStatus("DELAYED");
					} else {
						act.setStatus("PROCESSING");
					}
				} else {
					act.setStatus("PROCESSING");
				}
				
				
			} else if (status.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("started"), "started"))) {
				act.setStatus("ACTIVE");
			} else if (status.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("returned"), "returned"))) {
				act.setStatus("RETURNED");
			} else if (status.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("suspended"), "suspended"))) {
				act.setStatus("SUSPENDED");
			} else if (status.equalsIgnoreCase(CommonUtil.toDefault((String)MisUtil.taskStatusMap().get("terminated"), "terminated"))) {
				act.setStatus("TERMINATED");
			} else { 
				act.setStatus("COMPLETED");
			}
		}
	}
	
	private void setTransitionsStatus(Transitions trans, Map linkMap) throws Exception {
		if (trans == null || linkMap == null || linkMap.isEmpty())
			return;
		List tranList = trans.getTransition();
		if (tranList == null || tranList.isEmpty())
			return;
		for (Iterator tranItr = tranList.iterator(); tranItr.hasNext();) {
			Transition tran = (Transition) tranItr.next();
			
			String tranId = tran.getId();
			if (tranId == null)
				continue;
			
			LnkLink link = (LnkLink) linkMap.get(tranId);
			if (link == null)
				continue;
			
			tran.setStatus("COMPLETED");
		}
	}
}
