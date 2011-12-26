/**
 * <copyright>
 * </copyright>
 *
 * $Id: Transaction.java,v 1.1 2009/12/22 06:18:39 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionProtocol <em>Transaction Protocol</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionMethod <em>Transaction Method</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Transaction extends Serializable
{
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
   * Returns the value of the '<em><b>Transaction Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transaction Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transaction Id</em>' attribute.
   * @see #isSetTransactionId()
   * @see #unsetTransactionId()
   * @see #setTransactionId(String)
   * @generated
   */
  String getTransactionId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionId <em>Transaction Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transaction Id</em>' attribute.
   * @see #isSetTransactionId()
   * @see #unsetTransactionId()
   * @see #getTransactionId()
   * @generated
   */
  void setTransactionId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionId <em>Transaction Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransactionId()
   * @see #getTransactionId()
   * @see #setTransactionId(String)
   * @generated
   */
  void unsetTransactionId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionId <em>Transaction Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transaction Id</em>' attribute is set.
   * @see #unsetTransactionId()
   * @see #getTransactionId()
   * @see #setTransactionId(String)
   * @generated
   */
  boolean isSetTransactionId();

  /**
   * Returns the value of the '<em><b>Transaction Protocol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transaction Protocol</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transaction Protocol</em>' attribute.
   * @see #isSetTransactionProtocol()
   * @see #unsetTransactionProtocol()
   * @see #setTransactionProtocol(String)
   * @generated
   */
  String getTransactionProtocol();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionProtocol <em>Transaction Protocol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transaction Protocol</em>' attribute.
   * @see #isSetTransactionProtocol()
   * @see #unsetTransactionProtocol()
   * @see #getTransactionProtocol()
   * @generated
   */
  void setTransactionProtocol(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionProtocol <em>Transaction Protocol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransactionProtocol()
   * @see #getTransactionProtocol()
   * @see #setTransactionProtocol(String)
   * @generated
   */
  void unsetTransactionProtocol();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionProtocol <em>Transaction Protocol</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transaction Protocol</em>' attribute is set.
   * @see #unsetTransactionProtocol()
   * @see #getTransactionProtocol()
   * @see #setTransactionProtocol(String)
   * @generated
   */
  boolean isSetTransactionProtocol();

  /**
   * Returns the value of the '<em><b>Transaction Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transaction Method</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transaction Method</em>' attribute.
   * @see #isSetTransactionMethod()
   * @see #unsetTransactionMethod()
   * @see #setTransactionMethod(String)
   * @generated
   */
  String getTransactionMethod();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionMethod <em>Transaction Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transaction Method</em>' attribute.
   * @see #isSetTransactionMethod()
   * @see #unsetTransactionMethod()
   * @see #getTransactionMethod()
   * @generated
   */
  void setTransactionMethod(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionMethod <em>Transaction Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransactionMethod()
   * @see #getTransactionMethod()
   * @see #setTransactionMethod(String)
   * @generated
   */
  void unsetTransactionMethod();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Transaction#getTransactionMethod <em>Transaction Method</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transaction Method</em>' attribute is set.
   * @see #unsetTransactionMethod()
   * @see #getTransactionMethod()
   * @see #setTransactionMethod(String)
   * @generated
   */
  boolean isSetTransactionMethod();

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

} // Transaction
