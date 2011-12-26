/**
 * <copyright>
 * </copyright>
 *
 * $Id: FormalParametersImpl.java,v 1.1 2009/12/22 06:17:48 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import java.util.Collection;
import java.util.List;

import net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameter;
import net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameters;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Parameters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.FormalParametersImpl#getFormalParameter <em>Formal Parameter</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.FormalParametersImpl#getFormalParameter1 <em>Formal Parameter1</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.FormalParametersImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.FormalParametersImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.FormalParametersImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalParametersImpl extends DataObjectBase implements FormalParameters
{

  public final static int FORMAL_PARAMETER = 0;

  public final static int FORMAL_PARAMETER1 = 1;

  public final static int EXTENSIONS = 2;

  public final static int ANY = -1;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Formal Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FORMAL_PARAMETER = 0;

  /**
   * The internal feature id for the '<em><b>Formal Parameter1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FORMAL_PARAMETER1 = 1;

  /**
   * The internal feature id for the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENSIONS = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

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
      case INTERNAL_FORMAL_PARAMETER: return FORMAL_PARAMETER;
      case INTERNAL_FORMAL_PARAMETER1: return FORMAL_PARAMETER1;
      case INTERNAL_EXTENSIONS: return EXTENSIONS;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getFormalParameter() <em>Formal Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameter()
   * @generated
   * @ordered
   */
  
  protected List formalParameter = null;
  
  /**
   * The cached value of the '{@link #getFormalParameter1() <em>Formal Parameter1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameter1()
   * @generated
   * @ordered
   */
  
  protected List formalParameter1 = null;
  
  /**
   * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensions()
   * @generated
   * @ordered
   */
  
  protected DataObject extensions = null;
  
  /**
   * This is true if the Extensions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extensions_set_ = false;

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
  public FormalParametersImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getFormalParameters();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getFormalParameter()
  {
    if (formalParameter == null)
    {
      formalParameter = createPropertyList(ListKind.CONTAINMENT, FormalParameter.class, FORMAL_PARAMETER, 0);
    }
    return formalParameter;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getFormalParameter1()
  {
    if (formalParameter1 == null)
    {
      formalParameter1 = createPropertyList(ListKind.CONTAINMENT, net.smartworks.server.engine.process.xpdl.xpdl2.FormalParameter.class, FORMAL_PARAMETER1, 0);
    }
    return formalParameter1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject getExtensions()
  {
    return extensions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExtensions(DataObject newExtensions, ChangeContext changeContext)
  {
    DataObject oldExtensions = extensions;
    extensions = newExtensions;
    boolean oldExtensions_set_ = extensions_set_;
    extensions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTENSIONS, oldExtensions, newExtensions, !oldExtensions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtensions(DataObject newExtensions)
  {
    if (newExtensions != extensions)
    {
      ChangeContext changeContext = null;
      if (extensions != null)
        changeContext = inverseRemove(extensions, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENSIONS, null, changeContext);
      if (newExtensions != null)
        changeContext = inverseAdd(newExtensions, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENSIONS, null, changeContext);
      changeContext = basicSetExtensions(newExtensions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExtensions_set_ = extensions_set_;
      extensions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTENSIONS, newExtensions, newExtensions, !oldExtensions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExtensions(ChangeContext changeContext)
  {
    DataObject oldExtensions = extensions;
    extensions = null;
    boolean oldExtensions_set_ = extensions_set_;
    extensions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTENSIONS, oldExtensions, null, !oldExtensions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtensions()
  {
    if (extensions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(extensions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTENSIONS, null, changeContext);
      changeContext = basicUnsetExtensions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExtensions_set_ = extensions_set_;
      extensions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTENSIONS, null, null, oldExtensions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtensions()
  {
    return extensions_set_;
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
      case FORMAL_PARAMETER:
        return removeFromList(getFormalParameter(), otherEnd, changeContext);
      case FORMAL_PARAMETER1:
        return removeFromList(getFormalParameter1(), otherEnd, changeContext);
      case EXTENSIONS:
        return basicUnsetExtensions(changeContext);
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
      case FORMAL_PARAMETER:
        return getFormalParameter();
      case FORMAL_PARAMETER1:
        return getFormalParameter1();
      case EXTENSIONS:
        return getExtensions();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
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
      case FORMAL_PARAMETER:
        getFormalParameter().clear();
        getFormalParameter().addAll((Collection)newValue);
        return;
      case FORMAL_PARAMETER1:
        getFormalParameter1().clear();
        getFormalParameter1().addAll((Collection)newValue);
        return;
      case EXTENSIONS:
        setExtensions((DataObject)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
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
      case FORMAL_PARAMETER:
        getFormalParameter().clear();
        return;
      case FORMAL_PARAMETER1:
        getFormalParameter1().clear();
        return;
      case EXTENSIONS:
        unsetExtensions();
        return;
      case ANY:
        unsetSequence(getAny());
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
      case FORMAL_PARAMETER:
        return formalParameter != null && !formalParameter.isEmpty();
      case FORMAL_PARAMETER1:
        return formalParameter1 != null && !formalParameter1.isEmpty();
      case EXTENSIONS:
        return isSetExtensions();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
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
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //FormalParametersImpl
