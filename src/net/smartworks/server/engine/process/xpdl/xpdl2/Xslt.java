/**
 * <copyright>
 * </copyright>
 *
 * $Id: Xslt.java,v 1.1 2009/12/22 06:18:31 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xslt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Xslt#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Xslt#getLocation <em>Location</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Xslt#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Xslt extends Serializable
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
   * Returns the value of the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' attribute.
   * @see #isSetLocation()
   * @see #unsetLocation()
   * @see #setLocation(String)
   * @generated
   */
  String getLocation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Xslt#getLocation <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' attribute.
   * @see #isSetLocation()
   * @see #unsetLocation()
   * @see #getLocation()
   * @generated
   */
  void setLocation(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Xslt#getLocation <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLocation()
   * @see #getLocation()
   * @see #setLocation(String)
   * @generated
   */
  void unsetLocation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Xslt#getLocation <em>Location</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Location</em>' attribute is set.
   * @see #unsetLocation()
   * @see #getLocation()
   * @see #setLocation(String)
   * @generated
   */
  boolean isSetLocation();

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

} // Xslt
