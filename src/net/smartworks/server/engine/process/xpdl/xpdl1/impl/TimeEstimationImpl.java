/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeEstimationImpl.java,v 1.1 2009/12/22 06:17:17 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Estimation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TimeEstimationImpl#getWaitingTime <em>Waiting Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TimeEstimationImpl#getWorkingTime <em>Working Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TimeEstimationImpl#getDuration <em>Duration</em>}</li>
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

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Waiting Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WAITING_TIME = 0;

  /**
   * The internal feature id for the '<em><b>Working Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WORKING_TIME = 1;

  /**
   * The internal feature id for the '<em><b>Duration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DURATION = 2;

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
      case INTERNAL_WAITING_TIME: return WAITING_TIME;
      case INTERNAL_WORKING_TIME: return WORKING_TIME;
      case INTERNAL_DURATION: return DURATION;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWaitingTime()
   * @generated
   * @ordered
   */
  protected static final String WAITING_TIME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWaitingTime()
   * @generated
   * @ordered
   */
  protected String waitingTime = WAITING_TIME_DEFAULT_;

  /**
   * This is true if the Waiting Time attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean waitingTime_set_ = false;

  /**
   * The default value of the '{@link #getWorkingTime() <em>Working Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorkingTime()
   * @generated
   * @ordered
   */
  protected static final String WORKING_TIME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getWorkingTime() <em>Working Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorkingTime()
   * @generated
   * @ordered
   */
  protected String workingTime = WORKING_TIME_DEFAULT_;

  /**
   * This is true if the Working Time attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean workingTime_set_ = false;

  /**
   * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected static final String DURATION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected String duration = DURATION_DEFAULT_;

  /**
   * This is true if the Duration attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean duration_set_ = false;

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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getTimeEstimation();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getWaitingTime()
  {
    return waitingTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWaitingTime(String newWaitingTime)
  {
    String oldWaitingTime = waitingTime;
    waitingTime = newWaitingTime;
    boolean oldWaitingTime_set_ = waitingTime_set_;
    waitingTime_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_WAITING_TIME, oldWaitingTime, waitingTime, !oldWaitingTime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWaitingTime()
  {
    String oldWaitingTime = waitingTime;
    boolean oldWaitingTime_set_ = waitingTime_set_;
    waitingTime = WAITING_TIME_DEFAULT_;
    waitingTime_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_WAITING_TIME, oldWaitingTime, WAITING_TIME_DEFAULT_, oldWaitingTime_set_);
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
  public String getWorkingTime()
  {
    return workingTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorkingTime(String newWorkingTime)
  {
    String oldWorkingTime = workingTime;
    workingTime = newWorkingTime;
    boolean oldWorkingTime_set_ = workingTime_set_;
    workingTime_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_WORKING_TIME, oldWorkingTime, workingTime, !oldWorkingTime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWorkingTime()
  {
    String oldWorkingTime = workingTime;
    boolean oldWorkingTime_set_ = workingTime_set_;
    workingTime = WORKING_TIME_DEFAULT_;
    workingTime_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_WORKING_TIME, oldWorkingTime, WORKING_TIME_DEFAULT_, oldWorkingTime_set_);
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
  public String getDuration()
  {
    return duration;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuration(String newDuration)
  {
    String oldDuration = duration;
    duration = newDuration;
    boolean oldDuration_set_ = duration_set_;
    duration_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DURATION, oldDuration, duration, !oldDuration_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDuration()
  {
    String oldDuration = duration;
    boolean oldDuration_set_ = duration_set_;
    duration = DURATION_DEFAULT_;
    duration_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DURATION, oldDuration, DURATION_DEFAULT_, oldDuration_set_);
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
        setWaitingTime((String)newValue);
        return;
      case WORKING_TIME:
        setWorkingTime((String)newValue);
        return;
      case DURATION:
        setDuration((String)newValue);
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
    result.append(" (WaitingTime: ");
    if (waitingTime_set_) result.append(waitingTime); else result.append("<unset>");
    result.append(", WorkingTime: ");
    if (workingTime_set_) result.append(workingTime); else result.append("<unset>");
    result.append(", Duration: ");
    if (duration_set_) result.append(duration); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TimeEstimationImpl
