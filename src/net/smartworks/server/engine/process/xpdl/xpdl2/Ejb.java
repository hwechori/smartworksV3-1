/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ejb.java,v 1.1 2009/12/22 06:18:37 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ejb</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getHomeClass <em>Home Class</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getMethod <em>Method</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Ejb extends Serializable
{
  /**
   * Returns the value of the '<em><b>Jndi Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jndi Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jndi Name</em>' containment reference.
   * @see #isSetJndiName()
   * @see #unsetJndiName()
   * @see #setJndiName(JndiName)
   * @generated
   */
  JndiName getJndiName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getJndiName <em>Jndi Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Jndi Name</em>' containment reference.
   * @see #isSetJndiName()
   * @see #unsetJndiName()
   * @see #getJndiName()
   * @generated
   */
  void setJndiName(JndiName value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getJndiName <em>Jndi Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetJndiName()
   * @see #getJndiName()
   * @see #setJndiName(JndiName)
   * @generated
   */
  void unsetJndiName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getJndiName <em>Jndi Name</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Jndi Name</em>' containment reference is set.
   * @see #unsetJndiName()
   * @see #getJndiName()
   * @see #setJndiName(JndiName)
   * @generated
   */
  boolean isSetJndiName();

  /**
   * Returns the value of the '<em><b>Home Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Home Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Home Class</em>' containment reference.
   * @see #isSetHomeClass()
   * @see #unsetHomeClass()
   * @see #setHomeClass(HomeClass)
   * @generated
   */
  HomeClass getHomeClass();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getHomeClass <em>Home Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Home Class</em>' containment reference.
   * @see #isSetHomeClass()
   * @see #unsetHomeClass()
   * @see #getHomeClass()
   * @generated
   */
  void setHomeClass(HomeClass value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getHomeClass <em>Home Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetHomeClass()
   * @see #getHomeClass()
   * @see #setHomeClass(HomeClass)
   * @generated
   */
  void unsetHomeClass();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getHomeClass <em>Home Class</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Home Class</em>' containment reference is set.
   * @see #unsetHomeClass()
   * @see #getHomeClass()
   * @see #setHomeClass(HomeClass)
   * @generated
   */
  boolean isSetHomeClass();

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
   * @see #setMethod(Method1)
   * @generated
   */
  Method1 getMethod();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getMethod <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' containment reference.
   * @see #isSetMethod()
   * @see #unsetMethod()
   * @see #getMethod()
   * @generated
   */
  void setMethod(Method1 value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getMethod <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMethod()
   * @see #getMethod()
   * @see #setMethod(Method1)
   * @generated
   */
  void unsetMethod();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Ejb#getMethod <em>Method</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Method</em>' containment reference is set.
   * @see #unsetMethod()
   * @see #getMethod()
   * @see #setMethod(Method1)
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

} // Ejb
