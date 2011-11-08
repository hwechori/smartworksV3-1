/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoopStandard.java,v 1.1 2009/12/22 06:18:28 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Standard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCounter <em>Loop Counter</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getTestTime <em>Test Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface LoopStandard extends Serializable
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
   * Returns the value of the '<em><b>Loop Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Loop Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loop Condition</em>' attribute.
   * @see #isSetLoopCondition()
   * @see #unsetLoopCondition()
   * @see #setLoopCondition(String)
   * @generated
   */
  String getLoopCondition();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCondition <em>Loop Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Condition</em>' attribute.
   * @see #isSetLoopCondition()
   * @see #unsetLoopCondition()
   * @see #getLoopCondition()
   * @generated
   */
  void setLoopCondition(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCondition <em>Loop Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoopCondition()
   * @see #getLoopCondition()
   * @see #setLoopCondition(String)
   * @generated
   */
  void unsetLoopCondition();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCondition <em>Loop Condition</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Loop Condition</em>' attribute is set.
   * @see #unsetLoopCondition()
   * @see #getLoopCondition()
   * @see #setLoopCondition(String)
   * @generated
   */
  boolean isSetLoopCondition();

  /**
   * Returns the value of the '<em><b>Loop Counter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  This is updated at run time to count the number of executions of the loop and is available as a property to be used in expressions. Does this belong in the XPDL?
   * <!-- end-model-doc -->
   * @return the value of the '<em>Loop Counter</em>' attribute.
   * @see #isSetLoopCounter()
   * @see #unsetLoopCounter()
   * @see #setLoopCounter(BigInteger)
   * @generated
   */
  BigInteger getLoopCounter();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCounter <em>Loop Counter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Counter</em>' attribute.
   * @see #isSetLoopCounter()
   * @see #unsetLoopCounter()
   * @see #getLoopCounter()
   * @generated
   */
  void setLoopCounter(BigInteger value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCounter <em>Loop Counter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoopCounter()
   * @see #getLoopCounter()
   * @see #setLoopCounter(BigInteger)
   * @generated
   */
  void unsetLoopCounter();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopCounter <em>Loop Counter</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Loop Counter</em>' attribute is set.
   * @see #unsetLoopCounter()
   * @see #getLoopCounter()
   * @see #setLoopCounter(BigInteger)
   * @generated
   */
  boolean isSetLoopCounter();

  /**
   * Returns the value of the '<em><b>Loop Maximum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Loop Maximum</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loop Maximum</em>' attribute.
   * @see #isSetLoopMaximum()
   * @see #unsetLoopMaximum()
   * @see #setLoopMaximum(BigInteger)
   * @generated
   */
  BigInteger getLoopMaximum();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopMaximum <em>Loop Maximum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Maximum</em>' attribute.
   * @see #isSetLoopMaximum()
   * @see #unsetLoopMaximum()
   * @see #getLoopMaximum()
   * @generated
   */
  void setLoopMaximum(BigInteger value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopMaximum <em>Loop Maximum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoopMaximum()
   * @see #getLoopMaximum()
   * @see #setLoopMaximum(BigInteger)
   * @generated
   */
  void unsetLoopMaximum();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getLoopMaximum <em>Loop Maximum</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Loop Maximum</em>' attribute is set.
   * @see #unsetLoopMaximum()
   * @see #getLoopMaximum()
   * @see #setLoopMaximum(BigInteger)
   * @generated
   */
  boolean isSetLoopMaximum();

  /**
   * Returns the value of the '<em><b>Test Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test Time</em>' attribute.
   * @see #isSetTestTime()
   * @see #unsetTestTime()
   * @see #setTestTime(String)
   * @generated
   */
  String getTestTime();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getTestTime <em>Test Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Test Time</em>' attribute.
   * @see #isSetTestTime()
   * @see #unsetTestTime()
   * @see #getTestTime()
   * @generated
   */
  void setTestTime(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getTestTime <em>Test Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTestTime()
   * @see #getTestTime()
   * @see #setTestTime(String)
   * @generated
   */
  void unsetTestTime();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard#getTestTime <em>Test Time</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Test Time</em>' attribute is set.
   * @see #unsetTestTime()
   * @see #getTestTime()
   * @see #setTestTime(String)
   * @generated
   */
  boolean isSetTestTime();

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

} // LoopStandard
