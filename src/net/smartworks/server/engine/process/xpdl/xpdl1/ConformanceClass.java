/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConformanceClass.java,v 1.1 2009/12/22 06:18:05 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conformance Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ConformanceClass extends Serializable
{
  /**
   * Returns the value of the '<em><b>Graph Conformance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Graph Conformance</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Graph Conformance</em>' attribute.
   * @see #isSetGraphConformance()
   * @see #unsetGraphConformance()
   * @see #setGraphConformance(String)
   * @generated
   */
  String getGraphConformance();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Graph Conformance</em>' attribute.
   * @see #isSetGraphConformance()
   * @see #unsetGraphConformance()
   * @see #getGraphConformance()
   * @generated
   */
  void setGraphConformance(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetGraphConformance()
   * @see #getGraphConformance()
   * @see #setGraphConformance(String)
   * @generated
   */
  void unsetGraphConformance();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Graph Conformance</em>' attribute is set.
   * @see #unsetGraphConformance()
   * @see #getGraphConformance()
   * @see #setGraphConformance(String)
   * @generated
   */
  boolean isSetGraphConformance();

} // ConformanceClass
