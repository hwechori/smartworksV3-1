/**
 * <copyright>
 * </copyright>
 *
 * $Id: Activities.java,v 1.1 2009/12/22 06:18:09 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activities#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Activities extends Serializable
{
  /**
   * Returns the value of the '<em><b>Activity</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity</em>' containment reference list.
   * @generated
   */
  List getActivity();

} // Activities
