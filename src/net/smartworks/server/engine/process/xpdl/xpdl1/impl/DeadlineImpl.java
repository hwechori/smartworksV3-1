/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeadlineImpl.java,v 1.1 2009/12/22 06:17:21 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Deadline;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.DataObject;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deadline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DeadlineImpl#getDeadlineCondition <em>Deadline Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DeadlineImpl#getExceptionName <em>Exception Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.DeadlineImpl#getExecution <em>Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeadlineImpl extends DataObjectBase implements Deadline
{

  public final static int DEADLINE_CONDITION = 0;

  public final static int EXCEPTION_NAME = 1;

  public final static int EXECUTION = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Deadline Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEADLINE_CONDITION = 0;

  /**
   * The internal feature id for the '<em><b>Exception Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXCEPTION_NAME = 1;

  /**
   * The internal feature id for the '<em><b>Execution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXECUTION = 2;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 3;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_DEADLINE_CONDITION: return DEADLINE_CONDITION;
      case INTERNAL_EXCEPTION_NAME: return EXCEPTION_NAME;
      case INTERNAL_EXECUTION: return EXECUTION;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getDeadlineCondition() <em>Deadline Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeadlineCondition()
   * @generated
   * @ordered
   */
  
  protected DataObject deadlineCondition = null;
  
  /**
   * This is true if the Deadline Condition containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean deadlineCondition_set_ = false;

  /**
   * The cached value of the '{@link #getExceptionName() <em>Exception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionName()
   * @generated
   * @ordered
   */
  
  protected DataObject exceptionName = null;
  
  /**
   * This is true if the Exception Name containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean exceptionName_set_ = false;

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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getDeadline();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject getDeadlineCondition()
  {
    return deadlineCondition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDeadlineCondition(DataObject newDeadlineCondition, ChangeContext changeContext)
  {
    DataObject oldDeadlineCondition = deadlineCondition;
    deadlineCondition = newDeadlineCondition;
    boolean oldDeadlineCondition_set_ = deadlineCondition_set_;
    deadlineCondition_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DEADLINE_CONDITION, oldDeadlineCondition, newDeadlineCondition, !oldDeadlineCondition_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeadlineCondition(DataObject newDeadlineCondition)
  {
    if (newDeadlineCondition != deadlineCondition)
    {
      ChangeContext changeContext = null;
      if (deadlineCondition != null)
        changeContext = inverseRemove(deadlineCondition, this, OPPOSITE_FEATURE_BASE - INTERNAL_DEADLINE_CONDITION, null, changeContext);
      if (newDeadlineCondition != null)
        changeContext = inverseAdd(newDeadlineCondition, this, OPPOSITE_FEATURE_BASE - INTERNAL_DEADLINE_CONDITION, null, changeContext);
      changeContext = basicSetDeadlineCondition(newDeadlineCondition, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDeadlineCondition_set_ = deadlineCondition_set_;
      deadlineCondition_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DEADLINE_CONDITION, newDeadlineCondition, newDeadlineCondition, !oldDeadlineCondition_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDeadlineCondition(ChangeContext changeContext)
  {
    DataObject oldDeadlineCondition = deadlineCondition;
    deadlineCondition = null;
    boolean oldDeadlineCondition_set_ = deadlineCondition_set_;
    deadlineCondition_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DEADLINE_CONDITION, oldDeadlineCondition, null, !oldDeadlineCondition_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDeadlineCondition()
  {
    if (deadlineCondition != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(deadlineCondition, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DEADLINE_CONDITION, null, changeContext);
      changeContext = basicUnsetDeadlineCondition(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDeadlineCondition_set_ = deadlineCondition_set_;
      deadlineCondition_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DEADLINE_CONDITION, null, null, oldDeadlineCondition_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDeadlineCondition()
  {
    return deadlineCondition_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject getExceptionName()
  {
    return exceptionName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExceptionName(DataObject newExceptionName, ChangeContext changeContext)
  {
    DataObject oldExceptionName = exceptionName;
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
  public void setExceptionName(DataObject newExceptionName)
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
    DataObject oldExceptionName = exceptionName;
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
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case DEADLINE_CONDITION:
        return basicUnsetDeadlineCondition(changeContext);
      case EXCEPTION_NAME:
        return basicUnsetExceptionName(changeContext);
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
      case DEADLINE_CONDITION:
        return getDeadlineCondition();
      case EXCEPTION_NAME:
        return getExceptionName();
      case EXECUTION:
        return getExecution();
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
      case DEADLINE_CONDITION:
        setDeadlineCondition((DataObject)newValue);
        return;
      case EXCEPTION_NAME:
        setExceptionName((DataObject)newValue);
        return;
      case EXECUTION:
        setExecution((String)newValue);
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
      case DEADLINE_CONDITION:
        unsetDeadlineCondition();
        return;
      case EXCEPTION_NAME:
        unsetExceptionName();
        return;
      case EXECUTION:
        unsetExecution();
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
      case DEADLINE_CONDITION:
        return isSetDeadlineCondition();
      case EXCEPTION_NAME:
        return isSetExceptionName();
      case EXECUTION:
        return isSetExecution();
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
    result.append(" (Execution: ");
    if (execution_set_) result.append(execution); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //DeadlineImpl
