/**
 * <copyright>
 * </copyright>
 *
 * $Id: BlockActivityImpl.java,v 1.1 2009/12/22 06:17:22 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.BlockActivity;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.BlockActivityImpl#getBlockId <em>Block Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockActivityImpl extends DataObjectBase implements BlockActivity
{

  public final static int BLOCK_ID = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Block Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BLOCK_ID = 0;

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
      case INTERNAL_BLOCK_ID: return BLOCK_ID;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getBlockId() <em>Block Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockId()
   * @generated
   * @ordered
   */
  protected static final String BLOCK_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getBlockId() <em>Block Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockId()
   * @generated
   * @ordered
   */
  protected String blockId = BLOCK_ID_DEFAULT_;

  /**
   * This is true if the Block Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean blockId_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockActivityImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getBlockActivity();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBlockId()
  {
    return blockId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlockId(String newBlockId)
  {
    String oldBlockId = blockId;
    blockId = newBlockId;
    boolean oldBlockId_set_ = blockId_set_;
    blockId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_BLOCK_ID, oldBlockId, blockId, !oldBlockId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBlockId()
  {
    String oldBlockId = blockId;
    boolean oldBlockId_set_ = blockId_set_;
    blockId = BLOCK_ID_DEFAULT_;
    blockId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_BLOCK_ID, oldBlockId, BLOCK_ID_DEFAULT_, oldBlockId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBlockId()
  {
    return blockId_set_;
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
      case BLOCK_ID:
        return getBlockId();
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
      case BLOCK_ID:
        setBlockId((String)newValue);
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
      case BLOCK_ID:
        unsetBlockId();
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
      case BLOCK_ID:
        return isSetBlockId();
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
    result.append(" (BlockId: ");
    if (blockId_set_) result.append(blockId); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //BlockActivityImpl
