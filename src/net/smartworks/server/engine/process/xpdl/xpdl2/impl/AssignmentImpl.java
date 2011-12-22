/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssignmentImpl.java,v 1.1 2009/12/22 06:17:40 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Assignment;
import net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.AssignmentImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.AssignmentImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.AssignmentImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.AssignmentImpl#getAssignTime <em>Assign Time</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.AssignmentImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentImpl extends DataObjectBase implements Assignment
{

  public final static int TARGET = 0;

  public final static int EXPRESSION = 1;

  public final static int ANY = -1;

  public final static int ASSIGN_TIME = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TARGET = 0;

  /**
   * The internal feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXPRESSION = 1;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 2;

  /**
   * The internal feature id for the '<em><b>Assign Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ASSIGN_TIME = 3;

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
      case INTERNAL_TARGET: return TARGET;
      case INTERNAL_EXPRESSION: return EXPRESSION;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ASSIGN_TIME: return ASSIGN_TIME;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  
  protected ExpressionType target = null;
  
  /**
   * This is true if the Target containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean target_set_ = false;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  
  protected ExpressionType expression = null;
  
  /**
   * This is true if the Expression containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean expression_set_ = false;

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
   * The default value of the '{@link #getAssignTime() <em>Assign Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignTime()
   * @generated
   * @ordered
   */
  protected static final String ASSIGN_TIME_DEFAULT_ = "Start";

  /**
   * The cached value of the '{@link #getAssignTime() <em>Assign Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignTime()
   * @generated
   * @ordered
   */
  protected String assignTime = ASSIGN_TIME_DEFAULT_;

  /**
   * This is true if the Assign Time attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean assignTime_set_ = false;

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
  public AssignmentImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getAssignment();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionType getTarget()
  {
    return target;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTarget(ExpressionType newTarget, ChangeContext changeContext)
  {
    ExpressionType oldTarget = target;
    target = newTarget;
    boolean oldTarget_set_ = target_set_;
    target_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TARGET, oldTarget, newTarget, !oldTarget_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(ExpressionType newTarget)
  {
    if (newTarget != target)
    {
      ChangeContext changeContext = null;
      if (target != null)
        changeContext = inverseRemove(target, this, OPPOSITE_FEATURE_BASE - INTERNAL_TARGET, null, changeContext);
      if (newTarget != null)
        changeContext = inverseAdd(newTarget, this, OPPOSITE_FEATURE_BASE - INTERNAL_TARGET, null, changeContext);
      changeContext = basicSetTarget(newTarget, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTarget_set_ = target_set_;
      target_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TARGET, newTarget, newTarget, !oldTarget_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTarget(ChangeContext changeContext)
  {
    ExpressionType oldTarget = target;
    target = null;
    boolean oldTarget_set_ = target_set_;
    target_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TARGET, oldTarget, null, !oldTarget_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTarget()
  {
    if (target != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(target, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TARGET, null, changeContext);
      changeContext = basicUnsetTarget(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTarget_set_ = target_set_;
      target_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TARGET, null, null, oldTarget_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTarget()
  {
    return target_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionType getExpression()
  {
    return expression;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExpression(ExpressionType newExpression, ChangeContext changeContext)
  {
    ExpressionType oldExpression = expression;
    expression = newExpression;
    boolean oldExpression_set_ = expression_set_;
    expression_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXPRESSION, oldExpression, newExpression, !oldExpression_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(ExpressionType newExpression)
  {
    if (newExpression != expression)
    {
      ChangeContext changeContext = null;
      if (expression != null)
        changeContext = inverseRemove(expression, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXPRESSION, null, changeContext);
      if (newExpression != null)
        changeContext = inverseAdd(newExpression, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXPRESSION, null, changeContext);
      changeContext = basicSetExpression(newExpression, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExpression_set_ = expression_set_;
      expression_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXPRESSION, newExpression, newExpression, !oldExpression_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExpression(ChangeContext changeContext)
  {
    ExpressionType oldExpression = expression;
    expression = null;
    boolean oldExpression_set_ = expression_set_;
    expression_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXPRESSION, oldExpression, null, !oldExpression_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExpression()
  {
    if (expression != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(expression, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXPRESSION, null, changeContext);
      changeContext = basicUnsetExpression(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExpression_set_ = expression_set_;
      expression_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXPRESSION, null, null, oldExpression_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExpression()
  {
    return expression_set_;
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
  public String getAssignTime()
  {
    return assignTime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignTime(String newAssignTime)
  {
    String oldAssignTime = assignTime;
    assignTime = newAssignTime;
    boolean oldAssignTime_set_ = assignTime_set_;
    assignTime_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ASSIGN_TIME, oldAssignTime, assignTime, !oldAssignTime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAssignTime()
  {
    String oldAssignTime = assignTime;
    boolean oldAssignTime_set_ = assignTime_set_;
    assignTime = ASSIGN_TIME_DEFAULT_;
    assignTime_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ASSIGN_TIME, oldAssignTime, ASSIGN_TIME_DEFAULT_, oldAssignTime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAssignTime()
  {
    return assignTime_set_;
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
      case TARGET:
        return basicUnsetTarget(changeContext);
      case EXPRESSION:
        return basicUnsetExpression(changeContext);
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
      case TARGET:
        return getTarget();
      case EXPRESSION:
        return getExpression();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ASSIGN_TIME:
        return getAssignTime();
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
      case TARGET:
        setTarget((ExpressionType)newValue);
        return;
      case EXPRESSION:
        setExpression((ExpressionType)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case ASSIGN_TIME:
        setAssignTime((String)newValue);
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
      case TARGET:
        unsetTarget();
        return;
      case EXPRESSION:
        unsetExpression();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case ASSIGN_TIME:
        unsetAssignTime();
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
      case TARGET:
        return isSetTarget();
      case EXPRESSION:
        return isSetExpression();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ASSIGN_TIME:
        return isSetAssignTime();
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
    result.append(", AssignTime: ");
    if (assignTime_set_) result.append(assignTime); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //AssignmentImpl
