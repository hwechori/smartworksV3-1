/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResultMultipleImpl.java,v 1.1 2009/12/22 06:17:49 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.ResultCompensation;
import net.smartworks.server.engine.process.xpdl.xpdl2.ResultError;
import net.smartworks.server.engine.process.xpdl.xpdl2.ResultMultiple;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultLink;
import net.smartworks.server.engine.process.xpdl.xpdl2.TriggerResultMessage;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Multiple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ResultMultipleImpl#getTriggerResultMessage <em>Trigger Result Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ResultMultipleImpl#getTriggerResultLink <em>Trigger Result Link</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ResultMultipleImpl#getResultCompensation <em>Result Compensation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ResultMultipleImpl#getResultError <em>Result Error</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ResultMultipleImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ResultMultipleImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultMultipleImpl extends DataObjectBase implements ResultMultiple
{

  public final static int TRIGGER_RESULT_MESSAGE = 0;

  public final static int TRIGGER_RESULT_LINK = 1;

  public final static int RESULT_COMPENSATION = 2;

  public final static int RESULT_ERROR = 3;

  public final static int ANY = -1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 4;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Trigger Result Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_RESULT_MESSAGE = 0;

  /**
   * The internal feature id for the '<em><b>Trigger Result Link</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRIGGER_RESULT_LINK = 1;

  /**
   * The internal feature id for the '<em><b>Result Compensation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_RESULT_COMPENSATION = 2;

  /**
   * The internal feature id for the '<em><b>Result Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_RESULT_ERROR = 3;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 4;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 5;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 6;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_TRIGGER_RESULT_MESSAGE: return TRIGGER_RESULT_MESSAGE;
      case INTERNAL_TRIGGER_RESULT_LINK: return TRIGGER_RESULT_LINK;
      case INTERNAL_RESULT_COMPENSATION: return RESULT_COMPENSATION;
      case INTERNAL_RESULT_ERROR: return RESULT_ERROR;
      case INTERNAL_ANY: return ANY;
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
  public ResultMultipleImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getResultMultiple();
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
      case TRIGGER_RESULT_MESSAGE:
        return basicUnsetTriggerResultMessage(changeContext);
      case TRIGGER_RESULT_LINK:
        return basicUnsetTriggerResultLink(changeContext);
      case RESULT_COMPENSATION:
        return basicUnsetResultCompensation(changeContext);
      case RESULT_ERROR:
        return basicUnsetResultError(changeContext);
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
      case TRIGGER_RESULT_MESSAGE:
        return getTriggerResultMessage();
      case TRIGGER_RESULT_LINK:
        return getTriggerResultLink();
      case RESULT_COMPENSATION:
        return getResultCompensation();
      case RESULT_ERROR:
        return getResultError();
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
      case TRIGGER_RESULT_MESSAGE:
        setTriggerResultMessage((TriggerResultMessage)newValue);
        return;
      case TRIGGER_RESULT_LINK:
        setTriggerResultLink((TriggerResultLink)newValue);
        return;
      case RESULT_COMPENSATION:
        setResultCompensation((ResultCompensation)newValue);
        return;
      case RESULT_ERROR:
        setResultError((ResultError)newValue);
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
      case TRIGGER_RESULT_MESSAGE:
        unsetTriggerResultMessage();
        return;
      case TRIGGER_RESULT_LINK:
        unsetTriggerResultLink();
        return;
      case RESULT_COMPENSATION:
        unsetResultCompensation();
        return;
      case RESULT_ERROR:
        unsetResultError();
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
      case TRIGGER_RESULT_MESSAGE:
        return isSetTriggerResultMessage();
      case TRIGGER_RESULT_LINK:
        return isSetTriggerResultLink();
      case RESULT_COMPENSATION:
        return isSetResultCompensation();
      case RESULT_ERROR:
        return isSetResultError();
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

} //ResultMultipleImpl
