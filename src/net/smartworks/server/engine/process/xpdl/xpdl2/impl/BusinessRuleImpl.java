/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessRuleImpl.java,v 1.1 2009/12/22 06:17:51 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule;
import net.smartworks.server.engine.process.xpdl.xpdl2.Location;
import net.smartworks.server.engine.process.xpdl.xpdl2.RuleName;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BusinessRuleImpl#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BusinessRuleImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BusinessRuleImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BusinessRuleImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessRuleImpl extends DataObjectBase implements BusinessRule
{

  public final static int RULE_NAME = 0;

  public final static int LOCATION = 1;

  public final static int ANY = -1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Rule Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_RULE_NAME = 0;

  /**
   * The internal feature id for the '<em><b>Location</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOCATION = 1;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 2;

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
      case INTERNAL_RULE_NAME: return RULE_NAME;
      case INTERNAL_LOCATION: return LOCATION;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getRuleName() <em>Rule Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuleName()
   * @generated
   * @ordered
   */
  
  protected RuleName ruleName = null;
  
  /**
   * This is true if the Rule Name containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean ruleName_set_ = false;

  /**
   * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  
  protected Location location = null;
  
  /**
   * This is true if the Location containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean location_set_ = false;

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
  public BusinessRuleImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getBusinessRule();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleName getRuleName()
  {
    return ruleName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetRuleName(RuleName newRuleName, ChangeContext changeContext)
  {
    RuleName oldRuleName = ruleName;
    ruleName = newRuleName;
    boolean oldRuleName_set_ = ruleName_set_;
    ruleName_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_RULE_NAME, oldRuleName, newRuleName, !oldRuleName_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRuleName(RuleName newRuleName)
  {
    if (newRuleName != ruleName)
    {
      ChangeContext changeContext = null;
      if (ruleName != null)
        changeContext = inverseRemove(ruleName, this, OPPOSITE_FEATURE_BASE - INTERNAL_RULE_NAME, null, changeContext);
      if (newRuleName != null)
        changeContext = inverseAdd(newRuleName, this, OPPOSITE_FEATURE_BASE - INTERNAL_RULE_NAME, null, changeContext);
      changeContext = basicSetRuleName(newRuleName, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldRuleName_set_ = ruleName_set_;
      ruleName_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_RULE_NAME, newRuleName, newRuleName, !oldRuleName_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetRuleName(ChangeContext changeContext)
  {
    RuleName oldRuleName = ruleName;
    ruleName = null;
    boolean oldRuleName_set_ = ruleName_set_;
    ruleName_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_RULE_NAME, oldRuleName, null, !oldRuleName_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRuleName()
  {
    if (ruleName != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(ruleName, this, EOPPOSITE_FEATURE_BASE - INTERNAL_RULE_NAME, null, changeContext);
      changeContext = basicUnsetRuleName(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldRuleName_set_ = ruleName_set_;
      ruleName_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_RULE_NAME, null, null, oldRuleName_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRuleName()
  {
    return ruleName_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Location getLocation()
  {
    return location;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLocation(Location newLocation, ChangeContext changeContext)
  {
    Location oldLocation = location;
    location = newLocation;
    boolean oldLocation_set_ = location_set_;
    location_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LOCATION, oldLocation, newLocation, !oldLocation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocation(Location newLocation)
  {
    if (newLocation != location)
    {
      ChangeContext changeContext = null;
      if (location != null)
        changeContext = inverseRemove(location, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOCATION, null, changeContext);
      if (newLocation != null)
        changeContext = inverseAdd(newLocation, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOCATION, null, changeContext);
      changeContext = basicSetLocation(newLocation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLocation_set_ = location_set_;
      location_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LOCATION, newLocation, newLocation, !oldLocation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLocation(ChangeContext changeContext)
  {
    Location oldLocation = location;
    location = null;
    boolean oldLocation_set_ = location_set_;
    location_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LOCATION, oldLocation, null, !oldLocation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLocation()
  {
    if (location != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(location, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LOCATION, null, changeContext);
      changeContext = basicUnsetLocation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLocation_set_ = location_set_;
      location_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LOCATION, null, null, oldLocation_set_);
    	}
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
      case RULE_NAME:
        return basicUnsetRuleName(changeContext);
      case LOCATION:
        return basicUnsetLocation(changeContext);
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
      case RULE_NAME:
        return getRuleName();
      case LOCATION:
        return getLocation();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
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
      case RULE_NAME:
        setRuleName((RuleName)newValue);
        return;
      case LOCATION:
        setLocation((Location)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
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
      case RULE_NAME:
        unsetRuleName();
        return;
      case LOCATION:
        unsetLocation();
        return;
      case ANY:
        unsetSequence(getAny());
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
      case RULE_NAME:
        return isSetRuleName();
      case LOCATION:
        return isSetLocation();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
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
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //BusinessRuleImpl
