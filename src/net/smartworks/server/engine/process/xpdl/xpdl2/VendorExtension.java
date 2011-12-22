/**
 * <copyright>
 * </copyright>
 *
 * $Id: VendorExtension.java,v 1.1 2009/12/22 06:18:36 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vendor Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getToolId <em>Tool Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getSchemaLocation <em>Schema Location</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getExtensionDescription <em>Extension Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface VendorExtension extends Serializable
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
   * Returns the value of the '<em><b>Tool Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tool Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tool Id</em>' attribute.
   * @see #isSetToolId()
   * @see #unsetToolId()
   * @see #setToolId(String)
   * @generated
   */
  String getToolId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getToolId <em>Tool Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tool Id</em>' attribute.
   * @see #isSetToolId()
   * @see #unsetToolId()
   * @see #getToolId()
   * @generated
   */
  void setToolId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getToolId <em>Tool Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetToolId()
   * @see #getToolId()
   * @see #setToolId(String)
   * @generated
   */
  void unsetToolId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getToolId <em>Tool Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Tool Id</em>' attribute is set.
   * @see #unsetToolId()
   * @see #getToolId()
   * @see #setToolId(String)
   * @generated
   */
  boolean isSetToolId();

  /**
   * Returns the value of the '<em><b>Schema Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Schema Location</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Schema Location</em>' attribute.
   * @see #isSetSchemaLocation()
   * @see #unsetSchemaLocation()
   * @see #setSchemaLocation(String)
   * @generated
   */
  String getSchemaLocation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getSchemaLocation <em>Schema Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Schema Location</em>' attribute.
   * @see #isSetSchemaLocation()
   * @see #unsetSchemaLocation()
   * @see #getSchemaLocation()
   * @generated
   */
  void setSchemaLocation(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getSchemaLocation <em>Schema Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSchemaLocation()
   * @see #getSchemaLocation()
   * @see #setSchemaLocation(String)
   * @generated
   */
  void unsetSchemaLocation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getSchemaLocation <em>Schema Location</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Schema Location</em>' attribute is set.
   * @see #unsetSchemaLocation()
   * @see #getSchemaLocation()
   * @see #setSchemaLocation(String)
   * @generated
   */
  boolean isSetSchemaLocation();

  /**
   * Returns the value of the '<em><b>Extension Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension Description</em>' attribute.
   * @see #isSetExtensionDescription()
   * @see #unsetExtensionDescription()
   * @see #setExtensionDescription(String)
   * @generated
   */
  String getExtensionDescription();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getExtensionDescription <em>Extension Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension Description</em>' attribute.
   * @see #isSetExtensionDescription()
   * @see #unsetExtensionDescription()
   * @see #getExtensionDescription()
   * @generated
   */
  void setExtensionDescription(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getExtensionDescription <em>Extension Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtensionDescription()
   * @see #getExtensionDescription()
   * @see #setExtensionDescription(String)
   * @generated
   */
  void unsetExtensionDescription();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension#getExtensionDescription <em>Extension Description</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Extension Description</em>' attribute is set.
   * @see #unsetExtensionDescription()
   * @see #getExtensionDescription()
   * @see #setExtensionDescription(String)
   * @generated
   */
  boolean isSetExtensionDescription();

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

} // VendorExtension
