/**
 * <copyright>
 * </copyright>
 *
 * $Id: FormalParameter.java,v 1.1 2009/12/22 06:18:05 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDataType <em>Data Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getIndex <em>Index</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface FormalParameter extends Serializable
{
  /**
   * Returns the value of the '<em><b>Data Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Type</em>' containment reference.
   * @see #isSetDataType()
   * @see #unsetDataType()
   * @see #setDataType(DataType)
   * @generated
   */
  DataType getDataType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDataType <em>Data Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Type</em>' containment reference.
   * @see #isSetDataType()
   * @see #unsetDataType()
   * @see #getDataType()
   * @generated
   */
  void setDataType(DataType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDataType <em>Data Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataType()
   * @see #getDataType()
   * @see #setDataType(DataType)
   * @generated
   */
  void unsetDataType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDataType <em>Data Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Data Type</em>' containment reference is set.
   * @see #unsetDataType()
   * @see #getDataType()
   * @see #setDataType(DataType)
   * @generated
   */
  boolean isSetDataType();

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #setDescription(String)
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDescription()
   * @see #getDescription()
   * @see #setDescription(String)
   * @generated
   */
  void unsetDescription();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getDescription <em>Description</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Description</em>' attribute is set.
   * @see #unsetDescription()
   * @see #getDescription()
   * @see #setDescription(String)
   * @generated
   */
  boolean isSetDescription();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #setId(String)
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getId <em>Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Id</em>' attribute is set.
   * @see #unsetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  boolean isSetId();

  /**
   * Returns the value of the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' attribute.
   * @see #isSetIndex()
   * @see #unsetIndex()
   * @see #setIndex(String)
   * @generated
   */
  String getIndex();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getIndex <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' attribute.
   * @see #isSetIndex()
   * @see #unsetIndex()
   * @see #getIndex()
   * @generated
   */
  void setIndex(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getIndex <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIndex()
   * @see #getIndex()
   * @see #setIndex(String)
   * @generated
   */
  void unsetIndex();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getIndex <em>Index</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Index</em>' attribute is set.
   * @see #unsetIndex()
   * @see #getIndex()
   * @see #setIndex(String)
   * @generated
   */
  boolean isSetIndex();

  /**
   * Returns the value of the '<em><b>Mode</b></em>' attribute.
   * The default value is <code>"IN"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' attribute.
   * @see #isSetMode()
   * @see #unsetMode()
   * @see #setMode(String)
   * @generated
   */
  String getMode();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getMode <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mode</em>' attribute.
   * @see #isSetMode()
   * @see #unsetMode()
   * @see #getMode()
   * @generated
   */
  void setMode(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getMode <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMode()
   * @see #getMode()
   * @see #setMode(String)
   * @generated
   */
  void unsetMode();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter#getMode <em>Mode</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Mode</em>' attribute is set.
   * @see #unsetMode()
   * @see #getMode()
   * @see #setMode(String)
   * @generated
   */
  boolean isSetMode();

} // FormalParameter
