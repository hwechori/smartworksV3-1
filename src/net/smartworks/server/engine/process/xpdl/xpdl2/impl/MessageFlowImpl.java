/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageFlowImpl.java,v 1.1 2009/12/22 06:17:38 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfos;
import net.smartworks.server.engine.process.xpdl.xpdl2.MessageFlow;
import net.smartworks.server.engine.process.xpdl.xpdl2.MessageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getConnectorGraphicsInfos <em>Connector Graphics Infos</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getSource <em>Source</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.MessageFlowImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageFlowImpl extends DataObjectBase implements MessageFlow
{

  public final static int MESSAGE = 0;

  public final static int OBJECT = 1;

  public final static int CONNECTOR_GRAPHICS_INFOS = 2;

  public final static int ANY = -1;

  public final static int ID = 3;

  public final static int NAME = 4;

  public final static int SOURCE = 5;

  public final static int TARGET = 6;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 7;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MESSAGE = 0;

  /**
   * The internal feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OBJECT = 1;

  /**
   * The internal feature id for the '<em><b>Connector Graphics Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CONNECTOR_GRAPHICS_INFOS = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

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
   * The internal feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SOURCE = 6;

  /**
   * The internal feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TARGET = 7;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 8;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 9;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_MESSAGE: return MESSAGE;
      case INTERNAL_OBJECT: return OBJECT;
      case INTERNAL_CONNECTOR_GRAPHICS_INFOS: return CONNECTOR_GRAPHICS_INFOS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_SOURCE: return SOURCE;
      case INTERNAL_TARGET: return TARGET;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  
  protected MessageType message = null;
  
  /**
   * This is true if the Message containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean message_set_ = false;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  
  protected net.smartworks.server.engine.process.xpdl.xpdl2.Object object = null;
  
  /**
   * This is true if the Object containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean object_set_ = false;

  /**
   * The cached value of the '{@link #getConnectorGraphicsInfos() <em>Connector Graphics Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectorGraphicsInfos()
   * @generated
   * @ordered
   */
  
  protected ConnectorGraphicsInfos connectorGraphicsInfos = null;
  
  /**
   * This is true if the Connector Graphics Infos containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean connectorGraphicsInfos_set_ = false;

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
   * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected String source = SOURCE_DEFAULT_;

  /**
   * This is true if the Source attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean source_set_ = false;

  /**
   * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected static final String TARGET_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected String target = TARGET_DEFAULT_;

  /**
   * This is true if the Target attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean target_set_ = false;

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
  public MessageFlowImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getMessageFlow();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageType getMessage()
  {
    return message;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetMessage(MessageType newMessage, ChangeContext changeContext)
  {
    MessageType oldMessage = message;
    message = newMessage;
    boolean oldMessage_set_ = message_set_;
    message_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_MESSAGE, oldMessage, newMessage, !oldMessage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(MessageType newMessage)
  {
    if (newMessage != message)
    {
      ChangeContext changeContext = null;
      if (message != null)
        changeContext = inverseRemove(message, this, OPPOSITE_FEATURE_BASE - INTERNAL_MESSAGE, null, changeContext);
      if (newMessage != null)
        changeContext = inverseAdd(newMessage, this, OPPOSITE_FEATURE_BASE - INTERNAL_MESSAGE, null, changeContext);
      changeContext = basicSetMessage(newMessage, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldMessage_set_ = message_set_;
      message_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_MESSAGE, newMessage, newMessage, !oldMessage_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetMessage(ChangeContext changeContext)
  {
    MessageType oldMessage = message;
    message = null;
    boolean oldMessage_set_ = message_set_;
    message_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_MESSAGE, oldMessage, null, !oldMessage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMessage()
  {
    if (message != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(message, this, EOPPOSITE_FEATURE_BASE - INTERNAL_MESSAGE, null, changeContext);
      changeContext = basicUnsetMessage(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldMessage_set_ = message_set_;
      message_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_MESSAGE, null, null, oldMessage_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMessage()
  {
    return message_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public net.smartworks.server.engine.process.xpdl.xpdl2.Object getObject()
  {
    return object;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object newObject, ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Object oldObject = object;
    object = newObject;
    boolean oldObject_set_ = object_set_;
    object_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_OBJECT, oldObject, newObject, !oldObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(net.smartworks.server.engine.process.xpdl.xpdl2.Object newObject)
  {
    if (newObject != object)
    {
      ChangeContext changeContext = null;
      if (object != null)
        changeContext = inverseRemove(object, this, OPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      if (newObject != null)
        changeContext = inverseAdd(newObject, this, OPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      changeContext = basicSetObject(newObject, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldObject_set_ = object_set_;
      object_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_OBJECT, newObject, newObject, !oldObject_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetObject(ChangeContext changeContext)
  {
    net.smartworks.server.engine.process.xpdl.xpdl2.Object oldObject = object;
    object = null;
    boolean oldObject_set_ = object_set_;
    object_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_OBJECT, oldObject, null, !oldObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetObject()
  {
    if (object != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(object, this, EOPPOSITE_FEATURE_BASE - INTERNAL_OBJECT, null, changeContext);
      changeContext = basicUnsetObject(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldObject_set_ = object_set_;
      object_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_OBJECT, null, null, oldObject_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetObject()
  {
    return object_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectorGraphicsInfos getConnectorGraphicsInfos()
  {
    return connectorGraphicsInfos;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetConnectorGraphicsInfos(ConnectorGraphicsInfos newConnectorGraphicsInfos, ChangeContext changeContext)
  {
    ConnectorGraphicsInfos oldConnectorGraphicsInfos = connectorGraphicsInfos;
    connectorGraphicsInfos = newConnectorGraphicsInfos;
    boolean oldConnectorGraphicsInfos_set_ = connectorGraphicsInfos_set_;
    connectorGraphicsInfos_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_CONNECTOR_GRAPHICS_INFOS, oldConnectorGraphicsInfos, newConnectorGraphicsInfos, !oldConnectorGraphicsInfos_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConnectorGraphicsInfos(ConnectorGraphicsInfos newConnectorGraphicsInfos)
  {
    if (newConnectorGraphicsInfos != connectorGraphicsInfos)
    {
      ChangeContext changeContext = null;
      if (connectorGraphicsInfos != null)
        changeContext = inverseRemove(connectorGraphicsInfos, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONNECTOR_GRAPHICS_INFOS, null, changeContext);
      if (newConnectorGraphicsInfos != null)
        changeContext = inverseAdd(newConnectorGraphicsInfos, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONNECTOR_GRAPHICS_INFOS, null, changeContext);
      changeContext = basicSetConnectorGraphicsInfos(newConnectorGraphicsInfos, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldConnectorGraphicsInfos_set_ = connectorGraphicsInfos_set_;
      connectorGraphicsInfos_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_CONNECTOR_GRAPHICS_INFOS, newConnectorGraphicsInfos, newConnectorGraphicsInfos, !oldConnectorGraphicsInfos_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetConnectorGraphicsInfos(ChangeContext changeContext)
  {
    ConnectorGraphicsInfos oldConnectorGraphicsInfos = connectorGraphicsInfos;
    connectorGraphicsInfos = null;
    boolean oldConnectorGraphicsInfos_set_ = connectorGraphicsInfos_set_;
    connectorGraphicsInfos_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_CONNECTOR_GRAPHICS_INFOS, oldConnectorGraphicsInfos, null, !oldConnectorGraphicsInfos_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetConnectorGraphicsInfos()
  {
    if (connectorGraphicsInfos != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(connectorGraphicsInfos, this, EOPPOSITE_FEATURE_BASE - INTERNAL_CONNECTOR_GRAPHICS_INFOS, null, changeContext);
      changeContext = basicUnsetConnectorGraphicsInfos(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldConnectorGraphicsInfos_set_ = connectorGraphicsInfos_set_;
      connectorGraphicsInfos_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_CONNECTOR_GRAPHICS_INFOS, null, null, oldConnectorGraphicsInfos_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetConnectorGraphicsInfos()
  {
    return connectorGraphicsInfos_set_;
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
  public String getSource()
  {
    return source;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(String newSource)
  {
    String oldSource = source;
    source = newSource;
    boolean oldSource_set_ = source_set_;
    source_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SOURCE, oldSource, source, !oldSource_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSource()
  {
    String oldSource = source;
    boolean oldSource_set_ = source_set_;
    source = SOURCE_DEFAULT_;
    source_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SOURCE, oldSource, SOURCE_DEFAULT_, oldSource_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSource()
  {
    return source_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTarget()
  {
    return target;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(String newTarget)
  {
    String oldTarget = target;
    target = newTarget;
    boolean oldTarget_set_ = target_set_;
    target_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TARGET, oldTarget, target, !oldTarget_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTarget()
  {
    String oldTarget = target;
    boolean oldTarget_set_ = target_set_;
    target = TARGET_DEFAULT_;
    target_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TARGET, oldTarget, TARGET_DEFAULT_, oldTarget_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTarget()
  {
    return target_set_;
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
      case MESSAGE:
        return basicUnsetMessage(changeContext);
      case OBJECT:
        return basicUnsetObject(changeContext);
      case CONNECTOR_GRAPHICS_INFOS:
        return basicUnsetConnectorGraphicsInfos(changeContext);
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
      case MESSAGE:
        return getMessage();
      case OBJECT:
        return getObject();
      case CONNECTOR_GRAPHICS_INFOS:
        return getConnectorGraphicsInfos();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ID:
        return getId();
      case NAME:
        return getName();
      case SOURCE:
        return getSource();
      case TARGET:
        return getTarget();
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
      case MESSAGE:
        setMessage((MessageType)newValue);
        return;
      case OBJECT:
        setObject((net.smartworks.server.engine.process.xpdl.xpdl2.Object)newValue);
        return;
      case CONNECTOR_GRAPHICS_INFOS:
        setConnectorGraphicsInfos((ConnectorGraphicsInfos)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case NAME:
        setName((String)newValue);
        return;
      case SOURCE:
        setSource((String)newValue);
        return;
      case TARGET:
        setTarget((String)newValue);
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
      case MESSAGE:
        unsetMessage();
        return;
      case OBJECT:
        unsetObject();
        return;
      case CONNECTOR_GRAPHICS_INFOS:
        unsetConnectorGraphicsInfos();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case ID:
        unsetId();
        return;
      case NAME:
        unsetName();
        return;
      case SOURCE:
        unsetSource();
        return;
      case TARGET:
        unsetTarget();
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
      case MESSAGE:
        return isSetMessage();
      case OBJECT:
        return isSetObject();
      case CONNECTOR_GRAPHICS_INFOS:
        return isSetConnectorGraphicsInfos();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case SOURCE:
        return isSetSource();
      case TARGET:
        return isSetTarget();
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
    result.append(", Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", Source: ");
    if (source_set_) result.append(source); else result.append("<unset>");
    result.append(", Target: ");
    if (target_set_) result.append(target); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //MessageFlowImpl
