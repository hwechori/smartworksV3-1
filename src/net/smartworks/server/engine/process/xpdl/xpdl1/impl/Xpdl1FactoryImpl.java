/**
 * <copyright>
 * </copyright>
 *
 * $Id: Xpdl1FactoryImpl.java,v 1.1 2009/12/22 06:17:20 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl1.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet;
import net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySets;
import net.smartworks.server.engine.process.xpdl.xpdl1.ActualParameters;
import net.smartworks.server.engine.process.xpdl.xpdl1.Application;
import net.smartworks.server.engine.process.xpdl.xpdl1.Applications;
import net.smartworks.server.engine.process.xpdl.xpdl1.ArrayType;
import net.smartworks.server.engine.process.xpdl.xpdl1.Automatic;
import net.smartworks.server.engine.process.xpdl.xpdl1.BasicType;
import net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity;
import net.smartworks.server.engine.process.xpdl.xpdl1.Condition;
import net.smartworks.server.engine.process.xpdl.xpdl1.ConformanceClass;
import net.smartworks.server.engine.process.xpdl.xpdl1.DataField;
import net.smartworks.server.engine.process.xpdl.xpdl1.DataFields;
import net.smartworks.server.engine.process.xpdl.xpdl1.DataType;
import net.smartworks.server.engine.process.xpdl.xpdl1.Deadline;
import net.smartworks.server.engine.process.xpdl.xpdl1.DeclaredType;
import net.smartworks.server.engine.process.xpdl.xpdl1.EnumerationType;
import net.smartworks.server.engine.process.xpdl.xpdl1.EnumerationValue;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttribute;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackages;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference;
import net.smartworks.server.engine.process.xpdl.xpdl1.FinishMode;
import net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter;
import net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameters;
import net.smartworks.server.engine.process.xpdl.xpdl1.Implementation;
import net.smartworks.server.engine.process.xpdl.xpdl1.Join;
import net.smartworks.server.engine.process.xpdl.xpdl1.ListType;
import net.smartworks.server.engine.process.xpdl.xpdl1.Manual;
import net.smartworks.server.engine.process.xpdl.xpdl1.Member;
import net.smartworks.server.engine.process.xpdl.xpdl1.No;
import net.smartworks.server.engine.process.xpdl.xpdl1.PackageHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.Participant;
import net.smartworks.server.engine.process.xpdl.xpdl1.ParticipantType;
import net.smartworks.server.engine.process.xpdl.xpdl1.Participants;
import net.smartworks.server.engine.process.xpdl.xpdl1.ProcessHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.RecordType;
import net.smartworks.server.engine.process.xpdl.xpdl1.RedefinableHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.Responsibles;
import net.smartworks.server.engine.process.xpdl.xpdl1.Route;
import net.smartworks.server.engine.process.xpdl.xpdl1.SchemaType;
import net.smartworks.server.engine.process.xpdl.xpdl1.Script;
import net.smartworks.server.engine.process.xpdl.xpdl1.SimulationInformation;
import net.smartworks.server.engine.process.xpdl.xpdl1.Split;
import net.smartworks.server.engine.process.xpdl.xpdl1.StartMode;
import net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow;
import net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation;
import net.smartworks.server.engine.process.xpdl.xpdl1.Tool;
import net.smartworks.server.engine.process.xpdl.xpdl1.Transition;
import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRef;
import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRefs;
import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction;
import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestrictions;
import net.smartworks.server.engine.process.xpdl.xpdl1.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl1.TypeDeclaration;
import net.smartworks.server.engine.process.xpdl.xpdl1.TypeDeclarations;
import net.smartworks.server.engine.process.xpdl.xpdl1.UnionType;
import net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess;
import net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcesses;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpression;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2; -prefix Xpdl1
 * <!-- end-user-doc -->
 * @generated
 */
public class Xpdl1FactoryImpl extends FactoryBase implements Xpdl1Factory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.wfmc.org/2002/XPDL1.0";

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
  public static final int ARRAY_TYPE = 8;	
  public static final int AUTOMATIC = 9;	
  public static final int BASIC_TYPE = 10;	
  public static final int BLOCK_ACTIVITY = 11;	
  public static final int CONDITION = 12;	
  public static final int CONFORMANCE_CLASS = 13;	
  public static final int DATA_FIELD = 14;	
  public static final int DATA_FIELDS = 15;	
  public static final int DATA_TYPE = 16;	
  public static final int DEADLINE = 17;	
  public static final int DECLARED_TYPE = 18;	
  public static final int ENUMERATION_TYPE = 19;	
  public static final int ENUMERATION_VALUE = 20;	
  public static final int EXTENDED_ATTRIBUTE = 21;	
  public static final int EXTENDED_ATTRIBUTES = 22;	
  public static final int EXTERNAL_PACKAGE = 23;	
  public static final int EXTERNAL_PACKAGES = 24;	
  public static final int EXTERNAL_REFERENCE = 25;	
  public static final int FINISH_MODE = 26;	
  public static final int FORMAL_PARAMETER = 27;	
  public static final int FORMAL_PARAMETERS = 28;	
  public static final int IMPLEMENTATION = 29;	
  public static final int JOIN = 30;	
  public static final int LIST_TYPE = 31;	
  public static final int MANUAL = 32;	
  public static final int MEMBER = 33;	
  public static final int NO = 34;	
  public static final int PACKAGE = 35;	
  public static final int PACKAGE_HEADER = 36;	
  public static final int PARTICIPANT = 37;	
  public static final int PARTICIPANTS = 38;	
  public static final int PARTICIPANT_TYPE = 39;	
  public static final int PROCESS_HEADER = 40;	
  public static final int RECORD_TYPE = 41;	
  public static final int REDEFINABLE_HEADER = 42;	
  public static final int RESPONSIBLES = 43;	
  public static final int ROUTE = 44;	
  public static final int SCHEMA_TYPE = 45;	
  public static final int SCRIPT = 46;	
  public static final int SIMULATION_INFORMATION = 47;	
  public static final int SPLIT = 48;	
  public static final int START_MODE = 49;	
  public static final int SUB_FLOW = 50;	
  public static final int TIME_ESTIMATION = 51;	
  public static final int TOOL = 52;	
  public static final int TRANSITION = 53;	
  public static final int TRANSITION_REF = 54;	
  public static final int TRANSITION_REFS = 55;	
  public static final int TRANSITION_RESTRICTION = 56;	
  public static final int TRANSITION_RESTRICTIONS = 57;	
  public static final int TRANSITIONS = 58;	
  public static final int TYPE_DECLARATION = 59;	
  public static final int TYPE_DECLARATIONS = 60;	
  public static final int UNION_TYPE = 61;	
  public static final int WORKFLOW_PROCESS = 62;	
  public static final int WORKFLOW_PROCESSES = 63;	
  public static final int XPRESSION = 64;	
  public static final int ACCESS_LEVEL = 65;	
  public static final int DURATION_UNIT = 66;	
  public static final int EXECUTION = 67;	
  public static final int EXECUTION1 = 68;	
  public static final int GRAPH_CONFORMANCE = 69;	
  public static final int INSTANTIATION = 70;	
  public static final int IS_ARRAY = 71;	
  public static final int MODE = 72;	
  public static final int PUBLICATION_STATUS = 73;	
  public static final int TYPE = 74;	
  public static final int TYPE1 = 75;	
  public static final int TYPE2 = 76;	
  public static final int TYPE3 = 77;	
  public static final int TYPE4 = 78;	
  public static final int TYPE5 = 79;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Xpdl1FactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "net.smartworks.server.engine.process.xpdl.xpdl1");
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
      case ARRAY_TYPE: return (DataObject)createArrayType();
      case AUTOMATIC: return (DataObject)createAutomatic();
      case BASIC_TYPE: return (DataObject)createBasicType();
      case BLOCK_ACTIVITY: return (DataObject)createBlockActivity();
      case CONDITION: return (DataObject)createCondition();
      case CONFORMANCE_CLASS: return (DataObject)createConformanceClass();
      case DATA_FIELD: return (DataObject)createDataField();
      case DATA_FIELDS: return (DataObject)createDataFields();
      case DATA_TYPE: return (DataObject)createDataType();
      case DEADLINE: return (DataObject)createDeadline();
      case DECLARED_TYPE: return (DataObject)createDeclaredType();
      case ENUMERATION_TYPE: return (DataObject)createEnumerationType();
      case ENUMERATION_VALUE: return (DataObject)createEnumerationValue();
      case EXTENDED_ATTRIBUTE: return (DataObject)createExtendedAttribute();
      case EXTENDED_ATTRIBUTES: return (DataObject)createExtendedAttributes();
      case EXTERNAL_PACKAGE: return (DataObject)createExternalPackage();
      case EXTERNAL_PACKAGES: return (DataObject)createExternalPackages();
      case EXTERNAL_REFERENCE: return (DataObject)createExternalReference();
      case FINISH_MODE: return (DataObject)createFinishMode();
      case FORMAL_PARAMETER: return (DataObject)createFormalParameter();
      case FORMAL_PARAMETERS: return (DataObject)createFormalParameters();
      case IMPLEMENTATION: return (DataObject)createImplementation();
      case JOIN: return (DataObject)createJoin();
      case LIST_TYPE: return (DataObject)createListType();
      case MANUAL: return (DataObject)createManual();
      case MEMBER: return (DataObject)createMember();
      case NO: return (DataObject)createNo();
      case PACKAGE: return (DataObject)createPackage();
      case PACKAGE_HEADER: return (DataObject)createPackageHeader();
      case PARTICIPANT: return (DataObject)createParticipant();
      case PARTICIPANTS: return (DataObject)createParticipants();
      case PARTICIPANT_TYPE: return (DataObject)createParticipantType();
      case PROCESS_HEADER: return (DataObject)createProcessHeader();
      case RECORD_TYPE: return (DataObject)createRecordType();
      case REDEFINABLE_HEADER: return (DataObject)createRedefinableHeader();
      case RESPONSIBLES: return (DataObject)createResponsibles();
      case ROUTE: return (DataObject)createRoute();
      case SCHEMA_TYPE: return (DataObject)createSchemaType();
      case SCRIPT: return (DataObject)createScript();
      case SIMULATION_INFORMATION: return (DataObject)createSimulationInformation();
      case SPLIT: return (DataObject)createSplit();
      case START_MODE: return (DataObject)createStartMode();
      case SUB_FLOW: return (DataObject)createSubFlow();
      case TIME_ESTIMATION: return (DataObject)createTimeEstimation();
      case TOOL: return (DataObject)createTool();
      case TRANSITION: return (DataObject)createTransition();
      case TRANSITION_REF: return (DataObject)createTransitionRef();
      case TRANSITION_REFS: return (DataObject)createTransitionRefs();
      case TRANSITION_RESTRICTION: return (DataObject)createTransitionRestriction();
      case TRANSITION_RESTRICTIONS: return (DataObject)createTransitionRestrictions();
      case TRANSITIONS: return (DataObject)createTransitions();
      case TYPE_DECLARATION: return (DataObject)createTypeDeclaration();
      case TYPE_DECLARATIONS: return (DataObject)createTypeDeclarations();
      case UNION_TYPE: return (DataObject)createUnionType();
      case WORKFLOW_PROCESS: return (DataObject)createWorkflowProcess();
      case WORKFLOW_PROCESSES: return (DataObject)createWorkflowProcesses();
      case XPRESSION: return (DataObject)createXpression();
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
      case DURATION_UNIT:
        return createDurationUnitFromString(initialValue);
      case EXECUTION:
        return createExecutionFromString(initialValue);
      case EXECUTION1:
        return createExecution1FromString(initialValue);
      case GRAPH_CONFORMANCE:
        return createGraphConformanceFromString(initialValue);
      case INSTANTIATION:
        return createInstantiationFromString(initialValue);
      case IS_ARRAY:
        return createIsArrayFromString(initialValue);
      case MODE:
        return createModeFromString(initialValue);
      case PUBLICATION_STATUS:
        return createPublicationStatusFromString(initialValue);
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
      case TYPE5:
        return createType5FromString(initialValue);
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
      case DURATION_UNIT:
        return convertDurationUnitToString(instanceValue);
      case EXECUTION:
        return convertExecutionToString(instanceValue);
      case EXECUTION1:
        return convertExecution1ToString(instanceValue);
      case GRAPH_CONFORMANCE:
        return convertGraphConformanceToString(instanceValue);
      case INSTANTIATION:
        return convertInstantiationToString(instanceValue);
      case IS_ARRAY:
        return convertIsArrayToString(instanceValue);
      case MODE:
        return convertModeToString(instanceValue);
      case PUBLICATION_STATUS:
        return convertPublicationStatusToString(instanceValue);
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
      case TYPE5:
        return convertType5ToString(instanceValue);
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
  public Automatic createAutomatic()
  {
    AutomaticImpl automatic = new AutomaticImpl();
    return automatic;
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
  public FinishMode createFinishMode()
  {
    FinishModeImpl finishMode = new FinishModeImpl();
    return finishMode;
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
  public Implementation createImplementation()
  {
    ImplementationImpl implementation = new ImplementationImpl();
    return implementation;
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
  public Manual createManual()
  {
    ManualImpl manual = new ManualImpl();
    return manual;
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
  public net.smartworks.server.engine.process.xpdl.xpdl1.Package createPackage()
  {
    PackageImpl package_ = new PackageImpl();
    return package_;
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
  public StartMode createStartMode()
  {
    StartModeImpl startMode = new StartModeImpl();
    return startMode;
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
  public Tool createTool()
  {
    ToolImpl tool = new ToolImpl();
    return tool;
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
  public WorkflowProcess createWorkflowProcess()
  {
    WorkflowProcessImpl workflowProcess = new WorkflowProcessImpl();
    return workflowProcess;
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
  public Xpression createXpression()
  {
    XpressionImpl xpression = new XpressionImpl();
    return xpression;
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
    
  protected Type arrayTypeType = null;

  public Type getArrayType()
  {
    return arrayTypeType;
  }
    
  protected Type automaticType = null;

  public Type getAutomatic()
  {
    return automaticType;
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
    
  protected Type finishModeType = null;

  public Type getFinishMode()
  {
    return finishModeType;
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
    
  protected Type implementationType = null;

  public Type getImplementation()
  {
    return implementationType;
  }
    
  protected Type joinType = null;

  public Type getJoin()
  {
    return joinType;
  }
    
  protected Type listTypeType = null;

  public Type getListType()
  {
    return listTypeType;
  }
    
  protected Type manualType = null;

  public Type getManual()
  {
    return manualType;
  }
    
  protected Type memberType = null;

  public Type getMember()
  {
    return memberType;
  }
    
  protected Type noType = null;

  public Type getNo()
  {
    return noType;
  }
    
  protected Type package_Type = null;

  public Type getPackage()
  {
    return package_Type;
  }
    
  protected Type packageHeaderType = null;

  public Type getPackageHeader()
  {
    return packageHeaderType;
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
    
  protected Type processHeaderType = null;

  public Type getProcessHeader()
  {
    return processHeaderType;
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
    
  protected Type responsiblesType = null;

  public Type getResponsibles()
  {
    return responsiblesType;
  }
    
  protected Type routeType = null;

  public Type getRoute()
  {
    return routeType;
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
    
  protected Type startModeType = null;

  public Type getStartMode()
  {
    return startModeType;
  }
    
  protected Type subFlowType = null;

  public Type getSubFlow()
  {
    return subFlowType;
  }
    
  protected Type timeEstimationType = null;

  public Type getTimeEstimation()
  {
    return timeEstimationType;
  }
    
  protected Type toolType = null;

  public Type getTool()
  {
    return toolType;
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
    
  protected Type workflowProcessType = null;

  public Type getWorkflowProcess()
  {
    return workflowProcessType;
  }
    
  protected Type workflowProcessesType = null;

  public Type getWorkflowProcesses()
  {
    return workflowProcessesType;
  }
    
  protected Type xpressionType = null;

  public Type getXpression()
  {
    return xpressionType;
  }
    
  protected Type accessLevelType = null;

  public Type getAccessLevel()
  {
    return accessLevelType;
  }
    
  protected Type durationUnitType = null;

  public Type getDurationUnit()
  {
    return durationUnitType;
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
    
  protected Type graphConformanceType = null;

  public Type getGraphConformance()
  {
    return graphConformanceType;
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
    
  protected Type modeType = null;

  public Type getMode()
  {
    return modeType;
  }
    
  protected Type publicationStatusType = null;

  public Type getPublicationStatus()
  {
    return publicationStatusType;
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
    
  protected Type type5Type = null;

  public Type getType5()
  {
    return type5Type;
  }
  

  private static Xpdl1FactoryImpl instance = null; 
  public static Xpdl1FactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new Xpdl1FactoryImpl();

    // Initialize dependent packages
    ModelFactory ModelFactoryInstance = ModelFactory.INSTANCE;
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theXpdl1FactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

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
    activityType = createType(false, ACTIVITY);
    createProperty(true, activityType,ActivityImpl.INTERNAL_DESCRIPTION); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_LIMIT); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_ROUTE); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_IMPLEMENTATION); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_BLOCK_ACTIVITY); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_PERFORMER); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_START_MODE); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_FINISH_MODE); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_PRIORITY); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_DEADLINE); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_SIMULATION_INFORMATION); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_ICON); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_DOCUMENTATION); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_TRANSITION_RESTRICTIONS); 
    createProperty(false, activityType,ActivityImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_ID); 
    createProperty(true, activityType,ActivityImpl.INTERNAL_NAME); 
    activitySetType = createType(false, ACTIVITY_SET);
    createProperty(false, activitySetType,ActivitySetImpl.INTERNAL_ACTIVITIES); 
    createProperty(false, activitySetType,ActivitySetImpl.INTERNAL_TRANSITIONS); 
    createProperty(true, activitySetType,ActivitySetImpl.INTERNAL_ID); 
    activitySetsType = createType(false, ACTIVITY_SETS);
    createProperty(false, activitySetsType,ActivitySetsImpl.INTERNAL_ACTIVITY_SET); 
    actualParametersType = createType(false, ACTUAL_PARAMETERS);
    createProperty(true, actualParametersType,ActualParametersImpl.INTERNAL_ACTUAL_PARAMETER); 
    applicationType = createType(false, APPLICATION);
    createProperty(true, applicationType,ApplicationImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_FORMAL_PARAMETERS); 
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, applicationType,ApplicationImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, applicationType,ApplicationImpl.INTERNAL_ID); 
    createProperty(true, applicationType,ApplicationImpl.INTERNAL_NAME); 
    applicationsType = createType(false, APPLICATIONS);
    createProperty(false, applicationsType,ApplicationsImpl.INTERNAL_APPLICATION); 
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
    automaticType = createType(false, AUTOMATIC);
    basicTypeType = createType(false, BASIC_TYPE);
    createProperty(true, basicTypeType,BasicTypeImpl.INTERNAL_TYPE); 
    blockActivityType = createType(false, BLOCK_ACTIVITY);
    createProperty(true, blockActivityType,BlockActivityImpl.INTERNAL_BLOCK_ID); 
    conditionType = createType(false, CONDITION);
    createProperty(true, conditionType,ConditionImpl.INTERNAL_MIXED); 
    createProperty(true, conditionType,ConditionImpl.INTERNAL_GROUP); 
    createProperty(false, conditionType,ConditionImpl.INTERNAL_XPRESSION); 
    createProperty(true, conditionType,ConditionImpl.INTERNAL_TYPE); 
    conformanceClassType = createType(false, CONFORMANCE_CLASS);
    createProperty(true, conformanceClassType,ConformanceClassImpl.INTERNAL_GRAPH_CONFORMANCE); 
    dataFieldType = createType(false, DATA_FIELD);
    createProperty(false, dataFieldType,DataFieldImpl.INTERNAL_DATA_TYPE); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_INITIAL_VALUE); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_LENGTH); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, dataFieldType,DataFieldImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_ID); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_NAME); 
    createProperty(true, dataFieldType,DataFieldImpl.INTERNAL_IS_ARRAY); 
    dataFieldsType = createType(false, DATA_FIELDS);
    createProperty(false, dataFieldsType,DataFieldsImpl.INTERNAL_DATA_FIELD); 
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
    deadlineType = createType(false, DEADLINE);
    createProperty(false, deadlineType,DeadlineImpl.INTERNAL_DEADLINE_CONDITION); 
    createProperty(false, deadlineType,DeadlineImpl.INTERNAL_EXCEPTION_NAME); 
    createProperty(true, deadlineType,DeadlineImpl.INTERNAL_EXECUTION); 
    declaredTypeType = createType(false, DECLARED_TYPE);
    createProperty(true, declaredTypeType,DeclaredTypeImpl.INTERNAL_ID); 
    enumerationTypeType = createType(false, ENUMERATION_TYPE);
    createProperty(false, enumerationTypeType,EnumerationTypeImpl.INTERNAL_ENUMERATION_VALUE); 
    enumerationValueType = createType(false, ENUMERATION_VALUE);
    createProperty(true, enumerationValueType,EnumerationValueImpl.INTERNAL_NAME); 
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
    createProperty(true, externalPackageType,ExternalPackageImpl.INTERNAL_HREF); 
    externalPackagesType = createType(false, EXTERNAL_PACKAGES);
    createProperty(false, externalPackagesType,ExternalPackagesImpl.INTERNAL_EXTERNAL_PACKAGE); 
    externalReferenceType = createType(false, EXTERNAL_REFERENCE);
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_XREF); 
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_LOCATION); 
    createProperty(true, externalReferenceType,ExternalReferenceImpl.INTERNAL_NAMESPACE); 
    finishModeType = createType(false, FINISH_MODE);
    createProperty(false, finishModeType,FinishModeImpl.INTERNAL_AUTOMATIC); 
    createProperty(false, finishModeType,FinishModeImpl.INTERNAL_MANUAL); 
    formalParameterType = createType(false, FORMAL_PARAMETER);
    createProperty(false, formalParameterType,FormalParameterImpl.INTERNAL_DATA_TYPE); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_DESCRIPTION); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_ID); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_INDEX); 
    createProperty(true, formalParameterType,FormalParameterImpl.INTERNAL_MODE); 
    formalParametersType = createType(false, FORMAL_PARAMETERS);
    createProperty(false, formalParametersType,FormalParametersImpl.INTERNAL_FORMAL_PARAMETER); 
    implementationType = createType(false, IMPLEMENTATION);
    createProperty(false, implementationType,ImplementationImpl.INTERNAL_NO); 
    createProperty(false, implementationType,ImplementationImpl.INTERNAL_TOOL); 
    createProperty(false, implementationType,ImplementationImpl.INTERNAL_SUB_FLOW); 
    joinType = createType(false, JOIN);
    createProperty(true, joinType,JoinImpl.INTERNAL_TYPE); 
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
    manualType = createType(false, MANUAL);
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
    noType = createType(false, NO);
    package_Type = createType(false, PACKAGE);
    createProperty(false, package_Type,PackageImpl.INTERNAL_PACKAGE_HEADER); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_REDEFINABLE_HEADER); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_CONFORMANCE_CLASS); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_SCRIPT); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_EXTERNAL_PACKAGES); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_TYPE_DECLARATIONS); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_PARTICIPANTS); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_APPLICATIONS); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_DATA_FIELDS); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_WORKFLOW_PROCESSES); 
    createProperty(false, package_Type,PackageImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, package_Type,PackageImpl.INTERNAL_ID); 
    createProperty(true, package_Type,PackageImpl.INTERNAL_NAME); 
    packageHeaderType = createType(false, PACKAGE_HEADER);
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_XPDL_VERSION); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_VENDOR); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_CREATED); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_DESCRIPTION); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_DOCUMENTATION); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_PRIORITY_UNIT); 
    createProperty(true, packageHeaderType,PackageHeaderImpl.INTERNAL_COST_UNIT); 
    participantType = createType(false, PARTICIPANT);
    createProperty(false, participantType,ParticipantImpl.INTERNAL_PARTICIPANT_TYPE); 
    createProperty(true, participantType,ParticipantImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, participantType,ParticipantImpl.INTERNAL_EXTERNAL_REFERENCE); 
    createProperty(false, participantType,ParticipantImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, participantType,ParticipantImpl.INTERNAL_ID); 
    createProperty(true, participantType,ParticipantImpl.INTERNAL_NAME); 
    participantsType = createType(false, PARTICIPANTS);
    createProperty(false, participantsType,ParticipantsImpl.INTERNAL_PARTICIPANT); 
    participantTypeType = createType(false, PARTICIPANT_TYPE);
    createProperty(true, participantTypeType,ParticipantTypeImpl.INTERNAL_TYPE); 
    processHeaderType = createType(false, PROCESS_HEADER);
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_CREATED); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_DESCRIPTION); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_PRIORITY); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_LIMIT); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_VALID_FROM); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_VALID_TO); 
    createProperty(false, processHeaderType,ProcessHeaderImpl.INTERNAL_TIME_ESTIMATION); 
    createProperty(true, processHeaderType,ProcessHeaderImpl.INTERNAL_DURATION_UNIT); 
    recordTypeType = createType(false, RECORD_TYPE);
    createProperty(false, recordTypeType,RecordTypeImpl.INTERNAL_MEMBER); 
    redefinableHeaderType = createType(false, REDEFINABLE_HEADER);
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_AUTHOR); 
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_VERSION); 
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_CODEPAGE); 
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_COUNTRYKEY); 
    createProperty(false, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_RESPONSIBLES); 
    createProperty(true, redefinableHeaderType,RedefinableHeaderImpl.INTERNAL_PUBLICATION_STATUS); 
    responsiblesType = createType(false, RESPONSIBLES);
    createProperty(true, responsiblesType,ResponsiblesImpl.INTERNAL_RESPONSIBLE); 
    routeType = createType(false, ROUTE);
    schemaTypeType = createType(false, SCHEMA_TYPE);
    createProperty(true, schemaTypeType,SchemaTypeImpl.INTERNAL_ANY); 
    scriptType = createType(false, SCRIPT);
    createProperty(true, scriptType,ScriptImpl.INTERNAL_TYPE); 
    createProperty(true, scriptType,ScriptImpl.INTERNAL_VERSION); 
    createProperty(true, scriptType,ScriptImpl.INTERNAL_GRAMMAR); 
    simulationInformationType = createType(false, SIMULATION_INFORMATION);
    createProperty(true, simulationInformationType,SimulationInformationImpl.INTERNAL_COST); 
    createProperty(false, simulationInformationType,SimulationInformationImpl.INTERNAL_TIME_ESTIMATION); 
    createProperty(true, simulationInformationType,SimulationInformationImpl.INTERNAL_INSTANTIATION); 
    splitType = createType(false, SPLIT);
    createProperty(false, splitType,SplitImpl.INTERNAL_TRANSITION_REFS); 
    createProperty(true, splitType,SplitImpl.INTERNAL_TYPE); 
    startModeType = createType(false, START_MODE);
    createProperty(false, startModeType,StartModeImpl.INTERNAL_AUTOMATIC); 
    createProperty(false, startModeType,StartModeImpl.INTERNAL_MANUAL); 
    subFlowType = createType(false, SUB_FLOW);
    createProperty(false, subFlowType,SubFlowImpl.INTERNAL_ACTUAL_PARAMETERS); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_ID); 
    createProperty(true, subFlowType,SubFlowImpl.INTERNAL_EXECUTION); 
    timeEstimationType = createType(false, TIME_ESTIMATION);
    createProperty(true, timeEstimationType,TimeEstimationImpl.INTERNAL_WAITING_TIME); 
    createProperty(true, timeEstimationType,TimeEstimationImpl.INTERNAL_WORKING_TIME); 
    createProperty(true, timeEstimationType,TimeEstimationImpl.INTERNAL_DURATION); 
    toolType = createType(false, TOOL);
    createProperty(false, toolType,ToolImpl.INTERNAL_ACTUAL_PARAMETERS); 
    createProperty(true, toolType,ToolImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, toolType,ToolImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, toolType,ToolImpl.INTERNAL_ID); 
    createProperty(true, toolType,ToolImpl.INTERNAL_TYPE); 
    transitionType = createType(false, TRANSITION);
    createProperty(false, transitionType,TransitionImpl.INTERNAL_CONDITION); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, transitionType,TransitionImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_ID); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_FROM); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_TO); 
    createProperty(true, transitionType,TransitionImpl.INTERNAL_NAME); 
    transitionRefType = createType(false, TRANSITION_REF);
    createProperty(true, transitionRefType,TransitionRefImpl.INTERNAL_ID); 
    transitionRefsType = createType(false, TRANSITION_REFS);
    createProperty(false, transitionRefsType,TransitionRefsImpl.INTERNAL_TRANSITION_REF); 
    transitionRestrictionType = createType(false, TRANSITION_RESTRICTION);
    createProperty(false, transitionRestrictionType,TransitionRestrictionImpl.INTERNAL_JOIN); 
    createProperty(false, transitionRestrictionType,TransitionRestrictionImpl.INTERNAL_SPLIT); 
    transitionRestrictionsType = createType(false, TRANSITION_RESTRICTIONS);
    createProperty(false, transitionRestrictionsType,TransitionRestrictionsImpl.INTERNAL_TRANSITION_RESTRICTION); 
    transitionsType = createType(false, TRANSITIONS);
    createProperty(false, transitionsType,TransitionsImpl.INTERNAL_TRANSITION); 
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
    createProperty(true, typeDeclarationType,TypeDeclarationImpl.INTERNAL_DESCRIPTION); 
    createProperty(false, typeDeclarationType,TypeDeclarationImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, typeDeclarationType,TypeDeclarationImpl.INTERNAL_ID); 
    createProperty(true, typeDeclarationType,TypeDeclarationImpl.INTERNAL_NAME); 
    typeDeclarationsType = createType(false, TYPE_DECLARATIONS);
    createProperty(false, typeDeclarationsType,TypeDeclarationsImpl.INTERNAL_TYPE_DECLARATION); 
    unionTypeType = createType(false, UNION_TYPE);
    createProperty(false, unionTypeType,UnionTypeImpl.INTERNAL_MEMBER); 
    workflowProcessType = createType(false, WORKFLOW_PROCESS);
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_PROCESS_HEADER); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_REDEFINABLE_HEADER); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_FORMAL_PARAMETERS); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_DATA_FIELDS); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_PARTICIPANTS); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_APPLICATIONS); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_ACTIVITY_SETS); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_ACTIVITIES); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_TRANSITIONS); 
    createProperty(false, workflowProcessType,WorkflowProcessImpl.INTERNAL_EXTENDED_ATTRIBUTES); 
    createProperty(true, workflowProcessType,WorkflowProcessImpl.INTERNAL_ID); 
    createProperty(true, workflowProcessType,WorkflowProcessImpl.INTERNAL_NAME); 
    createProperty(true, workflowProcessType,WorkflowProcessImpl.INTERNAL_ACCESS_LEVEL); 
    workflowProcessesType = createType(false, WORKFLOW_PROCESSES);
    createProperty(false, workflowProcessesType,WorkflowProcessesImpl.INTERNAL_WORKFLOW_PROCESS); 
    xpressionType = createType(false, XPRESSION);
    createProperty(true, xpressionType,XpressionImpl.INTERNAL_MIXED); 
    createProperty(true, xpressionType,XpressionImpl.INTERNAL_GROUP); 
    createProperty(true, xpressionType,XpressionImpl.INTERNAL_ANY); 

    // Create data types
    accessLevelType = createType(true, ACCESS_LEVEL );
    durationUnitType = createType(true, DURATION_UNIT );
    executionType = createType(true, EXECUTION );
    execution1Type = createType(true, EXECUTION1 );
    graphConformanceType = createType(true, GRAPH_CONFORMANCE );
    instantiationType = createType(true, INSTANTIATION );
    isArrayType = createType(true, IS_ARRAY );
    modeType = createType(true, MODE );
    publicationStatusType = createType(true, PUBLICATION_STATUS );
    typeType = createType(true, TYPE );
    type1Type = createType(true, TYPE1 );
    type2Type = createType(true, TYPE2 );
    type3Type = createType(true, TYPE3 );
    type4Type = createType(true, TYPE4 );
    type5Type = createType(true, TYPE5 );
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)ModelFactory.INSTANCE;
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    initializeType(activitiesType, Activities.class, "Activities", false);
    property = getLocalProperty(activitiesType, 0);
    initializeProperty(property, this.getActivity(), "Activity", null, 0, -1, Activities.class, false, false, false, true , null);

    initializeType(activityType, Activity.class, "Activity", false);
    property = getLocalProperty(activityType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Limit", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 2);
    initializeProperty(property, this.getRoute(), "Route", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 3);
    initializeProperty(property, this.getImplementation(), "Implementation", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 4);
    initializeProperty(property, this.getBlockActivity(), "BlockActivity", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Performer", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 6);
    initializeProperty(property, this.getStartMode(), "StartMode", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 7);
    initializeProperty(property, this.getFinishMode(), "FinishMode", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 8);
    initializeProperty(property, theModelPackageImpl.getString(), "Priority", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 9);
    initializeProperty(property, this.getDeadline(), "Deadline", null, 0, -1, Activity.class, false, false, false, true , null);

    property = getLocalProperty(activityType, 10);
    initializeProperty(property, this.getSimulationInformation(), "SimulationInformation", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 11);
    initializeProperty(property, theModelPackageImpl.getString(), "Icon", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 12);
    initializeProperty(property, theModelPackageImpl.getString(), "Documentation", null, 0, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 13);
    initializeProperty(property, this.getTransitionRestrictions(), "TransitionRestrictions", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 14);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Activity.class, false, true, false, true , null);

    property = getLocalProperty(activityType, 15);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Activity.class, false, true, false);

    property = getLocalProperty(activityType, 16);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Activity.class, false, true, false);

    initializeType(activitySetType, ActivitySet.class, "ActivitySet", false);
    property = getLocalProperty(activitySetType, 0);
    initializeProperty(property, this.getActivities(), "Activities", null, 0, 1, ActivitySet.class, false, true, false, true , null);

    property = getLocalProperty(activitySetType, 1);
    initializeProperty(property, this.getTransitions(), "Transitions", null, 0, 1, ActivitySet.class, false, true, false, true , null);

    property = getLocalProperty(activitySetType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, ActivitySet.class, false, true, false);

    initializeType(activitySetsType, ActivitySets.class, "ActivitySets", false);
    property = getLocalProperty(activitySetsType, 0);
    initializeProperty(property, this.getActivitySet(), "ActivitySet", null, 0, -1, ActivitySets.class, false, false, false, true , null);

    initializeType(actualParametersType, ActualParameters.class, "ActualParameters", false);
    property = getLocalProperty(actualParametersType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "ActualParameter", null, 0, -1, ActualParameters.class, false, false, false);

    initializeType(applicationType, Application.class, "Application", false);
    property = getLocalProperty(applicationType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, Application.class, false, true, false);

    property = getLocalProperty(applicationType, 1);
    initializeProperty(property, this.getFormalParameters(), "FormalParameters", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 2);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 3);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Application.class, false, true, false, true , null);

    property = getLocalProperty(applicationType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Application.class, false, true, false);

    property = getLocalProperty(applicationType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Application.class, false, true, false);

    initializeType(applicationsType, Applications.class, "Applications", false);
    property = getLocalProperty(applicationsType, 0);
    initializeProperty(property, this.getApplication(), "Application", null, 0, -1, Applications.class, false, false, false, true , null);

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

    initializeType(automaticType, Automatic.class, "Automatic", false);
    initializeType(basicTypeType, BasicType.class, "BasicType", false);
    property = getLocalProperty(basicTypeType, 0);
    initializeProperty(property, this.getType2(), "Type", null, 1, 1, BasicType.class, false, true, false);

    initializeType(blockActivityType, BlockActivity.class, "BlockActivity", false);
    property = getLocalProperty(blockActivityType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "BlockId", null, 1, 1, BlockActivity.class, false, true, false);

    initializeType(conditionType, Condition.class, "Condition", false);
    property = getLocalProperty(conditionType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, Condition.class, false, false, false);

    property = getLocalProperty(conditionType, 1);
    initializeProperty(property, getSequence(), "group", null, 0, -1, Condition.class, false, false, true);

    property = getLocalProperty(conditionType, 2);
    initializeProperty(property, this.getXpression(), "Xpression", null, 0, -1, Condition.class, false, false, true, true , null);

    property = getLocalProperty(conditionType, 3);
    initializeProperty(property, this.getType1(), "Type", null, 0, 1, Condition.class, false, true, false);

    initializeType(conformanceClassType, ConformanceClass.class, "ConformanceClass", false);
    property = getLocalProperty(conformanceClassType, 0);
    initializeProperty(property, this.getGraphConformance(), "GraphConformance", null, 0, 1, ConformanceClass.class, false, true, false);

    initializeType(dataFieldType, DataField.class, "DataField", false);
    property = getLocalProperty(dataFieldType, 0);
    initializeProperty(property, this.getDataType(), "DataType", null, 1, 1, DataField.class, false, true, false, true , null);

    property = getLocalProperty(dataFieldType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "InitialValue", null, 0, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Length", null, 0, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 4);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, DataField.class, false, true, false, true , null);

    property = getLocalProperty(dataFieldType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, DataField.class, false, true, false);

    property = getLocalProperty(dataFieldType, 7);
    initializeProperty(property, this.getIsArray(), "IsArray", "FALSE", 0, 1, DataField.class, false, true, false);

    initializeType(dataFieldsType, DataFields.class, "DataFields", false);
    property = getLocalProperty(dataFieldsType, 0);
    initializeProperty(property, this.getDataField(), "DataField", null, 0, -1, DataFields.class, false, false, false, true , null);

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

    initializeType(deadlineType, Deadline.class, "Deadline", false);
    property = getLocalProperty(deadlineType, 0);
    initializeProperty(property, theModelPackageImpl.getDataObject(), "DeadlineCondition", null, 1, 1, Deadline.class, false, true, false, true , null);

    property = getLocalProperty(deadlineType, 1);
    initializeProperty(property, theModelPackageImpl.getDataObject(), "ExceptionName", null, 1, 1, Deadline.class, false, true, false, true , null);

    property = getLocalProperty(deadlineType, 2);
    initializeProperty(property, this.getExecution(), "Execution", null, 0, 1, Deadline.class, false, true, false);

    initializeType(declaredTypeType, DeclaredType.class, "DeclaredType", false);
    property = getLocalProperty(declaredTypeType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, DeclaredType.class, false, true, false);

    initializeType(enumerationTypeType, EnumerationType.class, "EnumerationType", false);
    property = getLocalProperty(enumerationTypeType, 0);
    initializeProperty(property, this.getEnumerationValue(), "EnumerationValue", null, 1, -1, EnumerationType.class, false, false, false, true , null);

    initializeType(enumerationValueType, EnumerationValue.class, "EnumerationValue", false);
    property = getLocalProperty(enumerationValueType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 1, 1, EnumerationValue.class, false, true, false);

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
    initializeProperty(property, theModelPackageImpl.getString(), "href", null, 0, 1, ExternalPackage.class, false, true, false);

    initializeType(externalPackagesType, ExternalPackages.class, "ExternalPackages", false);
    property = getLocalProperty(externalPackagesType, 0);
    initializeProperty(property, this.getExternalPackage(), "ExternalPackage", null, 0, -1, ExternalPackages.class, false, false, false, true , null);

    initializeType(externalReferenceType, ExternalReference.class, "ExternalReference", false);
    property = getLocalProperty(externalReferenceType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "xref", null, 0, 1, ExternalReference.class, false, true, false);

    property = getLocalProperty(externalReferenceType, 1);
    initializeProperty(property, theModelPackageImpl.getURI(), "location", null, 1, 1, ExternalReference.class, false, true, false);

    property = getLocalProperty(externalReferenceType, 2);
    initializeProperty(property, theModelPackageImpl.getURI(), "namespace", null, 0, 1, ExternalReference.class, false, true, false);

    initializeType(finishModeType, FinishMode.class, "FinishMode", false);
    property = getLocalProperty(finishModeType, 0);
    initializeProperty(property, this.getAutomatic(), "Automatic", null, 0, 1, FinishMode.class, false, true, false, true , null);

    property = getLocalProperty(finishModeType, 1);
    initializeProperty(property, this.getManual(), "Manual", null, 0, 1, FinishMode.class, false, true, false, true , null);

    initializeType(formalParameterType, FormalParameter.class, "FormalParameter", false);
    property = getLocalProperty(formalParameterType, 0);
    initializeProperty(property, this.getDataType(), "DataType", null, 1, 1, FormalParameter.class, false, true, false, true , null);

    property = getLocalProperty(formalParameterType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, FormalParameter.class, false, true, false);

    property = getLocalProperty(formalParameterType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, FormalParameter.class, false, true, false);

    property = getLocalProperty(formalParameterType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Index", null, 0, 1, FormalParameter.class, false, true, false);

    property = getLocalProperty(formalParameterType, 4);
    initializeProperty(property, this.getMode(), "Mode", "IN", 0, 1, FormalParameter.class, false, true, false);

    initializeType(formalParametersType, FormalParameters.class, "FormalParameters", false);
    property = getLocalProperty(formalParametersType, 0);
    initializeProperty(property, this.getFormalParameter(), "FormalParameter", null, 0, -1, FormalParameters.class, false, false, false, true , null);

    initializeType(implementationType, Implementation.class, "Implementation", false);
    property = getLocalProperty(implementationType, 0);
    initializeProperty(property, this.getNo(), "No", null, 0, 1, Implementation.class, false, true, false, true , null);

    property = getLocalProperty(implementationType, 1);
    initializeProperty(property, this.getTool(), "Tool", null, 0, -1, Implementation.class, false, false, false, true , null);

    property = getLocalProperty(implementationType, 2);
    initializeProperty(property, this.getSubFlow(), "SubFlow", null, 0, 1, Implementation.class, false, true, false, true , null);

    initializeType(joinType, Join.class, "Join", false);
    property = getLocalProperty(joinType, 0);
    initializeProperty(property, this.getType3(), "Type", null, 0, 1, Join.class, false, true, false);

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

    initializeType(manualType, Manual.class, "Manual", false);
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

    initializeType(noType, No.class, "No", false);
    initializeType(package_Type, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, "Package", false);
    property = getLocalProperty(package_Type, 0);
    initializeProperty(property, this.getPackageHeader(), "PackageHeader", null, 1, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 1);
    initializeProperty(property, this.getRedefinableHeader(), "RedefinableHeader", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 2);
    initializeProperty(property, this.getConformanceClass(), "ConformanceClass", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 3);
    initializeProperty(property, this.getScript(), "Script", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 4);
    initializeProperty(property, this.getExternalPackages(), "ExternalPackages", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 5);
    initializeProperty(property, this.getTypeDeclarations(), "TypeDeclarations", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 6);
    initializeProperty(property, this.getParticipants(), "Participants", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 7);
    initializeProperty(property, this.getApplications(), "Applications", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 8);
    initializeProperty(property, this.getDataFields(), "DataFields", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 9);
    initializeProperty(property, this.getWorkflowProcesses(), "WorkflowProcesses", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 10);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false, true , null);

    property = getLocalProperty(package_Type, 11);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false);

    property = getLocalProperty(package_Type, 12);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, net.smartworks.server.engine.process.xpdl.xpdl1.Package.class, false, true, false);

    initializeType(packageHeaderType, PackageHeader.class, "PackageHeader", false);
    property = getLocalProperty(packageHeaderType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "XPDLVersion", null, 1, 1, PackageHeader.class, false, true, false);

    property = getLocalProperty(packageHeaderType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Vendor", null, 1, 1, PackageHeader.class, false, true, false);

    property = getLocalProperty(packageHeaderType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Created", null, 1, 1, PackageHeader.class, false, true, false);

    property = getLocalProperty(packageHeaderType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, PackageHeader.class, false, true, false);

    property = getLocalProperty(packageHeaderType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Documentation", null, 0, 1, PackageHeader.class, false, true, false);

    property = getLocalProperty(packageHeaderType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "PriorityUnit", null, 0, 1, PackageHeader.class, false, true, false);

    property = getLocalProperty(packageHeaderType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "CostUnit", null, 0, 1, PackageHeader.class, false, true, false);

    initializeType(participantType, Participant.class, "Participant", false);
    property = getLocalProperty(participantType, 0);
    initializeProperty(property, this.getParticipantType(), "ParticipantType", null, 1, 1, Participant.class, false, true, false, true , null);

    property = getLocalProperty(participantType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, Participant.class, false, true, false);

    property = getLocalProperty(participantType, 2);
    initializeProperty(property, this.getExternalReference(), "ExternalReference", null, 0, 1, Participant.class, false, true, false, true , null);

    property = getLocalProperty(participantType, 3);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Participant.class, false, true, false, true , null);

    property = getLocalProperty(participantType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Participant.class, false, true, false);

    property = getLocalProperty(participantType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Participant.class, false, true, false);

    initializeType(participantsType, Participants.class, "Participants", false);
    property = getLocalProperty(participantsType, 0);
    initializeProperty(property, this.getParticipant(), "Participant", null, 0, -1, Participants.class, false, false, false, true , null);

    initializeType(participantTypeType, ParticipantType.class, "ParticipantType", false);
    property = getLocalProperty(participantTypeType, 0);
    initializeProperty(property, this.getType4(), "Type", null, 1, 1, ParticipantType.class, false, true, false);

    initializeType(processHeaderType, ProcessHeader.class, "ProcessHeader", false);
    property = getLocalProperty(processHeaderType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Created", null, 0, 1, ProcessHeader.class, false, true, false);

    property = getLocalProperty(processHeaderType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, ProcessHeader.class, false, true, false);

    property = getLocalProperty(processHeaderType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Priority", null, 0, 1, ProcessHeader.class, false, true, false);

    property = getLocalProperty(processHeaderType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Limit", null, 0, 1, ProcessHeader.class, false, true, false);

    property = getLocalProperty(processHeaderType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "ValidFrom", null, 0, 1, ProcessHeader.class, false, true, false);

    property = getLocalProperty(processHeaderType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "ValidTo", null, 0, 1, ProcessHeader.class, false, true, false);

    property = getLocalProperty(processHeaderType, 6);
    initializeProperty(property, this.getTimeEstimation(), "TimeEstimation", null, 0, 1, ProcessHeader.class, false, true, false, true , null);

    property = getLocalProperty(processHeaderType, 7);
    initializeProperty(property, this.getDurationUnit(), "DurationUnit", null, 0, 1, ProcessHeader.class, false, true, false);

    initializeType(recordTypeType, RecordType.class, "RecordType", false);
    property = getLocalProperty(recordTypeType, 0);
    initializeProperty(property, this.getMember(), "Member", null, 1, -1, RecordType.class, false, false, false, true , null);

    initializeType(redefinableHeaderType, RedefinableHeader.class, "RedefinableHeader", false);
    property = getLocalProperty(redefinableHeaderType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Author", null, 0, 1, RedefinableHeader.class, false, true, false);

    property = getLocalProperty(redefinableHeaderType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Version", null, 0, 1, RedefinableHeader.class, false, true, false);

    property = getLocalProperty(redefinableHeaderType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Codepage", null, 0, 1, RedefinableHeader.class, false, true, false);

    property = getLocalProperty(redefinableHeaderType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Countrykey", null, 0, 1, RedefinableHeader.class, false, true, false);

    property = getLocalProperty(redefinableHeaderType, 4);
    initializeProperty(property, this.getResponsibles(), "Responsibles", null, 0, 1, RedefinableHeader.class, false, true, false, true , null);

    property = getLocalProperty(redefinableHeaderType, 5);
    initializeProperty(property, this.getPublicationStatus(), "PublicationStatus", null, 0, 1, RedefinableHeader.class, false, true, false);

    initializeType(responsiblesType, Responsibles.class, "Responsibles", false);
    property = getLocalProperty(responsiblesType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Responsible", null, 0, -1, Responsibles.class, false, false, false);

    initializeType(routeType, Route.class, "Route", false);
    initializeType(schemaTypeType, SchemaType.class, "SchemaType", false);
    property = getLocalProperty(schemaTypeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, SchemaType.class, false, false, false);

    initializeType(scriptType, Script.class, "Script", false);
    property = getLocalProperty(scriptType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Type", null, 1, 1, Script.class, false, true, false);

    property = getLocalProperty(scriptType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Version", null, 0, 1, Script.class, false, true, false);

    property = getLocalProperty(scriptType, 2);
    initializeProperty(property, theModelPackageImpl.getURI(), "Grammar", null, 0, 1, Script.class, false, true, false);

    initializeType(simulationInformationType, SimulationInformation.class, "SimulationInformation", false);
    property = getLocalProperty(simulationInformationType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Cost", null, 1, 1, SimulationInformation.class, false, true, false);

    property = getLocalProperty(simulationInformationType, 1);
    initializeProperty(property, this.getTimeEstimation(), "TimeEstimation", null, 1, 1, SimulationInformation.class, false, true, false, true , null);

    property = getLocalProperty(simulationInformationType, 2);
    initializeProperty(property, this.getInstantiation(), "Instantiation", null, 0, 1, SimulationInformation.class, false, true, false);

    initializeType(splitType, Split.class, "Split", false);
    property = getLocalProperty(splitType, 0);
    initializeProperty(property, this.getTransitionRefs(), "TransitionRefs", null, 0, 1, Split.class, false, true, false, true , null);

    property = getLocalProperty(splitType, 1);
    initializeProperty(property, this.getType(), "Type", null, 0, 1, Split.class, false, true, false);

    initializeType(startModeType, StartMode.class, "StartMode", false);
    property = getLocalProperty(startModeType, 0);
    initializeProperty(property, this.getAutomatic(), "Automatic", null, 0, 1, StartMode.class, false, true, false, true , null);

    property = getLocalProperty(startModeType, 1);
    initializeProperty(property, this.getManual(), "Manual", null, 0, 1, StartMode.class, false, true, false, true , null);

    initializeType(subFlowType, SubFlow.class, "SubFlow", false);
    property = getLocalProperty(subFlowType, 0);
    initializeProperty(property, this.getActualParameters(), "ActualParameters", null, 0, 1, SubFlow.class, false, true, false, true , null);

    property = getLocalProperty(subFlowType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, SubFlow.class, false, true, false);

    property = getLocalProperty(subFlowType, 2);
    initializeProperty(property, this.getExecution1(), "Execution", null, 0, 1, SubFlow.class, false, true, false);

    initializeType(timeEstimationType, TimeEstimation.class, "TimeEstimation", false);
    property = getLocalProperty(timeEstimationType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "WaitingTime", null, 0, 1, TimeEstimation.class, false, true, false);

    property = getLocalProperty(timeEstimationType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "WorkingTime", null, 0, 1, TimeEstimation.class, false, true, false);

    property = getLocalProperty(timeEstimationType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "Duration", null, 0, 1, TimeEstimation.class, false, true, false);

    initializeType(toolType, Tool.class, "Tool", false);
    property = getLocalProperty(toolType, 0);
    initializeProperty(property, this.getActualParameters(), "ActualParameters", null, 0, 1, Tool.class, false, true, false, true , null);

    property = getLocalProperty(toolType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, Tool.class, false, true, false);

    property = getLocalProperty(toolType, 2);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Tool.class, false, true, false, true , null);

    property = getLocalProperty(toolType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Tool.class, false, true, false);

    property = getLocalProperty(toolType, 4);
    initializeProperty(property, this.getType5(), "Type", null, 0, 1, Tool.class, false, true, false);

    initializeType(transitionType, Transition.class, "Transition", false);
    property = getLocalProperty(transitionType, 0);
    initializeProperty(property, this.getCondition(), "Condition", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 2);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, Transition.class, false, true, false, true , null);

    property = getLocalProperty(transitionType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "From", null, 1, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "To", null, 1, 1, Transition.class, false, true, false);

    property = getLocalProperty(transitionType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, Transition.class, false, true, false);

    initializeType(transitionRefType, TransitionRef.class, "TransitionRef", false);
    property = getLocalProperty(transitionRefType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, TransitionRef.class, false, true, false);

    initializeType(transitionRefsType, TransitionRefs.class, "TransitionRefs", false);
    property = getLocalProperty(transitionRefsType, 0);
    initializeProperty(property, this.getTransitionRef(), "TransitionRef", null, 0, -1, TransitionRefs.class, false, false, false, true , null);

    initializeType(transitionRestrictionType, TransitionRestriction.class, "TransitionRestriction", false);
    property = getLocalProperty(transitionRestrictionType, 0);
    initializeProperty(property, this.getJoin(), "Join", null, 0, 1, TransitionRestriction.class, false, true, false, true , null);

    property = getLocalProperty(transitionRestrictionType, 1);
    initializeProperty(property, this.getSplit(), "Split", null, 0, 1, TransitionRestriction.class, false, true, false, true , null);

    initializeType(transitionRestrictionsType, TransitionRestrictions.class, "TransitionRestrictions", false);
    property = getLocalProperty(transitionRestrictionsType, 0);
    initializeProperty(property, this.getTransitionRestriction(), "TransitionRestriction", null, 0, -1, TransitionRestrictions.class, false, false, false, true , null);

    initializeType(transitionsType, Transitions.class, "Transitions", false);
    property = getLocalProperty(transitionsType, 0);
    initializeProperty(property, this.getTransition(), "Transition", null, 0, -1, Transitions.class, false, false, false, true , null);

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
    initializeProperty(property, theModelPackageImpl.getString(), "Description", null, 0, 1, TypeDeclaration.class, false, true, false);

    property = getLocalProperty(typeDeclarationType, 10);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, TypeDeclaration.class, false, true, false, true , null);

    property = getLocalProperty(typeDeclarationType, 11);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, TypeDeclaration.class, false, true, false);

    property = getLocalProperty(typeDeclarationType, 12);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, TypeDeclaration.class, false, true, false);

    initializeType(typeDeclarationsType, TypeDeclarations.class, "TypeDeclarations", false);
    property = getLocalProperty(typeDeclarationsType, 0);
    initializeProperty(property, this.getTypeDeclaration(), "TypeDeclaration", null, 0, -1, TypeDeclarations.class, false, false, false, true , null);

    initializeType(unionTypeType, UnionType.class, "UnionType", false);
    property = getLocalProperty(unionTypeType, 0);
    initializeProperty(property, this.getMember(), "Member", null, 1, -1, UnionType.class, false, false, false, true , null);

    initializeType(workflowProcessType, WorkflowProcess.class, "WorkflowProcess", false);
    property = getLocalProperty(workflowProcessType, 0);
    initializeProperty(property, this.getProcessHeader(), "ProcessHeader", null, 1, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 1);
    initializeProperty(property, this.getRedefinableHeader(), "RedefinableHeader", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 2);
    initializeProperty(property, this.getFormalParameters(), "FormalParameters", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 3);
    initializeProperty(property, this.getDataFields(), "DataFields", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 4);
    initializeProperty(property, this.getParticipants(), "Participants", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 5);
    initializeProperty(property, this.getApplications(), "Applications", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 6);
    initializeProperty(property, this.getActivitySets(), "ActivitySets", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 7);
    initializeProperty(property, this.getActivities(), "Activities", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 8);
    initializeProperty(property, this.getTransitions(), "Transitions", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 9);
    initializeProperty(property, this.getExtendedAttributes(), "ExtendedAttributes", null, 0, 1, WorkflowProcess.class, false, true, false, true , null);

    property = getLocalProperty(workflowProcessType, 10);
    initializeProperty(property, theModelPackageImpl.getString(), "Id", null, 1, 1, WorkflowProcess.class, false, true, false);

    property = getLocalProperty(workflowProcessType, 11);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 0, 1, WorkflowProcess.class, false, true, false);

    property = getLocalProperty(workflowProcessType, 12);
    initializeProperty(property, this.getAccessLevel(), "AccessLevel", null, 0, 1, WorkflowProcess.class, false, true, false);

    initializeType(workflowProcessesType, WorkflowProcesses.class, "WorkflowProcesses", false);
    property = getLocalProperty(workflowProcessesType, 0);
    initializeProperty(property, this.getWorkflowProcess(), "WorkflowProcess", null, 0, -1, WorkflowProcesses.class, false, false, false, true , null);

    initializeType(xpressionType, Xpression.class, "Xpression", false);
    property = getLocalProperty(xpressionType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, Xpression.class, false, false, false);

    property = getLocalProperty(xpressionType, 1);
    initializeProperty(property, getSequence(), "group", null, 0, -1, Xpression.class, false, false, true);

    property = getLocalProperty(xpressionType, 2);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Xpression.class, false, false, true);

    // Initialize data types
    initializeType(accessLevelType, String.class, "AccessLevel", true, false);

    initializeType(durationUnitType, String.class, "DurationUnit", true, false);

    initializeType(executionType, String.class, "Execution", true, false);

    initializeType(execution1Type, String.class, "Execution1", true, false);

    initializeType(graphConformanceType, String.class, "GraphConformance", true, false);

    initializeType(instantiationType, String.class, "Instantiation", true, false);

    initializeType(isArrayType, String.class, "IsArray", true, false);

    initializeType(modeType, String.class, "Mode", true, false);

    initializeType(publicationStatusType, String.class, "PublicationStatus", true, false);

    initializeType(typeType, String.class, "Type", true, false);

    initializeType(type1Type, String.class, "Type1", true, false);

    initializeType(type2Type, String.class, "Type2", true, false);

    initializeType(type3Type, String.class, "Type3", true, false);

    initializeType(type4Type, String.class, "Type4", true, false);

    initializeType(type5Type, String.class, "Type5", true, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

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
      (getProperty(activityType, ActivityImpl.INTERNAL_START_MODE),
       new String[]
       {
       "kind", "element",
       "name", "StartMode",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(activityType, ActivityImpl.INTERNAL_FINISH_MODE),
       new String[]
       {
       "kind", "element",
       "name", "FinishMode",
       "namespace", "##targetNamespace"
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
      (getProperty(activitySetType, ActivitySetImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
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
      (automaticType,
       new String[] 
       {
       "name", "Automatic_._type",
       "kind", "empty"
       });

    addXSDMapping
      (basicTypeType,
       new String[] 
       {
       "name", "BasicType_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(basicTypeType, BasicTypeImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "Type"
       });

    addXSDMapping
      (blockActivityType,
       new String[] 
       {
       "name", "BlockActivity_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(blockActivityType, BlockActivityImpl.INTERNAL_BLOCK_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "BlockId"
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
      (getProperty(conditionType, ConditionImpl.INTERNAL_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "group:1"
       });

    addXSDMapping
      (getProperty(conditionType, ConditionImpl.INTERNAL_XPRESSION),
       new String[]
       {
       "kind", "element",
       "name", "Xpression",
       "namespace", "##targetNamespace",
       "group", "#group:1"
       });

    addXSDMapping
      (getProperty(conditionType, ConditionImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "Type"
       });

    addXSDMapping
      (conformanceClassType,
       new String[] 
       {
       "name", "ConformanceClass_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(conformanceClassType, ConformanceClassImpl.INTERNAL_GRAPH_CONFORMANCE),
       new String[]
       {
       "kind", "attribute",
       "name", "GraphConformance"
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
      (deadlineType,
       new String[] 
       {
       "name", "Deadline_._type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(deadlineType, DeadlineImpl.INTERNAL_DEADLINE_CONDITION),
       new String[]
       {
       "kind", "element",
       "name", "DeadlineCondition",
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
      (getProperty(deadlineType, DeadlineImpl.INTERNAL_EXECUTION),
       new String[]
       {
       "kind", "attribute",
       "name", "Execution"
       });

    addXSDMapping
      (declaredTypeType,
       new String[] 
       {
       "name", "DeclaredType_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(declaredTypeType, DeclaredTypeImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
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
      ("ActualParameter",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "ActualParameter",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      ("Author",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Author",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Automatic",
      this.getAutomatic(),
       new String[]
       {
       "kind", "element",
       "name", "Automatic",
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
      ("Codepage",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Codepage",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      ("Cost",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Cost",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("CostUnit",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "CostUnit",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Countrykey",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Countrykey",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Created",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Created",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Documentation",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Documentation",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Duration",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Duration",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      ("FinishMode",
      this.getFinishMode(),
       new String[]
       {
       "kind", "element",
       "name", "FinishMode",
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
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Icon",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Implementation",
      this.getImplementation(),
       new String[]
       {
       "kind", "element",
       "name", "Implementation",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("InitialValue",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "InitialValue",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      ("Length",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Length",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Limit",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Limit",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      ("Manual",
      this.getManual(),
       new String[]
       {
       "kind", "element",
       "name", "Manual",
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
      ("No",
      this.getNo(),
       new String[]
       {
       "kind", "element",
       "name", "No",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("Package",
      this.getPackage(),
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
      ("Performer",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Performer",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Priority",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Priority",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("PriorityUnit",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "PriorityUnit",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      ("Responsible",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Responsible",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
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
      ("Route",
      this.getRoute(),
       new String[]
       {
       "kind", "element",
       "name", "Route",
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
      ("StartMode",
      this.getStartMode(),
       new String[]
       {
       "kind", "element",
       "name", "StartMode",
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
      ("TimeEstimation",
      this.getTimeEstimation(),
       new String[]
       {
       "kind", "element",
       "name", "TimeEstimation",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("Tool",
      this.getTool(),
       new String[]
       {
       "kind", "element",
       "name", "Tool",
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
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "ValidFrom",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("ValidTo",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "ValidTo",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Vendor",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Vendor",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Version",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "Version",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("WaitingTime",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "WaitingTime",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("WorkflowProcess",
      this.getWorkflowProcess(),
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
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "WorkingTime",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("XPDLVersion",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "element",
       "name", "XPDLVersion",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("Xpression",
      this.getXpression(),
       new String[]
       {
       "kind", "element",
       "name", "Xpression",
       "namespace", "##targetNamespace"
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
      (enumerationValueType,
       new String[] 
       {
       "name", "EnumerationValue_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(enumerationValueType, EnumerationValueImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "attribute",
       "name", "Name"
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

    addXSDMapping
      (getProperty(extendedAttributeType, ExtendedAttributeImpl.INTERNAL_ANY),
       new String[]
       {
       "kind", "elementWildcard",
       "wildcards", "##any",
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
      (getProperty(externalPackageType, ExternalPackageImpl.INTERNAL_HREF),
       new String[]
       {
       "kind", "attribute",
       "name", "href"
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
      (externalReferenceType,
       new String[] 
       {
       "name", "ExternalReference_._type",
       "kind", "empty"
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
      (finishModeType,
       new String[] 
       {
       "name", "FinishMode_._type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(finishModeType, FinishModeImpl.INTERNAL_AUTOMATIC),
       new String[]
       {
       "kind", "element",
       "name", "Automatic",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(finishModeType, FinishModeImpl.INTERNAL_MANUAL),
       new String[]
       {
       "kind", "element",
       "name", "Manual",
       "namespace", "##targetNamespace"
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
      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
       });

    addXSDMapping
      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_INDEX),
       new String[]
       {
       "kind", "attribute",
       "name", "Index"
       });

    addXSDMapping
      (getProperty(formalParameterType, FormalParameterImpl.INTERNAL_MODE),
       new String[]
       {
       "kind", "attribute",
       "name", "Mode"
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
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (implementationType,
       new String[] 
       {
       "name", "Implementation_._type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(implementationType, ImplementationImpl.INTERNAL_NO),
       new String[]
       {
       "kind", "element",
       "name", "No",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(implementationType, ImplementationImpl.INTERNAL_TOOL),
       new String[]
       {
       "kind", "element",
       "name", "Tool",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(implementationType, ImplementationImpl.INTERNAL_SUB_FLOW),
       new String[]
       {
       "kind", "element",
       "name", "SubFlow",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (joinType,
       new String[] 
       {
       "name", "Join_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(joinType, JoinImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "Type"
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
      (manualType,
       new String[] 
       {
       "name", "Manual_._type",
       "kind", "empty"
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
      (noType,
       new String[] 
       {
       "name", "No_._type",
       "kind", "empty"
       });

    addXSDMapping
      (package_Type,
       new String[] 
       {
       "name", "Package_._type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_PACKAGE_HEADER),
       new String[]
       {
       "kind", "element",
       "name", "PackageHeader",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_REDEFINABLE_HEADER),
       new String[]
       {
       "kind", "element",
       "name", "RedefinableHeader",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_CONFORMANCE_CLASS),
       new String[]
       {
       "kind", "element",
       "name", "ConformanceClass",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_SCRIPT),
       new String[]
       {
       "kind", "element",
       "name", "Script",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_EXTERNAL_PACKAGES),
       new String[]
       {
       "kind", "element",
       "name", "ExternalPackages",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_TYPE_DECLARATIONS),
       new String[]
       {
       "kind", "element",
       "name", "TypeDeclarations",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_PARTICIPANTS),
       new String[]
       {
       "kind", "element",
       "name", "Participants",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_APPLICATIONS),
       new String[]
       {
       "kind", "element",
       "name", "Applications",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_DATA_FIELDS),
       new String[]
       {
       "kind", "element",
       "name", "DataFields",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_WORKFLOW_PROCESSES),
       new String[]
       {
       "kind", "element",
       "name", "WorkflowProcesses",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_EXTENDED_ATTRIBUTES),
       new String[]
       {
       "kind", "element",
       "name", "ExtendedAttributes",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
       });

    addXSDMapping
      (getProperty(package_Type, PackageImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "attribute",
       "name", "Name"
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
      (participantTypeType,
       new String[] 
       {
       "name", "ParticipantType_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(participantTypeType, ParticipantTypeImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "Type"
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
      (getProperty(processHeaderType, ProcessHeaderImpl.INTERNAL_DURATION_UNIT),
       new String[]
       {
       "kind", "attribute",
       "name", "DurationUnit"
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
      (getProperty(redefinableHeaderType, RedefinableHeaderImpl.INTERNAL_PUBLICATION_STATUS),
       new String[]
       {
       "kind", "attribute",
       "name", "PublicationStatus"
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
      (routeType,
       new String[] 
       {
       "name", "Route_._type",
       "kind", "empty"
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
      (scriptType,
       new String[] 
       {
       "name", "Script_._type",
       "kind", "empty"
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
      (getProperty(simulationInformationType, SimulationInformationImpl.INTERNAL_INSTANTIATION),
       new String[]
       {
       "kind", "attribute",
       "name", "Instantiation"
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
      (getProperty(splitType, SplitImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "Type"
       });

    addXSDMapping
      (startModeType,
       new String[] 
       {
       "name", "StartMode_._type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(startModeType, StartModeImpl.INTERNAL_AUTOMATIC),
       new String[]
       {
       "kind", "element",
       "name", "Automatic",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(startModeType, StartModeImpl.INTERNAL_MANUAL),
       new String[]
       {
       "kind", "element",
       "name", "Manual",
       "namespace", "##targetNamespace"
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

    addXSDMapping
      (getProperty(subFlowType, SubFlowImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
       });

    addXSDMapping
      (getProperty(subFlowType, SubFlowImpl.INTERNAL_EXECUTION),
       new String[]
       {
       "kind", "attribute",
       "name", "Execution"
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
      (toolType,
       new String[] 
       {
       "name", "Tool_._type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(toolType, ToolImpl.INTERNAL_ACTUAL_PARAMETERS),
       new String[]
       {
       "kind", "element",
       "name", "ActualParameters",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(toolType, ToolImpl.INTERNAL_DESCRIPTION),
       new String[]
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(toolType, ToolImpl.INTERNAL_EXTENDED_ATTRIBUTES),
       new String[]
       {
       "kind", "element",
       "name", "ExtendedAttributes",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(toolType, ToolImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
       });

    addXSDMapping
      (getProperty(toolType, ToolImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "Type"
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
      (transitionRefType,
       new String[] 
       {
       "name", "TransitionRef_._type",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(transitionRefType, TransitionRefImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
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
      (workflowProcessType,
       new String[] 
       {
       "name", "WorkflowProcess_._type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_PROCESS_HEADER),
       new String[]
       {
       "kind", "element",
       "name", "ProcessHeader",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_REDEFINABLE_HEADER),
       new String[]
       {
       "kind", "element",
       "name", "RedefinableHeader",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_FORMAL_PARAMETERS),
       new String[]
       {
       "kind", "element",
       "name", "FormalParameters",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_DATA_FIELDS),
       new String[]
       {
       "kind", "element",
       "name", "DataFields",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_PARTICIPANTS),
       new String[]
       {
       "kind", "element",
       "name", "Participants",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_APPLICATIONS),
       new String[]
       {
       "kind", "element",
       "name", "Applications",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_ACTIVITY_SETS),
       new String[]
       {
       "kind", "element",
       "name", "ActivitySets",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_ACTIVITIES),
       new String[]
       {
       "kind", "element",
       "name", "Activities",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_TRANSITIONS),
       new String[]
       {
       "kind", "element",
       "name", "Transitions",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_EXTENDED_ATTRIBUTES),
       new String[]
       {
       "kind", "element",
       "name", "ExtendedAttributes",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_ID),
       new String[]
       {
       "kind", "attribute",
       "name", "Id"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "attribute",
       "name", "Name"
       });

    addXSDMapping
      (getProperty(workflowProcessType, WorkflowProcessImpl.INTERNAL_ACCESS_LEVEL),
       new String[]
       {
       "kind", "attribute",
       "name", "AccessLevel"
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
      (xpressionType,
       new String[] 
       {
       "name", "Xpression_._type",
       "kind", "mixed"
       });

    addXSDMapping
      (getProperty(xpressionType, XpressionImpl.INTERNAL_MIXED),
       new String[]
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });

    addXSDMapping
      (getProperty(xpressionType, XpressionImpl.INTERNAL_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "group:1"
       });

    addXSDMapping
      (getProperty(xpressionType, XpressionImpl.INTERNAL_ANY),
       new String[]
       {
       "kind", "elementWildcard",
       "wildcards", "##any",
       "name", ":2",
       "processing", "lax",
       "group", "#group:1"
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
      (durationUnitType,
       new String[] 
       {
       "name", "DurationUnit_._type",
       "baseType", "commonj.sdo#String",
       "enumeration", "Y M D h m s"
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
      (graphConformanceType,
       new String[] 
       {
       "name", "GraphConformance_._type",
       "baseType", "commonj.sdo#String",
       "enumeration", "FULL_BLOCKED LOOP_BLOCKED NON_BLOCKED"
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
      (modeType,
       new String[] 
       {
       "name", "Mode_._type",
       "baseType", "commonj.sdo#String",
       "enumeration", "IN OUT INOUT"
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
      (typeType,
       new String[] 
       {
       "name", "Type_._type",
       "baseType", "commonj.sdo#String",
       "enumeration", "AND XOR"
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
       "enumeration", "STRING FLOAT INTEGER REFERENCE DATETIME BOOLEAN PERFORMER"
       });

    addXSDMapping
      (type3Type,
       new String[] 
       {
       "name", "Type_._3_._type",
       "baseType", "commonj.sdo#String",
       "enumeration", "AND XOR"
       });

    addXSDMapping
      (type4Type,
       new String[] 
       {
       "name", "Type_._4_._type",
       "baseType", "commonj.sdo#String",
       "enumeration", "RESOURCE_SET RESOURCE ROLE ORGANIZATIONAL_UNIT HUMAN SYSTEM"
       });

    addXSDMapping
      (type5Type,
       new String[] 
       {
       "name", "Type_._5_._type",
       "baseType", "commonj.sdo#String",
       "enumeration", "APPLICATION PROCEDURE"
       });

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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createType5FromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertType5ToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

} //Xpdl1FactoryImpl
