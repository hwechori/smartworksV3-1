/**
 * <copyright>
 * </copyright>
 *
 * $Id: LaneImpl.java,v 1.1 2009/12/22 06:17:36 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Lane;
import net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfos;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getNodeGraphicsInfos <em>Node Graphics Infos</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getParentLane <em>Parent Lane</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getParentPool <em>Parent Pool</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.LaneImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaneImpl extends DataObjectBase implements Lane
{

  public final static int OBJECT = 0;

  public final static int NODE_GRAPHICS_INFOS = 1;

  public final static int ANY = -1;

  public final static int ID = 2;

  public final static int NAME = 3;

  public final static int PARENT_LANE = 4;

  public final static int PARENT_POOL = 5;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 6;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OBJECT = 0;

  /**
   * The internal feature id for the '<em><b>Node Graphics Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NODE_GRAPHICS_INFOS = 1;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 2;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 3;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 4;

  /**
   * The internal feature id for the '<em><b>Parent Lane</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARENT_LANE = 5;

  /**
   * The internal feature id for the '<em><b>Parent Pool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARENT_POOL = 6;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 7;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 8;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_OBJECT: return OBJECT;
      case INTERNAL_NODE_GRAPHICS_INFOS: return NODE_GRAPHICS_INFOS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_PARENT_LANE: return PARENT_LANE;
      case INTERNAL_PARENT_POOL: return PARENT_POOL;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * The cached value of the '{@link #getNodeGraphicsInfos() <em>Node Graphics Infos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeGraphicsInfos()
   * @generated
   * @ordered
   */
  
  protected NodeGraphicsInfos nodeGraphicsInfos = null;
  
  /**
   * This is true if the Node Graphics Infos containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean nodeGraphicsInfos_set_ = false;

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
   * The default value of the '{@link #getParentLane() <em>Parent Lane</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentLane()
   * @generated
   * @ordered
   */
  protected static final String PARENT_LANE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getParentLane() <em>Parent Lane</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentLane()
   * @generated
   * @ordered
   */
  protected String parentLane = PARENT_LANE_DEFAULT_;

  /**
   * This is true if the Parent Lane attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean parentLane_set_ = false;

  /**
   * The default value of the '{@link #getParentPool() <em>Parent Pool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentPool()
   * @generated
   * @ordered
   */
  protected static final String PARENT_POOL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getParentPool() <em>Parent Pool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentPool()
   * @generated
   * @ordered
   */
  protected String parentPool = PARENT_POOL_DEFAULT_;

  /**
   * This is true if the Parent Pool attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean parentPool_set_ = false;

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
  public LaneImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getLane();
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
  public NodeGraphicsInfos getNodeGraphicsInfos()
  {
    return nodeGraphicsInfos;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetNodeGraphicsInfos(NodeGraphicsInfos newNodeGraphicsInfos, ChangeContext changeContext)
  {
    NodeGraphicsInfos oldNodeGraphicsInfos = nodeGraphicsInfos;
    nodeGraphicsInfos = newNodeGraphicsInfos;
    boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
    nodeGraphicsInfos_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_NODE_GRAPHICS_INFOS, oldNodeGraphicsInfos, newNodeGraphicsInfos, !oldNodeGraphicsInfos_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodeGraphicsInfos(NodeGraphicsInfos newNodeGraphicsInfos)
  {
    if (newNodeGraphicsInfos != nodeGraphicsInfos)
    {
      ChangeContext changeContext = null;
      if (nodeGraphicsInfos != null)
        changeContext = inverseRemove(nodeGraphicsInfos, this, OPPOSITE_FEATURE_BASE - INTERNAL_NODE_GRAPHICS_INFOS, null, changeContext);
      if (newNodeGraphicsInfos != null)
        changeContext = inverseAdd(newNodeGraphicsInfos, this, OPPOSITE_FEATURE_BASE - INTERNAL_NODE_GRAPHICS_INFOS, null, changeContext);
      changeContext = basicSetNodeGraphicsInfos(newNodeGraphicsInfos, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
      nodeGraphicsInfos_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_NODE_GRAPHICS_INFOS, newNodeGraphicsInfos, newNodeGraphicsInfos, !oldNodeGraphicsInfos_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetNodeGraphicsInfos(ChangeContext changeContext)
  {
    NodeGraphicsInfos oldNodeGraphicsInfos = nodeGraphicsInfos;
    nodeGraphicsInfos = null;
    boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
    nodeGraphicsInfos_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_NODE_GRAPHICS_INFOS, oldNodeGraphicsInfos, null, !oldNodeGraphicsInfos_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNodeGraphicsInfos()
  {
    if (nodeGraphicsInfos != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(nodeGraphicsInfos, this, EOPPOSITE_FEATURE_BASE - INTERNAL_NODE_GRAPHICS_INFOS, null, changeContext);
      changeContext = basicUnsetNodeGraphicsInfos(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldNodeGraphicsInfos_set_ = nodeGraphicsInfos_set_;
      nodeGraphicsInfos_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_NODE_GRAPHICS_INFOS, null, null, oldNodeGraphicsInfos_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNodeGraphicsInfos()
  {
    return nodeGraphicsInfos_set_;
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
  public String getParentLane()
  {
    return parentLane;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentLane(String newParentLane)
  {
    String oldParentLane = parentLane;
    parentLane = newParentLane;
    boolean oldParentLane_set_ = parentLane_set_;
    parentLane_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PARENT_LANE, oldParentLane, parentLane, !oldParentLane_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParentLane()
  {
    String oldParentLane = parentLane;
    boolean oldParentLane_set_ = parentLane_set_;
    parentLane = PARENT_LANE_DEFAULT_;
    parentLane_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PARENT_LANE, oldParentLane, PARENT_LANE_DEFAULT_, oldParentLane_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParentLane()
  {
    return parentLane_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParentPool()
  {
    return parentPool;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentPool(String newParentPool)
  {
    String oldParentPool = parentPool;
    parentPool = newParentPool;
    boolean oldParentPool_set_ = parentPool_set_;
    parentPool_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PARENT_POOL, oldParentPool, parentPool, !oldParentPool_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParentPool()
  {
    String oldParentPool = parentPool;
    boolean oldParentPool_set_ = parentPool_set_;
    parentPool = PARENT_POOL_DEFAULT_;
    parentPool_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PARENT_POOL, oldParentPool, PARENT_POOL_DEFAULT_, oldParentPool_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParentPool()
  {
    return parentPool_set_;
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
      case OBJECT:
        return basicUnsetObject(changeContext);
      case NODE_GRAPHICS_INFOS:
        return basicUnsetNodeGraphicsInfos(changeContext);
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
      case OBJECT:
        return getObject();
      case NODE_GRAPHICS_INFOS:
        return getNodeGraphicsInfos();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case ID:
        return getId();
      case NAME:
        return getName();
      case PARENT_LANE:
        return getParentLane();
      case PARENT_POOL:
        return getParentPool();
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
      case OBJECT:
        setObject((net.smartworks.server.engine.process.xpdl.xpdl2.Object)newValue);
        return;
      case NODE_GRAPHICS_INFOS:
        setNodeGraphicsInfos((NodeGraphicsInfos)newValue);
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
      case PARENT_LANE:
        setParentLane((String)newValue);
        return;
      case PARENT_POOL:
        setParentPool((String)newValue);
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
      case OBJECT:
        unsetObject();
        return;
      case NODE_GRAPHICS_INFOS:
        unsetNodeGraphicsInfos();
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
      case PARENT_LANE:
        unsetParentLane();
        return;
      case PARENT_POOL:
        unsetParentPool();
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
      case OBJECT:
        return isSetObject();
      case NODE_GRAPHICS_INFOS:
        return isSetNodeGraphicsInfos();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case PARENT_LANE:
        return isSetParentLane();
      case PARENT_POOL:
        return isSetParentPool();
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
    result.append(", ParentLane: ");
    if (parentLane_set_) result.append(parentLane); else result.append("<unset>");
    result.append(", ParentPool: ");
    if (parentPool_set_) result.append(parentPool); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //LaneImpl
