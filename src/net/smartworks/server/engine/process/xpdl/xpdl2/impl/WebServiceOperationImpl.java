/**
 * <copyright>
 * </copyright>
 *
 * $Id: WebServiceOperationImpl.java,v 1.1 2009/12/22 06:17:33 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Partner;
import net.smartworks.server.engine.process.xpdl.xpdl2.Service;
import net.smartworks.server.engine.process.xpdl.xpdl2.WebServiceOperation;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Service Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceOperationImpl#getPartner <em>Partner</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceOperationImpl#getService <em>Service</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceOperationImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceOperationImpl#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.WebServiceOperationImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebServiceOperationImpl extends DataObjectBase implements WebServiceOperation
{

  public final static int PARTNER = 0;

  public final static int SERVICE = 1;

  public final static int ANY = -1;

  public final static int OPERATION_NAME = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Partner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTNER = 0;

  /**
   * The internal feature id for the '<em><b>Service</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SERVICE = 1;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 2;

  /**
   * The internal feature id for the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OPERATION_NAME = 3;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 4;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 5;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_PARTNER: return PARTNER;
      case INTERNAL_SERVICE: return SERVICE;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_OPERATION_NAME: return OPERATION_NAME;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getPartner() <em>Partner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartner()
   * @generated
   * @ordered
   */
  
  protected Partner partner = null;
  
  /**
   * This is true if the Partner containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean partner_set_ = false;

  /**
   * The cached value of the '{@link #getService() <em>Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getService()
   * @generated
   * @ordered
   */
  
  protected Service service = null;
  
  /**
   * This is true if the Service containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean service_set_ = false;

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
   * The default value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationName()
   * @generated
   * @ordered
   */
  protected static final String OPERATION_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationName()
   * @generated
   * @ordered
   */
  protected String operationName = OPERATION_NAME_DEFAULT_;

  /**
   * This is true if the Operation Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean operationName_set_ = false;

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
  public WebServiceOperationImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getWebServiceOperation();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partner getPartner()
  {
    return partner;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPartner(Partner newPartner, ChangeContext changeContext)
  {
    Partner oldPartner = partner;
    partner = newPartner;
    boolean oldPartner_set_ = partner_set_;
    partner_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTNER, oldPartner, newPartner, !oldPartner_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartner(Partner newPartner)
  {
    if (newPartner != partner)
    {
      ChangeContext changeContext = null;
      if (partner != null)
        changeContext = inverseRemove(partner, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTNER, null, changeContext);
      if (newPartner != null)
        changeContext = inverseAdd(newPartner, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTNER, null, changeContext);
      changeContext = basicSetPartner(newPartner, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPartner_set_ = partner_set_;
      partner_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTNER, newPartner, newPartner, !oldPartner_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPartner(ChangeContext changeContext)
  {
    Partner oldPartner = partner;
    partner = null;
    boolean oldPartner_set_ = partner_set_;
    partner_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTNER, oldPartner, null, !oldPartner_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPartner()
  {
    if (partner != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(partner, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTNER, null, changeContext);
      changeContext = basicUnsetPartner(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPartner_set_ = partner_set_;
      partner_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTNER, null, null, oldPartner_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPartner()
  {
    return partner_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Service getService()
  {
    return service;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetService(Service newService, ChangeContext changeContext)
  {
    Service oldService = service;
    service = newService;
    boolean oldService_set_ = service_set_;
    service_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SERVICE, oldService, newService, !oldService_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setService(Service newService)
  {
    if (newService != service)
    {
      ChangeContext changeContext = null;
      if (service != null)
        changeContext = inverseRemove(service, this, OPPOSITE_FEATURE_BASE - INTERNAL_SERVICE, null, changeContext);
      if (newService != null)
        changeContext = inverseAdd(newService, this, OPPOSITE_FEATURE_BASE - INTERNAL_SERVICE, null, changeContext);
      changeContext = basicSetService(newService, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldService_set_ = service_set_;
      service_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SERVICE, newService, newService, !oldService_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetService(ChangeContext changeContext)
  {
    Service oldService = service;
    service = null;
    boolean oldService_set_ = service_set_;
    service_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SERVICE, oldService, null, !oldService_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetService()
  {
    if (service != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(service, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SERVICE, null, changeContext);
      changeContext = basicUnsetService(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldService_set_ = service_set_;
      service_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SERVICE, null, null, oldService_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetService()
  {
    return service_set_;
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
  public String getOperationName()
  {
    return operationName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationName(String newOperationName)
  {
    String oldOperationName = operationName;
    operationName = newOperationName;
    boolean oldOperationName_set_ = operationName_set_;
    operationName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_OPERATION_NAME, oldOperationName, operationName, !oldOperationName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOperationName()
  {
    String oldOperationName = operationName;
    boolean oldOperationName_set_ = operationName_set_;
    operationName = OPERATION_NAME_DEFAULT_;
    operationName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_OPERATION_NAME, oldOperationName, OPERATION_NAME_DEFAULT_, oldOperationName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOperationName()
  {
    return operationName_set_;
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
      case PARTNER:
        return basicUnsetPartner(changeContext);
      case SERVICE:
        return basicUnsetService(changeContext);
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
      case PARTNER:
        return getPartner();
      case SERVICE:
        return getService();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case OPERATION_NAME:
        return getOperationName();
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
      case PARTNER:
        setPartner((Partner)newValue);
        return;
      case SERVICE:
        setService((Service)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case OPERATION_NAME:
        setOperationName((String)newValue);
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
      case PARTNER:
        unsetPartner();
        return;
      case SERVICE:
        unsetService();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case OPERATION_NAME:
        unsetOperationName();
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
      case PARTNER:
        return isSetPartner();
      case SERVICE:
        return isSetService();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case OPERATION_NAME:
        return isSetOperationName();
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
    result.append(", OperationName: ");
    if (operationName_set_) result.append(operationName); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //WebServiceOperationImpl
