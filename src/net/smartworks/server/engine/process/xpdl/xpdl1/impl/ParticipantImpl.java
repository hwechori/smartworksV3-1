/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParticipantImpl.java,v 1.1 2009/12/22 06:17:12 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExternalReference;
import net.smartworks.server.engine.process.xpdl.xpdl1.Participant;
import net.smartworks.server.engine.process.xpdl.xpdl1.ParticipantType;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ParticipantImpl#getParticipantType <em>Participant Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ParticipantImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ParticipantImpl#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ParticipantImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ParticipantImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ParticipantImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParticipantImpl extends DataObjectBase implements Participant
{

  public final static int PARTICIPANT_TYPE = 0;

  public final static int DESCRIPTION = 1;

  public final static int EXTERNAL_REFERENCE = 2;

  public final static int EXTENDED_ATTRIBUTES = 3;

  public final static int ID = 4;

  public final static int NAME = 5;

  public final static int SDO_PROPERTY_COUNT = 6;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Participant Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTICIPANT_TYPE = 0;

  /**
   * The internal feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DESCRIPTION = 1;

  /**
   * The internal feature id for the '<em><b>External Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTERNAL_REFERENCE = 2;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 3;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 4;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 5;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 6;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_PARTICIPANT_TYPE: return PARTICIPANT_TYPE;
      case INTERNAL_DESCRIPTION: return DESCRIPTION;
      case INTERNAL_EXTERNAL_REFERENCE: return EXTERNAL_REFERENCE;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getParticipantType() <em>Participant Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticipantType()
   * @generated
   * @ordered
   */
  
  protected ParticipantType participantType = null;
  
  /**
   * This is true if the Participant Type containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean participantType_set_ = false;

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
   * The cached value of the '{@link #getExternalReference() <em>External Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalReference()
   * @generated
   * @ordered
   */
  
  protected ExternalReference externalReference = null;
  
  /**
   * This is true if the External Reference containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean externalReference_set_ = false;

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
  public ParticipantImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getParticipant();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParticipantType getParticipantType()
  {
    return participantType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetParticipantType(ParticipantType newParticipantType, ChangeContext changeContext)
  {
    ParticipantType oldParticipantType = participantType;
    participantType = newParticipantType;
    boolean oldParticipantType_set_ = participantType_set_;
    participantType_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTICIPANT_TYPE, oldParticipantType, newParticipantType, !oldParticipantType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParticipantType(ParticipantType newParticipantType)
  {
    if (newParticipantType != participantType)
    {
      ChangeContext changeContext = null;
      if (participantType != null)
        changeContext = inverseRemove(participantType, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANT_TYPE, null, changeContext);
      if (newParticipantType != null)
        changeContext = inverseAdd(newParticipantType, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANT_TYPE, null, changeContext);
      changeContext = basicSetParticipantType(newParticipantType, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldParticipantType_set_ = participantType_set_;
      participantType_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTICIPANT_TYPE, newParticipantType, newParticipantType, !oldParticipantType_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetParticipantType(ChangeContext changeContext)
  {
    ParticipantType oldParticipantType = participantType;
    participantType = null;
    boolean oldParticipantType_set_ = participantType_set_;
    participantType_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTICIPANT_TYPE, oldParticipantType, null, !oldParticipantType_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParticipantType()
  {
    if (participantType != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(participantType, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANT_TYPE, null, changeContext);
      changeContext = basicUnsetParticipantType(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldParticipantType_set_ = participantType_set_;
      participantType_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTICIPANT_TYPE, null, null, oldParticipantType_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParticipantType()
  {
    return participantType_set_;
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
  public ExternalReference getExternalReference()
  {
    return externalReference;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExternalReference(ExternalReference newExternalReference, ChangeContext changeContext)
  {
    ExternalReference oldExternalReference = externalReference;
    externalReference = newExternalReference;
    boolean oldExternalReference_set_ = externalReference_set_;
    externalReference_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTERNAL_REFERENCE, oldExternalReference, newExternalReference, !oldExternalReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExternalReference(ExternalReference newExternalReference)
  {
    if (newExternalReference != externalReference)
    {
      ChangeContext changeContext = null;
      if (externalReference != null)
        changeContext = inverseRemove(externalReference, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_REFERENCE, null, changeContext);
      if (newExternalReference != null)
        changeContext = inverseAdd(newExternalReference, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_REFERENCE, null, changeContext);
      changeContext = basicSetExternalReference(newExternalReference, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExternalReference_set_ = externalReference_set_;
      externalReference_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTERNAL_REFERENCE, newExternalReference, newExternalReference, !oldExternalReference_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExternalReference(ChangeContext changeContext)
  {
    ExternalReference oldExternalReference = externalReference;
    externalReference = null;
    boolean oldExternalReference_set_ = externalReference_set_;
    externalReference_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTERNAL_REFERENCE, oldExternalReference, null, !oldExternalReference_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExternalReference()
  {
    if (externalReference != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(externalReference, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTERNAL_REFERENCE, null, changeContext);
      changeContext = basicUnsetExternalReference(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExternalReference_set_ = externalReference_set_;
      externalReference_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTERNAL_REFERENCE, null, null, oldExternalReference_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExternalReference()
  {
    return externalReference_set_;
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
      case PARTICIPANT_TYPE:
        return basicUnsetParticipantType(changeContext);
      case EXTERNAL_REFERENCE:
        return basicUnsetExternalReference(changeContext);
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
      case PARTICIPANT_TYPE:
        return getParticipantType();
      case DESCRIPTION:
        return getDescription();
      case EXTERNAL_REFERENCE:
        return getExternalReference();
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
      case PARTICIPANT_TYPE:
        setParticipantType((ParticipantType)newValue);
        return;
      case DESCRIPTION:
        setDescription((String)newValue);
        return;
      case EXTERNAL_REFERENCE:
        setExternalReference((ExternalReference)newValue);
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
      case PARTICIPANT_TYPE:
        unsetParticipantType();
        return;
      case DESCRIPTION:
        unsetDescription();
        return;
      case EXTERNAL_REFERENCE:
        unsetExternalReference();
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
      case PARTICIPANT_TYPE:
        return isSetParticipantType();
      case DESCRIPTION:
        return isSetDescription();
      case EXTERNAL_REFERENCE:
        return isSetExternalReference();
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
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ParticipantImpl
