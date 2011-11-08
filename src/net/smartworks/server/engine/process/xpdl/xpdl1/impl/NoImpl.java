/**
 * <copyright>
 * </copyright>
 *
 * $Id: NoImpl.java,v 1.1 2009/12/22 06:17:21 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.No;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>No</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NoImpl extends DataObjectBase implements No
{

  public final static int SDO_PROPERTY_COUNT = 0;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 0;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getNo();
  }

} //NoImpl
