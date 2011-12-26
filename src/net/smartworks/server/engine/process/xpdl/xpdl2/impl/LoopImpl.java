/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoopImpl.java,v 1.1 2009/12/22 06:17:57 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Loop;
import net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance;
import net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopImpl#getLoopStandard <em>Loop Standard</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopImpl#getLoopMultiInstance <em>Loop Multi Instance</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopImpl#getLoopType <em>Loop Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends DataObjectBase implements Loop
{

  public final static int LOOP_STANDARD = 0;

  public final static int LOOP_MULTI_INSTANCE = 1;

  public final static int LOOP_TYPE = 2;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Loop Standard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP_STANDARD = 0;

  /**
   * The internal feature id for the '<em><b>Loop Multi Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP_MULTI_INSTANCE = 1;

  /**
   * The internal feature id for the '<em><b>Loop Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP_TYPE = 2;

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
      case INTERNAL_LOOP_STANDARD: return LOOP_STANDARD;
      case INTERNAL_LOOP_MULTI_INSTANCE: return LOOP_MULTI_INSTANCE;
      case INTERNAL_LOOP_TYPE: return LOOP_TYPE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getLoopStandard() <em>Loop Standard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopStandard()
   * @generated
   * @ordered
   */
  
  protected LoopStandard loopStandard = null;
  
  /**
   * This is true if the Loop Standard containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loopStandard_set_ = false;

  /**
   * The cached value of the '{@link #getLoopMultiInstance() <em>Loop Multi Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopMultiInstance()
   * @generated
   * @ordered
   */
  
  protected LoopMultiInstance loopMultiInstance = null;
  
  /**
   * This is true if the Loop Multi Instance containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loopMultiInstance_set_ = false;

  /**
   * The default value of the '{@link #getLoopType() <em>Loop Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopType()
   * @generated
   * @ordered
   */
  protected static final String LOOP_TYPE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLoopType() <em>Loop Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopType()
   * @generated
   * @ordered
   */
  protected String loopType = LOOP_TYPE_DEFAULT_;

  /**
   * This is true if the Loop Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loopType_set_ = false;

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
  public LoopImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getLoop();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopStandard getLoopStandard()
  {
    return loopStandard;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLoopStandard(LoopStandard newLoopStandard, ChangeContext changeContext)
  {
    LoopStandard oldLoopStandard = loopStandard;
    loopStandard = newLoopStandard;
    boolean oldLoopStandard_set_ = loopStandard_set_;
    loopStandard_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LOOP_STANDARD, oldLoopStandard, newLoopStandard, !oldLoopStandard_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopStandard(LoopStandard newLoopStandard)
  {
    if (newLoopStandard != loopStandard)
    {
      ChangeContext changeContext = null;
      if (loopStandard != null)
        changeContext = inverseRemove(loopStandard, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOOP_STANDARD, null, changeContext);
      if (newLoopStandard != null)
        changeContext = inverseAdd(newLoopStandard, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOOP_STANDARD, null, changeContext);
      changeContext = basicSetLoopStandard(newLoopStandard, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLoopStandard_set_ = loopStandard_set_;
      loopStandard_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LOOP_STANDARD, newLoopStandard, newLoopStandard, !oldLoopStandard_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLoopStandard(ChangeContext changeContext)
  {
    LoopStandard oldLoopStandard = loopStandard;
    loopStandard = null;
    boolean oldLoopStandard_set_ = loopStandard_set_;
    loopStandard_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LOOP_STANDARD, oldLoopStandard, null, !oldLoopStandard_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLoopStandard()
  {
    if (loopStandard != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(loopStandard, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LOOP_STANDARD, null, changeContext);
      changeContext = basicUnsetLoopStandard(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLoopStandard_set_ = loopStandard_set_;
      loopStandard_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LOOP_STANDARD, null, null, oldLoopStandard_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLoopStandard()
  {
    return loopStandard_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopMultiInstance getLoopMultiInstance()
  {
    return loopMultiInstance;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLoopMultiInstance(LoopMultiInstance newLoopMultiInstance, ChangeContext changeContext)
  {
    LoopMultiInstance oldLoopMultiInstance = loopMultiInstance;
    loopMultiInstance = newLoopMultiInstance;
    boolean oldLoopMultiInstance_set_ = loopMultiInstance_set_;
    loopMultiInstance_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LOOP_MULTI_INSTANCE, oldLoopMultiInstance, newLoopMultiInstance, !oldLoopMultiInstance_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopMultiInstance(LoopMultiInstance newLoopMultiInstance)
  {
    if (newLoopMultiInstance != loopMultiInstance)
    {
      ChangeContext changeContext = null;
      if (loopMultiInstance != null)
        changeContext = inverseRemove(loopMultiInstance, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOOP_MULTI_INSTANCE, null, changeContext);
      if (newLoopMultiInstance != null)
        changeContext = inverseAdd(newLoopMultiInstance, this, OPPOSITE_FEATURE_BASE - INTERNAL_LOOP_MULTI_INSTANCE, null, changeContext);
      changeContext = basicSetLoopMultiInstance(newLoopMultiInstance, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLoopMultiInstance_set_ = loopMultiInstance_set_;
      loopMultiInstance_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LOOP_MULTI_INSTANCE, newLoopMultiInstance, newLoopMultiInstance, !oldLoopMultiInstance_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLoopMultiInstance(ChangeContext changeContext)
  {
    LoopMultiInstance oldLoopMultiInstance = loopMultiInstance;
    loopMultiInstance = null;
    boolean oldLoopMultiInstance_set_ = loopMultiInstance_set_;
    loopMultiInstance_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LOOP_MULTI_INSTANCE, oldLoopMultiInstance, null, !oldLoopMultiInstance_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLoopMultiInstance()
  {
    if (loopMultiInstance != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(loopMultiInstance, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LOOP_MULTI_INSTANCE, null, changeContext);
      changeContext = basicUnsetLoopMultiInstance(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLoopMultiInstance_set_ = loopMultiInstance_set_;
      loopMultiInstance_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LOOP_MULTI_INSTANCE, null, null, oldLoopMultiInstance_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLoopMultiInstance()
  {
    return loopMultiInstance_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLoopType()
  {
    return loopType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopType(String newLoopType)
  {
    String oldLoopType = loopType;
    loopType = newLoopType;
    boolean oldLoopType_set_ = loopType_set_;
    loopType_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LOOP_TYPE, oldLoopType, loopType, !oldLoopType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLoopType()
  {
    String oldLoopType = loopType;
    boolean oldLoopType_set_ = loopType_set_;
    loopType = LOOP_TYPE_DEFAULT_;
    loopType_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LOOP_TYPE, oldLoopType, LOOP_TYPE_DEFAULT_, oldLoopType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLoopType()
  {
    return loopType_set_;
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
      case LOOP_STANDARD:
        return basicUnsetLoopStandard(changeContext);
      case LOOP_MULTI_INSTANCE:
        return basicUnsetLoopMultiInstance(changeContext);
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
      case LOOP_STANDARD:
        return getLoopStandard();
      case LOOP_MULTI_INSTANCE:
        return getLoopMultiInstance();
      case LOOP_TYPE:
        return getLoopType();
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
      case LOOP_STANDARD:
        setLoopStandard((LoopStandard)newValue);
        return;
      case LOOP_MULTI_INSTANCE:
        setLoopMultiInstance((LoopMultiInstance)newValue);
        return;
      case LOOP_TYPE:
        setLoopType((String)newValue);
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
      case LOOP_STANDARD:
        unsetLoopStandard();
        return;
      case LOOP_MULTI_INSTANCE:
        unsetLoopMultiInstance();
        return;
      case LOOP_TYPE:
        unsetLoopType();
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
      case LOOP_STANDARD:
        return isSetLoopStandard();
      case LOOP_MULTI_INSTANCE:
        return isSetLoopMultiInstance();
      case LOOP_TYPE:
        return isSetLoopType();
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
    result.append(" (LoopType: ");
    if (loopType_set_) result.append(loopType); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //LoopImpl
