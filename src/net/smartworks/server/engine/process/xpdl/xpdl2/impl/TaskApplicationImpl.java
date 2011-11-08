/**
 * <copyright>
 * </copyright>
 *
 * $Id: TaskApplicationImpl.java,v 1.1 2009/12/22 06:17:29 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import net.smartworks.server.engine.process.xpdl.xpdl2.ActualParameters;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataMappings;
import net.smartworks.server.engine.process.xpdl.xpdl2.Description;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskApplication;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getDataMappings <em>Data Mappings</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getPackageRef <em>Package Ref</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskApplicationImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskApplicationImpl extends DataObjectBase implements TaskApplication
{

  public final static int ACTUAL_PARAMETERS = 0;

  public final static int DATA_MAPPINGS = 1;

  public final static int DESCRIPTION = 2;

  public final static int ANY = -1;

  public final static int ID = 3;

  public final static int NAME = 4;

  public final static int PACKAGE_REF = 5;

  public final static int ANY_ATTRIBUTE = -2;
// FIXME -1
  public final static int SDO_PROPERTY_COUNT = 7;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Actual Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTUAL_PARAMETERS = 0;

  /**
   * The internal feature id for the '<em><b>Data Mappings</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_MAPPINGS = 1;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 4;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 5;

  /**
   * The internal feature id for the '<em><b>Package Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PACKAGE_REF = 6;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 7;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 9;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_ACTUAL_PARAMETERS: return ACTUAL_PARAMETERS;
      case INTERNAL_DATA_MAPPINGS: return DATA_MAPPINGS;
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_PACKAGE_REF: return PACKAGE_REF;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
      case INTERNAL_VERSION: return VERSION;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getActualParameters() <em>Actual Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActualParameters()
   * @generated
   * @ordered
   */
  
  protected ActualParameters actualParameters = null;
  
  /**
   * This is true if the Actual Parameters containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean actualParameters_set_ = false;

  /**
   * The cached value of the '{@link #getDataMappings() <em>Data Mappings</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataMappings()
   * @generated
   * @ordered
   */
  
  protected DataMappings dataMappings = null;
  
  /**
   * This is true if the Data Mappings containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataMappings_set_ = false;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  
  protected Description description = null;
  
  /**
   * This is true if the Description containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean description_set_ = false;

  /**
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  
  protected Sequence any = null;
  
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
   * The default value of the '{@link #getPackageRef() <em>Package Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageRef()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_REF_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPackageRef() <em>Package Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageRef()
   * @generated
   * @ordered
   */
  protected String packageRef = PACKAGE_REF_DEFAULT_;

  /**
   * This is true if the Package Ref attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean packageRef_set_ = false;

  /**
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  
  protected Sequence anyAttribute = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskApplicationImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getTaskApplication();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualParameters getActualParameters()
  {
    return actualParameters;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActualParameters(ActualParameters newActualParameters, ChangeContext changeContext)
  {
    ActualParameters oldActualParameters = actualParameters;
    actualParameters = newActualParameters;
    boolean oldActualParameters_set_ = actualParameters_set_;
    actualParameters_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTUAL_PARAMETERS, oldActualParameters, newActualParameters, !oldActualParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActualParameters(ActualParameters newActualParameters)
  {
    if (newActualParameters != actualParameters)
    {
      ChangeContext changeContext = null;
      if (actualParameters != null)
        changeContext = inverseRemove(actualParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL_PARAMETERS, null, changeContext);
      if (newActualParameters != null)
        changeContext = inverseAdd(newActualParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL_PARAMETERS, null, changeContext);
      changeContext = basicSetActualParameters(newActualParameters, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActualParameters_set_ = actualParameters_set_;
      actualParameters_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTUAL_PARAMETERS, newActualParameters, newActualParameters, !oldActualParameters_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActualParameters(ChangeContext changeContext)
  {
    ActualParameters oldActualParameters = actualParameters;
    actualParameters = null;
    boolean oldActualParameters_set_ = actualParameters_set_;
    actualParameters_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTUAL_PARAMETERS, oldActualParameters, null, !oldActualParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActualParameters()
  {
    if (actualParameters != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(actualParameters, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL_PARAMETERS, null, changeContext);
      changeContext = basicUnsetActualParameters(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActualParameters_set_ = actualParameters_set_;
      actualParameters_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTUAL_PARAMETERS, null, null, oldActualParameters_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActualParameters()
  {
    return actualParameters_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataMappings getDataMappings()
  {
    return dataMappings;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataMappings(DataMappings newDataMappings, ChangeContext changeContext)
  {
    DataMappings oldDataMappings = dataMappings;
    dataMappings = newDataMappings;
    boolean oldDataMappings_set_ = dataMappings_set_;
    dataMappings_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_MAPPINGS, oldDataMappings, newDataMappings, !oldDataMappings_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataMappings(DataMappings newDataMappings)
  {
    if (newDataMappings != dataMappings)
    {
      ChangeContext changeContext = null;
      if (dataMappings != null)
        changeContext = inverseRemove(dataMappings, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_MAPPINGS, null, changeContext);
      if (newDataMappings != null)
        changeContext = inverseAdd(newDataMappings, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_MAPPINGS, null, changeContext);
      changeContext = basicSetDataMappings(newDataMappings, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataMappings_set_ = dataMappings_set_;
      dataMappings_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_MAPPINGS, newDataMappings, newDataMappings, !oldDataMappings_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataMappings(ChangeContext changeContext)
  {
    DataMappings oldDataMappings = dataMappings;
    dataMappings = null;
    boolean oldDataMappings_set_ = dataMappings_set_;
    dataMappings_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_MAPPINGS, oldDataMappings, null, !oldDataMappings_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataMappings()
  {
    if (dataMappings != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataMappings, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_MAPPINGS, null, changeContext);
      changeContext = basicUnsetDataMappings(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataMappings_set_ = dataMappings_set_;
      dataMappings_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_MAPPINGS, null, null, oldDataMappings_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataMappings()
  {
    return dataMappings_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description getDescription()
  {
    return description;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDescription(Description newDescription, ChangeContext changeContext)
  {
    Description oldDescription = description;
    description = newDescription;
    boolean oldDescription_set_ = description_set_;
    description_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DESCRIPTION, oldDescription, newDescription, !oldDescription_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(Description newDescription)
  {
    if (newDescription != description)
    {
      ChangeContext changeContext = null;
      if (description != null)
        changeContext = inverseRemove(description, this, OPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      if (newDescription != null)
        changeContext = inverseAdd(newDescription, this, OPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      changeContext = basicSetDescription(newDescription, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDescription_set_ = description_set_;
      description_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DESCRIPTION, newDescription, newDescription, !oldDescription_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDescription(ChangeContext changeContext)
  {
    Description oldDescription = description;
    description = null;
    boolean oldDescription_set_ = description_set_;
    description_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DESCRIPTION, oldDescription, null, !oldDescription_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDescription()
  {
    if (description != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(description, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      changeContext = basicUnsetDescription(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDescription_set_ = description_set_;
      description_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DESCRIPTION, null, null, oldDescription_set_);
    	}
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
  public Sequence getAny()
  {
    if (any == null)
    {
      any = createSequence(INTERNAL_ANY);
    }
    return any;
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
  public String getPackageRef()
  {
    return packageRef;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackageRef(String newPackageRef)
  {
    String oldPackageRef = packageRef;
    packageRef = newPackageRef;
    boolean oldPackageRef_set_ = packageRef_set_;
    packageRef_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PACKAGE_REF, oldPackageRef, packageRef, !oldPackageRef_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPackageRef()
  {
    String oldPackageRef = packageRef;
    boolean oldPackageRef_set_ = packageRef_set_;
    packageRef = PACKAGE_REF_DEFAULT_;
    packageRef_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PACKAGE_REF, oldPackageRef, PACKAGE_REF_DEFAULT_, oldPackageRef_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPackageRef()
  {
    return packageRef_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAnyAttribute()
  {
    if (anyAttribute == null)
    {
      anyAttribute = createSequence(INTERNAL_ANY_ATTRIBUTE);
    }
    return anyAttribute;
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
      case ACTUAL_PARAMETERS:
        return basicUnsetActualParameters(changeContext);
      case DATA_MAPPINGS:
        return basicUnsetDataMappings(changeContext);
      case DESCRIPTION:
        return basicUnsetDescription(changeContext);
      case ANY:
        return removeFromSequence(getAny(), otherEnd, changeContext);
      case ANY_ATTRIBUTE:
        return removeFromSequence(getAnyAttribute(), otherEnd, changeContext);
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
      case ACTUAL_PARAMETERS:
        return getActualParameters();
      case DATA_MAPPINGS:
        return getDataMappings();
      case DESCRIPTION:
        return getDescription();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ID:
        return getId();
      case NAME:
        return getName();
      case PACKAGE_REF:
        return getPackageRef();
      case ANY_ATTRIBUTE:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAnyAttribute();
      case VERSION:
    	return this.getVersion();
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
      case ACTUAL_PARAMETERS:
        setActualParameters((ActualParameters)newValue);
        return;
      case DATA_MAPPINGS:
        setDataMappings((DataMappings)newValue);
        return;
      case DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case NAME:
        setName((String)newValue);
        return;
      case PACKAGE_REF:
        setPackageRef((String)newValue);
        return;
      case ANY_ATTRIBUTE:
      	setSequence(getAnyAttribute(), newValue);
        return;
      case VERSION:
    	setVersion((String)newValue);
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
      case ACTUAL_PARAMETERS:
        unsetActualParameters();
        return;
      case DATA_MAPPINGS:
        unsetDataMappings();
        return;
      case DESCRIPTION:
        unsetDescription();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case ID:
        unsetId();
        return;
      case NAME:
        unsetName();
        return;
      case PACKAGE_REF:
        unsetPackageRef();
        return;
      case ANY_ATTRIBUTE:
        unsetSequence(getAnyAttribute());
        return;
      case VERSION:
    	  unsetVersion();
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
      case ACTUAL_PARAMETERS:
        return isSetActualParameters();
      case DATA_MAPPINGS:
        return isSetDataMappings();
      case DESCRIPTION:
        return isSetDescription();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case PACKAGE_REF:
        return isSetPackageRef();
      case ANY_ATTRIBUTE:
        return anyAttribute != null && !isSequenceEmpty(getAnyAttribute());
      case VERSION:
    	return isSetVersion();
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
    result.append(" (any: ");
    result.append(any);
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", PackageRef: ");
    if (packageRef_set_) result.append(packageRef); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

  public final static int VERSION = 6;
  public final static int INTERNAL_VERSION = 8;
  
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String VERSION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String version = VERSION_DEFAULT_;
  
  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean version_set_ = false;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVersion()
  {
	  Sequence seq = this.getAnyAttribute();
	  for (int i = 0; i < seq.size(); i++) {
		  Property prop = seq.getProperty(i);
		  if (prop != null) {
			  if(prop.getName().equals("Version"))
				  return (String)seq.getValue(i);
		  }
	  }
	  
	  return version;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion)
  {
	  Sequence seq = this.getAnyAttribute();
	  for (int i = 0; i < seq.size(); i++) {
		  Property prop = seq.getProperty(i);
		  if (prop != null) {
			  if(prop.getName().equals("Version")) {
				  seq.setValue(i, newVersion);
				  break;
			  }
		  }
	  }	  
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVersion()
  {
    String oldVersion = version;
    boolean oldVersion_set_ = version_set_;
    version = VERSION_DEFAULT_;
    version_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_VERSION, oldVersion, VERSION_DEFAULT_, oldVersion_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetVersion()
  {
    return version_set_;
  }

} //TaskApplicationImpl
