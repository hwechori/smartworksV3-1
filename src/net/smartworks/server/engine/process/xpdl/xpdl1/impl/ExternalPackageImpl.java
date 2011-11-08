/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExternalPackageImpl.java,v 1.1 2009/12/22 06:17:19 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackage;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ExternalPackageImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ExternalPackageImpl#getHref <em>Href</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalPackageImpl extends DataObjectBase implements ExternalPackage
{

  public final static int EXTENDED_ATTRIBUTES = 0;

  public final static int HREF = 1;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 0;

  /**
   * The internal feature id for the '<em><b>Href</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_HREF = 1;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 2;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_HREF: return HREF;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getExtendedAttributes() <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendedAttributes()
   * @generated
   * @ordered
   */
  
  protected ExtendedAttributes extendedAttributes = null;
  
  /**
   * This is true if the Extended Attributes containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extendedAttributes_set_ = false;

  /**
   * The default value of the '{@link #getHref() <em>Href</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHref()
   * @generated
   * @ordered
   */
  protected static final String HREF_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getHref() <em>Href</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHref()
   * @generated
   * @ordered
   */
  protected String href = HREF_DEFAULT_;

  /**
   * This is true if the Href attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean href_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalPackageImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getExternalPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedAttributes getExtendedAttributes()
  {
    return extendedAttributes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExtendedAttributes(ExtendedAttributes newExtendedAttributes, ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = newExtendedAttributes;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendedAttributes(ExtendedAttributes newExtendedAttributes)
  {
    if (newExtendedAttributes != extendedAttributes)
    {
      ChangeContext changeContext = null;
      if (extendedAttributes != null)
        changeContext = inverseRemove(extendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      if (newExtendedAttributes != null)
        changeContext = inverseAdd(newExtendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicSetExtendedAttributes(newExtendedAttributes, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, newExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExtendedAttributes(ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = null;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, null, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtendedAttributes()
  {
    if (extendedAttributes != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(extendedAttributes, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicUnsetExtendedAttributes(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, null, null, oldExtendedAttributes_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtendedAttributes()
  {
    return extendedAttributes_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getHref()
  {
    return href;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHref(String newHref)
  {
    String oldHref = href;
    href = newHref;
    boolean oldHref_set_ = href_set_;
    href_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_HREF, oldHref, href, !oldHref_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetHref()
  {
    String oldHref = href;
    boolean oldHref_set_ = href_set_;
    href = HREF_DEFAULT_;
    href_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_HREF, oldHref, HREF_DEFAULT_, oldHref_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetHref()
  {
    return href_set_;
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
      case EXTENDED_ATTRIBUTES:
        return basicUnsetExtendedAttributes(changeContext);
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
      case EXTENDED_ATTRIBUTES:
        return getExtendedAttributes();
      case HREF:
        return getHref();
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
      case EXTENDED_ATTRIBUTES:
        setExtendedAttributes((ExtendedAttributes)newValue);
        return;
      case HREF:
        setHref((String)newValue);
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
      case EXTENDED_ATTRIBUTES:
        unsetExtendedAttributes();
        return;
      case HREF:
        unsetHref();
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
      case EXTENDED_ATTRIBUTES:
        return isSetExtendedAttributes();
      case HREF:
        return isSetHref();
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
    result.append(" (href: ");
    if (href_set_) result.append(href); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ExternalPackageImpl
