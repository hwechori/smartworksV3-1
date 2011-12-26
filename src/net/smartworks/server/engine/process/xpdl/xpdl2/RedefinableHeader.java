/**
 * <copyright>
 * </copyright>
 *
 * $Id: RedefinableHeader.java,v 1.1 2009/12/22 06:18:22 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Redefinable Header</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getAuthor <em>Author</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getVersion <em>Version</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCountrykey <em>Countrykey</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getResponsibles <em>Responsibles</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getPublicationStatus <em>Publication Status</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface RedefinableHeader extends Serializable
{
  /**
   * Returns the value of the '<em><b>Author</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Author</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Author</em>' containment reference.
   * @see #isSetAuthor()
   * @see #unsetAuthor()
   * @see #setAuthor(Author)
   * @generated
   */
  Author getAuthor();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getAuthor <em>Author</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Author</em>' containment reference.
   * @see #isSetAuthor()
   * @see #unsetAuthor()
   * @see #getAuthor()
   * @generated
   */
  void setAuthor(Author value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getAuthor <em>Author</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAuthor()
   * @see #getAuthor()
   * @see #setAuthor(Author)
   * @generated
   */
  void unsetAuthor();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getAuthor <em>Author</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Author</em>' containment reference is set.
   * @see #unsetAuthor()
   * @see #getAuthor()
   * @see #setAuthor(Author)
   * @generated
   */
  boolean isSetAuthor();

  /**
   * Returns the value of the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' containment reference.
   * @see #isSetVersion()
   * @see #unsetVersion()
   * @see #setVersion(Version)
   * @generated
   */
  Version getVersion();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getVersion <em>Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' containment reference.
   * @see #isSetVersion()
   * @see #unsetVersion()
   * @see #getVersion()
   * @generated
   */
  void setVersion(Version value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getVersion <em>Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetVersion()
   * @see #getVersion()
   * @see #setVersion(Version)
   * @generated
   */
  void unsetVersion();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getVersion <em>Version</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Version</em>' containment reference is set.
   * @see #unsetVersion()
   * @see #getVersion()
   * @see #setVersion(Version)
   * @generated
   */
  boolean isSetVersion();

  /**
   * Returns the value of the '<em><b>Codepage</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Codepage</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Codepage</em>' containment reference.
   * @see #isSetCodepage()
   * @see #unsetCodepage()
   * @see #setCodepage(Codepage)
   * @generated
   */
  Codepage getCodepage();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCodepage <em>Codepage</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Codepage</em>' containment reference.
   * @see #isSetCodepage()
   * @see #unsetCodepage()
   * @see #getCodepage()
   * @generated
   */
  void setCodepage(Codepage value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCodepage <em>Codepage</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCodepage()
   * @see #getCodepage()
   * @see #setCodepage(Codepage)
   * @generated
   */
  void unsetCodepage();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCodepage <em>Codepage</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Codepage</em>' containment reference is set.
   * @see #unsetCodepage()
   * @see #getCodepage()
   * @see #setCodepage(Codepage)
   * @generated
   */
  boolean isSetCodepage();

  /**
   * Returns the value of the '<em><b>Countrykey</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Countrykey</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Countrykey</em>' containment reference.
   * @see #isSetCountrykey()
   * @see #unsetCountrykey()
   * @see #setCountrykey(Countrykey)
   * @generated
   */
  Countrykey getCountrykey();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCountrykey <em>Countrykey</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Countrykey</em>' containment reference.
   * @see #isSetCountrykey()
   * @see #unsetCountrykey()
   * @see #getCountrykey()
   * @generated
   */
  void setCountrykey(Countrykey value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCountrykey <em>Countrykey</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCountrykey()
   * @see #getCountrykey()
   * @see #setCountrykey(Countrykey)
   * @generated
   */
  void unsetCountrykey();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getCountrykey <em>Countrykey</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Countrykey</em>' containment reference is set.
   * @see #unsetCountrykey()
   * @see #getCountrykey()
   * @see #setCountrykey(Countrykey)
   * @generated
   */
  boolean isSetCountrykey();

  /**
   * Returns the value of the '<em><b>Responsibles</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Responsibles</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Responsibles</em>' containment reference.
   * @see #isSetResponsibles()
   * @see #unsetResponsibles()
   * @see #setResponsibles(Responsibles)
   * @generated
   */
  Responsibles getResponsibles();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getResponsibles <em>Responsibles</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Responsibles</em>' containment reference.
   * @see #isSetResponsibles()
   * @see #unsetResponsibles()
   * @see #getResponsibles()
   * @generated
   */
  void setResponsibles(Responsibles value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getResponsibles <em>Responsibles</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetResponsibles()
   * @see #getResponsibles()
   * @see #setResponsibles(Responsibles)
   * @generated
   */
  void unsetResponsibles();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getResponsibles <em>Responsibles</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Responsibles</em>' containment reference is set.
   * @see #unsetResponsibles()
   * @see #getResponsibles()
   * @see #setResponsibles(Responsibles)
   * @generated
   */
  boolean isSetResponsibles();

  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @generated
   */
  Sequence getAny();

  /**
   * Returns the value of the '<em><b>Publication Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Publication Status</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Publication Status</em>' attribute.
   * @see #isSetPublicationStatus()
   * @see #unsetPublicationStatus()
   * @see #setPublicationStatus(String)
   * @generated
   */
  String getPublicationStatus();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getPublicationStatus <em>Publication Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Publication Status</em>' attribute.
   * @see #isSetPublicationStatus()
   * @see #unsetPublicationStatus()
   * @see #getPublicationStatus()
   * @generated
   */
  void setPublicationStatus(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getPublicationStatus <em>Publication Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPublicationStatus()
   * @see #getPublicationStatus()
   * @see #setPublicationStatus(String)
   * @generated
   */
  void unsetPublicationStatus();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.RedefinableHeader#getPublicationStatus <em>Publication Status</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Publication Status</em>' attribute is set.
   * @see #unsetPublicationStatus()
   * @see #getPublicationStatus()
   * @see #setPublicationStatus(String)
   * @generated
   */
  boolean isSetPublicationStatus();

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

} // RedefinableHeader
