/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransitionRestrictions.java,v 1.1 2009/12/22 06:18:06 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

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
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestrictions#getTransitionRestriction <em>Transition Restriction</em>}</li>
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
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction}.
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

} // TransitionRestrictions
