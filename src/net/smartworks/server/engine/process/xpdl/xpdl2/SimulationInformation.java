/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimulationInformation.java,v 1.1 2009/12/22 06:18:24 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getCost <em>Cost</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getTimeEstimation <em>Time Estimation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getInstantiation <em>Instantiation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface SimulationInformation extends Serializable
{
  /**
   * Returns the value of the '<em><b>Cost</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cost</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cost</em>' containment reference.
   * @see #isSetCost()
   * @see #unsetCost()
   * @see #setCost(Cost)
   * @generated
   */
  Cost getCost();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getCost <em>Cost</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cost</em>' containment reference.
   * @see #isSetCost()
   * @see #unsetCost()
   * @see #getCost()
   * @generated
   */
  void setCost(Cost value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getCost <em>Cost</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCost()
   * @see #getCost()
   * @see #setCost(Cost)
   * @generated
   */
  void unsetCost();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getCost <em>Cost</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Cost</em>' containment reference is set.
   * @see #unsetCost()
   * @see #getCost()
   * @see #setCost(Cost)
   * @generated
   */
  boolean isSetCost();

  /**
   * Returns the value of the '<em><b>Time Estimation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time Estimation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Estimation</em>' containment reference.
   * @see #isSetTimeEstimation()
   * @see #unsetTimeEstimation()
   * @see #setTimeEstimation(TimeEstimation)
   * @generated
   */
  TimeEstimation getTimeEstimation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getTimeEstimation <em>Time Estimation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Estimation</em>' containment reference.
   * @see #isSetTimeEstimation()
   * @see #unsetTimeEstimation()
   * @see #getTimeEstimation()
   * @generated
   */
  void setTimeEstimation(TimeEstimation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getTimeEstimation <em>Time Estimation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTimeEstimation()
   * @see #getTimeEstimation()
   * @see #setTimeEstimation(TimeEstimation)
   * @generated
   */
  void unsetTimeEstimation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getTimeEstimation <em>Time Estimation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Time Estimation</em>' containment reference is set.
   * @see #unsetTimeEstimation()
   * @see #getTimeEstimation()
   * @see #setTimeEstimation(TimeEstimation)
   * @generated
   */
  boolean isSetTimeEstimation();

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
   * Returns the value of the '<em><b>Instantiation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instantiation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instantiation</em>' attribute.
   * @see #isSetInstantiation()
   * @see #unsetInstantiation()
   * @see #setInstantiation(String)
   * @generated
   */
  String getInstantiation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getInstantiation <em>Instantiation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instantiation</em>' attribute.
   * @see #isSetInstantiation()
   * @see #unsetInstantiation()
   * @see #getInstantiation()
   * @generated
   */
  void setInstantiation(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getInstantiation <em>Instantiation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetInstantiation()
   * @see #getInstantiation()
   * @see #setInstantiation(String)
   * @generated
   */
  void unsetInstantiation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.SimulationInformation#getInstantiation <em>Instantiation</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Instantiation</em>' attribute is set.
   * @see #unsetInstantiation()
   * @see #getInstantiation()
   * @see #setInstantiation(String)
   * @generated
   */
  boolean isSetInstantiation();

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

} // SimulationInformation
