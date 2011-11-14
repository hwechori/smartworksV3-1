/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeGraphicsInfo.java,v 1.1 2009/12/22 06:18:29 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Graphics Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getToolId <em>Tool Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#isIsVisible <em>Is Visible</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getPage <em>Page</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getLaneId <em>Lane Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getHeight <em>Height</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getWidth <em>Width</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getFillColor <em>Fill Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getShape <em>Shape</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface NodeGraphicsInfo extends Serializable
{
  /**
   * Returns the value of the '<em><b>Coordinates</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN and XPDL
   * <!-- end-model-doc -->
   * @return the value of the '<em>Coordinates</em>' containment reference.
   * @see #isSetCoordinates()
   * @see #unsetCoordinates()
   * @see #setCoordinates(Coordinates)
   * @generated
   */
  Coordinates getCoordinates();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getCoordinates <em>Coordinates</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Coordinates</em>' containment reference.
   * @see #isSetCoordinates()
   * @see #unsetCoordinates()
   * @see #getCoordinates()
   * @generated
   */
  void setCoordinates(Coordinates value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getCoordinates <em>Coordinates</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCoordinates()
   * @see #getCoordinates()
   * @see #setCoordinates(Coordinates)
   * @generated
   */
  void unsetCoordinates();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getCoordinates <em>Coordinates</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Coordinates</em>' containment reference is set.
   * @see #unsetCoordinates()
   * @see #getCoordinates()
   * @see #setCoordinates(Coordinates)
   * @generated
   */
  boolean isSetCoordinates();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getToolId <em>Tool Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getToolId <em>Tool Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetToolId()
   * @see #getToolId()
   * @see #setToolId(String)
   * @generated
   */
  void unsetToolId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getToolId <em>Tool Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#isIsVisible <em>Is Visible</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#isIsVisible <em>Is Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIsVisible()
   * @see #isIsVisible()
   * @see #setIsVisible(boolean)
   * @generated
   */
  void unsetIsVisible();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#isIsVisible <em>Is Visible</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getPage <em>Page</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getPage <em>Page</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPage()
   * @see #getPage()
   * @see #setPage(String)
   * @generated
   */
  void unsetPage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getPage <em>Page</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Lane Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lane Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lane Id</em>' attribute.
   * @see #isSetLaneId()
   * @see #unsetLaneId()
   * @see #setLaneId(String)
   * @generated
   */
  String getLaneId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getLaneId <em>Lane Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lane Id</em>' attribute.
   * @see #isSetLaneId()
   * @see #unsetLaneId()
   * @see #getLaneId()
   * @generated
   */
  void setLaneId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getLaneId <em>Lane Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLaneId()
   * @see #getLaneId()
   * @see #setLaneId(String)
   * @generated
   */
  void unsetLaneId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getLaneId <em>Lane Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Lane Id</em>' attribute is set.
   * @see #unsetLaneId()
   * @see #getLaneId()
   * @see #setLaneId(String)
   * @generated
   */
  boolean isSetLaneId();

  /**
   * Returns the value of the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Height</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Height</em>' attribute.
   * @see #isSetHeight()
   * @see #unsetHeight()
   * @see #setHeight(double)
   * @generated
   */
  double getHeight();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getHeight <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Height</em>' attribute.
   * @see #isSetHeight()
   * @see #unsetHeight()
   * @see #getHeight()
   * @generated
   */
  void setHeight(double value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getHeight <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetHeight()
   * @see #getHeight()
   * @see #setHeight(double)
   * @generated
   */
  void unsetHeight();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getHeight <em>Height</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Height</em>' attribute is set.
   * @see #unsetHeight()
   * @see #getHeight()
   * @see #setHeight(double)
   * @generated
   */
  boolean isSetHeight();

  /**
   * Returns the value of the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Width</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Width</em>' attribute.
   * @see #isSetWidth()
   * @see #unsetWidth()
   * @see #setWidth(double)
   * @generated
   */
  double getWidth();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getWidth <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Width</em>' attribute.
   * @see #isSetWidth()
   * @see #unsetWidth()
   * @see #getWidth()
   * @generated
   */
  void setWidth(double value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getWidth <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWidth()
   * @see #getWidth()
   * @see #setWidth(double)
   * @generated
   */
  void unsetWidth();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getWidth <em>Width</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Width</em>' attribute is set.
   * @see #unsetWidth()
   * @see #getWidth()
   * @see #setWidth(double)
   * @generated
   */
  boolean isSetWidth();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getBorderColor <em>Border Color</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getBorderColor <em>Border Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBorderColor()
   * @see #getBorderColor()
   * @see #setBorderColor(String)
   * @generated
   */
  void unsetBorderColor();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getBorderColor <em>Border Color</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getFillColor <em>Fill Color</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getFillColor <em>Fill Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFillColor()
   * @see #getFillColor()
   * @see #setFillColor(String)
   * @generated
   */
  void unsetFillColor();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getFillColor <em>Fill Color</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Shape</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shape</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shape</em>' attribute.
   * @see #isSetShape()
   * @see #unsetShape()
   * @see #setShape(String)
   * @generated
   */
  String getShape();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getShape <em>Shape</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Shape</em>' attribute.
   * @see #isSetShape()
   * @see #unsetShape()
   * @see #getShape()
   * @generated
   */
  void setShape(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getShape <em>Shape</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetShape()
   * @see #getShape()
   * @see #setShape(String)
   * @generated
   */
  void unsetShape();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo#getShape <em>Shape</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Shape</em>' attribute is set.
   * @see #unsetShape()
   * @see #getShape()
   * @see #setShape(String)
   * @generated
   */
  boolean isSetShape();

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

} // NodeGraphicsInfo
