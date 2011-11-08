/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageFlow.java,v 1.1 2009/12/22 06:18:29 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getMessage <em>Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getConnectorGraphicsInfos <em>Connector Graphics Infos</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getSource <em>Source</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getTarget <em>Target</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface MessageFlow extends Serializable
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getMessage <em>Message</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMessage()
   * @see #getMessage()
   * @see #setMessage(MessageType)
   * @generated
   */
  void unsetMessage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getMessage <em>Message</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: This is used to identify the Activity in an EndEvent Compensation???Also used to associate categories and ocumentation with a variety of elements
   * <!-- end-model-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.Object getObject();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #getObject()
   * @generated
   */
  void setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  void unsetObject();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getObject <em>Object</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Object</em>' containment reference is set.
   * @see #unsetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  boolean isSetObject();

  /**
   * Returns the value of the '<em><b>Connector Graphics Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connector Graphics Infos</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connector Graphics Infos</em>' containment reference.
   * @see #isSetConnectorGraphicsInfos()
   * @see #unsetConnectorGraphicsInfos()
   * @see #setConnectorGraphicsInfos(ConnectorGraphicsInfos)
   * @generated
   */
  ConnectorGraphicsInfos getConnectorGraphicsInfos();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getConnectorGraphicsInfos <em>Connector Graphics Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connector Graphics Infos</em>' containment reference.
   * @see #isSetConnectorGraphicsInfos()
   * @see #unsetConnectorGraphicsInfos()
   * @see #getConnectorGraphicsInfos()
   * @generated
   */
  void setConnectorGraphicsInfos(ConnectorGraphicsInfos value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getConnectorGraphicsInfos <em>Connector Graphics Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetConnectorGraphicsInfos()
   * @see #getConnectorGraphicsInfos()
   * @see #setConnectorGraphicsInfos(ConnectorGraphicsInfos)
   * @generated
   */
  void unsetConnectorGraphicsInfos();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getConnectorGraphicsInfos <em>Connector Graphics Infos</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Connector Graphics Infos</em>' containment reference is set.
   * @see #unsetConnectorGraphicsInfos()
   * @see #getConnectorGraphicsInfos()
   * @see #setConnectorGraphicsInfos(ConnectorGraphicsInfos)
   * @generated
   */
  boolean isSetConnectorGraphicsInfos();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getId <em>Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getName <em>Name</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #isSetSource()
   * @see #unsetSource()
   * @see #setSource(String)
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #isSetSource()
   * @see #unsetSource()
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSource()
   * @see #getSource()
   * @see #setSource(String)
   * @generated
   */
  void unsetSource();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getSource <em>Source</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Source</em>' attribute is set.
   * @see #unsetSource()
   * @see #getSource()
   * @see #setSource(String)
   * @generated
   */
  boolean isSetSource();

  /**
   * Returns the value of the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' attribute.
   * @see #isSetTarget()
   * @see #unsetTarget()
   * @see #setTarget(String)
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #isSetTarget()
   * @see #unsetTarget()
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTarget()
   * @see #getTarget()
   * @see #setTarget(String)
   * @generated
   */
  void unsetTarget();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow#getTarget <em>Target</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Target</em>' attribute is set.
   * @see #unsetTarget()
   * @see #getTarget()
   * @see #setTarget(String)
   * @generated
   */
  boolean isSetTarget();

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

} // MessageFlow
