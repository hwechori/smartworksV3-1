/**
 * <copyright>
 * </copyright>
 *
 * $Id: PoolImpl.java,v 1.1 2009/12/22 06:17:47 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Lanes;
import net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfos;
import net.smartworks.server.engine.process.xpdl.xpdl2.Pool;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getLanes <em>Lanes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getNodeGraphicsInfos <em>Node Graphics Infos</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getParticipant <em>Participant</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#isBoundaryVisible <em>Boundary Visible</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.PoolImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PoolImpl extends DataObjectBase implements Pool
{

  public final static int LANES = 0;

  public final static int OBJECT = 1;

  public final static int NODE_GRAPHICS_INFOS = 2;

  public final static int ANY = -1;

  public final static int ID = 3;

  public final static int NAME = 4;

  public final static int ORIENTATION = 5;

  public final static int PROCESS = 6;

  public final static int PARTICIPANT = 7;

  public final static int BOUNDARY_VISIBLE = 8;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 9;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Lanes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LANES = 0;

  /**
   * The internal feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OBJECT = 1;

  /**
   * The internal feature id for the '<em><b>Node Graphics Infos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NODE_GRAPHICS_INFOS = 2;

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
   * The internal feature id for the '<em><b>Orientation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ORIENTATION = 6;

  /**
   * The internal feature id for the '<em><b>Process</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PROCESS = 7;

  /**
   * The internal feature id for the '<em><b>Participant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTICIPANT = 8;

  /**
   * The internal feature id for the '<em><b>Boundary Visible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BOUNDARY_VISIBLE = 9;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 10;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 11;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_LANES: return LANES;
      case INTERNAL_OBJECT: return OBJECT;
      case INTERNAL_NODE_GRAPHICS_INFOS: return NODE_GRAPHICS_INFOS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_ORIENTATION: return ORIENTATION;
      case INTERNAL_PROCESS: return PROCESS;
      case INTERNAL_PARTICIPANT: return PARTICIPANT;
      case INTERNAL_BOUNDARY_VISIBLE: return BOUNDARY_VISIBLE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getLanes() <em>Lanes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanes()
   * @generated
   * @ordered
   */
  
  protected Lanes lanes = null;
  
  /**
   * This is true if the Lanes containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean lanes_set_ = false;

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
   * The default value of the '{@link #getOrientation() <em>Orientation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrientation()
   * @generated
   * @ordered
   */
  protected static final String ORIENTATION_DEFAULT_ = "HORIZONTAL";

  /**
   * The cached value of the '{@link #getOrientation() <em>Orientation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrientation()
   * @generated
   * @ordered
   */
  protected String orientation = ORIENTATION_DEFAULT_;

  /**
   * This is true if the Orientation attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean orientation_set_ = false;

  /**
   * The default value of the '{@link #getProcess() <em>Process</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcess()
   * @generated
   * @ordered
   */
  protected static final String PROCESS_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getProcess() <em>Process</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcess()
   * @generated
   * @ordered
   */
  protected String process = PROCESS_DEFAULT_;

  /**
   * This is true if the Process attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean process_set_ = false;

  /**
   * The default value of the '{@link #getParticipant() <em>Participant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticipant()
   * @generated
   * @ordered
   */
  protected static final String PARTICIPANT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getParticipant() <em>Participant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticipant()
   * @generated
   * @ordered
   */
  protected String participant = PARTICIPANT_DEFAULT_;

  /**
   * This is true if the Participant attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean participant_set_ = false;

  /**
   * The default value of the '{@link #isBoundaryVisible() <em>Boundary Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBoundaryVisible()
   * @generated
   * @ordered
   */
  protected static final boolean BOUNDARY_VISIBLE_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isBoundaryVisible() <em>Boundary Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBoundaryVisible()
   * @generated
   * @ordered
   */
  protected boolean boundaryVisible = BOUNDARY_VISIBLE_DEFAULT_;

  /**
   * This is true if the Boundary Visible attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean boundaryVisible_set_ = false;

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
  public PoolImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getPool();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lanes getLanes()
  {
    return lanes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLanes(Lanes newLanes, ChangeContext changeContext)
  {
    Lanes oldLanes = lanes;
    lanes = newLanes;
    boolean oldLanes_set_ = lanes_set_;
    lanes_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LANES, oldLanes, newLanes, !oldLanes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLanes(Lanes newLanes)
  {
    if (newLanes != lanes)
    {
      ChangeContext changeContext = null;
      if (lanes != null)
        changeContext = inverseRemove(lanes, this, OPPOSITE_FEATURE_BASE - INTERNAL_LANES, null, changeContext);
      if (newLanes != null)
        changeContext = inverseAdd(newLanes, this, OPPOSITE_FEATURE_BASE - INTERNAL_LANES, null, changeContext);
      changeContext = basicSetLanes(newLanes, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLanes_set_ = lanes_set_;
      lanes_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LANES, newLanes, newLanes, !oldLanes_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLanes(ChangeContext changeContext)
  {
    Lanes oldLanes = lanes;
    lanes = null;
    boolean oldLanes_set_ = lanes_set_;
    lanes_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LANES, oldLanes, null, !oldLanes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLanes()
  {
    if (lanes != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(lanes, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LANES, null, changeContext);
      changeContext = basicUnsetLanes(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLanes_set_ = lanes_set_;
      lanes_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LANES, null, null, oldLanes_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLanes()
  {
    return lanes_set_;
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
  public String getOrientation()
  {
    return orientation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrientation(String newOrientation)
  {
    String oldOrientation = orientation;
    orientation = newOrientation;
    boolean oldOrientation_set_ = orientation_set_;
    orientation_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ORIENTATION, oldOrientation, orientation, !oldOrientation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOrientation()
  {
    String oldOrientation = orientation;
    boolean oldOrientation_set_ = orientation_set_;
    orientation = ORIENTATION_DEFAULT_;
    orientation_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ORIENTATION, oldOrientation, ORIENTATION_DEFAULT_, oldOrientation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOrientation()
  {
    return orientation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProcess()
  {
    return process;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcess(String newProcess)
  {
    String oldProcess = process;
    process = newProcess;
    boolean oldProcess_set_ = process_set_;
    process_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PROCESS, oldProcess, process, !oldProcess_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetProcess()
  {
    String oldProcess = process;
    boolean oldProcess_set_ = process_set_;
    process = PROCESS_DEFAULT_;
    process_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PROCESS, oldProcess, PROCESS_DEFAULT_, oldProcess_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetProcess()
  {
    return process_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParticipant()
  {
    return participant;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParticipant(String newParticipant)
  {
    String oldParticipant = participant;
    participant = newParticipant;
    boolean oldParticipant_set_ = participant_set_;
    participant_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PARTICIPANT, oldParticipant, participant, !oldParticipant_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParticipant()
  {
    String oldParticipant = participant;
    boolean oldParticipant_set_ = participant_set_;
    participant = PARTICIPANT_DEFAULT_;
    participant_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PARTICIPANT, oldParticipant, PARTICIPANT_DEFAULT_, oldParticipant_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParticipant()
  {
    return participant_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBoundaryVisible()
  {
    return boundaryVisible;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoundaryVisible(boolean newBoundaryVisible)
  {
    boolean oldBoundaryVisible = boundaryVisible;
    boundaryVisible = newBoundaryVisible;
    boolean oldBoundaryVisible_set_ = boundaryVisible_set_;
    boundaryVisible_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_BOUNDARY_VISIBLE, oldBoundaryVisible, boundaryVisible, !oldBoundaryVisible_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBoundaryVisible()
  {
    boolean oldBoundaryVisible = boundaryVisible;
    boolean oldBoundaryVisible_set_ = boundaryVisible_set_;
    boundaryVisible = BOUNDARY_VISIBLE_DEFAULT_;
    boundaryVisible_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_BOUNDARY_VISIBLE, oldBoundaryVisible, BOUNDARY_VISIBLE_DEFAULT_, oldBoundaryVisible_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBoundaryVisible()
  {
    return boundaryVisible_set_;
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
      case LANES:
        return basicUnsetLanes(changeContext);
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
      case LANES:
        return getLanes();
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
      case ORIENTATION:
        return getOrientation();
      case PROCESS:
        return getProcess();
      case PARTICIPANT:
        return getParticipant();
      case BOUNDARY_VISIBLE:
        return isBoundaryVisible() ? Boolean.TRUE : Boolean.FALSE;
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
      case LANES:
        setLanes((Lanes)newValue);
        return;
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
      case ORIENTATION:
        setOrientation((String)newValue);
        return;
      case PROCESS:
        setProcess((String)newValue);
        return;
      case PARTICIPANT:
        setParticipant((String)newValue);
        return;
      case BOUNDARY_VISIBLE:
        setBoundaryVisible(((Boolean)newValue).booleanValue());
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
      case LANES:
        unsetLanes();
        return;
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
      case ORIENTATION:
        unsetOrientation();
        return;
      case PROCESS:
        unsetProcess();
        return;
      case PARTICIPANT:
        unsetParticipant();
        return;
      case BOUNDARY_VISIBLE:
        unsetBoundaryVisible();
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
      case LANES:
        return isSetLanes();
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
      case ORIENTATION:
        return isSetOrientation();
      case PROCESS:
        return isSetProcess();
      case PARTICIPANT:
        return isSetParticipant();
      case BOUNDARY_VISIBLE:
        return isSetBoundaryVisible();
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
    result.append(", Orientation: ");
    if (orientation_set_) result.append(orientation); else result.append("<unset>");
    result.append(", Process: ");
    if (process_set_) result.append(process); else result.append("<unset>");
    result.append(", Participant: ");
    if (participant_set_) result.append(participant); else result.append("<unset>");
    result.append(", BoundaryVisible: ");
    if (boundaryVisible_set_) result.append(boundaryVisible); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //PoolImpl
