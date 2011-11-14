/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageType.java,v 1.1 2009/12/22 06:18:35 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Formal Parameters defined by WSDL. Must constraint the parameters to either all in or all out, because Message is in a single direction
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getDataMappings <em>Data Mappings</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFrom <em>From</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getTo <em>To</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface MessageType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Actual Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual Parameters</em>' containment reference.
   * @see #isSetActualParameters()
   * @see #unsetActualParameters()
   * @see #setActualParameters(ActualParameters)
   * @generated
   */
  ActualParameters getActualParameters();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getActualParameters <em>Actual Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual Parameters</em>' containment reference.
   * @see #isSetActualParameters()
   * @see #unsetActualParameters()
   * @see #getActualParameters()
   * @generated
   */
  void setActualParameters(ActualParameters value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getActualParameters <em>Actual Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActualParameters()
   * @see #getActualParameters()
   * @see #setActualParameters(ActualParameters)
   * @generated
   */
  void unsetActualParameters();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getActualParameters <em>Actual Parameters</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Actual Parameters</em>' containment reference is set.
   * @see #unsetActualParameters()
   * @see #getActualParameters()
   * @see #setActualParameters(ActualParameters)
   * @generated
   */
  boolean isSetActualParameters();

  /**
   * Returns the value of the '<em><b>Data Mappings</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * XPDL and BPMN:Maps fields or properties between calling and called processes or subprocesses
   * <!-- end-model-doc -->
   * @return the value of the '<em>Data Mappings</em>' containment reference.
   * @see #isSetDataMappings()
   * @see #unsetDataMappings()
   * @see #setDataMappings(DataMappings)
   * @generated
   */
  DataMappings getDataMappings();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getDataMappings <em>Data Mappings</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Mappings</em>' containment reference.
   * @see #isSetDataMappings()
   * @see #unsetDataMappings()
   * @see #getDataMappings()
   * @generated
   */
  void setDataMappings(DataMappings value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getDataMappings <em>Data Mappings</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataMappings()
   * @see #getDataMappings()
   * @see #setDataMappings(DataMappings)
   * @generated
   */
  void unsetDataMappings();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getDataMappings <em>Data Mappings</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Data Mappings</em>' containment reference is set.
   * @see #unsetDataMappings()
   * @see #getDataMappings()
   * @see #setDataMappings(DataMappings)
   * @generated
   */
  boolean isSetDataMappings();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getId <em>Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getName <em>Name</em>}' attribute is set.
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
   * Returns the value of the '<em><b>From</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This must be the name of a Participant
   * <!-- end-model-doc -->
   * @return the value of the '<em>From</em>' attribute.
   * @see #isSetFrom()
   * @see #unsetFrom()
   * @see #setFrom(String)
   * @generated
   */
  String getFrom();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFrom <em>From</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' attribute.
   * @see #isSetFrom()
   * @see #unsetFrom()
   * @see #getFrom()
   * @generated
   */
  void setFrom(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFrom <em>From</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFrom()
   * @see #getFrom()
   * @see #setFrom(String)
   * @generated
   */
  void unsetFrom();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFrom <em>From</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>From</em>' attribute is set.
   * @see #unsetFrom()
   * @see #getFrom()
   * @see #setFrom(String)
   * @generated
   */
  boolean isSetFrom();

  /**
   * Returns the value of the '<em><b>To</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This must be the name of a participant
   * <!-- end-model-doc -->
   * @return the value of the '<em>To</em>' attribute.
   * @see #isSetTo()
   * @see #unsetTo()
   * @see #setTo(String)
   * @generated
   */
  String getTo();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getTo <em>To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' attribute.
   * @see #isSetTo()
   * @see #unsetTo()
   * @see #getTo()
   * @generated
   */
  void setTo(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getTo <em>To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTo()
   * @see #getTo()
   * @see #setTo(String)
   * @generated
   */
  void unsetTo();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getTo <em>To</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>To</em>' attribute is set.
   * @see #unsetTo()
   * @see #getTo()
   * @see #setTo(String)
   * @generated
   */
  boolean isSetTo();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFaultName <em>Fault Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFaultName <em>Fault Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFaultName()
   * @see #getFaultName()
   * @see #setFaultName(String)
   * @generated
   */
  void unsetFaultName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.MessageType#getFaultName <em>Fault Name</em>}' attribute is set.
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

} // MessageType
