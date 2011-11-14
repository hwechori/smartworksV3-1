/**
 * <copyright>
 * </copyright>
 *
 * $Id: BasicType.java,v 1.1 2009/12/22 06:18:39 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getLength <em>Length</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getPrecision <em>Precision</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getScale <em>Scale</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getType_ <em>Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface BasicType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Length</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Length</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Length</em>' containment reference.
   * @see #isSetLength()
   * @see #unsetLength()
   * @see #setLength(Length)
   * @generated
   */
  Length getLength();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getLength <em>Length</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Length</em>' containment reference.
   * @see #isSetLength()
   * @see #unsetLength()
   * @see #getLength()
   * @generated
   */
  void setLength(Length value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getLength <em>Length</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLength()
   * @see #getLength()
   * @see #setLength(Length)
   * @generated
   */
  void unsetLength();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getLength <em>Length</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Length</em>' containment reference is set.
   * @see #unsetLength()
   * @see #getLength()
   * @see #setLength(Length)
   * @generated
   */
  boolean isSetLength();

  /**
   * Returns the value of the '<em><b>Precision</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Precision</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precision</em>' containment reference.
   * @see #isSetPrecision()
   * @see #unsetPrecision()
   * @see #setPrecision(Precision)
   * @generated
   */
  Precision getPrecision();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getPrecision <em>Precision</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precision</em>' containment reference.
   * @see #isSetPrecision()
   * @see #unsetPrecision()
   * @see #getPrecision()
   * @generated
   */
  void setPrecision(Precision value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getPrecision <em>Precision</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPrecision()
   * @see #getPrecision()
   * @see #setPrecision(Precision)
   * @generated
   */
  void unsetPrecision();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getPrecision <em>Precision</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Precision</em>' containment reference is set.
   * @see #unsetPrecision()
   * @see #getPrecision()
   * @see #setPrecision(Precision)
   * @generated
   */
  boolean isSetPrecision();

  /**
   * Returns the value of the '<em><b>Scale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scale</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scale</em>' containment reference.
   * @see #isSetScale()
   * @see #unsetScale()
   * @see #setScale(Scale)
   * @generated
   */
  Scale getScale();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getScale <em>Scale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scale</em>' containment reference.
   * @see #isSetScale()
   * @see #unsetScale()
   * @see #getScale()
   * @generated
   */
  void setScale(Scale value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getScale <em>Scale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetScale()
   * @see #getScale()
   * @see #setScale(Scale)
   * @generated
   */
  void unsetScale();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getScale <em>Scale</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Scale</em>' containment reference is set.
   * @see #unsetScale()
   * @see #getScale()
   * @see #setScale(Scale)
   * @generated
   */
  boolean isSetScale();

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
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #isSetType()
   * @see #unsetType()
   * @see #setType(String)
   * @generated
   */
  String getType_();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getType_ <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #isSetType()
   * @see #unsetType()
   * @see #getType_()
   * @generated
   */
  void setType(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getType_ <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetType()
   * @see #getType_()
   * @see #setType(String)
   * @generated
   */
  void unsetType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.BasicType#getType_ <em>Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Type</em>' attribute is set.
   * @see #unsetType()
   * @see #getType_()
   * @see #setType(String)
   * @generated
   */
  boolean isSetType();

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

} // BasicType
