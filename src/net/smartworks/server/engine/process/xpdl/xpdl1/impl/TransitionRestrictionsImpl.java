/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransitionRestrictionsImpl.java,v 1.1 2009/12/22 06:17:23 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestriction;
import net.smartworks.server.engine.process.xpdl.xpdl1.TransitionRestrictions;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Restrictions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.TransitionRestrictionsImpl#getTransitionRestriction <em>Transition Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionRestrictionsImpl extends DataObjectBase implements TransitionRestrictions
{

  public final static int TRANSITION_RESTRICTION = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Transition Restriction</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITION_RESTRICTION = 0;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 1;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_TRANSITION_RESTRICTION: return TRANSITION_RESTRICTION;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getTransitionRestriction() <em>Transition Restriction</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionRestriction()
   * @generated
   * @ordered
   */
  
  protected List transitionRestriction = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRestrictionsImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getTransitionRestrictions();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getTransitionRestriction()
  {
    if (transitionRestriction == null)
    {
      transitionRestriction = createPropertyList(ListKind.CONTAINMENT, TransitionRestriction.class, TRANSITION_RESTRICTION, 0);
    }
    return transitionRestriction;
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
      case TRANSITION_RESTRICTION:
        return removeFromList(getTransitionRestriction(), otherEnd, changeContext);
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
      case TRANSITION_RESTRICTION:
        return getTransitionRestriction();
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
      case TRANSITION_RESTRICTION:
        getTransitionRestriction().clear();
        getTransitionRestriction().addAll((Collection)newValue);
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
      case TRANSITION_RESTRICTION:
        getTransitionRestriction().clear();
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
      case TRANSITION_RESTRICTION:
        return transitionRestriction != null && !transitionRestriction.isEmpty();
    }
    return super.isSet(propertyIndex);
  }

} //TransitionRestrictionsImpl
