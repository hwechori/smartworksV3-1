/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransitionRefs.java,v 1.1 2009/12/22 06:18:01 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Refs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRefs#getTransitionRef <em>Transition Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TransitionRefs extends Serializable
{
  /**
   * Returns the value of the '<em><b>Transition Ref</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Ref</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Ref</em>' containment reference list.
   * @generated
   */
  List getTransitionRef();

} // TransitionRefs
