/**
 * <copyright>
 * </copyright>
 *
 * $Id: Form.java,v 1.1 2009/12/22 06:18:19 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Form</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Form#getFormLayout <em>Form Layout</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Form#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Form#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Form extends Serializable
{
  /**
   * Returns the value of the '<em><b>Form Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Form Layout</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Form Layout</em>' containment reference.
   * @see #isSetFormLayout()
   * @see #unsetFormLayout()
   * @see #setFormLayout(FormLayout)
   * @generated
   */
  FormLayout getFormLayout();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Form#getFormLayout <em>Form Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Form Layout</em>' containment reference.
   * @see #isSetFormLayout()
   * @see #unsetFormLayout()
   * @see #getFormLayout()
   * @generated
   */
  void setFormLayout(FormLayout value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Form#getFormLayout <em>Form Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFormLayout()
   * @see #getFormLayout()
   * @see #setFormLayout(FormLayout)
   * @generated
   */
  void unsetFormLayout();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Form#getFormLayout <em>Form Layout</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Form Layout</em>' containment reference is set.
   * @see #unsetFormLayout()
   * @see #getFormLayout()
   * @see #setFormLayout(FormLayout)
   * @generated
   */
  boolean isSetFormLayout();

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

} // Form
