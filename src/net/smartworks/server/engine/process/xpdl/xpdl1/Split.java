/**
 * <copyright>
 * </copyright>
 *
 * $Id: Split.java,v 1.1 2009/12/22 06:18:06 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getTransitionRefs <em>Transition Refs</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getType_ <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Split extends Serializable
{
  /**
   * Returns the value of the '<em><b>Transition Refs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Refs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Refs</em>' containment reference.
   * @see #isSetTransitionRefs()
   * @see #unsetTransitionRefs()
   * @see #setTransitionRefs(TransitionRefs)
   * @generated
   */
  TransitionRefs getTransitionRefs();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getTransitionRefs <em>Transition Refs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transition Refs</em>' containment reference.
   * @see #isSetTransitionRefs()
   * @see #unsetTransitionRefs()
   * @see #getTransitionRefs()
   * @generated
   */
  void setTransitionRefs(TransitionRefs value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getTransitionRefs <em>Transition Refs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitionRefs()
   * @see #getTransitionRefs()
   * @see #setTransitionRefs(TransitionRefs)
   * @generated
   */
  void unsetTransitionRefs();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getTransitionRefs <em>Transition Refs</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transition Refs</em>' containment reference is set.
   * @see #unsetTransitionRefs()
   * @see #getTransitionRefs()
   * @see #setTransitionRefs(TransitionRefs)
   * @generated
   */
  boolean isSetTransitionRefs();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #isSetType()
   * @see #unsetType()
   * @see #setType(String)
   * @generated
   */
  String getType_();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getType_ <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #isSetType()
   * @see #unsetType()
   * @see #getType_()
   * @generated
   */
  void setType(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getType_ <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetType()
   * @see #getType_()
   * @see #setType(String)
   * @generated
   */
  void unsetType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Split#getType_ <em>Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Type</em>' attribute is set.
   * @see #unsetType()
   * @see #getType_()
   * @see #setType(String)
   * @generated
   */
  boolean isSetType();

} // Split
