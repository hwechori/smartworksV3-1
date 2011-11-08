/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExternalPackage.java,v 1.1 2009/12/22 06:18:09 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getHref <em>Href</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ExternalPackage extends Serializable
{
  /**
   * Returns the value of the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extended Attributes</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extended Attributes</em>' containment reference.
   * @see #isSetExtendedAttributes()
   * @see #unsetExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  ExtendedAttributes getExtendedAttributes();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extended Attributes</em>' containment reference.
   * @see #isSetExtendedAttributes()
   * @see #unsetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @generated
   */
  void setExtendedAttributes(ExtendedAttributes value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  void unsetExtendedAttributes();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getExtendedAttributes <em>Extended Attributes</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Extended Attributes</em>' containment reference is set.
   * @see #unsetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  boolean isSetExtendedAttributes();

  /**
   * Returns the value of the '<em><b>Href</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Href</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Href</em>' attribute.
   * @see #isSetHref()
   * @see #unsetHref()
   * @see #setHref(String)
   * @generated
   */
  String getHref();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getHref <em>Href</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Href</em>' attribute.
   * @see #isSetHref()
   * @see #unsetHref()
   * @see #getHref()
   * @generated
   */
  void setHref(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getHref <em>Href</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetHref()
   * @see #getHref()
   * @see #setHref(String)
   * @generated
   */
  void unsetHref();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage#getHref <em>Href</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Href</em>' attribute is set.
   * @see #unsetHref()
   * @see #getHref()
   * @see #setHref(String)
   * @generated
   */
  boolean isSetHref();

} // ExternalPackage
