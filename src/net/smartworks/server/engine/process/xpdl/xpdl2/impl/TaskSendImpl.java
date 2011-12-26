/**
 * <copyright>
 * </copyright>
 *
 * $Id: TaskSendImpl.java,v 1.1 2009/12/22 06:17:25 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import java.util.Collection;
import java.util.List;

import net.smartworks.server.engine.process.xpdl.xpdl2.MessageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend;
import net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch;
import net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Send</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskSendImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskSendImpl#getWebServiceOperation <em>Web Service Operation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskSendImpl#getWebServiceFaultCatch <em>Web Service Fault Catch</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskSendImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskSendImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskSendImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskSendImpl extends DataObjectBase implements TaskSend
{

  public final static int MESSAGE = 0;

  public final static int WEB_SERVICE_OPERATION = 1;

  public final static int WEB_SERVICE_FAULT_CATCH = 2;

  public final static int ANY = -1;

  public final static int IMPLEMENTATION = 3;

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
   * The internal feature id for the '<em><b>Web Service Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WEB_SERVICE_OPERATION = 1;

  /**
   * The internal feature id for the '<em><b>Web Service Fault Catch</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WEB_SERVICE_FAULT_CATCH = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

  /**
   * The internal feature id for the '<em><b>Implementation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IMPLEMENTATION = 4;

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
      case INTERNAL_WEB_SERVICE_OPERATION: return WEB_SERVICE_OPERATION;
      case INTERNAL_WEB_SERVICE_FAULT_CATCH: return WEB_SERVICE_FAULT_CATCH;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_IMPLEMENTATION: return IMPLEMENTATION;
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
   * The cached value of the '{@link #getWebServiceOperation() <em>Web Service Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWebServiceOperation()
   * @generated
   * @ordered
   */
  
  protected WebServiceOperation webServiceOperation = null;
  
  /**
   * This is true if the Web Service Operation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean webServiceOperation_set_ = false;

  /**
   * The cached value of the '{@link #getWebServiceFaultCatch() <em>Web Service Fault Catch</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWebServiceFaultCatch()
   * @generated
   * @ordered
   */
  
  protected List webServiceFaultCatch = null;
  
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
  public TaskSendImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getTaskSend();
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
  public WebServiceOperation getWebServiceOperation()
  {
    return webServiceOperation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetWebServiceOperation(WebServiceOperation newWebServiceOperation, ChangeContext changeContext)
  {
    WebServiceOperation oldWebServiceOperation = webServiceOperation;
    webServiceOperation = newWebServiceOperation;
    boolean oldWebServiceOperation_set_ = webServiceOperation_set_;
    webServiceOperation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_WEB_SERVICE_OPERATION, oldWebServiceOperation, newWebServiceOperation, !oldWebServiceOperation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWebServiceOperation(WebServiceOperation newWebServiceOperation)
  {
    if (newWebServiceOperation != webServiceOperation)
    {
      ChangeContext changeContext = null;
      if (webServiceOperation != null)
        changeContext = inverseRemove(webServiceOperation, this, OPPOSITE_FEATURE_BASE - INTERNAL_WEB_SERVICE_OPERATION, null, changeContext);
      if (newWebServiceOperation != null)
        changeContext = inverseAdd(newWebServiceOperation, this, OPPOSITE_FEATURE_BASE - INTERNAL_WEB_SERVICE_OPERATION, null, changeContext);
      changeContext = basicSetWebServiceOperation(newWebServiceOperation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldWebServiceOperation_set_ = webServiceOperation_set_;
      webServiceOperation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_WEB_SERVICE_OPERATION, newWebServiceOperation, newWebServiceOperation, !oldWebServiceOperation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetWebServiceOperation(ChangeContext changeContext)
  {
    WebServiceOperation oldWebServiceOperation = webServiceOperation;
    webServiceOperation = null;
    boolean oldWebServiceOperation_set_ = webServiceOperation_set_;
    webServiceOperation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_WEB_SERVICE_OPERATION, oldWebServiceOperation, null, !oldWebServiceOperation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWebServiceOperation()
  {
    if (webServiceOperation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(webServiceOperation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_WEB_SERVICE_OPERATION, null, changeContext);
      changeContext = basicUnsetWebServiceOperation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldWebServiceOperation_set_ = webServiceOperation_set_;
      webServiceOperation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_WEB_SERVICE_OPERATION, null, null, oldWebServiceOperation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetWebServiceOperation()
  {
    return webServiceOperation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getWebServiceFaultCatch()
  {
    if (webServiceFaultCatch == null)
    {
      webServiceFaultCatch = createPropertyList(ListKind.CONTAINMENT, WebServiceFaultCatch.class, WEB_SERVICE_FAULT_CATCH, 0);
    }
    return webServiceFaultCatch;
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
      case MESSAGE:
        return basicUnsetMessage(changeContext);
      case WEB_SERVICE_OPERATION:
        return basicUnsetWebServiceOperation(changeContext);
      case WEB_SERVICE_FAULT_CATCH:
        return removeFromList(getWebServiceFaultCatch(), otherEnd, changeContext);
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
      case WEB_SERVICE_OPERATION:
        return getWebServiceOperation();
      case WEB_SERVICE_FAULT_CATCH:
        return getWebServiceFaultCatch();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
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
      case MESSAGE:
        setMessage((MessageType)newValue);
        return;
      case WEB_SERVICE_OPERATION:
        setWebServiceOperation((WebServiceOperation)newValue);
        return;
      case WEB_SERVICE_FAULT_CATCH:
        getWebServiceFaultCatch().clear();
        getWebServiceFaultCatch().addAll((Collection)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
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
      case MESSAGE:
        unsetMessage();
        return;
      case WEB_SERVICE_OPERATION:
        unsetWebServiceOperation();
        return;
      case WEB_SERVICE_FAULT_CATCH:
        getWebServiceFaultCatch().clear();
        return;
      case ANY:
        unsetSequence(getAny());
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
      case MESSAGE:
        return isSetMessage();
      case WEB_SERVICE_OPERATION:
        return isSetWebServiceOperation();
      case WEB_SERVICE_FAULT_CATCH:
        return webServiceFaultCatch != null && !webServiceFaultCatch.isEmpty();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
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
    result.append(" (any: ");
    result.append(any);
    result.append(", Implementation: ");
    if (implementation_set_) result.append(implementation); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //TaskSendImpl
