/**
 * <copyright>
 * </copyright>
 *
 * $Id: Object.java,v 1.1 2009/12/22 06:18:15 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getCategories <em>Categories</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Object extends Serializable
{
  /**
   * Returns the value of the '<em><b>Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Categories</em>' containment reference.
   * @see #isSetCategories()
   * @see #unsetCategories()
   * @see #setCategories(Categories)
   * @generated
   */
  Categories getCategories();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getCategories <em>Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Categories</em>' containment reference.
   * @see #isSetCategories()
   * @see #unsetCategories()
   * @see #getCategories()
   * @generated
   */
  void setCategories(Categories value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getCategories <em>Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCategories()
   * @see #getCategories()
   * @see #setCategories(Categories)
   * @generated
   */
  void unsetCategories();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getCategories <em>Categories</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Categories</em>' containment reference is set.
   * @see #unsetCategories()
   * @see #getCategories()
   * @see #setCategories(Categories)
   * @generated
   */
  boolean isSetCategories();

  /**
   * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' containment reference.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  Documentation getDocumentation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Documentation</em>' containment reference.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @generated
   */
  void setDocumentation(Documentation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  void unsetDocumentation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getDocumentation <em>Documentation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Documentation</em>' containment reference is set.
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  boolean isSetDocumentation();

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
   * This identifies any Object in the BPMN diagram.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #setId(String)
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getId <em>Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Object#getName <em>Name</em>}' attribute is set.
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

} // Object
