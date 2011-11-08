/**
 * <copyright>
 * </copyright>
 *
 * $Id: TriggerResultMessage.java,v 1.1 2009/12/22 06:18:31 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger Result Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getMessage <em>Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getWebServiceOperation <em>Web Service Operation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TriggerResultMessage extends Serializable
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getMessage <em>Message</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMessage()
   * @see #getMessage()
   * @see #setMessage(MessageType)
   * @generated
   */
  void unsetMessage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getMessage <em>Message</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Web Service Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: If the Implementation is a WebService this is required.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Web Service Operation</em>' containment reference.
   * @see #isSetWebServiceOperation()
   * @see #unsetWebServiceOperation()
   * @see #setWebServiceOperation(WebServiceOperation)
   * @generated
   */
  WebServiceOperation getWebServiceOperation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getWebServiceOperation <em>Web Service Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Web Service Operation</em>' containment reference.
   * @see #isSetWebServiceOperation()
   * @see #unsetWebServiceOperation()
   * @see #getWebServiceOperation()
   * @generated
   */
  void setWebServiceOperation(WebServiceOperation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getWebServiceOperation <em>Web Service Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWebServiceOperation()
   * @see #getWebServiceOperation()
   * @see #setWebServiceOperation(WebServiceOperation)
   * @generated
   */
  void unsetWebServiceOperation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage#getWebServiceOperation <em>Web Service Operation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Web Service Operation</em>' containment reference is set.
   * @see #unsetWebServiceOperation()
   * @see #getWebServiceOperation()
   * @see #setWebServiceOperation(WebServiceOperation)
   * @generated
   */
  boolean isSetWebServiceOperation();

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

} // TriggerResultMessage
