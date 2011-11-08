/**
 * <copyright>
 * </copyright>
 *
 * $Id: ImplementationImpl.java,v 1.1 2009/12/22 06:17:18 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Implementation;
import net.smartworks.server.engine.process.xpdl.xpdl1.No;
import net.smartworks.server.engine.process.xpdl.xpdl1.SubFlow;
import net.smartworks.server.engine.process.xpdl.xpdl1.Tool;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ImplementationImpl#getNo <em>No</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ImplementationImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ImplementationImpl#getSubFlow <em>Sub Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationImpl extends DataObjectBase implements Implementation
{

  public final static int NO = 0;

  public final static int TOOL = 1;

  public final static int SUB_FLOW = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


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
   * The internal feature id for the '<em><b>Sub Flow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SUB_FLOW = 2;

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
      case INTERNAL_NO: return NO;
      case INTERNAL_TOOL: return TOOL;
      case INTERNAL_SUB_FLOW: return SUB_FLOW;
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementationImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getImplementation();
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
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case NO:
        return basicUnsetNo(changeContext);
      case TOOL:
        return removeFromList(getTool(), otherEnd, changeContext);
      case SUB_FLOW:
        return basicUnsetSubFlow(changeContext);
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
      case SUB_FLOW:
        return getSubFlow();
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
      case SUB_FLOW:
        setSubFlow((SubFlow)newValue);
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
      case SUB_FLOW:
        unsetSubFlow();
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
      case SUB_FLOW:
        return isSetSubFlow();
    }
    return super.isSet(propertyIndex);
  }

} //ImplementationImpl
