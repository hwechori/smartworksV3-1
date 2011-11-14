/**
 * <copyright>
 * </copyright>
 *
 * $Id: TriggerResultLink.java,v 1.1 2009/12/22 06:18:11 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger Result Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getLinkId <em>Link Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getProcessRef <em>Process Ref</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TriggerResultLink extends Serializable
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
   * Returns the value of the '<em><b>Link Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Link Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link Id</em>' attribute.
   * @see #isSetLinkId()
   * @see #unsetLinkId()
   * @see #setLinkId(String)
   * @generated
   */
  String getLinkId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getLinkId <em>Link Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Link Id</em>' attribute.
   * @see #isSetLinkId()
   * @see #unsetLinkId()
   * @see #getLinkId()
   * @generated
   */
  void setLinkId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getLinkId <em>Link Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLinkId()
   * @see #getLinkId()
   * @see #setLinkId(String)
   * @generated
   */
  void unsetLinkId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getLinkId <em>Link Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Link Id</em>' attribute is set.
   * @see #unsetLinkId()
   * @see #getLinkId()
   * @see #setLinkId(String)
   * @generated
   */
  boolean isSetLinkId();

  /**
   * Returns the value of the '<em><b>Process Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This must identify a Process. Should be the Id of a process.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Process Ref</em>' attribute.
   * @see #isSetProcessRef()
   * @see #unsetProcessRef()
   * @see #setProcessRef(String)
   * @generated
   */
  String getProcessRef();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getProcessRef <em>Process Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process Ref</em>' attribute.
   * @see #isSetProcessRef()
   * @see #unsetProcessRef()
   * @see #getProcessRef()
   * @generated
   */
  void setProcessRef(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getProcessRef <em>Process Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetProcessRef()
   * @see #getProcessRef()
   * @see #setProcessRef(String)
   * @generated
   */
  void unsetProcessRef();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink#getProcessRef <em>Process Ref</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Process Ref</em>' attribute is set.
   * @see #unsetProcessRef()
   * @see #getProcessRef()
   * @see #setProcessRef(String)
   * @generated
   */
  boolean isSetProcessRef();

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

} // TriggerResultLink
