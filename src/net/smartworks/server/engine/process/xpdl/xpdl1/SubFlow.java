/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubFlow.java,v 1.1 2009/12/22 06:18:00 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getExecution <em>Execution</em>}</li>
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getActualParameters <em>Actual Parameters</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getActualParameters <em>Actual Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActualParameters()
   * @see #getActualParameters()
   * @see #setActualParameters(ActualParameters)
   * @generated
   */
  void unsetActualParameters();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getActualParameters <em>Actual Parameters</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getId <em>Id</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Execution</b></em>' attribute.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getExecution <em>Execution</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getExecution <em>Execution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExecution()
   * @see #getExecution()
   * @see #setExecution(String)
   * @generated
   */
  void unsetExecution();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow#getExecution <em>Execution</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Execution</em>' attribute is set.
   * @see #unsetExecution()
   * @see #getExecution()
   * @see #setExecution(String)
   * @generated
   */
  boolean isSetExecution();

} // SubFlow
