/**
 * <copyright>
 * </copyright>
 *
 * $Id: Event.java,v 1.1 2009/12/22 06:18:37 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getStartEvent <em>Start Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getIntermediateEvent <em>Intermediate Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getEndEvent <em>End Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Event extends Serializable
{
  /**
   * Returns the value of the '<em><b>Start Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Start Event</em>' containment reference.
   * @see #isSetStartEvent()
   * @see #unsetStartEvent()
   * @see #setStartEvent(StartEvent)
   * @generated
   */
  StartEvent getStartEvent();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getStartEvent <em>Start Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Event</em>' containment reference.
   * @see #isSetStartEvent()
   * @see #unsetStartEvent()
   * @see #getStartEvent()
   * @generated
   */
  void setStartEvent(StartEvent value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getStartEvent <em>Start Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartEvent()
   * @see #getStartEvent()
   * @see #setStartEvent(StartEvent)
   * @generated
   */
  void unsetStartEvent();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getStartEvent <em>Start Event</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Event</em>' containment reference is set.
   * @see #unsetStartEvent()
   * @see #getStartEvent()
   * @see #setStartEvent(StartEvent)
   * @generated
   */
  boolean isSetStartEvent();

  /**
   * Returns the value of the '<em><b>Intermediate Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>Intermediate Event</em>' containment reference.
   * @see #isSetIntermediateEvent()
   * @see #unsetIntermediateEvent()
   * @see #setIntermediateEvent(IntermediateEvent)
   * @generated
   */
  IntermediateEvent getIntermediateEvent();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getIntermediateEvent <em>Intermediate Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Intermediate Event</em>' containment reference.
   * @see #isSetIntermediateEvent()
   * @see #unsetIntermediateEvent()
   * @see #getIntermediateEvent()
   * @generated
   */
  void setIntermediateEvent(IntermediateEvent value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getIntermediateEvent <em>Intermediate Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIntermediateEvent()
   * @see #getIntermediateEvent()
   * @see #setIntermediateEvent(IntermediateEvent)
   * @generated
   */
  void unsetIntermediateEvent();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getIntermediateEvent <em>Intermediate Event</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Intermediate Event</em>' containment reference is set.
   * @see #unsetIntermediateEvent()
   * @see #getIntermediateEvent()
   * @see #setIntermediateEvent(IntermediateEvent)
   * @generated
   */
  boolean isSetIntermediateEvent();

  /**
   * Returns the value of the '<em><b>End Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN
   * <!-- end-model-doc -->
   * @return the value of the '<em>End Event</em>' containment reference.
   * @see #isSetEndEvent()
   * @see #unsetEndEvent()
   * @see #setEndEvent(EndEvent)
   * @generated
   */
  EndEvent getEndEvent();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getEndEvent <em>End Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Event</em>' containment reference.
   * @see #isSetEndEvent()
   * @see #unsetEndEvent()
   * @see #getEndEvent()
   * @generated
   */
  void setEndEvent(EndEvent value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getEndEvent <em>End Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEndEvent()
   * @see #getEndEvent()
   * @see #setEndEvent(EndEvent)
   * @generated
   */
  void unsetEndEvent();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Event#getEndEvent <em>End Event</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>End Event</em>' containment reference is set.
   * @see #unsetEndEvent()
   * @see #getEndEvent()
   * @see #setEndEvent(EndEvent)
   * @generated
   */
  boolean isSetEndEvent();

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

} // Event
