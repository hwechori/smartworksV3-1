/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageHeaderImpl.java,v 1.1 2009/12/22 06:17:29 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.CostUnit;
import net.smartworks.server.engine.process.xpdl.xpdl2.Created;
import net.smartworks.server.engine.process.xpdl.xpdl2.Description;
import net.smartworks.server.engine.process.xpdl.xpdl2.Documentation;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageHeader;
import net.smartworks.server.engine.process.xpdl.xpdl2.PriorityUnit;
import net.smartworks.server.engine.process.xpdl.xpdl2.Vendor;
import net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtensions;
import net.smartworks.server.engine.process.xpdl.xpdl2.XPDLVersion;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getXPDLVersion <em>XPDL Version</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getVendor <em>Vendor</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getPriorityUnit <em>Priority Unit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getCostUnit <em>Cost Unit</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getVendorExtensions <em>Vendor Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PackageHeaderImpl#getAnyAttribute <em>Any Attribute</em>}</li>
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

  public final static int VENDOR_EXTENSIONS = 7;

  public final static int ANY = -1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 8;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>XPDL Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XPDL_VERSION = 0;

  /**
   * The internal feature id for the '<em><b>Vendor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VENDOR = 1;

  /**
   * The internal feature id for the '<em><b>Created</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CREATED = 2;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 3;

  /**
   * The internal feature id for the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DOCUMENTATION = 4;

  /**
   * The internal feature id for the '<em><b>Priority Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRIORITY_UNIT = 5;

  /**
   * The internal feature id for the '<em><b>Cost Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COST_UNIT = 6;

  /**
   * The internal feature id for the '<em><b>Vendor Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VENDOR_EXTENSIONS = 7;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 8;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 9;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 10;

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
      case INTERNAL_VENDOR_EXTENSIONS: return VENDOR_EXTENSIONS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getXPDLVersion() <em>XPDL Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXPDLVersion()
   * @generated
   * @ordered
   */
  
  protected XPDLVersion xpdlVersion = null;
  
  /**
   * This is true if the XPDL Version containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xpdlVersion_set_ = false;

  /**
   * The cached value of the '{@link #getVendor() <em>Vendor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVendor()
   * @generated
   * @ordered
   */
  
  protected Vendor vendor = null;
  
  /**
   * This is true if the Vendor containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean vendor_set_ = false;

  /**
   * The cached value of the '{@link #getCreated() <em>Created</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreated()
   * @generated
   * @ordered
   */
  
  protected Created created = null;
  
  /**
   * This is true if the Created containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean created_set_ = false;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  
  protected Description description = null;
  
  /**
   * This is true if the Description containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean description_set_ = false;

  /**
   * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  
  protected Documentation documentation = null;
  
  /**
   * This is true if the Documentation containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean documentation_set_ = false;

  /**
   * The cached value of the '{@link #getPriorityUnit() <em>Priority Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriorityUnit()
   * @generated
   * @ordered
   */
  
  protected PriorityUnit priorityUnit = null;
  
  /**
   * This is true if the Priority Unit containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean priorityUnit_set_ = false;

  /**
   * The cached value of the '{@link #getCostUnit() <em>Cost Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCostUnit()
   * @generated
   * @ordered
   */
  
  protected CostUnit costUnit = null;
  
  /**
   * This is true if the Cost Unit containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean costUnit_set_ = false;

  /**
   * The cached value of the '{@link #getVendorExtensions() <em>Vendor Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVendorExtensions()
   * @generated
   * @ordered
   */
  
  protected VendorExtensions vendorExtensions = null;
  
  /**
   * This is true if the Vendor Extensions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean vendorExtensions_set_ = false;

  /**
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  
  protected Sequence any = null;
  
  /**
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  
  protected Sequence anyAttribute = null;
  
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getPackageHeader();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XPDLVersion getXPDLVersion()
  {
    return xpdlVersion;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetXPDLVersion(XPDLVersion newXPDLVersion, ChangeContext changeContext)
  {
    XPDLVersion oldXPDLVersion = xpdlVersion;
    xpdlVersion = newXPDLVersion;
    boolean oldXPDLVersion_set_ = xpdlVersion_set_;
    xpdlVersion_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_XPDL_VERSION, oldXPDLVersion, newXPDLVersion, !oldXPDLVersion_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXPDLVersion(XPDLVersion newXPDLVersion)
  {
    if (newXPDLVersion != xpdlVersion)
    {
      ChangeContext changeContext = null;
      if (xpdlVersion != null)
        changeContext = inverseRemove(xpdlVersion, this, OPPOSITE_FEATURE_BASE - INTERNAL_XPDL_VERSION, null, changeContext);
      if (newXPDLVersion != null)
        changeContext = inverseAdd(newXPDLVersion, this, OPPOSITE_FEATURE_BASE - INTERNAL_XPDL_VERSION, null, changeContext);
      changeContext = basicSetXPDLVersion(newXPDLVersion, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldXPDLVersion_set_ = xpdlVersion_set_;
      xpdlVersion_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_XPDL_VERSION, newXPDLVersion, newXPDLVersion, !oldXPDLVersion_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetXPDLVersion(ChangeContext changeContext)
  {
    XPDLVersion oldXPDLVersion = xpdlVersion;
    xpdlVersion = null;
    boolean oldXPDLVersion_set_ = xpdlVersion_set_;
    xpdlVersion_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_XPDL_VERSION, oldXPDLVersion, null, !oldXPDLVersion_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXPDLVersion()
  {
    if (xpdlVersion != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(xpdlVersion, this, EOPPOSITE_FEATURE_BASE - INTERNAL_XPDL_VERSION, null, changeContext);
      changeContext = basicUnsetXPDLVersion(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldXPDLVersion_set_ = xpdlVersion_set_;
      xpdlVersion_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_XPDL_VERSION, null, null, oldXPDLVersion_set_);
    	}
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
  public Vendor getVendor()
  {
    return vendor;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetVendor(Vendor newVendor, ChangeContext changeContext)
  {
    Vendor oldVendor = vendor;
    vendor = newVendor;
    boolean oldVendor_set_ = vendor_set_;
    vendor_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_VENDOR, oldVendor, newVendor, !oldVendor_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVendor(Vendor newVendor)
  {
    if (newVendor != vendor)
    {
      ChangeContext changeContext = null;
      if (vendor != null)
        changeContext = inverseRemove(vendor, this, OPPOSITE_FEATURE_BASE - INTERNAL_VENDOR, null, changeContext);
      if (newVendor != null)
        changeContext = inverseAdd(newVendor, this, OPPOSITE_FEATURE_BASE - INTERNAL_VENDOR, null, changeContext);
      changeContext = basicSetVendor(newVendor, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldVendor_set_ = vendor_set_;
      vendor_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_VENDOR, newVendor, newVendor, !oldVendor_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetVendor(ChangeContext changeContext)
  {
    Vendor oldVendor = vendor;
    vendor = null;
    boolean oldVendor_set_ = vendor_set_;
    vendor_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_VENDOR, oldVendor, null, !oldVendor_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVendor()
  {
    if (vendor != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(vendor, this, EOPPOSITE_FEATURE_BASE - INTERNAL_VENDOR, null, changeContext);
      changeContext = basicUnsetVendor(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldVendor_set_ = vendor_set_;
      vendor_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_VENDOR, null, null, oldVendor_set_);
    	}
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
  public Created getCreated()
  {
    return created;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetCreated(Created newCreated, ChangeContext changeContext)
  {
    Created oldCreated = created;
    created = newCreated;
    boolean oldCreated_set_ = created_set_;
    created_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_CREATED, oldCreated, newCreated, !oldCreated_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreated(Created newCreated)
  {
    if (newCreated != created)
    {
      ChangeContext changeContext = null;
      if (created != null)
        changeContext = inverseRemove(created, this, OPPOSITE_FEATURE_BASE - INTERNAL_CREATED, null, changeContext);
      if (newCreated != null)
        changeContext = inverseAdd(newCreated, this, OPPOSITE_FEATURE_BASE - INTERNAL_CREATED, null, changeContext);
      changeContext = basicSetCreated(newCreated, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldCreated_set_ = created_set_;
      created_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_CREATED, newCreated, newCreated, !oldCreated_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetCreated(ChangeContext changeContext)
  {
    Created oldCreated = created;
    created = null;
    boolean oldCreated_set_ = created_set_;
    created_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_CREATED, oldCreated, null, !oldCreated_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCreated()
  {
    if (created != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(created, this, EOPPOSITE_FEATURE_BASE - INTERNAL_CREATED, null, changeContext);
      changeContext = basicUnsetCreated(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldCreated_set_ = created_set_;
      created_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_CREATED, null, null, oldCreated_set_);
    	}
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
  public Description getDescription()
  {
    return description;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDescription(Description newDescription, ChangeContext changeContext)
  {
    Description oldDescription = description;
    description = newDescription;
    boolean oldDescription_set_ = description_set_;
    description_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DESCRIPTION, oldDescription, newDescription, !oldDescription_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(Description newDescription)
  {
    if (newDescription != description)
    {
      ChangeContext changeContext = null;
      if (description != null)
        changeContext = inverseRemove(description, this, OPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      if (newDescription != null)
        changeContext = inverseAdd(newDescription, this, OPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      changeContext = basicSetDescription(newDescription, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDescription_set_ = description_set_;
      description_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DESCRIPTION, newDescription, newDescription, !oldDescription_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDescription(ChangeContext changeContext)
  {
    Description oldDescription = description;
    description = null;
    boolean oldDescription_set_ = description_set_;
    description_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DESCRIPTION, oldDescription, null, !oldDescription_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDescription()
  {
    if (description != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(description, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DESCRIPTION, null, changeContext);
      changeContext = basicUnsetDescription(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDescription_set_ = description_set_;
      description_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DESCRIPTION, null, null, oldDescription_set_);
    	}
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
  public Documentation getDocumentation()
  {
    return documentation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDocumentation(Documentation newDocumentation, ChangeContext changeContext)
  {
    Documentation oldDocumentation = documentation;
    documentation = newDocumentation;
    boolean oldDocumentation_set_ = documentation_set_;
    documentation_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DOCUMENTATION, oldDocumentation, newDocumentation, !oldDocumentation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocumentation(Documentation newDocumentation)
  {
    if (newDocumentation != documentation)
    {
      ChangeContext changeContext = null;
      if (documentation != null)
        changeContext = inverseRemove(documentation, this, OPPOSITE_FEATURE_BASE - INTERNAL_DOCUMENTATION, null, changeContext);
      if (newDocumentation != null)
        changeContext = inverseAdd(newDocumentation, this, OPPOSITE_FEATURE_BASE - INTERNAL_DOCUMENTATION, null, changeContext);
      changeContext = basicSetDocumentation(newDocumentation, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDocumentation_set_ = documentation_set_;
      documentation_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DOCUMENTATION, newDocumentation, newDocumentation, !oldDocumentation_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDocumentation(ChangeContext changeContext)
  {
    Documentation oldDocumentation = documentation;
    documentation = null;
    boolean oldDocumentation_set_ = documentation_set_;
    documentation_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DOCUMENTATION, oldDocumentation, null, !oldDocumentation_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDocumentation()
  {
    if (documentation != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(documentation, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DOCUMENTATION, null, changeContext);
      changeContext = basicUnsetDocumentation(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDocumentation_set_ = documentation_set_;
      documentation_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DOCUMENTATION, null, null, oldDocumentation_set_);
    	}
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
  public PriorityUnit getPriorityUnit()
  {
    return priorityUnit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPriorityUnit(PriorityUnit newPriorityUnit, ChangeContext changeContext)
  {
    PriorityUnit oldPriorityUnit = priorityUnit;
    priorityUnit = newPriorityUnit;
    boolean oldPriorityUnit_set_ = priorityUnit_set_;
    priorityUnit_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PRIORITY_UNIT, oldPriorityUnit, newPriorityUnit, !oldPriorityUnit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriorityUnit(PriorityUnit newPriorityUnit)
  {
    if (newPriorityUnit != priorityUnit)
    {
      ChangeContext changeContext = null;
      if (priorityUnit != null)
        changeContext = inverseRemove(priorityUnit, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY_UNIT, null, changeContext);
      if (newPriorityUnit != null)
        changeContext = inverseAdd(newPriorityUnit, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY_UNIT, null, changeContext);
      changeContext = basicSetPriorityUnit(newPriorityUnit, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPriorityUnit_set_ = priorityUnit_set_;
      priorityUnit_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PRIORITY_UNIT, newPriorityUnit, newPriorityUnit, !oldPriorityUnit_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPriorityUnit(ChangeContext changeContext)
  {
    PriorityUnit oldPriorityUnit = priorityUnit;
    priorityUnit = null;
    boolean oldPriorityUnit_set_ = priorityUnit_set_;
    priorityUnit_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PRIORITY_UNIT, oldPriorityUnit, null, !oldPriorityUnit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPriorityUnit()
  {
    if (priorityUnit != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(priorityUnit, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PRIORITY_UNIT, null, changeContext);
      changeContext = basicUnsetPriorityUnit(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPriorityUnit_set_ = priorityUnit_set_;
      priorityUnit_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PRIORITY_UNIT, null, null, oldPriorityUnit_set_);
    	}
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
  public CostUnit getCostUnit()
  {
    return costUnit;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetCostUnit(CostUnit newCostUnit, ChangeContext changeContext)
  {
    CostUnit oldCostUnit = costUnit;
    costUnit = newCostUnit;
    boolean oldCostUnit_set_ = costUnit_set_;
    costUnit_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_COST_UNIT, oldCostUnit, newCostUnit, !oldCostUnit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCostUnit(CostUnit newCostUnit)
  {
    if (newCostUnit != costUnit)
    {
      ChangeContext changeContext = null;
      if (costUnit != null)
        changeContext = inverseRemove(costUnit, this, OPPOSITE_FEATURE_BASE - INTERNAL_COST_UNIT, null, changeContext);
      if (newCostUnit != null)
        changeContext = inverseAdd(newCostUnit, this, OPPOSITE_FEATURE_BASE - INTERNAL_COST_UNIT, null, changeContext);
      changeContext = basicSetCostUnit(newCostUnit, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldCostUnit_set_ = costUnit_set_;
      costUnit_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_COST_UNIT, newCostUnit, newCostUnit, !oldCostUnit_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetCostUnit(ChangeContext changeContext)
  {
    CostUnit oldCostUnit = costUnit;
    costUnit = null;
    boolean oldCostUnit_set_ = costUnit_set_;
    costUnit_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_COST_UNIT, oldCostUnit, null, !oldCostUnit_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCostUnit()
  {
    if (costUnit != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(costUnit, this, EOPPOSITE_FEATURE_BASE - INTERNAL_COST_UNIT, null, changeContext);
      changeContext = basicUnsetCostUnit(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldCostUnit_set_ = costUnit_set_;
      costUnit_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_COST_UNIT, null, null, oldCostUnit_set_);
    	}
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
  public VendorExtensions getVendorExtensions()
  {
    return vendorExtensions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetVendorExtensions(VendorExtensions newVendorExtensions, ChangeContext changeContext)
  {
    VendorExtensions oldVendorExtensions = vendorExtensions;
    vendorExtensions = newVendorExtensions;
    boolean oldVendorExtensions_set_ = vendorExtensions_set_;
    vendorExtensions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_VENDOR_EXTENSIONS, oldVendorExtensions, newVendorExtensions, !oldVendorExtensions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVendorExtensions(VendorExtensions newVendorExtensions)
  {
    if (newVendorExtensions != vendorExtensions)
    {
      ChangeContext changeContext = null;
      if (vendorExtensions != null)
        changeContext = inverseRemove(vendorExtensions, this, OPPOSITE_FEATURE_BASE - INTERNAL_VENDOR_EXTENSIONS, null, changeContext);
      if (newVendorExtensions != null)
        changeContext = inverseAdd(newVendorExtensions, this, OPPOSITE_FEATURE_BASE - INTERNAL_VENDOR_EXTENSIONS, null, changeContext);
      changeContext = basicSetVendorExtensions(newVendorExtensions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldVendorExtensions_set_ = vendorExtensions_set_;
      vendorExtensions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_VENDOR_EXTENSIONS, newVendorExtensions, newVendorExtensions, !oldVendorExtensions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetVendorExtensions(ChangeContext changeContext)
  {
    VendorExtensions oldVendorExtensions = vendorExtensions;
    vendorExtensions = null;
    boolean oldVendorExtensions_set_ = vendorExtensions_set_;
    vendorExtensions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_VENDOR_EXTENSIONS, oldVendorExtensions, null, !oldVendorExtensions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVendorExtensions()
  {
    if (vendorExtensions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(vendorExtensions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_VENDOR_EXTENSIONS, null, changeContext);
      changeContext = basicUnsetVendorExtensions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldVendorExtensions_set_ = vendorExtensions_set_;
      vendorExtensions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_VENDOR_EXTENSIONS, null, null, oldVendorExtensions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetVendorExtensions()
  {
    return vendorExtensions_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAny()
  {
    if (any == null)
    {
      any = createSequence(INTERNAL_ANY);
    }
    return any;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAnyAttribute()
  {
    if (anyAttribute == null)
    {
      anyAttribute = createSequence(INTERNAL_ANY_ATTRIBUTE);
    }
    return anyAttribute;
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
      case XPDL_VERSION:
        return basicUnsetXPDLVersion(changeContext);
      case VENDOR:
        return basicUnsetVendor(changeContext);
      case CREATED:
        return basicUnsetCreated(changeContext);
      case DESCRIPTION:
        return basicUnsetDescription(changeContext);
      case DOCUMENTATION:
        return basicUnsetDocumentation(changeContext);
      case PRIORITY_UNIT:
        return basicUnsetPriorityUnit(changeContext);
      case COST_UNIT:
        return basicUnsetCostUnit(changeContext);
      case VENDOR_EXTENSIONS:
        return basicUnsetVendorExtensions(changeContext);
      case ANY:
        return removeFromSequence(getAny(), otherEnd, changeContext);
      case ANY_ATTRIBUTE:
        return removeFromSequence(getAnyAttribute(), otherEnd, changeContext);
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
      case VENDOR_EXTENSIONS:
        return getVendorExtensions();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ANY_ATTRIBUTE:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAnyAttribute();
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
        setXPDLVersion((XPDLVersion)newValue);
        return;
      case VENDOR:
        setVendor((Vendor)newValue);
        return;
      case CREATED:
        setCreated((Created)newValue);
        return;
      case DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case DOCUMENTATION:
        setDocumentation((Documentation)newValue);
        return;
      case PRIORITY_UNIT:
        setPriorityUnit((PriorityUnit)newValue);
        return;
      case COST_UNIT:
        setCostUnit((CostUnit)newValue);
        return;
      case VENDOR_EXTENSIONS:
        setVendorExtensions((VendorExtensions)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case ANY_ATTRIBUTE:
      	setSequence(getAnyAttribute(), newValue);
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
      case VENDOR_EXTENSIONS:
        unsetVendorExtensions();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case ANY_ATTRIBUTE:
        unsetSequence(getAnyAttribute());
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
      case VENDOR_EXTENSIONS:
        return isSetVendorExtensions();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ANY_ATTRIBUTE:
        return anyAttribute != null && !isSequenceEmpty(getAnyAttribute());
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
    result.append(" (any: ");
    result.append(any);
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //PackageHeaderImpl
