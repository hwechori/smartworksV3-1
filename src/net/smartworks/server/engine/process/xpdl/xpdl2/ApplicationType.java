/**
 * <copyright>
 * </copyright>
 *
 * $Id: ApplicationType.java,v 1.1 2009/12/22 06:18:23 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getEjb <em>Ejb</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getPojo <em>Pojo</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getXslt <em>Xslt</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getScript <em>Script</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getWebService <em>Web Service</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getBusinessRule <em>Business Rule</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getForm <em>Form</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ApplicationType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Ejb</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Call EJB component -- There can be max one formal parameter that is OUT, if it exists it has to be the last formal parameter. no INOUT formal parameters
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ejb</em>' containment reference.
   * @see #isSetEjb()
   * @see #unsetEjb()
   * @see #setEjb(Ejb)
   * @generated
   */
  Ejb getEjb();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getEjb <em>Ejb</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ejb</em>' containment reference.
   * @see #isSetEjb()
   * @see #unsetEjb()
   * @see #getEjb()
   * @generated
   */
  void setEjb(Ejb value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getEjb <em>Ejb</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEjb()
   * @see #getEjb()
   * @see #setEjb(Ejb)
   * @generated
   */
  void unsetEjb();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getEjb <em>Ejb</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ejb</em>' containment reference is set.
   * @see #unsetEjb()
   * @see #getEjb()
   * @see #setEjb(Ejb)
   * @generated
   */
  boolean isSetEjb();

  /**
   * Returns the value of the '<em><b>Pojo</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Call method on Java class -- There can be max one formal parameter that is OUT, if it exists it has to be the last formal parameter. no INOUT formal parameters
   * <!-- end-model-doc -->
   * @return the value of the '<em>Pojo</em>' containment reference.
   * @see #isSetPojo()
   * @see #unsetPojo()
   * @see #setPojo(Pojo)
   * @generated
   */
  Pojo getPojo();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getPojo <em>Pojo</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pojo</em>' containment reference.
   * @see #isSetPojo()
   * @see #unsetPojo()
   * @see #getPojo()
   * @generated
   */
  void setPojo(Pojo value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getPojo <em>Pojo</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPojo()
   * @see #getPojo()
   * @see #setPojo(Pojo)
   * @generated
   */
  void unsetPojo();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getPojo <em>Pojo</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Pojo</em>' containment reference is set.
   * @see #unsetPojo()
   * @see #getPojo()
   * @see #setPojo(Pojo)
   * @generated
   */
  boolean isSetPojo();

  /**
   * Returns the value of the '<em><b>Xslt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Execute Tranformation -- Formal Parameters restrictions: one IN and one OUT formal parameters or only one INOUT formal parameter
   * <!-- end-model-doc -->
   * @return the value of the '<em>Xslt</em>' containment reference.
   * @see #isSetXslt()
   * @see #unsetXslt()
   * @see #setXslt(Xslt)
   * @generated
   */
  Xslt getXslt();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getXslt <em>Xslt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xslt</em>' containment reference.
   * @see #isSetXslt()
   * @see #unsetXslt()
   * @see #getXslt()
   * @generated
   */
  void setXslt(Xslt value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getXslt <em>Xslt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetXslt()
   * @see #getXslt()
   * @see #setXslt(Xslt)
   * @generated
   */
  void unsetXslt();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getXslt <em>Xslt</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Xslt</em>' containment reference is set.
   * @see #unsetXslt()
   * @see #getXslt()
   * @see #setXslt(Xslt)
   * @generated
   */
  boolean isSetXslt();

  /**
   * Returns the value of the '<em><b>Script</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  Execute Script -- No additional restrictions for formal parameters. The suggestion: every Formal Parameter should be registered in the script scope as a global variable
   * <!-- end-model-doc -->
   * @return the value of the '<em>Script</em>' containment reference.
   * @see #isSetScript()
   * @see #unsetScript()
   * @see #setScript(Script1)
   * @generated
   */
  Script1 getScript();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getScript <em>Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Script</em>' containment reference.
   * @see #isSetScript()
   * @see #unsetScript()
   * @see #getScript()
   * @generated
   */
  void setScript(Script1 value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getScript <em>Script</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetScript()
   * @see #getScript()
   * @see #setScript(Script1)
   * @generated
   */
  void unsetScript();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getScript <em>Script</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Script</em>' containment reference is set.
   * @see #unsetScript()
   * @see #getScript()
   * @see #setScript(Script1)
   * @generated
   */
  boolean isSetScript();

  /**
   * Returns the value of the '<em><b>Web Service</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  For WSDL 1.2 -- Invoke WebService, all IN Fprmal Parameters will be mapped to input message, all OUT Formal Parameters will be maped from output message
   * <!-- end-model-doc -->
   * @return the value of the '<em>Web Service</em>' containment reference.
   * @see #isSetWebService()
   * @see #unsetWebService()
   * @see #setWebService(WebService)
   * @generated
   */
  WebService getWebService();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getWebService <em>Web Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Web Service</em>' containment reference.
   * @see #isSetWebService()
   * @see #unsetWebService()
   * @see #getWebService()
   * @generated
   */
  void setWebService(WebService value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getWebService <em>Web Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetWebService()
   * @see #getWebService()
   * @see #setWebService(WebService)
   * @generated
   */
  void unsetWebService();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getWebService <em>Web Service</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Web Service</em>' containment reference is set.
   * @see #unsetWebService()
   * @see #getWebService()
   * @see #setWebService(WebService)
   * @generated
   */
  boolean isSetWebService();

  /**
   * Returns the value of the '<em><b>Business Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Invoke business rule
   * <!-- end-model-doc -->
   * @return the value of the '<em>Business Rule</em>' containment reference.
   * @see #isSetBusinessRule()
   * @see #unsetBusinessRule()
   * @see #setBusinessRule(BusinessRule)
   * @generated
   */
  BusinessRule getBusinessRule();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getBusinessRule <em>Business Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Business Rule</em>' containment reference.
   * @see #isSetBusinessRule()
   * @see #unsetBusinessRule()
   * @see #getBusinessRule()
   * @generated
   */
  void setBusinessRule(BusinessRule value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getBusinessRule <em>Business Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBusinessRule()
   * @see #getBusinessRule()
   * @see #setBusinessRule(BusinessRule)
   * @generated
   */
  void unsetBusinessRule();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getBusinessRule <em>Business Rule</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Business Rule</em>' containment reference is set.
   * @see #unsetBusinessRule()
   * @see #getBusinessRule()
   * @see #setBusinessRule(BusinessRule)
   * @generated
   */
  boolean isSetBusinessRule();

  /**
   * Returns the value of the '<em><b>Form</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Placeholder for all form related additional information.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Form</em>' containment reference.
   * @see #isSetForm()
   * @see #unsetForm()
   * @see #setForm(Form)
   * @generated
   */
  Form getForm();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getForm <em>Form</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Form</em>' containment reference.
   * @see #isSetForm()
   * @see #unsetForm()
   * @see #getForm()
   * @generated
   */
  void setForm(Form value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getForm <em>Form</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetForm()
   * @see #getForm()
   * @see #setForm(Form)
   * @generated
   */
  void unsetForm();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ApplicationType#getForm <em>Form</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Form</em>' containment reference is set.
   * @see #unsetForm()
   * @see #getForm()
   * @see #setForm(Form)
   * @generated
   */
  boolean isSetForm();

  /**
   * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Attribute</em>' attribute list.
   * @generated
   */
  Sequence getAnyAttribute();

} // ApplicationType
