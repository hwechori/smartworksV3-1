/**
 * <copyright>
 * </copyright>
 *
 * $Id: Partner.java,v 1.1 2009/12/22 06:18:10 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getPartnerLinkId <em>Partner Link Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getRoleType <em>Role Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Partner extends Serializable
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
   * Returns the value of the '<em><b>Partner Link Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partner Link Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partner Link Id</em>' attribute.
   * @see #isSetPartnerLinkId()
   * @see #unsetPartnerLinkId()
   * @see #setPartnerLinkId(String)
   * @generated
   */
  String getPartnerLinkId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getPartnerLinkId <em>Partner Link Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partner Link Id</em>' attribute.
   * @see #isSetPartnerLinkId()
   * @see #unsetPartnerLinkId()
   * @see #getPartnerLinkId()
   * @generated
   */
  void setPartnerLinkId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getPartnerLinkId <em>Partner Link Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPartnerLinkId()
   * @see #getPartnerLinkId()
   * @see #setPartnerLinkId(String)
   * @generated
   */
  void unsetPartnerLinkId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getPartnerLinkId <em>Partner Link Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Partner Link Id</em>' attribute is set.
   * @see #unsetPartnerLinkId()
   * @see #getPartnerLinkId()
   * @see #setPartnerLinkId(String)
   * @generated
   */
  boolean isSetPartnerLinkId();

  /**
   * Returns the value of the '<em><b>Role Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Type</em>' attribute.
   * @see #isSetRoleType()
   * @see #unsetRoleType()
   * @see #setRoleType(String)
   * @generated
   */
  String getRoleType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getRoleType <em>Role Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Type</em>' attribute.
   * @see #isSetRoleType()
   * @see #unsetRoleType()
   * @see #getRoleType()
   * @generated
   */
  void setRoleType(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getRoleType <em>Role Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRoleType()
   * @see #getRoleType()
   * @see #setRoleType(String)
   * @generated
   */
  void unsetRoleType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Partner#getRoleType <em>Role Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Role Type</em>' attribute is set.
   * @see #unsetRoleType()
   * @see #getRoleType()
   * @see #setRoleType(String)
   * @generated
   */
  boolean isSetRoleType();

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

} // Partner
