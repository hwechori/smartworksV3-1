/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessHeaderImpl.java,v 1.1 2009/12/22 06:17:13 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.ProcessHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getLimit <em>Limit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getValidTo <em>Valid To</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getTimeEstimation <em>Time Estimation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ProcessHeaderImpl#getDurationUnit <em>Duration Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessHeaderImpl extends DataObjectBase implements ProcessHeader
{

  public final static int CREATED = 0;

  public final static int DESCRIPTION = 1;

  public final static int PRIORITY = 2;

  public final static int LIMIT = 3;

  public final static int VALID_FROM = 4;

  public final static int VALID_TO = 5;

  public final static int TIME_ESTIMATION = 6;

  public final static int DURATION_UNIT = 7;

  public final static int SDO_PROPERTY_COUNT = 8;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Created</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CREATED = 0;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 1;

  /**
   * The internal feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRIORITY = 2;

  /**
   * The internal feature id for the '<em><b>Limit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LIMIT = 3;

  /**
   * The internal feature id for the '<em><b>Valid From</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VALID_FROM = 4;

  /**
   * The internal feature id for the '<em><b>Valid To</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VALID_TO = 5;

  /**
   * The internal feature id for the '<em><b>Time Estimation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TIME_ESTIMATION = 6;

  /**
   * The internal feature id for the '<em><b>Duration Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DURATION_UNIT = 7;

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
      case INTERNAL_CREATED: return CREATED;
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_PRIORITY: return PRIORITY;
      case INTERNAL_LIMIT: return LIMIT;
      case INTERNAL_VALID_FROM: return VALID_FROM;
      case INTERNAL_VALID_TO: return VALID_TO;
      case INTERNAL_TIME_ESTIMATION: return TIME_ESTIMATION;
      case INTERNAL_DURATION_UNIT: return DURATION_UNIT;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreated()
   * @generated
   * @ordered
   */
  protected static final String CREATED_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreated()
   * @generated
   * @ordered
   */
  protected String created = CREATED_DEFAULT_;

  /**
   * This is true if the Created attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean created_set_ = false;

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
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final String PRIORITY_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected String priority = PRIORITY_DEFAULT_;

  /**
   * This is true if the Priority attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean priority_set_ = false;

  /**
   * The default value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected static final String LIMIT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected String limit = LIMIT_DEFAULT_;

  /**
   * This is true if the Limit attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean limit_set_ = false;

  /**
   * The default value of the '{@link #getValidFrom() <em>Valid From</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidFrom()
   * @generated
   * @ordered
   */
  protected static final String VALID_FROM_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getValidFrom() <em>Valid From</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidFrom()
   * @generated
   * @ordered
   */
  protected String validFrom = VALID_FROM_DEFAULT_;

  /**
   * This is true if the Valid From attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean validFrom_set_ = false;

  /**
   * The default value of the '{@link #getValidTo() <em>Valid To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidTo()
   * @generated
   * @ordered
   */
  protected static final String VALID_TO_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getValidTo() <em>Valid To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidTo()
   * @generated
   * @ordered
   */
  protected String validTo = VALID_TO_DEFAULT_;

  /**
   * This is true if the Valid To attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean validTo_set_ = false;

  /**
   * The cached value of the '{@link #getTimeEstimation() <em>Time Estimation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeEstimation()
   * @generated
   * @ordered
   */
  
  protected TimeEstimation timeEstimation = null;
  
  /**
   * This is true if the Time Estimation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean timeEstimation_set_ = false;

  /**
   * The default value of the '{@link #getDurationUnit() <em>Duration Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDurationUnit()
   * @generated
   * @ordered
   */
  protected static final String DURATION_UNIT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDurationUnit() <em>Duration Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDurationUnit()
   * @generated
   * @ordered
   */
  protected String durationUnit = DURATION_UNIT_DEFAULT_;

  /**
   * This is true if the Duration Unit attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean durationUnit_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessHeaderImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getProcessHeader();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCreated()
  {
    return created;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreated(String newCreated)
  {
    String oldCreated = created;
    created = newCreated;
    boolean oldCreated_set_ = created_set_;
    created_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_CREATED, oldCreated, created, !oldCreated_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCreated()
  {
    String oldCreated = created;
    boolean oldCreated_set_ = created_set_;
    created = CREATED_DEFAULT_;
    created_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_CREATED, oldCreated, CREATED_DEFAULT_, oldCreated_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCreated()
  {
    return created_set_;
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
  public String getPriority()
  {
    return priority;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(String newPriority)
  {
    String oldPriority = priority;
    priority = newPriority;
    boolean oldPriority_set_ = priority_set_;
    priority_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PRIORITY, oldPriority, priority, !oldPriority_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPriority()
  {
    String oldPriority = priority;
    boolean oldPriority_set_ = priority_set_;
    priority = PRIORITY_DEFAULT_;
    priority_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PRIORITY, oldPriority, PRIORITY_DEFAULT_, oldPriority_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPriority()
  {
    return priority_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLimit()
  {
    return limit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimit(String newLimit)
  {
    String oldLimit = limit;
    limit = newLimit;
    boolean oldLimit_set_ = limit_set_;
    limit_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LIMIT, oldLimit, limit, !oldLimit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLimit()
  {
    String oldLimit = limit;
    boolean oldLimit_set_ = limit_set_;
    limit = LIMIT_DEFAULT_;
    limit_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LIMIT, oldLimit, LIMIT_DEFAULT_, oldLimit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLimit()
  {
    return limit_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValidFrom()
  {
    return validFrom;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValidFrom(String newValidFrom)
  {
    String oldValidFrom = validFrom;
    validFrom = newValidFrom;
    boolean oldValidFrom_set_ = validFrom_set_;
    validFrom_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_VALID_FROM, oldValidFrom, validFrom, !oldValidFrom_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetValidFrom()
  {
    String oldValidFrom = validFrom;
    boolean oldValidFrom_set_ = validFrom_set_;
    validFrom = VALID_FROM_DEFAULT_;
    validFrom_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_VALID_FROM, oldValidFrom, VALID_FROM_DEFAULT_, oldValidFrom_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetValidFrom()
  {
    return validFrom_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValidTo()
  {
    return validTo;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValidTo(String newValidTo)
  {
    String oldValidTo = validTo;
    validTo = newValidTo;
    boolean oldValidTo_set_ = validTo_set_;
    validTo_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_VALID_TO, oldValidTo, validTo, !oldValidTo_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetValidTo()
  {
    String oldValidTo = validTo;
    boolean oldValidTo_set_ = validTo_set_;
    validTo = VALID_TO_DEFAULT_;
    validTo_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_VALID_TO, oldValidTo, VALID_TO_DEFAULT_, oldValidTo_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetValidTo()
  {
    return validTo_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeEstimation getTimeEstimation()
  {
    return timeEstimation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTimeEstimation(TimeEstimation newTimeEstimation, ChangeContext changeContext)
  {
    TimeEstimation oldTimeEstimation = timeEstimation;
    timeEstimation = newTimeEstimation;
    boolean oldTimeEstimation_set_ = timeEstimation_set_;
    timeEstimation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TIME_ESTIMATION, oldTimeEstimation, newTimeEstimation, !oldTimeEstimation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeEstimation(TimeEstimation newTimeEstimation)
  {
    if (newTimeEstimation != timeEstimation)
    {
      ChangeContext changeContext = null;
      if (timeEstimation != null)
        changeContext = inverseRemove(timeEstimation, this, OPPOSITE_FEATURE_BASE - INTERNAL_TIME_ESTIMATION, null, changeContext);
      if (newTimeEstimation != null)
        changeContext = inverseAdd(newTimeEstimation, this, OPPOSITE_FEATURE_BASE - INTERNAL_TIME_ESTIMATION, null, changeContext);
      changeContext = basicSetTimeEstimation(newTimeEstimation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTimeEstimation_set_ = timeEstimation_set_;
      timeEstimation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TIME_ESTIMATION, newTimeEstimation, newTimeEstimation, !oldTimeEstimation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTimeEstimation(ChangeContext changeContext)
  {
    TimeEstimation oldTimeEstimation = timeEstimation;
    timeEstimation = null;
    boolean oldTimeEstimation_set_ = timeEstimation_set_;
    timeEstimation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TIME_ESTIMATION, oldTimeEstimation, null, !oldTimeEstimation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTimeEstimation()
  {
    if (timeEstimation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(timeEstimation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TIME_ESTIMATION, null, changeContext);
      changeContext = basicUnsetTimeEstimation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTimeEstimation_set_ = timeEstimation_set_;
      timeEstimation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TIME_ESTIMATION, null, null, oldTimeEstimation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTimeEstimation()
  {
    return timeEstimation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDurationUnit()
  {
    return durationUnit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDurationUnit(String newDurationUnit)
  {
    String oldDurationUnit = durationUnit;
    durationUnit = newDurationUnit;
    boolean oldDurationUnit_set_ = durationUnit_set_;
    durationUnit_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DURATION_UNIT, oldDurationUnit, durationUnit, !oldDurationUnit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDurationUnit()
  {
    String oldDurationUnit = durationUnit;
    boolean oldDurationUnit_set_ = durationUnit_set_;
    durationUnit = DURATION_UNIT_DEFAULT_;
    durationUnit_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DURATION_UNIT, oldDurationUnit, DURATION_UNIT_DEFAULT_, oldDurationUnit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDurationUnit()
  {
    return durationUnit_set_;
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
      case TIME_ESTIMATION:
        return basicUnsetTimeEstimation(changeContext);
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
      case CREATED:
        return getCreated();
      case DESCRIPTION:
        return getDescription();
      case PRIORITY:
        return getPriority();
      case LIMIT:
        return getLimit();
      case VALID_FROM:
        return getValidFrom();
      case VALID_TO:
        return getValidTo();
      case TIME_ESTIMATION:
        return getTimeEstimation();
      case DURATION_UNIT:
        return getDurationUnit();
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
      case CREATED:
        setCreated((String)newValue);
        return;
      case DESCRIPTION:
        setDescription((String)newValue);
        return;
      case PRIORITY:
        setPriority((String)newValue);
        return;
      case LIMIT:
        setLimit((String)newValue);
        return;
      case VALID_FROM:
        setValidFrom((String)newValue);
        return;
      case VALID_TO:
        setValidTo((String)newValue);
        return;
      case TIME_ESTIMATION:
        setTimeEstimation((TimeEstimation)newValue);
        return;
      case DURATION_UNIT:
        setDurationUnit((String)newValue);
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
      case CREATED:
        unsetCreated();
        return;
      case DESCRIPTION:
        unsetDescription();
        return;
      case PRIORITY:
        unsetPriority();
        return;
      case LIMIT:
        unsetLimit();
        return;
      case VALID_FROM:
        unsetValidFrom();
        return;
      case VALID_TO:
        unsetValidTo();
        return;
      case TIME_ESTIMATION:
        unsetTimeEstimation();
        return;
      case DURATION_UNIT:
        unsetDurationUnit();
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
      case CREATED:
        return isSetCreated();
      case DESCRIPTION:
        return isSetDescription();
      case PRIORITY:
        return isSetPriority();
      case LIMIT:
        return isSetLimit();
      case VALID_FROM:
        return isSetValidFrom();
      case VALID_TO:
        return isSetValidTo();
      case TIME_ESTIMATION:
        return isSetTimeEstimation();
      case DURATION_UNIT:
        return isSetDurationUnit();
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
    result.append(" (Created: ");
    if (created_set_) result.append(created); else result.append("<unset>");
    result.append(", Description: ");
    if (description_set_) result.append(description); else result.append("<unset>");
    result.append(", Priority: ");
    if (priority_set_) result.append(priority); else result.append("<unset>");
    result.append(", Limit: ");
    if (limit_set_) result.append(limit); else result.append("<unset>");
    result.append(", ValidFrom: ");
    if (validFrom_set_) result.append(validFrom); else result.append("<unset>");
    result.append(", ValidTo: ");
    if (validTo_set_) result.append(validTo); else result.append("<unset>");
    result.append(", DurationUnit: ");
    if (durationUnit_set_) result.append(durationUnit); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ProcessHeaderImpl
