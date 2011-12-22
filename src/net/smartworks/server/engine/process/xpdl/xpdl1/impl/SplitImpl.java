/**
 * <copyright>
 * </copyright>
 *
 * $Id: SplitImpl.java,v 1.1 2009/12/22 06:17:18 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Split;
import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRefs;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SplitImpl#getTransitionRefs <em>Transition Refs</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.SplitImpl#getType_ <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SplitImpl extends DataObjectBase implements Split
{

  public final static int TRANSITION_REFS = 0;

  public final static int TYPE = 1;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Transition Refs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITION_REFS = 0;

  /**
   * The internal feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE = 1;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 2;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_TRANSITION_REFS: return TRANSITION_REFS;
      case INTERNAL_TYPE: return TYPE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getTransitionRefs() <em>Transition Refs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionRefs()
   * @generated
   * @ordered
   */
  
  protected TransitionRefs transitionRefs = null;
  
  /**
   * This is true if the Transition Refs containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transitionRefs_set_ = false;

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
  public SplitImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getSplit();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRefs getTransitionRefs()
  {
    return transitionRefs;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransitionRefs(TransitionRefs newTransitionRefs, ChangeContext changeContext)
  {
    TransitionRefs oldTransitionRefs = transitionRefs;
    transitionRefs = newTransitionRefs;
    boolean oldTransitionRefs_set_ = transitionRefs_set_;
    transitionRefs_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSITION_REFS, oldTransitionRefs, newTransitionRefs, !oldTransitionRefs_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitionRefs(TransitionRefs newTransitionRefs)
  {
    if (newTransitionRefs != transitionRefs)
    {
      ChangeContext changeContext = null;
      if (transitionRefs != null)
        changeContext = inverseRemove(transitionRefs, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_REFS, null, changeContext);
      if (newTransitionRefs != null)
        changeContext = inverseAdd(newTransitionRefs, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_REFS, null, changeContext);
      changeContext = basicSetTransitionRefs(newTransitionRefs, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransitionRefs_set_ = transitionRefs_set_;
      transitionRefs_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSITION_REFS, newTransitionRefs, newTransitionRefs, !oldTransitionRefs_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransitionRefs(ChangeContext changeContext)
  {
    TransitionRefs oldTransitionRefs = transitionRefs;
    transitionRefs = null;
    boolean oldTransitionRefs_set_ = transitionRefs_set_;
    transitionRefs_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSITION_REFS, oldTransitionRefs, null, !oldTransitionRefs_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransitionRefs()
  {
    if (transitionRefs != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transitionRefs, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSITION_REFS, null, changeContext);
      changeContext = basicUnsetTransitionRefs(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransitionRefs_set_ = transitionRefs_set_;
      transitionRefs_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSITION_REFS, null, null, oldTransitionRefs_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransitionRefs()
  {
    return transitionRefs_set_;
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
      case TRANSITION_REFS:
        return basicUnsetTransitionRefs(changeContext);
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
      case TRANSITION_REFS:
        return getTransitionRefs();
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
      case TRANSITION_REFS:
        setTransitionRefs((TransitionRefs)newValue);
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
      case TRANSITION_REFS:
        unsetTransitionRefs();
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
      case TRANSITION_REFS:
        return isSetTransitionRefs();
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
    result.append(" (Type: ");
    if (type_set_) result.append(type); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //SplitImpl
