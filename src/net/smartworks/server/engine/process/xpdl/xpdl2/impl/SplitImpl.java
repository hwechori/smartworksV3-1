/**
 * <copyright>
 * </copyright>
 *
 * $Id: SplitImpl.java,v 1.1 2009/12/22 06:17:42 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Split;
import net.smartworks.server.engine.process.xpdl.xpdl2.TransitionRefs;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.SplitImpl#getTransitionRefs <em>Transition Refs</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.SplitImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.SplitImpl#getType_ <em>Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.SplitImpl#getOutgoingCondition <em>Outgoing Condition</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.SplitImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SplitImpl extends DataObjectBase implements Split
{

  public final static int TRANSITION_REFS = 0;

  public final static int ANY = -1;

  public final static int TYPE = 1;

  public final static int OUTGOING_CONDITION = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Transition Refs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITION_REFS = 0;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 1;

  /**
   * The internal feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE = 2;

  /**
   * The internal feature id for the '<em><b>Outgoing Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OUTGOING_CONDITION = 3;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 4;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 5;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_TRANSITION_REFS: return TRANSITION_REFS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_TYPE: return TYPE;
      case INTERNAL_OUTGOING_CONDITION: return OUTGOING_CONDITION;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
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
   * The default value of the '{@link #getOutgoingCondition() <em>Outgoing Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingCondition()
   * @generated
   * @ordered
   */
  protected static final String OUTGOING_CONDITION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getOutgoingCondition() <em>Outgoing Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingCondition()
   * @generated
   * @ordered
   */
  protected String outgoingCondition = OUTGOING_CONDITION_DEFAULT_;

  /**
   * This is true if the Outgoing Condition attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean outgoingCondition_set_ = false;

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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getSplit();
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
  public String getOutgoingCondition()
  {
    return outgoingCondition;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutgoingCondition(String newOutgoingCondition)
  {
    String oldOutgoingCondition = outgoingCondition;
    outgoingCondition = newOutgoingCondition;
    boolean oldOutgoingCondition_set_ = outgoingCondition_set_;
    outgoingCondition_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_OUTGOING_CONDITION, oldOutgoingCondition, outgoingCondition, !oldOutgoingCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOutgoingCondition()
  {
    String oldOutgoingCondition = outgoingCondition;
    boolean oldOutgoingCondition_set_ = outgoingCondition_set_;
    outgoingCondition = OUTGOING_CONDITION_DEFAULT_;
    outgoingCondition_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_OUTGOING_CONDITION, oldOutgoingCondition, OUTGOING_CONDITION_DEFAULT_, oldOutgoingCondition_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOutgoingCondition()
  {
    return outgoingCondition_set_;
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
      case TRANSITION_REFS:
        return basicUnsetTransitionRefs(changeContext);
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
      case TRANSITION_REFS:
        return getTransitionRefs();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case TYPE:
        return getType_();
      case OUTGOING_CONDITION:
        return getOutgoingCondition();
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
      case TRANSITION_REFS:
        setTransitionRefs((TransitionRefs)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case TYPE:
        setType((String)newValue);
        return;
      case OUTGOING_CONDITION:
        setOutgoingCondition((String)newValue);
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
      case TRANSITION_REFS:
        unsetTransitionRefs();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case TYPE:
        unsetType();
        return;
      case OUTGOING_CONDITION:
        unsetOutgoingCondition();
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
      case TRANSITION_REFS:
        return isSetTransitionRefs();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case TYPE:
        return isSetType();
      case OUTGOING_CONDITION:
        return isSetOutgoingCondition();
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
    result.append(", OutgoingCondition: ");
    if (outgoingCondition_set_) result.append(outgoingCondition); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //SplitImpl
