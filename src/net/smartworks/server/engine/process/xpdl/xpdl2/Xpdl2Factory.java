/**
 * <copyright>
 * </copyright>
 *
 * $Id: Xpdl2Factory.java,v 1.1 2009/12/22 06:18:35 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.helper.HelperContext;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface Xpdl2Factory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Xpdl2Factory INSTANCE = net.smartworks.server.engine.process.xpdl.xpdl2.impl.Xpdl2FactoryImpl.init();

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
   * Returns a new object of class '<em>Application Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application Type</em>'.
   * @generated
   */
  ApplicationType createApplicationType();

  /**
   * Returns a new object of class '<em>Array Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Type</em>'.
   * @generated
   */
  ArrayType createArrayType();

  /**
   * Returns a new object of class '<em>Artifact</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Artifact</em>'.
   * @generated
   */
  Artifact createArtifact();

  /**
   * Returns a new object of class '<em>Artifacts</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Artifacts</em>'.
   * @generated
   */
  Artifacts createArtifacts();

  /**
   * Returns a new object of class '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment</em>'.
   * @generated
   */
  Assignment createAssignment();

  /**
   * Returns a new object of class '<em>Assignments</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignments</em>'.
   * @generated
   */
  Assignments createAssignments();

  /**
   * Returns a new object of class '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association</em>'.
   * @generated
   */
  Association createAssociation();

  /**
   * Returns a new object of class '<em>Associations</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Associations</em>'.
   * @generated
   */
  Associations createAssociations();

  /**
   * Returns a new object of class '<em>Author</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Author</em>'.
   * @generated
   */
  Author createAuthor();

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
   * Returns a new object of class '<em>Business Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Business Rule</em>'.
   * @generated
   */
  BusinessRule createBusinessRule();

  /**
   * Returns a new object of class '<em>Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Categories</em>'.
   * @generated
   */
  Categories createCategories();

  /**
   * Returns a new object of class '<em>Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Category</em>'.
   * @generated
   */
  Category createCategory();

  /**
   * Returns a new object of class '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class</em>'.
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.Class createClass();

  /**
   * Returns a new object of class '<em>Codepage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Codepage</em>'.
   * @generated
   */
  Codepage createCodepage();

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
   * Returns a new object of class '<em>Connector Graphics Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Connector Graphics Info</em>'.
   * @generated
   */
  ConnectorGraphicsInfo createConnectorGraphicsInfo();

  /**
   * Returns a new object of class '<em>Connector Graphics Infos</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Connector Graphics Infos</em>'.
   * @generated
   */
  ConnectorGraphicsInfos createConnectorGraphicsInfos();

  /**
   * Returns a new object of class '<em>Coordinates</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Coordinates</em>'.
   * @generated
   */
  Coordinates createCoordinates();

  /**
   * Returns a new object of class '<em>Cost</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cost</em>'.
   * @generated
   */
  Cost createCost();

  /**
   * Returns a new object of class '<em>Cost Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cost Unit</em>'.
   * @generated
   */
  CostUnit createCostUnit();

  /**
   * Returns a new object of class '<em>Countrykey</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Countrykey</em>'.
   * @generated
   */
  Countrykey createCountrykey();

  /**
   * Returns a new object of class '<em>Created</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Created</em>'.
   * @generated
   */
  Created createCreated();

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
   * Returns a new object of class '<em>Data Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Mapping</em>'.
   * @generated
   */
  DataMapping createDataMapping();

  /**
   * Returns a new object of class '<em>Data Mappings</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Mappings</em>'.
   * @generated
   */
  DataMappings createDataMappings();

  /**
   * Returns a new object of class '<em>Data Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Object</em>'.
   * @generated
   */
  DataObject createDataObject();

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
   * Returns a new object of class '<em>Description</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Description</em>'.
   * @generated
   */
  Description createDescription();

  /**
   * Returns a new object of class '<em>Documentation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Documentation</em>'.
   * @generated
   */
  Documentation createDocumentation();

  /**
   * Returns a new object of class '<em>Duration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Duration</em>'.
   * @generated
   */
  Duration createDuration();

  /**
   * Returns a new object of class '<em>Ejb</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ejb</em>'.
   * @generated
   */
  Ejb createEjb();

  /**
   * Returns a new object of class '<em>End Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>End Event</em>'.
   * @generated
   */
  EndEvent createEndEvent();

  /**
   * Returns a new object of class '<em>End Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>End Point</em>'.
   * @generated
   */
  EndPoint createEndPoint();

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
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>Exception Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exception Name</em>'.
   * @generated
   */
  ExceptionName createExceptionName();

  /**
   * Returns a new object of class '<em>Expression Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Type</em>'.
   * @generated
   */
  ExpressionType createExpressionType();

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
   * Returns a new object of class '<em>Form</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Form</em>'.
   * @generated
   */
  Form createForm();

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
   * Returns a new object of class '<em>Form Layout</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Form Layout</em>'.
   * @generated
   */
  FormLayout createFormLayout();

  /**
   * Returns a new object of class '<em>Home Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Home Class</em>'.
   * @generated
   */
  HomeClass createHomeClass();

  /**
   * Returns a new object of class '<em>Icon</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Icon</em>'.
   * @generated
   */
  Icon createIcon();

  /**
   * Returns a new object of class '<em>Implementation7</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implementation7</em>'.
   * @generated
   */
  Implementation7 createImplementation7();

  /**
   * Returns a new object of class '<em>Input</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input</em>'.
   * @generated
   */
  Input createInput();

  /**
   * Returns a new object of class '<em>Input Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Set</em>'.
   * @generated
   */
  InputSet createInputSet();

  /**
   * Returns a new object of class '<em>Input Sets</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Sets</em>'.
   * @generated
   */
  InputSets createInputSets();

  /**
   * Returns a new object of class '<em>Intermediate Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Intermediate Event</em>'.
   * @generated
   */
  IntermediateEvent createIntermediateEvent();

  /**
   * Returns a new object of class '<em>IO Rules</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IO Rules</em>'.
   * @generated
   */
  IORules createIORules();

  /**
   * Returns a new object of class '<em>Jndi Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Jndi Name</em>'.
   * @generated
   */
  JndiName createJndiName();

  /**
   * Returns a new object of class '<em>Join</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Join</em>'.
   * @generated
   */
  Join createJoin();

  /**
   * Returns a new object of class '<em>Lane</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lane</em>'.
   * @generated
   */
  Lane createLane();

  /**
   * Returns a new object of class '<em>Lanes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lanes</em>'.
   * @generated
   */
  Lanes createLanes();

  /**
   * Returns a new object of class '<em>Length</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Length</em>'.
   * @generated
   */
  Length createLength();

  /**
   * Returns a new object of class '<em>Limit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Limit</em>'.
   * @generated
   */
  Limit createLimit();

  /**
   * Returns a new object of class '<em>List Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Type</em>'.
   * @generated
   */
  ListType createListType();

  /**
   * Returns a new object of class '<em>Location</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Location</em>'.
   * @generated
   */
  Location createLocation();

  /**
   * Returns a new object of class '<em>Loop</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loop</em>'.
   * @generated
   */
  Loop createLoop();

  /**
   * Returns a new object of class '<em>Loop Multi Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loop Multi Instance</em>'.
   * @generated
   */
  LoopMultiInstance createLoopMultiInstance();

  /**
   * Returns a new object of class '<em>Loop Standard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loop Standard</em>'.
   * @generated
   */
  LoopStandard createLoopStandard();

  /**
   * Returns a new object of class '<em>Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Member</em>'.
   * @generated
   */
  Member createMember();

  /**
   * Returns a new object of class '<em>Message Flow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Flow</em>'.
   * @generated
   */
  MessageFlow createMessageFlow();

  /**
   * Returns a new object of class '<em>Message Flows</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Flows</em>'.
   * @generated
   */
  MessageFlows createMessageFlows();

  /**
   * Returns a new object of class '<em>Message Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Type</em>'.
   * @generated
   */
  MessageType createMessageType();

  /**
   * Returns a new object of class '<em>Method</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method</em>'.
   * @generated
   */
  Method createMethod();

  /**
   * Returns a new object of class '<em>Method1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method1</em>'.
   * @generated
   */
  Method1 createMethod1();

  /**
   * Returns a new object of class '<em>My Role</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Role</em>'.
   * @generated
   */
  MyRole createMyRole();

  /**
   * Returns a new object of class '<em>No</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>No</em>'.
   * @generated
   */
  No createNo();

  /**
   * Returns a new object of class '<em>Node Graphics Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Graphics Info</em>'.
   * @generated
   */
  NodeGraphicsInfo createNodeGraphicsInfo();

  /**
   * Returns a new object of class '<em>Node Graphics Infos</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Graphics Infos</em>'.
   * @generated
   */
  NodeGraphicsInfos createNodeGraphicsInfos();

  /**
   * Returns a new object of class '<em>Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object</em>'.
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.Object createObject();

  /**
   * Returns a new object of class '<em>Output</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output</em>'.
   * @generated
   */
  Output createOutput();

  /**
   * Returns a new object of class '<em>Output Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Set</em>'.
   * @generated
   */
  OutputSet createOutputSet();

  /**
   * Returns a new object of class '<em>Output Sets</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Sets</em>'.
   * @generated
   */
  OutputSets createOutputSets();

  /**
   * Returns a new object of class '<em>Package Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Header</em>'.
   * @generated
   */
  PackageHeader createPackageHeader();

  /**
   * Returns a new object of class '<em>Package Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Type</em>'.
   * @generated
   */
  PackageType createPackageType();

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
   * Returns a new object of class '<em>Partner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partner</em>'.
   * @generated
   */
  Partner createPartner();

  /**
   * Returns a new object of class '<em>Partner Link</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partner Link</em>'.
   * @generated
   */
  PartnerLink createPartnerLink();

  /**
   * Returns a new object of class '<em>Partner Links</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partner Links</em>'.
   * @generated
   */
  PartnerLinks createPartnerLinks();

  /**
   * Returns a new object of class '<em>Partner Link Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partner Link Type</em>'.
   * @generated
   */
  PartnerLinkType createPartnerLinkType();

  /**
   * Returns a new object of class '<em>Partner Link Types</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partner Link Types</em>'.
   * @generated
   */
  PartnerLinkTypes createPartnerLinkTypes();

  /**
   * Returns a new object of class '<em>Partner Role</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partner Role</em>'.
   * @generated
   */
  PartnerRole createPartnerRole();

  /**
   * Returns a new object of class '<em>Performer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Performer</em>'.
   * @generated
   */
  Performer createPerformer();

  /**
   * Returns a new object of class '<em>Performers</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Performers</em>'.
   * @generated
   */
  Performers createPerformers();

  /**
   * Returns a new object of class '<em>Pojo</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo</em>'.
   * @generated
   */
  Pojo createPojo();

  /**
   * Returns a new object of class '<em>Pool</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pool</em>'.
   * @generated
   */
  Pool createPool();

  /**
   * Returns a new object of class '<em>Pools</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pools</em>'.
   * @generated
   */
  Pools createPools();

  /**
   * Returns a new object of class '<em>Precision</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Precision</em>'.
   * @generated
   */
  Precision createPrecision();

  /**
   * Returns a new object of class '<em>Priority</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Priority</em>'.
   * @generated
   */
  Priority createPriority();

  /**
   * Returns a new object of class '<em>Priority Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Priority Unit</em>'.
   * @generated
   */
  PriorityUnit createPriorityUnit();

  /**
   * Returns a new object of class '<em>Process Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Header</em>'.
   * @generated
   */
  ProcessHeader createProcessHeader();

  /**
   * Returns a new object of class '<em>Process Type1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Type1</em>'.
   * @generated
   */
  ProcessType1 createProcessType1();

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
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Reference createReference();

  /**
   * Returns a new object of class '<em>Responsible</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Responsible</em>'.
   * @generated
   */
  Responsible createResponsible();

  /**
   * Returns a new object of class '<em>Responsibles</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Responsibles</em>'.
   * @generated
   */
  Responsibles createResponsibles();

  /**
   * Returns a new object of class '<em>Result Compensation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Compensation</em>'.
   * @generated
   */
  ResultCompensation createResultCompensation();

  /**
   * Returns a new object of class '<em>Result Error</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Error</em>'.
   * @generated
   */
  ResultError createResultError();

  /**
   * Returns a new object of class '<em>Result Multiple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Multiple</em>'.
   * @generated
   */
  ResultMultiple createResultMultiple();

  /**
   * Returns a new object of class '<em>Role</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role</em>'.
   * @generated
   */
  Role createRole();

  /**
   * Returns a new object of class '<em>Route</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Route</em>'.
   * @generated
   */
  Route createRoute();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  Rule createRule();

  /**
   * Returns a new object of class '<em>Rule Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Name</em>'.
   * @generated
   */
  RuleName createRuleName();

  /**
   * Returns a new object of class '<em>Scale</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scale</em>'.
   * @generated
   */
  Scale createScale();

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
   * Returns a new object of class '<em>Script1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Script1</em>'.
   * @generated
   */
  Script1 createScript1();

  /**
   * Returns a new object of class '<em>Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service</em>'.
   * @generated
   */
  Service createService();

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
   * Returns a new object of class '<em>Start Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Start Event</em>'.
   * @generated
   */
  StartEvent createStartEvent();

  /**
   * Returns a new object of class '<em>Sub Flow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Flow</em>'.
   * @generated
   */
  SubFlow createSubFlow();

  /**
   * Returns a new object of class '<em>Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task</em>'.
   * @generated
   */
  Task createTask();

  /**
   * Returns a new object of class '<em>Task Application</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Application</em>'.
   * @generated
   */
  TaskApplication createTaskApplication();

  /**
   * Returns a new object of class '<em>Task Manual</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Manual</em>'.
   * @generated
   */
  TaskManual createTaskManual();

  /**
   * Returns a new object of class '<em>Task Receive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Receive</em>'.
   * @generated
   */
  TaskReceive createTaskReceive();

  /**
   * Returns a new object of class '<em>Task Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Reference</em>'.
   * @generated
   */
  TaskReference createTaskReference();

  /**
   * Returns a new object of class '<em>Task Script</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Script</em>'.
   * @generated
   */
  TaskScript createTaskScript();

  /**
   * Returns a new object of class '<em>Task Send</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Send</em>'.
   * @generated
   */
  TaskSend createTaskSend();

  /**
   * Returns a new object of class '<em>Task Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task Service</em>'.
   * @generated
   */
  TaskService createTaskService();

  /**
   * Returns a new object of class '<em>Task User</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task User</em>'.
   * @generated
   */
  TaskUser createTaskUser();

  /**
   * Returns a new object of class '<em>Time Estimation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Estimation</em>'.
   * @generated
   */
  TimeEstimation createTimeEstimation();

  /**
   * Returns a new object of class '<em>Transaction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transaction</em>'.
   * @generated
   */
  Transaction createTransaction();

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
   * Returns a new object of class '<em>Trigger Intermediate Multiple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Intermediate Multiple</em>'.
   * @generated
   */
  TriggerIntermediateMultiple createTriggerIntermediateMultiple();

  /**
   * Returns a new object of class '<em>Trigger Multiple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Multiple</em>'.
   * @generated
   */
  TriggerMultiple createTriggerMultiple();

  /**
   * Returns a new object of class '<em>Trigger Result Link</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Result Link</em>'.
   * @generated
   */
  TriggerResultLink createTriggerResultLink();

  /**
   * Returns a new object of class '<em>Trigger Result Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Result Message</em>'.
   * @generated
   */
  TriggerResultMessage createTriggerResultMessage();

  /**
   * Returns a new object of class '<em>Trigger Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Rule</em>'.
   * @generated
   */
  TriggerRule createTriggerRule();

  /**
   * Returns a new object of class '<em>Trigger Timer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Timer</em>'.
   * @generated
   */
  TriggerTimer createTriggerTimer();

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
   * Returns a new object of class '<em>Valid From</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Valid From</em>'.
   * @generated
   */
  ValidFrom createValidFrom();

  /**
   * Returns a new object of class '<em>Valid To</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Valid To</em>'.
   * @generated
   */
  ValidTo createValidTo();

  /**
   * Returns a new object of class '<em>Vendor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Vendor</em>'.
   * @generated
   */
  Vendor createVendor();

  /**
   * Returns a new object of class '<em>Vendor Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Vendor Extension</em>'.
   * @generated
   */
  VendorExtension createVendorExtension();

  /**
   * Returns a new object of class '<em>Vendor Extensions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Vendor Extensions</em>'.
   * @generated
   */
  VendorExtensions createVendorExtensions();

  /**
   * Returns a new object of class '<em>Version</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Version</em>'.
   * @generated
   */
  Version createVersion();

  /**
   * Returns a new object of class '<em>Waiting Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Waiting Time</em>'.
   * @generated
   */
  WaitingTime createWaitingTime();

  /**
   * Returns a new object of class '<em>Web Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Web Service</em>'.
   * @generated
   */
  WebService createWebService();

  /**
   * Returns a new object of class '<em>Web Service Fault Catch</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Web Service Fault Catch</em>'.
   * @generated
   */
  WebServiceFaultCatch createWebServiceFaultCatch();

  /**
   * Returns a new object of class '<em>Web Service Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Web Service Operation</em>'.
   * @generated
   */
  WebServiceOperation createWebServiceOperation();

  /**
   * Returns a new object of class '<em>Workflow Processes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Workflow Processes</em>'.
   * @generated
   */
  WorkflowProcesses createWorkflowProcesses();

  /**
   * Returns a new object of class '<em>Working Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Working Time</em>'.
   * @generated
   */
  WorkingTime createWorkingTime();

  /**
   * Returns a new object of class '<em>XPDL Version</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XPDL Version</em>'.
   * @generated
   */
  XPDLVersion createXPDLVersion();

  /**
   * Returns a new object of class '<em>Xslt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xslt</em>'.
   * @generated
   */
  Xslt createXslt();

  /**
   * Registers the types supported by this Factory within the supplied scope.argument
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param scope an instance of HelperContext used to manage the scoping of types.
   * @generated
   */
  public void register(HelperContext scope);
   
} //Xpdl2Factory
