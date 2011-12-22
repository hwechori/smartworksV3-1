/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubFlowImpl.java,v 1.1 2009/12/22 06:17:11 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.ActualParameters;
import net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SubFlowImpl#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SubFlowImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SubFlowImpl#getExecution <em>Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubFlowImpl extends DataObjectBase implements SubFlow
{

  public final static int ACTUAL_PARAMETERS = 0;

  public final static int ID = 1;

  public final static int EXECUTION = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Actual Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTUAL_PARAMETERS = 0;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 1;

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
      case INTERNAL_ACTUAL_PARAMETERS: return ACTUAL_PARAMETERS;
      case INTERNAL_ID: return ID;
      case INTERNAL_EXECUTION: return EXECUTION;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getActualParameters() <em>Actual Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActualParameters()
   * @generated
   * @ordered
   */
  
  protected ActualParameters actualParameters = null;
  
  /**
   * This is true if the Actual Parameters containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean actualParameters_set_ = false;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_DEFAULT_;

  /**
   * This is true if the Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean id_set_ = false;

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
  public SubFlowImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getSubFlow();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualParameters getActualParameters()
  {
    return actualParameters;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActualParameters(ActualParameters newActualParameters, ChangeContext changeContext)
  {
    ActualParameters oldActualParameters = actualParameters;
    actualParameters = newActualParameters;
    boolean oldActualParameters_set_ = actualParameters_set_;
    actualParameters_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTUAL_PARAMETERS, oldActualParameters, newActualParameters, !oldActualParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActualParameters(ActualParameters newActualParameters)
  {
    if (newActualParameters != actualParameters)
    {
      ChangeContext changeContext = null;
      if (actualParameters != null)
        changeContext = inverseRemove(actualParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL_PARAMETERS, null, changeContext);
      if (newActualParameters != null)
        changeContext = inverseAdd(newActualParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL_PARAMETERS, null, changeContext);
      changeContext = basicSetActualParameters(newActualParameters, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActualParameters_set_ = actualParameters_set_;
      actualParameters_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTUAL_PARAMETERS, newActualParameters, newActualParameters, !oldActualParameters_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActualParameters(ChangeContext changeContext)
  {
    ActualParameters oldActualParameters = actualParameters;
    actualParameters = null;
    boolean oldActualParameters_set_ = actualParameters_set_;
    actualParameters_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTUAL_PARAMETERS, oldActualParameters, null, !oldActualParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActualParameters()
  {
    if (actualParameters != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(actualParameters, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTUAL_PARAMETERS, null, changeContext);
      changeContext = basicUnsetActualParameters(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActualParameters_set_ = actualParameters_set_;
      actualParameters_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTUAL_PARAMETERS, null, null, oldActualParameters_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActualParameters()
  {
    return actualParameters_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    boolean oldId_set_ = id_set_;
    id_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ID, oldId, id, !oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetId()
  {
    String oldId = id;
    boolean oldId_set_ = id_set_;
    id = ID_DEFAULT_;
    id_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ID, oldId, ID_DEFAULT_, oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetId()
  {
    return id_set_;
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
      case ACTUAL_PARAMETERS:
        return basicUnsetActualParameters(changeContext);
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
      case ACTUAL_PARAMETERS:
        return getActualParameters();
      case ID:
        return getId();
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
      case ACTUAL_PARAMETERS:
        setActualParameters((ActualParameters)newValue);
        return;
      case ID:
        setId((String)newValue);
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
      case ACTUAL_PARAMETERS:
        unsetActualParameters();
        return;
      case ID:
        unsetId();
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
      case ACTUAL_PARAMETERS:
        return isSetActualParameters();
      case ID:
        return isSetId();
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
    result.append(" (Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Execution: ");
    if (execution_set_) result.append(execution); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //SubFlowImpl
