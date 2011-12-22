/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeEstimationImpl.java,v 1.1 2009/12/22 06:17:30 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Duration;
import net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation;
import net.smartworks.server.engine.process.xpdl.xpdl2.WaitingTime;
import net.smartworks.server.engine.process.xpdl.xpdl2.WorkingTime;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Estimation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TimeEstimationImpl#getWaitingTime <em>Waiting Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TimeEstimationImpl#getWorkingTime <em>Working Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TimeEstimationImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TimeEstimationImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TimeEstimationImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeEstimationImpl extends DataObjectBase implements TimeEstimation
{

  public final static int WAITING_TIME = 0;

  public final static int WORKING_TIME = 1;

  public final static int DURATION = 2;

  public final static int ANY = -1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Waiting Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WAITING_TIME = 0;

  /**
   * The internal feature id for the '<em><b>Working Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WORKING_TIME = 1;

  /**
   * The internal feature id for the '<em><b>Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DURATION = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 4;

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
      case INTERNAL_WAITING_TIME: return WAITING_TIME;
      case INTERNAL_WORKING_TIME: return WORKING_TIME;
      case INTERNAL_DURATION: return DURATION;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWaitingTime()
   * @generated
   * @ordered
   */
  
  protected WaitingTime waitingTime = null;
  
  /**
   * This is true if the Waiting Time containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean waitingTime_set_ = false;

  /**
   * The cached value of the '{@link #getWorkingTime() <em>Working Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorkingTime()
   * @generated
   * @ordered
   */
  
  protected WorkingTime workingTime = null;
  
  /**
   * This is true if the Working Time containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean workingTime_set_ = false;

  /**
   * The cached value of the '{@link #getDuration() <em>Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  
  protected Duration duration = null;
  
  /**
   * This is true if the Duration containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean duration_set_ = false;

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
  public TimeEstimationImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getTimeEstimation();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WaitingTime getWaitingTime()
  {
    return waitingTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetWaitingTime(WaitingTime newWaitingTime, ChangeContext changeContext)
  {
    WaitingTime oldWaitingTime = waitingTime;
    waitingTime = newWaitingTime;
    boolean oldWaitingTime_set_ = waitingTime_set_;
    waitingTime_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_WAITING_TIME, oldWaitingTime, newWaitingTime, !oldWaitingTime_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWaitingTime(WaitingTime newWaitingTime)
  {
    if (newWaitingTime != waitingTime)
    {
      ChangeContext changeContext = null;
      if (waitingTime != null)
        changeContext = inverseRemove(waitingTime, this, OPPOSITE_FEATURE_BASE - INTERNAL_WAITING_TIME, null, changeContext);
      if (newWaitingTime != null)
        changeContext = inverseAdd(newWaitingTime, this, OPPOSITE_FEATURE_BASE - INTERNAL_WAITING_TIME, null, changeContext);
      changeContext = basicSetWaitingTime(newWaitingTime, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldWaitingTime_set_ = waitingTime_set_;
      waitingTime_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_WAITING_TIME, newWaitingTime, newWaitingTime, !oldWaitingTime_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetWaitingTime(ChangeContext changeContext)
  {
    WaitingTime oldWaitingTime = waitingTime;
    waitingTime = null;
    boolean oldWaitingTime_set_ = waitingTime_set_;
    waitingTime_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_WAITING_TIME, oldWaitingTime, null, !oldWaitingTime_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWaitingTime()
  {
    if (waitingTime != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(waitingTime, this, EOPPOSITE_FEATURE_BASE - INTERNAL_WAITING_TIME, null, changeContext);
      changeContext = basicUnsetWaitingTime(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldWaitingTime_set_ = waitingTime_set_;
      waitingTime_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_WAITING_TIME, null, null, oldWaitingTime_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetWaitingTime()
  {
    return waitingTime_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkingTime getWorkingTime()
  {
    return workingTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetWorkingTime(WorkingTime newWorkingTime, ChangeContext changeContext)
  {
    WorkingTime oldWorkingTime = workingTime;
    workingTime = newWorkingTime;
    boolean oldWorkingTime_set_ = workingTime_set_;
    workingTime_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_WORKING_TIME, oldWorkingTime, newWorkingTime, !oldWorkingTime_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorkingTime(WorkingTime newWorkingTime)
  {
    if (newWorkingTime != workingTime)
    {
      ChangeContext changeContext = null;
      if (workingTime != null)
        changeContext = inverseRemove(workingTime, this, OPPOSITE_FEATURE_BASE - INTERNAL_WORKING_TIME, null, changeContext);
      if (newWorkingTime != null)
        changeContext = inverseAdd(newWorkingTime, this, OPPOSITE_FEATURE_BASE - INTERNAL_WORKING_TIME, null, changeContext);
      changeContext = basicSetWorkingTime(newWorkingTime, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldWorkingTime_set_ = workingTime_set_;
      workingTime_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_WORKING_TIME, newWorkingTime, newWorkingTime, !oldWorkingTime_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetWorkingTime(ChangeContext changeContext)
  {
    WorkingTime oldWorkingTime = workingTime;
    workingTime = null;
    boolean oldWorkingTime_set_ = workingTime_set_;
    workingTime_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_WORKING_TIME, oldWorkingTime, null, !oldWorkingTime_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWorkingTime()
  {
    if (workingTime != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(workingTime, this, EOPPOSITE_FEATURE_BASE - INTERNAL_WORKING_TIME, null, changeContext);
      changeContext = basicUnsetWorkingTime(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldWorkingTime_set_ = workingTime_set_;
      workingTime_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_WORKING_TIME, null, null, oldWorkingTime_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetWorkingTime()
  {
    return workingTime_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Duration getDuration()
  {
    return duration;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDuration(Duration newDuration, ChangeContext changeContext)
  {
    Duration oldDuration = duration;
    duration = newDuration;
    boolean oldDuration_set_ = duration_set_;
    duration_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DURATION, oldDuration, newDuration, !oldDuration_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuration(Duration newDuration)
  {
    if (newDuration != duration)
    {
      ChangeContext changeContext = null;
      if (duration != null)
        changeContext = inverseRemove(duration, this, OPPOSITE_FEATURE_BASE - INTERNAL_DURATION, null, changeContext);
      if (newDuration != null)
        changeContext = inverseAdd(newDuration, this, OPPOSITE_FEATURE_BASE - INTERNAL_DURATION, null, changeContext);
      changeContext = basicSetDuration(newDuration, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDuration_set_ = duration_set_;
      duration_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DURATION, newDuration, newDuration, !oldDuration_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDuration(ChangeContext changeContext)
  {
    Duration oldDuration = duration;
    duration = null;
    boolean oldDuration_set_ = duration_set_;
    duration_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DURATION, oldDuration, null, !oldDuration_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDuration()
  {
    if (duration != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(duration, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DURATION, null, changeContext);
      changeContext = basicUnsetDuration(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDuration_set_ = duration_set_;
      duration_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DURATION, null, null, oldDuration_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDuration()
  {
    return duration_set_;
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
      case WAITING_TIME:
        return basicUnsetWaitingTime(changeContext);
      case WORKING_TIME:
        return basicUnsetWorkingTime(changeContext);
      case DURATION:
        return basicUnsetDuration(changeContext);
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
      case WAITING_TIME:
        return getWaitingTime();
      case WORKING_TIME:
        return getWorkingTime();
      case DURATION:
        return getDuration();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
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
      case WAITING_TIME:
        setWaitingTime((WaitingTime)newValue);
        return;
      case WORKING_TIME:
        setWorkingTime((WorkingTime)newValue);
        return;
      case DURATION:
        setDuration((Duration)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
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
      case WAITING_TIME:
        unsetWaitingTime();
        return;
      case WORKING_TIME:
        unsetWorkingTime();
        return;
      case DURATION:
        unsetDuration();
        return;
      case ANY:
        unsetSequence(getAny());
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
      case WAITING_TIME:
        return isSetWaitingTime();
      case WORKING_TIME:
        return isSetWorkingTime();
      case DURATION:
        return isSetDuration();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
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
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //TimeEstimationImpl
