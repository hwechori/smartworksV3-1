/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConformanceClassImpl.java,v 1.1 2009/12/22 06:17:22 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.ConformanceClass;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conformance Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.ConformanceClassImpl#getGraphConformance <em>Graph Conformance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConformanceClassImpl extends DataObjectBase implements ConformanceClass
{

  public final static int GRAPH_CONFORMANCE = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Graph Conformance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GRAPH_CONFORMANCE = 0;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 1;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_GRAPH_CONFORMANCE: return GRAPH_CONFORMANCE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getGraphConformance() <em>Graph Conformance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGraphConformance()
   * @generated
   * @ordered
   */
  protected static final String GRAPH_CONFORMANCE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getGraphConformance() <em>Graph Conformance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGraphConformance()
   * @generated
   * @ordered
   */
  protected String graphConformance = GRAPH_CONFORMANCE_DEFAULT_;

  /**
   * This is true if the Graph Conformance attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean graphConformance_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConformanceClassImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getConformanceClass();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGraphConformance()
  {
    return graphConformance;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGraphConformance(String newGraphConformance)
  {
    String oldGraphConformance = graphConformance;
    graphConformance = newGraphConformance;
    boolean oldGraphConformance_set_ = graphConformance_set_;
    graphConformance_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_GRAPH_CONFORMANCE, oldGraphConformance, graphConformance, !oldGraphConformance_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetGraphConformance()
  {
    String oldGraphConformance = graphConformance;
    boolean oldGraphConformance_set_ = graphConformance_set_;
    graphConformance = GRAPH_CONFORMANCE_DEFAULT_;
    graphConformance_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_GRAPH_CONFORMANCE, oldGraphConformance, GRAPH_CONFORMANCE_DEFAULT_, oldGraphConformance_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetGraphConformance()
  {
    return graphConformance_set_;
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
      case GRAPH_CONFORMANCE:
        return getGraphConformance();
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
      case GRAPH_CONFORMANCE:
        setGraphConformance((String)newValue);
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
      case GRAPH_CONFORMANCE:
        unsetGraphConformance();
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
      case GRAPH_CONFORMANCE:
        return isSetGraphConformance();
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
    result.append(" (GraphConformance: ");
    if (graphConformance_set_) result.append(graphConformance); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ConformanceClassImpl
