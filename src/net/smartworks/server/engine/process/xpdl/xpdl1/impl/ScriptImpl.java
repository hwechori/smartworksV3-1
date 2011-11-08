/**
 * <copyright>
 * </copyright>
 *
 * $Id: ScriptImpl.java,v 1.1 2009/12/22 06:17:20 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Script;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ScriptImpl#getType_ <em>Type</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ScriptImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ScriptImpl#getGrammar <em>Grammar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptImpl extends DataObjectBase implements Script
{

  public final static int TYPE = 0;

  public final static int VERSION = 1;

  public final static int GRAMMAR = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE = 0;

  /**
   * The internal feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VERSION = 1;

  /**
   * The internal feature id for the '<em><b>Grammar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GRAMMAR = 2;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 3;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_TYPE: return TYPE;
      case INTERNAL_VERSION: return VERSION;
      case INTERNAL_GRAMMAR: return GRAMMAR;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final String VERSION_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected String version = VERSION_DEFAULT_;

  /**
   * This is true if the Version attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean version_set_ = false;

  /**
   * The default value of the '{@link #getGrammar() <em>Grammar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrammar()
   * @generated
   * @ordered
   */
  protected static final String GRAMMAR_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getGrammar() <em>Grammar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrammar()
   * @generated
   * @ordered
   */
  protected String grammar = GRAMMAR_DEFAULT_;

  /**
   * This is true if the Grammar attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean grammar_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getScript();
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
  public String getVersion()
  {
    return version;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion)
  {
    String oldVersion = version;
    version = newVersion;
    boolean oldVersion_set_ = version_set_;
    version_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_VERSION, oldVersion, version, !oldVersion_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVersion()
  {
    String oldVersion = version;
    boolean oldVersion_set_ = version_set_;
    version = VERSION_DEFAULT_;
    version_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_VERSION, oldVersion, VERSION_DEFAULT_, oldVersion_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetVersion()
  {
    return version_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGrammar()
  {
    return grammar;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGrammar(String newGrammar)
  {
    String oldGrammar = grammar;
    grammar = newGrammar;
    boolean oldGrammar_set_ = grammar_set_;
    grammar_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_GRAMMAR, oldGrammar, grammar, !oldGrammar_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetGrammar()
  {
    String oldGrammar = grammar;
    boolean oldGrammar_set_ = grammar_set_;
    grammar = GRAMMAR_DEFAULT_;
    grammar_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_GRAMMAR, oldGrammar, GRAMMAR_DEFAULT_, oldGrammar_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetGrammar()
  {
    return grammar_set_;
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
      case TYPE:
        return getType_();
      case VERSION:
        return getVersion();
      case GRAMMAR:
        return getGrammar();
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
      case TYPE:
        setType((String)newValue);
        return;
      case VERSION:
        setVersion((String)newValue);
        return;
      case GRAMMAR:
        setGrammar((String)newValue);
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
      case TYPE:
        unsetType();
        return;
      case VERSION:
        unsetVersion();
        return;
      case GRAMMAR:
        unsetGrammar();
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
      case TYPE:
        return isSetType();
      case VERSION:
        return isSetVersion();
      case GRAMMAR:
        return isSetGrammar();
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
    result.append(", Version: ");
    if (version_set_) result.append(version); else result.append("<unset>");
    result.append(", Grammar: ");
    if (grammar_set_) result.append(grammar); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ScriptImpl
