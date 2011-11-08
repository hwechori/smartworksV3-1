/**
 * <copyright>
 * </copyright>
 *
 * $Id: Deadline.java,v 1.1 2009/12/22 06:18:07 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import commonj.sdo.DataObject;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deadline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getDeadlineCondition <em>Deadline Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExceptionName <em>Exception Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExecution <em>Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Deadline extends Serializable
{
  /**
   * Returns the value of the '<em><b>Deadline Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deadline Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deadline Condition</em>' containment reference.
   * @see #isSetDeadlineCondition()
   * @see #unsetDeadlineCondition()
   * @see #setDeadlineCondition(DataObject)
   * @generated
   */
  DataObject getDeadlineCondition();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getDeadlineCondition <em>Deadline Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deadline Condition</em>' containment reference.
   * @see #isSetDeadlineCondition()
   * @see #unsetDeadlineCondition()
   * @see #getDeadlineCondition()
   * @generated
   */
  void setDeadlineCondition(DataObject value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getDeadlineCondition <em>Deadline Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDeadlineCondition()
   * @see #getDeadlineCondition()
   * @see #setDeadlineCondition(DataObject)
   * @generated
   */
  void unsetDeadlineCondition();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getDeadlineCondition <em>Deadline Condition</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Deadline Condition</em>' containment reference is set.
   * @see #unsetDeadlineCondition()
   * @see #getDeadlineCondition()
   * @see #setDeadlineCondition(DataObject)
   * @generated
   */
  boolean isSetDeadlineCondition();

  /**
   * Returns the value of the '<em><b>Exception Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception Name</em>' containment reference.
   * @see #isSetExceptionName()
   * @see #unsetExceptionName()
   * @see #setExceptionName(DataObject)
   * @generated
   */
  DataObject getExceptionName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExceptionName <em>Exception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Name</em>' containment reference.
   * @see #isSetExceptionName()
   * @see #unsetExceptionName()
   * @see #getExceptionName()
   * @generated
   */
  void setExceptionName(DataObject value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExceptionName <em>Exception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExceptionName()
   * @see #getExceptionName()
   * @see #setExceptionName(DataObject)
   * @generated
   */
  void unsetExceptionName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExceptionName <em>Exception Name</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Exception Name</em>' containment reference is set.
   * @see #unsetExceptionName()
   * @see #getExceptionName()
   * @see #setExceptionName(DataObject)
   * @generated
   */
  boolean isSetExceptionName();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExecution <em>Execution</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExecution <em>Execution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExecution()
   * @see #getExecution()
   * @see #setExecution(String)
   * @generated
   */
  void unsetExecution();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline#getExecution <em>Execution</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Execution</em>' attribute is set.
   * @see #unsetExecution()
   * @see #getExecution()
   * @see #setExecution(String)
   * @generated
   */
  boolean isSetExecution();

} // Deadline
