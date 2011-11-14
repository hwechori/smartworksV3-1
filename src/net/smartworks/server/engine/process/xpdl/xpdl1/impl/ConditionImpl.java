/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConditionImpl.java,v 1.1 2009/12/22 06:17:17 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Condition;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ConditionImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ConditionImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ConditionImpl#getXpression <em>Xpression</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ConditionImpl#getType_ <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionImpl extends DataObjectBase implements Condition
{

  public final static int MIXED = -1;

  public final static int GROUP = -2;

  public final static int XPRESSION = 0;

  public final static int TYPE = 1;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MIXED = 0;

  /**
   * The internal feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GROUP = 1;

  /**
   * The internal feature id for the '<em><b>Xpression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XPRESSION = 2;

  /**
   * The internal feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE = 3;

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
      case INTERNAL_MIXED: return MIXED;
      case INTERNAL_GROUP: return GROUP;
      case INTERNAL_XPRESSION: return XPRESSION;
      case INTERNAL_TYPE: return TYPE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixed()
   * @generated
   * @ordered
   */
  
  protected Sequence mixed = null;
  
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getCondition();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getMixed()
  {
    if (mixed == null)
    {
      mixed = createSequence(INTERNAL_MIXED);
    }
    return mixed;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getGroup()
  {
    return createSequence(getMixed(), getType(), INTERNAL_GROUP);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getXpression()
  {
    return getList(getGroup(), getType(), INTERNAL_XPRESSION);
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
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case MIXED:
        return removeFromSequence(getMixed(), otherEnd, changeContext);
      case GROUP:
        return removeFromSequence(getGroup(), otherEnd, changeContext);
      case XPRESSION:
        return removeFromList(getXpression(), otherEnd, changeContext);
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
      case MIXED:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getMixed();
      case GROUP:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getGroup();
      case XPRESSION:
        return getXpression();
      case TYPE:
        return getType_();
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
      case MIXED:
      	setSequence(getMixed(), newValue);
        return;
      case GROUP:
      	setSequence(getGroup(), newValue);
        return;
      case XPRESSION:
        getXpression().clear();
        getXpression().addAll((Collection)newValue);
        return;
      case TYPE:
        setType((String)newValue);
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
      case MIXED:
        unsetSequence(getMixed());
        return;
      case GROUP:
        unsetSequence(getGroup());
        return;
      case XPRESSION:
        getXpression().clear();
        return;
      case TYPE:
        unsetType();
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
      case MIXED:
        return mixed != null && !isSequenceEmpty(getMixed());
      case GROUP:
        return !isSequenceEmpty(getGroup());
      case XPRESSION:
        return !getXpression().isEmpty();
      case TYPE:
        return isSetType();
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
    result.append(" (mixed: ");
    result.append(mixed);
    result.append(", Type: ");
    if (type_set_) result.append(type); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ConditionImpl
