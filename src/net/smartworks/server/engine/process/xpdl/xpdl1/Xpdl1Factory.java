/**
 * <copyright>
 * </copyright>
 *
 * $Id: Xpdl1Factory.java,v 1.1 2009/12/22 06:18:09 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import commonj.sdo.helper.HelperContext;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface Xpdl1Factory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Xpdl1Factory INSTANCE = net.smartworks.server.engine.process.xpdl.xpdl1.impl.Xpdl1FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Activities</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activities</em>'.
   * @generated
   */
  Activities createActivities();

  /**
   * Returns a new object of class '<em>Activity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity</em>'.
   * @generated
   */
  Activity createActivity();

  /**
   * Returns a new object of class '<em>Activity Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity Set</em>'.
   * @generated
   */
  ActivitySet createActivitySet();

  /**
   * Returns a new object of class '<em>Activity Sets</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity Sets</em>'.
   * @generated
   */
  ActivitySets createActivitySets();

  /**
   * Returns a new object of class '<em>Actual Parameters</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actual Parameters</em>'.
   * @generated
   */
  ActualParameters createActualParameters();

  /**
   * Returns a new object of class '<em>Application</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application</em>'.
   * @generated
   */
  Application createApplication();

  /**
   * Returns a new object of class '<em>Applications</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Applications</em>'.
   * @generated
   */
  Applications createApplications();

  /**
   * Returns a new object of class '<em>Array Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Type</em>'.
   * @generated
   */
  ArrayType createArrayType();

  /**
   * Returns a new object of class '<em>Automatic</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Automatic</em>'.
   * @generated
   */
  Automatic createAutomatic();

  /**
   * Returns a new object of class '<em>Basic Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Basic Type</em>'.
   * @generated
   */
  BasicType createBasicType();

  /**
   * Returns a new object of class '<em>Block Activity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block Activity</em>'.
   * @generated
   */
  BlockActivity createBlockActivity();

  /**
   * Returns a new object of class '<em>Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition</em>'.
   * @generated
   */
  Condition createCondition();

  /**
   * Returns a new object of class '<em>Conformance Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conformance Class</em>'.
   * @generated
   */
  ConformanceClass createConformanceClass();

  /**
   * Returns a new object of class '<em>Data Field</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Field</em>'.
   * @generated
   */
  DataField createDataField();

  /**
   * Returns a new object of class '<em>Data Fields</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Fields</em>'.
   * @generated
   */
  DataFields createDataFields();

  /**
   * Returns a new object of class '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type</em>'.
   * @generated
   */
  DataType createDataType();

  /**
   * Returns a new object of class '<em>Deadline</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Deadline</em>'.
   * @generated
   */
  Deadline createDeadline();

  /**
   * Returns a new object of class '<em>Declared Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declared Type</em>'.
   * @generated
   */
  DeclaredType createDeclaredType();

  /**
   * Returns a new object of class '<em>Enumeration Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Type</em>'.
   * @generated
   */
  EnumerationType createEnumerationType();

  /**
   * Returns a new object of class '<em>Enumeration Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Value</em>'.
   * @generated
   */
  EnumerationValue createEnumerationValue();

  /**
   * Returns a new object of class '<em>Extended Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended Attribute</em>'.
   * @generated
   */
  ExtendedAttribute createExtendedAttribute();

  /**
   * Returns a new object of class '<em>Extended Attributes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended Attributes</em>'.
   * @generated
   */
  ExtendedAttributes createExtendedAttributes();

  /**
   * Returns a new object of class '<em>External Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Package</em>'.
   * @generated
   */
  ExternalPackage createExternalPackage();

  /**
   * Returns a new object of class '<em>External Packages</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Packages</em>'.
   * @generated
   */
  ExternalPackages createExternalPackages();

  /**
   * Returns a new object of class '<em>External Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Reference</em>'.
   * @generated
   */
  ExternalReference createExternalReference();

  /**
   * Returns a new object of class '<em>Finish Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Finish Mode</em>'.
   * @generated
   */
  FinishMode createFinishMode();

  /**
   * Returns a new object of class '<em>Formal Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameter</em>'.
   * @generated
   */
  FormalParameter createFormalParameter();

  /**
   * Returns a new object of class '<em>Formal Parameters</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameters</em>'.
   * @generated
   */
  FormalParameters createFormalParameters();

  /**
   * Returns a new object of class '<em>Implementation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implementation</em>'.
   * @generated
   */
  Implementation createImplementation();

  /**
   * Returns a new object of class '<em>Join</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Join</em>'.
   * @generated
   */
  Join createJoin();

  /**
   * Returns a new object of class '<em>List Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Type</em>'.
   * @generated
   */
  ListType createListType();

  /**
   * Returns a new object of class '<em>Manual</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Manual</em>'.
   * @generated
   */
  Manual createManual();

  /**
   * Returns a new object of class '<em>Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Member</em>'.
   * @generated
   */
  Member createMember();

  /**
   * Returns a new object of class '<em>No</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>No</em>'.
   * @generated
   */
  No createNo();

  /**
   * Returns a new object of class '<em>Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package</em>'.
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl1.Package createPackage();

  /**
   * Returns a new object of class '<em>Package Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Header</em>'.
   * @generated
   */
  PackageHeader createPackageHeader();

  /**
   * Returns a new object of class '<em>Participant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Participant</em>'.
   * @generated
   */
  Participant createParticipant();

  /**
   * Returns a new object of class '<em>Participants</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Participants</em>'.
   * @generated
   */
  Participants createParticipants();

  /**
   * Returns a new object of class '<em>Participant Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Participant Type</em>'.
   * @generated
   */
  ParticipantType createParticipantType();

  /**
   * Returns a new object of class '<em>Process Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Header</em>'.
   * @generated
   */
  ProcessHeader createProcessHeader();

  /**
   * Returns a new object of class '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Type</em>'.
   * @generated
   */
  RecordType createRecordType();

  /**
   * Returns a new object of class '<em>Redefinable Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Redefinable Header</em>'.
   * @generated
   */
  RedefinableHeader createRedefinableHeader();

  /**
   * Returns a new object of class '<em>Responsibles</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Responsibles</em>'.
   * @generated
   */
  Responsibles createResponsibles();

  /**
   * Returns a new object of class '<em>Route</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Route</em>'.
   * @generated
   */
  Route createRoute();

  /**
   * Returns a new object of class '<em>Schema Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Schema Type</em>'.
   * @generated
   */
  SchemaType createSchemaType();

  /**
   * Returns a new object of class '<em>Script</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Script</em>'.
   * @generated
   */
  Script createScript();

  /**
   * Returns a new object of class '<em>Simulation Information</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simulation Information</em>'.
   * @generated
   */
  SimulationInformation createSimulationInformation();

  /**
   * Returns a new object of class '<em>Split</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Split</em>'.
   * @generated
   */
  Split createSplit();

  /**
   * Returns a new object of class '<em>Start Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Start Mode</em>'.
   * @generated
   */
  StartMode createStartMode();

  /**
   * Returns a new object of class '<em>Sub Flow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Flow</em>'.
   * @generated
   */
  SubFlow createSubFlow();

  /**
   * Returns a new object of class '<em>Time Estimation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Estimation</em>'.
   * @generated
   */
  TimeEstimation createTimeEstimation();

  /**
   * Returns a new object of class '<em>Tool</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tool</em>'.
   * @generated
   */
  Tool createTool();

  /**
   * Returns a new object of class '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition</em>'.
   * @generated
   */
  Transition createTransition();

  /**
   * Returns a new object of class '<em>Transition Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Ref</em>'.
   * @generated
   */
  TransitionRef createTransitionRef();

  /**
   * Returns a new object of class '<em>Transition Refs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Refs</em>'.
   * @generated
   */
  TransitionRefs createTransitionRefs();

  /**
   * Returns a new object of class '<em>Transition Restriction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Restriction</em>'.
   * @generated
   */
  TransitionRestriction createTransitionRestriction();

  /**
   * Returns a new object of class '<em>Transition Restrictions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Restrictions</em>'.
   * @generated
   */
  TransitionRestrictions createTransitionRestrictions();

  /**
   * Returns a new object of class '<em>Transitions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transitions</em>'.
   * @generated
   */
  Transitions createTransitions();

  /**
   * Returns a new object of class '<em>Type Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Declaration</em>'.
   * @generated
   */
  TypeDeclaration createTypeDeclaration();

  /**
   * Returns a new object of class '<em>Type Declarations</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Declarations</em>'.
   * @generated
   */
  TypeDeclarations createTypeDeclarations();

  /**
   * Returns a new object of class '<em>Union Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Union Type</em>'.
   * @generated
   */
  UnionType createUnionType();

  /**
   * Returns a new object of class '<em>Workflow Process</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Workflow Process</em>'.
   * @generated
   */
  WorkflowProcess createWorkflowProcess();

  /**
   * Returns a new object of class '<em>Workflow Processes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Workflow Processes</em>'.
   * @generated
   */
  WorkflowProcesses createWorkflowProcesses();

  /**
   * Returns a new object of class '<em>Xpression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xpression</em>'.
   * @generated
   */
  Xpression createXpression();

  /**
   * Registers the types supported by this Factory within the supplied scope.argument
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param scope an instance of HelperContext used to manage the scoping of types.
   * @generated
   */
  public void register(HelperContext scope);
   
} //Xpdl1Factory
