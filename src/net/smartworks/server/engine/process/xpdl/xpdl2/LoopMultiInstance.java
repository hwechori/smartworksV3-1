/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoopMultiInstance.java,v 1.1 2009/12/22 06:18:16 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;
import java.math.BigInteger;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Multi Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Condition <em>MI Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getLoopCounter <em>Loop Counter</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Ordering <em>MI Ordering</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_FlowCondition <em>MI Flow Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface LoopMultiInstance extends Serializable
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
   * Returns the value of the '<em><b>MI Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>MI Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>MI Condition</em>' attribute.
   * @see #isSetMI_Condition()
   * @see #unsetMI_Condition()
   * @see #setMI_Condition(String)
   * @generated
   */
  String getMI_Condition();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Condition <em>MI Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>MI Condition</em>' attribute.
   * @see #isSetMI_Condition()
   * @see #unsetMI_Condition()
   * @see #getMI_Condition()
   * @generated
   */
  void setMI_Condition(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Condition <em>MI Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMI_Condition()
   * @see #getMI_Condition()
   * @see #setMI_Condition(String)
   * @generated
   */
  void unsetMI_Condition();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Condition <em>MI Condition</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>MI Condition</em>' attribute is set.
   * @see #unsetMI_Condition()
   * @see #getMI_Condition()
   * @see #setMI_Condition(String)
   * @generated
   */
  boolean isSetMI_Condition();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getLoopCounter <em>Loop Counter</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getLoopCounter <em>Loop Counter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoopCounter()
   * @see #getLoopCounter()
   * @see #setLoopCounter(BigInteger)
   * @generated
   */
  void unsetLoopCounter();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getLoopCounter <em>Loop Counter</em>}' attribute is set.
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
   * Returns the value of the '<em><b>MI Ordering</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>MI Ordering</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>MI Ordering</em>' attribute.
   * @see #isSetMI_Ordering()
   * @see #unsetMI_Ordering()
   * @see #setMI_Ordering(String)
   * @generated
   */
  String getMI_Ordering();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Ordering <em>MI Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>MI Ordering</em>' attribute.
   * @see #isSetMI_Ordering()
   * @see #unsetMI_Ordering()
   * @see #getMI_Ordering()
   * @generated
   */
  void setMI_Ordering(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Ordering <em>MI Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMI_Ordering()
   * @see #getMI_Ordering()
   * @see #setMI_Ordering(String)
   * @generated
   */
  void unsetMI_Ordering();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_Ordering <em>MI Ordering</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>MI Ordering</em>' attribute is set.
   * @see #unsetMI_Ordering()
   * @see #getMI_Ordering()
   * @see #setMI_Ordering(String)
   * @generated
   */
  boolean isSetMI_Ordering();

  /**
   * Returns the value of the '<em><b>MI Flow Condition</b></em>' attribute.
   * The default value is <code>"All"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>MI Flow Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>MI Flow Condition</em>' attribute.
   * @see #isSetMI_FlowCondition()
   * @see #unsetMI_FlowCondition()
   * @see #setMI_FlowCondition(String)
   * @generated
   */
  String getMI_FlowCondition();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_FlowCondition <em>MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>MI Flow Condition</em>' attribute.
   * @see #isSetMI_FlowCondition()
   * @see #unsetMI_FlowCondition()
   * @see #getMI_FlowCondition()
   * @generated
   */
  void setMI_FlowCondition(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_FlowCondition <em>MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMI_FlowCondition()
   * @see #getMI_FlowCondition()
   * @see #setMI_FlowCondition(String)
   * @generated
   */
  void unsetMI_FlowCondition();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getMI_FlowCondition <em>MI Flow Condition</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>MI Flow Condition</em>' attribute is set.
   * @see #unsetMI_FlowCondition()
   * @see #getMI_FlowCondition()
   * @see #setMI_FlowCondition(String)
   * @generated
   */
  boolean isSetMI_FlowCondition();

  /**
   * Returns the value of the '<em><b>Complex MI Flow Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Complex MI Flow Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Complex MI Flow Condition</em>' attribute.
   * @see #isSetComplexMI_FlowCondition()
   * @see #unsetComplexMI_FlowCondition()
   * @see #setComplexMI_FlowCondition(String)
   * @generated
   */
  String getComplexMI_FlowCondition();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Complex MI Flow Condition</em>' attribute.
   * @see #isSetComplexMI_FlowCondition()
   * @see #unsetComplexMI_FlowCondition()
   * @see #getComplexMI_FlowCondition()
   * @generated
   */
  void setComplexMI_FlowCondition(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetComplexMI_FlowCondition()
   * @see #getComplexMI_FlowCondition()
   * @see #setComplexMI_FlowCondition(String)
   * @generated
   */
  void unsetComplexMI_FlowCondition();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Complex MI Flow Condition</em>' attribute is set.
   * @see #unsetComplexMI_FlowCondition()
   * @see #getComplexMI_FlowCondition()
   * @see #setComplexMI_FlowCondition(String)
   * @generated
   */
  boolean isSetComplexMI_FlowCondition();

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

} // LoopMultiInstance
