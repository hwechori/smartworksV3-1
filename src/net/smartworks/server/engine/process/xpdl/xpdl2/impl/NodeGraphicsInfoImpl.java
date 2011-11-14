/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeGraphicsInfoImpl.java,v 1.1 2009/12/22 06:17:41 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates;
import net.smartworks.server.engine.process.xpdl.xpdl2.NodeGraphicsInfo;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Graphics Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getToolId <em>Tool Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#isIsVisible <em>Is Visible</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getPage <em>Page</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getLaneId <em>Lane Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getFillColor <em>Fill Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getShape <em>Shape</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.NodeGraphicsInfoImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeGraphicsInfoImpl extends DataObjectBase implements NodeGraphicsInfo
{

  public final static int COORDINATES = 0;

  public final static int ANY = -1;

  public final static int TOOL_ID = 1;

  public final static int IS_VISIBLE = 2;

  public final static int PAGE = 3;

  public final static int LANE_ID = 4;

  public final static int HEIGHT = 5;

  public final static int WIDTH = 6;

  public final static int BORDER_COLOR = 7;

  public final static int FILL_COLOR = 8;

  public final static int SHAPE = 9;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 10;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Coordinates</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COORDINATES = 0;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 1;

  /**
   * The internal feature id for the '<em><b>Tool Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TOOL_ID = 2;

  /**
   * The internal feature id for the '<em><b>Is Visible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IS_VISIBLE = 3;

  /**
   * The internal feature id for the '<em><b>Page</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PAGE = 4;

  /**
   * The internal feature id for the '<em><b>Lane Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LANE_ID = 5;

  /**
   * The internal feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_HEIGHT = 6;

  /**
   * The internal feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WIDTH = 7;

  /**
   * The internal feature id for the '<em><b>Border Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BORDER_COLOR = 8;

  /**
   * The internal feature id for the '<em><b>Fill Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FILL_COLOR = 9;

  /**
   * The internal feature id for the '<em><b>Shape</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SHAPE = 10;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 11;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 12;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_COORDINATES: return COORDINATES;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_TOOL_ID: return TOOL_ID;
      case INTERNAL_IS_VISIBLE: return IS_VISIBLE;
      case INTERNAL_PAGE: return PAGE;
      case INTERNAL_LANE_ID: return LANE_ID;
      case INTERNAL_HEIGHT: return HEIGHT;
      case INTERNAL_WIDTH: return WIDTH;
      case INTERNAL_BORDER_COLOR: return BORDER_COLOR;
      case INTERNAL_FILL_COLOR: return FILL_COLOR;
      case INTERNAL_SHAPE: return SHAPE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getCoordinates() <em>Coordinates</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCoordinates()
   * @generated
   * @ordered
   */
  
  protected Coordinates coordinates = null;
  
  /**
   * This is true if the Coordinates containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean coordinates_set_ = false;

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
   * The default value of the '{@link #isIsVisible() <em>Is Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsVisible()
   * @generated
   * @ordered
   */
  protected static final boolean IS_VISIBLE_DEFAULT_ = true;

  /**
   * The cached value of the '{@link #isIsVisible() <em>Is Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsVisible()
   * @generated
   * @ordered
   */
  protected boolean isVisible = IS_VISIBLE_DEFAULT_;

  /**
   * This is true if the Is Visible attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean isVisible_set_ = false;

  /**
   * The default value of the '{@link #getPage() <em>Page</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPage()
   * @generated
   * @ordered
   */
  protected static final String PAGE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPage() <em>Page</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPage()
   * @generated
   * @ordered
   */
  protected String page = PAGE_DEFAULT_;

  /**
   * This is true if the Page attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean page_set_ = false;

  /**
   * The default value of the '{@link #getLaneId() <em>Lane Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLaneId()
   * @generated
   * @ordered
   */
  protected static final String LANE_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLaneId() <em>Lane Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLaneId()
   * @generated
   * @ordered
   */
  protected String laneId = LANE_ID_DEFAULT_;

  /**
   * This is true if the Lane Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean laneId_set_ = false;

  /**
   * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeight()
   * @generated
   * @ordered
   */
  protected static final double HEIGHT_DEFAULT_ = 0.0;

  /**
   * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeight()
   * @generated
   * @ordered
   */
  protected double height = HEIGHT_DEFAULT_;

  /**
   * This is true if the Height attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean height_set_ = false;

  /**
   * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected static final double WIDTH_DEFAULT_ = 0.0;

  /**
   * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected double width = WIDTH_DEFAULT_;

  /**
   * This is true if the Width attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean width_set_ = false;

  /**
   * The default value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBorderColor()
   * @generated
   * @ordered
   */
  protected static final String BORDER_COLOR_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBorderColor()
   * @generated
   * @ordered
   */
  protected String borderColor = BORDER_COLOR_DEFAULT_;

  /**
   * This is true if the Border Color attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean borderColor_set_ = false;

  /**
   * The default value of the '{@link #getFillColor() <em>Fill Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFillColor()
   * @generated
   * @ordered
   */
  protected static final String FILL_COLOR_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getFillColor() <em>Fill Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFillColor()
   * @generated
   * @ordered
   */
  protected String fillColor = FILL_COLOR_DEFAULT_;

  /**
   * This is true if the Fill Color attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean fillColor_set_ = false;

  /**
   * The default value of the '{@link #getShape() <em>Shape</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShape()
   * @generated
   * @ordered
   */
  protected static final String SHAPE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getShape() <em>Shape</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShape()
   * @generated
   * @ordered
   */
  protected String shape = SHAPE_DEFAULT_;

  /**
   * This is true if the Shape attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean shape_set_ = false;

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
  public NodeGraphicsInfoImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getNodeGraphicsInfo();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinates getCoordinates()
  {
    return coordinates;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetCoordinates(Coordinates newCoordinates, ChangeContext changeContext)
  {
    Coordinates oldCoordinates = coordinates;
    coordinates = newCoordinates;
    boolean oldCoordinates_set_ = coordinates_set_;
    coordinates_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_COORDINATES, oldCoordinates, newCoordinates, !oldCoordinates_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCoordinates(Coordinates newCoordinates)
  {
    if (newCoordinates != coordinates)
    {
      ChangeContext changeContext = null;
      if (coordinates != null)
        changeContext = inverseRemove(coordinates, this, OPPOSITE_FEATURE_BASE - INTERNAL_COORDINATES, null, changeContext);
      if (newCoordinates != null)
        changeContext = inverseAdd(newCoordinates, this, OPPOSITE_FEATURE_BASE - INTERNAL_COORDINATES, null, changeContext);
      changeContext = basicSetCoordinates(newCoordinates, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldCoordinates_set_ = coordinates_set_;
      coordinates_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_COORDINATES, newCoordinates, newCoordinates, !oldCoordinates_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetCoordinates(ChangeContext changeContext)
  {
    Coordinates oldCoordinates = coordinates;
    coordinates = null;
    boolean oldCoordinates_set_ = coordinates_set_;
    coordinates_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_COORDINATES, oldCoordinates, null, !oldCoordinates_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCoordinates()
  {
    if (coordinates != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(coordinates, this, EOPPOSITE_FEATURE_BASE - INTERNAL_COORDINATES, null, changeContext);
      changeContext = basicUnsetCoordinates(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldCoordinates_set_ = coordinates_set_;
      coordinates_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_COORDINATES, null, null, oldCoordinates_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCoordinates()
  {
    return coordinates_set_;
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
  public boolean isIsVisible()
  {
    return isVisible;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsVisible(boolean newIsVisible)
  {
    boolean oldIsVisible = isVisible;
    isVisible = newIsVisible;
    boolean oldIsVisible_set_ = isVisible_set_;
    isVisible_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_IS_VISIBLE, oldIsVisible, isVisible, !oldIsVisible_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIsVisible()
  {
    boolean oldIsVisible = isVisible;
    boolean oldIsVisible_set_ = isVisible_set_;
    isVisible = IS_VISIBLE_DEFAULT_;
    isVisible_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_IS_VISIBLE, oldIsVisible, IS_VISIBLE_DEFAULT_, oldIsVisible_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIsVisible()
  {
    return isVisible_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPage()
  {
    return page;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPage(String newPage)
  {
    String oldPage = page;
    page = newPage;
    boolean oldPage_set_ = page_set_;
    page_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PAGE, oldPage, page, !oldPage_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPage()
  {
    String oldPage = page;
    boolean oldPage_set_ = page_set_;
    page = PAGE_DEFAULT_;
    page_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PAGE, oldPage, PAGE_DEFAULT_, oldPage_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPage()
  {
    return page_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLaneId()
  {
    return laneId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLaneId(String newLaneId)
  {
    String oldLaneId = laneId;
    laneId = newLaneId;
    boolean oldLaneId_set_ = laneId_set_;
    laneId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_LANE_ID, oldLaneId, laneId, !oldLaneId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLaneId()
  {
    String oldLaneId = laneId;
    boolean oldLaneId_set_ = laneId_set_;
    laneId = LANE_ID_DEFAULT_;
    laneId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_LANE_ID, oldLaneId, LANE_ID_DEFAULT_, oldLaneId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLaneId()
  {
    return laneId_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getHeight()
  {
    return height;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHeight(double newHeight)
  {
    double oldHeight = height;
    height = newHeight;
    boolean oldHeight_set_ = height_set_;
    height_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_HEIGHT, oldHeight, height, !oldHeight_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetHeight()
  {
    double oldHeight = height;
    boolean oldHeight_set_ = height_set_;
    height = HEIGHT_DEFAULT_;
    height_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_HEIGHT, oldHeight, HEIGHT_DEFAULT_, oldHeight_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetHeight()
  {
    return height_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getWidth()
  {
    return width;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWidth(double newWidth)
  {
    double oldWidth = width;
    width = newWidth;
    boolean oldWidth_set_ = width_set_;
    width_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_WIDTH, oldWidth, width, !oldWidth_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWidth()
  {
    double oldWidth = width;
    boolean oldWidth_set_ = width_set_;
    width = WIDTH_DEFAULT_;
    width_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_WIDTH, oldWidth, WIDTH_DEFAULT_, oldWidth_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetWidth()
  {
    return width_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBorderColor()
  {
    return borderColor;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBorderColor(String newBorderColor)
  {
    String oldBorderColor = borderColor;
    borderColor = newBorderColor;
    boolean oldBorderColor_set_ = borderColor_set_;
    borderColor_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_BORDER_COLOR, oldBorderColor, borderColor, !oldBorderColor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBorderColor()
  {
    String oldBorderColor = borderColor;
    boolean oldBorderColor_set_ = borderColor_set_;
    borderColor = BORDER_COLOR_DEFAULT_;
    borderColor_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_BORDER_COLOR, oldBorderColor, BORDER_COLOR_DEFAULT_, oldBorderColor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBorderColor()
  {
    return borderColor_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFillColor()
  {
    return fillColor;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFillColor(String newFillColor)
  {
    String oldFillColor = fillColor;
    fillColor = newFillColor;
    boolean oldFillColor_set_ = fillColor_set_;
    fillColor_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_FILL_COLOR, oldFillColor, fillColor, !oldFillColor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFillColor()
  {
    String oldFillColor = fillColor;
    boolean oldFillColor_set_ = fillColor_set_;
    fillColor = FILL_COLOR_DEFAULT_;
    fillColor_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_FILL_COLOR, oldFillColor, FILL_COLOR_DEFAULT_, oldFillColor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFillColor()
  {
    return fillColor_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShape()
  {
    return shape;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShape(String newShape)
  {
    String oldShape = shape;
    shape = newShape;
    boolean oldShape_set_ = shape_set_;
    shape_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SHAPE, oldShape, shape, !oldShape_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetShape()
  {
    String oldShape = shape;
    boolean oldShape_set_ = shape_set_;
    shape = SHAPE_DEFAULT_;
    shape_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SHAPE, oldShape, SHAPE_DEFAULT_, oldShape_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetShape()
  {
    return shape_set_;
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
      case COORDINATES:
        return basicUnsetCoordinates(changeContext);
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
      case COORDINATES:
        return getCoordinates();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case TOOL_ID:
        return getToolId();
      case IS_VISIBLE:
        return isIsVisible() ? Boolean.TRUE : Boolean.FALSE;
      case PAGE:
        return getPage();
      case LANE_ID:
        return getLaneId();
      case HEIGHT:
        return new Double(getHeight());
      case WIDTH:
        return new Double(getWidth());
      case BORDER_COLOR:
        return getBorderColor();
      case FILL_COLOR:
        return getFillColor();
      case SHAPE:
        return getShape();
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
      case COORDINATES:
        setCoordinates((Coordinates)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case TOOL_ID:
        setToolId((String)newValue);
        return;
      case IS_VISIBLE:
        setIsVisible(((Boolean)newValue).booleanValue());
        return;
      case PAGE:
        setPage((String)newValue);
        return;
      case LANE_ID:
        setLaneId((String)newValue);
        return;
      case HEIGHT:
        setHeight(((Double)newValue).doubleValue());
        return;
      case WIDTH:
        setWidth(((Double)newValue).doubleValue());
        return;
      case BORDER_COLOR:
        setBorderColor((String)newValue);
        return;
      case FILL_COLOR:
        setFillColor((String)newValue);
        return;
      case SHAPE:
        setShape((String)newValue);
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
      case COORDINATES:
        unsetCoordinates();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case TOOL_ID:
        unsetToolId();
        return;
      case IS_VISIBLE:
        unsetIsVisible();
        return;
      case PAGE:
        unsetPage();
        return;
      case LANE_ID:
        unsetLaneId();
        return;
      case HEIGHT:
        unsetHeight();
        return;
      case WIDTH:
        unsetWidth();
        return;
      case BORDER_COLOR:
        unsetBorderColor();
        return;
      case FILL_COLOR:
        unsetFillColor();
        return;
      case SHAPE:
        unsetShape();
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
      case COORDINATES:
        return isSetCoordinates();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case TOOL_ID:
        return isSetToolId();
      case IS_VISIBLE:
        return isSetIsVisible();
      case PAGE:
        return isSetPage();
      case LANE_ID:
        return isSetLaneId();
      case HEIGHT:
        return isSetHeight();
      case WIDTH:
        return isSetWidth();
      case BORDER_COLOR:
        return isSetBorderColor();
      case FILL_COLOR:
        return isSetFillColor();
      case SHAPE:
        return isSetShape();
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
    result.append(", IsVisible: ");
    if (isVisible_set_) result.append(isVisible); else result.append("<unset>");
    result.append(", Page: ");
    if (page_set_) result.append(page); else result.append("<unset>");
    result.append(", LaneId: ");
    if (laneId_set_) result.append(laneId); else result.append("<unset>");
    result.append(", Height: ");
    if (height_set_) result.append(height); else result.append("<unset>");
    result.append(", Width: ");
    if (width_set_) result.append(width); else result.append("<unset>");
    result.append(", BorderColor: ");
    if (borderColor_set_) result.append(borderColor); else result.append("<unset>");
    result.append(", FillColor: ");
    if (fillColor_set_) result.append(fillColor); else result.append("<unset>");
    result.append(", Shape: ");
    if (shape_set_) result.append(shape); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //NodeGraphicsInfoImpl
