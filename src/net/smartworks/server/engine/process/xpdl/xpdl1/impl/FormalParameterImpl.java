/**
 * <copyright>
 * </copyright>
 *
 * $Id: FormalParameterImpl.java,v 1.1 2009/12/22 06:17:13 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.DataType;
import net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.FormalParameterImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.FormalParameterImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.FormalParameterImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.FormalParameterImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.FormalParameterImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalParameterImpl extends DataObjectBase implements FormalParameter
{

  public final static int DATA_TYPE = 0;

  public final static int DESCRIPTION = 1;

  public final static int ID = 2;

  public final static int INDEX = 3;

  public final static int MODE = 4;

  public final static int SDO_PROPERTY_COUNT = 5;

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
   * The internal feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 1;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 2;

  /**
   * The internal feature id for the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INDEX = 3;

  /**
   * The internal feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MODE = 4;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 5;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_DATA_TYPE: return DATA_TYPE;
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_ID: return ID;
      case INTERNAL_INDEX: return INDEX;
      case INTERNAL_MODE: return MODE;
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
   * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected static final String INDEX_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected String index = INDEX_DEFAULT_;

  /**
   * This is true if the Index attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean index_set_ = false;

  /**
   * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected static final String MODE_DEFAULT_ = "IN";

  /**
   * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected String mode = MODE_DEFAULT_;

  /**
   * This is true if the Mode attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean mode_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameterImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getFormalParameter();
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
  public String getIndex()
  {
    return index;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex(String newIndex)
  {
    String oldIndex = index;
    index = newIndex;
    boolean oldIndex_set_ = index_set_;
    index_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_INDEX, oldIndex, index, !oldIndex_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIndex()
  {
    String oldIndex = index;
    boolean oldIndex_set_ = index_set_;
    index = INDEX_DEFAULT_;
    index_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_INDEX, oldIndex, INDEX_DEFAULT_, oldIndex_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIndex()
  {
    return index_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMode()
  {
    return mode;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMode(String newMode)
  {
    String oldMode = mode;
    mode = newMode;
    boolean oldMode_set_ = mode_set_;
    mode_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_MODE, oldMode, mode, !oldMode_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMode()
  {
    String oldMode = mode;
    boolean oldMode_set_ = mode_set_;
    mode = MODE_DEFAULT_;
    mode_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_MODE, oldMode, MODE_DEFAULT_, oldMode_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMode()
  {
    return mode_set_;
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
      case DESCRIPTION:
        return getDescription();
      case ID:
        return getId();
      case INDEX:
        return getIndex();
      case MODE:
        return getMode();
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
      case DESCRIPTION:
        setDescription((String)newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case INDEX:
        setIndex((String)newValue);
        return;
      case MODE:
        setMode((String)newValue);
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
      case DESCRIPTION:
        unsetDescription();
        return;
      case ID:
        unsetId();
        return;
      case INDEX:
        unsetIndex();
        return;
      case MODE:
        unsetMode();
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
      case DESCRIPTION:
        return isSetDescription();
      case ID:
        return isSetId();
      case INDEX:
        return isSetIndex();
      case MODE:
        return isSetMode();
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
    result.append(", Index: ");
    if (index_set_) result.append(index); else result.append("<unset>");
    result.append(", Mode: ");
    if (mode_set_) result.append(mode); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //FormalParameterImpl
