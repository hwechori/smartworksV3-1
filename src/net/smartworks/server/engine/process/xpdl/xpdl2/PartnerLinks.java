/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartnerLinks.java,v 1.1 2009/12/22 06:18:15 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;
import java.util.List;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner Links</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLinks#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLinks#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLinks#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface PartnerLinks extends Serializable
{
  /**
   * Returns the value of the '<em><b>Partner Link</b></em>' containment reference list.
   * The list contents are of type {@link net.smartworks.server.engine.process.xpdl.xpdl2.PartnerLink}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partner Link</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partner Link</em>' containment reference list.
   * @generated
   */
  List getPartnerLink();

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

} // PartnerLinks
