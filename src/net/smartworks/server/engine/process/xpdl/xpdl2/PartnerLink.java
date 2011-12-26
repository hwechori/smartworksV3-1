/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartnerLink.java,v 1.1 2009/12/22 06:18:28 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getMyRole <em>My Role</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerRole <em>Partner Role</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerLinkTypeId <em>Partner Link Type Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface PartnerLink extends Serializable
{
  /**
   * Returns the value of the '<em><b>My Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>My Role</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>My Role</em>' containment reference.
   * @see #isSetMyRole()
   * @see #unsetMyRole()
   * @see #setMyRole(MyRole)
   * @generated
   */
  MyRole getMyRole();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getMyRole <em>My Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>My Role</em>' containment reference.
   * @see #isSetMyRole()
   * @see #unsetMyRole()
   * @see #getMyRole()
   * @generated
   */
  void setMyRole(MyRole value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getMyRole <em>My Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMyRole()
   * @see #getMyRole()
   * @see #setMyRole(MyRole)
   * @generated
   */
  void unsetMyRole();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getMyRole <em>My Role</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>My Role</em>' containment reference is set.
   * @see #unsetMyRole()
   * @see #getMyRole()
   * @see #setMyRole(MyRole)
   * @generated
   */
  boolean isSetMyRole();

  /**
   * Returns the value of the '<em><b>Partner Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partner Role</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partner Role</em>' containment reference.
   * @see #isSetPartnerRole()
   * @see #unsetPartnerRole()
   * @see #setPartnerRole(PartnerRole)
   * @generated
   */
  PartnerRole getPartnerRole();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerRole <em>Partner Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partner Role</em>' containment reference.
   * @see #isSetPartnerRole()
   * @see #unsetPartnerRole()
   * @see #getPartnerRole()
   * @generated
   */
  void setPartnerRole(PartnerRole value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerRole <em>Partner Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPartnerRole()
   * @see #getPartnerRole()
   * @see #setPartnerRole(PartnerRole)
   * @generated
   */
  void unsetPartnerRole();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerRole <em>Partner Role</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Partner Role</em>' containment reference is set.
   * @see #unsetPartnerRole()
   * @see #getPartnerRole()
   * @see #setPartnerRole(PartnerRole)
   * @generated
   */
  boolean isSetPartnerRole();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getName <em>Name</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getId <em>Id</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Partner Link Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partner Link Type Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partner Link Type Id</em>' attribute.
   * @see #isSetPartnerLinkTypeId()
   * @see #unsetPartnerLinkTypeId()
   * @see #setPartnerLinkTypeId(String)
   * @generated
   */
  String getPartnerLinkTypeId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerLinkTypeId <em>Partner Link Type Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partner Link Type Id</em>' attribute.
   * @see #isSetPartnerLinkTypeId()
   * @see #unsetPartnerLinkTypeId()
   * @see #getPartnerLinkTypeId()
   * @generated
   */
  void setPartnerLinkTypeId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerLinkTypeId <em>Partner Link Type Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPartnerLinkTypeId()
   * @see #getPartnerLinkTypeId()
   * @see #setPartnerLinkTypeId(String)
   * @generated
   */
  void unsetPartnerLinkTypeId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink#getPartnerLinkTypeId <em>Partner Link Type Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Partner Link Type Id</em>' attribute is set.
   * @see #unsetPartnerLinkTypeId()
   * @see #getPartnerLinkTypeId()
   * @see #setPartnerLinkTypeId(String)
   * @generated
   */
  boolean isSetPartnerLinkTypeId();

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

} // PartnerLink
