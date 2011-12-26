/**
 * <copyright>
 * </copyright>
 *
 * $Id: EndPoint.java,v 1.1 2009/12/22 06:18:15 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getEndPointType <em>End Point Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface EndPoint extends Serializable
{
  /**
   * Returns the value of the '<em><b>External Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Reference</em>' containment reference.
   * @see #isSetExternalReference()
   * @see #unsetExternalReference()
   * @see #setExternalReference(ExternalReference)
   * @generated
   */
  ExternalReference getExternalReference();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getExternalReference <em>External Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>External Reference</em>' containment reference.
   * @see #isSetExternalReference()
   * @see #unsetExternalReference()
   * @see #getExternalReference()
   * @generated
   */
  void setExternalReference(ExternalReference value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getExternalReference <em>External Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExternalReference()
   * @see #getExternalReference()
   * @see #setExternalReference(ExternalReference)
   * @generated
   */
  void unsetExternalReference();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getExternalReference <em>External Reference</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>External Reference</em>' containment reference is set.
   * @see #unsetExternalReference()
   * @see #getExternalReference()
   * @see #setExternalReference(ExternalReference)
   * @generated
   */
  boolean isSetExternalReference();

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
   * Returns the value of the '<em><b>End Point Type</b></em>' attribute.
   * The default value is <code>"WSDL"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Point Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Point Type</em>' attribute.
   * @see #isSetEndPointType()
   * @see #unsetEndPointType()
   * @see #setEndPointType(String)
   * @generated
   */
  String getEndPointType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getEndPointType <em>End Point Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Point Type</em>' attribute.
   * @see #isSetEndPointType()
   * @see #unsetEndPointType()
   * @see #getEndPointType()
   * @generated
   */
  void setEndPointType(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getEndPointType <em>End Point Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEndPointType()
   * @see #getEndPointType()
   * @see #setEndPointType(String)
   * @generated
   */
  void unsetEndPointType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint#getEndPointType <em>End Point Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>End Point Type</em>' attribute is set.
   * @see #unsetEndPointType()
   * @see #getEndPointType()
   * @see #setEndPointType(String)
   * @generated
   */
  boolean isSetEndPointType();

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

} // EndPoint
