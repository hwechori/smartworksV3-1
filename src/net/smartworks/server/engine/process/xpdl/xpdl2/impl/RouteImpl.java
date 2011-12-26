/**
 * <copyright>
 * </copyright>
 *
 * $Id: RouteImpl.java,v 1.1 2009/12/22 06:17:25 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Route;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RouteImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RouteImpl#getGatewayType <em>Gateway Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RouteImpl#isInstantiate <em>Instantiate</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RouteImpl#isMarkerVisible <em>Marker Visible</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RouteImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouteImpl extends DataObjectBase implements Route
{

  public final static int ANY = -1;

  public final static int GATEWAY_TYPE = 0;

  public final static int INSTANTIATE = 1;

  public final static int MARKER_VISIBLE = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 0;

  /**
   * The internal feature id for the '<em><b>Gateway Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GATEWAY_TYPE = 1;

  /**
   * The internal feature id for the '<em><b>Instantiate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INSTANTIATE = 2;

  /**
   * The internal feature id for the '<em><b>Marker Visible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MARKER_VISIBLE = 3;

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
      case INTERNAL_ANY: return ANY;
      case INTERNAL_GATEWAY_TYPE: return GATEWAY_TYPE;
      case INTERNAL_INSTANTIATE: return INSTANTIATE;
      case INTERNAL_MARKER_VISIBLE: return MARKER_VISIBLE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * The default value of the '{@link #getGatewayType() <em>Gateway Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGatewayType()
   * @generated
   * @ordered
   */
  protected static final String GATEWAY_TYPE_DEFAULT_ = "XOR";

  /**
   * The cached value of the '{@link #getGatewayType() <em>Gateway Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGatewayType()
   * @generated
   * @ordered
   */
  protected String gatewayType = GATEWAY_TYPE_DEFAULT_;

  /**
   * This is true if the Gateway Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean gatewayType_set_ = false;

  /**
   * The default value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInstantiate()
   * @generated
   * @ordered
   */
  protected static final boolean INSTANTIATE_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInstantiate()
   * @generated
   * @ordered
   */
  protected boolean instantiate = INSTANTIATE_DEFAULT_;

  /**
   * This is true if the Instantiate attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean instantiate_set_ = false;

  /**
   * The default value of the '{@link #isMarkerVisible() <em>Marker Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMarkerVisible()
   * @generated
   * @ordered
   */
  protected static final boolean MARKER_VISIBLE_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isMarkerVisible() <em>Marker Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMarkerVisible()
   * @generated
   * @ordered
   */
  protected boolean markerVisible = MARKER_VISIBLE_DEFAULT_;

  /**
   * This is true if the Marker Visible attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean markerVisible_set_ = false;

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
  public RouteImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getRoute();
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
  public String getGatewayType()
  {
    return gatewayType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGatewayType(String newGatewayType)
  {
    String oldGatewayType = gatewayType;
    gatewayType = newGatewayType;
    boolean oldGatewayType_set_ = gatewayType_set_;
    gatewayType_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_GATEWAY_TYPE, oldGatewayType, gatewayType, !oldGatewayType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetGatewayType()
  {
    String oldGatewayType = gatewayType;
    boolean oldGatewayType_set_ = gatewayType_set_;
    gatewayType = GATEWAY_TYPE_DEFAULT_;
    gatewayType_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_GATEWAY_TYPE, oldGatewayType, GATEWAY_TYPE_DEFAULT_, oldGatewayType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetGatewayType()
  {
    return gatewayType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInstantiate()
  {
    return instantiate;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstantiate(boolean newInstantiate)
  {
    boolean oldInstantiate = instantiate;
    instantiate = newInstantiate;
    boolean oldInstantiate_set_ = instantiate_set_;
    instantiate_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_INSTANTIATE, oldInstantiate, instantiate, !oldInstantiate_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetInstantiate()
  {
    boolean oldInstantiate = instantiate;
    boolean oldInstantiate_set_ = instantiate_set_;
    instantiate = INSTANTIATE_DEFAULT_;
    instantiate_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_INSTANTIATE, oldInstantiate, INSTANTIATE_DEFAULT_, oldInstantiate_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetInstantiate()
  {
    return instantiate_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMarkerVisible()
  {
    return markerVisible;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMarkerVisible(boolean newMarkerVisible)
  {
    boolean oldMarkerVisible = markerVisible;
    markerVisible = newMarkerVisible;
    boolean oldMarkerVisible_set_ = markerVisible_set_;
    markerVisible_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_MARKER_VISIBLE, oldMarkerVisible, markerVisible, !oldMarkerVisible_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMarkerVisible()
  {
    boolean oldMarkerVisible = markerVisible;
    boolean oldMarkerVisible_set_ = markerVisible_set_;
    markerVisible = MARKER_VISIBLE_DEFAULT_;
    markerVisible_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_MARKER_VISIBLE, oldMarkerVisible, MARKER_VISIBLE_DEFAULT_, oldMarkerVisible_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMarkerVisible()
  {
    return markerVisible_set_;
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
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case GATEWAY_TYPE:
        return getGatewayType();
      case INSTANTIATE:
        return isInstantiate() ? Boolean.TRUE : Boolean.FALSE;
      case MARKER_VISIBLE:
        return isMarkerVisible() ? Boolean.TRUE : Boolean.FALSE;
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
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case GATEWAY_TYPE:
        setGatewayType((String)newValue);
        return;
      case INSTANTIATE:
        setInstantiate(((Boolean)newValue).booleanValue());
        return;
      case MARKER_VISIBLE:
        setMarkerVisible(((Boolean)newValue).booleanValue());
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
      case ANY:
        unsetSequence(getAny());
        return;
      case GATEWAY_TYPE:
        unsetGatewayType();
        return;
      case INSTANTIATE:
        unsetInstantiate();
        return;
      case MARKER_VISIBLE:
        unsetMarkerVisible();
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
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case GATEWAY_TYPE:
        return isSetGatewayType();
      case INSTANTIATE:
        return isSetInstantiate();
      case MARKER_VISIBLE:
        return isSetMarkerVisible();
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
    result.append(", GatewayType: ");
    if (gatewayType_set_) result.append(gatewayType); else result.append("<unset>");
    result.append(", Instantiate: ");
    if (instantiate_set_) result.append(instantiate); else result.append("<unset>");
    result.append(", MarkerVisible: ");
    if (markerVisible_set_) result.append(markerVisible); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //RouteImpl
