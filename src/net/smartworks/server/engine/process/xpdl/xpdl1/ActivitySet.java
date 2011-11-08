/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivitySet.java,v 1.1 2009/12/22 06:18:06 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ActivitySet extends Serializable
{
  /**
   * Returns the value of the '<em><b>Activities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activities</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activities</em>' containment reference.
   * @see #isSetActivities()
   * @see #unsetActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  Activities getActivities();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getActivities <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activities</em>' containment reference.
   * @see #isSetActivities()
   * @see #unsetActivities()
   * @see #getActivities()
   * @generated
   */
  void setActivities(Activities value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getActivities <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActivities()
   * @see #getActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  void unsetActivities();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getActivities <em>Activities</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Activities</em>' containment reference is set.
   * @see #unsetActivities()
   * @see #getActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  boolean isSetActivities();

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference.
   * @see #isSetTransitions()
   * @see #unsetTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  Transitions getTransitions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getTransitions <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transitions</em>' containment reference.
   * @see #isSetTransitions()
   * @see #unsetTransitions()
   * @see #getTransitions()
   * @generated
   */
  void setTransitions(Transitions value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getTransitions <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitions()
   * @see #getTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  void unsetTransitions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getTransitions <em>Transitions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transitions</em>' containment reference is set.
   * @see #unsetTransitions()
   * @see #getTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  boolean isSetTransitions();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #setId(String)
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet#getId <em>Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Id</em>' attribute is set.
   * @see #unsetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  boolean isSetId();

} // ActivitySet
