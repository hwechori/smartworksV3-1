/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataField.java,v 1.1 2009/12/22 06:18:07 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDataType <em>Data Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getLength <em>Length</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getIsArray <em>Is Array</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface DataField extends Serializable
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDataType <em>Data Type</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDataType <em>Data Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataType()
   * @see #getDataType()
   * @see #setDataType(DataType)
   * @generated
   */
  void unsetDataType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDataType <em>Data Type</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Initial Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Value</em>' attribute.
   * @see #isSetInitialValue()
   * @see #unsetInitialValue()
   * @see #setInitialValue(String)
   * @generated
   */
  String getInitialValue();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getInitialValue <em>Initial Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Value</em>' attribute.
   * @see #isSetInitialValue()
   * @see #unsetInitialValue()
   * @see #getInitialValue()
   * @generated
   */
  void setInitialValue(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getInitialValue <em>Initial Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetInitialValue()
   * @see #getInitialValue()
   * @see #setInitialValue(String)
   * @generated
   */
  void unsetInitialValue();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getInitialValue <em>Initial Value</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Initial Value</em>' attribute is set.
   * @see #unsetInitialValue()
   * @see #getInitialValue()
   * @see #setInitialValue(String)
   * @generated
   */
  boolean isSetInitialValue();

  /**
   * Returns the value of the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Length</em>' attribute.
   * @see #isSetLength()
   * @see #unsetLength()
   * @see #setLength(String)
   * @generated
   */
  String getLength();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getLength <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Length</em>' attribute.
   * @see #isSetLength()
   * @see #unsetLength()
   * @see #getLength()
   * @generated
   */
  void setLength(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getLength <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLength()
   * @see #getLength()
   * @see #setLength(String)
   * @generated
   */
  void unsetLength();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getLength <em>Length</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Length</em>' attribute is set.
   * @see #unsetLength()
   * @see #getLength()
   * @see #setLength(String)
   * @generated
   */
  boolean isSetLength();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDescription <em>Description</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDescription()
   * @see #getDescription()
   * @see #setDescription(String)
   * @generated
   */
  void unsetDescription();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getDescription <em>Description</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  void unsetExtendedAttributes();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getExtendedAttributes <em>Extended Attributes</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getId <em>Id</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #setName(String)
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getName <em>Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Name</em>' attribute is set.
   * @see #unsetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  boolean isSetName();

  /**
   * Returns the value of the '<em><b>Is Array</b></em>' attribute.
   * The default value is <code>"FALSE"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Array</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Array</em>' attribute.
   * @see #isSetIsArray()
   * @see #unsetIsArray()
   * @see #setIsArray(String)
   * @generated
   */
  String getIsArray();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getIsArray <em>Is Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Array</em>' attribute.
   * @see #isSetIsArray()
   * @see #unsetIsArray()
   * @see #getIsArray()
   * @generated
   */
  void setIsArray(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getIsArray <em>Is Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIsArray()
   * @see #getIsArray()
   * @see #setIsArray(String)
   * @generated
   */
  void unsetIsArray();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataField#getIsArray <em>Is Array</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Is Array</em>' attribute is set.
   * @see #unsetIsArray()
   * @see #getIsArray()
   * @see #setIsArray(String)
   * @generated
   */
  boolean isSetIsArray();

} // DataField
