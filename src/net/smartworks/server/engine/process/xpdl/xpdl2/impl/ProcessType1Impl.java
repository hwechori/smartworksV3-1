/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessType1Impl.java,v 1.1 2009/12/22 06:17:24 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySets;
import net.smartworks.server.engine.process.xpdl.xpdl2.Applications;
import net.smartworks.server.engine.process.xpdl.xpdl2.Assignments;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataFields;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters;
import net.smartworks.server.engine.process.xpdl.xpdl2.Participants;
import net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLinks;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;
import net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getProcessHeader <em>Process Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getRedefinableHeader <em>Redefinable Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getApplications <em>Applications</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getDataFields1 <em>Data Fields1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getParticipants1 <em>Participants1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getApplications1 <em>Applications1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getActivitySets <em>Activity Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getPartnerLinks <em>Partner Links</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getAccessLevel <em>Access Level</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getProcessType <em>Process Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getStatus <em>Status</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#isSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getAdHocOrdering <em>Ad Hoc Ordering</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getDefaultStartActivitySetId <em>Default Start Activity Set Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getDefaultStartActivityId <em>Default Start Activity Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessType1Impl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessType1Impl extends DataObjectBase implements ProcessType1
{

  public final static int PROCESS_HEADER = 0;

  public final static int REDEFINABLE_HEADER = 1;

  public final static int FORMAL_PARAMETERS = 2;

  public final static int PARTICIPANTS = 3;

  public final static int APPLICATIONS = 4;

  public final static int DATA_FIELDS = 5;

  public final static int DATA_FIELDS1 = 6;

  public final static int PARTICIPANTS1 = 7;

  public final static int APPLICATIONS1 = 8;

  public final static int ACTIVITY_SETS = 9;

  public final static int ACTIVITIES = 10;

  public final static int TRANSITIONS = 11;

  public final static int EXTENDED_ATTRIBUTES = 12;

  public final static int ASSIGNMENTS = 13;

  public final static int PARTNER_LINKS = 14;

  public final static int OBJECT = 15;

  public final static int EXTENSIONS = 16;

  public final static int ANY = -1;

  public final static int ID = 17;

  public final static int NAME = 18;

  public final static int ACCESS_LEVEL = 19;

  public final static int PROCESS_TYPE = 20;

  public final static int STATUS = 21;

  public final static int SUPPRESS_JOIN_FAILURE = 22;

  public final static int ENABLE_INSTANCE_COMPENSATION = 23;

  public final static int AD_HOC = 24;

  public final static int AD_HOC_ORDERING = 25;

  public final static int AD_HOC_COMPLETION_CONDITION = 26;

  public final static int DEFAULT_START_ACTIVITY_SET_ID = 27;

  public final static int DEFAULT_START_ACTIVITY_ID = 28;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 29;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Process Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PROCESS_HEADER = 0;

  /**
   * The internal feature id for the '<em><b>Redefinable Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_REDEFINABLE_HEADER = 1;

  /**
   * The internal feature id for the '<em><b>Formal Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FORMAL_PARAMETERS = 2;

  /**
   * The internal feature id for the '<em><b>Participants</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTICIPANTS = 3;

  /**
   * The internal feature id for the '<em><b>Applications</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_APPLICATIONS = 4;

  /**
   * The internal feature id for the '<em><b>Data Fields</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_FIELDS = 5;

  /**
   * The internal feature id for the '<em><b>Data Fields1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_FIELDS1 = 6;

  /**
   * The internal feature id for the '<em><b>Participants1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTICIPANTS1 = 7;

  /**
   * The internal feature id for the '<em><b>Applications1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_APPLICATIONS1 = 8;

  /**
   * The internal feature id for the '<em><b>Activity Sets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTIVITY_SETS = 9;

  /**
   * The internal feature id for the '<em><b>Activities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTIVITIES = 10;

  /**
   * The internal feature id for the '<em><b>Transitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITIONS = 11;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 12;

  /**
   * The internal feature id for the '<em><b>Assignments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ASSIGNMENTS = 13;

  /**
   * The internal feature id for the '<em><b>Partner Links</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTNER_LINKS = 14;

  /**
   * The internal feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OBJECT = 15;

  /**
   * The internal feature id for the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENSIONS = 16;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 17;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 18;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 19;

  /**
   * The internal feature id for the '<em><b>Access Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACCESS_LEVEL = 20;

  /**
   * The internal feature id for the '<em><b>Process Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PROCESS_TYPE = 21;

  /**
   * The internal feature id for the '<em><b>Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_STATUS = 22;

  /**
   * The internal feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SUPPRESS_JOIN_FAILURE = 23;

  /**
   * The internal feature id for the '<em><b>Enable Instance Compensation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ENABLE_INSTANCE_COMPENSATION = 24;

  /**
   * The internal feature id for the '<em><b>Ad Hoc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AD_HOC = 25;

  /**
   * The internal feature id for the '<em><b>Ad Hoc Ordering</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AD_HOC_ORDERING = 26;

  /**
   * The internal feature id for the '<em><b>Ad Hoc Completion Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AD_HOC_COMPLETION_CONDITION = 27;

  /**
   * The internal feature id for the '<em><b>Default Start Activity Set Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEFAULT_START_ACTIVITY_SET_ID = 28;

  /**
   * The internal feature id for the '<em><b>Default Start Activity Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEFAULT_START_ACTIVITY_ID = 29;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 30;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 31;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_PROCESS_HEADER: return PROCESS_HEADER;
      case INTERNAL_REDEFINABLE_HEADER: return REDEFINABLE_HEADER;
      case INTERNAL_FORMAL_PARAMETERS: return FORMAL_PARAMETERS;
      case INTERNAL_PARTICIPANTS: return PARTICIPANTS;
      case INTERNAL_APPLICATIONS: return APPLICATIONS;
      case INTERNAL_DATA_FIELDS: return DATA_FIELDS;
      case INTERNAL_DATA_FIELDS1: return DATA_FIELDS1;
      case INTERNAL_PARTICIPANTS1: return PARTICIPANTS1;
      case INTERNAL_APPLICATIONS1: return APPLICATIONS1;
      case INTERNAL_ACTIVITY_SETS: return ACTIVITY_SETS;
      case INTERNAL_ACTIVITIES: return ACTIVITIES;
      case INTERNAL_TRANSITIONS: return TRANSITIONS;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_ASSIGNMENTS: return ASSIGNMENTS;
      case INTERNAL_PARTNER_LINKS: return PARTNER_LINKS;
      case INTERNAL_OBJECT: return OBJECT;
      case INTERNAL_EXTENSIONS: return EXTENSIONS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_ACCESS_LEVEL: return ACCESS_LEVEL;
      case INTERNAL_PROCESS_TYPE: return PROCESS_TYPE;
      case INTERNAL_STATUS: return STATUS;
      case INTERNAL_SUPPRESS_JOIN_FAILURE: return SUPPRESS_JOIN_FAILURE;
      case INTERNAL_ENABLE_INSTANCE_COMPENSATION: return ENABLE_INSTANCE_COMPENSATION;
      case INTERNAL_AD_HOC: return AD_HOC;
      case INTERNAL_AD_HOC_ORDERING: return AD_HOC_ORDERING;
      case INTERNAL_AD_HOC_COMPLETION_CONDITION: return AD_HOC_COMPLETION_CONDITION;
      case INTERNAL_DEFAULT_START_ACTIVITY_SET_ID: return DEFAULT_START_ACTIVITY_SET_ID;
      case INTERNAL_DEFAULT_START_ACTIVITY_ID: return DEFAULT_START_ACTIVITY_ID;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getProcessHeader() <em>Process Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessHeader()
   * @generated
   * @ordered
   */
  
  protected ProcessHeader processHeader = null;
  
  /**
   * This is true if the Process Header containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean processHeader_set_ = false;

  /**
   * The cached value of the '{@link #getRedefinableHeader() <em>Redefinable Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinableHeader()
   * @generated
   * @ordered
   */
  
  protected RedefinableHeader redefinableHeader = null;
  
  /**
   * This is true if the Redefinable Header containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean redefinableHeader_set_ = false;

  /**
   * The cached value of the '{@link #getFormalParameters() <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameters()
   * @generated
   * @ordered
   */
  
  protected FormalParameters formalParameters = null;
  
  /**
   * This is true if the Formal Parameters containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean formalParameters_set_ = false;

  /**
   * The cached value of the '{@link #getParticipants() <em>Participants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticipants()
   * @generated
   * @ordered
   */
  
  protected Participants participants = null;
  
  /**
   * This is true if the Participants containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean participants_set_ = false;

  /**
   * The cached value of the '{@link #getApplications() <em>Applications</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplications()
   * @generated
   * @ordered
   */
  
  protected Applications applications = null;
  
  /**
   * This is true if the Applications containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean applications_set_ = false;

  /**
   * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataFields()
   * @generated
   * @ordered
   */
  
  protected DataFields dataFields = null;
  
  /**
   * This is true if the Data Fields containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataFields_set_ = false;

  /**
   * The cached value of the '{@link #getDataFields1() <em>Data Fields1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataFields1()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl1.DataFields dataFields1 = null;
  
  /**
   * This is true if the Data Fields1 containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataFields1_set_ = false;

  /**
   * The cached value of the '{@link #getParticipants1() <em>Participants1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticipants1()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl1.Participants participants1 = null;
  
  /**
   * This is true if the Participants1 containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean participants1_set_ = false;

  /**
   * The cached value of the '{@link #getApplications1() <em>Applications1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplications1()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl1.Applications applications1 = null;
  
  /**
   * This is true if the Applications1 containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean applications1_set_ = false;

  /**
   * The cached value of the '{@link #getActivitySets() <em>Activity Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivitySets()
   * @generated
   * @ordered
   */
  
  protected ActivitySets activitySets = null;
  
  /**
   * This is true if the Activity Sets containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean activitySets_set_ = false;

  /**
   * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivities()
   * @generated
   * @ordered
   */
  
  protected Activities activities = null;
  
  /**
   * This is true if the Activities containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean activities_set_ = false;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  
  protected Transitions transitions = null;
  
  /**
   * This is true if the Transitions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transitions_set_ = false;

  /**
   * The cached value of the '{@link #getExtendedAttributes() <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendedAttributes()
   * @generated
   * @ordered
   */
  
  protected ExtendedAttributes extendedAttributes = null;
  
  /**
   * This is true if the Extended Attributes containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extendedAttributes_set_ = false;

  /**
   * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignments()
   * @generated
   * @ordered
   */
  
  protected Assignments assignments = null;
  
  /**
   * This is true if the Assignments containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean assignments_set_ = false;

  /**
   * The cached value of the '{@link #getPartnerLinks() <em>Partner Links</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartnerLinks()
   * @generated
   * @ordered
   */
  
  protected PartnerLinks partnerLinks = null;
  
  /**
   * This is true if the Partner Links containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean partnerLinks_set_ = false;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl2.Object object = null;
  
  /**
   * This is true if the Object containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean object_set_ = false;

  /**
   * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensions()
   * @generated
   * @ordered
   */
  
  protected DataObject extensions = null;
  
  /**
   * This is true if the Extensions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extensions_set_ = false;

  /**
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  
  protected Sequence any = null;
  
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_DEFAULT_;

  /**
   * This is true if the Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean id_set_ = false;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_DEFAULT_;

  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean name_set_ = false;

  /**
   * The default value of the '{@link #getAccessLevel() <em>Access Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessLevel()
   * @generated
   * @ordered
   */
  protected static final String ACCESS_LEVEL_DEFAULT_ = "PUBLIC";

  /**
   * The cached value of the '{@link #getAccessLevel() <em>Access Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessLevel()
   * @generated
   * @ordered
   */
  protected String accessLevel = ACCESS_LEVEL_DEFAULT_;

  /**
   * This is true if the Access Level attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean accessLevel_set_ = false;

  /**
   * The default value of the '{@link #getProcessType() <em>Process Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessType()
   * @generated
   * @ordered
   */
  protected static final String PROCESS_TYPE_DEFAULT_ = "None";

  /**
   * The cached value of the '{@link #getProcessType() <em>Process Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessType()
   * @generated
   * @ordered
   */
  protected String processType = PROCESS_TYPE_DEFAULT_;

  /**
   * This is true if the Process Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean processType_set_ = false;

  /**
   * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected static final String STATUS_DEFAULT_ = "None";

  /**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected String status = STATUS_DEFAULT_;

  /**
   * This is true if the Status attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean status_set_ = false;

  /**
   * The default value of the '{@link #isSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressJoinFailure()
   * @generated
   * @ordered
   */
  protected static final boolean SUPPRESS_JOIN_FAILURE_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSuppressJoinFailure()
   * @generated
   * @ordered
   */
  protected boolean suppressJoinFailure = SUPPRESS_JOIN_FAILURE_DEFAULT_;

  /**
   * This is true if the Suppress Join Failure attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean suppressJoinFailure_set_ = false;

  /**
   * The default value of the '{@link #isEnableInstanceCompensation() <em>Enable Instance Compensation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEnableInstanceCompensation()
   * @generated
   * @ordered
   */
  protected static final boolean ENABLE_INSTANCE_COMPENSATION_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isEnableInstanceCompensation() <em>Enable Instance Compensation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEnableInstanceCompensation()
   * @generated
   * @ordered
   */
  protected boolean enableInstanceCompensation = ENABLE_INSTANCE_COMPENSATION_DEFAULT_;

  /**
   * This is true if the Enable Instance Compensation attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean enableInstanceCompensation_set_ = false;

  /**
   * The default value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdHoc()
   * @generated
   * @ordered
   */
  protected static final boolean AD_HOC_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdHoc()
   * @generated
   * @ordered
   */
  protected boolean adHoc = AD_HOC_DEFAULT_;

  /**
   * This is true if the Ad Hoc attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean adHoc_set_ = false;

  /**
   * The default value of the '{@link #getAdHocOrdering() <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocOrdering()
   * @generated
   * @ordered
   */
  protected static final String AD_HOC_ORDERING_DEFAULT_ = "Parallel";

  /**
   * The cached value of the '{@link #getAdHocOrdering() <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocOrdering()
   * @generated
   * @ordered
   */
  protected String adHocOrdering = AD_HOC_ORDERING_DEFAULT_;

  /**
   * This is true if the Ad Hoc Ordering attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean adHocOrdering_set_ = false;

  /**
   * The default value of the '{@link #getAdHocCompletionCondition() <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocCompletionCondition()
   * @generated
   * @ordered
   */
  protected static final String AD_HOC_COMPLETION_CONDITION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getAdHocCompletionCondition() <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocCompletionCondition()
   * @generated
   * @ordered
   */
  protected String adHocCompletionCondition = AD_HOC_COMPLETION_CONDITION_DEFAULT_;

  /**
   * This is true if the Ad Hoc Completion Condition attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean adHocCompletionCondition_set_ = false;

  /**
   * The default value of the '{@link #getDefaultStartActivitySetId() <em>Default Start Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultStartActivitySetId()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_START_ACTIVITY_SET_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDefaultStartActivitySetId() <em>Default Start Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultStartActivitySetId()
   * @generated
   * @ordered
   */
  protected String defaultStartActivitySetId = DEFAULT_START_ACTIVITY_SET_ID_DEFAULT_;

  /**
   * This is true if the Default Start Activity Set Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean defaultStartActivitySetId_set_ = false;

  /**
   * The default value of the '{@link #getDefaultStartActivityId() <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultStartActivityId()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_START_ACTIVITY_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDefaultStartActivityId() <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultStartActivityId()
   * @generated
   * @ordered
   */
  protected String defaultStartActivityId = DEFAULT_START_ACTIVITY_ID_DEFAULT_;

  /**
   * This is true if the Default Start Activity Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean defaultStartActivityId_set_ = false;

  /**
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  
  protected Sequence anyAttribute = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessType1Impl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getStaticType()
  {
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getProcessType1();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessHeader getProcessHeader()
  {
    return processHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetProcessHeader(ProcessHeader newProcessHeader, ChangeContext changeContext)
  {
    ProcessHeader oldProcessHeader = processHeader;
    processHeader = newProcessHeader;
    boolean oldProcessHeader_set_ = processHeader_set_;
    processHeader_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PROCESS_HEADER, oldProcessHeader, newProcessHeader, !oldProcessHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcessHeader(ProcessHeader newProcessHeader)
  {
    if (newProcessHeader != processHeader)
    {
      ChangeContext changeContext = null;
      if (processHeader != null)
        changeContext = inverseRemove(processHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_PROCESS_HEADER, null, changeContext);
      if (newProcessHeader != null)
        changeContext = inverseAdd(newProcessHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_PROCESS_HEADER, null, changeContext);
      changeContext = basicSetProcessHeader(newProcessHeader, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldProcessHeader_set_ = processHeader_set_;
      processHeader_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PROCESS_HEADER, newProcessHeader, newProcessHeader, !oldProcessHeader_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetProcessHeader(ChangeContext changeContext)
  {
    ProcessHeader oldProcessHeader = processHeader;
    processHeader = null;
    boolean oldProcessHeader_set_ = processHeader_set_;
    processHeader_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PROCESS_HEADER, oldProcessHeader, null, !oldProcessHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetProcessHeader()
  {
    if (processHeader != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(processHeader, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PROCESS_HEADER, null, changeContext);
      changeContext = basicUnsetProcessHeader(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldProcessHeader_set_ = processHeader_set_;
      processHeader_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PROCESS_HEADER, null, null, oldProcessHeader_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetProcessHeader()
  {
    return processHeader_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinableHeader getRedefinableHeader()
  {
    return redefinableHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetRedefinableHeader(RedefinableHeader newRedefinableHeader, ChangeContext changeContext)
  {
    RedefinableHeader oldRedefinableHeader = redefinableHeader;
    redefinableHeader = newRedefinableHeader;
    boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
    redefinableHeader_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_REDEFINABLE_HEADER, oldRedefinableHeader, newRedefinableHeader, !oldRedefinableHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedefinableHeader(RedefinableHeader newRedefinableHeader)
  {
    if (newRedefinableHeader != redefinableHeader)
    {
      ChangeContext changeContext = null;
      if (redefinableHeader != null)
        changeContext = inverseRemove(redefinableHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      if (newRedefinableHeader != null)
        changeContext = inverseAdd(newRedefinableHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      changeContext = basicSetRedefinableHeader(newRedefinableHeader, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
      redefinableHeader_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_REDEFINABLE_HEADER, newRedefinableHeader, newRedefinableHeader, !oldRedefinableHeader_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetRedefinableHeader(ChangeContext changeContext)
  {
    RedefinableHeader oldRedefinableHeader = redefinableHeader;
    redefinableHeader = null;
    boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
    redefinableHeader_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_REDEFINABLE_HEADER, oldRedefinableHeader, null, !oldRedefinableHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRedefinableHeader()
  {
    if (redefinableHeader != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(redefinableHeader, this, EOPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      changeContext = basicUnsetRedefinableHeader(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
      redefinableHeader_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_REDEFINABLE_HEADER, null, null, oldRedefinableHeader_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRedefinableHeader()
  {
    return redefinableHeader_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameters getFormalParameters()
  {
    return formalParameters;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetFormalParameters(FormalParameters newFormalParameters, ChangeContext changeContext)
  {
    FormalParameters oldFormalParameters = formalParameters;
    formalParameters = newFormalParameters;
    boolean oldFormalParameters_set_ = formalParameters_set_;
    formalParameters_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_FORMAL_PARAMETERS, oldFormalParameters, newFormalParameters, !oldFormalParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalParameters(FormalParameters newFormalParameters)
  {
    if (newFormalParameters != formalParameters)
    {
      ChangeContext changeContext = null;
      if (formalParameters != null)
        changeContext = inverseRemove(formalParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_FORMAL_PARAMETERS, null, changeContext);
      if (newFormalParameters != null)
        changeContext = inverseAdd(newFormalParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_FORMAL_PARAMETERS, null, changeContext);
      changeContext = basicSetFormalParameters(newFormalParameters, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldFormalParameters_set_ = formalParameters_set_;
      formalParameters_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_FORMAL_PARAMETERS, newFormalParameters, newFormalParameters, !oldFormalParameters_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetFormalParameters(ChangeContext changeContext)
  {
    FormalParameters oldFormalParameters = formalParameters;
    formalParameters = null;
    boolean oldFormalParameters_set_ = formalParameters_set_;
    formalParameters_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_FORMAL_PARAMETERS, oldFormalParameters, null, !oldFormalParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFormalParameters()
  {
    if (formalParameters != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(formalParameters, this, EOPPOSITE_FEATURE_BASE - INTERNAL_FORMAL_PARAMETERS, null, changeContext);
      changeContext = basicUnsetFormalParameters(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldFormalParameters_set_ = formalParameters_set_;
      formalParameters_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_FORMAL_PARAMETERS, null, null, oldFormalParameters_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFormalParameters()
  {
    return formalParameters_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Participants getParticipants()
  {
    return participants;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetParticipants(Participants newParticipants, ChangeContext changeContext)
  {
    Participants oldParticipants = participants;
    participants = newParticipants;
    boolean oldParticipants_set_ = participants_set_;
    participants_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTICIPANTS, oldParticipants, newParticipants, !oldParticipants_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParticipants(Participants newParticipants)
  {
    if (newParticipants != participants)
    {
      ChangeContext changeContext = null;
      if (participants != null)
        changeContext = inverseRemove(participants, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      if (newParticipants != null)
        changeContext = inverseAdd(newParticipants, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      changeContext = basicSetParticipants(newParticipants, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldParticipants_set_ = participants_set_;
      participants_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTICIPANTS, newParticipants, newParticipants, !oldParticipants_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetParticipants(ChangeContext changeContext)
  {
    Participants oldParticipants = participants;
    participants = null;
    boolean oldParticipants_set_ = participants_set_;
    participants_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTICIPANTS, oldParticipants, null, !oldParticipants_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParticipants()
  {
    if (participants != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(participants, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      changeContext = basicUnsetParticipants(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldParticipants_set_ = participants_set_;
      participants_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTICIPANTS, null, null, oldParticipants_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParticipants()
  {
    return participants_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Applications getApplications()
  {
    return applications;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetApplications(Applications newApplications, ChangeContext changeContext)
  {
    Applications oldApplications = applications;
    applications = newApplications;
    boolean oldApplications_set_ = applications_set_;
    applications_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_APPLICATIONS, oldApplications, newApplications, !oldApplications_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplications(Applications newApplications)
  {
    if (newApplications != applications)
    {
      ChangeContext changeContext = null;
      if (applications != null)
        changeContext = inverseRemove(applications, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      if (newApplications != null)
        changeContext = inverseAdd(newApplications, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      changeContext = basicSetApplications(newApplications, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldApplications_set_ = applications_set_;
      applications_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_APPLICATIONS, newApplications, newApplications, !oldApplications_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetApplications(ChangeContext changeContext)
  {
    Applications oldApplications = applications;
    applications = null;
    boolean oldApplications_set_ = applications_set_;
    applications_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_APPLICATIONS, oldApplications, null, !oldApplications_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetApplications()
  {
    if (applications != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(applications, this, EOPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      changeContext = basicUnsetApplications(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldApplications_set_ = applications_set_;
      applications_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_APPLICATIONS, null, null, oldApplications_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetApplications()
  {
    return applications_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataFields getDataFields()
  {
    return dataFields;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataFields(DataFields newDataFields, ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = newDataFields;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_FIELDS, oldDataFields, newDataFields, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataFields(DataFields newDataFields)
  {
    if (newDataFields != dataFields)
    {
      ChangeContext changeContext = null;
      if (dataFields != null)
        changeContext = inverseRemove(dataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      if (newDataFields != null)
        changeContext = inverseAdd(newDataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicSetDataFields(newDataFields, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_FIELDS, newDataFields, newDataFields, !oldDataFields_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataFields(ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = null;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_FIELDS, oldDataFields, null, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataFields()
  {
    if (dataFields != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataFields, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicUnsetDataFields(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_FIELDS, null, null, oldDataFields_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataFields()
  {
    return dataFields_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl1.DataFields getDataFields1()
  {
    return dataFields1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataFields1(net.smartworks.server.engine.process.xpdl.xpdl1.DataFields newDataFields1, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl1.DataFields oldDataFields1 = dataFields1;
    dataFields1 = newDataFields1;
    boolean oldDataFields1_set_ = dataFields1_set_;
    dataFields1_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_FIELDS1, oldDataFields1, newDataFields1, !oldDataFields1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataFields1(net.smartworks.server.engine.process.xpdl.xpdl1.DataFields newDataFields1)
  {
    if (newDataFields1 != dataFields1)
    {
      ChangeContext changeContext = null;
      if (dataFields1 != null)
        changeContext = inverseRemove(dataFields1, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS1, null, changeContext);
      if (newDataFields1 != null)
        changeContext = inverseAdd(newDataFields1, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS1, null, changeContext);
      changeContext = basicSetDataFields1(newDataFields1, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataFields1_set_ = dataFields1_set_;
      dataFields1_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_FIELDS1, newDataFields1, newDataFields1, !oldDataFields1_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataFields1(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl1.DataFields oldDataFields1 = dataFields1;
    dataFields1 = null;
    boolean oldDataFields1_set_ = dataFields1_set_;
    dataFields1_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_FIELDS1, oldDataFields1, null, !oldDataFields1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataFields1()
  {
    if (dataFields1 != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataFields1, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS1, null, changeContext);
      changeContext = basicUnsetDataFields1(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataFields1_set_ = dataFields1_set_;
      dataFields1_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_FIELDS1, null, null, oldDataFields1_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataFields1()
  {
    return dataFields1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl1.Participants getParticipants1()
  {
    return participants1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetParticipants1(net.smartworks.server.engine.process.xpdl.xpdl1.Participants newParticipants1, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl1.Participants oldParticipants1 = participants1;
    participants1 = newParticipants1;
    boolean oldParticipants1_set_ = participants1_set_;
    participants1_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTICIPANTS1, oldParticipants1, newParticipants1, !oldParticipants1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParticipants1(net.smartworks.server.engine.process.xpdl.xpdl1.Participants newParticipants1)
  {
    if (newParticipants1 != participants1)
    {
      ChangeContext changeContext = null;
      if (participants1 != null)
        changeContext = inverseRemove(participants1, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS1, null, changeContext);
      if (newParticipants1 != null)
        changeContext = inverseAdd(newParticipants1, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS1, null, changeContext);
      changeContext = basicSetParticipants1(newParticipants1, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldParticipants1_set_ = participants1_set_;
      participants1_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTICIPANTS1, newParticipants1, newParticipants1, !oldParticipants1_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetParticipants1(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl1.Participants oldParticipants1 = participants1;
    participants1 = null;
    boolean oldParticipants1_set_ = participants1_set_;
    participants1_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTICIPANTS1, oldParticipants1, null, !oldParticipants1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParticipants1()
  {
    if (participants1 != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(participants1, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS1, null, changeContext);
      changeContext = basicUnsetParticipants1(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldParticipants1_set_ = participants1_set_;
      participants1_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTICIPANTS1, null, null, oldParticipants1_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParticipants1()
  {
    return participants1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl1.Applications getApplications1()
  {
    return applications1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetApplications1(net.smartworks.server.engine.process.xpdl.xpdl1.Applications newApplications1, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl1.Applications oldApplications1 = applications1;
    applications1 = newApplications1;
    boolean oldApplications1_set_ = applications1_set_;
    applications1_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_APPLICATIONS1, oldApplications1, newApplications1, !oldApplications1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplications1(net.smartworks.server.engine.process.xpdl.xpdl1.Applications newApplications1)
  {
    if (newApplications1 != applications1)
    {
      ChangeContext changeContext = null;
      if (applications1 != null)
        changeContext = inverseRemove(applications1, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS1, null, changeContext);
      if (newApplications1 != null)
        changeContext = inverseAdd(newApplications1, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS1, null, changeContext);
      changeContext = basicSetApplications1(newApplications1, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldApplications1_set_ = applications1_set_;
      applications1_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_APPLICATIONS1, newApplications1, newApplications1, !oldApplications1_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetApplications1(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl1.Applications oldApplications1 = applications1;
    applications1 = null;
    boolean oldApplications1_set_ = applications1_set_;
    applications1_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_APPLICATIONS1, oldApplications1, null, !oldApplications1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetApplications1()
  {
    if (applications1 != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(applications1, this, EOPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS1, null, changeContext);
      changeContext = basicUnsetApplications1(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldApplications1_set_ = applications1_set_;
      applications1_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_APPLICATIONS1, null, null, oldApplications1_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetApplications1()
  {
    return applications1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivitySets getActivitySets()
  {
    return activitySets;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActivitySets(ActivitySets newActivitySets, ChangeContext changeContext)
  {
    ActivitySets oldActivitySets = activitySets;
    activitySets = newActivitySets;
    boolean oldActivitySets_set_ = activitySets_set_;
    activitySets_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTIVITY_SETS, oldActivitySets, newActivitySets, !oldActivitySets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivitySets(ActivitySets newActivitySets)
  {
    if (newActivitySets != activitySets)
    {
      ChangeContext changeContext = null;
      if (activitySets != null)
        changeContext = inverseRemove(activitySets, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITY_SETS, null, changeContext);
      if (newActivitySets != null)
        changeContext = inverseAdd(newActivitySets, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITY_SETS, null, changeContext);
      changeContext = basicSetActivitySets(newActivitySets, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActivitySets_set_ = activitySets_set_;
      activitySets_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTIVITY_SETS, newActivitySets, newActivitySets, !oldActivitySets_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActivitySets(ChangeContext changeContext)
  {
    ActivitySets oldActivitySets = activitySets;
    activitySets = null;
    boolean oldActivitySets_set_ = activitySets_set_;
    activitySets_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTIVITY_SETS, oldActivitySets, null, !oldActivitySets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActivitySets()
  {
    if (activitySets != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(activitySets, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITY_SETS, null, changeContext);
      changeContext = basicUnsetActivitySets(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActivitySets_set_ = activitySets_set_;
      activitySets_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTIVITY_SETS, null, null, oldActivitySets_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActivitySets()
  {
    return activitySets_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activities getActivities()
  {
    return activities;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActivities(Activities newActivities, ChangeContext changeContext)
  {
    Activities oldActivities = activities;
    activities = newActivities;
    boolean oldActivities_set_ = activities_set_;
    activities_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTIVITIES, oldActivities, newActivities, !oldActivities_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivities(Activities newActivities)
  {
    if (newActivities != activities)
    {
      ChangeContext changeContext = null;
      if (activities != null)
        changeContext = inverseRemove(activities, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      if (newActivities != null)
        changeContext = inverseAdd(newActivities, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      changeContext = basicSetActivities(newActivities, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActivities_set_ = activities_set_;
      activities_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTIVITIES, newActivities, newActivities, !oldActivities_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActivities(ChangeContext changeContext)
  {
    Activities oldActivities = activities;
    activities = null;
    boolean oldActivities_set_ = activities_set_;
    activities_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTIVITIES, oldActivities, null, !oldActivities_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActivities()
  {
    if (activities != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(activities, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      changeContext = basicUnsetActivities(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActivities_set_ = activities_set_;
      activities_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTIVITIES, null, null, oldActivities_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActivities()
  {
    return activities_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transitions getTransitions()
  {
    return transitions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransitions(Transitions newTransitions, ChangeContext changeContext)
  {
    Transitions oldTransitions = transitions;
    transitions = newTransitions;
    boolean oldTransitions_set_ = transitions_set_;
    transitions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSITIONS, oldTransitions, newTransitions, !oldTransitions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitions(Transitions newTransitions)
  {
    if (newTransitions != transitions)
    {
      ChangeContext changeContext = null;
      if (transitions != null)
        changeContext = inverseRemove(transitions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      if (newTransitions != null)
        changeContext = inverseAdd(newTransitions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      changeContext = basicSetTransitions(newTransitions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransitions_set_ = transitions_set_;
      transitions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSITIONS, newTransitions, newTransitions, !oldTransitions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransitions(ChangeContext changeContext)
  {
    Transitions oldTransitions = transitions;
    transitions = null;
    boolean oldTransitions_set_ = transitions_set_;
    transitions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSITIONS, oldTransitions, null, !oldTransitions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransitions()
  {
    if (transitions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transitions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      changeContext = basicUnsetTransitions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransitions_set_ = transitions_set_;
      transitions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSITIONS, null, null, oldTransitions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransitions()
  {
    return transitions_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedAttributes getExtendedAttributes()
  {
    return extendedAttributes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExtendedAttributes(ExtendedAttributes newExtendedAttributes, ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = newExtendedAttributes;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendedAttributes(ExtendedAttributes newExtendedAttributes)
  {
    if (newExtendedAttributes != extendedAttributes)
    {
      ChangeContext changeContext = null;
      if (extendedAttributes != null)
        changeContext = inverseRemove(extendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      if (newExtendedAttributes != null)
        changeContext = inverseAdd(newExtendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicSetExtendedAttributes(newExtendedAttributes, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, newExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExtendedAttributes(ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = null;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, null, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtendedAttributes()
  {
    if (extendedAttributes != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(extendedAttributes, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicUnsetExtendedAttributes(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, null, null, oldExtendedAttributes_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtendedAttributes()
  {
    return extendedAttributes_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignments getAssignments()
  {
    return assignments;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetAssignments(Assignments newAssignments, ChangeContext changeContext)
  {
    Assignments oldAssignments = assignments;
    assignments = newAssignments;
    boolean oldAssignments_set_ = assignments_set_;
    assignments_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ASSIGNMENTS, oldAssignments, newAssignments, !oldAssignments_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignments(Assignments newAssignments)
  {
    if (newAssignments != assignments)
    {
      ChangeContext changeContext = null;
      if (assignments != null)
        changeContext = inverseRemove(assignments, this, OPPOSITE_FEATURE_BASE - INTERNAL_ASSIGNMENTS, null, changeContext);
      if (newAssignments != null)
        changeContext = inverseAdd(newAssignments, this, OPPOSITE_FEATURE_BASE - INTERNAL_ASSIGNMENTS, null, changeContext);
      changeContext = basicSetAssignments(newAssignments, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldAssignments_set_ = assignments_set_;
      assignments_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ASSIGNMENTS, newAssignments, newAssignments, !oldAssignments_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetAssignments(ChangeContext changeContext)
  {
    Assignments oldAssignments = assignments;
    assignments = null;
    boolean oldAssignments_set_ = assignments_set_;
    assignments_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ASSIGNMENTS, oldAssignments, null, !oldAssignments_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAssignments()
  {
    if (assignments != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(assignments, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ASSIGNMENTS, null, changeContext);
      changeContext = basicUnsetAssignments(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldAssignments_set_ = assignments_set_;
      assignments_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ASSIGNMENTS, null, null, oldAssignments_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAssignments()
  {
    return assignments_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartnerLinks getPartnerLinks()
  {
    return partnerLinks;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPartnerLinks(PartnerLinks newPartnerLinks, ChangeContext changeContext)
  {
    PartnerLinks oldPartnerLinks = partnerLinks;
    partnerLinks = newPartnerLinks;
    boolean oldPartnerLinks_set_ = partnerLinks_set_;
    partnerLinks_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTNER_LINKS, oldPartnerLinks, newPartnerLinks, !oldPartnerLinks_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartnerLinks(PartnerLinks newPartnerLinks)
  {
    if (newPartnerLinks != partnerLinks)
    {
      ChangeContext changeContext = null;
      if (partnerLinks != null)
        changeContext = inverseRemove(partnerLinks, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTNER_LINKS, null, changeContext);
      if (newPartnerLinks != null)
        changeContext = inverseAdd(newPartnerLinks, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTNER_LINKS, null, changeContext);
      changeContext = basicSetPartnerLinks(newPartnerLinks, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPartnerLinks_set_ = partnerLinks_set_;
      partnerLinks_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTNER_LINKS, newPartnerLinks, newPartnerLinks, !oldPartnerLinks_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPartnerLinks(ChangeContext changeContext)
  {
    PartnerLinks oldPartnerLinks = partnerLinks;
    partnerLinks = null;
    boolean oldPartnerLinks_set_ = partnerLinks_set_;
    partnerLinks_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTNER_LINKS, oldPartnerLinks, null, !oldPartnerLinks_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPartnerLinks()
  {
    if (partnerLinks != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(partnerLinks, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTNER_LINKS, null, changeContext);
      changeContext = basicUnsetPartnerLinks(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPartnerLinks_set_ = partnerLinks_set_;
      partnerLinks_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTNER_LINKS, null, null, oldPartnerLinks_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPartnerLinks()
  {
    return partnerLinks_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.Object getObject()
  {
    return object;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object newObject, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Object oldObject = object;
    object = newObject;
    boolean oldObject_set_ = object_set_;
    object_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_OBJECT, oldObject, newObject, !oldObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object newObject)
  {
    if (newObject != object)
    {
      ChangeContext changeContext = null;
      if (object != null)
        changeContext = inverseRemove(object, this, OPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      if (newObject != null)
        changeContext = inverseAdd(newObject, this, OPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      changeContext = basicSetObject(newObject, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldObject_set_ = object_set_;
      object_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_OBJECT, newObject, newObject, !oldObject_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetObject(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Object oldObject = object;
    object = null;
    boolean oldObject_set_ = object_set_;
    object_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_OBJECT, oldObject, null, !oldObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetObject()
  {
    if (object != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(object, this, EOPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      changeContext = basicUnsetObject(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldObject_set_ = object_set_;
      object_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_OBJECT, null, null, oldObject_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetObject()
  {
    return object_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject getExtensions()
  {
    return extensions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExtensions(DataObject newExtensions, ChangeContext changeContext)
  {
    DataObject oldExtensions = extensions;
    extensions = newExtensions;
    boolean oldExtensions_set_ = extensions_set_;
    extensions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTENSIONS, oldExtensions, newExtensions, !oldExtensions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtensions(DataObject newExtensions)
  {
    if (newExtensions != extensions)
    {
      ChangeContext changeContext = null;
      if (extensions != null)
        changeContext = inverseRemove(extensions, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENSIONS, null, changeContext);
      if (newExtensions != null)
        changeContext = inverseAdd(newExtensions, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENSIONS, null, changeContext);
      changeContext = basicSetExtensions(newExtensions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExtensions_set_ = extensions_set_;
      extensions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTENSIONS, newExtensions, newExtensions, !oldExtensions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExtensions(ChangeContext changeContext)
  {
    DataObject oldExtensions = extensions;
    extensions = null;
    boolean oldExtensions_set_ = extensions_set_;
    extensions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTENSIONS, oldExtensions, null, !oldExtensions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtensions()
  {
    if (extensions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(extensions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTENSIONS, null, changeContext);
      changeContext = basicUnsetExtensions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExtensions_set_ = extensions_set_;
      extensions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTENSIONS, null, null, oldExtensions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtensions()
  {
    return extensions_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAny()
  {
    if (any == null)
    {
      any = createSequence(INTERNAL_ANY);
    }
    return any;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    boolean oldId_set_ = id_set_;
    id_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ID, oldId, id, !oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetId()
  {
    String oldId = id;
    boolean oldId_set_ = id_set_;
    id = ID_DEFAULT_;
    id_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ID, oldId, ID_DEFAULT_, oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetId()
  {
    return id_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    boolean oldName_set_ = name_set_;
    name_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAME, oldName, name, !oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetName()
  {
    String oldName = name;
    boolean oldName_set_ = name_set_;
    name = NAME_DEFAULT_;
    name_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAME, oldName, NAME_DEFAULT_, oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetName()
  {
    return name_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAccessLevel()
  {
    return accessLevel;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccessLevel(String newAccessLevel)
  {
    String oldAccessLevel = accessLevel;
    accessLevel = newAccessLevel;
    boolean oldAccessLevel_set_ = accessLevel_set_;
    accessLevel_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ACCESS_LEVEL, oldAccessLevel, accessLevel, !oldAccessLevel_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAccessLevel()
  {
    String oldAccessLevel = accessLevel;
    boolean oldAccessLevel_set_ = accessLevel_set_;
    accessLevel = ACCESS_LEVEL_DEFAULT_;
    accessLevel_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ACCESS_LEVEL, oldAccessLevel, ACCESS_LEVEL_DEFAULT_, oldAccessLevel_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAccessLevel()
  {
    return accessLevel_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProcessType()
  {
    return processType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcessType(String newProcessType)
  {
    String oldProcessType = processType;
    processType = newProcessType;
    boolean oldProcessType_set_ = processType_set_;
    processType_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PROCESS_TYPE, oldProcessType, processType, !oldProcessType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetProcessType()
  {
    String oldProcessType = processType;
    boolean oldProcessType_set_ = processType_set_;
    processType = PROCESS_TYPE_DEFAULT_;
    processType_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PROCESS_TYPE, oldProcessType, PROCESS_TYPE_DEFAULT_, oldProcessType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetProcessType()
  {
    return processType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStatus()
  {
    return status;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatus(String newStatus)
  {
    String oldStatus = status;
    status = newStatus;
    boolean oldStatus_set_ = status_set_;
    status_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_STATUS, oldStatus, status, !oldStatus_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStatus()
  {
    String oldStatus = status;
    boolean oldStatus_set_ = status_set_;
    status = STATUS_DEFAULT_;
    status_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_STATUS, oldStatus, STATUS_DEFAULT_, oldStatus_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStatus()
  {
    return status_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSuppressJoinFailure()
  {
    return suppressJoinFailure;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuppressJoinFailure(boolean newSuppressJoinFailure)
  {
    boolean oldSuppressJoinFailure = suppressJoinFailure;
    suppressJoinFailure = newSuppressJoinFailure;
    boolean oldSuppressJoinFailure_set_ = suppressJoinFailure_set_;
    suppressJoinFailure_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, suppressJoinFailure, !oldSuppressJoinFailure_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSuppressJoinFailure()
  {
    boolean oldSuppressJoinFailure = suppressJoinFailure;
    boolean oldSuppressJoinFailure_set_ = suppressJoinFailure_set_;
    suppressJoinFailure = SUPPRESS_JOIN_FAILURE_DEFAULT_;
    suppressJoinFailure_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, SUPPRESS_JOIN_FAILURE_DEFAULT_, oldSuppressJoinFailure_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSuppressJoinFailure()
  {
    return suppressJoinFailure_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isEnableInstanceCompensation()
  {
    return enableInstanceCompensation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnableInstanceCompensation(boolean newEnableInstanceCompensation)
  {
    boolean oldEnableInstanceCompensation = enableInstanceCompensation;
    enableInstanceCompensation = newEnableInstanceCompensation;
    boolean oldEnableInstanceCompensation_set_ = enableInstanceCompensation_set_;
    enableInstanceCompensation_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ENABLE_INSTANCE_COMPENSATION, oldEnableInstanceCompensation, enableInstanceCompensation, !oldEnableInstanceCompensation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEnableInstanceCompensation()
  {
    boolean oldEnableInstanceCompensation = enableInstanceCompensation;
    boolean oldEnableInstanceCompensation_set_ = enableInstanceCompensation_set_;
    enableInstanceCompensation = ENABLE_INSTANCE_COMPENSATION_DEFAULT_;
    enableInstanceCompensation_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ENABLE_INSTANCE_COMPENSATION, oldEnableInstanceCompensation, ENABLE_INSTANCE_COMPENSATION_DEFAULT_, oldEnableInstanceCompensation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEnableInstanceCompensation()
  {
    return enableInstanceCompensation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAdHoc()
  {
    return adHoc;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdHoc(boolean newAdHoc)
  {
    boolean oldAdHoc = adHoc;
    adHoc = newAdHoc;
    boolean oldAdHoc_set_ = adHoc_set_;
    adHoc_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_AD_HOC, oldAdHoc, adHoc, !oldAdHoc_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAdHoc()
  {
    boolean oldAdHoc = adHoc;
    boolean oldAdHoc_set_ = adHoc_set_;
    adHoc = AD_HOC_DEFAULT_;
    adHoc_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_AD_HOC, oldAdHoc, AD_HOC_DEFAULT_, oldAdHoc_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAdHoc()
  {
    return adHoc_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdHocOrdering()
  {
    return adHocOrdering;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdHocOrdering(String newAdHocOrdering)
  {
    String oldAdHocOrdering = adHocOrdering;
    adHocOrdering = newAdHocOrdering;
    boolean oldAdHocOrdering_set_ = adHocOrdering_set_;
    adHocOrdering_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_AD_HOC_ORDERING, oldAdHocOrdering, adHocOrdering, !oldAdHocOrdering_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAdHocOrdering()
  {
    String oldAdHocOrdering = adHocOrdering;
    boolean oldAdHocOrdering_set_ = adHocOrdering_set_;
    adHocOrdering = AD_HOC_ORDERING_DEFAULT_;
    adHocOrdering_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_AD_HOC_ORDERING, oldAdHocOrdering, AD_HOC_ORDERING_DEFAULT_, oldAdHocOrdering_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAdHocOrdering()
  {
    return adHocOrdering_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdHocCompletionCondition()
  {
    return adHocCompletionCondition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdHocCompletionCondition(String newAdHocCompletionCondition)
  {
    String oldAdHocCompletionCondition = adHocCompletionCondition;
    adHocCompletionCondition = newAdHocCompletionCondition;
    boolean oldAdHocCompletionCondition_set_ = adHocCompletionCondition_set_;
    adHocCompletionCondition_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_AD_HOC_COMPLETION_CONDITION, oldAdHocCompletionCondition, adHocCompletionCondition, !oldAdHocCompletionCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAdHocCompletionCondition()
  {
    String oldAdHocCompletionCondition = adHocCompletionCondition;
    boolean oldAdHocCompletionCondition_set_ = adHocCompletionCondition_set_;
    adHocCompletionCondition = AD_HOC_COMPLETION_CONDITION_DEFAULT_;
    adHocCompletionCondition_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_AD_HOC_COMPLETION_CONDITION, oldAdHocCompletionCondition, AD_HOC_COMPLETION_CONDITION_DEFAULT_, oldAdHocCompletionCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAdHocCompletionCondition()
  {
    return adHocCompletionCondition_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefaultStartActivitySetId()
  {
    return defaultStartActivitySetId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultStartActivitySetId(String newDefaultStartActivitySetId)
  {
    String oldDefaultStartActivitySetId = defaultStartActivitySetId;
    defaultStartActivitySetId = newDefaultStartActivitySetId;
    boolean oldDefaultStartActivitySetId_set_ = defaultStartActivitySetId_set_;
    defaultStartActivitySetId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DEFAULT_START_ACTIVITY_SET_ID, oldDefaultStartActivitySetId, defaultStartActivitySetId, !oldDefaultStartActivitySetId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDefaultStartActivitySetId()
  {
    String oldDefaultStartActivitySetId = defaultStartActivitySetId;
    boolean oldDefaultStartActivitySetId_set_ = defaultStartActivitySetId_set_;
    defaultStartActivitySetId = DEFAULT_START_ACTIVITY_SET_ID_DEFAULT_;
    defaultStartActivitySetId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DEFAULT_START_ACTIVITY_SET_ID, oldDefaultStartActivitySetId, DEFAULT_START_ACTIVITY_SET_ID_DEFAULT_, oldDefaultStartActivitySetId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDefaultStartActivitySetId()
  {
    return defaultStartActivitySetId_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefaultStartActivityId()
  {
    return defaultStartActivityId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultStartActivityId(String newDefaultStartActivityId)
  {
    String oldDefaultStartActivityId = defaultStartActivityId;
    defaultStartActivityId = newDefaultStartActivityId;
    boolean oldDefaultStartActivityId_set_ = defaultStartActivityId_set_;
    defaultStartActivityId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DEFAULT_START_ACTIVITY_ID, oldDefaultStartActivityId, defaultStartActivityId, !oldDefaultStartActivityId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDefaultStartActivityId()
  {
    String oldDefaultStartActivityId = defaultStartActivityId;
    boolean oldDefaultStartActivityId_set_ = defaultStartActivityId_set_;
    defaultStartActivityId = DEFAULT_START_ACTIVITY_ID_DEFAULT_;
    defaultStartActivityId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DEFAULT_START_ACTIVITY_ID, oldDefaultStartActivityId, DEFAULT_START_ACTIVITY_ID_DEFAULT_, oldDefaultStartActivityId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDefaultStartActivityId()
  {
    return defaultStartActivityId_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAnyAttribute()
  {
    if (anyAttribute == null)
    {
      anyAttribute = createSequence(INTERNAL_ANY_ATTRIBUTE);
    }
    return anyAttribute;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case PROCESS_HEADER:
        return basicUnsetProcessHeader(changeContext);
      case REDEFINABLE_HEADER:
        return basicUnsetRedefinableHeader(changeContext);
      case FORMAL_PARAMETERS:
        return basicUnsetFormalParameters(changeContext);
      case PARTICIPANTS:
        return basicUnsetParticipants(changeContext);
      case APPLICATIONS:
        return basicUnsetApplications(changeContext);
      case DATA_FIELDS:
        return basicUnsetDataFields(changeContext);
      case DATA_FIELDS1:
        return basicUnsetDataFields1(changeContext);
      case PARTICIPANTS1:
        return basicUnsetParticipants1(changeContext);
      case APPLICATIONS1:
        return basicUnsetApplications1(changeContext);
      case ACTIVITY_SETS:
        return basicUnsetActivitySets(changeContext);
      case ACTIVITIES:
        return basicUnsetActivities(changeContext);
      case TRANSITIONS:
        return basicUnsetTransitions(changeContext);
      case EXTENDED_ATTRIBUTES:
        return basicUnsetExtendedAttributes(changeContext);
      case ASSIGNMENTS:
        return basicUnsetAssignments(changeContext);
      case PARTNER_LINKS:
        return basicUnsetPartnerLinks(changeContext);
      case OBJECT:
        return basicUnsetObject(changeContext);
      case EXTENSIONS:
        return basicUnsetExtensions(changeContext);
      case ANY:
        return removeFromSequence(getAny(), otherEnd, changeContext);
      case ANY_ATTRIBUTE:
        return removeFromSequence(getAnyAttribute(), otherEnd, changeContext);
    }
    return super.inverseRemove(otherEnd, propertyIndex, changeContext);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object get(int propertyIndex, boolean resolve)
  {
    switch (propertyIndex)
    {
      case PROCESS_HEADER:
        return getProcessHeader();
      case REDEFINABLE_HEADER:
        return getRedefinableHeader();
      case FORMAL_PARAMETERS:
        return getFormalParameters();
      case PARTICIPANTS:
        return getParticipants();
      case APPLICATIONS:
        return getApplications();
      case DATA_FIELDS:
        return getDataFields();
      case DATA_FIELDS1:
        return getDataFields1();
      case PARTICIPANTS1:
        return getParticipants1();
      case APPLICATIONS1:
        return getApplications1();
      case ACTIVITY_SETS:
        return getActivitySets();
      case ACTIVITIES:
        return getActivities();
      case TRANSITIONS:
        return getTransitions();
      case EXTENDED_ATTRIBUTES:
        return getExtendedAttributes();
      case ASSIGNMENTS:
        return getAssignments();
      case PARTNER_LINKS:
        return getPartnerLinks();
      case OBJECT:
        return getObject();
      case EXTENSIONS:
        return getExtensions();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ID:
        return getId();
      case NAME:
        return getName();
      case ACCESS_LEVEL:
        return getAccessLevel();
      case PROCESS_TYPE:
        return getProcessType();
      case STATUS:
        return getStatus();
      case SUPPRESS_JOIN_FAILURE:
        return isSuppressJoinFailure() ? Boolean.TRUE : Boolean.FALSE;
      case ENABLE_INSTANCE_COMPENSATION:
        return isEnableInstanceCompensation() ? Boolean.TRUE : Boolean.FALSE;
      case AD_HOC:
        return isAdHoc() ? Boolean.TRUE : Boolean.FALSE;
      case AD_HOC_ORDERING:
        return getAdHocOrdering();
      case AD_HOC_COMPLETION_CONDITION:
        return getAdHocCompletionCondition();
      case DEFAULT_START_ACTIVITY_SET_ID:
        return getDefaultStartActivitySetId();
      case DEFAULT_START_ACTIVITY_ID:
        return getDefaultStartActivityId();
      case ANY_ATTRIBUTE:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAnyAttribute();
    }
    return super.get(propertyIndex, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void set(int propertyIndex, Object newValue)
  {
    switch (propertyIndex)
    {
      case PROCESS_HEADER:
        setProcessHeader((ProcessHeader)newValue);
        return;
      case REDEFINABLE_HEADER:
        setRedefinableHeader((RedefinableHeader)newValue);
        return;
      case FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)newValue);
        return;
      case PARTICIPANTS:
        setParticipants((Participants)newValue);
        return;
      case APPLICATIONS:
        setApplications((Applications)newValue);
        return;
      case DATA_FIELDS:
        setDataFields((DataFields)newValue);
        return;
      case DATA_FIELDS1:
        setDataFields1((net.smartworks.server.engine.process.xpdl.xpdl1.DataFields)newValue);
        return;
      case PARTICIPANTS1:
        setParticipants1((net.smartworks.server.engine.process.xpdl.xpdl1.Participants)newValue);
        return;
      case APPLICATIONS1:
        setApplications1((net.smartworks.server.engine.process.xpdl.xpdl1.Applications)newValue);
        return;
      case ACTIVITY_SETS:
        setActivitySets((ActivitySets)newValue);
        return;
      case ACTIVITIES:
        setActivities((Activities)newValue);
        return;
      case TRANSITIONS:
        setTransitions((Transitions)newValue);
        return;
      case EXTENDED_ATTRIBUTES:
        setExtendedAttributes((ExtendedAttributes)newValue);
        return;
      case ASSIGNMENTS:
        setAssignments((Assignments)newValue);
        return;
      case PARTNER_LINKS:
        setPartnerLinks((PartnerLinks)newValue);
        return;
      case OBJECT:
        setObject((net.smartworks.server.engine.process.xpdl.xpdl2.Object)newValue);
        return;
      case EXTENSIONS:
        setExtensions((DataObject)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case NAME:
        setName((String)newValue);
        return;
      case ACCESS_LEVEL:
        setAccessLevel((String)newValue);
        return;
      case PROCESS_TYPE:
        setProcessType((String)newValue);
        return;
      case STATUS:
        setStatus((String)newValue);
        return;
      case SUPPRESS_JOIN_FAILURE:
        setSuppressJoinFailure(((Boolean)newValue).booleanValue());
        return;
      case ENABLE_INSTANCE_COMPENSATION:
        setEnableInstanceCompensation(((Boolean)newValue).booleanValue());
        return;
      case AD_HOC:
        setAdHoc(((Boolean)newValue).booleanValue());
        return;
      case AD_HOC_ORDERING:
        setAdHocOrdering((String)newValue);
        return;
      case AD_HOC_COMPLETION_CONDITION:
        setAdHocCompletionCondition((String)newValue);
        return;
      case DEFAULT_START_ACTIVITY_SET_ID:
        setDefaultStartActivitySetId((String)newValue);
        return;
      case DEFAULT_START_ACTIVITY_ID:
        setDefaultStartActivityId((String)newValue);
        return;
      case ANY_ATTRIBUTE:
      	setSequence(getAnyAttribute(), newValue);
        return;
    }
    super.set(propertyIndex, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unset(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case PROCESS_HEADER:
        unsetProcessHeader();
        return;
      case REDEFINABLE_HEADER:
        unsetRedefinableHeader();
        return;
      case FORMAL_PARAMETERS:
        unsetFormalParameters();
        return;
      case PARTICIPANTS:
        unsetParticipants();
        return;
      case APPLICATIONS:
        unsetApplications();
        return;
      case DATA_FIELDS:
        unsetDataFields();
        return;
      case DATA_FIELDS1:
        unsetDataFields1();
        return;
      case PARTICIPANTS1:
        unsetParticipants1();
        return;
      case APPLICATIONS1:
        unsetApplications1();
        return;
      case ACTIVITY_SETS:
        unsetActivitySets();
        return;
      case ACTIVITIES:
        unsetActivities();
        return;
      case TRANSITIONS:
        unsetTransitions();
        return;
      case EXTENDED_ATTRIBUTES:
        unsetExtendedAttributes();
        return;
      case ASSIGNMENTS:
        unsetAssignments();
        return;
      case PARTNER_LINKS:
        unsetPartnerLinks();
        return;
      case OBJECT:
        unsetObject();
        return;
      case EXTENSIONS:
        unsetExtensions();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case ID:
        unsetId();
        return;
      case NAME:
        unsetName();
        return;
      case ACCESS_LEVEL:
        unsetAccessLevel();
        return;
      case PROCESS_TYPE:
        unsetProcessType();
        return;
      case STATUS:
        unsetStatus();
        return;
      case SUPPRESS_JOIN_FAILURE:
        unsetSuppressJoinFailure();
        return;
      case ENABLE_INSTANCE_COMPENSATION:
        unsetEnableInstanceCompensation();
        return;
      case AD_HOC:
        unsetAdHoc();
        return;
      case AD_HOC_ORDERING:
        unsetAdHocOrdering();
        return;
      case AD_HOC_COMPLETION_CONDITION:
        unsetAdHocCompletionCondition();
        return;
      case DEFAULT_START_ACTIVITY_SET_ID:
        unsetDefaultStartActivitySetId();
        return;
      case DEFAULT_START_ACTIVITY_ID:
        unsetDefaultStartActivityId();
        return;
      case ANY_ATTRIBUTE:
        unsetSequence(getAnyAttribute());
        return;
    }
    super.unset(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSet(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case PROCESS_HEADER:
        return isSetProcessHeader();
      case REDEFINABLE_HEADER:
        return isSetRedefinableHeader();
      case FORMAL_PARAMETERS:
        return isSetFormalParameters();
      case PARTICIPANTS:
        return isSetParticipants();
      case APPLICATIONS:
        return isSetApplications();
      case DATA_FIELDS:
        return isSetDataFields();
      case DATA_FIELDS1:
        return isSetDataFields1();
      case PARTICIPANTS1:
        return isSetParticipants1();
      case APPLICATIONS1:
        return isSetApplications1();
      case ACTIVITY_SETS:
        return isSetActivitySets();
      case ACTIVITIES:
        return isSetActivities();
      case TRANSITIONS:
        return isSetTransitions();
      case EXTENDED_ATTRIBUTES:
        return isSetExtendedAttributes();
      case ASSIGNMENTS:
        return isSetAssignments();
      case PARTNER_LINKS:
        return isSetPartnerLinks();
      case OBJECT:
        return isSetObject();
      case EXTENSIONS:
        return isSetExtensions();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case ACCESS_LEVEL:
        return isSetAccessLevel();
      case PROCESS_TYPE:
        return isSetProcessType();
      case STATUS:
        return isSetStatus();
      case SUPPRESS_JOIN_FAILURE:
        return isSetSuppressJoinFailure();
      case ENABLE_INSTANCE_COMPENSATION:
        return isSetEnableInstanceCompensation();
      case AD_HOC:
        return isSetAdHoc();
      case AD_HOC_ORDERING:
        return isSetAdHocOrdering();
      case AD_HOC_COMPLETION_CONDITION:
        return isSetAdHocCompletionCondition();
      case DEFAULT_START_ACTIVITY_SET_ID:
        return isSetDefaultStartActivitySetId();
      case DEFAULT_START_ACTIVITY_ID:
        return isSetDefaultStartActivityId();
      case ANY_ATTRIBUTE:
        return anyAttribute != null && !isSequenceEmpty(getAnyAttribute());
    }
    return super.isSet(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (isProxy(this)) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (any: ");
    result.append(any);
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", AccessLevel: ");
    if (accessLevel_set_) result.append(accessLevel); else result.append("<unset>");
    result.append(", ProcessType: ");
    if (processType_set_) result.append(processType); else result.append("<unset>");
    result.append(", Status: ");
    if (status_set_) result.append(status); else result.append("<unset>");
    result.append(", SuppressJoinFailure: ");
    if (suppressJoinFailure_set_) result.append(suppressJoinFailure); else result.append("<unset>");
    result.append(", EnableInstanceCompensation: ");
    if (enableInstanceCompensation_set_) result.append(enableInstanceCompensation); else result.append("<unset>");
    result.append(", AdHoc: ");
    if (adHoc_set_) result.append(adHoc); else result.append("<unset>");
    result.append(", AdHocOrdering: ");
    if (adHocOrdering_set_) result.append(adHocOrdering); else result.append("<unset>");
    result.append(", AdHocCompletionCondition: ");
    if (adHocCompletionCondition_set_) result.append(adHocCompletionCondition); else result.append("<unset>");
    result.append(", DefaultStartActivitySetId: ");
    if (defaultStartActivitySetId_set_) result.append(defaultStartActivitySetId); else result.append("<unset>");
    result.append(", DefaultStartActivityId: ");
    if (defaultStartActivityId_set_) result.append(defaultStartActivityId); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //ProcessType1Impl
