/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageImpl.java,v 1.1 2009/12/22 06:17:20 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Applications;
import net.smartworks.server.engine.process.xpdl.xpdl1.ConformanceClass;
import net.smartworks.server.engine.process.xpdl.xpdl1.DataFields;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalPackages;
import net.smartworks.server.engine.process.xpdl.xpdl1.PackageHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.Participants;
import net.smartworks.server.engine.process.xpdl.xpdl1.RedefinableHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.Script;
import net.smartworks.server.engine.process.xpdl.xpdl1.TypeDeclarations;
import net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcesses;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getPackageHeader <em>Package Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getRedefinableHeader <em>Redefinable Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getConformanceClass <em>Conformance Class</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getScript <em>Script</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getExternalPackages <em>External Packages</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getTypeDeclarations <em>Type Declarations</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getApplications <em>Applications</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getWorkflowProcesses <em>Workflow Processes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.PackageImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends DataObjectBase implements net.smartworks.server.engine.process.xpdl.xpdl1.Package
{

  public final static int PACKAGE_HEADER = 0;

  public final static int REDEFINABLE_HEADER = 1;

  public final static int CONFORMANCE_CLASS = 2;

  public final static int SCRIPT = 3;

  public final static int EXTERNAL_PACKAGES = 4;

  public final static int TYPE_DECLARATIONS = 5;

  public final static int PARTICIPANTS = 6;

  public final static int APPLICATIONS = 7;

  public final static int DATA_FIELDS = 8;

  public final static int WORKFLOW_PROCESSES = 9;

  public final static int EXTENDED_ATTRIBUTES = 10;

  public final static int ID = 11;

  public final static int NAME = 12;

  public final static int SDO_PROPERTY_COUNT = 13;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Package Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PACKAGE_HEADER = 0;

  /**
   * The internal feature id for the '<em><b>Redefinable Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_REDEFINABLE_HEADER = 1;

  /**
   * The internal feature id for the '<em><b>Conformance Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CONFORMANCE_CLASS = 2;

  /**
   * The internal feature id for the '<em><b>Script</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SCRIPT = 3;

  /**
   * The internal feature id for the '<em><b>External Packages</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTERNAL_PACKAGES = 4;

  /**
   * The internal feature id for the '<em><b>Type Declarations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE_DECLARATIONS = 5;

  /**
   * The internal feature id for the '<em><b>Participants</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTICIPANTS = 6;

  /**
   * The internal feature id for the '<em><b>Applications</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_APPLICATIONS = 7;

  /**
   * The internal feature id for the '<em><b>Data Fields</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_FIELDS = 8;

  /**
   * The internal feature id for the '<em><b>Workflow Processes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WORKFLOW_PROCESSES = 9;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 10;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 11;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 12;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 13;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_PACKAGE_HEADER: return PACKAGE_HEADER;
      case INTERNAL_REDEFINABLE_HEADER: return REDEFINABLE_HEADER;
      case INTERNAL_CONFORMANCE_CLASS: return CONFORMANCE_CLASS;
      case INTERNAL_SCRIPT: return SCRIPT;
      case INTERNAL_EXTERNAL_PACKAGES: return EXTERNAL_PACKAGES;
      case INTERNAL_TYPE_DECLARATIONS: return TYPE_DECLARATIONS;
      case INTERNAL_PARTICIPANTS: return PARTICIPANTS;
      case INTERNAL_APPLICATIONS: return APPLICATIONS;
      case INTERNAL_DATA_FIELDS: return DATA_FIELDS;
      case INTERNAL_WORKFLOW_PROCESSES: return WORKFLOW_PROCESSES;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getPackageHeader() <em>Package Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageHeader()
   * @generated
   * @ordered
   */
  
  protected PackageHeader packageHeader = null;
  
  /**
   * This is true if the Package Header containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean packageHeader_set_ = false;

  /**
   * The cached value of the '{@link #getRedefinableHeader() <em>Redefinable Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinableHeader()
   * @generated
   * @ordered
   */
  
  protected RedefinableHeader redefinableHeader = null;
  
  /**
   * This is true if the Redefinable Header containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean redefinableHeader_set_ = false;

  /**
   * The cached value of the '{@link #getConformanceClass() <em>Conformance Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConformanceClass()
   * @generated
   * @ordered
   */
  
  protected ConformanceClass conformanceClass = null;
  
  /**
   * This is true if the Conformance Class containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean conformanceClass_set_ = false;

  /**
   * The cached value of the '{@link #getScript() <em>Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScript()
   * @generated
   * @ordered
   */
  
  protected Script script = null;
  
  /**
   * This is true if the Script containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean script_set_ = false;

  /**
   * The cached value of the '{@link #getExternalPackages() <em>External Packages</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalPackages()
   * @generated
   * @ordered
   */
  
  protected ExternalPackages externalPackages = null;
  
  /**
   * This is true if the External Packages containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean externalPackages_set_ = false;

  /**
   * The cached value of the '{@link #getTypeDeclarations() <em>Type Declarations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeDeclarations()
   * @generated
   * @ordered
   */
  
  protected TypeDeclarations typeDeclarations = null;
  
  /**
   * This is true if the Type Declarations containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean typeDeclarations_set_ = false;

  /**
   * The cached value of the '{@link #getParticipants() <em>Participants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticipants()
   * @generated
   * @ordered
   */
  
  protected Participants participants = null;
  
  /**
   * This is true if the Participants containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean participants_set_ = false;

  /**
   * The cached value of the '{@link #getApplications() <em>Applications</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplications()
   * @generated
   * @ordered
   */
  
  protected Applications applications = null;
  
  /**
   * This is true if the Applications containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean applications_set_ = false;

  /**
   * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataFields()
   * @generated
   * @ordered
   */
  
  protected DataFields dataFields = null;
  
  /**
   * This is true if the Data Fields containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataFields_set_ = false;

  /**
   * The cached value of the '{@link #getWorkflowProcesses() <em>Workflow Processes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorkflowProcesses()
   * @generated
   * @ordered
   */
  
  protected WorkflowProcesses workflowProcesses = null;
  
  /**
   * This is true if the Workflow Processes containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean workflowProcesses_set_ = false;

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
  public PackageImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageHeader getPackageHeader()
  {
    return packageHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPackageHeader(PackageHeader newPackageHeader, ChangeContext changeContext)
  {
    PackageHeader oldPackageHeader = packageHeader;
    packageHeader = newPackageHeader;
    boolean oldPackageHeader_set_ = packageHeader_set_;
    packageHeader_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PACKAGE_HEADER, oldPackageHeader, newPackageHeader, !oldPackageHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackageHeader(PackageHeader newPackageHeader)
  {
    if (newPackageHeader != packageHeader)
    {
      ChangeContext changeContext = null;
      if (packageHeader != null)
        changeContext = inverseRemove(packageHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_PACKAGE_HEADER, null, changeContext);
      if (newPackageHeader != null)
        changeContext = inverseAdd(newPackageHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_PACKAGE_HEADER, null, changeContext);
      changeContext = basicSetPackageHeader(newPackageHeader, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPackageHeader_set_ = packageHeader_set_;
      packageHeader_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PACKAGE_HEADER, newPackageHeader, newPackageHeader, !oldPackageHeader_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPackageHeader(ChangeContext changeContext)
  {
    PackageHeader oldPackageHeader = packageHeader;
    packageHeader = null;
    boolean oldPackageHeader_set_ = packageHeader_set_;
    packageHeader_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PACKAGE_HEADER, oldPackageHeader, null, !oldPackageHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPackageHeader()
  {
    if (packageHeader != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(packageHeader, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PACKAGE_HEADER, null, changeContext);
      changeContext = basicUnsetPackageHeader(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPackageHeader_set_ = packageHeader_set_;
      packageHeader_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PACKAGE_HEADER, null, null, oldPackageHeader_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPackageHeader()
  {
    return packageHeader_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinableHeader getRedefinableHeader()
  {
    return redefinableHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetRedefinableHeader(RedefinableHeader newRedefinableHeader, ChangeContext changeContext)
  {
    RedefinableHeader oldRedefinableHeader = redefinableHeader;
    redefinableHeader = newRedefinableHeader;
    boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
    redefinableHeader_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_REDEFINABLE_HEADER, oldRedefinableHeader, newRedefinableHeader, !oldRedefinableHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedefinableHeader(RedefinableHeader newRedefinableHeader)
  {
    if (newRedefinableHeader != redefinableHeader)
    {
      ChangeContext changeContext = null;
      if (redefinableHeader != null)
        changeContext = inverseRemove(redefinableHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      if (newRedefinableHeader != null)
        changeContext = inverseAdd(newRedefinableHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      changeContext = basicSetRedefinableHeader(newRedefinableHeader, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
      redefinableHeader_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_REDEFINABLE_HEADER, newRedefinableHeader, newRedefinableHeader, !oldRedefinableHeader_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetRedefinableHeader(ChangeContext changeContext)
  {
    RedefinableHeader oldRedefinableHeader = redefinableHeader;
    redefinableHeader = null;
    boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
    redefinableHeader_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_REDEFINABLE_HEADER, oldRedefinableHeader, null, !oldRedefinableHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRedefinableHeader()
  {
    if (redefinableHeader != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(redefinableHeader, this, EOPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      changeContext = basicUnsetRedefinableHeader(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
      redefinableHeader_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_REDEFINABLE_HEADER, null, null, oldRedefinableHeader_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRedefinableHeader()
  {
    return redefinableHeader_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConformanceClass getConformanceClass()
  {
    return conformanceClass;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetConformanceClass(ConformanceClass newConformanceClass, ChangeContext changeContext)
  {
    ConformanceClass oldConformanceClass = conformanceClass;
    conformanceClass = newConformanceClass;
    boolean oldConformanceClass_set_ = conformanceClass_set_;
    conformanceClass_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_CONFORMANCE_CLASS, oldConformanceClass, newConformanceClass, !oldConformanceClass_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConformanceClass(ConformanceClass newConformanceClass)
  {
    if (newConformanceClass != conformanceClass)
    {
      ChangeContext changeContext = null;
      if (conformanceClass != null)
        changeContext = inverseRemove(conformanceClass, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONFORMANCE_CLASS, null, changeContext);
      if (newConformanceClass != null)
        changeContext = inverseAdd(newConformanceClass, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONFORMANCE_CLASS, null, changeContext);
      changeContext = basicSetConformanceClass(newConformanceClass, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldConformanceClass_set_ = conformanceClass_set_;
      conformanceClass_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_CONFORMANCE_CLASS, newConformanceClass, newConformanceClass, !oldConformanceClass_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetConformanceClass(ChangeContext changeContext)
  {
    ConformanceClass oldConformanceClass = conformanceClass;
    conformanceClass = null;
    boolean oldConformanceClass_set_ = conformanceClass_set_;
    conformanceClass_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_CONFORMANCE_CLASS, oldConformanceClass, null, !oldConformanceClass_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetConformanceClass()
  {
    if (conformanceClass != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(conformanceClass, this, EOPPOSITE_FEATURE_BASE - INTERNAL_CONFORMANCE_CLASS, null, changeContext);
      changeContext = basicUnsetConformanceClass(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldConformanceClass_set_ = conformanceClass_set_;
      conformanceClass_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_CONFORMANCE_CLASS, null, null, oldConformanceClass_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetConformanceClass()
  {
    return conformanceClass_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Script getScript()
  {
    return script;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetScript(Script newScript, ChangeContext changeContext)
  {
    Script oldScript = script;
    script = newScript;
    boolean oldScript_set_ = script_set_;
    script_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SCRIPT, oldScript, newScript, !oldScript_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScript(Script newScript)
  {
    if (newScript != script)
    {
      ChangeContext changeContext = null;
      if (script != null)
        changeContext = inverseRemove(script, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCRIPT, null, changeContext);
      if (newScript != null)
        changeContext = inverseAdd(newScript, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCRIPT, null, changeContext);
      changeContext = basicSetScript(newScript, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldScript_set_ = script_set_;
      script_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SCRIPT, newScript, newScript, !oldScript_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetScript(ChangeContext changeContext)
  {
    Script oldScript = script;
    script = null;
    boolean oldScript_set_ = script_set_;
    script_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SCRIPT, oldScript, null, !oldScript_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetScript()
  {
    if (script != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(script, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SCRIPT, null, changeContext);
      changeContext = basicUnsetScript(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldScript_set_ = script_set_;
      script_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SCRIPT, null, null, oldScript_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetScript()
  {
    return script_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalPackages getExternalPackages()
  {
    return externalPackages;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExternalPackages(ExternalPackages newExternalPackages, ChangeContext changeContext)
  {
    ExternalPackages oldExternalPackages = externalPackages;
    externalPackages = newExternalPackages;
    boolean oldExternalPackages_set_ = externalPackages_set_;
    externalPackages_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTERNAL_PACKAGES, oldExternalPackages, newExternalPackages, !oldExternalPackages_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExternalPackages(ExternalPackages newExternalPackages)
  {
    if (newExternalPackages != externalPackages)
    {
      ChangeContext changeContext = null;
      if (externalPackages != null)
        changeContext = inverseRemove(externalPackages, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_PACKAGES, null, changeContext);
      if (newExternalPackages != null)
        changeContext = inverseAdd(newExternalPackages, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_PACKAGES, null, changeContext);
      changeContext = basicSetExternalPackages(newExternalPackages, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExternalPackages_set_ = externalPackages_set_;
      externalPackages_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTERNAL_PACKAGES, newExternalPackages, newExternalPackages, !oldExternalPackages_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExternalPackages(ChangeContext changeContext)
  {
    ExternalPackages oldExternalPackages = externalPackages;
    externalPackages = null;
    boolean oldExternalPackages_set_ = externalPackages_set_;
    externalPackages_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTERNAL_PACKAGES, oldExternalPackages, null, !oldExternalPackages_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExternalPackages()
  {
    if (externalPackages != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(externalPackages, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_PACKAGES, null, changeContext);
      changeContext = basicUnsetExternalPackages(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExternalPackages_set_ = externalPackages_set_;
      externalPackages_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTERNAL_PACKAGES, null, null, oldExternalPackages_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExternalPackages()
  {
    return externalPackages_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclarations getTypeDeclarations()
  {
    return typeDeclarations;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTypeDeclarations(TypeDeclarations newTypeDeclarations, ChangeContext changeContext)
  {
    TypeDeclarations oldTypeDeclarations = typeDeclarations;
    typeDeclarations = newTypeDeclarations;
    boolean oldTypeDeclarations_set_ = typeDeclarations_set_;
    typeDeclarations_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TYPE_DECLARATIONS, oldTypeDeclarations, newTypeDeclarations, !oldTypeDeclarations_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeDeclarations(TypeDeclarations newTypeDeclarations)
  {
    if (newTypeDeclarations != typeDeclarations)
    {
      ChangeContext changeContext = null;
      if (typeDeclarations != null)
        changeContext = inverseRemove(typeDeclarations, this, OPPOSITE_FEATURE_BASE - INTERNAL_TYPE_DECLARATIONS, null, changeContext);
      if (newTypeDeclarations != null)
        changeContext = inverseAdd(newTypeDeclarations, this, OPPOSITE_FEATURE_BASE - INTERNAL_TYPE_DECLARATIONS, null, changeContext);
      changeContext = basicSetTypeDeclarations(newTypeDeclarations, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTypeDeclarations_set_ = typeDeclarations_set_;
      typeDeclarations_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TYPE_DECLARATIONS, newTypeDeclarations, newTypeDeclarations, !oldTypeDeclarations_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTypeDeclarations(ChangeContext changeContext)
  {
    TypeDeclarations oldTypeDeclarations = typeDeclarations;
    typeDeclarations = null;
    boolean oldTypeDeclarations_set_ = typeDeclarations_set_;
    typeDeclarations_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TYPE_DECLARATIONS, oldTypeDeclarations, null, !oldTypeDeclarations_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTypeDeclarations()
  {
    if (typeDeclarations != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(typeDeclarations, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TYPE_DECLARATIONS, null, changeContext);
      changeContext = basicUnsetTypeDeclarations(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTypeDeclarations_set_ = typeDeclarations_set_;
      typeDeclarations_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TYPE_DECLARATIONS, null, null, oldTypeDeclarations_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTypeDeclarations()
  {
    return typeDeclarations_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Participants getParticipants()
  {
    return participants;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetParticipants(Participants newParticipants, ChangeContext changeContext)
  {
    Participants oldParticipants = participants;
    participants = newParticipants;
    boolean oldParticipants_set_ = participants_set_;
    participants_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTICIPANTS, oldParticipants, newParticipants, !oldParticipants_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParticipants(Participants newParticipants)
  {
    if (newParticipants != participants)
    {
      ChangeContext changeContext = null;
      if (participants != null)
        changeContext = inverseRemove(participants, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      if (newParticipants != null)
        changeContext = inverseAdd(newParticipants, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      changeContext = basicSetParticipants(newParticipants, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldParticipants_set_ = participants_set_;
      participants_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTICIPANTS, newParticipants, newParticipants, !oldParticipants_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetParticipants(ChangeContext changeContext)
  {
    Participants oldParticipants = participants;
    participants = null;
    boolean oldParticipants_set_ = participants_set_;
    participants_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTICIPANTS, oldParticipants, null, !oldParticipants_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParticipants()
  {
    if (participants != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(participants, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      changeContext = basicUnsetParticipants(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldParticipants_set_ = participants_set_;
      participants_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTICIPANTS, null, null, oldParticipants_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParticipants()
  {
    return participants_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Applications getApplications()
  {
    return applications;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetApplications(Applications newApplications, ChangeContext changeContext)
  {
    Applications oldApplications = applications;
    applications = newApplications;
    boolean oldApplications_set_ = applications_set_;
    applications_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_APPLICATIONS, oldApplications, newApplications, !oldApplications_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplications(Applications newApplications)
  {
    if (newApplications != applications)
    {
      ChangeContext changeContext = null;
      if (applications != null)
        changeContext = inverseRemove(applications, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      if (newApplications != null)
        changeContext = inverseAdd(newApplications, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      changeContext = basicSetApplications(newApplications, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldApplications_set_ = applications_set_;
      applications_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_APPLICATIONS, newApplications, newApplications, !oldApplications_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetApplications(ChangeContext changeContext)
  {
    Applications oldApplications = applications;
    applications = null;
    boolean oldApplications_set_ = applications_set_;
    applications_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_APPLICATIONS, oldApplications, null, !oldApplications_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetApplications()
  {
    if (applications != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(applications, this, EOPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      changeContext = basicUnsetApplications(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldApplications_set_ = applications_set_;
      applications_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_APPLICATIONS, null, null, oldApplications_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetApplications()
  {
    return applications_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataFields getDataFields()
  {
    return dataFields;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataFields(DataFields newDataFields, ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = newDataFields;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_FIELDS, oldDataFields, newDataFields, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataFields(DataFields newDataFields)
  {
    if (newDataFields != dataFields)
    {
      ChangeContext changeContext = null;
      if (dataFields != null)
        changeContext = inverseRemove(dataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      if (newDataFields != null)
        changeContext = inverseAdd(newDataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicSetDataFields(newDataFields, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_FIELDS, newDataFields, newDataFields, !oldDataFields_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataFields(ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = null;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_FIELDS, oldDataFields, null, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataFields()
  {
    if (dataFields != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataFields, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicUnsetDataFields(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_FIELDS, null, null, oldDataFields_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataFields()
  {
    return dataFields_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkflowProcesses getWorkflowProcesses()
  {
    return workflowProcesses;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetWorkflowProcesses(WorkflowProcesses newWorkflowProcesses, ChangeContext changeContext)
  {
    WorkflowProcesses oldWorkflowProcesses = workflowProcesses;
    workflowProcesses = newWorkflowProcesses;
    boolean oldWorkflowProcesses_set_ = workflowProcesses_set_;
    workflowProcesses_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_WORKFLOW_PROCESSES, oldWorkflowProcesses, newWorkflowProcesses, !oldWorkflowProcesses_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorkflowProcesses(WorkflowProcesses newWorkflowProcesses)
  {
    if (newWorkflowProcesses != workflowProcesses)
    {
      ChangeContext changeContext = null;
      if (workflowProcesses != null)
        changeContext = inverseRemove(workflowProcesses, this, OPPOSITE_FEATURE_BASE - INTERNAL_WORKFLOW_PROCESSES, null, changeContext);
      if (newWorkflowProcesses != null)
        changeContext = inverseAdd(newWorkflowProcesses, this, OPPOSITE_FEATURE_BASE - INTERNAL_WORKFLOW_PROCESSES, null, changeContext);
      changeContext = basicSetWorkflowProcesses(newWorkflowProcesses, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldWorkflowProcesses_set_ = workflowProcesses_set_;
      workflowProcesses_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_WORKFLOW_PROCESSES, newWorkflowProcesses, newWorkflowProcesses, !oldWorkflowProcesses_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetWorkflowProcesses(ChangeContext changeContext)
  {
    WorkflowProcesses oldWorkflowProcesses = workflowProcesses;
    workflowProcesses = null;
    boolean oldWorkflowProcesses_set_ = workflowProcesses_set_;
    workflowProcesses_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_WORKFLOW_PROCESSES, oldWorkflowProcesses, null, !oldWorkflowProcesses_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWorkflowProcesses()
  {
    if (workflowProcesses != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(workflowProcesses, this, EOPPOSITE_FEATURE_BASE - INTERNAL_WORKFLOW_PROCESSES, null, changeContext);
      changeContext = basicUnsetWorkflowProcesses(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldWorkflowProcesses_set_ = workflowProcesses_set_;
      workflowProcesses_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_WORKFLOW_PROCESSES, null, null, oldWorkflowProcesses_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetWorkflowProcesses()
  {
    return workflowProcesses_set_;
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
      case PACKAGE_HEADER:
        return basicUnsetPackageHeader(changeContext);
      case REDEFINABLE_HEADER:
        return basicUnsetRedefinableHeader(changeContext);
      case CONFORMANCE_CLASS:
        return basicUnsetConformanceClass(changeContext);
      case SCRIPT:
        return basicUnsetScript(changeContext);
      case EXTERNAL_PACKAGES:
        return basicUnsetExternalPackages(changeContext);
      case TYPE_DECLARATIONS:
        return basicUnsetTypeDeclarations(changeContext);
      case PARTICIPANTS:
        return basicUnsetParticipants(changeContext);
      case APPLICATIONS:
        return basicUnsetApplications(changeContext);
      case DATA_FIELDS:
        return basicUnsetDataFields(changeContext);
      case WORKFLOW_PROCESSES:
        return basicUnsetWorkflowProcesses(changeContext);
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
      case PACKAGE_HEADER:
        return getPackageHeader();
      case REDEFINABLE_HEADER:
        return getRedefinableHeader();
      case CONFORMANCE_CLASS:
        return getConformanceClass();
      case SCRIPT:
        return getScript();
      case EXTERNAL_PACKAGES:
        return getExternalPackages();
      case TYPE_DECLARATIONS:
        return getTypeDeclarations();
      case PARTICIPANTS:
        return getParticipants();
      case APPLICATIONS:
        return getApplications();
      case DATA_FIELDS:
        return getDataFields();
      case WORKFLOW_PROCESSES:
        return getWorkflowProcesses();
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
      case PACKAGE_HEADER:
        setPackageHeader((PackageHeader)newValue);
        return;
      case REDEFINABLE_HEADER:
        setRedefinableHeader((RedefinableHeader)newValue);
        return;
      case CONFORMANCE_CLASS:
        setConformanceClass((ConformanceClass)newValue);
        return;
      case SCRIPT:
        setScript((Script)newValue);
        return;
      case EXTERNAL_PACKAGES:
        setExternalPackages((ExternalPackages)newValue);
        return;
      case TYPE_DECLARATIONS:
        setTypeDeclarations((TypeDeclarations)newValue);
        return;
      case PARTICIPANTS:
        setParticipants((Participants)newValue);
        return;
      case APPLICATIONS:
        setApplications((Applications)newValue);
        return;
      case DATA_FIELDS:
        setDataFields((DataFields)newValue);
        return;
      case WORKFLOW_PROCESSES:
        setWorkflowProcesses((WorkflowProcesses)newValue);
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
      case PACKAGE_HEADER:
        unsetPackageHeader();
        return;
      case REDEFINABLE_HEADER:
        unsetRedefinableHeader();
        return;
      case CONFORMANCE_CLASS:
        unsetConformanceClass();
        return;
      case SCRIPT:
        unsetScript();
        return;
      case EXTERNAL_PACKAGES:
        unsetExternalPackages();
        return;
      case TYPE_DECLARATIONS:
        unsetTypeDeclarations();
        return;
      case PARTICIPANTS:
        unsetParticipants();
        return;
      case APPLICATIONS:
        unsetApplications();
        return;
      case DATA_FIELDS:
        unsetDataFields();
        return;
      case WORKFLOW_PROCESSES:
        unsetWorkflowProcesses();
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
      case PACKAGE_HEADER:
        return isSetPackageHeader();
      case REDEFINABLE_HEADER:
        return isSetRedefinableHeader();
      case CONFORMANCE_CLASS:
        return isSetConformanceClass();
      case SCRIPT:
        return isSetScript();
      case EXTERNAL_PACKAGES:
        return isSetExternalPackages();
      case TYPE_DECLARATIONS:
        return isSetTypeDeclarations();
      case PARTICIPANTS:
        return isSetParticipants();
      case APPLICATIONS:
        return isSetApplications();
      case DATA_FIELDS:
        return isSetDataFields();
      case WORKFLOW_PROCESSES:
        return isSetWorkflowProcesses();
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
    result.append(" (Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //PackageImpl
