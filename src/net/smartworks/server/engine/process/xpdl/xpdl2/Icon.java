/**
 * <copyright>
 * </copyright>
 *
 * $Id: Icon.java,v 1.1 2009/12/22 06:18:29 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Icon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getValue <em>Value</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getXCOORD <em>XCOORD</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getYCOORD <em>YCOORD</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getWIDTH <em>WIDTH</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getHEIGHT <em>HEIGHT</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getSHAPE <em>SHAPE</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Icon extends Serializable
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #isSetValue()
   * @see #unsetValue()
   * @see #setValue(String)
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #isSetValue()
   * @see #unsetValue()
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetValue()
   * @see #getValue()
   * @see #setValue(String)
   * @generated
   */
  void unsetValue();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getValue <em>Value</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Value</em>' attribute is set.
   * @see #unsetValue()
   * @see #getValue()
   * @see #setValue(String)
   * @generated
   */
  boolean isSetValue();

  /**
   * Returns the value of the '<em><b>XCOORD</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XCOORD</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>XCOORD</em>' attribute.
   * @see #isSetXCOORD()
   * @see #unsetXCOORD()
   * @see #setXCOORD(BigInteger)
   * @generated
   */
  BigInteger getXCOORD();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getXCOORD <em>XCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>XCOORD</em>' attribute.
   * @see #isSetXCOORD()
   * @see #unsetXCOORD()
   * @see #getXCOORD()
   * @generated
   */
  void setXCOORD(BigInteger value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getXCOORD <em>XCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetXCOORD()
   * @see #getXCOORD()
   * @see #setXCOORD(BigInteger)
   * @generated
   */
  void unsetXCOORD();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getXCOORD <em>XCOORD</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>XCOORD</em>' attribute is set.
   * @see #unsetXCOORD()
   * @see #getXCOORD()
   * @see #setXCOORD(BigInteger)
   * @generated
   */
  boolean isSetXCOORD();

  /**
   * Returns the value of the '<em><b>YCOORD</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>YCOORD</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>YCOORD</em>' attribute.
   * @see #isSetYCOORD()
   * @see #unsetYCOORD()
   * @see #setYCOORD(BigInteger)
   * @generated
   */
  BigInteger getYCOORD();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getYCOORD <em>YCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>YCOORD</em>' attribute.
   * @see #isSetYCOORD()
   * @see #unsetYCOORD()
   * @see #getYCOORD()
   * @generated
   */
  void setYCOORD(BigInteger value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getYCOORD <em>YCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetYCOORD()
   * @see #getYCOORD()
   * @see #setYCOORD(BigInteger)
   * @generated
   */
  void unsetYCOORD();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getYCOORD <em>YCOORD</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>YCOORD</em>' attribute is set.
   * @see #unsetYCOORD()
   * @see #getYCOORD()
   * @see #setYCOORD(BigInteger)
   * @generated
   */
  boolean isSetYCOORD();

  /**
   * Returns the value of the '<em><b>WIDTH</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>WIDTH</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>WIDTH</em>' attribute.
   * @see #isSetWIDTH()
   * @see #unsetWIDTH()
   * @see #setWIDTH(BigInteger)
   * @generated
   */
  BigInteger getWIDTH();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getWIDTH <em>WIDTH</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>WIDTH</em>' attribute.
   * @see #isSetWIDTH()
   * @see #unsetWIDTH()
   * @see #getWIDTH()
   * @generated
   */
  void setWIDTH(BigInteger value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getWIDTH <em>WIDTH</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWIDTH()
   * @see #getWIDTH()
   * @see #setWIDTH(BigInteger)
   * @generated
   */
  void unsetWIDTH();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getWIDTH <em>WIDTH</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>WIDTH</em>' attribute is set.
   * @see #unsetWIDTH()
   * @see #getWIDTH()
   * @see #setWIDTH(BigInteger)
   * @generated
   */
  boolean isSetWIDTH();

  /**
   * Returns the value of the '<em><b>HEIGHT</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>HEIGHT</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>HEIGHT</em>' attribute.
   * @see #isSetHEIGHT()
   * @see #unsetHEIGHT()
   * @see #setHEIGHT(BigInteger)
   * @generated
   */
  BigInteger getHEIGHT();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getHEIGHT <em>HEIGHT</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>HEIGHT</em>' attribute.
   * @see #isSetHEIGHT()
   * @see #unsetHEIGHT()
   * @see #getHEIGHT()
   * @generated
   */
  void setHEIGHT(BigInteger value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getHEIGHT <em>HEIGHT</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetHEIGHT()
   * @see #getHEIGHT()
   * @see #setHEIGHT(BigInteger)
   * @generated
   */
  void unsetHEIGHT();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getHEIGHT <em>HEIGHT</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>HEIGHT</em>' attribute is set.
   * @see #unsetHEIGHT()
   * @see #getHEIGHT()
   * @see #setHEIGHT(BigInteger)
   * @generated
   */
  boolean isSetHEIGHT();

  /**
   * Returns the value of the '<em><b>SHAPE</b></em>' attribute.
   * The default value is <code>"RoundRectangle"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SHAPE</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>SHAPE</em>' attribute.
   * @see #isSetSHAPE()
   * @see #unsetSHAPE()
   * @see #setSHAPE(String)
   * @generated
   */
  String getSHAPE();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getSHAPE <em>SHAPE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>SHAPE</em>' attribute.
   * @see #isSetSHAPE()
   * @see #unsetSHAPE()
   * @see #getSHAPE()
   * @generated
   */
  void setSHAPE(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getSHAPE <em>SHAPE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSHAPE()
   * @see #getSHAPE()
   * @see #setSHAPE(String)
   * @generated
   */
  void unsetSHAPE();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.Icon#getSHAPE <em>SHAPE</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>SHAPE</em>' attribute is set.
   * @see #unsetSHAPE()
   * @see #getSHAPE()
   * @see #setSHAPE(String)
   * @generated
   */
  boolean isSetSHAPE();

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

} // Icon
