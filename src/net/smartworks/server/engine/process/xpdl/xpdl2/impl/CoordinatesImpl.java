/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoordinatesImpl.java,v 1.1 2009/12/22 06:17:41 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Coordinates;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coordinates</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.CoordinatesImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.CoordinatesImpl#getXCoordinate <em>XCoordinate</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.CoordinatesImpl#getYCoordinate <em>YCoordinate</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.CoordinatesImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoordinatesImpl extends DataObjectBase implements Coordinates
{

  public final static int ANY = -1;

  public final static int XCOORDINATE = 0;

  public final static int YCOORDINATE = 1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 2;

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
   * The internal feature id for the '<em><b>XCoordinate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XCOORDINATE = 1;

  /**
   * The internal feature id for the '<em><b>YCoordinate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_YCOORDINATE = 2;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 3;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 4;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_ANY: return ANY;
      case INTERNAL_XCOORDINATE: return XCOORDINATE;
      case INTERNAL_YCOORDINATE: return YCOORDINATE;
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
   * The default value of the '{@link #getXCoordinate() <em>XCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXCoordinate()
   * @generated
   * @ordered
   */
  protected static final double XCOORDINATE_DEFAULT_ = 0.0;

  /**
   * The cached value of the '{@link #getXCoordinate() <em>XCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXCoordinate()
   * @generated
   * @ordered
   */
  protected double xCoordinate = XCOORDINATE_DEFAULT_;

  /**
   * This is true if the XCoordinate attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xCoordinate_set_ = false;

  /**
   * The default value of the '{@link #getYCoordinate() <em>YCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYCoordinate()
   * @generated
   * @ordered
   */
  protected static final double YCOORDINATE_DEFAULT_ = 0.0;

  /**
   * The cached value of the '{@link #getYCoordinate() <em>YCoordinate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYCoordinate()
   * @generated
   * @ordered
   */
  protected double yCoordinate = YCOORDINATE_DEFAULT_;

  /**
   * This is true if the YCoordinate attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean yCoordinate_set_ = false;

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
  public CoordinatesImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getCoordinates();
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
  public double getXCoordinate()
  {
    return xCoordinate;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXCoordinate(double newXCoordinate)
  {
    double oldXCoordinate = xCoordinate;
    xCoordinate = newXCoordinate;
    boolean oldXCoordinate_set_ = xCoordinate_set_;
    xCoordinate_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_XCOORDINATE, oldXCoordinate, xCoordinate, !oldXCoordinate_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXCoordinate()
  {
    double oldXCoordinate = xCoordinate;
    boolean oldXCoordinate_set_ = xCoordinate_set_;
    xCoordinate = XCOORDINATE_DEFAULT_;
    xCoordinate_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_XCOORDINATE, oldXCoordinate, XCOORDINATE_DEFAULT_, oldXCoordinate_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetXCoordinate()
  {
    return xCoordinate_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getYCoordinate()
  {
    return yCoordinate;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setYCoordinate(double newYCoordinate)
  {
    double oldYCoordinate = yCoordinate;
    yCoordinate = newYCoordinate;
    boolean oldYCoordinate_set_ = yCoordinate_set_;
    yCoordinate_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_YCOORDINATE, oldYCoordinate, yCoordinate, !oldYCoordinate_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetYCoordinate()
  {
    double oldYCoordinate = yCoordinate;
    boolean oldYCoordinate_set_ = yCoordinate_set_;
    yCoordinate = YCOORDINATE_DEFAULT_;
    yCoordinate_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_YCOORDINATE, oldYCoordinate, YCOORDINATE_DEFAULT_, oldYCoordinate_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetYCoordinate()
  {
    return yCoordinate_set_;
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
      case XCOORDINATE:
        return new Double(getXCoordinate());
      case YCOORDINATE:
        return new Double(getYCoordinate());
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
      case XCOORDINATE:
        setXCoordinate(((Double)newValue).doubleValue());
        return;
      case YCOORDINATE:
        setYCoordinate(((Double)newValue).doubleValue());
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
      case XCOORDINATE:
        unsetXCoordinate();
        return;
      case YCOORDINATE:
        unsetYCoordinate();
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
      case XCOORDINATE:
        return isSetXCoordinate();
      case YCOORDINATE:
        return isSetYCoordinate();
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
    result.append(", XCoordinate: ");
    if (xCoordinate_set_) result.append(xCoordinate); else result.append("<unset>");
    result.append(", YCoordinate: ");
    if (yCoordinate_set_) result.append(yCoordinate); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //CoordinatesImpl
