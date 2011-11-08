/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataMapping.java,v 1.1 2009/12/22 06:18:12 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getActual <em>Actual</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getFormal <em>Formal</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getDirection <em>Direction</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface DataMapping extends Serializable
{
  /**
   * Returns the value of the '<em><b>Actual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual</em>' containment reference.
   * @see #isSetActual()
   * @see #unsetActual()
   * @see #setActual(ExpressionType)
   * @generated
   */
  ExpressionType getActual();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getActual <em>Actual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual</em>' containment reference.
   * @see #isSetActual()
   * @see #unsetActual()
   * @see #getActual()
   * @generated
   */
  void setActual(ExpressionType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getActual <em>Actual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActual()
   * @see #getActual()
   * @see #setActual(ExpressionType)
   * @generated
   */
  void unsetActual();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getActual <em>Actual</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Actual</em>' containment reference is set.
   * @see #unsetActual()
   * @see #getActual()
   * @see #setActual(ExpressionType)
   * @generated
   */
  boolean isSetActual();

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
   * Returns the value of the '<em><b>Formal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal</em>' attribute.
   * @see #isSetFormal()
   * @see #unsetFormal()
   * @see #setFormal(String)
   * @generated
   */
  String getFormal();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getFormal <em>Formal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal</em>' attribute.
   * @see #isSetFormal()
   * @see #unsetFormal()
   * @see #getFormal()
   * @generated
   */
  void setFormal(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getFormal <em>Formal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFormal()
   * @see #getFormal()
   * @see #setFormal(String)
   * @generated
   */
  void unsetFormal();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getFormal <em>Formal</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Formal</em>' attribute is set.
   * @see #unsetFormal()
   * @see #getFormal()
   * @see #setFormal(String)
   * @generated
   */
  boolean isSetFormal();

  /**
   * Returns the value of the '<em><b>Direction</b></em>' attribute.
   * The default value is <code>"IN"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direction</em>' attribute.
   * @see #isSetDirection()
   * @see #unsetDirection()
   * @see #setDirection(String)
   * @generated
   */
  String getDirection();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see #isSetDirection()
   * @see #unsetDirection()
   * @see #getDirection()
   * @generated
   */
  void setDirection(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDirection()
   * @see #getDirection()
   * @see #setDirection(String)
   * @generated
   */
  void unsetDirection();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping#getDirection <em>Direction</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Direction</em>' attribute is set.
   * @see #unsetDirection()
   * @see #getDirection()
   * @see #setDirection(String)
   * @generated
   */
  boolean isSetDirection();

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

} // DataMapping
