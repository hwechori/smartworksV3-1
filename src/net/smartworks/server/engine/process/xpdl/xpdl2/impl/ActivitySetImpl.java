/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivitySetImpl.java,v 1.1 2009/12/22 06:17:26 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl2.ActivitySet;
import net.smartworks.server.engine.process.xpdl.xpdl2.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getAdHocOrdering <em>Ad Hoc Ordering</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getDefaultStartActivityId <em>Default Start Activity Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ActivitySetImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivitySetImpl extends DataObjectBase implements ActivitySet
{

  public final static int ACTIVITIES = 0;

  public final static int TRANSITIONS = 1;

  public final static int OBJECT = 2;

  public final static int ANY = -1;

  public final static int ID = 3;

  public final static int NAME = 4;

  public final static int AD_HOC = 5;

  public final static int AD_HOC_ORDERING = 6;

  public final static int AD_HOC_COMPLETION_CONDITION = 7;

  public final static int DEFAULT_START_ACTIVITY_ID = 8;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 9;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Activities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTIVITIES = 0;

  /**
   * The internal feature id for the '<em><b>Transitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITIONS = 1;

  /**
   * The internal feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OBJECT = 2;

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
   * The internal feature id for the '<em><b>Ad Hoc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AD_HOC = 6;

  /**
   * The internal feature id for the '<em><b>Ad Hoc Ordering</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AD_HOC_ORDERING = 7;

  /**
   * The internal feature id for the '<em><b>Ad Hoc Completion Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AD_HOC_COMPLETION_CONDITION = 8;

  /**
   * The internal feature id for the '<em><b>Default Start Activity Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEFAULT_START_ACTIVITY_ID = 9;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 10;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 11;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_ACTIVITIES: return ACTIVITIES;
      case INTERNAL_TRANSITIONS: return TRANSITIONS;
      case INTERNAL_OBJECT: return OBJECT;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_AD_HOC: return AD_HOC;
      case INTERNAL_AD_HOC_ORDERING: return AD_HOC_ORDERING;
      case INTERNAL_AD_HOC_COMPLETION_CONDITION: return AD_HOC_COMPLETION_CONDITION;
      case INTERNAL_DEFAULT_START_ACTIVITY_ID: return DEFAULT_START_ACTIVITY_ID;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivities()
   * @generated
   * @ordered
   */
  
  protected Activities activities = null;
  
  /**
   * This is true if the Activities containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean activities_set_ = false;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  
  protected Transitions transitions = null;
  
  /**
   * This is true if the Transitions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transitions_set_ = false;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl2.Object object = null;
  
  /**
   * This is true if the Object containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean object_set_ = false;

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
   * The default value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdHoc()
   * @generated
   * @ordered
   */
  protected static final boolean AD_HOC_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdHoc()
   * @generated
   * @ordered
   */
  protected boolean adHoc = AD_HOC_DEFAULT_;

  /**
   * This is true if the Ad Hoc attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean adHoc_set_ = false;

  /**
   * The default value of the '{@link #getAdHocOrdering() <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocOrdering()
   * @generated
   * @ordered
   */
  protected static final String AD_HOC_ORDERING_DEFAULT_ = "Parallel";

  /**
   * The cached value of the '{@link #getAdHocOrdering() <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocOrdering()
   * @generated
   * @ordered
   */
  protected String adHocOrdering = AD_HOC_ORDERING_DEFAULT_;

  /**
   * This is true if the Ad Hoc Ordering attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean adHocOrdering_set_ = false;

  /**
   * The default value of the '{@link #getAdHocCompletionCondition() <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocCompletionCondition()
   * @generated
   * @ordered
   */
  protected static final String AD_HOC_COMPLETION_CONDITION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getAdHocCompletionCondition() <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdHocCompletionCondition()
   * @generated
   * @ordered
   */
  protected String adHocCompletionCondition = AD_HOC_COMPLETION_CONDITION_DEFAULT_;

  /**
   * This is true if the Ad Hoc Completion Condition attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean adHocCompletionCondition_set_ = false;

  /**
   * The default value of the '{@link #getDefaultStartActivityId() <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultStartActivityId()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_START_ACTIVITY_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDefaultStartActivityId() <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultStartActivityId()
   * @generated
   * @ordered
   */
  protected String defaultStartActivityId = DEFAULT_START_ACTIVITY_ID_DEFAULT_;

  /**
   * This is true if the Default Start Activity Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean defaultStartActivityId_set_ = false;

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
  public ActivitySetImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getActivitySet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activities getActivities()
  {
    return activities;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActivities(Activities newActivities, ChangeContext changeContext)
  {
    Activities oldActivities = activities;
    activities = newActivities;
    boolean oldActivities_set_ = activities_set_;
    activities_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTIVITIES, oldActivities, newActivities, !oldActivities_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivities(Activities newActivities)
  {
    if (newActivities != activities)
    {
      ChangeContext changeContext = null;
      if (activities != null)
        changeContext = inverseRemove(activities, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      if (newActivities != null)
        changeContext = inverseAdd(newActivities, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      changeContext = basicSetActivities(newActivities, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActivities_set_ = activities_set_;
      activities_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTIVITIES, newActivities, newActivities, !oldActivities_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActivities(ChangeContext changeContext)
  {
    Activities oldActivities = activities;
    activities = null;
    boolean oldActivities_set_ = activities_set_;
    activities_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTIVITIES, oldActivities, null, !oldActivities_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActivities()
  {
    if (activities != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(activities, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      changeContext = basicUnsetActivities(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActivities_set_ = activities_set_;
      activities_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTIVITIES, null, null, oldActivities_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActivities()
  {
    return activities_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transitions getTransitions()
  {
    return transitions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransitions(Transitions newTransitions, ChangeContext changeContext)
  {
    Transitions oldTransitions = transitions;
    transitions = newTransitions;
    boolean oldTransitions_set_ = transitions_set_;
    transitions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSITIONS, oldTransitions, newTransitions, !oldTransitions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitions(Transitions newTransitions)
  {
    if (newTransitions != transitions)
    {
      ChangeContext changeContext = null;
      if (transitions != null)
        changeContext = inverseRemove(transitions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      if (newTransitions != null)
        changeContext = inverseAdd(newTransitions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      changeContext = basicSetTransitions(newTransitions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransitions_set_ = transitions_set_;
      transitions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSITIONS, newTransitions, newTransitions, !oldTransitions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransitions(ChangeContext changeContext)
  {
    Transitions oldTransitions = transitions;
    transitions = null;
    boolean oldTransitions_set_ = transitions_set_;
    transitions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSITIONS, oldTransitions, null, !oldTransitions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransitions()
  {
    if (transitions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transitions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      changeContext = basicUnsetTransitions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransitions_set_ = transitions_set_;
      transitions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSITIONS, null, null, oldTransitions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransitions()
  {
    return transitions_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.Object getObject()
  {
    return object;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object newObject, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Object oldObject = object;
    object = newObject;
    boolean oldObject_set_ = object_set_;
    object_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_OBJECT, oldObject, newObject, !oldObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object newObject)
  {
    if (newObject != object)
    {
      ChangeContext changeContext = null;
      if (object != null)
        changeContext = inverseRemove(object, this, OPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      if (newObject != null)
        changeContext = inverseAdd(newObject, this, OPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      changeContext = basicSetObject(newObject, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldObject_set_ = object_set_;
      object_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_OBJECT, newObject, newObject, !oldObject_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetObject(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Object oldObject = object;
    object = null;
    boolean oldObject_set_ = object_set_;
    object_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_OBJECT, oldObject, null, !oldObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetObject()
  {
    if (object != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(object, this, EOPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      changeContext = basicUnsetObject(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldObject_set_ = object_set_;
      object_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_OBJECT, null, null, oldObject_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetObject()
  {
    return object_set_;
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
  public boolean isAdHoc()
  {
    return adHoc;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdHoc(boolean newAdHoc)
  {
    boolean oldAdHoc = adHoc;
    adHoc = newAdHoc;
    boolean oldAdHoc_set_ = adHoc_set_;
    adHoc_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_AD_HOC, oldAdHoc, adHoc, !oldAdHoc_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAdHoc()
  {
    boolean oldAdHoc = adHoc;
    boolean oldAdHoc_set_ = adHoc_set_;
    adHoc = AD_HOC_DEFAULT_;
    adHoc_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_AD_HOC, oldAdHoc, AD_HOC_DEFAULT_, oldAdHoc_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAdHoc()
  {
    return adHoc_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdHocOrdering()
  {
    return adHocOrdering;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdHocOrdering(String newAdHocOrdering)
  {
    String oldAdHocOrdering = adHocOrdering;
    adHocOrdering = newAdHocOrdering;
    boolean oldAdHocOrdering_set_ = adHocOrdering_set_;
    adHocOrdering_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_AD_HOC_ORDERING, oldAdHocOrdering, adHocOrdering, !oldAdHocOrdering_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAdHocOrdering()
  {
    String oldAdHocOrdering = adHocOrdering;
    boolean oldAdHocOrdering_set_ = adHocOrdering_set_;
    adHocOrdering = AD_HOC_ORDERING_DEFAULT_;
    adHocOrdering_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_AD_HOC_ORDERING, oldAdHocOrdering, AD_HOC_ORDERING_DEFAULT_, oldAdHocOrdering_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAdHocOrdering()
  {
    return adHocOrdering_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdHocCompletionCondition()
  {
    return adHocCompletionCondition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdHocCompletionCondition(String newAdHocCompletionCondition)
  {
    String oldAdHocCompletionCondition = adHocCompletionCondition;
    adHocCompletionCondition = newAdHocCompletionCondition;
    boolean oldAdHocCompletionCondition_set_ = adHocCompletionCondition_set_;
    adHocCompletionCondition_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_AD_HOC_COMPLETION_CONDITION, oldAdHocCompletionCondition, adHocCompletionCondition, !oldAdHocCompletionCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAdHocCompletionCondition()
  {
    String oldAdHocCompletionCondition = adHocCompletionCondition;
    boolean oldAdHocCompletionCondition_set_ = adHocCompletionCondition_set_;
    adHocCompletionCondition = AD_HOC_COMPLETION_CONDITION_DEFAULT_;
    adHocCompletionCondition_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_AD_HOC_COMPLETION_CONDITION, oldAdHocCompletionCondition, AD_HOC_COMPLETION_CONDITION_DEFAULT_, oldAdHocCompletionCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAdHocCompletionCondition()
  {
    return adHocCompletionCondition_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefaultStartActivityId()
  {
    return defaultStartActivityId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultStartActivityId(String newDefaultStartActivityId)
  {
    String oldDefaultStartActivityId = defaultStartActivityId;
    defaultStartActivityId = newDefaultStartActivityId;
    boolean oldDefaultStartActivityId_set_ = defaultStartActivityId_set_;
    defaultStartActivityId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DEFAULT_START_ACTIVITY_ID, oldDefaultStartActivityId, defaultStartActivityId, !oldDefaultStartActivityId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDefaultStartActivityId()
  {
    String oldDefaultStartActivityId = defaultStartActivityId;
    boolean oldDefaultStartActivityId_set_ = defaultStartActivityId_set_;
    defaultStartActivityId = DEFAULT_START_ACTIVITY_ID_DEFAULT_;
    defaultStartActivityId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DEFAULT_START_ACTIVITY_ID, oldDefaultStartActivityId, DEFAULT_START_ACTIVITY_ID_DEFAULT_, oldDefaultStartActivityId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDefaultStartActivityId()
  {
    return defaultStartActivityId_set_;
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
      case ACTIVITIES:
        return basicUnsetActivities(changeContext);
      case TRANSITIONS:
        return basicUnsetTransitions(changeContext);
      case OBJECT:
        return basicUnsetObject(changeContext);
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
      case ACTIVITIES:
        return getActivities();
      case TRANSITIONS:
        return getTransitions();
      case OBJECT:
        return getObject();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ID:
        return getId();
      case NAME:
        return getName();
      case AD_HOC:
        return isAdHoc() ? Boolean.TRUE : Boolean.FALSE;
      case AD_HOC_ORDERING:
        return getAdHocOrdering();
      case AD_HOC_COMPLETION_CONDITION:
        return getAdHocCompletionCondition();
      case DEFAULT_START_ACTIVITY_ID:
        return getDefaultStartActivityId();
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
      case ACTIVITIES:
        setActivities((Activities)newValue);
        return;
      case TRANSITIONS:
        setTransitions((Transitions)newValue);
        return;
      case OBJECT:
        setObject((net.smartworks.server.engine.process.xpdl.xpdl2.Object)newValue);
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
      case AD_HOC:
        setAdHoc(((Boolean)newValue).booleanValue());
        return;
      case AD_HOC_ORDERING:
        setAdHocOrdering((String)newValue);
        return;
      case AD_HOC_COMPLETION_CONDITION:
        setAdHocCompletionCondition((String)newValue);
        return;
      case DEFAULT_START_ACTIVITY_ID:
        setDefaultStartActivityId((String)newValue);
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
      case ACTIVITIES:
        unsetActivities();
        return;
      case TRANSITIONS:
        unsetTransitions();
        return;
      case OBJECT:
        unsetObject();
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
      case AD_HOC:
        unsetAdHoc();
        return;
      case AD_HOC_ORDERING:
        unsetAdHocOrdering();
        return;
      case AD_HOC_COMPLETION_CONDITION:
        unsetAdHocCompletionCondition();
        return;
      case DEFAULT_START_ACTIVITY_ID:
        unsetDefaultStartActivityId();
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
      case ACTIVITIES:
        return isSetActivities();
      case TRANSITIONS:
        return isSetTransitions();
      case OBJECT:
        return isSetObject();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case AD_HOC:
        return isSetAdHoc();
      case AD_HOC_ORDERING:
        return isSetAdHocOrdering();
      case AD_HOC_COMPLETION_CONDITION:
        return isSetAdHocCompletionCondition();
      case DEFAULT_START_ACTIVITY_ID:
        return isSetDefaultStartActivityId();
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
    result.append(", AdHoc: ");
    if (adHoc_set_) result.append(adHoc); else result.append("<unset>");
    result.append(", AdHocOrdering: ");
    if (adHocOrdering_set_) result.append(adHocOrdering); else result.append("<unset>");
    result.append(", AdHocCompletionCondition: ");
    if (adHocCompletionCondition_set_) result.append(adHocCompletionCondition); else result.append("<unset>");
    result.append(", DefaultStartActivityId: ");
    if (defaultStartActivityId_set_) result.append(defaultStartActivityId); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //ActivitySetImpl
