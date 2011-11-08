/**
 * <copyright>
 * </copyright>
 *
 * $Id: WebService.java,v 1.1 2009/12/22 06:18:22 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getWebServiceOperation <em>Web Service Operation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getWebServiceFaultCatch <em>Web Service Fault Catch</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getInputMsgName <em>Input Msg Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getOutputMsgName <em>Output Msg Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface WebService extends Serializable
{
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getWebServiceOperation <em>Web Service Operation</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getWebServiceOperation <em>Web Service Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWebServiceOperation()
   * @see #getWebServiceOperation()
   * @see #setWebServiceOperation(WebServiceOperation)
   * @generated
   */
  void unsetWebServiceOperation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getWebServiceOperation <em>Web Service Operation</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Input Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The name of inputMessage as defined in the WSDL which will help in uniquely identifying the operation to be invoked
   * <!-- end-model-doc -->
   * @return the value of the '<em>Input Msg Name</em>' attribute.
   * @see #isSetInputMsgName()
   * @see #unsetInputMsgName()
   * @see #setInputMsgName(String)
   * @generated
   */
  String getInputMsgName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getInputMsgName <em>Input Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input Msg Name</em>' attribute.
   * @see #isSetInputMsgName()
   * @see #unsetInputMsgName()
   * @see #getInputMsgName()
   * @generated
   */
  void setInputMsgName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getInputMsgName <em>Input Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetInputMsgName()
   * @see #getInputMsgName()
   * @see #setInputMsgName(String)
   * @generated
   */
  void unsetInputMsgName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getInputMsgName <em>Input Msg Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Input Msg Name</em>' attribute is set.
   * @see #unsetInputMsgName()
   * @see #getInputMsgName()
   * @see #setInputMsgName(String)
   * @generated
   */
  boolean isSetInputMsgName();

  /**
   * Returns the value of the '<em><b>Output Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The name of inputMessage as defined in the WSDL which will help in uniquely identifying the operation to be invoked
   * <!-- end-model-doc -->
   * @return the value of the '<em>Output Msg Name</em>' attribute.
   * @see #isSetOutputMsgName()
   * @see #unsetOutputMsgName()
   * @see #setOutputMsgName(String)
   * @generated
   */
  String getOutputMsgName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getOutputMsgName <em>Output Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output Msg Name</em>' attribute.
   * @see #isSetOutputMsgName()
   * @see #unsetOutputMsgName()
   * @see #getOutputMsgName()
   * @generated
   */
  void setOutputMsgName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getOutputMsgName <em>Output Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOutputMsgName()
   * @see #getOutputMsgName()
   * @see #setOutputMsgName(String)
   * @generated
   */
  void unsetOutputMsgName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.WebService#getOutputMsgName <em>Output Msg Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Output Msg Name</em>' attribute is set.
   * @see #unsetOutputMsgName()
   * @see #getOutputMsgName()
   * @see #setOutputMsgName(String)
   * @generated
   */
  boolean isSetOutputMsgName();

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

} // WebService
