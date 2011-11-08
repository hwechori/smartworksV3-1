/**
 * <copyright>
 * </copyright>
 *
 * $Id: Xpression.java,v 1.1 2009/12/22 06:17:59 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xpression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Xpression#getMixed <em>Mixed</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Xpression#getGroup <em>Group</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Xpression#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Xpression extends Serializable
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @generated
   */
  Sequence getMixed();

  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @generated
   */
  Sequence getGroup();

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

} // Xpression
