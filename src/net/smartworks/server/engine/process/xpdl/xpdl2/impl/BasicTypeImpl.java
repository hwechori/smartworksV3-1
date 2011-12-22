/**
 * <copyright>
 * </copyright>
 *
 * $Id: BasicTypeImpl.java,v 1.1 2009/12/22 06:17:28 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.BasicType;
import net.smartworks.server.engine.process.xpdl.xpdl2.Length;
import net.smartworks.server.engine.process.xpdl.xpdl2.Precision;
import net.smartworks.server.engine.process.xpdl.xpdl2.Scale;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BasicTypeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BasicTypeImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BasicTypeImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BasicTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BasicTypeImpl#getType_ <em>Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.BasicTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicTypeImpl extends DataObjectBase implements BasicType
{

  public final static int LENGTH = 0;

  public final static int PRECISION = 1;

  public final static int SCALE = 2;

  public final static int ANY = -1;

  public final static int TYPE = 3;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 4;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Length</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LENGTH = 0;

  /**
   * The internal feature id for the '<em><b>Precision</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRECISION = 1;

  /**
   * The internal feature id for the '<em><b>Scale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SCALE = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

  /**
   * The internal feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE = 4;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 5;

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
      case INTERNAL_LENGTH: return LENGTH;
      case INTERNAL_PRECISION: return PRECISION;
      case INTERNAL_SCALE: return SCALE;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_TYPE: return TYPE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getLength() <em>Length</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  
  protected Length length = null;
  
  /**
   * This is true if the Length containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean length_set_ = false;

  /**
   * The cached value of the '{@link #getPrecision() <em>Precision</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecision()
   * @generated
   * @ordered
   */
  
  protected Precision precision = null;
  
  /**
   * This is true if the Precision containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean precision_set_ = false;

  /**
   * The cached value of the '{@link #getScale() <em>Scale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScale()
   * @generated
   * @ordered
   */
  
  protected Scale scale = null;
  
  /**
   * This is true if the Scale containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean scale_set_ = false;

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
   * The default value of the '{@link #getType_() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_()
   * @generated
   * @ordered
   */
  protected static final String TYPE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getType_() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_()
   * @generated
   * @ordered
   */
  protected String type = TYPE_DEFAULT_;

  /**
   * This is true if the Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean type_set_ = false;

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
  public BasicTypeImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getBasicType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Length getLength()
  {
    return length;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetLength(Length newLength, ChangeContext changeContext)
  {
    Length oldLength = length;
    length = newLength;
    boolean oldLength_set_ = length_set_;
    length_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_LENGTH, oldLength, newLength, !oldLength_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLength(Length newLength)
  {
    if (newLength != length)
    {
      ChangeContext changeContext = null;
      if (length != null)
        changeContext = inverseRemove(length, this, OPPOSITE_FEATURE_BASE - INTERNAL_LENGTH, null, changeContext);
      if (newLength != null)
        changeContext = inverseAdd(newLength, this, OPPOSITE_FEATURE_BASE - INTERNAL_LENGTH, null, changeContext);
      changeContext = basicSetLength(newLength, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldLength_set_ = length_set_;
      length_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_LENGTH, newLength, newLength, !oldLength_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetLength(ChangeContext changeContext)
  {
    Length oldLength = length;
    length = null;
    boolean oldLength_set_ = length_set_;
    length_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_LENGTH, oldLength, null, !oldLength_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLength()
  {
    if (length != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(length, this, EOPPOSITE_FEATURE_BASE - INTERNAL_LENGTH, null, changeContext);
      changeContext = basicUnsetLength(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldLength_set_ = length_set_;
      length_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_LENGTH, null, null, oldLength_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLength()
  {
    return length_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Precision getPrecision()
  {
    return precision;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPrecision(Precision newPrecision, ChangeContext changeContext)
  {
    Precision oldPrecision = precision;
    precision = newPrecision;
    boolean oldPrecision_set_ = precision_set_;
    precision_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PRECISION, oldPrecision, newPrecision, !oldPrecision_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrecision(Precision newPrecision)
  {
    if (newPrecision != precision)
    {
      ChangeContext changeContext = null;
      if (precision != null)
        changeContext = inverseRemove(precision, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRECISION, null, changeContext);
      if (newPrecision != null)
        changeContext = inverseAdd(newPrecision, this, OPPOSITE_FEATURE_BASE - INTERNAL_PRECISION, null, changeContext);
      changeContext = basicSetPrecision(newPrecision, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPrecision_set_ = precision_set_;
      precision_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PRECISION, newPrecision, newPrecision, !oldPrecision_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPrecision(ChangeContext changeContext)
  {
    Precision oldPrecision = precision;
    precision = null;
    boolean oldPrecision_set_ = precision_set_;
    precision_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PRECISION, oldPrecision, null, !oldPrecision_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPrecision()
  {
    if (precision != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(precision, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PRECISION, null, changeContext);
      changeContext = basicUnsetPrecision(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPrecision_set_ = precision_set_;
      precision_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PRECISION, null, null, oldPrecision_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPrecision()
  {
    return precision_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scale getScale()
  {
    return scale;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetScale(Scale newScale, ChangeContext changeContext)
  {
    Scale oldScale = scale;
    scale = newScale;
    boolean oldScale_set_ = scale_set_;
    scale_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SCALE, oldScale, newScale, !oldScale_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScale(Scale newScale)
  {
    if (newScale != scale)
    {
      ChangeContext changeContext = null;
      if (scale != null)
        changeContext = inverseRemove(scale, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCALE, null, changeContext);
      if (newScale != null)
        changeContext = inverseAdd(newScale, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCALE, null, changeContext);
      changeContext = basicSetScale(newScale, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldScale_set_ = scale_set_;
      scale_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SCALE, newScale, newScale, !oldScale_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetScale(ChangeContext changeContext)
  {
    Scale oldScale = scale;
    scale = null;
    boolean oldScale_set_ = scale_set_;
    scale_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SCALE, oldScale, null, !oldScale_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetScale()
  {
    if (scale != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(scale, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SCALE, null, changeContext);
      changeContext = basicUnsetScale(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldScale_set_ = scale_set_;
      scale_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SCALE, null, null, oldScale_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetScale()
  {
    return scale_set_;
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
  public String getType_()
  {
    return type;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    boolean oldType_set_ = type_set_;
    type_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TYPE, oldType, type, !oldType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetType()
  {
    String oldType = type;
    boolean oldType_set_ = type_set_;
    type = TYPE_DEFAULT_;
    type_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TYPE, oldType, TYPE_DEFAULT_, oldType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetType()
  {
    return type_set_;
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
      case LENGTH:
        return basicUnsetLength(changeContext);
      case PRECISION:
        return basicUnsetPrecision(changeContext);
      case SCALE:
        return basicUnsetScale(changeContext);
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
      case LENGTH:
        return getLength();
      case PRECISION:
        return getPrecision();
      case SCALE:
        return getScale();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case TYPE:
        return getType_();
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
      case LENGTH:
        setLength((Length)newValue);
        return;
      case PRECISION:
        setPrecision((Precision)newValue);
        return;
      case SCALE:
        setScale((Scale)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case TYPE:
        setType((String)newValue);
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
      case LENGTH:
        unsetLength();
        return;
      case PRECISION:
        unsetPrecision();
        return;
      case SCALE:
        unsetScale();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case TYPE:
        unsetType();
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
      case LENGTH:
        return isSetLength();
      case PRECISION:
        return isSetPrecision();
      case SCALE:
        return isSetScale();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case TYPE:
        return isSetType();
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
    result.append(", Type: ");
    if (type_set_) result.append(type); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //BasicTypeImpl
