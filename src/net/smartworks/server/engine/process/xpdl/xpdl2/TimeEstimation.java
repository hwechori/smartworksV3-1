/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeEstimation.java,v 1.1 2009/12/22 06:18:37 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Estimation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWaitingTime <em>Waiting Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWorkingTime <em>Working Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getDuration <em>Duration</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TimeEstimation extends Serializable
{
  /**
   * Returns the value of the '<em><b>Waiting Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Waiting Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Waiting Time</em>' containment reference.
   * @see #isSetWaitingTime()
   * @see #unsetWaitingTime()
   * @see #setWaitingTime(WaitingTime)
   * @generated
   */
  WaitingTime getWaitingTime();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWaitingTime <em>Waiting Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Waiting Time</em>' containment reference.
   * @see #isSetWaitingTime()
   * @see #unsetWaitingTime()
   * @see #getWaitingTime()
   * @generated
   */
  void setWaitingTime(WaitingTime value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWaitingTime <em>Waiting Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWaitingTime()
   * @see #getWaitingTime()
   * @see #setWaitingTime(WaitingTime)
   * @generated
   */
  void unsetWaitingTime();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWaitingTime <em>Waiting Time</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Waiting Time</em>' containment reference is set.
   * @see #unsetWaitingTime()
   * @see #getWaitingTime()
   * @see #setWaitingTime(WaitingTime)
   * @generated
   */
  boolean isSetWaitingTime();

  /**
   * Returns the value of the '<em><b>Working Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Working Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Working Time</em>' containment reference.
   * @see #isSetWorkingTime()
   * @see #unsetWorkingTime()
   * @see #setWorkingTime(WorkingTime)
   * @generated
   */
  WorkingTime getWorkingTime();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWorkingTime <em>Working Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Working Time</em>' containment reference.
   * @see #isSetWorkingTime()
   * @see #unsetWorkingTime()
   * @see #getWorkingTime()
   * @generated
   */
  void setWorkingTime(WorkingTime value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWorkingTime <em>Working Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWorkingTime()
   * @see #getWorkingTime()
   * @see #setWorkingTime(WorkingTime)
   * @generated
   */
  void unsetWorkingTime();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getWorkingTime <em>Working Time</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Working Time</em>' containment reference is set.
   * @see #unsetWorkingTime()
   * @see #getWorkingTime()
   * @see #setWorkingTime(WorkingTime)
   * @generated
   */
  boolean isSetWorkingTime();

  /**
   * Returns the value of the '<em><b>Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Duration</em>' containment reference.
   * @see #isSetDuration()
   * @see #unsetDuration()
   * @see #setDuration(Duration)
   * @generated
   */
  Duration getDuration();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getDuration <em>Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration</em>' containment reference.
   * @see #isSetDuration()
   * @see #unsetDuration()
   * @see #getDuration()
   * @generated
   */
  void setDuration(Duration value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getDuration <em>Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDuration()
   * @see #getDuration()
   * @see #setDuration(Duration)
   * @generated
   */
  void unsetDuration();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation#getDuration <em>Duration</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Duration</em>' containment reference is set.
   * @see #unsetDuration()
   * @see #getDuration()
   * @see #setDuration(Duration)
   * @generated
   */
  boolean isSetDuration();

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

} // TimeEstimation
