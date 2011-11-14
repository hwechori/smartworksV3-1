/**
 * <copyright>
 * </copyright>
 *
 * $Id: TaskSend.java,v 1.1 2009/12/22 06:18:16 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Send</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getMessage <em>Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getWebServiceOperation <em>Web Service Operation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getWebServiceFaultCatch <em>Web Service Fault Catch</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TaskSend extends Serializable
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getMessage <em>Message</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMessage()
   * @see #getMessage()
   * @see #setMessage(MessageType)
   * @generated
   */
  void unsetMessage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getMessage <em>Message</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getWebServiceOperation <em>Web Service Operation</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getWebServiceOperation <em>Web Service Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWebServiceOperation()
   * @see #getWebServiceOperation()
   * @see #setWebServiceOperation(WebServiceOperation)
   * @generated
   */
  void unsetWebServiceOperation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getWebServiceOperation <em>Web Service Operation</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Web Service Fault Catch</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Web Service Fault Catch</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Web Service Fault Catch</em>' containment reference list.
   * @generated
   */
  List getWebServiceFaultCatch();

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
   * Returns the value of the '<em><b>Implementation</b></em>' attribute.
   * The default value is <code>"WebService"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Required if the Task is Send
   * <!-- end-model-doc -->
   * @return the value of the '<em>Implementation</em>' attribute.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  String getImplementation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation</em>' attribute.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @generated
   */
  void setImplementation(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  void unsetImplementation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend#getImplementation <em>Implementation</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Implementation</em>' attribute is set.
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  boolean isSetImplementation();

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

} // TaskSend
