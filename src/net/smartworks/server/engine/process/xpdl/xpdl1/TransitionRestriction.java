/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransitionRestriction.java,v 1.1 2009/12/22 06:18:02 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getJoin <em>Join</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getSplit <em>Split</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TransitionRestriction extends Serializable
{
  /**
   * Returns the value of the '<em><b>Join</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Join</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Join</em>' containment reference.
   * @see #isSetJoin()
   * @see #unsetJoin()
   * @see #setJoin(Join)
   * @generated
   */
  Join getJoin();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getJoin <em>Join</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Join</em>' containment reference.
   * @see #isSetJoin()
   * @see #unsetJoin()
   * @see #getJoin()
   * @generated
   */
  void setJoin(Join value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getJoin <em>Join</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetJoin()
   * @see #getJoin()
   * @see #setJoin(Join)
   * @generated
   */
  void unsetJoin();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getJoin <em>Join</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Join</em>' containment reference is set.
   * @see #unsetJoin()
   * @see #getJoin()
   * @see #setJoin(Join)
   * @generated
   */
  boolean isSetJoin();

  /**
   * Returns the value of the '<em><b>Split</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Split</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Split</em>' containment reference.
   * @see #isSetSplit()
   * @see #unsetSplit()
   * @see #setSplit(Split)
   * @generated
   */
  Split getSplit();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getSplit <em>Split</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Split</em>' containment reference.
   * @see #isSetSplit()
   * @see #unsetSplit()
   * @see #getSplit()
   * @generated
   */
  void setSplit(Split value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getSplit <em>Split</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSplit()
   * @see #getSplit()
   * @see #setSplit(Split)
   * @generated
   */
  void unsetSplit();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction#getSplit <em>Split</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Split</em>' containment reference is set.
   * @see #unsetSplit()
   * @see #getSplit()
   * @see #setSplit(Split)
   * @generated
   */
  boolean isSetSplit();

} // TransitionRestriction
