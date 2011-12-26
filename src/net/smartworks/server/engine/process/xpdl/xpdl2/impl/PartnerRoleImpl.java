/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartnerRoleImpl.java,v 1.1 2009/12/22 06:17:35 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.EndPoint;
import net.smartworks.server.engine.process.xpdl.xpdl2.PartnerRole;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partner Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerRoleImpl#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerRoleImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerRoleImpl#getRoleName <em>Role Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerRoleImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerRoleImpl#getPortName <em>Port Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerRoleImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartnerRoleImpl extends DataObjectBase implements PartnerRole
{

  public final static int END_POINT = 0;

  public final static int ANY = -1;

  public final static int ROLE_NAME = 1;

  public final static int SERVICE_NAME = 2;

  public final static int PORT_NAME = 3;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 4;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>End Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_END_POINT = 0;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 1;

  /**
   * The internal feature id for the '<em><b>Role Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ROLE_NAME = 2;

  /**
   * The internal feature id for the '<em><b>Service Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SERVICE_NAME = 3;

  /**
   * The internal feature id for the '<em><b>Port Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PORT_NAME = 4;

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
      case INTERNAL_END_POINT: return END_POINT;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ROLE_NAME: return ROLE_NAME;
      case INTERNAL_SERVICE_NAME: return SERVICE_NAME;
      case INTERNAL_PORT_NAME: return PORT_NAME;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getEndPoint() <em>End Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndPoint()
   * @generated
   * @ordered
   */
  
  protected EndPoint endPoint = null;
  
  /**
   * This is true if the End Point containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean endPoint_set_ = false;

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
   * The default value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleName()
   * @generated
   * @ordered
   */
  protected static final String ROLE_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleName()
   * @generated
   * @ordered
   */
  protected String roleName = ROLE_NAME_DEFAULT_;

  /**
   * This is true if the Role Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean roleName_set_ = false;

  /**
   * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceName()
   * @generated
   * @ordered
   */
  protected static final String SERVICE_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceName()
   * @generated
   * @ordered
   */
  protected String serviceName = SERVICE_NAME_DEFAULT_;

  /**
   * This is true if the Service Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean serviceName_set_ = false;

  /**
   * The default value of the '{@link #getPortName() <em>Port Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPortName()
   * @generated
   * @ordered
   */
  protected static final String PORT_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPortName() <em>Port Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPortName()
   * @generated
   * @ordered
   */
  protected String portName = PORT_NAME_DEFAULT_;

  /**
   * This is true if the Port Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean portName_set_ = false;

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
  public PartnerRoleImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getPartnerRole();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndPoint getEndPoint()
  {
    return endPoint;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetEndPoint(EndPoint newEndPoint, ChangeContext changeContext)
  {
    EndPoint oldEndPoint = endPoint;
    endPoint = newEndPoint;
    boolean oldEndPoint_set_ = endPoint_set_;
    endPoint_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_END_POINT, oldEndPoint, newEndPoint, !oldEndPoint_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndPoint(EndPoint newEndPoint)
  {
    if (newEndPoint != endPoint)
    {
      ChangeContext changeContext = null;
      if (endPoint != null)
        changeContext = inverseRemove(endPoint, this, OPPOSITE_FEATURE_BASE - INTERNAL_END_POINT, null, changeContext);
      if (newEndPoint != null)
        changeContext = inverseAdd(newEndPoint, this, OPPOSITE_FEATURE_BASE - INTERNAL_END_POINT, null, changeContext);
      changeContext = basicSetEndPoint(newEndPoint, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldEndPoint_set_ = endPoint_set_;
      endPoint_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_END_POINT, newEndPoint, newEndPoint, !oldEndPoint_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetEndPoint(ChangeContext changeContext)
  {
    EndPoint oldEndPoint = endPoint;
    endPoint = null;
    boolean oldEndPoint_set_ = endPoint_set_;
    endPoint_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_END_POINT, oldEndPoint, null, !oldEndPoint_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEndPoint()
  {
    if (endPoint != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(endPoint, this, EOPPOSITE_FEATURE_BASE - INTERNAL_END_POINT, null, changeContext);
      changeContext = basicUnsetEndPoint(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldEndPoint_set_ = endPoint_set_;
      endPoint_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_END_POINT, null, null, oldEndPoint_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEndPoint()
  {
    return endPoint_set_;
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
  public String getRoleName()
  {
    return roleName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoleName(String newRoleName)
  {
    String oldRoleName = roleName;
    roleName = newRoleName;
    boolean oldRoleName_set_ = roleName_set_;
    roleName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ROLE_NAME, oldRoleName, roleName, !oldRoleName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRoleName()
  {
    String oldRoleName = roleName;
    boolean oldRoleName_set_ = roleName_set_;
    roleName = ROLE_NAME_DEFAULT_;
    roleName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ROLE_NAME, oldRoleName, ROLE_NAME_DEFAULT_, oldRoleName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRoleName()
  {
    return roleName_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getServiceName()
  {
    return serviceName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setServiceName(String newServiceName)
  {
    String oldServiceName = serviceName;
    serviceName = newServiceName;
    boolean oldServiceName_set_ = serviceName_set_;
    serviceName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SERVICE_NAME, oldServiceName, serviceName, !oldServiceName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetServiceName()
  {
    String oldServiceName = serviceName;
    boolean oldServiceName_set_ = serviceName_set_;
    serviceName = SERVICE_NAME_DEFAULT_;
    serviceName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SERVICE_NAME, oldServiceName, SERVICE_NAME_DEFAULT_, oldServiceName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetServiceName()
  {
    return serviceName_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPortName()
  {
    return portName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPortName(String newPortName)
  {
    String oldPortName = portName;
    portName = newPortName;
    boolean oldPortName_set_ = portName_set_;
    portName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PORT_NAME, oldPortName, portName, !oldPortName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPortName()
  {
    String oldPortName = portName;
    boolean oldPortName_set_ = portName_set_;
    portName = PORT_NAME_DEFAULT_;
    portName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PORT_NAME, oldPortName, PORT_NAME_DEFAULT_, oldPortName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPortName()
  {
    return portName_set_;
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
      case END_POINT:
        return basicUnsetEndPoint(changeContext);
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
      case END_POINT:
        return getEndPoint();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ROLE_NAME:
        return getRoleName();
      case SERVICE_NAME:
        return getServiceName();
      case PORT_NAME:
        return getPortName();
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
      case END_POINT:
        setEndPoint((EndPoint)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case ROLE_NAME:
        setRoleName((String)newValue);
        return;
      case SERVICE_NAME:
        setServiceName((String)newValue);
        return;
      case PORT_NAME:
        setPortName((String)newValue);
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
      case END_POINT:
        unsetEndPoint();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case ROLE_NAME:
        unsetRoleName();
        return;
      case SERVICE_NAME:
        unsetServiceName();
        return;
      case PORT_NAME:
        unsetPortName();
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
      case END_POINT:
        return isSetEndPoint();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ROLE_NAME:
        return isSetRoleName();
      case SERVICE_NAME:
        return isSetServiceName();
      case PORT_NAME:
        return isSetPortName();
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
    result.append(", RoleName: ");
    if (roleName_set_) result.append(roleName); else result.append("<unset>");
    result.append(", ServiceName: ");
    if (serviceName_set_) result.append(serviceName); else result.append("<unset>");
    result.append(", PortName: ");
    if (portName_set_) result.append(portName); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //PartnerRoleImpl
