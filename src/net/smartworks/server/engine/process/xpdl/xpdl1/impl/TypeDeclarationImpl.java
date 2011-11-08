/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeDeclarationImpl.java,v 1.1 2009/12/22 06:17:15 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.ArrayType;
import net.smartworks.server.engine.process.xpdl.xpdl1.BasicType;
import net.smartworks.server.engine.process.xpdl.xpdl1.DeclaredType;
import net.smartworks.server.engine.process.xpdl.xpdl1.EnumerationType;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference;
import net.smartworks.server.engine.process.xpdl.xpdl1.ListType;
import net.smartworks.server.engine.process.xpdl.xpdl1.RecordType;
import net.smartworks.server.engine.process.xpdl.xpdl1.SchemaType;
import net.smartworks.server.engine.process.xpdl.xpdl1.TypeDeclaration;
import net.smartworks.server.engine.process.xpdl.xpdl1.UnionType;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getBasicType <em>Basic Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getSchemaType <em>Schema Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getRecordType <em>Record Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getUnionType <em>Union Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getEnumerationType <em>Enumeration Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getArrayType <em>Array Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getListType <em>List Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TypeDeclarationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeDeclarationImpl extends DataObjectBase implements TypeDeclaration
{

  public final static int BASIC_TYPE = 0;

  public final static int DECLARED_TYPE = 1;

  public final static int SCHEMA_TYPE = 2;

  public final static int EXTERNAL_REFERENCE = 3;

  public final static int RECORD_TYPE = 4;

  public final static int UNION_TYPE = 5;

  public final static int ENUMERATION_TYPE = 6;

  public final static int ARRAY_TYPE = 7;

  public final static int LIST_TYPE = 8;

  public final static int DESCRIPTION = 9;

  public final static int EXTENDED_ATTRIBUTES = 10;

  public final static int ID = 11;

  public final static int NAME = 12;

  public final static int SDO_PROPERTY_COUNT = 13;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Basic Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BASIC_TYPE = 0;

  /**
   * The internal feature id for the '<em><b>Declared Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DECLARED_TYPE = 1;

  /**
   * The internal feature id for the '<em><b>Schema Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SCHEMA_TYPE = 2;

  /**
   * The internal feature id for the '<em><b>External Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTERNAL_REFERENCE = 3;

  /**
   * The internal feature id for the '<em><b>Record Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_RECORD_TYPE = 4;

  /**
   * The internal feature id for the '<em><b>Union Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_UNION_TYPE = 5;

  /**
   * The internal feature id for the '<em><b>Enumeration Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ENUMERATION_TYPE = 6;

  /**
   * The internal feature id for the '<em><b>Array Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ARRAY_TYPE = 7;

  /**
   * The internal feature id for the '<em><b>List Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LIST_TYPE = 8;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 9;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 10;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 11;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 12;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 13;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_BASIC_TYPE: return BASIC_TYPE;
      case INTERNAL_DECLARED_TYPE: return DECLARED_TYPE;
      case INTERNAL_SCHEMA_TYPE: return SCHEMA_TYPE;
      case INTERNAL_EXTERNAL_REFERENCE: return EXTERNAL_REFERENCE;
      case INTERNAL_RECORD_TYPE: return RECORD_TYPE;
      case INTERNAL_UNION_TYPE: return UNION_TYPE;
      case INTERNAL_ENUMERATION_TYPE: return ENUMERATION_TYPE;
      case INTERNAL_ARRAY_TYPE: return ARRAY_TYPE;
      case INTERNAL_LIST_TYPE: return LIST_TYPE;
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getBasicType() <em>Basic Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBasicType()
   * @generated
   * @ordered
   */
  
  protected BasicType basicType = null;
  
  /**
   * This is true if the Basic Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean basicType_set_ = false;

  /**
   * The cached value of the '{@link #getDeclaredType() <em>Declared Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclaredType()
   * @generated
   * @ordered
   */
  
  protected DeclaredType declaredType = null;
  
  /**
   * This is true if the Declared Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean declaredType_set_ = false;

  /**
   * The cached value of the '{@link #getSchemaType() <em>Schema Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchemaType()
   * @generated
   * @ordered
   */
  
  protected SchemaType schemaType = null;
  
  /**
   * This is true if the Schema Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean schemaType_set_ = false;

  /**
   * The cached value of the '{@link #getExternalReference() <em>External Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalReference()
   * @generated
   * @ordered
   */
  
  protected ExternalReference externalReference = null;
  
  /**
   * This is true if the External Reference containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean externalReference_set_ = false;

  /**
   * The cached value of the '{@link #getRecordType() <em>Record Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordType()
   * @generated
   * @ordered
   */
  
  protected RecordType recordType = null;
  
  /**
   * This is true if the Record Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean recordType_set_ = false;

  /**
   * The cached value of the '{@link #getUnionType() <em>Union Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnionType()
   * @generated
   * @ordered
   */
  
  protected UnionType unionType = null;
  
  /**
   * This is true if the Union Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean unionType_set_ = false;

  /**
   * The cached value of the '{@link #getEnumerationType() <em>Enumeration Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerationType()
   * @generated
   * @ordered
   */
  
  protected EnumerationType enumerationType = null;
  
  /**
   * This is true if the Enumeration Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean enumerationType_set_ = false;

  /**
   * The cached value of the '{@link #getArrayType() <em>Array Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayType()
   * @generated
   * @ordered
   */
  
  protected ArrayType arrayType = null;
  
  /**
   * This is true if the Array Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean arrayType_set_ = false;

  /**
   * The cached value of the '{@link #getListType() <em>List Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListType()
   * @generated
   * @ordered
   */
  
  protected ListType listType = null;
  
  /**
   * This is true if the List Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean listType_set_ = false;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_DEFAULT_;

  /**
   * This is true if the Description attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean description_set_ = false;

  /**
   * The cached value of the '{@link #getExtendedAttributes() <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendedAttributes()
   * @generated
   * @ordered
   */
  
  protected ExtendedAttributes extendedAttributes = null;
  
  /**
   * This is true if the Extended Attributes containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extendedAttributes_set_ = false;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_DEFAULT_;

  /**
   * This is true if the Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean id_set_ = false;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_DEFAULT_;

  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean name_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclarationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getStaticType()
  {
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getTypeDeclaration();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasicType getBasicType()
  {
    return basicType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetBasicType(BasicType newBasicType, ChangeContext changeContext)
  {
    BasicType oldBasicType = basicType;
    basicType = newBasicType;
    boolean oldBasicType_set_ = basicType_set_;
    basicType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_BASIC_TYPE, oldBasicType, newBasicType, !oldBasicType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBasicType(BasicType newBasicType)
  {
    if (newBasicType != basicType)
    {
      ChangeContext changeContext = null;
      if (basicType != null)
        changeContext = inverseRemove(basicType, this, OPPOSITE_FEATURE_BASE - INTERNAL_BASIC_TYPE, null, changeContext);
      if (newBasicType != null)
        changeContext = inverseAdd(newBasicType, this, OPPOSITE_FEATURE_BASE - INTERNAL_BASIC_TYPE, null, changeContext);
      changeContext = basicSetBasicType(newBasicType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldBasicType_set_ = basicType_set_;
      basicType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_BASIC_TYPE, newBasicType, newBasicType, !oldBasicType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetBasicType(ChangeContext changeContext)
  {
    BasicType oldBasicType = basicType;
    basicType = null;
    boolean oldBasicType_set_ = basicType_set_;
    basicType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_BASIC_TYPE, oldBasicType, null, !oldBasicType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBasicType()
  {
    if (basicType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(basicType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_BASIC_TYPE, null, changeContext);
      changeContext = basicUnsetBasicType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldBasicType_set_ = basicType_set_;
      basicType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_BASIC_TYPE, null, null, oldBasicType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBasicType()
  {
    return basicType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclaredType getDeclaredType()
  {
    return declaredType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDeclaredType(DeclaredType newDeclaredType, ChangeContext changeContext)
  {
    DeclaredType oldDeclaredType = declaredType;
    declaredType = newDeclaredType;
    boolean oldDeclaredType_set_ = declaredType_set_;
    declaredType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DECLARED_TYPE, oldDeclaredType, newDeclaredType, !oldDeclaredType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclaredType(DeclaredType newDeclaredType)
  {
    if (newDeclaredType != declaredType)
    {
      ChangeContext changeContext = null;
      if (declaredType != null)
        changeContext = inverseRemove(declaredType, this, OPPOSITE_FEATURE_BASE - INTERNAL_DECLARED_TYPE, null, changeContext);
      if (newDeclaredType != null)
        changeContext = inverseAdd(newDeclaredType, this, OPPOSITE_FEATURE_BASE - INTERNAL_DECLARED_TYPE, null, changeContext);
      changeContext = basicSetDeclaredType(newDeclaredType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDeclaredType_set_ = declaredType_set_;
      declaredType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DECLARED_TYPE, newDeclaredType, newDeclaredType, !oldDeclaredType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDeclaredType(ChangeContext changeContext)
  {
    DeclaredType oldDeclaredType = declaredType;
    declaredType = null;
    boolean oldDeclaredType_set_ = declaredType_set_;
    declaredType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DECLARED_TYPE, oldDeclaredType, null, !oldDeclaredType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDeclaredType()
  {
    if (declaredType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(declaredType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DECLARED_TYPE, null, changeContext);
      changeContext = basicUnsetDeclaredType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDeclaredType_set_ = declaredType_set_;
      declaredType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DECLARED_TYPE, null, null, oldDeclaredType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDeclaredType()
  {
    return declaredType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemaType getSchemaType()
  {
    return schemaType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetSchemaType(SchemaType newSchemaType, ChangeContext changeContext)
  {
    SchemaType oldSchemaType = schemaType;
    schemaType = newSchemaType;
    boolean oldSchemaType_set_ = schemaType_set_;
    schemaType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SCHEMA_TYPE, oldSchemaType, newSchemaType, !oldSchemaType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSchemaType(SchemaType newSchemaType)
  {
    if (newSchemaType != schemaType)
    {
      ChangeContext changeContext = null;
      if (schemaType != null)
        changeContext = inverseRemove(schemaType, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCHEMA_TYPE, null, changeContext);
      if (newSchemaType != null)
        changeContext = inverseAdd(newSchemaType, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCHEMA_TYPE, null, changeContext);
      changeContext = basicSetSchemaType(newSchemaType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldSchemaType_set_ = schemaType_set_;
      schemaType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SCHEMA_TYPE, newSchemaType, newSchemaType, !oldSchemaType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetSchemaType(ChangeContext changeContext)
  {
    SchemaType oldSchemaType = schemaType;
    schemaType = null;
    boolean oldSchemaType_set_ = schemaType_set_;
    schemaType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SCHEMA_TYPE, oldSchemaType, null, !oldSchemaType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSchemaType()
  {
    if (schemaType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(schemaType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SCHEMA_TYPE, null, changeContext);
      changeContext = basicUnsetSchemaType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldSchemaType_set_ = schemaType_set_;
      schemaType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SCHEMA_TYPE, null, null, oldSchemaType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSchemaType()
  {
    return schemaType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalReference getExternalReference()
  {
    return externalReference;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExternalReference(ExternalReference newExternalReference, ChangeContext changeContext)
  {
    ExternalReference oldExternalReference = externalReference;
    externalReference = newExternalReference;
    boolean oldExternalReference_set_ = externalReference_set_;
    externalReference_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTERNAL_REFERENCE, oldExternalReference, newExternalReference, !oldExternalReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExternalReference(ExternalReference newExternalReference)
  {
    if (newExternalReference != externalReference)
    {
      ChangeContext changeContext = null;
      if (externalReference != null)
        changeContext = inverseRemove(externalReference, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_REFERENCE, null, changeContext);
      if (newExternalReference != null)
        changeContext = inverseAdd(newExternalReference, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_REFERENCE, null, changeContext);
      changeContext = basicSetExternalReference(newExternalReference, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExternalReference_set_ = externalReference_set_;
      externalReference_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTERNAL_REFERENCE, newExternalReference, newExternalReference, !oldExternalReference_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExternalReference(ChangeContext changeContext)
  {
    ExternalReference oldExternalReference = externalReference;
    externalReference = null;
    boolean oldExternalReference_set_ = externalReference_set_;
    externalReference_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTERNAL_REFERENCE, oldExternalReference, null, !oldExternalReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExternalReference()
  {
    if (externalReference != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(externalReference, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_REFERENCE, null, changeContext);
      changeContext = basicUnsetExternalReference(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExternalReference_set_ = externalReference_set_;
      externalReference_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTERNAL_REFERENCE, null, null, oldExternalReference_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExternalReference()
  {
    return externalReference_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordType getRecordType()
  {
    return recordType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetRecordType(RecordType newRecordType, ChangeContext changeContext)
  {
    RecordType oldRecordType = recordType;
    recordType = newRecordType;
    boolean oldRecordType_set_ = recordType_set_;
    recordType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_RECORD_TYPE, oldRecordType, newRecordType, !oldRecordType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordType(RecordType newRecordType)
  {
    if (newRecordType != recordType)
    {
      ChangeContext changeContext = null;
      if (recordType != null)
        changeContext = inverseRemove(recordType, this, OPPOSITE_FEATURE_BASE - INTERNAL_RECORD_TYPE, null, changeContext);
      if (newRecordType != null)
        changeContext = inverseAdd(newRecordType, this, OPPOSITE_FEATURE_BASE - INTERNAL_RECORD_TYPE, null, changeContext);
      changeContext = basicSetRecordType(newRecordType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldRecordType_set_ = recordType_set_;
      recordType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_RECORD_TYPE, newRecordType, newRecordType, !oldRecordType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetRecordType(ChangeContext changeContext)
  {
    RecordType oldRecordType = recordType;
    recordType = null;
    boolean oldRecordType_set_ = recordType_set_;
    recordType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_RECORD_TYPE, oldRecordType, null, !oldRecordType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRecordType()
  {
    if (recordType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(recordType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_RECORD_TYPE, null, changeContext);
      changeContext = basicUnsetRecordType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldRecordType_set_ = recordType_set_;
      recordType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_RECORD_TYPE, null, null, oldRecordType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRecordType()
  {
    return recordType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnionType getUnionType()
  {
    return unionType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetUnionType(UnionType newUnionType, ChangeContext changeContext)
  {
    UnionType oldUnionType = unionType;
    unionType = newUnionType;
    boolean oldUnionType_set_ = unionType_set_;
    unionType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_UNION_TYPE, oldUnionType, newUnionType, !oldUnionType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnionType(UnionType newUnionType)
  {
    if (newUnionType != unionType)
    {
      ChangeContext changeContext = null;
      if (unionType != null)
        changeContext = inverseRemove(unionType, this, OPPOSITE_FEATURE_BASE - INTERNAL_UNION_TYPE, null, changeContext);
      if (newUnionType != null)
        changeContext = inverseAdd(newUnionType, this, OPPOSITE_FEATURE_BASE - INTERNAL_UNION_TYPE, null, changeContext);
      changeContext = basicSetUnionType(newUnionType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldUnionType_set_ = unionType_set_;
      unionType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_UNION_TYPE, newUnionType, newUnionType, !oldUnionType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetUnionType(ChangeContext changeContext)
  {
    UnionType oldUnionType = unionType;
    unionType = null;
    boolean oldUnionType_set_ = unionType_set_;
    unionType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_UNION_TYPE, oldUnionType, null, !oldUnionType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetUnionType()
  {
    if (unionType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(unionType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_UNION_TYPE, null, changeContext);
      changeContext = basicUnsetUnionType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldUnionType_set_ = unionType_set_;
      unionType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_UNION_TYPE, null, null, oldUnionType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetUnionType()
  {
    return unionType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationType getEnumerationType()
  {
    return enumerationType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetEnumerationType(EnumerationType newEnumerationType, ChangeContext changeContext)
  {
    EnumerationType oldEnumerationType = enumerationType;
    enumerationType = newEnumerationType;
    boolean oldEnumerationType_set_ = enumerationType_set_;
    enumerationType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ENUMERATION_TYPE, oldEnumerationType, newEnumerationType, !oldEnumerationType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumerationType(EnumerationType newEnumerationType)
  {
    if (newEnumerationType != enumerationType)
    {
      ChangeContext changeContext = null;
      if (enumerationType != null)
        changeContext = inverseRemove(enumerationType, this, OPPOSITE_FEATURE_BASE - INTERNAL_ENUMERATION_TYPE, null, changeContext);
      if (newEnumerationType != null)
        changeContext = inverseAdd(newEnumerationType, this, OPPOSITE_FEATURE_BASE - INTERNAL_ENUMERATION_TYPE, null, changeContext);
      changeContext = basicSetEnumerationType(newEnumerationType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldEnumerationType_set_ = enumerationType_set_;
      enumerationType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ENUMERATION_TYPE, newEnumerationType, newEnumerationType, !oldEnumerationType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetEnumerationType(ChangeContext changeContext)
  {
    EnumerationType oldEnumerationType = enumerationType;
    enumerationType = null;
    boolean oldEnumerationType_set_ = enumerationType_set_;
    enumerationType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ENUMERATION_TYPE, oldEnumerationType, null, !oldEnumerationType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEnumerationType()
  {
    if (enumerationType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(enumerationType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ENUMERATION_TYPE, null, changeContext);
      changeContext = basicUnsetEnumerationType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldEnumerationType_set_ = enumerationType_set_;
      enumerationType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ENUMERATION_TYPE, null, null, oldEnumerationType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEnumerationType()
  {
    return enumerationType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayType getArrayType()
  {
    return arrayType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetArrayType(ArrayType newArrayType, ChangeContext changeContext)
  {
    ArrayType oldArrayType = arrayType;
    arrayType = newArrayType;
    boolean oldArrayType_set_ = arrayType_set_;
    arrayType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ARRAY_TYPE, oldArrayType, newArrayType, !oldArrayType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArrayType(ArrayType newArrayType)
  {
    if (newArrayType != arrayType)
    {
      ChangeContext changeContext = null;
      if (arrayType != null)
        changeContext = inverseRemove(arrayType, this, OPPOSITE_FEATURE_BASE - INTERNAL_ARRAY_TYPE, null, changeContext);
      if (newArrayType != null)
        changeContext = inverseAdd(newArrayType, this, OPPOSITE_FEATURE_BASE - INTERNAL_ARRAY_TYPE, null, changeContext);
      changeContext = basicSetArrayType(newArrayType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldArrayType_set_ = arrayType_set_;
      arrayType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ARRAY_TYPE, newArrayType, newArrayType, !oldArrayType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetArrayType(ChangeContext changeContext)
  {
    ArrayType oldArrayType = arrayType;
    arrayType = null;
    boolean oldArrayType_set_ = arrayType_set_;
    arrayType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ARRAY_TYPE, oldArrayType, null, !oldArrayType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetArrayType()
  {
    if (arrayType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(arrayType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ARRAY_TYPE, null, changeContext);
      changeContext = basicUnsetArrayType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldArrayType_set_ = arrayType_set_;
      arrayType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ARRAY_TYPE, null, null, oldArrayType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetArrayType()
  {
    return arrayType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListType getListType()
  {
    return listType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetListType(ListType newListType, ChangeContext changeContext)
  {
    ListType oldListType = listType;
    listType = newListType;
    boolean oldListType_set_ = listType_set_;
    listType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LIST_TYPE, oldListType, newListType, !oldListType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setListType(ListType newListType)
  {
    if (newListType != listType)
    {
      ChangeContext changeContext = null;
      if (listType != null)
        changeContext = inverseRemove(listType, this, OPPOSITE_FEATURE_BASE - INTERNAL_LIST_TYPE, null, changeContext);
      if (newListType != null)
        changeContext = inverseAdd(newListType, this, OPPOSITE_FEATURE_BASE - INTERNAL_LIST_TYPE, null, changeContext);
      changeContext = basicSetListType(newListType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldListType_set_ = listType_set_;
      listType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LIST_TYPE, newListType, newListType, !oldListType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetListType(ChangeContext changeContext)
  {
    ListType oldListType = listType;
    listType = null;
    boolean oldListType_set_ = listType_set_;
    listType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LIST_TYPE, oldListType, null, !oldListType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetListType()
  {
    if (listType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(listType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LIST_TYPE, null, changeContext);
      changeContext = basicUnsetListType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldListType_set_ = listType_set_;
      listType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LIST_TYPE, null, null, oldListType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetListType()
  {
    return listType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    boolean oldDescription_set_ = description_set_;
    description_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DESCRIPTION, oldDescription, description, !oldDescription_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDescription()
  {
    String oldDescription = description;
    boolean oldDescription_set_ = description_set_;
    description = DESCRIPTION_DEFAULT_;
    description_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DESCRIPTION, oldDescription, DESCRIPTION_DEFAULT_, oldDescription_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDescription()
  {
    return description_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedAttributes getExtendedAttributes()
  {
    return extendedAttributes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExtendedAttributes(ExtendedAttributes newExtendedAttributes, ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = newExtendedAttributes;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendedAttributes(ExtendedAttributes newExtendedAttributes)
  {
    if (newExtendedAttributes != extendedAttributes)
    {
      ChangeContext changeContext = null;
      if (extendedAttributes != null)
        changeContext = inverseRemove(extendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      if (newExtendedAttributes != null)
        changeContext = inverseAdd(newExtendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicSetExtendedAttributes(newExtendedAttributes, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, newExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExtendedAttributes(ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = null;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, null, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtendedAttributes()
  {
    if (extendedAttributes != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(extendedAttributes, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicUnsetExtendedAttributes(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, null, null, oldExtendedAttributes_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtendedAttributes()
  {
    return extendedAttributes_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    boolean oldId_set_ = id_set_;
    id_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ID, oldId, id, !oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetId()
  {
    String oldId = id;
    boolean oldId_set_ = id_set_;
    id = ID_DEFAULT_;
    id_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ID, oldId, ID_DEFAULT_, oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetId()
  {
    return id_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    boolean oldName_set_ = name_set_;
    name_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAME, oldName, name, !oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetName()
  {
    String oldName = name;
    boolean oldName_set_ = name_set_;
    name = NAME_DEFAULT_;
    name_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAME, oldName, NAME_DEFAULT_, oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetName()
  {
    return name_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case BASIC_TYPE:
        return basicUnsetBasicType(changeContext);
      case DECLARED_TYPE:
        return basicUnsetDeclaredType(changeContext);
      case SCHEMA_TYPE:
        return basicUnsetSchemaType(changeContext);
      case EXTERNAL_REFERENCE:
        return basicUnsetExternalReference(changeContext);
      case RECORD_TYPE:
        return basicUnsetRecordType(changeContext);
      case UNION_TYPE:
        return basicUnsetUnionType(changeContext);
      case ENUMERATION_TYPE:
        return basicUnsetEnumerationType(changeContext);
      case ARRAY_TYPE:
        return basicUnsetArrayType(changeContext);
      case LIST_TYPE:
        return basicUnsetListType(changeContext);
      case EXTENDED_ATTRIBUTES:
        return basicUnsetExtendedAttributes(changeContext);
    }
    return super.inverseRemove(otherEnd, propertyIndex, changeContext);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object get(int propertyIndex, boolean resolve)
  {
    switch (propertyIndex)
    {
      case BASIC_TYPE:
        return getBasicType();
      case DECLARED_TYPE:
        return getDeclaredType();
      case SCHEMA_TYPE:
        return getSchemaType();
      case EXTERNAL_REFERENCE:
        return getExternalReference();
      case RECORD_TYPE:
        return getRecordType();
      case UNION_TYPE:
        return getUnionType();
      case ENUMERATION_TYPE:
        return getEnumerationType();
      case ARRAY_TYPE:
        return getArrayType();
      case LIST_TYPE:
        return getListType();
      case DESCRIPTION:
        return getDescription();
      case EXTENDED_ATTRIBUTES:
        return getExtendedAttributes();
      case ID:
        return getId();
      case NAME:
        return getName();
    }
    return super.get(propertyIndex, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void set(int propertyIndex, Object newValue)
  {
    switch (propertyIndex)
    {
      case BASIC_TYPE:
        setBasicType((BasicType)newValue);
        return;
      case DECLARED_TYPE:
        setDeclaredType((DeclaredType)newValue);
        return;
      case SCHEMA_TYPE:
        setSchemaType((SchemaType)newValue);
        return;
      case EXTERNAL_REFERENCE:
        setExternalReference((ExternalReference)newValue);
        return;
      case RECORD_TYPE:
        setRecordType((RecordType)newValue);
        return;
      case UNION_TYPE:
        setUnionType((UnionType)newValue);
        return;
      case ENUMERATION_TYPE:
        setEnumerationType((EnumerationType)newValue);
        return;
      case ARRAY_TYPE:
        setArrayType((ArrayType)newValue);
        return;
      case LIST_TYPE:
        setListType((ListType)newValue);
        return;
      case DESCRIPTION:
        setDescription((String)newValue);
        return;
      case EXTENDED_ATTRIBUTES:
        setExtendedAttributes((ExtendedAttributes)newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case NAME:
        setName((String)newValue);
        return;
    }
    super.set(propertyIndex, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unset(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case BASIC_TYPE:
        unsetBasicType();
        return;
      case DECLARED_TYPE:
        unsetDeclaredType();
        return;
      case SCHEMA_TYPE:
        unsetSchemaType();
        return;
      case EXTERNAL_REFERENCE:
        unsetExternalReference();
        return;
      case RECORD_TYPE:
        unsetRecordType();
        return;
      case UNION_TYPE:
        unsetUnionType();
        return;
      case ENUMERATION_TYPE:
        unsetEnumerationType();
        return;
      case ARRAY_TYPE:
        unsetArrayType();
        return;
      case LIST_TYPE:
        unsetListType();
        return;
      case DESCRIPTION:
        unsetDescription();
        return;
      case EXTENDED_ATTRIBUTES:
        unsetExtendedAttributes();
        return;
      case ID:
        unsetId();
        return;
      case NAME:
        unsetName();
        return;
    }
    super.unset(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSet(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case BASIC_TYPE:
        return isSetBasicType();
      case DECLARED_TYPE:
        return isSetDeclaredType();
      case SCHEMA_TYPE:
        return isSetSchemaType();
      case EXTERNAL_REFERENCE:
        return isSetExternalReference();
      case RECORD_TYPE:
        return isSetRecordType();
      case UNION_TYPE:
        return isSetUnionType();
      case ENUMERATION_TYPE:
        return isSetEnumerationType();
      case ARRAY_TYPE:
        return isSetArrayType();
      case LIST_TYPE:
        return isSetListType();
      case DESCRIPTION:
        return isSetDescription();
      case EXTENDED_ATTRIBUTES:
        return isSetExtendedAttributes();
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
    }
    return super.isSet(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (isProxy(this)) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (Description: ");
    if (description_set_) result.append(description); else result.append("<unset>");
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TypeDeclarationImpl
