/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataMappingImpl.java,v 1.1 2009/12/22 06:17:46 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.DataMapping;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataMappingImpl#getActual <em>Actual</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataMappingImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataMappingImpl#getFormal <em>Formal</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataMappingImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DataMappingImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMappingImpl extends DataObjectBase implements DataMapping
{

  public final static int ACTUAL = 0;

  public final static int ANY = -1;

  public final static int FORMAL = 1;

  public final static int DIRECTION = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Actual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTUAL = 0;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 1;

  /**
   * The internal feature id for the '<em><b>Formal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FORMAL = 2;

  /**
   * The internal feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DIRECTION = 3;

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
      case INTERNAL_ACTUAL: return ACTUAL;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_FORMAL: return FORMAL;
      case INTERNAL_DIRECTION: return DIRECTION;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getActual() <em>Actual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActual()
   * @generated
   * @ordered
   */
  
  protected ExpressionType actual = null;
  
  /**
   * This is true if the Actual containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean actual_set_ = false;

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
   * The default value of the '{@link #getFormal() <em>Formal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormal()
   * @generated
   * @ordered
   */
  protected static final String FORMAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getFormal() <em>Formal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormal()
   * @generated
   * @ordered
   */
  protected String formal = FORMAL_DEFAULT_;

  /**
   * This is true if the Formal attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean formal_set_ = false;

  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final String DIRECTION_DEFAULT_ = "IN";

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected String direction = DIRECTION_DEFAULT_;

  /**
   * This is true if the Direction attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean direction_set_ = false;

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
  public DataMappingImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getDataMapping();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionType getActual()
  {
    return actual;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActual(ExpressionType newActual, ChangeContext changeContext)
  {
    ExpressionType oldActual = actual;
    actual = newActual;
    boolean oldActual_set_ = actual_set_;
    actual_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTUAL, oldActual, newActual, !oldActual_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActual(ExpressionType newActual)
  {
    if (newActual != actual)
    {
      ChangeContext changeContext = null;
      if (actual != null)
        changeContext = inverseRemove(actual, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL, null, changeContext);
      if (newActual != null)
        changeContext = inverseAdd(newActual, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL, null, changeContext);
      changeContext = basicSetActual(newActual, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActual_set_ = actual_set_;
      actual_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTUAL, newActual, newActual, !oldActual_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActual(ChangeContext changeContext)
  {
    ExpressionType oldActual = actual;
    actual = null;
    boolean oldActual_set_ = actual_set_;
    actual_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTUAL, oldActual, null, !oldActual_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActual()
  {
    if (actual != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(actual, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL, null, changeContext);
      changeContext = basicUnsetActual(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActual_set_ = actual_set_;
      actual_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTUAL, null, null, oldActual_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActual()
  {
    return actual_set_;
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
  public String getFormal()
  {
    return formal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormal(String newFormal)
  {
    String oldFormal = formal;
    formal = newFormal;
    boolean oldFormal_set_ = formal_set_;
    formal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_FORMAL, oldFormal, formal, !oldFormal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFormal()
  {
    String oldFormal = formal;
    boolean oldFormal_set_ = formal_set_;
    formal = FORMAL_DEFAULT_;
    formal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_FORMAL, oldFormal, FORMAL_DEFAULT_, oldFormal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFormal()
  {
    return formal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDirection()
  {
    return direction;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirection(String newDirection)
  {
    String oldDirection = direction;
    direction = newDirection;
    boolean oldDirection_set_ = direction_set_;
    direction_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DIRECTION, oldDirection, direction, !oldDirection_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDirection()
  {
    String oldDirection = direction;
    boolean oldDirection_set_ = direction_set_;
    direction = DIRECTION_DEFAULT_;
    direction_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DIRECTION, oldDirection, DIRECTION_DEFAULT_, oldDirection_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDirection()
  {
    return direction_set_;
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
      case ACTUAL:
        return basicUnsetActual(changeContext);
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
      case ACTUAL:
        return getActual();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case FORMAL:
        return getFormal();
      case DIRECTION:
        return getDirection();
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
      case ACTUAL:
        setActual((ExpressionType)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case FORMAL:
        setFormal((String)newValue);
        return;
      case DIRECTION:
        setDirection((String)newValue);
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
      case ACTUAL:
        unsetActual();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case FORMAL:
        unsetFormal();
        return;
      case DIRECTION:
        unsetDirection();
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
      case ACTUAL:
        return isSetActual();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case FORMAL:
        return isSetFormal();
      case DIRECTION:
        return isSetDirection();
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
    result.append(", Formal: ");
    if (formal_set_) result.append(formal); else result.append("<unset>");
    result.append(", Direction: ");
    if (direction_set_) result.append(direction); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //DataMappingImpl
