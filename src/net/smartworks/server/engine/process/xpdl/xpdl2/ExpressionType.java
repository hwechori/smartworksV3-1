/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpressionType.java,v 1.1 2009/12/22 06:18:11 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl2;

import java.io.Serializable;

import commonj.sdo.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getGroup <em>Group</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getAny <em>Any</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getScriptGrammar <em>Script Grammar</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ExpressionType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @generated
   */
  Sequence getMixed();

  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @generated
   */
  Sequence getGroup();

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
   * Returns the value of the '<em><b>Script Grammar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script Grammar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Script Grammar</em>' attribute.
   * @see #isSetScriptGrammar()
   * @see #unsetScriptGrammar()
   * @see #setScriptGrammar(String)
   * @generated
   */
  String getScriptGrammar();

  /**
   * Sets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getScriptGrammar <em>Script Grammar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Script Grammar</em>' attribute.
   * @see #isSetScriptGrammar()
   * @see #unsetScriptGrammar()
   * @see #getScriptGrammar()
   * @generated
   */
  void setScriptGrammar(String value);

  /**
   * Unsets the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getScriptGrammar <em>Script Grammar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetScriptGrammar()
   * @see #getScriptGrammar()
   * @see #setScriptGrammar(String)
   * @generated
   */
  void unsetScriptGrammar();

  /**
   * Returns whether the value of the '{@link net.smartworks.server.engine.process.xpdl.xpdl2.ExpressionType#getScriptGrammar <em>Script Grammar</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Script Grammar</em>' attribute is set.
   * @see #unsetScriptGrammar()
   * @see #getScriptGrammar()
   * @see #setScriptGrammar(String)
   * @generated
   */
  boolean isSetScriptGrammar();

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
  
  /**
   * ���� �߰� �������̽� - expression ���� �����Ѵ�.
   * 
   * @return
   */
  public String getExprValue();
  
  /**
   * ���� �߰� �������̽� - expression ���� �����Ѵ�.
   * 
   * @param exprValue
   */
  public void setExprValue(String exprValue);

} // ExpressionType
