/**
 * <copyright>
 * </copyright>
 *
 * $Id: WorkflowProcess.java,v 1.1 2009/12/22 06:18:06 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getProcessHeader <em>Process Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getRedefinableHeader <em>Redefinable Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getParticipants <em>Participants</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getApplications <em>Applications</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivitySets <em>Activity Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getAccessLevel <em>Access Level</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface WorkflowProcess extends Serializable
{
  /**
   * Returns the value of the '<em><b>Process Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Process Header</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Process Header</em>' containment reference.
   * @see #isSetProcessHeader()
   * @see #unsetProcessHeader()
   * @see #setProcessHeader(ProcessHeader)
   * @generated
   */
  ProcessHeader getProcessHeader();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getProcessHeader <em>Process Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process Header</em>' containment reference.
   * @see #isSetProcessHeader()
   * @see #unsetProcessHeader()
   * @see #getProcessHeader()
   * @generated
   */
  void setProcessHeader(ProcessHeader value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getProcessHeader <em>Process Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetProcessHeader()
   * @see #getProcessHeader()
   * @see #setProcessHeader(ProcessHeader)
   * @generated
   */
  void unsetProcessHeader();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getProcessHeader <em>Process Header</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Process Header</em>' containment reference is set.
   * @see #unsetProcessHeader()
   * @see #getProcessHeader()
   * @see #setProcessHeader(ProcessHeader)
   * @generated
   */
  boolean isSetProcessHeader();

  /**
   * Returns the value of the '<em><b>Redefinable Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Redefinable Header</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Redefinable Header</em>' containment reference.
   * @see #isSetRedefinableHeader()
   * @see #unsetRedefinableHeader()
   * @see #setRedefinableHeader(RedefinableHeader)
   * @generated
   */
  RedefinableHeader getRedefinableHeader();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getRedefinableHeader <em>Redefinable Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Redefinable Header</em>' containment reference.
   * @see #isSetRedefinableHeader()
   * @see #unsetRedefinableHeader()
   * @see #getRedefinableHeader()
   * @generated
   */
  void setRedefinableHeader(RedefinableHeader value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getRedefinableHeader <em>Redefinable Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRedefinableHeader()
   * @see #getRedefinableHeader()
   * @see #setRedefinableHeader(RedefinableHeader)
   * @generated
   */
  void unsetRedefinableHeader();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getRedefinableHeader <em>Redefinable Header</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Redefinable Header</em>' containment reference is set.
   * @see #unsetRedefinableHeader()
   * @see #getRedefinableHeader()
   * @see #setRedefinableHeader(RedefinableHeader)
   * @generated
   */
  boolean isSetRedefinableHeader();

  /**
   * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameters</em>' containment reference.
   * @see #isSetFormalParameters()
   * @see #unsetFormalParameters()
   * @see #setFormalParameters(FormalParameters)
   * @generated
   */
  FormalParameters getFormalParameters();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getFormalParameters <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Parameters</em>' containment reference.
   * @see #isSetFormalParameters()
   * @see #unsetFormalParameters()
   * @see #getFormalParameters()
   * @generated
   */
  void setFormalParameters(FormalParameters value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getFormalParameters <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFormalParameters()
   * @see #getFormalParameters()
   * @see #setFormalParameters(FormalParameters)
   * @generated
   */
  void unsetFormalParameters();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getFormalParameters <em>Formal Parameters</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Formal Parameters</em>' containment reference is set.
   * @see #unsetFormalParameters()
   * @see #getFormalParameters()
   * @see #setFormalParameters(FormalParameters)
   * @generated
   */
  boolean isSetFormalParameters();

  /**
   * Returns the value of the '<em><b>Data Fields</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Fields</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Fields</em>' containment reference.
   * @see #isSetDataFields()
   * @see #unsetDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  DataFields getDataFields();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getDataFields <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Fields</em>' containment reference.
   * @see #isSetDataFields()
   * @see #unsetDataFields()
   * @see #getDataFields()
   * @generated
   */
  void setDataFields(DataFields value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getDataFields <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataFields()
   * @see #getDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  void unsetDataFields();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getDataFields <em>Data Fields</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Data Fields</em>' containment reference is set.
   * @see #unsetDataFields()
   * @see #getDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  boolean isSetDataFields();

  /**
   * Returns the value of the '<em><b>Participants</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Participants</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Participants</em>' containment reference.
   * @see #isSetParticipants()
   * @see #unsetParticipants()
   * @see #setParticipants(Participants)
   * @generated
   */
  Participants getParticipants();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getParticipants <em>Participants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Participants</em>' containment reference.
   * @see #isSetParticipants()
   * @see #unsetParticipants()
   * @see #getParticipants()
   * @generated
   */
  void setParticipants(Participants value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getParticipants <em>Participants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParticipants()
   * @see #getParticipants()
   * @see #setParticipants(Participants)
   * @generated
   */
  void unsetParticipants();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getParticipants <em>Participants</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Participants</em>' containment reference is set.
   * @see #unsetParticipants()
   * @see #getParticipants()
   * @see #setParticipants(Participants)
   * @generated
   */
  boolean isSetParticipants();

  /**
   * Returns the value of the '<em><b>Applications</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applications</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applications</em>' containment reference.
   * @see #isSetApplications()
   * @see #unsetApplications()
   * @see #setApplications(Applications)
   * @generated
   */
  Applications getApplications();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getApplications <em>Applications</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Applications</em>' containment reference.
   * @see #isSetApplications()
   * @see #unsetApplications()
   * @see #getApplications()
   * @generated
   */
  void setApplications(Applications value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getApplications <em>Applications</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetApplications()
   * @see #getApplications()
   * @see #setApplications(Applications)
   * @generated
   */
  void unsetApplications();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getApplications <em>Applications</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Applications</em>' containment reference is set.
   * @see #unsetApplications()
   * @see #getApplications()
   * @see #setApplications(Applications)
   * @generated
   */
  boolean isSetApplications();

  /**
   * Returns the value of the '<em><b>Activity Sets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Sets</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Sets</em>' containment reference.
   * @see #isSetActivitySets()
   * @see #unsetActivitySets()
   * @see #setActivitySets(ActivitySets)
   * @generated
   */
  ActivitySets getActivitySets();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivitySets <em>Activity Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Sets</em>' containment reference.
   * @see #isSetActivitySets()
   * @see #unsetActivitySets()
   * @see #getActivitySets()
   * @generated
   */
  void setActivitySets(ActivitySets value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivitySets <em>Activity Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActivitySets()
   * @see #getActivitySets()
   * @see #setActivitySets(ActivitySets)
   * @generated
   */
  void unsetActivitySets();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivitySets <em>Activity Sets</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Activity Sets</em>' containment reference is set.
   * @see #unsetActivitySets()
   * @see #getActivitySets()
   * @see #setActivitySets(ActivitySets)
   * @generated
   */
  boolean isSetActivitySets();

  /**
   * Returns the value of the '<em><b>Activities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activities</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activities</em>' containment reference.
   * @see #isSetActivities()
   * @see #unsetActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  Activities getActivities();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivities <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activities</em>' containment reference.
   * @see #isSetActivities()
   * @see #unsetActivities()
   * @see #getActivities()
   * @generated
   */
  void setActivities(Activities value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivities <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActivities()
   * @see #getActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  void unsetActivities();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getActivities <em>Activities</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Activities</em>' containment reference is set.
   * @see #unsetActivities()
   * @see #getActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  boolean isSetActivities();

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference.
   * @see #isSetTransitions()
   * @see #unsetTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  Transitions getTransitions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getTransitions <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transitions</em>' containment reference.
   * @see #isSetTransitions()
   * @see #unsetTransitions()
   * @see #getTransitions()
   * @generated
   */
  void setTransitions(Transitions value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getTransitions <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitions()
   * @see #getTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  void unsetTransitions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getTransitions <em>Transitions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transitions</em>' containment reference is set.
   * @see #unsetTransitions()
   * @see #getTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  boolean isSetTransitions();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  void unsetExtendedAttributes();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getExtendedAttributes <em>Extended Attributes</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getId <em>Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getName <em>Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Name</em>' attribute is set.
   * @see #unsetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  boolean isSetName();

  /**
   * Returns the value of the '<em><b>Access Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Access Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access Level</em>' attribute.
   * @see #isSetAccessLevel()
   * @see #unsetAccessLevel()
   * @see #setAccessLevel(String)
   * @generated
   */
  String getAccessLevel();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getAccessLevel <em>Access Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access Level</em>' attribute.
   * @see #isSetAccessLevel()
   * @see #unsetAccessLevel()
   * @see #getAccessLevel()
   * @generated
   */
  void setAccessLevel(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getAccessLevel <em>Access Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAccessLevel()
   * @see #getAccessLevel()
   * @see #setAccessLevel(String)
   * @generated
   */
  void unsetAccessLevel();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess#getAccessLevel <em>Access Level</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Access Level</em>' attribute is set.
   * @see #unsetAccessLevel()
   * @see #getAccessLevel()
   * @see #setAccessLevel(String)
   * @generated
   */
  boolean isSetAccessLevel();

} // WorkflowProcess
