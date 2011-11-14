/**
 * <copyright>
 * </copyright>
 *
 * $Id: BlockActivity.java,v 1.1 2009/12/22 06:18:05 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity#getBlockId <em>Block Id</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface BlockActivity extends Serializable
{
  /**
   * Returns the value of the '<em><b>Block Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block Id</em>' attribute.
   * @see #isSetBlockId()
   * @see #unsetBlockId()
   * @see #setBlockId(String)
   * @generated
   */
  String getBlockId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity#getBlockId <em>Block Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block Id</em>' attribute.
   * @see #isSetBlockId()
   * @see #unsetBlockId()
   * @see #getBlockId()
   * @generated
   */
  void setBlockId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity#getBlockId <em>Block Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBlockId()
   * @see #getBlockId()
   * @see #setBlockId(String)
   * @generated
   */
  void unsetBlockId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity#getBlockId <em>Block Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Block Id</em>' attribute is set.
   * @see #unsetBlockId()
   * @see #getBlockId()
   * @see #setBlockId(String)
   * @generated
   */
  boolean isSetBlockId();

} // BlockActivity
