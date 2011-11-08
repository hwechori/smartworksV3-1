/**
 * <copyright>
 * </copyright>
 *
 * $Id: Implementation7Impl.java,v 1.1 2009/12/22 06:17:39 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Tool;

import net.smartworks.server.engine.process.xpdl.xpdl2.Implementation7;
import net.smartworks.server.engine.process.xpdl.xpdl2.No;
import net.smartworks.server.engine.process.xpdl.xpdl2.Reference;
import net.smartworks.server.engine.process.xpdl.xpdl2.SubFlow;
import net.smartworks.server.engine.process.xpdl.xpdl2.Task;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation7</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.Implementation7Impl#getNo <em>No</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.Implementation7Impl#getTool <em>Tool</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.Implementation7Impl#getTask <em>Task</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.Implementation7Impl#getSubFlow <em>Sub Flow</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.Implementation7Impl#getReference <em>Reference</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.Implementation7Impl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Implementation7Impl extends DataObjectBase implements Implementation7
{

  public final static int NO = 0;

  public final static int TOOL = 1;

  public final static int TASK = 2;

  public final static int SUB_FLOW = 3;

  public final static int REFERENCE = 4;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 5;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>No</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NO = 0;

  /**
   * The internal feature id for the '<em><b>Tool</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TOOL = 1;

  /**
   * The internal feature id for the '<em><b>Task</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK = 2;

  /**
   * The internal feature id for the '<em><b>Sub Flow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SUB_FLOW = 3;

  /**
   * The internal feature id for the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_REFERENCE = 4;

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
      case INTERNAL_NO: return NO;
      case INTERNAL_TOOL: return TOOL;
      case INTERNAL_TASK: return TASK;
      case INTERNAL_SUB_FLOW: return SUB_FLOW;
      case INTERNAL_REFERENCE: return REFERENCE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getNo() <em>No</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNo()
   * @generated
   * @ordered
   */
  
  protected No no = null;
  
  /**
   * This is true if the No containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean no_set_ = false;

  /**
   * The cached value of the '{@link #getTool() <em>Tool</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTool()
   * @generated
   * @ordered
   */
  
  protected List tool = null;
  
  /**
   * The cached value of the '{@link #getTask() <em>Task</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTask()
   * @generated
   * @ordered
   */
  
  protected Task task = null;
  
  /**
   * This is true if the Task containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean task_set_ = false;

  /**
   * The cached value of the '{@link #getSubFlow() <em>Sub Flow</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubFlow()
   * @generated
   * @ordered
   */
  
  protected SubFlow subFlow = null;
  
  /**
   * This is true if the Sub Flow containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean subFlow_set_ = false;

  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  
  protected Reference reference = null;
  
  /**
   * This is true if the Reference containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean reference_set_ = false;

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
  public Implementation7Impl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getImplementation7();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public No getNo()
  {
    return no;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetNo(No newNo, ChangeContext changeContext)
  {
    No oldNo = no;
    no = newNo;
    boolean oldNo_set_ = no_set_;
    no_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_NO, oldNo, newNo, !oldNo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNo(No newNo)
  {
    if (newNo != no)
    {
      ChangeContext changeContext = null;
      if (no != null)
        changeContext = inverseRemove(no, this, OPPOSITE_FEATURE_BASE - INTERNAL_NO, null, changeContext);
      if (newNo != null)
        changeContext = inverseAdd(newNo, this, OPPOSITE_FEATURE_BASE - INTERNAL_NO, null, changeContext);
      changeContext = basicSetNo(newNo, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldNo_set_ = no_set_;
      no_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_NO, newNo, newNo, !oldNo_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetNo(ChangeContext changeContext)
  {
    No oldNo = no;
    no = null;
    boolean oldNo_set_ = no_set_;
    no_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_NO, oldNo, null, !oldNo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNo()
  {
    if (no != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(no, this, EOPPOSITE_FEATURE_BASE - INTERNAL_NO, null, changeContext);
      changeContext = basicUnsetNo(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldNo_set_ = no_set_;
      no_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_NO, null, null, oldNo_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNo()
  {
    return no_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getTool()
  {
    if (tool == null)
    {
      tool = createPropertyList(ListKind.CONTAINMENT, Tool.class, TOOL, 0);
    }
    return tool;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task getTask()
  {
    return task;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTask(Task newTask, ChangeContext changeContext)
  {
    Task oldTask = task;
    task = newTask;
    boolean oldTask_set_ = task_set_;
    task_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK, oldTask, newTask, !oldTask_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTask(Task newTask)
  {
    if (newTask != task)
    {
      ChangeContext changeContext = null;
      if (task != null)
        changeContext = inverseRemove(task, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK, null, changeContext);
      if (newTask != null)
        changeContext = inverseAdd(newTask, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK, null, changeContext);
      changeContext = basicSetTask(newTask, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTask_set_ = task_set_;
      task_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK, newTask, newTask, !oldTask_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTask(ChangeContext changeContext)
  {
    Task oldTask = task;
    task = null;
    boolean oldTask_set_ = task_set_;
    task_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK, oldTask, null, !oldTask_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTask()
  {
    if (task != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(task, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK, null, changeContext);
      changeContext = basicUnsetTask(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTask_set_ = task_set_;
      task_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK, null, null, oldTask_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTask()
  {
    return task_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubFlow getSubFlow()
  {
    return subFlow;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetSubFlow(SubFlow newSubFlow, ChangeContext changeContext)
  {
    SubFlow oldSubFlow = subFlow;
    subFlow = newSubFlow;
    boolean oldSubFlow_set_ = subFlow_set_;
    subFlow_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SUB_FLOW, oldSubFlow, newSubFlow, !oldSubFlow_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubFlow(SubFlow newSubFlow)
  {
    if (newSubFlow != subFlow)
    {
      ChangeContext changeContext = null;
      if (subFlow != null)
        changeContext = inverseRemove(subFlow, this, OPPOSITE_FEATURE_BASE - INTERNAL_SUB_FLOW, null, changeContext);
      if (newSubFlow != null)
        changeContext = inverseAdd(newSubFlow, this, OPPOSITE_FEATURE_BASE - INTERNAL_SUB_FLOW, null, changeContext);
      changeContext = basicSetSubFlow(newSubFlow, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldSubFlow_set_ = subFlow_set_;
      subFlow_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SUB_FLOW, newSubFlow, newSubFlow, !oldSubFlow_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetSubFlow(ChangeContext changeContext)
  {
    SubFlow oldSubFlow = subFlow;
    subFlow = null;
    boolean oldSubFlow_set_ = subFlow_set_;
    subFlow_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SUB_FLOW, oldSubFlow, null, !oldSubFlow_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSubFlow()
  {
    if (subFlow != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(subFlow, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SUB_FLOW, null, changeContext);
      changeContext = basicUnsetSubFlow(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldSubFlow_set_ = subFlow_set_;
      subFlow_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SUB_FLOW, null, null, oldSubFlow_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSubFlow()
  {
    return subFlow_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference getReference()
  {
    return reference;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetReference(Reference newReference, ChangeContext changeContext)
  {
    Reference oldReference = reference;
    reference = newReference;
    boolean oldReference_set_ = reference_set_;
    reference_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_REFERENCE, oldReference, newReference, !oldReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReference(Reference newReference)
  {
    if (newReference != reference)
    {
      ChangeContext changeContext = null;
      if (reference != null)
        changeContext = inverseRemove(reference, this, OPPOSITE_FEATURE_BASE - INTERNAL_REFERENCE, null, changeContext);
      if (newReference != null)
        changeContext = inverseAdd(newReference, this, OPPOSITE_FEATURE_BASE - INTERNAL_REFERENCE, null, changeContext);
      changeContext = basicSetReference(newReference, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldReference_set_ = reference_set_;
      reference_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_REFERENCE, newReference, newReference, !oldReference_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetReference(ChangeContext changeContext)
  {
    Reference oldReference = reference;
    reference = null;
    boolean oldReference_set_ = reference_set_;
    reference_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_REFERENCE, oldReference, null, !oldReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetReference()
  {
    if (reference != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(reference, this, EOPPOSITE_FEATURE_BASE - INTERNAL_REFERENCE, null, changeContext);
      changeContext = basicUnsetReference(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldReference_set_ = reference_set_;
      reference_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_REFERENCE, null, null, oldReference_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetReference()
  {
    return reference_set_;
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
      case NO:
        return basicUnsetNo(changeContext);
      case TOOL:
        return removeFromList(getTool(), otherEnd, changeContext);
      case TASK:
        return basicUnsetTask(changeContext);
      case SUB_FLOW:
        return basicUnsetSubFlow(changeContext);
      case REFERENCE:
        return basicUnsetReference(changeContext);
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
      case NO:
        return getNo();
      case TOOL:
        return getTool();
      case TASK:
        return getTask();
      case SUB_FLOW:
        return getSubFlow();
      case REFERENCE:
        return getReference();
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
      case NO:
        setNo((No)newValue);
        return;
      case TOOL:
        getTool().clear();
        getTool().addAll((Collection)newValue);
        return;
      case TASK:
        setTask((Task)newValue);
        return;
      case SUB_FLOW:
        setSubFlow((SubFlow)newValue);
        return;
      case REFERENCE:
        setReference((Reference)newValue);
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
      case NO:
        unsetNo();
        return;
      case TOOL:
        getTool().clear();
        return;
      case TASK:
        unsetTask();
        return;
      case SUB_FLOW:
        unsetSubFlow();
        return;
      case REFERENCE:
        unsetReference();
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
      case NO:
        return isSetNo();
      case TOOL:
        return tool != null && !tool.isEmpty();
      case TASK:
        return isSetTask();
      case SUB_FLOW:
        return isSetSubFlow();
      case REFERENCE:
        return isSetReference();
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
    result.append(" (anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //Implementation7Impl
