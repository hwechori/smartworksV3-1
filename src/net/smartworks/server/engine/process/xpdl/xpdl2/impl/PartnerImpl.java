/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartnerImpl.java,v 1.1 2009/12/22 06:17:40 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Partner;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerImpl#getPartnerLinkId <em>Partner Link Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerImpl#getRoleType <em>Role Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartnerImpl extends DataObjectBase implements Partner
{

  public final static int ANY = -1;

  public final static int PARTNER_LINK_ID = 0;

  public final static int ROLE_TYPE = 1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 2;

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
   * The internal feature id for the '<em><b>Partner Link Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTNER_LINK_ID = 1;

  /**
   * The internal feature id for the '<em><b>Role Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ROLE_TYPE = 2;

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
      case INTERNAL_ANY: return ANY;
      case INTERNAL_PARTNER_LINK_ID: return PARTNER_LINK_ID;
      case INTERNAL_ROLE_TYPE: return ROLE_TYPE;
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
   * The default value of the '{@link #getPartnerLinkId() <em>Partner Link Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartnerLinkId()
   * @generated
   * @ordered
   */
  protected static final String PARTNER_LINK_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPartnerLinkId() <em>Partner Link Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartnerLinkId()
   * @generated
   * @ordered
   */
  protected String partnerLinkId = PARTNER_LINK_ID_DEFAULT_;

  /**
   * This is true if the Partner Link Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean partnerLinkId_set_ = false;

  /**
   * The default value of the '{@link #getRoleType() <em>Role Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleType()
   * @generated
   * @ordered
   */
  protected static final String ROLE_TYPE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getRoleType() <em>Role Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleType()
   * @generated
   * @ordered
   */
  protected String roleType = ROLE_TYPE_DEFAULT_;

  /**
   * This is true if the Role Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean roleType_set_ = false;

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
  public PartnerImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getPartner();
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
  public String getPartnerLinkId()
  {
    return partnerLinkId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartnerLinkId(String newPartnerLinkId)
  {
    String oldPartnerLinkId = partnerLinkId;
    partnerLinkId = newPartnerLinkId;
    boolean oldPartnerLinkId_set_ = partnerLinkId_set_;
    partnerLinkId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PARTNER_LINK_ID, oldPartnerLinkId, partnerLinkId, !oldPartnerLinkId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPartnerLinkId()
  {
    String oldPartnerLinkId = partnerLinkId;
    boolean oldPartnerLinkId_set_ = partnerLinkId_set_;
    partnerLinkId = PARTNER_LINK_ID_DEFAULT_;
    partnerLinkId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PARTNER_LINK_ID, oldPartnerLinkId, PARTNER_LINK_ID_DEFAULT_, oldPartnerLinkId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPartnerLinkId()
  {
    return partnerLinkId_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRoleType()
  {
    return roleType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoleType(String newRoleType)
  {
    String oldRoleType = roleType;
    roleType = newRoleType;
    boolean oldRoleType_set_ = roleType_set_;
    roleType_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ROLE_TYPE, oldRoleType, roleType, !oldRoleType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRoleType()
  {
    String oldRoleType = roleType;
    boolean oldRoleType_set_ = roleType_set_;
    roleType = ROLE_TYPE_DEFAULT_;
    roleType_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ROLE_TYPE, oldRoleType, ROLE_TYPE_DEFAULT_, oldRoleType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRoleType()
  {
    return roleType_set_;
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
      case PARTNER_LINK_ID:
        return getPartnerLinkId();
      case ROLE_TYPE:
        return getRoleType();
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
      case PARTNER_LINK_ID:
        setPartnerLinkId((String)newValue);
        return;
      case ROLE_TYPE:
        setRoleType((String)newValue);
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
      case PARTNER_LINK_ID:
        unsetPartnerLinkId();
        return;
      case ROLE_TYPE:
        unsetRoleType();
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
      case PARTNER_LINK_ID:
        return isSetPartnerLinkId();
      case ROLE_TYPE:
        return isSetRoleType();
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
    result.append(", PartnerLinkId: ");
    if (partnerLinkId_set_) result.append(partnerLinkId); else result.append("<unset>");
    result.append(", RoleType: ");
    if (roleType_set_) result.append(roleType); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //PartnerImpl
