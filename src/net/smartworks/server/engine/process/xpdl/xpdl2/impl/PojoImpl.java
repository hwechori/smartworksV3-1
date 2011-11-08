/**
 * <copyright>
 * </copyright>
 *
 * $Id: PojoImpl.java,v 1.1 2009/12/22 06:17:26 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Method;
import net.smartworks.server.engine.process.xpdl.xpdl2.Pojo;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PojoImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PojoImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PojoImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PojoImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoImpl extends DataObjectBase implements Pojo
{

  public final static int CLASS = 0;

  public final static int METHOD = 1;

  public final static int ANY = -1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CLASS = 0;

  /**
   * The internal feature id for the '<em><b>Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_METHOD = 1;

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
      case INTERNAL_CLASS: return CLASS;
      case INTERNAL_METHOD: return METHOD;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getClass_() <em>Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClass_()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl2.Class class_ = null;
  
  /**
   * This is true if the Class containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean class_set_ = false;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  
  protected Method method = null;
  
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
  public PojoImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getPojo();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.Class getClass_()
  {
    return class_;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetClass(net.smartworks.server.engine.process.xpdl.xpdl2.Class newClass, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Class oldClass = class_;
    class_ = newClass;
    boolean oldClass_set_ = class_set_;
    class_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_CLASS, oldClass, newClass, !oldClass_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClass(net.smartworks.server.engine.process.xpdl.xpdl2.Class newClass)
  {
    if (newClass != class_)
    {
      ChangeContext changeContext = null;
      if (class_ != null)
        changeContext = inverseRemove(class_, this, OPPOSITE_FEATURE_BASE - INTERNAL_CLASS, null, changeContext);
      if (newClass != null)
        changeContext = inverseAdd(newClass, this, OPPOSITE_FEATURE_BASE - INTERNAL_CLASS, null, changeContext);
      changeContext = basicSetClass(newClass, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldClass_set_ = class_set_;
      class_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_CLASS, newClass, newClass, !oldClass_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetClass(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Class oldClass = class_;
    class_ = null;
    boolean oldClass_set_ = class_set_;
    class_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_CLASS, oldClass, null, !oldClass_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetClass()
  {
    if (class_ != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(class_, this, EOPPOSITE_FEATURE_BASE - INTERNAL_CLASS, null, changeContext);
      changeContext = basicUnsetClass(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldClass_set_ = class_set_;
      class_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_CLASS, null, null, oldClass_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetClass()
  {
    return class_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method getMethod()
  {
    return method;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetMethod(Method newMethod, ChangeContext changeContext)
  {
    Method oldMethod = method;
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
  public void setMethod(Method newMethod)
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
    Method oldMethod = method;
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
      case CLASS:
        return basicUnsetClass(changeContext);
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
      case CLASS:
        return getClass_();
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
      case CLASS:
        setClass((net.smartworks.server.engine.process.xpdl.xpdl2.Class)newValue);
        return;
      case METHOD:
        setMethod((Method)newValue);
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
      case CLASS:
        unsetClass();
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
      case CLASS:
        return isSetClass();
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

} //PojoImpl
