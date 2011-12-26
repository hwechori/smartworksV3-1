/**
 * <copyright>
 * </copyright>
 *
 * $Id: IconImpl.java,v 1.1 2009/12/22 06:17:37 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import java.math.BigInteger;

import net.smartworks.server.engine.process.xpdl.xpdl2.Icon;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Icon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IconImpl#getValue <em>Value</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IconImpl#getXCOORD <em>XCOORD</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IconImpl#getYCOORD <em>YCOORD</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IconImpl#getWIDTH <em>WIDTH</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IconImpl#getHEIGHT <em>HEIGHT</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IconImpl#getSHAPE <em>SHAPE</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.IconImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IconImpl extends DataObjectBase implements Icon
{

  public final static int VALUE = 0;

  public final static int XCOORD = 1;

  public final static int YCOORD = 2;

  public final static int WIDTH = 3;

  public final static int HEIGHT = 4;

  public final static int SHAPE = 5;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 6;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VALUE = 0;

  /**
   * The internal feature id for the '<em><b>XCOORD</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XCOORD = 1;

  /**
   * The internal feature id for the '<em><b>YCOORD</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_YCOORD = 2;

  /**
   * The internal feature id for the '<em><b>WIDTH</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WIDTH = 3;

  /**
   * The internal feature id for the '<em><b>HEIGHT</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_HEIGHT = 4;

  /**
   * The internal feature id for the '<em><b>SHAPE</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SHAPE = 5;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 6;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 7;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_VALUE: return VALUE;
      case INTERNAL_XCOORD: return XCOORD;
      case INTERNAL_YCOORD: return YCOORD;
      case INTERNAL_WIDTH: return WIDTH;
      case INTERNAL_HEIGHT: return HEIGHT;
      case INTERNAL_SHAPE: return SHAPE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_DEFAULT_;

  /**
   * This is true if the Value attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean value_set_ = false;

  /**
   * The default value of the '{@link #getXCOORD() <em>XCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXCOORD()
   * @generated
   * @ordered
   */
  protected static final BigInteger XCOORD_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getXCOORD() <em>XCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXCOORD()
   * @generated
   * @ordered
   */
  protected BigInteger xcoord = XCOORD_DEFAULT_;

  /**
   * This is true if the XCOORD attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xcoord_set_ = false;

  /**
   * The default value of the '{@link #getYCOORD() <em>YCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYCOORD()
   * @generated
   * @ordered
   */
  protected static final BigInteger YCOORD_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getYCOORD() <em>YCOORD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYCOORD()
   * @generated
   * @ordered
   */
  protected BigInteger ycoord = YCOORD_DEFAULT_;

  /**
   * This is true if the YCOORD attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean ycoord_set_ = false;

  /**
   * The default value of the '{@link #getWIDTH() <em>WIDTH</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWIDTH()
   * @generated
   * @ordered
   */
  protected static final BigInteger WIDTH_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getWIDTH() <em>WIDTH</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWIDTH()
   * @generated
   * @ordered
   */
  protected BigInteger width = WIDTH_DEFAULT_;

  /**
   * This is true if the WIDTH attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean width_set_ = false;

  /**
   * The default value of the '{@link #getHEIGHT() <em>HEIGHT</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHEIGHT()
   * @generated
   * @ordered
   */
  protected static final BigInteger HEIGHT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getHEIGHT() <em>HEIGHT</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHEIGHT()
   * @generated
   * @ordered
   */
  protected BigInteger height = HEIGHT_DEFAULT_;

  /**
   * This is true if the HEIGHT attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean height_set_ = false;

  /**
   * The default value of the '{@link #getSHAPE() <em>SHAPE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSHAPE()
   * @generated
   * @ordered
   */
  protected static final String SHAPE_DEFAULT_ = "RoundRectangle";

  /**
   * The cached value of the '{@link #getSHAPE() <em>SHAPE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSHAPE()
   * @generated
   * @ordered
   */
  protected String shape = SHAPE_DEFAULT_;

  /**
   * This is true if the SHAPE attribute has been set.
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
  public IconImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getIcon();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    boolean oldValue_set_ = value_set_;
    value_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_VALUE, oldValue, value, !oldValue_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetValue()
  {
    String oldValue = value;
    boolean oldValue_set_ = value_set_;
    value = VALUE_DEFAULT_;
    value_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_VALUE, oldValue, VALUE_DEFAULT_, oldValue_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetValue()
  {
    return value_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getXCOORD()
  {
    return xcoord;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXCOORD(BigInteger newXCOORD)
  {
    BigInteger oldXCOORD = xcoord;
    xcoord = newXCOORD;
    boolean oldXCOORD_set_ = xcoord_set_;
    xcoord_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_XCOORD, oldXCOORD, xcoord, !oldXCOORD_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXCOORD()
  {
    BigInteger oldXCOORD = xcoord;
    boolean oldXCOORD_set_ = xcoord_set_;
    xcoord = XCOORD_DEFAULT_;
    xcoord_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_XCOORD, oldXCOORD, XCOORD_DEFAULT_, oldXCOORD_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetXCOORD()
  {
    return xcoord_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getYCOORD()
  {
    return ycoord;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setYCOORD(BigInteger newYCOORD)
  {
    BigInteger oldYCOORD = ycoord;
    ycoord = newYCOORD;
    boolean oldYCOORD_set_ = ycoord_set_;
    ycoord_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_YCOORD, oldYCOORD, ycoord, !oldYCOORD_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetYCOORD()
  {
    BigInteger oldYCOORD = ycoord;
    boolean oldYCOORD_set_ = ycoord_set_;
    ycoord = YCOORD_DEFAULT_;
    ycoord_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_YCOORD, oldYCOORD, YCOORD_DEFAULT_, oldYCOORD_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetYCOORD()
  {
    return ycoord_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getWIDTH()
  {
    return width;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWIDTH(BigInteger newWIDTH)
  {
    BigInteger oldWIDTH = width;
    width = newWIDTH;
    boolean oldWIDTH_set_ = width_set_;
    width_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_WIDTH, oldWIDTH, width, !oldWIDTH_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWIDTH()
  {
    BigInteger oldWIDTH = width;
    boolean oldWIDTH_set_ = width_set_;
    width = WIDTH_DEFAULT_;
    width_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_WIDTH, oldWIDTH, WIDTH_DEFAULT_, oldWIDTH_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetWIDTH()
  {
    return width_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getHEIGHT()
  {
    return height;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHEIGHT(BigInteger newHEIGHT)
  {
    BigInteger oldHEIGHT = height;
    height = newHEIGHT;
    boolean oldHEIGHT_set_ = height_set_;
    height_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_HEIGHT, oldHEIGHT, height, !oldHEIGHT_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetHEIGHT()
  {
    BigInteger oldHEIGHT = height;
    boolean oldHEIGHT_set_ = height_set_;
    height = HEIGHT_DEFAULT_;
    height_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_HEIGHT, oldHEIGHT, HEIGHT_DEFAULT_, oldHEIGHT_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetHEIGHT()
  {
    return height_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSHAPE()
  {
    return shape;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSHAPE(String newSHAPE)
  {
    String oldSHAPE = shape;
    shape = newSHAPE;
    boolean oldSHAPE_set_ = shape_set_;
    shape_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SHAPE, oldSHAPE, shape, !oldSHAPE_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSHAPE()
  {
    String oldSHAPE = shape;
    boolean oldSHAPE_set_ = shape_set_;
    shape = SHAPE_DEFAULT_;
    shape_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SHAPE, oldSHAPE, SHAPE_DEFAULT_, oldSHAPE_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSHAPE()
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
      case VALUE:
        return getValue();
      case XCOORD:
        return getXCOORD();
      case YCOORD:
        return getYCOORD();
      case WIDTH:
        return getWIDTH();
      case HEIGHT:
        return getHEIGHT();
      case SHAPE:
        return getSHAPE();
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
      case VALUE:
        setValue((String)newValue);
        return;
      case XCOORD:
        setXCOORD((BigInteger)newValue);
        return;
      case YCOORD:
        setYCOORD((BigInteger)newValue);
        return;
      case WIDTH:
        setWIDTH((BigInteger)newValue);
        return;
      case HEIGHT:
        setHEIGHT((BigInteger)newValue);
        return;
      case SHAPE:
        setSHAPE((String)newValue);
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
      case VALUE:
        unsetValue();
        return;
      case XCOORD:
        unsetXCOORD();
        return;
      case YCOORD:
        unsetYCOORD();
        return;
      case WIDTH:
        unsetWIDTH();
        return;
      case HEIGHT:
        unsetHEIGHT();
        return;
      case SHAPE:
        unsetSHAPE();
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
      case VALUE:
        return isSetValue();
      case XCOORD:
        return isSetXCOORD();
      case YCOORD:
        return isSetYCOORD();
      case WIDTH:
        return isSetWIDTH();
      case HEIGHT:
        return isSetHEIGHT();
      case SHAPE:
        return isSetSHAPE();
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
    result.append(" (value: ");
    if (value_set_) result.append(value); else result.append("<unset>");
    result.append(", XCOORD: ");
    if (xcoord_set_) result.append(xcoord); else result.append("<unset>");
    result.append(", YCOORD: ");
    if (ycoord_set_) result.append(ycoord); else result.append("<unset>");
    result.append(", WIDTH: ");
    if (width_set_) result.append(width); else result.append("<unset>");
    result.append(", HEIGHT: ");
    if (height_set_) result.append(height); else result.append("<unset>");
    result.append(", SHAPE: ");
    if (shape_set_) result.append(shape); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //IconImpl
