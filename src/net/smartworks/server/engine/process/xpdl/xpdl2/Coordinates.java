/**
 * <copyright>
 * </copyright>
 *
 * $Id: Coordinates.java,v 1.1 2009/12/22 06:18:39 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coordinates</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getXCoordinate <em>XCoordinate</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getYCoordinate <em>YCoordinate</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Coordinates extends Serializable
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
   * Returns the value of the '<em><b>XCoordinate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XCoordinate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>XCoordinate</em>' attribute.
   * @see #isSetXCoordinate()
   * @see #unsetXCoordinate()
   * @see #setXCoordinate(double)
   * @generated
   */
  double getXCoordinate();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getXCoordinate <em>XCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>XCoordinate</em>' attribute.
   * @see #isSetXCoordinate()
   * @see #unsetXCoordinate()
   * @see #getXCoordinate()
   * @generated
   */
  void setXCoordinate(double value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getXCoordinate <em>XCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetXCoordinate()
   * @see #getXCoordinate()
   * @see #setXCoordinate(double)
   * @generated
   */
  void unsetXCoordinate();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getXCoordinate <em>XCoordinate</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>XCoordinate</em>' attribute is set.
   * @see #unsetXCoordinate()
   * @see #getXCoordinate()
   * @see #setXCoordinate(double)
   * @generated
   */
  boolean isSetXCoordinate();

  /**
   * Returns the value of the '<em><b>YCoordinate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>YCoordinate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>YCoordinate</em>' attribute.
   * @see #isSetYCoordinate()
   * @see #unsetYCoordinate()
   * @see #setYCoordinate(double)
   * @generated
   */
  double getYCoordinate();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getYCoordinate <em>YCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>YCoordinate</em>' attribute.
   * @see #isSetYCoordinate()
   * @see #unsetYCoordinate()
   * @see #getYCoordinate()
   * @generated
   */
  void setYCoordinate(double value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getYCoordinate <em>YCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetYCoordinate()
   * @see #getYCoordinate()
   * @see #setYCoordinate(double)
   * @generated
   */
  void unsetYCoordinate();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates#getYCoordinate <em>YCoordinate</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>YCoordinate</em>' attribute is set.
   * @see #unsetYCoordinate()
   * @see #getYCoordinate()
   * @see #setYCoordinate(double)
   * @generated
   */
  boolean isSetYCoordinate();

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

} // Coordinates
