/**
 * <copyright>
 * </copyright>
 *
 * $Id: Activity.java,v 1.1 2009/12/22 06:18:27 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity;
import net.smartworks.server.engine.process.xpdl.xpdl1.FinishMode;
import net.smartworks.server.engine.process.xpdl.xpdl1.StartMode;

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;

import java.io.Serializable;

import java.math.BigInteger;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLimit <em>Limit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getRoute <em>Route</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity <em>Block Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity1 <em>Block Activity1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getEvent <em>Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransaction <em>Transaction</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformer <em>Performer</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformers <em>Performers</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode <em>Start Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode <em>Finish Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPriority <em>Priority</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDeadline1 <em>Deadline1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getSimulationInformation <em>Simulation Information</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIcon <em>Icon</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getInputSets <em>Input Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getOutputSets <em>Output Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIORules <em>IO Rules</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLoop <em>Loop</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getNodeGraphicsInfos <em>Node Graphics Infos</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isStartActivity <em>Start Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStatus <em>Status</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode1 <em>Start Mode1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode1 <em>Finish Mode1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartQuantity <em>Start Quantity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isIsATransaction <em>Is ATransaction</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Activity extends Serializable
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #setDescription(Description)
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDescription()
   * @see #getDescription()
   * @see #setDescription(Description)
   * @generated
   */
  void unsetDescription();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDescription <em>Description</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Description</em>' containment reference is set.
   * @see #unsetDescription()
   * @see #getDescription()
   * @see #setDescription(Description)
   * @generated
   */
  boolean isSetDescription();

  /**
   * Returns the value of the '<em><b>Limit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Limit</em>' containment reference.
   * @see #isSetLimit()
   * @see #unsetLimit()
   * @see #setLimit(Limit)
   * @generated
   */
  Limit getLimit();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLimit <em>Limit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Limit</em>' containment reference.
   * @see #isSetLimit()
   * @see #unsetLimit()
   * @see #getLimit()
   * @generated
   */
  void setLimit(Limit value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLimit <em>Limit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLimit()
   * @see #getLimit()
   * @see #setLimit(Limit)
   * @generated
   */
  void unsetLimit();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLimit <em>Limit</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Limit</em>' containment reference is set.
   * @see #unsetLimit()
   * @see #getLimit()
   * @see #setLimit(Limit)
   * @generated
   */
  boolean isSetLimit();

  /**
   * Returns the value of the '<em><b>Route</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Route</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Route</em>' containment reference.
   * @see #isSetRoute()
   * @see #unsetRoute()
   * @see #setRoute(Route)
   * @generated
   */
  Route getRoute();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getRoute <em>Route</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Route</em>' containment reference.
   * @see #isSetRoute()
   * @see #unsetRoute()
   * @see #getRoute()
   * @generated
   */
  void setRoute(Route value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getRoute <em>Route</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRoute()
   * @see #getRoute()
   * @see #setRoute(Route)
   * @generated
   */
  void unsetRoute();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getRoute <em>Route</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Route</em>' containment reference is set.
   * @see #unsetRoute()
   * @see #getRoute()
   * @see #setRoute(Route)
   * @generated
   */
  boolean isSetRoute();

  /**
   * Returns the value of the '<em><b>Implementation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implementation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implementation</em>' containment reference.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #setImplementation(Implementation7)
   * @generated
   */
  Implementation7 getImplementation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getImplementation <em>Implementation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation</em>' containment reference.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @generated
   */
  void setImplementation(Implementation7 value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getImplementation <em>Implementation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(Implementation7)
   * @generated
   */
  void unsetImplementation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getImplementation <em>Implementation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Implementation</em>' containment reference is set.
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(Implementation7)
   * @generated
   */
  boolean isSetImplementation();

  /**
   * Returns the value of the '<em><b>Block Activity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block Activity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block Activity</em>' containment reference.
   * @see #isSetBlockActivity()
   * @see #unsetBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  BlockActivity getBlockActivity();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block Activity</em>' containment reference.
   * @see #isSetBlockActivity()
   * @see #unsetBlockActivity()
   * @see #getBlockActivity()
   * @generated
   */
  void setBlockActivity(BlockActivity value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBlockActivity()
   * @see #getBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  void unsetBlockActivity();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity <em>Block Activity</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Block Activity</em>' containment reference is set.
   * @see #unsetBlockActivity()
   * @see #getBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  boolean isSetBlockActivity();

  /**
   * Returns the value of the '<em><b>Block Activity1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block Activity1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block Activity1</em>' containment reference.
   * @see #isSetBlockActivity1()
   * @see #unsetBlockActivity1()
   * @see #setBlockActivity1(net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity getBlockActivity1();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity1 <em>Block Activity1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block Activity1</em>' containment reference.
   * @see #isSetBlockActivity1()
   * @see #unsetBlockActivity1()
   * @see #getBlockActivity1()
   * @generated
   */
  void setBlockActivity1(net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity1 <em>Block Activity1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBlockActivity1()
   * @see #getBlockActivity1()
   * @see #setBlockActivity1(net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity)
   * @generated
   */
  void unsetBlockActivity1();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getBlockActivity1 <em>Block Activity1</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Block Activity1</em>' containment reference is set.
   * @see #unsetBlockActivity1()
   * @see #getBlockActivity1()
   * @see #setBlockActivity1(net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity)
   * @generated
   */
  boolean isSetBlockActivity1();

  /**
   * Returns the value of the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Event</em>' containment reference.
   * @see #isSetEvent()
   * @see #unsetEvent()
   * @see #setEvent(Event)
   * @generated
   */
  Event getEvent();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getEvent <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' containment reference.
   * @see #isSetEvent()
   * @see #unsetEvent()
   * @see #getEvent()
   * @generated
   */
  void setEvent(Event value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getEvent <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEvent()
   * @see #getEvent()
   * @see #setEvent(Event)
   * @generated
   */
  void unsetEvent();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getEvent <em>Event</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Event</em>' containment reference is set.
   * @see #unsetEvent()
   * @see #getEvent()
   * @see #setEvent(Event)
   * @generated
   */
  boolean isSetEvent();

  /**
   * Returns the value of the '<em><b>Transaction</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: If SubProcess is a transaction then this is required.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Transaction</em>' containment reference.
   * @see #isSetTransaction()
   * @see #unsetTransaction()
   * @see #setTransaction(Transaction)
   * @generated
   */
  Transaction getTransaction();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransaction <em>Transaction</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transaction</em>' containment reference.
   * @see #isSetTransaction()
   * @see #unsetTransaction()
   * @see #getTransaction()
   * @generated
   */
  void setTransaction(Transaction value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransaction <em>Transaction</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransaction()
   * @see #getTransaction()
   * @see #setTransaction(Transaction)
   * @generated
   */
  void unsetTransaction();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransaction <em>Transaction</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transaction</em>' containment reference is set.
   * @see #unsetTransaction()
   * @see #getTransaction()
   * @see #setTransaction(Transaction)
   * @generated
   */
  boolean isSetTransaction();

  /**
   * Returns the value of the '<em><b>Performer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A String or Expression designating the Performer
   * <!-- end-model-doc -->
   * @return the value of the '<em>Performer</em>' containment reference.
   * @see #isSetPerformer()
   * @see #unsetPerformer()
   * @see #setPerformer(Performer)
   * @generated
   */
  Performer getPerformer();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformer <em>Performer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Performer</em>' containment reference.
   * @see #isSetPerformer()
   * @see #unsetPerformer()
   * @see #getPerformer()
   * @generated
   */
  void setPerformer(Performer value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformer <em>Performer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPerformer()
   * @see #getPerformer()
   * @see #setPerformer(Performer)
   * @generated
   */
  void unsetPerformer();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformer <em>Performer</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Performer</em>' containment reference is set.
   * @see #unsetPerformer()
   * @see #getPerformer()
   * @see #setPerformer(Performer)
   * @generated
   */
  boolean isSetPerformer();

  /**
   * Returns the value of the '<em><b>Performers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN and XPDL
   * <!-- end-model-doc -->
   * @return the value of the '<em>Performers</em>' containment reference.
   * @see #isSetPerformers()
   * @see #unsetPerformers()
   * @see #setPerformers(Performers)
   * @generated
   */
  Performers getPerformers();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformers <em>Performers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Performers</em>' containment reference.
   * @see #isSetPerformers()
   * @see #unsetPerformers()
   * @see #getPerformers()
   * @generated
   */
  void setPerformers(Performers value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformers <em>Performers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPerformers()
   * @see #getPerformers()
   * @see #setPerformers(Performers)
   * @generated
   */
  void unsetPerformers();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPerformers <em>Performers</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Performers</em>' containment reference is set.
   * @see #unsetPerformers()
   * @see #getPerformers()
   * @see #setPerformers(Performers)
   * @generated
   */
  boolean isSetPerformers();

  /**
   * Returns the value of the '<em><b>Start Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Mode</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Mode</em>' containment reference.
   * @see #isSetStartMode()
   * @see #unsetStartMode()
   * @see #setStartMode(StartMode)
   * @generated
   */
  StartMode getStartMode();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode <em>Start Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Mode</em>' containment reference.
   * @see #isSetStartMode()
   * @see #unsetStartMode()
   * @see #getStartMode()
   * @generated
   */
  void setStartMode(StartMode value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode <em>Start Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartMode()
   * @see #getStartMode()
   * @see #setStartMode(StartMode)
   * @generated
   */
  void unsetStartMode();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode <em>Start Mode</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Mode</em>' containment reference is set.
   * @see #unsetStartMode()
   * @see #getStartMode()
   * @see #setStartMode(StartMode)
   * @generated
   */
  boolean isSetStartMode();

  /**
   * Returns the value of the '<em><b>Finish Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Finish Mode</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Finish Mode</em>' containment reference.
   * @see #isSetFinishMode()
   * @see #unsetFinishMode()
   * @see #setFinishMode(FinishMode)
   * @generated
   */
  FinishMode getFinishMode();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode <em>Finish Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Finish Mode</em>' containment reference.
   * @see #isSetFinishMode()
   * @see #unsetFinishMode()
   * @see #getFinishMode()
   * @generated
   */
  void setFinishMode(FinishMode value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode <em>Finish Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFinishMode()
   * @see #getFinishMode()
   * @see #setFinishMode(FinishMode)
   * @generated
   */
  void unsetFinishMode();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode <em>Finish Mode</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Finish Mode</em>' containment reference is set.
   * @see #unsetFinishMode()
   * @see #getFinishMode()
   * @see #setFinishMode(FinishMode)
   * @generated
   */
  boolean isSetFinishMode();

  /**
   * Returns the value of the '<em><b>Priority</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' containment reference.
   * @see #isSetPriority()
   * @see #unsetPriority()
   * @see #setPriority(Priority)
   * @generated
   */
  Priority getPriority();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPriority <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' containment reference.
   * @see #isSetPriority()
   * @see #unsetPriority()
   * @see #getPriority()
   * @generated
   */
  void setPriority(Priority value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPriority <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPriority()
   * @see #getPriority()
   * @see #setPriority(Priority)
   * @generated
   */
  void unsetPriority();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getPriority <em>Priority</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Priority</em>' containment reference is set.
   * @see #unsetPriority()
   * @see #getPriority()
   * @see #setPriority(Priority)
   * @generated
   */
  boolean isSetPriority();

  /**
   * Returns the value of the '<em><b>Deadline</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deadline</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deadline</em>' containment reference list.
   * @generated
   */
  List getDeadline();

  /**
   * Returns the value of the '<em><b>Deadline1</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deadline1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deadline1</em>' containment reference list.
   * @generated
   */
  List getDeadline1();

  /**
   * Returns the value of the '<em><b>Simulation Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simulation Information</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simulation Information</em>' containment reference.
   * @see #isSetSimulationInformation()
   * @see #unsetSimulationInformation()
   * @see #setSimulationInformation(SimulationInformation)
   * @generated
   */
  SimulationInformation getSimulationInformation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getSimulationInformation <em>Simulation Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simulation Information</em>' containment reference.
   * @see #isSetSimulationInformation()
   * @see #unsetSimulationInformation()
   * @see #getSimulationInformation()
   * @generated
   */
  void setSimulationInformation(SimulationInformation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getSimulationInformation <em>Simulation Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSimulationInformation()
   * @see #getSimulationInformation()
   * @see #setSimulationInformation(SimulationInformation)
   * @generated
   */
  void unsetSimulationInformation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getSimulationInformation <em>Simulation Information</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Simulation Information</em>' containment reference is set.
   * @see #unsetSimulationInformation()
   * @see #getSimulationInformation()
   * @see #setSimulationInformation(SimulationInformation)
   * @generated
   */
  boolean isSetSimulationInformation();

  /**
   * Returns the value of the '<em><b>Icon</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Icon</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Icon</em>' containment reference.
   * @see #isSetIcon()
   * @see #unsetIcon()
   * @see #setIcon(Icon)
   * @generated
   */
  Icon getIcon();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIcon <em>Icon</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Icon</em>' containment reference.
   * @see #isSetIcon()
   * @see #unsetIcon()
   * @see #getIcon()
   * @generated
   */
  void setIcon(Icon value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIcon <em>Icon</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIcon()
   * @see #getIcon()
   * @see #setIcon(Icon)
   * @generated
   */
  void unsetIcon();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIcon <em>Icon</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Icon</em>' containment reference is set.
   * @see #unsetIcon()
   * @see #getIcon()
   * @see #setIcon(Icon)
   * @generated
   */
  boolean isSetIcon();

  /**
   * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' containment reference.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  Documentation getDocumentation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Documentation</em>' containment reference.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @generated
   */
  void setDocumentation(Documentation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  void unsetDocumentation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDocumentation <em>Documentation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Documentation</em>' containment reference is set.
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  boolean isSetDocumentation();

  /**
   * Returns the value of the '<em><b>Transition Restrictions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Restrictions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Restrictions</em>' containment reference.
   * @see #isSetTransitionRestrictions()
   * @see #unsetTransitionRestrictions()
   * @see #setTransitionRestrictions(TransitionRestrictions)
   * @generated
   */
  TransitionRestrictions getTransitionRestrictions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transition Restrictions</em>' containment reference.
   * @see #isSetTransitionRestrictions()
   * @see #unsetTransitionRestrictions()
   * @see #getTransitionRestrictions()
   * @generated
   */
  void setTransitionRestrictions(TransitionRestrictions value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitionRestrictions()
   * @see #getTransitionRestrictions()
   * @see #setTransitionRestrictions(TransitionRestrictions)
   * @generated
   */
  void unsetTransitionRestrictions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transition Restrictions</em>' containment reference is set.
   * @see #unsetTransitionRestrictions()
   * @see #getTransitionRestrictions()
   * @see #setTransitionRestrictions(TransitionRestrictions)
   * @generated
   */
  boolean isSetTransitionRestrictions();

  /**
   * Returns the value of the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extended Attributes</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extended Attributes</em>' containment reference.
   * @see #isSetExtendedAttributes()
   * @see #unsetExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  ExtendedAttributes getExtendedAttributes();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extended Attributes</em>' containment reference.
   * @see #isSetExtendedAttributes()
   * @see #unsetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @generated
   */
  void setExtendedAttributes(ExtendedAttributes value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  void unsetExtendedAttributes();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtendedAttributes <em>Extended Attributes</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Extended Attributes</em>' containment reference is set.
   * @see #unsetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  boolean isSetExtendedAttributes();

  /**
   * Returns the value of the '<em><b>Data Fields</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Fields</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Fields</em>' containment reference.
   * @see #isSetDataFields()
   * @see #unsetDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  DataFields getDataFields();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDataFields <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Fields</em>' containment reference.
   * @see #isSetDataFields()
   * @see #unsetDataFields()
   * @see #getDataFields()
   * @generated
   */
  void setDataFields(DataFields value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDataFields <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataFields()
   * @see #getDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  void unsetDataFields();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getDataFields <em>Data Fields</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Data Fields</em>' containment reference is set.
   * @see #unsetDataFields()
   * @see #getDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  boolean isSetDataFields();

  /**
   * Returns the value of the '<em><b>Input Sets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Input Sets</em>' containment reference.
   * @see #isSetInputSets()
   * @see #unsetInputSets()
   * @see #setInputSets(InputSets)
   * @generated
   */
  InputSets getInputSets();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getInputSets <em>Input Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input Sets</em>' containment reference.
   * @see #isSetInputSets()
   * @see #unsetInputSets()
   * @see #getInputSets()
   * @generated
   */
  void setInputSets(InputSets value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getInputSets <em>Input Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetInputSets()
   * @see #getInputSets()
   * @see #setInputSets(InputSets)
   * @generated
   */
  void unsetInputSets();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getInputSets <em>Input Sets</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Input Sets</em>' containment reference is set.
   * @see #unsetInputSets()
   * @see #getInputSets()
   * @see #setInputSets(InputSets)
   * @generated
   */
  boolean isSetInputSets();

  /**
   * Returns the value of the '<em><b>Output Sets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Output Sets</em>' containment reference.
   * @see #isSetOutputSets()
   * @see #unsetOutputSets()
   * @see #setOutputSets(OutputSets)
   * @generated
   */
  OutputSets getOutputSets();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getOutputSets <em>Output Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output Sets</em>' containment reference.
   * @see #isSetOutputSets()
   * @see #unsetOutputSets()
   * @see #getOutputSets()
   * @generated
   */
  void setOutputSets(OutputSets value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getOutputSets <em>Output Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOutputSets()
   * @see #getOutputSets()
   * @see #setOutputSets(OutputSets)
   * @generated
   */
  void unsetOutputSets();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getOutputSets <em>Output Sets</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Output Sets</em>' containment reference is set.
   * @see #unsetOutputSets()
   * @see #getOutputSets()
   * @see #setOutputSets(OutputSets)
   * @generated
   */
  boolean isSetOutputSets();

  /**
   * Returns the value of the '<em><b>IO Rules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>IO Rules</em>' containment reference.
   * @see #isSetIORules()
   * @see #unsetIORules()
   * @see #setIORules(IORules)
   * @generated
   */
  IORules getIORules();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIORules <em>IO Rules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>IO Rules</em>' containment reference.
   * @see #isSetIORules()
   * @see #unsetIORules()
   * @see #getIORules()
   * @generated
   */
  void setIORules(IORules value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIORules <em>IO Rules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIORules()
   * @see #getIORules()
   * @see #setIORules(IORules)
   * @generated
   */
  void unsetIORules();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getIORules <em>IO Rules</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>IO Rules</em>' containment reference is set.
   * @see #unsetIORules()
   * @see #getIORules()
   * @see #setIORules(IORules)
   * @generated
   */
  boolean isSetIORules();

  /**
   * Returns the value of the '<em><b>Loop</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN (and possibly XPDL)
   * <!-- end-model-doc -->
   * @return the value of the '<em>Loop</em>' containment reference.
   * @see #isSetLoop()
   * @see #unsetLoop()
   * @see #setLoop(Loop)
   * @generated
   */
  Loop getLoop();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLoop <em>Loop</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop</em>' containment reference.
   * @see #isSetLoop()
   * @see #unsetLoop()
   * @see #getLoop()
   * @generated
   */
  void setLoop(Loop value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLoop <em>Loop</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoop()
   * @see #getLoop()
   * @see #setLoop(Loop)
   * @generated
   */
  void unsetLoop();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getLoop <em>Loop</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Loop</em>' containment reference is set.
   * @see #unsetLoop()
   * @see #getLoop()
   * @see #setLoop(Loop)
   * @generated
   */
  boolean isSetLoop();

  /**
   * Returns the value of the '<em><b>Assignments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN and XPDL
   * <!-- end-model-doc -->
   * @return the value of the '<em>Assignments</em>' containment reference.
   * @see #isSetAssignments()
   * @see #unsetAssignments()
   * @see #setAssignments(Assignments)
   * @generated
   */
  Assignments getAssignments();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getAssignments <em>Assignments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignments</em>' containment reference.
   * @see #isSetAssignments()
   * @see #unsetAssignments()
   * @see #getAssignments()
   * @generated
   */
  void setAssignments(Assignments value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getAssignments <em>Assignments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAssignments()
   * @see #getAssignments()
   * @see #setAssignments(Assignments)
   * @generated
   */
  void unsetAssignments();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getAssignments <em>Assignments</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Assignments</em>' containment reference is set.
   * @see #unsetAssignments()
   * @see #getAssignments()
   * @see #setAssignments(Assignments)
   * @generated
   */
  boolean isSetAssignments();

  /**
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: This is used to identify the Activity in an EndEvent Compensation???Also used to associate categories and ocumentation with a variety of elements
   * <!-- end-model-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.Object getObject();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #getObject()
   * @generated
   */
  void setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  void unsetObject();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getObject <em>Object</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Object</em>' containment reference is set.
   * @see #unsetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  boolean isSetObject();

  /**
   * Returns the value of the '<em><b>Node Graphics Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Graphics Infos</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Graphics Infos</em>' containment reference.
   * @see #isSetNodeGraphicsInfos()
   * @see #unsetNodeGraphicsInfos()
   * @see #setNodeGraphicsInfos(NodeGraphicsInfos)
   * @generated
   */
  NodeGraphicsInfos getNodeGraphicsInfos();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getNodeGraphicsInfos <em>Node Graphics Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Graphics Infos</em>' containment reference.
   * @see #isSetNodeGraphicsInfos()
   * @see #unsetNodeGraphicsInfos()
   * @see #getNodeGraphicsInfos()
   * @generated
   */
  void setNodeGraphicsInfos(NodeGraphicsInfos value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getNodeGraphicsInfos <em>Node Graphics Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNodeGraphicsInfos()
   * @see #getNodeGraphicsInfos()
   * @see #setNodeGraphicsInfos(NodeGraphicsInfos)
   * @generated
   */
  void unsetNodeGraphicsInfos();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getNodeGraphicsInfos <em>Node Graphics Infos</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Node Graphics Infos</em>' containment reference is set.
   * @see #unsetNodeGraphicsInfos()
   * @see #getNodeGraphicsInfos()
   * @see #setNodeGraphicsInfos(NodeGraphicsInfos)
   * @generated
   */
  boolean isSetNodeGraphicsInfos();

  /**
   * Returns the value of the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extensions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extensions</em>' containment reference.
   * @see #isSetExtensions()
   * @see #unsetExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  DataObject getExtensions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtensions <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extensions</em>' containment reference.
   * @see #isSetExtensions()
   * @see #unsetExtensions()
   * @see #getExtensions()
   * @generated
   */
  void setExtensions(DataObject value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtensions <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtensions()
   * @see #getExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  void unsetExtensions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getExtensions <em>Extensions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Extensions</em>' containment reference is set.
   * @see #unsetExtensions()
   * @see #getExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  boolean isSetExtensions();

  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @generated
   */
  Sequence getAny();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #setId(String)
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getId <em>Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Id</em>' attribute is set.
   * @see #unsetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  boolean isSetId();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #setName(String)
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getName <em>Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Name</em>' attribute is set.
   * @see #unsetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  boolean isSetName();

  /**
   * Returns the value of the '<em><b>Start Activity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Designates the first activity to be executed when the process is instantiated. Used when there is no other way to determine this Conflicts with BPMN StartEvent and no process definition should use both.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Start Activity</em>' attribute.
   * @see #isSetStartActivity()
   * @see #unsetStartActivity()
   * @see #setStartActivity(boolean)
   * @generated
   */
  boolean isStartActivity();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isStartActivity <em>Start Activity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Activity</em>' attribute.
   * @see #isSetStartActivity()
   * @see #unsetStartActivity()
   * @see #isStartActivity()
   * @generated
   */
  void setStartActivity(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isStartActivity <em>Start Activity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartActivity()
   * @see #isStartActivity()
   * @see #setStartActivity(boolean)
   * @generated
   */
  void unsetStartActivity();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isStartActivity <em>Start Activity</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Activity</em>' attribute is set.
   * @see #unsetStartActivity()
   * @see #isStartActivity()
   * @see #setStartActivity(boolean)
   * @generated
   */
  boolean isSetStartActivity();

  /**
   * Returns the value of the '<em><b>Status</b></em>' attribute.
   * The default value is <code>"None"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  BPMN: Status values are assigned during execution. Status can be treated as a property and used in expressions local to an Activity. It is unclear that status belongs in the XPDL document.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Status</em>' attribute.
   * @see #isSetStatus()
   * @see #unsetStatus()
   * @see #setStatus(String)
   * @generated
   */
  String getStatus();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' attribute.
   * @see #isSetStatus()
   * @see #unsetStatus()
   * @see #getStatus()
   * @generated
   */
  void setStatus(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStatus()
   * @see #getStatus()
   * @see #setStatus(String)
   * @generated
   */
  void unsetStatus();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStatus <em>Status</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Status</em>' attribute is set.
   * @see #unsetStatus()
   * @see #getStatus()
   * @see #setStatus(String)
   * @generated
   */
  boolean isSetStatus();

  /**
   * Returns the value of the '<em><b>Start Mode1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Mode1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Mode1</em>' attribute.
   * @see #isSetStartMode1()
   * @see #unsetStartMode1()
   * @see #setStartMode1(String)
   * @generated
   */
  String getStartMode1();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode1 <em>Start Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Mode1</em>' attribute.
   * @see #isSetStartMode1()
   * @see #unsetStartMode1()
   * @see #getStartMode1()
   * @generated
   */
  void setStartMode1(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode1 <em>Start Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartMode1()
   * @see #getStartMode1()
   * @see #setStartMode1(String)
   * @generated
   */
  void unsetStartMode1();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartMode1 <em>Start Mode1</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Mode1</em>' attribute is set.
   * @see #unsetStartMode1()
   * @see #getStartMode1()
   * @see #setStartMode1(String)
   * @generated
   */
  boolean isSetStartMode1();

  /**
   * Returns the value of the '<em><b>Finish Mode1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Finish Mode1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Finish Mode1</em>' attribute.
   * @see #isSetFinishMode1()
   * @see #unsetFinishMode1()
   * @see #setFinishMode1(String)
   * @generated
   */
  String getFinishMode1();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode1 <em>Finish Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Finish Mode1</em>' attribute.
   * @see #isSetFinishMode1()
   * @see #unsetFinishMode1()
   * @see #getFinishMode1()
   * @generated
   */
  void setFinishMode1(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode1 <em>Finish Mode1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFinishMode1()
   * @see #getFinishMode1()
   * @see #setFinishMode1(String)
   * @generated
   */
  void unsetFinishMode1();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getFinishMode1 <em>Finish Mode1</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Finish Mode1</em>' attribute is set.
   * @see #unsetFinishMode1()
   * @see #getFinishMode1()
   * @see #setFinishMode1(String)
   * @generated
   */
  boolean isSetFinishMode1();

  /**
   * Returns the value of the '<em><b>Start Quantity</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Quantity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Quantity</em>' attribute.
   * @see #isSetStartQuantity()
   * @see #unsetStartQuantity()
   * @see #setStartQuantity(BigInteger)
   * @generated
   */
  BigInteger getStartQuantity();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartQuantity <em>Start Quantity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Quantity</em>' attribute.
   * @see #isSetStartQuantity()
   * @see #unsetStartQuantity()
   * @see #getStartQuantity()
   * @generated
   */
  void setStartQuantity(BigInteger value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartQuantity <em>Start Quantity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartQuantity()
   * @see #getStartQuantity()
   * @see #setStartQuantity(BigInteger)
   * @generated
   */
  void unsetStartQuantity();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#getStartQuantity <em>Start Quantity</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Quantity</em>' attribute is set.
   * @see #unsetStartQuantity()
   * @see #getStartQuantity()
   * @see #setStartQuantity(BigInteger)
   * @generated
   */
  boolean isSetStartQuantity();

  /**
   * Returns the value of the '<em><b>Is ATransaction</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is ATransaction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is ATransaction</em>' attribute.
   * @see #isSetIsATransaction()
   * @see #unsetIsATransaction()
   * @see #setIsATransaction(boolean)
   * @generated
   */
  boolean isIsATransaction();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isIsATransaction <em>Is ATransaction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is ATransaction</em>' attribute.
   * @see #isSetIsATransaction()
   * @see #unsetIsATransaction()
   * @see #isIsATransaction()
   * @generated
   */
  void setIsATransaction(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isIsATransaction <em>Is ATransaction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIsATransaction()
   * @see #isIsATransaction()
   * @see #setIsATransaction(boolean)
   * @generated
   */
  void unsetIsATransaction();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Activity#isIsATransaction <em>Is ATransaction</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Is ATransaction</em>' attribute is set.
   * @see #unsetIsATransaction()
   * @see #isIsATransaction()
   * @see #setIsATransaction(boolean)
   * @generated
   */
  boolean isSetIsATransaction();

  /**
   * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Attribute</em>' attribute list.
   * @generated
   */
  Sequence getAnyAttribute();

} // Activity
