/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataObjectImpl.java,v 1.1 2009/12/22 06:17:51 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.DataFields;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataObject;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#getState <em>State</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#isRequiredForStart <em>Required For Start</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#isProducedAtCompletion <em>Produced At Completion</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataObjectImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataObjectImpl extends DataObjectBase implements DataObject
{

  public final static int DATA_FIELDS = 0;

  public final static int ANY = -1;

  public final static int ID = 1;

  public final static int NAME = 2;

  public final static int STATE = 3;

  public final static int REQUIRED_FOR_START = 4;

  public final static int PRODUCED_AT_COMPLETION = 5;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 6;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Data Fields</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_FIELDS = 0;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 1;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 2;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 3;

  /**
   * The internal feature id for the '<em><b>State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_STATE = 4;

  /**
   * The internal feature id for the '<em><b>Required For Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_REQUIRED_FOR_START = 5;

  /**
   * The internal feature id for the '<em><b>Produced At Completion</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRODUCED_AT_COMPLETION = 6;

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
  public final static int INTERNAL_PROPERTY_COUNT = 8;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_DATA_FIELDS: return DATA_FIELDS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_STATE: return STATE;
      case INTERNAL_REQUIRED_FOR_START: return REQUIRED_FOR_START;
      case INTERNAL_PRODUCED_AT_COMPLETION: return PRODUCED_AT_COMPLETION;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataFields()
   * @generated
   * @ordered
   */
  
  protected DataFields dataFields = null;
  
  /**
   * This is true if the Data Fields containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataFields_set_ = false;

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
   * The default value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected static final String STATE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected String state = STATE_DEFAULT_;

  /**
   * This is true if the State attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean state_set_ = false;

  /**
   * The default value of the '{@link #isRequiredForStart() <em>Required For Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequiredForStart()
   * @generated
   * @ordered
   */
  protected static final boolean REQUIRED_FOR_START_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isRequiredForStart() <em>Required For Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequiredForStart()
   * @generated
   * @ordered
   */
  protected boolean requiredForStart = REQUIRED_FOR_START_DEFAULT_;

  /**
   * This is true if the Required For Start attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean requiredForStart_set_ = false;

  /**
   * The default value of the '{@link #isProducedAtCompletion() <em>Produced At Completion</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isProducedAtCompletion()
   * @generated
   * @ordered
   */
  protected static final boolean PRODUCED_AT_COMPLETION_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isProducedAtCompletion() <em>Produced At Completion</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isProducedAtCompletion()
   * @generated
   * @ordered
   */
  protected boolean producedAtCompletion = PRODUCED_AT_COMPLETION_DEFAULT_;

  /**
   * This is true if the Produced At Completion attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean producedAtCompletion_set_ = false;

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
  public DataObjectImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getDataObject();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataFields getDataFields()
  {
    return dataFields;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataFields(DataFields newDataFields, ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = newDataFields;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_FIELDS, oldDataFields, newDataFields, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataFields(DataFields newDataFields)
  {
    if (newDataFields != dataFields)
    {
      ChangeContext changeContext = null;
      if (dataFields != null)
        changeContext = inverseRemove(dataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      if (newDataFields != null)
        changeContext = inverseAdd(newDataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicSetDataFields(newDataFields, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_FIELDS, newDataFields, newDataFields, !oldDataFields_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataFields(ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = null;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_FIELDS, oldDataFields, null, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataFields()
  {
    if (dataFields != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataFields, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicUnsetDataFields(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_FIELDS, null, null, oldDataFields_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataFields()
  {
    return dataFields_set_;
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
  public String getState()
  {
    return state;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(String newState)
  {
    String oldState = state;
    state = newState;
    boolean oldState_set_ = state_set_;
    state_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_STATE, oldState, state, !oldState_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetState()
  {
    String oldState = state;
    boolean oldState_set_ = state_set_;
    state = STATE_DEFAULT_;
    state_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_STATE, oldState, STATE_DEFAULT_, oldState_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetState()
  {
    return state_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRequiredForStart()
  {
    return requiredForStart;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequiredForStart(boolean newRequiredForStart)
  {
    boolean oldRequiredForStart = requiredForStart;
    requiredForStart = newRequiredForStart;
    boolean oldRequiredForStart_set_ = requiredForStart_set_;
    requiredForStart_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_REQUIRED_FOR_START, oldRequiredForStart, requiredForStart, !oldRequiredForStart_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRequiredForStart()
  {
    boolean oldRequiredForStart = requiredForStart;
    boolean oldRequiredForStart_set_ = requiredForStart_set_;
    requiredForStart = REQUIRED_FOR_START_DEFAULT_;
    requiredForStart_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_REQUIRED_FOR_START, oldRequiredForStart, REQUIRED_FOR_START_DEFAULT_, oldRequiredForStart_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRequiredForStart()
  {
    return requiredForStart_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isProducedAtCompletion()
  {
    return producedAtCompletion;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProducedAtCompletion(boolean newProducedAtCompletion)
  {
    boolean oldProducedAtCompletion = producedAtCompletion;
    producedAtCompletion = newProducedAtCompletion;
    boolean oldProducedAtCompletion_set_ = producedAtCompletion_set_;
    producedAtCompletion_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PRODUCED_AT_COMPLETION, oldProducedAtCompletion, producedAtCompletion, !oldProducedAtCompletion_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetProducedAtCompletion()
  {
    boolean oldProducedAtCompletion = producedAtCompletion;
    boolean oldProducedAtCompletion_set_ = producedAtCompletion_set_;
    producedAtCompletion = PRODUCED_AT_COMPLETION_DEFAULT_;
    producedAtCompletion_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PRODUCED_AT_COMPLETION, oldProducedAtCompletion, PRODUCED_AT_COMPLETION_DEFAULT_, oldProducedAtCompletion_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetProducedAtCompletion()
  {
    return producedAtCompletion_set_;
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
      case DATA_FIELDS:
        return basicUnsetDataFields(changeContext);
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
      case DATA_FIELDS:
        return getDataFields();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ID:
        return getId();
      case NAME:
        return getName();
      case STATE:
        return getState();
      case REQUIRED_FOR_START:
        return isRequiredForStart() ? Boolean.TRUE : Boolean.FALSE;
      case PRODUCED_AT_COMPLETION:
        return isProducedAtCompletion() ? Boolean.TRUE : Boolean.FALSE;
      case ANY_ATTRIBUTE:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAnyAttribute();
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
      case DATA_FIELDS:
        setDataFields((DataFields)newValue);
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
      case STATE:
        setState((String)newValue);
        return;
      case REQUIRED_FOR_START:
        setRequiredForStart(((Boolean)newValue).booleanValue());
        return;
      case PRODUCED_AT_COMPLETION:
        setProducedAtCompletion(((Boolean)newValue).booleanValue());
        return;
      case ANY_ATTRIBUTE:
      	setSequence(getAnyAttribute(), newValue);
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
      case DATA_FIELDS:
        unsetDataFields();
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
      case STATE:
        unsetState();
        return;
      case REQUIRED_FOR_START:
        unsetRequiredForStart();
        return;
      case PRODUCED_AT_COMPLETION:
        unsetProducedAtCompletion();
        return;
      case ANY_ATTRIBUTE:
        unsetSequence(getAnyAttribute());
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
      case DATA_FIELDS:
        return isSetDataFields();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case STATE:
        return isSetState();
      case REQUIRED_FOR_START:
        return isSetRequiredForStart();
      case PRODUCED_AT_COMPLETION:
        return isSetProducedAtCompletion();
      case ANY_ATTRIBUTE:
        return anyAttribute != null && !isSequenceEmpty(getAnyAttribute());
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
    result.append(", State: ");
    if (state_set_) result.append(state); else result.append("<unset>");
    result.append(", RequiredForStart: ");
    if (requiredForStart_set_) result.append(requiredForStart); else result.append("<unset>");
    result.append(", ProducedAtCompletion: ");
    if (producedAtCompletion_set_) result.append(producedAtCompletion); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //DataObjectImpl
