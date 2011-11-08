/**
 * <copyright>
 * </copyright>
 *
 * $Id: BlockActivityImpl.java,v 1.1 2009/12/22 06:17:24 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BlockActivityImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BlockActivityImpl#getActivitySetId <em>Activity Set Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BlockActivityImpl#getStartActivityId <em>Start Activity Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BlockActivityImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockActivityImpl extends DataObjectBase implements BlockActivity
{

  public final static int ANY = -1;

  public final static int ACTIVITY_SET_ID = 0;

  public final static int START_ACTIVITY_ID = 1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 0;

  /**
   * The internal feature id for the '<em><b>Activity Set Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTIVITY_SET_ID = 1;

  /**
   * The internal feature id for the '<em><b>Start Activity Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_START_ACTIVITY_ID = 2;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 3;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 4;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ACTIVITY_SET_ID: return ACTIVITY_SET_ID;
      case INTERNAL_START_ACTIVITY_ID: return START_ACTIVITY_ID;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * The default value of the '{@link #getActivitySetId() <em>Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivitySetId()
   * @generated
   * @ordered
   */
  protected static final String ACTIVITY_SET_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getActivitySetId() <em>Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivitySetId()
   * @generated
   * @ordered
   */
  protected String activitySetId = ACTIVITY_SET_ID_DEFAULT_;

  /**
   * This is true if the Activity Set Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean activitySetId_set_ = false;

  /**
   * The default value of the '{@link #getStartActivityId() <em>Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartActivityId()
   * @generated
   * @ordered
   */
  protected static final String START_ACTIVITY_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getStartActivityId() <em>Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartActivityId()
   * @generated
   * @ordered
   */
  protected String startActivityId = START_ACTIVITY_ID_DEFAULT_;

  /**
   * This is true if the Start Activity Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean startActivityId_set_ = false;

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
  public BlockActivityImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getBlockActivity();
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
  public String getActivitySetId()
  {
    return activitySetId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivitySetId(String newActivitySetId)
  {
    String oldActivitySetId = activitySetId;
    activitySetId = newActivitySetId;
    boolean oldActivitySetId_set_ = activitySetId_set_;
    activitySetId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ACTIVITY_SET_ID, oldActivitySetId, activitySetId, !oldActivitySetId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActivitySetId()
  {
    String oldActivitySetId = activitySetId;
    boolean oldActivitySetId_set_ = activitySetId_set_;
    activitySetId = ACTIVITY_SET_ID_DEFAULT_;
    activitySetId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ACTIVITY_SET_ID, oldActivitySetId, ACTIVITY_SET_ID_DEFAULT_, oldActivitySetId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActivitySetId()
  {
    return activitySetId_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStartActivityId()
  {
    return startActivityId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartActivityId(String newStartActivityId)
  {
    String oldStartActivityId = startActivityId;
    startActivityId = newStartActivityId;
    boolean oldStartActivityId_set_ = startActivityId_set_;
    startActivityId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_START_ACTIVITY_ID, oldStartActivityId, startActivityId, !oldStartActivityId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStartActivityId()
  {
    String oldStartActivityId = startActivityId;
    boolean oldStartActivityId_set_ = startActivityId_set_;
    startActivityId = START_ACTIVITY_ID_DEFAULT_;
    startActivityId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_START_ACTIVITY_ID, oldStartActivityId, START_ACTIVITY_ID_DEFAULT_, oldStartActivityId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStartActivityId()
  {
    return startActivityId_set_;
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
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ACTIVITY_SET_ID:
        return getActivitySetId();
      case START_ACTIVITY_ID:
        return getStartActivityId();
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
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case ACTIVITY_SET_ID:
        setActivitySetId((String)newValue);
        return;
      case START_ACTIVITY_ID:
        setStartActivityId((String)newValue);
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
      case ANY:
        unsetSequence(getAny());
        return;
      case ACTIVITY_SET_ID:
        unsetActivitySetId();
        return;
      case START_ACTIVITY_ID:
        unsetStartActivityId();
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
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ACTIVITY_SET_ID:
        return isSetActivitySetId();
      case START_ACTIVITY_ID:
        return isSetStartActivityId();
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
    result.append(", ActivitySetId: ");
    if (activitySetId_set_) result.append(activitySetId); else result.append("<unset>");
    result.append(", StartActivityId: ");
    if (startActivityId_set_) result.append(startActivityId); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //BlockActivityImpl
