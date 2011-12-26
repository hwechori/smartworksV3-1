/**
 * <copyright>
 * </copyright>
 *
 * $Id: ArtifactImpl.java,v 1.1 2009/12/22 06:17:52 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Artifact;
import net.smartworks.server.engine.process.xpdl.xpdl2.DataObject;
import net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfos;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getObject <em>Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getDataObject <em>Data Object</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getNodeGraphicsInfos <em>Node Graphics Infos</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getArtifactType <em>Artifact Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getTextAnnotation <em>Text Annotation</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ArtifactImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArtifactImpl extends DataObjectBase implements Artifact
{

  public final static int OBJECT = 0;

  public final static int DATA_OBJECT = 1;

  public final static int NODE_GRAPHICS_INFOS = 2;

  public final static int ANY = -1;

  public final static int ID = 3;

  public final static int NAME = 4;

  public final static int ARTIFACT_TYPE = 5;

  public final static int TEXT_ANNOTATION = 6;

  public final static int GROUP = 7;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 8;

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
   * The internal feature id for the '<em><b>Data Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_OBJECT = 1;

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
   * The internal feature id for the '<em><b>Artifact Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ARTIFACT_TYPE = 6;

  /**
   * The internal feature id for the '<em><b>Text Annotation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TEXT_ANNOTATION = 7;

  /**
   * The internal feature id for the '<em><b>Group</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GROUP = 8;

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
      case INTERNAL_OBJECT: return OBJECT;
      case INTERNAL_DATA_OBJECT: return DATA_OBJECT;
      case INTERNAL_NODE_GRAPHICS_INFOS: return NODE_GRAPHICS_INFOS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_ARTIFACT_TYPE: return ARTIFACT_TYPE;
      case INTERNAL_TEXT_ANNOTATION: return TEXT_ANNOTATION;
      case INTERNAL_GROUP: return GROUP;
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
   * The cached value of the '{@link #getDataObject() <em>Data Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataObject()
   * @generated
   * @ordered
   */
  
  protected DataObject dataObject = null;
  
  /**
   * This is true if the Data Object containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataObject_set_ = false;

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
   * The default value of the '{@link #getArtifactType() <em>Artifact Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArtifactType()
   * @generated
   * @ordered
   */
  protected static final String ARTIFACT_TYPE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getArtifactType() <em>Artifact Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArtifactType()
   * @generated
   * @ordered
   */
  protected String artifactType = ARTIFACT_TYPE_DEFAULT_;

  /**
   * This is true if the Artifact Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean artifactType_set_ = false;

  /**
   * The default value of the '{@link #getTextAnnotation() <em>Text Annotation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextAnnotation()
   * @generated
   * @ordered
   */
  protected static final String TEXT_ANNOTATION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTextAnnotation() <em>Text Annotation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextAnnotation()
   * @generated
   * @ordered
   */
  protected String textAnnotation = TEXT_ANNOTATION_DEFAULT_;

  /**
   * This is true if the Text Annotation attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean textAnnotation_set_ = false;

  /**
   * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected static final String GROUP_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected String group = GROUP_DEFAULT_;

  /**
   * This is true if the Group attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean group_set_ = false;

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
  public ArtifactImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getArtifact();
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
  public DataObject getDataObject()
  {
    return dataObject;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataObject(DataObject newDataObject, ChangeContext changeContext)
  {
    DataObject oldDataObject = dataObject;
    dataObject = newDataObject;
    boolean oldDataObject_set_ = dataObject_set_;
    dataObject_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_OBJECT, oldDataObject, newDataObject, !oldDataObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataObject(DataObject newDataObject)
  {
    if (newDataObject != dataObject)
    {
      ChangeContext changeContext = null;
      if (dataObject != null)
        changeContext = inverseRemove(dataObject, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_OBJECT, null, changeContext);
      if (newDataObject != null)
        changeContext = inverseAdd(newDataObject, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_OBJECT, null, changeContext);
      changeContext = basicSetDataObject(newDataObject, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataObject_set_ = dataObject_set_;
      dataObject_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_OBJECT, newDataObject, newDataObject, !oldDataObject_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataObject(ChangeContext changeContext)
  {
    DataObject oldDataObject = dataObject;
    dataObject = null;
    boolean oldDataObject_set_ = dataObject_set_;
    dataObject_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_OBJECT, oldDataObject, null, !oldDataObject_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataObject()
  {
    if (dataObject != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataObject, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_OBJECT, null, changeContext);
      changeContext = basicUnsetDataObject(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataObject_set_ = dataObject_set_;
      dataObject_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_OBJECT, null, null, oldDataObject_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataObject()
  {
    return dataObject_set_;
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
  public String getArtifactType()
  {
    return artifactType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArtifactType(String newArtifactType)
  {
    String oldArtifactType = artifactType;
    artifactType = newArtifactType;
    boolean oldArtifactType_set_ = artifactType_set_;
    artifactType_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ARTIFACT_TYPE, oldArtifactType, artifactType, !oldArtifactType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetArtifactType()
  {
    String oldArtifactType = artifactType;
    boolean oldArtifactType_set_ = artifactType_set_;
    artifactType = ARTIFACT_TYPE_DEFAULT_;
    artifactType_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ARTIFACT_TYPE, oldArtifactType, ARTIFACT_TYPE_DEFAULT_, oldArtifactType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetArtifactType()
  {
    return artifactType_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTextAnnotation()
  {
    return textAnnotation;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTextAnnotation(String newTextAnnotation)
  {
    String oldTextAnnotation = textAnnotation;
    textAnnotation = newTextAnnotation;
    boolean oldTextAnnotation_set_ = textAnnotation_set_;
    textAnnotation_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TEXT_ANNOTATION, oldTextAnnotation, textAnnotation, !oldTextAnnotation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTextAnnotation()
  {
    String oldTextAnnotation = textAnnotation;
    boolean oldTextAnnotation_set_ = textAnnotation_set_;
    textAnnotation = TEXT_ANNOTATION_DEFAULT_;
    textAnnotation_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TEXT_ANNOTATION, oldTextAnnotation, TEXT_ANNOTATION_DEFAULT_, oldTextAnnotation_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTextAnnotation()
  {
    return textAnnotation_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGroup()
  {
    return group;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroup(String newGroup)
  {
    String oldGroup = group;
    group = newGroup;
    boolean oldGroup_set_ = group_set_;
    group_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_GROUP, oldGroup, group, !oldGroup_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetGroup()
  {
    String oldGroup = group;
    boolean oldGroup_set_ = group_set_;
    group = GROUP_DEFAULT_;
    group_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_GROUP, oldGroup, GROUP_DEFAULT_, oldGroup_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetGroup()
  {
    return group_set_;
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
      case DATA_OBJECT:
        return basicUnsetDataObject(changeContext);
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
      case DATA_OBJECT:
        return getDataObject();
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
      case ARTIFACT_TYPE:
        return getArtifactType();
      case TEXT_ANNOTATION:
        return getTextAnnotation();
      case GROUP:
        return getGroup();
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
      case DATA_OBJECT:
        setDataObject((DataObject)newValue);
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
      case ARTIFACT_TYPE:
        setArtifactType((String)newValue);
        return;
      case TEXT_ANNOTATION:
        setTextAnnotation((String)newValue);
        return;
      case GROUP:
        setGroup((String)newValue);
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
      case DATA_OBJECT:
        unsetDataObject();
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
      case ARTIFACT_TYPE:
        unsetArtifactType();
        return;
      case TEXT_ANNOTATION:
        unsetTextAnnotation();
        return;
      case GROUP:
        unsetGroup();
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
      case DATA_OBJECT:
        return isSetDataObject();
      case NODE_GRAPHICS_INFOS:
        return isSetNodeGraphicsInfos();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case ARTIFACT_TYPE:
        return isSetArtifactType();
      case TEXT_ANNOTATION:
        return isSetTextAnnotation();
      case GROUP:
        return isSetGroup();
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
    result.append(", ArtifactType: ");
    if (artifactType_set_) result.append(artifactType); else result.append("<unset>");
    result.append(", TextAnnotation: ");
    if (textAnnotation_set_) result.append(textAnnotation); else result.append("<unset>");
    result.append(", Group: ");
    if (group_set_) result.append(group); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //ArtifactImpl
