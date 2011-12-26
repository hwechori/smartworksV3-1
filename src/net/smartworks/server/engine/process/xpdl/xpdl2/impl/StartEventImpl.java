/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartEventImpl.java,v 1.1 2009/12/22 06:17:46 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerMultiple;
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
 * An implementation of the model object '<em><b>Start Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getTriggerResultMessage <em>Trigger Result Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getTriggerTimer <em>Trigger Timer</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getTriggerRule <em>Trigger Rule</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getTriggerResultLink <em>Trigger Result Link</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getTriggerMultiple <em>Trigger Multiple</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.StartEventImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StartEventImpl extends DataObjectBase implements StartEvent
{

  public final static int TRIGGER_RESULT_MESSAGE = 0;

  public final static int TRIGGER_TIMER = 1;

  public final static int TRIGGER_RULE = 2;

  public final static int TRIGGER_RESULT_LINK = 3;

  public final static int TRIGGER_MULTIPLE = 4;

  public final static int TRIGGER = 5;

  public final static int IMPLEMENTATION = 6;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 7;

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
   * The internal feature id for the '<em><b>Trigger Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_RULE = 2;

  /**
   * The internal feature id for the '<em><b>Trigger Result Link</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_RESULT_LINK = 3;

  /**
   * The internal feature id for the '<em><b>Trigger Multiple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_MULTIPLE = 4;

  /**
   * The internal feature id for the '<em><b>Trigger</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER = 5;

  /**
   * The internal feature id for the '<em><b>Implementation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IMPLEMENTATION = 6;

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
      case INTERNAL_TRIGGER_RESULT_MESSAGE: return TRIGGER_RESULT_MESSAGE;
      case INTERNAL_TRIGGER_TIMER: return TRIGGER_TIMER;
      case INTERNAL_TRIGGER_RULE: return TRIGGER_RULE;
      case INTERNAL_TRIGGER_RESULT_LINK: return TRIGGER_RESULT_LINK;
      case INTERNAL_TRIGGER_MULTIPLE: return TRIGGER_MULTIPLE;
      case INTERNAL_TRIGGER: return TRIGGER;
      case INTERNAL_IMPLEMENTATION: return IMPLEMENTATION;
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
   * The cached value of the '{@link #getTriggerMultiple() <em>Trigger Multiple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerMultiple()
   * @generated
   * @ordered
   */
  
  protected TriggerMultiple triggerMultiple = null;
  
  /**
   * This is true if the Trigger Multiple containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean triggerMultiple_set_ = false;

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
  public StartEventImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getStartEvent();
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
  public TriggerMultiple getTriggerMultiple()
  {
    return triggerMultiple;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTriggerMultiple(TriggerMultiple newTriggerMultiple, ChangeContext changeContext)
  {
    TriggerMultiple oldTriggerMultiple = triggerMultiple;
    triggerMultiple = newTriggerMultiple;
    boolean oldTriggerMultiple_set_ = triggerMultiple_set_;
    triggerMultiple_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRIGGER_MULTIPLE, oldTriggerMultiple, newTriggerMultiple, !oldTriggerMultiple_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerMultiple(TriggerMultiple newTriggerMultiple)
  {
    if (newTriggerMultiple != triggerMultiple)
    {
      ChangeContext changeContext = null;
      if (triggerMultiple != null)
        changeContext = inverseRemove(triggerMultiple, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_MULTIPLE, null, changeContext);
      if (newTriggerMultiple != null)
        changeContext = inverseAdd(newTriggerMultiple, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_MULTIPLE, null, changeContext);
      changeContext = basicSetTriggerMultiple(newTriggerMultiple, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTriggerMultiple_set_ = triggerMultiple_set_;
      triggerMultiple_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRIGGER_MULTIPLE, newTriggerMultiple, newTriggerMultiple, !oldTriggerMultiple_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTriggerMultiple(ChangeContext changeContext)
  {
    TriggerMultiple oldTriggerMultiple = triggerMultiple;
    triggerMultiple = null;
    boolean oldTriggerMultiple_set_ = triggerMultiple_set_;
    triggerMultiple_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRIGGER_MULTIPLE, oldTriggerMultiple, null, !oldTriggerMultiple_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTriggerMultiple()
  {
    if (triggerMultiple != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(triggerMultiple, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRIGGER_MULTIPLE, null, changeContext);
      changeContext = basicUnsetTriggerMultiple(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTriggerMultiple_set_ = triggerMultiple_set_;
      triggerMultiple_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRIGGER_MULTIPLE, null, null, oldTriggerMultiple_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTriggerMultiple()
  {
    return triggerMultiple_set_;
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
      case TRIGGER_RULE:
        return basicUnsetTriggerRule(changeContext);
      case TRIGGER_RESULT_LINK:
        return basicUnsetTriggerResultLink(changeContext);
      case TRIGGER_MULTIPLE:
        return basicUnsetTriggerMultiple(changeContext);
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
      case TRIGGER_RULE:
        return getTriggerRule();
      case TRIGGER_RESULT_LINK:
        return getTriggerResultLink();
      case TRIGGER_MULTIPLE:
        return getTriggerMultiple();
      case TRIGGER:
        return getTrigger();
      case IMPLEMENTATION:
        return getImplementation();
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
      case TRIGGER_RULE:
        setTriggerRule((TriggerRule)newValue);
        return;
      case TRIGGER_RESULT_LINK:
        setTriggerResultLink((TriggerResultLink)newValue);
        return;
      case TRIGGER_MULTIPLE:
        setTriggerMultiple((TriggerMultiple)newValue);
        return;
      case TRIGGER:
        setTrigger((String)newValue);
        return;
      case IMPLEMENTATION:
        setImplementation((String)newValue);
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
      case TRIGGER_RULE:
        unsetTriggerRule();
        return;
      case TRIGGER_RESULT_LINK:
        unsetTriggerResultLink();
        return;
      case TRIGGER_MULTIPLE:
        unsetTriggerMultiple();
        return;
      case TRIGGER:
        unsetTrigger();
        return;
      case IMPLEMENTATION:
        unsetImplementation();
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
      case TRIGGER_RULE:
        return isSetTriggerRule();
      case TRIGGER_RESULT_LINK:
        return isSetTriggerResultLink();
      case TRIGGER_MULTIPLE:
        return isSetTriggerMultiple();
      case TRIGGER:
        return isSetTrigger();
      case IMPLEMENTATION:
        return isSetImplementation();
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
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //StartEventImpl
