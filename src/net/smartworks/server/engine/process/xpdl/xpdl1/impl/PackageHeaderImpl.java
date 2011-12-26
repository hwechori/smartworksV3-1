/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageHeaderImpl.java,v 1.1 2009/12/22 06:17:23 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.PackageHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageHeaderImpl#getXPDLVersion <em>XPDL Version</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageHeaderImpl#getVendor <em>Vendor</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageHeaderImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageHeaderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageHeaderImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageHeaderImpl#getPriorityUnit <em>Priority Unit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageHeaderImpl#getCostUnit <em>Cost Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageHeaderImpl extends DataObjectBase implements PackageHeader
{

  public final static int XPDL_VERSION = 0;

  public final static int VENDOR = 1;

  public final static int CREATED = 2;

  public final static int DESCRIPTION = 3;

  public final static int DOCUMENTATION = 4;

  public final static int PRIORITY_UNIT = 5;

  public final static int COST_UNIT = 6;

  public final static int SDO_PROPERTY_COUNT = 7;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>XPDL Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XPDL_VERSION = 0;

  /**
   * The internal feature id for the '<em><b>Vendor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VENDOR = 1;

  /**
   * The internal feature id for the '<em><b>Created</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CREATED = 2;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 3;

  /**
   * The internal feature id for the '<em><b>Documentation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DOCUMENTATION = 4;

  /**
   * The internal feature id for the '<em><b>Priority Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRIORITY_UNIT = 5;

  /**
   * The internal feature id for the '<em><b>Cost Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COST_UNIT = 6;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 7;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_XPDL_VERSION: return XPDL_VERSION;
      case INTERNAL_VENDOR: return VENDOR;
      case INTERNAL_CREATED: return CREATED;
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_DOCUMENTATION: return DOCUMENTATION;
      case INTERNAL_PRIORITY_UNIT: return PRIORITY_UNIT;
      case INTERNAL_COST_UNIT: return COST_UNIT;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getXPDLVersion() <em>XPDL Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXPDLVersion()
   * @generated
   * @ordered
   */
  protected static final String XPDL_VERSION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getXPDLVersion() <em>XPDL Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXPDLVersion()
   * @generated
   * @ordered
   */
  protected String xpdlVersion = XPDL_VERSION_DEFAULT_;

  /**
   * This is true if the XPDL Version attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xpdlVersion_set_ = false;

  /**
   * The default value of the '{@link #getVendor() <em>Vendor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVendor()
   * @generated
   * @ordered
   */
  protected static final String VENDOR_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getVendor() <em>Vendor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVendor()
   * @generated
   * @ordered
   */
  protected String vendor = VENDOR_DEFAULT_;

  /**
   * This is true if the Vendor attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean vendor_set_ = false;

  /**
   * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreated()
   * @generated
   * @ordered
   */
  protected static final String CREATED_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreated()
   * @generated
   * @ordered
   */
  protected String created = CREATED_DEFAULT_;

  /**
   * This is true if the Created attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean created_set_ = false;

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
   * The default value of the '{@link #getPriorityUnit() <em>Priority Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriorityUnit()
   * @generated
   * @ordered
   */
  protected static final String PRIORITY_UNIT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPriorityUnit() <em>Priority Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriorityUnit()
   * @generated
   * @ordered
   */
  protected String priorityUnit = PRIORITY_UNIT_DEFAULT_;

  /**
   * This is true if the Priority Unit attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean priorityUnit_set_ = false;

  /**
   * The default value of the '{@link #getCostUnit() <em>Cost Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCostUnit()
   * @generated
   * @ordered
   */
  protected static final String COST_UNIT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCostUnit() <em>Cost Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCostUnit()
   * @generated
   * @ordered
   */
  protected String costUnit = COST_UNIT_DEFAULT_;

  /**
   * This is true if the Cost Unit attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean costUnit_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageHeaderImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getPackageHeader();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getXPDLVersion()
  {
    return xpdlVersion;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXPDLVersion(String newXPDLVersion)
  {
    String oldXPDLVersion = xpdlVersion;
    xpdlVersion = newXPDLVersion;
    boolean oldXPDLVersion_set_ = xpdlVersion_set_;
    xpdlVersion_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_XPDL_VERSION, oldXPDLVersion, xpdlVersion, !oldXPDLVersion_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXPDLVersion()
  {
    String oldXPDLVersion = xpdlVersion;
    boolean oldXPDLVersion_set_ = xpdlVersion_set_;
    xpdlVersion = XPDL_VERSION_DEFAULT_;
    xpdlVersion_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_XPDL_VERSION, oldXPDLVersion, XPDL_VERSION_DEFAULT_, oldXPDLVersion_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetXPDLVersion()
  {
    return xpdlVersion_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVendor()
  {
    return vendor;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVendor(String newVendor)
  {
    String oldVendor = vendor;
    vendor = newVendor;
    boolean oldVendor_set_ = vendor_set_;
    vendor_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_VENDOR, oldVendor, vendor, !oldVendor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVendor()
  {
    String oldVendor = vendor;
    boolean oldVendor_set_ = vendor_set_;
    vendor = VENDOR_DEFAULT_;
    vendor_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_VENDOR, oldVendor, VENDOR_DEFAULT_, oldVendor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetVendor()
  {
    return vendor_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCreated()
  {
    return created;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreated(String newCreated)
  {
    String oldCreated = created;
    created = newCreated;
    boolean oldCreated_set_ = created_set_;
    created_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_CREATED, oldCreated, created, !oldCreated_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCreated()
  {
    String oldCreated = created;
    boolean oldCreated_set_ = created_set_;
    created = CREATED_DEFAULT_;
    created_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_CREATED, oldCreated, CREATED_DEFAULT_, oldCreated_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCreated()
  {
    return created_set_;
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
  public String getPriorityUnit()
  {
    return priorityUnit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriorityUnit(String newPriorityUnit)
  {
    String oldPriorityUnit = priorityUnit;
    priorityUnit = newPriorityUnit;
    boolean oldPriorityUnit_set_ = priorityUnit_set_;
    priorityUnit_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PRIORITY_UNIT, oldPriorityUnit, priorityUnit, !oldPriorityUnit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPriorityUnit()
  {
    String oldPriorityUnit = priorityUnit;
    boolean oldPriorityUnit_set_ = priorityUnit_set_;
    priorityUnit = PRIORITY_UNIT_DEFAULT_;
    priorityUnit_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PRIORITY_UNIT, oldPriorityUnit, PRIORITY_UNIT_DEFAULT_, oldPriorityUnit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPriorityUnit()
  {
    return priorityUnit_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCostUnit()
  {
    return costUnit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCostUnit(String newCostUnit)
  {
    String oldCostUnit = costUnit;
    costUnit = newCostUnit;
    boolean oldCostUnit_set_ = costUnit_set_;
    costUnit_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_COST_UNIT, oldCostUnit, costUnit, !oldCostUnit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCostUnit()
  {
    String oldCostUnit = costUnit;
    boolean oldCostUnit_set_ = costUnit_set_;
    costUnit = COST_UNIT_DEFAULT_;
    costUnit_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_COST_UNIT, oldCostUnit, COST_UNIT_DEFAULT_, oldCostUnit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCostUnit()
  {
    return costUnit_set_;
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
      case XPDL_VERSION:
        return getXPDLVersion();
      case VENDOR:
        return getVendor();
      case CREATED:
        return getCreated();
      case DESCRIPTION:
        return getDescription();
      case DOCUMENTATION:
        return getDocumentation();
      case PRIORITY_UNIT:
        return getPriorityUnit();
      case COST_UNIT:
        return getCostUnit();
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
      case XPDL_VERSION:
        setXPDLVersion((String)newValue);
        return;
      case VENDOR:
        setVendor((String)newValue);
        return;
      case CREATED:
        setCreated((String)newValue);
        return;
      case DESCRIPTION:
        setDescription((String)newValue);
        return;
      case DOCUMENTATION:
        setDocumentation((String)newValue);
        return;
      case PRIORITY_UNIT:
        setPriorityUnit((String)newValue);
        return;
      case COST_UNIT:
        setCostUnit((String)newValue);
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
      case XPDL_VERSION:
        unsetXPDLVersion();
        return;
      case VENDOR:
        unsetVendor();
        return;
      case CREATED:
        unsetCreated();
        return;
      case DESCRIPTION:
        unsetDescription();
        return;
      case DOCUMENTATION:
        unsetDocumentation();
        return;
      case PRIORITY_UNIT:
        unsetPriorityUnit();
        return;
      case COST_UNIT:
        unsetCostUnit();
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
      case XPDL_VERSION:
        return isSetXPDLVersion();
      case VENDOR:
        return isSetVendor();
      case CREATED:
        return isSetCreated();
      case DESCRIPTION:
        return isSetDescription();
      case DOCUMENTATION:
        return isSetDocumentation();
      case PRIORITY_UNIT:
        return isSetPriorityUnit();
      case COST_UNIT:
        return isSetCostUnit();
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
    result.append(" (XPDLVersion: ");
    if (xpdlVersion_set_) result.append(xpdlVersion); else result.append("<unset>");
    result.append(", Vendor: ");
    if (vendor_set_) result.append(vendor); else result.append("<unset>");
    result.append(", Created: ");
    if (created_set_) result.append(created); else result.append("<unset>");
    result.append(", Description: ");
    if (description_set_) result.append(description); else result.append("<unset>");
    result.append(", Documentation: ");
    if (documentation_set_) result.append(documentation); else result.append("<unset>");
    result.append(", PriorityUnit: ");
    if (priorityUnit_set_) result.append(priorityUnit); else result.append("<unset>");
    result.append(", CostUnit: ");
    if (costUnit_set_) result.append(costUnit); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //PackageHeaderImpl
