/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoopMultiInstanceImpl.java,v 1.1 2009/12/22 06:17:54 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.LoopMultiInstance;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import java.math.BigInteger;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Multi Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopMultiInstanceImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopMultiInstanceImpl#getMI_Condition <em>MI Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopMultiInstanceImpl#getLoopCounter <em>Loop Counter</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopMultiInstanceImpl#getMI_Ordering <em>MI Ordering</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopMultiInstanceImpl#getMI_FlowCondition <em>MI Flow Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopMultiInstanceImpl#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopMultiInstanceImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopMultiInstanceImpl extends DataObjectBase implements LoopMultiInstance
{

  public final static int ANY = -1;

  public final static int MI_CONDITION = 0;

  public final static int LOOP_COUNTER = 1;

  public final static int MI_ORDERING = 2;

  public final static int MI_FLOW_CONDITION = 3;

  public final static int COMPLEX_MI_FLOW_CONDITION = 4;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 5;

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
   * The internal feature id for the '<em><b>MI Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MI_CONDITION = 1;

  /**
   * The internal feature id for the '<em><b>Loop Counter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP_COUNTER = 2;

  /**
   * The internal feature id for the '<em><b>MI Ordering</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MI_ORDERING = 3;

  /**
   * The internal feature id for the '<em><b>MI Flow Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MI_FLOW_CONDITION = 4;

  /**
   * The internal feature id for the '<em><b>Complex MI Flow Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COMPLEX_MI_FLOW_CONDITION = 5;

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
      case INTERNAL_ANY: return ANY;
      case INTERNAL_MI_CONDITION: return MI_CONDITION;
      case INTERNAL_LOOP_COUNTER: return LOOP_COUNTER;
      case INTERNAL_MI_ORDERING: return MI_ORDERING;
      case INTERNAL_MI_FLOW_CONDITION: return MI_FLOW_CONDITION;
      case INTERNAL_COMPLEX_MI_FLOW_CONDITION: return COMPLEX_MI_FLOW_CONDITION;
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
   * The default value of the '{@link #getMI_Condition() <em>MI Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMI_Condition()
   * @generated
   * @ordered
   */
  protected static final String MI_CONDITION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getMI_Condition() <em>MI Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMI_Condition()
   * @generated
   * @ordered
   */
  protected String mI_Condition = MI_CONDITION_DEFAULT_;

  /**
   * This is true if the MI Condition attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean mI_Condition_set_ = false;

  /**
   * The default value of the '{@link #getLoopCounter() <em>Loop Counter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopCounter()
   * @generated
   * @ordered
   */
  protected static final BigInteger LOOP_COUNTER_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLoopCounter() <em>Loop Counter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopCounter()
   * @generated
   * @ordered
   */
  protected BigInteger loopCounter = LOOP_COUNTER_DEFAULT_;

  /**
   * This is true if the Loop Counter attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loopCounter_set_ = false;

  /**
   * The default value of the '{@link #getMI_Ordering() <em>MI Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMI_Ordering()
   * @generated
   * @ordered
   */
  protected static final String MI_ORDERING_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getMI_Ordering() <em>MI Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMI_Ordering()
   * @generated
   * @ordered
   */
  protected String mI_Ordering = MI_ORDERING_DEFAULT_;

  /**
   * This is true if the MI Ordering attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean mI_Ordering_set_ = false;

  /**
   * The default value of the '{@link #getMI_FlowCondition() <em>MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMI_FlowCondition()
   * @generated
   * @ordered
   */
  protected static final String MI_FLOW_CONDITION_DEFAULT_ = "All";

  /**
   * The cached value of the '{@link #getMI_FlowCondition() <em>MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMI_FlowCondition()
   * @generated
   * @ordered
   */
  protected String mI_FlowCondition = MI_FLOW_CONDITION_DEFAULT_;

  /**
   * This is true if the MI Flow Condition attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean mI_FlowCondition_set_ = false;

  /**
   * The default value of the '{@link #getComplexMI_FlowCondition() <em>Complex MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplexMI_FlowCondition()
   * @generated
   * @ordered
   */
  protected static final String COMPLEX_MI_FLOW_CONDITION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getComplexMI_FlowCondition() <em>Complex MI Flow Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplexMI_FlowCondition()
   * @generated
   * @ordered
   */
  protected String complexMI_FlowCondition = COMPLEX_MI_FLOW_CONDITION_DEFAULT_;

  /**
   * This is true if the Complex MI Flow Condition attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean complexMI_FlowCondition_set_ = false;

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
  public LoopMultiInstanceImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getLoopMultiInstance();
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
  public String getMI_Condition()
  {
    return mI_Condition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMI_Condition(String newMI_Condition)
  {
    String oldMI_Condition = mI_Condition;
    mI_Condition = newMI_Condition;
    boolean oldMI_Condition_set_ = mI_Condition_set_;
    mI_Condition_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_MI_CONDITION, oldMI_Condition, mI_Condition, !oldMI_Condition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMI_Condition()
  {
    String oldMI_Condition = mI_Condition;
    boolean oldMI_Condition_set_ = mI_Condition_set_;
    mI_Condition = MI_CONDITION_DEFAULT_;
    mI_Condition_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_MI_CONDITION, oldMI_Condition, MI_CONDITION_DEFAULT_, oldMI_Condition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMI_Condition()
  {
    return mI_Condition_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getLoopCounter()
  {
    return loopCounter;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopCounter(BigInteger newLoopCounter)
  {
    BigInteger oldLoopCounter = loopCounter;
    loopCounter = newLoopCounter;
    boolean oldLoopCounter_set_ = loopCounter_set_;
    loopCounter_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LOOP_COUNTER, oldLoopCounter, loopCounter, !oldLoopCounter_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLoopCounter()
  {
    BigInteger oldLoopCounter = loopCounter;
    boolean oldLoopCounter_set_ = loopCounter_set_;
    loopCounter = LOOP_COUNTER_DEFAULT_;
    loopCounter_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LOOP_COUNTER, oldLoopCounter, LOOP_COUNTER_DEFAULT_, oldLoopCounter_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLoopCounter()
  {
    return loopCounter_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMI_Ordering()
  {
    return mI_Ordering;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMI_Ordering(String newMI_Ordering)
  {
    String oldMI_Ordering = mI_Ordering;
    mI_Ordering = newMI_Ordering;
    boolean oldMI_Ordering_set_ = mI_Ordering_set_;
    mI_Ordering_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_MI_ORDERING, oldMI_Ordering, mI_Ordering, !oldMI_Ordering_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMI_Ordering()
  {
    String oldMI_Ordering = mI_Ordering;
    boolean oldMI_Ordering_set_ = mI_Ordering_set_;
    mI_Ordering = MI_ORDERING_DEFAULT_;
    mI_Ordering_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_MI_ORDERING, oldMI_Ordering, MI_ORDERING_DEFAULT_, oldMI_Ordering_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMI_Ordering()
  {
    return mI_Ordering_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMI_FlowCondition()
  {
    return mI_FlowCondition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMI_FlowCondition(String newMI_FlowCondition)
  {
    String oldMI_FlowCondition = mI_FlowCondition;
    mI_FlowCondition = newMI_FlowCondition;
    boolean oldMI_FlowCondition_set_ = mI_FlowCondition_set_;
    mI_FlowCondition_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_MI_FLOW_CONDITION, oldMI_FlowCondition, mI_FlowCondition, !oldMI_FlowCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMI_FlowCondition()
  {
    String oldMI_FlowCondition = mI_FlowCondition;
    boolean oldMI_FlowCondition_set_ = mI_FlowCondition_set_;
    mI_FlowCondition = MI_FLOW_CONDITION_DEFAULT_;
    mI_FlowCondition_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_MI_FLOW_CONDITION, oldMI_FlowCondition, MI_FLOW_CONDITION_DEFAULT_, oldMI_FlowCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMI_FlowCondition()
  {
    return mI_FlowCondition_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComplexMI_FlowCondition()
  {
    return complexMI_FlowCondition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComplexMI_FlowCondition(String newComplexMI_FlowCondition)
  {
    String oldComplexMI_FlowCondition = complexMI_FlowCondition;
    complexMI_FlowCondition = newComplexMI_FlowCondition;
    boolean oldComplexMI_FlowCondition_set_ = complexMI_FlowCondition_set_;
    complexMI_FlowCondition_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_COMPLEX_MI_FLOW_CONDITION, oldComplexMI_FlowCondition, complexMI_FlowCondition, !oldComplexMI_FlowCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetComplexMI_FlowCondition()
  {
    String oldComplexMI_FlowCondition = complexMI_FlowCondition;
    boolean oldComplexMI_FlowCondition_set_ = complexMI_FlowCondition_set_;
    complexMI_FlowCondition = COMPLEX_MI_FLOW_CONDITION_DEFAULT_;
    complexMI_FlowCondition_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_COMPLEX_MI_FLOW_CONDITION, oldComplexMI_FlowCondition, COMPLEX_MI_FLOW_CONDITION_DEFAULT_, oldComplexMI_FlowCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetComplexMI_FlowCondition()
  {
    return complexMI_FlowCondition_set_;
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
      case MI_CONDITION:
        return getMI_Condition();
      case LOOP_COUNTER:
        return getLoopCounter();
      case MI_ORDERING:
        return getMI_Ordering();
      case MI_FLOW_CONDITION:
        return getMI_FlowCondition();
      case COMPLEX_MI_FLOW_CONDITION:
        return getComplexMI_FlowCondition();
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
      case MI_CONDITION:
        setMI_Condition((String)newValue);
        return;
      case LOOP_COUNTER:
        setLoopCounter((BigInteger)newValue);
        return;
      case MI_ORDERING:
        setMI_Ordering((String)newValue);
        return;
      case MI_FLOW_CONDITION:
        setMI_FlowCondition((String)newValue);
        return;
      case COMPLEX_MI_FLOW_CONDITION:
        setComplexMI_FlowCondition((String)newValue);
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
      case MI_CONDITION:
        unsetMI_Condition();
        return;
      case LOOP_COUNTER:
        unsetLoopCounter();
        return;
      case MI_ORDERING:
        unsetMI_Ordering();
        return;
      case MI_FLOW_CONDITION:
        unsetMI_FlowCondition();
        return;
      case COMPLEX_MI_FLOW_CONDITION:
        unsetComplexMI_FlowCondition();
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
      case MI_CONDITION:
        return isSetMI_Condition();
      case LOOP_COUNTER:
        return isSetLoopCounter();
      case MI_ORDERING:
        return isSetMI_Ordering();
      case MI_FLOW_CONDITION:
        return isSetMI_FlowCondition();
      case COMPLEX_MI_FLOW_CONDITION:
        return isSetComplexMI_FlowCondition();
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
    result.append(", MI_Condition: ");
    if (mI_Condition_set_) result.append(mI_Condition); else result.append("<unset>");
    result.append(", LoopCounter: ");
    if (loopCounter_set_) result.append(loopCounter); else result.append("<unset>");
    result.append(", MI_Ordering: ");
    if (mI_Ordering_set_) result.append(mI_Ordering); else result.append("<unset>");
    result.append(", MI_FlowCondition: ");
    if (mI_FlowCondition_set_) result.append(mI_FlowCondition); else result.append("<unset>");
    result.append(", ComplexMI_FlowCondition: ");
    if (complexMI_FlowCondition_set_) result.append(complexMI_FlowCondition); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //LoopMultiInstanceImpl
