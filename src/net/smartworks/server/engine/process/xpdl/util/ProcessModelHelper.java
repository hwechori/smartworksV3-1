/*
 * $Id: ProcessModelHelper.java,v 1.1 2009/12/22 06:18:42 kmyu Exp $
 * created by    : jhnam
 * creation-date : 2007. 12. 15
 * =========================================================
 * Copyright (c) 2007 ManInSoft, Inc. All rights reserved.
 */
package net.smartworks.server.engine.process.xpdl.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.process.xpdl.Constants;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl2.Applications;
import net.smartworks.server.engine.process.xpdl.xpdl2.Assignment;
import net.smartworks.server.engine.process.xpdl.xpdl2.Assignments;
import net.smartworks.server.engine.process.xpdl.xpdl2.Author;
import net.smartworks.server.engine.process.xpdl.xpdl2.BasicType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Codepage;
import net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates;
import net.smartworks.server.engine.process.xpdl.xpdl2.Countrykey;
import net.smartworks.server.engine.process.xpdl.xpdl2.Created;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataField;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataFields;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Description;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType;
import net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters;
import net.smartworks.server.engine.process.xpdl.xpdl2.Lane;
import net.smartworks.server.engine.process.xpdl.xpdl2.Lanes;
import net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo;
import net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfos;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Participants;
import net.smartworks.server.engine.process.xpdl.xpdl2.Performer;
import net.smartworks.server.engine.process.xpdl.xpdl2.Pool;
import net.smartworks.server.engine.process.xpdl.xpdl2.Pools;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;
import net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader;
import net.smartworks.server.engine.process.xpdl.xpdl2.Responsible;
import net.smartworks.server.engine.process.xpdl.xpdl2.SchemaType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Script;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl2.Vendor;
import net.smartworks.server.engine.process.xpdl.xpdl2.Version;
import net.smartworks.server.engine.process.xpdl.xpdl2.WorkflowProcesses;
import net.smartworks.server.engine.process.xpdl.xpdl2.XPDLVersion;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;

/**
 * 프로세스 모델 생성, 로드, 저장, 삭제 등의 조작을 도와주는 헬퍼
 * 
 * @author jhnam
 * @version $Id: ProcessModelHelper.java,v 1.1 2009/12/22 06:18:42 kmyu Exp $
 */
public class ProcessModelHelper {

	/**
	 * HelperContext
	 */
	private static HelperContext hc = null;
	/**
	 * Xpdl2Factory
	 */
	private static Xpdl2Factory factory = null;
	
	/**
	 * 초기화
	 */
	static {		
		hc = SDOUtil.createHelperContext();
		factory = Xpdl2Factory.INSTANCE;		
		factory.register(hc);
	};

	/**
	 * SDO HelperContext를 리턴한다.
	 * 
	 * @return
	 */
	public static HelperContext getHelperContext() {
		return hc;
	}
	
	/**
	 * Xpdl2Factory를 리턴한다.
	 * 
	 * @return
	 */
	public static Xpdl2Factory getXpdl2Factory() {
		return factory;
	}
	
	/**
	 * xpdl file path로 부터 파일을 읽어서 프로세스 템플릿을 생성한다.
	 * 
	 * @param xpdlFilePath
	 * @return
	 * @throws Exception
	 */
	public static PackageType createProcessTemplate(String xpdlFilePath) throws Exception {
		
		PackageType xpdl = load(new FileInputStream(xpdlFilePath));
		return xpdl;
	}
	
	/**
	 * 기본값으로 프로세스 템플릿을 생성한다.
	 * 
	 * @return
	 */
	public static PackageType createProcessTemplate() {
		return createProcessTemplate("", "", 1, "");
	}
	
	/**
	 * 넘어온 파라미터 값으로 프로세스 템플릿을 생성한다.
	 * 
	 * @param processId
	 * @param name
	 * @param version
	 * @param creator
	 * @return
	 */
	public static PackageType createProcessTemplate(String processId, String name, int version, String creator) {
		
		PackageType pt = factory.createPackageType();
		pt.setId(processId);
		pt.setName(name);
		
		PackageHeader ph = factory.createPackageHeader();
		ph.setVendor(ProcessModelHelper.createVendor("ManInSoft"));
		ph.setCreated(ProcessModelHelper.createCurrentCreated());
		ph.setDescription(ProcessModelHelper.createDescription(""));
		ph.setXPDLVersion(ProcessModelHelper.createXPDLVersion("2.0"));
		pt.setPackageHeader(ph);
		
		RedefinableHeader rh = factory.createRedefinableHeader();
		// UNDER_REVISION, RELEASED, UNDER_TEST
		rh.setPublicationStatus("UNDER_REVISION");
		rh.setCodepage(ProcessModelHelper.createCodepage("UTF-8"));
		rh.setCountrykey(ProcessModelHelper.createCountryKey("KR"));
		rh.setVersion(ProcessModelHelper.createVersion("" + version));
		rh.setAuthor(ProcessModelHelper.createAuthor(creator));
		pt.setRedefinableHeader(rh);

		Script script = factory.createScript();
		script.setGrammar("text/javascript");
		pt.setScript(script);
		
		pt.setPools(createTemplatePools(processId, name));
		
		WorkflowProcesses wps = factory.createWorkflowProcesses();
		ProcessType1 process = factory.createProcessType1();
		process.setId(processId);
		process.setAccessLevel("PUBLIC");
		process.setName(name);
		
		wps.getWorkflowProcess().add(process);
		pt.setWorkflowProcesses(wps);
		
		Participants participants = factory.createParticipants();
		process.setParticipants(participants);
		
		DataFields dataFields = factory.createDataFields();
		process.setDataFields(dataFields);
		
		Applications apps = factory.createApplications();
		process.setApplications(apps);
		
		FormalParameters formParams = factory.createFormalParameters();
		process.setFormalParameters(formParams);
		
		Activities activities = factory.createActivities();
		process.setActivities(activities);
		
		Transitions transitions = factory.createTransitions();
		process.setTransitions(transitions);
		
		return pt;
	}
	
	/**
	 * 템플릿 풀을 생성한다.
	 * 
	 * @param processId
	 * @param processName
	 * @return
	 */
	public static Pools createTemplatePools(String processId, String processName) {
		
		Pools pools = factory.createPools();
		Pool pool = factory.createPool();
		pool.setId("1");
		pool.setName("프로세스");
		pool.setProcess(processId);
		pool.setOrientation("VERTICAL");
		pool.setBoundaryVisible(true);
		
		pools.getPool().add(pool);
		
		Lanes lanes = factory.createLanes();
		Lane lane = factory.createLane();
		lane.setId("1");
		lane.setName("Lane-1");
		lane.setParentLane("0");
		
		NodeGraphicsInfos ngis = createNodeGraphicsInfos("1", 320, 200, "-16777216", "-32", 22, 252);
		lane.setNodeGraphicsInfos(ngis);
		
		lanes.getLane().add(lane);
		pool.setLanes(lanes);
		
		NodeGraphicsInfos pngis = createNodeGraphicsInfos("1", 320, 200, null, null, 15, 15);
		pool.setNodeGraphicsInfos(pngis);
		
		return pools;
	}
	
	/**
	 * NodeGraphicsInfos를 생성한다.
	 * 
	 * @param page
	 * @param height
	 * @param width
	 * @param borderColor
	 * @param fillColor
	 * @param xCoord
	 * @param yCoord
	 * @return
	 */
	public static NodeGraphicsInfos createNodeGraphicsInfos(String page, int height, int width, String borderColor, String fillColor, int xCoord, int yCoord) {
		
		NodeGraphicsInfos ngis = factory.createNodeGraphicsInfos();
		NodeGraphicsInfo ngi = factory.createNodeGraphicsInfo(); 
		ngis.getNodeGraphicsInfo().add(ngi);
		ngi.setPage(page);
		ngi.setHeight(height);
		ngi.setWidth(width);
		
		if(borderColor != null)			
			ngi.setBorderColor(borderColor);
		
		if(fillColor != null)
			ngi.setFillColor(fillColor);
		
		Coordinates coords = factory.createCoordinates();
		ngi.setCoordinates(coords);
		coords.setXCoordinate(xCoord);
		coords.setYCoordinate(yCoord);
		
		return ngis;
	}
	
	/**
	 * 프로세스 이름, 업무 정보, 데이터 정보로 부터 템플릿 프로세스를 생성한다.
	 * 
	 * @param processId
	 * @param processName
	 * @param workStepInfo
	 * @param dataInfo
	 * @return
	 */
	public static PackageType createProcessTemplate(String processId, String processName, Map workStepInfo, Map dataInfo) throws Exception {
		
		InputStream is = ProcessModelHelper.class.getClassLoader().getResourceAsStream("com/maninsoft/smart/model/process/conf/template-3step.xpdl");
		PackageType process = ProcessModelHelper.load(is);
		process.setId(processId);
		process.setName(processName);
		
		ProcessType1 processType = (ProcessType1)process.getWorkflowProcesses().getWorkflowProcess().get(0);
		processType.setId(processId);
		processType.setName(processName);
		List actList = processType.getActivities().getActivity();
		
		if (actList != null && !actList.isEmpty()) {
			for (Iterator actItr = actList.iterator(); actItr.hasNext();) {
				Activity actModel = (Activity)actItr.next();
				String actId = actModel.getId();
				
				if(!workStepInfo.containsKey(actId))
					continue;
				
				String[] workStep = (String[])workStepInfo.get(actId);
				// 액티비티 이름 설정
				actModel.setName(workStep[1]);
				
				// performer 설정
				if(!actModel.getPerformers().getPerformer().isEmpty()) {
					Performer performer = (Performer)actModel.getPerformers().getPerformer().get(0);
					performer.setValue(workStep[2]);
				}
				
				// data field 생성, assignment 생성
				createActivityDataFields(actModel, dataInfo);
				
				if(!actId.equals("1"))
					createActivityAssignment(actModel, dataInfo);
			}
		}
				
		return process;
	}
	
	/**
	 * 액티비티 데이터를 생성한다.
	 * 
	 * @param activityModel
	 * @param dataInfo
	 * @throws Exception
	 */
	public static void createActivityDataFields(Activity activityModel, Map dataInfo) throws Exception {
		
		DataFields dataFields = activityModel.getDataFields();		
		Iterator diIt = dataInfo.values().iterator();
		
		while(diIt.hasNext()) {
			String[] dataMeta = (String[])diIt.next();
			DataField df = factory.createDataField();
			
			// 데이터 필드 아이디
			df.setId("A" + activityModel.getId() + "_" + dataMeta[0]);
			
			// 데이터 필드 이름
			df.setName(dataMeta[1]);
			DataType dt = factory.createDataType();
			BasicType bt = factory.createBasicType();
			
			// 데이터 타입
			bt.setType(dataMeta[2]);
			dt.setBasicType(bt);
			df.setDataType(dt);
			
			ExpressionType exprType = factory.createExpressionType();			
			// 기본값
			exprType.setExprValue(dataMeta[3]);
			df.setInitialValue(exprType);
			dataFields.getDataField().add(df);
		}
	}
	
	/**
	 * 액티비티 Assignment를 생성한다.
	 * 
	 * @param activityModel
	 * @param dataInfo
	 * @throws Exception
	 */
	public static void createActivityAssignment(Activity activityModel, Map dataInfo) throws Exception {
		
		Assignments assignments = activityModel.getAssignments();		
		Iterator diIt = dataInfo.values().iterator();
		
		while(diIt.hasNext()) {
			String[] dataMeta = (String[])diIt.next();
			Assignment ass = factory.createAssignment();
			ass.setAssignTime("Start");
			
			ExpressionType exprType = factory.createExpressionType();
			ass.setExpression(exprType);			
			exprType.setExprValue("/task/" + (Integer.parseInt(activityModel.getId()) - 1) + "/" + dataMeta[1]);
			
			ExpressionType targetType = factory.createExpressionType();
			ass.setTarget(targetType);
			targetType.setExprValue(dataMeta[1]);

			assignments.getAssignment().add(ass);
		}		
	}
	
	/**
	 * process model xml로 부터 PackageType을 로딩하여 리턴한다.
	 * 
	 * @param modelXml
	 * @return
	 * @throws Exception
	 */
	public static PackageType load(String modelXml) throws Exception {
		
		XMLHelper xmlHelper = hc.getXMLHelper();
		XMLDocument doc = xmlHelper.load(modelXml);
		DataObject rdo = doc.getRootObject();
		
		if(rdo instanceof PackageType)
			return (PackageType)rdo;
		else
			throw new Exception("DataObject is not PackageType!");
	}
	
	/**
	 * Reader로 XPDL 객체를 로딩한다.
	 * 
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public static PackageType load(Reader reader) throws Exception {
				
		XMLHelper xmlHelper = hc.getXMLHelper();
		XMLDocument doc = xmlHelper.load(reader, null, null);
		DataObject rdo = doc.getRootObject();
		
		if(rdo instanceof PackageType)
			return (PackageType)rdo;
		else
			throw new Exception("DataObject is not PackageType!");		
	}
	
	/**
	 * InputStream으로 XPDL 객체를 로딩한다.
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static PackageType load(InputStream is) throws Exception {
		
		XMLHelper xmlHelper = hc.getXMLHelper();
		XMLDocument doc = xmlHelper.load(is, null, null);
		DataObject rdo = doc.getRootObject();
		
		if(rdo instanceof PackageType)
			return (PackageType)rdo;
		else
			throw new Exception("DataObject is not PackageType!");		
	}
	
	/**
	 * 변경된 PackageType을 저장한다. 결과로는 xml string이 리턴된다.
	 * 
	 * @param pt
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String save(PackageType pt, String encoding) throws Exception {
		
		// TODO 상수화 - 설정으로 처리
		if(encoding == null)
			encoding = "UTF-8";
		
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, encoding);
		
		XMLDocument xmlDoc = hc.getXMLHelper().createDocument((DataObject)pt, Constants.XPDL_NS, Constants.XPDL_ROOT_NAME);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		hc.getXMLHelper().save(xmlDoc, os, options);
		byte[] ba = os.toByteArray();
		return new String(ba, encoding);
	}
	
	/**
	 * XPDL 객체를 OutputStream으로 write한다. encoding 고려
	 * 
	 * @param pt
	 * @param os
	 * @param encoding
	 * @throws Exception
	 */
	public static void save(PackageType pt, OutputStream os, String encoding) throws Exception {
		
		if(encoding == null)
			encoding = "UTF-8";
		
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, encoding);
		
		// 현재 SDO 라이브러리(1.0incubating)에서는 Writer를 사용하는 XMLHelper 구현이 잘못 되어 있음. (인코딩 고려를 하지 않았음)
		XMLDocument xmlDoc = hc.getXMLHelper().createDocument((DataObject)pt, Constants.XPDL_NS, Constants.XPDL_ROOT_NAME);
		hc.getXMLHelper().save(xmlDoc, os, options);
	}
	
	/**
	 * Vendor를 생성한다.
	 * 
	 * @param vendorValue
	 * @return
	 */
	public static Vendor createVendor(String vendorValue) {
		
		Vendor version = factory.createVendor();
		version.setValue(vendorValue);
		return version;
	}
	
	/**
	 * Author를 생성한다.
	 * 
	 * @param authorValue
	 * @return
	 */
	public static Author createAuthor(String authorValue) {
		
		Author author = factory.createAuthor();
		author.setValue(authorValue);
		return author;
	}
	
	/**
	 * Version을 생성한다.
	 * 
	 * @param versionValue
	 * @return
	 */
	public static Version createVersion(String versionValue) {
		
		Version version = factory.createVersion();
		version.setValue(versionValue);
		return version;
	}
	
	/**
	 * XPDLVersion을 생성한다.
	 * 
	 * @param versionValue
	 * @return
	 */
	public static XPDLVersion createXPDLVersion(String versionValue) {
		
		XPDLVersion version = factory.createXPDLVersion();
		version.setValue(versionValue);
		return version;
	}	
	
	/**
	 * Countrykey를 생성한다.
	 * 
	 * @param countryKeyValue
	 * @return
	 */
	public static Countrykey createCountryKey(String countryKeyValue) {
		
		Countrykey countryKey = factory.createCountrykey();
		countryKey.setValue(countryKeyValue);
		return countryKey;
	}	
	
	/**
	 * Codepage를 생성한다.
	 * 
	 * @param codepageValue
	 * @return
	 */
	public static Codepage createCodepage(String codepageValue) {
		
		Codepage codepage = factory.createCodepage();
		codepage.setValue(codepageValue);
		return codepage;
	}
	
	/**
	 * Responsible를 생성한다.
	 * 
	 * @param responsibleValue
	 * @return
	 */
	public static Responsible createResponsible(String responsibleValue) {
		
		Responsible res = factory.createResponsible();
		res.setValue(responsibleValue);
		return res;
	}	
	
	/**
	 * 생성 날짜를 현재 시간으로 생성한다.
	 *  
	 * @return
	 */
	public static Created createCurrentCreated() {
		
		Created createdTime = factory.createCreated();
		createdTime.setValue(new Date().toString());
		return createdTime;
	}
	
	/**
	 * 생성 날짜를 value로 설정하고 생성한다.
	 * 
	 * @param value
	 * @return
	 */
	public static Created createCreated(String value) {
		
		Created createdTime = factory.createCreated();
		createdTime.setValue(value);
		return createdTime;
	}
	
	/**
	 * 설명을 value로 설정하고 생성한다.
	 * 
	 * @param value
	 * @return
	 */
	public static Description createDescription(String value) {
		
		Description desc = factory.createDescription();
		desc.setValue(value);
		return desc;
	}
	
	/**
	 * xsdSchema를 설정한다.
	 * 
	 * @param xsdSchema
	 * @return
	 */
	public static SchemaType createSchemaType(String xsdSchema) {
		
		SchemaType schemaType = factory.createSchemaType();
		schemaType.setSchemaValue(xsdSchema);
		return schemaType;
	}
	
	/**
	 * scriptGrammar와 exprValue로 ExpressionType을 생성한다.
	 * 
	 * @param scriptGrammar
	 * @param exprValue
	 * @return
	 */
	public static ExpressionType createExpressionType(String scriptGrammar, String exprValue) {
		
		ExpressionType exprType = factory.createExpressionType();
		exprType.setScriptGrammar(scriptGrammar);
		exprType.setExprValue(exprValue);
		return exprType;
	}
	
	/**
	 * Class를 생성한다.
	 * 
	 * @param classsValue
	 * @return
	 */
	public static net.smartworks.server.engine.process.xpdl.xpdl2.Class createClass(String classsValue) {
		
		net.smartworks.server.engine.process.xpdl.xpdl2.Class cls = factory.createClass();
		cls.setValue(classsValue);
		return cls;
	}
	
	/**
	 * Method를 생성한다.
	 * 
	 * @param methodValue
	 * @return
	 */
	public static net.smartworks.server.engine.process.xpdl.xpdl2.Method createMethod(String methodValue) {
		
		net.smartworks.server.engine.process.xpdl.xpdl2.Method mtd = factory.createMethod();
		mtd.setValue(methodValue);
		return mtd;
	}
}
