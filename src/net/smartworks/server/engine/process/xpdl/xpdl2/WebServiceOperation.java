/**
 * <copyright>
 * </copyright>
 *
 * $Id: WebServiceOperation.java,v 1.1 2009/12/22 06:18:36 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Service Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getPartner <em>Partner</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getService <em>Service</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface WebServiceOperation extends Serializable
{
  /**
   * Returns the value of the '<em><b>Partner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partner</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partner</em>' containment reference.
   * @see #isSetPartner()
   * @see #unsetPartner()
   * @see #setPartner(Partner)
   * @generated
   */
  Partner getPartner();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getPartner <em>Partner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partner</em>' containment reference.
   * @see #isSetPartner()
   * @see #unsetPartner()
   * @see #getPartner()
   * @generated
   */
  void setPartner(Partner value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getPartner <em>Partner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPartner()
   * @see #getPartner()
   * @see #setPartner(Partner)
   * @generated
   */
  void unsetPartner();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getPartner <em>Partner</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Partner</em>' containment reference is set.
   * @see #unsetPartner()
   * @see #getPartner()
   * @see #setPartner(Partner)
   * @generated
   */
  boolean isSetPartner();

  /**
   * Returns the value of the '<em><b>Service</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service</em>' containment reference.
   * @see #isSetService()
   * @see #unsetService()
   * @see #setService(Service)
   * @generated
   */
  Service getService();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getService <em>Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service</em>' containment reference.
   * @see #isSetService()
   * @see #unsetService()
   * @see #getService()
   * @generated
   */
  void setService(Service value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getService <em>Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetService()
   * @see #getService()
   * @see #setService(Service)
   * @generated
   */
  void unsetService();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getService <em>Service</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Service</em>' containment reference is set.
   * @see #unsetService()
   * @see #getService()
   * @see #setService(Service)
   * @generated
   */
  boolean isSetService();

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
   * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Name</em>' attribute.
   * @see #isSetOperationName()
   * @see #unsetOperationName()
   * @see #setOperationName(String)
   * @generated
   */
  String getOperationName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getOperationName <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Name</em>' attribute.
   * @see #isSetOperationName()
   * @see #unsetOperationName()
   * @see #getOperationName()
   * @generated
   */
  void setOperationName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getOperationName <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOperationName()
   * @see #getOperationName()
   * @see #setOperationName(String)
   * @generated
   */
  void unsetOperationName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation#getOperationName <em>Operation Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Operation Name</em>' attribute is set.
   * @see #unsetOperationName()
   * @see #getOperationName()
   * @see #setOperationName(String)
   * @generated
   */
  boolean isSetOperationName();

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

} // WebServiceOperation
