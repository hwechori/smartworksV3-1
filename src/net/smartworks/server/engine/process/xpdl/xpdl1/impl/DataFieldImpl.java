/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataFieldImpl.java,v 1.1 2009/12/22 06:17:18 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.DataField;
import net.smartworks.server.engine.process.xpdl.xpdl1.DataType;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getLength <em>Length</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DataFieldImpl#getIsArray <em>Is Array</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataFieldImpl extends DataObjectBase implements DataField
{

  public final static int DATA_TYPE = 0;

  public final static int INITIAL_VALUE = 1;

  public final static int LENGTH = 2;

  public final static int DESCRIPTION = 3;

  public final static int EXTENDED_ATTRIBUTES = 4;

  public final static int ID = 5;

  public final static int NAME = 6;

  public final static int IS_ARRAY = 7;

  public final static int SDO_PROPERTY_COUNT = 8;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Data Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_TYPE = 0;

  /**
   * The internal feature id for the '<em><b>Initial Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INITIAL_VALUE = 1;

  /**
   * The internal feature id for the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LENGTH = 2;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 3;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 4;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 5;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 6;

  /**
   * The internal feature id for the '<em><b>Is Array</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IS_ARRAY = 7;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 8;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_DATA_TYPE: return DATA_TYPE;
      case INTERNAL_INITIAL_VALUE: return INITIAL_VALUE;
      case INTERNAL_LENGTH: return LENGTH;
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_IS_ARRAY: return IS_ARRAY;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getDataType() <em>Data Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataType()
   * @generated
   * @ordered
   */
  
  protected DataType dataType = null;
  
  /**
   * This is true if the Data Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataType_set_ = false;

  /**
   * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialValue()
   * @generated
   * @ordered
   */
  protected static final String INITIAL_VALUE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialValue()
   * @generated
   * @ordered
   */
  protected String initialValue = INITIAL_VALUE_DEFAULT_;

  /**
   * This is true if the Initial Value attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean initialValue_set_ = false;

  /**
   * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected static final String LENGTH_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected String length = LENGTH_DEFAULT_;

  /**
   * This is true if the Length attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean length_set_ = false;

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
   * The default value of the '{@link #getIsArray() <em>Is Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsArray()
   * @generated
   * @ordered
   */
  protected static final String IS_ARRAY_DEFAULT_ = "FALSE";

  /**
   * The cached value of the '{@link #getIsArray() <em>Is Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsArray()
   * @generated
   * @ordered
   */
  protected String isArray = IS_ARRAY_DEFAULT_;

  /**
   * This is true if the Is Array attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean isArray_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataFieldImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getDataField();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType getDataType()
  {
    return dataType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataType(DataType newDataType, ChangeContext changeContext)
  {
    DataType oldDataType = dataType;
    dataType = newDataType;
    boolean oldDataType_set_ = dataType_set_;
    dataType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_TYPE, oldDataType, newDataType, !oldDataType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataType(DataType newDataType)
  {
    if (newDataType != dataType)
    {
      ChangeContext changeContext = null;
      if (dataType != null)
        changeContext = inverseRemove(dataType, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_TYPE, null, changeContext);
      if (newDataType != null)
        changeContext = inverseAdd(newDataType, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_TYPE, null, changeContext);
      changeContext = basicSetDataType(newDataType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataType_set_ = dataType_set_;
      dataType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_TYPE, newDataType, newDataType, !oldDataType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataType(ChangeContext changeContext)
  {
    DataType oldDataType = dataType;
    dataType = null;
    boolean oldDataType_set_ = dataType_set_;
    dataType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_TYPE, oldDataType, null, !oldDataType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataType()
  {
    if (dataType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_TYPE, null, changeContext);
      changeContext = basicUnsetDataType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataType_set_ = dataType_set_;
      dataType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_TYPE, null, null, oldDataType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataType()
  {
    return dataType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInitialValue()
  {
    return initialValue;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialValue(String newInitialValue)
  {
    String oldInitialValue = initialValue;
    initialValue = newInitialValue;
    boolean oldInitialValue_set_ = initialValue_set_;
    initialValue_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_INITIAL_VALUE, oldInitialValue, initialValue, !oldInitialValue_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetInitialValue()
  {
    String oldInitialValue = initialValue;
    boolean oldInitialValue_set_ = initialValue_set_;
    initialValue = INITIAL_VALUE_DEFAULT_;
    initialValue_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_INITIAL_VALUE, oldInitialValue, INITIAL_VALUE_DEFAULT_, oldInitialValue_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetInitialValue()
  {
    return initialValue_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLength()
  {
    return length;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLength(String newLength)
  {
    String oldLength = length;
    length = newLength;
    boolean oldLength_set_ = length_set_;
    length_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LENGTH, oldLength, length, !oldLength_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLength()
  {
    String oldLength = length;
    boolean oldLength_set_ = length_set_;
    length = LENGTH_DEFAULT_;
    length_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LENGTH, oldLength, LENGTH_DEFAULT_, oldLength_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLength()
  {
    return length_set_;
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
  public String getIsArray()
  {
    return isArray;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsArray(String newIsArray)
  {
    String oldIsArray = isArray;
    isArray = newIsArray;
    boolean oldIsArray_set_ = isArray_set_;
    isArray_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_IS_ARRAY, oldIsArray, isArray, !oldIsArray_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIsArray()
  {
    String oldIsArray = isArray;
    boolean oldIsArray_set_ = isArray_set_;
    isArray = IS_ARRAY_DEFAULT_;
    isArray_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_IS_ARRAY, oldIsArray, IS_ARRAY_DEFAULT_, oldIsArray_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIsArray()
  {
    return isArray_set_;
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
      case DATA_TYPE:
        return basicUnsetDataType(changeContext);
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
      case DATA_TYPE:
        return getDataType();
      case INITIAL_VALUE:
        return getInitialValue();
      case LENGTH:
        return getLength();
      case DESCRIPTION:
        return getDescription();
      case EXTENDED_ATTRIBUTES:
        return getExtendedAttributes();
      case ID:
        return getId();
      case NAME:
        return getName();
      case IS_ARRAY:
        return getIsArray();
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
      case DATA_TYPE:
        setDataType((DataType)newValue);
        return;
      case INITIAL_VALUE:
        setInitialValue((String)newValue);
        return;
      case LENGTH:
        setLength((String)newValue);
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
      case IS_ARRAY:
        setIsArray((String)newValue);
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
      case DATA_TYPE:
        unsetDataType();
        return;
      case INITIAL_VALUE:
        unsetInitialValue();
        return;
      case LENGTH:
        unsetLength();
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
      case IS_ARRAY:
        unsetIsArray();
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
      case DATA_TYPE:
        return isSetDataType();
      case INITIAL_VALUE:
        return isSetInitialValue();
      case LENGTH:
        return isSetLength();
      case DESCRIPTION:
        return isSetDescription();
      case EXTENDED_ATTRIBUTES:
        return isSetExtendedAttributes();
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case IS_ARRAY:
        return isSetIsArray();
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
    result.append(" (InitialValue: ");
    if (initialValue_set_) result.append(initialValue); else result.append("<unset>");
    result.append(", Length: ");
    if (length_set_) result.append(length); else result.append("<unset>");
    result.append(", Description: ");
    if (description_set_) result.append(description); else result.append("<unset>");
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", IsArray: ");
    if (isArray_set_) result.append(isArray); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //DataFieldImpl
