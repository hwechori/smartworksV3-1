/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivityImpl.java,v 1.1 2009/12/22 06:17:21 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity;
import net.smartworks.server.engine.process.xpdl.xpdl1.Deadline;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.FinishMode;
import net.smartworks.server.engine.process.xpdl.xpdl1.Implementation;
import net.smartworks.server.engine.process.xpdl.xpdl1.Route;
import net.smartworks.server.engine.process.xpdl.xpdl1.SimulationInformation;
import net.smartworks.server.engine.process.xpdl.xpdl1.StartMode;
import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestrictions;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getLimit <em>Limit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getBlockActivity <em>Block Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getPerformer <em>Performer</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getStartMode <em>Start Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getFinishMode <em>Finish Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getSimulationInformation <em>Simulation Information</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getTransitionRestrictions <em>Transition Restrictions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActivityImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends DataObjectBase implements Activity
{

  public final static int DESCRIPTION = 0;

  public final static int LIMIT = 1;

  public final static int ROUTE = 2;

  public final static int IMPLEMENTATION = 3;

  public final static int BLOCK_ACTIVITY = 4;

  public final static int PERFORMER = 5;

  public final static int START_MODE = 6;

  public final static int FINISH_MODE = 7;

  public final static int PRIORITY = 8;

  public final static int DEADLINE = 9;

  public final static int SIMULATION_INFORMATION = 10;

  public final static int ICON = 11;

  public final static int DOCUMENTATION = 12;

  public final static int TRANSITION_RESTRICTIONS = 13;

  public final static int EXTENDED_ATTRIBUTES = 14;

  public final static int ID = 15;

  public final static int NAME = 16;

  public final static int SDO_PROPERTY_COUNT = 17;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 0;

  /**
   * The internal feature id for the '<em><b>Limit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LIMIT = 1;

  /**
   * The internal feature id for the '<em><b>Route</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ROUTE = 2;

  /**
   * The internal feature id for the '<em><b>Implementation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IMPLEMENTATION = 3;

  /**
   * The internal feature id for the '<em><b>Block Activity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BLOCK_ACTIVITY = 4;

  /**
   * The internal feature id for the '<em><b>Performer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PERFORMER = 5;

  /**
   * The internal feature id for the '<em><b>Start Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_START_MODE = 6;

  /**
   * The internal feature id for the '<em><b>Finish Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FINISH_MODE = 7;

  /**
   * The internal feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRIORITY = 8;

  /**
   * The internal feature id for the '<em><b>Deadline</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEADLINE = 9;

  /**
   * The internal feature id for the '<em><b>Simulation Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SIMULATION_INFORMATION = 10;

  /**
   * The internal feature id for the '<em><b>Icon</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ICON = 11;

  /**
   * The internal feature id for the '<em><b>Documentation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DOCUMENTATION = 12;

  /**
   * The internal feature id for the '<em><b>Transition Restrictions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITION_RESTRICTIONS = 13;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 14;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 15;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 16;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 17;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_LIMIT: return LIMIT;
      case INTERNAL_ROUTE: return ROUTE;
      case INTERNAL_IMPLEMENTATION: return IMPLEMENTATION;
      case INTERNAL_BLOCK_ACTIVITY: return BLOCK_ACTIVITY;
      case INTERNAL_PERFORMER: return PERFORMER;
      case INTERNAL_START_MODE: return START_MODE;
      case INTERNAL_FINISH_MODE: return FINISH_MODE;
      case INTERNAL_PRIORITY: return PRIORITY;
      case INTERNAL_DEADLINE: return DEADLINE;
      case INTERNAL_SIMULATION_INFORMATION: return SIMULATION_INFORMATION;
      case INTERNAL_ICON: return ICON;
      case INTERNAL_DOCUMENTATION: return DOCUMENTATION;
      case INTERNAL_TRANSITION_RESTRICTIONS: return TRANSITION_RESTRICTIONS;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_DEFAULT_;

  /**
   * This is true if the Description attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean description_set_ = false;

  /**
   * The default value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected static final String LIMIT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected String limit = LIMIT_DEFAULT_;

  /**
   * This is true if the Limit attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean limit_set_ = false;

  /**
   * The cached value of the '{@link #getRoute() <em>Route</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoute()
   * @generated
   * @ordered
   */
  
  protected Route route = null;
  
  /**
   * This is true if the Route containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean route_set_ = false;

  /**
   * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementation()
   * @generated
   * @ordered
   */
  
  protected Implementation implementation = null;
  
  /**
   * This is true if the Implementation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean implementation_set_ = false;

  /**
   * The cached value of the '{@link #getBlockActivity() <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockActivity()
   * @generated
   * @ordered
   */
  
  protected BlockActivity blockActivity = null;
  
  /**
   * This is true if the Block Activity containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean blockActivity_set_ = false;

  /**
   * The default value of the '{@link #getPerformer() <em>Performer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPerformer()
   * @generated
   * @ordered
   */
  protected static final String PERFORMER_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPerformer() <em>Performer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPerformer()
   * @generated
   * @ordered
   */
  protected String performer = PERFORMER_DEFAULT_;

  /**
   * This is true if the Performer attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean performer_set_ = false;

  /**
   * The cached value of the '{@link #getStartMode() <em>Start Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartMode()
   * @generated
   * @ordered
   */
  
  protected StartMode startMode = null;
  
  /**
   * This is true if the Start Mode containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean startMode_set_ = false;

  /**
   * The cached value of the '{@link #getFinishMode() <em>Finish Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinishMode()
   * @generated
   * @ordered
   */
  
  protected FinishMode finishMode = null;
  
  /**
   * This is true if the Finish Mode containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean finishMode_set_ = false;

  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final String PRIORITY_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected String priority = PRIORITY_DEFAULT_;

  /**
   * This is true if the Priority attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean priority_set_ = false;

  /**
   * The cached value of the '{@link #getDeadline() <em>Deadline</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeadline()
   * @generated
   * @ordered
   */
  
  protected List deadline = null;
  
  /**
   * The cached value of the '{@link #getSimulationInformation() <em>Simulation Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimulationInformation()
   * @generated
   * @ordered
   */
  
  protected SimulationInformation simulationInformation = null;
  
  /**
   * This is true if the Simulation Information containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean simulationInformation_set_ = false;

  /**
   * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIcon()
   * @generated
   * @ordered
   */
  protected static final String ICON_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIcon()
   * @generated
   * @ordered
   */
  protected String icon = ICON_DEFAULT_;

  /**
   * This is true if the Icon attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean icon_set_ = false;

  /**
   * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected static final String DOCUMENTATION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected String documentation = DOCUMENTATION_DEFAULT_;

  /**
   * This is true if the Documentation attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean documentation_set_ = false;

  /**
   * The cached value of the '{@link #getTransitionRestrictions() <em>Transition Restrictions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionRestrictions()
   * @generated
   * @ordered
   */
  
  protected TransitionRestrictions transitionRestrictions = null;
  
  /**
   * This is true if the Transition Restrictions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transitionRestrictions_set_ = false;

  /**
   * The cached value of the '{@link #getExtendedAttributes() <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendedAttributes()
   * @generated
   * @ordered
   */
  
  protected ExtendedAttributes extendedAttributes = null;
  
  /**
   * This is true if the Extended Attributes containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extendedAttributes_set_ = false;

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
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_DEFAULT_;

  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean name_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getActivity();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    boolean oldDescription_set_ = description_set_;
    description_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DESCRIPTION, oldDescription, description, !oldDescription_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDescription()
  {
    String oldDescription = description;
    boolean oldDescription_set_ = description_set_;
    description = DESCRIPTION_DEFAULT_;
    description_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DESCRIPTION, oldDescription, DESCRIPTION_DEFAULT_, oldDescription_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDescription()
  {
    return description_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLimit()
  {
    return limit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimit(String newLimit)
  {
    String oldLimit = limit;
    limit = newLimit;
    boolean oldLimit_set_ = limit_set_;
    limit_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LIMIT, oldLimit, limit, !oldLimit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLimit()
  {
    String oldLimit = limit;
    boolean oldLimit_set_ = limit_set_;
    limit = LIMIT_DEFAULT_;
    limit_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LIMIT, oldLimit, LIMIT_DEFAULT_, oldLimit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLimit()
  {
    return limit_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Route getRoute()
  {
    return route;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetRoute(Route newRoute, ChangeContext changeContext)
  {
    Route oldRoute = route;
    route = newRoute;
    boolean oldRoute_set_ = route_set_;
    route_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ROUTE, oldRoute, newRoute, !oldRoute_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoute(Route newRoute)
  {
    if (newRoute != route)
    {
      ChangeContext changeContext = null;
      if (route != null)
        changeContext = inverseRemove(route, this, OPPOSITE_FEATURE_BASE - INTERNAL_ROUTE, null, changeContext);
      if (newRoute != null)
        changeContext = inverseAdd(newRoute, this, OPPOSITE_FEATURE_BASE - INTERNAL_ROUTE, null, changeContext);
      changeContext = basicSetRoute(newRoute, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldRoute_set_ = route_set_;
      route_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ROUTE, newRoute, newRoute, !oldRoute_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetRoute(ChangeContext changeContext)
  {
    Route oldRoute = route;
    route = null;
    boolean oldRoute_set_ = route_set_;
    route_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ROUTE, oldRoute, null, !oldRoute_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRoute()
  {
    if (route != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(route, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ROUTE, null, changeContext);
      changeContext = basicUnsetRoute(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldRoute_set_ = route_set_;
      route_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ROUTE, null, null, oldRoute_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRoute()
  {
    return route_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Implementation getImplementation()
  {
    return implementation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetImplementation(Implementation newImplementation, ChangeContext changeContext)
  {
    Implementation oldImplementation = implementation;
    implementation = newImplementation;
    boolean oldImplementation_set_ = implementation_set_;
    implementation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_IMPLEMENTATION, oldImplementation, newImplementation, !oldImplementation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImplementation(Implementation newImplementation)
  {
    if (newImplementation != implementation)
    {
      ChangeContext changeContext = null;
      if (implementation != null)
        changeContext = inverseRemove(implementation, this, OPPOSITE_FEATURE_BASE - INTERNAL_IMPLEMENTATION, null, changeContext);
      if (newImplementation != null)
        changeContext = inverseAdd(newImplementation, this, OPPOSITE_FEATURE_BASE - INTERNAL_IMPLEMENTATION, null, changeContext);
      changeContext = basicSetImplementation(newImplementation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldImplementation_set_ = implementation_set_;
      implementation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_IMPLEMENTATION, newImplementation, newImplementation, !oldImplementation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetImplementation(ChangeContext changeContext)
  {
    Implementation oldImplementation = implementation;
    implementation = null;
    boolean oldImplementation_set_ = implementation_set_;
    implementation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_IMPLEMENTATION, oldImplementation, null, !oldImplementation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetImplementation()
  {
    if (implementation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(implementation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_IMPLEMENTATION, null, changeContext);
      changeContext = basicUnsetImplementation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldImplementation_set_ = implementation_set_;
      implementation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_IMPLEMENTATION, null, null, oldImplementation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetImplementation()
  {
    return implementation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockActivity getBlockActivity()
  {
    return blockActivity;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetBlockActivity(BlockActivity newBlockActivity, ChangeContext changeContext)
  {
    BlockActivity oldBlockActivity = blockActivity;
    blockActivity = newBlockActivity;
    boolean oldBlockActivity_set_ = blockActivity_set_;
    blockActivity_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY, oldBlockActivity, newBlockActivity, !oldBlockActivity_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlockActivity(BlockActivity newBlockActivity)
  {
    if (newBlockActivity != blockActivity)
    {
      ChangeContext changeContext = null;
      if (blockActivity != null)
        changeContext = inverseRemove(blockActivity, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      if (newBlockActivity != null)
        changeContext = inverseAdd(newBlockActivity, this, OPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      changeContext = basicSetBlockActivity(newBlockActivity, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldBlockActivity_set_ = blockActivity_set_;
      blockActivity_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_BLOCK_ACTIVITY, newBlockActivity, newBlockActivity, !oldBlockActivity_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetBlockActivity(ChangeContext changeContext)
  {
    BlockActivity oldBlockActivity = blockActivity;
    blockActivity = null;
    boolean oldBlockActivity_set_ = blockActivity_set_;
    blockActivity_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY, oldBlockActivity, null, !oldBlockActivity_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBlockActivity()
  {
    if (blockActivity != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(blockActivity, this, EOPPOSITE_FEATURE_BASE - INTERNAL_BLOCK_ACTIVITY, null, changeContext);
      changeContext = basicUnsetBlockActivity(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldBlockActivity_set_ = blockActivity_set_;
      blockActivity_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_BLOCK_ACTIVITY, null, null, oldBlockActivity_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBlockActivity()
  {
    return blockActivity_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPerformer()
  {
    return performer;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPerformer(String newPerformer)
  {
    String oldPerformer = performer;
    performer = newPerformer;
    boolean oldPerformer_set_ = performer_set_;
    performer_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PERFORMER, oldPerformer, performer, !oldPerformer_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPerformer()
  {
    String oldPerformer = performer;
    boolean oldPerformer_set_ = performer_set_;
    performer = PERFORMER_DEFAULT_;
    performer_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PERFORMER, oldPerformer, PERFORMER_DEFAULT_, oldPerformer_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPerformer()
  {
    return performer_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StartMode getStartMode()
  {
    return startMode;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetStartMode(StartMode newStartMode, ChangeContext changeContext)
  {
    StartMode oldStartMode = startMode;
    startMode = newStartMode;
    boolean oldStartMode_set_ = startMode_set_;
    startMode_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_START_MODE, oldStartMode, newStartMode, !oldStartMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartMode(StartMode newStartMode)
  {
    if (newStartMode != startMode)
    {
      ChangeContext changeContext = null;
      if (startMode != null)
        changeContext = inverseRemove(startMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_START_MODE, null, changeContext);
      if (newStartMode != null)
        changeContext = inverseAdd(newStartMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_START_MODE, null, changeContext);
      changeContext = basicSetStartMode(newStartMode, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldStartMode_set_ = startMode_set_;
      startMode_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_START_MODE, newStartMode, newStartMode, !oldStartMode_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetStartMode(ChangeContext changeContext)
  {
    StartMode oldStartMode = startMode;
    startMode = null;
    boolean oldStartMode_set_ = startMode_set_;
    startMode_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_START_MODE, oldStartMode, null, !oldStartMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStartMode()
  {
    if (startMode != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(startMode, this, EOPPOSITE_FEATURE_BASE - INTERNAL_START_MODE, null, changeContext);
      changeContext = basicUnsetStartMode(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldStartMode_set_ = startMode_set_;
      startMode_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_START_MODE, null, null, oldStartMode_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStartMode()
  {
    return startMode_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinishMode getFinishMode()
  {
    return finishMode;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetFinishMode(FinishMode newFinishMode, ChangeContext changeContext)
  {
    FinishMode oldFinishMode = finishMode;
    finishMode = newFinishMode;
    boolean oldFinishMode_set_ = finishMode_set_;
    finishMode_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_FINISH_MODE, oldFinishMode, newFinishMode, !oldFinishMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinishMode(FinishMode newFinishMode)
  {
    if (newFinishMode != finishMode)
    {
      ChangeContext changeContext = null;
      if (finishMode != null)
        changeContext = inverseRemove(finishMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_FINISH_MODE, null, changeContext);
      if (newFinishMode != null)
        changeContext = inverseAdd(newFinishMode, this, OPPOSITE_FEATURE_BASE - INTERNAL_FINISH_MODE, null, changeContext);
      changeContext = basicSetFinishMode(newFinishMode, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldFinishMode_set_ = finishMode_set_;
      finishMode_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_FINISH_MODE, newFinishMode, newFinishMode, !oldFinishMode_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetFinishMode(ChangeContext changeContext)
  {
    FinishMode oldFinishMode = finishMode;
    finishMode = null;
    boolean oldFinishMode_set_ = finishMode_set_;
    finishMode_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_FINISH_MODE, oldFinishMode, null, !oldFinishMode_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFinishMode()
  {
    if (finishMode != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(finishMode, this, EOPPOSITE_FEATURE_BASE - INTERNAL_FINISH_MODE, null, changeContext);
      changeContext = basicUnsetFinishMode(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldFinishMode_set_ = finishMode_set_;
      finishMode_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_FINISH_MODE, null, null, oldFinishMode_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFinishMode()
  {
    return finishMode_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPriority()
  {
    return priority;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(String newPriority)
  {
    String oldPriority = priority;
    priority = newPriority;
    boolean oldPriority_set_ = priority_set_;
    priority_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PRIORITY, oldPriority, priority, !oldPriority_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPriority()
  {
    String oldPriority = priority;
    boolean oldPriority_set_ = priority_set_;
    priority = PRIORITY_DEFAULT_;
    priority_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PRIORITY, oldPriority, PRIORITY_DEFAULT_, oldPriority_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPriority()
  {
    return priority_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getDeadline()
  {
    if (deadline == null)
    {
      deadline = createPropertyList(ListKind.CONTAINMENT, Deadline.class, DEADLINE, 0);
    }
    return deadline;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimulationInformation getSimulationInformation()
  {
    return simulationInformation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetSimulationInformation(SimulationInformation newSimulationInformation, ChangeContext changeContext)
  {
    SimulationInformation oldSimulationInformation = simulationInformation;
    simulationInformation = newSimulationInformation;
    boolean oldSimulationInformation_set_ = simulationInformation_set_;
    simulationInformation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SIMULATION_INFORMATION, oldSimulationInformation, newSimulationInformation, !oldSimulationInformation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSimulationInformation(SimulationInformation newSimulationInformation)
  {
    if (newSimulationInformation != simulationInformation)
    {
      ChangeContext changeContext = null;
      if (simulationInformation != null)
        changeContext = inverseRemove(simulationInformation, this, OPPOSITE_FEATURE_BASE - INTERNAL_SIMULATION_INFORMATION, null, changeContext);
      if (newSimulationInformation != null)
        changeContext = inverseAdd(newSimulationInformation, this, OPPOSITE_FEATURE_BASE - INTERNAL_SIMULATION_INFORMATION, null, changeContext);
      changeContext = basicSetSimulationInformation(newSimulationInformation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldSimulationInformation_set_ = simulationInformation_set_;
      simulationInformation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SIMULATION_INFORMATION, newSimulationInformation, newSimulationInformation, !oldSimulationInformation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetSimulationInformation(ChangeContext changeContext)
  {
    SimulationInformation oldSimulationInformation = simulationInformation;
    simulationInformation = null;
    boolean oldSimulationInformation_set_ = simulationInformation_set_;
    simulationInformation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SIMULATION_INFORMATION, oldSimulationInformation, null, !oldSimulationInformation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSimulationInformation()
  {
    if (simulationInformation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(simulationInformation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SIMULATION_INFORMATION, null, changeContext);
      changeContext = basicUnsetSimulationInformation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldSimulationInformation_set_ = simulationInformation_set_;
      simulationInformation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SIMULATION_INFORMATION, null, null, oldSimulationInformation_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSimulationInformation()
  {
    return simulationInformation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIcon()
  {
    return icon;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIcon(String newIcon)
  {
    String oldIcon = icon;
    icon = newIcon;
    boolean oldIcon_set_ = icon_set_;
    icon_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ICON, oldIcon, icon, !oldIcon_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIcon()
  {
    String oldIcon = icon;
    boolean oldIcon_set_ = icon_set_;
    icon = ICON_DEFAULT_;
    icon_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ICON, oldIcon, ICON_DEFAULT_, oldIcon_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIcon()
  {
    return icon_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDocumentation()
  {
    return documentation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocumentation(String newDocumentation)
  {
    String oldDocumentation = documentation;
    documentation = newDocumentation;
    boolean oldDocumentation_set_ = documentation_set_;
    documentation_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DOCUMENTATION, oldDocumentation, documentation, !oldDocumentation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDocumentation()
  {
    String oldDocumentation = documentation;
    boolean oldDocumentation_set_ = documentation_set_;
    documentation = DOCUMENTATION_DEFAULT_;
    documentation_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DOCUMENTATION, oldDocumentation, DOCUMENTATION_DEFAULT_, oldDocumentation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDocumentation()
  {
    return documentation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRestrictions getTransitionRestrictions()
  {
    return transitionRestrictions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransitionRestrictions(TransitionRestrictions newTransitionRestrictions, ChangeContext changeContext)
  {
    TransitionRestrictions oldTransitionRestrictions = transitionRestrictions;
    transitionRestrictions = newTransitionRestrictions;
    boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
    transitionRestrictions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSITION_RESTRICTIONS, oldTransitionRestrictions, newTransitionRestrictions, !oldTransitionRestrictions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitionRestrictions(TransitionRestrictions newTransitionRestrictions)
  {
    if (newTransitionRestrictions != transitionRestrictions)
    {
      ChangeContext changeContext = null;
      if (transitionRestrictions != null)
        changeContext = inverseRemove(transitionRestrictions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_RESTRICTIONS, null, changeContext);
      if (newTransitionRestrictions != null)
        changeContext = inverseAdd(newTransitionRestrictions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_RESTRICTIONS, null, changeContext);
      changeContext = basicSetTransitionRestrictions(newTransitionRestrictions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
      transitionRestrictions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSITION_RESTRICTIONS, newTransitionRestrictions, newTransitionRestrictions, !oldTransitionRestrictions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransitionRestrictions(ChangeContext changeContext)
  {
    TransitionRestrictions oldTransitionRestrictions = transitionRestrictions;
    transitionRestrictions = null;
    boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
    transitionRestrictions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSITION_RESTRICTIONS, oldTransitionRestrictions, null, !oldTransitionRestrictions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransitionRestrictions()
  {
    if (transitionRestrictions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transitionRestrictions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_RESTRICTIONS, null, changeContext);
      changeContext = basicUnsetTransitionRestrictions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransitionRestrictions_set_ = transitionRestrictions_set_;
      transitionRestrictions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSITION_RESTRICTIONS, null, null, oldTransitionRestrictions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransitionRestrictions()
  {
    return transitionRestrictions_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedAttributes getExtendedAttributes()
  {
    return extendedAttributes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExtendedAttributes(ExtendedAttributes newExtendedAttributes, ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = newExtendedAttributes;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendedAttributes(ExtendedAttributes newExtendedAttributes)
  {
    if (newExtendedAttributes != extendedAttributes)
    {
      ChangeContext changeContext = null;
      if (extendedAttributes != null)
        changeContext = inverseRemove(extendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      if (newExtendedAttributes != null)
        changeContext = inverseAdd(newExtendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicSetExtendedAttributes(newExtendedAttributes, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, newExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExtendedAttributes(ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = null;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, null, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtendedAttributes()
  {
    if (extendedAttributes != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(extendedAttributes, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicUnsetExtendedAttributes(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, null, null, oldExtendedAttributes_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtendedAttributes()
  {
    return extendedAttributes_set_;
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
  public String getName()
  {
    return name;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    boolean oldName_set_ = name_set_;
    name_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAME, oldName, name, !oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetName()
  {
    String oldName = name;
    boolean oldName_set_ = name_set_;
    name = NAME_DEFAULT_;
    name_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAME, oldName, NAME_DEFAULT_, oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetName()
  {
    return name_set_;
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
      case ROUTE:
        return basicUnsetRoute(changeContext);
      case IMPLEMENTATION:
        return basicUnsetImplementation(changeContext);
      case BLOCK_ACTIVITY:
        return basicUnsetBlockActivity(changeContext);
      case START_MODE:
        return basicUnsetStartMode(changeContext);
      case FINISH_MODE:
        return basicUnsetFinishMode(changeContext);
      case DEADLINE:
        return removeFromList(getDeadline(), otherEnd, changeContext);
      case SIMULATION_INFORMATION:
        return basicUnsetSimulationInformation(changeContext);
      case TRANSITION_RESTRICTIONS:
        return basicUnsetTransitionRestrictions(changeContext);
      case EXTENDED_ATTRIBUTES:
        return basicUnsetExtendedAttributes(changeContext);
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
      case DESCRIPTION:
        return getDescription();
      case LIMIT:
        return getLimit();
      case ROUTE:
        return getRoute();
      case IMPLEMENTATION:
        return getImplementation();
      case BLOCK_ACTIVITY:
        return getBlockActivity();
      case PERFORMER:
        return getPerformer();
      case START_MODE:
        return getStartMode();
      case FINISH_MODE:
        return getFinishMode();
      case PRIORITY:
        return getPriority();
      case DEADLINE:
        return getDeadline();
      case SIMULATION_INFORMATION:
        return getSimulationInformation();
      case ICON:
        return getIcon();
      case DOCUMENTATION:
        return getDocumentation();
      case TRANSITION_RESTRICTIONS:
        return getTransitionRestrictions();
      case EXTENDED_ATTRIBUTES:
        return getExtendedAttributes();
      case ID:
        return getId();
      case NAME:
        return getName();
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
      case DESCRIPTION:
        setDescription((String)newValue);
        return;
      case LIMIT:
        setLimit((String)newValue);
        return;
      case ROUTE:
        setRoute((Route)newValue);
        return;
      case IMPLEMENTATION:
        setImplementation((Implementation)newValue);
        return;
      case BLOCK_ACTIVITY:
        setBlockActivity((BlockActivity)newValue);
        return;
      case PERFORMER:
        setPerformer((String)newValue);
        return;
      case START_MODE:
        setStartMode((StartMode)newValue);
        return;
      case FINISH_MODE:
        setFinishMode((FinishMode)newValue);
        return;
      case PRIORITY:
        setPriority((String)newValue);
        return;
      case DEADLINE:
        getDeadline().clear();
        getDeadline().addAll((Collection)newValue);
        return;
      case SIMULATION_INFORMATION:
        setSimulationInformation((SimulationInformation)newValue);
        return;
      case ICON:
        setIcon((String)newValue);
        return;
      case DOCUMENTATION:
        setDocumentation((String)newValue);
        return;
      case TRANSITION_RESTRICTIONS:
        setTransitionRestrictions((TransitionRestrictions)newValue);
        return;
      case EXTENDED_ATTRIBUTES:
        setExtendedAttributes((ExtendedAttributes)newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case NAME:
        setName((String)newValue);
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
      case DESCRIPTION:
        unsetDescription();
        return;
      case LIMIT:
        unsetLimit();
        return;
      case ROUTE:
        unsetRoute();
        return;
      case IMPLEMENTATION:
        unsetImplementation();
        return;
      case BLOCK_ACTIVITY:
        unsetBlockActivity();
        return;
      case PERFORMER:
        unsetPerformer();
        return;
      case START_MODE:
        unsetStartMode();
        return;
      case FINISH_MODE:
        unsetFinishMode();
        return;
      case PRIORITY:
        unsetPriority();
        return;
      case DEADLINE:
        getDeadline().clear();
        return;
      case SIMULATION_INFORMATION:
        unsetSimulationInformation();
        return;
      case ICON:
        unsetIcon();
        return;
      case DOCUMENTATION:
        unsetDocumentation();
        return;
      case TRANSITION_RESTRICTIONS:
        unsetTransitionRestrictions();
        return;
      case EXTENDED_ATTRIBUTES:
        unsetExtendedAttributes();
        return;
      case ID:
        unsetId();
        return;
      case NAME:
        unsetName();
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
      case DESCRIPTION:
        return isSetDescription();
      case LIMIT:
        return isSetLimit();
      case ROUTE:
        return isSetRoute();
      case IMPLEMENTATION:
        return isSetImplementation();
      case BLOCK_ACTIVITY:
        return isSetBlockActivity();
      case PERFORMER:
        return isSetPerformer();
      case START_MODE:
        return isSetStartMode();
      case FINISH_MODE:
        return isSetFinishMode();
      case PRIORITY:
        return isSetPriority();
      case DEADLINE:
        return deadline != null && !deadline.isEmpty();
      case SIMULATION_INFORMATION:
        return isSetSimulationInformation();
      case ICON:
        return isSetIcon();
      case DOCUMENTATION:
        return isSetDocumentation();
      case TRANSITION_RESTRICTIONS:
        return isSetTransitionRestrictions();
      case EXTENDED_ATTRIBUTES:
        return isSetExtendedAttributes();
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
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
    result.append(" (Description: ");
    if (description_set_) result.append(description); else result.append("<unset>");
    result.append(", Limit: ");
    if (limit_set_) result.append(limit); else result.append("<unset>");
    result.append(", Performer: ");
    if (performer_set_) result.append(performer); else result.append("<unset>");
    result.append(", Priority: ");
    if (priority_set_) result.append(priority); else result.append("<unset>");
    result.append(", Icon: ");
    if (icon_set_) result.append(icon); else result.append("<unset>");
    result.append(", Documentation: ");
    if (documentation_set_) result.append(documentation); else result.append("<unset>");
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ActivityImpl
