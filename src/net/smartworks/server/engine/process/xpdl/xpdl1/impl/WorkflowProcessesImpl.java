/**
 * <copyright>
 * </copyright>
 *
 * $Id: WorkflowProcessesImpl.java,v 1.1 2009/12/22 06:17:19 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import java.util.Collection;
import java.util.List;

import net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess;
import net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcesses;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow Processes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessesImpl#getWorkflowProcess <em>Workflow Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkflowProcessesImpl extends DataObjectBase implements WorkflowProcesses
{

  public final static int WORKFLOW_PROCESS = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Workflow Process</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WORKFLOW_PROCESS = 0;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 1;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_WORKFLOW_PROCESS: return WORKFLOW_PROCESS;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getWorkflowProcess() <em>Workflow Process</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorkflowProcess()
   * @generated
   * @ordered
   */
  
  protected List workflowProcess = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkflowProcessesImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getWorkflowProcesses();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getWorkflowProcess()
  {
    if (workflowProcess == null)
    {
      workflowProcess = createPropertyList(ListKind.CONTAINMENT, WorkflowProcess.class, WORKFLOW_PROCESS, 0);
    }
    return workflowProcess;
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
      case WORKFLOW_PROCESS:
        return removeFromList(getWorkflowProcess(), otherEnd, changeContext);
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
      case WORKFLOW_PROCESS:
        return getWorkflowProcess();
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
      case WORKFLOW_PROCESS:
        getWorkflowProcess().clear();
        getWorkflowProcess().addAll((Collection)newValue);
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
      case WORKFLOW_PROCESS:
        getWorkflowProcess().clear();
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
      case WORKFLOW_PROCESS:
        return workflowProcess != null && !workflowProcess.isEmpty();
    }
    return super.isSet(propertyIndex);
  }

} //WorkflowProcessesImpl
