/**
 * <copyright>
 * </copyright>
 *
 * $Id: WebServiceImpl.java,v 1.1 2009/12/22 06:17:47 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.WebService;
import net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceFaultCatch;
import net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceImpl#getWebServiceOperation <em>Web Service Operation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceImpl#getWebServiceFaultCatch <em>Web Service Fault Catch</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceImpl#getInputMsgName <em>Input Msg Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceImpl#getOutputMsgName <em>Output Msg Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebServiceImpl extends DataObjectBase implements WebService
{

  public final static int WEB_SERVICE_OPERATION = 0;

  public final static int WEB_SERVICE_FAULT_CATCH = 1;

  public final static int ANY = -1;

  public final static int INPUT_MSG_NAME = 2;

  public final static int OUTPUT_MSG_NAME = 3;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 4;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Web Service Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WEB_SERVICE_OPERATION = 0;

  /**
   * The internal feature id for the '<em><b>Web Service Fault Catch</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WEB_SERVICE_FAULT_CATCH = 1;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 2;

  /**
   * The internal feature id for the '<em><b>Input Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INPUT_MSG_NAME = 3;

  /**
   * The internal feature id for the '<em><b>Output Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OUTPUT_MSG_NAME = 4;

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
      case INTERNAL_WEB_SERVICE_OPERATION: return WEB_SERVICE_OPERATION;
      case INTERNAL_WEB_SERVICE_FAULT_CATCH: return WEB_SERVICE_FAULT_CATCH;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_INPUT_MSG_NAME: return INPUT_MSG_NAME;
      case INTERNAL_OUTPUT_MSG_NAME: return OUTPUT_MSG_NAME;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * The default value of the '{@link #getInputMsgName() <em>Input Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputMsgName()
   * @generated
   * @ordered
   */
  protected static final String INPUT_MSG_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getInputMsgName() <em>Input Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputMsgName()
   * @generated
   * @ordered
   */
  protected String inputMsgName = INPUT_MSG_NAME_DEFAULT_;

  /**
   * This is true if the Input Msg Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean inputMsgName_set_ = false;

  /**
   * The default value of the '{@link #getOutputMsgName() <em>Output Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputMsgName()
   * @generated
   * @ordered
   */
  protected static final String OUTPUT_MSG_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getOutputMsgName() <em>Output Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputMsgName()
   * @generated
   * @ordered
   */
  protected String outputMsgName = OUTPUT_MSG_NAME_DEFAULT_;

  /**
   * This is true if the Output Msg Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean outputMsgName_set_ = false;

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
  public WebServiceImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getWebService();
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
  public String getInputMsgName()
  {
    return inputMsgName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInputMsgName(String newInputMsgName)
  {
    String oldInputMsgName = inputMsgName;
    inputMsgName = newInputMsgName;
    boolean oldInputMsgName_set_ = inputMsgName_set_;
    inputMsgName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_INPUT_MSG_NAME, oldInputMsgName, inputMsgName, !oldInputMsgName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetInputMsgName()
  {
    String oldInputMsgName = inputMsgName;
    boolean oldInputMsgName_set_ = inputMsgName_set_;
    inputMsgName = INPUT_MSG_NAME_DEFAULT_;
    inputMsgName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_INPUT_MSG_NAME, oldInputMsgName, INPUT_MSG_NAME_DEFAULT_, oldInputMsgName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetInputMsgName()
  {
    return inputMsgName_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOutputMsgName()
  {
    return outputMsgName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutputMsgName(String newOutputMsgName)
  {
    String oldOutputMsgName = outputMsgName;
    outputMsgName = newOutputMsgName;
    boolean oldOutputMsgName_set_ = outputMsgName_set_;
    outputMsgName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_OUTPUT_MSG_NAME, oldOutputMsgName, outputMsgName, !oldOutputMsgName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOutputMsgName()
  {
    String oldOutputMsgName = outputMsgName;
    boolean oldOutputMsgName_set_ = outputMsgName_set_;
    outputMsgName = OUTPUT_MSG_NAME_DEFAULT_;
    outputMsgName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_OUTPUT_MSG_NAME, oldOutputMsgName, OUTPUT_MSG_NAME_DEFAULT_, oldOutputMsgName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOutputMsgName()
  {
    return outputMsgName_set_;
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
      case WEB_SERVICE_OPERATION:
        return getWebServiceOperation();
      case WEB_SERVICE_FAULT_CATCH:
        return getWebServiceFaultCatch();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case INPUT_MSG_NAME:
        return getInputMsgName();
      case OUTPUT_MSG_NAME:
        return getOutputMsgName();
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
      case INPUT_MSG_NAME:
        setInputMsgName((String)newValue);
        return;
      case OUTPUT_MSG_NAME:
        setOutputMsgName((String)newValue);
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
      case WEB_SERVICE_OPERATION:
        unsetWebServiceOperation();
        return;
      case WEB_SERVICE_FAULT_CATCH:
        getWebServiceFaultCatch().clear();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case INPUT_MSG_NAME:
        unsetInputMsgName();
        return;
      case OUTPUT_MSG_NAME:
        unsetOutputMsgName();
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
      case WEB_SERVICE_OPERATION:
        return isSetWebServiceOperation();
      case WEB_SERVICE_FAULT_CATCH:
        return webServiceFaultCatch != null && !webServiceFaultCatch.isEmpty();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case INPUT_MSG_NAME:
        return isSetInputMsgName();
      case OUTPUT_MSG_NAME:
        return isSetOutputMsgName();
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
    result.append(", InputMsgName: ");
    if (inputMsgName_set_) result.append(inputMsgName); else result.append("<unset>");
    result.append(", OutputMsgName: ");
    if (outputMsgName_set_) result.append(outputMsgName); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //WebServiceImpl
