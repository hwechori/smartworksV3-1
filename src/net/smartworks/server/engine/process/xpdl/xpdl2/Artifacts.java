/**
 * <copyright>
 * </copyright>
 *
 * $Id: Artifacts.java,v 1.1 2009/12/22 06:18:17 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Artifacts</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Artifacts#getGroup <em>Group</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Artifacts#getArtifact <em>Artifact</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Artifacts#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Artifacts#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Artifacts extends Serializable
{
  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @generated
   */
  Sequence getGroup();

  /**
   * Returns the value of the '<em><b>Artifact</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl2.Artifact}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: Not further defined here.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Artifact</em>' containment reference list.
   * @generated
   */
  List getArtifact();

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

} // Artifacts
