/**
 * <copyright>
 * </copyright>
 *
 * $Id: Route.java,v 1.1 2009/12/22 06:18:34 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#getGatewayType <em>Gateway Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isInstantiate <em>Instantiate</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isMarkerVisible <em>Marker Visible</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Route extends Serializable
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
   * Returns the value of the '<em><b>Gateway Type</b></em>' attribute.
   * The default value is <code>"XOR"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Used when needed for BPMN Gateways. Gate and sequence information is associated with the Transition Element.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Gateway Type</em>' attribute.
   * @see #isSetGatewayType()
   * @see #unsetGatewayType()
   * @see #setGatewayType(String)
   * @generated
   */
  String getGatewayType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#getGatewayType <em>Gateway Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gateway Type</em>' attribute.
   * @see #isSetGatewayType()
   * @see #unsetGatewayType()
   * @see #getGatewayType()
   * @generated
   */
  void setGatewayType(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#getGatewayType <em>Gateway Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetGatewayType()
   * @see #getGatewayType()
   * @see #setGatewayType(String)
   * @generated
   */
  void unsetGatewayType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#getGatewayType <em>Gateway Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Gateway Type</em>' attribute is set.
   * @see #unsetGatewayType()
   * @see #getGatewayType()
   * @see #setGatewayType(String)
   * @generated
   */
  boolean isSetGatewayType();

  /**
   * Returns the value of the '<em><b>Instantiate</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instantiate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instantiate</em>' attribute.
   * @see #isSetInstantiate()
   * @see #unsetInstantiate()
   * @see #setInstantiate(boolean)
   * @generated
   */
  boolean isInstantiate();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isInstantiate <em>Instantiate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instantiate</em>' attribute.
   * @see #isSetInstantiate()
   * @see #unsetInstantiate()
   * @see #isInstantiate()
   * @generated
   */
  void setInstantiate(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isInstantiate <em>Instantiate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetInstantiate()
   * @see #isInstantiate()
   * @see #setInstantiate(boolean)
   * @generated
   */
  void unsetInstantiate();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isInstantiate <em>Instantiate</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Instantiate</em>' attribute is set.
   * @see #unsetInstantiate()
   * @see #isInstantiate()
   * @see #setInstantiate(boolean)
   * @generated
   */
  boolean isSetInstantiate();

  /**
   * Returns the value of the '<em><b>Marker Visible</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Applicable only to XOR Gateways
   * <!-- end-model-doc -->
   * @return the value of the '<em>Marker Visible</em>' attribute.
   * @see #isSetMarkerVisible()
   * @see #unsetMarkerVisible()
   * @see #setMarkerVisible(boolean)
   * @generated
   */
  boolean isMarkerVisible();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isMarkerVisible <em>Marker Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Marker Visible</em>' attribute.
   * @see #isSetMarkerVisible()
   * @see #unsetMarkerVisible()
   * @see #isMarkerVisible()
   * @generated
   */
  void setMarkerVisible(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isMarkerVisible <em>Marker Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMarkerVisible()
   * @see #isMarkerVisible()
   * @see #setMarkerVisible(boolean)
   * @generated
   */
  void unsetMarkerVisible();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Route#isMarkerVisible <em>Marker Visible</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Marker Visible</em>' attribute is set.
   * @see #unsetMarkerVisible()
   * @see #isMarkerVisible()
   * @see #setMarkerVisible(boolean)
   * @generated
   */
  boolean isSetMarkerVisible();

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

} // Route
