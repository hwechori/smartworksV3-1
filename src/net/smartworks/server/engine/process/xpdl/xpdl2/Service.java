/**
 * <copyright>
 * </copyright>
 *
 * $Id: Service.java,v 1.1 2009/12/22 06:18:11 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getPortName <em>Port Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Service extends Serializable
{
  /**
   * Returns the value of the '<em><b>End Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Point</em>' containment reference.
   * @see #isSetEndPoint()
   * @see #unsetEndPoint()
   * @see #setEndPoint(EndPoint)
   * @generated
   */
  EndPoint getEndPoint();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getEndPoint <em>End Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Point</em>' containment reference.
   * @see #isSetEndPoint()
   * @see #unsetEndPoint()
   * @see #getEndPoint()
   * @generated
   */
  void setEndPoint(EndPoint value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getEndPoint <em>End Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEndPoint()
   * @see #getEndPoint()
   * @see #setEndPoint(EndPoint)
   * @generated
   */
  void unsetEndPoint();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getEndPoint <em>End Point</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>End Point</em>' containment reference is set.
   * @see #unsetEndPoint()
   * @see #getEndPoint()
   * @see #setEndPoint(EndPoint)
   * @generated
   */
  boolean isSetEndPoint();

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
   * Returns the value of the '<em><b>Service Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service Name</em>' attribute.
   * @see #isSetServiceName()
   * @see #unsetServiceName()
   * @see #setServiceName(String)
   * @generated
   */
  String getServiceName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getServiceName <em>Service Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service Name</em>' attribute.
   * @see #isSetServiceName()
   * @see #unsetServiceName()
   * @see #getServiceName()
   * @generated
   */
  void setServiceName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getServiceName <em>Service Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetServiceName()
   * @see #getServiceName()
   * @see #setServiceName(String)
   * @generated
   */
  void unsetServiceName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getServiceName <em>Service Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Service Name</em>' attribute is set.
   * @see #unsetServiceName()
   * @see #getServiceName()
   * @see #setServiceName(String)
   * @generated
   */
  boolean isSetServiceName();

  /**
   * Returns the value of the '<em><b>Port Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port Name</em>' attribute.
   * @see #isSetPortName()
   * @see #unsetPortName()
   * @see #setPortName(String)
   * @generated
   */
  String getPortName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getPortName <em>Port Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port Name</em>' attribute.
   * @see #isSetPortName()
   * @see #unsetPortName()
   * @see #getPortName()
   * @generated
   */
  void setPortName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getPortName <em>Port Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPortName()
   * @see #getPortName()
   * @see #setPortName(String)
   * @generated
   */
  void unsetPortName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Service#getPortName <em>Port Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Port Name</em>' attribute is set.
   * @see #unsetPortName()
   * @see #getPortName()
   * @see #setPortName(String)
   * @generated
   */
  boolean isSetPortName();

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

} // Service
