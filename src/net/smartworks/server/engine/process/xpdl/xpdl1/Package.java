/**
 * <copyright>
 * </copyright>
 *
 * $Id: Package.java,v 1.1 2009/12/22 06:17:59 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getPackageHeader <em>Package Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getRedefinableHeader <em>Redefinable Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getConformanceClass <em>Conformance Class</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getScript <em>Script</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExternalPackages <em>External Packages</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getTypeDeclarations <em>Type Declarations</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getParticipants <em>Participants</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getApplications <em>Applications</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getWorkflowProcesses <em>Workflow Processes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Package extends Serializable
{
  /**
   * Returns the value of the '<em><b>Package Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package Header</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package Header</em>' containment reference.
   * @see #isSetPackageHeader()
   * @see #unsetPackageHeader()
   * @see #setPackageHeader(PackageHeader)
   * @generated
   */
  PackageHeader getPackageHeader();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getPackageHeader <em>Package Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package Header</em>' containment reference.
   * @see #isSetPackageHeader()
   * @see #unsetPackageHeader()
   * @see #getPackageHeader()
   * @generated
   */
  void setPackageHeader(PackageHeader value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getPackageHeader <em>Package Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPackageHeader()
   * @see #getPackageHeader()
   * @see #setPackageHeader(PackageHeader)
   * @generated
   */
  void unsetPackageHeader();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getPackageHeader <em>Package Header</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Package Header</em>' containment reference is set.
   * @see #unsetPackageHeader()
   * @see #getPackageHeader()
   * @see #setPackageHeader(PackageHeader)
   * @generated
   */
  boolean isSetPackageHeader();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getRedefinableHeader <em>Redefinable Header</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getRedefinableHeader <em>Redefinable Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRedefinableHeader()
   * @see #getRedefinableHeader()
   * @see #setRedefinableHeader(RedefinableHeader)
   * @generated
   */
  void unsetRedefinableHeader();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getRedefinableHeader <em>Redefinable Header</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Conformance Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conformance Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conformance Class</em>' containment reference.
   * @see #isSetConformanceClass()
   * @see #unsetConformanceClass()
   * @see #setConformanceClass(ConformanceClass)
   * @generated
   */
  ConformanceClass getConformanceClass();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getConformanceClass <em>Conformance Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conformance Class</em>' containment reference.
   * @see #isSetConformanceClass()
   * @see #unsetConformanceClass()
   * @see #getConformanceClass()
   * @generated
   */
  void setConformanceClass(ConformanceClass value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getConformanceClass <em>Conformance Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetConformanceClass()
   * @see #getConformanceClass()
   * @see #setConformanceClass(ConformanceClass)
   * @generated
   */
  void unsetConformanceClass();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getConformanceClass <em>Conformance Class</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Conformance Class</em>' containment reference is set.
   * @see #unsetConformanceClass()
   * @see #getConformanceClass()
   * @see #setConformanceClass(ConformanceClass)
   * @generated
   */
  boolean isSetConformanceClass();

  /**
   * Returns the value of the '<em><b>Script</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Script</em>' containment reference.
   * @see #isSetScript()
   * @see #unsetScript()
   * @see #setScript(Script)
   * @generated
   */
  Script getScript();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getScript <em>Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Script</em>' containment reference.
   * @see #isSetScript()
   * @see #unsetScript()
   * @see #getScript()
   * @generated
   */
  void setScript(Script value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getScript <em>Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetScript()
   * @see #getScript()
   * @see #setScript(Script)
   * @generated
   */
  void unsetScript();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getScript <em>Script</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Script</em>' containment reference is set.
   * @see #unsetScript()
   * @see #getScript()
   * @see #setScript(Script)
   * @generated
   */
  boolean isSetScript();

  /**
   * Returns the value of the '<em><b>External Packages</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Packages</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Packages</em>' containment reference.
   * @see #isSetExternalPackages()
   * @see #unsetExternalPackages()
   * @see #setExternalPackages(ExternalPackages)
   * @generated
   */
  ExternalPackages getExternalPackages();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExternalPackages <em>External Packages</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>External Packages</em>' containment reference.
   * @see #isSetExternalPackages()
   * @see #unsetExternalPackages()
   * @see #getExternalPackages()
   * @generated
   */
  void setExternalPackages(ExternalPackages value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExternalPackages <em>External Packages</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExternalPackages()
   * @see #getExternalPackages()
   * @see #setExternalPackages(ExternalPackages)
   * @generated
   */
  void unsetExternalPackages();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExternalPackages <em>External Packages</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>External Packages</em>' containment reference is set.
   * @see #unsetExternalPackages()
   * @see #getExternalPackages()
   * @see #setExternalPackages(ExternalPackages)
   * @generated
   */
  boolean isSetExternalPackages();

  /**
   * Returns the value of the '<em><b>Type Declarations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Declarations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Declarations</em>' containment reference.
   * @see #isSetTypeDeclarations()
   * @see #unsetTypeDeclarations()
   * @see #setTypeDeclarations(TypeDeclarations)
   * @generated
   */
  TypeDeclarations getTypeDeclarations();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getTypeDeclarations <em>Type Declarations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Declarations</em>' containment reference.
   * @see #isSetTypeDeclarations()
   * @see #unsetTypeDeclarations()
   * @see #getTypeDeclarations()
   * @generated
   */
  void setTypeDeclarations(TypeDeclarations value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getTypeDeclarations <em>Type Declarations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTypeDeclarations()
   * @see #getTypeDeclarations()
   * @see #setTypeDeclarations(TypeDeclarations)
   * @generated
   */
  void unsetTypeDeclarations();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getTypeDeclarations <em>Type Declarations</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Type Declarations</em>' containment reference is set.
   * @see #unsetTypeDeclarations()
   * @see #getTypeDeclarations()
   * @see #setTypeDeclarations(TypeDeclarations)
   * @generated
   */
  boolean isSetTypeDeclarations();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getParticipants <em>Participants</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getParticipants <em>Participants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParticipants()
   * @see #getParticipants()
   * @see #setParticipants(Participants)
   * @generated
   */
  void unsetParticipants();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getParticipants <em>Participants</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getApplications <em>Applications</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getApplications <em>Applications</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetApplications()
   * @see #getApplications()
   * @see #setApplications(Applications)
   * @generated
   */
  void unsetApplications();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getApplications <em>Applications</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getDataFields <em>Data Fields</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getDataFields <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataFields()
   * @see #getDataFields()
   * @see #setDataFields(DataFields)
   * @generated
   */
  void unsetDataFields();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getDataFields <em>Data Fields</em>}' containment reference is set.
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
   * Returns the value of the '<em><b>Workflow Processes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Workflow Processes</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Workflow Processes</em>' containment reference.
   * @see #isSetWorkflowProcesses()
   * @see #unsetWorkflowProcesses()
   * @see #setWorkflowProcesses(WorkflowProcesses)
   * @generated
   */
  WorkflowProcesses getWorkflowProcesses();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getWorkflowProcesses <em>Workflow Processes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Workflow Processes</em>' containment reference.
   * @see #isSetWorkflowProcesses()
   * @see #unsetWorkflowProcesses()
   * @see #getWorkflowProcesses()
   * @generated
   */
  void setWorkflowProcesses(WorkflowProcesses value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getWorkflowProcesses <em>Workflow Processes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWorkflowProcesses()
   * @see #getWorkflowProcesses()
   * @see #setWorkflowProcesses(WorkflowProcesses)
   * @generated
   */
  void unsetWorkflowProcesses();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getWorkflowProcesses <em>Workflow Processes</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Workflow Processes</em>' containment reference is set.
   * @see #unsetWorkflowProcesses()
   * @see #getWorkflowProcesses()
   * @see #setWorkflowProcesses(WorkflowProcesses)
   * @generated
   */
  boolean isSetWorkflowProcesses();

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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExtendedAttributes <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetExtendedAttributes()
   * @see #getExtendedAttributes()
   * @see #setExtendedAttributes(ExtendedAttributes)
   * @generated
   */
  void unsetExtendedAttributes();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getExtendedAttributes <em>Extended Attributes</em>}' containment reference is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getId <em>Id</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(String)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getId <em>Id</em>}' attribute is set.
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
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl1.Package#getName <em>Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Name</em>' attribute is set.
   * @see #unsetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  boolean isSetName();

} // Package
