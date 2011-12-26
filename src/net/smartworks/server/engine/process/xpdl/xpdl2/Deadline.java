/**
 * <copyright>
 * </copyright>
 *
 * $Id: Deadline.java,v 1.1 2009/12/22 06:18:17 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deadline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getDeadlineDuration <em>Deadline Duration</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExceptionName <em>Exception Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExecution <em>Execution</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Deadline extends Serializable
{
  /**
   * Returns the value of the '<em><b>Deadline Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deadline Duration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deadline Duration</em>' containment reference.
   * @see #isSetDeadlineDuration()
   * @see #unsetDeadlineDuration()
   * @see #setDeadlineDuration(ExpressionType)
   * @generated
   */
  ExpressionType getDeadlineDuration();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getDeadlineDuration <em>Deadline Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deadline Duration</em>' containment reference.
   * @see #isSetDeadlineDuration()
   * @see #unsetDeadlineDuration()
   * @see #getDeadlineDuration()
   * @generated
   */
  void setDeadlineDuration(ExpressionType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getDeadlineDuration <em>Deadline Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDeadlineDuration()
   * @see #getDeadlineDuration()
   * @see #setDeadlineDuration(ExpressionType)
   * @generated
   */
  void unsetDeadlineDuration();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getDeadlineDuration <em>Deadline Duration</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Deadline Duration</em>' containment reference is set.
   * @see #unsetDeadlineDuration()
   * @see #getDeadlineDuration()
   * @see #setDeadlineDuration(ExpressionType)
   * @generated
   */
  boolean isSetDeadlineDuration();

  /**
   * Returns the value of the '<em><b>Exception Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This name should match that specified in Transition/Condition/Expression
   * <!-- end-model-doc -->
   * @return the value of the '<em>Exception Name</em>' containment reference.
   * @see #isSetExceptionName()
   * @see #unsetExceptionName()
   * @see #setExceptionName(ExceptionName)
   * @generated
   */
  ExceptionName getExceptionName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExceptionName <em>Exception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Name</em>' containment reference.
   * @see #isSetExceptionName()
   * @see #unsetExceptionName()
   * @see #getExceptionName()
   * @generated
   */
  void setExceptionName(ExceptionName value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExceptionName <em>Exception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExceptionName()
   * @see #getExceptionName()
   * @see #setExceptionName(ExceptionName)
   * @generated
   */
  void unsetExceptionName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExceptionName <em>Exception Name</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Exception Name</em>' containment reference is set.
   * @see #unsetExceptionName()
   * @see #getExceptionName()
   * @see #setExceptionName(ExceptionName)
   * @generated
   */
  boolean isSetExceptionName();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExecution <em>Execution</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExecution <em>Execution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExecution()
   * @see #getExecution()
   * @see #setExecution(String)
   * @generated
   */
  void unsetExecution();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Deadline#getExecution <em>Execution</em>}' attribute is set.
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

} // Deadline
