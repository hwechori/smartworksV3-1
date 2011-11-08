/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExternalReferenceImpl.java,v 1.1 2009/12/22 06:17:16 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ExternalReferenceImpl#getXref <em>Xref</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ExternalReferenceImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ExternalReferenceImpl#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalReferenceImpl extends DataObjectBase implements ExternalReference
{

  public final static int XREF = 0;

  public final static int LOCATION = 1;

  public final static int NAMESPACE = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Xref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XREF = 0;

  /**
   * The internal feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOCATION = 1;

  /**
   * The internal feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAMESPACE = 2;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 3;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_XREF: return XREF;
      case INTERNAL_LOCATION: return LOCATION;
      case INTERNAL_NAMESPACE: return NAMESPACE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getXref() <em>Xref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXref()
   * @generated
   * @ordered
   */
  protected static final String XREF_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getXref() <em>Xref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXref()
   * @generated
   * @ordered
   */
  protected String xref = XREF_DEFAULT_;

  /**
   * This is true if the Xref attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xref_set_ = false;

  /**
   * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected static final String LOCATION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected String location = LOCATION_DEFAULT_;

  /**
   * This is true if the Location attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean location_set_ = false;

  /**
   * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace()
   * @generated
   * @ordered
   */
  protected static final String NAMESPACE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace()
   * @generated
   * @ordered
   */
  protected String namespace = NAMESPACE_DEFAULT_;

  /**
   * This is true if the Namespace attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean namespace_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalReferenceImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getExternalReference();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getXref()
  {
    return xref;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXref(String newXref)
  {
    String oldXref = xref;
    xref = newXref;
    boolean oldXref_set_ = xref_set_;
    xref_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_XREF, oldXref, xref, !oldXref_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXref()
  {
    String oldXref = xref;
    boolean oldXref_set_ = xref_set_;
    xref = XREF_DEFAULT_;
    xref_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_XREF, oldXref, XREF_DEFAULT_, oldXref_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetXref()
  {
    return xref_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLocation()
  {
    return location;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocation(String newLocation)
  {
    String oldLocation = location;
    location = newLocation;
    boolean oldLocation_set_ = location_set_;
    location_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LOCATION, oldLocation, location, !oldLocation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLocation()
  {
    String oldLocation = location;
    boolean oldLocation_set_ = location_set_;
    location = LOCATION_DEFAULT_;
    location_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LOCATION, oldLocation, LOCATION_DEFAULT_, oldLocation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLocation()
  {
    return location_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNamespace()
  {
    return namespace;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamespace(String newNamespace)
  {
    String oldNamespace = namespace;
    namespace = newNamespace;
    boolean oldNamespace_set_ = namespace_set_;
    namespace_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAMESPACE, oldNamespace, namespace, !oldNamespace_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNamespace()
  {
    String oldNamespace = namespace;
    boolean oldNamespace_set_ = namespace_set_;
    namespace = NAMESPACE_DEFAULT_;
    namespace_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAMESPACE, oldNamespace, NAMESPACE_DEFAULT_, oldNamespace_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNamespace()
  {
    return namespace_set_;
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
      case XREF:
        return getXref();
      case LOCATION:
        return getLocation();
      case NAMESPACE:
        return getNamespace();
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
      case XREF:
        setXref((String)newValue);
        return;
      case LOCATION:
        setLocation((String)newValue);
        return;
      case NAMESPACE:
        setNamespace((String)newValue);
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
      case XREF:
        unsetXref();
        return;
      case LOCATION:
        unsetLocation();
        return;
      case NAMESPACE:
        unsetNamespace();
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
      case XREF:
        return isSetXref();
      case LOCATION:
        return isSetLocation();
      case NAMESPACE:
        return isSetNamespace();
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
    result.append(" (xref: ");
    if (xref_set_) result.append(xref); else result.append("<unset>");
    result.append(", location: ");
    if (location_set_) result.append(location); else result.append("<unset>");
    result.append(", namespace: ");
    if (namespace_set_) result.append(namespace); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ExternalReferenceImpl
