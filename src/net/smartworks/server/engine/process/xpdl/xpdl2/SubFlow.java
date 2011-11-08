/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubFlow.java,v 1.1 2009/12/22 06:18:38 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getDataMappings <em>Data Mappings</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getExecution <em>Execution</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getPackageRef <em>Package Ref</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getInstanceDataField <em>Instance Data Field</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivitySetId <em>Start Activity Set Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivityId <em>Start Activity Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface SubFlow extends Serializable
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getActualParameters <em>Actual Parameters</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getActualParameters <em>Actual Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActualParameters()
   * @see #getActualParameters()
   * @see #setActualParameters(ActualParameters)
   * @generated
   */
  void unsetActualParameters();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getActualParameters <em>Actual Parameters</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getDataMappings <em>Data Mappings</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getDataMappings <em>Data Mappings</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataMappings()
   * @see #getDataMappings()
   * @see #setDataMappings(DataMappings)
   * @generated
   */
  void unsetDataMappings();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getDataMappings <em>Data Mappings</em>}' containment reference is set.
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Used in XPDL and BPMN. In BPMN is equivalent to ProcessRef attribute.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #setId(String)
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getId <em>Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getName <em>Name</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Execution</b></em>' attribute.
   * The default value is <code>"SYNCHR"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Execution</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Execution</em>' attribute.
   * @see #isSetExecution()
   * @see #unsetExecution()
   * @see #setExecution(String)
   * @generated
   */
  String getExecution();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getExecution <em>Execution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execution</em>' attribute.
   * @see #isSetExecution()
   * @see #unsetExecution()
   * @see #getExecution()
   * @generated
   */
  void setExecution(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getExecution <em>Execution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExecution()
   * @see #getExecution()
   * @see #setExecution(String)
   * @generated
   */
  void unsetExecution();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getExecution <em>Execution</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Execution</em>' attribute is set.
   * @see #unsetExecution()
   * @see #getExecution()
   * @see #setExecution(String)
   * @generated
   */
  boolean isSetExecution();

  /**
   * Returns the value of the '<em><b>Package Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: needed for independent subprocess
   * <!-- end-model-doc -->
   * @return the value of the '<em>Package Ref</em>' attribute.
   * @see #isSetPackageRef()
   * @see #unsetPackageRef()
   * @see #setPackageRef(String)
   * @generated
   */
  String getPackageRef();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getPackageRef <em>Package Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package Ref</em>' attribute.
   * @see #isSetPackageRef()
   * @see #unsetPackageRef()
   * @see #getPackageRef()
   * @generated
   */
  void setPackageRef(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getPackageRef <em>Package Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPackageRef()
   * @see #getPackageRef()
   * @see #setPackageRef(String)
   * @generated
   */
  void unsetPackageRef();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getPackageRef <em>Package Ref</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Package Ref</em>' attribute is set.
   * @see #unsetPackageRef()
   * @see #getPackageRef()
   * @see #setPackageRef(String)
   * @generated
   */
  boolean isSetPackageRef();

  /**
   * Returns the value of the '<em><b>Instance Data Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Used to store the instance id of the subflow instantiated by the activity. This is then available later on (e.g. for correlation, messaging etc.) especially in the case of asynchronous invocation.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Instance Data Field</em>' attribute.
   * @see #isSetInstanceDataField()
   * @see #unsetInstanceDataField()
   * @see #setInstanceDataField(String)
   * @generated
   */
  String getInstanceDataField();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getInstanceDataField <em>Instance Data Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance Data Field</em>' attribute.
   * @see #isSetInstanceDataField()
   * @see #unsetInstanceDataField()
   * @see #getInstanceDataField()
   * @generated
   */
  void setInstanceDataField(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getInstanceDataField <em>Instance Data Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetInstanceDataField()
   * @see #getInstanceDataField()
   * @see #setInstanceDataField(String)
   * @generated
   */
  void unsetInstanceDataField();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getInstanceDataField <em>Instance Data Field</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Instance Data Field</em>' attribute is set.
   * @see #unsetInstanceDataField()
   * @see #getInstanceDataField()
   * @see #setInstanceDataField(String)
   * @generated
   */
  boolean isSetInstanceDataField();

  /**
   * Returns the value of the '<em><b>Start Activity Set Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Activity Set Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Activity Set Id</em>' attribute.
   * @see #isSetStartActivitySetId()
   * @see #unsetStartActivitySetId()
   * @see #setStartActivitySetId(String)
   * @generated
   */
  String getStartActivitySetId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivitySetId <em>Start Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Activity Set Id</em>' attribute.
   * @see #isSetStartActivitySetId()
   * @see #unsetStartActivitySetId()
   * @see #getStartActivitySetId()
   * @generated
   */
  void setStartActivitySetId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivitySetId <em>Start Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartActivitySetId()
   * @see #getStartActivitySetId()
   * @see #setStartActivitySetId(String)
   * @generated
   */
  void unsetStartActivitySetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivitySetId <em>Start Activity Set Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Activity Set Id</em>' attribute is set.
   * @see #unsetStartActivitySetId()
   * @see #getStartActivitySetId()
   * @see #setStartActivitySetId(String)
   * @generated
   */
  boolean isSetStartActivitySetId();

  /**
   * Returns the value of the '<em><b>Start Activity Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Activity Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Activity Id</em>' attribute.
   * @see #isSetStartActivityId()
   * @see #unsetStartActivityId()
   * @see #setStartActivityId(String)
   * @generated
   */
  String getStartActivityId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivityId <em>Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Activity Id</em>' attribute.
   * @see #isSetStartActivityId()
   * @see #unsetStartActivityId()
   * @see #getStartActivityId()
   * @generated
   */
  void setStartActivityId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivityId <em>Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartActivityId()
   * @see #getStartActivityId()
   * @see #setStartActivityId(String)
   * @generated
   */
  void unsetStartActivityId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow#getStartActivityId <em>Start Activity Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Activity Id</em>' attribute is set.
   * @see #unsetStartActivityId()
   * @see #getStartActivityId()
   * @see #setStartActivityId(String)
   * @generated
   */
  boolean isSetStartActivityId();

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

} // SubFlow
