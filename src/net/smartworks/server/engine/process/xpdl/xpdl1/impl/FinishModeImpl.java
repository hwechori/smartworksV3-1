/**
 * <copyright>
 * </copyright>
 *
 * $Id: FinishModeImpl.java,v 1.1 2009/12/22 06:17:16 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Automatic;
import net.smartworks.server.engine.process.xpdl.xpdl1.FinishMode;
import net.smartworks.server.engine.process.xpdl.xpdl1.Manual;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Finish Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.FinishModeImpl#getAutomatic <em>Automatic</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.FinishModeImpl#getManual <em>Manual</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FinishModeImpl extends DataObjectBase implements FinishMode
{

  public final static int AUTOMATIC = 0;

  public final static int MANUAL = 1;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Automatic</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AUTOMATIC = 0;

  /**
   * The internal feature id for the '<em><b>Manual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MANUAL = 1;

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
      case INTERNAL_AUTOMATIC: return AUTOMATIC;
      case INTERNAL_MANUAL: return MANUAL;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getAutomatic() <em>Automatic</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAutomatic()
   * @generated
   * @ordered
   */
  
  protected Automatic automatic = null;
  
  /**
   * This is true if the Automatic containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean automatic_set_ = false;

  /**
   * The cached value of the '{@link #getManual() <em>Manual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getManual()
   * @generated
   * @ordered
   */
  
  protected Manual manual = null;
  
  /**
   * This is true if the Manual containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean manual_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinishModeImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getFinishMode();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Automatic getAutomatic()
  {
    return automatic;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetAutomatic(Automatic newAutomatic, ChangeContext changeContext)
  {
    Automatic oldAutomatic = automatic;
    automatic = newAutomatic;
    boolean oldAutomatic_set_ = automatic_set_;
    automatic_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_AUTOMATIC, oldAutomatic, newAutomatic, !oldAutomatic_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAutomatic(Automatic newAutomatic)
  {
    if (newAutomatic != automatic)
    {
      ChangeContext changeContext = null;
      if (automatic != null)
        changeContext = inverseRemove(automatic, this, OPPOSITE_FEATURE_BASE - INTERNAL_AUTOMATIC, null, changeContext);
      if (newAutomatic != null)
        changeContext = inverseAdd(newAutomatic, this, OPPOSITE_FEATURE_BASE - INTERNAL_AUTOMATIC, null, changeContext);
      changeContext = basicSetAutomatic(newAutomatic, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldAutomatic_set_ = automatic_set_;
      automatic_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_AUTOMATIC, newAutomatic, newAutomatic, !oldAutomatic_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetAutomatic(ChangeContext changeContext)
  {
    Automatic oldAutomatic = automatic;
    automatic = null;
    boolean oldAutomatic_set_ = automatic_set_;
    automatic_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_AUTOMATIC, oldAutomatic, null, !oldAutomatic_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAutomatic()
  {
    if (automatic != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(automatic, this, EOPPOSITE_FEATURE_BASE - INTERNAL_AUTOMATIC, null, changeContext);
      changeContext = basicUnsetAutomatic(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldAutomatic_set_ = automatic_set_;
      automatic_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_AUTOMATIC, null, null, oldAutomatic_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAutomatic()
  {
    return automatic_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Manual getManual()
  {
    return manual;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetManual(Manual newManual, ChangeContext changeContext)
  {
    Manual oldManual = manual;
    manual = newManual;
    boolean oldManual_set_ = manual_set_;
    manual_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_MANUAL, oldManual, newManual, !oldManual_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setManual(Manual newManual)
  {
    if (newManual != manual)
    {
      ChangeContext changeContext = null;
      if (manual != null)
        changeContext = inverseRemove(manual, this, OPPOSITE_FEATURE_BASE - INTERNAL_MANUAL, null, changeContext);
      if (newManual != null)
        changeContext = inverseAdd(newManual, this, OPPOSITE_FEATURE_BASE - INTERNAL_MANUAL, null, changeContext);
      changeContext = basicSetManual(newManual, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldManual_set_ = manual_set_;
      manual_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_MANUAL, newManual, newManual, !oldManual_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetManual(ChangeContext changeContext)
  {
    Manual oldManual = manual;
    manual = null;
    boolean oldManual_set_ = manual_set_;
    manual_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_MANUAL, oldManual, null, !oldManual_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetManual()
  {
    if (manual != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(manual, this, EOPPOSITE_FEATURE_BASE - INTERNAL_MANUAL, null, changeContext);
      changeContext = basicUnsetManual(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldManual_set_ = manual_set_;
      manual_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_MANUAL, null, null, oldManual_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetManual()
  {
    return manual_set_;
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
      case AUTOMATIC:
        return basicUnsetAutomatic(changeContext);
      case MANUAL:
        return basicUnsetManual(changeContext);
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
      case AUTOMATIC:
        return getAutomatic();
      case MANUAL:
        return getManual();
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
      case AUTOMATIC:
        setAutomatic((Automatic)newValue);
        return;
      case MANUAL:
        setManual((Manual)newValue);
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
      case AUTOMATIC:
        unsetAutomatic();
        return;
      case MANUAL:
        unsetManual();
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
      case AUTOMATIC:
        return isSetAutomatic();
      case MANUAL:
        return isSetManual();
    }
    return super.isSet(propertyIndex);
  }

} //FinishModeImpl
