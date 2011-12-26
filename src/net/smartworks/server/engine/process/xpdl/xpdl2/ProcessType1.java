/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessType1.java,v 1.1 2009/12/22 06:18:25 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessHeader <em>Process Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getRedefinableHeader <em>Redefinable Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants <em>Participants</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications <em>Applications</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields1 <em>Data Fields1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants1 <em>Participants1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications1 <em>Applications1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivitySets <em>Activity Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getPartnerLinks <em>Partner Links</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAccessLevel <em>Access Level</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessType <em>Process Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getStatus <em>Status</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocOrdering <em>Ad Hoc Ordering</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivitySetId <em>Default Start Activity Set Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivityId <em>Default Start Activity Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ProcessType1 extends Serializable
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessHeader <em>Process Header</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessHeader <em>Process Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetProcessHeader()
   * @see #getProcessHeader()
   * @see #setProcessHeader(ProcessHeader)
   * @generated
   */
  void unsetProcessHeader();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessHeader <em>Process Header</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getRedefinableHeader <em>Redefinable Header</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getRedefinableHeader <em>Redefinable Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRedefinableHeader()
   * @see #getRedefinableHeader()
   * @see #setRedefinableHeader(RedefinableHeader)
   * @generated
   */
  void unsetRedefinableHeader();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getRedefinableHeader <em>Redefinable Header</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getFormalParameters <em>Formal Parameters</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getFormalParameters <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFormalParameters()
   * @see #getFormalParameters()
   * @see #setFormalParameters(FormalParameters)
   * @generated
   */
  void unsetFormalParameters();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getFormalParameters <em>Formal Parameters</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants <em>Participants</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants <em>Participants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParticipants()
   * @see #getParticipants()
   * @see #setParticipants(Participants)
   * @generated
   */
  void unsetParticipants();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants <em>Participants</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications <em>Applications</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications <em>Applications</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetApplications()
   * @see #getApplications()
   * @see #setApplications(Applications)
   * @generated
   */
  void unsetApplications();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications <em>Applications</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields <em>Data Fields</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataFields()
   * @see #getDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  void unsetDataFields();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields <em>Data Fields</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Data Fields1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Fields1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Fields1</em>' containment reference.
   * @see #isSetDataFields1()
   * @see #unsetDataFields1()
   * @see #setDataFields1(net.smartworks.server.engine.process.xpdl.xpdl1.DataFields)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl1.DataFields getDataFields1();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields1 <em>Data Fields1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Fields1</em>' containment reference.
   * @see #isSetDataFields1()
   * @see #unsetDataFields1()
   * @see #getDataFields1()
   * @generated
   */
  void setDataFields1(net.smartworks.server.engine.process.xpdl.xpdl1.DataFields value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields1 <em>Data Fields1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataFields1()
   * @see #getDataFields1()
   * @see #setDataFields1(net.smartworks.server.engine.process.xpdl.xpdl1.DataFields)
   * @generated
   */
  void unsetDataFields1();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDataFields1 <em>Data Fields1</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Data Fields1</em>' containment reference is set.
   * @see #unsetDataFields1()
   * @see #getDataFields1()
   * @see #setDataFields1(net.smartworks.server.engine.process.xpdl.xpdl1.DataFields)
   * @generated
   */
  boolean isSetDataFields1();

  /**
   * Returns the value of the '<em><b>Participants1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Participants1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Participants1</em>' containment reference.
   * @see #isSetParticipants1()
   * @see #unsetParticipants1()
   * @see #setParticipants1(net.smartworks.server.engine.process.xpdl.xpdl1.Participants)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl1.Participants getParticipants1();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants1 <em>Participants1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Participants1</em>' containment reference.
   * @see #isSetParticipants1()
   * @see #unsetParticipants1()
   * @see #getParticipants1()
   * @generated
   */
  void setParticipants1(net.smartworks.server.engine.process.xpdl.xpdl1.Participants value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants1 <em>Participants1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParticipants1()
   * @see #getParticipants1()
   * @see #setParticipants1(net.smartworks.server.engine.process.xpdl.xpdl1.Participants)
   * @generated
   */
  void unsetParticipants1();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getParticipants1 <em>Participants1</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Participants1</em>' containment reference is set.
   * @see #unsetParticipants1()
   * @see #getParticipants1()
   * @see #setParticipants1(net.smartworks.server.engine.process.xpdl.xpdl1.Participants)
   * @generated
   */
  boolean isSetParticipants1();

  /**
   * Returns the value of the '<em><b>Applications1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applications1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applications1</em>' containment reference.
   * @see #isSetApplications1()
   * @see #unsetApplications1()
   * @see #setApplications1(net.smartworks.server.engine.process.xpdl.xpdl1.Applications)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl1.Applications getApplications1();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications1 <em>Applications1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Applications1</em>' containment reference.
   * @see #isSetApplications1()
   * @see #unsetApplications1()
   * @see #getApplications1()
   * @generated
   */
  void setApplications1(net.smartworks.server.engine.process.xpdl.xpdl1.Applications value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications1 <em>Applications1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetApplications1()
   * @see #getApplications1()
   * @see #setApplications1(net.smartworks.server.engine.process.xpdl.xpdl1.Applications)
   * @generated
   */
  void unsetApplications1();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getApplications1 <em>Applications1</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Applications1</em>' containment reference is set.
   * @see #unsetApplications1()
   * @see #getApplications1()
   * @see #setApplications1(net.smartworks.server.engine.process.xpdl.xpdl1.Applications)
   * @generated
   */
  boolean isSetApplications1();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivitySets <em>Activity Sets</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivitySets <em>Activity Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActivitySets()
   * @see #getActivitySets()
   * @see #setActivitySets(ActivitySets)
   * @generated
   */
  void unsetActivitySets();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivitySets <em>Activity Sets</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivities <em>Activities</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivities <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetActivities()
   * @see #getActivities()
   * @see #setActivities(Activities)
   * @generated
   */
  void unsetActivities();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getActivities <em>Activities</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getTransitions <em>Transitions</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getTransitions <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitions()
   * @see #getTransitions()
   * @see #setTransitions(Transitions)
   * @generated
   */
  void unsetTransitions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getTransitions <em>Transitions</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  void unsetExtendedAttributes();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtendedAttributes <em>Extended Attributes</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Assignments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN and XPDL
   * <!-- end-model-doc -->
   * @return the value of the '<em>Assignments</em>' containment reference.
   * @see #isSetAssignments()
   * @see #unsetAssignments()
   * @see #setAssignments(Assignments)
   * @generated
   */
  Assignments getAssignments();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAssignments <em>Assignments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignments</em>' containment reference.
   * @see #isSetAssignments()
   * @see #unsetAssignments()
   * @see #getAssignments()
   * @generated
   */
  void setAssignments(Assignments value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAssignments <em>Assignments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAssignments()
   * @see #getAssignments()
   * @see #setAssignments(Assignments)
   * @generated
   */
  void unsetAssignments();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAssignments <em>Assignments</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Assignments</em>' containment reference is set.
   * @see #unsetAssignments()
   * @see #getAssignments()
   * @see #setAssignments(Assignments)
   * @generated
   */
  boolean isSetAssignments();

  /**
   * Returns the value of the '<em><b>Partner Links</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partner Links</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partner Links</em>' containment reference.
   * @see #isSetPartnerLinks()
   * @see #unsetPartnerLinks()
   * @see #setPartnerLinks(PartnerLinks)
   * @generated
   */
  PartnerLinks getPartnerLinks();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getPartnerLinks <em>Partner Links</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partner Links</em>' containment reference.
   * @see #isSetPartnerLinks()
   * @see #unsetPartnerLinks()
   * @see #getPartnerLinks()
   * @generated
   */
  void setPartnerLinks(PartnerLinks value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getPartnerLinks <em>Partner Links</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPartnerLinks()
   * @see #getPartnerLinks()
   * @see #setPartnerLinks(PartnerLinks)
   * @generated
   */
  void unsetPartnerLinks();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getPartnerLinks <em>Partner Links</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Partner Links</em>' containment reference is set.
   * @see #unsetPartnerLinks()
   * @see #getPartnerLinks()
   * @see #setPartnerLinks(PartnerLinks)
   * @generated
   */
  boolean isSetPartnerLinks();

  /**
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: This is used to identify the Activity in an EndEvent Compensation???Also used to associate categories and ocumentation with a variety of elements
   * <!-- end-model-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  net.smartworks.server.engine.process.xpdl.xpdl2.Object getObject();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #isSetObject()
   * @see #unsetObject()
   * @see #getObject()
   * @generated
   */
  void setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  void unsetObject();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getObject <em>Object</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Object</em>' containment reference is set.
   * @see #unsetObject()
   * @see #getObject()
   * @see #setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object)
   * @generated
   */
  boolean isSetObject();

  /**
   * Returns the value of the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extensions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extensions</em>' containment reference.
   * @see #isSetExtensions()
   * @see #unsetExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  DataObject getExtensions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtensions <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extensions</em>' containment reference.
   * @see #isSetExtensions()
   * @see #unsetExtensions()
   * @see #getExtensions()
   * @generated
   */
  void setExtensions(DataObject value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtensions <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtensions()
   * @see #getExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  void unsetExtensions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getExtensions <em>Extensions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Extensions</em>' containment reference is set.
   * @see #unsetExtensions()
   * @see #getExtensions()
   * @see #setExtensions(DataObject)
   * @generated
   */
  boolean isSetExtensions();

  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @generated
   */
  Sequence getAny();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getId <em>Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getName <em>Name</em>}' attribute is set.
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
   * The default value is <code>"PUBLIC"</code>.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAccessLevel <em>Access Level</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAccessLevel <em>Access Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAccessLevel()
   * @see #getAccessLevel()
   * @see #setAccessLevel(String)
   * @generated
   */
  void unsetAccessLevel();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAccessLevel <em>Access Level</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Access Level</em>' attribute is set.
   * @see #unsetAccessLevel()
   * @see #getAccessLevel()
   * @see #setAccessLevel(String)
   * @generated
   */
  boolean isSetAccessLevel();

  /**
   * Returns the value of the '<em><b>Process Type</b></em>' attribute.
   * The default value is <code>"None"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN:
   * <!-- end-model-doc -->
   * @return the value of the '<em>Process Type</em>' attribute.
   * @see #isSetProcessType()
   * @see #unsetProcessType()
   * @see #setProcessType(String)
   * @generated
   */
  String getProcessType();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessType <em>Process Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process Type</em>' attribute.
   * @see #isSetProcessType()
   * @see #unsetProcessType()
   * @see #getProcessType()
   * @generated
   */
  void setProcessType(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessType <em>Process Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetProcessType()
   * @see #getProcessType()
   * @see #setProcessType(String)
   * @generated
   */
  void unsetProcessType();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getProcessType <em>Process Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Process Type</em>' attribute is set.
   * @see #unsetProcessType()
   * @see #getProcessType()
   * @see #setProcessType(String)
   * @generated
   */
  boolean isSetProcessType();

  /**
   * Returns the value of the '<em><b>Status</b></em>' attribute.
   * The default value is <code>"None"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  BPMN: Status values are assigned during execution. Status can be treated as a property and used in expressions local to a Process. It is unclear that status belongs in the XPDL document.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Status</em>' attribute.
   * @see #isSetStatus()
   * @see #unsetStatus()
   * @see #setStatus(String)
   * @generated
   */
  String getStatus();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' attribute.
   * @see #isSetStatus()
   * @see #unsetStatus()
   * @see #getStatus()
   * @generated
   */
  void setStatus(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStatus()
   * @see #getStatus()
   * @see #setStatus(String)
   * @generated
   */
  void unsetStatus();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getStatus <em>Status</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Status</em>' attribute is set.
   * @see #unsetStatus()
   * @see #getStatus()
   * @see #setStatus(String)
   * @generated
   */
  boolean isSetStatus();

  /**
   * Returns the value of the '<em><b>Suppress Join Failure</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Suppress Join Failure</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Suppress Join Failure</em>' attribute.
   * @see #isSetSuppressJoinFailure()
   * @see #unsetSuppressJoinFailure()
   * @see #setSuppressJoinFailure(boolean)
   * @generated
   */
  boolean isSuppressJoinFailure();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Suppress Join Failure</em>' attribute.
   * @see #isSetSuppressJoinFailure()
   * @see #unsetSuppressJoinFailure()
   * @see #isSuppressJoinFailure()
   * @generated
   */
  void setSuppressJoinFailure(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSuppressJoinFailure()
   * @see #isSuppressJoinFailure()
   * @see #setSuppressJoinFailure(boolean)
   * @generated
   */
  void unsetSuppressJoinFailure();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Suppress Join Failure</em>' attribute is set.
   * @see #unsetSuppressJoinFailure()
   * @see #isSuppressJoinFailure()
   * @see #setSuppressJoinFailure(boolean)
   * @generated
   */
  boolean isSetSuppressJoinFailure();

  /**
   * Returns the value of the '<em><b>Enable Instance Compensation</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enable Instance Compensation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enable Instance Compensation</em>' attribute.
   * @see #isSetEnableInstanceCompensation()
   * @see #unsetEnableInstanceCompensation()
   * @see #setEnableInstanceCompensation(boolean)
   * @generated
   */
  boolean isEnableInstanceCompensation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enable Instance Compensation</em>' attribute.
   * @see #isSetEnableInstanceCompensation()
   * @see #unsetEnableInstanceCompensation()
   * @see #isEnableInstanceCompensation()
   * @generated
   */
  void setEnableInstanceCompensation(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEnableInstanceCompensation()
   * @see #isEnableInstanceCompensation()
   * @see #setEnableInstanceCompensation(boolean)
   * @generated
   */
  void unsetEnableInstanceCompensation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Enable Instance Compensation</em>' attribute is set.
   * @see #unsetEnableInstanceCompensation()
   * @see #isEnableInstanceCompensation()
   * @see #setEnableInstanceCompensation(boolean)
   * @generated
   */
  boolean isSetEnableInstanceCompensation();

  /**
   * Returns the value of the '<em><b>Ad Hoc</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: for Embedded subprocess
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ad Hoc</em>' attribute.
   * @see #isSetAdHoc()
   * @see #unsetAdHoc()
   * @see #setAdHoc(boolean)
   * @generated
   */
  boolean isAdHoc();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isAdHoc <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ad Hoc</em>' attribute.
   * @see #isSetAdHoc()
   * @see #unsetAdHoc()
   * @see #isAdHoc()
   * @generated
   */
  void setAdHoc(boolean value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isAdHoc <em>Ad Hoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAdHoc()
   * @see #isAdHoc()
   * @see #setAdHoc(boolean)
   * @generated
   */
  void unsetAdHoc();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#isAdHoc <em>Ad Hoc</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ad Hoc</em>' attribute is set.
   * @see #unsetAdHoc()
   * @see #isAdHoc()
   * @see #setAdHoc(boolean)
   * @generated
   */
  boolean isSetAdHoc();

  /**
   * Returns the value of the '<em><b>Ad Hoc Ordering</b></em>' attribute.
   * The default value is <code>"Parallel"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: for Embedded subprocess
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ad Hoc Ordering</em>' attribute.
   * @see #isSetAdHocOrdering()
   * @see #unsetAdHocOrdering()
   * @see #setAdHocOrdering(String)
   * @generated
   */
  String getAdHocOrdering();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocOrdering <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ad Hoc Ordering</em>' attribute.
   * @see #isSetAdHocOrdering()
   * @see #unsetAdHocOrdering()
   * @see #getAdHocOrdering()
   * @generated
   */
  void setAdHocOrdering(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocOrdering <em>Ad Hoc Ordering</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAdHocOrdering()
   * @see #getAdHocOrdering()
   * @see #setAdHocOrdering(String)
   * @generated
   */
  void unsetAdHocOrdering();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocOrdering <em>Ad Hoc Ordering</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ad Hoc Ordering</em>' attribute is set.
   * @see #unsetAdHocOrdering()
   * @see #getAdHocOrdering()
   * @see #setAdHocOrdering(String)
   * @generated
   */
  boolean isSetAdHocOrdering();

  /**
   * Returns the value of the '<em><b>Ad Hoc Completion Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * BPMN: for Embedded subprocess
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ad Hoc Completion Condition</em>' attribute.
   * @see #isSetAdHocCompletionCondition()
   * @see #unsetAdHocCompletionCondition()
   * @see #setAdHocCompletionCondition(String)
   * @generated
   */
  String getAdHocCompletionCondition();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ad Hoc Completion Condition</em>' attribute.
   * @see #isSetAdHocCompletionCondition()
   * @see #unsetAdHocCompletionCondition()
   * @see #getAdHocCompletionCondition()
   * @generated
   */
  void setAdHocCompletionCondition(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAdHocCompletionCondition()
   * @see #getAdHocCompletionCondition()
   * @see #setAdHocCompletionCondition(String)
   * @generated
   */
  void unsetAdHocCompletionCondition();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ad Hoc Completion Condition</em>' attribute is set.
   * @see #unsetAdHocCompletionCondition()
   * @see #getAdHocCompletionCondition()
   * @see #setAdHocCompletionCondition(String)
   * @generated
   */
  boolean isSetAdHocCompletionCondition();

  /**
   * Returns the value of the '<em><b>Default Start Activity Set Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Start Activity Set Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Start Activity Set Id</em>' attribute.
   * @see #isSetDefaultStartActivitySetId()
   * @see #unsetDefaultStartActivitySetId()
   * @see #setDefaultStartActivitySetId(String)
   * @generated
   */
  String getDefaultStartActivitySetId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivitySetId <em>Default Start Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Start Activity Set Id</em>' attribute.
   * @see #isSetDefaultStartActivitySetId()
   * @see #unsetDefaultStartActivitySetId()
   * @see #getDefaultStartActivitySetId()
   * @generated
   */
  void setDefaultStartActivitySetId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivitySetId <em>Default Start Activity Set Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDefaultStartActivitySetId()
   * @see #getDefaultStartActivitySetId()
   * @see #setDefaultStartActivitySetId(String)
   * @generated
   */
  void unsetDefaultStartActivitySetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivitySetId <em>Default Start Activity Set Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Default Start Activity Set Id</em>' attribute is set.
   * @see #unsetDefaultStartActivitySetId()
   * @see #getDefaultStartActivitySetId()
   * @see #setDefaultStartActivitySetId(String)
   * @generated
   */
  boolean isSetDefaultStartActivitySetId();

  /**
   * Returns the value of the '<em><b>Default Start Activity Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Start Activity Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Start Activity Id</em>' attribute.
   * @see #isSetDefaultStartActivityId()
   * @see #unsetDefaultStartActivityId()
   * @see #setDefaultStartActivityId(String)
   * @generated
   */
  String getDefaultStartActivityId();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivityId <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Start Activity Id</em>' attribute.
   * @see #isSetDefaultStartActivityId()
   * @see #unsetDefaultStartActivityId()
   * @see #getDefaultStartActivityId()
   * @generated
   */
  void setDefaultStartActivityId(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivityId <em>Default Start Activity Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDefaultStartActivityId()
   * @see #getDefaultStartActivityId()
   * @see #setDefaultStartActivityId(String)
   * @generated
   */
  void unsetDefaultStartActivityId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1#getDefaultStartActivityId <em>Default Start Activity Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Default Start Activity Id</em>' attribute is set.
   * @see #unsetDefaultStartActivityId()
   * @see #getDefaultStartActivityId()
   * @see #setDefaultStartActivityId(String)
   * @generated
   */
  boolean isSetDefaultStartActivityId();

  /**
   * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Attribute</em>' attribute list.
   * @generated
   */
  Sequence getAnyAttribute();

} // ProcessType1
