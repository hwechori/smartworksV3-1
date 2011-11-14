/**
 * <copyright>
 * </copyright>
 *
 * $Id: FormalParameters.java,v 1.1 2009/12/22 06:18:17 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getFormalParameter <em>Formal Parameter</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getFormalParameter1 <em>Formal Parameter1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface FormalParameters extends Serializable
{
  /**
   * Returns the value of the '<em><b>Formal Parameter</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameter</em>' containment reference list.
   * @generated
   */
  List getFormalParameter();

  /**
   * Returns the value of the '<em><b>Formal Parameter1</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameter1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameter1</em>' containment reference list.
   * @generated
   */
  List getFormalParameter1();

  /**
   * Returns the value of the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extensions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extensions</em>' containment reference.
   * @see #isSetExtensions()
   * @see #unsetExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  DataObject getExtensions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getExtensions <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extensions</em>' containment reference.
   * @see #isSetExtensions()
   * @see #unsetExtensions()
   * @see #getExtensions()
   * @generated
   */
  void setExtensions(DataObject value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getExtensions <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtensions()
   * @see #getExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  void unsetExtensions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters#getExtensions <em>Extensions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Extensions</em>' containment reference is set.
   * @see #unsetExtensions()
   * @see #getExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  boolean isSetExtensions();

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

} // FormalParameters
