/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivityImpl.java,v 1.1 2009/12/22 06:17:37 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity;
import net.smartworks.server.engine.process.xpdl.xpdl1.Deadline;
import net.smartworks.server.engine.process.xpdl.xpdl1.FinishMode;
import net.smartworks.server.engine.process.xpdl.xpdl1.StartMode;

import net.smartworks.server.engine.process.xpdl.xpdl2.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl2.Assignments;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataFields;
import net.smartworks.server.engine.process.xpdl.xpdl2.Description;
import net.smartworks.server.engine.process.xpdl.xpdl2.Documentation;
import net.smartworks.server.engine.process.xpdl.xpdl2.Event;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl2.IORules;
import net.smartworks.server.engine.process.xpdl.xpdl2.Icon;
import net.smartworks.server.engine.process.xpdl.xpdl2.Implementation7;
import net.smartworks.server.engine.process.xpdl.xpdl2.InputSets;
import net.smartworks.server.engine.process.xpdl.xpdl2.Limit;
import net.smartworks.server.engine.process.xpdl.xpdl2.Loop;
import net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfos;
import net.smartworks.server.engine.process.xpdl.xpdl2.OutputSets;
import net.smartworks.server.engine.process.xpdl.xpdl2.Performer;
import net.smartworks.server.engine.process.xpdl.xpdl2.Performers;
import net.smartworks.server.engine.process.xpdl.xpdl2.Priority;
import net.smartworks.server.engine.process.xpdl.xpdl2.Route;
import net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transaction;
import net.smartworks.server.engine.process.xpdl.xpdl2.TransitionRestrictions;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import java.math.BigInteger;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getLimit <em>Limit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getBlockActivity <em>Block Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getBlockActivity1 <em>Block Activity1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getTransaction <em>Transaction</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getPerformer <em>Performer</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getPerformers <em>Performers</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getStartMode <em>Start Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getFinishMode <em>Finish Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getDeadline1 <em>Deadline1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getSimulationInformation <em>Simulation Information</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getTransitionRestrictions <em>Transition Restrictions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getInputSets <em>Input Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getOutputSets <em>Output Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getIORules <em>IO Rules</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getLoop <em>Loop</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getNodeGraphicsInfos <em>Node Graphics Infos</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#isStartActivity <em>Start Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getStartMode1 <em>Start Mode1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getFinishMode1 <em>Finish Mode1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getStartQuantity <em>Start Quantity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#isIsATransaction <em>Is ATransaction</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivityImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends DataObjectBase implements Activity
{

  public final static int DESCRIPTION = 0;

  public final static int LIMIT = 1;

  public final static int ROUTE = 2;

  public final static int IMPLEMENTATION = 3;

  public final static int BLOCK_ACTIVITY = 4;

  public final static int BLOCK_ACTIVITY1 = 5;

  public final static int EVENT = 6;

  public final static int TRANSACTION = 7;

  public final static int PERFORMER = 8;

  public final static int PERFORMERS = 9;

  public final static int START_MODE = 10;

  public final static int FINISH_MODE = 11;

  public final static int PRIORITY = 12;

  public final static int DEADLINE = 13;

  public final static int DEADLINE1 = 14;

  public final static int SIMULATION_INFORMATION = 15;

  public final static int ICON = 16;

  public final static int DOCUMENTATION = 17;

  public final static int TRANSITION_RESTRICTIONS = 18;

  public final static int EXTENDED_ATTRIBUTES = 19;

  public final static int DATA_FIELDS = 20;

  public final static int INPUT_SETS = 21;

  public final static int OUTPUT_SETS = 22;

  public final static int IO_RULES = 23;

  public final static int LOOP = 24;

  public final static int ASSIGNMENTS = 25;

  public final static int OBJECT = 26;

  public final static int NODE_GRAPHICS_INFOS = 27;

  public final static int EXTENSIONS = 28;

  public final static int ANY = -1;

  public final static int ID = 29;

  public final static int NAME = 30;

  public final static int START_ACTIVITY = 31;

  public final static int STATUS = 32;

  public final static int START_MODE1 = 33;

  public final static int FINISH_MODE1 = 34;

  public final static int START_QUANTITY = 35;

  public final static int IS_ATRANSACTION = 36;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 37;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 0;

  /**
   * The internal feature id for the '<em><b>Limit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LIMIT = 1;

  /**
   * The internal feature id for the '<em><b>Route</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ROUTE = 2;

  /**
   * The internal feature id for the '<em><b>Implementation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IMPLEMENTATION = 3;

  /**
   * The internal feature id for the '<em><b>Block Activity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BLOCK_ACTIVITY = 4;

  /**
   * The internal feature id for the '<em><b>Block Activity1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BLOCK_ACTIVITY1 = 5;

  /**
   * The internal feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EVENT = 6;

  /**
   * The internal feature id for the '<em><b>Transaction</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSACTION = 7;

  /**
   * The internal feature id for the '<em><b>Performer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PERFORMER = 8;

  /**
   * The internal feature id for the '<em><b>Performers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PERFORMERS = 9;

  /**
   * The internal feature id for the '<em><b>Start Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_START_MODE = 10;

  /**
   * The internal feature id for the '<em><b>Finish Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FINISH_MODE = 11;

  /**
   * The internal feature id for the '<em><b>Priority</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRIORITY = 12;

  /**
   * The internal feature id for the '<em><b>Deadline</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEADLINE = 13;

  /**
   * The internal feature id for the '<em><b>Deadline1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEADLINE1 = 14;

  /**
   * The internal feature id for the '<em><b>Simulation Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SIMULATION_INFORMATION = 15;

  /**
   * The internal feature id for the '<em><b>Icon</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ICON = 16;

  /**
   * The internal feature id for the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DOCUMENTATION = 17;

  /**
   * The internal feature id for the '<em><b>Transition Restrictions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITION_RESTRICTIONS = 18;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 19;

  /**
   * The internal feature id for the '<em><b>Data Fields</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_FIELDS = 20;

  /**
   * The internal feature id for the '<em><b>Input Sets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INPUT_SETS = 21;

  /**
   * The internal feature id for the '<em><b>Output Sets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OUTPUT_SETS = 22;

  /**
   * The internal feature id for the '<em><b>IO Rules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IO_RULES = 23;

  /**
   * The internal feature id for the '<em><b>Loop</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP = 24;

  /**
   * The internal feature id for the '<em><b>Assignments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ASSIGNMENTS = 25;

  /**
   * The internal feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OBJECT = 26;

  /**
   * The internal feature id for the '<em><b>Node Graphics Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NODE_GRAPHICS_INFOS = 27;

  /**
   * The internal feature id for the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENSIONS = 28;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 29;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 30;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 31;

  /**
   * The internal feature id for the '<em><b>Start Activity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_START_ACTIVITY = 32;

  /**
   * The internal feature id for the '<em><b>Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_STATUS = 33;

  /**
   * The internal feature id for the '<em><b>Start Mode1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_START_MODE1 = 34;

  /**
   * The internal feature id for the '<em><b>Finish Mode1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FINISH_MODE1 = 35;

  /**
   * The internal feature id for the '<em><b>Start Quantity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_START_QUANTITY = 36;

  /**
   * The internal feature id for the '<em><b>Is ATransaction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IS_ATRANSACTION = 37;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 38;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 39;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_LIMIT: return LIMIT;
      case INTERNAL_ROUTE: return ROUTE;
      case INTERNAL_IMPLEMENTATION: return IMPLEMENTATION;
      case INTERNAL_BLOCK_ACTIVITY: return BLOCK_ACTIVITY;
      case INTERNAL_BLOCK_ACTIVITY1: return BLOCK_ACTIVITY1;
      case INTERNAL_EVENT: return EVENT;
      case INTERNAL_TRANSACTION: return TRANSACTION;
      case INTERNAL_PERFORMER: return PERFORMER;
      case INTERNAL_PERFORMERS: return PERFORMERS;
      case INTERNAL_START_MODE: return START_MODE;
      case INTERNAL_FINISH_MODE: return FINISH_MODE;
      case INTERNAL_PRIORITY: return PRIORITY;
      case INTERNAL_DEADLINE: return DEADLINE;
      case INTERNAL_DEADLINE1: return DEADLINE1;
      case INTERNAL_SIMULATION_INFORMATION: return SIMULATION_INFORMATION;
      case INTERNAL_ICON: return ICON;
      case INTERNAL_DOCUMENTATION: return DOCUMENTATION;
      case INTERNAL_TRANSITION_RESTRICTIONS: return TRANSITION_RESTRICTIONS;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_DATA_FIELDS: return DATA_FIELDS;
      case INTERNAL_INPUT_SETS: return INPUT_SETS;
      case INTERNAL_OUTPUT_SETS: return OUTPUT_SETS;
      case INTERNAL_IO_RULES: return IO_RULES;
      case INTERNAL_LOOP: return LOOP;
      case INTERNAL_ASSIGNMENTS: return ASSIGNMENTS;
      case INTERNAL_OBJECT: return OBJECT;
      case INTERNAL_NODE_GRAPHICS_INFOS: return NODE_GRAPHICS_INFOS;
      case INTERNAL_EXTENSIONS: return EXTENSIONS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_START_ACTIVITY: return START_ACTIVITY;
      case INTERNAL_STATUS: return STATUS;
      case INTERNAL_START_MODE1: return START_MODE1;
      case INTERNAL_FINISH_MODE1: return FINISH_MODE1;
      case INTERNAL_START_QUANTITY: return START_QUANTITY;
      case INTERNAL_IS_ATRANSACTION: return IS_ATRANSACTION;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  
  protected Description description = null;
  
  /**
   * This is true if the Description containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean description_set_ = false;

  /**
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  
  protected Limit limit = null;
  
  /**
   * This is true if the Limit containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean limit_set_ = false;

  /**
   * The cached value of the '{@link #getRoute() <em>Route</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoute()
   * @generated
   * @ordered
   */
  
  protected Route route = null;
  
  /**
   * This is true if the Route containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean route_set_ = false;

  /**
   * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementation()
   * @generated
   * @ordered
   */
  
  protected Implementation7 implementation = null;
  
  /**
   * This is true if the Implementation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean implementation_set_ = false;

  /**
   * The cached value of the '{@link #getBlockActivity() <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockActivity()
   * @generated
   * @ordered
   */
  
  protected BlockActivity blockActivity = null;
  
  /**
   * This is true if the Block Activity containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean blockActivity_set_ = false;

  /**
   * The cached value of the '{@link #getBlockActivity1() <em>Block Activity1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockActivity1()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity blockActivity1 = null;
  
  /**
   * This is true if the Block Activity1 containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean blockActivity1_set_ = false;

  /**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
  
  protected Event event = null;
  
  /**
   * This is true if the Event containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean event_set_ = false;

  /**
   * The cached value of the '{@link #getTransaction() <em>Transaction</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransaction()
   * @generated
   * @ordered
   */
  
  protected Transaction transaction = null;
  
  /**
   * This is true if the Transaction containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transaction_set_ = false;

  /**
   * The cached value of the '{@link #getPerformer() <em>Performer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPerformer()
   * @generated
   * @ordered
   */
  
  protected Performer performer = null;
  
  /**
   * This is true if the Performer containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean performer_set_ = false;

  /**
   * The cached value of the '{@link #getPerformers() <em>Performers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPerformers()
   * @generated
   * @ordered
   */
  
  protected Performers performers = null;
  
  /**
   * This is true if the Performers containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean performers_set_ = false;

  /**
   * The cached value of the '{@link #getStartMode() <em>Start Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartMode()
   * @generated
   * @ordered
   */
  
  protected StartMode startMode = null;
  
  /**
   * This is true if the Start Mode containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean startMode_set_ = false;

  /**
   * The cached value of the '{@link #getFinishMode() <em>Finish Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinishMode()
   * @generated
   * @ordered
   */
  
  protected FinishMode finishMode = null;
  
  /**
   * This is true if the Finish Mode containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean finishMode_set_ = false;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  
  protected Priority priority = null;
  
  /**
   * This is true if the Priority containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean priority_set_ = false;

  /**
   * The cached value of the '{@link #getDeadline() <em>Deadline</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeadline()
   * @generated
   * @ordered
   */
  
  protected List deadline = null;
  
  /**
   * The cached value of the '{@link #getDeadline1() <em>Deadline1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeadline1()
   * @generated
   * @ordered
   */
  
  protected List deadline1 = null;
  
  /**
   * The cached value of the '{@link #getSimulationInformation() <em>Simulation Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimulationInformation()
   * @generated
   * @ordered
   */
  
  protected SimulationInformation simulationInformation = null;
  
  /**
   * This is true if the Simulation Information containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean simulationInformation_set_ = false;

  /**
   * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIcon()
   * @generated
   * @ordered
   */
  
  protected Icon icon = null;
  
  /**
   * This is true if the Icon containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean icon_set_ = false;

  /**
   * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  
  protected Documentation documentation = null;
  
  /**
   * This is true if the Documentation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean documentation_set_ = false;

  /**
   * The cached value of the '{@link #getTransitionRestrictions() <em>Transition Restrictions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionRestrictions()
   * @generated
   * @ordered
   */
  
  protected TransitionRestrictions transitionRestrictions = null;
  
  /**
   * This is true if the Transition Restrictions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transitionRestrictions_set_ = false;

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
   * The cached value of the '{@link #getInputSets() <em>Input Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputSets()
   * @generated
   * @ordered
   */
  
  protected InputSets inputSets = null;
  
  /**
   * This is true if the Input Sets containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean inputSets_set_ = false;

  /**
   * The cached value of the '{@link #getOutputSets() <em>Output Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputSets()
   * @generated
   * @ordered
   */
  
  protected OutputSets outputSets = null;
  
  /**
   * This is true if the Output Sets containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean outputSets_set_ = false;

  /**
   * The cached value of the '{@link #getIORules() <em>IO Rules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIORules()
   * @generated
   * @ordered
   */
  
  protected IORules ioRules = null;
  
  /**
   * This is true if the IO Rules containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean ioRules_set_ = false;

  /**
   * The cached value of the '{@link #getLoop() <em>Loop</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoop()
   * @generated
   * @ordered
   */
  
  protected Loop loop = null;
  
  /**
   * This is true if the Loop containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loop_set_ = false;

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
   * The cached value of the '{@link #getNodeGraphicsInfos() <em>Node Graphics Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeGraphicsInfos()
   * @generated
   * @ordered
   */
  
  protected NodeGraphicsInfos nodeGraphicsInfos = null;
  
  /**
   * This is true if the Node Graphics Infos containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean nodeGraphicsInfos_set_ = false;

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
   * The default value of the '{@link #isStartActivity() <em>Start Activity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStartActivity()
   * @generated
   * @ordered
   */
  protected static final boolean START_ACTIVITY_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isStartActivity() <em>Start Activity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStartActivity()
   * @generated
   * @ordered
   */
  protected boolean startActivity = START_ACTIVITY_DEFAULT_;

  /**
   * This is true if the Start Activity attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean startActivity_set_ = false;

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
   * The default value of the '{@link #getStartMode1() <em>Start Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartMode1()
   * @generated
   * @ordered
   */
  protected static final String START_MODE1_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getStartMode1() <em>Start Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartMode1()
   * @generated
   * @ordered
   */
  protected String startMode1 = START_MODE1_DEFAULT_;

  /**
   * This is true if the Start Mode1 attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean startMode1_set_ = false;

  /**
   * The default value of the '{@link #getFinishMode1() <em>Finish Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinishMode1()
   * @generated
   * @ordered
   */
  protected static final String FINISH_MODE1_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getFinishMode1() <em>Finish Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinishMode1()
   * @generated
   * @ordered
   */
  protected String finishMode1 = FINISH_MODE1_DEFAULT_;

  /**
   * This is true if the Finish Mode1 attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean finishMode1_set_ = false;

  /**
   * The default value of the '{@link #getStartQuantity() <em>Start Quantity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartQuantity()
   * @generated
   * @ordered
   */
  protected static final BigInteger START_QUANTITY_DEFAULT_ = new BigInteger("1");

  /**
   * The cached value of the '{@link #getStartQuantity() <em>Start Quantity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartQuantity()
   * @generated
   * @ordered
   */
  protected BigInteger startQuantity = START_QUANTITY_DEFAULT_;

  /**
   * This is true if the Start Quantity attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean startQuantity_set_ = false;

  /**
   * The default value of the '{@link #isIsATransaction() <em>Is ATransaction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsATransaction()
   * @generated
   * @ordered
   */
  protected static final boolean IS_ATRANSACTION_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isIsATransaction() <em>Is ATransaction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsATransaction()
   * @generated
   * @ordered
   */
  protected boolean isATransaction = IS_ATRANSACTION_DEFAULT_;

  /**
   * This is true if the Is ATransaction attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean isATransaction_set_ = false;

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
  public ActivityImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getActivity();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description getDescription()
  {
    return description;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDescription(Description newDescription, ChangeContext changeContext)
  {
    Description oldDescription = description;
    description = newDescription;
    boolean oldDescription_set_ = description_set_;
    description_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DESCRIPTION, oldDescription, newDescription, !oldDescription_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(Description newDescription)
  {
    if (newDescription != description)
    {
      ChangeContext changeContext = null;
      if (description != null)
        changeContext = inverseRemove(description, this, OPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      if (newDescription != null)
        changeContext = inverseAdd(newDescription, this, OPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      changeContext = basicSetDescription(newDescription, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDescription_set_ = description_set_;
      description_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DESCRIPTION, newDescription, newDescription, !oldDescription_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDescription(ChangeContext changeContext)
  {
    Description oldDescription = description;
    description = null;
    boolean oldDescription_set_ = description_set_;
    description_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DESCRIPTION, oldDescription, null, !oldDescription_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDescription()
  {
    if (description != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(description, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      changeContext = basicUnsetDescription(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDescription_set_ = description_set_;
      description_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DESCRIPTION, null, null, oldDescription_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDescription()
  {
    return description_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Limit getLimit()
  {
    return limit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLimit(Limit newLimit, ChangeContext changeContext)
  {
    Limit oldLimit = limit;
    limit = newLimit;
    boolean oldLimit_set_ = limit_set_;
    limit_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LIMIT, oldLimit, newLimit, !oldLimit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimit(Limit newLimit)
  {
    if (newLimit != limit)
    {
      ChangeContext changeContext = null;
      if (limit != null)
        changeContext = inverseRemove(limit, this, OPPOSITE_FEATURE_BASE - INTERNAL_LIMIT, null, changeContext);
      if (newLimit != null)
        changeContext = inverseAdd(newLimit, this, OPPOSITE_FEATURE_BASE - INTERNAL_LIMIT, null, changeContext);
      changeContext = basicSetLimit(newLimit, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLimit_set_ = limit_set_;
      limit_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LIMIT, newLimit, newLimit, !oldLimit_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLimit(ChangeContext changeContext)
  {
    Limit oldLimit = limit;
    limit = null;
    boolean oldLimit_set_ = limit_set_;
    limit_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LIMIT, oldLimit, null, !oldLimit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLimit()
  {
    if (limit != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(limit, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LIMIT, null, changeContext);
      changeContext = basicUnsetLimit(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLimit_set_ = limit_set_;
      limit_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LIMIT, null, null, oldLimit_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLimit()
  {
    return limit_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Route getRoute()
  {
    return route;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetRoute(Route newRoute, ChangeContext changeContext)
  {
    Route oldRoute = route;
    route = newRoute;
    boolean oldRoute_set_ = route_set_;
    route_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ROUTE, oldRoute, newRoute, !oldRoute_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoute(Route newRoute)
  {
    if (newRoute != route)
    {
      ChangeContext changeContext = null;
      if (route != null)
        changeContext = inverseRemove(route, this, OPPOSITE_FEATURE_BASE - INTERNAL_ROUTE, null, changeContext);
      if (newRoute != null)
        changeContext = inverseAdd(newRoute, this, OPPOSITE_FEATURE_BASE - INTERNAL_ROUTE, null, changeContext);
      changeContext = basicSetRoute(newRoute, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldRoute_set_ = route_set_;
      route_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ROUTE, newRoute, newRoute, !oldRoute_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetRoute(ChangeContext changeContext)
  {
    Route oldRoute = route;
    route = null;
    boolean oldRoute_set_ = route_set_;
    route_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ROUTE, oldRoute, null, !oldRoute_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRoute()
  {
    if (route != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(route, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ROUTE, null, changeContext);
      changeContext = basicUnsetRoute(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldRoute_set_ = route_set_;
      route_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ROUTE, null, null, oldRoute_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRoute()
  {
    return route_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Implementation7 getImplementation()
  {
    return implementation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetImplementation(Implementation7 newImplementation, ChangeContext changeContext)
  {
    Implementation7 oldImplementation = implementation;
    implementation = newImplementation;
    boolean oldImplementation_set_ = implementation_set_;
    implementation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_IMPLEMENTATION, oldImplementation, newImplementation, !oldImplementation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImplementation(Implementation7 newImplementation)
  {
    if (newImplementation != implementation)
    {
      ChangeContext changeContext = null;
      if (implementation != null)
        changeContext = inverseRemove(implementation, this, OPPOSITE_FEATURE_BASE - INTERNAL_IMPLEMENTATION, null, changeContext);
      if (newImplementation != null)
        changeContext = inverseAdd(newImplementation, this, OPPOSITE_FEATURE_BASE - INTERNAL_IMPLEMENTATION, null, changeContext);
      changeContext = basicSetImplementation(newImplementation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldImplementation_set_ = implementation_set_;
      implementation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_IMPLEMENTATION, newImplementation, newImplementation, !oldImplementation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetImplementation(ChangeContext changeContext)
  {
    Implementation7 oldImplementation = implementation;
    implementation = null;
    boolean oldImplementation_set_ = implementation_set_;
    implementation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_IMPLEMENTATION, oldImplementation, null, !oldImplementation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetImplementation()
  {
    if (implementation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(implementation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_IMPLEMENTATION, null, changeContext);
      changeContext = basicUnsetImplementation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldImplementation_set_ = implementation_set_;
      implementation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_IMPLEMENTATION, null, null, oldImplementation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetImplementation()
  {
    return implementation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockActivity getBlockActivity()
  {
    return blockActivity;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetBlockActivity(BlockActivity newBlockActivity, ChangeContext changeContext)
  {
    BlockActivity oldBlockActivity = blockActivity;
    blockActivity = newBlockActivity;
    boolean oldBlockActivity_set_ = blockActivity_set_;
    blockActivity_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY, oldBlockActivity, newBlockActivity, !oldBlockActivity_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlockActivity(BlockActivity newBlockActivity)
  {
    if (newBlockActivity != blockActivity)
    {
      ChangeContext changeContext = null;
      if (blockActivity != null)
        changeContext = inverseRemove(blockActivity, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      if (newBlockActivity != null)
        changeContext = inverseAdd(newBlockActivity, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      changeContext = basicSetBlockActivity(newBlockActivity, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldBlockActivity_set_ = blockActivity_set_;
      blockActivity_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY, newBlockActivity, newBlockActivity, !oldBlockActivity_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetBlockActivity(ChangeContext changeContext)
  {
    BlockActivity oldBlockActivity = blockActivity;
    blockActivity = null;
    boolean oldBlockActivity_set_ = blockActivity_set_;
    blockActivity_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY, oldBlockActivity, null, !oldBlockActivity_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBlockActivity()
  {
    if (blockActivity != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(blockActivity, this, EOPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      changeContext = basicUnsetBlockActivity(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldBlockActivity_set_ = blockActivity_set_;
      blockActivity_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY, null, null, oldBlockActivity_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBlockActivity()
  {
    return blockActivity_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity getBlockActivity1()
  {
    return blockActivity1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetBlockActivity1(net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity newBlockActivity1, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity oldBlockActivity1 = blockActivity1;
    blockActivity1 = newBlockActivity1;
    boolean oldBlockActivity1_set_ = blockActivity1_set_;
    blockActivity1_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY1, oldBlockActivity1, newBlockActivity1, !oldBlockActivity1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlockActivity1(net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity newBlockActivity1)
  {
    if (newBlockActivity1 != blockActivity1)
    {
      ChangeContext changeContext = null;
      if (blockActivity1 != null)
        changeContext = inverseRemove(blockActivity1, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY1, null, changeContext);
      if (newBlockActivity1 != null)
        changeContext = inverseAdd(newBlockActivity1, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY1, null, changeContext);
      changeContext = basicSetBlockActivity1(newBlockActivity1, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldBlockActivity1_set_ = blockActivity1_set_;
      blockActivity1_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY1, newBlockActivity1, newBlockActivity1, !oldBlockActivity1_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetBlockActivity1(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity oldBlockActivity1 = blockActivity1;
    blockActivity1 = null;
    boolean oldBlockActivity1_set_ = blockActivity1_set_;
    blockActivity1_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY1, oldBlockActivity1, null, !oldBlockActivity1_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBlockActivity1()
  {
    if (blockActivity1 != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(blockActivity1, this, EOPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY1, null, changeContext);
      changeContext = basicUnsetBlockActivity1(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldBlockActivity1_set_ = blockActivity1_set_;
      blockActivity1_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY1, null, null, oldBlockActivity1_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBlockActivity1()
  {
    return blockActivity1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event getEvent()
  {
    return event;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetEvent(Event newEvent, ChangeContext changeContext)
  {
    Event oldEvent = event;
    event = newEvent;
    boolean oldEvent_set_ = event_set_;
    event_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EVENT, oldEvent, newEvent, !oldEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvent(Event newEvent)
  {
    if (newEvent != event)
    {
      ChangeContext changeContext = null;
      if (event != null)
        changeContext = inverseRemove(event, this, OPPOSITE_FEATURE_BASE - INTERNAL_EVENT, null, changeContext);
      if (newEvent != null)
        changeContext = inverseAdd(newEvent, this, OPPOSITE_FEATURE_BASE - INTERNAL_EVENT, null, changeContext);
      changeContext = basicSetEvent(newEvent, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldEvent_set_ = event_set_;
      event_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EVENT, newEvent, newEvent, !oldEvent_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetEvent(ChangeContext changeContext)
  {
    Event oldEvent = event;
    event = null;
    boolean oldEvent_set_ = event_set_;
    event_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EVENT, oldEvent, null, !oldEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEvent()
  {
    if (event != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(event, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EVENT, null, changeContext);
      changeContext = basicUnsetEvent(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldEvent_set_ = event_set_;
      event_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EVENT, null, null, oldEvent_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEvent()
  {
    return event_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transaction getTransaction()
  {
    return transaction;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransaction(Transaction newTransaction, ChangeContext changeContext)
  {
    Transaction oldTransaction = transaction;
    transaction = newTransaction;
    boolean oldTransaction_set_ = transaction_set_;
    transaction_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSACTION, oldTransaction, newTransaction, !oldTransaction_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransaction(Transaction newTransaction)
  {
    if (newTransaction != transaction)
    {
      ChangeContext changeContext = null;
      if (transaction != null)
        changeContext = inverseRemove(transaction, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSACTION, null, changeContext);
      if (newTransaction != null)
        changeContext = inverseAdd(newTransaction, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSACTION, null, changeContext);
      changeContext = basicSetTransaction(newTransaction, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransaction_set_ = transaction_set_;
      transaction_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSACTION, newTransaction, newTransaction, !oldTransaction_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransaction(ChangeContext changeContext)
  {
    Transaction oldTransaction = transaction;
    transaction = null;
    boolean oldTransaction_set_ = transaction_set_;
    transaction_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSACTION, oldTransaction, null, !oldTransaction_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransaction()
  {
    if (transaction != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transaction, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSACTION, null, changeContext);
      changeContext = basicUnsetTransaction(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransaction_set_ = transaction_set_;
      transaction_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSACTION, null, null, oldTransaction_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransaction()
  {
    return transaction_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Performer getPerformer()
  {
    return performer;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPerformer(Performer newPerformer, ChangeContext changeContext)
  {
    Performer oldPerformer = performer;
    performer = newPerformer;
    boolean oldPerformer_set_ = performer_set_;
    performer_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PERFORMER, oldPerformer, newPerformer, !oldPerformer_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPerformer(Performer newPerformer)
  {
    if (newPerformer != performer)
    {
      ChangeContext changeContext = null;
      if (performer != null)
        changeContext = inverseRemove(performer, this, OPPOSITE_FEATURE_BASE - INTERNAL_PERFORMER, null, changeContext);
      if (newPerformer != null)
        changeContext = inverseAdd(newPerformer, this, OPPOSITE_FEATURE_BASE - INTERNAL_PERFORMER, null, changeContext);
      changeContext = basicSetPerformer(newPerformer, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPerformer_set_ = performer_set_;
      performer_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PERFORMER, newPerformer, newPerformer, !oldPerformer_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPerformer(ChangeContext changeContext)
  {
    Performer oldPerformer = performer;
    performer = null;
    boolean oldPerformer_set_ = performer_set_;
    performer_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PERFORMER, oldPerformer, null, !oldPerformer_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPerformer()
  {
    if (performer != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(performer, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PERFORMER, null, changeContext);
      changeContext = basicUnsetPerformer(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPerformer_set_ = performer_set_;
      performer_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PERFORMER, null, null, oldPerformer_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPerformer()
  {
    return performer_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Performers getPerformers()
  {
    return performers;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPerformers(Performers newPerformers, ChangeContext changeContext)
  {
    Performers oldPerformers = performers;
    performers = newPerformers;
    boolean oldPerformers_set_ = performers_set_;
    performers_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PERFORMERS, oldPerformers, newPerformers, !oldPerformers_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPerformers(Performers newPerformers)
  {
    if (newPerformers != performers)
    {
      ChangeContext changeContext = null;
      if (performers != null)
        changeContext = inverseRemove(performers, this, OPPOSITE_FEATURE_BASE - INTERNAL_PERFORMERS, null, changeContext);
      if (newPerformers != null)
        changeContext = inverseAdd(newPerformers, this, OPPOSITE_FEATURE_BASE - INTERNAL_PERFORMERS, null, changeContext);
      changeContext = basicSetPerformers(newPerformers, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPerformers_set_ = performers_set_;
      performers_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PERFORMERS, newPerformers, newPerformers, !oldPerformers_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPerformers(ChangeContext changeContext)
  {
    Performers oldPerformers = performers;
    performers = null;
    boolean oldPerformers_set_ = performers_set_;
    performers_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PERFORMERS, oldPerformers, null, !oldPerformers_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPerformers()
  {
    if (performers != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(performers, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PERFORMERS, null, changeContext);
      changeContext = basicUnsetPerformers(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPerformers_set_ = performers_set_;
      performers_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PERFORMERS, null, null, oldPerformers_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPerformers()
  {
    return performers_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StartMode getStartMode()
  {
    return startMode;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetStartMode(StartMode newStartMode, ChangeContext changeContext)
  {
    StartMode oldStartMode = startMode;
    startMode = newStartMode;
    boolean oldStartMode_set_ = startMode_set_;
    startMode_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_START_MODE, oldStartMode, newStartMode, !oldStartMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartMode(StartMode newStartMode)
  {
    if (newStartMode != startMode)
    {
      ChangeContext changeContext = null;
      if (startMode != null)
        changeContext = inverseRemove(startMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_START_MODE, null, changeContext);
      if (newStartMode != null)
        changeContext = inverseAdd(newStartMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_START_MODE, null, changeContext);
      changeContext = basicSetStartMode(newStartMode, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldStartMode_set_ = startMode_set_;
      startMode_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_START_MODE, newStartMode, newStartMode, !oldStartMode_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetStartMode(ChangeContext changeContext)
  {
    StartMode oldStartMode = startMode;
    startMode = null;
    boolean oldStartMode_set_ = startMode_set_;
    startMode_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_START_MODE, oldStartMode, null, !oldStartMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStartMode()
  {
    if (startMode != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(startMode, this, EOPPOSITE_FEATURE_BASE - INTERNAL_START_MODE, null, changeContext);
      changeContext = basicUnsetStartMode(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldStartMode_set_ = startMode_set_;
      startMode_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_START_MODE, null, null, oldStartMode_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStartMode()
  {
    return startMode_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinishMode getFinishMode()
  {
    return finishMode;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetFinishMode(FinishMode newFinishMode, ChangeContext changeContext)
  {
    FinishMode oldFinishMode = finishMode;
    finishMode = newFinishMode;
    boolean oldFinishMode_set_ = finishMode_set_;
    finishMode_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_FINISH_MODE, oldFinishMode, newFinishMode, !oldFinishMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinishMode(FinishMode newFinishMode)
  {
    if (newFinishMode != finishMode)
    {
      ChangeContext changeContext = null;
      if (finishMode != null)
        changeContext = inverseRemove(finishMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_FINISH_MODE, null, changeContext);
      if (newFinishMode != null)
        changeContext = inverseAdd(newFinishMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_FINISH_MODE, null, changeContext);
      changeContext = basicSetFinishMode(newFinishMode, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldFinishMode_set_ = finishMode_set_;
      finishMode_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_FINISH_MODE, newFinishMode, newFinishMode, !oldFinishMode_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetFinishMode(ChangeContext changeContext)
  {
    FinishMode oldFinishMode = finishMode;
    finishMode = null;
    boolean oldFinishMode_set_ = finishMode_set_;
    finishMode_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_FINISH_MODE, oldFinishMode, null, !oldFinishMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFinishMode()
  {
    if (finishMode != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(finishMode, this, EOPPOSITE_FEATURE_BASE - INTERNAL_FINISH_MODE, null, changeContext);
      changeContext = basicUnsetFinishMode(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldFinishMode_set_ = finishMode_set_;
      finishMode_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_FINISH_MODE, null, null, oldFinishMode_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFinishMode()
  {
    return finishMode_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Priority getPriority()
  {
    return priority;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPriority(Priority newPriority, ChangeContext changeContext)
  {
    Priority oldPriority = priority;
    priority = newPriority;
    boolean oldPriority_set_ = priority_set_;
    priority_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PRIORITY, oldPriority, newPriority, !oldPriority_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(Priority newPriority)
  {
    if (newPriority != priority)
    {
      ChangeContext changeContext = null;
      if (priority != null)
        changeContext = inverseRemove(priority, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY, null, changeContext);
      if (newPriority != null)
        changeContext = inverseAdd(newPriority, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY, null, changeContext);
      changeContext = basicSetPriority(newPriority, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPriority_set_ = priority_set_;
      priority_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PRIORITY, newPriority, newPriority, !oldPriority_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPriority(ChangeContext changeContext)
  {
    Priority oldPriority = priority;
    priority = null;
    boolean oldPriority_set_ = priority_set_;
    priority_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PRIORITY, oldPriority, null, !oldPriority_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPriority()
  {
    if (priority != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(priority, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY, null, changeContext);
      changeContext = basicUnsetPriority(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPriority_set_ = priority_set_;
      priority_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PRIORITY, null, null, oldPriority_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPriority()
  {
    return priority_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getDeadline()
  {
    if (deadline == null)
    {
      deadline = createPropertyList(ListKind.CONTAINMENT, Deadline.class, DEADLINE, 0);
    }
    return deadline;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getDeadline1()
  {
    if (deadline1 == null)
    {
      deadline1 = createPropertyList(ListKind.CONTAINMENT, net.smartworks.server.engine.process.xpdl.xpdl2.Deadline.class, DEADLINE1, 0);
    }
    return deadline1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimulationInformation getSimulationInformation()
  {
    return simulationInformation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetSimulationInformation(SimulationInformation newSimulationInformation, ChangeContext changeContext)
  {
    SimulationInformation oldSimulationInformation = simulationInformation;
    simulationInformation = newSimulationInformation;
    boolean oldSimulationInformation_set_ = simulationInformation_set_;
    simulationInformation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SIMULATION_INFORMATION, oldSimulationInformation, newSimulationInformation, !oldSimulationInformation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSimulationInformation(SimulationInformation newSimulationInformation)
  {
    if (newSimulationInformation != simulationInformation)
    {
      ChangeContext changeContext = null;
      if (simulationInformation != null)
        changeContext = inverseRemove(simulationInformation, this, OPPOSITE_FEATURE_BASE - INTERNAL_SIMULATION_INFORMATION, null, changeContext);
      if (newSimulationInformation != null)
        changeContext = inverseAdd(newSimulationInformation, this, OPPOSITE_FEATURE_BASE - INTERNAL_SIMULATION_INFORMATION, null, changeContext);
      changeContext = basicSetSimulationInformation(newSimulationInformation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldSimulationInformation_set_ = simulationInformation_set_;
      simulationInformation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SIMULATION_INFORMATION, newSimulationInformation, newSimulationInformation, !oldSimulationInformation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetSimulationInformation(ChangeContext changeContext)
  {
    SimulationInformation oldSimulationInformation = simulationInformation;
    simulationInformation = null;
    boolean oldSimulationInformation_set_ = simulationInformation_set_;
    simulationInformation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SIMULATION_INFORMATION, oldSimulationInformation, null, !oldSimulationInformation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSimulationInformation()
  {
    if (simulationInformation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(simulationInformation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SIMULATION_INFORMATION, null, changeContext);
      changeContext = basicUnsetSimulationInformation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldSimulationInformation_set_ = simulationInformation_set_;
      simulationInformation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SIMULATION_INFORMATION, null, null, oldSimulationInformation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSimulationInformation()
  {
    return simulationInformation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Icon getIcon()
  {
    return icon;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetIcon(Icon newIcon, ChangeContext changeContext)
  {
    Icon oldIcon = icon;
    icon = newIcon;
    boolean oldIcon_set_ = icon_set_;
    icon_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ICON, oldIcon, newIcon, !oldIcon_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIcon(Icon newIcon)
  {
    if (newIcon != icon)
    {
      ChangeContext changeContext = null;
      if (icon != null)
        changeContext = inverseRemove(icon, this, OPPOSITE_FEATURE_BASE - INTERNAL_ICON, null, changeContext);
      if (newIcon != null)
        changeContext = inverseAdd(newIcon, this, OPPOSITE_FEATURE_BASE - INTERNAL_ICON, null, changeContext);
      changeContext = basicSetIcon(newIcon, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldIcon_set_ = icon_set_;
      icon_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ICON, newIcon, newIcon, !oldIcon_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetIcon(ChangeContext changeContext)
  {
    Icon oldIcon = icon;
    icon = null;
    boolean oldIcon_set_ = icon_set_;
    icon_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ICON, oldIcon, null, !oldIcon_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIcon()
  {
    if (icon != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(icon, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ICON, null, changeContext);
      changeContext = basicUnsetIcon(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldIcon_set_ = icon_set_;
      icon_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ICON, null, null, oldIcon_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIcon()
  {
    return icon_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Documentation getDocumentation()
  {
    return documentation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDocumentation(Documentation newDocumentation, ChangeContext changeContext)
  {
    Documentation oldDocumentation = documentation;
    documentation = newDocumentation;
    boolean oldDocumentation_set_ = documentation_set_;
    documentation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DOCUMENTATION, oldDocumentation, newDocumentation, !oldDocumentation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocumentation(Documentation newDocumentation)
  {
    if (newDocumentation != documentation)
    {
      ChangeContext changeContext = null;
      if (documentation != null)
        changeContext = inverseRemove(documentation, this, OPPOSITE_FEATURE_BASE - INTERNAL_DOCUMENTATION, null, changeContext);
      if (newDocumentation != null)
        changeContext = inverseAdd(newDocumentation, this, OPPOSITE_FEATURE_BASE - INTERNAL_DOCUMENTATION, null, changeContext);
      changeContext = basicSetDocumentation(newDocumentation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDocumentation_set_ = documentation_set_;
      documentation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DOCUMENTATION, newDocumentation, newDocumentation, !oldDocumentation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDocumentation(ChangeContext changeContext)
  {
    Documentation oldDocumentation = documentation;
    documentation = null;
    boolean oldDocumentation_set_ = documentation_set_;
    documentation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DOCUMENTATION, oldDocumentation, null, !oldDocumentation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDocumentation()
  {
    if (documentation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(documentation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DOCUMENTATION, null, changeContext);
      changeContext = basicUnsetDocumentation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDocumentation_set_ = documentation_set_;
      documentation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DOCUMENTATION, null, null, oldDocumentation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDocumentation()
  {
    return documentation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRestrictions getTransitionRestrictions()
  {
    return transitionRestrictions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransitionRestrictions(TransitionRestrictions newTransitionRestrictions, ChangeContext changeContext)
  {
    TransitionRestrictions oldTransitionRestrictions = transitionRestrictions;
    transitionRestrictions = newTransitionRestrictions;
    boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
    transitionRestrictions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSITION_RESTRICTIONS, oldTransitionRestrictions, newTransitionRestrictions, !oldTransitionRestrictions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitionRestrictions(TransitionRestrictions newTransitionRestrictions)
  {
    if (newTransitionRestrictions != transitionRestrictions)
    {
      ChangeContext changeContext = null;
      if (transitionRestrictions != null)
        changeContext = inverseRemove(transitionRestrictions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_RESTRICTIONS, null, changeContext);
      if (newTransitionRestrictions != null)
        changeContext = inverseAdd(newTransitionRestrictions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_RESTRICTIONS, null, changeContext);
      changeContext = basicSetTransitionRestrictions(newTransitionRestrictions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
      transitionRestrictions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSITION_RESTRICTIONS, newTransitionRestrictions, newTransitionRestrictions, !oldTransitionRestrictions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransitionRestrictions(ChangeContext changeContext)
  {
    TransitionRestrictions oldTransitionRestrictions = transitionRestrictions;
    transitionRestrictions = null;
    boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
    transitionRestrictions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSITION_RESTRICTIONS, oldTransitionRestrictions, null, !oldTransitionRestrictions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransitionRestrictions()
  {
    if (transitionRestrictions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transitionRestrictions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_RESTRICTIONS, null, changeContext);
      changeContext = basicUnsetTransitionRestrictions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
      transitionRestrictions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSITION_RESTRICTIONS, null, null, oldTransitionRestrictions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransitionRestrictions()
  {
    return transitionRestrictions_set_;
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
  public InputSets getInputSets()
  {
    return inputSets;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetInputSets(InputSets newInputSets, ChangeContext changeContext)
  {
    InputSets oldInputSets = inputSets;
    inputSets = newInputSets;
    boolean oldInputSets_set_ = inputSets_set_;
    inputSets_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_INPUT_SETS, oldInputSets, newInputSets, !oldInputSets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInputSets(InputSets newInputSets)
  {
    if (newInputSets != inputSets)
    {
      ChangeContext changeContext = null;
      if (inputSets != null)
        changeContext = inverseRemove(inputSets, this, OPPOSITE_FEATURE_BASE - INTERNAL_INPUT_SETS, null, changeContext);
      if (newInputSets != null)
        changeContext = inverseAdd(newInputSets, this, OPPOSITE_FEATURE_BASE - INTERNAL_INPUT_SETS, null, changeContext);
      changeContext = basicSetInputSets(newInputSets, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldInputSets_set_ = inputSets_set_;
      inputSets_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_INPUT_SETS, newInputSets, newInputSets, !oldInputSets_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetInputSets(ChangeContext changeContext)
  {
    InputSets oldInputSets = inputSets;
    inputSets = null;
    boolean oldInputSets_set_ = inputSets_set_;
    inputSets_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_INPUT_SETS, oldInputSets, null, !oldInputSets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetInputSets()
  {
    if (inputSets != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(inputSets, this, EOPPOSITE_FEATURE_BASE - INTERNAL_INPUT_SETS, null, changeContext);
      changeContext = basicUnsetInputSets(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldInputSets_set_ = inputSets_set_;
      inputSets_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_INPUT_SETS, null, null, oldInputSets_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetInputSets()
  {
    return inputSets_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputSets getOutputSets()
  {
    return outputSets;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetOutputSets(OutputSets newOutputSets, ChangeContext changeContext)
  {
    OutputSets oldOutputSets = outputSets;
    outputSets = newOutputSets;
    boolean oldOutputSets_set_ = outputSets_set_;
    outputSets_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_OUTPUT_SETS, oldOutputSets, newOutputSets, !oldOutputSets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutputSets(OutputSets newOutputSets)
  {
    if (newOutputSets != outputSets)
    {
      ChangeContext changeContext = null;
      if (outputSets != null)
        changeContext = inverseRemove(outputSets, this, OPPOSITE_FEATURE_BASE - INTERNAL_OUTPUT_SETS, null, changeContext);
      if (newOutputSets != null)
        changeContext = inverseAdd(newOutputSets, this, OPPOSITE_FEATURE_BASE - INTERNAL_OUTPUT_SETS, null, changeContext);
      changeContext = basicSetOutputSets(newOutputSets, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldOutputSets_set_ = outputSets_set_;
      outputSets_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_OUTPUT_SETS, newOutputSets, newOutputSets, !oldOutputSets_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetOutputSets(ChangeContext changeContext)
  {
    OutputSets oldOutputSets = outputSets;
    outputSets = null;
    boolean oldOutputSets_set_ = outputSets_set_;
    outputSets_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_OUTPUT_SETS, oldOutputSets, null, !oldOutputSets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOutputSets()
  {
    if (outputSets != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(outputSets, this, EOPPOSITE_FEATURE_BASE - INTERNAL_OUTPUT_SETS, null, changeContext);
      changeContext = basicUnsetOutputSets(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldOutputSets_set_ = outputSets_set_;
      outputSets_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_OUTPUT_SETS, null, null, oldOutputSets_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOutputSets()
  {
    return outputSets_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IORules getIORules()
  {
    return ioRules;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetIORules(IORules newIORules, ChangeContext changeContext)
  {
    IORules oldIORules = ioRules;
    ioRules = newIORules;
    boolean oldIORules_set_ = ioRules_set_;
    ioRules_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_IO_RULES, oldIORules, newIORules, !oldIORules_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIORules(IORules newIORules)
  {
    if (newIORules != ioRules)
    {
      ChangeContext changeContext = null;
      if (ioRules != null)
        changeContext = inverseRemove(ioRules, this, OPPOSITE_FEATURE_BASE - INTERNAL_IO_RULES, null, changeContext);
      if (newIORules != null)
        changeContext = inverseAdd(newIORules, this, OPPOSITE_FEATURE_BASE - INTERNAL_IO_RULES, null, changeContext);
      changeContext = basicSetIORules(newIORules, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldIORules_set_ = ioRules_set_;
      ioRules_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_IO_RULES, newIORules, newIORules, !oldIORules_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetIORules(ChangeContext changeContext)
  {
    IORules oldIORules = ioRules;
    ioRules = null;
    boolean oldIORules_set_ = ioRules_set_;
    ioRules_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_IO_RULES, oldIORules, null, !oldIORules_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIORules()
  {
    if (ioRules != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(ioRules, this, EOPPOSITE_FEATURE_BASE - INTERNAL_IO_RULES, null, changeContext);
      changeContext = basicUnsetIORules(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldIORules_set_ = ioRules_set_;
      ioRules_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_IO_RULES, null, null, oldIORules_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIORules()
  {
    return ioRules_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop getLoop()
  {
    return loop;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLoop(Loop newLoop, ChangeContext changeContext)
  {
    Loop oldLoop = loop;
    loop = newLoop;
    boolean oldLoop_set_ = loop_set_;
    loop_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LOOP, oldLoop, newLoop, !oldLoop_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoop(Loop newLoop)
  {
    if (newLoop != loop)
    {
      ChangeContext changeContext = null;
      if (loop != null)
        changeContext = inverseRemove(loop, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOOP, null, changeContext);
      if (newLoop != null)
        changeContext = inverseAdd(newLoop, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOOP, null, changeContext);
      changeContext = basicSetLoop(newLoop, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLoop_set_ = loop_set_;
      loop_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LOOP, newLoop, newLoop, !oldLoop_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLoop(ChangeContext changeContext)
  {
    Loop oldLoop = loop;
    loop = null;
    boolean oldLoop_set_ = loop_set_;
    loop_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LOOP, oldLoop, null, !oldLoop_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLoop()
  {
    if (loop != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(loop, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LOOP, null, changeContext);
      changeContext = basicUnsetLoop(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLoop_set_ = loop_set_;
      loop_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LOOP, null, null, oldLoop_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLoop()
  {
    return loop_set_;
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
  public NodeGraphicsInfos getNodeGraphicsInfos()
  {
    return nodeGraphicsInfos;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetNodeGraphicsInfos(NodeGraphicsInfos newNodeGraphicsInfos, ChangeContext changeContext)
  {
    NodeGraphicsInfos oldNodeGraphicsInfos = nodeGraphicsInfos;
    nodeGraphicsInfos = newNodeGraphicsInfos;
    boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
    nodeGraphicsInfos_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_NODE_GRAPHICS_INFOS, oldNodeGraphicsInfos, newNodeGraphicsInfos, !oldNodeGraphicsInfos_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodeGraphicsInfos(NodeGraphicsInfos newNodeGraphicsInfos)
  {
    if (newNodeGraphicsInfos != nodeGraphicsInfos)
    {
      ChangeContext changeContext = null;
      if (nodeGraphicsInfos != null)
        changeContext = inverseRemove(nodeGraphicsInfos, this, OPPOSITE_FEATURE_BASE - INTERNAL_NODE_GRAPHICS_INFOS, null, changeContext);
      if (newNodeGraphicsInfos != null)
        changeContext = inverseAdd(newNodeGraphicsInfos, this, OPPOSITE_FEATURE_BASE - INTERNAL_NODE_GRAPHICS_INFOS, null, changeContext);
      changeContext = basicSetNodeGraphicsInfos(newNodeGraphicsInfos, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
      nodeGraphicsInfos_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_NODE_GRAPHICS_INFOS, newNodeGraphicsInfos, newNodeGraphicsInfos, !oldNodeGraphicsInfos_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetNodeGraphicsInfos(ChangeContext changeContext)
  {
    NodeGraphicsInfos oldNodeGraphicsInfos = nodeGraphicsInfos;
    nodeGraphicsInfos = null;
    boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
    nodeGraphicsInfos_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_NODE_GRAPHICS_INFOS, oldNodeGraphicsInfos, null, !oldNodeGraphicsInfos_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNodeGraphicsInfos()
  {
    if (nodeGraphicsInfos != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(nodeGraphicsInfos, this, EOPPOSITE_FEATURE_BASE - INTERNAL_NODE_GRAPHICS_INFOS, null, changeContext);
      changeContext = basicUnsetNodeGraphicsInfos(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
      nodeGraphicsInfos_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_NODE_GRAPHICS_INFOS, null, null, oldNodeGraphicsInfos_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNodeGraphicsInfos()
  {
    return nodeGraphicsInfos_set_;
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
  public boolean isStartActivity()
  {
    return startActivity;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartActivity(boolean newStartActivity)
  {
    boolean oldStartActivity = startActivity;
    startActivity = newStartActivity;
    boolean oldStartActivity_set_ = startActivity_set_;
    startActivity_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_START_ACTIVITY, oldStartActivity, startActivity, !oldStartActivity_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStartActivity()
  {
    boolean oldStartActivity = startActivity;
    boolean oldStartActivity_set_ = startActivity_set_;
    startActivity = START_ACTIVITY_DEFAULT_;
    startActivity_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_START_ACTIVITY, oldStartActivity, START_ACTIVITY_DEFAULT_, oldStartActivity_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStartActivity()
  {
    return startActivity_set_;
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
  public String getStartMode1()
  {
    return startMode1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartMode1(String newStartMode1)
  {
    String oldStartMode1 = startMode1;
    startMode1 = newStartMode1;
    boolean oldStartMode1_set_ = startMode1_set_;
    startMode1_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_START_MODE1, oldStartMode1, startMode1, !oldStartMode1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStartMode1()
  {
    String oldStartMode1 = startMode1;
    boolean oldStartMode1_set_ = startMode1_set_;
    startMode1 = START_MODE1_DEFAULT_;
    startMode1_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_START_MODE1, oldStartMode1, START_MODE1_DEFAULT_, oldStartMode1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStartMode1()
  {
    return startMode1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFinishMode1()
  {
    return finishMode1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinishMode1(String newFinishMode1)
  {
    String oldFinishMode1 = finishMode1;
    finishMode1 = newFinishMode1;
    boolean oldFinishMode1_set_ = finishMode1_set_;
    finishMode1_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_FINISH_MODE1, oldFinishMode1, finishMode1, !oldFinishMode1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFinishMode1()
  {
    String oldFinishMode1 = finishMode1;
    boolean oldFinishMode1_set_ = finishMode1_set_;
    finishMode1 = FINISH_MODE1_DEFAULT_;
    finishMode1_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_FINISH_MODE1, oldFinishMode1, FINISH_MODE1_DEFAULT_, oldFinishMode1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFinishMode1()
  {
    return finishMode1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getStartQuantity()
  {
    return startQuantity;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartQuantity(BigInteger newStartQuantity)
  {
    BigInteger oldStartQuantity = startQuantity;
    startQuantity = newStartQuantity;
    boolean oldStartQuantity_set_ = startQuantity_set_;
    startQuantity_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_START_QUANTITY, oldStartQuantity, startQuantity, !oldStartQuantity_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStartQuantity()
  {
    BigInteger oldStartQuantity = startQuantity;
    boolean oldStartQuantity_set_ = startQuantity_set_;
    startQuantity = START_QUANTITY_DEFAULT_;
    startQuantity_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_START_QUANTITY, oldStartQuantity, START_QUANTITY_DEFAULT_, oldStartQuantity_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStartQuantity()
  {
    return startQuantity_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsATransaction()
  {
    return isATransaction;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsATransaction(boolean newIsATransaction)
  {
    boolean oldIsATransaction = isATransaction;
    isATransaction = newIsATransaction;
    boolean oldIsATransaction_set_ = isATransaction_set_;
    isATransaction_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_IS_ATRANSACTION, oldIsATransaction, isATransaction, !oldIsATransaction_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIsATransaction()
  {
    boolean oldIsATransaction = isATransaction;
    boolean oldIsATransaction_set_ = isATransaction_set_;
    isATransaction = IS_ATRANSACTION_DEFAULT_;
    isATransaction_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_IS_ATRANSACTION, oldIsATransaction, IS_ATRANSACTION_DEFAULT_, oldIsATransaction_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIsATransaction()
  {
    return isATransaction_set_;
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
      case DESCRIPTION:
        return basicUnsetDescription(changeContext);
      case LIMIT:
        return basicUnsetLimit(changeContext);
      case ROUTE:
        return basicUnsetRoute(changeContext);
      case IMPLEMENTATION:
        return basicUnsetImplementation(changeContext);
      case BLOCK_ACTIVITY:
        return basicUnsetBlockActivity(changeContext);
      case BLOCK_ACTIVITY1:
        return basicUnsetBlockActivity1(changeContext);
      case EVENT:
        return basicUnsetEvent(changeContext);
      case TRANSACTION:
        return basicUnsetTransaction(changeContext);
      case PERFORMER:
        return basicUnsetPerformer(changeContext);
      case PERFORMERS:
        return basicUnsetPerformers(changeContext);
      case START_MODE:
        return basicUnsetStartMode(changeContext);
      case FINISH_MODE:
        return basicUnsetFinishMode(changeContext);
      case PRIORITY:
        return basicUnsetPriority(changeContext);
      case DEADLINE:
        return removeFromList(getDeadline(), otherEnd, changeContext);
      case DEADLINE1:
        return removeFromList(getDeadline1(), otherEnd, changeContext);
      case SIMULATION_INFORMATION:
        return basicUnsetSimulationInformation(changeContext);
      case ICON:
        return basicUnsetIcon(changeContext);
      case DOCUMENTATION:
        return basicUnsetDocumentation(changeContext);
      case TRANSITION_RESTRICTIONS:
        return basicUnsetTransitionRestrictions(changeContext);
      case EXTENDED_ATTRIBUTES:
        return basicUnsetExtendedAttributes(changeContext);
      case DATA_FIELDS:
        return basicUnsetDataFields(changeContext);
      case INPUT_SETS:
        return basicUnsetInputSets(changeContext);
      case OUTPUT_SETS:
        return basicUnsetOutputSets(changeContext);
      case IO_RULES:
        return basicUnsetIORules(changeContext);
      case LOOP:
        return basicUnsetLoop(changeContext);
      case ASSIGNMENTS:
        return basicUnsetAssignments(changeContext);
      case OBJECT:
        return basicUnsetObject(changeContext);
      case NODE_GRAPHICS_INFOS:
        return basicUnsetNodeGraphicsInfos(changeContext);
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
      case DESCRIPTION:
        return getDescription();
      case LIMIT:
        return getLimit();
      case ROUTE:
        return getRoute();
      case IMPLEMENTATION:
        return getImplementation();
      case BLOCK_ACTIVITY:
        return getBlockActivity();
      case BLOCK_ACTIVITY1:
        return getBlockActivity1();
      case EVENT:
        return getEvent();
      case TRANSACTION:
        return getTransaction();
      case PERFORMER:
        return getPerformer();
      case PERFORMERS:
        return getPerformers();
      case START_MODE:
        return getStartMode();
      case FINISH_MODE:
        return getFinishMode();
      case PRIORITY:
        return getPriority();
      case DEADLINE:
        return getDeadline();
      case DEADLINE1:
        return getDeadline1();
      case SIMULATION_INFORMATION:
        return getSimulationInformation();
      case ICON:
        return getIcon();
      case DOCUMENTATION:
        return getDocumentation();
      case TRANSITION_RESTRICTIONS:
        return getTransitionRestrictions();
      case EXTENDED_ATTRIBUTES:
        return getExtendedAttributes();
      case DATA_FIELDS:
        return getDataFields();
      case INPUT_SETS:
        return getInputSets();
      case OUTPUT_SETS:
        return getOutputSets();
      case IO_RULES:
        return getIORules();
      case LOOP:
        return getLoop();
      case ASSIGNMENTS:
        return getAssignments();
      case OBJECT:
        return getObject();
      case NODE_GRAPHICS_INFOS:
        return getNodeGraphicsInfos();
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
      case START_ACTIVITY:
        return isStartActivity() ? Boolean.TRUE : Boolean.FALSE;
      case STATUS:
        return getStatus();
      case START_MODE1:
        return getStartMode1();
      case FINISH_MODE1:
        return getFinishMode1();
      case START_QUANTITY:
        return getStartQuantity();
      case IS_ATRANSACTION:
        return isIsATransaction() ? Boolean.TRUE : Boolean.FALSE;
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
      case DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case LIMIT:
        setLimit((Limit)newValue);
        return;
      case ROUTE:
        setRoute((Route)newValue);
        return;
      case IMPLEMENTATION:
        setImplementation((Implementation7)newValue);
        return;
      case BLOCK_ACTIVITY:
        setBlockActivity((BlockActivity)newValue);
        return;
      case BLOCK_ACTIVITY1:
        setBlockActivity1((net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity)newValue);
        return;
      case EVENT:
        setEvent((Event)newValue);
        return;
      case TRANSACTION:
        setTransaction((Transaction)newValue);
        return;
      case PERFORMER:
        setPerformer((Performer)newValue);
        return;
      case PERFORMERS:
        setPerformers((Performers)newValue);
        return;
      case START_MODE:
        setStartMode((StartMode)newValue);
        return;
      case FINISH_MODE:
        setFinishMode((FinishMode)newValue);
        return;
      case PRIORITY:
        setPriority((Priority)newValue);
        return;
      case DEADLINE:
        getDeadline().clear();
        getDeadline().addAll((Collection)newValue);
        return;
      case DEADLINE1:
        getDeadline1().clear();
        getDeadline1().addAll((Collection)newValue);
        return;
      case SIMULATION_INFORMATION:
        setSimulationInformation((SimulationInformation)newValue);
        return;
      case ICON:
        setIcon((Icon)newValue);
        return;
      case DOCUMENTATION:
        setDocumentation((Documentation)newValue);
        return;
      case TRANSITION_RESTRICTIONS:
        setTransitionRestrictions((TransitionRestrictions)newValue);
        return;
      case EXTENDED_ATTRIBUTES:
        setExtendedAttributes((ExtendedAttributes)newValue);
        return;
      case DATA_FIELDS:
        setDataFields((DataFields)newValue);
        return;
      case INPUT_SETS:
        setInputSets((InputSets)newValue);
        return;
      case OUTPUT_SETS:
        setOutputSets((OutputSets)newValue);
        return;
      case IO_RULES:
        setIORules((IORules)newValue);
        return;
      case LOOP:
        setLoop((Loop)newValue);
        return;
      case ASSIGNMENTS:
        setAssignments((Assignments)newValue);
        return;
      case OBJECT:
        setObject((net.smartworks.server.engine.process.xpdl.xpdl2.Object)newValue);
        return;
      case NODE_GRAPHICS_INFOS:
        setNodeGraphicsInfos((NodeGraphicsInfos)newValue);
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
      case START_ACTIVITY:
        setStartActivity(((Boolean)newValue).booleanValue());
        return;
      case STATUS:
        setStatus((String)newValue);
        return;
      case START_MODE1:
        setStartMode1((String)newValue);
        return;
      case FINISH_MODE1:
        setFinishMode1((String)newValue);
        return;
      case START_QUANTITY:
        setStartQuantity((BigInteger)newValue);
        return;
      case IS_ATRANSACTION:
        setIsATransaction(((Boolean)newValue).booleanValue());
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
      case DESCRIPTION:
        unsetDescription();
        return;
      case LIMIT:
        unsetLimit();
        return;
      case ROUTE:
        unsetRoute();
        return;
      case IMPLEMENTATION:
        unsetImplementation();
        return;
      case BLOCK_ACTIVITY:
        unsetBlockActivity();
        return;
      case BLOCK_ACTIVITY1:
        unsetBlockActivity1();
        return;
      case EVENT:
        unsetEvent();
        return;
      case TRANSACTION:
        unsetTransaction();
        return;
      case PERFORMER:
        unsetPerformer();
        return;
      case PERFORMERS:
        unsetPerformers();
        return;
      case START_MODE:
        unsetStartMode();
        return;
      case FINISH_MODE:
        unsetFinishMode();
        return;
      case PRIORITY:
        unsetPriority();
        return;
      case DEADLINE:
        getDeadline().clear();
        return;
      case DEADLINE1:
        getDeadline1().clear();
        return;
      case SIMULATION_INFORMATION:
        unsetSimulationInformation();
        return;
      case ICON:
        unsetIcon();
        return;
      case DOCUMENTATION:
        unsetDocumentation();
        return;
      case TRANSITION_RESTRICTIONS:
        unsetTransitionRestrictions();
        return;
      case EXTENDED_ATTRIBUTES:
        unsetExtendedAttributes();
        return;
      case DATA_FIELDS:
        unsetDataFields();
        return;
      case INPUT_SETS:
        unsetInputSets();
        return;
      case OUTPUT_SETS:
        unsetOutputSets();
        return;
      case IO_RULES:
        unsetIORules();
        return;
      case LOOP:
        unsetLoop();
        return;
      case ASSIGNMENTS:
        unsetAssignments();
        return;
      case OBJECT:
        unsetObject();
        return;
      case NODE_GRAPHICS_INFOS:
        unsetNodeGraphicsInfos();
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
      case START_ACTIVITY:
        unsetStartActivity();
        return;
      case STATUS:
        unsetStatus();
        return;
      case START_MODE1:
        unsetStartMode1();
        return;
      case FINISH_MODE1:
        unsetFinishMode1();
        return;
      case START_QUANTITY:
        unsetStartQuantity();
        return;
      case IS_ATRANSACTION:
        unsetIsATransaction();
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
      case DESCRIPTION:
        return isSetDescription();
      case LIMIT:
        return isSetLimit();
      case ROUTE:
        return isSetRoute();
      case IMPLEMENTATION:
        return isSetImplementation();
      case BLOCK_ACTIVITY:
        return isSetBlockActivity();
      case BLOCK_ACTIVITY1:
        return isSetBlockActivity1();
      case EVENT:
        return isSetEvent();
      case TRANSACTION:
        return isSetTransaction();
      case PERFORMER:
        return isSetPerformer();
      case PERFORMERS:
        return isSetPerformers();
      case START_MODE:
        return isSetStartMode();
      case FINISH_MODE:
        return isSetFinishMode();
      case PRIORITY:
        return isSetPriority();
      case DEADLINE:
        return deadline != null && !deadline.isEmpty();
      case DEADLINE1:
        return deadline1 != null && !deadline1.isEmpty();
      case SIMULATION_INFORMATION:
        return isSetSimulationInformation();
      case ICON:
        return isSetIcon();
      case DOCUMENTATION:
        return isSetDocumentation();
      case TRANSITION_RESTRICTIONS:
        return isSetTransitionRestrictions();
      case EXTENDED_ATTRIBUTES:
        return isSetExtendedAttributes();
      case DATA_FIELDS:
        return isSetDataFields();
      case INPUT_SETS:
        return isSetInputSets();
      case OUTPUT_SETS:
        return isSetOutputSets();
      case IO_RULES:
        return isSetIORules();
      case LOOP:
        return isSetLoop();
      case ASSIGNMENTS:
        return isSetAssignments();
      case OBJECT:
        return isSetObject();
      case NODE_GRAPHICS_INFOS:
        return isSetNodeGraphicsInfos();
      case EXTENSIONS:
        return isSetExtensions();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case START_ACTIVITY:
        return isSetStartActivity();
      case STATUS:
        return isSetStatus();
      case START_MODE1:
        return isSetStartMode1();
      case FINISH_MODE1:
        return isSetFinishMode1();
      case START_QUANTITY:
        return isSetStartQuantity();
      case IS_ATRANSACTION:
        return isSetIsATransaction();
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
    result.append(", StartActivity: ");
    if (startActivity_set_) result.append(startActivity); else result.append("<unset>");
    result.append(", Status: ");
    if (status_set_) result.append(status); else result.append("<unset>");
    result.append(", StartMode1: ");
    if (startMode1_set_) result.append(startMode1); else result.append("<unset>");
    result.append(", FinishMode1: ");
    if (finishMode1_set_) result.append(finishMode1); else result.append("<unset>");
    result.append(", StartQuantity: ");
    if (startQuantity_set_) result.append(startQuantity); else result.append("<unset>");
    result.append(", IsATransaction: ");
    if (isATransaction_set_) result.append(isATransaction); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //ActivityImpl
