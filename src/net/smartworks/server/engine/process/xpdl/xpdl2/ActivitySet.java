/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivitySet.java,v 1.1 2009/12/22 06:18:38 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocOrdering <em>Ad Hoc Ordering</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getDefaultStartActivityId <em>Default Start Activity Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAnyAttribute <em>Any Attribute</em>}</li>
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getActivities <em>Activities</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getActivities <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActivities()
   * @see #getActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  void unsetActivities();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getActivities <em>Activities</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getTransitions <em>Transitions</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getTransitions <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitions()
   * @see #getTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  void unsetTransitions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getTransitions <em>Transitions</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: This is used to identify the Activity in an EndEvent Compensation???Also used to associate categories and ocumentation with a variety of elements
   * <!-- end-model-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.Object getObject();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #getObject()
   * @generated
   */
  void setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  void unsetObject();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getObject <em>Object</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Object</em>' containment reference is set.
   * @see #unsetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  boolean isSetObject();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getId <em>Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Id</em>' attribute is set.
   * @see #unsetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  boolean isSetId();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #setName(String)
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getName <em>Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Name</em>' attribute is set.
   * @see #unsetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  boolean isSetName();

  /**
   * Returns the value of the '<em><b>Ad Hoc</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: for Embedded subprocess
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ad Hoc</em>' attribute.
   * @see #isSetAdHoc()
   * @see #unsetAdHoc()
   * @see #setAdHoc(boolean)
   * @generated
   */
  boolean isAdHoc();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#isAdHoc <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ad Hoc</em>' attribute.
   * @see #isSetAdHoc()
   * @see #unsetAdHoc()
   * @see #isAdHoc()
   * @generated
   */
  void setAdHoc(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#isAdHoc <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAdHoc()
   * @see #isAdHoc()
   * @see #setAdHoc(boolean)
   * @generated
   */
  void unsetAdHoc();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#isAdHoc <em>Ad Hoc</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ad Hoc</em>' attribute is set.
   * @see #unsetAdHoc()
   * @see #isAdHoc()
   * @see #setAdHoc(boolean)
   * @generated
   */
  boolean isSetAdHoc();

  /**
   * Returns the value of the '<em><b>Ad Hoc Ordering</b></em>' attribute.
   * The default value is <code>"Parallel"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: for Embedded subprocess
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ad Hoc Ordering</em>' attribute.
   * @see #isSetAdHocOrdering()
   * @see #unsetAdHocOrdering()
   * @see #setAdHocOrdering(String)
   * @generated
   */
  String getAdHocOrdering();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocOrdering <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ad Hoc Ordering</em>' attribute.
   * @see #isSetAdHocOrdering()
   * @see #unsetAdHocOrdering()
   * @see #getAdHocOrdering()
   * @generated
   */
  void setAdHocOrdering(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocOrdering <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAdHocOrdering()
   * @see #getAdHocOrdering()
   * @see #setAdHocOrdering(String)
   * @generated
   */
  void unsetAdHocOrdering();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocOrdering <em>Ad Hoc Ordering</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ad Hoc Ordering</em>' attribute is set.
   * @see #unsetAdHocOrdering()
   * @see #getAdHocOrdering()
   * @see #setAdHocOrdering(String)
   * @generated
   */
  boolean isSetAdHocOrdering();

  /**
   * Returns the value of the '<em><b>Ad Hoc Completion Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: for Embedded subprocess
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ad Hoc Completion Condition</em>' attribute.
   * @see #isSetAdHocCompletionCondition()
   * @see #unsetAdHocCompletionCondition()
   * @see #setAdHocCompletionCondition(String)
   * @generated
   */
  String getAdHocCompletionCondition();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ad Hoc Completion Condition</em>' attribute.
   * @see #isSetAdHocCompletionCondition()
   * @see #unsetAdHocCompletionCondition()
   * @see #getAdHocCompletionCondition()
   * @generated
   */
  void setAdHocCompletionCondition(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAdHocCompletionCondition()
   * @see #getAdHocCompletionCondition()
   * @see #setAdHocCompletionCondition(String)
   * @generated
   */
  void unsetAdHocCompletionCondition();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ad Hoc Completion Condition</em>' attribute is set.
   * @see #unsetAdHocCompletionCondition()
   * @see #getAdHocCompletionCondition()
   * @see #setAdHocCompletionCondition(String)
   * @generated
   */
  boolean isSetAdHocCompletionCondition();

  /**
   * Returns the value of the '<em><b>Default Start Activity Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Start Activity Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Start Activity Id</em>' attribute.
   * @see #isSetDefaultStartActivityId()
   * @see #unsetDefaultStartActivityId()
   * @see #setDefaultStartActivityId(String)
   * @generated
   */
  String getDefaultStartActivityId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getDefaultStartActivityId <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Start Activity Id</em>' attribute.
   * @see #isSetDefaultStartActivityId()
   * @see #unsetDefaultStartActivityId()
   * @see #getDefaultStartActivityId()
   * @generated
   */
  void setDefaultStartActivityId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getDefaultStartActivityId <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDefaultStartActivityId()
   * @see #getDefaultStartActivityId()
   * @see #setDefaultStartActivityId(String)
   * @generated
   */
  void unsetDefaultStartActivityId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet#getDefaultStartActivityId <em>Default Start Activity Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Default Start Activity Id</em>' attribute is set.
   * @see #unsetDefaultStartActivityId()
   * @see #getDefaultStartActivityId()
   * @see #setDefaultStartActivityId(String)
   * @generated
   */
  boolean isSetDefaultStartActivityId();

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

} // ActivitySet
