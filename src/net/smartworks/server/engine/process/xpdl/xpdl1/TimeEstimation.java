/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeEstimation.java,v 1.1 2009/12/22 06:18:04 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Estimation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWaitingTime <em>Waiting Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWorkingTime <em>Working Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getDuration <em>Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TimeEstimation extends Serializable
{
  /**
   * Returns the value of the '<em><b>Waiting Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Waiting Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Waiting Time</em>' attribute.
   * @see #isSetWaitingTime()
   * @see #unsetWaitingTime()
   * @see #setWaitingTime(String)
   * @generated
   */
  String getWaitingTime();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWaitingTime <em>Waiting Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Waiting Time</em>' attribute.
   * @see #isSetWaitingTime()
   * @see #unsetWaitingTime()
   * @see #getWaitingTime()
   * @generated
   */
  void setWaitingTime(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWaitingTime <em>Waiting Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWaitingTime()
   * @see #getWaitingTime()
   * @see #setWaitingTime(String)
   * @generated
   */
  void unsetWaitingTime();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWaitingTime <em>Waiting Time</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Waiting Time</em>' attribute is set.
   * @see #unsetWaitingTime()
   * @see #getWaitingTime()
   * @see #setWaitingTime(String)
   * @generated
   */
  boolean isSetWaitingTime();

  /**
   * Returns the value of the '<em><b>Working Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Working Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Working Time</em>' attribute.
   * @see #isSetWorkingTime()
   * @see #unsetWorkingTime()
   * @see #setWorkingTime(String)
   * @generated
   */
  String getWorkingTime();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWorkingTime <em>Working Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Working Time</em>' attribute.
   * @see #isSetWorkingTime()
   * @see #unsetWorkingTime()
   * @see #getWorkingTime()
   * @generated
   */
  void setWorkingTime(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWorkingTime <em>Working Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWorkingTime()
   * @see #getWorkingTime()
   * @see #setWorkingTime(String)
   * @generated
   */
  void unsetWorkingTime();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getWorkingTime <em>Working Time</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Working Time</em>' attribute is set.
   * @see #unsetWorkingTime()
   * @see #getWorkingTime()
   * @see #setWorkingTime(String)
   * @generated
   */
  boolean isSetWorkingTime();

  /**
   * Returns the value of the '<em><b>Duration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Duration</em>' attribute.
   * @see #isSetDuration()
   * @see #unsetDuration()
   * @see #setDuration(String)
   * @generated
   */
  String getDuration();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getDuration <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration</em>' attribute.
   * @see #isSetDuration()
   * @see #unsetDuration()
   * @see #getDuration()
   * @generated
   */
  void setDuration(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getDuration <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDuration()
   * @see #getDuration()
   * @see #setDuration(String)
   * @generated
   */
  void unsetDuration();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation#getDuration <em>Duration</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Duration</em>' attribute is set.
   * @see #unsetDuration()
   * @see #getDuration()
   * @see #setDuration(String)
   * @generated
   */
  boolean isSetDuration();

} // TimeEstimation
