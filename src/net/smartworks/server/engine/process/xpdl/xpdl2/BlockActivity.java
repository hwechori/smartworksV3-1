/**
 * <copyright>
 * </copyright>
 *
 * $Id: BlockActivity.java,v 1.1 2009/12/22 06:18:19 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getActivitySetId <em>Activity Set Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getStartActivityId <em>Start Activity Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface BlockActivity extends Serializable
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
   * Returns the value of the '<em><b>Activity Set Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Set Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Set Id</em>' attribute.
   * @see #isSetActivitySetId()
   * @see #unsetActivitySetId()
   * @see #setActivitySetId(String)
   * @generated
   */
  String getActivitySetId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getActivitySetId <em>Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Set Id</em>' attribute.
   * @see #isSetActivitySetId()
   * @see #unsetActivitySetId()
   * @see #getActivitySetId()
   * @generated
   */
  void setActivitySetId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getActivitySetId <em>Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActivitySetId()
   * @see #getActivitySetId()
   * @see #setActivitySetId(String)
   * @generated
   */
  void unsetActivitySetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getActivitySetId <em>Activity Set Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Activity Set Id</em>' attribute is set.
   * @see #unsetActivitySetId()
   * @see #getActivitySetId()
   * @see #setActivitySetId(String)
   * @generated
   */
  boolean isSetActivitySetId();

  /**
   * Returns the value of the '<em><b>Start Activity Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Activity Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Activity Id</em>' attribute.
   * @see #isSetStartActivityId()
   * @see #unsetStartActivityId()
   * @see #setStartActivityId(String)
   * @generated
   */
  String getStartActivityId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getStartActivityId <em>Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Activity Id</em>' attribute.
   * @see #isSetStartActivityId()
   * @see #unsetStartActivityId()
   * @see #getStartActivityId()
   * @generated
   */
  void setStartActivityId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getStartActivityId <em>Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartActivityId()
   * @see #getStartActivityId()
   * @see #setStartActivityId(String)
   * @generated
   */
  void unsetStartActivityId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity#getStartActivityId <em>Start Activity Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Activity Id</em>' attribute is set.
   * @see #unsetStartActivityId()
   * @see #getStartActivityId()
   * @see #setStartActivityId(String)
   * @generated
   */
  boolean isSetStartActivityId();

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

} // BlockActivity
