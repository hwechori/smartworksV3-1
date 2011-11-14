/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoopStandardImpl.java,v 1.1 2009/12/22 06:17:39 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.LoopStandard;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import java.math.BigInteger;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Standard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopStandardImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopStandardImpl#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopStandardImpl#getLoopCounter <em>Loop Counter</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopStandardImpl#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopStandardImpl#getTestTime <em>Test Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LoopStandardImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopStandardImpl extends DataObjectBase implements LoopStandard
{

  public final static int ANY = -1;

  public final static int LOOP_CONDITION = 0;

  public final static int LOOP_COUNTER = 1;

  public final static int LOOP_MAXIMUM = 2;

  public final static int TEST_TIME = 3;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 4;

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
   * The internal feature id for the '<em><b>Loop Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP_CONDITION = 1;

  /**
   * The internal feature id for the '<em><b>Loop Counter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP_COUNTER = 2;

  /**
   * The internal feature id for the '<em><b>Loop Maximum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOOP_MAXIMUM = 3;

  /**
   * The internal feature id for the '<em><b>Test Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TEST_TIME = 4;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 5;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 6;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_ANY: return ANY;
      case INTERNAL_LOOP_CONDITION: return LOOP_CONDITION;
      case INTERNAL_LOOP_COUNTER: return LOOP_COUNTER;
      case INTERNAL_LOOP_MAXIMUM: return LOOP_MAXIMUM;
      case INTERNAL_TEST_TIME: return TEST_TIME;
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
   * The default value of the '{@link #getLoopCondition() <em>Loop Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopCondition()
   * @generated
   * @ordered
   */
  protected static final String LOOP_CONDITION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLoopCondition() <em>Loop Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopCondition()
   * @generated
   * @ordered
   */
  protected String loopCondition = LOOP_CONDITION_DEFAULT_;

  /**
   * This is true if the Loop Condition attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loopCondition_set_ = false;

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
   * The default value of the '{@link #getLoopMaximum() <em>Loop Maximum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopMaximum()
   * @generated
   * @ordered
   */
  protected static final BigInteger LOOP_MAXIMUM_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLoopMaximum() <em>Loop Maximum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopMaximum()
   * @generated
   * @ordered
   */
  protected BigInteger loopMaximum = LOOP_MAXIMUM_DEFAULT_;

  /**
   * This is true if the Loop Maximum attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loopMaximum_set_ = false;

  /**
   * The default value of the '{@link #getTestTime() <em>Test Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestTime()
   * @generated
   * @ordered
   */
  protected static final String TEST_TIME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTestTime() <em>Test Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestTime()
   * @generated
   * @ordered
   */
  protected String testTime = TEST_TIME_DEFAULT_;

  /**
   * This is true if the Test Time attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean testTime_set_ = false;

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
  public LoopStandardImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getLoopStandard();
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
  public String getLoopCondition()
  {
    return loopCondition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopCondition(String newLoopCondition)
  {
    String oldLoopCondition = loopCondition;
    loopCondition = newLoopCondition;
    boolean oldLoopCondition_set_ = loopCondition_set_;
    loopCondition_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LOOP_CONDITION, oldLoopCondition, loopCondition, !oldLoopCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLoopCondition()
  {
    String oldLoopCondition = loopCondition;
    boolean oldLoopCondition_set_ = loopCondition_set_;
    loopCondition = LOOP_CONDITION_DEFAULT_;
    loopCondition_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LOOP_CONDITION, oldLoopCondition, LOOP_CONDITION_DEFAULT_, oldLoopCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLoopCondition()
  {
    return loopCondition_set_;
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
  public BigInteger getLoopMaximum()
  {
    return loopMaximum;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopMaximum(BigInteger newLoopMaximum)
  {
    BigInteger oldLoopMaximum = loopMaximum;
    loopMaximum = newLoopMaximum;
    boolean oldLoopMaximum_set_ = loopMaximum_set_;
    loopMaximum_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LOOP_MAXIMUM, oldLoopMaximum, loopMaximum, !oldLoopMaximum_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLoopMaximum()
  {
    BigInteger oldLoopMaximum = loopMaximum;
    boolean oldLoopMaximum_set_ = loopMaximum_set_;
    loopMaximum = LOOP_MAXIMUM_DEFAULT_;
    loopMaximum_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LOOP_MAXIMUM, oldLoopMaximum, LOOP_MAXIMUM_DEFAULT_, oldLoopMaximum_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLoopMaximum()
  {
    return loopMaximum_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTestTime()
  {
    return testTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTestTime(String newTestTime)
  {
    String oldTestTime = testTime;
    testTime = newTestTime;
    boolean oldTestTime_set_ = testTime_set_;
    testTime_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TEST_TIME, oldTestTime, testTime, !oldTestTime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTestTime()
  {
    String oldTestTime = testTime;
    boolean oldTestTime_set_ = testTime_set_;
    testTime = TEST_TIME_DEFAULT_;
    testTime_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TEST_TIME, oldTestTime, TEST_TIME_DEFAULT_, oldTestTime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTestTime()
  {
    return testTime_set_;
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
      case LOOP_CONDITION:
        return getLoopCondition();
      case LOOP_COUNTER:
        return getLoopCounter();
      case LOOP_MAXIMUM:
        return getLoopMaximum();
      case TEST_TIME:
        return getTestTime();
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
      case LOOP_CONDITION:
        setLoopCondition((String)newValue);
        return;
      case LOOP_COUNTER:
        setLoopCounter((BigInteger)newValue);
        return;
      case LOOP_MAXIMUM:
        setLoopMaximum((BigInteger)newValue);
        return;
      case TEST_TIME:
        setTestTime((String)newValue);
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
      case LOOP_CONDITION:
        unsetLoopCondition();
        return;
      case LOOP_COUNTER:
        unsetLoopCounter();
        return;
      case LOOP_MAXIMUM:
        unsetLoopMaximum();
        return;
      case TEST_TIME:
        unsetTestTime();
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
      case LOOP_CONDITION:
        return isSetLoopCondition();
      case LOOP_COUNTER:
        return isSetLoopCounter();
      case LOOP_MAXIMUM:
        return isSetLoopMaximum();
      case TEST_TIME:
        return isSetTestTime();
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
    result.append(", LoopCondition: ");
    if (loopCondition_set_) result.append(loopCondition); else result.append("<unset>");
    result.append(", LoopCounter: ");
    if (loopCounter_set_) result.append(loopCounter); else result.append("<unset>");
    result.append(", LoopMaximum: ");
    if (loopMaximum_set_) result.append(loopMaximum); else result.append("<unset>");
    result.append(", TestTime: ");
    if (testTime_set_) result.append(testTime); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //LoopStandardImpl
