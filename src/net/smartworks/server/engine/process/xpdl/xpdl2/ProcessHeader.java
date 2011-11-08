/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessHeader.java,v 1.1 2009/12/22 06:18:21 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Header</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getCreated <em>Created</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getPriority <em>Priority</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getLimit <em>Limit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidTo <em>Valid To</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getTimeEstimation <em>Time Estimation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDurationUnit <em>Duration Unit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ProcessHeader extends Serializable
{
  /**
   * Returns the value of the '<em><b>Created</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Created</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Created</em>' containment reference.
   * @see #isSetCreated()
   * @see #unsetCreated()
   * @see #setCreated(Created)
   * @generated
   */
  Created getCreated();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getCreated <em>Created</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Created</em>' containment reference.
   * @see #isSetCreated()
   * @see #unsetCreated()
   * @see #getCreated()
   * @generated
   */
  void setCreated(Created value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getCreated <em>Created</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCreated()
   * @see #getCreated()
   * @see #setCreated(Created)
   * @generated
   */
  void unsetCreated();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getCreated <em>Created</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Created</em>' containment reference is set.
   * @see #unsetCreated()
   * @see #getCreated()
   * @see #setCreated(Created)
   * @generated
   */
  boolean isSetCreated();

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #setDescription(Description)
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDescription()
   * @see #getDescription()
   * @see #setDescription(Description)
   * @generated
   */
  void unsetDescription();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDescription <em>Description</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Description</em>' containment reference is set.
   * @see #unsetDescription()
   * @see #getDescription()
   * @see #setDescription(Description)
   * @generated
   */
  boolean isSetDescription();

  /**
   * Returns the value of the '<em><b>Priority</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' containment reference.
   * @see #isSetPriority()
   * @see #unsetPriority()
   * @see #setPriority(Priority)
   * @generated
   */
  Priority getPriority();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getPriority <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' containment reference.
   * @see #isSetPriority()
   * @see #unsetPriority()
   * @see #getPriority()
   * @generated
   */
  void setPriority(Priority value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getPriority <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPriority()
   * @see #getPriority()
   * @see #setPriority(Priority)
   * @generated
   */
  void unsetPriority();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getPriority <em>Priority</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Priority</em>' containment reference is set.
   * @see #unsetPriority()
   * @see #getPriority()
   * @see #setPriority(Priority)
   * @generated
   */
  boolean isSetPriority();

  /**
   * Returns the value of the '<em><b>Limit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Limit</em>' containment reference.
   * @see #isSetLimit()
   * @see #unsetLimit()
   * @see #setLimit(Limit)
   * @generated
   */
  Limit getLimit();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getLimit <em>Limit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Limit</em>' containment reference.
   * @see #isSetLimit()
   * @see #unsetLimit()
   * @see #getLimit()
   * @generated
   */
  void setLimit(Limit value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getLimit <em>Limit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLimit()
   * @see #getLimit()
   * @see #setLimit(Limit)
   * @generated
   */
  void unsetLimit();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getLimit <em>Limit</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Limit</em>' containment reference is set.
   * @see #unsetLimit()
   * @see #getLimit()
   * @see #setLimit(Limit)
   * @generated
   */
  boolean isSetLimit();

  /**
   * Returns the value of the '<em><b>Valid From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Valid From</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valid From</em>' containment reference.
   * @see #isSetValidFrom()
   * @see #unsetValidFrom()
   * @see #setValidFrom(ValidFrom)
   * @generated
   */
  ValidFrom getValidFrom();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidFrom <em>Valid From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valid From</em>' containment reference.
   * @see #isSetValidFrom()
   * @see #unsetValidFrom()
   * @see #getValidFrom()
   * @generated
   */
  void setValidFrom(ValidFrom value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidFrom <em>Valid From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetValidFrom()
   * @see #getValidFrom()
   * @see #setValidFrom(ValidFrom)
   * @generated
   */
  void unsetValidFrom();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidFrom <em>Valid From</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Valid From</em>' containment reference is set.
   * @see #unsetValidFrom()
   * @see #getValidFrom()
   * @see #setValidFrom(ValidFrom)
   * @generated
   */
  boolean isSetValidFrom();

  /**
   * Returns the value of the '<em><b>Valid To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Valid To</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valid To</em>' containment reference.
   * @see #isSetValidTo()
   * @see #unsetValidTo()
   * @see #setValidTo(ValidTo)
   * @generated
   */
  ValidTo getValidTo();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidTo <em>Valid To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valid To</em>' containment reference.
   * @see #isSetValidTo()
   * @see #unsetValidTo()
   * @see #getValidTo()
   * @generated
   */
  void setValidTo(ValidTo value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidTo <em>Valid To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetValidTo()
   * @see #getValidTo()
   * @see #setValidTo(ValidTo)
   * @generated
   */
  void unsetValidTo();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getValidTo <em>Valid To</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Valid To</em>' containment reference is set.
   * @see #unsetValidTo()
   * @see #getValidTo()
   * @see #setValidTo(ValidTo)
   * @generated
   */
  boolean isSetValidTo();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getTimeEstimation <em>Time Estimation</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getTimeEstimation <em>Time Estimation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTimeEstimation()
   * @see #getTimeEstimation()
   * @see #setTimeEstimation(TimeEstimation)
   * @generated
   */
  void unsetTimeEstimation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getTimeEstimation <em>Time Estimation</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Duration Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Duration Unit</em>' attribute.
   * @see #isSetDurationUnit()
   * @see #unsetDurationUnit()
   * @see #setDurationUnit(String)
   * @generated
   */
  String getDurationUnit();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDurationUnit <em>Duration Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration Unit</em>' attribute.
   * @see #isSetDurationUnit()
   * @see #unsetDurationUnit()
   * @see #getDurationUnit()
   * @generated
   */
  void setDurationUnit(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDurationUnit <em>Duration Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDurationUnit()
   * @see #getDurationUnit()
   * @see #setDurationUnit(String)
   * @generated
   */
  void unsetDurationUnit();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader#getDurationUnit <em>Duration Unit</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Duration Unit</em>' attribute is set.
   * @see #unsetDurationUnit()
   * @see #getDurationUnit()
   * @see #setDurationUnit(String)
   * @generated
   */
  boolean isSetDurationUnit();

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

} // ProcessHeader
