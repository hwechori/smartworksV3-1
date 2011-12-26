/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActualParametersImpl.java,v 1.1 2009/12/22 06:17:13 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import java.util.Collection;
import java.util.List;

import net.smartworks.server.engine.process.xpdl.xpdl1.ActualParameters;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actual Parameters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ActualParametersImpl#getActualParameter <em>Actual Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActualParametersImpl extends DataObjectBase implements ActualParameters
{

  public final static int ACTUAL_PARAMETER = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Actual Parameter</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTUAL_PARAMETER = 0;

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
      case INTERNAL_ACTUAL_PARAMETER: return ACTUAL_PARAMETER;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getActualParameter() <em>Actual Parameter</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActualParameter()
   * @generated
   * @ordered
   */
  
  protected List actualParameter = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualParametersImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getActualParameters();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getActualParameter()
  {
    if (actualParameter == null)
    {
      actualParameter = createPropertyList(ListKind.DATATYPE, String.class, ACTUAL_PARAMETER, 0);
    }
    return actualParameter;
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
      case ACTUAL_PARAMETER:
        return getActualParameter();
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
      case ACTUAL_PARAMETER:
        getActualParameter().clear();
        getActualParameter().addAll((Collection)newValue);
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
      case ACTUAL_PARAMETER:
        getActualParameter().clear();
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
      case ACTUAL_PARAMETER:
        return actualParameter != null && !actualParameter.isEmpty();
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
    result.append(" (ActualParameter: ");
    result.append(actualParameter);
    result.append(')');
    return result.toString();
  }

} //ActualParametersImpl
