/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartMode.java,v 1.1 2009/12/22 06:18:07 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getAutomatic <em>Automatic</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getManual <em>Manual</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface StartMode extends Serializable
{
  /**
   * Returns the value of the '<em><b>Automatic</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Automatic</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Automatic</em>' containment reference.
   * @see #isSetAutomatic()
   * @see #unsetAutomatic()
   * @see #setAutomatic(Automatic)
   * @generated
   */
  Automatic getAutomatic();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getAutomatic <em>Automatic</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Automatic</em>' containment reference.
   * @see #isSetAutomatic()
   * @see #unsetAutomatic()
   * @see #getAutomatic()
   * @generated
   */
  void setAutomatic(Automatic value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getAutomatic <em>Automatic</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAutomatic()
   * @see #getAutomatic()
   * @see #setAutomatic(Automatic)
   * @generated
   */
  void unsetAutomatic();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getAutomatic <em>Automatic</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Automatic</em>' containment reference is set.
   * @see #unsetAutomatic()
   * @see #getAutomatic()
   * @see #setAutomatic(Automatic)
   * @generated
   */
  boolean isSetAutomatic();

  /**
   * Returns the value of the '<em><b>Manual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manual</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Manual</em>' containment reference.
   * @see #isSetManual()
   * @see #unsetManual()
   * @see #setManual(Manual)
   * @generated
   */
  Manual getManual();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getManual <em>Manual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Manual</em>' containment reference.
   * @see #isSetManual()
   * @see #unsetManual()
   * @see #getManual()
   * @generated
   */
  void setManual(Manual value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getManual <em>Manual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetManual()
   * @see #getManual()
   * @see #setManual(Manual)
   * @generated
   */
  void unsetManual();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.StartMode#getManual <em>Manual</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Manual</em>' containment reference is set.
   * @see #unsetManual()
   * @see #getManual()
   * @see #setManual(Manual)
   * @generated
   */
  boolean isSetManual();

} // StartMode
