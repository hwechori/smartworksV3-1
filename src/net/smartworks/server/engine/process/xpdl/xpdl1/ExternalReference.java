/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExternalReference.java,v 1.1 2009/12/22 06:18:08 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getXref <em>Xref</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getLocation <em>Location</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ExternalReference extends Serializable
{
  /**
   * Returns the value of the '<em><b>Xref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xref</em>' attribute.
   * @see #isSetXref()
   * @see #unsetXref()
   * @see #setXref(String)
   * @generated
   */
  String getXref();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getXref <em>Xref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xref</em>' attribute.
   * @see #isSetXref()
   * @see #unsetXref()
   * @see #getXref()
   * @generated
   */
  void setXref(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getXref <em>Xref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetXref()
   * @see #getXref()
   * @see #setXref(String)
   * @generated
   */
  void unsetXref();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getXref <em>Xref</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Xref</em>' attribute is set.
   * @see #unsetXref()
   * @see #getXref()
   * @see #setXref(String)
   * @generated
   */
  boolean isSetXref();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getLocation <em>Location</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getLocation <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLocation()
   * @see #getLocation()
   * @see #setLocation(String)
   * @generated
   */
  void unsetLocation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getLocation <em>Location</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace</em>' attribute.
   * @see #isSetNamespace()
   * @see #unsetNamespace()
   * @see #setNamespace(String)
   * @generated
   */
  String getNamespace();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getNamespace <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace</em>' attribute.
   * @see #isSetNamespace()
   * @see #unsetNamespace()
   * @see #getNamespace()
   * @generated
   */
  void setNamespace(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getNamespace <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNamespace()
   * @see #getNamespace()
   * @see #setNamespace(String)
   * @generated
   */
  void unsetNamespace();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference#getNamespace <em>Namespace</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Namespace</em>' attribute is set.
   * @see #unsetNamespace()
   * @see #getNamespace()
   * @see #setNamespace(String)
   * @generated
   */
  boolean isSetNamespace();

} // ExternalReference
