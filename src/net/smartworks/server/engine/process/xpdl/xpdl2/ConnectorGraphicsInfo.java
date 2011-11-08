/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConnectorGraphicsInfo.java,v 1.1 2009/12/22 06:18:38 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Graphics Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getToolId <em>Tool Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#isIsVisible <em>Is Visible</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getPage <em>Page</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getStyle <em>Style</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getFillColor <em>Fill Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ConnectorGraphicsInfo extends Serializable
{
  /**
   * Returns the value of the '<em><b>Coordinates</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN and XPDL
   * <!-- end-model-doc -->
   * @return the value of the '<em>Coordinates</em>' containment reference list.
   * @generated
   */
  List getCoordinates();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getToolId <em>Tool Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getToolId <em>Tool Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetToolId()
   * @see #getToolId()
   * @see #setToolId(String)
   * @generated
   */
  void unsetToolId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getToolId <em>Tool Id</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Is Visible</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Visible</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Visible</em>' attribute.
   * @see #isSetIsVisible()
   * @see #unsetIsVisible()
   * @see #setIsVisible(boolean)
   * @generated
   */
  boolean isIsVisible();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#isIsVisible <em>Is Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Visible</em>' attribute.
   * @see #isSetIsVisible()
   * @see #unsetIsVisible()
   * @see #isIsVisible()
   * @generated
   */
  void setIsVisible(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#isIsVisible <em>Is Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIsVisible()
   * @see #isIsVisible()
   * @see #setIsVisible(boolean)
   * @generated
   */
  void unsetIsVisible();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#isIsVisible <em>Is Visible</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Is Visible</em>' attribute is set.
   * @see #unsetIsVisible()
   * @see #isIsVisible()
   * @see #setIsVisible(boolean)
   * @generated
   */
  boolean isSetIsVisible();

  /**
   * Returns the value of the '<em><b>Page</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Page</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Page</em>' attribute.
   * @see #isSetPage()
   * @see #unsetPage()
   * @see #setPage(String)
   * @generated
   */
  String getPage();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getPage <em>Page</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Page</em>' attribute.
   * @see #isSetPage()
   * @see #unsetPage()
   * @see #getPage()
   * @generated
   */
  void setPage(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getPage <em>Page</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPage()
   * @see #getPage()
   * @see #setPage(String)
   * @generated
   */
  void unsetPage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getPage <em>Page</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Page</em>' attribute is set.
   * @see #unsetPage()
   * @see #getPage()
   * @see #setPage(String)
   * @generated
   */
  boolean isSetPage();

  /**
   * Returns the value of the '<em><b>Style</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Style</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Style</em>' attribute.
   * @see #isSetStyle()
   * @see #unsetStyle()
   * @see #setStyle(String)
   * @generated
   */
  String getStyle();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getStyle <em>Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Style</em>' attribute.
   * @see #isSetStyle()
   * @see #unsetStyle()
   * @see #getStyle()
   * @generated
   */
  void setStyle(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getStyle <em>Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStyle()
   * @see #getStyle()
   * @see #setStyle(String)
   * @generated
   */
  void unsetStyle();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getStyle <em>Style</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Style</em>' attribute is set.
   * @see #unsetStyle()
   * @see #getStyle()
   * @see #setStyle(String)
   * @generated
   */
  boolean isSetStyle();

  /**
   * Returns the value of the '<em><b>Border Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Border Color</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Border Color</em>' attribute.
   * @see #isSetBorderColor()
   * @see #unsetBorderColor()
   * @see #setBorderColor(String)
   * @generated
   */
  String getBorderColor();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getBorderColor <em>Border Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Border Color</em>' attribute.
   * @see #isSetBorderColor()
   * @see #unsetBorderColor()
   * @see #getBorderColor()
   * @generated
   */
  void setBorderColor(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getBorderColor <em>Border Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBorderColor()
   * @see #getBorderColor()
   * @see #setBorderColor(String)
   * @generated
   */
  void unsetBorderColor();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getBorderColor <em>Border Color</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Border Color</em>' attribute is set.
   * @see #unsetBorderColor()
   * @see #getBorderColor()
   * @see #setBorderColor(String)
   * @generated
   */
  boolean isSetBorderColor();

  /**
   * Returns the value of the '<em><b>Fill Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fill Color</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fill Color</em>' attribute.
   * @see #isSetFillColor()
   * @see #unsetFillColor()
   * @see #setFillColor(String)
   * @generated
   */
  String getFillColor();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getFillColor <em>Fill Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fill Color</em>' attribute.
   * @see #isSetFillColor()
   * @see #unsetFillColor()
   * @see #getFillColor()
   * @generated
   */
  void setFillColor(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getFillColor <em>Fill Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFillColor()
   * @see #getFillColor()
   * @see #setFillColor(String)
   * @generated
   */
  void unsetFillColor();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo#getFillColor <em>Fill Color</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Fill Color</em>' attribute is set.
   * @see #unsetFillColor()
   * @see #getFillColor()
   * @see #setFillColor(String)
   * @generated
   */
  boolean isSetFillColor();

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

} // ConnectorGraphicsInfo
