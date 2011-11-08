/**
 * <copyright>
 * </copyright>
 *
 * $Id: WebServiceFaultCatch.java,v 1.1 2009/12/22 06:18:36 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Service Fault Catch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getMessage <em>Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getBlockActivity <em>Block Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getTransitionRef <em>Transition Ref</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface WebServiceFaultCatch extends Serializable
{
  /**
   * Returns the value of the '<em><b>Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' containment reference.
   * @see #isSetMessage()
   * @see #unsetMessage()
   * @see #setMessage(MessageType)
   * @generated
   */
  MessageType getMessage();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' containment reference.
   * @see #isSetMessage()
   * @see #unsetMessage()
   * @see #getMessage()
   * @generated
   */
  void setMessage(MessageType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMessage()
   * @see #getMessage()
   * @see #setMessage(MessageType)
   * @generated
   */
  void unsetMessage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getMessage <em>Message</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Message</em>' containment reference is set.
   * @see #unsetMessage()
   * @see #getMessage()
   * @see #setMessage(MessageType)
   * @generated
   */
  boolean isSetMessage();

  /**
   * Returns the value of the '<em><b>Block Activity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block Activity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block Activity</em>' containment reference.
   * @see #isSetBlockActivity()
   * @see #unsetBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  BlockActivity getBlockActivity();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getBlockActivity <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block Activity</em>' containment reference.
   * @see #isSetBlockActivity()
   * @see #unsetBlockActivity()
   * @see #getBlockActivity()
   * @generated
   */
  void setBlockActivity(BlockActivity value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getBlockActivity <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBlockActivity()
   * @see #getBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  void unsetBlockActivity();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getBlockActivity <em>Block Activity</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Block Activity</em>' containment reference is set.
   * @see #unsetBlockActivity()
   * @see #getBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  boolean isSetBlockActivity();

  /**
   * Returns the value of the '<em><b>Transition Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Ref</em>' containment reference.
   * @see #isSetTransitionRef()
   * @see #unsetTransitionRef()
   * @see #setTransitionRef(TransitionRef)
   * @generated
   */
  TransitionRef getTransitionRef();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getTransitionRef <em>Transition Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transition Ref</em>' containment reference.
   * @see #isSetTransitionRef()
   * @see #unsetTransitionRef()
   * @see #getTransitionRef()
   * @generated
   */
  void setTransitionRef(TransitionRef value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getTransitionRef <em>Transition Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitionRef()
   * @see #getTransitionRef()
   * @see #setTransitionRef(TransitionRef)
   * @generated
   */
  void unsetTransitionRef();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getTransitionRef <em>Transition Ref</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transition Ref</em>' containment reference is set.
   * @see #unsetTransitionRef()
   * @see #getTransitionRef()
   * @see #setTransitionRef(TransitionRef)
   * @generated
   */
  boolean isSetTransitionRef();

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
   * Returns the value of the '<em><b>Fault Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fault Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fault Name</em>' attribute.
   * @see #isSetFaultName()
   * @see #unsetFaultName()
   * @see #setFaultName(String)
   * @generated
   */
  String getFaultName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getFaultName <em>Fault Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fault Name</em>' attribute.
   * @see #isSetFaultName()
   * @see #unsetFaultName()
   * @see #getFaultName()
   * @generated
   */
  void setFaultName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getFaultName <em>Fault Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFaultName()
   * @see #getFaultName()
   * @see #setFaultName(String)
   * @generated
   */
  void unsetFaultName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch#getFaultName <em>Fault Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Fault Name</em>' attribute is set.
   * @see #unsetFaultName()
   * @see #getFaultName()
   * @see #setFaultName(String)
   * @generated
   */
  boolean isSetFaultName();

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

} // WebServiceFaultCatch
