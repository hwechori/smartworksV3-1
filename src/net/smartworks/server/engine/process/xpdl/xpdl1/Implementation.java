/**
 * <copyright>
 * </copyright>
 *
 * $Id: Implementation.java,v 1.1 2009/12/22 06:18:02 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getNo <em>No</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getTool <em>Tool</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getSubFlow <em>Sub Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Implementation extends Serializable
{
  /**
   * Returns the value of the '<em><b>No</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>No</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>No</em>' containment reference.
   * @see #isSetNo()
   * @see #unsetNo()
   * @see #setNo(No)
   * @generated
   */
  No getNo();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getNo <em>No</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>No</em>' containment reference.
   * @see #isSetNo()
   * @see #unsetNo()
   * @see #getNo()
   * @generated
   */
  void setNo(No value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getNo <em>No</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNo()
   * @see #getNo()
   * @see #setNo(No)
   * @generated
   */
  void unsetNo();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getNo <em>No</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>No</em>' containment reference is set.
   * @see #unsetNo()
   * @see #getNo()
   * @see #setNo(No)
   * @generated
   */
  boolean isSetNo();

  /**
   * Returns the value of the '<em><b>Tool</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.Tool}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tool</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tool</em>' containment reference list.
   * @generated
   */
  List getTool();

  /**
   * Returns the value of the '<em><b>Sub Flow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Flow</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Flow</em>' containment reference.
   * @see #isSetSubFlow()
   * @see #unsetSubFlow()
   * @see #setSubFlow(SubFlow)
   * @generated
   */
  SubFlow getSubFlow();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getSubFlow <em>Sub Flow</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Flow</em>' containment reference.
   * @see #isSetSubFlow()
   * @see #unsetSubFlow()
   * @see #getSubFlow()
   * @generated
   */
  void setSubFlow(SubFlow value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getSubFlow <em>Sub Flow</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSubFlow()
   * @see #getSubFlow()
   * @see #setSubFlow(SubFlow)
   * @generated
   */
  void unsetSubFlow();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Implementation#getSubFlow <em>Sub Flow</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Sub Flow</em>' containment reference is set.
   * @see #unsetSubFlow()
   * @see #getSubFlow()
   * @see #setSubFlow(SubFlow)
   * @generated
   */
  boolean isSetSubFlow();

} // Implementation
