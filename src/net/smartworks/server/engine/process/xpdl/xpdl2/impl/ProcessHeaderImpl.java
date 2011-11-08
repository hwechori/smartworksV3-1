/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessHeaderImpl.java,v 1.1 2009/12/22 06:17:25 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Created;
import net.smartworks.server.engine.process.xpdl.xpdl2.Description;
import net.smartworks.server.engine.process.xpdl.xpdl2.Limit;
import net.smartworks.server.engine.process.xpdl.xpdl2.Priority;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessHeader;
import net.smartworks.server.engine.process.xpdl.xpdl2.TimeEstimation;
import net.smartworks.server.engine.process.xpdl.xpdl2.ValidFrom;
import net.smartworks.server.engine.process.xpdl.xpdl2.ValidTo;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getLimit <em>Limit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getValidTo <em>Valid To</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getTimeEstimation <em>Time Estimation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getDurationUnit <em>Duration Unit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ProcessHeaderImpl#getAnyAttribute <em>Any Attribute</em>}</li>
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

  public final static int ANY = -1;

  public final static int DURATION_UNIT = 7;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 8;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Created</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CREATED = 0;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 1;

  /**
   * The internal feature id for the '<em><b>Priority</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRIORITY = 2;

  /**
   * The internal feature id for the '<em><b>Limit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LIMIT = 3;

  /**
   * The internal feature id for the '<em><b>Valid From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VALID_FROM = 4;

  /**
   * The internal feature id for the '<em><b>Valid To</b></em>' containment reference.
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
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 7;

  /**
   * The internal feature id for the '<em><b>Duration Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DURATION_UNIT = 8;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 9;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 10;

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
      case INTERNAL_ANY: return ANY;
      case INTERNAL_DURATION_UNIT: return DURATION_UNIT;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getCreated() <em>Created</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreated()
   * @generated
   * @ordered
   */
  
  protected Created created = null;
  
  /**
   * This is true if the Created containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean created_set_ = false;

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
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  
  protected Priority priority = null;
  
  /**
   * This is true if the Priority containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean priority_set_ = false;

  /**
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  
  protected Limit limit = null;
  
  /**
   * This is true if the Limit containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean limit_set_ = false;

  /**
   * The cached value of the '{@link #getValidFrom() <em>Valid From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidFrom()
   * @generated
   * @ordered
   */
  
  protected ValidFrom validFrom = null;
  
  /**
   * This is true if the Valid From containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean validFrom_set_ = false;

  /**
   * The cached value of the '{@link #getValidTo() <em>Valid To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidTo()
   * @generated
   * @ordered
   */
  
  protected ValidTo validTo = null;
  
  /**
   * This is true if the Valid To containment reference has been set.
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
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  
  protected Sequence any = null;
  
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getProcessHeader();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Created getCreated()
  {
    return created;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetCreated(Created newCreated, ChangeContext changeContext)
  {
    Created oldCreated = created;
    created = newCreated;
    boolean oldCreated_set_ = created_set_;
    created_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_CREATED, oldCreated, newCreated, !oldCreated_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreated(Created newCreated)
  {
    if (newCreated != created)
    {
      ChangeContext changeContext = null;
      if (created != null)
        changeContext = inverseRemove(created, this, OPPOSITE_FEATURE_BASE - INTERNAL_CREATED, null, changeContext);
      if (newCreated != null)
        changeContext = inverseAdd(newCreated, this, OPPOSITE_FEATURE_BASE - INTERNAL_CREATED, null, changeContext);
      changeContext = basicSetCreated(newCreated, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldCreated_set_ = created_set_;
      created_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_CREATED, newCreated, newCreated, !oldCreated_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetCreated(ChangeContext changeContext)
  {
    Created oldCreated = created;
    created = null;
    boolean oldCreated_set_ = created_set_;
    created_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_CREATED, oldCreated, null, !oldCreated_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCreated()
  {
    if (created != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(created, this, EOPPOSITE_FEATURE_BASE - INTERNAL_CREATED, null, changeContext);
      changeContext = basicUnsetCreated(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldCreated_set_ = created_set_;
      created_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_CREATED, null, null, oldCreated_set_);
    	}
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
  public Priority getPriority()
  {
    return priority;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPriority(Priority newPriority, ChangeContext changeContext)
  {
    Priority oldPriority = priority;
    priority = newPriority;
    boolean oldPriority_set_ = priority_set_;
    priority_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PRIORITY, oldPriority, newPriority, !oldPriority_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(Priority newPriority)
  {
    if (newPriority != priority)
    {
      ChangeContext changeContext = null;
      if (priority != null)
        changeContext = inverseRemove(priority, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY, null, changeContext);
      if (newPriority != null)
        changeContext = inverseAdd(newPriority, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY, null, changeContext);
      changeContext = basicSetPriority(newPriority, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPriority_set_ = priority_set_;
      priority_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PRIORITY, newPriority, newPriority, !oldPriority_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPriority(ChangeContext changeContext)
  {
    Priority oldPriority = priority;
    priority = null;
    boolean oldPriority_set_ = priority_set_;
    priority_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PRIORITY, oldPriority, null, !oldPriority_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPriority()
  {
    if (priority != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(priority, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY, null, changeContext);
      changeContext = basicUnsetPriority(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPriority_set_ = priority_set_;
      priority_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PRIORITY, null, null, oldPriority_set_);
    	}
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
  public Limit getLimit()
  {
    return limit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLimit(Limit newLimit, ChangeContext changeContext)
  {
    Limit oldLimit = limit;
    limit = newLimit;
    boolean oldLimit_set_ = limit_set_;
    limit_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LIMIT, oldLimit, newLimit, !oldLimit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimit(Limit newLimit)
  {
    if (newLimit != limit)
    {
      ChangeContext changeContext = null;
      if (limit != null)
        changeContext = inverseRemove(limit, this, OPPOSITE_FEATURE_BASE - INTERNAL_LIMIT, null, changeContext);
      if (newLimit != null)
        changeContext = inverseAdd(newLimit, this, OPPOSITE_FEATURE_BASE - INTERNAL_LIMIT, null, changeContext);
      changeContext = basicSetLimit(newLimit, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLimit_set_ = limit_set_;
      limit_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LIMIT, newLimit, newLimit, !oldLimit_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLimit(ChangeContext changeContext)
  {
    Limit oldLimit = limit;
    limit = null;
    boolean oldLimit_set_ = limit_set_;
    limit_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LIMIT, oldLimit, null, !oldLimit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLimit()
  {
    if (limit != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(limit, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LIMIT, null, changeContext);
      changeContext = basicUnsetLimit(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLimit_set_ = limit_set_;
      limit_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LIMIT, null, null, oldLimit_set_);
    	}
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
  public ValidFrom getValidFrom()
  {
    return validFrom;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetValidFrom(ValidFrom newValidFrom, ChangeContext changeContext)
  {
    ValidFrom oldValidFrom = validFrom;
    validFrom = newValidFrom;
    boolean oldValidFrom_set_ = validFrom_set_;
    validFrom_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_VALID_FROM, oldValidFrom, newValidFrom, !oldValidFrom_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValidFrom(ValidFrom newValidFrom)
  {
    if (newValidFrom != validFrom)
    {
      ChangeContext changeContext = null;
      if (validFrom != null)
        changeContext = inverseRemove(validFrom, this, OPPOSITE_FEATURE_BASE - INTERNAL_VALID_FROM, null, changeContext);
      if (newValidFrom != null)
        changeContext = inverseAdd(newValidFrom, this, OPPOSITE_FEATURE_BASE - INTERNAL_VALID_FROM, null, changeContext);
      changeContext = basicSetValidFrom(newValidFrom, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldValidFrom_set_ = validFrom_set_;
      validFrom_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_VALID_FROM, newValidFrom, newValidFrom, !oldValidFrom_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetValidFrom(ChangeContext changeContext)
  {
    ValidFrom oldValidFrom = validFrom;
    validFrom = null;
    boolean oldValidFrom_set_ = validFrom_set_;
    validFrom_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_VALID_FROM, oldValidFrom, null, !oldValidFrom_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetValidFrom()
  {
    if (validFrom != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(validFrom, this, EOPPOSITE_FEATURE_BASE - INTERNAL_VALID_FROM, null, changeContext);
      changeContext = basicUnsetValidFrom(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldValidFrom_set_ = validFrom_set_;
      validFrom_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_VALID_FROM, null, null, oldValidFrom_set_);
    	}
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
  public ValidTo getValidTo()
  {
    return validTo;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetValidTo(ValidTo newValidTo, ChangeContext changeContext)
  {
    ValidTo oldValidTo = validTo;
    validTo = newValidTo;
    boolean oldValidTo_set_ = validTo_set_;
    validTo_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_VALID_TO, oldValidTo, newValidTo, !oldValidTo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValidTo(ValidTo newValidTo)
  {
    if (newValidTo != validTo)
    {
      ChangeContext changeContext = null;
      if (validTo != null)
        changeContext = inverseRemove(validTo, this, OPPOSITE_FEATURE_BASE - INTERNAL_VALID_TO, null, changeContext);
      if (newValidTo != null)
        changeContext = inverseAdd(newValidTo, this, OPPOSITE_FEATURE_BASE - INTERNAL_VALID_TO, null, changeContext);
      changeContext = basicSetValidTo(newValidTo, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldValidTo_set_ = validTo_set_;
      validTo_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_VALID_TO, newValidTo, newValidTo, !oldValidTo_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetValidTo(ChangeContext changeContext)
  {
    ValidTo oldValidTo = validTo;
    validTo = null;
    boolean oldValidTo_set_ = validTo_set_;
    validTo_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_VALID_TO, oldValidTo, null, !oldValidTo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetValidTo()
  {
    if (validTo != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(validTo, this, EOPPOSITE_FEATURE_BASE - INTERNAL_VALID_TO, null, changeContext);
      changeContext = basicUnsetValidTo(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldValidTo_set_ = validTo_set_;
      validTo_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_VALID_TO, null, null, oldValidTo_set_);
    	}
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
      case CREATED:
        return basicUnsetCreated(changeContext);
      case DESCRIPTION:
        return basicUnsetDescription(changeContext);
      case PRIORITY:
        return basicUnsetPriority(changeContext);
      case LIMIT:
        return basicUnsetLimit(changeContext);
      case VALID_FROM:
        return basicUnsetValidFrom(changeContext);
      case VALID_TO:
        return basicUnsetValidTo(changeContext);
      case TIME_ESTIMATION:
        return basicUnsetTimeEstimation(changeContext);
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
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case DURATION_UNIT:
        return getDurationUnit();
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
      case CREATED:
        setCreated((Created)newValue);
        return;
      case DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case PRIORITY:
        setPriority((Priority)newValue);
        return;
      case LIMIT:
        setLimit((Limit)newValue);
        return;
      case VALID_FROM:
        setValidFrom((ValidFrom)newValue);
        return;
      case VALID_TO:
        setValidTo((ValidTo)newValue);
        return;
      case TIME_ESTIMATION:
        setTimeEstimation((TimeEstimation)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case DURATION_UNIT:
        setDurationUnit((String)newValue);
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
      case ANY:
        unsetSequence(getAny());
        return;
      case DURATION_UNIT:
        unsetDurationUnit();
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
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case DURATION_UNIT:
        return isSetDurationUnit();
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
    result.append(", DurationUnit: ");
    if (durationUnit_set_) result.append(durationUnit); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //ProcessHeaderImpl
