/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessRule.java,v 1.1 2009/12/22 06:18:33 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getLocation <em>Location</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface BusinessRule extends Serializable
{
  /**
   * Returns the value of the '<em><b>Rule Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule Name</em>' containment reference.
   * @see #isSetRuleName()
   * @see #unsetRuleName()
   * @see #setRuleName(RuleName)
   * @generated
   */
  RuleName getRuleName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getRuleName <em>Rule Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule Name</em>' containment reference.
   * @see #isSetRuleName()
   * @see #unsetRuleName()
   * @see #getRuleName()
   * @generated
   */
  void setRuleName(RuleName value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getRuleName <em>Rule Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRuleName()
   * @see #getRuleName()
   * @see #setRuleName(RuleName)
   * @generated
   */
  void unsetRuleName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getRuleName <em>Rule Name</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Rule Name</em>' containment reference is set.
   * @see #unsetRuleName()
   * @see #getRuleName()
   * @see #setRuleName(RuleName)
   * @generated
   */
  boolean isSetRuleName();

  /**
   * Returns the value of the '<em><b>Location</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' containment reference.
   * @see #isSetLocation()
   * @see #unsetLocation()
   * @see #setLocation(Location)
   * @generated
   */
  Location getLocation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getLocation <em>Location</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' containment reference.
   * @see #isSetLocation()
   * @see #unsetLocation()
   * @see #getLocation()
   * @generated
   */
  void setLocation(Location value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getLocation <em>Location</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLocation()
   * @see #getLocation()
   * @see #setLocation(Location)
   * @generated
   */
  void unsetLocation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule#getLocation <em>Location</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Location</em>' containment reference is set.
   * @see #unsetLocation()
   * @see #getLocation()
   * @see #setLocation(Location)
   * @generated
   */
  boolean isSetLocation();

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

} // BusinessRule
