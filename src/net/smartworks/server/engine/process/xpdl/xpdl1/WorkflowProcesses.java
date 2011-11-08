/**
 * <copyright>
 * </copyright>
 *
 * $Id: WorkflowProcesses.java,v 1.1 2009/12/22 06:18:07 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow Processes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcesses#getWorkflowProcess <em>Workflow Process</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface WorkflowProcesses extends Serializable
{
  /**
   * Returns the value of the '<em><b>Workflow Process</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Workflow Process</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Workflow Process</em>' containment reference list.
   * @generated
   */
  List getWorkflowProcess();

} // WorkflowProcesses
