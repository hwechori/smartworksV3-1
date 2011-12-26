/**
 * <copyright>
 * </copyright>
 *
 * $Id: RedefinableHeaderImpl.java,v 1.1 2009/12/22 06:17:34 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.Author;
import net.smartworks.server.engine.process.xpdl.xpdl2.Codepage;
import net.smartworks.server.engine.process.xpdl.xpdl2.Countrykey;
import net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader;
import net.smartworks.server.engine.process.xpdl.xpdl2.Responsibles;
import net.smartworks.server.engine.process.xpdl.xpdl2.Version;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Redefinable Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getCountrykey <em>Countrykey</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getResponsibles <em>Responsibles</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getPublicationStatus <em>Publication Status</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.RedefinableHeaderImpl#getAnyAttribute <em>Any Attribute</em>}</li>
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

  public final static int ANY = -1;

  public final static int PUBLICATION_STATUS = 5;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 6;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Author</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_AUTHOR = 0;

  /**
   * The internal feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VERSION = 1;

  /**
   * The internal feature id for the '<em><b>Codepage</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CODEPAGE = 2;

  /**
   * The internal feature id for the '<em><b>Countrykey</b></em>' containment reference.
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
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 5;

  /**
   * The internal feature id for the '<em><b>Publication Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PUBLICATION_STATUS = 6;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 7;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 8;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_AUTHOR: return AUTHOR;
      case INTERNAL_VERSION: return VERSION;
      case INTERNAL_CODEPAGE: return CODEPAGE;
      case INTERNAL_COUNTRYKEY: return COUNTRYKEY;
      case INTERNAL_RESPONSIBLES: return RESPONSIBLES;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_PUBLICATION_STATUS: return PUBLICATION_STATUS;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getAuthor() <em>Author</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthor()
   * @generated
   * @ordered
   */
  
  protected Author author = null;
  
  /**
   * This is true if the Author containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean author_set_ = false;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  
  protected Version version = null;
  
  /**
   * This is true if the Version containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean version_set_ = false;

  /**
   * The cached value of the '{@link #getCodepage() <em>Codepage</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodepage()
   * @generated
   * @ordered
   */
  
  protected Codepage codepage = null;
  
  /**
   * This is true if the Codepage containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean codepage_set_ = false;

  /**
   * The cached value of the '{@link #getCountrykey() <em>Countrykey</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCountrykey()
   * @generated
   * @ordered
   */
  
  protected Countrykey countrykey = null;
  
  /**
   * This is true if the Countrykey containment reference has been set.
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
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  
  protected Sequence any = null;
  
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getRedefinableHeader();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Author getAuthor()
  {
    return author;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetAuthor(Author newAuthor, ChangeContext changeContext)
  {
    Author oldAuthor = author;
    author = newAuthor;
    boolean oldAuthor_set_ = author_set_;
    author_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_AUTHOR, oldAuthor, newAuthor, !oldAuthor_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAuthor(Author newAuthor)
  {
    if (newAuthor != author)
    {
      ChangeContext changeContext = null;
      if (author != null)
        changeContext = inverseRemove(author, this, OPPOSITE_FEATURE_BASE - INTERNAL_AUTHOR, null, changeContext);
      if (newAuthor != null)
        changeContext = inverseAdd(newAuthor, this, OPPOSITE_FEATURE_BASE - INTERNAL_AUTHOR, null, changeContext);
      changeContext = basicSetAuthor(newAuthor, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldAuthor_set_ = author_set_;
      author_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_AUTHOR, newAuthor, newAuthor, !oldAuthor_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetAuthor(ChangeContext changeContext)
  {
    Author oldAuthor = author;
    author = null;
    boolean oldAuthor_set_ = author_set_;
    author_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_AUTHOR, oldAuthor, null, !oldAuthor_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAuthor()
  {
    if (author != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(author, this, EOPPOSITE_FEATURE_BASE - INTERNAL_AUTHOR, null, changeContext);
      changeContext = basicUnsetAuthor(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldAuthor_set_ = author_set_;
      author_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_AUTHOR, null, null, oldAuthor_set_);
    	}
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
  public Version getVersion()
  {
    return version;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetVersion(Version newVersion, ChangeContext changeContext)
  {
    Version oldVersion = version;
    version = newVersion;
    boolean oldVersion_set_ = version_set_;
    version_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_VERSION, oldVersion, newVersion, !oldVersion_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(Version newVersion)
  {
    if (newVersion != version)
    {
      ChangeContext changeContext = null;
      if (version != null)
        changeContext = inverseRemove(version, this, OPPOSITE_FEATURE_BASE - INTERNAL_VERSION, null, changeContext);
      if (newVersion != null)
        changeContext = inverseAdd(newVersion, this, OPPOSITE_FEATURE_BASE - INTERNAL_VERSION, null, changeContext);
      changeContext = basicSetVersion(newVersion, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldVersion_set_ = version_set_;
      version_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_VERSION, newVersion, newVersion, !oldVersion_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetVersion(ChangeContext changeContext)
  {
    Version oldVersion = version;
    version = null;
    boolean oldVersion_set_ = version_set_;
    version_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_VERSION, oldVersion, null, !oldVersion_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVersion()
  {
    if (version != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(version, this, EOPPOSITE_FEATURE_BASE - INTERNAL_VERSION, null, changeContext);
      changeContext = basicUnsetVersion(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldVersion_set_ = version_set_;
      version_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_VERSION, null, null, oldVersion_set_);
    	}
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
  public Codepage getCodepage()
  {
    return codepage;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetCodepage(Codepage newCodepage, ChangeContext changeContext)
  {
    Codepage oldCodepage = codepage;
    codepage = newCodepage;
    boolean oldCodepage_set_ = codepage_set_;
    codepage_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_CODEPAGE, oldCodepage, newCodepage, !oldCodepage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodepage(Codepage newCodepage)
  {
    if (newCodepage != codepage)
    {
      ChangeContext changeContext = null;
      if (codepage != null)
        changeContext = inverseRemove(codepage, this, OPPOSITE_FEATURE_BASE - INTERNAL_CODEPAGE, null, changeContext);
      if (newCodepage != null)
        changeContext = inverseAdd(newCodepage, this, OPPOSITE_FEATURE_BASE - INTERNAL_CODEPAGE, null, changeContext);
      changeContext = basicSetCodepage(newCodepage, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldCodepage_set_ = codepage_set_;
      codepage_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_CODEPAGE, newCodepage, newCodepage, !oldCodepage_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetCodepage(ChangeContext changeContext)
  {
    Codepage oldCodepage = codepage;
    codepage = null;
    boolean oldCodepage_set_ = codepage_set_;
    codepage_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_CODEPAGE, oldCodepage, null, !oldCodepage_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCodepage()
  {
    if (codepage != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(codepage, this, EOPPOSITE_FEATURE_BASE - INTERNAL_CODEPAGE, null, changeContext);
      changeContext = basicUnsetCodepage(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldCodepage_set_ = codepage_set_;
      codepage_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_CODEPAGE, null, null, oldCodepage_set_);
    	}
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
  public Countrykey getCountrykey()
  {
    return countrykey;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetCountrykey(Countrykey newCountrykey, ChangeContext changeContext)
  {
    Countrykey oldCountrykey = countrykey;
    countrykey = newCountrykey;
    boolean oldCountrykey_set_ = countrykey_set_;
    countrykey_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_COUNTRYKEY, oldCountrykey, newCountrykey, !oldCountrykey_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCountrykey(Countrykey newCountrykey)
  {
    if (newCountrykey != countrykey)
    {
      ChangeContext changeContext = null;
      if (countrykey != null)
        changeContext = inverseRemove(countrykey, this, OPPOSITE_FEATURE_BASE - INTERNAL_COUNTRYKEY, null, changeContext);
      if (newCountrykey != null)
        changeContext = inverseAdd(newCountrykey, this, OPPOSITE_FEATURE_BASE - INTERNAL_COUNTRYKEY, null, changeContext);
      changeContext = basicSetCountrykey(newCountrykey, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldCountrykey_set_ = countrykey_set_;
      countrykey_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_COUNTRYKEY, newCountrykey, newCountrykey, !oldCountrykey_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetCountrykey(ChangeContext changeContext)
  {
    Countrykey oldCountrykey = countrykey;
    countrykey = null;
    boolean oldCountrykey_set_ = countrykey_set_;
    countrykey_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_COUNTRYKEY, oldCountrykey, null, !oldCountrykey_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCountrykey()
  {
    if (countrykey != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(countrykey, this, EOPPOSITE_FEATURE_BASE - INTERNAL_COUNTRYKEY, null, changeContext);
      changeContext = basicUnsetCountrykey(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldCountrykey_set_ = countrykey_set_;
      countrykey_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_COUNTRYKEY, null, null, oldCountrykey_set_);
    	}
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
      case AUTHOR:
        return basicUnsetAuthor(changeContext);
      case VERSION:
        return basicUnsetVersion(changeContext);
      case CODEPAGE:
        return basicUnsetCodepage(changeContext);
      case COUNTRYKEY:
        return basicUnsetCountrykey(changeContext);
      case RESPONSIBLES:
        return basicUnsetResponsibles(changeContext);
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
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case PUBLICATION_STATUS:
        return getPublicationStatus();
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
      case AUTHOR:
        setAuthor((Author)newValue);
        return;
      case VERSION:
        setVersion((Version)newValue);
        return;
      case CODEPAGE:
        setCodepage((Codepage)newValue);
        return;
      case COUNTRYKEY:
        setCountrykey((Countrykey)newValue);
        return;
      case RESPONSIBLES:
        setResponsibles((Responsibles)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case PUBLICATION_STATUS:
        setPublicationStatus((String)newValue);
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
      case ANY:
        unsetSequence(getAny());
        return;
      case PUBLICATION_STATUS:
        unsetPublicationStatus();
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
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case PUBLICATION_STATUS:
        return isSetPublicationStatus();
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
    result.append(", PublicationStatus: ");
    if (publicationStatus_set_) result.append(publicationStatus); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //RedefinableHeaderImpl
