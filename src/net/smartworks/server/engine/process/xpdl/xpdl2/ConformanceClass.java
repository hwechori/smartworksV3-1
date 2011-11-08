/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConformanceClass.java,v 1.1 2009/12/22 06:18:30 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conformance Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConformanceClass#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConformanceClass#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ConformanceClass extends Serializable
{
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
   * Returns the value of the '<em><b>Graph Conformance</b></em>' attribute.
   * The default value is <code>"NON_BLOCKED"</code>.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetGraphConformance()
   * @see #getGraphConformance()
   * @see #setGraphConformance(String)
   * @generated
   */
  void unsetGraphConformance();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConformanceClass#getGraphConformance <em>Graph Conformance</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Graph Conformance</em>' attribute is set.
   * @see #unsetGraphConformance()
   * @see #getGraphConformance()
   * @see #setGraphConformance(String)
   * @generated
   */
  boolean isSetGraphConformance();

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

} // ConformanceClass
