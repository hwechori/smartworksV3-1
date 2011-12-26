/**
 * <copyright>
 * </copyright>
 *
 * $Id: TriggerRule.java,v 1.1 2009/12/22 06:18:32 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerRule#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerRule#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerRule#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TriggerRule extends Serializable
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
   * Returns the value of the '<em><b>Rule Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the nameof a Rule element.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Rule Name</em>' attribute.
   * @see #isSetRuleName()
   * @see #unsetRuleName()
   * @see #setRuleName(String)
   * @generated
   */
  String getRuleName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerRule#getRuleName <em>Rule Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule Name</em>' attribute.
   * @see #isSetRuleName()
   * @see #unsetRuleName()
   * @see #getRuleName()
   * @generated
   */
  void setRuleName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerRule#getRuleName <em>Rule Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRuleName()
   * @see #getRuleName()
   * @see #setRuleName(String)
   * @generated
   */
  void unsetRuleName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerRule#getRuleName <em>Rule Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Rule Name</em>' attribute is set.
   * @see #unsetRuleName()
   * @see #getRuleName()
   * @see #setRuleName(String)
   * @generated
   */
  boolean isSetRuleName();

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

} // TriggerRule
