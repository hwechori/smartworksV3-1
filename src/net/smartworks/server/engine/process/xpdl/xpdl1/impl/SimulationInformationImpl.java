/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimulationInformationImpl.java,v 1.1 2009/12/22 06:17:23 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.SimulationInformation;
import net.smartworks.server.engine.process.xpdl.xpdl1.TimeEstimation;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SimulationInformationImpl#getCost <em>Cost</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SimulationInformationImpl#getTimeEstimation <em>Time Estimation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SimulationInformationImpl#getInstantiation <em>Instantiation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationInformationImpl extends DataObjectBase implements SimulationInformation
{

  public final static int COST = 0;

  public final static int TIME_ESTIMATION = 1;

  public final static int INSTANTIATION = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Cost</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COST = 0;

  /**
   * The internal feature id for the '<em><b>Time Estimation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TIME_ESTIMATION = 1;

  /**
   * The internal feature id for the '<em><b>Instantiation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INSTANTIATION = 2;

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
      case INTERNAL_COST: return COST;
      case INTERNAL_TIME_ESTIMATION: return TIME_ESTIMATION;
      case INTERNAL_INSTANTIATION: return INSTANTIATION;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getCost() <em>Cost</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCost()
   * @generated
   * @ordered
   */
  protected static final String COST_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCost() <em>Cost</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCost()
   * @generated
   * @ordered
   */
  protected String cost = COST_DEFAULT_;

  /**
   * This is true if the Cost attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean cost_set_ = false;

  /**
   * The cached value of the '{@link #getTimeEstimation() <em>Time Estimation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeEstimation()
   * @generated
   * @ordered
   */
  
  protected TimeEstimation timeEstimation = null;
  
  /**
   * This is true if the Time Estimation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean timeEstimation_set_ = false;

  /**
   * The default value of the '{@link #getInstantiation() <em>Instantiation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstantiation()
   * @generated
   * @ordered
   */
  protected static final String INSTANTIATION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getInstantiation() <em>Instantiation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstantiation()
   * @generated
   * @ordered
   */
  protected String instantiation = INSTANTIATION_DEFAULT_;

  /**
   * This is true if the Instantiation attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean instantiation_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimulationInformationImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getSimulationInformation();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCost()
  {
    return cost;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCost(String newCost)
  {
    String oldCost = cost;
    cost = newCost;
    boolean oldCost_set_ = cost_set_;
    cost_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_COST, oldCost, cost, !oldCost_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCost()
  {
    String oldCost = cost;
    boolean oldCost_set_ = cost_set_;
    cost = COST_DEFAULT_;
    cost_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_COST, oldCost, COST_DEFAULT_, oldCost_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCost()
  {
    return cost_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeEstimation getTimeEstimation()
  {
    return timeEstimation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTimeEstimation(TimeEstimation newTimeEstimation, ChangeContext changeContext)
  {
    TimeEstimation oldTimeEstimation = timeEstimation;
    timeEstimation = newTimeEstimation;
    boolean oldTimeEstimation_set_ = timeEstimation_set_;
    timeEstimation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TIME_ESTIMATION, oldTimeEstimation, newTimeEstimation, !oldTimeEstimation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeEstimation(TimeEstimation newTimeEstimation)
  {
    if (newTimeEstimation != timeEstimation)
    {
      ChangeContext changeContext = null;
      if (timeEstimation != null)
        changeContext = inverseRemove(timeEstimation, this, OPPOSITE_FEATURE_BASE - INTERNAL_TIME_ESTIMATION, null, changeContext);
      if (newTimeEstimation != null)
        changeContext = inverseAdd(newTimeEstimation, this, OPPOSITE_FEATURE_BASE - INTERNAL_TIME_ESTIMATION, null, changeContext);
      changeContext = basicSetTimeEstimation(newTimeEstimation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTimeEstimation_set_ = timeEstimation_set_;
      timeEstimation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TIME_ESTIMATION, newTimeEstimation, newTimeEstimation, !oldTimeEstimation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTimeEstimation(ChangeContext changeContext)
  {
    TimeEstimation oldTimeEstimation = timeEstimation;
    timeEstimation = null;
    boolean oldTimeEstimation_set_ = timeEstimation_set_;
    timeEstimation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TIME_ESTIMATION, oldTimeEstimation, null, !oldTimeEstimation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTimeEstimation()
  {
    if (timeEstimation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(timeEstimation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TIME_ESTIMATION, null, changeContext);
      changeContext = basicUnsetTimeEstimation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTimeEstimation_set_ = timeEstimation_set_;
      timeEstimation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TIME_ESTIMATION, null, null, oldTimeEstimation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTimeEstimation()
  {
    return timeEstimation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInstantiation()
  {
    return instantiation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstantiation(String newInstantiation)
  {
    String oldInstantiation = instantiation;
    instantiation = newInstantiation;
    boolean oldInstantiation_set_ = instantiation_set_;
    instantiation_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_INSTANTIATION, oldInstantiation, instantiation, !oldInstantiation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetInstantiation()
  {
    String oldInstantiation = instantiation;
    boolean oldInstantiation_set_ = instantiation_set_;
    instantiation = INSTANTIATION_DEFAULT_;
    instantiation_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_INSTANTIATION, oldInstantiation, INSTANTIATION_DEFAULT_, oldInstantiation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetInstantiation()
  {
    return instantiation_set_;
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
      case TIME_ESTIMATION:
        return basicUnsetTimeEstimation(changeContext);
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
      case COST:
        return getCost();
      case TIME_ESTIMATION:
        return getTimeEstimation();
      case INSTANTIATION:
        return getInstantiation();
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
      case COST:
        setCost((String)newValue);
        return;
      case TIME_ESTIMATION:
        setTimeEstimation((TimeEstimation)newValue);
        return;
      case INSTANTIATION:
        setInstantiation((String)newValue);
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
      case COST:
        unsetCost();
        return;
      case TIME_ESTIMATION:
        unsetTimeEstimation();
        return;
      case INSTANTIATION:
        unsetInstantiation();
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
      case COST:
        return isSetCost();
      case TIME_ESTIMATION:
        return isSetTimeEstimation();
      case INSTANTIATION:
        return isSetInstantiation();
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
    result.append(" (Cost: ");
    if (cost_set_) result.append(cost); else result.append("<unset>");
    result.append(", Instantiation: ");
    if (instantiation_set_) result.append(instantiation); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //SimulationInformationImpl
