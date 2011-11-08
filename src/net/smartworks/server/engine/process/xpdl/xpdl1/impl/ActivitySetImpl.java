/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivitySetImpl.java,v 1.1 2009/12/22 06:17:12 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySet;
import net.smartworks.server.engine.process.xpdl.xpdl1.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivitySetImpl#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivitySetImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivitySetImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivitySetImpl extends DataObjectBase implements ActivitySet
{

  public final static int ACTIVITIES = 0;

  public final static int TRANSITIONS = 1;

  public final static int ID = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


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
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 2;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 3;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_ACTIVITIES: return ACTIVITIES;
      case INTERNAL_TRANSITIONS: return TRANSITIONS;
      case INTERNAL_ID: return ID;
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getActivitySet();
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
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case ACTIVITIES:
        return basicUnsetActivities(changeContext);
      case TRANSITIONS:
        return basicUnsetTransitions(changeContext);
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
      case ID:
        return getId();
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
      case ID:
        setId((String)newValue);
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
      case ID:
        unsetId();
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
      case ID:
        return isSetId();
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
    result.append(" (Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ActivitySetImpl
