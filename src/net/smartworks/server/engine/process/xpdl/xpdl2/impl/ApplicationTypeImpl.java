/**
 * <copyright>
 * </copyright>
 *
 * $Id: ApplicationTypeImpl.java,v 1.1 2009/12/22 06:17:28 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2.impl;

import net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType;
import net.smartworks.server.engine.process.xpdl.xpdl2.BusinessRule;
import net.smartworks.server.engine.process.xpdl.xpdl2.Ejb;
import net.smartworks.server.engine.process.xpdl.xpdl2.Form;
import net.smartworks.server.engine.process.xpdl.xpdl2.Pojo;
import net.smartworks.server.engine.process.xpdl.xpdl2.Script1;
import net.smartworks.server.engine.process.xpdl.xpdl2.WebService;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xpdl2Factory;
import net.smartworks.server.engine.process.xpdl.xpdl2.Xslt;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.lang.Object;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getEjb <em>Ejb</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getPojo <em>Pojo</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getXslt <em>Xslt</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getScript <em>Script</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getWebService <em>Web Service</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getBusinessRule <em>Business Rule</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getForm <em>Form</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.impl.ApplicationTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationTypeImpl extends DataObjectBase implements ApplicationType
{

  public final static int EJB = 0;

  public final static int POJO = 1;

  public final static int XSLT = 2;

  public final static int SCRIPT = 3;

  public final static int WEB_SERVICE = 4;

  public final static int BUSINESS_RULE = 5;

  public final static int FORM = 6;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 7;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Ejb</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EJB = 0;

  /**
   * The internal feature id for the '<em><b>Pojo</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_POJO = 1;

  /**
   * The internal feature id for the '<em><b>Xslt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XSLT = 2;

  /**
   * The internal feature id for the '<em><b>Script</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SCRIPT = 3;

  /**
   * The internal feature id for the '<em><b>Web Service</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_WEB_SERVICE = 4;

  /**
   * The internal feature id for the '<em><b>Business Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BUSINESS_RULE = 5;

  /**
   * The internal feature id for the '<em><b>Form</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FORM = 6;

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
      case INTERNAL_EJB: return EJB;
      case INTERNAL_POJO: return POJO;
      case INTERNAL_XSLT: return XSLT;
      case INTERNAL_SCRIPT: return SCRIPT;
      case INTERNAL_WEB_SERVICE: return WEB_SERVICE;
      case INTERNAL_BUSINESS_RULE: return BUSINESS_RULE;
      case INTERNAL_FORM: return FORM;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getEjb() <em>Ejb</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEjb()
   * @generated
   * @ordered
   */
  
  protected Ejb ejb = null;
  
  /**
   * This is true if the Ejb containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean ejb_set_ = false;

  /**
   * The cached value of the '{@link #getPojo() <em>Pojo</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPojo()
   * @generated
   * @ordered
   */
  
  protected Pojo pojo = null;
  
  /**
   * This is true if the Pojo containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean pojo_set_ = false;

  /**
   * The cached value of the '{@link #getXslt() <em>Xslt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXslt()
   * @generated
   * @ordered
   */
  
  protected Xslt xslt = null;
  
  /**
   * This is true if the Xslt containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xslt_set_ = false;

  /**
   * The cached value of the '{@link #getScript() <em>Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScript()
   * @generated
   * @ordered
   */
  
  protected Script1 script = null;
  
  /**
   * This is true if the Script containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean script_set_ = false;

  /**
   * The cached value of the '{@link #getWebService() <em>Web Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWebService()
   * @generated
   * @ordered
   */
  
  protected WebService webService = null;
  
  /**
   * This is true if the Web Service containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean webService_set_ = false;

  /**
   * The cached value of the '{@link #getBusinessRule() <em>Business Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBusinessRule()
   * @generated
   * @ordered
   */
  
  protected BusinessRule businessRule = null;
  
  /**
   * This is true if the Business Rule containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean businessRule_set_ = false;

  /**
   * The cached value of the '{@link #getForm() <em>Form</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForm()
   * @generated
   * @ordered
   */
  
  protected Form form = null;
  
  /**
   * This is true if the Form containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean form_set_ = false;

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
  public ApplicationTypeImpl()
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
    return ((Xpdl2FactoryImpl)Xpdl2Factory.INSTANCE).getApplicationType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ejb getEjb()
  {
    return ejb;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetEjb(Ejb newEjb, ChangeContext changeContext)
  {
    Ejb oldEjb = ejb;
    ejb = newEjb;
    boolean oldEjb_set_ = ejb_set_;
    ejb_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EJB, oldEjb, newEjb, !oldEjb_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEjb(Ejb newEjb)
  {
    if (newEjb != ejb)
    {
      ChangeContext changeContext = null;
      if (ejb != null)
        changeContext = inverseRemove(ejb, this, OPPOSITE_FEATURE_BASE - INTERNAL_EJB, null, changeContext);
      if (newEjb != null)
        changeContext = inverseAdd(newEjb, this, OPPOSITE_FEATURE_BASE - INTERNAL_EJB, null, changeContext);
      changeContext = basicSetEjb(newEjb, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldEjb_set_ = ejb_set_;
      ejb_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EJB, newEjb, newEjb, !oldEjb_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetEjb(ChangeContext changeContext)
  {
    Ejb oldEjb = ejb;
    ejb = null;
    boolean oldEjb_set_ = ejb_set_;
    ejb_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EJB, oldEjb, null, !oldEjb_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEjb()
  {
    if (ejb != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(ejb, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EJB, null, changeContext);
      changeContext = basicUnsetEjb(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldEjb_set_ = ejb_set_;
      ejb_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EJB, null, null, oldEjb_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEjb()
  {
    return ejb_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pojo getPojo()
  {
    return pojo;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetPojo(Pojo newPojo, ChangeContext changeContext)
  {
    Pojo oldPojo = pojo;
    pojo = newPojo;
    boolean oldPojo_set_ = pojo_set_;
    pojo_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_POJO, oldPojo, newPojo, !oldPojo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPojo(Pojo newPojo)
  {
    if (newPojo != pojo)
    {
      ChangeContext changeContext = null;
      if (pojo != null)
        changeContext = inverseRemove(pojo, this, OPPOSITE_FEATURE_BASE - INTERNAL_POJO, null, changeContext);
      if (newPojo != null)
        changeContext = inverseAdd(newPojo, this, OPPOSITE_FEATURE_BASE - INTERNAL_POJO, null, changeContext);
      changeContext = basicSetPojo(newPojo, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldPojo_set_ = pojo_set_;
      pojo_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_POJO, newPojo, newPojo, !oldPojo_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetPojo(ChangeContext changeContext)
  {
    Pojo oldPojo = pojo;
    pojo = null;
    boolean oldPojo_set_ = pojo_set_;
    pojo_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_POJO, oldPojo, null, !oldPojo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPojo()
  {
    if (pojo != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(pojo, this, EOPPOSITE_FEATURE_BASE - INTERNAL_POJO, null, changeContext);
      changeContext = basicUnsetPojo(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldPojo_set_ = pojo_set_;
      pojo_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_POJO, null, null, oldPojo_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPojo()
  {
    return pojo_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Xslt getXslt()
  {
    return xslt;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetXslt(Xslt newXslt, ChangeContext changeContext)
  {
    Xslt oldXslt = xslt;
    xslt = newXslt;
    boolean oldXslt_set_ = xslt_set_;
    xslt_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_XSLT, oldXslt, newXslt, !oldXslt_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXslt(Xslt newXslt)
  {
    if (newXslt != xslt)
    {
      ChangeContext changeContext = null;
      if (xslt != null)
        changeContext = inverseRemove(xslt, this, OPPOSITE_FEATURE_BASE - INTERNAL_XSLT, null, changeContext);
      if (newXslt != null)
        changeContext = inverseAdd(newXslt, this, OPPOSITE_FEATURE_BASE - INTERNAL_XSLT, null, changeContext);
      changeContext = basicSetXslt(newXslt, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldXslt_set_ = xslt_set_;
      xslt_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_XSLT, newXslt, newXslt, !oldXslt_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetXslt(ChangeContext changeContext)
  {
    Xslt oldXslt = xslt;
    xslt = null;
    boolean oldXslt_set_ = xslt_set_;
    xslt_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_XSLT, oldXslt, null, !oldXslt_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXslt()
  {
    if (xslt != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(xslt, this, EOPPOSITE_FEATURE_BASE - INTERNAL_XSLT, null, changeContext);
      changeContext = basicUnsetXslt(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldXslt_set_ = xslt_set_;
      xslt_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_XSLT, null, null, oldXslt_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetXslt()
  {
    return xslt_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Script1 getScript()
  {
    return script;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetScript(Script1 newScript, ChangeContext changeContext)
  {
    Script1 oldScript = script;
    script = newScript;
    boolean oldScript_set_ = script_set_;
    script_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_SCRIPT, oldScript, newScript, !oldScript_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScript(Script1 newScript)
  {
    if (newScript != script)
    {
      ChangeContext changeContext = null;
      if (script != null)
        changeContext = inverseRemove(script, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCRIPT, null, changeContext);
      if (newScript != null)
        changeContext = inverseAdd(newScript, this, OPPOSITE_FEATURE_BASE - INTERNAL_SCRIPT, null, changeContext);
      changeContext = basicSetScript(newScript, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldScript_set_ = script_set_;
      script_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_SCRIPT, newScript, newScript, !oldScript_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetScript(ChangeContext changeContext)
  {
    Script1 oldScript = script;
    script = null;
    boolean oldScript_set_ = script_set_;
    script_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_SCRIPT, oldScript, null, !oldScript_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetScript()
  {
    if (script != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(script, this, EOPPOSITE_FEATURE_BASE - INTERNAL_SCRIPT, null, changeContext);
      changeContext = basicUnsetScript(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldScript_set_ = script_set_;
      script_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_SCRIPT, null, null, oldScript_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetScript()
  {
    return script_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WebService getWebService()
  {
    return webService;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetWebService(WebService newWebService, ChangeContext changeContext)
  {
    WebService oldWebService = webService;
    webService = newWebService;
    boolean oldWebService_set_ = webService_set_;
    webService_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_WEB_SERVICE, oldWebService, newWebService, !oldWebService_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWebService(WebService newWebService)
  {
    if (newWebService != webService)
    {
      ChangeContext changeContext = null;
      if (webService != null)
        changeContext = inverseRemove(webService, this, OPPOSITE_FEATURE_BASE - INTERNAL_WEB_SERVICE, null, changeContext);
      if (newWebService != null)
        changeContext = inverseAdd(newWebService, this, OPPOSITE_FEATURE_BASE - INTERNAL_WEB_SERVICE, null, changeContext);
      changeContext = basicSetWebService(newWebService, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldWebService_set_ = webService_set_;
      webService_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_WEB_SERVICE, newWebService, newWebService, !oldWebService_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetWebService(ChangeContext changeContext)
  {
    WebService oldWebService = webService;
    webService = null;
    boolean oldWebService_set_ = webService_set_;
    webService_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_WEB_SERVICE, oldWebService, null, !oldWebService_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetWebService()
  {
    if (webService != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(webService, this, EOPPOSITE_FEATURE_BASE - INTERNAL_WEB_SERVICE, null, changeContext);
      changeContext = basicUnsetWebService(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldWebService_set_ = webService_set_;
      webService_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_WEB_SERVICE, null, null, oldWebService_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetWebService()
  {
    return webService_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BusinessRule getBusinessRule()
  {
    return businessRule;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetBusinessRule(BusinessRule newBusinessRule, ChangeContext changeContext)
  {
    BusinessRule oldBusinessRule = businessRule;
    businessRule = newBusinessRule;
    boolean oldBusinessRule_set_ = businessRule_set_;
    businessRule_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_BUSINESS_RULE, oldBusinessRule, newBusinessRule, !oldBusinessRule_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBusinessRule(BusinessRule newBusinessRule)
  {
    if (newBusinessRule != businessRule)
    {
      ChangeContext changeContext = null;
      if (businessRule != null)
        changeContext = inverseRemove(businessRule, this, OPPOSITE_FEATURE_BASE - INTERNAL_BUSINESS_RULE, null, changeContext);
      if (newBusinessRule != null)
        changeContext = inverseAdd(newBusinessRule, this, OPPOSITE_FEATURE_BASE - INTERNAL_BUSINESS_RULE, null, changeContext);
      changeContext = basicSetBusinessRule(newBusinessRule, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldBusinessRule_set_ = businessRule_set_;
      businessRule_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_BUSINESS_RULE, newBusinessRule, newBusinessRule, !oldBusinessRule_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetBusinessRule(ChangeContext changeContext)
  {
    BusinessRule oldBusinessRule = businessRule;
    businessRule = null;
    boolean oldBusinessRule_set_ = businessRule_set_;
    businessRule_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_BUSINESS_RULE, oldBusinessRule, null, !oldBusinessRule_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBusinessRule()
  {
    if (businessRule != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(businessRule, this, EOPPOSITE_FEATURE_BASE - INTERNAL_BUSINESS_RULE, null, changeContext);
      changeContext = basicUnsetBusinessRule(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldBusinessRule_set_ = businessRule_set_;
      businessRule_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_BUSINESS_RULE, null, null, oldBusinessRule_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBusinessRule()
  {
    return businessRule_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Form getForm()
  {
    return form;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetForm(Form newForm, ChangeContext changeContext)
  {
    Form oldForm = form;
    form = newForm;
    boolean oldForm_set_ = form_set_;
    form_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_FORM, oldForm, newForm, !oldForm_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForm(Form newForm)
  {
    if (newForm != form)
    {
      ChangeContext changeContext = null;
      if (form != null)
        changeContext = inverseRemove(form, this, OPPOSITE_FEATURE_BASE - INTERNAL_FORM, null, changeContext);
      if (newForm != null)
        changeContext = inverseAdd(newForm, this, OPPOSITE_FEATURE_BASE - INTERNAL_FORM, null, changeContext);
      changeContext = basicSetForm(newForm, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldForm_set_ = form_set_;
      form_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_FORM, newForm, newForm, !oldForm_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetForm(ChangeContext changeContext)
  {
    Form oldForm = form;
    form = null;
    boolean oldForm_set_ = form_set_;
    form_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_FORM, oldForm, null, !oldForm_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetForm()
  {
    if (form != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(form, this, EOPPOSITE_FEATURE_BASE - INTERNAL_FORM, null, changeContext);
      changeContext = basicUnsetForm(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldForm_set_ = form_set_;
      form_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_FORM, null, null, oldForm_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetForm()
  {
    return form_set_;
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
      case EJB:
        return basicUnsetEjb(changeContext);
      case POJO:
        return basicUnsetPojo(changeContext);
      case XSLT:
        return basicUnsetXslt(changeContext);
      case SCRIPT:
        return basicUnsetScript(changeContext);
      case WEB_SERVICE:
        return basicUnsetWebService(changeContext);
      case BUSINESS_RULE:
        return basicUnsetBusinessRule(changeContext);
      case FORM:
        return basicUnsetForm(changeContext);
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
      case EJB:
        return getEjb();
      case POJO:
        return getPojo();
      case XSLT:
        return getXslt();
      case SCRIPT:
        return getScript();
      case WEB_SERVICE:
        return getWebService();
      case BUSINESS_RULE:
        return getBusinessRule();
      case FORM:
        return getForm();
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
      case EJB:
        setEjb((Ejb)newValue);
        return;
      case POJO:
        setPojo((Pojo)newValue);
        return;
      case XSLT:
        setXslt((Xslt)newValue);
        return;
      case SCRIPT:
        setScript((Script1)newValue);
        return;
      case WEB_SERVICE:
        setWebService((WebService)newValue);
        return;
      case BUSINESS_RULE:
        setBusinessRule((BusinessRule)newValue);
        return;
      case FORM:
        setForm((Form)newValue);
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
      case EJB:
        unsetEjb();
        return;
      case POJO:
        unsetPojo();
        return;
      case XSLT:
        unsetXslt();
        return;
      case SCRIPT:
        unsetScript();
        return;
      case WEB_SERVICE:
        unsetWebService();
        return;
      case BUSINESS_RULE:
        unsetBusinessRule();
        return;
      case FORM:
        unsetForm();
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
      case EJB:
        return isSetEjb();
      case POJO:
        return isSetPojo();
      case XSLT:
        return isSetXslt();
      case SCRIPT:
        return isSetScript();
      case WEB_SERVICE:
        return isSetWebService();
      case BUSINESS_RULE:
        return isSetBusinessRule();
      case FORM:
        return isSetForm();
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
    result.append(" (anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //ApplicationTypeImpl
