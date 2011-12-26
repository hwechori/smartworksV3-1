/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConnectorGraphicsInfoImpl.java,v 1.1 2009/12/22 06:17:38 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import java.util.Collection;
import java.util.List;

import net.smartworks.server.engine.process.xpdl.xpdl2.ConnectorGraphicsInfo;
import net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Graphics Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getToolId <em>Tool Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#isIsVisible <em>Is Visible</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getPage <em>Page</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getFillColor <em>Fill Color</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ConnectorGraphicsInfoImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorGraphicsInfoImpl extends DataObjectBase implements ConnectorGraphicsInfo
{

  public final static int COORDINATES = 0;

  public final static int ANY = -1;

  public final static int TOOL_ID = 1;

  public final static int IS_VISIBLE = 2;

  public final static int PAGE = 3;

  public final static int STYLE = 4;

  public final static int BORDER_COLOR = 5;

  public final static int FILL_COLOR = 6;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 7;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Coordinates</b></em>' containment reference list.
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
   * The internal feature id for the '<em><b>Style</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_STYLE = 5;

  /**
   * The internal feature id for the '<em><b>Border Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BORDER_COLOR = 6;

  /**
   * The internal feature id for the '<em><b>Fill Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FILL_COLOR = 7;

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
      case INTERNAL_COORDINATES: return COORDINATES;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_TOOL_ID: return TOOL_ID;
      case INTERNAL_IS_VISIBLE: return IS_VISIBLE;
      case INTERNAL_PAGE: return PAGE;
      case INTERNAL_STYLE: return STYLE;
      case INTERNAL_BORDER_COLOR: return BORDER_COLOR;
      case INTERNAL_FILL_COLOR: return FILL_COLOR;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getCoordinates() <em>Coordinates</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCoordinates()
   * @generated
   * @ordered
   */
  
  protected List coordinates = null;
  
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
   * The default value of the '{@link #getStyle() <em>Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStyle()
   * @generated
   * @ordered
   */
  protected static final String STYLE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getStyle() <em>Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStyle()
   * @generated
   * @ordered
   */
  protected String style = STYLE_DEFAULT_;

  /**
   * This is true if the Style attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean style_set_ = false;

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
  public ConnectorGraphicsInfoImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getConnectorGraphicsInfo();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getCoordinates()
  {
    if (coordinates == null)
    {
      coordinates = createPropertyList(ListKind.CONTAINMENT, Coordinates.class, COORDINATES, 0);
    }
    return coordinates;
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
  public String getStyle()
  {
    return style;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStyle(String newStyle)
  {
    String oldStyle = style;
    style = newStyle;
    boolean oldStyle_set_ = style_set_;
    style_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_STYLE, oldStyle, style, !oldStyle_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStyle()
  {
    String oldStyle = style;
    boolean oldStyle_set_ = style_set_;
    style = STYLE_DEFAULT_;
    style_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_STYLE, oldStyle, STYLE_DEFAULT_, oldStyle_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStyle()
  {
    return style_set_;
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
        return removeFromList(getCoordinates(), otherEnd, changeContext);
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
      case STYLE:
        return getStyle();
      case BORDER_COLOR:
        return getBorderColor();
      case FILL_COLOR:
        return getFillColor();
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
        getCoordinates().clear();
        getCoordinates().addAll((Collection)newValue);
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
      case STYLE:
        setStyle((String)newValue);
        return;
      case BORDER_COLOR:
        setBorderColor((String)newValue);
        return;
      case FILL_COLOR:
        setFillColor((String)newValue);
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
        getCoordinates().clear();
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
      case STYLE:
        unsetStyle();
        return;
      case BORDER_COLOR:
        unsetBorderColor();
        return;
      case FILL_COLOR:
        unsetFillColor();
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
        return coordinates != null && !coordinates.isEmpty();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case TOOL_ID:
        return isSetToolId();
      case IS_VISIBLE:
        return isSetIsVisible();
      case PAGE:
        return isSetPage();
      case STYLE:
        return isSetStyle();
      case BORDER_COLOR:
        return isSetBorderColor();
      case FILL_COLOR:
        return isSetFillColor();
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
    result.append(", Style: ");
    if (style_set_) result.append(style); else result.append("<unset>");
    result.append(", BorderColor: ");
    if (borderColor_set_) result.append(borderColor); else result.append("<unset>");
    result.append(", FillColor: ");
    if (fillColor_set_) result.append(fillColor); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //ConnectorGraphicsInfoImpl
