/**
 * <copyright>
 * </copyright>
 *
 * $Id: TaskImpl.java,v 1.1 2009/12/22 06:17:37 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Task;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskApplication;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskManual;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskReceive;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskReference;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskScript;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskSend;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskService;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskUser;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskService <em>Task Service</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskReceive <em>Task Receive</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskManual <em>Task Manual</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskReference <em>Task Reference</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskScript <em>Task Script</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskSend <em>Task Send</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskUser <em>Task User</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getTaskApplication <em>Task Application</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends DataObjectBase implements Task
{

  public final static int TASK_SERVICE = 0;

  public final static int TASK_RECEIVE = 1;

  public final static int TASK_MANUAL = 2;

  public final static int TASK_REFERENCE = 3;

  public final static int TASK_SCRIPT = 4;

  public final static int TASK_SEND = 5;

  public final static int TASK_USER = 6;

  public final static int TASK_APPLICATION = 7;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 8;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Task Service</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_SERVICE = 0;

  /**
   * The internal feature id for the '<em><b>Task Receive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_RECEIVE = 1;

  /**
   * The internal feature id for the '<em><b>Task Manual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_MANUAL = 2;

  /**
   * The internal feature id for the '<em><b>Task Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_REFERENCE = 3;

  /**
   * The internal feature id for the '<em><b>Task Script</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_SCRIPT = 4;

  /**
   * The internal feature id for the '<em><b>Task Send</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_SEND = 5;

  /**
   * The internal feature id for the '<em><b>Task User</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_USER = 6;

  /**
   * The internal feature id for the '<em><b>Task Application</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TASK_APPLICATION = 7;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 8;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 9;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_TASK_SERVICE: return TASK_SERVICE;
      case INTERNAL_TASK_RECEIVE: return TASK_RECEIVE;
      case INTERNAL_TASK_MANUAL: return TASK_MANUAL;
      case INTERNAL_TASK_REFERENCE: return TASK_REFERENCE;
      case INTERNAL_TASK_SCRIPT: return TASK_SCRIPT;
      case INTERNAL_TASK_SEND: return TASK_SEND;
      case INTERNAL_TASK_USER: return TASK_USER;
      case INTERNAL_TASK_APPLICATION: return TASK_APPLICATION;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getTaskService() <em>Task Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskService()
   * @generated
   * @ordered
   */
  
  protected TaskService taskService = null;
  
  /**
   * This is true if the Task Service containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskService_set_ = false;

  /**
   * The cached value of the '{@link #getTaskReceive() <em>Task Receive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskReceive()
   * @generated
   * @ordered
   */
  
  protected TaskReceive taskReceive = null;
  
  /**
   * This is true if the Task Receive containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskReceive_set_ = false;

  /**
   * The cached value of the '{@link #getTaskManual() <em>Task Manual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskManual()
   * @generated
   * @ordered
   */
  
  protected TaskManual taskManual = null;
  
  /**
   * This is true if the Task Manual containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskManual_set_ = false;

  /**
   * The cached value of the '{@link #getTaskReference() <em>Task Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskReference()
   * @generated
   * @ordered
   */
  
  protected TaskReference taskReference = null;
  
  /**
   * This is true if the Task Reference containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskReference_set_ = false;

  /**
   * The cached value of the '{@link #getTaskScript() <em>Task Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskScript()
   * @generated
   * @ordered
   */
  
  protected TaskScript taskScript = null;
  
  /**
   * This is true if the Task Script containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskScript_set_ = false;

  /**
   * The cached value of the '{@link #getTaskSend() <em>Task Send</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskSend()
   * @generated
   * @ordered
   */
  
  protected TaskSend taskSend = null;
  
  /**
   * This is true if the Task Send containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskSend_set_ = false;

  /**
   * The cached value of the '{@link #getTaskUser() <em>Task User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskUser()
   * @generated
   * @ordered
   */
  
  protected TaskUser taskUser = null;
  
  /**
   * This is true if the Task User containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskUser_set_ = false;

  /**
   * The cached value of the '{@link #getTaskApplication() <em>Task Application</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskApplication()
   * @generated
   * @ordered
   */
  
  protected TaskApplication taskApplication = null;
  
  /**
   * This is true if the Task Application containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean taskApplication_set_ = false;

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
  public TaskImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getTask();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskService getTaskService()
  {
    return taskService;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskService(TaskService newTaskService, ChangeContext changeContext)
  {
    TaskService oldTaskService = taskService;
    taskService = newTaskService;
    boolean oldTaskService_set_ = taskService_set_;
    taskService_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_SERVICE, oldTaskService, newTaskService, !oldTaskService_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskService(TaskService newTaskService)
  {
    if (newTaskService != taskService)
    {
      ChangeContext changeContext = null;
      if (taskService != null)
        changeContext = inverseRemove(taskService, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_SERVICE, null, changeContext);
      if (newTaskService != null)
        changeContext = inverseAdd(newTaskService, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_SERVICE, null, changeContext);
      changeContext = basicSetTaskService(newTaskService, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskService_set_ = taskService_set_;
      taskService_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_SERVICE, newTaskService, newTaskService, !oldTaskService_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskService(ChangeContext changeContext)
  {
    TaskService oldTaskService = taskService;
    taskService = null;
    boolean oldTaskService_set_ = taskService_set_;
    taskService_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_SERVICE, oldTaskService, null, !oldTaskService_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskService()
  {
    if (taskService != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskService, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_SERVICE, null, changeContext);
      changeContext = basicUnsetTaskService(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskService_set_ = taskService_set_;
      taskService_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_SERVICE, null, null, oldTaskService_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskService()
  {
    return taskService_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskReceive getTaskReceive()
  {
    return taskReceive;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskReceive(TaskReceive newTaskReceive, ChangeContext changeContext)
  {
    TaskReceive oldTaskReceive = taskReceive;
    taskReceive = newTaskReceive;
    boolean oldTaskReceive_set_ = taskReceive_set_;
    taskReceive_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_RECEIVE, oldTaskReceive, newTaskReceive, !oldTaskReceive_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskReceive(TaskReceive newTaskReceive)
  {
    if (newTaskReceive != taskReceive)
    {
      ChangeContext changeContext = null;
      if (taskReceive != null)
        changeContext = inverseRemove(taskReceive, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_RECEIVE, null, changeContext);
      if (newTaskReceive != null)
        changeContext = inverseAdd(newTaskReceive, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_RECEIVE, null, changeContext);
      changeContext = basicSetTaskReceive(newTaskReceive, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskReceive_set_ = taskReceive_set_;
      taskReceive_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_RECEIVE, newTaskReceive, newTaskReceive, !oldTaskReceive_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskReceive(ChangeContext changeContext)
  {
    TaskReceive oldTaskReceive = taskReceive;
    taskReceive = null;
    boolean oldTaskReceive_set_ = taskReceive_set_;
    taskReceive_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_RECEIVE, oldTaskReceive, null, !oldTaskReceive_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskReceive()
  {
    if (taskReceive != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskReceive, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_RECEIVE, null, changeContext);
      changeContext = basicUnsetTaskReceive(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskReceive_set_ = taskReceive_set_;
      taskReceive_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_RECEIVE, null, null, oldTaskReceive_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskReceive()
  {
    return taskReceive_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskManual getTaskManual()
  {
    return taskManual;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskManual(TaskManual newTaskManual, ChangeContext changeContext)
  {
    TaskManual oldTaskManual = taskManual;
    taskManual = newTaskManual;
    boolean oldTaskManual_set_ = taskManual_set_;
    taskManual_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_MANUAL, oldTaskManual, newTaskManual, !oldTaskManual_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskManual(TaskManual newTaskManual)
  {
    if (newTaskManual != taskManual)
    {
      ChangeContext changeContext = null;
      if (taskManual != null)
        changeContext = inverseRemove(taskManual, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_MANUAL, null, changeContext);
      if (newTaskManual != null)
        changeContext = inverseAdd(newTaskManual, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_MANUAL, null, changeContext);
      changeContext = basicSetTaskManual(newTaskManual, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskManual_set_ = taskManual_set_;
      taskManual_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_MANUAL, newTaskManual, newTaskManual, !oldTaskManual_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskManual(ChangeContext changeContext)
  {
    TaskManual oldTaskManual = taskManual;
    taskManual = null;
    boolean oldTaskManual_set_ = taskManual_set_;
    taskManual_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_MANUAL, oldTaskManual, null, !oldTaskManual_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskManual()
  {
    if (taskManual != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskManual, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_MANUAL, null, changeContext);
      changeContext = basicUnsetTaskManual(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskManual_set_ = taskManual_set_;
      taskManual_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_MANUAL, null, null, oldTaskManual_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskManual()
  {
    return taskManual_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskReference getTaskReference()
  {
    return taskReference;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskReference(TaskReference newTaskReference, ChangeContext changeContext)
  {
    TaskReference oldTaskReference = taskReference;
    taskReference = newTaskReference;
    boolean oldTaskReference_set_ = taskReference_set_;
    taskReference_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_REFERENCE, oldTaskReference, newTaskReference, !oldTaskReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskReference(TaskReference newTaskReference)
  {
    if (newTaskReference != taskReference)
    {
      ChangeContext changeContext = null;
      if (taskReference != null)
        changeContext = inverseRemove(taskReference, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_REFERENCE, null, changeContext);
      if (newTaskReference != null)
        changeContext = inverseAdd(newTaskReference, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_REFERENCE, null, changeContext);
      changeContext = basicSetTaskReference(newTaskReference, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskReference_set_ = taskReference_set_;
      taskReference_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_REFERENCE, newTaskReference, newTaskReference, !oldTaskReference_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskReference(ChangeContext changeContext)
  {
    TaskReference oldTaskReference = taskReference;
    taskReference = null;
    boolean oldTaskReference_set_ = taskReference_set_;
    taskReference_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_REFERENCE, oldTaskReference, null, !oldTaskReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskReference()
  {
    if (taskReference != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskReference, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_REFERENCE, null, changeContext);
      changeContext = basicUnsetTaskReference(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskReference_set_ = taskReference_set_;
      taskReference_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_REFERENCE, null, null, oldTaskReference_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskReference()
  {
    return taskReference_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskScript getTaskScript()
  {
    return taskScript;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskScript(TaskScript newTaskScript, ChangeContext changeContext)
  {
    TaskScript oldTaskScript = taskScript;
    taskScript = newTaskScript;
    boolean oldTaskScript_set_ = taskScript_set_;
    taskScript_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_SCRIPT, oldTaskScript, newTaskScript, !oldTaskScript_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskScript(TaskScript newTaskScript)
  {
    if (newTaskScript != taskScript)
    {
      ChangeContext changeContext = null;
      if (taskScript != null)
        changeContext = inverseRemove(taskScript, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_SCRIPT, null, changeContext);
      if (newTaskScript != null)
        changeContext = inverseAdd(newTaskScript, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_SCRIPT, null, changeContext);
      changeContext = basicSetTaskScript(newTaskScript, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskScript_set_ = taskScript_set_;
      taskScript_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_SCRIPT, newTaskScript, newTaskScript, !oldTaskScript_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskScript(ChangeContext changeContext)
  {
    TaskScript oldTaskScript = taskScript;
    taskScript = null;
    boolean oldTaskScript_set_ = taskScript_set_;
    taskScript_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_SCRIPT, oldTaskScript, null, !oldTaskScript_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskScript()
  {
    if (taskScript != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskScript, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_SCRIPT, null, changeContext);
      changeContext = basicUnsetTaskScript(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskScript_set_ = taskScript_set_;
      taskScript_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_SCRIPT, null, null, oldTaskScript_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskScript()
  {
    return taskScript_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskSend getTaskSend()
  {
    return taskSend;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskSend(TaskSend newTaskSend, ChangeContext changeContext)
  {
    TaskSend oldTaskSend = taskSend;
    taskSend = newTaskSend;
    boolean oldTaskSend_set_ = taskSend_set_;
    taskSend_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_SEND, oldTaskSend, newTaskSend, !oldTaskSend_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskSend(TaskSend newTaskSend)
  {
    if (newTaskSend != taskSend)
    {
      ChangeContext changeContext = null;
      if (taskSend != null)
        changeContext = inverseRemove(taskSend, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_SEND, null, changeContext);
      if (newTaskSend != null)
        changeContext = inverseAdd(newTaskSend, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_SEND, null, changeContext);
      changeContext = basicSetTaskSend(newTaskSend, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskSend_set_ = taskSend_set_;
      taskSend_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_SEND, newTaskSend, newTaskSend, !oldTaskSend_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskSend(ChangeContext changeContext)
  {
    TaskSend oldTaskSend = taskSend;
    taskSend = null;
    boolean oldTaskSend_set_ = taskSend_set_;
    taskSend_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_SEND, oldTaskSend, null, !oldTaskSend_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskSend()
  {
    if (taskSend != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskSend, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_SEND, null, changeContext);
      changeContext = basicUnsetTaskSend(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskSend_set_ = taskSend_set_;
      taskSend_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_SEND, null, null, oldTaskSend_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskSend()
  {
    return taskSend_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskUser getTaskUser()
  {
    return taskUser;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskUser(TaskUser newTaskUser, ChangeContext changeContext)
  {
    TaskUser oldTaskUser = taskUser;
    taskUser = newTaskUser;
    boolean oldTaskUser_set_ = taskUser_set_;
    taskUser_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_USER, oldTaskUser, newTaskUser, !oldTaskUser_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskUser(TaskUser newTaskUser)
  {
    if (newTaskUser != taskUser)
    {
      ChangeContext changeContext = null;
      if (taskUser != null)
        changeContext = inverseRemove(taskUser, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_USER, null, changeContext);
      if (newTaskUser != null)
        changeContext = inverseAdd(newTaskUser, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_USER, null, changeContext);
      changeContext = basicSetTaskUser(newTaskUser, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskUser_set_ = taskUser_set_;
      taskUser_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_USER, newTaskUser, newTaskUser, !oldTaskUser_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskUser(ChangeContext changeContext)
  {
    TaskUser oldTaskUser = taskUser;
    taskUser = null;
    boolean oldTaskUser_set_ = taskUser_set_;
    taskUser_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_USER, oldTaskUser, null, !oldTaskUser_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskUser()
  {
    if (taskUser != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskUser, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_USER, null, changeContext);
      changeContext = basicUnsetTaskUser(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskUser_set_ = taskUser_set_;
      taskUser_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_USER, null, null, oldTaskUser_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskUser()
  {
    return taskUser_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskApplication getTaskApplication()
  {
    return taskApplication;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTaskApplication(TaskApplication newTaskApplication, ChangeContext changeContext)
  {
    TaskApplication oldTaskApplication = taskApplication;
    taskApplication = newTaskApplication;
    boolean oldTaskApplication_set_ = taskApplication_set_;
    taskApplication_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TASK_APPLICATION, oldTaskApplication, newTaskApplication, !oldTaskApplication_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaskApplication(TaskApplication newTaskApplication)
  {
    if (newTaskApplication != taskApplication)
    {
      ChangeContext changeContext = null;
      if (taskApplication != null)
        changeContext = inverseRemove(taskApplication, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_APPLICATION, null, changeContext);
      if (newTaskApplication != null)
        changeContext = inverseAdd(newTaskApplication, this, OPPOSITE_FEATURE_BASE - INTERNAL_TASK_APPLICATION, null, changeContext);
      changeContext = basicSetTaskApplication(newTaskApplication, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTaskApplication_set_ = taskApplication_set_;
      taskApplication_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TASK_APPLICATION, newTaskApplication, newTaskApplication, !oldTaskApplication_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTaskApplication(ChangeContext changeContext)
  {
    TaskApplication oldTaskApplication = taskApplication;
    taskApplication = null;
    boolean oldTaskApplication_set_ = taskApplication_set_;
    taskApplication_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TASK_APPLICATION, oldTaskApplication, null, !oldTaskApplication_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTaskApplication()
  {
    if (taskApplication != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(taskApplication, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TASK_APPLICATION, null, changeContext);
      changeContext = basicUnsetTaskApplication(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTaskApplication_set_ = taskApplication_set_;
      taskApplication_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TASK_APPLICATION, null, null, oldTaskApplication_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTaskApplication()
  {
    return taskApplication_set_;
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
      case TASK_SERVICE:
        return basicUnsetTaskService(changeContext);
      case TASK_RECEIVE:
        return basicUnsetTaskReceive(changeContext);
      case TASK_MANUAL:
        return basicUnsetTaskManual(changeContext);
      case TASK_REFERENCE:
        return basicUnsetTaskReference(changeContext);
      case TASK_SCRIPT:
        return basicUnsetTaskScript(changeContext);
      case TASK_SEND:
        return basicUnsetTaskSend(changeContext);
      case TASK_USER:
        return basicUnsetTaskUser(changeContext);
      case TASK_APPLICATION:
        return basicUnsetTaskApplication(changeContext);
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
      case TASK_SERVICE:
        return getTaskService();
      case TASK_RECEIVE:
        return getTaskReceive();
      case TASK_MANUAL:
        return getTaskManual();
      case TASK_REFERENCE:
        return getTaskReference();
      case TASK_SCRIPT:
        return getTaskScript();
      case TASK_SEND:
        return getTaskSend();
      case TASK_USER:
        return getTaskUser();
      case TASK_APPLICATION:
        return getTaskApplication();
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
      case TASK_SERVICE:
        setTaskService((TaskService)newValue);
        return;
      case TASK_RECEIVE:
        setTaskReceive((TaskReceive)newValue);
        return;
      case TASK_MANUAL:
        setTaskManual((TaskManual)newValue);
        return;
      case TASK_REFERENCE:
        setTaskReference((TaskReference)newValue);
        return;
      case TASK_SCRIPT:
        setTaskScript((TaskScript)newValue);
        return;
      case TASK_SEND:
        setTaskSend((TaskSend)newValue);
        return;
      case TASK_USER:
        setTaskUser((TaskUser)newValue);
        return;
      case TASK_APPLICATION:
        setTaskApplication((TaskApplication)newValue);
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
      case TASK_SERVICE:
        unsetTaskService();
        return;
      case TASK_RECEIVE:
        unsetTaskReceive();
        return;
      case TASK_MANUAL:
        unsetTaskManual();
        return;
      case TASK_REFERENCE:
        unsetTaskReference();
        return;
      case TASK_SCRIPT:
        unsetTaskScript();
        return;
      case TASK_SEND:
        unsetTaskSend();
        return;
      case TASK_USER:
        unsetTaskUser();
        return;
      case TASK_APPLICATION:
        unsetTaskApplication();
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
      case TASK_SERVICE:
        return isSetTaskService();
      case TASK_RECEIVE:
        return isSetTaskReceive();
      case TASK_MANUAL:
        return isSetTaskManual();
      case TASK_REFERENCE:
        return isSetTaskReference();
      case TASK_SCRIPT:
        return isSetTaskScript();
      case TASK_SEND:
        return isSetTaskSend();
      case TASK_USER:
        return isSetTaskUser();
      case TASK_APPLICATION:
        return isSetTaskApplication();
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

} //TaskImpl
