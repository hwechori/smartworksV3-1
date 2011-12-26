/**
 * <copyright>
 * </copyright>
 *
 * $Id: VendorExtensionImpl.java,v 1.1 2009/12/22 06:17:52 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.VendorExtension;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vendor Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.VendorExtensionImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.VendorExtensionImpl#getToolId <em>Tool Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.VendorExtensionImpl#getSchemaLocation <em>Schema Location</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.VendorExtensionImpl#getExtensionDescription <em>Extension Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.VendorExtensionImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VendorExtensionImpl extends DataObjectBase implements VendorExtension
{

  public final static int ANY = -1;

  public final static int TOOL_ID = 0;

  public final static int SCHEMA_LOCATION = 1;

  public final static int EXTENSION_DESCRIPTION = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 0;

  /**
   * The internal feature id for the '<em><b>Tool Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TOOL_ID = 1;

  /**
   * The internal feature id for the '<em><b>Schema Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SCHEMA_LOCATION = 2;

  /**
   * The internal feature id for the '<em><b>Extension Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENSION_DESCRIPTION = 3;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 4;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 5;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_ANY: return ANY;
      case INTERNAL_TOOL_ID: return TOOL_ID;
      case INTERNAL_SCHEMA_LOCATION: return SCHEMA_LOCATION;
      case INTERNAL_EXTENSION_DESCRIPTION: return EXTENSION_DESCRIPTION;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * The default value of the '{@link #getToolId() <em>Tool Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToolId()
   * @generated
   * @ordered
   */
  protected static final String TOOL_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getToolId() <em>Tool Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToolId()
   * @generated
   * @ordered
   */
  protected String toolId = TOOL_ID_DEFAULT_;

  /**
   * This is true if the Tool Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean toolId_set_ = false;

  /**
   * The default value of the '{@link #getSchemaLocation() <em>Schema Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchemaLocation()
   * @generated
   * @ordered
   */
  protected static final String SCHEMA_LOCATION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getSchemaLocation() <em>Schema Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchemaLocation()
   * @generated
   * @ordered
   */
  protected String schemaLocation = SCHEMA_LOCATION_DEFAULT_;

  /**
   * This is true if the Schema Location attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean schemaLocation_set_ = false;

  /**
   * The default value of the '{@link #getExtensionDescription() <em>Extension Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensionDescription()
   * @generated
   * @ordered
   */
  protected static final String EXTENSION_DESCRIPTION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getExtensionDescription() <em>Extension Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensionDescription()
   * @generated
   * @ordered
   */
  protected String extensionDescription = EXTENSION_DESCRIPTION_DEFAULT_;

  /**
   * This is true if the Extension Description attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extensionDescription_set_ = false;

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
  public VendorExtensionImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getVendorExtension();
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
  public String getToolId()
  {
    return toolId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToolId(String newToolId)
  {
    String oldToolId = toolId;
    toolId = newToolId;
    boolean oldToolId_set_ = toolId_set_;
    toolId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TOOL_ID, oldToolId, toolId, !oldToolId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetToolId()
  {
    String oldToolId = toolId;
    boolean oldToolId_set_ = toolId_set_;
    toolId = TOOL_ID_DEFAULT_;
    toolId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TOOL_ID, oldToolId, TOOL_ID_DEFAULT_, oldToolId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetToolId()
  {
    return toolId_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSchemaLocation()
  {
    return schemaLocation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSchemaLocation(String newSchemaLocation)
  {
    String oldSchemaLocation = schemaLocation;
    schemaLocation = newSchemaLocation;
    boolean oldSchemaLocation_set_ = schemaLocation_set_;
    schemaLocation_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SCHEMA_LOCATION, oldSchemaLocation, schemaLocation, !oldSchemaLocation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSchemaLocation()
  {
    String oldSchemaLocation = schemaLocation;
    boolean oldSchemaLocation_set_ = schemaLocation_set_;
    schemaLocation = SCHEMA_LOCATION_DEFAULT_;
    schemaLocation_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SCHEMA_LOCATION, oldSchemaLocation, SCHEMA_LOCATION_DEFAULT_, oldSchemaLocation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSchemaLocation()
  {
    return schemaLocation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtensionDescription()
  {
    return extensionDescription;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtensionDescription(String newExtensionDescription)
  {
    String oldExtensionDescription = extensionDescription;
    extensionDescription = newExtensionDescription;
    boolean oldExtensionDescription_set_ = extensionDescription_set_;
    extensionDescription_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_EXTENSION_DESCRIPTION, oldExtensionDescription, extensionDescription, !oldExtensionDescription_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtensionDescription()
  {
    String oldExtensionDescription = extensionDescription;
    boolean oldExtensionDescription_set_ = extensionDescription_set_;
    extensionDescription = EXTENSION_DESCRIPTION_DEFAULT_;
    extensionDescription_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_EXTENSION_DESCRIPTION, oldExtensionDescription, EXTENSION_DESCRIPTION_DEFAULT_, oldExtensionDescription_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtensionDescription()
  {
    return extensionDescription_set_;
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
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case TOOL_ID:
        return getToolId();
      case SCHEMA_LOCATION:
        return getSchemaLocation();
      case EXTENSION_DESCRIPTION:
        return getExtensionDescription();
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
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case TOOL_ID:
        setToolId((String)newValue);
        return;
      case SCHEMA_LOCATION:
        setSchemaLocation((String)newValue);
        return;
      case EXTENSION_DESCRIPTION:
        setExtensionDescription((String)newValue);
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
      case ANY:
        unsetSequence(getAny());
        return;
      case TOOL_ID:
        unsetToolId();
        return;
      case SCHEMA_LOCATION:
        unsetSchemaLocation();
        return;
      case EXTENSION_DESCRIPTION:
        unsetExtensionDescription();
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
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case TOOL_ID:
        return isSetToolId();
      case SCHEMA_LOCATION:
        return isSetSchemaLocation();
      case EXTENSION_DESCRIPTION:
        return isSetExtensionDescription();
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
    result.append(", ToolId: ");
    if (toolId_set_) result.append(toolId); else result.append("<unset>");
    result.append(", schemaLocation: ");
    if (schemaLocation_set_) result.append(schemaLocation); else result.append("<unset>");
    result.append(", extensionDescription: ");
    if (extensionDescription_set_) result.append(extensionDescription); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //VendorExtensionImpl
