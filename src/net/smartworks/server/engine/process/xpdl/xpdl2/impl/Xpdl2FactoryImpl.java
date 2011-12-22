/**
 * <copyright>
 * </copyright>
 *
 * $Id: Xpdl2FactoryImpl.java,v 1.1 2009/12/22 06:17:45 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;
import net.smartworks.server.engine.process.xpdl.xpdl1.impl.Xpdl1FactoryImpl;
import net.smartworks.server.engine.process.xpdl.xpdl2.*;

import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.impl.FactoryBase;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2; -prefix Xpdl2
 * <!-- end-user-doc -->
 * @generated
 */
public class Xpdl2FactoryImpl extends FactoryBase implements Xpdl2Factory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.wfmc.org/2004/XPDL2.0alpha";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "xpdl";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int ACTIVITIES = 1;	
  public static final int ACTIVITY = 2;	
  public static final int ACTIVITY_SET = 3;	
  public static final int ACTIVITY_SETS = 4;	
  public static final int ACTUAL_PARAMETERS = 5;	
  public static final int APPLICATION = 6;	
  public static final int APPLICATIONS = 7;	
  public static final int APPLICATION_TYPE = 8;	
  public static final int ARRAY_TYPE = 9;	
  public static final int ARTIFACT = 10;	
  public static final int ARTIFACTS = 11;	
  public static final int ASSIGNMENT = 12;	
  public static final int ASSIGNMENTS = 13;	
  public static final int ASSOCIATION = 14;	
  public static final int ASSOCIATIONS = 15;	
  public static final int AUTHOR = 16;	
  public static final int BASIC_TYPE = 17;	
  public static final int BLOCK_ACTIVITY = 18;	
  public static final int BUSINESS_RULE = 19;	
  public static final int CATEGORIES = 20;	
  public static final int CATEGORY = 21;	
  public static final int CLASS = 22;	
  public static final int CODEPAGE = 23;	
  public static final int CONDITION = 24;	
  public static final int CONFORMANCE_CLASS = 25;	
  public static final int CONNECTOR_GRAPHICS_INFO = 26;	
  public static final int CONNECTOR_GRAPHICS_INFOS = 27;	
  public static final int COORDINATES = 28;	
  public static final int COST = 29;	
  public static final int COST_UNIT = 30;	
  public static final int COUNTRYKEY = 31;	
  public static final int CREATED = 32;	
  public static final int DATA_FIELD = 33;	
  public static final int DATA_FIELDS = 34;	
  public static final int DATA_MAPPING = 35;	
  public static final int DATA_MAPPINGS = 36;	
  public static final int DATA_OBJECT = 37;	
  public static final int DATA_TYPE = 38;	
  public static final int DEADLINE = 39;	
  public static final int DECLARED_TYPE = 40;	
  public static final int DESCRIPTION = 41;	
  public static final int DOCUMENTATION = 42;	
  public static final int DURATION = 43;	
  public static final int EJB = 44;	
  public static final int END_EVENT = 45;	
  public static final int END_POINT = 46;	
  public static final int ENUMERATION_TYPE = 47;	
  public static final int ENUMERATION_VALUE = 48;	
  public static final int EVENT = 49;	
  public static final int EXCEPTION_NAME = 50;	
  public static final int EXPRESSION_TYPE = 51;	
  public static final int EXTENDED_ATTRIBUTE = 52;	
  public static final int EXTENDED_ATTRIBUTES = 53;	
  public static final int EXTERNAL_PACKAGE = 54;	
  public static final int EXTERNAL_PACKAGES = 55;	
  public static final int EXTERNAL_REFERENCE = 56;	
  public static final int FORM = 57;	
  public static final int FORMAL_PARAMETER = 58;	
  public static final int FORMAL_PARAMETERS = 59;	
  public static final int FORM_LAYOUT = 60;	
  public static final int HOME_CLASS = 61;	
  public static final int ICON = 62;	
  public static final int IMPLEMENTATION7 = 63;	
  public static final int INPUT = 64;	
  public static final int INPUT_SET = 65;	
  public static final int INPUT_SETS = 66;	
  public static final int INTERMEDIATE_EVENT = 67;	
  public static final int IO_RULES = 68;	
  public static final int JNDI_NAME = 69;	
  public static final int JOIN = 70;	
  public static final int LANE = 71;	
  public static final int LANES = 72;	
  public static final int LENGTH = 73;	
  public static final int LIMIT = 74;	
  public static final int LIST_TYPE = 75;	
  public static final int LOCATION = 76;	
  public static final int LOOP = 77;	
  public static final int LOOP_MULTI_INSTANCE = 78;	
  public static final int LOOP_STANDARD = 79;	
  public static final int MEMBER = 80;	
  public static final int MESSAGE_FLOW = 81;	
  public static final int MESSAGE_FLOWS = 82;	
  public static final int MESSAGE_TYPE = 83;	
  public static final int METHOD = 84;	
  public static final int METHOD1 = 85;	
  public static final int MY_ROLE = 86;	
  public static final int NO = 87;	
  public static final int NODE_GRAPHICS_INFO = 88;	
  public static final int NODE_GRAPHICS_INFOS = 89;	
  public static final int OBJECT = 90;	
  public static final int OUTPUT = 91;	
  public static final int OUTPUT_SET = 92;	
  public static final int OUTPUT_SETS = 93;	
  public static final int PACKAGE_HEADER = 94;	
  public static final int PACKAGE_TYPE = 95;	
  public static final int PARTICIPANT = 96;	
  public static final int PARTICIPANTS = 97;	
  public static final int PARTICIPANT_TYPE = 98;	
  public static final int PARTNER = 99;	
  public static final int PARTNER_LINK = 100;	
  public static final int PARTNER_LINKS = 101;	
  public static final int PARTNER_LINK_TYPE = 102;	
  public static final int PARTNER_LINK_TYPES = 103;	
  public static final int PARTNER_ROLE = 104;	
  public static final int PERFORMER = 105;	
  public static final int PERFORMERS = 106;	
  public static final int POJO = 107;	
  public static final int POOL = 108;	
  public static final int POOLS = 109;	
  public static final int PRECISION = 110;	
  public static final int PRIORITY = 111;	
  public static final int PRIORITY_UNIT = 112;	
  public static final int PROCESS_HEADER = 113;	
  public static final int PROCESS_TYPE1 = 114;	
  public static final int RECORD_TYPE = 115;	
  public static final int REDEFINABLE_HEADER = 116;	
  public static final int REFERENCE = 117;	
  public static final int RESPONSIBLE = 118;	
  public static final int RESPONSIBLES = 119;	
  public static final int RESULT_COMPENSATION = 120;	
  public static final int RESULT_ERROR = 121;	
  public static final int RESULT_MULTIPLE = 122;	
  public static final int ROLE = 123;	
  public static final int ROUTE = 124;	
  public static final int RULE = 125;	
  public static final int RULE_NAME = 126;	
  public static final int SCALE = 127;	
  public static final int SCHEMA_TYPE = 128;	
  public static final int SCRIPT = 129;	
  public static final int SCRIPT1 = 130;	
  public static final int SERVICE = 131;	
  public static final int SIMULATION_INFORMATION = 132;	
  public static final int SPLIT = 133;	
  public static final int START_EVENT = 134;	
  public static final int SUB_FLOW = 135;	
  public static final int TASK = 136;	
  public static final int TASK_APPLICATION = 137;	
  public static final int TASK_MANUAL = 138;	
  public static final int TASK_RECEIVE = 139;	
  public static final int TASK_REFERENCE = 140;	
  public static final int TASK_SCRIPT = 141;	
  public static final int TASK_SEND = 142;	
  public static final int TASK_SERVICE = 143;	
  public static final int TASK_USER = 144;	
  public static final int TIME_ESTIMATION = 145;	
  public static final int TRANSACTION = 146;	
  public static final int TRANSITION = 147;	
  public static final int TRANSITION_REF = 148;	
  public static final int TRANSITION_REFS = 149;	
  public static final int TRANSITION_RESTRICTION = 150;	
  public static final int TRANSITION_RESTRICTIONS = 151;	
  public static final int TRANSITIONS = 152;	
  public static final int TRIGGER_INTERMEDIATE_MULTIPLE = 153;	
  public static final int TRIGGER_MULTIPLE = 154;	
  public static final int TRIGGER_RESULT_LINK = 155;	
  public static final int TRIGGER_RESULT_MESSAGE = 156;	
  public static final int TRIGGER_RULE = 157;	
  public static final int TRIGGER_TIMER = 158;	
  public static final int TYPE_DECLARATION = 159;	
  public static final int TYPE_DECLARATIONS = 160;	
  public static final int UNION_TYPE = 161;	
  public static final int VALID_FROM = 162;	
  public static final int VALID_TO = 163;	
  public static final int VENDOR = 164;	
  public static final int VENDOR_EXTENSION = 165;	
  public static final int VENDOR_EXTENSIONS = 166;	
  public static final int VERSION = 167;	
  public static final int WAITING_TIME = 168;	
  public static final int WEB_SERVICE = 169;	
  public static final int WEB_SERVICE_FAULT_CATCH = 170;	
  public static final int WEB_SERVICE_OPERATION = 171;	
  public static final int WORKFLOW_PROCESSES = 172;	
  public static final int WORKING_TIME = 173;	
  public static final int XPDL_VERSION = 174;	
  public static final int XSLT = 175;	
  public static final int ACCESS_LEVEL = 176;	
  public static final int AD_HOC_ORDERING = 177;	
  public static final int AD_HOC_ORDERING1 = 178;	
  public static final int ARTIFACT_TYPE = 179;	
  public static final int ASSIGN_TIME = 180;	
  public static final int ASSOCIATION_DIRECTION = 181;	
  public static final int DIRECTION = 182;	
  public static final int DURATION_UNIT = 183;	
  public static final int END_POINT_TYPE = 184;	
  public static final int EXECUTION = 185;	
  public static final int EXECUTION1 = 186;	
  public static final int FINISH_MODE = 187;	
  public static final int GATEWAY_TYPE = 188;	
  public static final int GRAPH_CONFORMANCE = 189;	
  public static final int IMPLEMENTATION = 190;	
  public static final int IMPLEMENTATION1 = 191;	
  public static final int IMPLEMENTATION2 = 192;	
  public static final int IMPLEMENTATION3 = 193;	
  public static final int IMPLEMENTATION4 = 194;	
  public static final int IMPLEMENTATION5 = 195;	
  public static final int IMPLEMENTATION6 = 196;	
  public static final int INSTANTIATION = 197;	
  public static final int IS_ARRAY = 198;	
  public static final int LOOP_TYPE = 199;	
  public static final int MI_FLOW_CONDITION = 200;	
  public static final int MI_ORDERING = 201;	
  public static final int MODE = 202;	
  public static final int ORIENTATION = 203;	
  public static final int PROCESS_TYPE = 204;	
  public static final int PUBLICATION_STATUS = 205;	
  public static final int RESULT = 206;	
  public static final int ROLE_TYPE = 207;	
  public static final int SHAPE = 208;	
  public static final int START_MODE = 209;	
  public static final int STATUS = 210;	
  public static final int STATUS1 = 211;	
  public static final int TEST_TIME = 212;	
  public static final int TRANSACTION_METHOD = 213;	
  public static final int TRIGGER = 214;	
  public static final int TRIGGER1 = 215;	
  public static final int TYPE = 216;	
  public static final int TYPE1 = 217;	
  public static final int TYPE2 = 218;	
  public static final int TYPE3 = 219;	
  public static final int TYPE4 = 220;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Xpdl2FactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "net.smartworks.server.engine.process.xpdl.xpdl2");
  }

  /**
   * Registers the Factory instance so that it is available within the supplied scope.
   * @argument scope a HelperContext instance that will make the types supported by this Factory available.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void register(HelperContext scope) 
  {
    if(scope == null) {
      throw new IllegalArgumentException("Scope can not be null");
    }
    
    //Register dependent packages with provided scope
    Xpdl1Factory.INSTANCE.register(scope);
    ModelFactory.INSTANCE.register(scope);
    
    // Initialize this package   
    TypeHelperImpl th = (TypeHelperImpl)scope.getTypeHelper();
    th.getExtendedMetaData().putPackage(NAMESPACE_URI, this);
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject create(int typeNumber)
  {
    switch (typeNumber)
    {
      case ACTIVITIES: return (DataObject)createActivities();
      case ACTIVITY: return (DataObject)createActivity();
      case ACTIVITY_SET: return (DataObject)createActivitySet();
      case ACTIVITY_SETS: return (DataObject)createActivitySets();
      case ACTUAL_PARAMETERS: return (DataObject)createActualParameters();
      case APPLICATION: return (DataObject)createApplication();
      case APPLICATIONS: return (DataObject)createApplications();
      case APPLICATION_TYPE: return (DataObject)createApplicationType();
      case ARRAY_TYPE: return (DataObject)createArrayType();
      case ARTIFACT: return (DataObject)createArtifact();
      case ARTIFACTS: return (DataObject)createArtifacts();
      case ASSIGNMENT: return (DataObject)createAssignment();
      case ASSIGNMENTS: return (DataObject)createAssignments();
      case ASSOCIATION: return (DataObject)createAssociation();
      case ASSOCIATIONS: return (DataObject)createAssociations();
      case AUTHOR: return (DataObject)createAuthor();
      case BASIC_TYPE: return (DataObject)createBasicType();
      case BLOCK_ACTIVITY: return (DataObject)createBlockActivity();
      case BUSINESS_RULE: return (DataObject)createBusinessRule();
      case CATEGORIES: return (DataObject)createCategories();
      case CATEGORY: return (DataObject)createCategory();
      case CLASS: return (DataObject)createClass();
      case CODEPAGE: return (DataObject)createCodepage();
      case CONDITION: return (DataObject)createCondition();
      case CONFORMANCE_CLASS: return (DataObject)createConformanceClass();
      case CONNECTOR_GRAPHICS_INFO: return (DataObject)createConnectorGraphicsInfo();
      case CONNECTOR_GRAPHICS_INFOS: return (DataObject)createConnectorGraphicsInfos();
      case COORDINATES: return (DataObject)createCoordinates();
      case COST: return (DataObject)createCost();
      case COST_UNIT: return (DataObject)createCostUnit();
      case COUNTRYKEY: return (DataObject)createCountrykey();
      case CREATED: return (DataObject)createCreated();
      case DATA_FIELD: return (DataObject)createDataField();
      case DATA_FIELDS: return (DataObject)createDataFields();
      case DATA_MAPPING: return (DataObject)createDataMapping();
      case DATA_MAPPINGS: return (DataObject)createDataMappings();
      case DATA_OBJECT: return (DataObject)createDataObject();
      case DATA_TYPE: return (DataObject)createDataType();
      case DEADLINE: return (DataObject)createDeadline();
      case DECLARED_TYPE: return (DataObject)createDeclaredType();
      case DESCRIPTION: return (DataObject)createDescription();
      case DOCUMENTATION: return (DataObject)createDocumentation();
      case DURATION: return (DataObject)createDuration();
      case EJB: return (DataObject)createEjb();
      case END_EVENT: return (DataObject)createEndEvent();
      case END_POINT: return (DataObject)createEndPoint();
      case ENUMERATION_TYPE: return (DataObject)createEnumerationType();
      case ENUMERATION_VALUE: return (DataObject)createEnumerationValue();
      case EVENT: return (DataObject)createEvent();
      case EXCEPTION_NAME: return (DataObject)createExceptionName();
      case EXPRESSION_TYPE: return (DataObject)createExpressionType();
      case EXTENDED_ATTRIBUTE: return (DataObject)createExtendedAttribute();
      case EXTENDED_ATTRIBUTES: return (DataObject)createExtendedAttributes();
      case EXTERNAL_PACKAGE: return (DataObject)createExternalPackage();
      case EXTERNAL_PACKAGES: return (DataObject)createExternalPackages();
      case EXTERNAL_REFERENCE: return (DataObject)createExternalReference();
      case FORM: return (DataObject)createForm();
      case FORMAL_PARAMETER: return (DataObject)createFormalParameter();
      case FORMAL_PARAMETERS: return (DataObject)createFormalParameters();
      case FORM_LAYOUT: return (DataObject)createFormLayout();
      case HOME_CLASS: return (DataObject)createHomeClass();
      case ICON: return (DataObject)createIcon();
      case IMPLEMENTATION7: return (DataObject)createImplementation7();
      case INPUT: return (DataObject)createInput();
      case INPUT_SET: return (DataObject)createInputSet();
      case INPUT_SETS: return (DataObject)createInputSets();
      case INTERMEDIATE_EVENT: return (DataObject)createIntermediateEvent();
      case IO_RULES: return (DataObject)createIORules();
      case JNDI_NAME: return (DataObject)createJndiName();
      case JOIN: return (DataObject)createJoin();
      case LANE: return (DataObject)createLane();
      case LANES: return (DataObject)createLanes();
      case LENGTH: return (DataObject)createLength();
      case LIMIT: return (DataObject)createLimit();
      case LIST_TYPE: return (DataObject)createListType();
      case LOCATION: return (DataObject)createLocation();
      case LOOP: return (DataObject)createLoop();
      case LOOP_MULTI_INSTANCE: return (DataObject)createLoopMultiInstance();
      case LOOP_STANDARD: return (DataObject)createLoopStandard();
      case MEMBER: return (DataObject)createMember();
      case MESSAGE_FLOW: return (DataObject)createMessageFlow();
      case MESSAGE_FLOWS: return (DataObject)createMessageFlows();
      case MESSAGE_TYPE: return (DataObject)createMessageType();
      case METHOD: return (DataObject)createMethod();
      case METHOD1: return (DataObject)createMethod1();
      case MY_ROLE: return (DataObject)createMyRole();
      case NO: return (DataObject)createNo();
      case NODE_GRAPHICS_INFO: return (DataObject)createNodeGraphicsInfo();
      case NODE_GRAPHICS_INFOS: return (DataObject)createNodeGraphicsInfos();
      case OBJECT: return (DataObject)createObject();
      case OUTPUT: return (DataObject)createOutput();
      case OUTPUT_SET: return (DataObject)createOutputSet();
      case OUTPUT_SETS: return (DataObject)createOutputSets();
      case PACKAGE_HEADER: return (DataObject)createPackageHeader();
      case PACKAGE_TYPE: return (DataObject)createPackageType();
      case PARTICIPANT: return (DataObject)createParticipant();
      case PARTICIPANTS: return (DataObject)createParticipants();
      case PARTICIPANT_TYPE: return (DataObject)createParticipantType();
      case PARTNER: return (DataObject)createPartner();
      case PARTNER_LINK: return (DataObject)createPartnerLink();
      case PARTNER_LINKS: return (DataObject)createPartnerLinks();
      case PARTNER_LINK_TYPE: return (DataObject)createPartnerLinkType();
      case PARTNER_LINK_TYPES: return (DataObject)createPartnerLinkTypes();
      case PARTNER_ROLE: return (DataObject)createPartnerRole();
      case PERFORMER: return (DataObject)createPerformer();
      case PERFORMERS: return (DataObject)createPerformers();
      case POJO: return (DataObject)createPojo();
      case POOL: return (DataObject)createPool();
      case POOLS: return (DataObject)createPools();
      case PRECISION: return (DataObject)createPrecision();
      case PRIORITY: return (DataObject)createPriority();
      case PRIORITY_UNIT: return (DataObject)createPriorityUnit();
      case PROCESS_HEADER: return (DataObject)createProcessHeader();
      case PROCESS_TYPE1: return (DataObject)createProcessType1();
      case RECORD_TYPE: return (DataObject)createRecordType();
      case REDEFINABLE_HEADER: return (DataObject)createRedefinableHeader();
      case REFERENCE: return (DataObject)createReference();
      case RESPONSIBLE: return (DataObject)createResponsible();
      case RESPONSIBLES: return (DataObject)createResponsibles();
      case RESULT_COMPENSATION: return (DataObject)createResultCompensation();
      case RESULT_ERROR: return (DataObject)createResultError();
      case RESULT_MULTIPLE: return (DataObject)createResultMultiple();
      case ROLE: return (DataObject)createRole();
      case ROUTE: return (DataObject)createRoute();
      case RULE: return (DataObject)createRule();
      case RULE_NAME: return (DataObject)createRuleName();
      case SCALE: return (DataObject)createScale();
      case SCHEMA_TYPE: return (DataObject)createSchemaType();
      case SCRIPT: return (DataObject)createScript();
      case SCRIPT1: return (DataObject)createScript1();
      case SERVICE: return (DataObject)createService();
      case SIMULATION_INFORMATION: return (DataObject)createSimulationInformation();
      case SPLIT: return (DataObject)createSplit();
      case START_EVENT: return (DataObject)createStartEvent();
      case SUB_FLOW: return (DataObject)createSubFlow();
      case TASK: return (DataObject)createTask();
      case TASK_APPLICATION: return (DataObject)createTaskApplication();
      case TASK_MANUAL: return (DataObject)createTaskManual();
      case TASK_RECEIVE: return (DataObject)createTaskReceive();
      case TASK_REFERENCE: return (DataObject)createTaskReference();
      case TASK_SCRIPT: return (DataObject)createTaskScript();
      case TASK_SEND: return (DataObject)createTaskSend();
      case TASK_SERVICE: return (DataObject)createTaskService();
      case TASK_USER: return (DataObject)createTaskUser();
      case TIME_ESTIMATION: return (DataObject)createTimeEstimation();
      case TRANSACTION: return (DataObject)createTransaction();
      case TRANSITION: return (DataObject)createTransition();
      case TRANSITION_REF: return (DataObject)createTransitionRef();
      case TRANSITION_REFS: return (DataObject)createTransitionRefs();
      case TRANSITION_RESTRICTION: return (DataObject)createTransitionRestriction();
      case TRANSITION_RESTRICTIONS: return (DataObject)createTransitionRestrictions();
      case TRANSITIONS: return (DataObject)createTransitions();
      case TRIGGER_INTERMEDIATE_MULTIPLE: return (DataObject)createTriggerIntermediateMultiple();
      case TRIGGER_MULTIPLE: return (DataObject)createTriggerMultiple();
      case TRIGGER_RESULT_LINK: return (DataObject)createTriggerResultLink();
      case TRIGGER_RESULT_MESSAGE: return (DataObject)createTriggerResultMessage();
      case TRIGGER_RULE: return (DataObject)createTriggerRule();
      case TRIGGER_TIMER: return (DataObject)createTriggerTimer();
      case TYPE_DECLARATION: return (DataObject)createTypeDeclaration();
      case TYPE_DECLARATIONS: return (DataObject)createTypeDeclarations();
      case UNION_TYPE: return (DataObject)createUnionType();
      case VALID_FROM: return (DataObject)createValidFrom();
      case VALID_TO: return (DataObject)createValidTo();
      case VENDOR: return (DataObject)createVendor();
      case VENDOR_EXTENSION: return (DataObject)createVendorExtension();
      case VENDOR_EXTENSIONS: return (DataObject)createVendorExtensions();
      case VERSION: return (DataObject)createVersion();
      case WAITING_TIME: return (DataObject)createWaitingTime();
      case WEB_SERVICE: return (DataObject)createWebService();
      case WEB_SERVICE_FAULT_CATCH: return (DataObject)createWebServiceFaultCatch();
      case WEB_SERVICE_OPERATION: return (DataObject)createWebServiceOperation();
      case WORKFLOW_PROCESSES: return (DataObject)createWorkflowProcesses();
      case WORKING_TIME: return (DataObject)createWorkingTime();
      case XPDL_VERSION: return (DataObject)createXPDLVersion();
      case XSLT: return (DataObject)createXslt();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(int typeNumber, String initialValue)
  {
    switch (typeNumber)
    {
      case ACCESS_LEVEL:
        return createAccessLevelFromString(initialValue);
      case AD_HOC_ORDERING:
        return createAdHocOrderingFromString(initialValue);
      case AD_HOC_ORDERING1:
        return createAdHocOrdering1FromString(initialValue);
      case ARTIFACT_TYPE:
        return createArtifactTypeFromString(initialValue);
      case ASSIGN_TIME:
        return createAssignTimeFromString(initialValue);
      case ASSOCIATION_DIRECTION:
        return createAssociationDirectionFromString(initialValue);
      case DIRECTION:
        return createDirectionFromString(initialValue);
      case DURATION_UNIT:
        return createDurationUnitFromString(initialValue);
      case END_POINT_TYPE:
        return createEndPointTypeFromString(initialValue);
      case EXECUTION:
        return createExecutionFromString(initialValue);
      case EXECUTION1:
        return createExecution1FromString(initialValue);
      case FINISH_MODE:
        return createFinishModeFromString(initialValue);
      case GATEWAY_TYPE:
        return createGatewayTypeFromString(initialValue);
      case GRAPH_CONFORMANCE:
        return createGraphConformanceFromString(initialValue);
      case IMPLEMENTATION:
        return createImplementationFromString(initialValue);
      case IMPLEMENTATION1:
        return createImplementation1FromString(initialValue);
      case IMPLEMENTATION2:
        return createImplementation2FromString(initialValue);
      case IMPLEMENTATION3:
        return createImplementation3FromString(initialValue);
      case IMPLEMENTATION4:
        return createImplementation4FromString(initialValue);
      case IMPLEMENTATION5:
        return createImplementation5FromString(initialValue);
      case IMPLEMENTATION6:
        return createImplementation6FromString(initialValue);
      case INSTANTIATION:
        return createInstantiationFromString(initialValue);
      case IS_ARRAY:
        return createIsArrayFromString(initialValue);
      case LOOP_TYPE:
        return createLoopTypeFromString(initialValue);
      case MI_FLOW_CONDITION:
        return createMI_FlowConditionFromString(initialValue);
      case MI_ORDERING:
        return createMI_OrderingFromString(initialValue);
      case MODE:
        return createModeFromString(initialValue);
      case ORIENTATION:
        return createOrientationFromString(initialValue);
      case PROCESS_TYPE:
        return createProcessTypeFromString(initialValue);
      case PUBLICATION_STATUS:
        return createPublicationStatusFromString(initialValue);
      case RESULT:
        return createResultFromString(initialValue);
      case ROLE_TYPE:
        return createRoleTypeFromString(initialValue);
      case SHAPE:
        return createSHAPEFromString(initialValue);
      case START_MODE:
        return createStartModeFromString(initialValue);
      case STATUS:
        return createStatusFromString(initialValue);
      case STATUS1:
        return createStatus1FromString(initialValue);
      case TEST_TIME:
        return createTestTimeFromString(initialValue);
      case TRANSACTION_METHOD:
        return createTransactionMethodFromString(initialValue);
      case TRIGGER:
        return createTriggerFromString(initialValue);
      case TRIGGER1:
        return createTrigger1FromString(initialValue);
      case TYPE:
        return createTypeFromString(initialValue);
      case TYPE1:
        return createType1FromString(initialValue);
      case TYPE2:
        return createType2FromString(initialValue);
      case TYPE3:
        return createType3FromString(initialValue);
      case TYPE4:
        return createType4FromString(initialValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(int typeNumber, Object instanceValue)
  {
    switch (typeNumber)
    {
      case ACCESS_LEVEL:
        return convertAccessLevelToString(instanceValue);
      case AD_HOC_ORDERING:
        return convertAdHocOrderingToString(instanceValue);
      case AD_HOC_ORDERING1:
        return convertAdHocOrdering1ToString(instanceValue);
      case ARTIFACT_TYPE:
        return convertArtifactTypeToString(instanceValue);
      case ASSIGN_TIME:
        return convertAssignTimeToString(instanceValue);
      case ASSOCIATION_DIRECTION:
        return convertAssociationDirectionToString(instanceValue);
      case DIRECTION:
        return convertDirectionToString(instanceValue);
      case DURATION_UNIT:
        return convertDurationUnitToString(instanceValue);
      case END_POINT_TYPE:
        return convertEndPointTypeToString(instanceValue);
      case EXECUTION:
        return convertExecutionToString(instanceValue);
      case EXECUTION1:
        return convertExecution1ToString(instanceValue);
      case FINISH_MODE:
        return convertFinishModeToString(instanceValue);
      case GATEWAY_TYPE:
        return convertGatewayTypeToString(instanceValue);
      case GRAPH_CONFORMANCE:
        return convertGraphConformanceToString(instanceValue);
      case IMPLEMENTATION:
        return convertImplementationToString(instanceValue);
      case IMPLEMENTATION1:
        return convertImplementation1ToString(instanceValue);
      case IMPLEMENTATION2:
        return convertImplementation2ToString(instanceValue);
      case IMPLEMENTATION3:
        return convertImplementation3ToString(instanceValue);
      case IMPLEMENTATION4:
        return convertImplementation4ToString(instanceValue);
      case IMPLEMENTATION5:
        return convertImplementation5ToString(instanceValue);
      case IMPLEMENTATION6:
        return convertImplementation6ToString(instanceValue);
      case INSTANTIATION:
        return convertInstantiationToString(instanceValue);
      case IS_ARRAY:
        return convertIsArrayToString(instanceValue);
      case LOOP_TYPE:
        return convertLoopTypeToString(instanceValue);
      case MI_FLOW_CONDITION:
        return convertMI_FlowConditionToString(instanceValue);
      case MI_ORDERING:
        return convertMI_OrderingToString(instanceValue);
      case MODE:
        return convertModeToString(instanceValue);
      case ORIENTATION:
        return convertOrientationToString(instanceValue);
      case PROCESS_TYPE:
        return convertProcessTypeToString(instanceValue);
      case PUBLICATION_STATUS:
        return convertPublicationStatusToString(instanceValue);
      case RESULT:
        return convertResultToString(instanceValue);
      case ROLE_TYPE:
        return convertRoleTypeToString(instanceValue);
      case SHAPE:
        return convertSHAPEToString(instanceValue);
      case START_MODE:
        return convertStartModeToString(instanceValue);
      case STATUS:
        return convertStatusToString(instanceValue);
      case STATUS1:
        return convertStatus1ToString(instanceValue);
      case TEST_TIME:
        return convertTestTimeToString(instanceValue);
      case TRANSACTION_METHOD:
        return convertTransactionMethodToString(instanceValue);
      case TRIGGER:
        return convertTriggerToString(instanceValue);
      case TRIGGER1:
        return convertTrigger1ToString(instanceValue);
      case TYPE:
        return convertTypeToString(instanceValue);
      case TYPE1:
        return convertType1ToString(instanceValue);
      case TYPE2:
        return convertType2ToString(instanceValue);
      case TYPE3:
        return convertType3ToString(instanceValue);
      case TYPE4:
        return convertType4ToString(instanceValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activities createActivities()
  {
    ActivitiesImpl activities = new ActivitiesImpl();
    return activities;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity createActivity()
  {
    ActivityImpl activity = new ActivityImpl();
    return activity;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivitySet createActivitySet()
  {
    ActivitySetImpl activitySet = new ActivitySetImpl();
    return activitySet;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivitySets createActivitySets()
  {
    ActivitySetsImpl activitySets = new ActivitySetsImpl();
    return activitySets;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualParameters createActualParameters()
  {
    ActualParametersImpl actualParameters = new ActualParametersImpl();
    return actualParameters;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Application createApplication()
  {
    ApplicationImpl application = new ApplicationImpl();
    return application;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Applications createApplications()
  {
    ApplicationsImpl applications = new ApplicationsImpl();
    return applications;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationType createApplicationType()
  {
    ApplicationTypeImpl applicationType = new ApplicationTypeImpl();
    return applicationType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayType createArrayType()
  {
    ArrayTypeImpl arrayType = new ArrayTypeImpl();
    return arrayType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Artifact createArtifact()
  {
    ArtifactImpl artifact = new ArtifactImpl();
    return artifact;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Artifacts createArtifacts()
  {
    ArtifactsImpl artifacts = new ArtifactsImpl();
    return artifacts;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignments createAssignments()
  {
    AssignmentsImpl assignments = new AssignmentsImpl();
    return assignments;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association createAssociation()
  {
    AssociationImpl association = new AssociationImpl();
    return association;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Associations createAssociations()
  {
    AssociationsImpl associations = new AssociationsImpl();
    return associations;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Author createAuthor()
  {
    AuthorImpl author = new AuthorImpl();
    return author;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasicType createBasicType()
  {
    BasicTypeImpl basicType = new BasicTypeImpl();
    return basicType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockActivity createBlockActivity()
  {
    BlockActivityImpl blockActivity = new BlockActivityImpl();
    return blockActivity;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BusinessRule createBusinessRule()
  {
    BusinessRuleImpl businessRule = new BusinessRuleImpl();
    return businessRule;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories createCategories()
  {
    CategoriesImpl categories = new CategoriesImpl();
    return categories;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Category createCategory()
  {
    CategoryImpl category = new CategoryImpl();
    return category;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.Class createClass()
  {
    ClassImpl class_ = new ClassImpl();
    return class_;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Codepage createCodepage()
  {
    CodepageImpl codepage = new CodepageImpl();
    return codepage;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Condition createCondition()
  {
    ConditionImpl condition = new ConditionImpl();
    return condition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConformanceClass createConformanceClass()
  {
    ConformanceClassImpl conformanceClass = new ConformanceClassImpl();
    return conformanceClass;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectorGraphicsInfo createConnectorGraphicsInfo()
  {
    ConnectorGraphicsInfoImpl connectorGraphicsInfo = new ConnectorGraphicsInfoImpl();
    return connectorGraphicsInfo;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectorGraphicsInfos createConnectorGraphicsInfos()
  {
    ConnectorGraphicsInfosImpl connectorGraphicsInfos = new ConnectorGraphicsInfosImpl();
    return connectorGraphicsInfos;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinates createCoordinates()
  {
    CoordinatesImpl coordinates = new CoordinatesImpl();
    return coordinates;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cost createCost()
  {
    CostImpl cost = new CostImpl();
    return cost;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CostUnit createCostUnit()
  {
    CostUnitImpl costUnit = new CostUnitImpl();
    return costUnit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Countrykey createCountrykey()
  {
    CountrykeyImpl countrykey = new CountrykeyImpl();
    return countrykey;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Created createCreated()
  {
    CreatedImpl created = new CreatedImpl();
    return created;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataField createDataField()
  {
    DataFieldImpl dataField = new DataFieldImpl();
    return dataField;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataFields createDataFields()
  {
    DataFieldsImpl dataFields = new DataFieldsImpl();
    return dataFields;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataMapping createDataMapping()
  {
    DataMappingImpl dataMapping = new DataMappingImpl();
    return dataMapping;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataMappings createDataMappings()
  {
    DataMappingsImpl dataMappings = new DataMappingsImpl();
    return dataMappings;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.DataObject createDataObject()
  {
    DataObjectImpl dataObject = new DataObjectImpl();
    return dataObject;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Deadline createDeadline()
  {
    DeadlineImpl deadline = new DeadlineImpl();
    return deadline;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclaredType createDeclaredType()
  {
    DeclaredTypeImpl declaredType = new DeclaredTypeImpl();
    return declaredType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description createDescription()
  {
    DescriptionImpl description = new DescriptionImpl();
    return description;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Documentation createDocumentation()
  {
    DocumentationImpl documentation = new DocumentationImpl();
    return documentation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Duration createDuration()
  {
    DurationImpl duration = new DurationImpl();
    return duration;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ejb createEjb()
  {
    EjbImpl ejb = new EjbImpl();
    return ejb;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndEvent createEndEvent()
  {
    EndEventImpl endEvent = new EndEventImpl();
    return endEvent;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndPoint createEndPoint()
  {
    EndPointImpl endPoint = new EndPointImpl();
    return endPoint;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationType createEnumerationType()
  {
    EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
    return enumerationType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationValue createEnumerationValue()
  {
    EnumerationValueImpl enumerationValue = new EnumerationValueImpl();
    return enumerationValue;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExceptionName createExceptionName()
  {
    ExceptionNameImpl exceptionName = new ExceptionNameImpl();
    return exceptionName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionType createExpressionType()
  {
    ExpressionTypeImpl expressionType = new ExpressionTypeImpl();
    return expressionType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedAttribute createExtendedAttribute()
  {
    ExtendedAttributeImpl extendedAttribute = new ExtendedAttributeImpl();
    return extendedAttribute;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedAttributes createExtendedAttributes()
  {
    ExtendedAttributesImpl extendedAttributes = new ExtendedAttributesImpl();
    return extendedAttributes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalPackage createExternalPackage()
  {
    ExternalPackageImpl externalPackage = new ExternalPackageImpl();
    return externalPackage;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalPackages createExternalPackages()
  {
    ExternalPackagesImpl externalPackages = new ExternalPackagesImpl();
    return externalPackages;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalReference createExternalReference()
  {
    ExternalReferenceImpl externalReference = new ExternalReferenceImpl();
    return externalReference;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Form createForm()
  {
    FormImpl form = new FormImpl();
    return form;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameter createFormalParameter()
  {
    FormalParameterImpl formalParameter = new FormalParameterImpl();
    return formalParameter;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameters createFormalParameters()
  {
    FormalParametersImpl formalParameters = new FormalParametersImpl();
    return formalParameters;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormLayout createFormLayout()
  {
    FormLayoutImpl formLayout = new FormLayoutImpl();
    return formLayout;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HomeClass createHomeClass()
  {
    HomeClassImpl homeClass = new HomeClassImpl();
    return homeClass;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Icon createIcon()
  {
    IconImpl icon = new IconImpl();
    return icon;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Implementation7 createImplementation7()
  {
    Implementation7Impl implementation7 = new Implementation7Impl();
    return implementation7;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Input createInput()
  {
    InputImpl input = new InputImpl();
    return input;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputSet createInputSet()
  {
    InputSetImpl inputSet = new InputSetImpl();
    return inputSet;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputSets createInputSets()
  {
    InputSetsImpl inputSets = new InputSetsImpl();
    return inputSets;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntermediateEvent createIntermediateEvent()
  {
    IntermediateEventImpl intermediateEvent = new IntermediateEventImpl();
    return intermediateEvent;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IORules createIORules()
  {
    IORulesImpl ioRules = new IORulesImpl();
    return ioRules;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JndiName createJndiName()
  {
    JndiNameImpl jndiName = new JndiNameImpl();
    return jndiName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Join createJoin()
  {
    JoinImpl join = new JoinImpl();
    return join;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lane createLane()
  {
    LaneImpl lane = new LaneImpl();
    return lane;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lanes createLanes()
  {
    LanesImpl lanes = new LanesImpl();
    return lanes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Length createLength()
  {
    LengthImpl length = new LengthImpl();
    return length;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Limit createLimit()
  {
    LimitImpl limit = new LimitImpl();
    return limit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListType createListType()
  {
    ListTypeImpl listType = new ListTypeImpl();
    return listType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Location createLocation()
  {
    LocationImpl location = new LocationImpl();
    return location;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop createLoop()
  {
    LoopImpl loop = new LoopImpl();
    return loop;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopMultiInstance createLoopMultiInstance()
  {
    LoopMultiInstanceImpl loopMultiInstance = new LoopMultiInstanceImpl();
    return loopMultiInstance;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopStandard createLoopStandard()
  {
    LoopStandardImpl loopStandard = new LoopStandardImpl();
    return loopStandard;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Member createMember()
  {
    MemberImpl member = new MemberImpl();
    return member;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageFlow createMessageFlow()
  {
    MessageFlowImpl messageFlow = new MessageFlowImpl();
    return messageFlow;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageFlows createMessageFlows()
  {
    MessageFlowsImpl messageFlows = new MessageFlowsImpl();
    return messageFlows;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageType createMessageType()
  {
    MessageTypeImpl messageType = new MessageTypeImpl();
    return messageType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method createMethod()
  {
    MethodImpl method = new MethodImpl();
    return method;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method1 createMethod1()
  {
    Method1Impl method1 = new Method1Impl();
    return method1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyRole createMyRole()
  {
    MyRoleImpl myRole = new MyRoleImpl();
    return myRole;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public No createNo()
  {
    NoImpl no = new NoImpl();
    return no;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeGraphicsInfo createNodeGraphicsInfo()
  {
    NodeGraphicsInfoImpl nodeGraphicsInfo = new NodeGraphicsInfoImpl();
    return nodeGraphicsInfo;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeGraphicsInfos createNodeGraphicsInfos()
  {
    NodeGraphicsInfosImpl nodeGraphicsInfos = new NodeGraphicsInfosImpl();
    return nodeGraphicsInfos;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.Object createObject()
  {
    ObjectImpl object = new ObjectImpl();
    return object;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output createOutput()
  {
    OutputImpl output = new OutputImpl();
    return output;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputSet createOutputSet()
  {
    OutputSetImpl outputSet = new OutputSetImpl();
    return outputSet;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputSets createOutputSets()
  {
    OutputSetsImpl outputSets = new OutputSetsImpl();
    return outputSets;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageHeader createPackageHeader()
  {
    PackageHeaderImpl packageHeader = new PackageHeaderImpl();
    return packageHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageType createPackageType()
  {
    PackageTypeImpl packageType = new PackageTypeImpl();
    return packageType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Participant createParticipant()
  {
    ParticipantImpl participant = new ParticipantImpl();
    return participant;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Participants createParticipants()
  {
    ParticipantsImpl participants = new ParticipantsImpl();
    return participants;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParticipantType createParticipantType()
  {
    ParticipantTypeImpl participantType = new ParticipantTypeImpl();
    return participantType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partner createPartner()
  {
    PartnerImpl partner = new PartnerImpl();
    return partner;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartnerLink createPartnerLink()
  {
    PartnerLinkImpl partnerLink = new PartnerLinkImpl();
    return partnerLink;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartnerLinks createPartnerLinks()
  {
    PartnerLinksImpl partnerLinks = new PartnerLinksImpl();
    return partnerLinks;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartnerLinkType createPartnerLinkType()
  {
    PartnerLinkTypeImpl partnerLinkType = new PartnerLinkTypeImpl();
    return partnerLinkType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartnerLinkTypes createPartnerLinkTypes()
  {
    PartnerLinkTypesImpl partnerLinkTypes = new PartnerLinkTypesImpl();
    return partnerLinkTypes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartnerRole createPartnerRole()
  {
    PartnerRoleImpl partnerRole = new PartnerRoleImpl();
    return partnerRole;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Performer createPerformer()
  {
    PerformerImpl performer = new PerformerImpl();
    return performer;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Performers createPerformers()
  {
    PerformersImpl performers = new PerformersImpl();
    return performers;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pojo createPojo()
  {
    PojoImpl pojo = new PojoImpl();
    return pojo;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pool createPool()
  {
    PoolImpl pool = new PoolImpl();
    return pool;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pools createPools()
  {
    PoolsImpl pools = new PoolsImpl();
    return pools;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Precision createPrecision()
  {
    PrecisionImpl precision = new PrecisionImpl();
    return precision;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Priority createPriority()
  {
    PriorityImpl priority = new PriorityImpl();
    return priority;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PriorityUnit createPriorityUnit()
  {
    PriorityUnitImpl priorityUnit = new PriorityUnitImpl();
    return priorityUnit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessHeader createProcessHeader()
  {
    ProcessHeaderImpl processHeader = new ProcessHeaderImpl();
    return processHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessType1 createProcessType1()
  {
    ProcessType1Impl processType1 = new ProcessType1Impl();
    return processType1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordType createRecordType()
  {
    RecordTypeImpl recordType = new RecordTypeImpl();
    return recordType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinableHeader createRedefinableHeader()
  {
    RedefinableHeaderImpl redefinableHeader = new RedefinableHeaderImpl();
    return redefinableHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference createReference()
  {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Responsible createResponsible()
  {
    ResponsibleImpl responsible = new ResponsibleImpl();
    return responsible;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Responsibles createResponsibles()
  {
    ResponsiblesImpl responsibles = new ResponsiblesImpl();
    return responsibles;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultCompensation createResultCompensation()
  {
    ResultCompensationImpl resultCompensation = new ResultCompensationImpl();
    return resultCompensation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultError createResultError()
  {
    ResultErrorImpl resultError = new ResultErrorImpl();
    return resultError;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultMultiple createResultMultiple()
  {
    ResultMultipleImpl resultMultiple = new ResultMultipleImpl();
    return resultMultiple;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Role createRole()
  {
    RoleImpl role = new RoleImpl();
    return role;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Route createRoute()
  {
    RouteImpl route = new RouteImpl();
    return route;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleName createRuleName()
  {
    RuleNameImpl ruleName = new RuleNameImpl();
    return ruleName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scale createScale()
  {
    ScaleImpl scale = new ScaleImpl();
    return scale;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemaType createSchemaType()
  {
    SchemaTypeImpl schemaType = new SchemaTypeImpl();
    return schemaType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Script createScript()
  {
    ScriptImpl script = new ScriptImpl();
    return script;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Script1 createScript1()
  {
    Script1Impl script1 = new Script1Impl();
    return script1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Service createService()
  {
    ServiceImpl service = new ServiceImpl();
    return service;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimulationInformation createSimulationInformation()
  {
    SimulationInformationImpl simulationInformation = new SimulationInformationImpl();
    return simulationInformation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Split createSplit()
  {
    SplitImpl split = new SplitImpl();
    return split;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StartEvent createStartEvent()
  {
    StartEventImpl startEvent = new StartEventImpl();
    return startEvent;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubFlow createSubFlow()
  {
    SubFlowImpl subFlow = new SubFlowImpl();
    return subFlow;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task createTask()
  {
    TaskImpl task = new TaskImpl();
    return task;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskApplication createTaskApplication()
  {
    TaskApplicationImpl taskApplication = new TaskApplicationImpl();
    return taskApplication;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskManual createTaskManual()
  {
    TaskManualImpl taskManual = new TaskManualImpl();
    return taskManual;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskReceive createTaskReceive()
  {
    TaskReceiveImpl taskReceive = new TaskReceiveImpl();
    return taskReceive;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskReference createTaskReference()
  {
    TaskReferenceImpl taskReference = new TaskReferenceImpl();
    return taskReference;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskScript createTaskScript()
  {
    TaskScriptImpl taskScript = new TaskScriptImpl();
    return taskScript;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskSend createTaskSend()
  {
    TaskSendImpl taskSend = new TaskSendImpl();
    return taskSend;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskService createTaskService()
  {
    TaskServiceImpl taskService = new TaskServiceImpl();
    return taskService;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskUser createTaskUser()
  {
    TaskUserImpl taskUser = new TaskUserImpl();
    return taskUser;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeEstimation createTimeEstimation()
  {
    TimeEstimationImpl timeEstimation = new TimeEstimationImpl();
    return timeEstimation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transaction createTransaction()
  {
    TransactionImpl transaction = new TransactionImpl();
    return transaction;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRef createTransitionRef()
  {
    TransitionRefImpl transitionRef = new TransitionRefImpl();
    return transitionRef;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRefs createTransitionRefs()
  {
    TransitionRefsImpl transitionRefs = new TransitionRefsImpl();
    return transitionRefs;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRestriction createTransitionRestriction()
  {
    TransitionRestrictionImpl transitionRestriction = new TransitionRestrictionImpl();
    return transitionRestriction;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRestrictions createTransitionRestrictions()
  {
    TransitionRestrictionsImpl transitionRestrictions = new TransitionRestrictionsImpl();
    return transitionRestrictions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transitions createTransitions()
  {
    TransitionsImpl transitions = new TransitionsImpl();
    return transitions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerIntermediateMultiple createTriggerIntermediateMultiple()
  {
    TriggerIntermediateMultipleImpl triggerIntermediateMultiple = new TriggerIntermediateMultipleImpl();
    return triggerIntermediateMultiple;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerMultiple createTriggerMultiple()
  {
    TriggerMultipleImpl triggerMultiple = new TriggerMultipleImpl();
    return triggerMultiple;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerResultLink createTriggerResultLink()
  {
    TriggerResultLinkImpl triggerResultLink = new TriggerResultLinkImpl();
    return triggerResultLink;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerResultMessage createTriggerResultMessage()
  {
    TriggerResultMessageImpl triggerResultMessage = new TriggerResultMessageImpl();
    return triggerResultMessage;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerRule createTriggerRule()
  {
    TriggerRuleImpl triggerRule = new TriggerRuleImpl();
    return triggerRule;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerTimer createTriggerTimer()
  {
    TriggerTimerImpl triggerTimer = new TriggerTimerImpl();
    return triggerTimer;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclaration createTypeDeclaration()
  {
    TypeDeclarationImpl typeDeclaration = new TypeDeclarationImpl();
    return typeDeclaration;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclarations createTypeDeclarations()
  {
    TypeDeclarationsImpl typeDeclarations = new TypeDeclarationsImpl();
    return typeDeclarations;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnionType createUnionType()
  {
    UnionTypeImpl unionType = new UnionTypeImpl();
    return unionType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValidFrom createValidFrom()
  {
    ValidFromImpl validFrom = new ValidFromImpl();
    return validFrom;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValidTo createValidTo()
  {
    ValidToImpl validTo = new ValidToImpl();
    return validTo;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vendor createVendor()
  {
    VendorImpl vendor = new VendorImpl();
    return vendor;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VendorExtension createVendorExtension()
  {
    VendorExtensionImpl vendorExtension = new VendorExtensionImpl();
    return vendorExtension;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VendorExtensions createVendorExtensions()
  {
    VendorExtensionsImpl vendorExtensions = new VendorExtensionsImpl();
    return vendorExtensions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Version createVersion()
  {
    VersionImpl version = new VersionImpl();
    return version;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WaitingTime createWaitingTime()
  {
    WaitingTimeImpl waitingTime = new WaitingTimeImpl();
    return waitingTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WebService createWebService()
  {
    WebServiceImpl webService = new WebServiceImpl();
    return webService;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WebServiceFaultCatch createWebServiceFaultCatch()
  {
    WebServiceFaultCatchImpl webServiceFaultCatch = new WebServiceFaultCatchImpl();
    return webServiceFaultCatch;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WebServiceOperation createWebServiceOperation()
  {
    WebServiceOperationImpl webServiceOperation = new WebServiceOperationImpl();
    return webServiceOperation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkflowProcesses createWorkflowProcesses()
  {
    WorkflowProcessesImpl workflowProcesses = new WorkflowProcessesImpl();
    return workflowProcesses;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkingTime createWorkingTime()
  {
    WorkingTimeImpl workingTime = new WorkingTimeImpl();
    return workingTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XPDLVersion createXPDLVersion()
  {
    XPDLVersionImpl xpdlVersion = new XPDLVersionImpl();
    return xpdlVersion;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Xslt createXslt()
  {
    XsltImpl xslt = new XsltImpl();
    return xslt;
  }
  
  // Following creates and initializes SDO metadata for the supported types.		
  protected Type activitiesType = null;

  public Type getActivities()
  {
    return activitiesType;
  }
    
  protected Type activityType = null;

  public Type getActivity()
  {
    return activityType;
  }
    
  protected Type activitySetType = null;

  public Type getActivitySet()
  {
    return activitySetType;
  }
    
  protected Type activitySetsType = null;

  public Type getActivitySets()
  {
    return activitySetsType;
  }
    
  protected Type actualParametersType = null;

  public Type getActualParameters()
  {
    return actualParametersType;
  }
    
  protected Type applicationType = null;

  public Type getApplication()
  {
    return applicationType;
  }
    
  protected Type applicationsType = null;

  public Type getApplications()
  {
    return applicationsType;
  }
    
  protected Type applicationTypeType = null;

  public Type getApplicationType()
  {
    return applicationTypeType;
  }
    
  protected Type arrayTypeType = null;

  public Type getArrayType()
  {
    return arrayTypeType;
  }
    
  protected Type artifactType = null;

  public Type getArtifact()
  {
    return artifactType;
  }
    
  protected Type artifactsType = null;

  public Type getArtifacts()
  {
    return artifactsType;
  }
    
  protected Type assignmentType = null;

  public Type getAssignment()
  {
    return assignmentType;
  }
    
  protected Type assignmentsType = null;

  public Type getAssignments()
  {
    return assignmentsType;
  }
    
  protected Type associationType = null;

  public Type getAssociation()
  {
    return associationType;
  }
    
  protected Type associationsType = null;

  public Type getAssociations()
  {
    return associationsType;
  }
    
  protected Type authorType = null;

  public Type getAuthor()
  {
    return authorType;
  }
    
  protected Type basicTypeType = null;

  public Type getBasicType()
  {
    return basicTypeType;
  }
    
  protected Type blockActivityType = null;

  public Type getBlockActivity()
  {
    return blockActivityType;
  }
    
  protected Type businessRuleType = null;

  public Type getBusinessRule()
  {
    return businessRuleType;
  }
    
  protected Type categoriesType = null;

  public Type getCategories()
  {
    return categoriesType;
  }
    
  protected Type categoryType = null;

  public Type getCategory()
  {
    return categoryType;
  }
    
  protected Type class_Type = null;

  public Type getClass_()
  {
    return class_Type;
  }
    
  protected Type codepageType = null;

  public Type getCodepage()
  {
    return codepageType;
  }
    
  protected Type conditionType = null;

  public Type getCondition()
  {
    return conditionType;
  }
    
  protected Type conformanceClassType = null;

  public Type getConformanceClass()
  {
    return conformanceClassType;
  }
    
  protected Type connectorGraphicsInfoType = null;

  public Type getConnectorGraphicsInfo()
  {
    return connectorGraphicsInfoType;
  }
    
  protected Type connectorGraphicsInfosType = null;

  public Type getConnectorGraphicsInfos()
  {
    return connectorGraphicsInfosType;
  }
    
  protected Type coordinatesType = null;

  public Type getCoordinates()
  {
    return coordinatesType;
  }
    
  protected Type costType = null;

  public Type getCost()
  {
    return costType;
  }
    
  protected Type costUnitType = null;

  public Type getCostUnit()
  {
    return costUnitType;
  }
    
  protected Type countrykeyType = null;

  public Type getCountrykey()
  {
    return countrykeyType;
  }
    
  protected Type createdType = null;

  public Type getCreated()
  {
    return createdType;
  }
    
  protected Type dataFieldType = null;

  public Type getDataField()
  {
    return dataFieldType;
  }
    
  protected Type dataFieldsType = null;

  public Type getDataFields()
  {
    return dataFieldsType;
  }
    
  protected Type dataMappingType = null;

  public Type getDataMapping()
  {
    return dataMappingType;
  }
    
  protected Type dataMappingsType = null;

  public Type getDataMappings()
  {
    return dataMappingsType;
  }
    
  protected Type dataObjectType = null;

  public Type getDataObject()
  {
    return dataObjectType;
  }
    
  protected Type dataTypeType = null;

  public Type getDataType()
  {
    return dataTypeType;
  }
    
  protected Type deadlineType = null;

  public Type getDeadline()
  {
    return deadlineType;
  }
    
  protected Type declaredTypeType = null;

  public Type getDeclaredType()
  {
    return declaredTypeType;
  }
    
  protected Type descriptionType = null;

  public Type getDescription()
  {
    return descriptionType;
  }
    
  protected Type documentationType = null;

  public Type getDocumentation()
  {
    return documentationType;
  }
      
  protected Type durationType = null;

  public Type getDuration()
  {
    return durationType;
  }
    
  protected Type ejbType = null;

  public Type getEjb()
  {
    return ejbType;
  }
    
  protected Type endEventType = null;

  public Type getEndEvent()
  {
    return endEventType;
  }
    
  protected Type endPointType = null;

  public Type getEndPoint()
  {
    return endPointType;
  }
    
  protected Type enumerationTypeType = null;

  public Type getEnumerationType()
  {
    return enumerationTypeType;
  }
    
  protected Type enumerationValueType = null;

  public Type getEnumerationValue()
  {
    return enumerationValueType;
  }
    
  protected Type eventType = null;

  public Type getEvent()
  {
    return eventType;
  }
    
  protected Type exceptionNameType = null;

  public Type getExceptionName()
  {
    return exceptionNameType;
  }
    
  protected Type expressionTypeType = null;

  public Type getExpressionType()
  {
    return expressionTypeType;
  }
    
  protected Type extendedAttributeType = null;

  public Type getExtendedAttribute()
  {
    return extendedAttributeType;
  }
    
  protected Type extendedAttributesType = null;

  public Type getExtendedAttributes()
  {
    return extendedAttributesType;
  }
    
  protected Type externalPackageType = null;

  public Type getExternalPackage()
  {
    return externalPackageType;
  }
    
  protected Type externalPackagesType = null;

  public Type getExternalPackages()
  {
    return externalPackagesType;
  }
    
  protected Type externalReferenceType = null;

  public Type getExternalReference()
  {
    return externalReferenceType;
  }
    
  protected Type formType = null;

  public Type getForm()
  {
    return formType;
  }
    
  protected Type formalParameterType = null;

  public Type getFormalParameter()
  {
    return formalParameterType;
  }
    
  protected Type formalParametersType = null;

  public Type getFormalParameters()
  {
    return formalParametersType;
  }
    
  protected Type formLayoutType = null;

  public Type getFormLayout()
  {
    return formLayoutType;
  }
    
  protected Type homeClassType = null;

  public Type getHomeClass()
  {
    return homeClassType;
  }
    
  protected Type iconType = null;

  public Type getIcon()
  {
    return iconType;
  }
    
  protected Type implementation7Type = null;

  public Type getImplementation7()
  {
    return implementation7Type;
  }
    
  protected Type inputType = null;

  public Type getInput()
  {
    return inputType;
  }
    
  protected Type inputSetType = null;

  public Type getInputSet()
  {
    return inputSetType;
  }
    
  protected Type inputSetsType = null;

  public Type getInputSets()
  {
    return inputSetsType;
  }
    
  protected Type intermediateEventType = null;

  public Type getIntermediateEvent()
  {
    return intermediateEventType;
  }
    
  protected Type ioRulesType = null;

  public Type getIORules()
  {
    return ioRulesType;
  }
    
  protected Type jndiNameType = null;

  public Type getJndiName()
  {
    return jndiNameType;
  }
    
  protected Type joinType = null;

  public Type getJoin()
  {
    return joinType;
  }
    
  protected Type laneType = null;

  public Type getLane()
  {
    return laneType;
  }
    
  protected Type lanesType = null;

  public Type getLanes()
  {
    return lanesType;
  }
    
  protected Type lengthType = null;

  public Type getLength()
  {
    return lengthType;
  }
    
  protected Type limitType = null;

  public Type getLimit()
  {
    return limitType;
  }
    
  protected Type listTypeType = null;

  public Type getListType()
  {
    return listTypeType;
  }
    
  protected Type locationType = null;

  public Type getLocation()
  {
    return locationType;
  }
    
  protected Type loopType = null;

  public Type getLoop()
  {
    return loopType;
  }
    
  protected Type loopMultiInstanceType = null;

  public Type getLoopMultiInstance()
  {
    return loopMultiInstanceType;
  }
    
  protected Type loopStandardType = null;

  public Type getLoopStandard()
  {
    return loopStandardType;
  }
    
  protected Type memberType = null;

  public Type getMember()
  {
    return memberType;
  }
    
  protected Type messageFlowType = null;

  public Type getMessageFlow()
  {
    return messageFlowType;
  }
    
  protected Type messageFlowsType = null;

  public Type getMessageFlows()
  {
    return messageFlowsType;
  }
    
  protected Type messageTypeType = null;

  public Type getMessageType()
  {
    return messageTypeType;
  }
    
  protected Type methodType = null;

  public Type getMethod()
  {
    return methodType;
  }
    
  protected Type method1Type = null;

  public Type getMethod1()
  {
    return method1Type;
  }
    
  protected Type myRoleType = null;

  public Type getMyRole()
  {
    return myRoleType;
  }
    
  protected Type noType = null;

  public Type getNo()
  {
    return noType;
  }
    
  protected Type nodeGraphicsInfoType = null;

  public Type getNodeGraphicsInfo()
  {
    return nodeGraphicsInfoType;
  }
    
  protected Type nodeGraphicsInfosType = null;

  public Type getNodeGraphicsInfos()
  {
    return nodeGraphicsInfosType;
  }
    
  protected Type objectType = null;

  public Type getObject()
  {
    return objectType;
  }
    
  protected Type outputType = null;

  public Type getOutput()
  {
    return outputType;
  }
    
  protected Type outputSetType = null;

  public Type getOutputSet()
  {
    return outputSetType;
  }
    
  protected Type outputSetsType = null;

  public Type getOutputSets()
  {
    return outputSetsType;
  }
    
  protected Type packageHeaderType = null;

  public Type getPackageHeader()
  {
    return packageHeaderType;
  }
    
  protected Type packageTypeType = null;

  public Type getPackageType()
  {
    return packageTypeType;
  }
    
  protected Type participantType = null;

  public Type getParticipant()
  {
    return participantType;
  }
    
  protected Type participantsType = null;

  public Type getParticipants()
  {
    return participantsType;
  }
    
  protected Type participantTypeType = null;

  public Type getParticipantType()
  {
    return participantTypeType;
  }
    
  protected Type partnerType = null;

  public Type getPartner()
  {
    return partnerType;
  }
    
  protected Type partnerLinkType = null;

  public Type getPartnerLink()
  {
    return partnerLinkType;
  }
    
  protected Type partnerLinksType = null;

  public Type getPartnerLinks()
  {
    return partnerLinksType;
  }
    
  protected Type partnerLinkTypeType = null;

  public Type getPartnerLinkType()
  {
    return partnerLinkTypeType;
  }
    
  protected Type partnerLinkTypesType = null;

  public Type getPartnerLinkTypes()
  {
    return partnerLinkTypesType;
  }
    
  protected Type partnerRoleType = null;

  public Type getPartnerRole()
  {
    return partnerRoleType;
  }
    
  protected Type performerType = null;

  public Type getPerformer()
  {
    return performerType;
  }
    
  protected Type performersType = null;

  public Type getPerformers()
  {
    return performersType;
  }
    
  protected Type pojoType = null;

  public Type getPojo()
  {
    return pojoType;
  }
    
  protected Type poolType = null;

  public Type getPool()
  {
    return poolType;
  }
    
  protected Type poolsType = null;

  public Type getPools()
  {
    return poolsType;
  }
    
  protected Type precisionType = null;

  public Type getPrecision()
  {
    return precisionType;
  }
    
  protected Type priorityType = null;

  public Type getPriority()
  {
    return priorityType;
  }
    
  protected Type priorityUnitType = null;

  public Type getPriorityUnit()
  {
    return priorityUnitType;
  }
    
  protected Type processHeaderType = null;

  public Type getProcessHeader()
  {
    return processHeaderType;
  }
    
  protected Type processType1Type = null;

  public Type getProcessType1()
  {
    return processType1Type;
  }
    
  protected Type recordTypeType = null;

  public Type getRecordType()
  {
    return recordTypeType;
  }
    
  protected Type redefinableHeaderType = null;

  public Type getRedefinableHeader()
  {
    return redefinableHeaderType;
  }
    
  protected Type referenceType = null;

  public Type getReference()
  {
    return referenceType;
  }
    
  protected Type responsibleType = null;

  public Type getResponsible()
  {
    return responsibleType;
  }
    
  protected Type responsiblesType = null;

  public Type getResponsibles()
  {
    return responsiblesType;
  }
    
  protected Type resultCompensationType = null;

  public Type getResultCompensation()
  {
    return resultCompensationType;
  }
    
  protected Type resultErrorType = null;

  public Type getResultError()
  {
    return resultErrorType;
  }
    
  protected Type resultMultipleType = null;

  public Type getResultMultiple()
  {
    return resultMultipleType;
  }
    
  protected Type roleType = null;

  public Type getRole()
  {
    return roleType;
  }
    
  protected Type routeType = null;

  public Type getRoute()
  {
    return routeType;
  }
    
  protected Type ruleType = null;

  public Type getRule()
  {
    return ruleType;
  }
    
  protected Type ruleNameType = null;

  public Type getRuleName()
  {
    return ruleNameType;
  }
    
  protected Type scaleType = null;

  public Type getScale()
  {
    return scaleType;
  }
    
  protected Type schemaTypeType = null;

  public Type getSchemaType()
  {
    return schemaTypeType;
  }
    
  protected Type scriptType = null;

  public Type getScript()
  {
    return scriptType;
  }
    
  protected Type script1Type = null;

  public Type getScript1()
  {
    return script1Type;
  }
    
  protected Type serviceType = null;

  public Type getService()
  {
    return serviceType;
  }
    
  protected Type simulationInformationType = null;

  public Type getSimulationInformation()
  {
    return simulationInformationType;
  }
    
  protected Type splitType = null;

  public Type getSplit()
  {
    return splitType;
  }
    
  protected Type startEventType = null;

  public Type getStartEvent()
  {
    return startEventType;
  }
    
  protected Type subFlowType = null;

  public Type getSubFlow()
  {
    return subFlowType;
  }
    
  protected Type taskType = null;

  public Type getTask()
  {
    return taskType;
  }
    
  protected Type taskApplicationType = null;

  public Type getTaskApplication()
  {
    return taskApplicationType;
  }
    
  protected Type taskManualType = null;

  public Type getTaskManual()
  {
    return taskManualType;
  }
    
  protected Type taskReceiveType = null;

  public Type getTaskReceive()
  {
    return taskReceiveType;
  }
    
  protected Type taskReferenceType = null;

  public Type getTaskReference()
  {
    return taskReferenceType;
  }
    
  protected Type taskScriptType = null;

  public Type getTaskScript()
  {
    return taskScriptType;
  }
    
  protected Type taskSendType = null;

  public Type getTaskSend()
  {
    return taskSendType;
  }
    
  protected Type taskServiceType = null;

  public Type getTaskService()
  {
    return taskServiceType;
  }
    
  protected Type taskUserType = null;

  public Type getTaskUser()
  {
    return taskUserType;
  }
    
  protected Type timeEstimationType = null;

  public Type getTimeEstimation()
  {
    return timeEstimationType;
  }
    
  protected Type transactionType = null;

  public Type getTransaction()
  {
    return transactionType;
  }
    
  protected Type transitionType = null;

  public Type getTransition()
  {
    return transitionType;
  }
    
  protected Type transitionRefType = null;

  public Type getTransitionRef()
  {
    return transitionRefType;
  }
    
  protected Type transitionRefsType = null;

  public Type getTransitionRefs()
  {
    return transitionRefsType;
  }
    
  protected Type transitionRestrictionType = null;

  public Type getTransitionRestriction()
  {
    return transitionRestrictionType;
  }
    
  protected Type transitionRestrictionsType = null;

  public Type getTransitionRestrictions()
  {
    return transitionRestrictionsType;
  }
    
  protected Type transitionsType = null;

  public Type getTransitions()
  {
    return transitionsType;
  }
    
  protected Type triggerIntermediateMultipleType = null;

  public Type getTriggerIntermediateMultiple()
  {
    return triggerIntermediateMultipleType;
  }
    
  protected Type triggerMultipleType = null;

  public Type getTriggerMultiple()
  {
    return triggerMultipleType;
  }
    
  protected Type triggerResultLinkType = null;

  public Type getTriggerResultLink()
  {
    return triggerResultLinkType;
  }
    
  protected Type triggerResultMessageType = null;

  public Type getTriggerResultMessage()
  {
    return triggerResultMessageType;
  }
    
  protected Type triggerRuleType = null;

  public Type getTriggerRule()
  {
    return triggerRuleType;
  }
    
  protected Type triggerTimerType = null;

  public Type getTriggerTimer()
  {
    return triggerTimerType;
  }
    
  protected Type typeDeclarationType = null;

  public Type getTypeDeclaration()
  {
    return typeDeclarationType;
  }
    
  protected Type typeDeclarationsType = null;

  public Type getTypeDeclarations()
  {
    return typeDeclarationsType;
  }
    
  protected Type unionTypeType = null;

  public Type getUnionType()
  {
    return unionTypeType;
  }
    
  protected Type validFromType = null;

  public Type getValidFrom()
  {
    return validFromType;
  }
    
  protected Type validToType = null;

  public Type getValidTo()
  {
    return validToType;
  }
    
  protected Type vendorType = null;

  public Type getVendor()
  {
    return vendorType;
  }
    
  protected Type vendorExtensionType = null;

  public Type getVendorExtension()
  {
    return vendorExtensionType;
  }
    
  protected Type vendorExtensionsType = null;

  public Type getVendorExtensions()
  {
    return vendorExtensionsType;
  }
    
  protected Type versionType = null;

  public Type getVersion()
  {
    return versionType;
  }
    
  protected Type waitingTimeType = null;

  public Type getWaitingTime()
  {
    return waitingTimeType;
  }
    
  protected Type webServiceType = null;

  public Type getWebService()
  {
    return webServiceType;
  }
    
  protected Type webServiceFaultCatchType = null;

  public Type getWebServiceFaultCatch()
  {
    return webServiceFaultCatchType;
  }
    
  protected Type webServiceOperationType = null;

  public Type getWebServiceOperation()
  {
    return webServiceOperationType;
  }
    
  protected Type workflowProcessesType = null;

  public Type getWorkflowProcesses()
  {
    return workflowProcessesType;
  }
    
  protected Type workingTimeType = null;

  public Type getWorkingTime()
  {
    return workingTimeType;
  }
    
  protected Type xpdlVersionType = null;

  public Type getXPDLVersion()
  {
    return xpdlVersionType;
  }
    
  protected Type xsltType = null;

  public Type getXslt()
  {
    return xsltType;
  }
    
  protected Type accessLevelType = null;

  public Type getAccessLevel()
  {
    return accessLevelType;
  }
    
  protected Type adHocOrderingType = null;

  public Type getAdHocOrdering()
  {
    return adHocOrderingType;
  }
    
  protected Type adHocOrdering1Type = null;

  public Type getAdHocOrdering1()
  {
    return adHocOrdering1Type;
  }
    
  protected Type artifactTypeType = null;

  public Type getArtifactType()
  {
    return artifactTypeType;
  }
    
  protected Type assignTimeType = null;

  public Type getAssignTime()
  {
    return assignTimeType;
  }
    
  protected Type associationDirectionType = null;

  public Type getAssociationDirection()
  {
    return associationDirectionType;
  }
    
  protected Type directionType = null;

  public Type getDirection()
  {
    return directionType;
  }
    
  protected Type durationUnitType = null;

  public Type getDurationUnit()
  {
    return durationUnitType;
  }
    
  protected Type endPointTypeType = null;

  public Type getEndPointType()
  {
    return endPointTypeType;
  }
    
  protected Type executionType = null;

  public Type getExecution()
  {
    return executionType;
  }
    
  protected Type execution1Type = null;

  public Type getExecution1()
  {
    return execution1Type;
  }
    
  protected Type finishModeType = null;

  public Type getFinishMode()
  {
    return finishModeType;
  }
    
  protected Type gatewayTypeType = null;

  public Type getGatewayType()
  {
    return gatewayTypeType;
  }
    
  protected Type graphConformanceType = null;

  public Type getGraphConformance()
  {
    return graphConformanceType;
  }
    
  protected Type implementationType = null;

  public Type getImplementation()
  {
    return implementationType;
  }
    
  protected Type implementation1Type = null;

  public Type getImplementation1()
  {
    return implementation1Type;
  }
    
  protected Type implementation2Type = null;

  public Type getImplementation2()
  {
    return implementation2Type;
  }
    
  protected Type implementation3Type = null;

  public Type getImplementation3()
  {
    return implementation3Type;
  }
    
  protected Type implementation4Type = null;

  public Type getImplementation4()
  {
    return implementation4Type;
  }
    
  protected Type implementation5Type = null;

  public Type getImplementation5()
  {
    return implementation5Type;
  }
    
  protected Type implementation6Type = null;

  public Type getImplementation6()
  {
    return implementation6Type;
  }
    
  protected Type instantiationType = null;

  public Type getInstantiation()
  {
    return instantiationType;
  }
    
  protected Type isArrayType = null;

  public Type getIsArray()
  {
    return isArrayType;
  }
    
  protected Type loopTypeType = null;

  public Type getLoopType()
  {
    return loopTypeType;
  }
    
  protected Type mI_FlowConditionType = null;

  public Type getMI_FlowCondition()
  {
    return mI_FlowConditionType;
  }
    
  protected Type mI_OrderingType = null;

  public Type getMI_Ordering()
  {
    return mI_OrderingType;
  }
    
  protected Type modeType = null;

  public Type getMode()
  {
    return modeType;
  }
    
  protected Type orientationType = null;

  public Type getOrientation()
  {
    return orientationType;
  }
    
  protected Type processTypeType = null;

  public Type getProcessType()
  {
    return processTypeType;
  }
    
  protected Type publicationStatusType = null;

  public Type getPublicationStatus()
  {
    return publicationStatusType;
  }
    
  protected Type resultType = null;

  public Type getResult()
  {
    return resultType;
  }
    
  protected Type roleTypeType = null;

  public Type getRoleType()
  {
    return roleTypeType;
  }
    
  protected Type shapeType = null;

  public Type getSHAPE()
  {
    return shapeType;
  }
    
  protected Type startModeType = null;

  public Type getStartMode()
  {
    return startModeType;
  }
    
  protected Type statusType = null;

  public Type getStatus()
  {
    return statusType;
  }
    
  protected Type status1Type = null;

  public Type getStatus1()
  {
    return status1Type;
  }
    
  protected Type testTimeType = null;

  public Type getTestTime()
  {
    return testTimeType;
  }
    
  protected Type transactionMethodType = null;

  public Type getTransactionMethod()
  {
    return transactionMethodType;
  }
    
  protected Type triggerType = null;

  public Type getTrigger()
  {
    return triggerType;
  }
    
  protected Type trigger1Type = null;

  public Type getTrigger1()
  {
    return trigger1Type;
  }
    
  protected Type typeType = null;

  public Type getType()
  {
    return typeType;
  }
    
  protected Type type1Type = null;

  public Type getType1()
  {
    return type1Type;
  }
    
  protected Type type2Type = null;

  public Type getType2()
  {
    return type2Type;
  }
    
  protected Type type3Type = null;

  public Type getType3()
  {
    return type3Type;
  }
    
  protected Type type4Type = null;

  public Type getType4()
  {
    return type4Type;
  }
  

  private static Xpdl2FactoryImpl instance = null; 
  public static Xpdl2FactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new Xpdl2FactoryImpl();

    // Initialize dependent packages
    Xpdl1Factory Xpdl1FactoryInstance = Xpdl1Factory.INSTANCE;
    ModelFactory ModelFactoryInstance = ModelFactory.INSTANCE;
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theXpdl2FactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
    activitiesType = createType(false, ACTIVITIES);
    createProperty(false, activitiesType,ActivitiesImpl.INTERNAL_ACTIVITY); 
    createProperty(true, activitiesType,ActivitiesImpl.INTERNAL_ANY); 
    createProperty(true, activitiesType,ActivitiesImpl.INTERNAL_ANY_ATTRIBUTE); 
    activityType = createType(false, ACTIVITY);
    createProperty(false, activityType,ActivityImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_LIMIT); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_ROUTE); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_BLOCK_ACTIVITY); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_BLOCK_ACTIVITY1); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_EVENT); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_TRANSACTION); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_PERFORMER); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_PERFORMERS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_START_MODE); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_FINISH_MODE); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_PRIORITY); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_DEADLINE); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_DEADLINE1); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_SIMULATION_INFORMATION); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_ICON); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_DOCUMENTATION); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_TRANSITION_RESTRICTIONS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_DATA_FIELDS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_INPUT_SETS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_OUTPUT_SETS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_IO_RULES); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_LOOP); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_ASSIGNMENTS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_OBJECT); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_NODE_GRAPHICS_INFOS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_EXTENSIONS); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_ANY); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_ID); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_NAME); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_START_ACTIVITY); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_STATUS); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_START_MODE1); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_FINISH_MODE1); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_START_QUANTITY); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_IS_ATRANSACTION); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_ANY_ATTRIBUTE); 
    activitySetType = createType(false, ACTIVITY_SET);
    createProperty(false, activitySetType,ActivitySetImpl.INTERNAL_ACTIVITIES); 
    createProperty(false, activitySetType,ActivitySetImpl.INTERNAL_TRANSITIONS); 
    createProperty(false, activitySetType,ActivitySetImpl.INTERNAL_OBJECT); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_ANY); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_ID); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_NAME); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_AD_HOC); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_AD_HOC_ORDERING); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_AD_HOC_COMPLETION_CONDITION); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_DEFAULT_START_ACTIVITY_ID); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_ANY_ATTRIBUTE); 
    activitySetsType = createType(false, ACTIVITY_SETS);
    createProperty(false, activitySetsType,ActivitySetsImpl.INTERNAL_ACTIVITY_SET); 
    createProperty(true, activitySetsType,ActivitySetsImpl.INTERNAL_ANY); 
    createProperty(true, activitySetsType,ActivitySetsImpl.INTERNAL_ANY_ATTRIBUTE); 
    actualParametersType = createType(false, ACTUAL_PARAMETERS);
    createProperty(false, actualParametersType,ActualParametersImpl.INTERNAL_ACTUAL_PARAMETER); 
    createProperty(true, actualParametersType,ActualParametersImpl.INTERNAL_ANY); 
    createProperty(true, actualParametersType,ActualParametersImpl.INTERNAL_ANY_ATTRIBUTE); 
    applicationType = createType(false, APPLICATION);
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_TYPE); 
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_FORMAL_PARAMETERS); 
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, applicationType,ApplicationImpl.INTERNAL_ANY); 
    createProperty(true, applicationType,ApplicationImpl.INTERNAL_ID); 
    createProperty(true, applicationType,ApplicationImpl.INTERNAL_NAME); 
    createProperty(true, applicationType,ApplicationImpl.INTERNAL_ANY_ATTRIBUTE); 
    applicationsType = createType(false, APPLICATIONS);
    createProperty(false, applicationsType,ApplicationsImpl.INTERNAL_APPLICATION); 
    createProperty(true, applicationsType,ApplicationsImpl.INTERNAL_ANY); 
    createProperty(true, applicationsType,ApplicationsImpl.INTERNAL_ANY_ATTRIBUTE); 
    applicationTypeType = createType(false, APPLICATION_TYPE);
    createProperty(false, applicationTypeType,ApplicationTypeImpl.INTERNAL_EJB); 
    createProperty(false, applicationTypeType,ApplicationTypeImpl.INTERNAL_POJO); 
    createProperty(false, applicationTypeType,ApplicationTypeImpl.INTERNAL_XSLT); 
    createProperty(false, applicationTypeType,ApplicationTypeImpl.INTERNAL_SCRIPT); 
    createProperty(false, applicationTypeType,ApplicationTypeImpl.INTERNAL_WEB_SERVICE); 
    createProperty(false, applicationTypeType,ApplicationTypeImpl.INTERNAL_BUSINESS_RULE); 
    createProperty(false, applicationTypeType,ApplicationTypeImpl.INTERNAL_FORM); 
    createProperty(true, applicationTypeType,ApplicationTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    arrayTypeType = createType(false, ARRAY_TYPE);
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_BASIC_TYPE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_DECLARED_TYPE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_SCHEMA_TYPE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_RECORD_TYPE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_UNION_TYPE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_ENUMERATION_TYPE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_ARRAY_TYPE); 
    createProperty(false, arrayTypeType,ArrayTypeImpl.INTERNAL_LIST_TYPE); 
    createProperty(true, arrayTypeType,ArrayTypeImpl.INTERNAL_LOWER_INDEX); 
    createProperty(true, arrayTypeType,ArrayTypeImpl.INTERNAL_UPPER_INDEX); 
    createProperty(true, arrayTypeType,ArrayTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    artifactType = createType(false, ARTIFACT);
    createProperty(false, artifactType,ArtifactImpl.INTERNAL_OBJECT); 
    createProperty(false, artifactType,ArtifactImpl.INTERNAL_DATA_OBJECT); 
    createProperty(false, artifactType,ArtifactImpl.INTERNAL_NODE_GRAPHICS_INFOS); 
    createProperty(true, artifactType,ArtifactImpl.INTERNAL_ANY); 
    createProperty(true, artifactType,ArtifactImpl.INTERNAL_ID); 
    createProperty(true, artifactType,ArtifactImpl.INTERNAL_NAME); 
    createProperty(true, artifactType,ArtifactImpl.INTERNAL_ARTIFACT_TYPE); 
    createProperty(true, artifactType,ArtifactImpl.INTERNAL_TEXT_ANNOTATION); 
    createProperty(true, artifactType,ArtifactImpl.INTERNAL_GROUP); 
    createProperty(true, artifactType,ArtifactImpl.INTERNAL_ANY_ATTRIBUTE); 
    artifactsType = createType(false, ARTIFACTS);
    createProperty(true, artifactsType,ArtifactsImpl.INTERNAL_GROUP); 
    createProperty(false, artifactsType,ArtifactsImpl.INTERNAL_ARTIFACT); 
    createProperty(true, artifactsType,ArtifactsImpl.INTERNAL_ANY); 
    createProperty(true, artifactsType,ArtifactsImpl.INTERNAL_ANY_ATTRIBUTE); 
    assignmentType = createType(false, ASSIGNMENT);
    createProperty(false, assignmentType,AssignmentImpl.INTERNAL_TARGET); 
    createProperty(false, assignmentType,AssignmentImpl.INTERNAL_EXPRESSION); 
    createProperty(true, assignmentType,AssignmentImpl.INTERNAL_ANY); 
    createProperty(true, assignmentType,AssignmentImpl.INTERNAL_ASSIGN_TIME); 
    createProperty(true, assignmentType,AssignmentImpl.INTERNAL_ANY_ATTRIBUTE); 
    assignmentsType = createType(false, ASSIGNMENTS);
    createProperty(false, assignmentsType,AssignmentsImpl.INTERNAL_ASSIGNMENT); 
    createProperty(true, assignmentsType,AssignmentsImpl.INTERNAL_ANY); 
    createProperty(true, assignmentsType,AssignmentsImpl.INTERNAL_ANY_ATTRIBUTE); 
    associationType = createType(false, ASSOCIATION);
    createProperty(false, associationType,AssociationImpl.INTERNAL_OBJECT); 
    createProperty(false, associationType,AssociationImpl.INTERNAL_CONNECTOR_GRAPHICS_INFOS); 
    createProperty(true, associationType,AssociationImpl.INTERNAL_ANY); 
    createProperty(true, associationType,AssociationImpl.INTERNAL_ID); 
    createProperty(true, associationType,AssociationImpl.INTERNAL_SOURCE); 
    createProperty(true, associationType,AssociationImpl.INTERNAL_TARGET); 
    createProperty(true, associationType,AssociationImpl.INTERNAL_NAME); 
    createProperty(true, associationType,AssociationImpl.INTERNAL_ASSOCIATION_DIRECTION); 
    createProperty(true, associationType,AssociationImpl.INTERNAL_ANY_ATTRIBUTE); 
    associationsType = createType(false, ASSOCIATIONS);
    createProperty(true, associationsType,AssociationsImpl.INTERNAL_GROUP); 
    createProperty(false, associationsType,AssociationsImpl.INTERNAL_ASSOCIATION); 
    createProperty(true, associationsType,AssociationsImpl.INTERNAL_ANY); 
    createProperty(true, associationsType,AssociationsImpl.INTERNAL_ANY_ATTRIBUTE); 
    authorType = createType(false, AUTHOR);
    createProperty(true, authorType,AuthorImpl.INTERNAL_VALUE); 
    createProperty(true, authorType,AuthorImpl.INTERNAL_ANY_ATTRIBUTE); 
    basicTypeType = createType(false, BASIC_TYPE);
    createProperty(false, basicTypeType,BasicTypeImpl.INTERNAL_LENGTH); 
    createProperty(false, basicTypeType,BasicTypeImpl.INTERNAL_PRECISION); 
    createProperty(false, basicTypeType,BasicTypeImpl.INTERNAL_SCALE); 
    createProperty(true, basicTypeType,BasicTypeImpl.INTERNAL_ANY); 
    createProperty(true, basicTypeType,BasicTypeImpl.INTERNAL_TYPE); 
    createProperty(true, basicTypeType,BasicTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    blockActivityType = createType(false, BLOCK_ACTIVITY);
    createProperty(true, blockActivityType,BlockActivityImpl.INTERNAL_ANY); 
    createProperty(true, blockActivityType,BlockActivityImpl.INTERNAL_ACTIVITY_SET_ID); 
    createProperty(true, blockActivityType,BlockActivityImpl.INTERNAL_START_ACTIVITY_ID); 
    createProperty(true, blockActivityType,BlockActivityImpl.INTERNAL_ANY_ATTRIBUTE); 
    businessRuleType = createType(false, BUSINESS_RULE);
    createProperty(false, businessRuleType,BusinessRuleImpl.INTERNAL_RULE_NAME); 
    createProperty(false, businessRuleType,BusinessRuleImpl.INTERNAL_LOCATION); 
    createProperty(true, businessRuleType,BusinessRuleImpl.INTERNAL_ANY); 
    createProperty(true, businessRuleType,BusinessRuleImpl.INTERNAL_ANY_ATTRIBUTE); 
    categoriesType = createType(false, CATEGORIES);
    createProperty(false, categoriesType,CategoriesImpl.INTERNAL_CATEGORY); 
    createProperty(true, categoriesType,CategoriesImpl.INTERNAL_ANY); 
    createProperty(true, categoriesType,CategoriesImpl.INTERNAL_ANY_ATTRIBUTE); 
    categoryType = createType(false, CATEGORY);
    createProperty(true, categoryType,CategoryImpl.INTERNAL_ANY); 
    createProperty(true, categoryType,CategoryImpl.INTERNAL_ID); 
    createProperty(true, categoryType,CategoryImpl.INTERNAL_NAME); 
    createProperty(true, categoryType,CategoryImpl.INTERNAL_ANY_ATTRIBUTE); 
    class_Type = createType(false, CLASS);
    createProperty(true, class_Type,ClassImpl.INTERNAL_VALUE); 
    createProperty(true, class_Type,ClassImpl.INTERNAL_ANY_ATTRIBUTE); 
    codepageType = createType(false, CODEPAGE);
    createProperty(true, codepageType,CodepageImpl.INTERNAL_VALUE); 
    createProperty(true, codepageType,CodepageImpl.INTERNAL_ANY_ATTRIBUTE); 
    conditionType = createType(false, CONDITION);
    createProperty(true, conditionType,ConditionImpl.INTERNAL_MIXED); 
    createProperty(false, conditionType,ConditionImpl.INTERNAL_XPRESSION); 
    createProperty(false, conditionType,ConditionImpl.INTERNAL_EXPRESSION); 
    createProperty(true, conditionType,ConditionImpl.INTERNAL_TYPE); 
    createProperty(true, conditionType,ConditionImpl.INTERNAL_ANY_ATTRIBUTE); 
    conformanceClassType = createType(false, CONFORMANCE_CLASS);
    createProperty(true, conformanceClassType,ConformanceClassImpl.INTERNAL_ANY); 
    createProperty(true, conformanceClassType,ConformanceClassImpl.INTERNAL_GRAPH_CONFORMANCE); 
    createProperty(true, conformanceClassType,ConformanceClassImpl.INTERNAL_ANY_ATTRIBUTE); 
    connectorGraphicsInfoType = createType(false, CONNECTOR_GRAPHICS_INFO);
    createProperty(false, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_COORDINATES); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_ANY); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_TOOL_ID); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_IS_VISIBLE); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_PAGE); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_STYLE); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_BORDER_COLOR); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_FILL_COLOR); 
    createProperty(true, connectorGraphicsInfoType,ConnectorGraphicsInfoImpl.INTERNAL_ANY_ATTRIBUTE); 
    connectorGraphicsInfosType = createType(false, CONNECTOR_GRAPHICS_INFOS);
    createProperty(false, connectorGraphicsInfosType,ConnectorGraphicsInfosImpl.INTERNAL_CONNECTOR_GRAPHICS_INFO); 
    createProperty(true, connectorGraphicsInfosType,ConnectorGraphicsInfosImpl.INTERNAL_ANY); 
    createProperty(true, connectorGraphicsInfosType,ConnectorGraphicsInfosImpl.INTERNAL_ANY_ATTRIBUTE); 
    coordinatesType = createType(false, COORDINATES);
    createProperty(true, coordinatesType,CoordinatesImpl.INTERNAL_ANY); 
    createProperty(true, coordinatesType,CoordinatesImpl.INTERNAL_XCOORDINATE); 
    createProperty(true, coordinatesType,CoordinatesImpl.INTERNAL_YCOORDINATE); 
    createProperty(true, coordinatesType,CoordinatesImpl.INTERNAL_ANY_ATTRIBUTE); 
    costType = createType(false, COST);
    createProperty(true, costType,CostImpl.INTERNAL_VALUE); 
    createProperty(true, costType,CostImpl.INTERNAL_ANY_ATTRIBUTE); 
    costUnitType = createType(false, COST_UNIT);
    createProperty(true, costUnitType,CostUnitImpl.INTERNAL_VALUE); 
    createProperty(true, costUnitType,CostUnitImpl.INTERNAL_ANY_ATTRIBUTE); 
    countrykeyType = createType(false, COUNTRYKEY);
    createProperty(true, countrykeyType,CountrykeyImpl.INTERNAL_VALUE); 
    createProperty(true, countrykeyType,CountrykeyImpl.INTERNAL_ANY_ATTRIBUTE); 
    createdType = createType(false, CREATED);
    createProperty(true, createdType,CreatedImpl.INTERNAL_VALUE); 
    createProperty(true, createdType,CreatedImpl.INTERNAL_ANY_ATTRIBUTE); 
    dataFieldType = createType(false, DATA_FIELD);
    createProperty(false, dataFieldType,DataFieldImpl.INTERNAL_DATA_TYPE); 
    createProperty(false, dataFieldType,DataFieldImpl.INTERNAL_INITIAL_VALUE); 
    createProperty(false, dataFieldType,DataFieldImpl.INTERNAL_LENGTH); 
    createProperty(false, dataFieldType,DataFieldImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, dataFieldType,DataFieldImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_ANY); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_ID); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_NAME); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_IS_ARRAY); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_CORRELATION); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_ANY_ATTRIBUTE); 
    dataFieldsType = createType(false, DATA_FIELDS);
    createProperty(false, dataFieldsType,DataFieldsImpl.INTERNAL_DATA_FIELD); 
    createProperty(true, dataFieldsType,DataFieldsImpl.INTERNAL_ANY); 
    createProperty(true, dataFieldsType,DataFieldsImpl.INTERNAL_ANY_ATTRIBUTE); 
    dataMappingType = createType(false, DATA_MAPPING);
    createProperty(false, dataMappingType,DataMappingImpl.INTERNAL_ACTUAL); 
    createProperty(true, dataMappingType,DataMappingImpl.INTERNAL_ANY); 
    createProperty(true, dataMappingType,DataMappingImpl.INTERNAL_FORMAL); 
    createProperty(true, dataMappingType,DataMappingImpl.INTERNAL_DIRECTION); 
    createProperty(true, dataMappingType,DataMappingImpl.INTERNAL_ANY_ATTRIBUTE); 
    dataMappingsType = createType(false, DATA_MAPPINGS);
    createProperty(false, dataMappingsType,DataMappingsImpl.INTERNAL_DATA_MAPPING); 
    createProperty(true, dataMappingsType,DataMappingsImpl.INTERNAL_ANY); 
    createProperty(true, dataMappingsType,DataMappingsImpl.INTERNAL_ANY_ATTRIBUTE); 
    dataObjectType = createType(false, DATA_OBJECT);
    createProperty(false, dataObjectType,DataObjectImpl.INTERNAL_DATA_FIELDS); 
    createProperty(true, dataObjectType,DataObjectImpl.INTERNAL_ANY); 
    createProperty(true, dataObjectType,DataObjectImpl.INTERNAL_ID); 
    createProperty(true, dataObjectType,DataObjectImpl.INTERNAL_NAME); 
    createProperty(true, dataObjectType,DataObjectImpl.INTERNAL_STATE); 
    createProperty(true, dataObjectType,DataObjectImpl.INTERNAL_REQUIRED_FOR_START); 
    createProperty(true, dataObjectType,DataObjectImpl.INTERNAL_PRODUCED_AT_COMPLETION); 
    createProperty(true, dataObjectType,DataObjectImpl.INTERNAL_ANY_ATTRIBUTE); 
    dataTypeType = createType(false, DATA_TYPE);
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_BASIC_TYPE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_DECLARED_TYPE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_SCHEMA_TYPE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_RECORD_TYPE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_UNION_TYPE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_ENUMERATION_TYPE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_ARRAY_TYPE); 
    createProperty(false, dataTypeType,DataTypeImpl.INTERNAL_LIST_TYPE); 
    createProperty(true, dataTypeType,DataTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    deadlineType = createType(false, DEADLINE);
    createProperty(false, deadlineType,DeadlineImpl.INTERNAL_DEADLINE_DURATION); 
    createProperty(false, deadlineType,DeadlineImpl.INTERNAL_EXCEPTION_NAME); 
    createProperty(true, deadlineType,DeadlineImpl.INTERNAL_ANY); 
    createProperty(true, deadlineType,DeadlineImpl.INTERNAL_EXECUTION); 
    createProperty(true, deadlineType,DeadlineImpl.INTERNAL_ANY_ATTRIBUTE); 
    declaredTypeType = createType(false, DECLARED_TYPE);
    createProperty(true, declaredTypeType,DeclaredTypeImpl.INTERNAL_ANY); 
    createProperty(true, declaredTypeType,DeclaredTypeImpl.INTERNAL_ID); 
    createProperty(true, declaredTypeType,DeclaredTypeImpl.INTERNAL_NAME); 
    createProperty(true, declaredTypeType,DeclaredTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    descriptionType = createType(false, DESCRIPTION);
    createProperty(true, descriptionType,DescriptionImpl.INTERNAL_VALUE); 
    createProperty(true, descriptionType,DescriptionImpl.INTERNAL_ANY_ATTRIBUTE); 
    documentationType = createType(false, DOCUMENTATION);
    createProperty(true, documentationType,DocumentationImpl.INTERNAL_VALUE); 
    createProperty(true, documentationType,DocumentationImpl.INTERNAL_ANY_ATTRIBUTE); 
    durationType = createType(false, DURATION);
    createProperty(true, durationType,DurationImpl.INTERNAL_VALUE); 
    createProperty(true, durationType,DurationImpl.INTERNAL_ANY_ATTRIBUTE); 
    ejbType = createType(false, EJB);
    createProperty(false, ejbType,EjbImpl.INTERNAL_JNDI_NAME); 
    createProperty(false, ejbType,EjbImpl.INTERNAL_HOME_CLASS); 
    createProperty(false, ejbType,EjbImpl.INTERNAL_METHOD); 
    createProperty(true, ejbType,EjbImpl.INTERNAL_ANY); 
    createProperty(true, ejbType,EjbImpl.INTERNAL_ANY_ATTRIBUTE); 
    endEventType = createType(false, END_EVENT);
    createProperty(false, endEventType,EndEventImpl.INTERNAL_TRIGGER_RESULT_MESSAGE); 
    createProperty(false, endEventType,EndEventImpl.INTERNAL_RESULT_ERROR); 
    createProperty(false, endEventType,EndEventImpl.INTERNAL_RESULT_COMPENSATION); 
    createProperty(false, endEventType,EndEventImpl.INTERNAL_TRIGGER_RESULT_LINK); 
    createProperty(false, endEventType,EndEventImpl.INTERNAL_RESULT_MULTIPLE); 
    createProperty(true, endEventType,EndEventImpl.INTERNAL_RESULT); 
    createProperty(true, endEventType,EndEventImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(true, endEventType,EndEventImpl.INTERNAL_ANY_ATTRIBUTE); 
    endPointType = createType(false, END_POINT);
    createProperty(false, endPointType,EndPointImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(true, endPointType,EndPointImpl.INTERNAL_ANY); 
    createProperty(true, endPointType,EndPointImpl.INTERNAL_END_POINT_TYPE); 
    createProperty(true, endPointType,EndPointImpl.INTERNAL_ANY_ATTRIBUTE); 
    enumerationTypeType = createType(false, ENUMERATION_TYPE);
    createProperty(false, enumerationTypeType,EnumerationTypeImpl.INTERNAL_ENUMERATION_VALUE); 
    createProperty(true, enumerationTypeType,EnumerationTypeImpl.INTERNAL_ANY); 
    createProperty(true, enumerationTypeType,EnumerationTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    enumerationValueType = createType(false, ENUMERATION_VALUE);
    createProperty(true, enumerationValueType,EnumerationValueImpl.INTERNAL_ANY); 
    createProperty(true, enumerationValueType,EnumerationValueImpl.INTERNAL_NAME); 
    createProperty(true, enumerationValueType,EnumerationValueImpl.INTERNAL_ANY_ATTRIBUTE); 
    eventType = createType(false, EVENT);
    createProperty(false, eventType,EventImpl.INTERNAL_START_EVENT); 
    createProperty(false, eventType,EventImpl.INTERNAL_INTERMEDIATE_EVENT); 
    createProperty(false, eventType,EventImpl.INTERNAL_END_EVENT); 
    createProperty(true, eventType,EventImpl.INTERNAL_ANY_ATTRIBUTE); 
    exceptionNameType = createType(false, EXCEPTION_NAME);
    createProperty(true, exceptionNameType,ExceptionNameImpl.INTERNAL_VALUE); 
    createProperty(true, exceptionNameType,ExceptionNameImpl.INTERNAL_ANY_ATTRIBUTE); 
    expressionTypeType = createType(false, EXPRESSION_TYPE);
    createProperty(true, expressionTypeType,ExpressionTypeImpl.INTERNAL_MIXED); 
    createProperty(true, expressionTypeType,ExpressionTypeImpl.INTERNAL_GROUP); 
    createProperty(true, expressionTypeType,ExpressionTypeImpl.INTERNAL_ANY); 
    createProperty(true, expressionTypeType,ExpressionTypeImpl.INTERNAL_SCRIPT_GRAMMAR); 
    createProperty(true, expressionTypeType,ExpressionTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    extendedAttributeType = createType(false, EXTENDED_ATTRIBUTE);
    createProperty(true, extendedAttributeType,ExtendedAttributeImpl.INTERNAL_MIXED); 
    createProperty(true, extendedAttributeType,ExtendedAttributeImpl.INTERNAL_GROUP); 
    createProperty(true, extendedAttributeType,ExtendedAttributeImpl.INTERNAL_ANY); 
    createProperty(true, extendedAttributeType,ExtendedAttributeImpl.INTERNAL_NAME); 
    createProperty(true, extendedAttributeType,ExtendedAttributeImpl.INTERNAL_VALUE); 
    extendedAttributesType = createType(false, EXTENDED_ATTRIBUTES);
    createProperty(false, extendedAttributesType,ExtendedAttributesImpl.INTERNAL_EXTENDED_ATTRIBUTE); 
    externalPackageType = createType(false, EXTERNAL_PACKAGE);
    createProperty(false, externalPackageType,ExternalPackageImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, externalPackageType,ExternalPackageImpl.INTERNAL_ANY); 
    createProperty(true, externalPackageType,ExternalPackageImpl.INTERNAL_HREF); 
    createProperty(true, externalPackageType,ExternalPackageImpl.INTERNAL_ID); 
    createProperty(true, externalPackageType,ExternalPackageImpl.INTERNAL_NAME); 
    createProperty(true, externalPackageType,ExternalPackageImpl.INTERNAL_ANY_ATTRIBUTE); 
    externalPackagesType = createType(false, EXTERNAL_PACKAGES);
    createProperty(false, externalPackagesType,ExternalPackagesImpl.INTERNAL_EXTERNAL_PACKAGE); 
    createProperty(true, externalPackagesType,ExternalPackagesImpl.INTERNAL_ANY); 
    createProperty(true, externalPackagesType,ExternalPackagesImpl.INTERNAL_ANY_ATTRIBUTE); 
    externalReferenceType = createType(false, EXTERNAL_REFERENCE);
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_ANY); 
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_XREF); 
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_LOCATION); 
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_NAMESPACE); 
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_ANY_ATTRIBUTE); 
    formType = createType(false, FORM);
    createProperty(false, formType,FormImpl.INTERNAL_FORM_LAYOUT); 
    createProperty(true, formType,FormImpl.INTERNAL_ANY); 
    createProperty(true, formType,FormImpl.INTERNAL_ANY_ATTRIBUTE); 
    formalParameterType = createType(false, FORMAL_PARAMETER);
    createProperty(false, formalParameterType,FormalParameterImpl.INTERNAL_DATA_TYPE); 
    createProperty(false, formalParameterType,FormalParameterImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, formalParameterType,FormalParameterImpl.INTERNAL_LENGTH); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_ANY); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_ID); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_MODE); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_NAME); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_IS_ARRAY); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_ANY_ATTRIBUTE); 
    formalParametersType = createType(false, FORMAL_PARAMETERS);
    createProperty(false, formalParametersType,FormalParametersImpl.INTERNAL_FORMAL_PARAMETER); 
    createProperty(false, formalParametersType,FormalParametersImpl.INTERNAL_FORMAL_PARAMETER1); 
    createProperty(false, formalParametersType,FormalParametersImpl.INTERNAL_EXTENSIONS); 
    createProperty(true, formalParametersType,FormalParametersImpl.INTERNAL_ANY); 
    createProperty(true, formalParametersType,FormalParametersImpl.INTERNAL_ANY_ATTRIBUTE); 
    formLayoutType = createType(false, FORM_LAYOUT);
    createProperty(true, formLayoutType,FormLayoutImpl.INTERNAL_MIXED); 
    homeClassType = createType(false, HOME_CLASS);
    createProperty(true, homeClassType,HomeClassImpl.INTERNAL_VALUE); 
    createProperty(true, homeClassType,HomeClassImpl.INTERNAL_ANY_ATTRIBUTE); 
    iconType = createType(false, ICON);
    createProperty(true, iconType,IconImpl.INTERNAL_VALUE); 
    createProperty(true, iconType,IconImpl.INTERNAL_XCOORD); 
    createProperty(true, iconType,IconImpl.INTERNAL_YCOORD); 
    createProperty(true, iconType,IconImpl.INTERNAL_WIDTH); 
    createProperty(true, iconType,IconImpl.INTERNAL_HEIGHT); 
    createProperty(true, iconType,IconImpl.INTERNAL_SHAPE); 
    createProperty(true, iconType,IconImpl.INTERNAL_ANY_ATTRIBUTE); 
    implementation7Type = createType(false, IMPLEMENTATION7);
    createProperty(false, implementation7Type,Implementation7Impl.INTERNAL_NO); 
    createProperty(false, implementation7Type,Implementation7Impl.INTERNAL_TOOL); 
    createProperty(false, implementation7Type,Implementation7Impl.INTERNAL_TASK); 
    createProperty(false, implementation7Type,Implementation7Impl.INTERNAL_SUB_FLOW); 
    createProperty(false, implementation7Type,Implementation7Impl.INTERNAL_REFERENCE); 
    createProperty(true, implementation7Type,Implementation7Impl.INTERNAL_ANY_ATTRIBUTE); 
    inputType = createType(false, INPUT);
    createProperty(true, inputType,InputImpl.INTERNAL_ANY); 
    createProperty(true, inputType,InputImpl.INTERNAL_ARTIFACT_ID); 
    createProperty(true, inputType,InputImpl.INTERNAL_ANY_ATTRIBUTE); 
    inputSetType = createType(false, INPUT_SET);
    createProperty(false, inputSetType,InputSetImpl.INTERNAL_INPUT); 
    createProperty(true, inputSetType,InputSetImpl.INTERNAL_ANY); 
    createProperty(true, inputSetType,InputSetImpl.INTERNAL_ANY_ATTRIBUTE); 
    inputSetsType = createType(false, INPUT_SETS);
    createProperty(false, inputSetsType,InputSetsImpl.INTERNAL_INPUT_SET); 
    createProperty(true, inputSetsType,InputSetsImpl.INTERNAL_ANY); 
    createProperty(true, inputSetsType,InputSetsImpl.INTERNAL_ANY_ATTRIBUTE); 
    intermediateEventType = createType(false, INTERMEDIATE_EVENT);
    createProperty(false, intermediateEventType,IntermediateEventImpl.INTERNAL_TRIGGER_RESULT_MESSAGE); 
    createProperty(false, intermediateEventType,IntermediateEventImpl.INTERNAL_TRIGGER_TIMER); 
    createProperty(false, intermediateEventType,IntermediateEventImpl.INTERNAL_RESULT_ERROR); 
    createProperty(false, intermediateEventType,IntermediateEventImpl.INTERNAL_RESULT_COMPENSATION); 
    createProperty(false, intermediateEventType,IntermediateEventImpl.INTERNAL_TRIGGER_RULE); 
    createProperty(false, intermediateEventType,IntermediateEventImpl.INTERNAL_TRIGGER_RESULT_LINK); 
    createProperty(false, intermediateEventType,IntermediateEventImpl.INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE); 
    createProperty(true, intermediateEventType,IntermediateEventImpl.INTERNAL_TRIGGER); 
    createProperty(true, intermediateEventType,IntermediateEventImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(true, intermediateEventType,IntermediateEventImpl.INTERNAL_TARGET); 
    createProperty(true, intermediateEventType,IntermediateEventImpl.INTERNAL_ANY_ATTRIBUTE); 
    ioRulesType = createType(false, IO_RULES);
    createProperty(false, ioRulesType,IORulesImpl.INTERNAL_EXPRESSION); 
    createProperty(true, ioRulesType,IORulesImpl.INTERNAL_ANY); 
    createProperty(true, ioRulesType,IORulesImpl.INTERNAL_ANY_ATTRIBUTE); 
    jndiNameType = createType(false, JNDI_NAME);
    createProperty(true, jndiNameType,JndiNameImpl.INTERNAL_VALUE); 
    createProperty(true, jndiNameType,JndiNameImpl.INTERNAL_ANY_ATTRIBUTE); 
    joinType = createType(false, JOIN);
    createProperty(true, joinType,JoinImpl.INTERNAL_ANY); 
    createProperty(true, joinType,JoinImpl.INTERNAL_TYPE); 
    createProperty(true, joinType,JoinImpl.INTERNAL_INCOMING_CONDTION); 
    createProperty(true, joinType,JoinImpl.INTERNAL_ANY_ATTRIBUTE); 
    laneType = createType(false, LANE);
    createProperty(false, laneType,LaneImpl.INTERNAL_OBJECT); 
    createProperty(false, laneType,LaneImpl.INTERNAL_NODE_GRAPHICS_INFOS); 
    createProperty(true, laneType,LaneImpl.INTERNAL_ANY); 
    createProperty(true, laneType,LaneImpl.INTERNAL_ID); 
    createProperty(true, laneType,LaneImpl.INTERNAL_NAME); 
    createProperty(true, laneType,LaneImpl.INTERNAL_PARENT_LANE); 
    createProperty(true, laneType,LaneImpl.INTERNAL_PARENT_POOL); 
    createProperty(true, laneType,LaneImpl.INTERNAL_ANY_ATTRIBUTE); 
    lanesType = createType(false, LANES);
    createProperty(false, lanesType,LanesImpl.INTERNAL_LANE); 
    createProperty(true, lanesType,LanesImpl.INTERNAL_ANY); 
    createProperty(true, lanesType,LanesImpl.INTERNAL_ANY_ATTRIBUTE); 
    lengthType = createType(false, LENGTH);
    createProperty(true, lengthType,LengthImpl.INTERNAL_VALUE); 
    createProperty(true, lengthType,LengthImpl.INTERNAL_ANY_ATTRIBUTE); 
    limitType = createType(false, LIMIT);
    createProperty(true, limitType,LimitImpl.INTERNAL_VALUE); 
    createProperty(true, limitType,LimitImpl.INTERNAL_ANY_ATTRIBUTE); 
    listTypeType = createType(false, LIST_TYPE);
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_BASIC_TYPE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_DECLARED_TYPE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_SCHEMA_TYPE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_RECORD_TYPE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_UNION_TYPE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_ENUMERATION_TYPE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_ARRAY_TYPE); 
    createProperty(false, listTypeType,ListTypeImpl.INTERNAL_LIST_TYPE); 
    createProperty(true, listTypeType,ListTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    locationType = createType(false, LOCATION);
    createProperty(true, locationType,LocationImpl.INTERNAL_VALUE); 
    createProperty(true, locationType,LocationImpl.INTERNAL_ANY_ATTRIBUTE); 
    loopType = createType(false, LOOP);
    createProperty(false, loopType,LoopImpl.INTERNAL_LOOP_STANDARD); 
    createProperty(false, loopType,LoopImpl.INTERNAL_LOOP_MULTI_INSTANCE); 
    createProperty(true, loopType,LoopImpl.INTERNAL_LOOP_TYPE); 
    createProperty(true, loopType,LoopImpl.INTERNAL_ANY_ATTRIBUTE); 
    loopMultiInstanceType = createType(false, LOOP_MULTI_INSTANCE);
    createProperty(true, loopMultiInstanceType,LoopMultiInstanceImpl.INTERNAL_ANY); 
    createProperty(true, loopMultiInstanceType,LoopMultiInstanceImpl.INTERNAL_MI_CONDITION); 
    createProperty(true, loopMultiInstanceType,LoopMultiInstanceImpl.INTERNAL_LOOP_COUNTER); 
    createProperty(true, loopMultiInstanceType,LoopMultiInstanceImpl.INTERNAL_MI_ORDERING); 
    createProperty(true, loopMultiInstanceType,LoopMultiInstanceImpl.INTERNAL_MI_FLOW_CONDITION); 
    createProperty(true, loopMultiInstanceType,LoopMultiInstanceImpl.INTERNAL_COMPLEX_MI_FLOW_CONDITION); 
    createProperty(true, loopMultiInstanceType,LoopMultiInstanceImpl.INTERNAL_ANY_ATTRIBUTE); 
    loopStandardType = createType(false, LOOP_STANDARD);
    createProperty(true, loopStandardType,LoopStandardImpl.INTERNAL_ANY); 
    createProperty(true, loopStandardType,LoopStandardImpl.INTERNAL_LOOP_CONDITION); 
    createProperty(true, loopStandardType,LoopStandardImpl.INTERNAL_LOOP_COUNTER); 
    createProperty(true, loopStandardType,LoopStandardImpl.INTERNAL_LOOP_MAXIMUM); 
    createProperty(true, loopStandardType,LoopStandardImpl.INTERNAL_TEST_TIME); 
    createProperty(true, loopStandardType,LoopStandardImpl.INTERNAL_ANY_ATTRIBUTE); 
    memberType = createType(false, MEMBER);
    createProperty(false, memberType,MemberImpl.INTERNAL_BASIC_TYPE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_DECLARED_TYPE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_SCHEMA_TYPE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_RECORD_TYPE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_UNION_TYPE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_ENUMERATION_TYPE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_ARRAY_TYPE); 
    createProperty(false, memberType,MemberImpl.INTERNAL_LIST_TYPE); 
    createProperty(true, memberType,MemberImpl.INTERNAL_ANY_ATTRIBUTE); 
    messageFlowType = createType(false, MESSAGE_FLOW);
    createProperty(false, messageFlowType,MessageFlowImpl.INTERNAL_MESSAGE); 
    createProperty(false, messageFlowType,MessageFlowImpl.INTERNAL_OBJECT); 
    createProperty(false, messageFlowType,MessageFlowImpl.INTERNAL_CONNECTOR_GRAPHICS_INFOS); 
    createProperty(true, messageFlowType,MessageFlowImpl.INTERNAL_ANY); 
    createProperty(true, messageFlowType,MessageFlowImpl.INTERNAL_ID); 
    createProperty(true, messageFlowType,MessageFlowImpl.INTERNAL_NAME); 
    createProperty(true, messageFlowType,MessageFlowImpl.INTERNAL_SOURCE); 
    createProperty(true, messageFlowType,MessageFlowImpl.INTERNAL_TARGET); 
    createProperty(true, messageFlowType,MessageFlowImpl.INTERNAL_ANY_ATTRIBUTE); 
    messageFlowsType = createType(false, MESSAGE_FLOWS);
    createProperty(true, messageFlowsType,MessageFlowsImpl.INTERNAL_GROUP); 
    createProperty(false, messageFlowsType,MessageFlowsImpl.INTERNAL_MESSAGE_FLOW); 
    createProperty(true, messageFlowsType,MessageFlowsImpl.INTERNAL_ANY); 
    createProperty(true, messageFlowsType,MessageFlowsImpl.INTERNAL_ANY_ATTRIBUTE); 
    messageTypeType = createType(false, MESSAGE_TYPE);
    createProperty(false, messageTypeType,MessageTypeImpl.INTERNAL_ACTUAL_PARAMETERS); 
    createProperty(false, messageTypeType,MessageTypeImpl.INTERNAL_DATA_MAPPINGS); 
    createProperty(true, messageTypeType,MessageTypeImpl.INTERNAL_ANY); 
    createProperty(true, messageTypeType,MessageTypeImpl.INTERNAL_ID); 
    createProperty(true, messageTypeType,MessageTypeImpl.INTERNAL_NAME); 
    createProperty(true, messageTypeType,MessageTypeImpl.INTERNAL_FROM); 
    createProperty(true, messageTypeType,MessageTypeImpl.INTERNAL_TO); 
    createProperty(true, messageTypeType,MessageTypeImpl.INTERNAL_FAULT_NAME); 
    createProperty(true, messageTypeType,MessageTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    methodType = createType(false, METHOD);
    createProperty(true, methodType,MethodImpl.INTERNAL_VALUE); 
    createProperty(true, methodType,MethodImpl.INTERNAL_ANY_ATTRIBUTE); 
    method1Type = createType(false, METHOD1);
    createProperty(true, method1Type,Method1Impl.INTERNAL_VALUE); 
    createProperty(true, method1Type,Method1Impl.INTERNAL_ANY_ATTRIBUTE); 
    myRoleType = createType(false, MY_ROLE);
    createProperty(true, myRoleType,MyRoleImpl.INTERNAL_ANY); 
    createProperty(true, myRoleType,MyRoleImpl.INTERNAL_ROLE_NAME); 
    createProperty(true, myRoleType,MyRoleImpl.INTERNAL_ANY_ATTRIBUTE); 
    noType = createType(false, NO);
    createProperty(true, noType,NoImpl.INTERNAL_ANY); 
    createProperty(true, noType,NoImpl.INTERNAL_ANY_ATTRIBUTE); 
    nodeGraphicsInfoType = createType(false, NODE_GRAPHICS_INFO);
    createProperty(false, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_COORDINATES); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_ANY); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_TOOL_ID); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_IS_VISIBLE); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_PAGE); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_LANE_ID); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_HEIGHT); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_WIDTH); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_BORDER_COLOR); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_FILL_COLOR); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_SHAPE); 
    createProperty(true, nodeGraphicsInfoType,NodeGraphicsInfoImpl.INTERNAL_ANY_ATTRIBUTE); 
    nodeGraphicsInfosType = createType(false, NODE_GRAPHICS_INFOS);
    createProperty(false, nodeGraphicsInfosType,NodeGraphicsInfosImpl.INTERNAL_NODE_GRAPHICS_INFO); 
    createProperty(true, nodeGraphicsInfosType,NodeGraphicsInfosImpl.INTERNAL_ANY); 
    createProperty(true, nodeGraphicsInfosType,NodeGraphicsInfosImpl.INTERNAL_ANY_ATTRIBUTE); 
    objectType = createType(false, OBJECT);
    createProperty(false, objectType,ObjectImpl.INTERNAL_CATEGORIES); 
    createProperty(false, objectType,ObjectImpl.INTERNAL_DOCUMENTATION); 
    createProperty(true, objectType,ObjectImpl.INTERNAL_ANY); 
    createProperty(true, objectType,ObjectImpl.INTERNAL_ID); 
    createProperty(true, objectType,ObjectImpl.INTERNAL_NAME); 
    createProperty(true, objectType,ObjectImpl.INTERNAL_ANY_ATTRIBUTE); 
    outputType = createType(false, OUTPUT);
    createProperty(true, outputType,OutputImpl.INTERNAL_ANY); 
    createProperty(true, outputType,OutputImpl.INTERNAL_ARTIFACT_ID); 
    createProperty(true, outputType,OutputImpl.INTERNAL_ANY_ATTRIBUTE); 
    outputSetType = createType(false, OUTPUT_SET);
    createProperty(false, outputSetType,OutputSetImpl.INTERNAL_OUTPUT); 
    createProperty(true, outputSetType,OutputSetImpl.INTERNAL_ANY); 
    createProperty(true, outputSetType,OutputSetImpl.INTERNAL_ANY_ATTRIBUTE); 
    outputSetsType = createType(false, OUTPUT_SETS);
    createProperty(false, outputSetsType,OutputSetsImpl.INTERNAL_OUTPUT_SET); 
    createProperty(true, outputSetsType,OutputSetsImpl.INTERNAL_ANY); 
    createProperty(true, outputSetsType,OutputSetsImpl.INTERNAL_ANY_ATTRIBUTE); 
    packageHeaderType = createType(false, PACKAGE_HEADER);
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_XPDL_VERSION); 
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_VENDOR); 
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_CREATED); 
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_DOCUMENTATION); 
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_PRIORITY_UNIT); 
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_COST_UNIT); 
    createProperty(false, packageHeaderType,PackageHeaderImpl.INTERNAL_VENDOR_EXTENSIONS); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_ANY); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_ANY_ATTRIBUTE); 
    packageTypeType = createType(false, PACKAGE_TYPE);
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_PACKAGE_HEADER); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_REDEFINABLE_HEADER); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_CONFORMANCE_CLASS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_SCRIPT); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_EXTERNAL_PACKAGES); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_TYPE_DECLARATIONS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_PARTICIPANTS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_APPLICATIONS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_DATA_FIELDS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_PARTNER_LINK_TYPES); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_POOLS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_MESSAGE_FLOWS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_ASSOCIATIONS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_ARTIFACTS); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_WORKFLOW_PROCESSES); 
    createProperty(false, packageTypeType,PackageTypeImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, packageTypeType,PackageTypeImpl.INTERNAL_ANY); 
    createProperty(true, packageTypeType,PackageTypeImpl.INTERNAL_ID); 
    createProperty(true, packageTypeType,PackageTypeImpl.INTERNAL_NAME); 
    createProperty(true, packageTypeType,PackageTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    participantType = createType(false, PARTICIPANT);
    createProperty(false, participantType,ParticipantImpl.INTERNAL_PARTICIPANT_TYPE); 
    createProperty(false, participantType,ParticipantImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, participantType,ParticipantImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, participantType,ParticipantImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, participantType,ParticipantImpl.INTERNAL_ANY); 
    createProperty(true, participantType,ParticipantImpl.INTERNAL_ID); 
    createProperty(true, participantType,ParticipantImpl.INTERNAL_NAME); 
    createProperty(true, participantType,ParticipantImpl.INTERNAL_ANY_ATTRIBUTE); 
    participantsType = createType(false, PARTICIPANTS);
    createProperty(false, participantsType,ParticipantsImpl.INTERNAL_PARTICIPANT); 
    createProperty(true, participantsType,ParticipantsImpl.INTERNAL_ANY); 
    createProperty(true, participantsType,ParticipantsImpl.INTERNAL_ANY_ATTRIBUTE); 
    participantTypeType = createType(false, PARTICIPANT_TYPE);
    createProperty(true, participantTypeType,ParticipantTypeImpl.INTERNAL_ANY); 
    createProperty(true, participantTypeType,ParticipantTypeImpl.INTERNAL_TYPE); 
    createProperty(true, participantTypeType,ParticipantTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    partnerType = createType(false, PARTNER);
    createProperty(true, partnerType,PartnerImpl.INTERNAL_ANY); 
    createProperty(true, partnerType,PartnerImpl.INTERNAL_PARTNER_LINK_ID); 
    createProperty(true, partnerType,PartnerImpl.INTERNAL_ROLE_TYPE); 
    createProperty(true, partnerType,PartnerImpl.INTERNAL_ANY_ATTRIBUTE); 
    partnerLinkType = createType(false, PARTNER_LINK);
    createProperty(false, partnerLinkType,PartnerLinkImpl.INTERNAL_MY_ROLE); 
    createProperty(false, partnerLinkType,PartnerLinkImpl.INTERNAL_PARTNER_ROLE); 
    createProperty(true, partnerLinkType,PartnerLinkImpl.INTERNAL_ANY); 
    createProperty(true, partnerLinkType,PartnerLinkImpl.INTERNAL_NAME); 
    createProperty(true, partnerLinkType,PartnerLinkImpl.INTERNAL_ID); 
    createProperty(true, partnerLinkType,PartnerLinkImpl.INTERNAL_PARTNER_LINK_TYPE_ID); 
    createProperty(true, partnerLinkType,PartnerLinkImpl.INTERNAL_ANY_ATTRIBUTE); 
    partnerLinksType = createType(false, PARTNER_LINKS);
    createProperty(false, partnerLinksType,PartnerLinksImpl.INTERNAL_PARTNER_LINK); 
    createProperty(true, partnerLinksType,PartnerLinksImpl.INTERNAL_ANY); 
    createProperty(true, partnerLinksType,PartnerLinksImpl.INTERNAL_ANY_ATTRIBUTE); 
    partnerLinkTypeType = createType(false, PARTNER_LINK_TYPE);
    createProperty(false, partnerLinkTypeType,PartnerLinkTypeImpl.INTERNAL_ROLE); 
    createProperty(true, partnerLinkTypeType,PartnerLinkTypeImpl.INTERNAL_ANY); 
    createProperty(true, partnerLinkTypeType,PartnerLinkTypeImpl.INTERNAL_ID); 
    createProperty(true, partnerLinkTypeType,PartnerLinkTypeImpl.INTERNAL_NAME); 
    createProperty(true, partnerLinkTypeType,PartnerLinkTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    partnerLinkTypesType = createType(false, PARTNER_LINK_TYPES);
    createProperty(false, partnerLinkTypesType,PartnerLinkTypesImpl.INTERNAL_PARTNER_LINK_TYPE); 
    createProperty(true, partnerLinkTypesType,PartnerLinkTypesImpl.INTERNAL_ANY); 
    createProperty(true, partnerLinkTypesType,PartnerLinkTypesImpl.INTERNAL_ANY_ATTRIBUTE); 
    partnerRoleType = createType(false, PARTNER_ROLE);
    createProperty(false, partnerRoleType,PartnerRoleImpl.INTERNAL_END_POINT); 
    createProperty(true, partnerRoleType,PartnerRoleImpl.INTERNAL_ANY); 
    createProperty(true, partnerRoleType,PartnerRoleImpl.INTERNAL_ROLE_NAME); 
    createProperty(true, partnerRoleType,PartnerRoleImpl.INTERNAL_SERVICE_NAME); 
    createProperty(true, partnerRoleType,PartnerRoleImpl.INTERNAL_PORT_NAME); 
    createProperty(true, partnerRoleType,PartnerRoleImpl.INTERNAL_ANY_ATTRIBUTE); 
    performerType = createType(false, PERFORMER);
    createProperty(true, performerType,PerformerImpl.INTERNAL_VALUE); 
    createProperty(true, performerType,PerformerImpl.INTERNAL_ANY_ATTRIBUTE); 
    performersType = createType(false, PERFORMERS);
    createProperty(false, performersType,PerformersImpl.INTERNAL_PERFORMER); 
    createProperty(true, performersType,PerformersImpl.INTERNAL_ANY); 
    createProperty(true, performersType,PerformersImpl.INTERNAL_ANY_ATTRIBUTE); 
    pojoType = createType(false, POJO);
    createProperty(false, pojoType,PojoImpl.INTERNAL_CLASS); 
    createProperty(false, pojoType,PojoImpl.INTERNAL_METHOD); 
    createProperty(true, pojoType,PojoImpl.INTERNAL_ANY); 
    createProperty(true, pojoType,PojoImpl.INTERNAL_ANY_ATTRIBUTE); 
    poolType = createType(false, POOL);
    createProperty(false, poolType,PoolImpl.INTERNAL_LANES); 
    createProperty(false, poolType,PoolImpl.INTERNAL_OBJECT); 
    createProperty(false, poolType,PoolImpl.INTERNAL_NODE_GRAPHICS_INFOS); 
    createProperty(true, poolType,PoolImpl.INTERNAL_ANY); 
    createProperty(true, poolType,PoolImpl.INTERNAL_ID); 
    createProperty(true, poolType,PoolImpl.INTERNAL_NAME); 
    createProperty(true, poolType,PoolImpl.INTERNAL_ORIENTATION); 
    createProperty(true, poolType,PoolImpl.INTERNAL_PROCESS); 
    createProperty(true, poolType,PoolImpl.INTERNAL_PARTICIPANT); 
    createProperty(true, poolType,PoolImpl.INTERNAL_BOUNDARY_VISIBLE); 
    createProperty(true, poolType,PoolImpl.INTERNAL_ANY_ATTRIBUTE); 
    poolsType = createType(false, POOLS);
    createProperty(false, poolsType,PoolsImpl.INTERNAL_POOL); 
    createProperty(true, poolsType,PoolsImpl.INTERNAL_ANY); 
    createProperty(true, poolsType,PoolsImpl.INTERNAL_ANY_ATTRIBUTE); 
    precisionType = createType(false, PRECISION);
    createProperty(true, precisionType,PrecisionImpl.INTERNAL_VALUE); 
    createProperty(true, precisionType,PrecisionImpl.INTERNAL_ANY_ATTRIBUTE); 
    priorityType = createType(false, PRIORITY);
    createProperty(true, priorityType,PriorityImpl.INTERNAL_VALUE); 
    createProperty(true, priorityType,PriorityImpl.INTERNAL_ANY_ATTRIBUTE); 
    priorityUnitType = createType(false, PRIORITY_UNIT);
    createProperty(true, priorityUnitType,PriorityUnitImpl.INTERNAL_VALUE); 
    createProperty(true, priorityUnitType,PriorityUnitImpl.INTERNAL_ANY_ATTRIBUTE); 
    processHeaderType = createType(false, PROCESS_HEADER);
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_CREATED); 
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_PRIORITY); 
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_LIMIT); 
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_VALID_FROM); 
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_VALID_TO); 
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_TIME_ESTIMATION); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_ANY); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_DURATION_UNIT); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_ANY_ATTRIBUTE); 
    processType1Type = createType(false, PROCESS_TYPE1);
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_PROCESS_HEADER); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_REDEFINABLE_HEADER); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_FORMAL_PARAMETERS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_PARTICIPANTS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_APPLICATIONS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_DATA_FIELDS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_DATA_FIELDS1); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_PARTICIPANTS1); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_APPLICATIONS1); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_ACTIVITY_SETS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_ACTIVITIES); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_TRANSITIONS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_ASSIGNMENTS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_PARTNER_LINKS); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_OBJECT); 
    createProperty(false, processType1Type,ProcessType1Impl.INTERNAL_EXTENSIONS); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_ANY); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_ID); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_NAME); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_ACCESS_LEVEL); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_PROCESS_TYPE); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_STATUS); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_SUPPRESS_JOIN_FAILURE); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_ENABLE_INSTANCE_COMPENSATION); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_AD_HOC); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_AD_HOC_ORDERING); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_AD_HOC_COMPLETION_CONDITION); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_DEFAULT_START_ACTIVITY_SET_ID); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_DEFAULT_START_ACTIVITY_ID); 
    createProperty(true, processType1Type,ProcessType1Impl.INTERNAL_ANY_ATTRIBUTE); 
    recordTypeType = createType(false, RECORD_TYPE);
    createProperty(false, recordTypeType,RecordTypeImpl.INTERNAL_MEMBER); 
    createProperty(true, recordTypeType,RecordTypeImpl.INTERNAL_ANY); 
    createProperty(true, recordTypeType,RecordTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    redefinableHeaderType = createType(false, REDEFINABLE_HEADER);
    createProperty(false, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_AUTHOR); 
    createProperty(false, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_VERSION); 
    createProperty(false, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_CODEPAGE); 
    createProperty(false, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_COUNTRYKEY); 
    createProperty(false, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_RESPONSIBLES); 
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_ANY); 
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_PUBLICATION_STATUS); 
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_ANY_ATTRIBUTE); 
    referenceType = createType(false, REFERENCE);
    createProperty(true, referenceType,ReferenceImpl.INTERNAL_ANY); 
    createProperty(true, referenceType,ReferenceImpl.INTERNAL_ACTIVITY_ID); 
    createProperty(true, referenceType,ReferenceImpl.INTERNAL_ANY_ATTRIBUTE); 
    responsibleType = createType(false, RESPONSIBLE);
    createProperty(true, responsibleType,ResponsibleImpl.INTERNAL_VALUE); 
    createProperty(true, responsibleType,ResponsibleImpl.INTERNAL_ANY_ATTRIBUTE); 
    responsiblesType = createType(false, RESPONSIBLES);
    createProperty(false, responsiblesType,ResponsiblesImpl.INTERNAL_RESPONSIBLE); 
    createProperty(true, responsiblesType,ResponsiblesImpl.INTERNAL_ANY); 
    createProperty(true, responsiblesType,ResponsiblesImpl.INTERNAL_ANY_ATTRIBUTE); 
    resultCompensationType = createType(false, RESULT_COMPENSATION);
    createProperty(true, resultCompensationType,ResultCompensationImpl.INTERNAL_ANY); 
    createProperty(true, resultCompensationType,ResultCompensationImpl.INTERNAL_ACTIVITY_ID); 
    createProperty(true, resultCompensationType,ResultCompensationImpl.INTERNAL_ANY_ATTRIBUTE); 
    resultErrorType = createType(false, RESULT_ERROR);
    createProperty(true, resultErrorType,ResultErrorImpl.INTERNAL_ANY); 
    createProperty(true, resultErrorType,ResultErrorImpl.INTERNAL_ERROR_CODE); 
    createProperty(true, resultErrorType,ResultErrorImpl.INTERNAL_ANY_ATTRIBUTE); 
    resultMultipleType = createType(false, RESULT_MULTIPLE);
    createProperty(false, resultMultipleType,ResultMultipleImpl.INTERNAL_TRIGGER_RESULT_MESSAGE); 
    createProperty(false, resultMultipleType,ResultMultipleImpl.INTERNAL_TRIGGER_RESULT_LINK); 
    createProperty(false, resultMultipleType,ResultMultipleImpl.INTERNAL_RESULT_COMPENSATION); 
    createProperty(false, resultMultipleType,ResultMultipleImpl.INTERNAL_RESULT_ERROR); 
    createProperty(true, resultMultipleType,ResultMultipleImpl.INTERNAL_ANY); 
    createProperty(true, resultMultipleType,ResultMultipleImpl.INTERNAL_ANY_ATTRIBUTE); 
    roleType = createType(false, ROLE);
    createProperty(true, roleType,RoleImpl.INTERNAL_ANY); 
    createProperty(true, roleType,RoleImpl.INTERNAL_PORT_TYPE); 
    createProperty(true, roleType,RoleImpl.INTERNAL_NAME); 
    createProperty(true, roleType,RoleImpl.INTERNAL_ANY_ATTRIBUTE); 
    routeType = createType(false, ROUTE);
    createProperty(true, routeType,RouteImpl.INTERNAL_ANY); 
    createProperty(true, routeType,RouteImpl.INTERNAL_GATEWAY_TYPE); 
    createProperty(true, routeType,RouteImpl.INTERNAL_INSTANTIATE); 
    createProperty(true, routeType,RouteImpl.INTERNAL_MARKER_VISIBLE); 
    createProperty(true, routeType,RouteImpl.INTERNAL_ANY_ATTRIBUTE); 
    ruleType = createType(false, RULE);
    createProperty(false, ruleType,RuleImpl.INTERNAL_EXPRESSION); 
    createProperty(true, ruleType,RuleImpl.INTERNAL_ANY); 
    createProperty(true, ruleType,RuleImpl.INTERNAL_ID); 
    createProperty(true, ruleType,RuleImpl.INTERNAL_NAME); 
    createProperty(true, ruleType,RuleImpl.INTERNAL_ANY_ATTRIBUTE); 
    ruleNameType = createType(false, RULE_NAME);
    createProperty(true, ruleNameType,RuleNameImpl.INTERNAL_VALUE); 
    createProperty(true, ruleNameType,RuleNameImpl.INTERNAL_ANY_ATTRIBUTE); 
    scaleType = createType(false, SCALE);
    createProperty(true, scaleType,ScaleImpl.INTERNAL_VALUE); 
    createProperty(true, scaleType,ScaleImpl.INTERNAL_ANY_ATTRIBUTE); 
    schemaTypeType = createType(false, SCHEMA_TYPE);
    createProperty(true, schemaTypeType,SchemaTypeImpl.INTERNAL_ANY); 
    createProperty(true, schemaTypeType,SchemaTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    scriptType = createType(false, SCRIPT);
    createProperty(true, scriptType,ScriptImpl.INTERNAL_ANY); 
    createProperty(true, scriptType,ScriptImpl.INTERNAL_TYPE); 
    createProperty(true, scriptType,ScriptImpl.INTERNAL_VERSION); 
    createProperty(true, scriptType,ScriptImpl.INTERNAL_GRAMMAR); 
    createProperty(true, scriptType,ScriptImpl.INTERNAL_ANY_ATTRIBUTE); 
    script1Type = createType(false, SCRIPT1);
    createProperty(false, script1Type,Script1Impl.INTERNAL_EXPRESSION); 
    createProperty(true, script1Type,Script1Impl.INTERNAL_ANY); 
    createProperty(true, script1Type,Script1Impl.INTERNAL_ANY_ATTRIBUTE); 
    serviceType = createType(false, SERVICE);
    createProperty(false, serviceType,ServiceImpl.INTERNAL_END_POINT); 
    createProperty(true, serviceType,ServiceImpl.INTERNAL_ANY); 
    createProperty(true, serviceType,ServiceImpl.INTERNAL_SERVICE_NAME); 
    createProperty(true, serviceType,ServiceImpl.INTERNAL_PORT_NAME); 
    createProperty(true, serviceType,ServiceImpl.INTERNAL_ANY_ATTRIBUTE); 
    simulationInformationType = createType(false, SIMULATION_INFORMATION);
    createProperty(false, simulationInformationType,SimulationInformationImpl.INTERNAL_COST); 
    createProperty(false, simulationInformationType,SimulationInformationImpl.INTERNAL_TIME_ESTIMATION); 
    createProperty(true, simulationInformationType,SimulationInformationImpl.INTERNAL_ANY); 
    createProperty(true, simulationInformationType,SimulationInformationImpl.INTERNAL_INSTANTIATION); 
    createProperty(true, simulationInformationType,SimulationInformationImpl.INTERNAL_ANY_ATTRIBUTE); 
    splitType = createType(false, SPLIT);
    createProperty(false, splitType,SplitImpl.INTERNAL_TRANSITION_REFS); 
    createProperty(true, splitType,SplitImpl.INTERNAL_ANY); 
    createProperty(true, splitType,SplitImpl.INTERNAL_TYPE); 
    createProperty(true, splitType,SplitImpl.INTERNAL_OUTGOING_CONDITION); 
    createProperty(true, splitType,SplitImpl.INTERNAL_ANY_ATTRIBUTE); 
    startEventType = createType(false, START_EVENT);
    createProperty(false, startEventType,StartEventImpl.INTERNAL_TRIGGER_RESULT_MESSAGE); 
    createProperty(false, startEventType,StartEventImpl.INTERNAL_TRIGGER_TIMER); 
    createProperty(false, startEventType,StartEventImpl.INTERNAL_TRIGGER_RULE); 
    createProperty(false, startEventType,StartEventImpl.INTERNAL_TRIGGER_RESULT_LINK); 
    createProperty(false, startEventType,StartEventImpl.INTERNAL_TRIGGER_MULTIPLE); 
    createProperty(true, startEventType,StartEventImpl.INTERNAL_TRIGGER); 
    createProperty(true, startEventType,StartEventImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(true, startEventType,StartEventImpl.INTERNAL_ANY_ATTRIBUTE); 
    subFlowType = createType(false, SUB_FLOW);
    createProperty(false, subFlowType,SubFlowImpl.INTERNAL_ACTUAL_PARAMETERS); 
    createProperty(false, subFlowType,SubFlowImpl.INTERNAL_DATA_MAPPINGS); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_ANY); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_ID); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_NAME); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_EXECUTION); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_PACKAGE_REF); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_INSTANCE_DATA_FIELD); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_START_ACTIVITY_SET_ID); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_START_ACTIVITY_ID); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskType = createType(false, TASK);
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_SERVICE); 
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_RECEIVE); 
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_MANUAL); 
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_REFERENCE); 
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_SCRIPT); 
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_SEND); 
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_USER); 
    createProperty(false, taskType,TaskImpl.INTERNAL_TASK_APPLICATION); 
    createProperty(true, taskType,TaskImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskApplicationType = createType(false, TASK_APPLICATION);
    createProperty(false, taskApplicationType,TaskApplicationImpl.INTERNAL_ACTUAL_PARAMETERS); 
    createProperty(false, taskApplicationType,TaskApplicationImpl.INTERNAL_DATA_MAPPINGS); 
    createProperty(false, taskApplicationType,TaskApplicationImpl.INTERNAL_DESCRIPTION); 
    createProperty(true, taskApplicationType,TaskApplicationImpl.INTERNAL_ANY); 
    createProperty(true, taskApplicationType,TaskApplicationImpl.INTERNAL_ID); 
    createProperty(true, taskApplicationType,TaskApplicationImpl.INTERNAL_NAME); 
    createProperty(true, taskApplicationType,TaskApplicationImpl.INTERNAL_PACKAGE_REF); 
    createProperty(true, taskApplicationType,TaskApplicationImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskManualType = createType(false, TASK_MANUAL);
    createProperty(false, taskManualType,TaskManualImpl.INTERNAL_PERFORMERS); 
    createProperty(true, taskManualType,TaskManualImpl.INTERNAL_ANY); 
    createProperty(true, taskManualType,TaskManualImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskReceiveType = createType(false, TASK_RECEIVE);
    createProperty(false, taskReceiveType,TaskReceiveImpl.INTERNAL_MESSAGE); 
    createProperty(false, taskReceiveType,TaskReceiveImpl.INTERNAL_WEB_SERVICE_OPERATION); 
    createProperty(true, taskReceiveType,TaskReceiveImpl.INTERNAL_ANY); 
    createProperty(true, taskReceiveType,TaskReceiveImpl.INTERNAL_INSTANTIATE); 
    createProperty(true, taskReceiveType,TaskReceiveImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(true, taskReceiveType,TaskReceiveImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskReferenceType = createType(false, TASK_REFERENCE);
    createProperty(true, taskReferenceType,TaskReferenceImpl.INTERNAL_ANY); 
    createProperty(true, taskReferenceType,TaskReferenceImpl.INTERNAL_TASK_REF); 
    createProperty(true, taskReferenceType,TaskReferenceImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskScriptType = createType(false, TASK_SCRIPT);
    createProperty(false, taskScriptType,TaskScriptImpl.INTERNAL_SCRIPT); 
    createProperty(true, taskScriptType,TaskScriptImpl.INTERNAL_ANY); 
    createProperty(true, taskScriptType,TaskScriptImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskSendType = createType(false, TASK_SEND);
    createProperty(false, taskSendType,TaskSendImpl.INTERNAL_MESSAGE); 
    createProperty(false, taskSendType,TaskSendImpl.INTERNAL_WEB_SERVICE_OPERATION); 
    createProperty(false, taskSendType,TaskSendImpl.INTERNAL_WEB_SERVICE_FAULT_CATCH); 
    createProperty(true, taskSendType,TaskSendImpl.INTERNAL_ANY); 
    createProperty(true, taskSendType,TaskSendImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(true, taskSendType,TaskSendImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskServiceType = createType(false, TASK_SERVICE);
    createProperty(false, taskServiceType,TaskServiceImpl.INTERNAL_MESSAGE_IN); 
    createProperty(false, taskServiceType,TaskServiceImpl.INTERNAL_MESSAGE_OUT); 
    createProperty(false, taskServiceType,TaskServiceImpl.INTERNAL_WEB_SERVICE_OPERATION); 
    createProperty(false, taskServiceType,TaskServiceImpl.INTERNAL_WEB_SERVICE_FAULT_CATCH); 
    createProperty(true, taskServiceType,TaskServiceImpl.INTERNAL_ANY); 
    createProperty(true, taskServiceType,TaskServiceImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(true, taskServiceType,TaskServiceImpl.INTERNAL_ANY_ATTRIBUTE); 
    taskUserType = createType(false, TASK_USER);
    createProperty(false, taskUserType,TaskUserImpl.INTERNAL_PERFORMERS); 
    createProperty(false, taskUserType,TaskUserImpl.INTERNAL_MESSAGE_IN); 
    createProperty(false, taskUserType,TaskUserImpl.INTERNAL_MESSAGE_OUT); 
    createProperty(false, taskUserType,TaskUserImpl.INTERNAL_WEB_SERVICE_OPERATION); 
    createProperty(true, taskUserType,TaskUserImpl.INTERNAL_ANY); 
    createProperty(true, taskUserType,TaskUserImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(true, taskUserType,TaskUserImpl.INTERNAL_ANY_ATTRIBUTE); 
    timeEstimationType = createType(false, TIME_ESTIMATION);
    createProperty(false, timeEstimationType,TimeEstimationImpl.INTERNAL_WAITING_TIME); 
    createProperty(false, timeEstimationType,TimeEstimationImpl.INTERNAL_WORKING_TIME); 
    createProperty(false, timeEstimationType,TimeEstimationImpl.INTERNAL_DURATION); 
    createProperty(true, timeEstimationType,TimeEstimationImpl.INTERNAL_ANY); 
    createProperty(true, timeEstimationType,TimeEstimationImpl.INTERNAL_ANY_ATTRIBUTE); 
    transactionType = createType(false, TRANSACTION);
    createProperty(true, transactionType,TransactionImpl.INTERNAL_ANY); 
    createProperty(true, transactionType,TransactionImpl.INTERNAL_TRANSACTION_ID); 
    createProperty(true, transactionType,TransactionImpl.INTERNAL_TRANSACTION_PROTOCOL); 
    createProperty(true, transactionType,TransactionImpl.INTERNAL_TRANSACTION_METHOD); 
    createProperty(true, transactionType,TransactionImpl.INTERNAL_ANY_ATTRIBUTE); 
    transitionType = createType(false, TRANSITION);
    createProperty(false, transitionType,TransitionImpl.INTERNAL_CONDITION); 
    createProperty(false, transitionType,TransitionImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, transitionType,TransitionImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(false, transitionType,TransitionImpl.INTERNAL_ASSIGNMENTS); 
    createProperty(false, transitionType,TransitionImpl.INTERNAL_OBJECT); 
    createProperty(false, transitionType,TransitionImpl.INTERNAL_CONNECTOR_GRAPHICS_INFOS); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_ANY); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_ID); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_FROM); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_TO); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_NAME); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_QUANTITY); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_ANY_ATTRIBUTE); 
    transitionRefType = createType(false, TRANSITION_REF);
    createProperty(true, transitionRefType,TransitionRefImpl.INTERNAL_ANY); 
    createProperty(true, transitionRefType,TransitionRefImpl.INTERNAL_ID); 
    createProperty(true, transitionRefType,TransitionRefImpl.INTERNAL_NAME); 
    createProperty(true, transitionRefType,TransitionRefImpl.INTERNAL_ANY_ATTRIBUTE); 
    transitionRefsType = createType(false, TRANSITION_REFS);
    createProperty(false, transitionRefsType,TransitionRefsImpl.INTERNAL_TRANSITION_REF); 
    createProperty(true, transitionRefsType,TransitionRefsImpl.INTERNAL_ANY); 
    createProperty(true, transitionRefsType,TransitionRefsImpl.INTERNAL_ANY_ATTRIBUTE); 
    transitionRestrictionType = createType(false, TRANSITION_RESTRICTION);
    createProperty(false, transitionRestrictionType,TransitionRestrictionImpl.INTERNAL_JOIN); 
    createProperty(false, transitionRestrictionType,TransitionRestrictionImpl.INTERNAL_SPLIT); 
    createProperty(true, transitionRestrictionType,TransitionRestrictionImpl.INTERNAL_ANY); 
    createProperty(true, transitionRestrictionType,TransitionRestrictionImpl.INTERNAL_ANY_ATTRIBUTE); 
    transitionRestrictionsType = createType(false, TRANSITION_RESTRICTIONS);
    createProperty(false, transitionRestrictionsType,TransitionRestrictionsImpl.INTERNAL_TRANSITION_RESTRICTION); 
    createProperty(true, transitionRestrictionsType,TransitionRestrictionsImpl.INTERNAL_ANY); 
    createProperty(true, transitionRestrictionsType,TransitionRestrictionsImpl.INTERNAL_ANY_ATTRIBUTE); 
    transitionsType = createType(false, TRANSITIONS);
    createProperty(false, transitionsType,TransitionsImpl.INTERNAL_TRANSITION); 
    createProperty(true, transitionsType,TransitionsImpl.INTERNAL_ANY); 
    createProperty(true, transitionsType,TransitionsImpl.INTERNAL_ANY_ATTRIBUTE); 
    triggerIntermediateMultipleType = createType(false, TRIGGER_INTERMEDIATE_MULTIPLE);
    createProperty(false, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_RESULT_MESSAGE); 
    createProperty(false, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_TIMER); 
    createProperty(false, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_RESULT_ERROR); 
    createProperty(false, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_RESULT_COMPENSATION); 
    createProperty(false, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_RULE); 
    createProperty(false, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_RESULT_LINK); 
    createProperty(true, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_ANY); 
    createProperty(true, triggerIntermediateMultipleType,TriggerIntermediateMultipleImpl.INTERNAL_ANY_ATTRIBUTE); 
    triggerMultipleType = createType(false, TRIGGER_MULTIPLE);
    createProperty(false, triggerMultipleType,TriggerMultipleImpl.INTERNAL_TRIGGER_RESULT_MESSAGE); 
    createProperty(false, triggerMultipleType,TriggerMultipleImpl.INTERNAL_TRIGGER_TIMER); 
    createProperty(false, triggerMultipleType,TriggerMultipleImpl.INTERNAL_TRIGGER_RULE); 
    createProperty(false, triggerMultipleType,TriggerMultipleImpl.INTERNAL_TRIGGER_RESULT_LINK); 
    createProperty(true, triggerMultipleType,TriggerMultipleImpl.INTERNAL_ANY); 
    createProperty(true, triggerMultipleType,TriggerMultipleImpl.INTERNAL_ANY_ATTRIBUTE); 
    triggerResultLinkType = createType(false, TRIGGER_RESULT_LINK);
    createProperty(true, triggerResultLinkType,TriggerResultLinkImpl.INTERNAL_ANY); 
    createProperty(true, triggerResultLinkType,TriggerResultLinkImpl.INTERNAL_LINK_ID); 
    createProperty(true, triggerResultLinkType,TriggerResultLinkImpl.INTERNAL_PROCESS_REF); 
    createProperty(true, triggerResultLinkType,TriggerResultLinkImpl.INTERNAL_ANY_ATTRIBUTE); 
    triggerResultMessageType = createType(false, TRIGGER_RESULT_MESSAGE);
    createProperty(false, triggerResultMessageType,TriggerResultMessageImpl.INTERNAL_MESSAGE); 
    createProperty(false, triggerResultMessageType,TriggerResultMessageImpl.INTERNAL_WEB_SERVICE_OPERATION); 
    createProperty(true, triggerResultMessageType,TriggerResultMessageImpl.INTERNAL_ANY); 
    createProperty(true, triggerResultMessageType,TriggerResultMessageImpl.INTERNAL_ANY_ATTRIBUTE); 
    triggerRuleType = createType(false, TRIGGER_RULE);
    createProperty(true, triggerRuleType,TriggerRuleImpl.INTERNAL_ANY); 
    createProperty(true, triggerRuleType,TriggerRuleImpl.INTERNAL_RULE_NAME); 
    createProperty(true, triggerRuleType,TriggerRuleImpl.INTERNAL_ANY_ATTRIBUTE); 
    triggerTimerType = createType(false, TRIGGER_TIMER);
    createProperty(true, triggerTimerType,TriggerTimerImpl.INTERNAL_ANY); 
    createProperty(true, triggerTimerType,TriggerTimerImpl.INTERNAL_TIME_DATE); 
    createProperty(true, triggerTimerType,TriggerTimerImpl.INTERNAL_TIME_CYCLE); 
    createProperty(true, triggerTimerType,TriggerTimerImpl.INTERNAL_ANY_ATTRIBUTE); 
    typeDeclarationType = createType(false, TYPE_DECLARATION);
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_BASIC_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_DECLARED_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_SCHEMA_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_RECORD_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_UNION_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_ENUMERATION_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_ARRAY_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_LIST_TYPE); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, typeDeclarationType,TypeDeclarationImpl.INTERNAL_ANY); 
    createProperty(true, typeDeclarationType,TypeDeclarationImpl.INTERNAL_ID); 
    createProperty(true, typeDeclarationType,TypeDeclarationImpl.INTERNAL_NAME); 
    createProperty(true, typeDeclarationType,TypeDeclarationImpl.INTERNAL_ANY_ATTRIBUTE); 
    typeDeclarationsType = createType(false, TYPE_DECLARATIONS);
    createProperty(false, typeDeclarationsType,TypeDeclarationsImpl.INTERNAL_TYPE_DECLARATION); 
    createProperty(true, typeDeclarationsType,TypeDeclarationsImpl.INTERNAL_ANY); 
    createProperty(true, typeDeclarationsType,TypeDeclarationsImpl.INTERNAL_ANY_ATTRIBUTE); 
    unionTypeType = createType(false, UNION_TYPE);
    createProperty(false, unionTypeType,UnionTypeImpl.INTERNAL_MEMBER); 
    createProperty(true, unionTypeType,UnionTypeImpl.INTERNAL_ANY); 
    createProperty(true, unionTypeType,UnionTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    validFromType = createType(false, VALID_FROM);
    createProperty(true, validFromType,ValidFromImpl.INTERNAL_VALUE); 
    createProperty(true, validFromType,ValidFromImpl.INTERNAL_ANY_ATTRIBUTE); 
    validToType = createType(false, VALID_TO);
    createProperty(true, validToType,ValidToImpl.INTERNAL_VALUE); 
    createProperty(true, validToType,ValidToImpl.INTERNAL_ANY_ATTRIBUTE); 
    vendorType = createType(false, VENDOR);
    createProperty(true, vendorType,VendorImpl.INTERNAL_VALUE); 
    createProperty(true, vendorType,VendorImpl.INTERNAL_ANY_ATTRIBUTE); 
    vendorExtensionType = createType(false, VENDOR_EXTENSION);
    createProperty(true, vendorExtensionType,VendorExtensionImpl.INTERNAL_ANY); 
    createProperty(true, vendorExtensionType,VendorExtensionImpl.INTERNAL_TOOL_ID); 
    createProperty(true, vendorExtensionType,VendorExtensionImpl.INTERNAL_SCHEMA_LOCATION); 
    createProperty(true, vendorExtensionType,VendorExtensionImpl.INTERNAL_EXTENSION_DESCRIPTION); 
    createProperty(true, vendorExtensionType,VendorExtensionImpl.INTERNAL_ANY_ATTRIBUTE); 
    vendorExtensionsType = createType(false, VENDOR_EXTENSIONS);
    createProperty(false, vendorExtensionsType,VendorExtensionsImpl.INTERNAL_VENDOR_EXTENSION); 
    createProperty(true, vendorExtensionsType,VendorExtensionsImpl.INTERNAL_ANY); 
    createProperty(true, vendorExtensionsType,VendorExtensionsImpl.INTERNAL_ANY_ATTRIBUTE); 
    versionType = createType(false, VERSION);
    createProperty(true, versionType,VersionImpl.INTERNAL_VALUE); 
    createProperty(true, versionType,VersionImpl.INTERNAL_ANY_ATTRIBUTE); 
    waitingTimeType = createType(false, WAITING_TIME);
    createProperty(true, waitingTimeType,WaitingTimeImpl.INTERNAL_VALUE); 
    createProperty(true, waitingTimeType,WaitingTimeImpl.INTERNAL_ANY_ATTRIBUTE); 
    webServiceType = createType(false, WEB_SERVICE);
    createProperty(false, webServiceType,WebServiceImpl.INTERNAL_WEB_SERVICE_OPERATION); 
    createProperty(false, webServiceType,WebServiceImpl.INTERNAL_WEB_SERVICE_FAULT_CATCH); 
    createProperty(true, webServiceType,WebServiceImpl.INTERNAL_ANY); 
    createProperty(true, webServiceType,WebServiceImpl.INTERNAL_INPUT_MSG_NAME); 
    createProperty(true, webServiceType,WebServiceImpl.INTERNAL_OUTPUT_MSG_NAME); 
    createProperty(true, webServiceType,WebServiceImpl.INTERNAL_ANY_ATTRIBUTE); 
    webServiceFaultCatchType = createType(false, WEB_SERVICE_FAULT_CATCH);
    createProperty(false, webServiceFaultCatchType,WebServiceFaultCatchImpl.INTERNAL_MESSAGE); 
    createProperty(false, webServiceFaultCatchType,WebServiceFaultCatchImpl.INTERNAL_BLOCK_ACTIVITY); 
    createProperty(false, webServiceFaultCatchType,WebServiceFaultCatchImpl.INTERNAL_TRANSITION_REF); 
    createProperty(true, webServiceFaultCatchType,WebServiceFaultCatchImpl.INTERNAL_ANY); 
    createProperty(true, webServiceFaultCatchType,WebServiceFaultCatchImpl.INTERNAL_FAULT_NAME); 
    createProperty(true, webServiceFaultCatchType,WebServiceFaultCatchImpl.INTERNAL_ANY_ATTRIBUTE); 
    webServiceOperationType = createType(false, WEB_SERVICE_OPERATION);
    createProperty(false, webServiceOperationType,WebServiceOperationImpl.INTERNAL_PARTNER); 
    createProperty(false, webServiceOperationType,WebServiceOperationImpl.INTERNAL_SERVICE); 
    createProperty(true, webServiceOperationType,WebServiceOperationImpl.INTERNAL_ANY); 
    createProperty(true, webServiceOperationType,WebServiceOperationImpl.INTERNAL_OPERATION_NAME); 
    createProperty(true, webServiceOperationType,WebServiceOperationImpl.INTERNAL_ANY_ATTRIBUTE); 
    workflowProcessesType = createType(false, WORKFLOW_PROCESSES);
    createProperty(false, workflowProcessesType,WorkflowProcessesImpl.INTERNAL_WORKFLOW_PROCESS); 
    createProperty(true, workflowProcessesType,WorkflowProcessesImpl.INTERNAL_ANY); 
    createProperty(true, workflowProcessesType,WorkflowProcessesImpl.INTERNAL_ANY_ATTRIBUTE); 
    workingTimeType = createType(false, WORKING_TIME);
    createProperty(true, workingTimeType,WorkingTimeImpl.INTERNAL_VALUE); 
    createProperty(true, workingTimeType,WorkingTimeImpl.INTERNAL_ANY_ATTRIBUTE); 
    xpdlVersionType = createType(false, XPDL_VERSION);
    createProperty(true, xpdlVersionType,XPDLVersionImpl.INTERNAL_VALUE); 
    createProperty(true, xpdlVersionType,XPDLVersionImpl.INTERNAL_ANY_ATTRIBUTE); 
    xsltType = createType(false, XSLT);
    createProperty(true, xsltType,XsltImpl.INTERNAL_ANY); 
    createProperty(true, xsltType,XsltImpl.INTERNAL_LOCATION); 
    createProperty(true, xsltType,XsltImpl.INTERNAL_ANY_ATTRIBUTE); 

    // Create data types
    accessLevelType = createType(true, ACCESS_LEVEL );
    adHocOrderingType = createType(true, AD_HOC_ORDERING );
    adHocOrdering1Type = createType(true, AD_HOC_ORDERING1 );
    artifactTypeType = createType(true, ARTIFACT_TYPE );
    assignTimeType = createType(true, ASSIGN_TIME );
    associationDirectionType = createType(true, ASSOCIATION_DIRECTION );
    directionType = createType(true, DIRECTION );
    durationUnitType = createType(true, DURATION_UNIT );
    endPointTypeType = createType(true, END_POINT_TYPE );
    executionType = createType(true, EXECUTION );
    execution1Type = createType(true, EXECUTION1 );
    finishModeType = createType(true, FINISH_MODE );
    gatewayTypeType = createType(true, GATEWAY_TYPE );
    graphConformanceType = createType(true, GRAPH_CONFORMANCE );
    implementationType = createType(true, IMPLEMENTATION );
    implementation1Type = createType(true, IMPLEMENTATION1 );
    implementation2Type = createType(true, IMPLEMENTATION2 );
    implementation3Type = createType(true, IMPLEMENTATION3 );
    implementation4Type = createType(true, IMPLEMENTATION4 );
    implementation5Type = createType(true, IMPLEMENTATION5 );
    implementation6Type = createType(true, IMPLEMENTATION6 );
    instantiationType = createType(true, INSTANTIATION );
    isArrayType = createType(true, IS_ARRAY );
    loopTypeType = createType(true, LOOP_TYPE );
    mI_FlowConditionType = createType(true, MI_FLOW_CONDITION );
    mI_OrderingType = createType(true, MI_ORDERING );
    modeType = createType(true, MODE );
    orientationType = createType(true, ORIENTATION );
    processTypeType = createType(true, PROCESS_TYPE );
    publicationStatusType = createType(true, PUBLICATION_STATUS );
    resultType = createType(true, RESULT );
    roleTypeType = createType(true, ROLE_TYPE );
    shapeType = createType(true, SHAPE );
    startModeType = createType(true, START_MODE );
    statusType = createType(true, STATUS );
    status1Type = createType(true, STATUS1 );
    testTimeType = createType(true, TEST_TIME );
    transactionMethodType = createType(true, TRANSACTION_METHOD );
    triggerType = createType(true, TRIGGER );
    trigger1Type = createType(true, TRIGGER1 );
    typeType = createType(true, TYPE );
    type1Type = createType(true, TYPE1 );
    type2Type = createType(true, TYPE2 );
    type3Type = createType(true, TYPE3 );
    type4Type = createType(true, TYPE4 );
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    Xpdl1FactoryImpl theXpdl1PackageImpl = (Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE;
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)ModelFactory.INSTANCE;
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    initializeType(activitiesType, Activities.class, "Activities", false);
    property = getLocalProperty(activitiesType, 0);
    initializeProperty(property, this.getActivity(), "Activity", null, 0, -1, Activities.class, false, false, false, true , null);

    property = getLocalProperty(activitiesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Activities.class, false, false, false);

    property = getLocalProperty(activitiesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Activities.class, false, false, false);

    initializeType(activityType, Activity.class, "Activity", false);
    property = getLocalProperty(activityType, 0);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 1);
    initializeProperty(property, this.getLimit(), "Limit", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 2);
    initializeProperty(property, this.getRoute(), "Route", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 3);
    initializeProperty(property, this.getImplementation7(), "Implementation", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 4);
    initializeProperty(property, theXpdl1PackageImpl.getBlockActivity(), "BlockActivity", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 5);
    initializeProperty(property, this.getBlockActivity(), "BlockActivity1", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 6);
    initializeProperty(property, this.getEvent(), "Event", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 7);
    initializeProperty(property, this.getTransaction(), "Transaction", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 8);
    initializeProperty(property, this.getPerformer(), "Performer", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 9);
    initializeProperty(property, this.getPerformers(), "Performers", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 10);
    initializeProperty(property, theXpdl1PackageImpl.getStartMode(), "StartMode", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 11);
    initializeProperty(property, theXpdl1PackageImpl.getFinishMode(), "FinishMode", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 12);
    initializeProperty(property, this.getPriority(), "Priority", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 13);
    initializeProperty(property, theXpdl1PackageImpl.getDeadline(), "Deadline", null, 0, -1, Activity.class, false, false, false, true , null);

    property = getLocalProperty(activityType, 14);
    initializeProperty(property, this.getDeadline(), "Deadline1", null, 0, -1, Activity.class, false, false, false, true , null);

    property = getLocalProperty(activityType, 15);
    initializeProperty(property, this.getSimulationInformation(), "SimulationInformation", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 16);
    initializeProperty(property, this.getIcon(), "Icon", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 17);
    initializeProperty(property, this.getDocumentation(), "Documentation", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 18);
    initializeProperty(property, this.getTransitionRestrictions(), "TransitionRestrictions", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 19);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 20);
    initializeProperty(property, this.getDataFields(), "DataFields", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 21);
    initializeProperty(property, this.getInputSets(), "InputSets", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 22);
    initializeProperty(property, this.getOutputSets(), "OutputSets", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 23);
    initializeProperty(property, this.getIORules(), "IORules", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 24);
    initializeProperty(property, this.getLoop(), "Loop", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 25);
    initializeProperty(property, this.getAssignments(), "Assignments", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 26);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 27);
    initializeProperty(property, this.getNodeGraphicsInfos(), "NodeGraphicsInfos", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 28);
    initializeProperty(property, theModelPackageImpl.getDataObject(), "Extensions", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 29);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Activity.class, false, false, false);

    property = getLocalProperty(activityType, 30);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 31);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 32);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "StartActivity", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 33);
    initializeProperty(property, this.getStatus1(), "Status", "None", 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 34);
    initializeProperty(property, this.getStartMode(), "StartMode1", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 35);
    initializeProperty(property, this.getFinishMode(), "FinishMode1", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 36);
    initializeProperty(property, theModelPackageImpl.getInteger(), "StartQuantity", "1", 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 37);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "IsATransaction", "false", 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 38);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Activity.class, false, false, false);

    initializeType(activitySetType, ActivitySet.class, "ActivitySet", false);
    property = getLocalProperty(activitySetType, 0);
    initializeProperty(property, this.getActivities(), "Activities", null, 0, 1, ActivitySet.class, false, true, false, true , null);

    property = getLocalProperty(activitySetType, 1);
    initializeProperty(property, this.getTransitions(), "Transitions", null, 0, 1, ActivitySet.class, false, true, false, true , null);

    property = getLocalProperty(activitySetType, 2);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, ActivitySet.class, false, true, false, true , null);

    property = getLocalProperty(activitySetType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ActivitySet.class, false, false, false);

    property = getLocalProperty(activitySetType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, ActivitySet.class, false, true, false);

    property = getLocalProperty(activitySetType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, ActivitySet.class, false, true, false);

    property = getLocalProperty(activitySetType, 6);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "AdHoc", "false", 0, 1, ActivitySet.class, false, true, false);

    property = getLocalProperty(activitySetType, 7);
    initializeProperty(property, this.getAdHocOrdering1(), "AdHocOrdering", "Parallel", 0, 1, ActivitySet.class, false, true, false);

    property = getLocalProperty(activitySetType, 8);
    initializeProperty(property, theModelPackageImpl.getString(), "AdHocCompletionCondition", null, 0, 1, ActivitySet.class, false, true, false);

    property = getLocalProperty(activitySetType, 9);
    initializeProperty(property, theModelPackageImpl.getString(), "DefaultStartActivityId", null, 0, 1, ActivitySet.class, false, true, false);

    property = getLocalProperty(activitySetType, 10);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ActivitySet.class, false, false, false);

    initializeType(activitySetsType, ActivitySets.class, "ActivitySets", false);
    property = getLocalProperty(activitySetsType, 0);
    initializeProperty(property, this.getActivitySet(), "ActivitySet", null, 0, -1, ActivitySets.class, false, false, false, true , null);

    property = getLocalProperty(activitySetsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ActivitySets.class, false, false, false);

    property = getLocalProperty(activitySetsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ActivitySets.class, false, false, false);

    initializeType(actualParametersType, ActualParameters.class, "ActualParameters", false);
    property = getLocalProperty(actualParametersType, 0);
    initializeProperty(property, this.getExpressionType(), "ActualParameter", null, 0, -1, ActualParameters.class, false, false, false, true , null);

    property = getLocalProperty(actualParametersType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ActualParameters.class, false, false, false);

    property = getLocalProperty(actualParametersType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ActualParameters.class, false, false, false);

    initializeType(applicationType, Application.class, "Application", false);
    property = getLocalProperty(applicationType, 0);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 1);
    initializeProperty(property, this.getApplicationType(), "Type", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 2);
    initializeProperty(property, this.getFormalParameters(), "FormalParameters", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 3);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 4);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 5);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Application.class, false, false, false);

    property = getLocalProperty(applicationType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Application.class, false, true, false);

    property = getLocalProperty(applicationType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Application.class, false, true, false);

    property = getLocalProperty(applicationType, 8);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Application.class, false, false, false);

    initializeType(applicationsType, Applications.class, "Applications", false);
    property = getLocalProperty(applicationsType, 0);
    initializeProperty(property, this.getApplication(), "Application", null, 0, -1, Applications.class, false, false, false, true , null);

    property = getLocalProperty(applicationsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Applications.class, false, false, false);

    property = getLocalProperty(applicationsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Applications.class, false, false, false);

    initializeType(applicationTypeType, ApplicationType.class, "ApplicationType", false);
    property = getLocalProperty(applicationTypeType, 0);
    initializeProperty(property, this.getEjb(), "Ejb", null, 0, 1, ApplicationType.class, false, true, false, true , null);

    property = getLocalProperty(applicationTypeType, 1);
    initializeProperty(property, this.getPojo(), "Pojo", null, 0, 1, ApplicationType.class, false, true, false, true , null);

    property = getLocalProperty(applicationTypeType, 2);
    initializeProperty(property, this.getXslt(), "Xslt", null, 0, 1, ApplicationType.class, false, true, false, true , null);

    property = getLocalProperty(applicationTypeType, 3);
    initializeProperty(property, this.getScript1(), "Script", null, 0, 1, ApplicationType.class, false, true, false, true , null);

    property = getLocalProperty(applicationTypeType, 4);
    initializeProperty(property, this.getWebService(), "WebService", null, 0, 1, ApplicationType.class, false, true, false, true , null);

    property = getLocalProperty(applicationTypeType, 5);
    initializeProperty(property, this.getBusinessRule(), "BusinessRule", null, 0, 1, ApplicationType.class, false, true, false, true , null);

    property = getLocalProperty(applicationTypeType, 6);
    initializeProperty(property, this.getForm(), "Form", null, 0, 1, ApplicationType.class, false, true, false, true , null);

    property = getLocalProperty(applicationTypeType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ApplicationType.class, false, false, false);

    initializeType(arrayTypeType, ArrayType.class, "ArrayType", false);
    property = getLocalProperty(arrayTypeType, 0);
    initializeProperty(property, this.getBasicType(), "BasicType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 1);
    initializeProperty(property, this.getDeclaredType(), "DeclaredType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 2);
    initializeProperty(property, this.getSchemaType(), "SchemaType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 3);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 4);
    initializeProperty(property, this.getRecordType(), "RecordType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 5);
    initializeProperty(property, this.getUnionType(), "UnionType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 6);
    initializeProperty(property, this.getEnumerationType(), "EnumerationType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 7);
    initializeProperty(property, this.getArrayType(), "ArrayType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 8);
    initializeProperty(property, this.getListType(), "ListType", null, 0, 1, ArrayType.class, false, true, false, true , null);

    property = getLocalProperty(arrayTypeType, 9);
    initializeProperty(property, theModelPackageImpl.getString(), "LowerIndex", null, 1, 1, ArrayType.class, false, true, false);

    property = getLocalProperty(arrayTypeType, 10);
    initializeProperty(property, theModelPackageImpl.getString(), "UpperIndex", null, 1, 1, ArrayType.class, false, true, false);

    property = getLocalProperty(arrayTypeType, 11);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ArrayType.class, false, false, false);

    initializeType(artifactType, Artifact.class, "Artifact", false);
    property = getLocalProperty(artifactType, 0);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, Artifact.class, false, true, false, true , null);

    property = getLocalProperty(artifactType, 1);
    initializeProperty(property, this.getDataObject(), "DataObject", null, 0, 1, Artifact.class, false, true, false, true , null);

    property = getLocalProperty(artifactType, 2);
    initializeProperty(property, this.getNodeGraphicsInfos(), "NodeGraphicsInfos", null, 0, 1, Artifact.class, false, true, false, true , null);

    property = getLocalProperty(artifactType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Artifact.class, false, false, false);

    property = getLocalProperty(artifactType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Artifact.class, false, true, false);

    property = getLocalProperty(artifactType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Artifact.class, false, true, false);

    property = getLocalProperty(artifactType, 6);
    initializeProperty(property, this.getArtifactType(), "ArtifactType", null, 1, 1, Artifact.class, false, true, false);

    property = getLocalProperty(artifactType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "TextAnnotation", null, 0, 1, Artifact.class, false, true, false);

    property = getLocalProperty(artifactType, 8);
    initializeProperty(property, theModelPackageImpl.getString(), "Group", null, 0, 1, Artifact.class, false, true, false);

    property = getLocalProperty(artifactType, 9);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Artifact.class, false, false, false);

    initializeType(artifactsType, Artifacts.class, "Artifacts", false);
    property = getLocalProperty(artifactsType, 0);
    initializeProperty(property, getSequence(), "group", null, 0, -1, Artifacts.class, false, false, false);

    property = getLocalProperty(artifactsType, 1);
    initializeProperty(property, this.getArtifact(), "Artifact", null, 1, -1, Artifacts.class, false, false, true, true , null);

    property = getLocalProperty(artifactsType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Artifacts.class, false, false, true);

    property = getLocalProperty(artifactsType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Artifacts.class, false, false, false);

    initializeType(assignmentType, Assignment.class, "Assignment", false);
    property = getLocalProperty(assignmentType, 0);
    initializeProperty(property, this.getExpressionType(), "Target", null, 1, 1, Assignment.class, false, true, false, true , null);

    property = getLocalProperty(assignmentType, 1);
    initializeProperty(property, this.getExpressionType(), "Expression", null, 1, 1, Assignment.class, false, true, false, true , null);

    property = getLocalProperty(assignmentType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Assignment.class, false, false, false);

    property = getLocalProperty(assignmentType, 3);
    initializeProperty(property, this.getAssignTime(), "AssignTime", "Start", 0, 1, Assignment.class, false, true, false);

    property = getLocalProperty(assignmentType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Assignment.class, false, false, false);

    initializeType(assignmentsType, Assignments.class, "Assignments", false);
    property = getLocalProperty(assignmentsType, 0);
    initializeProperty(property, this.getAssignment(), "Assignment", null, 1, -1, Assignments.class, false, false, false, true , null);

    property = getLocalProperty(assignmentsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Assignments.class, false, false, false);

    property = getLocalProperty(assignmentsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Assignments.class, false, false, false);

    initializeType(associationType, Association.class, "Association", false);
    property = getLocalProperty(associationType, 0);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, Association.class, false, true, false, true , null);

    property = getLocalProperty(associationType, 1);
    initializeProperty(property, this.getConnectorGraphicsInfos(), "ConnectorGraphicsInfos", null, 0, 1, Association.class, false, true, false, true , null);

    property = getLocalProperty(associationType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Association.class, false, false, false);

    property = getLocalProperty(associationType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Association.class, false, true, false);

    property = getLocalProperty(associationType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Source", null, 1, 1, Association.class, false, true, false);

    property = getLocalProperty(associationType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Target", null, 1, 1, Association.class, false, true, false);

    property = getLocalProperty(associationType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Association.class, false, true, false);

    property = getLocalProperty(associationType, 7);
    initializeProperty(property, this.getAssociationDirection(), "AssociationDirection", "None", 0, 1, Association.class, false, true, false);

    property = getLocalProperty(associationType, 8);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Association.class, false, false, false);

    initializeType(associationsType, Associations.class, "Associations", false);
    property = getLocalProperty(associationsType, 0);
    initializeProperty(property, getSequence(), "group", null, 0, -1, Associations.class, false, false, false);

    property = getLocalProperty(associationsType, 1);
    initializeProperty(property, this.getAssociation(), "Association", null, 1, -1, Associations.class, false, false, true, true , null);

    property = getLocalProperty(associationsType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Associations.class, false, false, true);

    property = getLocalProperty(associationsType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Associations.class, false, false, false);

    initializeType(authorType, Author.class, "Author", false);
    property = getLocalProperty(authorType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Author.class, false, true, false);

    property = getLocalProperty(authorType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Author.class, false, false, false);

    initializeType(basicTypeType, BasicType.class, "BasicType", false);
    property = getLocalProperty(basicTypeType, 0);
    initializeProperty(property, this.getLength(), "Length", null, 0, 1, BasicType.class, false, true, false, true , null);

    property = getLocalProperty(basicTypeType, 1);
    initializeProperty(property, this.getPrecision(), "Precision", null, 0, 1, BasicType.class, false, true, false, true , null);

    property = getLocalProperty(basicTypeType, 2);
    initializeProperty(property, this.getScale(), "Scale", null, 0, 1, BasicType.class, false, true, false, true , null);

    property = getLocalProperty(basicTypeType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, BasicType.class, false, false, false);

    property = getLocalProperty(basicTypeType, 4);
    initializeProperty(property, this.getType(), "Type", null, 1, 1, BasicType.class, false, true, false);

    property = getLocalProperty(basicTypeType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, BasicType.class, false, false, false);

    initializeType(blockActivityType, BlockActivity.class, "BlockActivity", false);
    property = getLocalProperty(blockActivityType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, BlockActivity.class, false, false, false);

    property = getLocalProperty(blockActivityType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "ActivitySetId", null, 1, 1, BlockActivity.class, false, true, false);

    property = getLocalProperty(blockActivityType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "StartActivityId", null, 0, 1, BlockActivity.class, false, true, false);

    property = getLocalProperty(blockActivityType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, BlockActivity.class, false, false, false);

    initializeType(businessRuleType, BusinessRule.class, "BusinessRule", false);
    property = getLocalProperty(businessRuleType, 0);
    initializeProperty(property, this.getRuleName(), "RuleName", null, 1, 1, BusinessRule.class, false, true, false, true , null);

    property = getLocalProperty(businessRuleType, 1);
    initializeProperty(property, this.getLocation(), "Location", null, 1, 1, BusinessRule.class, false, true, false, true , null);

    property = getLocalProperty(businessRuleType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, BusinessRule.class, false, false, false);

    property = getLocalProperty(businessRuleType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, BusinessRule.class, false, false, false);

    initializeType(categoriesType, Categories.class, "Categories", false);
    property = getLocalProperty(categoriesType, 0);
    initializeProperty(property, this.getCategory(), "Category", null, 1, -1, Categories.class, false, false, false, true , null);

    property = getLocalProperty(categoriesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Categories.class, false, false, false);

    property = getLocalProperty(categoriesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Categories.class, false, false, false);

    initializeType(categoryType, Category.class, "Category", false);
    property = getLocalProperty(categoryType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Category.class, false, false, false);

    property = getLocalProperty(categoryType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Category.class, false, true, false);

    property = getLocalProperty(categoryType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Category.class, false, true, false);

    property = getLocalProperty(categoryType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Category.class, false, false, false);

    initializeType(class_Type, net.smartworks.server.engine.process.xpdl.xpdl2.Class.class, "Class", false);
    property = getLocalProperty(class_Type, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl2.Class.class, false, true, false);

    property = getLocalProperty(class_Type, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, net.smartworks.server.engine.process.xpdl.xpdl2.Class.class, false, false, false);

    initializeType(codepageType, Codepage.class, "Codepage", false);
    property = getLocalProperty(codepageType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Codepage.class, false, true, false);

    property = getLocalProperty(codepageType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Codepage.class, false, false, false);

    initializeType(conditionType, Condition.class, "Condition", false);
    property = getLocalProperty(conditionType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, Condition.class, false, false, false);

    property = getLocalProperty(conditionType, 1);
    initializeProperty(property, theXpdl1PackageImpl.getXpression(), "Xpression", null, 0, 1, Condition.class, false, true, true, true , null);

    property = getLocalProperty(conditionType, 2);
    initializeProperty(property, this.getExpressionType(), "Expression", null, 0, 1, Condition.class, false, true, true, true , null);

    property = getLocalProperty(conditionType, 3);
    initializeProperty(property, this.getType1(), "Type", null, 0, 1, Condition.class, false, true, false);

    property = getLocalProperty(conditionType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Condition.class, false, false, false);

    initializeType(conformanceClassType, ConformanceClass.class, "ConformanceClass", false);
    property = getLocalProperty(conformanceClassType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ConformanceClass.class, false, false, false);

    property = getLocalProperty(conformanceClassType, 1);
    initializeProperty(property, this.getGraphConformance(), "GraphConformance", "NON_BLOCKED", 0, 1, ConformanceClass.class, false, true, false);

    property = getLocalProperty(conformanceClassType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ConformanceClass.class, false, false, false);

    initializeType(connectorGraphicsInfoType, ConnectorGraphicsInfo.class, "ConnectorGraphicsInfo", false);
    property = getLocalProperty(connectorGraphicsInfoType, 0);
    initializeProperty(property, this.getCoordinates(), "Coordinates", null, 0, -1, ConnectorGraphicsInfo.class, false, false, false, true , null);

    property = getLocalProperty(connectorGraphicsInfoType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ConnectorGraphicsInfo.class, false, false, false);

    property = getLocalProperty(connectorGraphicsInfoType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "ToolId", null, 0, 1, ConnectorGraphicsInfo.class, false, true, false);

    property = getLocalProperty(connectorGraphicsInfoType, 3);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "IsVisible", "true", 0, 1, ConnectorGraphicsInfo.class, false, true, false);

    property = getLocalProperty(connectorGraphicsInfoType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Page", null, 0, 1, ConnectorGraphicsInfo.class, false, true, false);

    property = getLocalProperty(connectorGraphicsInfoType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Style", null, 0, 1, ConnectorGraphicsInfo.class, false, true, false);

    property = getLocalProperty(connectorGraphicsInfoType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "BorderColor", null, 0, 1, ConnectorGraphicsInfo.class, false, true, false);

    property = getLocalProperty(connectorGraphicsInfoType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "FillColor", null, 0, 1, ConnectorGraphicsInfo.class, false, true, false);

    property = getLocalProperty(connectorGraphicsInfoType, 8);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ConnectorGraphicsInfo.class, false, false, false);

    initializeType(connectorGraphicsInfosType, ConnectorGraphicsInfos.class, "ConnectorGraphicsInfos", false);
    property = getLocalProperty(connectorGraphicsInfosType, 0);
    initializeProperty(property, this.getConnectorGraphicsInfo(), "ConnectorGraphicsInfo", null, 0, -1, ConnectorGraphicsInfos.class, false, false, false, true , null);

    property = getLocalProperty(connectorGraphicsInfosType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ConnectorGraphicsInfos.class, false, false, false);

    property = getLocalProperty(connectorGraphicsInfosType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ConnectorGraphicsInfos.class, false, false, false);

    initializeType(coordinatesType, Coordinates.class, "Coordinates", false);
    property = getLocalProperty(coordinatesType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Coordinates.class, false, false, false);

    property = getLocalProperty(coordinatesType, 1);
    initializeProperty(property, theModelPackageImpl.getDouble(), "XCoordinate", null, 0, 1, Coordinates.class, false, true, false);

    property = getLocalProperty(coordinatesType, 2);
    initializeProperty(property, theModelPackageImpl.getDouble(), "YCoordinate", null, 0, 1, Coordinates.class, false, true, false);

    property = getLocalProperty(coordinatesType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Coordinates.class, false, false, false);

    initializeType(costType, Cost.class, "Cost", false);
    property = getLocalProperty(costType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Cost.class, false, true, false);

    property = getLocalProperty(costType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Cost.class, false, false, false);

    initializeType(costUnitType, CostUnit.class, "CostUnit", false);
    property = getLocalProperty(costUnitType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, CostUnit.class, false, true, false);

    property = getLocalProperty(costUnitType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, CostUnit.class, false, false, false);

    initializeType(countrykeyType, Countrykey.class, "Countrykey", false);
    property = getLocalProperty(countrykeyType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Countrykey.class, false, true, false);

    property = getLocalProperty(countrykeyType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Countrykey.class, false, false, false);

    initializeType(createdType, Created.class, "Created", false);
    property = getLocalProperty(createdType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Created.class, false, true, false);

    property = getLocalProperty(createdType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Created.class, false, false, false);

    initializeType(dataFieldType, DataField.class, "DataField", false);
    property = getLocalProperty(dataFieldType, 0);
    initializeProperty(property, this.getDataType(), "DataType", null, 1, 1, DataField.class, false, true, false, true , null);

    property = getLocalProperty(dataFieldType, 1);
    initializeProperty(property, this.getExpressionType(), "InitialValue", null, 0, 1, DataField.class, false, true, false, true , null);

    property = getLocalProperty(dataFieldType, 2);
    initializeProperty(property, this.getLength(), "Length", null, 0, 1, DataField.class, false, true, false, true , null);

    property = getLocalProperty(dataFieldType, 3);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, DataField.class, false, true, false, true , null);

    property = getLocalProperty(dataFieldType, 4);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, DataField.class, false, true, false, true , null);

    property = getLocalProperty(dataFieldType, 5);
    initializeProperty(property, getSequence(), "any", null, 0, -1, DataField.class, false, false, false);

    property = getLocalProperty(dataFieldType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 8);
    initializeProperty(property, this.getIsArray(), "IsArray", "FALSE", 0, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 9);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "Correlation", "false", 0, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 10);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, DataField.class, false, false, false);

    initializeType(dataFieldsType, DataFields.class, "DataFields", false);
    property = getLocalProperty(dataFieldsType, 0);
    initializeProperty(property, this.getDataField(), "DataField", null, 0, -1, DataFields.class, false, false, false, true , null);

    property = getLocalProperty(dataFieldsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, DataFields.class, false, false, false);

    property = getLocalProperty(dataFieldsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, DataFields.class, false, false, false);

    initializeType(dataMappingType, DataMapping.class, "DataMapping", false);
    property = getLocalProperty(dataMappingType, 0);
    initializeProperty(property, this.getExpressionType(), "Actual", null, 1, 1, DataMapping.class, false, true, false, true , null);

    property = getLocalProperty(dataMappingType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, DataMapping.class, false, false, false);

    property = getLocalProperty(dataMappingType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Formal", null, 1, 1, DataMapping.class, false, true, false);

    property = getLocalProperty(dataMappingType, 3);
    initializeProperty(property, this.getDirection(), "Direction", "IN", 0, 1, DataMapping.class, false, true, false);

    property = getLocalProperty(dataMappingType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, DataMapping.class, false, false, false);

    initializeType(dataMappingsType, DataMappings.class, "DataMappings", false);
    property = getLocalProperty(dataMappingsType, 0);
    initializeProperty(property, this.getDataMapping(), "DataMapping", null, 0, -1, DataMappings.class, false, false, false, true , null);

    property = getLocalProperty(dataMappingsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, DataMappings.class, false, false, false);

    property = getLocalProperty(dataMappingsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, DataMappings.class, false, false, false);

    initializeType(dataObjectType, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, "DataObject", false);
    property = getLocalProperty(dataObjectType, 0);
    initializeProperty(property, this.getDataFields(), "DataFields", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, true, false, true , null);

    property = getLocalProperty(dataObjectType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, false, false);

    property = getLocalProperty(dataObjectType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, true, false);

    property = getLocalProperty(dataObjectType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, true, false);

    property = getLocalProperty(dataObjectType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "State", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, true, false);

    property = getLocalProperty(dataObjectType, 5);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "RequiredForStart", null, 1, 1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, true, false);

    property = getLocalProperty(dataObjectType, 6);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "ProducedAtCompletion", null, 1, 1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, true, false);

    property = getLocalProperty(dataObjectType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, net.smartworks.server.engine.process.xpdl.xpdl2.DataObject.class, false, false, false);

    initializeType(dataTypeType, DataType.class, "DataType", false);
    property = getLocalProperty(dataTypeType, 0);
    initializeProperty(property, this.getBasicType(), "BasicType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 1);
    initializeProperty(property, this.getDeclaredType(), "DeclaredType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 2);
    initializeProperty(property, this.getSchemaType(), "SchemaType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 3);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 4);
    initializeProperty(property, this.getRecordType(), "RecordType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 5);
    initializeProperty(property, this.getUnionType(), "UnionType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 6);
    initializeProperty(property, this.getEnumerationType(), "EnumerationType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 7);
    initializeProperty(property, this.getArrayType(), "ArrayType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 8);
    initializeProperty(property, this.getListType(), "ListType", null, 0, 1, DataType.class, false, true, false, true , null);

    property = getLocalProperty(dataTypeType, 9);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, DataType.class, false, false, false);

    initializeType(deadlineType, Deadline.class, "Deadline", false);
    property = getLocalProperty(deadlineType, 0);
    initializeProperty(property, this.getExpressionType(), "DeadlineDuration", null, 0, 1, Deadline.class, false, true, false, true , null);

    property = getLocalProperty(deadlineType, 1);
    initializeProperty(property, this.getExceptionName(), "ExceptionName", null, 0, 1, Deadline.class, false, true, false, true , null);

    property = getLocalProperty(deadlineType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Deadline.class, false, false, false);

    property = getLocalProperty(deadlineType, 3);
    initializeProperty(property, this.getExecution(), "Execution", null, 0, 1, Deadline.class, false, true, false);

    property = getLocalProperty(deadlineType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Deadline.class, false, false, false);

    initializeType(declaredTypeType, DeclaredType.class, "DeclaredType", false);
    property = getLocalProperty(declaredTypeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, DeclaredType.class, false, false, false);

    property = getLocalProperty(declaredTypeType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, DeclaredType.class, false, true, false);

    property = getLocalProperty(declaredTypeType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, DeclaredType.class, false, true, false);

    property = getLocalProperty(declaredTypeType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, DeclaredType.class, false, false, false);

    initializeType(descriptionType, Description.class, "Description", false);
    property = getLocalProperty(descriptionType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Description.class, false, true, false);

    property = getLocalProperty(descriptionType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Description.class, false, false, false);

    initializeType(documentationType, Documentation.class, "Documentation", false);
    property = getLocalProperty(documentationType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Documentation.class, false, true, false);

    property = getLocalProperty(documentationType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Documentation.class, false, false, false);

    initializeType(durationType, Duration.class, "Duration", false);
    property = getLocalProperty(durationType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Duration.class, false, true, false);

    property = getLocalProperty(durationType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Duration.class, false, false, false);

    initializeType(ejbType, Ejb.class, "Ejb", false);
    property = getLocalProperty(ejbType, 0);
    initializeProperty(property, this.getJndiName(), "JndiName", null, 1, 1, Ejb.class, false, true, false, true , null);

    property = getLocalProperty(ejbType, 1);
    initializeProperty(property, this.getHomeClass(), "HomeClass", null, 1, 1, Ejb.class, false, true, false, true , null);

    property = getLocalProperty(ejbType, 2);
    initializeProperty(property, this.getMethod1(), "Method", null, 1, 1, Ejb.class, false, true, false, true , null);

    property = getLocalProperty(ejbType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Ejb.class, false, false, false);

    property = getLocalProperty(ejbType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Ejb.class, false, false, false);

    initializeType(endEventType, EndEvent.class, "EndEvent", false);
    property = getLocalProperty(endEventType, 0);
    initializeProperty(property, this.getTriggerResultMessage(), "TriggerResultMessage", null, 0, 1, EndEvent.class, false, true, false, true , null);

    property = getLocalProperty(endEventType, 1);
    initializeProperty(property, this.getResultError(), "ResultError", null, 0, 1, EndEvent.class, false, true, false, true , null);

    property = getLocalProperty(endEventType, 2);
    initializeProperty(property, this.getResultCompensation(), "ResultCompensation", null, 0, 1, EndEvent.class, false, true, false, true , null);

    property = getLocalProperty(endEventType, 3);
    initializeProperty(property, this.getTriggerResultLink(), "TriggerResultLink", null, 0, 1, EndEvent.class, false, true, false, true , null);

    property = getLocalProperty(endEventType, 4);
    initializeProperty(property, this.getResultMultiple(), "ResultMultiple", null, 0, 1, EndEvent.class, false, true, false, true , null);

    property = getLocalProperty(endEventType, 5);
    initializeProperty(property, this.getResult(), "Result", "None", 0, 1, EndEvent.class, false, true, false);

    property = getLocalProperty(endEventType, 6);
    initializeProperty(property, this.getImplementation5(), "Implementation", "WebService", 0, 1, EndEvent.class, false, true, false);

    property = getLocalProperty(endEventType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, EndEvent.class, false, false, false);

    initializeType(endPointType, EndPoint.class, "EndPoint", false);
    property = getLocalProperty(endPointType, 0);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 1, 1, EndPoint.class, false, true, false, true , null);

    property = getLocalProperty(endPointType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, EndPoint.class, false, false, false);

    property = getLocalProperty(endPointType, 2);
    initializeProperty(property, this.getEndPointType(), "EndPointType", "WSDL", 0, 1, EndPoint.class, false, true, false);

    property = getLocalProperty(endPointType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, EndPoint.class, false, false, false);

    initializeType(enumerationTypeType, EnumerationType.class, "EnumerationType", false);
    property = getLocalProperty(enumerationTypeType, 0);
    initializeProperty(property, this.getEnumerationValue(), "EnumerationValue", null, 1, -1, EnumerationType.class, false, false, false, true , null);

    property = getLocalProperty(enumerationTypeType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, EnumerationType.class, false, false, false);

    property = getLocalProperty(enumerationTypeType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, EnumerationType.class, false, false, false);

    initializeType(enumerationValueType, EnumerationValue.class, "EnumerationValue", false);
    property = getLocalProperty(enumerationValueType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, EnumerationValue.class, false, false, false);

    property = getLocalProperty(enumerationValueType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 1, 1, EnumerationValue.class, false, true, false);

    property = getLocalProperty(enumerationValueType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, EnumerationValue.class, false, false, false);

    initializeType(eventType, Event.class, "Event", false);
    property = getLocalProperty(eventType, 0);
    initializeProperty(property, this.getStartEvent(), "StartEvent", null, 0, 1, Event.class, false, true, false, true , null);

    property = getLocalProperty(eventType, 1);
    initializeProperty(property, this.getIntermediateEvent(), "IntermediateEvent", null, 0, 1, Event.class, false, true, false, true , null);

    property = getLocalProperty(eventType, 2);
    initializeProperty(property, this.getEndEvent(), "EndEvent", null, 0, 1, Event.class, false, true, false, true , null);

    property = getLocalProperty(eventType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Event.class, false, false, false);

    initializeType(exceptionNameType, ExceptionName.class, "ExceptionName", false);
    property = getLocalProperty(exceptionNameType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, ExceptionName.class, false, true, false);

    property = getLocalProperty(exceptionNameType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ExceptionName.class, false, false, false);

    initializeType(expressionTypeType, ExpressionType.class, "ExpressionType", false);
    property = getLocalProperty(expressionTypeType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, ExpressionType.class, false, false, false);

    property = getLocalProperty(expressionTypeType, 1);
    initializeProperty(property, getSequence(), "group", null, 0, -1, ExpressionType.class, false, false, true);

    property = getLocalProperty(expressionTypeType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ExpressionType.class, false, false, true);

    property = getLocalProperty(expressionTypeType, 3);
    initializeProperty(property, theModelPackageImpl.getURI(), "ScriptGrammar", null, 0, 1, ExpressionType.class, false, true, false);

    property = getLocalProperty(expressionTypeType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ExpressionType.class, false, false, false);

    initializeType(extendedAttributeType, ExtendedAttribute.class, "ExtendedAttribute", false);
    property = getLocalProperty(extendedAttributeType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, ExtendedAttribute.class, false, false, false);

    property = getLocalProperty(extendedAttributeType, 1);
    initializeProperty(property, getSequence(), "group", null, 0, -1, ExtendedAttribute.class, false, false, true);

    property = getLocalProperty(extendedAttributeType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ExtendedAttribute.class, false, false, true);

    property = getLocalProperty(extendedAttributeType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 1, 1, ExtendedAttribute.class, false, true, false);

    property = getLocalProperty(extendedAttributeType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Value", null, 0, 1, ExtendedAttribute.class, false, true, false);

    initializeType(extendedAttributesType, ExtendedAttributes.class, "ExtendedAttributes", false);
    property = getLocalProperty(extendedAttributesType, 0);
    initializeProperty(property, this.getExtendedAttribute(), "ExtendedAttribute", null, 0, -1, ExtendedAttributes.class, false, false, false, true , null);

    initializeType(externalPackageType, ExternalPackage.class, "ExternalPackage", false);
    property = getLocalProperty(externalPackageType, 0);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, ExternalPackage.class, false, true, false, true , null);

    property = getLocalProperty(externalPackageType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ExternalPackage.class, false, false, false);

    property = getLocalProperty(externalPackageType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "href", null, 0, 1, ExternalPackage.class, false, true, false);

    property = getLocalProperty(externalPackageType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 0, 1, ExternalPackage.class, false, true, false);

    property = getLocalProperty(externalPackageType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, ExternalPackage.class, false, true, false);

    property = getLocalProperty(externalPackageType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ExternalPackage.class, false, false, false);

    initializeType(externalPackagesType, ExternalPackages.class, "ExternalPackages", false);
    property = getLocalProperty(externalPackagesType, 0);
    initializeProperty(property, this.getExternalPackage(), "ExternalPackage", null, 0, -1, ExternalPackages.class, false, false, false, true , null);

    property = getLocalProperty(externalPackagesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ExternalPackages.class, false, false, false);

    property = getLocalProperty(externalPackagesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ExternalPackages.class, false, false, false);

    initializeType(externalReferenceType, ExternalReference.class, "ExternalReference", false);
    property = getLocalProperty(externalReferenceType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ExternalReference.class, false, false, false);

    property = getLocalProperty(externalReferenceType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "xref", null, 0, 1, ExternalReference.class, false, true, false);

    property = getLocalProperty(externalReferenceType, 2);
    initializeProperty(property, theModelPackageImpl.getURI(), "location", null, 1, 1, ExternalReference.class, false, true, false);

    property = getLocalProperty(externalReferenceType, 3);
    initializeProperty(property, theModelPackageImpl.getURI(), "namespace", null, 0, 1, ExternalReference.class, false, true, false);

    property = getLocalProperty(externalReferenceType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ExternalReference.class, false, false, false);

    initializeType(formType, Form.class, "Form", false);
    property = getLocalProperty(formType, 0);
    initializeProperty(property, this.getFormLayout(), "FormLayout", null, 0, 1, Form.class, false, true, false, true , null);

    property = getLocalProperty(formType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Form.class, false, false, false);

    property = getLocalProperty(formType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Form.class, false, false, false);

    initializeType(formalParameterType, FormalParameter.class, "FormalParameter", false);
    property = getLocalProperty(formalParameterType, 0);
    initializeProperty(property, this.getDataType(), "DataType", null, 1, 1, FormalParameter.class, false, true, false, true , null);

    property = getLocalProperty(formalParameterType, 1);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, FormalParameter.class, false, true, false, true , null);

    property = getLocalProperty(formalParameterType, 2);
    initializeProperty(property, this.getLength(), "Length", null, 0, 1, FormalParameter.class, false, true, false, true , null);

    property = getLocalProperty(formalParameterType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, FormalParameter.class, false, false, false);

    property = getLocalProperty(formalParameterType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, FormalParameter.class, false, true, false);

    property = getLocalProperty(formalParameterType, 5);
    initializeProperty(property, this.getMode(), "Mode", "IN", 0, 1, FormalParameter.class, false, true, false);

    property = getLocalProperty(formalParameterType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, FormalParameter.class, false, true, false);

    property = getLocalProperty(formalParameterType, 7);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "IsArray", "false", 0, 1, FormalParameter.class, false, true, false);

    property = getLocalProperty(formalParameterType, 8);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, FormalParameter.class, false, false, false);

    initializeType(formalParametersType, FormalParameters.class, "FormalParameters", false);
    property = getLocalProperty(formalParametersType, 0);
    initializeProperty(property, theXpdl1PackageImpl.getFormalParameter(), "FormalParameter", null, 0, -1, FormalParameters.class, false, false, false, true , null);

    property = getLocalProperty(formalParametersType, 1);
    initializeProperty(property, this.getFormalParameter(), "FormalParameter1", null, 0, -1, FormalParameters.class, false, false, false, true , null);

    property = getLocalProperty(formalParametersType, 2);
    initializeProperty(property, theModelPackageImpl.getDataObject(), "Extensions", null, 0, 1, FormalParameters.class, false, true, false, true , null);

    property = getLocalProperty(formalParametersType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, FormalParameters.class, false, false, false);

    property = getLocalProperty(formalParametersType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, FormalParameters.class, false, false, false);

    initializeType(formLayoutType, FormLayout.class, "FormLayout", false);
    property = getLocalProperty(formLayoutType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, FormLayout.class, false, false, false);

    initializeType(homeClassType, HomeClass.class, "HomeClass", false);
    property = getLocalProperty(homeClassType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, HomeClass.class, false, true, false);

    property = getLocalProperty(homeClassType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, HomeClass.class, false, false, false);

    initializeType(iconType, Icon.class, "Icon", false);
    property = getLocalProperty(iconType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Icon.class, false, true, false);

    property = getLocalProperty(iconType, 1);
    initializeProperty(property, theModelPackageImpl.getInteger(), "XCOORD", null, 0, 1, Icon.class, false, true, false);

    property = getLocalProperty(iconType, 2);
    initializeProperty(property, theModelPackageImpl.getInteger(), "YCOORD", null, 0, 1, Icon.class, false, true, false);

    property = getLocalProperty(iconType, 3);
    initializeProperty(property, theModelPackageImpl.getInteger(), "WIDTH", null, 0, 1, Icon.class, false, true, false);

    property = getLocalProperty(iconType, 4);
    initializeProperty(property, theModelPackageImpl.getInteger(), "HEIGHT", null, 0, 1, Icon.class, false, true, false);

    property = getLocalProperty(iconType, 5);
    initializeProperty(property, this.getSHAPE(), "SHAPE", "RoundRectangle", 0, 1, Icon.class, false, true, false);

    property = getLocalProperty(iconType, 6);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Icon.class, false, false, false);

    initializeType(implementation7Type, Implementation7.class, "Implementation7", false);
    property = getLocalProperty(implementation7Type, 0);
    initializeProperty(property, this.getNo(), "No", null, 0, 1, Implementation7.class, false, true, false, true , null);

    property = getLocalProperty(implementation7Type, 1);
    initializeProperty(property, theXpdl1PackageImpl.getTool(), "Tool", null, 0, -1, Implementation7.class, false, false, false, true , null);

    property = getLocalProperty(implementation7Type, 2);
    initializeProperty(property, this.getTask(), "Task", null, 0, 1, Implementation7.class, false, true, false, true , null);

    property = getLocalProperty(implementation7Type, 3);
    initializeProperty(property, this.getSubFlow(), "SubFlow", null, 0, 1, Implementation7.class, false, true, false, true , null);

    property = getLocalProperty(implementation7Type, 4);
    initializeProperty(property, this.getReference(), "Reference", null, 0, 1, Implementation7.class, false, true, false, true , null);

    property = getLocalProperty(implementation7Type, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Implementation7.class, false, false, false);

    initializeType(inputType, Input.class, "Input", false);
    property = getLocalProperty(inputType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Input.class, false, false, false);

    property = getLocalProperty(inputType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "ArtifactId", null, 1, 1, Input.class, false, true, false);

    property = getLocalProperty(inputType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Input.class, false, false, false);

    initializeType(inputSetType, InputSet.class, "InputSet", false);
    property = getLocalProperty(inputSetType, 0);
    initializeProperty(property, this.getInput(), "Input", null, 1, -1, InputSet.class, false, false, false, true , null);

    property = getLocalProperty(inputSetType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, InputSet.class, false, false, false);

    property = getLocalProperty(inputSetType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, InputSet.class, false, false, false);

    initializeType(inputSetsType, InputSets.class, "InputSets", false);
    property = getLocalProperty(inputSetsType, 0);
    initializeProperty(property, this.getInputSet(), "InputSet", null, 1, -1, InputSets.class, false, false, false, true , null);

    property = getLocalProperty(inputSetsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, InputSets.class, false, false, false);

    property = getLocalProperty(inputSetsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, InputSets.class, false, false, false);

    initializeType(intermediateEventType, IntermediateEvent.class, "IntermediateEvent", false);
    property = getLocalProperty(intermediateEventType, 0);
    initializeProperty(property, this.getTriggerResultMessage(), "TriggerResultMessage", null, 0, 1, IntermediateEvent.class, false, true, false, true , null);

    property = getLocalProperty(intermediateEventType, 1);
    initializeProperty(property, this.getTriggerTimer(), "TriggerTimer", null, 0, 1, IntermediateEvent.class, false, true, false, true , null);

    property = getLocalProperty(intermediateEventType, 2);
    initializeProperty(property, this.getResultError(), "ResultError", null, 0, 1, IntermediateEvent.class, false, true, false, true , null);

    property = getLocalProperty(intermediateEventType, 3);
    initializeProperty(property, this.getResultCompensation(), "ResultCompensation", null, 0, 1, IntermediateEvent.class, false, true, false, true , null);

    property = getLocalProperty(intermediateEventType, 4);
    initializeProperty(property, this.getTriggerRule(), "TriggerRule", null, 0, 1, IntermediateEvent.class, false, true, false, true , null);

    property = getLocalProperty(intermediateEventType, 5);
    initializeProperty(property, this.getTriggerResultLink(), "TriggerResultLink", null, 0, 1, IntermediateEvent.class, false, true, false, true , null);

    property = getLocalProperty(intermediateEventType, 6);
    initializeProperty(property, this.getTriggerIntermediateMultiple(), "TriggerIntermediateMultiple", null, 0, 1, IntermediateEvent.class, false, true, false, true , null);

    property = getLocalProperty(intermediateEventType, 7);
    initializeProperty(property, this.getTrigger(), "Trigger", null, 1, 1, IntermediateEvent.class, false, true, false);

    property = getLocalProperty(intermediateEventType, 8);
    initializeProperty(property, this.getImplementation4(), "Implementation", "WebService", 0, 1, IntermediateEvent.class, false, true, false);

    property = getLocalProperty(intermediateEventType, 9);
    initializeProperty(property, theModelPackageImpl.getString(), "Target", null, 0, 1, IntermediateEvent.class, false, true, false);

    property = getLocalProperty(intermediateEventType, 10);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, IntermediateEvent.class, false, false, false);

    initializeType(ioRulesType, IORules.class, "IORules", false);
    property = getLocalProperty(ioRulesType, 0);
    initializeProperty(property, this.getExpressionType(), "Expression", null, 1, -1, IORules.class, false, false, false, true , null);

    property = getLocalProperty(ioRulesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, IORules.class, false, false, false);

    property = getLocalProperty(ioRulesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, IORules.class, false, false, false);

    initializeType(jndiNameType, JndiName.class, "JndiName", false);
    property = getLocalProperty(jndiNameType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, JndiName.class, false, true, false);

    property = getLocalProperty(jndiNameType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, JndiName.class, false, false, false);

    initializeType(joinType, Join.class, "Join", false);
    property = getLocalProperty(joinType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Join.class, false, false, false);

    property = getLocalProperty(joinType, 1);
    initializeProperty(property, this.getType4(), "Type", null, 0, 1, Join.class, false, true, false);

    property = getLocalProperty(joinType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "IncomingCondtion", null, 0, 1, Join.class, false, true, false);

    property = getLocalProperty(joinType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Join.class, false, false, false);

    initializeType(laneType, Lane.class, "Lane", false);
    property = getLocalProperty(laneType, 0);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, Lane.class, false, true, false, true , null);

    property = getLocalProperty(laneType, 1);
    initializeProperty(property, this.getNodeGraphicsInfos(), "NodeGraphicsInfos", null, 0, 1, Lane.class, false, true, false, true , null);

    property = getLocalProperty(laneType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Lane.class, false, false, false);

    property = getLocalProperty(laneType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Lane.class, false, true, false);

    property = getLocalProperty(laneType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Lane.class, false, true, false);

    property = getLocalProperty(laneType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "ParentLane", null, 0, 1, Lane.class, false, true, false);

    property = getLocalProperty(laneType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "ParentPool", null, 0, 1, Lane.class, false, true, false);

    property = getLocalProperty(laneType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Lane.class, false, false, false);

    initializeType(lanesType, Lanes.class, "Lanes", false);
    property = getLocalProperty(lanesType, 0);
    initializeProperty(property, this.getLane(), "Lane", null, 0, -1, Lanes.class, false, false, false, true , null);

    property = getLocalProperty(lanesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Lanes.class, false, false, false);

    property = getLocalProperty(lanesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Lanes.class, false, false, false);

    initializeType(lengthType, Length.class, "Length", false);
    property = getLocalProperty(lengthType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Length.class, false, true, false);

    property = getLocalProperty(lengthType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Length.class, false, false, false);

    initializeType(limitType, Limit.class, "Limit", false);
    property = getLocalProperty(limitType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Limit.class, false, true, false);

    property = getLocalProperty(limitType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Limit.class, false, false, false);

    initializeType(listTypeType, ListType.class, "ListType", false);
    property = getLocalProperty(listTypeType, 0);
    initializeProperty(property, this.getBasicType(), "BasicType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 1);
    initializeProperty(property, this.getDeclaredType(), "DeclaredType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 2);
    initializeProperty(property, this.getSchemaType(), "SchemaType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 3);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 4);
    initializeProperty(property, this.getRecordType(), "RecordType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 5);
    initializeProperty(property, this.getUnionType(), "UnionType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 6);
    initializeProperty(property, this.getEnumerationType(), "EnumerationType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 7);
    initializeProperty(property, this.getArrayType(), "ArrayType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 8);
    initializeProperty(property, this.getListType(), "ListType", null, 0, 1, ListType.class, false, true, false, true , null);

    property = getLocalProperty(listTypeType, 9);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ListType.class, false, false, false);

    initializeType(locationType, Location.class, "Location", false);
    property = getLocalProperty(locationType, 0);
    initializeProperty(property, theModelPackageImpl.getURI(), "value", null, 0, 1, Location.class, false, true, false);

    property = getLocalProperty(locationType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Location.class, false, false, false);

    initializeType(loopType, Loop.class, "Loop", false);
    property = getLocalProperty(loopType, 0);
    initializeProperty(property, this.getLoopStandard(), "LoopStandard", null, 0, 1, Loop.class, false, true, false, true , null);

    property = getLocalProperty(loopType, 1);
    initializeProperty(property, this.getLoopMultiInstance(), "LoopMultiInstance", null, 0, 1, Loop.class, false, true, false, true , null);

    property = getLocalProperty(loopType, 2);
    initializeProperty(property, this.getLoopType(), "LoopType", null, 1, 1, Loop.class, false, true, false);

    property = getLocalProperty(loopType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Loop.class, false, false, false);

    initializeType(loopMultiInstanceType, LoopMultiInstance.class, "LoopMultiInstance", false);
    property = getLocalProperty(loopMultiInstanceType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, LoopMultiInstance.class, false, false, false);

    property = getLocalProperty(loopMultiInstanceType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "MI_Condition", null, 1, 1, LoopMultiInstance.class, false, true, false);

    property = getLocalProperty(loopMultiInstanceType, 2);
    initializeProperty(property, theModelPackageImpl.getInteger(), "LoopCounter", null, 0, 1, LoopMultiInstance.class, false, true, false);

    property = getLocalProperty(loopMultiInstanceType, 3);
    initializeProperty(property, this.getMI_Ordering(), "MI_Ordering", null, 1, 1, LoopMultiInstance.class, false, true, false);

    property = getLocalProperty(loopMultiInstanceType, 4);
    initializeProperty(property, this.getMI_FlowCondition(), "MI_FlowCondition", "All", 0, 1, LoopMultiInstance.class, false, true, false);

    property = getLocalProperty(loopMultiInstanceType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "ComplexMI_FlowCondition", null, 0, 1, LoopMultiInstance.class, false, true, false);

    property = getLocalProperty(loopMultiInstanceType, 6);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, LoopMultiInstance.class, false, false, false);

    initializeType(loopStandardType, LoopStandard.class, "LoopStandard", false);
    property = getLocalProperty(loopStandardType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, LoopStandard.class, false, false, false);

    property = getLocalProperty(loopStandardType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "LoopCondition", null, 1, 1, LoopStandard.class, false, true, false);

    property = getLocalProperty(loopStandardType, 2);
    initializeProperty(property, theModelPackageImpl.getInteger(), "LoopCounter", null, 0, 1, LoopStandard.class, false, true, false);

    property = getLocalProperty(loopStandardType, 3);
    initializeProperty(property, theModelPackageImpl.getInteger(), "LoopMaximum", null, 0, 1, LoopStandard.class, false, true, false);

    property = getLocalProperty(loopStandardType, 4);
    initializeProperty(property, this.getTestTime(), "TestTime", null, 1, 1, LoopStandard.class, false, true, false);

    property = getLocalProperty(loopStandardType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, LoopStandard.class, false, false, false);

    initializeType(memberType, Member.class, "Member", false);
    property = getLocalProperty(memberType, 0);
    initializeProperty(property, this.getBasicType(), "BasicType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 1);
    initializeProperty(property, this.getDeclaredType(), "DeclaredType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 2);
    initializeProperty(property, this.getSchemaType(), "SchemaType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 3);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 4);
    initializeProperty(property, this.getRecordType(), "RecordType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 5);
    initializeProperty(property, this.getUnionType(), "UnionType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 6);
    initializeProperty(property, this.getEnumerationType(), "EnumerationType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 7);
    initializeProperty(property, this.getArrayType(), "ArrayType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 8);
    initializeProperty(property, this.getListType(), "ListType", null, 0, 1, Member.class, false, true, false, true , null);

    property = getLocalProperty(memberType, 9);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Member.class, false, false, false);

    initializeType(messageFlowType, MessageFlow.class, "MessageFlow", false);
    property = getLocalProperty(messageFlowType, 0);
    initializeProperty(property, this.getMessageType(), "Message", null, 0, 1, MessageFlow.class, false, true, false, true , null);

    property = getLocalProperty(messageFlowType, 1);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, MessageFlow.class, false, true, false, true , null);

    property = getLocalProperty(messageFlowType, 2);
    initializeProperty(property, this.getConnectorGraphicsInfos(), "ConnectorGraphicsInfos", null, 0, 1, MessageFlow.class, false, true, false, true , null);

    property = getLocalProperty(messageFlowType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, MessageFlow.class, false, false, false);

    property = getLocalProperty(messageFlowType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, MessageFlow.class, false, true, false);

    property = getLocalProperty(messageFlowType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, MessageFlow.class, false, true, false);

    property = getLocalProperty(messageFlowType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Source", null, 1, 1, MessageFlow.class, false, true, false);

    property = getLocalProperty(messageFlowType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "Target", null, 1, 1, MessageFlow.class, false, true, false);

    property = getLocalProperty(messageFlowType, 8);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, MessageFlow.class, false, false, false);

    initializeType(messageFlowsType, MessageFlows.class, "MessageFlows", false);
    property = getLocalProperty(messageFlowsType, 0);
    initializeProperty(property, getSequence(), "group", null, 0, -1, MessageFlows.class, false, false, false);

    property = getLocalProperty(messageFlowsType, 1);
    initializeProperty(property, this.getMessageFlow(), "MessageFlow", null, 0, -1, MessageFlows.class, false, false, true, true , null);

    property = getLocalProperty(messageFlowsType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, MessageFlows.class, false, false, true);

    property = getLocalProperty(messageFlowsType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, MessageFlows.class, false, false, false);

    initializeType(messageTypeType, MessageType.class, "MessageType", false);
    property = getLocalProperty(messageTypeType, 0);
    initializeProperty(property, this.getActualParameters(), "ActualParameters", null, 0, 1, MessageType.class, false, true, false, true , null);

    property = getLocalProperty(messageTypeType, 1);
    initializeProperty(property, this.getDataMappings(), "DataMappings", null, 0, 1, MessageType.class, false, true, false, true , null);

    property = getLocalProperty(messageTypeType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, MessageType.class, false, false, false);

    property = getLocalProperty(messageTypeType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, MessageType.class, false, true, false);

    property = getLocalProperty(messageTypeType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, MessageType.class, false, true, false);

    property = getLocalProperty(messageTypeType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "From", null, 0, 1, MessageType.class, false, true, false);

    property = getLocalProperty(messageTypeType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "To", null, 0, 1, MessageType.class, false, true, false);

    property = getLocalProperty(messageTypeType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "FaultName", null, 0, 1, MessageType.class, false, true, false);

    property = getLocalProperty(messageTypeType, 8);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, MessageType.class, false, false, false);

    initializeType(methodType, Method.class, "Method", false);
    property = getLocalProperty(methodType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Method.class, false, true, false);

    property = getLocalProperty(methodType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Method.class, false, false, false);

    initializeType(method1Type, Method1.class, "Method1", false);
    property = getLocalProperty(method1Type, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Method1.class, false, true, false);

    property = getLocalProperty(method1Type, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Method1.class, false, false, false);

    initializeType(myRoleType, MyRole.class, "MyRole", false);
    property = getLocalProperty(myRoleType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, MyRole.class, false, false, false);

    property = getLocalProperty(myRoleType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "RoleName", null, 1, 1, MyRole.class, false, true, false);

    property = getLocalProperty(myRoleType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, MyRole.class, false, false, false);

    initializeType(noType, No.class, "No", false);
    property = getLocalProperty(noType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, No.class, false, false, false);

    property = getLocalProperty(noType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, No.class, false, false, false);

    initializeType(nodeGraphicsInfoType, NodeGraphicsInfo.class, "NodeGraphicsInfo", false);
    property = getLocalProperty(nodeGraphicsInfoType, 0);
    initializeProperty(property, this.getCoordinates(), "Coordinates", null, 0, 1, NodeGraphicsInfo.class, false, true, false, true , null);

    property = getLocalProperty(nodeGraphicsInfoType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, NodeGraphicsInfo.class, false, false, false);

    property = getLocalProperty(nodeGraphicsInfoType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "ToolId", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 3);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "IsVisible", "true", 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Page", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "LaneId", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 6);
    initializeProperty(property, theModelPackageImpl.getDouble(), "Height", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 7);
    initializeProperty(property, theModelPackageImpl.getDouble(), "Width", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 8);
    initializeProperty(property, theModelPackageImpl.getString(), "BorderColor", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 9);
    initializeProperty(property, theModelPackageImpl.getString(), "FillColor", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 10);
    initializeProperty(property, theModelPackageImpl.getString(), "Shape", null, 0, 1, NodeGraphicsInfo.class, false, true, false);

    property = getLocalProperty(nodeGraphicsInfoType, 11);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, NodeGraphicsInfo.class, false, false, false);

    initializeType(nodeGraphicsInfosType, NodeGraphicsInfos.class, "NodeGraphicsInfos", false);
    property = getLocalProperty(nodeGraphicsInfosType, 0);
    initializeProperty(property, this.getNodeGraphicsInfo(), "NodeGraphicsInfo", null, 0, -1, NodeGraphicsInfos.class, false, false, false, true , null);

    property = getLocalProperty(nodeGraphicsInfosType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, NodeGraphicsInfos.class, false, false, false);

    property = getLocalProperty(nodeGraphicsInfosType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, NodeGraphicsInfos.class, false, false, false);

    initializeType(objectType, net.smartworks.server.engine.process.xpdl.xpdl2.Object.class, "Object", false);
    property = getLocalProperty(objectType, 0);
    initializeProperty(property, this.getCategories(), "Categories", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl2.Object.class, false, true, false, true , null);

    property = getLocalProperty(objectType, 1);
    initializeProperty(property, this.getDocumentation(), "Documentation", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl2.Object.class, false, true, false, true , null);

    property = getLocalProperty(objectType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, net.smartworks.server.engine.process.xpdl.xpdl2.Object.class, false, false, false);

    property = getLocalProperty(objectType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, net.smartworks.server.engine.process.xpdl.xpdl2.Object.class, false, true, false);

    property = getLocalProperty(objectType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl2.Object.class, false, true, false);

    property = getLocalProperty(objectType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, net.smartworks.server.engine.process.xpdl.xpdl2.Object.class, false, false, false);

    initializeType(outputType, Output.class, "Output", false);
    property = getLocalProperty(outputType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Output.class, false, false, false);

    property = getLocalProperty(outputType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "ArtifactId", null, 1, 1, Output.class, false, true, false);

    property = getLocalProperty(outputType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Output.class, false, false, false);

    initializeType(outputSetType, OutputSet.class, "OutputSet", false);
    property = getLocalProperty(outputSetType, 0);
    initializeProperty(property, this.getOutput(), "Output", null, 1, -1, OutputSet.class, false, false, false, true , null);

    property = getLocalProperty(outputSetType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, OutputSet.class, false, false, false);

    property = getLocalProperty(outputSetType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, OutputSet.class, false, false, false);

    initializeType(outputSetsType, OutputSets.class, "OutputSets", false);
    property = getLocalProperty(outputSetsType, 0);
    initializeProperty(property, this.getOutputSet(), "OutputSet", null, 1, -1, OutputSets.class, false, false, false, true , null);

    property = getLocalProperty(outputSetsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, OutputSets.class, false, false, false);

    property = getLocalProperty(outputSetsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, OutputSets.class, false, false, false);

    initializeType(packageHeaderType, PackageHeader.class, "PackageHeader", false);
    property = getLocalProperty(packageHeaderType, 0);
    initializeProperty(property, this.getXPDLVersion(), "XPDLVersion", null, 1, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 1);
    initializeProperty(property, this.getVendor(), "Vendor", null, 1, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 2);
    initializeProperty(property, this.getCreated(), "Created", null, 1, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 3);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 4);
    initializeProperty(property, this.getDocumentation(), "Documentation", null, 0, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 5);
    initializeProperty(property, this.getPriorityUnit(), "PriorityUnit", null, 0, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 6);
    initializeProperty(property, this.getCostUnit(), "CostUnit", null, 0, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 7);
    initializeProperty(property, this.getVendorExtensions(), "VendorExtensions", null, 0, 1, PackageHeader.class, false, true, false, true , null);

    property = getLocalProperty(packageHeaderType, 8);
    initializeProperty(property, getSequence(), "any", null, 0, -1, PackageHeader.class, false, false, false);

    property = getLocalProperty(packageHeaderType, 9);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PackageHeader.class, false, false, false);

    initializeType(packageTypeType, PackageType.class, "PackageType", false);
    property = getLocalProperty(packageTypeType, 0);
    initializeProperty(property, this.getPackageHeader(), "PackageHeader", null, 1, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 1);
    initializeProperty(property, this.getRedefinableHeader(), "RedefinableHeader", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 2);
    initializeProperty(property, this.getConformanceClass(), "ConformanceClass", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 3);
    initializeProperty(property, this.getScript(), "Script", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 4);
    initializeProperty(property, this.getExternalPackages(), "ExternalPackages", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 5);
    initializeProperty(property, this.getTypeDeclarations(), "TypeDeclarations", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 6);
    initializeProperty(property, this.getParticipants(), "Participants", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 7);
    initializeProperty(property, this.getApplications(), "Applications", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 8);
    initializeProperty(property, this.getDataFields(), "DataFields", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 9);
    initializeProperty(property, this.getPartnerLinkTypes(), "PartnerLinkTypes", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 10);
    initializeProperty(property, this.getPools(), "Pools", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 11);
    initializeProperty(property, this.getMessageFlows(), "MessageFlows", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 12);
    initializeProperty(property, this.getAssociations(), "Associations", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 13);
    initializeProperty(property, this.getArtifacts(), "Artifacts", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 14);
    initializeProperty(property, this.getWorkflowProcesses(), "WorkflowProcesses", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 15);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, PackageType.class, false, true, false, true , null);

    property = getLocalProperty(packageTypeType, 16);
    initializeProperty(property, getSequence(), "any", null, 0, -1, PackageType.class, false, false, false);

    property = getLocalProperty(packageTypeType, 17);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, PackageType.class, false, true, false);

    property = getLocalProperty(packageTypeType, 18);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, PackageType.class, false, true, false);

    property = getLocalProperty(packageTypeType, 19);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PackageType.class, false, false, false);

    initializeType(participantType, Participant.class, "Participant", false);
    property = getLocalProperty(participantType, 0);
    initializeProperty(property, this.getParticipantType(), "ParticipantType", null, 1, 1, Participant.class, false, true, false, true , null);

    property = getLocalProperty(participantType, 1);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, Participant.class, false, true, false, true , null);

    property = getLocalProperty(participantType, 2);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, Participant.class, false, true, false, true , null);

    property = getLocalProperty(participantType, 3);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Participant.class, false, true, false, true , null);

    property = getLocalProperty(participantType, 4);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Participant.class, false, false, false);

    property = getLocalProperty(participantType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Participant.class, false, true, false);

    property = getLocalProperty(participantType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Participant.class, false, true, false);

    property = getLocalProperty(participantType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Participant.class, false, false, false);

    initializeType(participantsType, Participants.class, "Participants", false);
    property = getLocalProperty(participantsType, 0);
    initializeProperty(property, this.getParticipant(), "Participant", null, 0, -1, Participants.class, false, false, false, true , null);

    property = getLocalProperty(participantsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Participants.class, false, false, false);

    property = getLocalProperty(participantsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Participants.class, false, false, false);

    initializeType(participantTypeType, ParticipantType.class, "ParticipantType", false);
    property = getLocalProperty(participantTypeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ParticipantType.class, false, false, false);

    property = getLocalProperty(participantTypeType, 1);
    initializeProperty(property, this.getType2(), "Type", null, 1, 1, ParticipantType.class, false, true, false);

    property = getLocalProperty(participantTypeType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ParticipantType.class, false, false, false);

    initializeType(partnerType, Partner.class, "Partner", false);
    property = getLocalProperty(partnerType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Partner.class, false, false, false);

    property = getLocalProperty(partnerType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "PartnerLinkId", null, 1, 1, Partner.class, false, true, false);

    property = getLocalProperty(partnerType, 2);
    initializeProperty(property, this.getRoleType(), "RoleType", null, 1, 1, Partner.class, false, true, false);

    property = getLocalProperty(partnerType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Partner.class, false, false, false);

    initializeType(partnerLinkType, PartnerLink.class, "PartnerLink", false);
    property = getLocalProperty(partnerLinkType, 0);
    initializeProperty(property, this.getMyRole(), "MyRole", null, 0, 1, PartnerLink.class, false, true, false, true , null);

    property = getLocalProperty(partnerLinkType, 1);
    initializeProperty(property, this.getPartnerRole(), "PartnerRole", null, 0, 1, PartnerLink.class, false, true, false, true , null);

    property = getLocalProperty(partnerLinkType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, PartnerLink.class, false, false, false);

    property = getLocalProperty(partnerLinkType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "name", null, 1, 1, PartnerLink.class, false, true, false);

    property = getLocalProperty(partnerLinkType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, PartnerLink.class, false, true, false);

    property = getLocalProperty(partnerLinkType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "PartnerLinkTypeId", null, 1, 1, PartnerLink.class, false, true, false);

    property = getLocalProperty(partnerLinkType, 6);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PartnerLink.class, false, false, false);

    initializeType(partnerLinksType, PartnerLinks.class, "PartnerLinks", false);
    property = getLocalProperty(partnerLinksType, 0);
    initializeProperty(property, this.getPartnerLink(), "PartnerLink", null, 1, -1, PartnerLinks.class, false, false, false, true , null);

    property = getLocalProperty(partnerLinksType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, PartnerLinks.class, false, false, false);

    property = getLocalProperty(partnerLinksType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PartnerLinks.class, false, false, false);

    initializeType(partnerLinkTypeType, PartnerLinkType.class, "PartnerLinkType", false);
    property = getLocalProperty(partnerLinkTypeType, 0);
    initializeProperty(property, this.getRole(), "Role", null, 1, 2, PartnerLinkType.class, false, false, false, true , null);

    property = getLocalProperty(partnerLinkTypeType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, PartnerLinkType.class, false, false, false);

    property = getLocalProperty(partnerLinkTypeType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, PartnerLinkType.class, false, true, false);

    property = getLocalProperty(partnerLinkTypeType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "name", null, 1, 1, PartnerLinkType.class, false, true, false);

    property = getLocalProperty(partnerLinkTypeType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PartnerLinkType.class, false, false, false);

    initializeType(partnerLinkTypesType, PartnerLinkTypes.class, "PartnerLinkTypes", false);
    property = getLocalProperty(partnerLinkTypesType, 0);
    initializeProperty(property, this.getPartnerLinkType(), "PartnerLinkType", null, 1, -1, PartnerLinkTypes.class, false, false, false, true , null);

    property = getLocalProperty(partnerLinkTypesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, PartnerLinkTypes.class, false, false, false);

    property = getLocalProperty(partnerLinkTypesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PartnerLinkTypes.class, false, false, false);

    initializeType(partnerRoleType, PartnerRole.class, "PartnerRole", false);
    property = getLocalProperty(partnerRoleType, 0);
    initializeProperty(property, this.getEndPoint(), "EndPoint", null, 1, 1, PartnerRole.class, false, true, false, true , null);

    property = getLocalProperty(partnerRoleType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, PartnerRole.class, false, false, false);

    property = getLocalProperty(partnerRoleType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "RoleName", null, 1, 1, PartnerRole.class, false, true, false);

    property = getLocalProperty(partnerRoleType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "ServiceName", null, 0, 1, PartnerRole.class, false, true, false);

    property = getLocalProperty(partnerRoleType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "PortName", null, 0, 1, PartnerRole.class, false, true, false);

    property = getLocalProperty(partnerRoleType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PartnerRole.class, false, false, false);

    initializeType(performerType, Performer.class, "Performer", false);
    property = getLocalProperty(performerType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Performer.class, false, true, false);

    property = getLocalProperty(performerType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Performer.class, false, false, false);

    initializeType(performersType, Performers.class, "Performers", false);
    property = getLocalProperty(performersType, 0);
    initializeProperty(property, this.getPerformer(), "Performer", null, 1, -1, Performers.class, false, false, false, true , null);

    property = getLocalProperty(performersType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Performers.class, false, false, false);

    property = getLocalProperty(performersType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Performers.class, false, false, false);

    initializeType(pojoType, Pojo.class, "Pojo", false);
    property = getLocalProperty(pojoType, 0);
    initializeProperty(property, this.getClass_(), "Class", null, 1, 1, Pojo.class, false, true, false, true , null);

    property = getLocalProperty(pojoType, 1);
    initializeProperty(property, this.getMethod(), "Method", null, 1, 1, Pojo.class, false, true, false, true , null);

    property = getLocalProperty(pojoType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Pojo.class, false, false, false);

    property = getLocalProperty(pojoType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Pojo.class, false, false, false);

    initializeType(poolType, Pool.class, "Pool", false);
    property = getLocalProperty(poolType, 0);
    initializeProperty(property, this.getLanes(), "Lanes", null, 0, 1, Pool.class, false, true, false, true , null);

    property = getLocalProperty(poolType, 1);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, Pool.class, false, true, false, true , null);

    property = getLocalProperty(poolType, 2);
    initializeProperty(property, this.getNodeGraphicsInfos(), "NodeGraphicsInfos", null, 0, 1, Pool.class, false, true, false, true , null);

    property = getLocalProperty(poolType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Pool.class, false, false, false);

    property = getLocalProperty(poolType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Pool.class, false, true, false);

    property = getLocalProperty(poolType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Pool.class, false, true, false);

    property = getLocalProperty(poolType, 6);
    initializeProperty(property, this.getOrientation(), "Orientation", "HORIZONTAL", 0, 1, Pool.class, false, true, false);

    property = getLocalProperty(poolType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "Process", null, 0, 1, Pool.class, false, true, false);

    property = getLocalProperty(poolType, 8);
    initializeProperty(property, theModelPackageImpl.getString(), "Participant", null, 0, 1, Pool.class, false, true, false);

    property = getLocalProperty(poolType, 9);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "BoundaryVisible", null, 1, 1, Pool.class, false, true, false);

    property = getLocalProperty(poolType, 10);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Pool.class, false, false, false);

    initializeType(poolsType, Pools.class, "Pools", false);
    property = getLocalProperty(poolsType, 0);
    initializeProperty(property, this.getPool(), "Pool", null, 0, -1, Pools.class, false, false, false, true , null);

    property = getLocalProperty(poolsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Pools.class, false, false, false);

    property = getLocalProperty(poolsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Pools.class, false, false, false);

    initializeType(precisionType, Precision.class, "Precision", false);
    property = getLocalProperty(precisionType, 0);
    initializeProperty(property, theModelPackageImpl.getShort(), "value", null, 0, 1, Precision.class, false, true, false);

    property = getLocalProperty(precisionType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Precision.class, false, false, false);

    initializeType(priorityType, Priority.class, "Priority", false);
    property = getLocalProperty(priorityType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Priority.class, false, true, false);

    property = getLocalProperty(priorityType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Priority.class, false, false, false);

    initializeType(priorityUnitType, PriorityUnit.class, "PriorityUnit", false);
    property = getLocalProperty(priorityUnitType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, PriorityUnit.class, false, true, false);

    property = getLocalProperty(priorityUnitType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, PriorityUnit.class, false, false, false);

    initializeType(processHeaderType, ProcessHeader.class, "ProcessHeader", false);
    property = getLocalProperty(processHeaderType, 0);
    initializeProperty(property, this.getCreated(), "Created", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 1);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 2);
    initializeProperty(property, this.getPriority(), "Priority", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 3);
    initializeProperty(property, this.getLimit(), "Limit", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 4);
    initializeProperty(property, this.getValidFrom(), "ValidFrom", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 5);
    initializeProperty(property, this.getValidTo(), "ValidTo", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 6);
    initializeProperty(property, this.getTimeEstimation(), "TimeEstimation", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 7);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ProcessHeader.class, false, false, false);

    property = getLocalProperty(processHeaderType, 8);
    initializeProperty(property, this.getDurationUnit(), "DurationUnit", null, 0, 1, ProcessHeader.class, false, true, false);

    property = getLocalProperty(processHeaderType, 9);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ProcessHeader.class, false, false, false);

    initializeType(processType1Type, ProcessType1.class, "ProcessType1", false);
    property = getLocalProperty(processType1Type, 0);
    initializeProperty(property, this.getProcessHeader(), "ProcessHeader", null, 1, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 1);
    initializeProperty(property, this.getRedefinableHeader(), "RedefinableHeader", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 2);
    initializeProperty(property, this.getFormalParameters(), "FormalParameters", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 3);
    initializeProperty(property, this.getParticipants(), "Participants", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 4);
    initializeProperty(property, this.getApplications(), "Applications", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 5);
    initializeProperty(property, this.getDataFields(), "DataFields", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 6);
    initializeProperty(property, theXpdl1PackageImpl.getDataFields(), "DataFields1", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 7);
    initializeProperty(property, theXpdl1PackageImpl.getParticipants(), "Participants1", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 8);
    initializeProperty(property, theXpdl1PackageImpl.getApplications(), "Applications1", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 9);
    initializeProperty(property, this.getActivitySets(), "ActivitySets", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 10);
    initializeProperty(property, this.getActivities(), "Activities", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 11);
    initializeProperty(property, this.getTransitions(), "Transitions", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 12);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 13);
    initializeProperty(property, this.getAssignments(), "Assignments", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 14);
    initializeProperty(property, this.getPartnerLinks(), "PartnerLinks", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 15);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 16);
    initializeProperty(property, theModelPackageImpl.getDataObject(), "Extensions", null, 0, 1, ProcessType1.class, false, true, false, true , null);

    property = getLocalProperty(processType1Type, 17);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ProcessType1.class, false, false, false);

    property = getLocalProperty(processType1Type, 18);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 19);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 20);
    initializeProperty(property, this.getAccessLevel(), "AccessLevel", "PUBLIC", 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 21);
    initializeProperty(property, this.getProcessType(), "ProcessType", "None", 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 22);
    initializeProperty(property, this.getStatus(), "Status", "None", 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 23);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "SuppressJoinFailure", "false", 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 24);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "EnableInstanceCompensation", "false", 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 25);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "AdHoc", "false", 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 26);
    initializeProperty(property, this.getAdHocOrdering(), "AdHocOrdering", "Parallel", 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 27);
    initializeProperty(property, theModelPackageImpl.getString(), "AdHocCompletionCondition", null, 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 28);
    initializeProperty(property, theModelPackageImpl.getString(), "DefaultStartActivitySetId", null, 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 29);
    initializeProperty(property, theModelPackageImpl.getString(), "DefaultStartActivityId", null, 0, 1, ProcessType1.class, false, true, false);

    property = getLocalProperty(processType1Type, 30);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ProcessType1.class, false, false, false);

    initializeType(recordTypeType, RecordType.class, "RecordType", false);
    property = getLocalProperty(recordTypeType, 0);
    initializeProperty(property, this.getMember(), "Member", null, 1, -1, RecordType.class, false, false, false, true , null);

    property = getLocalProperty(recordTypeType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, RecordType.class, false, false, false);

    property = getLocalProperty(recordTypeType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, RecordType.class, false, false, false);

    initializeType(redefinableHeaderType, RedefinableHeader.class, "RedefinableHeader", false);
    property = getLocalProperty(redefinableHeaderType, 0);
    initializeProperty(property, this.getAuthor(), "Author", null, 0, 1, RedefinableHeader.class, false, true, false, true , null);

    property = getLocalProperty(redefinableHeaderType, 1);
    initializeProperty(property, this.getVersion(), "Version", null, 0, 1, RedefinableHeader.class, false, true, false, true , null);

    property = getLocalProperty(redefinableHeaderType, 2);
    initializeProperty(property, this.getCodepage(), "Codepage", null, 0, 1, RedefinableHeader.class, false, true, false, true , null);

    property = getLocalProperty(redefinableHeaderType, 3);
    initializeProperty(property, this.getCountrykey(), "Countrykey", null, 0, 1, RedefinableHeader.class, false, true, false, true , null);

    property = getLocalProperty(redefinableHeaderType, 4);
    initializeProperty(property, this.getResponsibles(), "Responsibles", null, 0, 1, RedefinableHeader.class, false, true, false, true , null);

    property = getLocalProperty(redefinableHeaderType, 5);
    initializeProperty(property, getSequence(), "any", null, 0, -1, RedefinableHeader.class, false, false, false);

    property = getLocalProperty(redefinableHeaderType, 6);
    initializeProperty(property, this.getPublicationStatus(), "PublicationStatus", null, 0, 1, RedefinableHeader.class, false, true, false);

    property = getLocalProperty(redefinableHeaderType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, RedefinableHeader.class, false, false, false);

    initializeType(referenceType, Reference.class, "Reference", false);
    property = getLocalProperty(referenceType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Reference.class, false, false, false);

    property = getLocalProperty(referenceType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "ActivityId", null, 1, 1, Reference.class, false, true, false);

    property = getLocalProperty(referenceType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Reference.class, false, false, false);

    initializeType(responsibleType, Responsible.class, "Responsible", false);
    property = getLocalProperty(responsibleType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Responsible.class, false, true, false);

    property = getLocalProperty(responsibleType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Responsible.class, false, false, false);

    initializeType(responsiblesType, Responsibles.class, "Responsibles", false);
    property = getLocalProperty(responsiblesType, 0);
    initializeProperty(property, this.getResponsible(), "Responsible", null, 0, -1, Responsibles.class, false, false, false, true , null);

    property = getLocalProperty(responsiblesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Responsibles.class, false, false, false);

    property = getLocalProperty(responsiblesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Responsibles.class, false, false, false);

    initializeType(resultCompensationType, ResultCompensation.class, "ResultCompensation", false);
    property = getLocalProperty(resultCompensationType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ResultCompensation.class, false, false, false);

    property = getLocalProperty(resultCompensationType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "ActivityId", null, 0, 1, ResultCompensation.class, false, true, false);

    property = getLocalProperty(resultCompensationType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ResultCompensation.class, false, false, false);

    initializeType(resultErrorType, ResultError.class, "ResultError", false);
    property = getLocalProperty(resultErrorType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ResultError.class, false, false, false);

    property = getLocalProperty(resultErrorType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "ErrorCode", null, 1, 1, ResultError.class, false, true, false);

    property = getLocalProperty(resultErrorType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ResultError.class, false, false, false);

    initializeType(resultMultipleType, ResultMultiple.class, "ResultMultiple", false);
    property = getLocalProperty(resultMultipleType, 0);
    initializeProperty(property, this.getTriggerResultMessage(), "TriggerResultMessage", null, 0, 1, ResultMultiple.class, false, true, false, true , null);

    property = getLocalProperty(resultMultipleType, 1);
    initializeProperty(property, this.getTriggerResultLink(), "TriggerResultLink", null, 0, 1, ResultMultiple.class, false, true, false, true , null);

    property = getLocalProperty(resultMultipleType, 2);
    initializeProperty(property, this.getResultCompensation(), "ResultCompensation", null, 0, 1, ResultMultiple.class, false, true, false, true , null);

    property = getLocalProperty(resultMultipleType, 3);
    initializeProperty(property, this.getResultError(), "ResultError", null, 0, 1, ResultMultiple.class, false, true, false, true , null);

    property = getLocalProperty(resultMultipleType, 4);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ResultMultiple.class, false, false, false);

    property = getLocalProperty(resultMultipleType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ResultMultiple.class, false, false, false);

    initializeType(roleType, Role.class, "Role", false);
    property = getLocalProperty(roleType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Role.class, false, false, false);

    property = getLocalProperty(roleType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "portType", null, 1, 1, Role.class, false, true, false);

    property = getLocalProperty(roleType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 1, 1, Role.class, false, true, false);

    property = getLocalProperty(roleType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Role.class, false, false, false);

    initializeType(routeType, Route.class, "Route", false);
    property = getLocalProperty(routeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Route.class, false, false, false);

    property = getLocalProperty(routeType, 1);
    initializeProperty(property, this.getGatewayType(), "GatewayType", "XOR", 0, 1, Route.class, false, true, false);

    property = getLocalProperty(routeType, 2);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "Instantiate", "false", 0, 1, Route.class, false, true, false);

    property = getLocalProperty(routeType, 3);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "MarkerVisible", "false", 0, 1, Route.class, false, true, false);

    property = getLocalProperty(routeType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Route.class, false, false, false);

    initializeType(ruleType, Rule.class, "Rule", false);
    property = getLocalProperty(ruleType, 0);
    initializeProperty(property, this.getExpressionType(), "Expression", null, 1, 1, Rule.class, false, true, false, true , null);

    property = getLocalProperty(ruleType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Rule.class, false, false, false);

    property = getLocalProperty(ruleType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Rule.class, false, true, false);

    property = getLocalProperty(ruleType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Rule.class, false, true, false);

    property = getLocalProperty(ruleType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Rule.class, false, false, false);

    initializeType(ruleNameType, RuleName.class, "RuleName", false);
    property = getLocalProperty(ruleNameType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, RuleName.class, false, true, false);

    property = getLocalProperty(ruleNameType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, RuleName.class, false, false, false);

    initializeType(scaleType, Scale.class, "Scale", false);
    property = getLocalProperty(scaleType, 0);
    initializeProperty(property, theModelPackageImpl.getShort(), "value", null, 0, 1, Scale.class, false, true, false);

    property = getLocalProperty(scaleType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Scale.class, false, false, false);

    initializeType(schemaTypeType, SchemaType.class, "SchemaType", false);
    property = getLocalProperty(schemaTypeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, SchemaType.class, false, false, false);

    property = getLocalProperty(schemaTypeType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, SchemaType.class, false, false, false);

    initializeType(scriptType, Script.class, "Script", false);
    property = getLocalProperty(scriptType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Script.class, false, false, false);

    property = getLocalProperty(scriptType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Type", null, 1, 1, Script.class, false, true, false);

    property = getLocalProperty(scriptType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Version", null, 0, 1, Script.class, false, true, false);

    property = getLocalProperty(scriptType, 3);
    initializeProperty(property, theModelPackageImpl.getURI(), "Grammar", null, 0, 1, Script.class, false, true, false);

    property = getLocalProperty(scriptType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Script.class, false, false, false);

    initializeType(script1Type, Script1.class, "Script1", false);
    property = getLocalProperty(script1Type, 0);
    initializeProperty(property, this.getExpressionType(), "Expression", null, 0, 1, Script1.class, false, true, false, true , null);

    property = getLocalProperty(script1Type, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Script1.class, false, false, false);

    property = getLocalProperty(script1Type, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Script1.class, false, false, false);

    initializeType(serviceType, Service.class, "Service", false);
    property = getLocalProperty(serviceType, 0);
    initializeProperty(property, this.getEndPoint(), "EndPoint", null, 1, 1, Service.class, false, true, false, true , null);

    property = getLocalProperty(serviceType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Service.class, false, false, false);

    property = getLocalProperty(serviceType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "ServiceName", null, 1, 1, Service.class, false, true, false);

    property = getLocalProperty(serviceType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "PortName", null, 1, 1, Service.class, false, true, false);

    property = getLocalProperty(serviceType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Service.class, false, false, false);

    initializeType(simulationInformationType, SimulationInformation.class, "SimulationInformation", false);
    property = getLocalProperty(simulationInformationType, 0);
    initializeProperty(property, this.getCost(), "Cost", null, 1, 1, SimulationInformation.class, false, true, false, true , null);

    property = getLocalProperty(simulationInformationType, 1);
    initializeProperty(property, this.getTimeEstimation(), "TimeEstimation", null, 1, 1, SimulationInformation.class, false, true, false, true , null);

    property = getLocalProperty(simulationInformationType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, SimulationInformation.class, false, false, false);

    property = getLocalProperty(simulationInformationType, 3);
    initializeProperty(property, this.getInstantiation(), "Instantiation", null, 0, 1, SimulationInformation.class, false, true, false);

    property = getLocalProperty(simulationInformationType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, SimulationInformation.class, false, false, false);

    initializeType(splitType, Split.class, "Split", false);
    property = getLocalProperty(splitType, 0);
    initializeProperty(property, this.getTransitionRefs(), "TransitionRefs", null, 0, 1, Split.class, false, true, false, true , null);

    property = getLocalProperty(splitType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Split.class, false, false, false);

    property = getLocalProperty(splitType, 2);
    initializeProperty(property, this.getType3(), "Type", null, 0, 1, Split.class, false, true, false);

    property = getLocalProperty(splitType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "OutgoingCondition", null, 0, 1, Split.class, false, true, false);

    property = getLocalProperty(splitType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Split.class, false, false, false);

    initializeType(startEventType, StartEvent.class, "StartEvent", false);
    property = getLocalProperty(startEventType, 0);
    initializeProperty(property, this.getTriggerResultMessage(), "TriggerResultMessage", null, 0, 1, StartEvent.class, false, true, false, true , null);

    property = getLocalProperty(startEventType, 1);
    initializeProperty(property, this.getTriggerTimer(), "TriggerTimer", null, 0, 1, StartEvent.class, false, true, false, true , null);

    property = getLocalProperty(startEventType, 2);
    initializeProperty(property, this.getTriggerRule(), "TriggerRule", null, 0, 1, StartEvent.class, false, true, false, true , null);

    property = getLocalProperty(startEventType, 3);
    initializeProperty(property, this.getTriggerResultLink(), "TriggerResultLink", null, 0, 1, StartEvent.class, false, true, false, true , null);

    property = getLocalProperty(startEventType, 4);
    initializeProperty(property, this.getTriggerMultiple(), "TriggerMultiple", null, 0, 1, StartEvent.class, false, true, false, true , null);

    property = getLocalProperty(startEventType, 5);
    initializeProperty(property, this.getTrigger1(), "Trigger", null, 1, 1, StartEvent.class, false, true, false);

    property = getLocalProperty(startEventType, 6);
    initializeProperty(property, this.getImplementation2(), "Implementation", "WebService", 0, 1, StartEvent.class, false, true, false);

    property = getLocalProperty(startEventType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, StartEvent.class, false, false, false);

    initializeType(subFlowType, SubFlow.class, "SubFlow", false);
    property = getLocalProperty(subFlowType, 0);
    initializeProperty(property, this.getActualParameters(), "ActualParameters", null, 0, 1, SubFlow.class, false, true, false, true , null);

    property = getLocalProperty(subFlowType, 1);
    initializeProperty(property, this.getDataMappings(), "DataMappings", null, 0, 1, SubFlow.class, false, true, false, true , null);

    property = getLocalProperty(subFlowType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, SubFlow.class, false, false, false);

    property = getLocalProperty(subFlowType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 5);
    initializeProperty(property, this.getExecution1(), "Execution", "SYNCHR", 0, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "PackageRef", null, 0, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "InstanceDataField", null, 0, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 8);
    initializeProperty(property, theModelPackageImpl.getString(), "StartActivitySetId", null, 0, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 9);
    initializeProperty(property, theModelPackageImpl.getString(), "StartActivityId", null, 0, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 10);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, SubFlow.class, false, false, false);

    initializeType(taskType, Task.class, "Task", false);
    property = getLocalProperty(taskType, 0);
    initializeProperty(property, this.getTaskService(), "TaskService", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 1);
    initializeProperty(property, this.getTaskReceive(), "TaskReceive", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 2);
    initializeProperty(property, this.getTaskManual(), "TaskManual", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 3);
    initializeProperty(property, this.getTaskReference(), "TaskReference", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 4);
    initializeProperty(property, this.getTaskScript(), "TaskScript", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 5);
    initializeProperty(property, this.getTaskSend(), "TaskSend", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 6);
    initializeProperty(property, this.getTaskUser(), "TaskUser", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 7);
    initializeProperty(property, this.getTaskApplication(), "TaskApplication", null, 0, 1, Task.class, false, true, false, true , null);

    property = getLocalProperty(taskType, 8);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Task.class, false, false, false);

    initializeType(taskApplicationType, TaskApplication.class, "TaskApplication", false);
    property = getLocalProperty(taskApplicationType, 0);
    initializeProperty(property, this.getActualParameters(), "ActualParameters", null, 0, 1, TaskApplication.class, false, true, false, true , null);

    property = getLocalProperty(taskApplicationType, 1);
    initializeProperty(property, this.getDataMappings(), "DataMappings", null, 0, 1, TaskApplication.class, false, true, false, true , null);

    property = getLocalProperty(taskApplicationType, 2);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, TaskApplication.class, false, true, false, true , null);

    property = getLocalProperty(taskApplicationType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskApplication.class, false, false, false);

    property = getLocalProperty(taskApplicationType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, TaskApplication.class, false, true, false);

    property = getLocalProperty(taskApplicationType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, TaskApplication.class, false, true, false);

    property = getLocalProperty(taskApplicationType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "PackageRef", null, 0, 1, TaskApplication.class, false, true, false);

    property = getLocalProperty(taskApplicationType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskApplication.class, false, false, false);

    initializeType(taskManualType, TaskManual.class, "TaskManual", false);
    property = getLocalProperty(taskManualType, 0);
    initializeProperty(property, this.getPerformers(), "Performers", null, 1, 1, TaskManual.class, false, true, false, true , null);

    property = getLocalProperty(taskManualType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskManual.class, false, false, false);

    property = getLocalProperty(taskManualType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskManual.class, false, false, false);

    initializeType(taskReceiveType, TaskReceive.class, "TaskReceive", false);
    property = getLocalProperty(taskReceiveType, 0);
    initializeProperty(property, this.getMessageType(), "Message", null, 1, 1, TaskReceive.class, false, true, false, true , null);

    property = getLocalProperty(taskReceiveType, 1);
    initializeProperty(property, this.getWebServiceOperation(), "WebServiceOperation", null, 0, 1, TaskReceive.class, false, true, false, true , null);

    property = getLocalProperty(taskReceiveType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskReceive.class, false, false, false);

    property = getLocalProperty(taskReceiveType, 3);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "Instantiate", null, 1, 1, TaskReceive.class, false, true, false);

    property = getLocalProperty(taskReceiveType, 4);
    initializeProperty(property, this.getImplementation3(), "Implementation", "WebService", 0, 1, TaskReceive.class, false, true, false);

    property = getLocalProperty(taskReceiveType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskReceive.class, false, false, false);

    initializeType(taskReferenceType, TaskReference.class, "TaskReference", false);
    property = getLocalProperty(taskReferenceType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskReference.class, false, false, false);

    property = getLocalProperty(taskReferenceType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "TaskRef", null, 1, 1, TaskReference.class, false, true, false);

    property = getLocalProperty(taskReferenceType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskReference.class, false, false, false);

    initializeType(taskScriptType, TaskScript.class, "TaskScript", false);
    property = getLocalProperty(taskScriptType, 0);
    initializeProperty(property, this.getExpressionType(), "Script", null, 1, 1, TaskScript.class, false, true, false, true , null);

    property = getLocalProperty(taskScriptType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskScript.class, false, false, false);

    property = getLocalProperty(taskScriptType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskScript.class, false, false, false);

    initializeType(taskSendType, TaskSend.class, "TaskSend", false);
    property = getLocalProperty(taskSendType, 0);
    initializeProperty(property, this.getMessageType(), "Message", null, 1, 1, TaskSend.class, false, true, false, true , null);

    property = getLocalProperty(taskSendType, 1);
    initializeProperty(property, this.getWebServiceOperation(), "WebServiceOperation", null, 0, 1, TaskSend.class, false, true, false, true , null);

    property = getLocalProperty(taskSendType, 2);
    initializeProperty(property, this.getWebServiceFaultCatch(), "WebServiceFaultCatch", null, 0, -1, TaskSend.class, false, false, false, true , null);

    property = getLocalProperty(taskSendType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskSend.class, false, false, false);

    property = getLocalProperty(taskSendType, 4);
    initializeProperty(property, this.getImplementation(), "Implementation", "WebService", 0, 1, TaskSend.class, false, true, false);

    property = getLocalProperty(taskSendType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskSend.class, false, false, false);

    initializeType(taskServiceType, TaskService.class, "TaskService", false);
    property = getLocalProperty(taskServiceType, 0);
    initializeProperty(property, this.getMessageType(), "MessageIn", null, 1, 1, TaskService.class, false, true, false, true , null);

    property = getLocalProperty(taskServiceType, 1);
    initializeProperty(property, this.getMessageType(), "MessageOut", null, 1, 1, TaskService.class, false, true, false, true , null);

    property = getLocalProperty(taskServiceType, 2);
    initializeProperty(property, this.getWebServiceOperation(), "WebServiceOperation", null, 0, 1, TaskService.class, false, true, false, true , null);

    property = getLocalProperty(taskServiceType, 3);
    initializeProperty(property, this.getWebServiceFaultCatch(), "WebServiceFaultCatch", null, 0, -1, TaskService.class, false, false, false, true , null);

    property = getLocalProperty(taskServiceType, 4);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskService.class, false, false, false);

    property = getLocalProperty(taskServiceType, 5);
    initializeProperty(property, this.getImplementation6(), "Implementation", "WebService", 0, 1, TaskService.class, false, true, false);

    property = getLocalProperty(taskServiceType, 6);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskService.class, false, false, false);

    initializeType(taskUserType, TaskUser.class, "TaskUser", false);
    property = getLocalProperty(taskUserType, 0);
    initializeProperty(property, this.getPerformers(), "Performers", null, 1, 1, TaskUser.class, false, true, false, true , null);

    property = getLocalProperty(taskUserType, 1);
    initializeProperty(property, this.getMessageType(), "MessageIn", null, 1, 1, TaskUser.class, false, true, false, true , null);

    property = getLocalProperty(taskUserType, 2);
    initializeProperty(property, this.getMessageType(), "MessageOut", null, 1, 1, TaskUser.class, false, true, false, true , null);

    property = getLocalProperty(taskUserType, 3);
    initializeProperty(property, this.getWebServiceOperation(), "WebServiceOperation", null, 0, 1, TaskUser.class, false, true, false, true , null);

    property = getLocalProperty(taskUserType, 4);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TaskUser.class, false, false, false);

    property = getLocalProperty(taskUserType, 5);
    initializeProperty(property, this.getImplementation1(), "Implementation", "WebService", 0, 1, TaskUser.class, false, true, false);

    property = getLocalProperty(taskUserType, 6);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TaskUser.class, false, false, false);

    initializeType(timeEstimationType, TimeEstimation.class, "TimeEstimation", false);
    property = getLocalProperty(timeEstimationType, 0);
    initializeProperty(property, this.getWaitingTime(), "WaitingTime", null, 0, 1, TimeEstimation.class, false, true, false, true , null);

    property = getLocalProperty(timeEstimationType, 1);
    initializeProperty(property, this.getWorkingTime(), "WorkingTime", null, 0, 1, TimeEstimation.class, false, true, false, true , null);

    property = getLocalProperty(timeEstimationType, 2);
    initializeProperty(property, this.getDuration(), "Duration", null, 0, 1, TimeEstimation.class, false, true, false, true , null);

    property = getLocalProperty(timeEstimationType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TimeEstimation.class, false, false, false);

    property = getLocalProperty(timeEstimationType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TimeEstimation.class, false, false, false);

    initializeType(transactionType, Transaction.class, "Transaction", false);
    property = getLocalProperty(transactionType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Transaction.class, false, false, false);

    property = getLocalProperty(transactionType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "TransactionId", null, 1, 1, Transaction.class, false, true, false);

    property = getLocalProperty(transactionType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "TransactionProtocol", null, 1, 1, Transaction.class, false, true, false);

    property = getLocalProperty(transactionType, 3);
    initializeProperty(property, this.getTransactionMethod(), "TransactionMethod", null, 1, 1, Transaction.class, false, true, false);

    property = getLocalProperty(transactionType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Transaction.class, false, false, false);

    initializeType(transitionType, Transition.class, "Transition", false);
    property = getLocalProperty(transitionType, 0);
    initializeProperty(property, this.getCondition(), "Condition", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 1);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 2);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 3);
    initializeProperty(property, this.getAssignments(), "Assignments", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 4);
    initializeProperty(property, this.getObject(), "Object", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 5);
    initializeProperty(property, this.getConnectorGraphicsInfos(), "ConnectorGraphicsInfos", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 6);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Transition.class, false, false, false);

    property = getLocalProperty(transitionType, 7);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 8);
    initializeProperty(property, theModelPackageImpl.getString(), "From", null, 1, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 9);
    initializeProperty(property, theModelPackageImpl.getString(), "To", null, 1, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 10);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 11);
    initializeProperty(property, theModelPackageImpl.getInt(), "Quantity", "1", 0, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 12);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Transition.class, false, false, false);

    initializeType(transitionRefType, TransitionRef.class, "TransitionRef", false);
    property = getLocalProperty(transitionRefType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TransitionRef.class, false, false, false);

    property = getLocalProperty(transitionRefType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, TransitionRef.class, false, true, false);

    property = getLocalProperty(transitionRefType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, TransitionRef.class, false, true, false);

    property = getLocalProperty(transitionRefType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TransitionRef.class, false, false, false);

    initializeType(transitionRefsType, TransitionRefs.class, "TransitionRefs", false);
    property = getLocalProperty(transitionRefsType, 0);
    initializeProperty(property, this.getTransitionRef(), "TransitionRef", null, 0, -1, TransitionRefs.class, false, false, false, true , null);

    property = getLocalProperty(transitionRefsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TransitionRefs.class, false, false, false);

    property = getLocalProperty(transitionRefsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TransitionRefs.class, false, false, false);

    initializeType(transitionRestrictionType, TransitionRestriction.class, "TransitionRestriction", false);
    property = getLocalProperty(transitionRestrictionType, 0);
    initializeProperty(property, this.getJoin(), "Join", null, 0, 1, TransitionRestriction.class, false, true, false, true , null);

    property = getLocalProperty(transitionRestrictionType, 1);
    initializeProperty(property, this.getSplit(), "Split", null, 0, 1, TransitionRestriction.class, false, true, false, true , null);

    property = getLocalProperty(transitionRestrictionType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TransitionRestriction.class, false, false, false);

    property = getLocalProperty(transitionRestrictionType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TransitionRestriction.class, false, false, false);

    initializeType(transitionRestrictionsType, TransitionRestrictions.class, "TransitionRestrictions", false);
    property = getLocalProperty(transitionRestrictionsType, 0);
    initializeProperty(property, this.getTransitionRestriction(), "TransitionRestriction", null, 0, -1, TransitionRestrictions.class, false, false, false, true , null);

    property = getLocalProperty(transitionRestrictionsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TransitionRestrictions.class, false, false, false);

    property = getLocalProperty(transitionRestrictionsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TransitionRestrictions.class, false, false, false);

    initializeType(transitionsType, Transitions.class, "Transitions", false);
    property = getLocalProperty(transitionsType, 0);
    initializeProperty(property, this.getTransition(), "Transition", null, 0, -1, Transitions.class, false, false, false, true , null);

    property = getLocalProperty(transitionsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Transitions.class, false, false, false);

    property = getLocalProperty(transitionsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Transitions.class, false, false, false);

    initializeType(triggerIntermediateMultipleType, TriggerIntermediateMultiple.class, "TriggerIntermediateMultiple", false);
    property = getLocalProperty(triggerIntermediateMultipleType, 0);
    initializeProperty(property, this.getTriggerResultMessage(), "TriggerResultMessage", null, 0, 1, TriggerIntermediateMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerIntermediateMultipleType, 1);
    initializeProperty(property, this.getTriggerTimer(), "TriggerTimer", null, 0, 1, TriggerIntermediateMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerIntermediateMultipleType, 2);
    initializeProperty(property, this.getResultError(), "ResultError", null, 0, 1, TriggerIntermediateMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerIntermediateMultipleType, 3);
    initializeProperty(property, this.getResultCompensation(), "ResultCompensation", null, 0, 1, TriggerIntermediateMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerIntermediateMultipleType, 4);
    initializeProperty(property, this.getTriggerRule(), "TriggerRule", null, 0, 1, TriggerIntermediateMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerIntermediateMultipleType, 5);
    initializeProperty(property, this.getTriggerResultLink(), "TriggerResultLink", null, 0, 1, TriggerIntermediateMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerIntermediateMultipleType, 6);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TriggerIntermediateMultiple.class, false, false, false);

    property = getLocalProperty(triggerIntermediateMultipleType, 7);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TriggerIntermediateMultiple.class, false, false, false);

    initializeType(triggerMultipleType, TriggerMultiple.class, "TriggerMultiple", false);
    property = getLocalProperty(triggerMultipleType, 0);
    initializeProperty(property, this.getTriggerResultMessage(), "TriggerResultMessage", null, 0, 1, TriggerMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerMultipleType, 1);
    initializeProperty(property, this.getTriggerTimer(), "TriggerTimer", null, 0, 1, TriggerMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerMultipleType, 2);
    initializeProperty(property, this.getTriggerRule(), "TriggerRule", null, 0, 1, TriggerMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerMultipleType, 3);
    initializeProperty(property, this.getTriggerResultLink(), "TriggerResultLink", null, 0, 1, TriggerMultiple.class, false, true, false, true , null);

    property = getLocalProperty(triggerMultipleType, 4);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TriggerMultiple.class, false, false, false);

    property = getLocalProperty(triggerMultipleType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TriggerMultiple.class, false, false, false);

    initializeType(triggerResultLinkType, TriggerResultLink.class, "TriggerResultLink", false);
    property = getLocalProperty(triggerResultLinkType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TriggerResultLink.class, false, false, false);

    property = getLocalProperty(triggerResultLinkType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "LinkId", null, 1, 1, TriggerResultLink.class, false, true, false);

    property = getLocalProperty(triggerResultLinkType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "ProcessRef", null, 1, 1, TriggerResultLink.class, false, true, false);

    property = getLocalProperty(triggerResultLinkType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TriggerResultLink.class, false, false, false);

    initializeType(triggerResultMessageType, TriggerResultMessage.class, "TriggerResultMessage", false);
    property = getLocalProperty(triggerResultMessageType, 0);
    initializeProperty(property, this.getMessageType(), "Message", null, 1, 1, TriggerResultMessage.class, false, true, false, true , null);

    property = getLocalProperty(triggerResultMessageType, 1);
    initializeProperty(property, this.getWebServiceOperation(), "WebServiceOperation", null, 0, 1, TriggerResultMessage.class, false, true, false, true , null);

    property = getLocalProperty(triggerResultMessageType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TriggerResultMessage.class, false, false, false);

    property = getLocalProperty(triggerResultMessageType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TriggerResultMessage.class, false, false, false);

    initializeType(triggerRuleType, TriggerRule.class, "TriggerRule", false);
    property = getLocalProperty(triggerRuleType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TriggerRule.class, false, false, false);

    property = getLocalProperty(triggerRuleType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "RuleName", null, 1, 1, TriggerRule.class, false, true, false);

    property = getLocalProperty(triggerRuleType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TriggerRule.class, false, false, false);

    initializeType(triggerTimerType, TriggerTimer.class, "TriggerTimer", false);
    property = getLocalProperty(triggerTimerType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TriggerTimer.class, false, false, false);

    property = getLocalProperty(triggerTimerType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "TimeDate", null, 0, 1, TriggerTimer.class, false, true, false);

    property = getLocalProperty(triggerTimerType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "TimeCycle", null, 0, 1, TriggerTimer.class, false, true, false);

    property = getLocalProperty(triggerTimerType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TriggerTimer.class, false, false, false);

    initializeType(typeDeclarationType, TypeDeclaration.class, "TypeDeclaration", false);
    property = getLocalProperty(typeDeclarationType, 0);
    initializeProperty(property, this.getBasicType(), "BasicType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 1);
    initializeProperty(property, this.getDeclaredType(), "DeclaredType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 2);
    initializeProperty(property, this.getSchemaType(), "SchemaType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 3);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 4);
    initializeProperty(property, this.getRecordType(), "RecordType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 5);
    initializeProperty(property, this.getUnionType(), "UnionType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 6);
    initializeProperty(property, this.getEnumerationType(), "EnumerationType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 7);
    initializeProperty(property, this.getArrayType(), "ArrayType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 8);
    initializeProperty(property, this.getListType(), "ListType", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 9);
    initializeProperty(property, this.getDescription(), "Description", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 10);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 11);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TypeDeclaration.class, false, false, false);

    property = getLocalProperty(typeDeclarationType, 12);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, TypeDeclaration.class, false, true, false);

    property = getLocalProperty(typeDeclarationType, 13);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, TypeDeclaration.class, false, true, false);

    property = getLocalProperty(typeDeclarationType, 14);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TypeDeclaration.class, false, false, false);

    initializeType(typeDeclarationsType, TypeDeclarations.class, "TypeDeclarations", false);
    property = getLocalProperty(typeDeclarationsType, 0);
    initializeProperty(property, this.getTypeDeclaration(), "TypeDeclaration", null, 0, -1, TypeDeclarations.class, false, false, false, true , null);

    property = getLocalProperty(typeDeclarationsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, TypeDeclarations.class, false, false, false);

    property = getLocalProperty(typeDeclarationsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, TypeDeclarations.class, false, false, false);

    initializeType(unionTypeType, UnionType.class, "UnionType", false);
    property = getLocalProperty(unionTypeType, 0);
    initializeProperty(property, this.getMember(), "Member", null, 1, -1, UnionType.class, false, false, false, true , null);

    property = getLocalProperty(unionTypeType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, UnionType.class, false, false, false);

    property = getLocalProperty(unionTypeType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, UnionType.class, false, false, false);

    initializeType(validFromType, ValidFrom.class, "ValidFrom", false);
    property = getLocalProperty(validFromType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, ValidFrom.class, false, true, false);

    property = getLocalProperty(validFromType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ValidFrom.class, false, false, false);

    initializeType(validToType, ValidTo.class, "ValidTo", false);
    property = getLocalProperty(validToType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, ValidTo.class, false, true, false);

    property = getLocalProperty(validToType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, ValidTo.class, false, false, false);

    initializeType(vendorType, Vendor.class, "Vendor", false);
    property = getLocalProperty(vendorType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Vendor.class, false, true, false);

    property = getLocalProperty(vendorType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Vendor.class, false, false, false);

    initializeType(vendorExtensionType, VendorExtension.class, "VendorExtension", false);
    property = getLocalProperty(vendorExtensionType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, VendorExtension.class, false, false, false);

    property = getLocalProperty(vendorExtensionType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "ToolId", null, 1, 1, VendorExtension.class, false, true, false);

    property = getLocalProperty(vendorExtensionType, 2);
    initializeProperty(property, theModelPackageImpl.getURI(), "schemaLocation", null, 1, 1, VendorExtension.class, false, true, false);

    property = getLocalProperty(vendorExtensionType, 3);
    initializeProperty(property, theModelPackageImpl.getURI(), "extensionDescription", null, 0, 1, VendorExtension.class, false, true, false);

    property = getLocalProperty(vendorExtensionType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, VendorExtension.class, false, false, false);

    initializeType(vendorExtensionsType, VendorExtensions.class, "VendorExtensions", false);
    property = getLocalProperty(vendorExtensionsType, 0);
    initializeProperty(property, this.getVendorExtension(), "VendorExtension", null, 0, -1, VendorExtensions.class, false, false, false, true , null);

    property = getLocalProperty(vendorExtensionsType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, VendorExtensions.class, false, false, false);

    property = getLocalProperty(vendorExtensionsType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, VendorExtensions.class, false, false, false);

    initializeType(versionType, Version.class, "Version", false);
    property = getLocalProperty(versionType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, Version.class, false, true, false);

    property = getLocalProperty(versionType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Version.class, false, false, false);

    initializeType(waitingTimeType, WaitingTime.class, "WaitingTime", false);
    property = getLocalProperty(waitingTimeType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, WaitingTime.class, false, true, false);

    property = getLocalProperty(waitingTimeType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, WaitingTime.class, false, false, false);

    initializeType(webServiceType, WebService.class, "WebService", false);
    property = getLocalProperty(webServiceType, 0);
    initializeProperty(property, this.getWebServiceOperation(), "WebServiceOperation", null, 1, 1, WebService.class, false, true, false, true , null);

    property = getLocalProperty(webServiceType, 1);
    initializeProperty(property, this.getWebServiceFaultCatch(), "WebServiceFaultCatch", null, 0, -1, WebService.class, false, false, false, true , null);

    property = getLocalProperty(webServiceType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, WebService.class, false, false, false);

    property = getLocalProperty(webServiceType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "InputMsgName", null, 1, 1, WebService.class, false, true, false);

    property = getLocalProperty(webServiceType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "OutputMsgName", null, 0, 1, WebService.class, false, true, false);

    property = getLocalProperty(webServiceType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, WebService.class, false, false, false);

    initializeType(webServiceFaultCatchType, WebServiceFaultCatch.class, "WebServiceFaultCatch", false);
    property = getLocalProperty(webServiceFaultCatchType, 0);
    initializeProperty(property, this.getMessageType(), "Message", null, 0, 1, WebServiceFaultCatch.class, false, true, false, true , null);

    property = getLocalProperty(webServiceFaultCatchType, 1);
    initializeProperty(property, this.getBlockActivity(), "BlockActivity", null, 0, 1, WebServiceFaultCatch.class, false, true, false, true , null);

    property = getLocalProperty(webServiceFaultCatchType, 2);
    initializeProperty(property, this.getTransitionRef(), "TransitionRef", null, 0, 1, WebServiceFaultCatch.class, false, true, false, true , null);

    property = getLocalProperty(webServiceFaultCatchType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, WebServiceFaultCatch.class, false, false, false);

    property = getLocalProperty(webServiceFaultCatchType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "FaultName", null, 0, 1, WebServiceFaultCatch.class, false, true, false);

    property = getLocalProperty(webServiceFaultCatchType, 5);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, WebServiceFaultCatch.class, false, false, false);

    initializeType(webServiceOperationType, WebServiceOperation.class, "WebServiceOperation", false);
    property = getLocalProperty(webServiceOperationType, 0);
    initializeProperty(property, this.getPartner(), "Partner", null, 0, 1, WebServiceOperation.class, false, true, false, true , null);

    property = getLocalProperty(webServiceOperationType, 1);
    initializeProperty(property, this.getService(), "Service", null, 0, 1, WebServiceOperation.class, false, true, false, true , null);

    property = getLocalProperty(webServiceOperationType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, WebServiceOperation.class, false, false, false);

    property = getLocalProperty(webServiceOperationType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "OperationName", null, 1, 1, WebServiceOperation.class, false, true, false);

    property = getLocalProperty(webServiceOperationType, 4);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, WebServiceOperation.class, false, false, false);

    initializeType(workflowProcessesType, WorkflowProcesses.class, "WorkflowProcesses", false);
    property = getLocalProperty(workflowProcessesType, 0);
    initializeProperty(property, this.getProcessType1(), "WorkflowProcess", null, 0, -1, WorkflowProcesses.class, false, false, false, true , null);

    property = getLocalProperty(workflowProcessesType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, WorkflowProcesses.class, false, false, false);

    property = getLocalProperty(workflowProcessesType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, WorkflowProcesses.class, false, false, false);

    initializeType(workingTimeType, WorkingTime.class, "WorkingTime", false);
    property = getLocalProperty(workingTimeType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, WorkingTime.class, false, true, false);

    property = getLocalProperty(workingTimeType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, WorkingTime.class, false, false, false);

    initializeType(xpdlVersionType, XPDLVersion.class, "XPDLVersion", false);
    property = getLocalProperty(xpdlVersionType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "value", null, 0, 1, XPDLVersion.class, false, true, false);

    property = getLocalProperty(xpdlVersionType, 1);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, XPDLVersion.class, false, false, false);

    initializeType(xsltType, Xslt.class, "Xslt", false);
    property = getLocalProperty(xsltType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Xslt.class, false, false, false);

    property = getLocalProperty(xsltType, 1);
    initializeProperty(property, theModelPackageImpl.getURI(), "location", null, 0, 1, Xslt.class, false, true, false);

    property = getLocalProperty(xsltType, 2);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Xslt.class, false, false, false);

    // Initialize data types
    initializeType(accessLevelType, String.class, "AccessLevel", true, false);

    initializeType(adHocOrderingType, String.class, "AdHocOrdering", true, false);

    initializeType(adHocOrdering1Type, String.class, "AdHocOrdering1", true, false);

    initializeType(artifactTypeType, String.class, "ArtifactType", true, false);

    initializeType(assignTimeType, String.class, "AssignTime", true, false);

    initializeType(associationDirectionType, String.class, "AssociationDirection", true, false);

    initializeType(directionType, String.class, "Direction", true, false);

    initializeType(durationUnitType, String.class, "DurationUnit", true, false);

    initializeType(endPointTypeType, String.class, "EndPointType", true, false);

    initializeType(executionType, String.class, "Execution", true, false);

    initializeType(execution1Type, String.class, "Execution1", true, false);

    initializeType(finishModeType, String.class, "FinishMode", true, false);

    initializeType(gatewayTypeType, String.class, "GatewayType", true, false);

    initializeType(graphConformanceType, String.class, "GraphConformance", true, false);

    initializeType(implementationType, String.class, "Implementation", true, false);

    initializeType(implementation1Type, String.class, "Implementation1", true, false);

    initializeType(implementation2Type, String.class, "Implementation2", true, false);

    initializeType(implementation3Type, String.class, "Implementation3", true, false);

    initializeType(implementation4Type, String.class, "Implementation4", true, false);

    initializeType(implementation5Type, String.class, "Implementation5", true, false);

    initializeType(implementation6Type, String.class, "Implementation6", true, false);

    initializeType(instantiationType, String.class, "Instantiation", true, false);

    initializeType(isArrayType, String.class, "IsArray", true, false);

    initializeType(loopTypeType, String.class, "LoopType", true, false);

    initializeType(mI_FlowConditionType, String.class, "MI_FlowCondition", true, false);

    initializeType(mI_OrderingType, String.class, "MI_Ordering", true, false);

    initializeType(modeType, String.class, "Mode", true, false);

    initializeType(orientationType, String.class, "Orientation", true, false);

    initializeType(processTypeType, String.class, "ProcessType", true, false);

    initializeType(publicationStatusType, String.class, "PublicationStatus", true, false);

    initializeType(resultType, String.class, "Result", true, false);

    initializeType(roleTypeType, String.class, "RoleType", true, false);

    initializeType(shapeType, String.class, "SHAPE", true, false);

    initializeType(startModeType, String.class, "StartMode", true, false);

    initializeType(statusType, String.class, "Status", true, false);

    initializeType(status1Type, String.class, "Status1", true, false);

    initializeType(testTimeType, String.class, "TestTime", true, false);

    initializeType(transactionMethodType, String.class, "TransactionMethod", true, false);

    initializeType(triggerType, String.class, "Trigger", true, false);

    initializeType(trigger1Type, String.class, "Trigger1", true, false);

    initializeType(typeType, String.class, "Type", true, false);

    initializeType(type1Type, String.class, "Type1", true, false);

    initializeType(type2Type, String.class, "Type2", true, false);

    initializeType(type3Type, String.class, "Type3", true, false);

    initializeType(type4Type, String.class, "Type4", true, false);

    createXSDMetaData(theXpdl1PackageImpl, theModelPackageImpl);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createAccessLevelFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAccessLevelToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createAdHocOrderingFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdHocOrderingToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createAdHocOrdering1FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdHocOrdering1ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createArtifactTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertArtifactTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createAssignTimeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignTimeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createAssociationDirectionFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssociationDirectionToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createDirectionFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDirectionToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createDurationUnitFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDurationUnitToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createEndPointTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEndPointTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createExecutionFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertExecutionToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createExecution1FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertExecution1ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createFinishModeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFinishModeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createGatewayTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertGatewayTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createGraphConformanceFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertGraphConformanceToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createImplementationFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImplementationToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createImplementation1FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImplementation1ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createImplementation2FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImplementation2ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createImplementation3FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImplementation3ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createImplementation4FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImplementation4ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createImplementation5FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImplementation5ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createImplementation6FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImplementation6ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createInstantiationFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertInstantiationToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createIsArrayFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIsArrayToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createLoopTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLoopTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createMI_FlowConditionFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMI_FlowConditionToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createMI_OrderingFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMI_OrderingToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createModeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertModeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createOrientationFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOrientationToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createProcessTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertProcessTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createPublicationStatusFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPublicationStatusToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createResultFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertResultToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createRoleTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRoleTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createSHAPEFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSHAPEToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createStartModeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStartModeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createStatusFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStatusToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createStatus1FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStatus1ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createTestTimeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTestTimeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createTransactionMethodFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTransactionMethodToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createTriggerFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTriggerToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createTrigger1FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTrigger1ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createType1FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertType1ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createType2FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertType2ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createType3FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertType3ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createType4FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertType4ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }  
  
  protected void createXSDMetaData(Xpdl1FactoryImpl theXpdl1PackageImpl, ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;

	this.createXSDMetaDataPart1(theXpdl1PackageImpl, theModelPackageImpl);
	property = this.createXSDMetaDataPart2(theXpdl1PackageImpl, theModelPackageImpl);
	this.createXSDMetaDataPart3(theXpdl1PackageImpl, theModelPackageImpl);
	this.createXSDMetaDataPart4(theXpdl1PackageImpl, theModelPackageImpl);
	this.createXSDMetaDataPart5(theXpdl1PackageImpl, theModelPackageImpl);

  }
  
  private void createXSDMetaDataPart1(Xpdl1FactoryImpl theXpdl1PackageImpl, ModelFactoryImpl theModelPackageImpl) {
	    addXSDMapping
	      (activitiesType,
	       new String[] 
	       {
	       "name", "Activities_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(activitiesType, ActivitiesImpl.INTERNAL_ACTIVITY),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Activity",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activitiesType, ActivitiesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(activitiesType, ActivitiesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (activityType,
	       new String[] 
	       {
	       "name", "Activity_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_LIMIT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Limit",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_ROUTE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Route",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Implementation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_BLOCK_ACTIVITY),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BlockActivity",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_BLOCK_ACTIVITY1),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BlockActivity",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_EVENT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Event",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_TRANSACTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Transaction",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_PERFORMER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Performer",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_PERFORMERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Performers",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_START_MODE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "StartMode",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_FINISH_MODE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FinishMode",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_PRIORITY),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Priority",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_DEADLINE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Deadline",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_DEADLINE1),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Deadline",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_SIMULATION_INFORMATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SimulationInformation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_ICON),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Icon",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_DOCUMENTATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Documentation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_TRANSITION_RESTRICTIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRestrictions",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_DATA_FIELDS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataFields",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_INPUT_SETS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "InputSets",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_OUTPUT_SETS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "OutputSets",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_IO_RULES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "IORules",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_LOOP),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Loop",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_ASSIGNMENTS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Assignments",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_NODE_GRAPHICS_INFOS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "NodeGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_EXTENSIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Extensions",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":29",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_START_ACTIVITY),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "StartActivity"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_STATUS),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Status"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_START_MODE1),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "StartMode"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_FINISH_MODE1),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "FinishMode"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_START_QUANTITY),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "StartQuantity"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_IS_ATRANSACTION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "IsATransaction"
	       });

	    addXSDMapping
	      (getProperty(activityType, ActivityImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":38",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (activitySetType,
	       new String[] 
	       {
	       "name", "ActivitySet_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_ACTIVITIES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Activities",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_TRANSITIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Transitions",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_AD_HOC),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AdHoc"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_AD_HOC_ORDERING),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AdHocOrdering"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_AD_HOC_COMPLETION_CONDITION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AdHocCompletionCondition"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_DEFAULT_START_ACTIVITY_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "DefaultStartActivityId"
	       });

	    addXSDMapping
	      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":10",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (activitySetsType,
	       new String[] 
	       {
	       "name", "ActivitySets_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(activitySetsType, ActivitySetsImpl.INTERNAL_ACTIVITY_SET),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActivitySet",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(activitySetsType, ActivitySetsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(activitySetsType, ActivitySetsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (actualParametersType,
	       new String[] 
	       {
	       "name", "ActualParameters_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(actualParametersType, ActualParametersImpl.INTERNAL_ACTUAL_PARAMETER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActualParameter",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(actualParametersType, ActualParametersImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(actualParametersType, ActualParametersImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (applicationType,
	       new String[] 
	       {
	       "name", "Application_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Type",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_FORMAL_PARAMETERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FormalParameters",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(applicationType, ApplicationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (applicationsType,
	       new String[] 
	       {
	       "name", "Applications_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(applicationsType, ApplicationsImpl.INTERNAL_APPLICATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Application",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationsType, ApplicationsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(applicationsType, ApplicationsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (applicationTypeType,
	       new String[] 
	       {
	       "name", "ApplicationType",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_EJB),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Ejb",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_POJO),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Pojo",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_XSLT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Xslt",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_SCRIPT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Script",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_WEB_SERVICE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebService",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_BUSINESS_RULE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BusinessRule",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_FORM),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Form",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(applicationTypeType, ApplicationTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (arrayTypeType,
	       new String[] 
	       {
	       "name", "ArrayType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_BASIC_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BasicType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_DECLARED_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DeclaredType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_SCHEMA_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SchemaType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_RECORD_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RecordType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_UNION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "UnionType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_ENUMERATION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_ARRAY_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ArrayType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_LIST_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ListType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_LOWER_INDEX),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LowerIndex"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_UPPER_INDEX),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "UpperIndex"
	       });

	    addXSDMapping
	      (getProperty(arrayTypeType, ArrayTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":11",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (artifactType,
	       new String[] 
	       {
	       "name", "Artifact_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_DATA_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataObject",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_NODE_GRAPHICS_INFOS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "NodeGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_ARTIFACT_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ArtifactType"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_TEXT_ANNOTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TextAnnotation"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_GROUP),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Group"
	       });

	    addXSDMapping
	      (getProperty(artifactType, ArtifactImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":9",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (artifactsType,
	       new String[] 
	       {
	       "name", "Artifacts_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(artifactsType, ArtifactsImpl.INTERNAL_GROUP),
	       new String[]
	       {
	       "kind", "group",
	       "name", "group:0"
	       });

	    addXSDMapping
	      (getProperty(artifactsType, ArtifactsImpl.INTERNAL_ARTIFACT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Artifact",
	       "namespace", "##targetNamespace",
	       "group", "#group:0"
	       });

	    addXSDMapping
	      (getProperty(artifactsType, ArtifactsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax",
	       "group", "#group:0"
	       });

	    addXSDMapping
	      (getProperty(artifactsType, ArtifactsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (assignmentType,
	       new String[] 
	       {
	       "name", "Assignment_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(assignmentType, AssignmentImpl.INTERNAL_TARGET),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Target",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(assignmentType, AssignmentImpl.INTERNAL_EXPRESSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Expression",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(assignmentType, AssignmentImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(assignmentType, AssignmentImpl.INTERNAL_ASSIGN_TIME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AssignTime"
	       });

	    addXSDMapping
	      (getProperty(assignmentType, AssignmentImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (assignmentsType,
	       new String[] 
	       {
	       "name", "Assignments_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(assignmentsType, AssignmentsImpl.INTERNAL_ASSIGNMENT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Assignment",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(assignmentsType, AssignmentsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(assignmentsType, AssignmentsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (associationType,
	       new String[] 
	       {
	       "name", "Association_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_CONNECTOR_GRAPHICS_INFOS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConnectorGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_SOURCE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Source"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_TARGET),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Target"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_ASSOCIATION_DIRECTION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AssociationDirection"
	       });

	    addXSDMapping
	      (getProperty(associationType, AssociationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (associationsType,
	       new String[] 
	       {
	       "name", "Associations_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(associationsType, AssociationsImpl.INTERNAL_GROUP),
	       new String[]
	       {
	       "kind", "group",
	       "name", "group:0"
	       });

	    addXSDMapping
	      (getProperty(associationsType, AssociationsImpl.INTERNAL_ASSOCIATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Association",
	       "namespace", "##targetNamespace",
	       "group", "#group:0"
	       });

	    addXSDMapping
	      (getProperty(associationsType, AssociationsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax",
	       "group", "#group:0"
	       });

	    addXSDMapping
	      (getProperty(associationsType, AssociationsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (authorType,
	       new String[] 
	       {
	       "name", "Author_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(authorType, AuthorImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(authorType, AuthorImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (basicTypeType,
	       new String[] 
	       {
	       "name", "BasicType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(basicTypeType, BasicTypeImpl.INTERNAL_LENGTH),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Length",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(basicTypeType, BasicTypeImpl.INTERNAL_PRECISION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Precision",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(basicTypeType, BasicTypeImpl.INTERNAL_SCALE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Scale",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(basicTypeType, BasicTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(basicTypeType, BasicTypeImpl.INTERNAL_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Type"
	       });

	    addXSDMapping
	      (getProperty(basicTypeType, BasicTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (blockActivityType,
	       new String[] 
	       {
	       "name", "BlockActivity_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(blockActivityType, BlockActivityImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(blockActivityType, BlockActivityImpl.INTERNAL_ACTIVITY_SET_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ActivitySetId"
	       });

	    addXSDMapping
	      (getProperty(blockActivityType, BlockActivityImpl.INTERNAL_START_ACTIVITY_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "StartActivityId"
	       });

	    addXSDMapping
	      (getProperty(blockActivityType, BlockActivityImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (businessRuleType,
	       new String[] 
	       {
	       "name", "BusinessRule_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(businessRuleType, BusinessRuleImpl.INTERNAL_RULE_NAME),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RuleName",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(businessRuleType, BusinessRuleImpl.INTERNAL_LOCATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Location",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(businessRuleType, BusinessRuleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(businessRuleType, BusinessRuleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (categoriesType,
	       new String[] 
	       {
	       "name", "Categories_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(categoriesType, CategoriesImpl.INTERNAL_CATEGORY),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Category",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(categoriesType, CategoriesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(categoriesType, CategoriesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (categoryType,
	       new String[] 
	       {
	       "name", "Category_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(categoryType, CategoryImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(categoryType, CategoryImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(categoryType, CategoryImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(categoryType, CategoryImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (class_Type,
	       new String[] 
	       {
	       "name", "Class_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(class_Type, ClassImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(class_Type, ClassImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (codepageType,
	       new String[] 
	       {
	       "name", "Codepage_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(codepageType, CodepageImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(codepageType, CodepageImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (conditionType,
	       new String[] 
	       {
	       "name", "Condition_._type",
	       "kind", "mixed"
	       });

	    addXSDMapping
	      (getProperty(conditionType, ConditionImpl.INTERNAL_MIXED),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "name", ":mixed"
	       });

	    addXSDMapping
	      (getProperty(conditionType, ConditionImpl.INTERNAL_XPRESSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Xpression",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(conditionType, ConditionImpl.INTERNAL_EXPRESSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Expression",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(conditionType, ConditionImpl.INTERNAL_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Type"
	       });

	    addXSDMapping
	      (getProperty(conditionType, ConditionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (conformanceClassType,
	       new String[] 
	       {
	       "name", "ConformanceClass_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(conformanceClassType, ConformanceClassImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(conformanceClassType, ConformanceClassImpl.INTERNAL_GRAPH_CONFORMANCE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "GraphConformance"
	       });

	    addXSDMapping
	      (getProperty(conformanceClassType, ConformanceClassImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (connectorGraphicsInfoType,
	       new String[] 
	       {
	       "name", "ConnectorGraphicsInfo_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_COORDINATES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Coordinates",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_TOOL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ToolId"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_IS_VISIBLE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "IsVisible"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_PAGE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Page"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_STYLE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Style"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_BORDER_COLOR),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "BorderColor"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_FILL_COLOR),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "FillColor"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfoType, ConnectorGraphicsInfoImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (connectorGraphicsInfosType,
	       new String[] 
	       {
	       "name", "ConnectorGraphicsInfos_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfosType, ConnectorGraphicsInfosImpl.INTERNAL_CONNECTOR_GRAPHICS_INFO),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConnectorGraphicsInfo",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfosType, ConnectorGraphicsInfosImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(connectorGraphicsInfosType, ConnectorGraphicsInfosImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (coordinatesType,
	       new String[] 
	       {
	       "name", "Coordinates_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(coordinatesType, CoordinatesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(coordinatesType, CoordinatesImpl.INTERNAL_XCOORDINATE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "XCoordinate"
	       });

	    addXSDMapping
	      (getProperty(coordinatesType, CoordinatesImpl.INTERNAL_YCOORDINATE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "YCoordinate"
	       });

	    addXSDMapping
	      (getProperty(coordinatesType, CoordinatesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (costType,
	       new String[] 
	       {
	       "name", "Cost_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(costType, CostImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(costType, CostImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (costUnitType,
	       new String[] 
	       {
	       "name", "CostUnit_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(costUnitType, CostUnitImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(costUnitType, CostUnitImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (countrykeyType,
	       new String[] 
	       {
	       "name", "Countrykey_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(countrykeyType, CountrykeyImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(countrykeyType, CountrykeyImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (createdType,
	       new String[] 
	       {
	       "name", "Created_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(createdType, CreatedImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(createdType, CreatedImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (dataFieldType,
	       new String[] 
	       {
	       "name", "DataField_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_DATA_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_INITIAL_VALUE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "InitialValue",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_LENGTH),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Length",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_IS_ARRAY),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "IsArray"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_CORRELATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Correlation"
	       });

	    addXSDMapping
	      (getProperty(dataFieldType, DataFieldImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":10",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (dataFieldsType,
	       new String[] 
	       {
	       "name", "DataFields_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(dataFieldsType, DataFieldsImpl.INTERNAL_DATA_FIELD),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataField",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataFieldsType, DataFieldsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(dataFieldsType, DataFieldsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (dataMappingType,
	       new String[] 
	       {
	       "name", "DataMapping_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(dataMappingType, DataMappingImpl.INTERNAL_ACTUAL),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Actual",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataMappingType, DataMappingImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(dataMappingType, DataMappingImpl.INTERNAL_FORMAL),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Formal"
	       });

	    addXSDMapping
	      (getProperty(dataMappingType, DataMappingImpl.INTERNAL_DIRECTION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Direction"
	       });

	    addXSDMapping
	      (getProperty(dataMappingType, DataMappingImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (dataMappingsType,
	       new String[] 
	       {
	       "name", "DataMappings_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(dataMappingsType, DataMappingsImpl.INTERNAL_DATA_MAPPING),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataMapping",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataMappingsType, DataMappingsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(dataMappingsType, DataMappingsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (dataObjectType,
	       new String[] 
	       {
	       "name", "DataObject_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_DATA_FIELDS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataFields",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_STATE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "State"
	       });

	  }

	  private Property createXSDMetaDataPart2(Xpdl1FactoryImpl theXpdl1PackageImpl, ModelFactoryImpl theModelPackageImpl) {
		  
		Property property = null;
	    
		addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_REQUIRED_FOR_START),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "RequiredForStart"
	       });

	    addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_PRODUCED_AT_COMPLETION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ProducedAtCompletion"
	       });

	    addXSDMapping
	      (getProperty(dataObjectType, DataObjectImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (dataTypeType,
	       new String[] 
	       {
	       "name", "DataType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_BASIC_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BasicType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_DECLARED_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DeclaredType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_SCHEMA_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SchemaType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_RECORD_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RecordType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_UNION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "UnionType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_ENUMERATION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_ARRAY_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ArrayType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_LIST_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ListType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(dataTypeType, DataTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":9",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (deadlineType,
	       new String[] 
	       {
	       "name", "Deadline_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(deadlineType, DeadlineImpl.INTERNAL_DEADLINE_DURATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DeadlineDuration",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(deadlineType, DeadlineImpl.INTERNAL_EXCEPTION_NAME),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExceptionName",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(deadlineType, DeadlineImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(deadlineType, DeadlineImpl.INTERNAL_EXECUTION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Execution"
	       });

	    addXSDMapping
	      (getProperty(deadlineType, DeadlineImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (declaredTypeType,
	       new String[] 
	       {
	       "name", "DeclaredType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(declaredTypeType, DeclaredTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(declaredTypeType, DeclaredTypeImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(declaredTypeType, DeclaredTypeImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(declaredTypeType, DeclaredTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (descriptionType,
	       new String[] 
	       {
	       "name", "Description_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(descriptionType, DescriptionImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(descriptionType, DescriptionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (documentationType,
	       new String[] 
	       {
	       "name", "Documentation_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(documentationType, DocumentationImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(documentationType, DocumentationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    property = createGlobalProperty
	      ("Activities",
	      this.getActivities(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Activities",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Activity",
	      this.getActivity(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Activity",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ActivitySet",
	      this.getActivitySet(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActivitySet",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ActivitySets",
	      this.getActivitySets(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActivitySets",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ActualParameters",
	      this.getActualParameters(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActualParameters",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Application",
	      this.getApplication(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Application",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Applications",
	      this.getApplications(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Applications",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ArrayType",
	      this.getArrayType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ArrayType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Artifact",
	      this.getArtifact(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Artifact",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Artifacts",
	      this.getArtifacts(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Artifacts",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Assignment",
	      this.getAssignment(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Assignment",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Assignments",
	      this.getAssignments(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Assignments",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Association",
	      this.getAssociation(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Association",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Associations",
	      this.getAssociations(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Associations",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Author",
	      this.getAuthor(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Author",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("BasicType",
	      this.getBasicType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BasicType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("BlockActivity",
	      this.getBlockActivity(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BlockActivity",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Categories",
	      this.getCategories(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Categories",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Category",
	      this.getCategory(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Category",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Codepage",
	      this.getCodepage(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Codepage",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Condition",
	      this.getCondition(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Condition",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ConformanceClass",
	      this.getConformanceClass(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConformanceClass",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ConnectorGraphicsInfo",
	      this.getConnectorGraphicsInfo(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConnectorGraphicsInfo",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ConnectorGraphicsInfos",
	      this.getConnectorGraphicsInfos(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConnectorGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Coordinates",
	      this.getCoordinates(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Coordinates",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Cost",
	      this.getCost(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Cost",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("CostUnit",
	      this.getCostUnit(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "CostUnit",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Countrykey",
	      this.getCountrykey(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Countrykey",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Created",
	      this.getCreated(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Created",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("DataField",
	      this.getDataField(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataField",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("DataFields",
	      this.getDataFields(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataFields",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("DataMapping",
	      this.getDataMapping(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataMapping",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("DataMappings",
	      this.getDataMappings(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataMappings",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("DataObject",
	      this.getDataObject(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataObject",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("DataType",
	      this.getDataType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Deadline",
	      this.getDeadline(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Deadline",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("DeclaredType",
	      this.getDeclaredType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DeclaredType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Description",
	      this.getDescription(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Documentation",
	      this.getDocumentation(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Documentation",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Duration",
	      this.getDuration(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Duration",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("EndEvent",
	      this.getEndEvent(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EndEvent",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("EndPoint",
	      this.getEndPoint(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EndPoint",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("EnumerationType",
	      this.getEnumerationType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("EnumerationValue",
	      this.getEnumerationValue(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationValue",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Event",
	      this.getEvent(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Event",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ExtendedAttribute",
	      this.getExtendedAttribute(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttribute",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ExtendedAttributes",
	      this.getExtendedAttributes(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ExternalPackage",
	      this.getExternalPackage(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalPackage",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ExternalPackages",
	      this.getExternalPackages(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalPackages",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ExternalReference",
	      this.getExternalReference(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("FormalParameter",
	      this.getFormalParameter(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FormalParameter",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("FormalParameters",
	      this.getFormalParameters(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FormalParameters",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Icon",
	      this.getIcon(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Icon",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Implementation",
	      this.getImplementation7(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Implementation",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Input",
	      this.getInput(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Input",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("InputSet",
	      this.getInputSet(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "InputSet",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("InputSets",
	      this.getInputSets(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "InputSets",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("IntermediateEvent",
	      this.getIntermediateEvent(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "IntermediateEvent",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("IORules",
	      this.getIORules(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "IORules",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Join",
	      this.getJoin(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Join",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Lane",
	      this.getLane(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Lane",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Lanes",
	      this.getLanes(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Lanes",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Length",
	      this.getLength(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Length",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Limit",
	      this.getLimit(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Limit",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ListType",
	      this.getListType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ListType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Loop",
	      this.getLoop(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Loop",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("LoopMultiInstance",
	      this.getLoopMultiInstance(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "LoopMultiInstance",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("LoopStandard",
	      this.getLoopStandard(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "LoopStandard",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Member",
	      this.getMember(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Member",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("MessageFlow",
	      this.getMessageFlow(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageFlow",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("MessageFlows",
	      this.getMessageFlows(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageFlows",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("No",
	      this.getNo(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "No",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("NodeGraphicsInfo",
	      this.getNodeGraphicsInfo(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "NodeGraphicsInfo",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("NodeGraphicsInfos",
	      this.getNodeGraphicsInfos(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "NodeGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Object",
	      this.getObject(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Output",
	      this.getOutput(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Output",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("OutputSet",
	      this.getOutputSet(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "OutputSet",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("OutputSets",
	      this.getOutputSets(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "OutputSets",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Package",
	      this.getPackageType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Package",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("PackageHeader",
	      this.getPackageHeader(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PackageHeader",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Participant",
	      this.getParticipant(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Participant",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Participants",
	      this.getParticipants(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Participants",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ParticipantType",
	      this.getParticipantType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ParticipantType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("PartnerLink",
	      this.getPartnerLink(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLink",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("PartnerLinks",
	      this.getPartnerLinks(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLinks",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("PartnerLinkType",
	      this.getPartnerLinkType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLinkType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("PartnerLinkTypes",
	      this.getPartnerLinkTypes(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLinkTypes",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Performer",
	      this.getPerformer(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Performer",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Performers",
	      this.getPerformers(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Performers",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Pool",
	      this.getPool(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Pool",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Pools",
	      this.getPools(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Pools",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Precision",
	      this.getPrecision(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Precision",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Priority",
	      this.getPriority(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Priority",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("PriorityUnit",
	      this.getPriorityUnit(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PriorityUnit",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ProcessHeader",
	      this.getProcessHeader(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ProcessHeader",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("RecordType",
	      this.getRecordType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RecordType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("RedefinableHeader",
	      this.getRedefinableHeader(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RedefinableHeader",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Reference",
	      this.getReference(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Reference",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Responsible",
	      this.getResponsible(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Responsible",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Responsibles",
	      this.getResponsibles(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Responsibles",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ResultCompensation",
	      this.getResultCompensation(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultCompensation",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ResultError",
	      this.getResultError(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultError",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ResultMultiple",
	      this.getResultMultiple(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultMultiple",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Route",
	      this.getRoute(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Route",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Rule",
	      this.getRule(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Rule",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Scale",
	      this.getScale(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Scale",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("SchemaType",
	      this.getSchemaType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SchemaType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Script",
	      this.getScript(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Script",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("SimulationInformation",
	      this.getSimulationInformation(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SimulationInformation",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Split",
	      this.getSplit(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Split",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("StartEvent",
	      this.getStartEvent(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "StartEvent",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("SubFlow",
	      this.getSubFlow(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SubFlow",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Task",
	      this.getTask(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Task",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskApplication",
	      this.getTaskApplication(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskApplication",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskManual",
	      this.getTaskManual(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskManual",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskReceive",
	      this.getTaskReceive(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskReceive",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskReference",
	      this.getTaskReference(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskReference",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskScript",
	      this.getTaskScript(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskScript",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskSend",
	      this.getTaskSend(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskSend",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskService",
	      this.getTaskService(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskService",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TaskUser",
	      this.getTaskUser(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskUser",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TimeEstimation",
	      this.getTimeEstimation(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TimeEstimation",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Transaction",
	      this.getTransaction(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Transaction",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Transition",
	      this.getTransition(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Transition",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TransitionRef",
	      this.getTransitionRef(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRef",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TransitionRefs",
	      this.getTransitionRefs(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRefs",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TransitionRestriction",
	      this.getTransitionRestriction(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRestriction",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TransitionRestrictions",
	      this.getTransitionRestrictions(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRestrictions",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Transitions",
	      this.getTransitions(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Transitions",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TriggerIntermediateMultiple",
	      this.getTriggerIntermediateMultiple(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerIntermediateMultiple",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TriggerMultiple",
	      this.getTriggerMultiple(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerMultiple",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TriggerResultLink",
	      this.getTriggerResultLink(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultLink",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TriggerResultMessage",
	      this.getTriggerResultMessage(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultMessage",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TriggerRule",
	      this.getTriggerRule(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerRule",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TriggerTimer",
	      this.getTriggerTimer(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerTimer",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TypeDeclaration",
	      this.getTypeDeclaration(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TypeDeclaration",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("TypeDeclarations",
	      this.getTypeDeclarations(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TypeDeclarations",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("UnionType",
	      this.getUnionType(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "UnionType",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ValidFrom",
	      this.getValidFrom(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ValidFrom",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("ValidTo",
	      this.getValidTo(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ValidTo",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Vendor",
	      this.getVendor(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Vendor",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("VendorExtension",
	      this.getVendorExtension(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "VendorExtension",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("VendorExtensions",
	      this.getVendorExtensions(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "VendorExtensions",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("Version",
	      this.getVersion(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Version",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("WaitingTime",
	      this.getWaitingTime(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WaitingTime",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("WebServiceFaultCatch",
	      this.getWebServiceFaultCatch(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceFaultCatch",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("WebServiceOperation",
	      this.getWebServiceOperation(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceOperation",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("WorkflowProcess",
	      this.getProcessType1(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WorkflowProcess",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("WorkflowProcesses",
	      this.getWorkflowProcesses(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WorkflowProcesses",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("WorkingTime",
	      this.getWorkingTime(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WorkingTime",
	       "namespace", "##targetNamespace"
	       });
	                
	    property = createGlobalProperty
	      ("XPDLVersion",
	      this.getXPDLVersion(),
	       new String[]
	       {
	       "kind", "element",
	       "name", "XPDLVersion",
	       "namespace", "##targetNamespace"
	       });
	                
	    addXSDMapping
	      (durationType,
	       new String[] 
	       {
	       "name", "Duration_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(durationType, DurationImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(durationType, DurationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (ejbType,
	       new String[] 
	       {
	       "name", "Ejb_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(ejbType, EjbImpl.INTERNAL_JNDI_NAME),
	       new String[]
	       {
	       "kind", "element",
	       "name", "JndiName",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(ejbType, EjbImpl.INTERNAL_HOME_CLASS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "HomeClass",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(ejbType, EjbImpl.INTERNAL_METHOD),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Method",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(ejbType, EjbImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(ejbType, EjbImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (endEventType,
	       new String[] 
	       {
	       "name", "EndEvent_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_TRIGGER_RESULT_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultMessage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_RESULT_ERROR),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultError",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_RESULT_COMPENSATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultCompensation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_TRIGGER_RESULT_LINK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultLink",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_RESULT_MULTIPLE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultMultiple",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_RESULT),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Result"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Implementation"
	       });

	    addXSDMapping
	      (getProperty(endEventType, EndEventImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (endPointType,
	       new String[] 
	       {
	       "name", "EndPoint_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(endPointType, EndPointImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(endPointType, EndPointImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(endPointType, EndPointImpl.INTERNAL_END_POINT_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "EndPointType"
	       });

	    addXSDMapping
	      (getProperty(endPointType, EndPointImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (enumerationTypeType,
	       new String[] 
	       {
	       "name", "EnumerationType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(enumerationTypeType, EnumerationTypeImpl.INTERNAL_ENUMERATION_VALUE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationValue",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(enumerationTypeType, EnumerationTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(enumerationTypeType, EnumerationTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (enumerationValueType,
	       new String[] 
	       {
	       "name", "EnumerationValue_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(enumerationValueType, EnumerationValueImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(enumerationValueType, EnumerationValueImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(enumerationValueType, EnumerationValueImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (eventType,
	       new String[] 
	       {
	       "name", "Event_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(eventType, EventImpl.INTERNAL_START_EVENT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "StartEvent",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(eventType, EventImpl.INTERNAL_INTERMEDIATE_EVENT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "IntermediateEvent",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(eventType, EventImpl.INTERNAL_END_EVENT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EndEvent",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(eventType, EventImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (exceptionNameType,
	       new String[] 
	       {
	       "name", "ExceptionName_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(exceptionNameType, ExceptionNameImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(exceptionNameType, ExceptionNameImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (expressionTypeType,
	       new String[] 
	       {
	       "name", "ExpressionType",
	       "kind", "mixed"
	       });

	    addXSDMapping
	      (getProperty(expressionTypeType, ExpressionTypeImpl.INTERNAL_MIXED),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "name", ":mixed"
	       });

	    addXSDMapping
	      (getProperty(expressionTypeType, ExpressionTypeImpl.INTERNAL_GROUP),
	       new String[]
	       {
	       "kind", "group",
	       "name", "group:1"
	       });

	    addXSDMapping
	      (getProperty(expressionTypeType, ExpressionTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##any",
	       "name", ":2",
	       "processing", "lax",
	       "group", "#group:1"
	       });

	    addXSDMapping
	      (getProperty(expressionTypeType, ExpressionTypeImpl.INTERNAL_SCRIPT_GRAMMAR),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ScriptGrammar"
	       });

	    addXSDMapping
	      (getProperty(expressionTypeType, ExpressionTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (extendedAttributeType,
	       new String[] 
	       {
	       "name", "ExtendedAttribute_._type",
	       "kind", "mixed"
	       });

	    addXSDMapping
	      (getProperty(extendedAttributeType, ExtendedAttributeImpl.INTERNAL_MIXED),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "name", ":mixed"
	       });

	    addXSDMapping
	      (getProperty(extendedAttributeType, ExtendedAttributeImpl.INTERNAL_GROUP),
	       new String[]
	       {
	       "kind", "group",
	       "name", "group:1"
	       });
	    
	    return property;
	  }

	  private void createXSDMetaDataPart3(Xpdl1FactoryImpl theXpdl1PackageImpl, ModelFactoryImpl theModelPackageImpl) {
	   addXSDMapping
	      (getProperty(extendedAttributeType, ExtendedAttributeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax",
	       "group", "#group:1"
	       });

	    addXSDMapping
	      (getProperty(extendedAttributeType, ExtendedAttributeImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(extendedAttributeType, ExtendedAttributeImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Value"
	       });

	    addXSDMapping
	      (extendedAttributesType,
	       new String[] 
	       {
	       "name", "ExtendedAttributes_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(extendedAttributesType, ExtendedAttributesImpl.INTERNAL_EXTENDED_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttribute",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (externalPackageType,
	       new String[] 
	       {
	       "name", "ExternalPackage_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(externalPackageType, ExternalPackageImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(externalPackageType, ExternalPackageImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(externalPackageType, ExternalPackageImpl.INTERNAL_HREF),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "href"
	       });

	    addXSDMapping
	      (getProperty(externalPackageType, ExternalPackageImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(externalPackageType, ExternalPackageImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(externalPackageType, ExternalPackageImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (externalPackagesType,
	       new String[] 
	       {
	       "name", "ExternalPackages_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(externalPackagesType, ExternalPackagesImpl.INTERNAL_EXTERNAL_PACKAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalPackage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(externalPackagesType, ExternalPackagesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(externalPackagesType, ExternalPackagesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (externalReferenceType,
	       new String[] 
	       {
	       "name", "ExternalReference_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(externalReferenceType, ExternalReferenceImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(externalReferenceType, ExternalReferenceImpl.INTERNAL_XREF),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "xref"
	       });

	    addXSDMapping
	      (getProperty(externalReferenceType, ExternalReferenceImpl.INTERNAL_LOCATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "location"
	       });

	    addXSDMapping
	      (getProperty(externalReferenceType, ExternalReferenceImpl.INTERNAL_NAMESPACE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "namespace"
	       });

	    addXSDMapping
	      (getProperty(externalReferenceType, ExternalReferenceImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (formType,
	       new String[] 
	       {
	       "name", "Form_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(formType, FormImpl.INTERNAL_FORM_LAYOUT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FormLayout",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(formType, FormImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(formType, FormImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (formalParameterType,
	       new String[] 
	       {
	       "name", "FormalParameter_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_DATA_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_LENGTH),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Length",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_MODE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Mode"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_IS_ARRAY),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "IsArray"
	       });

	    addXSDMapping
	      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (formalParametersType,
	       new String[] 
	       {
	       "name", "FormalParameters_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(formalParametersType, FormalParametersImpl.INTERNAL_FORMAL_PARAMETER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FormalParameter",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(formalParametersType, FormalParametersImpl.INTERNAL_FORMAL_PARAMETER1),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FormalParameter",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(formalParametersType, FormalParametersImpl.INTERNAL_EXTENSIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Extensions",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(formalParametersType, FormalParametersImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(formalParametersType, FormalParametersImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (formLayoutType,
	       new String[] 
	       {
	       "name", "FormLayout_._type",
	       "kind", "mixed"
	       });

	    addXSDMapping
	      (getProperty(formLayoutType, FormLayoutImpl.INTERNAL_MIXED),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "name", ":mixed"
	       });

	    addXSDMapping
	      (homeClassType,
	       new String[] 
	       {
	       "name", "HomeClass_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(homeClassType, HomeClassImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(homeClassType, HomeClassImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (iconType,
	       new String[] 
	       {
	       "name", "Icon_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(iconType, IconImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(iconType, IconImpl.INTERNAL_XCOORD),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "XCOORD"
	       });

	    addXSDMapping
	      (getProperty(iconType, IconImpl.INTERNAL_YCOORD),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "YCOORD"
	       });

	    addXSDMapping
	      (getProperty(iconType, IconImpl.INTERNAL_WIDTH),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "WIDTH"
	       });

	    addXSDMapping
	      (getProperty(iconType, IconImpl.INTERNAL_HEIGHT),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "HEIGHT"
	       });

	    addXSDMapping
	      (getProperty(iconType, IconImpl.INTERNAL_SHAPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "SHAPE"
	       });

	    addXSDMapping
	      (getProperty(iconType, IconImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":6",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (implementation7Type,
	       new String[] 
	       {
	       "name", "Implementation_._7_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(implementation7Type, Implementation7Impl.INTERNAL_NO),
	       new String[]
	       {
	       "kind", "element",
	       "name", "No",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(implementation7Type, Implementation7Impl.INTERNAL_TOOL),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Tool",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(implementation7Type, Implementation7Impl.INTERNAL_TASK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Task",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(implementation7Type, Implementation7Impl.INTERNAL_SUB_FLOW),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SubFlow",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(implementation7Type, Implementation7Impl.INTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Reference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(implementation7Type, Implementation7Impl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (inputType,
	       new String[] 
	       {
	       "name", "Input_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(inputType, InputImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(inputType, InputImpl.INTERNAL_ARTIFACT_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ArtifactId"
	       });

	    addXSDMapping
	      (getProperty(inputType, InputImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (inputSetType,
	       new String[] 
	       {
	       "name", "InputSet_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(inputSetType, InputSetImpl.INTERNAL_INPUT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Input",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(inputSetType, InputSetImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(inputSetType, InputSetImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (inputSetsType,
	       new String[] 
	       {
	       "name", "InputSets_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(inputSetsType, InputSetsImpl.INTERNAL_INPUT_SET),
	       new String[]
	       {
	       "kind", "element",
	       "name", "InputSet",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(inputSetsType, InputSetsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(inputSetsType, InputSetsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (intermediateEventType,
	       new String[] 
	       {
	       "name", "IntermediateEvent_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_TRIGGER_RESULT_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultMessage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_TRIGGER_TIMER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerTimer",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_RESULT_ERROR),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultError",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_RESULT_COMPENSATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultCompensation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_TRIGGER_RULE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerRule",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_TRIGGER_RESULT_LINK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultLink",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerIntermediateMultiple",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_TRIGGER),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Trigger"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Implementation"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_TARGET),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Target"
	       });

	    addXSDMapping
	      (getProperty(intermediateEventType, IntermediateEventImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":10",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (ioRulesType,
	       new String[] 
	       {
	       "name", "IORules_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(ioRulesType, IORulesImpl.INTERNAL_EXPRESSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Expression",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(ioRulesType, IORulesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(ioRulesType, IORulesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (jndiNameType,
	       new String[] 
	       {
	       "name", "JndiName_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(jndiNameType, JndiNameImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(jndiNameType, JndiNameImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (joinType,
	       new String[] 
	       {
	       "name", "Join_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(joinType, JoinImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(joinType, JoinImpl.INTERNAL_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Type"
	       });

	    addXSDMapping
	      (getProperty(joinType, JoinImpl.INTERNAL_INCOMING_CONDTION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "IncomingCondtion"
	       });

	    addXSDMapping
	      (getProperty(joinType, JoinImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (laneType,
	       new String[] 
	       {
	       "name", "Lane_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_NODE_GRAPHICS_INFOS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "NodeGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_PARENT_LANE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ParentLane"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_PARENT_POOL),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ParentPool"
	       });

	    addXSDMapping
	      (getProperty(laneType, LaneImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (lanesType,
	       new String[] 
	       {
	       "name", "Lanes_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(lanesType, LanesImpl.INTERNAL_LANE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Lane",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(lanesType, LanesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(lanesType, LanesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (lengthType,
	       new String[] 
	       {
	       "name", "Length_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(lengthType, LengthImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(lengthType, LengthImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (limitType,
	       new String[] 
	       {
	       "name", "Limit_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(limitType, LimitImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(limitType, LimitImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (listTypeType,
	       new String[] 
	       {
	       "name", "ListType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_BASIC_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BasicType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_DECLARED_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DeclaredType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_SCHEMA_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SchemaType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_RECORD_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RecordType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_UNION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "UnionType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_ENUMERATION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_ARRAY_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ArrayType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_LIST_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ListType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(listTypeType, ListTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":9",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (locationType,
	       new String[] 
	       {
	       "name", "Location_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(locationType, LocationImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(locationType, LocationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (loopType,
	       new String[] 
	       {
	       "name", "Loop_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(loopType, LoopImpl.INTERNAL_LOOP_STANDARD),
	       new String[]
	       {
	       "kind", "element",
	       "name", "LoopStandard",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(loopType, LoopImpl.INTERNAL_LOOP_MULTI_INSTANCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "LoopMultiInstance",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(loopType, LoopImpl.INTERNAL_LOOP_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LoopType"
	       });

	    addXSDMapping
	      (getProperty(loopType, LoopImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (loopMultiInstanceType,
	       new String[] 
	       {
	       "name", "LoopMultiInstance_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(loopMultiInstanceType, LoopMultiInstanceImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(loopMultiInstanceType, LoopMultiInstanceImpl.INTERNAL_MI_CONDITION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "MI_Condition"
	       });

	    addXSDMapping
	      (getProperty(loopMultiInstanceType, LoopMultiInstanceImpl.INTERNAL_LOOP_COUNTER),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LoopCounter"
	       });

	    addXSDMapping
	      (getProperty(loopMultiInstanceType, LoopMultiInstanceImpl.INTERNAL_MI_ORDERING),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "MI_Ordering"
	       });

	    addXSDMapping
	      (getProperty(loopMultiInstanceType, LoopMultiInstanceImpl.INTERNAL_MI_FLOW_CONDITION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "MI_FlowCondition"
	       });

	    addXSDMapping
	      (getProperty(loopMultiInstanceType, LoopMultiInstanceImpl.INTERNAL_COMPLEX_MI_FLOW_CONDITION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ComplexMI_FlowCondition"
	       });

	    addXSDMapping
	      (getProperty(loopMultiInstanceType, LoopMultiInstanceImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":6",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (loopStandardType,
	       new String[] 
	       {
	       "name", "LoopStandard_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(loopStandardType, LoopStandardImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(loopStandardType, LoopStandardImpl.INTERNAL_LOOP_CONDITION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LoopCondition"
	       });

	    addXSDMapping
	      (getProperty(loopStandardType, LoopStandardImpl.INTERNAL_LOOP_COUNTER),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LoopCounter"
	       });

	    addXSDMapping
	      (getProperty(loopStandardType, LoopStandardImpl.INTERNAL_LOOP_MAXIMUM),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LoopMaximum"
	       });

	    addXSDMapping
	      (getProperty(loopStandardType, LoopStandardImpl.INTERNAL_TEST_TIME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TestTime"
	       });

	    addXSDMapping
	      (getProperty(loopStandardType, LoopStandardImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (memberType,
	       new String[] 
	       {
	       "name", "Member_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_BASIC_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BasicType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_DECLARED_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DeclaredType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_SCHEMA_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SchemaType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_RECORD_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RecordType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_UNION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "UnionType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_ENUMERATION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_ARRAY_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ArrayType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_LIST_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ListType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(memberType, MemberImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":9",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (messageFlowType,
	       new String[] 
	       {
	       "name", "MessageFlow_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Message",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_CONNECTOR_GRAPHICS_INFOS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConnectorGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_SOURCE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Source"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_TARGET),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Target"
	       });

	    addXSDMapping
	      (getProperty(messageFlowType, MessageFlowImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (messageFlowsType,
	       new String[] 
	       {
	       "name", "MessageFlows_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(messageFlowsType, MessageFlowsImpl.INTERNAL_GROUP),
	       new String[]
	       {
	       "kind", "group",
	       "name", "group:0"
	       });

	    addXSDMapping
	      (getProperty(messageFlowsType, MessageFlowsImpl.INTERNAL_MESSAGE_FLOW),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageFlow",
	       "namespace", "##targetNamespace",
	       "group", "#group:0"
	       });

	    addXSDMapping
	      (getProperty(messageFlowsType, MessageFlowsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax",
	       "group", "#group:0"
	       });

	    addXSDMapping
	      (getProperty(messageFlowsType, MessageFlowsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (messageTypeType,
	       new String[] 
	       {
	       "name", "MessageType",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_ACTUAL_PARAMETERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActualParameters",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_DATA_MAPPINGS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataMappings",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_FROM),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "From"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_TO),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "To"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_FAULT_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "FaultName"
	       });

	    addXSDMapping
	      (getProperty(messageTypeType, MessageTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (methodType,
	       new String[] 
	       {
	       "name", "Method_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(methodType, MethodImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(methodType, MethodImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (method1Type,
	       new String[] 
	       {
	       "name", "Method_._1_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(method1Type, Method1Impl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(method1Type, Method1Impl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (myRoleType,
	       new String[] 
	       {
	       "name", "MyRole_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(myRoleType, MyRoleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(myRoleType, MyRoleImpl.INTERNAL_ROLE_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "RoleName"
	       });

	    addXSDMapping
	      (getProperty(myRoleType, MyRoleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (noType,
	       new String[] 
	       {
	       "name", "No_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(noType, NoImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(noType, NoImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (nodeGraphicsInfoType,
	       new String[] 
	       {
	       "name", "NodeGraphicsInfo_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_COORDINATES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Coordinates",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_TOOL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ToolId"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_IS_VISIBLE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "IsVisible"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_PAGE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Page"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_LANE_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LaneId"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_HEIGHT),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Height"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_WIDTH),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Width"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_BORDER_COLOR),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "BorderColor"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_FILL_COLOR),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "FillColor"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_SHAPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Shape"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfoType, NodeGraphicsInfoImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":11",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (nodeGraphicsInfosType,
	       new String[] 
	       {
	       "name", "NodeGraphicsInfos_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfosType, NodeGraphicsInfosImpl.INTERNAL_NODE_GRAPHICS_INFO),
	       new String[]
	       {
	       "kind", "element",
	       "name", "NodeGraphicsInfo",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfosType, NodeGraphicsInfosImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(nodeGraphicsInfosType, NodeGraphicsInfosImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (objectType,
	       new String[] 
	       {
	       "name", "Object_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(objectType, ObjectImpl.INTERNAL_CATEGORIES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Categories",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(objectType, ObjectImpl.INTERNAL_DOCUMENTATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Documentation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(objectType, ObjectImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(objectType, ObjectImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(objectType, ObjectImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(objectType, ObjectImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (outputType,
	       new String[] 
	       {
	       "name", "Output_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(outputType, OutputImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(outputType, OutputImpl.INTERNAL_ARTIFACT_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ArtifactId"
	       });

	    addXSDMapping
	      (getProperty(outputType, OutputImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (outputSetType,
	       new String[] 
	       {
	       "name", "OutputSet_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(outputSetType, OutputSetImpl.INTERNAL_OUTPUT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Output",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(outputSetType, OutputSetImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(outputSetType, OutputSetImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (outputSetsType,
	       new String[] 
	       {
	       "name", "OutputSets_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(outputSetsType, OutputSetsImpl.INTERNAL_OUTPUT_SET),
	       new String[]
	       {
	       "kind", "element",
	       "name", "OutputSet",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(outputSetsType, OutputSetsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(outputSetsType, OutputSetsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (packageHeaderType,
	       new String[] 
	       {
	       "name", "PackageHeader_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_XPDL_VERSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "XPDLVersion",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_VENDOR),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Vendor",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_CREATED),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Created",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_DOCUMENTATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Documentation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_PRIORITY_UNIT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PriorityUnit",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_COST_UNIT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "CostUnit",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_VENDOR_EXTENSIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "VendorExtensions",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(packageHeaderType, PackageHeaderImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":9",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (packageTypeType,
	       new String[] 
	       {
	       "name", "PackageType",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_PACKAGE_HEADER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PackageHeader",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_REDEFINABLE_HEADER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RedefinableHeader",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_CONFORMANCE_CLASS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConformanceClass",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_SCRIPT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Script",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_EXTERNAL_PACKAGES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalPackages",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_TYPE_DECLARATIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TypeDeclarations",
	       "namespace", "##targetNamespace"
	       });
	  }

	  private void createXSDMetaDataPart4(Xpdl1FactoryImpl theXpdl1PackageImpl, ModelFactoryImpl theModelPackageImpl) {
	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_PARTICIPANTS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Participants",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_APPLICATIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Applications",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_DATA_FIELDS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataFields",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_PARTNER_LINK_TYPES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLinkTypes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_POOLS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Pools",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_MESSAGE_FLOWS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageFlows",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_ASSOCIATIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Associations",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_ARTIFACTS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Artifacts",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_WORKFLOW_PROCESSES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WorkflowProcesses",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":16",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(packageTypeType, PackageTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":19",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (participantType,
	       new String[] 
	       {
	       "name", "Participant_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_PARTICIPANT_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ParticipantType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(participantType, ParticipantImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (participantsType,
	       new String[] 
	       {
	       "name", "Participants_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(participantsType, ParticipantsImpl.INTERNAL_PARTICIPANT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Participant",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(participantsType, ParticipantsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(participantsType, ParticipantsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (participantTypeType,
	       new String[] 
	       {
	       "name", "ParticipantType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(participantTypeType, ParticipantTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(participantTypeType, ParticipantTypeImpl.INTERNAL_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Type"
	       });

	    addXSDMapping
	      (getProperty(participantTypeType, ParticipantTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (partnerType,
	       new String[] 
	       {
	       "name", "Partner_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(partnerType, PartnerImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(partnerType, PartnerImpl.INTERNAL_PARTNER_LINK_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "PartnerLinkId"
	       });

	    addXSDMapping
	      (getProperty(partnerType, PartnerImpl.INTERNAL_ROLE_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "RoleType"
	       });

	    addXSDMapping
	      (getProperty(partnerType, PartnerImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (partnerLinkType,
	       new String[] 
	       {
	       "name", "PartnerLink_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkType, PartnerLinkImpl.INTERNAL_MY_ROLE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MyRole",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkType, PartnerLinkImpl.INTERNAL_PARTNER_ROLE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerRole",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkType, PartnerLinkImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkType, PartnerLinkImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "name"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkType, PartnerLinkImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkType, PartnerLinkImpl.INTERNAL_PARTNER_LINK_TYPE_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "PartnerLinkTypeId"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkType, PartnerLinkImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":6",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (partnerLinksType,
	       new String[] 
	       {
	       "name", "PartnerLinks_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(partnerLinksType, PartnerLinksImpl.INTERNAL_PARTNER_LINK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLink",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(partnerLinksType, PartnerLinksImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(partnerLinksType, PartnerLinksImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (partnerLinkTypeType,
	       new String[] 
	       {
	       "name", "PartnerLinkType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypeType, PartnerLinkTypeImpl.INTERNAL_ROLE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Role",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypeType, PartnerLinkTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypeType, PartnerLinkTypeImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypeType, PartnerLinkTypeImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "name"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypeType, PartnerLinkTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (partnerLinkTypesType,
	       new String[] 
	       {
	       "name", "PartnerLinkTypes_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypesType, PartnerLinkTypesImpl.INTERNAL_PARTNER_LINK_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLinkType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypesType, PartnerLinkTypesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(partnerLinkTypesType, PartnerLinkTypesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (partnerRoleType,
	       new String[] 
	       {
	       "name", "PartnerRole_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(partnerRoleType, PartnerRoleImpl.INTERNAL_END_POINT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EndPoint",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(partnerRoleType, PartnerRoleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(partnerRoleType, PartnerRoleImpl.INTERNAL_ROLE_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "RoleName"
	       });

	    addXSDMapping
	      (getProperty(partnerRoleType, PartnerRoleImpl.INTERNAL_SERVICE_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ServiceName"
	       });

	    addXSDMapping
	      (getProperty(partnerRoleType, PartnerRoleImpl.INTERNAL_PORT_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "PortName"
	       });

	    addXSDMapping
	      (getProperty(partnerRoleType, PartnerRoleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (performerType,
	       new String[] 
	       {
	       "name", "Performer_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(performerType, PerformerImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(performerType, PerformerImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (performersType,
	       new String[] 
	       {
	       "name", "Performers_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(performersType, PerformersImpl.INTERNAL_PERFORMER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Performer",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(performersType, PerformersImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(performersType, PerformersImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (pojoType,
	       new String[] 
	       {
	       "name", "Pojo_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(pojoType, PojoImpl.INTERNAL_CLASS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Class",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(pojoType, PojoImpl.INTERNAL_METHOD),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Method",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(pojoType, PojoImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(pojoType, PojoImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (poolType,
	       new String[] 
	       {
	       "name", "Pool_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_LANES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Lanes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_NODE_GRAPHICS_INFOS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "NodeGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_ORIENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Orientation"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_PROCESS),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Process"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_PARTICIPANT),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Participant"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_BOUNDARY_VISIBLE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "BoundaryVisible"
	       });

	    addXSDMapping
	      (getProperty(poolType, PoolImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":10",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (poolsType,
	       new String[] 
	       {
	       "name", "Pools_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(poolsType, PoolsImpl.INTERNAL_POOL),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Pool",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(poolsType, PoolsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(poolsType, PoolsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (precisionType,
	       new String[] 
	       {
	       "name", "Precision_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(precisionType, PrecisionImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(precisionType, PrecisionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (priorityType,
	       new String[] 
	       {
	       "name", "Priority_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(priorityType, PriorityImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(priorityType, PriorityImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (priorityUnitType,
	       new String[] 
	       {
	       "name", "PriorityUnit_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(priorityUnitType, PriorityUnitImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(priorityUnitType, PriorityUnitImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (processHeaderType,
	       new String[] 
	       {
	       "name", "ProcessHeader_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_CREATED),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Created",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_PRIORITY),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Priority",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_LIMIT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Limit",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_VALID_FROM),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ValidFrom",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_VALID_TO),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ValidTo",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_TIME_ESTIMATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TimeEstimation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_DURATION_UNIT),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "DurationUnit"
	       });

	    addXSDMapping
	      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":9",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (processType1Type,
	       new String[] 
	       {
	       "name", "ProcessType",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_PROCESS_HEADER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ProcessHeader",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_REDEFINABLE_HEADER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RedefinableHeader",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_FORMAL_PARAMETERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "FormalParameters",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_PARTICIPANTS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Participants",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_APPLICATIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Applications",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_DATA_FIELDS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataFields",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_DATA_FIELDS1),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataFields",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_PARTICIPANTS1),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Participants",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_APPLICATIONS1),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Applications",
	       "namespace", "http://www.wfmc.org/2002/XPDL1.0"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ACTIVITY_SETS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActivitySets",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ACTIVITIES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Activities",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_TRANSITIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Transitions",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ASSIGNMENTS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Assignments",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_PARTNER_LINKS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "PartnerLinks",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_EXTENSIONS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Extensions",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":17",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ACCESS_LEVEL),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AccessLevel"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_PROCESS_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ProcessType"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_STATUS),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Status"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_SUPPRESS_JOIN_FAILURE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "SuppressJoinFailure"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ENABLE_INSTANCE_COMPENSATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "EnableInstanceCompensation"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_AD_HOC),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AdHoc"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_AD_HOC_ORDERING),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AdHocOrdering"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_AD_HOC_COMPLETION_CONDITION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "AdHocCompletionCondition"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_DEFAULT_START_ACTIVITY_SET_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "DefaultStartActivitySetId"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_DEFAULT_START_ACTIVITY_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "DefaultStartActivityId"
	       });

	    addXSDMapping
	      (getProperty(processType1Type, ProcessType1Impl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":30",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (recordTypeType,
	       new String[] 
	       {
	       "name", "RecordType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(recordTypeType, RecordTypeImpl.INTERNAL_MEMBER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Member",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(recordTypeType, RecordTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(recordTypeType, RecordTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (redefinableHeaderType,
	       new String[] 
	       {
	       "name", "RedefinableHeader_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_AUTHOR),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Author",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_VERSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Version",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_CODEPAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Codepage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_COUNTRYKEY),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Countrykey",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_RESPONSIBLES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Responsibles",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_PUBLICATION_STATUS),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "PublicationStatus"
	       });

	    addXSDMapping
	      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (referenceType,
	       new String[] 
	       {
	       "name", "Reference_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(referenceType, ReferenceImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(referenceType, ReferenceImpl.INTERNAL_ACTIVITY_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ActivityId"
	       });

	    addXSDMapping
	      (getProperty(referenceType, ReferenceImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (responsibleType,
	       new String[] 
	       {
	       "name", "Responsible_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(responsibleType, ResponsibleImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(responsibleType, ResponsibleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (responsiblesType,
	       new String[] 
	       {
	       "name", "Responsibles_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(responsiblesType, ResponsiblesImpl.INTERNAL_RESPONSIBLE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Responsible",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(responsiblesType, ResponsiblesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(responsiblesType, ResponsiblesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (resultCompensationType,
	       new String[] 
	       {
	       "name", "ResultCompensation_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(resultCompensationType, ResultCompensationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(resultCompensationType, ResultCompensationImpl.INTERNAL_ACTIVITY_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ActivityId"
	       });

	    addXSDMapping
	      (getProperty(resultCompensationType, ResultCompensationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (resultErrorType,
	       new String[] 
	       {
	       "name", "ResultError_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(resultErrorType, ResultErrorImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(resultErrorType, ResultErrorImpl.INTERNAL_ERROR_CODE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ErrorCode"
	       });

	    addXSDMapping
	      (getProperty(resultErrorType, ResultErrorImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (resultMultipleType,
	       new String[] 
	       {
	       "name", "ResultMultiple_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(resultMultipleType, ResultMultipleImpl.INTERNAL_TRIGGER_RESULT_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultMessage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(resultMultipleType, ResultMultipleImpl.INTERNAL_TRIGGER_RESULT_LINK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultLink",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(resultMultipleType, ResultMultipleImpl.INTERNAL_RESULT_COMPENSATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultCompensation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(resultMultipleType, ResultMultipleImpl.INTERNAL_RESULT_ERROR),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultError",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(resultMultipleType, ResultMultipleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(resultMultipleType, ResultMultipleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (roleType,
	       new String[] 
	       {
	       "name", "Role_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(roleType, RoleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(roleType, RoleImpl.INTERNAL_PORT_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "portType"
	       });

	    addXSDMapping
	      (getProperty(roleType, RoleImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(roleType, RoleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (routeType,
	       new String[] 
	       {
	       "name", "Route_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(routeType, RouteImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(routeType, RouteImpl.INTERNAL_GATEWAY_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "GatewayType"
	       });

	    addXSDMapping
	      (getProperty(routeType, RouteImpl.INTERNAL_INSTANTIATE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Instantiate"
	       });

	    addXSDMapping
	      (getProperty(routeType, RouteImpl.INTERNAL_MARKER_VISIBLE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "MarkerVisible"
	       });

	    addXSDMapping
	      (getProperty(routeType, RouteImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (ruleType,
	       new String[] 
	       {
	       "name", "Rule_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(ruleType, RuleImpl.INTERNAL_EXPRESSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Expression",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(ruleType, RuleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(ruleType, RuleImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(ruleType, RuleImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(ruleType, RuleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (ruleNameType,
	       new String[] 
	       {
	       "name", "RuleName_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(ruleNameType, RuleNameImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(ruleNameType, RuleNameImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (scaleType,
	       new String[] 
	       {
	       "name", "Scale_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(scaleType, ScaleImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(scaleType, ScaleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (schemaTypeType,
	       new String[] 
	       {
	       "name", "SchemaType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(schemaTypeType, SchemaTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(schemaTypeType, SchemaTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (scriptType,
	       new String[] 
	       {
	       "name", "Script_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(scriptType, ScriptImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(scriptType, ScriptImpl.INTERNAL_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Type"
	       });

	    addXSDMapping
	      (getProperty(scriptType, ScriptImpl.INTERNAL_VERSION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Version"
	       });

	    addXSDMapping
	      (getProperty(scriptType, ScriptImpl.INTERNAL_GRAMMAR),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Grammar"
	       });

	    addXSDMapping
	      (getProperty(scriptType, ScriptImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (script1Type,
	       new String[] 
	       {
	       "name", "Script_._1_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(script1Type, Script1Impl.INTERNAL_EXPRESSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Expression",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(script1Type, Script1Impl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(script1Type, Script1Impl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (serviceType,
	       new String[] 
	       {
	       "name", "Service_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(serviceType, ServiceImpl.INTERNAL_END_POINT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EndPoint",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(serviceType, ServiceImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(serviceType, ServiceImpl.INTERNAL_SERVICE_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ServiceName"
	       });

	    addXSDMapping
	      (getProperty(serviceType, ServiceImpl.INTERNAL_PORT_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "PortName"
	       });

	    addXSDMapping
	      (getProperty(serviceType, ServiceImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (simulationInformationType,
	       new String[] 
	       {
	       "name", "SimulationInformation_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(simulationInformationType, SimulationInformationImpl.INTERNAL_COST),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Cost",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(simulationInformationType, SimulationInformationImpl.INTERNAL_TIME_ESTIMATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TimeEstimation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(simulationInformationType, SimulationInformationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(simulationInformationType, SimulationInformationImpl.INTERNAL_INSTANTIATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Instantiation"
	       });

	    addXSDMapping
	      (getProperty(simulationInformationType, SimulationInformationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (splitType,
	       new String[] 
	       {
	       "name", "Split_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(splitType, SplitImpl.INTERNAL_TRANSITION_REFS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRefs",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(splitType, SplitImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(splitType, SplitImpl.INTERNAL_TYPE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Type"
	       });

	    addXSDMapping
	      (getProperty(splitType, SplitImpl.INTERNAL_OUTGOING_CONDITION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "OutgoingCondition"
	       });

	    addXSDMapping
	      (getProperty(splitType, SplitImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (startEventType,
	       new String[] 
	       {
	       "name", "StartEvent_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_TRIGGER_RESULT_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultMessage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_TRIGGER_TIMER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerTimer",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_TRIGGER_RULE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerRule",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_TRIGGER_RESULT_LINK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultLink",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_TRIGGER_MULTIPLE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerMultiple",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_TRIGGER),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Trigger"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Implementation"
	       });

	    addXSDMapping
	      (getProperty(startEventType, StartEventImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (subFlowType,
	       new String[] 
	       {
	       "name", "SubFlow_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_ACTUAL_PARAMETERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActualParameters",
	       "namespace", "##targetNamespace"
	       });
	  }

	  private void createXSDMetaDataPart5(Xpdl1FactoryImpl theXpdl1PackageImpl, ModelFactoryImpl theModelPackageImpl) {
	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_DATA_MAPPINGS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataMappings",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_EXECUTION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Execution"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_PACKAGE_REF),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "PackageRef"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_INSTANCE_DATA_FIELD),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "InstanceDataField"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_START_ACTIVITY_SET_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "StartActivitySetId"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_START_ACTIVITY_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "StartActivityId"
	       });

	    addXSDMapping
	      (getProperty(subFlowType, SubFlowImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":10",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskType,
	       new String[] 
	       {
	       "name", "Task_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_SERVICE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskService",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_RECEIVE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskReceive",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_MANUAL),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskManual",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_SCRIPT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskScript",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_SEND),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskSend",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_USER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskUser",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_TASK_APPLICATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TaskApplication",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskType, TaskImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":8",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskApplicationType,
	       new String[] 
	       {
	       "name", "TaskApplication_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_ACTUAL_PARAMETERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ActualParameters",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_DATA_MAPPINGS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DataMappings",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_PACKAGE_REF),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "PackageRef"
	       });

	    addXSDMapping
	      (getProperty(taskApplicationType, TaskApplicationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskManualType,
	       new String[] 
	       {
	       "name", "TaskManual_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskManualType, TaskManualImpl.INTERNAL_PERFORMERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Performers",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskManualType, TaskManualImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskManualType, TaskManualImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskReceiveType,
	       new String[] 
	       {
	       "name", "TaskReceive_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskReceiveType, TaskReceiveImpl.INTERNAL_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Message",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskReceiveType, TaskReceiveImpl.INTERNAL_WEB_SERVICE_OPERATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceOperation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskReceiveType, TaskReceiveImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskReceiveType, TaskReceiveImpl.INTERNAL_INSTANTIATE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Instantiate"
	       });

	    addXSDMapping
	      (getProperty(taskReceiveType, TaskReceiveImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Implementation"
	       });

	    addXSDMapping
	      (getProperty(taskReceiveType, TaskReceiveImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskReferenceType,
	       new String[] 
	       {
	       "name", "TaskReference_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskReferenceType, TaskReferenceImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskReferenceType, TaskReferenceImpl.INTERNAL_TASK_REF),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TaskRef"
	       });

	    addXSDMapping
	      (getProperty(taskReferenceType, TaskReferenceImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskScriptType,
	       new String[] 
	       {
	       "name", "TaskScript_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskScriptType, TaskScriptImpl.INTERNAL_SCRIPT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Script",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskScriptType, TaskScriptImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskScriptType, TaskScriptImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskSendType,
	       new String[] 
	       {
	       "name", "TaskSend_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskSendType, TaskSendImpl.INTERNAL_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Message",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskSendType, TaskSendImpl.INTERNAL_WEB_SERVICE_OPERATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceOperation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskSendType, TaskSendImpl.INTERNAL_WEB_SERVICE_FAULT_CATCH),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceFaultCatch",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskSendType, TaskSendImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskSendType, TaskSendImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Implementation"
	       });

	    addXSDMapping
	      (getProperty(taskSendType, TaskSendImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskServiceType,
	       new String[] 
	       {
	       "name", "TaskService_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskServiceType, TaskServiceImpl.INTERNAL_MESSAGE_IN),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageIn",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskServiceType, TaskServiceImpl.INTERNAL_MESSAGE_OUT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageOut",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskServiceType, TaskServiceImpl.INTERNAL_WEB_SERVICE_OPERATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceOperation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskServiceType, TaskServiceImpl.INTERNAL_WEB_SERVICE_FAULT_CATCH),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceFaultCatch",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskServiceType, TaskServiceImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskServiceType, TaskServiceImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Implementation"
	       });

	    addXSDMapping
	      (getProperty(taskServiceType, TaskServiceImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":6",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (taskUserType,
	       new String[] 
	       {
	       "name", "TaskUser_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(taskUserType, TaskUserImpl.INTERNAL_PERFORMERS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Performers",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskUserType, TaskUserImpl.INTERNAL_MESSAGE_IN),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageIn",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskUserType, TaskUserImpl.INTERNAL_MESSAGE_OUT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "MessageOut",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskUserType, TaskUserImpl.INTERNAL_WEB_SERVICE_OPERATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceOperation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(taskUserType, TaskUserImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(taskUserType, TaskUserImpl.INTERNAL_IMPLEMENTATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Implementation"
	       });

	    addXSDMapping
	      (getProperty(taskUserType, TaskUserImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":6",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (timeEstimationType,
	       new String[] 
	       {
	       "name", "TimeEstimation_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(timeEstimationType, TimeEstimationImpl.INTERNAL_WAITING_TIME),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WaitingTime",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(timeEstimationType, TimeEstimationImpl.INTERNAL_WORKING_TIME),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WorkingTime",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(timeEstimationType, TimeEstimationImpl.INTERNAL_DURATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Duration",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(timeEstimationType, TimeEstimationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(timeEstimationType, TimeEstimationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (transactionType,
	       new String[] 
	       {
	       "name", "Transaction_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(transactionType, TransactionImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(transactionType, TransactionImpl.INTERNAL_TRANSACTION_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TransactionId"
	       });

	    addXSDMapping
	      (getProperty(transactionType, TransactionImpl.INTERNAL_TRANSACTION_PROTOCOL),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TransactionProtocol"
	       });

	    addXSDMapping
	      (getProperty(transactionType, TransactionImpl.INTERNAL_TRANSACTION_METHOD),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TransactionMethod"
	       });

	    addXSDMapping
	      (getProperty(transactionType, TransactionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (transitionType,
	       new String[] 
	       {
	       "name", "Transition_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_CONDITION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Condition",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_ASSIGNMENTS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Assignments",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_OBJECT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Object",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_CONNECTOR_GRAPHICS_INFOS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ConnectorGraphicsInfos",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":6",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_FROM),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "From"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_TO),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "To"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_QUANTITY),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Quantity"
	       });

	    addXSDMapping
	      (getProperty(transitionType, TransitionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":12",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (transitionRefType,
	       new String[] 
	       {
	       "name", "TransitionRef_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(transitionRefType, TransitionRefImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(transitionRefType, TransitionRefImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(transitionRefType, TransitionRefImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(transitionRefType, TransitionRefImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (transitionRefsType,
	       new String[] 
	       {
	       "name", "TransitionRefs_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(transitionRefsType, TransitionRefsImpl.INTERNAL_TRANSITION_REF),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRef",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionRefsType, TransitionRefsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(transitionRefsType, TransitionRefsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (transitionRestrictionType,
	       new String[] 
	       {
	       "name", "TransitionRestriction_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(transitionRestrictionType, TransitionRestrictionImpl.INTERNAL_JOIN),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Join",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionRestrictionType, TransitionRestrictionImpl.INTERNAL_SPLIT),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Split",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionRestrictionType, TransitionRestrictionImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(transitionRestrictionType, TransitionRestrictionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (transitionRestrictionsType,
	       new String[] 
	       {
	       "name", "TransitionRestrictions_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(transitionRestrictionsType, TransitionRestrictionsImpl.INTERNAL_TRANSITION_RESTRICTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRestriction",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionRestrictionsType, TransitionRestrictionsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(transitionRestrictionsType, TransitionRestrictionsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (transitionsType,
	       new String[] 
	       {
	       "name", "Transitions_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(transitionsType, TransitionsImpl.INTERNAL_TRANSITION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Transition",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(transitionsType, TransitionsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(transitionsType, TransitionsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (triggerIntermediateMultipleType,
	       new String[] 
	       {
	       "name", "TriggerIntermediateMultiple_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_RESULT_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultMessage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_TIMER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerTimer",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_RESULT_ERROR),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultError",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_RESULT_COMPENSATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ResultCompensation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_RULE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerRule",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_TRIGGER_RESULT_LINK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultLink",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":6",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(triggerIntermediateMultipleType, TriggerIntermediateMultipleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":7",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (triggerMultipleType,
	       new String[] 
	       {
	       "name", "TriggerMultiple_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(triggerMultipleType, TriggerMultipleImpl.INTERNAL_TRIGGER_RESULT_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultMessage",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerMultipleType, TriggerMultipleImpl.INTERNAL_TRIGGER_TIMER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerTimer",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerMultipleType, TriggerMultipleImpl.INTERNAL_TRIGGER_RULE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerRule",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerMultipleType, TriggerMultipleImpl.INTERNAL_TRIGGER_RESULT_LINK),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TriggerResultLink",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerMultipleType, TriggerMultipleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(triggerMultipleType, TriggerMultipleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (triggerResultLinkType,
	       new String[] 
	       {
	       "name", "TriggerResultLink_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(triggerResultLinkType, TriggerResultLinkImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(triggerResultLinkType, TriggerResultLinkImpl.INTERNAL_LINK_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "LinkId"
	       });

	    addXSDMapping
	      (getProperty(triggerResultLinkType, TriggerResultLinkImpl.INTERNAL_PROCESS_REF),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ProcessRef"
	       });

	    addXSDMapping
	      (getProperty(triggerResultLinkType, TriggerResultLinkImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (triggerResultMessageType,
	       new String[] 
	       {
	       "name", "TriggerResultMessage_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(triggerResultMessageType, TriggerResultMessageImpl.INTERNAL_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Message",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerResultMessageType, TriggerResultMessageImpl.INTERNAL_WEB_SERVICE_OPERATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceOperation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(triggerResultMessageType, TriggerResultMessageImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(triggerResultMessageType, TriggerResultMessageImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (triggerRuleType,
	       new String[] 
	       {
	       "name", "TriggerRule_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(triggerRuleType, TriggerRuleImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(triggerRuleType, TriggerRuleImpl.INTERNAL_RULE_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "RuleName"
	       });

	    addXSDMapping
	      (getProperty(triggerRuleType, TriggerRuleImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (triggerTimerType,
	       new String[] 
	       {
	       "name", "TriggerTimer_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(triggerTimerType, TriggerTimerImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(triggerTimerType, TriggerTimerImpl.INTERNAL_TIME_DATE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TimeDate"
	       });

	    addXSDMapping
	      (getProperty(triggerTimerType, TriggerTimerImpl.INTERNAL_TIME_CYCLE),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "TimeCycle"
	       });

	    addXSDMapping
	      (getProperty(triggerTimerType, TriggerTimerImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (typeDeclarationType,
	       new String[] 
	       {
	       "name", "TypeDeclaration_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_BASIC_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BasicType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_DECLARED_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "DeclaredType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_SCHEMA_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "SchemaType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_EXTERNAL_REFERENCE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExternalReference",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_RECORD_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "RecordType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_UNION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "UnionType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_ENUMERATION_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "EnumerationType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_ARRAY_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ArrayType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_LIST_TYPE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ListType",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_DESCRIPTION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Description",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_EXTENDED_ATTRIBUTES),
	       new String[]
	       {
	       "kind", "element",
	       "name", "ExtendedAttributes",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":11",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Id"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "Name"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationType, TypeDeclarationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":14",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (typeDeclarationsType,
	       new String[] 
	       {
	       "name", "TypeDeclarations_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationsType, TypeDeclarationsImpl.INTERNAL_TYPE_DECLARATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TypeDeclaration",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationsType, TypeDeclarationsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(typeDeclarationsType, TypeDeclarationsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (unionTypeType,
	       new String[] 
	       {
	       "name", "UnionType_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(unionTypeType, UnionTypeImpl.INTERNAL_MEMBER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Member",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(unionTypeType, UnionTypeImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(unionTypeType, UnionTypeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (validFromType,
	       new String[] 
	       {
	       "name", "ValidFrom_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(validFromType, ValidFromImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(validFromType, ValidFromImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (validToType,
	       new String[] 
	       {
	       "name", "ValidTo_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(validToType, ValidToImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(validToType, ValidToImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (vendorType,
	       new String[] 
	       {
	       "name", "Vendor_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(vendorType, VendorImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(vendorType, VendorImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (vendorExtensionType,
	       new String[] 
	       {
	       "name", "VendorExtension_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionType, VendorExtensionImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionType, VendorExtensionImpl.INTERNAL_TOOL_ID),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "ToolId"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionType, VendorExtensionImpl.INTERNAL_SCHEMA_LOCATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "schemaLocation"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionType, VendorExtensionImpl.INTERNAL_EXTENSION_DESCRIPTION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "extensionDescription"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionType, VendorExtensionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (vendorExtensionsType,
	       new String[] 
	       {
	       "name", "VendorExtensions_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionsType, VendorExtensionsImpl.INTERNAL_VENDOR_EXTENSION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "VendorExtension",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionsType, VendorExtensionsImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(vendorExtensionsType, VendorExtensionsImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (versionType,
	       new String[] 
	       {
	       "name", "Version_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(versionType, VersionImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(versionType, VersionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (waitingTimeType,
	       new String[] 
	       {
	       "name", "WaitingTime_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(waitingTimeType, WaitingTimeImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(waitingTimeType, WaitingTimeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (webServiceType,
	       new String[] 
	       {
	       "name", "WebService_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(webServiceType, WebServiceImpl.INTERNAL_WEB_SERVICE_OPERATION),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceOperation",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(webServiceType, WebServiceImpl.INTERNAL_WEB_SERVICE_FAULT_CATCH),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WebServiceFaultCatch",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(webServiceType, WebServiceImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(webServiceType, WebServiceImpl.INTERNAL_INPUT_MSG_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "InputMsgName"
	       });

	    addXSDMapping
	      (getProperty(webServiceType, WebServiceImpl.INTERNAL_OUTPUT_MSG_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "OutputMsgName"
	       });

	    addXSDMapping
	      (getProperty(webServiceType, WebServiceImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (webServiceFaultCatchType,
	       new String[] 
	       {
	       "name", "WebServiceFaultCatch_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(webServiceFaultCatchType, WebServiceFaultCatchImpl.INTERNAL_MESSAGE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Message",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(webServiceFaultCatchType, WebServiceFaultCatchImpl.INTERNAL_BLOCK_ACTIVITY),
	       new String[]
	       {
	       "kind", "element",
	       "name", "BlockActivity",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(webServiceFaultCatchType, WebServiceFaultCatchImpl.INTERNAL_TRANSITION_REF),
	       new String[]
	       {
	       "kind", "element",
	       "name", "TransitionRef",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(webServiceFaultCatchType, WebServiceFaultCatchImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":3",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(webServiceFaultCatchType, WebServiceFaultCatchImpl.INTERNAL_FAULT_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "FaultName"
	       });

	    addXSDMapping
	      (getProperty(webServiceFaultCatchType, WebServiceFaultCatchImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":5",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (webServiceOperationType,
	       new String[] 
	       {
	       "name", "WebServiceOperation_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(webServiceOperationType, WebServiceOperationImpl.INTERNAL_PARTNER),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Partner",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(webServiceOperationType, WebServiceOperationImpl.INTERNAL_SERVICE),
	       new String[]
	       {
	       "kind", "element",
	       "name", "Service",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(webServiceOperationType, WebServiceOperationImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(webServiceOperationType, WebServiceOperationImpl.INTERNAL_OPERATION_NAME),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "OperationName"
	       });

	    addXSDMapping
	      (getProperty(webServiceOperationType, WebServiceOperationImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":4",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (workflowProcessesType,
	       new String[] 
	       {
	       "name", "WorkflowProcesses_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(workflowProcessesType, WorkflowProcessesImpl.INTERNAL_WORKFLOW_PROCESS),
	       new String[]
	       {
	       "kind", "element",
	       "name", "WorkflowProcess",
	       "namespace", "##targetNamespace"
	       });

	    addXSDMapping
	      (getProperty(workflowProcessesType, WorkflowProcessesImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(workflowProcessesType, WorkflowProcessesImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (workingTimeType,
	       new String[] 
	       {
	       "name", "WorkingTime_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(workingTimeType, WorkingTimeImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(workingTimeType, WorkingTimeImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (xpdlVersionType,
	       new String[] 
	       {
	       "name", "XPDLVersion_._type",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(xpdlVersionType, XPDLVersionImpl.INTERNAL_VALUE),
	       new String[]
	       {
	       "name", ":0",
	       "kind", "simple"
	       });

	    addXSDMapping
	      (getProperty(xpdlVersionType, XPDLVersionImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":1",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (xsltType,
	       new String[] 
	       {
	       "name", "Xslt_._type",
	       "kind", "elementOnly"
	       });

	    addXSDMapping
	      (getProperty(xsltType, XsltImpl.INTERNAL_ANY),
	       new String[]
	       {
	       "kind", "elementWildcard",
	       "wildcards", "##other",
	       "name", ":0",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (getProperty(xsltType, XsltImpl.INTERNAL_LOCATION),
	       new String[]
	       {
	       "kind", "attribute",
	       "name", "location"
	       });

	    addXSDMapping
	      (getProperty(xsltType, XsltImpl.INTERNAL_ANY_ATTRIBUTE),
	       new String[]
	       {
	       "kind", "attributeWildcard",
	       "wildcards", "##other",
	       "name", ":2",
	       "processing", "lax"
	       });

	    addXSDMapping
	      (accessLevelType,
	       new String[] 
	       {
	       "name", "AccessLevel_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "PUBLIC PRIVATE"
	       });

	    addXSDMapping
	      (adHocOrderingType,
	       new String[] 
	       {
	       "name", "AdHocOrdering_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Sequential Parallel"
	       });

	    addXSDMapping
	      (adHocOrdering1Type,
	       new String[] 
	       {
	       "name", "AdHocOrdering_._1_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Sequential Parallel"
	       });

	    addXSDMapping
	      (artifactTypeType,
	       new String[] 
	       {
	       "name", "ArtifactType_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "DataObject Group Annotation"
	       });

	    addXSDMapping
	      (assignTimeType,
	       new String[] 
	       {
	       "name", "AssignTime_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Start End"
	       });

	    addXSDMapping
	      (associationDirectionType,
	       new String[] 
	       {
	       "name", "AssociationDirection_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None To From Both"
	       });

	    addXSDMapping
	      (directionType,
	       new String[] 
	       {
	       "name", "Direction_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "IN OUT INOUT"
	       });

	    addXSDMapping
	      (durationUnitType,
	       new String[] 
	       {
	       "name", "DurationUnit_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Y M D h m s"
	       });

	    addXSDMapping
	      (endPointTypeType,
	       new String[] 
	       {
	       "name", "EndPointType_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WSDL Service"
	       });

	    addXSDMapping
	      (executionType,
	       new String[] 
	       {
	       "name", "Execution_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "ASYNCHR SYNCHR"
	       });

	    addXSDMapping
	      (execution1Type,
	       new String[] 
	       {
	       "name", "Execution_._1_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "ASYNCHR SYNCHR"
	       });

	    addXSDMapping
	      (finishModeType,
	       new String[] 
	       {
	       "name", "FinishMode_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Automatic Manual"
	       });

	    addXSDMapping
	      (gatewayTypeType,
	       new String[] 
	       {
	       "name", "GatewayType_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "XOR OR Complex AND"
	       });

	    addXSDMapping
	      (graphConformanceType,
	       new String[] 
	       {
	       "name", "GraphConformance_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "FULL_BLOCKED LOOP_BLOCKED NON_BLOCKED"
	       });

	    addXSDMapping
	      (implementationType,
	       new String[] 
	       {
	       "name", "Implementation_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WebService Other Unspecified"
	       });

	    addXSDMapping
	      (implementation1Type,
	       new String[] 
	       {
	       "name", "Implementation_._1_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WebService Other Unspecified"
	       });

	    addXSDMapping
	      (implementation2Type,
	       new String[] 
	       {
	       "name", "Implementation_._2_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WebService Other Unspecified"
	       });

	    addXSDMapping
	      (implementation3Type,
	       new String[] 
	       {
	       "name", "Implementation_._3_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WebService Other Unspecified"
	       });

	    addXSDMapping
	      (implementation4Type,
	       new String[] 
	       {
	       "name", "Implementation_._4_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WebService Other Unspecified"
	       });

	    addXSDMapping
	      (implementation5Type,
	       new String[] 
	       {
	       "name", "Implementation_._5_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WebService Other Unspecified"
	       });

	    addXSDMapping
	      (implementation6Type,
	       new String[] 
	       {
	       "name", "Implementation_._6_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "WebService Other Unspecified"
	       });

	    addXSDMapping
	      (instantiationType,
	       new String[] 
	       {
	       "name", "Instantiation_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "ONCE MULTIPLE"
	       });

	    addXSDMapping
	      (isArrayType,
	       new String[] 
	       {
	       "name", "IsArray_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "TRUE FALSE"
	       });

	    addXSDMapping
	      (loopTypeType,
	       new String[] 
	       {
	       "name", "LoopType_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Standard MultiInstance"
	       });

	    addXSDMapping
	      (mI_FlowConditionType,
	       new String[] 
	       {
	       "name", "MI_FlowCondition_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None One All Complex"
	       });

	    addXSDMapping
	      (mI_OrderingType,
	       new String[] 
	       {
	       "name", "MI_Ordering_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Sequential Parallel"
	       });

	    addXSDMapping
	      (modeType,
	       new String[] 
	       {
	       "name", "Mode_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "IN OUT INOUT"
	       });

	    addXSDMapping
	      (orientationType,
	       new String[] 
	       {
	       "name", "Orientation_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "HORIZONTAL VERTICAL"
	       });

	    addXSDMapping
	      (processTypeType,
	       new String[] 
	       {
	       "name", "ProcessType_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None Private Abstract Collaboration"
	       });

	    addXSDMapping
	      (publicationStatusType,
	       new String[] 
	       {
	       "name", "PublicationStatus_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "UNDER_REVISION RELEASED UNDER_TEST"
	       });

	    addXSDMapping
	      (resultType,
	       new String[] 
	       {
	       "name", "Result_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None Message Error Cancel Compensation Link Terminate Multiple"
	       });

	    addXSDMapping
	      (roleTypeType,
	       new String[] 
	       {
	       "name", "RoleType_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "MyRole PartnerRole"
	       });

	    addXSDMapping
	      (shapeType,
	       new String[] 
	       {
	       "name", "SHAPE_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "RoundRectangle Rectangle Ellipse Diamond Ellipse UpTriangle DownTriangle"
	       });

	    addXSDMapping
	      (startModeType,
	       new String[] 
	       {
	       "name", "StartMode_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Automatic Manual"
	       });

	    addXSDMapping
	      (statusType,
	       new String[] 
	       {
	       "name", "Status_._1_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None Ready Active Cancelled Aborting Aborted Completing Completed"
	       });

	    addXSDMapping
	      (status1Type,
	       new String[] 
	       {
	       "name", "Status_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None Ready Active Cancelled Aborting Aborted Completing Completed"
	       });

	    addXSDMapping
	      (testTimeType,
	       new String[] 
	       {
	       "name", "TestTime_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Before After"
	       });

	    addXSDMapping
	      (transactionMethodType,
	       new String[] 
	       {
	       "name", "TransactionMethod_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "Compensate Store Image"
	       });

	    addXSDMapping
	      (triggerType,
	       new String[] 
	       {
	       "name", "Trigger_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None Message Timer Error Cancel Rule Link Compensation Multiple"
	       });

	    addXSDMapping
	      (trigger1Type,
	       new String[] 
	       {
	       "name", "Trigger_._1_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "None Message Timer Rule Link Multiple"
	       });

	    addXSDMapping
	      (typeType,
	       new String[] 
	       {
	       "name", "Type_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "STRING FLOAT INTEGER REFERENCE DATETIME BOOLEAN PERFORMER"
	       });

	    addXSDMapping
	      (type1Type,
	       new String[] 
	       {
	       "name", "Type_._1_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "CONDITION OTHERWISE EXCEPTION DEFAULTEXCEPTION"
	       });

	    addXSDMapping
	      (type2Type,
	       new String[] 
	       {
	       "name", "Type_._2_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "RESOURCE_SET RESOURCE ROLE ORGANIZATIONAL_UNIT HUMAN SYSTEM"
	       });

	    addXSDMapping
	      (type3Type,
	       new String[] 
	       {
	       "name", "Type_._3_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "AND XOR XOREVENT OR COMPLEX"
	       });

	    addXSDMapping
	      (type4Type,
	       new String[] 
	       {
	       "name", "Type_._4_._type",
	       "baseType", "commonj.sdo#String",
	       "enumeration", "AND XOR XOREVENT OR COMPLEX"
	       });
	  }  

} //Xpdl2FactoryImpl
