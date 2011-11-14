/**
 * <copyright>
 * </copyright>
 *
 * $Id: EventImpl.java,v 1.1 2009/12/22 06:17:53 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.EndEvent;
import net.smartworks.server.engine.process.xpdl.xpdl2.Event;
import net.smartworks.server.engine.process.xpdl.xpdl2.IntermediateEvent;
import net.smartworks.server.engine.process.xpdl.xpdl2.StartEvent;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EventImpl#getStartEvent <em>Start Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EventImpl#getIntermediateEvent <em>Intermediate Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EventImpl#getEndEvent <em>End Event</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EventImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventImpl extends DataObjectBase implements Event
{

  public final static int START_EVENT = 0;

  public final static int INTERMEDIATE_EVENT = 1;

  public final static int END_EVENT = 2;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Start Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_START_EVENT = 0;

  /**
   * The internal feature id for the '<em><b>Intermediate Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INTERMEDIATE_EVENT = 1;

  /**
   * The internal feature id for the '<em><b>End Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_END_EVENT = 2;

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
      case INTERNAL_START_EVENT: return START_EVENT;
      case INTERNAL_INTERMEDIATE_EVENT: return INTERMEDIATE_EVENT;
      case INTERNAL_END_EVENT: return END_EVENT;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getStartEvent() <em>Start Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartEvent()
   * @generated
   * @ordered
   */
  
  protected StartEvent startEvent = null;
  
  /**
   * This is true if the Start Event containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean startEvent_set_ = false;

  /**
   * The cached value of the '{@link #getIntermediateEvent() <em>Intermediate Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntermediateEvent()
   * @generated
   * @ordered
   */
  
  protected IntermediateEvent intermediateEvent = null;
  
  /**
   * This is true if the Intermediate Event containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean intermediateEvent_set_ = false;

  /**
   * The cached value of the '{@link #getEndEvent() <em>End Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndEvent()
   * @generated
   * @ordered
   */
  
  protected EndEvent endEvent = null;
  
  /**
   * This is true if the End Event containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean endEvent_set_ = false;

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
  public EventImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getEvent();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StartEvent getStartEvent()
  {
    return startEvent;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetStartEvent(StartEvent newStartEvent, ChangeContext changeContext)
  {
    StartEvent oldStartEvent = startEvent;
    startEvent = newStartEvent;
    boolean oldStartEvent_set_ = startEvent_set_;
    startEvent_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_START_EVENT, oldStartEvent, newStartEvent, !oldStartEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartEvent(StartEvent newStartEvent)
  {
    if (newStartEvent != startEvent)
    {
      ChangeContext changeContext = null;
      if (startEvent != null)
        changeContext = inverseRemove(startEvent, this, OPPOSITE_FEATURE_BASE - INTERNAL_START_EVENT, null, changeContext);
      if (newStartEvent != null)
        changeContext = inverseAdd(newStartEvent, this, OPPOSITE_FEATURE_BASE - INTERNAL_START_EVENT, null, changeContext);
      changeContext = basicSetStartEvent(newStartEvent, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldStartEvent_set_ = startEvent_set_;
      startEvent_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_START_EVENT, newStartEvent, newStartEvent, !oldStartEvent_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetStartEvent(ChangeContext changeContext)
  {
    StartEvent oldStartEvent = startEvent;
    startEvent = null;
    boolean oldStartEvent_set_ = startEvent_set_;
    startEvent_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_START_EVENT, oldStartEvent, null, !oldStartEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStartEvent()
  {
    if (startEvent != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(startEvent, this, EOPPOSITE_FEATURE_BASE - INTERNAL_START_EVENT, null, changeContext);
      changeContext = basicUnsetStartEvent(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldStartEvent_set_ = startEvent_set_;
      startEvent_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_START_EVENT, null, null, oldStartEvent_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStartEvent()
  {
    return startEvent_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntermediateEvent getIntermediateEvent()
  {
    return intermediateEvent;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetIntermediateEvent(IntermediateEvent newIntermediateEvent, ChangeContext changeContext)
  {
    IntermediateEvent oldIntermediateEvent = intermediateEvent;
    intermediateEvent = newIntermediateEvent;
    boolean oldIntermediateEvent_set_ = intermediateEvent_set_;
    intermediateEvent_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_INTERMEDIATE_EVENT, oldIntermediateEvent, newIntermediateEvent, !oldIntermediateEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntermediateEvent(IntermediateEvent newIntermediateEvent)
  {
    if (newIntermediateEvent != intermediateEvent)
    {
      ChangeContext changeContext = null;
      if (intermediateEvent != null)
        changeContext = inverseRemove(intermediateEvent, this, OPPOSITE_FEATURE_BASE - INTERNAL_INTERMEDIATE_EVENT, null, changeContext);
      if (newIntermediateEvent != null)
        changeContext = inverseAdd(newIntermediateEvent, this, OPPOSITE_FEATURE_BASE - INTERNAL_INTERMEDIATE_EVENT, null, changeContext);
      changeContext = basicSetIntermediateEvent(newIntermediateEvent, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldIntermediateEvent_set_ = intermediateEvent_set_;
      intermediateEvent_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_INTERMEDIATE_EVENT, newIntermediateEvent, newIntermediateEvent, !oldIntermediateEvent_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetIntermediateEvent(ChangeContext changeContext)
  {
    IntermediateEvent oldIntermediateEvent = intermediateEvent;
    intermediateEvent = null;
    boolean oldIntermediateEvent_set_ = intermediateEvent_set_;
    intermediateEvent_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_INTERMEDIATE_EVENT, oldIntermediateEvent, null, !oldIntermediateEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIntermediateEvent()
  {
    if (intermediateEvent != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(intermediateEvent, this, EOPPOSITE_FEATURE_BASE - INTERNAL_INTERMEDIATE_EVENT, null, changeContext);
      changeContext = basicUnsetIntermediateEvent(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldIntermediateEvent_set_ = intermediateEvent_set_;
      intermediateEvent_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_INTERMEDIATE_EVENT, null, null, oldIntermediateEvent_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIntermediateEvent()
  {
    return intermediateEvent_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndEvent getEndEvent()
  {
    return endEvent;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetEndEvent(EndEvent newEndEvent, ChangeContext changeContext)
  {
    EndEvent oldEndEvent = endEvent;
    endEvent = newEndEvent;
    boolean oldEndEvent_set_ = endEvent_set_;
    endEvent_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_END_EVENT, oldEndEvent, newEndEvent, !oldEndEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndEvent(EndEvent newEndEvent)
  {
    if (newEndEvent != endEvent)
    {
      ChangeContext changeContext = null;
      if (endEvent != null)
        changeContext = inverseRemove(endEvent, this, OPPOSITE_FEATURE_BASE - INTERNAL_END_EVENT, null, changeContext);
      if (newEndEvent != null)
        changeContext = inverseAdd(newEndEvent, this, OPPOSITE_FEATURE_BASE - INTERNAL_END_EVENT, null, changeContext);
      changeContext = basicSetEndEvent(newEndEvent, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldEndEvent_set_ = endEvent_set_;
      endEvent_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_END_EVENT, newEndEvent, newEndEvent, !oldEndEvent_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetEndEvent(ChangeContext changeContext)
  {
    EndEvent oldEndEvent = endEvent;
    endEvent = null;
    boolean oldEndEvent_set_ = endEvent_set_;
    endEvent_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_END_EVENT, oldEndEvent, null, !oldEndEvent_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEndEvent()
  {
    if (endEvent != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(endEvent, this, EOPPOSITE_FEATURE_BASE - INTERNAL_END_EVENT, null, changeContext);
      changeContext = basicUnsetEndEvent(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldEndEvent_set_ = endEvent_set_;
      endEvent_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_END_EVENT, null, null, oldEndEvent_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEndEvent()
  {
    return endEvent_set_;
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
      case START_EVENT:
        return basicUnsetStartEvent(changeContext);
      case INTERMEDIATE_EVENT:
        return basicUnsetIntermediateEvent(changeContext);
      case END_EVENT:
        return basicUnsetEndEvent(changeContext);
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
      case START_EVENT:
        return getStartEvent();
      case INTERMEDIATE_EVENT:
        return getIntermediateEvent();
      case END_EVENT:
        return getEndEvent();
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
      case START_EVENT:
        setStartEvent((StartEvent)newValue);
        return;
      case INTERMEDIATE_EVENT:
        setIntermediateEvent((IntermediateEvent)newValue);
        return;
      case END_EVENT:
        setEndEvent((EndEvent)newValue);
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
      case START_EVENT:
        unsetStartEvent();
        return;
      case INTERMEDIATE_EVENT:
        unsetIntermediateEvent();
        return;
      case END_EVENT:
        unsetEndEvent();
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
      case START_EVENT:
        return isSetStartEvent();
      case INTERMEDIATE_EVENT:
        return isSetIntermediateEvent();
      case END_EVENT:
        return isSetEndEvent();
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
    result.append(" (anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //EventImpl
