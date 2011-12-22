/**
 * <copyright>
 * </copyright>
 *
 * $Id: Task.java,v 1.1 2009/12/22 06:18:14 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskService <em>Task Service</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReceive <em>Task Receive</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskManual <em>Task Manual</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReference <em>Task Reference</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskScript <em>Task Script</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskSend <em>Task Send</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskUser <em>Task User</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskApplication <em>Task Application</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Task extends Serializable
{
  /**
   * Returns the value of the '<em><b>Task Service</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Task Service</em>' containment reference.
   * @see #isSetTaskService()
   * @see #unsetTaskService()
   * @see #setTaskService(TaskService)
   * @generated
   */
  TaskService getTaskService();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskService <em>Task Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Service</em>' containment reference.
   * @see #isSetTaskService()
   * @see #unsetTaskService()
   * @see #getTaskService()
   * @generated
   */
  void setTaskService(TaskService value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskService <em>Task Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskService()
   * @see #getTaskService()
   * @see #setTaskService(TaskService)
   * @generated
   */
  void unsetTaskService();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskService <em>Task Service</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task Service</em>' containment reference is set.
   * @see #unsetTaskService()
   * @see #getTaskService()
   * @see #setTaskService(TaskService)
   * @generated
   */
  boolean isSetTaskService();

  /**
   * Returns the value of the '<em><b>Task Receive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Task Receive</em>' containment reference.
   * @see #isSetTaskReceive()
   * @see #unsetTaskReceive()
   * @see #setTaskReceive(TaskReceive)
   * @generated
   */
  TaskReceive getTaskReceive();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReceive <em>Task Receive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Receive</em>' containment reference.
   * @see #isSetTaskReceive()
   * @see #unsetTaskReceive()
   * @see #getTaskReceive()
   * @generated
   */
  void setTaskReceive(TaskReceive value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReceive <em>Task Receive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskReceive()
   * @see #getTaskReceive()
   * @see #setTaskReceive(TaskReceive)
   * @generated
   */
  void unsetTaskReceive();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReceive <em>Task Receive</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task Receive</em>' containment reference is set.
   * @see #unsetTaskReceive()
   * @see #getTaskReceive()
   * @see #setTaskReceive(TaskReceive)
   * @generated
   */
  boolean isSetTaskReceive();

  /**
   * Returns the value of the '<em><b>Task Manual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Task Manual</em>' containment reference.
   * @see #isSetTaskManual()
   * @see #unsetTaskManual()
   * @see #setTaskManual(TaskManual)
   * @generated
   */
  TaskManual getTaskManual();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskManual <em>Task Manual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Manual</em>' containment reference.
   * @see #isSetTaskManual()
   * @see #unsetTaskManual()
   * @see #getTaskManual()
   * @generated
   */
  void setTaskManual(TaskManual value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskManual <em>Task Manual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskManual()
   * @see #getTaskManual()
   * @see #setTaskManual(TaskManual)
   * @generated
   */
  void unsetTaskManual();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskManual <em>Task Manual</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task Manual</em>' containment reference is set.
   * @see #unsetTaskManual()
   * @see #getTaskManual()
   * @see #setTaskManual(TaskManual)
   * @generated
   */
  boolean isSetTaskManual();

  /**
   * Returns the value of the '<em><b>Task Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Task Reference</em>' containment reference.
   * @see #isSetTaskReference()
   * @see #unsetTaskReference()
   * @see #setTaskReference(TaskReference)
   * @generated
   */
  TaskReference getTaskReference();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReference <em>Task Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Reference</em>' containment reference.
   * @see #isSetTaskReference()
   * @see #unsetTaskReference()
   * @see #getTaskReference()
   * @generated
   */
  void setTaskReference(TaskReference value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReference <em>Task Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskReference()
   * @see #getTaskReference()
   * @see #setTaskReference(TaskReference)
   * @generated
   */
  void unsetTaskReference();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskReference <em>Task Reference</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task Reference</em>' containment reference is set.
   * @see #unsetTaskReference()
   * @see #getTaskReference()
   * @see #setTaskReference(TaskReference)
   * @generated
   */
  boolean isSetTaskReference();

  /**
   * Returns the value of the '<em><b>Task Script</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Task Script</em>' containment reference.
   * @see #isSetTaskScript()
   * @see #unsetTaskScript()
   * @see #setTaskScript(TaskScript)
   * @generated
   */
  TaskScript getTaskScript();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskScript <em>Task Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Script</em>' containment reference.
   * @see #isSetTaskScript()
   * @see #unsetTaskScript()
   * @see #getTaskScript()
   * @generated
   */
  void setTaskScript(TaskScript value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskScript <em>Task Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskScript()
   * @see #getTaskScript()
   * @see #setTaskScript(TaskScript)
   * @generated
   */
  void unsetTaskScript();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskScript <em>Task Script</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task Script</em>' containment reference is set.
   * @see #unsetTaskScript()
   * @see #getTaskScript()
   * @see #setTaskScript(TaskScript)
   * @generated
   */
  boolean isSetTaskScript();

  /**
   * Returns the value of the '<em><b>Task Send</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Task Send</em>' containment reference.
   * @see #isSetTaskSend()
   * @see #unsetTaskSend()
   * @see #setTaskSend(TaskSend)
   * @generated
   */
  TaskSend getTaskSend();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskSend <em>Task Send</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Send</em>' containment reference.
   * @see #isSetTaskSend()
   * @see #unsetTaskSend()
   * @see #getTaskSend()
   * @generated
   */
  void setTaskSend(TaskSend value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskSend <em>Task Send</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskSend()
   * @see #getTaskSend()
   * @see #setTaskSend(TaskSend)
   * @generated
   */
  void unsetTaskSend();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskSend <em>Task Send</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task Send</em>' containment reference is set.
   * @see #unsetTaskSend()
   * @see #getTaskSend()
   * @see #setTaskSend(TaskSend)
   * @generated
   */
  boolean isSetTaskSend();

  /**
   * Returns the value of the '<em><b>Task User</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Task User</em>' containment reference.
   * @see #isSetTaskUser()
   * @see #unsetTaskUser()
   * @see #setTaskUser(TaskUser)
   * @generated
   */
  TaskUser getTaskUser();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskUser <em>Task User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task User</em>' containment reference.
   * @see #isSetTaskUser()
   * @see #unsetTaskUser()
   * @see #getTaskUser()
   * @generated
   */
  void setTaskUser(TaskUser value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskUser <em>Task User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskUser()
   * @see #getTaskUser()
   * @see #setTaskUser(TaskUser)
   * @generated
   */
  void unsetTaskUser();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskUser <em>Task User</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task User</em>' containment reference is set.
   * @see #unsetTaskUser()
   * @see #getTaskUser()
   * @see #setTaskUser(TaskUser)
   * @generated
   */
  boolean isSetTaskUser();

  /**
   * Returns the value of the '<em><b>Task Application</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Task Application</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Task Application</em>' containment reference.
   * @see #isSetTaskApplication()
   * @see #unsetTaskApplication()
   * @see #setTaskApplication(TaskApplication)
   * @generated
   */
  TaskApplication getTaskApplication();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskApplication <em>Task Application</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Application</em>' containment reference.
   * @see #isSetTaskApplication()
   * @see #unsetTaskApplication()
   * @see #getTaskApplication()
   * @generated
   */
  void setTaskApplication(TaskApplication value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskApplication <em>Task Application</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTaskApplication()
   * @see #getTaskApplication()
   * @see #setTaskApplication(TaskApplication)
   * @generated
   */
  void unsetTaskApplication();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Task#getTaskApplication <em>Task Application</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Task Application</em>' containment reference is set.
   * @see #unsetTaskApplication()
   * @see #getTaskApplication()
   * @see #setTaskApplication(TaskApplication)
   * @generated
   */
  boolean isSetTaskApplication();

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

} // Task
