/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartnerLinkImpl.java,v 1.1 2009/12/22 06:17:33 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.MyRole;
import net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink;
import net.smartworks.server.engine.process.xpdl.xpdl2.PartnerRole;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partner Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerLinkImpl#getMyRole <em>My Role</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerLinkImpl#getPartnerRole <em>Partner Role</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerLinkImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerLinkImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerLinkImpl#getPartnerLinkTypeId <em>Partner Link Type Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PartnerLinkImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartnerLinkImpl extends DataObjectBase implements PartnerLink
{

  public final static int MY_ROLE = 0;

  public final static int PARTNER_ROLE = 1;

  public final static int ANY = -1;

  public final static int NAME = 2;

  public final static int ID = 3;

  public final static int PARTNER_LINK_TYPE_ID = 4;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 5;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>My Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MY_ROLE = 0;

  /**
   * The internal feature id for the '<em><b>Partner Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTNER_ROLE = 1;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 2;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 3;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 4;

  /**
   * The internal feature id for the '<em><b>Partner Link Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTNER_LINK_TYPE_ID = 5;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 6;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 7;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_MY_ROLE: return MY_ROLE;
      case INTERNAL_PARTNER_ROLE: return PARTNER_ROLE;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_ID: return ID;
      case INTERNAL_PARTNER_LINK_TYPE_ID: return PARTNER_LINK_TYPE_ID;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getMyRole() <em>My Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMyRole()
   * @generated
   * @ordered
   */
  
  protected MyRole myRole = null;
  
  /**
   * This is true if the My Role containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean myRole_set_ = false;

  /**
   * The cached value of the '{@link #getPartnerRole() <em>Partner Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartnerRole()
   * @generated
   * @ordered
   */
  
  protected PartnerRole partnerRole = null;
  
  /**
   * This is true if the Partner Role containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean partnerRole_set_ = false;

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
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_DEFAULT_;

  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean name_set_ = false;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_DEFAULT_;

  /**
   * This is true if the Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean id_set_ = false;

  /**
   * The default value of the '{@link #getPartnerLinkTypeId() <em>Partner Link Type Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartnerLinkTypeId()
   * @generated
   * @ordered
   */
  protected static final String PARTNER_LINK_TYPE_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPartnerLinkTypeId() <em>Partner Link Type Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartnerLinkTypeId()
   * @generated
   * @ordered
   */
  protected String partnerLinkTypeId = PARTNER_LINK_TYPE_ID_DEFAULT_;

  /**
   * This is true if the Partner Link Type Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean partnerLinkTypeId_set_ = false;

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
  public PartnerLinkImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getPartnerLink();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyRole getMyRole()
  {
    return myRole;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetMyRole(MyRole newMyRole, ChangeContext changeContext)
  {
    MyRole oldMyRole = myRole;
    myRole = newMyRole;
    boolean oldMyRole_set_ = myRole_set_;
    myRole_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_MY_ROLE, oldMyRole, newMyRole, !oldMyRole_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMyRole(MyRole newMyRole)
  {
    if (newMyRole != myRole)
    {
      ChangeContext changeContext = null;
      if (myRole != null)
        changeContext = inverseRemove(myRole, this, OPPOSITE_FEATURE_BASE - INTERNAL_MY_ROLE, null, changeContext);
      if (newMyRole != null)
        changeContext = inverseAdd(newMyRole, this, OPPOSITE_FEATURE_BASE - INTERNAL_MY_ROLE, null, changeContext);
      changeContext = basicSetMyRole(newMyRole, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldMyRole_set_ = myRole_set_;
      myRole_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_MY_ROLE, newMyRole, newMyRole, !oldMyRole_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetMyRole(ChangeContext changeContext)
  {
    MyRole oldMyRole = myRole;
    myRole = null;
    boolean oldMyRole_set_ = myRole_set_;
    myRole_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_MY_ROLE, oldMyRole, null, !oldMyRole_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMyRole()
  {
    if (myRole != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(myRole, this, EOPPOSITE_FEATURE_BASE - INTERNAL_MY_ROLE, null, changeContext);
      changeContext = basicUnsetMyRole(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldMyRole_set_ = myRole_set_;
      myRole_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_MY_ROLE, null, null, oldMyRole_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMyRole()
  {
    return myRole_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartnerRole getPartnerRole()
  {
    return partnerRole;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPartnerRole(PartnerRole newPartnerRole, ChangeContext changeContext)
  {
    PartnerRole oldPartnerRole = partnerRole;
    partnerRole = newPartnerRole;
    boolean oldPartnerRole_set_ = partnerRole_set_;
    partnerRole_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTNER_ROLE, oldPartnerRole, newPartnerRole, !oldPartnerRole_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartnerRole(PartnerRole newPartnerRole)
  {
    if (newPartnerRole != partnerRole)
    {
      ChangeContext changeContext = null;
      if (partnerRole != null)
        changeContext = inverseRemove(partnerRole, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTNER_ROLE, null, changeContext);
      if (newPartnerRole != null)
        changeContext = inverseAdd(newPartnerRole, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTNER_ROLE, null, changeContext);
      changeContext = basicSetPartnerRole(newPartnerRole, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPartnerRole_set_ = partnerRole_set_;
      partnerRole_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTNER_ROLE, newPartnerRole, newPartnerRole, !oldPartnerRole_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPartnerRole(ChangeContext changeContext)
  {
    PartnerRole oldPartnerRole = partnerRole;
    partnerRole = null;
    boolean oldPartnerRole_set_ = partnerRole_set_;
    partnerRole_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTNER_ROLE, oldPartnerRole, null, !oldPartnerRole_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPartnerRole()
  {
    if (partnerRole != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(partnerRole, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTNER_ROLE, null, changeContext);
      changeContext = basicUnsetPartnerRole(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPartnerRole_set_ = partnerRole_set_;
      partnerRole_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTNER_ROLE, null, null, oldPartnerRole_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPartnerRole()
  {
    return partnerRole_set_;
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
  public String getName()
  {
    return name;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    boolean oldName_set_ = name_set_;
    name_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAME, oldName, name, !oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetName()
  {
    String oldName = name;
    boolean oldName_set_ = name_set_;
    name = NAME_DEFAULT_;
    name_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAME, oldName, NAME_DEFAULT_, oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetName()
  {
    return name_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    boolean oldId_set_ = id_set_;
    id_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ID, oldId, id, !oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetId()
  {
    String oldId = id;
    boolean oldId_set_ = id_set_;
    id = ID_DEFAULT_;
    id_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ID, oldId, ID_DEFAULT_, oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetId()
  {
    return id_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPartnerLinkTypeId()
  {
    return partnerLinkTypeId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartnerLinkTypeId(String newPartnerLinkTypeId)
  {
    String oldPartnerLinkTypeId = partnerLinkTypeId;
    partnerLinkTypeId = newPartnerLinkTypeId;
    boolean oldPartnerLinkTypeId_set_ = partnerLinkTypeId_set_;
    partnerLinkTypeId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PARTNER_LINK_TYPE_ID, oldPartnerLinkTypeId, partnerLinkTypeId, !oldPartnerLinkTypeId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPartnerLinkTypeId()
  {
    String oldPartnerLinkTypeId = partnerLinkTypeId;
    boolean oldPartnerLinkTypeId_set_ = partnerLinkTypeId_set_;
    partnerLinkTypeId = PARTNER_LINK_TYPE_ID_DEFAULT_;
    partnerLinkTypeId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PARTNER_LINK_TYPE_ID, oldPartnerLinkTypeId, PARTNER_LINK_TYPE_ID_DEFAULT_, oldPartnerLinkTypeId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPartnerLinkTypeId()
  {
    return partnerLinkTypeId_set_;
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
      case MY_ROLE:
        return basicUnsetMyRole(changeContext);
      case PARTNER_ROLE:
        return basicUnsetPartnerRole(changeContext);
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
      case MY_ROLE:
        return getMyRole();
      case PARTNER_ROLE:
        return getPartnerRole();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case NAME:
        return getName();
      case ID:
        return getId();
      case PARTNER_LINK_TYPE_ID:
        return getPartnerLinkTypeId();
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
      case MY_ROLE:
        setMyRole((MyRole)newValue);
        return;
      case PARTNER_ROLE:
        setPartnerRole((PartnerRole)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case NAME:
        setName((String)newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case PARTNER_LINK_TYPE_ID:
        setPartnerLinkTypeId((String)newValue);
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
      case MY_ROLE:
        unsetMyRole();
        return;
      case PARTNER_ROLE:
        unsetPartnerRole();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case NAME:
        unsetName();
        return;
      case ID:
        unsetId();
        return;
      case PARTNER_LINK_TYPE_ID:
        unsetPartnerLinkTypeId();
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
      case MY_ROLE:
        return isSetMyRole();
      case PARTNER_ROLE:
        return isSetPartnerRole();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case NAME:
        return isSetName();
      case ID:
        return isSetId();
      case PARTNER_LINK_TYPE_ID:
        return isSetPartnerLinkTypeId();
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
    result.append(", name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", PartnerLinkTypeId: ");
    if (partnerLinkTypeId_set_) result.append(partnerLinkTypeId); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //PartnerLinkImpl
