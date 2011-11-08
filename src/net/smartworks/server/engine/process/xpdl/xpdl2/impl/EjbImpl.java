/**
 * <copyright>
 * </copyright>
 *
 * $Id: EjbImpl.java,v 1.1 2009/12/22 06:17:34 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Ejb;
import net.smartworks.server.engine.process.xpdl.xpdl2.HomeClass;
import net.smartworks.server.engine.process.xpdl.xpdl2.JndiName;
import net.smartworks.server.engine.process.xpdl.xpdl2.Method1;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ejb</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EjbImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EjbImpl#getHomeClass <em>Home Class</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EjbImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EjbImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.EjbImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EjbImpl extends DataObjectBase implements Ejb
{

  public final static int JNDI_NAME = 0;

  public final static int HOME_CLASS = 1;

  public final static int METHOD = 2;

  public final static int ANY = -1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Jndi Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_JNDI_NAME = 0;

  /**
   * The internal feature id for the '<em><b>Home Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_HOME_CLASS = 1;

  /**
   * The internal feature id for the '<em><b>Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_METHOD = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

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
      case INTERNAL_JNDI_NAME: return JNDI_NAME;
      case INTERNAL_HOME_CLASS: return HOME_CLASS;
      case INTERNAL_METHOD: return METHOD;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJndiName()
   * @generated
   * @ordered
   */
  
  protected JndiName jndiName = null;
  
  /**
   * This is true if the Jndi Name containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean jndiName_set_ = false;

  /**
   * The cached value of the '{@link #getHomeClass() <em>Home Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHomeClass()
   * @generated
   * @ordered
   */
  
  protected HomeClass homeClass = null;
  
  /**
   * This is true if the Home Class containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean homeClass_set_ = false;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  
  protected Method1 method = null;
  
  /**
   * This is true if the Method containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean method_set_ = false;

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
  public EjbImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getEjb();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JndiName getJndiName()
  {
    return jndiName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetJndiName(JndiName newJndiName, ChangeContext changeContext)
  {
    JndiName oldJndiName = jndiName;
    jndiName = newJndiName;
    boolean oldJndiName_set_ = jndiName_set_;
    jndiName_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_JNDI_NAME, oldJndiName, newJndiName, !oldJndiName_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJndiName(JndiName newJndiName)
  {
    if (newJndiName != jndiName)
    {
      ChangeContext changeContext = null;
      if (jndiName != null)
        changeContext = inverseRemove(jndiName, this, OPPOSITE_FEATURE_BASE - INTERNAL_JNDI_NAME, null, changeContext);
      if (newJndiName != null)
        changeContext = inverseAdd(newJndiName, this, OPPOSITE_FEATURE_BASE - INTERNAL_JNDI_NAME, null, changeContext);
      changeContext = basicSetJndiName(newJndiName, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldJndiName_set_ = jndiName_set_;
      jndiName_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_JNDI_NAME, newJndiName, newJndiName, !oldJndiName_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetJndiName(ChangeContext changeContext)
  {
    JndiName oldJndiName = jndiName;
    jndiName = null;
    boolean oldJndiName_set_ = jndiName_set_;
    jndiName_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_JNDI_NAME, oldJndiName, null, !oldJndiName_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetJndiName()
  {
    if (jndiName != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(jndiName, this, EOPPOSITE_FEATURE_BASE - INTERNAL_JNDI_NAME, null, changeContext);
      changeContext = basicUnsetJndiName(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldJndiName_set_ = jndiName_set_;
      jndiName_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_JNDI_NAME, null, null, oldJndiName_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetJndiName()
  {
    return jndiName_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HomeClass getHomeClass()
  {
    return homeClass;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetHomeClass(HomeClass newHomeClass, ChangeContext changeContext)
  {
    HomeClass oldHomeClass = homeClass;
    homeClass = newHomeClass;
    boolean oldHomeClass_set_ = homeClass_set_;
    homeClass_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_HOME_CLASS, oldHomeClass, newHomeClass, !oldHomeClass_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHomeClass(HomeClass newHomeClass)
  {
    if (newHomeClass != homeClass)
    {
      ChangeContext changeContext = null;
      if (homeClass != null)
        changeContext = inverseRemove(homeClass, this, OPPOSITE_FEATURE_BASE - INTERNAL_HOME_CLASS, null, changeContext);
      if (newHomeClass != null)
        changeContext = inverseAdd(newHomeClass, this, OPPOSITE_FEATURE_BASE - INTERNAL_HOME_CLASS, null, changeContext);
      changeContext = basicSetHomeClass(newHomeClass, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldHomeClass_set_ = homeClass_set_;
      homeClass_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_HOME_CLASS, newHomeClass, newHomeClass, !oldHomeClass_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetHomeClass(ChangeContext changeContext)
  {
    HomeClass oldHomeClass = homeClass;
    homeClass = null;
    boolean oldHomeClass_set_ = homeClass_set_;
    homeClass_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_HOME_CLASS, oldHomeClass, null, !oldHomeClass_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetHomeClass()
  {
    if (homeClass != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(homeClass, this, EOPPOSITE_FEATURE_BASE - INTERNAL_HOME_CLASS, null, changeContext);
      changeContext = basicUnsetHomeClass(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldHomeClass_set_ = homeClass_set_;
      homeClass_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_HOME_CLASS, null, null, oldHomeClass_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetHomeClass()
  {
    return homeClass_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method1 getMethod()
  {
    return method;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetMethod(Method1 newMethod, ChangeContext changeContext)
  {
    Method1 oldMethod = method;
    method = newMethod;
    boolean oldMethod_set_ = method_set_;
    method_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_METHOD, oldMethod, newMethod, !oldMethod_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethod(Method1 newMethod)
  {
    if (newMethod != method)
    {
      ChangeContext changeContext = null;
      if (method != null)
        changeContext = inverseRemove(method, this, OPPOSITE_FEATURE_BASE - INTERNAL_METHOD, null, changeContext);
      if (newMethod != null)
        changeContext = inverseAdd(newMethod, this, OPPOSITE_FEATURE_BASE - INTERNAL_METHOD, null, changeContext);
      changeContext = basicSetMethod(newMethod, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldMethod_set_ = method_set_;
      method_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_METHOD, newMethod, newMethod, !oldMethod_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetMethod(ChangeContext changeContext)
  {
    Method1 oldMethod = method;
    method = null;
    boolean oldMethod_set_ = method_set_;
    method_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_METHOD, oldMethod, null, !oldMethod_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMethod()
  {
    if (method != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(method, this, EOPPOSITE_FEATURE_BASE - INTERNAL_METHOD, null, changeContext);
      changeContext = basicUnsetMethod(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldMethod_set_ = method_set_;
      method_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_METHOD, null, null, oldMethod_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMethod()
  {
    return method_set_;
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
      case JNDI_NAME:
        return basicUnsetJndiName(changeContext);
      case HOME_CLASS:
        return basicUnsetHomeClass(changeContext);
      case METHOD:
        return basicUnsetMethod(changeContext);
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
      case JNDI_NAME:
        return getJndiName();
      case HOME_CLASS:
        return getHomeClass();
      case METHOD:
        return getMethod();
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
      case JNDI_NAME:
        setJndiName((JndiName)newValue);
        return;
      case HOME_CLASS:
        setHomeClass((HomeClass)newValue);
        return;
      case METHOD:
        setMethod((Method1)newValue);
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
      case JNDI_NAME:
        unsetJndiName();
        return;
      case HOME_CLASS:
        unsetHomeClass();
        return;
      case METHOD:
        unsetMethod();
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
      case JNDI_NAME:
        return isSetJndiName();
      case HOME_CLASS:
        return isSetHomeClass();
      case METHOD:
        return isSetMethod();
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

} //EjbImpl
