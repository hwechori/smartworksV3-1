/**
 * <copyright>
 * </copyright>
 *
 * $Id: EndEvent.java,v 1.1 2009/12/22 06:18:31 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultMessage <em>Trigger Result Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultError <em>Result Error</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultCompensation <em>Result Compensation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultLink <em>Trigger Result Link</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultMultiple <em>Result Multiple</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResult <em>Result</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface EndEvent extends Serializable
{
  /**
   * Returns the value of the '<em><b>Trigger Result Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  BPMN: If the Trigger or Result Type is Message then this must be present
   * <!-- end-model-doc -->
   * @return the value of the '<em>Trigger Result Message</em>' containment reference.
   * @see #isSetTriggerResultMessage()
   * @see #unsetTriggerResultMessage()
   * @see #setTriggerResultMessage(TriggerResultMessage)
   * @generated
   */
  TriggerResultMessage getTriggerResultMessage();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultMessage <em>Trigger Result Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger Result Message</em>' containment reference.
   * @see #isSetTriggerResultMessage()
   * @see #unsetTriggerResultMessage()
   * @see #getTriggerResultMessage()
   * @generated
   */
  void setTriggerResultMessage(TriggerResultMessage value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultMessage <em>Trigger Result Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTriggerResultMessage()
   * @see #getTriggerResultMessage()
   * @see #setTriggerResultMessage(TriggerResultMessage)
   * @generated
   */
  void unsetTriggerResultMessage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultMessage <em>Trigger Result Message</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Trigger Result Message</em>' containment reference is set.
   * @see #unsetTriggerResultMessage()
   * @see #getTriggerResultMessage()
   * @see #setTriggerResultMessage(TriggerResultMessage)
   * @generated
   */
  boolean isSetTriggerResultMessage();

  /**
   * Returns the value of the '<em><b>Result Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: Must be present if Trigger or ResultType is error.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Result Error</em>' containment reference.
   * @see #isSetResultError()
   * @see #unsetResultError()
   * @see #setResultError(ResultError)
   * @generated
   */
  ResultError getResultError();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultError <em>Result Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Error</em>' containment reference.
   * @see #isSetResultError()
   * @see #unsetResultError()
   * @see #getResultError()
   * @generated
   */
  void setResultError(ResultError value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultError <em>Result Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetResultError()
   * @see #getResultError()
   * @see #setResultError(ResultError)
   * @generated
   */
  void unsetResultError();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultError <em>Result Error</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Result Error</em>' containment reference is set.
   * @see #unsetResultError()
   * @see #getResultError()
   * @see #setResultError(ResultError)
   * @generated
   */
  boolean isSetResultError();

  /**
   * Returns the value of the '<em><b>Result Compensation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: Must be present if if Trigger or ResultType is Compensation.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Result Compensation</em>' containment reference.
   * @see #isSetResultCompensation()
   * @see #unsetResultCompensation()
   * @see #setResultCompensation(ResultCompensation)
   * @generated
   */
  ResultCompensation getResultCompensation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultCompensation <em>Result Compensation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Compensation</em>' containment reference.
   * @see #isSetResultCompensation()
   * @see #unsetResultCompensation()
   * @see #getResultCompensation()
   * @generated
   */
  void setResultCompensation(ResultCompensation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultCompensation <em>Result Compensation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetResultCompensation()
   * @see #getResultCompensation()
   * @see #setResultCompensation(ResultCompensation)
   * @generated
   */
  void unsetResultCompensation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultCompensation <em>Result Compensation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Result Compensation</em>' containment reference is set.
   * @see #unsetResultCompensation()
   * @see #getResultCompensation()
   * @see #setResultCompensation(ResultCompensation)
   * @generated
   */
  boolean isSetResultCompensation();

  /**
   * Returns the value of the '<em><b>Trigger Result Link</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: if the Trigger or Result Type is Link then this must be present.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Trigger Result Link</em>' containment reference.
   * @see #isSetTriggerResultLink()
   * @see #unsetTriggerResultLink()
   * @see #setTriggerResultLink(TriggerResultLink)
   * @generated
   */
  TriggerResultLink getTriggerResultLink();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultLink <em>Trigger Result Link</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger Result Link</em>' containment reference.
   * @see #isSetTriggerResultLink()
   * @see #unsetTriggerResultLink()
   * @see #getTriggerResultLink()
   * @generated
   */
  void setTriggerResultLink(TriggerResultLink value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultLink <em>Trigger Result Link</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTriggerResultLink()
   * @see #getTriggerResultLink()
   * @see #setTriggerResultLink(TriggerResultLink)
   * @generated
   */
  void unsetTriggerResultLink();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getTriggerResultLink <em>Trigger Result Link</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Trigger Result Link</em>' containment reference is set.
   * @see #unsetTriggerResultLink()
   * @see #getTriggerResultLink()
   * @see #setTriggerResultLink(TriggerResultLink)
   * @generated
   */
  boolean isSetTriggerResultLink();

  /**
   * Returns the value of the '<em><b>Result Multiple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: Must be present if ResultType is Multiple.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Result Multiple</em>' containment reference.
   * @see #isSetResultMultiple()
   * @see #unsetResultMultiple()
   * @see #setResultMultiple(ResultMultiple)
   * @generated
   */
  ResultMultiple getResultMultiple();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultMultiple <em>Result Multiple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Multiple</em>' containment reference.
   * @see #isSetResultMultiple()
   * @see #unsetResultMultiple()
   * @see #getResultMultiple()
   * @generated
   */
  void setResultMultiple(ResultMultiple value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultMultiple <em>Result Multiple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetResultMultiple()
   * @see #getResultMultiple()
   * @see #setResultMultiple(ResultMultiple)
   * @generated
   */
  void unsetResultMultiple();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResultMultiple <em>Result Multiple</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Result Multiple</em>' containment reference is set.
   * @see #unsetResultMultiple()
   * @see #getResultMultiple()
   * @see #setResultMultiple(ResultMultiple)
   * @generated
   */
  boolean isSetResultMultiple();

  /**
   * Returns the value of the '<em><b>Result</b></em>' attribute.
   * The default value is <code>"None"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' attribute.
   * @see #isSetResult()
   * @see #unsetResult()
   * @see #setResult(String)
   * @generated
   */
  String getResult();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResult <em>Result</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' attribute.
   * @see #isSetResult()
   * @see #unsetResult()
   * @see #getResult()
   * @generated
   */
  void setResult(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResult <em>Result</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetResult()
   * @see #getResult()
   * @see #setResult(String)
   * @generated
   */
  void unsetResult();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getResult <em>Result</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Result</em>' attribute is set.
   * @see #unsetResult()
   * @see #getResult()
   * @see #setResult(String)
   * @generated
   */
  boolean isSetResult();

  /**
   * Returns the value of the '<em><b>Implementation</b></em>' attribute.
   * The default value is <code>"WebService"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Required if the Trigger or Result is Message
   * <!-- end-model-doc -->
   * @return the value of the '<em>Implementation</em>' attribute.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  String getImplementation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation</em>' attribute.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @generated
   */
  void setImplementation(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  void unsetImplementation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent#getImplementation <em>Implementation</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Implementation</em>' attribute is set.
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  boolean isSetImplementation();

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

} // EndEvent
