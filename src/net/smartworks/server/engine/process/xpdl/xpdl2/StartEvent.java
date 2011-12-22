/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartEvent.java,v 1.1 2009/12/22 06:18:18 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultMessage <em>Trigger Result Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerTimer <em>Trigger Timer</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerRule <em>Trigger Rule</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultLink <em>Trigger Result Link</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerMultiple <em>Trigger Multiple</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface StartEvent extends Serializable
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultMessage <em>Trigger Result Message</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultMessage <em>Trigger Result Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTriggerResultMessage()
   * @see #getTriggerResultMessage()
   * @see #setTriggerResultMessage(TriggerResultMessage)
   * @generated
   */
  void unsetTriggerResultMessage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultMessage <em>Trigger Result Message</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Trigger Timer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: If the Trigger Type is Timer then this must be present
   * <!-- end-model-doc -->
   * @return the value of the '<em>Trigger Timer</em>' containment reference.
   * @see #isSetTriggerTimer()
   * @see #unsetTriggerTimer()
   * @see #setTriggerTimer(TriggerTimer)
   * @generated
   */
  TriggerTimer getTriggerTimer();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerTimer <em>Trigger Timer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger Timer</em>' containment reference.
   * @see #isSetTriggerTimer()
   * @see #unsetTriggerTimer()
   * @see #getTriggerTimer()
   * @generated
   */
  void setTriggerTimer(TriggerTimer value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerTimer <em>Trigger Timer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTriggerTimer()
   * @see #getTriggerTimer()
   * @see #setTriggerTimer(TriggerTimer)
   * @generated
   */
  void unsetTriggerTimer();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerTimer <em>Trigger Timer</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Trigger Timer</em>' containment reference is set.
   * @see #unsetTriggerTimer()
   * @see #getTriggerTimer()
   * @see #setTriggerTimer(TriggerTimer)
   * @generated
   */
  boolean isSetTriggerTimer();

  /**
   * Returns the value of the '<em><b>Trigger Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: if the TriggerType is Rule then this must be present.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Trigger Rule</em>' containment reference.
   * @see #isSetTriggerRule()
   * @see #unsetTriggerRule()
   * @see #setTriggerRule(TriggerRule)
   * @generated
   */
  TriggerRule getTriggerRule();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerRule <em>Trigger Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger Rule</em>' containment reference.
   * @see #isSetTriggerRule()
   * @see #unsetTriggerRule()
   * @see #getTriggerRule()
   * @generated
   */
  void setTriggerRule(TriggerRule value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerRule <em>Trigger Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTriggerRule()
   * @see #getTriggerRule()
   * @see #setTriggerRule(TriggerRule)
   * @generated
   */
  void unsetTriggerRule();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerRule <em>Trigger Rule</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Trigger Rule</em>' containment reference is set.
   * @see #unsetTriggerRule()
   * @see #getTriggerRule()
   * @see #setTriggerRule(TriggerRule)
   * @generated
   */
  boolean isSetTriggerRule();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultLink <em>Trigger Result Link</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultLink <em>Trigger Result Link</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTriggerResultLink()
   * @see #getTriggerResultLink()
   * @see #setTriggerResultLink(TriggerResultLink)
   * @generated
   */
  void unsetTriggerResultLink();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerResultLink <em>Trigger Result Link</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Trigger Multiple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: if the TriggerType is Multiple then this must be present.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Trigger Multiple</em>' containment reference.
   * @see #isSetTriggerMultiple()
   * @see #unsetTriggerMultiple()
   * @see #setTriggerMultiple(TriggerMultiple)
   * @generated
   */
  TriggerMultiple getTriggerMultiple();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerMultiple <em>Trigger Multiple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger Multiple</em>' containment reference.
   * @see #isSetTriggerMultiple()
   * @see #unsetTriggerMultiple()
   * @see #getTriggerMultiple()
   * @generated
   */
  void setTriggerMultiple(TriggerMultiple value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerMultiple <em>Trigger Multiple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTriggerMultiple()
   * @see #getTriggerMultiple()
   * @see #setTriggerMultiple(TriggerMultiple)
   * @generated
   */
  void unsetTriggerMultiple();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTriggerMultiple <em>Trigger Multiple</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Trigger Multiple</em>' containment reference is set.
   * @see #unsetTriggerMultiple()
   * @see #getTriggerMultiple()
   * @see #setTriggerMultiple(TriggerMultiple)
   * @generated
   */
  boolean isSetTriggerMultiple();

  /**
   * Returns the value of the '<em><b>Trigger</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger</em>' attribute.
   * @see #isSetTrigger()
   * @see #unsetTrigger()
   * @see #setTrigger(String)
   * @generated
   */
  String getTrigger();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTrigger <em>Trigger</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger</em>' attribute.
   * @see #isSetTrigger()
   * @see #unsetTrigger()
   * @see #getTrigger()
   * @generated
   */
  void setTrigger(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTrigger <em>Trigger</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTrigger()
   * @see #getTrigger()
   * @see #setTrigger(String)
   * @generated
   */
  void unsetTrigger();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getTrigger <em>Trigger</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Trigger</em>' attribute is set.
   * @see #unsetTrigger()
   * @see #getTrigger()
   * @see #setTrigger(String)
   * @generated
   */
  boolean isSetTrigger();

  /**
   * Returns the value of the '<em><b>Implementation</b></em>' attribute.
   * The default value is <code>"WebService"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Required if the Trigger is Message
   * <!-- end-model-doc -->
   * @return the value of the '<em>Implementation</em>' attribute.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  String getImplementation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getImplementation <em>Implementation</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(String)
   * @generated
   */
  void unsetImplementation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent#getImplementation <em>Implementation</em>}' attribute is set.
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

} // StartEvent
