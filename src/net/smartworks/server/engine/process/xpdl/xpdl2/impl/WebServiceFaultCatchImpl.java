/**
 * <copyright>
 * </copyright>
 *
 * $Id: WebServiceFaultCatchImpl.java,v 1.1 2009/12/22 06:17:24 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.BlockActivity;
import net.smartworks.server.engine.process.xpdl.xpdl2.MessageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.TransitionRef;
import net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Service Fault Catch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceFaultCatchImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceFaultCatchImpl#getBlockActivity <em>Block Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceFaultCatchImpl#getTransitionRef <em>Transition Ref</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceFaultCatchImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceFaultCatchImpl#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceFaultCatchImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebServiceFaultCatchImpl extends DataObjectBase implements WebServiceFaultCatch
{

  public final static int MESSAGE = 0;

  public final static int BLOCK_ACTIVITY = 1;

  public final static int TRANSITION_REF = 2;

  public final static int ANY = -1;

  public final static int FAULT_NAME = 3;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 4;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MESSAGE = 0;

  /**
   * The internal feature id for the '<em><b>Block Activity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BLOCK_ACTIVITY = 1;

  /**
   * The internal feature id for the '<em><b>Transition Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITION_REF = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

  /**
   * The internal feature id for the '<em><b>Fault Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FAULT_NAME = 4;

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
      case INTERNAL_MESSAGE: return MESSAGE;
      case INTERNAL_BLOCK_ACTIVITY: return BLOCK_ACTIVITY;
      case INTERNAL_TRANSITION_REF: return TRANSITION_REF;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_FAULT_NAME: return FAULT_NAME;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  
  protected MessageType message = null;
  
  /**
   * This is true if the Message containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean message_set_ = false;

  /**
   * The cached value of the '{@link #getBlockActivity() <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockActivity()
   * @generated
   * @ordered
   */
  
  protected BlockActivity blockActivity = null;
  
  /**
   * This is true if the Block Activity containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean blockActivity_set_ = false;

  /**
   * The cached value of the '{@link #getTransitionRef() <em>Transition Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionRef()
   * @generated
   * @ordered
   */
  
  protected TransitionRef transitionRef = null;
  
  /**
   * This is true if the Transition Ref containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transitionRef_set_ = false;

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
   * The default value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFaultName()
   * @generated
   * @ordered
   */
  protected static final String FAULT_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFaultName()
   * @generated
   * @ordered
   */
  protected String faultName = FAULT_NAME_DEFAULT_;

  /**
   * This is true if the Fault Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean faultName_set_ = false;

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
  public WebServiceFaultCatchImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getWebServiceFaultCatch();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageType getMessage()
  {
    return message;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetMessage(MessageType newMessage, ChangeContext changeContext)
  {
    MessageType oldMessage = message;
    message = newMessage;
    boolean oldMessage_set_ = message_set_;
    message_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_MESSAGE, oldMessage, newMessage, !oldMessage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(MessageType newMessage)
  {
    if (newMessage != message)
    {
      ChangeContext changeContext = null;
      if (message != null)
        changeContext = inverseRemove(message, this, OPPOSITE_FEATURE_BASE - INTERNAL_MESSAGE, null, changeContext);
      if (newMessage != null)
        changeContext = inverseAdd(newMessage, this, OPPOSITE_FEATURE_BASE - INTERNAL_MESSAGE, null, changeContext);
      changeContext = basicSetMessage(newMessage, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldMessage_set_ = message_set_;
      message_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_MESSAGE, newMessage, newMessage, !oldMessage_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetMessage(ChangeContext changeContext)
  {
    MessageType oldMessage = message;
    message = null;
    boolean oldMessage_set_ = message_set_;
    message_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_MESSAGE, oldMessage, null, !oldMessage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMessage()
  {
    if (message != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(message, this, EOPPOSITE_FEATURE_BASE - INTERNAL_MESSAGE, null, changeContext);
      changeContext = basicUnsetMessage(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldMessage_set_ = message_set_;
      message_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_MESSAGE, null, null, oldMessage_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMessage()
  {
    return message_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockActivity getBlockActivity()
  {
    return blockActivity;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetBlockActivity(BlockActivity newBlockActivity, ChangeContext changeContext)
  {
    BlockActivity oldBlockActivity = blockActivity;
    blockActivity = newBlockActivity;
    boolean oldBlockActivity_set_ = blockActivity_set_;
    blockActivity_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY, oldBlockActivity, newBlockActivity, !oldBlockActivity_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlockActivity(BlockActivity newBlockActivity)
  {
    if (newBlockActivity != blockActivity)
    {
      ChangeContext changeContext = null;
      if (blockActivity != null)
        changeContext = inverseRemove(blockActivity, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      if (newBlockActivity != null)
        changeContext = inverseAdd(newBlockActivity, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      changeContext = basicSetBlockActivity(newBlockActivity, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldBlockActivity_set_ = blockActivity_set_;
      blockActivity_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY, newBlockActivity, newBlockActivity, !oldBlockActivity_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetBlockActivity(ChangeContext changeContext)
  {
    BlockActivity oldBlockActivity = blockActivity;
    blockActivity = null;
    boolean oldBlockActivity_set_ = blockActivity_set_;
    blockActivity_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY, oldBlockActivity, null, !oldBlockActivity_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBlockActivity()
  {
    if (blockActivity != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(blockActivity, this, EOPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      changeContext = basicUnsetBlockActivity(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldBlockActivity_set_ = blockActivity_set_;
      blockActivity_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY, null, null, oldBlockActivity_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBlockActivity()
  {
    return blockActivity_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRef getTransitionRef()
  {
    return transitionRef;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransitionRef(TransitionRef newTransitionRef, ChangeContext changeContext)
  {
    TransitionRef oldTransitionRef = transitionRef;
    transitionRef = newTransitionRef;
    boolean oldTransitionRef_set_ = transitionRef_set_;
    transitionRef_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSITION_REF, oldTransitionRef, newTransitionRef, !oldTransitionRef_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitionRef(TransitionRef newTransitionRef)
  {
    if (newTransitionRef != transitionRef)
    {
      ChangeContext changeContext = null;
      if (transitionRef != null)
        changeContext = inverseRemove(transitionRef, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_REF, null, changeContext);
      if (newTransitionRef != null)
        changeContext = inverseAdd(newTransitionRef, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_REF, null, changeContext);
      changeContext = basicSetTransitionRef(newTransitionRef, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransitionRef_set_ = transitionRef_set_;
      transitionRef_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSITION_REF, newTransitionRef, newTransitionRef, !oldTransitionRef_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransitionRef(ChangeContext changeContext)
  {
    TransitionRef oldTransitionRef = transitionRef;
    transitionRef = null;
    boolean oldTransitionRef_set_ = transitionRef_set_;
    transitionRef_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSITION_REF, oldTransitionRef, null, !oldTransitionRef_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransitionRef()
  {
    if (transitionRef != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transitionRef, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_REF, null, changeContext);
      changeContext = basicUnsetTransitionRef(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransitionRef_set_ = transitionRef_set_;
      transitionRef_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSITION_REF, null, null, oldTransitionRef_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransitionRef()
  {
    return transitionRef_set_;
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
  public String getFaultName()
  {
    return faultName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFaultName(String newFaultName)
  {
    String oldFaultName = faultName;
    faultName = newFaultName;
    boolean oldFaultName_set_ = faultName_set_;
    faultName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_FAULT_NAME, oldFaultName, faultName, !oldFaultName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFaultName()
  {
    String oldFaultName = faultName;
    boolean oldFaultName_set_ = faultName_set_;
    faultName = FAULT_NAME_DEFAULT_;
    faultName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_FAULT_NAME, oldFaultName, FAULT_NAME_DEFAULT_, oldFaultName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFaultName()
  {
    return faultName_set_;
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
      case MESSAGE:
        return basicUnsetMessage(changeContext);
      case BLOCK_ACTIVITY:
        return basicUnsetBlockActivity(changeContext);
      case TRANSITION_REF:
        return basicUnsetTransitionRef(changeContext);
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
      case MESSAGE:
        return getMessage();
      case BLOCK_ACTIVITY:
        return getBlockActivity();
      case TRANSITION_REF:
        return getTransitionRef();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case FAULT_NAME:
        return getFaultName();
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
      case MESSAGE:
        setMessage((MessageType)newValue);
        return;
      case BLOCK_ACTIVITY:
        setBlockActivity((BlockActivity)newValue);
        return;
      case TRANSITION_REF:
        setTransitionRef((TransitionRef)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case FAULT_NAME:
        setFaultName((String)newValue);
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
      case MESSAGE:
        unsetMessage();
        return;
      case BLOCK_ACTIVITY:
        unsetBlockActivity();
        return;
      case TRANSITION_REF:
        unsetTransitionRef();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case FAULT_NAME:
        unsetFaultName();
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
      case MESSAGE:
        return isSetMessage();
      case BLOCK_ACTIVITY:
        return isSetBlockActivity();
      case TRANSITION_REF:
        return isSetTransitionRef();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case FAULT_NAME:
        return isSetFaultName();
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
    result.append(", FaultName: ");
    if (faultName_set_) result.append(faultName); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //WebServiceFaultCatchImpl
