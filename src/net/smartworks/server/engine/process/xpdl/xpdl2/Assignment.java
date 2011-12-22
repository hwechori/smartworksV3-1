/**
 * <copyright>
 * </copyright>
 *
 * $Id: Assignment.java,v 1.1 2009/12/22 06:18:17 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getTarget <em>Target</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getExpression <em>Expression</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getAssignTime <em>Assign Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Assignment extends Serializable
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  lvalue expression of the assignment, in XPDL may be the name of a DataField, in BPMN name of a Property, in XPATH a reference
   * <!-- end-model-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #isSetTarget()
   * @see #unsetTarget()
   * @see #setTarget(ExpressionType)
   * @generated
   */
  ExpressionType getTarget();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #isSetTarget()
   * @see #unsetTarget()
   * @see #getTarget()
   * @generated
   */
  void setTarget(ExpressionType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTarget()
   * @see #getTarget()
   * @see #setTarget(ExpressionType)
   * @generated
   */
  void unsetTarget();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getTarget <em>Target</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Target</em>' containment reference is set.
   * @see #unsetTarget()
   * @see #getTarget()
   * @see #setTarget(ExpressionType)
   * @generated
   */
  boolean isSetTarget();

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * rvalue expression of the assignment
   * <!-- end-model-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #isSetExpression()
   * @see #unsetExpression()
   * @see #setExpression(ExpressionType)
   * @generated
   */
  ExpressionType getExpression();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #isSetExpression()
   * @see #unsetExpression()
   * @see #getExpression()
   * @generated
   */
  void setExpression(ExpressionType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExpression()
   * @see #getExpression()
   * @see #setExpression(ExpressionType)
   * @generated
   */
  void unsetExpression();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getExpression <em>Expression</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Expression</em>' containment reference is set.
   * @see #unsetExpression()
   * @see #getExpression()
   * @see #setExpression(ExpressionType)
   * @generated
   */
  boolean isSetExpression();

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
   * Returns the value of the '<em><b>Assign Time</b></em>' attribute.
   * The default value is <code>"Start"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign Time</em>' attribute.
   * @see #isSetAssignTime()
   * @see #unsetAssignTime()
   * @see #setAssignTime(String)
   * @generated
   */
  String getAssignTime();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getAssignTime <em>Assign Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign Time</em>' attribute.
   * @see #isSetAssignTime()
   * @see #unsetAssignTime()
   * @see #getAssignTime()
   * @generated
   */
  void setAssignTime(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getAssignTime <em>Assign Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAssignTime()
   * @see #getAssignTime()
   * @see #setAssignTime(String)
   * @generated
   */
  void unsetAssignTime();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Assignment#getAssignTime <em>Assign Time</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Assign Time</em>' attribute is set.
   * @see #unsetAssignTime()
   * @see #getAssignTime()
   * @see #setAssignTime(String)
   * @generated
   */
  boolean isSetAssignTime();

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

} // Assignment
