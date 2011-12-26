/**
 * <copyright>
 * </copyright>
 *
 * $Id: Activity.java,v 1.1 2009/12/22 06:17:58 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getLimit <em>Limit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getRoute <em>Route</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getBlockActivity <em>Block Activity</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPerformer <em>Performer</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getStartMode <em>Start Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getFinishMode <em>Finish Mode</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPriority <em>Priority</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getSimulationInformation <em>Simulation Information</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getIcon <em>Icon</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Activity extends Serializable
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #setDescription(String)
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDescription()
   * @see #getDescription()
   * @see #setDescription(String)
   * @generated
   */
  void unsetDescription();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDescription <em>Description</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Description</em>' attribute is set.
   * @see #unsetDescription()
   * @see #getDescription()
   * @see #setDescription(String)
   * @generated
   */
  boolean isSetDescription();

  /**
   * Returns the value of the '<em><b>Limit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Limit</em>' attribute.
   * @see #isSetLimit()
   * @see #unsetLimit()
   * @see #setLimit(String)
   * @generated
   */
  String getLimit();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getLimit <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Limit</em>' attribute.
   * @see #isSetLimit()
   * @see #unsetLimit()
   * @see #getLimit()
   * @generated
   */
  void setLimit(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getLimit <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLimit()
   * @see #getLimit()
   * @see #setLimit(String)
   * @generated
   */
  void unsetLimit();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getLimit <em>Limit</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Limit</em>' attribute is set.
   * @see #unsetLimit()
   * @see #getLimit()
   * @see #setLimit(String)
   * @generated
   */
  boolean isSetLimit();

  /**
   * Returns the value of the '<em><b>Route</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Route</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Route</em>' containment reference.
   * @see #isSetRoute()
   * @see #unsetRoute()
   * @see #setRoute(Route)
   * @generated
   */
  Route getRoute();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getRoute <em>Route</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Route</em>' containment reference.
   * @see #isSetRoute()
   * @see #unsetRoute()
   * @see #getRoute()
   * @generated
   */
  void setRoute(Route value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getRoute <em>Route</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRoute()
   * @see #getRoute()
   * @see #setRoute(Route)
   * @generated
   */
  void unsetRoute();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getRoute <em>Route</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Route</em>' containment reference is set.
   * @see #unsetRoute()
   * @see #getRoute()
   * @see #setRoute(Route)
   * @generated
   */
  boolean isSetRoute();

  /**
   * Returns the value of the '<em><b>Implementation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implementation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implementation</em>' containment reference.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #setImplementation(Implementation)
   * @generated
   */
  Implementation getImplementation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getImplementation <em>Implementation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation</em>' containment reference.
   * @see #isSetImplementation()
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @generated
   */
  void setImplementation(Implementation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getImplementation <em>Implementation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(Implementation)
   * @generated
   */
  void unsetImplementation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getImplementation <em>Implementation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Implementation</em>' containment reference is set.
   * @see #unsetImplementation()
   * @see #getImplementation()
   * @see #setImplementation(Implementation)
   * @generated
   */
  boolean isSetImplementation();

  /**
   * Returns the value of the '<em><b>Block Activity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block Activity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block Activity</em>' containment reference.
   * @see #isSetBlockActivity()
   * @see #unsetBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  BlockActivity getBlockActivity();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getBlockActivity <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block Activity</em>' containment reference.
   * @see #isSetBlockActivity()
   * @see #unsetBlockActivity()
   * @see #getBlockActivity()
   * @generated
   */
  void setBlockActivity(BlockActivity value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getBlockActivity <em>Block Activity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBlockActivity()
   * @see #getBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  void unsetBlockActivity();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getBlockActivity <em>Block Activity</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Block Activity</em>' containment reference is set.
   * @see #unsetBlockActivity()
   * @see #getBlockActivity()
   * @see #setBlockActivity(BlockActivity)
   * @generated
   */
  boolean isSetBlockActivity();

  /**
   * Returns the value of the '<em><b>Performer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Performer</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Performer</em>' attribute.
   * @see #isSetPerformer()
   * @see #unsetPerformer()
   * @see #setPerformer(String)
   * @generated
   */
  String getPerformer();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPerformer <em>Performer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Performer</em>' attribute.
   * @see #isSetPerformer()
   * @see #unsetPerformer()
   * @see #getPerformer()
   * @generated
   */
  void setPerformer(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPerformer <em>Performer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPerformer()
   * @see #getPerformer()
   * @see #setPerformer(String)
   * @generated
   */
  void unsetPerformer();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPerformer <em>Performer</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Performer</em>' attribute is set.
   * @see #unsetPerformer()
   * @see #getPerformer()
   * @see #setPerformer(String)
   * @generated
   */
  boolean isSetPerformer();

  /**
   * Returns the value of the '<em><b>Start Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Mode</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Mode</em>' containment reference.
   * @see #isSetStartMode()
   * @see #unsetStartMode()
   * @see #setStartMode(StartMode)
   * @generated
   */
  StartMode getStartMode();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getStartMode <em>Start Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Mode</em>' containment reference.
   * @see #isSetStartMode()
   * @see #unsetStartMode()
   * @see #getStartMode()
   * @generated
   */
  void setStartMode(StartMode value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getStartMode <em>Start Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStartMode()
   * @see #getStartMode()
   * @see #setStartMode(StartMode)
   * @generated
   */
  void unsetStartMode();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getStartMode <em>Start Mode</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Start Mode</em>' containment reference is set.
   * @see #unsetStartMode()
   * @see #getStartMode()
   * @see #setStartMode(StartMode)
   * @generated
   */
  boolean isSetStartMode();

  /**
   * Returns the value of the '<em><b>Finish Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Finish Mode</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Finish Mode</em>' containment reference.
   * @see #isSetFinishMode()
   * @see #unsetFinishMode()
   * @see #setFinishMode(FinishMode)
   * @generated
   */
  FinishMode getFinishMode();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getFinishMode <em>Finish Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Finish Mode</em>' containment reference.
   * @see #isSetFinishMode()
   * @see #unsetFinishMode()
   * @see #getFinishMode()
   * @generated
   */
  void setFinishMode(FinishMode value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getFinishMode <em>Finish Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFinishMode()
   * @see #getFinishMode()
   * @see #setFinishMode(FinishMode)
   * @generated
   */
  void unsetFinishMode();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getFinishMode <em>Finish Mode</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Finish Mode</em>' containment reference is set.
   * @see #unsetFinishMode()
   * @see #getFinishMode()
   * @see #setFinishMode(FinishMode)
   * @generated
   */
  boolean isSetFinishMode();

  /**
   * Returns the value of the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' attribute.
   * @see #isSetPriority()
   * @see #unsetPriority()
   * @see #setPriority(String)
   * @generated
   */
  String getPriority();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' attribute.
   * @see #isSetPriority()
   * @see #unsetPriority()
   * @see #getPriority()
   * @generated
   */
  void setPriority(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPriority()
   * @see #getPriority()
   * @see #setPriority(String)
   * @generated
   */
  void unsetPriority();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getPriority <em>Priority</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Priority</em>' attribute is set.
   * @see #unsetPriority()
   * @see #getPriority()
   * @see #setPriority(String)
   * @generated
   */
  boolean isSetPriority();

  /**
   * Returns the value of the '<em><b>Deadline</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl1.Deadline}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deadline</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deadline</em>' containment reference list.
   * @generated
   */
  List getDeadline();

  /**
   * Returns the value of the '<em><b>Simulation Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simulation Information</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simulation Information</em>' containment reference.
   * @see #isSetSimulationInformation()
   * @see #unsetSimulationInformation()
   * @see #setSimulationInformation(SimulationInformation)
   * @generated
   */
  SimulationInformation getSimulationInformation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getSimulationInformation <em>Simulation Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simulation Information</em>' containment reference.
   * @see #isSetSimulationInformation()
   * @see #unsetSimulationInformation()
   * @see #getSimulationInformation()
   * @generated
   */
  void setSimulationInformation(SimulationInformation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getSimulationInformation <em>Simulation Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSimulationInformation()
   * @see #getSimulationInformation()
   * @see #setSimulationInformation(SimulationInformation)
   * @generated
   */
  void unsetSimulationInformation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getSimulationInformation <em>Simulation Information</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Simulation Information</em>' containment reference is set.
   * @see #unsetSimulationInformation()
   * @see #getSimulationInformation()
   * @see #setSimulationInformation(SimulationInformation)
   * @generated
   */
  boolean isSetSimulationInformation();

  /**
   * Returns the value of the '<em><b>Icon</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Icon</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Icon</em>' attribute.
   * @see #isSetIcon()
   * @see #unsetIcon()
   * @see #setIcon(String)
   * @generated
   */
  String getIcon();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getIcon <em>Icon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Icon</em>' attribute.
   * @see #isSetIcon()
   * @see #unsetIcon()
   * @see #getIcon()
   * @generated
   */
  void setIcon(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getIcon <em>Icon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetIcon()
   * @see #getIcon()
   * @see #setIcon(String)
   * @generated
   */
  void unsetIcon();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getIcon <em>Icon</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Icon</em>' attribute is set.
   * @see #unsetIcon()
   * @see #getIcon()
   * @see #setIcon(String)
   * @generated
   */
  boolean isSetIcon();

  /**
   * Returns the value of the '<em><b>Documentation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' attribute.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #setDocumentation(String)
   * @generated
   */
  String getDocumentation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDocumentation <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Documentation</em>' attribute.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @generated
   */
  void setDocumentation(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDocumentation <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(String)
   * @generated
   */
  void unsetDocumentation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getDocumentation <em>Documentation</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Documentation</em>' attribute is set.
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(String)
   * @generated
   */
  boolean isSetDocumentation();

  /**
   * Returns the value of the '<em><b>Transition Restrictions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Restrictions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Restrictions</em>' containment reference.
   * @see #isSetTransitionRestrictions()
   * @see #unsetTransitionRestrictions()
   * @see #setTransitionRestrictions(TransitionRestrictions)
   * @generated
   */
  TransitionRestrictions getTransitionRestrictions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transition Restrictions</em>' containment reference.
   * @see #isSetTransitionRestrictions()
   * @see #unsetTransitionRestrictions()
   * @see #getTransitionRestrictions()
   * @generated
   */
  void setTransitionRestrictions(TransitionRestrictions value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitionRestrictions()
   * @see #getTransitionRestrictions()
   * @see #setTransitionRestrictions(TransitionRestrictions)
   * @generated
   */
  void unsetTransitionRestrictions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getTransitionRestrictions <em>Transition Restrictions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transition Restrictions</em>' containment reference is set.
   * @see #unsetTransitionRestrictions()
   * @see #getTransitionRestrictions()
   * @see #setTransitionRestrictions(TransitionRestrictions)
   * @generated
   */
  boolean isSetTransitionRestrictions();

  /**
   * Returns the value of the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extended Attributes</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extended Attributes</em>' containment reference.
   * @see #isSetExtendedAttributes()
   * @see #unsetExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  ExtendedAttributes getExtendedAttributes();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extended Attributes</em>' containment reference.
   * @see #isSetExtendedAttributes()
   * @see #unsetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @generated
   */
  void setExtendedAttributes(ExtendedAttributes value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  void unsetExtendedAttributes();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getExtendedAttributes <em>Extended Attributes</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Extended Attributes</em>' containment reference is set.
   * @see #unsetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  boolean isSetExtendedAttributes();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #setId(String)
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getId <em>Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Id</em>' attribute is set.
   * @see #unsetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  boolean isSetId();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #setName(String)
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Activity#getName <em>Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Name</em>' attribute is set.
   * @see #unsetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  boolean isSetName();

} // Activity
