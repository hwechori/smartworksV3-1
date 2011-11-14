/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeadlineImpl.java,v 1.1 2009/12/22 06:17:57 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Deadline;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExceptionName;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deadline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DeadlineImpl#getDeadlineDuration <em>Deadline Duration</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DeadlineImpl#getExceptionName <em>Exception Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DeadlineImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DeadlineImpl#getExecution <em>Execution</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.DeadlineImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeadlineImpl extends DataObjectBase implements Deadline
{

  public final static int DEADLINE_DURATION = 0;

  public final static int EXCEPTION_NAME = 1;

  public final static int ANY = -1;

  public final static int EXECUTION = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Deadline Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEADLINE_DURATION = 0;

  /**
   * The internal feature id for the '<em><b>Exception Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXCEPTION_NAME = 1;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 2;

  /**
   * The internal feature id for the '<em><b>Execution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXECUTION = 3;

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
      case INTERNAL_DEADLINE_DURATION: return DEADLINE_DURATION;
      case INTERNAL_EXCEPTION_NAME: return EXCEPTION_NAME;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_EXECUTION: return EXECUTION;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getDeadlineDuration() <em>Deadline Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeadlineDuration()
   * @generated
   * @ordered
   */
  
  protected ExpressionType deadlineDuration = null;
  
  /**
   * This is true if the Deadline Duration containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean deadlineDuration_set_ = false;

  /**
   * The cached value of the '{@link #getExceptionName() <em>Exception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionName()
   * @generated
   * @ordered
   */
  
  protected ExceptionName exceptionName = null;
  
  /**
   * This is true if the Exception Name containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean exceptionName_set_ = false;

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
   * The default value of the '{@link #getExecution() <em>Execution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecution()
   * @generated
   * @ordered
   */
  protected static final String EXECUTION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getExecution() <em>Execution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecution()
   * @generated
   * @ordered
   */
  protected String execution = EXECUTION_DEFAULT_;

  /**
   * This is true if the Execution attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean execution_set_ = false;

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
  public DeadlineImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getDeadline();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionType getDeadlineDuration()
  {
    return deadlineDuration;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDeadlineDuration(ExpressionType newDeadlineDuration, ChangeContext changeContext)
  {
    ExpressionType oldDeadlineDuration = deadlineDuration;
    deadlineDuration = newDeadlineDuration;
    boolean oldDeadlineDuration_set_ = deadlineDuration_set_;
    deadlineDuration_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DEADLINE_DURATION, oldDeadlineDuration, newDeadlineDuration, !oldDeadlineDuration_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeadlineDuration(ExpressionType newDeadlineDuration)
  {
    if (newDeadlineDuration != deadlineDuration)
    {
      ChangeContext changeContext = null;
      if (deadlineDuration != null)
        changeContext = inverseRemove(deadlineDuration, this, OPPOSITE_FEATURE_BASE - INTERNAL_DEADLINE_DURATION, null, changeContext);
      if (newDeadlineDuration != null)
        changeContext = inverseAdd(newDeadlineDuration, this, OPPOSITE_FEATURE_BASE - INTERNAL_DEADLINE_DURATION, null, changeContext);
      changeContext = basicSetDeadlineDuration(newDeadlineDuration, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDeadlineDuration_set_ = deadlineDuration_set_;
      deadlineDuration_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DEADLINE_DURATION, newDeadlineDuration, newDeadlineDuration, !oldDeadlineDuration_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDeadlineDuration(ChangeContext changeContext)
  {
    ExpressionType oldDeadlineDuration = deadlineDuration;
    deadlineDuration = null;
    boolean oldDeadlineDuration_set_ = deadlineDuration_set_;
    deadlineDuration_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DEADLINE_DURATION, oldDeadlineDuration, null, !oldDeadlineDuration_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDeadlineDuration()
  {
    if (deadlineDuration != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(deadlineDuration, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DEADLINE_DURATION, null, changeContext);
      changeContext = basicUnsetDeadlineDuration(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDeadlineDuration_set_ = deadlineDuration_set_;
      deadlineDuration_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DEADLINE_DURATION, null, null, oldDeadlineDuration_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDeadlineDuration()
  {
    return deadlineDuration_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExceptionName getExceptionName()
  {
    return exceptionName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExceptionName(ExceptionName newExceptionName, ChangeContext changeContext)
  {
    ExceptionName oldExceptionName = exceptionName;
    exceptionName = newExceptionName;
    boolean oldExceptionName_set_ = exceptionName_set_;
    exceptionName_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXCEPTION_NAME, oldExceptionName, newExceptionName, !oldExceptionName_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExceptionName(ExceptionName newExceptionName)
  {
    if (newExceptionName != exceptionName)
    {
      ChangeContext changeContext = null;
      if (exceptionName != null)
        changeContext = inverseRemove(exceptionName, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXCEPTION_NAME, null, changeContext);
      if (newExceptionName != null)
        changeContext = inverseAdd(newExceptionName, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXCEPTION_NAME, null, changeContext);
      changeContext = basicSetExceptionName(newExceptionName, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExceptionName_set_ = exceptionName_set_;
      exceptionName_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXCEPTION_NAME, newExceptionName, newExceptionName, !oldExceptionName_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExceptionName(ChangeContext changeContext)
  {
    ExceptionName oldExceptionName = exceptionName;
    exceptionName = null;
    boolean oldExceptionName_set_ = exceptionName_set_;
    exceptionName_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXCEPTION_NAME, oldExceptionName, null, !oldExceptionName_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExceptionName()
  {
    if (exceptionName != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(exceptionName, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXCEPTION_NAME, null, changeContext);
      changeContext = basicUnsetExceptionName(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExceptionName_set_ = exceptionName_set_;
      exceptionName_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXCEPTION_NAME, null, null, oldExceptionName_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExceptionName()
  {
    return exceptionName_set_;
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
  public String getExecution()
  {
    return execution;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecution(String newExecution)
  {
    String oldExecution = execution;
    execution = newExecution;
    boolean oldExecution_set_ = execution_set_;
    execution_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_EXECUTION, oldExecution, execution, !oldExecution_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExecution()
  {
    String oldExecution = execution;
    boolean oldExecution_set_ = execution_set_;
    execution = EXECUTION_DEFAULT_;
    execution_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_EXECUTION, oldExecution, EXECUTION_DEFAULT_, oldExecution_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExecution()
  {
    return execution_set_;
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
      case DEADLINE_DURATION:
        return basicUnsetDeadlineDuration(changeContext);
      case EXCEPTION_NAME:
        return basicUnsetExceptionName(changeContext);
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
      case DEADLINE_DURATION:
        return getDeadlineDuration();
      case EXCEPTION_NAME:
        return getExceptionName();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case EXECUTION:
        return getExecution();
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
      case DEADLINE_DURATION:
        setDeadlineDuration((ExpressionType)newValue);
        return;
      case EXCEPTION_NAME:
        setExceptionName((ExceptionName)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case EXECUTION:
        setExecution((String)newValue);
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
      case DEADLINE_DURATION:
        unsetDeadlineDuration();
        return;
      case EXCEPTION_NAME:
        unsetExceptionName();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case EXECUTION:
        unsetExecution();
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
      case DEADLINE_DURATION:
        return isSetDeadlineDuration();
      case EXCEPTION_NAME:
        return isSetExceptionName();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case EXECUTION:
        return isSetExecution();
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
    result.append(", Execution: ");
    if (execution_set_) result.append(execution); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //DeadlineImpl
