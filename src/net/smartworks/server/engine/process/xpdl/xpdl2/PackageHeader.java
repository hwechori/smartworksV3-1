/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageHeader.java,v 1.1 2009/12/22 06:18:13 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Header</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getXPDLVersion <em>XPDL Version</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendor <em>Vendor</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCreated <em>Created</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getPriorityUnit <em>Priority Unit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCostUnit <em>Cost Unit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendorExtensions <em>Vendor Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface PackageHeader extends Serializable
{
  /**
   * Returns the value of the '<em><b>XPDL Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XPDL Version</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>XPDL Version</em>' containment reference.
   * @see #isSetXPDLVersion()
   * @see #unsetXPDLVersion()
   * @see #setXPDLVersion(XPDLVersion)
   * @generated
   */
  XPDLVersion getXPDLVersion();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getXPDLVersion <em>XPDL Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>XPDL Version</em>' containment reference.
   * @see #isSetXPDLVersion()
   * @see #unsetXPDLVersion()
   * @see #getXPDLVersion()
   * @generated
   */
  void setXPDLVersion(XPDLVersion value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getXPDLVersion <em>XPDL Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetXPDLVersion()
   * @see #getXPDLVersion()
   * @see #setXPDLVersion(XPDLVersion)
   * @generated
   */
  void unsetXPDLVersion();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getXPDLVersion <em>XPDL Version</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>XPDL Version</em>' containment reference is set.
   * @see #unsetXPDLVersion()
   * @see #getXPDLVersion()
   * @see #setXPDLVersion(XPDLVersion)
   * @generated
   */
  boolean isSetXPDLVersion();

  /**
   * Returns the value of the '<em><b>Vendor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vendor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vendor</em>' containment reference.
   * @see #isSetVendor()
   * @see #unsetVendor()
   * @see #setVendor(Vendor)
   * @generated
   */
  Vendor getVendor();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendor <em>Vendor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vendor</em>' containment reference.
   * @see #isSetVendor()
   * @see #unsetVendor()
   * @see #getVendor()
   * @generated
   */
  void setVendor(Vendor value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendor <em>Vendor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetVendor()
   * @see #getVendor()
   * @see #setVendor(Vendor)
   * @generated
   */
  void unsetVendor();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendor <em>Vendor</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Vendor</em>' containment reference is set.
   * @see #unsetVendor()
   * @see #getVendor()
   * @see #setVendor(Vendor)
   * @generated
   */
  boolean isSetVendor();

  /**
   * Returns the value of the '<em><b>Created</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Created</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Created</em>' containment reference.
   * @see #isSetCreated()
   * @see #unsetCreated()
   * @see #setCreated(Created)
   * @generated
   */
  Created getCreated();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCreated <em>Created</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Created</em>' containment reference.
   * @see #isSetCreated()
   * @see #unsetCreated()
   * @see #getCreated()
   * @generated
   */
  void setCreated(Created value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCreated <em>Created</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCreated()
   * @see #getCreated()
   * @see #setCreated(Created)
   * @generated
   */
  void unsetCreated();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCreated <em>Created</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Created</em>' containment reference is set.
   * @see #unsetCreated()
   * @see #getCreated()
   * @see #setCreated(Created)
   * @generated
   */
  boolean isSetCreated();

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #setDescription(Description)
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #isSetDescription()
   * @see #unsetDescription()
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDescription()
   * @see #getDescription()
   * @see #setDescription(Description)
   * @generated
   */
  void unsetDescription();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDescription <em>Description</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Description</em>' containment reference is set.
   * @see #unsetDescription()
   * @see #getDescription()
   * @see #setDescription(Description)
   * @generated
   */
  boolean isSetDescription();

  /**
   * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' containment reference.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  Documentation getDocumentation();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Documentation</em>' containment reference.
   * @see #isSetDocumentation()
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @generated
   */
  void setDocumentation(Documentation value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  void unsetDocumentation();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getDocumentation <em>Documentation</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Documentation</em>' containment reference is set.
   * @see #unsetDocumentation()
   * @see #getDocumentation()
   * @see #setDocumentation(Documentation)
   * @generated
   */
  boolean isSetDocumentation();

  /**
   * Returns the value of the '<em><b>Priority Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority Unit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority Unit</em>' containment reference.
   * @see #isSetPriorityUnit()
   * @see #unsetPriorityUnit()
   * @see #setPriorityUnit(PriorityUnit)
   * @generated
   */
  PriorityUnit getPriorityUnit();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getPriorityUnit <em>Priority Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority Unit</em>' containment reference.
   * @see #isSetPriorityUnit()
   * @see #unsetPriorityUnit()
   * @see #getPriorityUnit()
   * @generated
   */
  void setPriorityUnit(PriorityUnit value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getPriorityUnit <em>Priority Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPriorityUnit()
   * @see #getPriorityUnit()
   * @see #setPriorityUnit(PriorityUnit)
   * @generated
   */
  void unsetPriorityUnit();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getPriorityUnit <em>Priority Unit</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Priority Unit</em>' containment reference is set.
   * @see #unsetPriorityUnit()
   * @see #getPriorityUnit()
   * @see #setPriorityUnit(PriorityUnit)
   * @generated
   */
  boolean isSetPriorityUnit();

  /**
   * Returns the value of the '<em><b>Cost Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cost Unit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cost Unit</em>' containment reference.
   * @see #isSetCostUnit()
   * @see #unsetCostUnit()
   * @see #setCostUnit(CostUnit)
   * @generated
   */
  CostUnit getCostUnit();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCostUnit <em>Cost Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cost Unit</em>' containment reference.
   * @see #isSetCostUnit()
   * @see #unsetCostUnit()
   * @see #getCostUnit()
   * @generated
   */
  void setCostUnit(CostUnit value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCostUnit <em>Cost Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCostUnit()
   * @see #getCostUnit()
   * @see #setCostUnit(CostUnit)
   * @generated
   */
  void unsetCostUnit();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getCostUnit <em>Cost Unit</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Cost Unit</em>' containment reference is set.
   * @see #unsetCostUnit()
   * @see #getCostUnit()
   * @see #setCostUnit(CostUnit)
   * @generated
   */
  boolean isSetCostUnit();

  /**
   * Returns the value of the '<em><b>Vendor Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vendor Extensions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vendor Extensions</em>' containment reference.
   * @see #isSetVendorExtensions()
   * @see #unsetVendorExtensions()
   * @see #setVendorExtensions(VendorExtensions)
   * @generated
   */
  VendorExtensions getVendorExtensions();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendorExtensions <em>Vendor Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vendor Extensions</em>' containment reference.
   * @see #isSetVendorExtensions()
   * @see #unsetVendorExtensions()
   * @see #getVendorExtensions()
   * @generated
   */
  void setVendorExtensions(VendorExtensions value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendorExtensions <em>Vendor Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetVendorExtensions()
   * @see #getVendorExtensions()
   * @see #setVendorExtensions(VendorExtensions)
   * @generated
   */
  void unsetVendorExtensions();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader#getVendorExtensions <em>Vendor Extensions</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Vendor Extensions</em>' containment reference is set.
   * @see #unsetVendorExtensions()
   * @see #getVendorExtensions()
   * @see #setVendorExtensions(VendorExtensions)
   * @generated
   */
  boolean isSetVendorExtensions();

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

} // PackageHeader
