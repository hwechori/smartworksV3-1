/**
 * <copyright>
 * </copyright>
 *
 * $Id: Pojo.java,v 1.1 2009/12/22 06:18:23 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pojo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getClass_ <em>Class</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getMethod <em>Method</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Pojo extends Serializable
{
  /**
   * Returns the value of the '<em><b>Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class</em>' containment reference.
   * @see #isSetClass()
   * @see #unsetClass()
   * @see #setClass(net.smartworks.server.engine.process.xpdl.xpdl2.Class)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.Class getClass_();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getClass_ <em>Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class</em>' containment reference.
   * @see #isSetClass()
   * @see #unsetClass()
   * @see #getClass_()
   * @generated
   */
  void setClass(net.smartworks.server.engine.process.xpdl.xpdl2.Class value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getClass_ <em>Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetClass()
   * @see #getClass_()
   * @see #setClass(net.smartworks.server.engine.process.xpdl.xpdl2.Class)
   * @generated
   */
  void unsetClass();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getClass_ <em>Class</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Class</em>' containment reference is set.
   * @see #unsetClass()
   * @see #getClass_()
   * @see #setClass(net.smartworks.server.engine.process.xpdl.xpdl2.Class)
   * @generated
   */
  boolean isSetClass();

  /**
   * Returns the value of the '<em><b>Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' containment reference.
   * @see #isSetMethod()
   * @see #unsetMethod()
   * @see #setMethod(Method)
   * @generated
   */
  Method getMethod();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getMethod <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' containment reference.
   * @see #isSetMethod()
   * @see #unsetMethod()
   * @see #getMethod()
   * @generated
   */
  void setMethod(Method value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getMethod <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMethod()
   * @see #getMethod()
   * @see #setMethod(Method)
   * @generated
   */
  void unsetMethod();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Pojo#getMethod <em>Method</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Method</em>' containment reference is set.
   * @see #unsetMethod()
   * @see #getMethod()
   * @see #setMethod(Method)
   * @generated
   */
  boolean isSetMethod();

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

} // Pojo
