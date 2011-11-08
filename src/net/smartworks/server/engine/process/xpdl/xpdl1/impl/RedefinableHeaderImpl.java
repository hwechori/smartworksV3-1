/**
 * <copyright>
 * </copyright>
 *
 * $Id: RedefinableHeaderImpl.java,v 1.1 2009/12/22 06:17:12 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.RedefinableHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.Responsibles;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Redefinable Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.RedefinableHeaderImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.RedefinableHeaderImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.RedefinableHeaderImpl#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.RedefinableHeaderImpl#getCountrykey <em>Countrykey</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.RedefinableHeaderImpl#getResponsibles <em>Responsibles</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.RedefinableHeaderImpl#getPublicationStatus <em>Publication Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RedefinableHeaderImpl extends DataObjectBase implements RedefinableHeader
{

  public final static int AUTHOR = 0;

  public final static int VERSION = 1;

  public final static int CODEPAGE = 2;

  public final static int COUNTRYKEY = 3;

  public final static int RESPONSIBLES = 4;

  public final static int PUBLICATION_STATUS = 5;

  public final static int SDO_PROPERTY_COUNT = 6;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Author</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AUTHOR = 0;

  /**
   * The internal feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VERSION = 1;

  /**
   * The internal feature id for the '<em><b>Codepage</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CODEPAGE = 2;

  /**
   * The internal feature id for the '<em><b>Countrykey</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COUNTRYKEY = 3;

  /**
   * The internal feature id for the '<em><b>Responsibles</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_RESPONSIBLES = 4;

  /**
   * The internal feature id for the '<em><b>Publication Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PUBLICATION_STATUS = 5;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 6;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_AUTHOR: return AUTHOR;
      case INTERNAL_VERSION: return VERSION;
      case INTERNAL_CODEPAGE: return CODEPAGE;
      case INTERNAL_COUNTRYKEY: return COUNTRYKEY;
      case INTERNAL_RESPONSIBLES: return RESPONSIBLES;
      case INTERNAL_PUBLICATION_STATUS: return PUBLICATION_STATUS;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthor()
   * @generated
   * @ordered
   */
  protected static final String AUTHOR_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthor()
   * @generated
   * @ordered
   */
  protected String author = AUTHOR_DEFAULT_;

  /**
   * This is true if the Author attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean author_set_ = false;

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
   * The default value of the '{@link #getCodepage() <em>Codepage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodepage()
   * @generated
   * @ordered
   */
  protected static final String CODEPAGE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCodepage() <em>Codepage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodepage()
   * @generated
   * @ordered
   */
  protected String codepage = CODEPAGE_DEFAULT_;

  /**
   * This is true if the Codepage attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean codepage_set_ = false;

  /**
   * The default value of the '{@link #getCountrykey() <em>Countrykey</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCountrykey()
   * @generated
   * @ordered
   */
  protected static final String COUNTRYKEY_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCountrykey() <em>Countrykey</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCountrykey()
   * @generated
   * @ordered
   */
  protected String countrykey = COUNTRYKEY_DEFAULT_;

  /**
   * This is true if the Countrykey attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean countrykey_set_ = false;

  /**
   * The cached value of the '{@link #getResponsibles() <em>Responsibles</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponsibles()
   * @generated
   * @ordered
   */
  
  protected Responsibles responsibles = null;
  
  /**
   * This is true if the Responsibles containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean responsibles_set_ = false;

  /**
   * The default value of the '{@link #getPublicationStatus() <em>Publication Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPublicationStatus()
   * @generated
   * @ordered
   */
  protected static final String PUBLICATION_STATUS_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPublicationStatus() <em>Publication Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPublicationStatus()
   * @generated
   * @ordered
   */
  protected String publicationStatus = PUBLICATION_STATUS_DEFAULT_;

  /**
   * This is true if the Publication Status attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean publicationStatus_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinableHeaderImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getRedefinableHeader();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAuthor()
  {
    return author;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAuthor(String newAuthor)
  {
    String oldAuthor = author;
    author = newAuthor;
    boolean oldAuthor_set_ = author_set_;
    author_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_AUTHOR, oldAuthor, author, !oldAuthor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAuthor()
  {
    String oldAuthor = author;
    boolean oldAuthor_set_ = author_set_;
    author = AUTHOR_DEFAULT_;
    author_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_AUTHOR, oldAuthor, AUTHOR_DEFAULT_, oldAuthor_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAuthor()
  {
    return author_set_;
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
  public String getCodepage()
  {
    return codepage;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodepage(String newCodepage)
  {
    String oldCodepage = codepage;
    codepage = newCodepage;
    boolean oldCodepage_set_ = codepage_set_;
    codepage_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_CODEPAGE, oldCodepage, codepage, !oldCodepage_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCodepage()
  {
    String oldCodepage = codepage;
    boolean oldCodepage_set_ = codepage_set_;
    codepage = CODEPAGE_DEFAULT_;
    codepage_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_CODEPAGE, oldCodepage, CODEPAGE_DEFAULT_, oldCodepage_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCodepage()
  {
    return codepage_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCountrykey()
  {
    return countrykey;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCountrykey(String newCountrykey)
  {
    String oldCountrykey = countrykey;
    countrykey = newCountrykey;
    boolean oldCountrykey_set_ = countrykey_set_;
    countrykey_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_COUNTRYKEY, oldCountrykey, countrykey, !oldCountrykey_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCountrykey()
  {
    String oldCountrykey = countrykey;
    boolean oldCountrykey_set_ = countrykey_set_;
    countrykey = COUNTRYKEY_DEFAULT_;
    countrykey_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_COUNTRYKEY, oldCountrykey, COUNTRYKEY_DEFAULT_, oldCountrykey_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCountrykey()
  {
    return countrykey_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Responsibles getResponsibles()
  {
    return responsibles;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetResponsibles(Responsibles newResponsibles, ChangeContext changeContext)
  {
    Responsibles oldResponsibles = responsibles;
    responsibles = newResponsibles;
    boolean oldResponsibles_set_ = responsibles_set_;
    responsibles_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_RESPONSIBLES, oldResponsibles, newResponsibles, !oldResponsibles_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResponsibles(Responsibles newResponsibles)
  {
    if (newResponsibles != responsibles)
    {
      ChangeContext changeContext = null;
      if (responsibles != null)
        changeContext = inverseRemove(responsibles, this, OPPOSITE_FEATURE_BASE - INTERNAL_RESPONSIBLES, null, changeContext);
      if (newResponsibles != null)
        changeContext = inverseAdd(newResponsibles, this, OPPOSITE_FEATURE_BASE - INTERNAL_RESPONSIBLES, null, changeContext);
      changeContext = basicSetResponsibles(newResponsibles, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldResponsibles_set_ = responsibles_set_;
      responsibles_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_RESPONSIBLES, newResponsibles, newResponsibles, !oldResponsibles_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetResponsibles(ChangeContext changeContext)
  {
    Responsibles oldResponsibles = responsibles;
    responsibles = null;
    boolean oldResponsibles_set_ = responsibles_set_;
    responsibles_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_RESPONSIBLES, oldResponsibles, null, !oldResponsibles_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetResponsibles()
  {
    if (responsibles != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(responsibles, this, EOPPOSITE_FEATURE_BASE - INTERNAL_RESPONSIBLES, null, changeContext);
      changeContext = basicUnsetResponsibles(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldResponsibles_set_ = responsibles_set_;
      responsibles_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_RESPONSIBLES, null, null, oldResponsibles_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetResponsibles()
  {
    return responsibles_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPublicationStatus()
  {
    return publicationStatus;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPublicationStatus(String newPublicationStatus)
  {
    String oldPublicationStatus = publicationStatus;
    publicationStatus = newPublicationStatus;
    boolean oldPublicationStatus_set_ = publicationStatus_set_;
    publicationStatus_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_PUBLICATION_STATUS, oldPublicationStatus, publicationStatus, !oldPublicationStatus_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPublicationStatus()
  {
    String oldPublicationStatus = publicationStatus;
    boolean oldPublicationStatus_set_ = publicationStatus_set_;
    publicationStatus = PUBLICATION_STATUS_DEFAULT_;
    publicationStatus_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_PUBLICATION_STATUS, oldPublicationStatus, PUBLICATION_STATUS_DEFAULT_, oldPublicationStatus_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPublicationStatus()
  {
    return publicationStatus_set_;
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
      case RESPONSIBLES:
        return basicUnsetResponsibles(changeContext);
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
      case AUTHOR:
        return getAuthor();
      case VERSION:
        return getVersion();
      case CODEPAGE:
        return getCodepage();
      case COUNTRYKEY:
        return getCountrykey();
      case RESPONSIBLES:
        return getResponsibles();
      case PUBLICATION_STATUS:
        return getPublicationStatus();
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
      case AUTHOR:
        setAuthor((String)newValue);
        return;
      case VERSION:
        setVersion((String)newValue);
        return;
      case CODEPAGE:
        setCodepage((String)newValue);
        return;
      case COUNTRYKEY:
        setCountrykey((String)newValue);
        return;
      case RESPONSIBLES:
        setResponsibles((Responsibles)newValue);
        return;
      case PUBLICATION_STATUS:
        setPublicationStatus((String)newValue);
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
      case AUTHOR:
        unsetAuthor();
        return;
      case VERSION:
        unsetVersion();
        return;
      case CODEPAGE:
        unsetCodepage();
        return;
      case COUNTRYKEY:
        unsetCountrykey();
        return;
      case RESPONSIBLES:
        unsetResponsibles();
        return;
      case PUBLICATION_STATUS:
        unsetPublicationStatus();
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
      case AUTHOR:
        return isSetAuthor();
      case VERSION:
        return isSetVersion();
      case CODEPAGE:
        return isSetCodepage();
      case COUNTRYKEY:
        return isSetCountrykey();
      case RESPONSIBLES:
        return isSetResponsibles();
      case PUBLICATION_STATUS:
        return isSetPublicationStatus();
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
    result.append(" (Author: ");
    if (author_set_) result.append(author); else result.append("<unset>");
    result.append(", Version: ");
    if (version_set_) result.append(version); else result.append("<unset>");
    result.append(", Codepage: ");
    if (codepage_set_) result.append(codepage); else result.append("<unset>");
    result.append(", Countrykey: ");
    if (countrykey_set_) result.append(countrykey); else result.append("<unset>");
    result.append(", PublicationStatus: ");
    if (publicationStatus_set_) result.append(publicationStatus); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //RedefinableHeaderImpl
