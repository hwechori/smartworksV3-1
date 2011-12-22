/**
 * <copyright>
 * </copyright>
 *
 * $Id: Loop.java,v 1.1 2009/12/22 06:18:13 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopStandard <em>Loop Standard</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopMultiInstance <em>Loop Multi Instance</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopType <em>Loop Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Loop extends Serializable
{
  /**
   * Returns the value of the '<em><b>Loop Standard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Loop Standard</em>' containment reference.
   * @see #isSetLoopStandard()
   * @see #unsetLoopStandard()
   * @see #setLoopStandard(LoopStandard)
   * @generated
   */
  LoopStandard getLoopStandard();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopStandard <em>Loop Standard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Standard</em>' containment reference.
   * @see #isSetLoopStandard()
   * @see #unsetLoopStandard()
   * @see #getLoopStandard()
   * @generated
   */
  void setLoopStandard(LoopStandard value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopStandard <em>Loop Standard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoopStandard()
   * @see #getLoopStandard()
   * @see #setLoopStandard(LoopStandard)
   * @generated
   */
  void unsetLoopStandard();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopStandard <em>Loop Standard</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Loop Standard</em>' containment reference is set.
   * @see #unsetLoopStandard()
   * @see #getLoopStandard()
   * @see #setLoopStandard(LoopStandard)
   * @generated
   */
  boolean isSetLoopStandard();

  /**
   * Returns the value of the '<em><b>Loop Multi Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Loop Multi Instance</em>' containment reference.
   * @see #isSetLoopMultiInstance()
   * @see #unsetLoopMultiInstance()
   * @see #setLoopMultiInstance(LoopMultiInstance)
   * @generated
   */
  LoopMultiInstance getLoopMultiInstance();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopMultiInstance <em>Loop Multi Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Multi Instance</em>' containment reference.
   * @see #isSetLoopMultiInstance()
   * @see #unsetLoopMultiInstance()
   * @see #getLoopMultiInstance()
   * @generated
   */
  void setLoopMultiInstance(LoopMultiInstance value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopMultiInstance <em>Loop Multi Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoopMultiInstance()
   * @see #getLoopMultiInstance()
   * @see #setLoopMultiInstance(LoopMultiInstance)
   * @generated
   */
  void unsetLoopMultiInstance();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopMultiInstance <em>Loop Multi Instance</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Loop Multi Instance</em>' containment reference is set.
   * @see #unsetLoopMultiInstance()
   * @see #getLoopMultiInstance()
   * @see #setLoopMultiInstance(LoopMultiInstance)
   * @generated
   */
  boolean isSetLoopMultiInstance();

  /**
   * Returns the value of the '<em><b>Loop Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Loop Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loop Type</em>' attribute.
   * @see #isSetLoopType()
   * @see #unsetLoopType()
   * @see #setLoopType(String)
   * @generated
   */
  String getLoopType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopType <em>Loop Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Type</em>' attribute.
   * @see #isSetLoopType()
   * @see #unsetLoopType()
   * @see #getLoopType()
   * @generated
   */
  void setLoopType(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopType <em>Loop Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLoopType()
   * @see #getLoopType()
   * @see #setLoopType(String)
   * @generated
   */
  void unsetLoopType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Loop#getLoopType <em>Loop Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Loop Type</em>' attribute is set.
   * @see #unsetLoopType()
   * @see #getLoopType()
   * @see #setLoopType(String)
   * @generated
   */
  boolean isSetLoopType();

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

} // Loop
