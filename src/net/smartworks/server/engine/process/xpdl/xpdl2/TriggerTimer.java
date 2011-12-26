/**
 * <copyright>
 * </copyright>
 *
 * $Id: TriggerTimer.java,v 1.1 2009/12/22 06:18:20 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeDate <em>Time Date</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeCycle <em>Time Cycle</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TriggerTimer extends Serializable
{
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
   * Returns the value of the '<em><b>Time Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * One of TimeDate or TimeCycle must be present
   * <!-- end-model-doc -->
   * @return the value of the '<em>Time Date</em>' attribute.
   * @see #isSetTimeDate()
   * @see #unsetTimeDate()
   * @see #setTimeDate(String)
   * @generated
   */
  String getTimeDate();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeDate <em>Time Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Date</em>' attribute.
   * @see #isSetTimeDate()
   * @see #unsetTimeDate()
   * @see #getTimeDate()
   * @generated
   */
  void setTimeDate(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeDate <em>Time Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTimeDate()
   * @see #getTimeDate()
   * @see #setTimeDate(String)
   * @generated
   */
  void unsetTimeDate();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeDate <em>Time Date</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Time Date</em>' attribute is set.
   * @see #unsetTimeDate()
   * @see #getTimeDate()
   * @see #setTimeDate(String)
   * @generated
   */
  boolean isSetTimeDate();

  /**
   * Returns the value of the '<em><b>Time Cycle</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time Cycle</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Cycle</em>' attribute.
   * @see #isSetTimeCycle()
   * @see #unsetTimeCycle()
   * @see #setTimeCycle(String)
   * @generated
   */
  String getTimeCycle();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeCycle <em>Time Cycle</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Cycle</em>' attribute.
   * @see #isSetTimeCycle()
   * @see #unsetTimeCycle()
   * @see #getTimeCycle()
   * @generated
   */
  void setTimeCycle(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeCycle <em>Time Cycle</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTimeCycle()
   * @see #getTimeCycle()
   * @see #setTimeCycle(String)
   * @generated
   */
  void unsetTimeCycle();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer#getTimeCycle <em>Time Cycle</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Time Cycle</em>' attribute is set.
   * @see #unsetTimeCycle()
   * @see #getTimeCycle()
   * @see #setTimeCycle(String)
   * @generated
   */
  boolean isSetTimeCycle();

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

} // TriggerTimer
