/**
 * <copyright>
 * </copyright>
 *
 * $Id: IntermediateEventImpl.java,v 1.1 2009/12/22 06:17:50 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.IntermediateEvent;
import net.smartworks.server.engine.process.xpdl.xpdl2.ResultCompensation;
import net.smartworks.server.engine.process.xpdl.xpdl2.ResultError;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerIntermediateMultiple;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerRule;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerTimer;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intermediate Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getTriggerResultMessage <em>Trigger Result Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getTriggerTimer <em>Trigger Timer</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getResultError <em>Result Error</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getResultCompensation <em>Result Compensation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getTriggerRule <em>Trigger Rule</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getTriggerResultLink <em>Trigger Result Link</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getTriggerIntermediateMultiple <em>Trigger Intermediate Multiple</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IntermediateEventImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntermediateEventImpl extends DataObjectBase implements IntermediateEvent
{

  public final static int TRIGGER_RESULT_MESSAGE = 0;

  public final static int TRIGGER_TIMER = 1;

  public final static int RESULT_ERROR = 2;

  public final static int RESULT_COMPENSATION = 3;

  public final static int TRIGGER_RULE = 4;

  public final static int TRIGGER_RESULT_LINK = 5;

  public final static int TRIGGER_INTERMEDIATE_MULTIPLE = 6;

  public final static int TRIGGER = 7;

  public final static int IMPLEMENTATION = 8;

  public final static int TARGET = 9;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 10;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Trigger Result Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_RESULT_MESSAGE = 0;

  /**
   * The internal feature id for the '<em><b>Trigger Timer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_TIMER = 1;

  /**
   * The internal feature id for the '<em><b>Result Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_RESULT_ERROR = 2;

  /**
   * The internal feature id for the '<em><b>Result Compensation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_RESULT_COMPENSATION = 3;

  /**
   * The internal feature id for the '<em><b>Trigger Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_RULE = 4;

  /**
   * The internal feature id for the '<em><b>Trigger Result Link</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_RESULT_LINK = 5;

  /**
   * The internal feature id for the '<em><b>Trigger Intermediate Multiple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE = 6;

  /**
   * The internal feature id for the '<em><b>Trigger</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER = 7;

  /**
   * The internal feature id for the '<em><b>Implementation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IMPLEMENTATION = 8;

  /**
   * The internal feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TARGET = 9;

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
      case INTERNAL_TRIGGER_RESULT_MESSAGE: return TRIGGER_RESULT_MESSAGE;
      case INTERNAL_TRIGGER_TIMER: return TRIGGER_TIMER;
      case INTERNAL_RESULT_ERROR: return RESULT_ERROR;
      case INTERNAL_RESULT_COMPENSATION: return RESULT_COMPENSATION;
      case INTERNAL_TRIGGER_RULE: return TRIGGER_RULE;
      case INTERNAL_TRIGGER_RESULT_LINK: return TRIGGER_RESULT_LINK;
      case INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE: return TRIGGER_INTERMEDIATE_MULTIPLE;
      case INTERNAL_TRIGGER: return TRIGGER;
      case INTERNAL_IMPLEMENTATION: return IMPLEMENTATION;
      case INTERNAL_TARGET: return TARGET;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getTriggerResultMessage() <em>Trigger Result Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerResultMessage()
   * @generated
   * @ordered
   */
  
  protected TriggerResultMessage triggerResultMessage = null;
  
  /**
   * This is true if the Trigger Result Message containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean triggerResultMessage_set_ = false;

  /**
   * The cached value of the '{@link #getTriggerTimer() <em>Trigger Timer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerTimer()
   * @generated
   * @ordered
   */
  
  protected TriggerTimer triggerTimer = null;
  
  /**
   * This is true if the Trigger Timer containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean triggerTimer_set_ = false;

  /**
   * The cached value of the '{@link #getResultError() <em>Result Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultError()
   * @generated
   * @ordered
   */
  
  protected ResultError resultError = null;
  
  /**
   * This is true if the Result Error containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean resultError_set_ = false;

  /**
   * The cached value of the '{@link #getResultCompensation() <em>Result Compensation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultCompensation()
   * @generated
   * @ordered
   */
  
  protected ResultCompensation resultCompensation = null;
  
  /**
   * This is true if the Result Compensation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean resultCompensation_set_ = false;

  /**
   * The cached value of the '{@link #getTriggerRule() <em>Trigger Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerRule()
   * @generated
   * @ordered
   */
  
  protected TriggerRule triggerRule = null;
  
  /**
   * This is true if the Trigger Rule containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean triggerRule_set_ = false;

  /**
   * The cached value of the '{@link #getTriggerResultLink() <em>Trigger Result Link</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerResultLink()
   * @generated
   * @ordered
   */
  
  protected TriggerResultLink triggerResultLink = null;
  
  /**
   * This is true if the Trigger Result Link containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean triggerResultLink_set_ = false;

  /**
   * The cached value of the '{@link #getTriggerIntermediateMultiple() <em>Trigger Intermediate Multiple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerIntermediateMultiple()
   * @generated
   * @ordered
   */
  
  protected TriggerIntermediateMultiple triggerIntermediateMultiple = null;
  
  /**
   * This is true if the Trigger Intermediate Multiple containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean triggerIntermediateMultiple_set_ = false;

  /**
   * The default value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected static final String TRIGGER_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected String trigger = TRIGGER_DEFAULT_;

  /**
   * This is true if the Trigger attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean trigger_set_ = false;

  /**
   * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementation()
   * @generated
   * @ordered
   */
  protected static final String IMPLEMENTATION_DEFAULT_ = "WebService";

  /**
   * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementation()
   * @generated
   * @ordered
   */
  protected String implementation = IMPLEMENTATION_DEFAULT_;

  /**
   * This is true if the Implementation attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean implementation_set_ = false;

  /**
   * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected static final String TARGET_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected String target = TARGET_DEFAULT_;

  /**
   * This is true if the Target attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean target_set_ = false;

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
  public IntermediateEventImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getIntermediateEvent();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerResultMessage getTriggerResultMessage()
  {
    return triggerResultMessage;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTriggerResultMessage(TriggerResultMessage newTriggerResultMessage, ChangeContext changeContext)
  {
    TriggerResultMessage oldTriggerResultMessage = triggerResultMessage;
    triggerResultMessage = newTriggerResultMessage;
    boolean oldTriggerResultMessage_set_ = triggerResultMessage_set_;
    triggerResultMessage_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRIGGER_RESULT_MESSAGE, oldTriggerResultMessage, newTriggerResultMessage, !oldTriggerResultMessage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerResultMessage(TriggerResultMessage newTriggerResultMessage)
  {
    if (newTriggerResultMessage != triggerResultMessage)
    {
      ChangeContext changeContext = null;
      if (triggerResultMessage != null)
        changeContext = inverseRemove(triggerResultMessage, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RESULT_MESSAGE, null, changeContext);
      if (newTriggerResultMessage != null)
        changeContext = inverseAdd(newTriggerResultMessage, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RESULT_MESSAGE, null, changeContext);
      changeContext = basicSetTriggerResultMessage(newTriggerResultMessage, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTriggerResultMessage_set_ = triggerResultMessage_set_;
      triggerResultMessage_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRIGGER_RESULT_MESSAGE, newTriggerResultMessage, newTriggerResultMessage, !oldTriggerResultMessage_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTriggerResultMessage(ChangeContext changeContext)
  {
    TriggerResultMessage oldTriggerResultMessage = triggerResultMessage;
    triggerResultMessage = null;
    boolean oldTriggerResultMessage_set_ = triggerResultMessage_set_;
    triggerResultMessage_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRIGGER_RESULT_MESSAGE, oldTriggerResultMessage, null, !oldTriggerResultMessage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTriggerResultMessage()
  {
    if (triggerResultMessage != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(triggerResultMessage, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RESULT_MESSAGE, null, changeContext);
      changeContext = basicUnsetTriggerResultMessage(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTriggerResultMessage_set_ = triggerResultMessage_set_;
      triggerResultMessage_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRIGGER_RESULT_MESSAGE, null, null, oldTriggerResultMessage_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTriggerResultMessage()
  {
    return triggerResultMessage_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerTimer getTriggerTimer()
  {
    return triggerTimer;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTriggerTimer(TriggerTimer newTriggerTimer, ChangeContext changeContext)
  {
    TriggerTimer oldTriggerTimer = triggerTimer;
    triggerTimer = newTriggerTimer;
    boolean oldTriggerTimer_set_ = triggerTimer_set_;
    triggerTimer_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRIGGER_TIMER, oldTriggerTimer, newTriggerTimer, !oldTriggerTimer_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerTimer(TriggerTimer newTriggerTimer)
  {
    if (newTriggerTimer != triggerTimer)
    {
      ChangeContext changeContext = null;
      if (triggerTimer != null)
        changeContext = inverseRemove(triggerTimer, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_TIMER, null, changeContext);
      if (newTriggerTimer != null)
        changeContext = inverseAdd(newTriggerTimer, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_TIMER, null, changeContext);
      changeContext = basicSetTriggerTimer(newTriggerTimer, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTriggerTimer_set_ = triggerTimer_set_;
      triggerTimer_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRIGGER_TIMER, newTriggerTimer, newTriggerTimer, !oldTriggerTimer_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTriggerTimer(ChangeContext changeContext)
  {
    TriggerTimer oldTriggerTimer = triggerTimer;
    triggerTimer = null;
    boolean oldTriggerTimer_set_ = triggerTimer_set_;
    triggerTimer_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRIGGER_TIMER, oldTriggerTimer, null, !oldTriggerTimer_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTriggerTimer()
  {
    if (triggerTimer != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(triggerTimer, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_TIMER, null, changeContext);
      changeContext = basicUnsetTriggerTimer(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTriggerTimer_set_ = triggerTimer_set_;
      triggerTimer_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRIGGER_TIMER, null, null, oldTriggerTimer_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTriggerTimer()
  {
    return triggerTimer_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultError getResultError()
  {
    return resultError;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetResultError(ResultError newResultError, ChangeContext changeContext)
  {
    ResultError oldResultError = resultError;
    resultError = newResultError;
    boolean oldResultError_set_ = resultError_set_;
    resultError_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_RESULT_ERROR, oldResultError, newResultError, !oldResultError_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultError(ResultError newResultError)
  {
    if (newResultError != resultError)
    {
      ChangeContext changeContext = null;
      if (resultError != null)
        changeContext = inverseRemove(resultError, this, OPPOSITE_FEATURE_BASE - INTERNAL_RESULT_ERROR, null, changeContext);
      if (newResultError != null)
        changeContext = inverseAdd(newResultError, this, OPPOSITE_FEATURE_BASE - INTERNAL_RESULT_ERROR, null, changeContext);
      changeContext = basicSetResultError(newResultError, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldResultError_set_ = resultError_set_;
      resultError_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_RESULT_ERROR, newResultError, newResultError, !oldResultError_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetResultError(ChangeContext changeContext)
  {
    ResultError oldResultError = resultError;
    resultError = null;
    boolean oldResultError_set_ = resultError_set_;
    resultError_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_RESULT_ERROR, oldResultError, null, !oldResultError_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetResultError()
  {
    if (resultError != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(resultError, this, EOPPOSITE_FEATURE_BASE - INTERNAL_RESULT_ERROR, null, changeContext);
      changeContext = basicUnsetResultError(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldResultError_set_ = resultError_set_;
      resultError_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_RESULT_ERROR, null, null, oldResultError_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetResultError()
  {
    return resultError_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultCompensation getResultCompensation()
  {
    return resultCompensation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetResultCompensation(ResultCompensation newResultCompensation, ChangeContext changeContext)
  {
    ResultCompensation oldResultCompensation = resultCompensation;
    resultCompensation = newResultCompensation;
    boolean oldResultCompensation_set_ = resultCompensation_set_;
    resultCompensation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_RESULT_COMPENSATION, oldResultCompensation, newResultCompensation, !oldResultCompensation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultCompensation(ResultCompensation newResultCompensation)
  {
    if (newResultCompensation != resultCompensation)
    {
      ChangeContext changeContext = null;
      if (resultCompensation != null)
        changeContext = inverseRemove(resultCompensation, this, OPPOSITE_FEATURE_BASE - INTERNAL_RESULT_COMPENSATION, null, changeContext);
      if (newResultCompensation != null)
        changeContext = inverseAdd(newResultCompensation, this, OPPOSITE_FEATURE_BASE - INTERNAL_RESULT_COMPENSATION, null, changeContext);
      changeContext = basicSetResultCompensation(newResultCompensation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldResultCompensation_set_ = resultCompensation_set_;
      resultCompensation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_RESULT_COMPENSATION, newResultCompensation, newResultCompensation, !oldResultCompensation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetResultCompensation(ChangeContext changeContext)
  {
    ResultCompensation oldResultCompensation = resultCompensation;
    resultCompensation = null;
    boolean oldResultCompensation_set_ = resultCompensation_set_;
    resultCompensation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_RESULT_COMPENSATION, oldResultCompensation, null, !oldResultCompensation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetResultCompensation()
  {
    if (resultCompensation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(resultCompensation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_RESULT_COMPENSATION, null, changeContext);
      changeContext = basicUnsetResultCompensation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldResultCompensation_set_ = resultCompensation_set_;
      resultCompensation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_RESULT_COMPENSATION, null, null, oldResultCompensation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetResultCompensation()
  {
    return resultCompensation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerRule getTriggerRule()
  {
    return triggerRule;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTriggerRule(TriggerRule newTriggerRule, ChangeContext changeContext)
  {
    TriggerRule oldTriggerRule = triggerRule;
    triggerRule = newTriggerRule;
    boolean oldTriggerRule_set_ = triggerRule_set_;
    triggerRule_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRIGGER_RULE, oldTriggerRule, newTriggerRule, !oldTriggerRule_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerRule(TriggerRule newTriggerRule)
  {
    if (newTriggerRule != triggerRule)
    {
      ChangeContext changeContext = null;
      if (triggerRule != null)
        changeContext = inverseRemove(triggerRule, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RULE, null, changeContext);
      if (newTriggerRule != null)
        changeContext = inverseAdd(newTriggerRule, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RULE, null, changeContext);
      changeContext = basicSetTriggerRule(newTriggerRule, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTriggerRule_set_ = triggerRule_set_;
      triggerRule_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRIGGER_RULE, newTriggerRule, newTriggerRule, !oldTriggerRule_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTriggerRule(ChangeContext changeContext)
  {
    TriggerRule oldTriggerRule = triggerRule;
    triggerRule = null;
    boolean oldTriggerRule_set_ = triggerRule_set_;
    triggerRule_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRIGGER_RULE, oldTriggerRule, null, !oldTriggerRule_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTriggerRule()
  {
    if (triggerRule != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(triggerRule, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RULE, null, changeContext);
      changeContext = basicUnsetTriggerRule(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTriggerRule_set_ = triggerRule_set_;
      triggerRule_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRIGGER_RULE, null, null, oldTriggerRule_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTriggerRule()
  {
    return triggerRule_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerResultLink getTriggerResultLink()
  {
    return triggerResultLink;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTriggerResultLink(TriggerResultLink newTriggerResultLink, ChangeContext changeContext)
  {
    TriggerResultLink oldTriggerResultLink = triggerResultLink;
    triggerResultLink = newTriggerResultLink;
    boolean oldTriggerResultLink_set_ = triggerResultLink_set_;
    triggerResultLink_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRIGGER_RESULT_LINK, oldTriggerResultLink, newTriggerResultLink, !oldTriggerResultLink_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerResultLink(TriggerResultLink newTriggerResultLink)
  {
    if (newTriggerResultLink != triggerResultLink)
    {
      ChangeContext changeContext = null;
      if (triggerResultLink != null)
        changeContext = inverseRemove(triggerResultLink, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RESULT_LINK, null, changeContext);
      if (newTriggerResultLink != null)
        changeContext = inverseAdd(newTriggerResultLink, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RESULT_LINK, null, changeContext);
      changeContext = basicSetTriggerResultLink(newTriggerResultLink, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTriggerResultLink_set_ = triggerResultLink_set_;
      triggerResultLink_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRIGGER_RESULT_LINK, newTriggerResultLink, newTriggerResultLink, !oldTriggerResultLink_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTriggerResultLink(ChangeContext changeContext)
  {
    TriggerResultLink oldTriggerResultLink = triggerResultLink;
    triggerResultLink = null;
    boolean oldTriggerResultLink_set_ = triggerResultLink_set_;
    triggerResultLink_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRIGGER_RESULT_LINK, oldTriggerResultLink, null, !oldTriggerResultLink_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTriggerResultLink()
  {
    if (triggerResultLink != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(triggerResultLink, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_RESULT_LINK, null, changeContext);
      changeContext = basicUnsetTriggerResultLink(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTriggerResultLink_set_ = triggerResultLink_set_;
      triggerResultLink_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRIGGER_RESULT_LINK, null, null, oldTriggerResultLink_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTriggerResultLink()
  {
    return triggerResultLink_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerIntermediateMultiple getTriggerIntermediateMultiple()
  {
    return triggerIntermediateMultiple;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTriggerIntermediateMultiple(TriggerIntermediateMultiple newTriggerIntermediateMultiple, ChangeContext changeContext)
  {
    TriggerIntermediateMultiple oldTriggerIntermediateMultiple = triggerIntermediateMultiple;
    triggerIntermediateMultiple = newTriggerIntermediateMultiple;
    boolean oldTriggerIntermediateMultiple_set_ = triggerIntermediateMultiple_set_;
    triggerIntermediateMultiple_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE, oldTriggerIntermediateMultiple, newTriggerIntermediateMultiple, !oldTriggerIntermediateMultiple_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerIntermediateMultiple(TriggerIntermediateMultiple newTriggerIntermediateMultiple)
  {
    if (newTriggerIntermediateMultiple != triggerIntermediateMultiple)
    {
      ChangeContext changeContext = null;
      if (triggerIntermediateMultiple != null)
        changeContext = inverseRemove(triggerIntermediateMultiple, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE, null, changeContext);
      if (newTriggerIntermediateMultiple != null)
        changeContext = inverseAdd(newTriggerIntermediateMultiple, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE, null, changeContext);
      changeContext = basicSetTriggerIntermediateMultiple(newTriggerIntermediateMultiple, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTriggerIntermediateMultiple_set_ = triggerIntermediateMultiple_set_;
      triggerIntermediateMultiple_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE, newTriggerIntermediateMultiple, newTriggerIntermediateMultiple, !oldTriggerIntermediateMultiple_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTriggerIntermediateMultiple(ChangeContext changeContext)
  {
    TriggerIntermediateMultiple oldTriggerIntermediateMultiple = triggerIntermediateMultiple;
    triggerIntermediateMultiple = null;
    boolean oldTriggerIntermediateMultiple_set_ = triggerIntermediateMultiple_set_;
    triggerIntermediateMultiple_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE, oldTriggerIntermediateMultiple, null, !oldTriggerIntermediateMultiple_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTriggerIntermediateMultiple()
  {
    if (triggerIntermediateMultiple != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(triggerIntermediateMultiple, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE, null, changeContext);
      changeContext = basicUnsetTriggerIntermediateMultiple(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTriggerIntermediateMultiple_set_ = triggerIntermediateMultiple_set_;
      triggerIntermediateMultiple_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRIGGER_INTERMEDIATE_MULTIPLE, null, null, oldTriggerIntermediateMultiple_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTriggerIntermediateMultiple()
  {
    return triggerIntermediateMultiple_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrigger()
  {
    return trigger;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrigger(String newTrigger)
  {
    String oldTrigger = trigger;
    trigger = newTrigger;
    boolean oldTrigger_set_ = trigger_set_;
    trigger_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TRIGGER, oldTrigger, trigger, !oldTrigger_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTrigger()
  {
    String oldTrigger = trigger;
    boolean oldTrigger_set_ = trigger_set_;
    trigger = TRIGGER_DEFAULT_;
    trigger_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TRIGGER, oldTrigger, TRIGGER_DEFAULT_, oldTrigger_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTrigger()
  {
    return trigger_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImplementation()
  {
    return implementation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImplementation(String newImplementation)
  {
    String oldImplementation = implementation;
    implementation = newImplementation;
    boolean oldImplementation_set_ = implementation_set_;
    implementation_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_IMPLEMENTATION, oldImplementation, implementation, !oldImplementation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetImplementation()
  {
    String oldImplementation = implementation;
    boolean oldImplementation_set_ = implementation_set_;
    implementation = IMPLEMENTATION_DEFAULT_;
    implementation_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_IMPLEMENTATION, oldImplementation, IMPLEMENTATION_DEFAULT_, oldImplementation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetImplementation()
  {
    return implementation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTarget()
  {
    return target;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(String newTarget)
  {
    String oldTarget = target;
    target = newTarget;
    boolean oldTarget_set_ = target_set_;
    target_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TARGET, oldTarget, target, !oldTarget_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTarget()
  {
    String oldTarget = target;
    boolean oldTarget_set_ = target_set_;
    target = TARGET_DEFAULT_;
    target_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TARGET, oldTarget, TARGET_DEFAULT_, oldTarget_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTarget()
  {
    return target_set_;
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
      case TRIGGER_RESULT_MESSAGE:
        return basicUnsetTriggerResultMessage(changeContext);
      case TRIGGER_TIMER:
        return basicUnsetTriggerTimer(changeContext);
      case RESULT_ERROR:
        return basicUnsetResultError(changeContext);
      case RESULT_COMPENSATION:
        return basicUnsetResultCompensation(changeContext);
      case TRIGGER_RULE:
        return basicUnsetTriggerRule(changeContext);
      case TRIGGER_RESULT_LINK:
        return basicUnsetTriggerResultLink(changeContext);
      case TRIGGER_INTERMEDIATE_MULTIPLE:
        return basicUnsetTriggerIntermediateMultiple(changeContext);
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
      case TRIGGER_RESULT_MESSAGE:
        return getTriggerResultMessage();
      case TRIGGER_TIMER:
        return getTriggerTimer();
      case RESULT_ERROR:
        return getResultError();
      case RESULT_COMPENSATION:
        return getResultCompensation();
      case TRIGGER_RULE:
        return getTriggerRule();
      case TRIGGER_RESULT_LINK:
        return getTriggerResultLink();
      case TRIGGER_INTERMEDIATE_MULTIPLE:
        return getTriggerIntermediateMultiple();
      case TRIGGER:
        return getTrigger();
      case IMPLEMENTATION:
        return getImplementation();
      case TARGET:
        return getTarget();
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
      case TRIGGER_RESULT_MESSAGE:
        setTriggerResultMessage((TriggerResultMessage)newValue);
        return;
      case TRIGGER_TIMER:
        setTriggerTimer((TriggerTimer)newValue);
        return;
      case RESULT_ERROR:
        setResultError((ResultError)newValue);
        return;
      case RESULT_COMPENSATION:
        setResultCompensation((ResultCompensation)newValue);
        return;
      case TRIGGER_RULE:
        setTriggerRule((TriggerRule)newValue);
        return;
      case TRIGGER_RESULT_LINK:
        setTriggerResultLink((TriggerResultLink)newValue);
        return;
      case TRIGGER_INTERMEDIATE_MULTIPLE:
        setTriggerIntermediateMultiple((TriggerIntermediateMultiple)newValue);
        return;
      case TRIGGER:
        setTrigger((String)newValue);
        return;
      case IMPLEMENTATION:
        setImplementation((String)newValue);
        return;
      case TARGET:
        setTarget((String)newValue);
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
      case TRIGGER_RESULT_MESSAGE:
        unsetTriggerResultMessage();
        return;
      case TRIGGER_TIMER:
        unsetTriggerTimer();
        return;
      case RESULT_ERROR:
        unsetResultError();
        return;
      case RESULT_COMPENSATION:
        unsetResultCompensation();
        return;
      case TRIGGER_RULE:
        unsetTriggerRule();
        return;
      case TRIGGER_RESULT_LINK:
        unsetTriggerResultLink();
        return;
      case TRIGGER_INTERMEDIATE_MULTIPLE:
        unsetTriggerIntermediateMultiple();
        return;
      case TRIGGER:
        unsetTrigger();
        return;
      case IMPLEMENTATION:
        unsetImplementation();
        return;
      case TARGET:
        unsetTarget();
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
      case TRIGGER_RESULT_MESSAGE:
        return isSetTriggerResultMessage();
      case TRIGGER_TIMER:
        return isSetTriggerTimer();
      case RESULT_ERROR:
        return isSetResultError();
      case RESULT_COMPENSATION:
        return isSetResultCompensation();
      case TRIGGER_RULE:
        return isSetTriggerRule();
      case TRIGGER_RESULT_LINK:
        return isSetTriggerResultLink();
      case TRIGGER_INTERMEDIATE_MULTIPLE:
        return isSetTriggerIntermediateMultiple();
      case TRIGGER:
        return isSetTrigger();
      case IMPLEMENTATION:
        return isSetImplementation();
      case TARGET:
        return isSetTarget();
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
    result.append(" (Trigger: ");
    if (trigger_set_) result.append(trigger); else result.append("<unset>");
    result.append(", Implementation: ");
    if (implementation_set_) result.append(implementation); else result.append("<unset>");
    result.append(", Target: ");
    if (target_set_) result.append(target); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //IntermediateEventImpl
