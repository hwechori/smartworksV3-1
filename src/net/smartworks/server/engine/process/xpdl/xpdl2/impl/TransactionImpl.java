/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransactionImpl.java,v 1.1 2009/12/22 06:17:53 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Transaction;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TransactionImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TransactionImpl#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TransactionImpl#getTransactionProtocol <em>Transaction Protocol</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TransactionImpl#getTransactionMethod <em>Transaction Method</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.TransactionImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransactionImpl extends DataObjectBase implements Transaction
{

  public final static int ANY = -1;

  public final static int TRANSACTION_ID = 0;

  public final static int TRANSACTION_PROTOCOL = 1;

  public final static int TRANSACTION_METHOD = 2;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

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
   * The internal feature id for the '<em><b>Transaction Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSACTION_ID = 1;

  /**
   * The internal feature id for the '<em><b>Transaction Protocol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSACTION_PROTOCOL = 2;

  /**
   * The internal feature id for the '<em><b>Transaction Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSACTION_METHOD = 3;

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
      case INTERNAL_ANY: return ANY;
      case INTERNAL_TRANSACTION_ID: return TRANSACTION_ID;
      case INTERNAL_TRANSACTION_PROTOCOL: return TRANSACTION_PROTOCOL;
      case INTERNAL_TRANSACTION_METHOD: return TRANSACTION_METHOD;
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
   * The default value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransactionId()
   * @generated
   * @ordered
   */
  protected static final String TRANSACTION_ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransactionId()
   * @generated
   * @ordered
   */
  protected String transactionId = TRANSACTION_ID_DEFAULT_;

  /**
   * This is true if the Transaction Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transactionId_set_ = false;

  /**
   * The default value of the '{@link #getTransactionProtocol() <em>Transaction Protocol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransactionProtocol()
   * @generated
   * @ordered
   */
  protected static final String TRANSACTION_PROTOCOL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTransactionProtocol() <em>Transaction Protocol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransactionProtocol()
   * @generated
   * @ordered
   */
  protected String transactionProtocol = TRANSACTION_PROTOCOL_DEFAULT_;

  /**
   * This is true if the Transaction Protocol attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transactionProtocol_set_ = false;

  /**
   * The default value of the '{@link #getTransactionMethod() <em>Transaction Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransactionMethod()
   * @generated
   * @ordered
   */
  protected static final String TRANSACTION_METHOD_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTransactionMethod() <em>Transaction Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransactionMethod()
   * @generated
   * @ordered
   */
  protected String transactionMethod = TRANSACTION_METHOD_DEFAULT_;

  /**
   * This is true if the Transaction Method attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transactionMethod_set_ = false;

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
  public TransactionImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getTransaction();
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
  public String getTransactionId()
  {
    return transactionId;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransactionId(String newTransactionId)
  {
    String oldTransactionId = transactionId;
    transactionId = newTransactionId;
    boolean oldTransactionId_set_ = transactionId_set_;
    transactionId_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TRANSACTION_ID, oldTransactionId, transactionId, !oldTransactionId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransactionId()
  {
    String oldTransactionId = transactionId;
    boolean oldTransactionId_set_ = transactionId_set_;
    transactionId = TRANSACTION_ID_DEFAULT_;
    transactionId_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TRANSACTION_ID, oldTransactionId, TRANSACTION_ID_DEFAULT_, oldTransactionId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransactionId()
  {
    return transactionId_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTransactionProtocol()
  {
    return transactionProtocol;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransactionProtocol(String newTransactionProtocol)
  {
    String oldTransactionProtocol = transactionProtocol;
    transactionProtocol = newTransactionProtocol;
    boolean oldTransactionProtocol_set_ = transactionProtocol_set_;
    transactionProtocol_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TRANSACTION_PROTOCOL, oldTransactionProtocol, transactionProtocol, !oldTransactionProtocol_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransactionProtocol()
  {
    String oldTransactionProtocol = transactionProtocol;
    boolean oldTransactionProtocol_set_ = transactionProtocol_set_;
    transactionProtocol = TRANSACTION_PROTOCOL_DEFAULT_;
    transactionProtocol_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TRANSACTION_PROTOCOL, oldTransactionProtocol, TRANSACTION_PROTOCOL_DEFAULT_, oldTransactionProtocol_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransactionProtocol()
  {
    return transactionProtocol_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTransactionMethod()
  {
    return transactionMethod;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransactionMethod(String newTransactionMethod)
  {
    String oldTransactionMethod = transactionMethod;
    transactionMethod = newTransactionMethod;
    boolean oldTransactionMethod_set_ = transactionMethod_set_;
    transactionMethod_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TRANSACTION_METHOD, oldTransactionMethod, transactionMethod, !oldTransactionMethod_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransactionMethod()
  {
    String oldTransactionMethod = transactionMethod;
    boolean oldTransactionMethod_set_ = transactionMethod_set_;
    transactionMethod = TRANSACTION_METHOD_DEFAULT_;
    transactionMethod_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TRANSACTION_METHOD, oldTransactionMethod, TRANSACTION_METHOD_DEFAULT_, oldTransactionMethod_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransactionMethod()
  {
    return transactionMethod_set_;
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
      case TRANSACTION_ID:
        return getTransactionId();
      case TRANSACTION_PROTOCOL:
        return getTransactionProtocol();
      case TRANSACTION_METHOD:
        return getTransactionMethod();
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
      case TRANSACTION_ID:
        setTransactionId((String)newValue);
        return;
      case TRANSACTION_PROTOCOL:
        setTransactionProtocol((String)newValue);
        return;
      case TRANSACTION_METHOD:
        setTransactionMethod((String)newValue);
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
      case TRANSACTION_ID:
        unsetTransactionId();
        return;
      case TRANSACTION_PROTOCOL:
        unsetTransactionProtocol();
        return;
      case TRANSACTION_METHOD:
        unsetTransactionMethod();
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
      case TRANSACTION_ID:
        return isSetTransactionId();
      case TRANSACTION_PROTOCOL:
        return isSetTransactionProtocol();
      case TRANSACTION_METHOD:
        return isSetTransactionMethod();
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
    result.append(", TransactionId: ");
    if (transactionId_set_) result.append(transactionId); else result.append("<unset>");
    result.append(", TransactionProtocol: ");
    if (transactionProtocol_set_) result.append(transactionProtocol); else result.append("<unset>");
    result.append(", TransactionMethod: ");
    if (transactionMethod_set_) result.append(transactionMethod); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //TransactionImpl
