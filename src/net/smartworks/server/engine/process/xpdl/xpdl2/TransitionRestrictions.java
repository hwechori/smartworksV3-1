/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransitionRestrictions.java,v 1.1 2009/12/22 06:18:10 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Restrictions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TransitionRestrictions#getTransitionRestriction <em>Transition Restriction</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TransitionRestrictions#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.TransitionRestrictions#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TransitionRestrictions extends Serializable
{
  /**
   * Returns the value of the '<em><b>Transition Restriction</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl2.TransitionRestriction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Restriction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Restriction</em>' containment reference list.
   * @generated
   */
  List getTransitionRestriction();

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

} // TransitionRestrictions
