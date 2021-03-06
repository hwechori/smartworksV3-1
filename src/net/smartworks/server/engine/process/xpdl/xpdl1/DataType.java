/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataType.java,v 1.1 2009/12/22 06:18:04 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getBasicType <em>Basic Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getSchemaType <em>Schema Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getRecordType <em>Record Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getUnionType <em>Union Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getEnumerationType <em>Enumeration Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getArrayType <em>Array Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getListType <em>List Type</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface DataType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Basic Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Basic Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Basic Type</em>' containment reference.
   * @see #isSetBasicType()
   * @see #unsetBasicType()
   * @see #setBasicType(BasicType)
   * @generated
   */
  BasicType getBasicType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getBasicType <em>Basic Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Basic Type</em>' containment reference.
   * @see #isSetBasicType()
   * @see #unsetBasicType()
   * @see #getBasicType()
   * @generated
   */
  void setBasicType(BasicType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getBasicType <em>Basic Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBasicType()
   * @see #getBasicType()
   * @see #setBasicType(BasicType)
   * @generated
   */
  void unsetBasicType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getBasicType <em>Basic Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Basic Type</em>' containment reference is set.
   * @see #unsetBasicType()
   * @see #getBasicType()
   * @see #setBasicType(BasicType)
   * @generated
   */
  boolean isSetBasicType();

  /**
   * Returns the value of the '<em><b>Declared Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declared Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declared Type</em>' containment reference.
   * @see #isSetDeclaredType()
   * @see #unsetDeclaredType()
   * @see #setDeclaredType(DeclaredType)
   * @generated
   */
  DeclaredType getDeclaredType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getDeclaredType <em>Declared Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declared Type</em>' containment reference.
   * @see #isSetDeclaredType()
   * @see #unsetDeclaredType()
   * @see #getDeclaredType()
   * @generated
   */
  void setDeclaredType(DeclaredType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getDeclaredType <em>Declared Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDeclaredType()
   * @see #getDeclaredType()
   * @see #setDeclaredType(DeclaredType)
   * @generated
   */
  void unsetDeclaredType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getDeclaredType <em>Declared Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Declared Type</em>' containment reference is set.
   * @see #unsetDeclaredType()
   * @see #getDeclaredType()
   * @see #setDeclaredType(DeclaredType)
   * @generated
   */
  boolean isSetDeclaredType();

  /**
   * Returns the value of the '<em><b>Schema Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Schema Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Schema Type</em>' containment reference.
   * @see #isSetSchemaType()
   * @see #unsetSchemaType()
   * @see #setSchemaType(SchemaType)
   * @generated
   */
  SchemaType getSchemaType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getSchemaType <em>Schema Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Schema Type</em>' containment reference.
   * @see #isSetSchemaType()
   * @see #unsetSchemaType()
   * @see #getSchemaType()
   * @generated
   */
  void setSchemaType(SchemaType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getSchemaType <em>Schema Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSchemaType()
   * @see #getSchemaType()
   * @see #setSchemaType(SchemaType)
   * @generated
   */
  void unsetSchemaType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getSchemaType <em>Schema Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Schema Type</em>' containment reference is set.
   * @see #unsetSchemaType()
   * @see #getSchemaType()
   * @see #setSchemaType(SchemaType)
   * @generated
   */
  boolean isSetSchemaType();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getExternalReference <em>External Reference</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getExternalReference <em>External Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExternalReference()
   * @see #getExternalReference()
   * @see #setExternalReference(ExternalReference)
   * @generated
   */
  void unsetExternalReference();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getExternalReference <em>External Reference</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Record Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Type</em>' containment reference.
   * @see #isSetRecordType()
   * @see #unsetRecordType()
   * @see #setRecordType(RecordType)
   * @generated
   */
  RecordType getRecordType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getRecordType <em>Record Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record Type</em>' containment reference.
   * @see #isSetRecordType()
   * @see #unsetRecordType()
   * @see #getRecordType()
   * @generated
   */
  void setRecordType(RecordType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getRecordType <em>Record Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRecordType()
   * @see #getRecordType()
   * @see #setRecordType(RecordType)
   * @generated
   */
  void unsetRecordType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getRecordType <em>Record Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Record Type</em>' containment reference is set.
   * @see #unsetRecordType()
   * @see #getRecordType()
   * @see #setRecordType(RecordType)
   * @generated
   */
  boolean isSetRecordType();

  /**
   * Returns the value of the '<em><b>Union Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Union Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Union Type</em>' containment reference.
   * @see #isSetUnionType()
   * @see #unsetUnionType()
   * @see #setUnionType(UnionType)
   * @generated
   */
  UnionType getUnionType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getUnionType <em>Union Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Union Type</em>' containment reference.
   * @see #isSetUnionType()
   * @see #unsetUnionType()
   * @see #getUnionType()
   * @generated
   */
  void setUnionType(UnionType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getUnionType <em>Union Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetUnionType()
   * @see #getUnionType()
   * @see #setUnionType(UnionType)
   * @generated
   */
  void unsetUnionType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getUnionType <em>Union Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Union Type</em>' containment reference is set.
   * @see #unsetUnionType()
   * @see #getUnionType()
   * @see #setUnionType(UnionType)
   * @generated
   */
  boolean isSetUnionType();

  /**
   * Returns the value of the '<em><b>Enumeration Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration Type</em>' containment reference.
   * @see #isSetEnumerationType()
   * @see #unsetEnumerationType()
   * @see #setEnumerationType(EnumerationType)
   * @generated
   */
  EnumerationType getEnumerationType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getEnumerationType <em>Enumeration Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration Type</em>' containment reference.
   * @see #isSetEnumerationType()
   * @see #unsetEnumerationType()
   * @see #getEnumerationType()
   * @generated
   */
  void setEnumerationType(EnumerationType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getEnumerationType <em>Enumeration Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEnumerationType()
   * @see #getEnumerationType()
   * @see #setEnumerationType(EnumerationType)
   * @generated
   */
  void unsetEnumerationType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getEnumerationType <em>Enumeration Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Enumeration Type</em>' containment reference is set.
   * @see #unsetEnumerationType()
   * @see #getEnumerationType()
   * @see #setEnumerationType(EnumerationType)
   * @generated
   */
  boolean isSetEnumerationType();

  /**
   * Returns the value of the '<em><b>Array Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Type</em>' containment reference.
   * @see #isSetArrayType()
   * @see #unsetArrayType()
   * @see #setArrayType(ArrayType)
   * @generated
   */
  ArrayType getArrayType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getArrayType <em>Array Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Type</em>' containment reference.
   * @see #isSetArrayType()
   * @see #unsetArrayType()
   * @see #getArrayType()
   * @generated
   */
  void setArrayType(ArrayType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getArrayType <em>Array Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetArrayType()
   * @see #getArrayType()
   * @see #setArrayType(ArrayType)
   * @generated
   */
  void unsetArrayType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getArrayType <em>Array Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Array Type</em>' containment reference is set.
   * @see #unsetArrayType()
   * @see #getArrayType()
   * @see #setArrayType(ArrayType)
   * @generated
   */
  boolean isSetArrayType();

  /**
   * Returns the value of the '<em><b>List Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List Type</em>' containment reference.
   * @see #isSetListType()
   * @see #unsetListType()
   * @see #setListType(ListType)
   * @generated
   */
  ListType getListType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getListType <em>List Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List Type</em>' containment reference.
   * @see #isSetListType()
   * @see #unsetListType()
   * @see #getListType()
   * @generated
   */
  void setListType(ListType value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getListType <em>List Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetListType()
   * @see #getListType()
   * @see #setListType(ListType)
   * @generated
   */
  void unsetListType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.DataType#getListType <em>List Type</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>List Type</em>' containment reference is set.
   * @see #unsetListType()
   * @see #getListType()
   * @see #setListType(ListType)
   * @generated
   */
  boolean isSetListType();

} // DataType
