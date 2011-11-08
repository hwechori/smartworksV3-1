/**
 * <copyright>
 * </copyright>
 *
 * $Id: WorkflowProcessImpl.java,v 1.1 2009/12/22 06:17:13 kmyu Exp $
 */
package net.smartworks.server.engine.process.xpdl.xpdl1.impl;

import net.smartworks.server.engine.process.xpdl.xpdl1.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl1.ActivitySets;
import net.smartworks.server.engine.process.xpdl.xpdl1.Applications;
import net.smartworks.server.engine.process.xpdl.xpdl1.DataFields;
import net.smartworks.server.engine.process.xpdl.xpdl1.ExtendedAttributes;
import net.smartworks.server.engine.process.xpdl.xpdl1.FormalParameters;
import net.smartworks.server.engine.process.xpdl.xpdl1.Participants;
import net.smartworks.server.engine.process.xpdl.xpdl1.ProcessHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.RedefinableHeader;
import net.smartworks.server.engine.process.xpdl.xpdl1.Transitions;
import net.smartworks.server.engine.process.xpdl.xpdl1.WorkflowProcess;
import net.smartworks.server.engine.process.xpdl.xpdl1.Xpdl1Factory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getProcessHeader <em>Process Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getRedefinableHeader <em>Redefinable Header</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getApplications <em>Applications</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getActivitySets <em>Activity Sets</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getActivities <em>Activities</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.smartworks.server.engine.process.xpdl.xpdl1.impl.WorkflowProcessImpl#getAccessLevel <em>Access Level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkflowProcessImpl extends DataObjectBase implements WorkflowProcess
{

  public final static int PROCESS_HEADER = 0;

  public final static int REDEFINABLE_HEADER = 1;

  public final static int FORMAL_PARAMETERS = 2;

  public final static int DATA_FIELDS = 3;

  public final static int PARTICIPANTS = 4;

  public final static int APPLICATIONS = 5;

  public final static int ACTIVITY_SETS = 6;

  public final static int ACTIVITIES = 7;

  public final static int TRANSITIONS = 8;

  public final static int EXTENDED_ATTRIBUTES = 9;

  public final static int ID = 10;

  public final static int NAME = 11;

  public final static int ACCESS_LEVEL = 12;

  public final static int SDO_PROPERTY_COUNT = 13;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Process Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PROCESS_HEADER = 0;

  /**
   * The internal feature id for the '<em><b>Redefinable Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_REDEFINABLE_HEADER = 1;

  /**
   * The internal feature id for the '<em><b>Formal Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FORMAL_PARAMETERS = 2;

  /**
   * The internal feature id for the '<em><b>Data Fields</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_FIELDS = 3;

  /**
   * The internal feature id for the '<em><b>Participants</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PARTICIPANTS = 4;

  /**
   * The internal feature id for the '<em><b>Applications</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_APPLICATIONS = 5;

  /**
   * The internal feature id for the '<em><b>Activity Sets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTIVITY_SETS = 6;

  /**
   * The internal feature id for the '<em><b>Activities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACTIVITIES = 7;

  /**
   * The internal feature id for the '<em><b>Transitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TRANSITIONS = 8;

  /**
   * The internal feature id for the '<em><b>Extended Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_EXTENDED_ATTRIBUTES = 9;

  /**
   * The internal feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ID = 10;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 11;

  /**
   * The internal feature id for the '<em><b>Access Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACCESS_LEVEL = 12;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 13;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_PROCESS_HEADER: return PROCESS_HEADER;
      case INTERNAL_REDEFINABLE_HEADER: return REDEFINABLE_HEADER;
      case INTERNAL_FORMAL_PARAMETERS: return FORMAL_PARAMETERS;
      case INTERNAL_DATA_FIELDS: return DATA_FIELDS;
      case INTERNAL_PARTICIPANTS: return PARTICIPANTS;
      case INTERNAL_APPLICATIONS: return APPLICATIONS;
      case INTERNAL_ACTIVITY_SETS: return ACTIVITY_SETS;
      case INTERNAL_ACTIVITIES: return ACTIVITIES;
      case INTERNAL_TRANSITIONS: return TRANSITIONS;
      case INTERNAL_EXTENDED_ATTRIBUTES: return EXTENDED_ATTRIBUTES;
      case INTERNAL_ID: return ID;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_ACCESS_LEVEL: return ACCESS_LEVEL;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getProcessHeader() <em>Process Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessHeader()
   * @generated
   * @ordered
   */
  
  protected ProcessHeader processHeader = null;
  
  /**
   * This is true if the Process Header containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean processHeader_set_ = false;

  /**
   * The cached value of the '{@link #getRedefinableHeader() <em>Redefinable Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinableHeader()
   * @generated
   * @ordered
   */
  
  protected RedefinableHeader redefinableHeader = null;
  
  /**
   * This is true if the Redefinable Header containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean redefinableHeader_set_ = false;

  /**
   * The cached value of the '{@link #getFormalParameters() <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameters()
   * @generated
   * @ordered
   */
  
  protected FormalParameters formalParameters = null;
  
  /**
   * This is true if the Formal Parameters containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean formalParameters_set_ = false;

  /**
   * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataFields()
   * @generated
   * @ordered
   */
  
  protected DataFields dataFields = null;
  
  /**
   * This is true if the Data Fields containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataFields_set_ = false;

  /**
   * The cached value of the '{@link #getParticipants() <em>Participants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticipants()
   * @generated
   * @ordered
   */
  
  protected Participants participants = null;
  
  /**
   * This is true if the Participants containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean participants_set_ = false;

  /**
   * The cached value of the '{@link #getApplications() <em>Applications</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplications()
   * @generated
   * @ordered
   */
  
  protected Applications applications = null;
  
  /**
   * This is true if the Applications containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean applications_set_ = false;

  /**
   * The cached value of the '{@link #getActivitySets() <em>Activity Sets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivitySets()
   * @generated
   * @ordered
   */
  
  protected ActivitySets activitySets = null;
  
  /**
   * This is true if the Activity Sets containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean activitySets_set_ = false;

  /**
   * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivities()
   * @generated
   * @ordered
   */
  
  protected Activities activities = null;
  
  /**
   * This is true if the Activities containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean activities_set_ = false;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  
  protected Transitions transitions = null;
  
  /**
   * This is true if the Transitions containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean transitions_set_ = false;

  /**
   * The cached value of the '{@link #getExtendedAttributes() <em>Extended Attributes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendedAttributes()
   * @generated
   * @ordered
   */
  
  protected ExtendedAttributes extendedAttributes = null;
  
  /**
   * This is true if the Extended Attributes containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean extendedAttributes_set_ = false;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_DEFAULT_;

  /**
   * This is true if the Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean id_set_ = false;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_DEFAULT_;

  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean name_set_ = false;

  /**
   * The default value of the '{@link #getAccessLevel() <em>Access Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessLevel()
   * @generated
   * @ordered
   */
  protected static final String ACCESS_LEVEL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getAccessLevel() <em>Access Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessLevel()
   * @generated
   * @ordered
   */
  protected String accessLevel = ACCESS_LEVEL_DEFAULT_;

  /**
   * This is true if the Access Level attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean accessLevel_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkflowProcessImpl()
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
    return ((Xpdl1FactoryImpl)Xpdl1Factory.INSTANCE).getWorkflowProcess();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessHeader getProcessHeader()
  {
    return processHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetProcessHeader(ProcessHeader newProcessHeader, ChangeContext changeContext)
  {
    ProcessHeader oldProcessHeader = processHeader;
    processHeader = newProcessHeader;
    boolean oldProcessHeader_set_ = processHeader_set_;
    processHeader_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PROCESS_HEADER, oldProcessHeader, newProcessHeader, !oldProcessHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcessHeader(ProcessHeader newProcessHeader)
  {
    if (newProcessHeader != processHeader)
    {
      ChangeContext changeContext = null;
      if (processHeader != null)
        changeContext = inverseRemove(processHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_PROCESS_HEADER, null, changeContext);
      if (newProcessHeader != null)
        changeContext = inverseAdd(newProcessHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_PROCESS_HEADER, null, changeContext);
      changeContext = basicSetProcessHeader(newProcessHeader, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldProcessHeader_set_ = processHeader_set_;
      processHeader_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PROCESS_HEADER, newProcessHeader, newProcessHeader, !oldProcessHeader_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetProcessHeader(ChangeContext changeContext)
  {
    ProcessHeader oldProcessHeader = processHeader;
    processHeader = null;
    boolean oldProcessHeader_set_ = processHeader_set_;
    processHeader_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PROCESS_HEADER, oldProcessHeader, null, !oldProcessHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetProcessHeader()
  {
    if (processHeader != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(processHeader, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PROCESS_HEADER, null, changeContext);
      changeContext = basicUnsetProcessHeader(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldProcessHeader_set_ = processHeader_set_;
      processHeader_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PROCESS_HEADER, null, null, oldProcessHeader_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetProcessHeader()
  {
    return processHeader_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinableHeader getRedefinableHeader()
  {
    return redefinableHeader;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetRedefinableHeader(RedefinableHeader newRedefinableHeader, ChangeContext changeContext)
  {
    RedefinableHeader oldRedefinableHeader = redefinableHeader;
    redefinableHeader = newRedefinableHeader;
    boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
    redefinableHeader_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_REDEFINABLE_HEADER, oldRedefinableHeader, newRedefinableHeader, !oldRedefinableHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedefinableHeader(RedefinableHeader newRedefinableHeader)
  {
    if (newRedefinableHeader != redefinableHeader)
    {
      ChangeContext changeContext = null;
      if (redefinableHeader != null)
        changeContext = inverseRemove(redefinableHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      if (newRedefinableHeader != null)
        changeContext = inverseAdd(newRedefinableHeader, this, OPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      changeContext = basicSetRedefinableHeader(newRedefinableHeader, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
      redefinableHeader_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_REDEFINABLE_HEADER, newRedefinableHeader, newRedefinableHeader, !oldRedefinableHeader_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetRedefinableHeader(ChangeContext changeContext)
  {
    RedefinableHeader oldRedefinableHeader = redefinableHeader;
    redefinableHeader = null;
    boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
    redefinableHeader_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_REDEFINABLE_HEADER, oldRedefinableHeader, null, !oldRedefinableHeader_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetRedefinableHeader()
  {
    if (redefinableHeader != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(redefinableHeader, this, EOPPOSITE_FEATURE_BASE - INTERNAL_REDEFINABLE_HEADER, null, changeContext);
      changeContext = basicUnsetRedefinableHeader(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldRedefinableHeader_set_ = redefinableHeader_set_;
      redefinableHeader_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_REDEFINABLE_HEADER, null, null, oldRedefinableHeader_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRedefinableHeader()
  {
    return redefinableHeader_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameters getFormalParameters()
  {
    return formalParameters;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetFormalParameters(FormalParameters newFormalParameters, ChangeContext changeContext)
  {
    FormalParameters oldFormalParameters = formalParameters;
    formalParameters = newFormalParameters;
    boolean oldFormalParameters_set_ = formalParameters_set_;
    formalParameters_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_FORMAL_PARAMETERS, oldFormalParameters, newFormalParameters, !oldFormalParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalParameters(FormalParameters newFormalParameters)
  {
    if (newFormalParameters != formalParameters)
    {
      ChangeContext changeContext = null;
      if (formalParameters != null)
        changeContext = inverseRemove(formalParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_FORMAL_PARAMETERS, null, changeContext);
      if (newFormalParameters != null)
        changeContext = inverseAdd(newFormalParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_FORMAL_PARAMETERS, null, changeContext);
      changeContext = basicSetFormalParameters(newFormalParameters, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldFormalParameters_set_ = formalParameters_set_;
      formalParameters_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_FORMAL_PARAMETERS, newFormalParameters, newFormalParameters, !oldFormalParameters_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetFormalParameters(ChangeContext changeContext)
  {
    FormalParameters oldFormalParameters = formalParameters;
    formalParameters = null;
    boolean oldFormalParameters_set_ = formalParameters_set_;
    formalParameters_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_FORMAL_PARAMETERS, oldFormalParameters, null, !oldFormalParameters_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFormalParameters()
  {
    if (formalParameters != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(formalParameters, this, EOPPOSITE_FEATURE_BASE - INTERNAL_FORMAL_PARAMETERS, null, changeContext);
      changeContext = basicUnsetFormalParameters(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldFormalParameters_set_ = formalParameters_set_;
      formalParameters_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_FORMAL_PARAMETERS, null, null, oldFormalParameters_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFormalParameters()
  {
    return formalParameters_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataFields getDataFields()
  {
    return dataFields;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetDataFields(DataFields newDataFields, ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = newDataFields;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_DATA_FIELDS, oldDataFields, newDataFields, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataFields(DataFields newDataFields)
  {
    if (newDataFields != dataFields)
    {
      ChangeContext changeContext = null;
      if (dataFields != null)
        changeContext = inverseRemove(dataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      if (newDataFields != null)
        changeContext = inverseAdd(newDataFields, this, OPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicSetDataFields(newDataFields, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_DATA_FIELDS, newDataFields, newDataFields, !oldDataFields_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetDataFields(ChangeContext changeContext)
  {
    DataFields oldDataFields = dataFields;
    dataFields = null;
    boolean oldDataFields_set_ = dataFields_set_;
    dataFields_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_DATA_FIELDS, oldDataFields, null, !oldDataFields_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataFields()
  {
    if (dataFields != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(dataFields, this, EOPPOSITE_FEATURE_BASE - INTERNAL_DATA_FIELDS, null, changeContext);
      changeContext = basicUnsetDataFields(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldDataFields_set_ = dataFields_set_;
      dataFields_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_DATA_FIELDS, null, null, oldDataFields_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataFields()
  {
    return dataFields_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Participants getParticipants()
  {
    return participants;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetParticipants(Participants newParticipants, ChangeContext changeContext)
  {
    Participants oldParticipants = participants;
    participants = newParticipants;
    boolean oldParticipants_set_ = participants_set_;
    participants_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_PARTICIPANTS, oldParticipants, newParticipants, !oldParticipants_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParticipants(Participants newParticipants)
  {
    if (newParticipants != participants)
    {
      ChangeContext changeContext = null;
      if (participants != null)
        changeContext = inverseRemove(participants, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      if (newParticipants != null)
        changeContext = inverseAdd(newParticipants, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      changeContext = basicSetParticipants(newParticipants, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldParticipants_set_ = participants_set_;
      participants_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_PARTICIPANTS, newParticipants, newParticipants, !oldParticipants_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetParticipants(ChangeContext changeContext)
  {
    Participants oldParticipants = participants;
    participants = null;
    boolean oldParticipants_set_ = participants_set_;
    participants_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_PARTICIPANTS, oldParticipants, null, !oldParticipants_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParticipants()
  {
    if (participants != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(participants, this, EOPPOSITE_FEATURE_BASE - INTERNAL_PARTICIPANTS, null, changeContext);
      changeContext = basicUnsetParticipants(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldParticipants_set_ = participants_set_;
      participants_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_PARTICIPANTS, null, null, oldParticipants_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParticipants()
  {
    return participants_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Applications getApplications()
  {
    return applications;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetApplications(Applications newApplications, ChangeContext changeContext)
  {
    Applications oldApplications = applications;
    applications = newApplications;
    boolean oldApplications_set_ = applications_set_;
    applications_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_APPLICATIONS, oldApplications, newApplications, !oldApplications_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplications(Applications newApplications)
  {
    if (newApplications != applications)
    {
      ChangeContext changeContext = null;
      if (applications != null)
        changeContext = inverseRemove(applications, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      if (newApplications != null)
        changeContext = inverseAdd(newApplications, this, OPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      changeContext = basicSetApplications(newApplications, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldApplications_set_ = applications_set_;
      applications_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_APPLICATIONS, newApplications, newApplications, !oldApplications_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetApplications(ChangeContext changeContext)
  {
    Applications oldApplications = applications;
    applications = null;
    boolean oldApplications_set_ = applications_set_;
    applications_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_APPLICATIONS, oldApplications, null, !oldApplications_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetApplications()
  {
    if (applications != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(applications, this, EOPPOSITE_FEATURE_BASE - INTERNAL_APPLICATIONS, null, changeContext);
      changeContext = basicUnsetApplications(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldApplications_set_ = applications_set_;
      applications_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_APPLICATIONS, null, null, oldApplications_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetApplications()
  {
    return applications_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivitySets getActivitySets()
  {
    return activitySets;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActivitySets(ActivitySets newActivitySets, ChangeContext changeContext)
  {
    ActivitySets oldActivitySets = activitySets;
    activitySets = newActivitySets;
    boolean oldActivitySets_set_ = activitySets_set_;
    activitySets_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTIVITY_SETS, oldActivitySets, newActivitySets, !oldActivitySets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivitySets(ActivitySets newActivitySets)
  {
    if (newActivitySets != activitySets)
    {
      ChangeContext changeContext = null;
      if (activitySets != null)
        changeContext = inverseRemove(activitySets, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITY_SETS, null, changeContext);
      if (newActivitySets != null)
        changeContext = inverseAdd(newActivitySets, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITY_SETS, null, changeContext);
      changeContext = basicSetActivitySets(newActivitySets, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActivitySets_set_ = activitySets_set_;
      activitySets_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTIVITY_SETS, newActivitySets, newActivitySets, !oldActivitySets_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActivitySets(ChangeContext changeContext)
  {
    ActivitySets oldActivitySets = activitySets;
    activitySets = null;
    boolean oldActivitySets_set_ = activitySets_set_;
    activitySets_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTIVITY_SETS, oldActivitySets, null, !oldActivitySets_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActivitySets()
  {
    if (activitySets != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(activitySets, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITY_SETS, null, changeContext);
      changeContext = basicUnsetActivitySets(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActivitySets_set_ = activitySets_set_;
      activitySets_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTIVITY_SETS, null, null, oldActivitySets_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActivitySets()
  {
    return activitySets_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activities getActivities()
  {
    return activities;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetActivities(Activities newActivities, ChangeContext changeContext)
  {
    Activities oldActivities = activities;
    activities = newActivities;
    boolean oldActivities_set_ = activities_set_;
    activities_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_ACTIVITIES, oldActivities, newActivities, !oldActivities_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivities(Activities newActivities)
  {
    if (newActivities != activities)
    {
      ChangeContext changeContext = null;
      if (activities != null)
        changeContext = inverseRemove(activities, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      if (newActivities != null)
        changeContext = inverseAdd(newActivities, this, OPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      changeContext = basicSetActivities(newActivities, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldActivities_set_ = activities_set_;
      activities_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_ACTIVITIES, newActivities, newActivities, !oldActivities_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetActivities(ChangeContext changeContext)
  {
    Activities oldActivities = activities;
    activities = null;
    boolean oldActivities_set_ = activities_set_;
    activities_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_ACTIVITIES, oldActivities, null, !oldActivities_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetActivities()
  {
    if (activities != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(activities, this, EOPPOSITE_FEATURE_BASE - INTERNAL_ACTIVITIES, null, changeContext);
      changeContext = basicUnsetActivities(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldActivities_set_ = activities_set_;
      activities_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_ACTIVITIES, null, null, oldActivities_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetActivities()
  {
    return activities_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transitions getTransitions()
  {
    return transitions;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetTransitions(Transitions newTransitions, ChangeContext changeContext)
  {
    Transitions oldTransitions = transitions;
    transitions = newTransitions;
    boolean oldTransitions_set_ = transitions_set_;
    transitions_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_TRANSITIONS, oldTransitions, newTransitions, !oldTransitions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitions(Transitions newTransitions)
  {
    if (newTransitions != transitions)
    {
      ChangeContext changeContext = null;
      if (transitions != null)
        changeContext = inverseRemove(transitions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      if (newTransitions != null)
        changeContext = inverseAdd(newTransitions, this, OPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      changeContext = basicSetTransitions(newTransitions, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldTransitions_set_ = transitions_set_;
      transitions_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_TRANSITIONS, newTransitions, newTransitions, !oldTransitions_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetTransitions(ChangeContext changeContext)
  {
    Transitions oldTransitions = transitions;
    transitions = null;
    boolean oldTransitions_set_ = transitions_set_;
    transitions_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_TRANSITIONS, oldTransitions, null, !oldTransitions_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTransitions()
  {
    if (transitions != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(transitions, this, EOPPOSITE_FEATURE_BASE - INTERNAL_TRANSITIONS, null, changeContext);
      changeContext = basicUnsetTransitions(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldTransitions_set_ = transitions_set_;
      transitions_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_TRANSITIONS, null, null, oldTransitions_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTransitions()
  {
    return transitions_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedAttributes getExtendedAttributes()
  {
    return extendedAttributes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetExtendedAttributes(ExtendedAttributes newExtendedAttributes, ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = newExtendedAttributes;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendedAttributes(ExtendedAttributes newExtendedAttributes)
  {
    if (newExtendedAttributes != extendedAttributes)
    {
      ChangeContext changeContext = null;
      if (extendedAttributes != null)
        changeContext = inverseRemove(extendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      if (newExtendedAttributes != null)
        changeContext = inverseAdd(newExtendedAttributes, this, OPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicSetExtendedAttributes(newExtendedAttributes, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_EXTENDED_ATTRIBUTES, newExtendedAttributes, newExtendedAttributes, !oldExtendedAttributes_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetExtendedAttributes(ChangeContext changeContext)
  {
    ExtendedAttributes oldExtendedAttributes = extendedAttributes;
    extendedAttributes = null;
    boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
    extendedAttributes_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, oldExtendedAttributes, null, !oldExtendedAttributes_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetExtendedAttributes()
  {
    if (extendedAttributes != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(extendedAttributes, this, EOPPOSITE_FEATURE_BASE - INTERNAL_EXTENDED_ATTRIBUTES, null, changeContext);
      changeContext = basicUnsetExtendedAttributes(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldExtendedAttributes_set_ = extendedAttributes_set_;
      extendedAttributes_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_EXTENDED_ATTRIBUTES, null, null, oldExtendedAttributes_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetExtendedAttributes()
  {
    return extendedAttributes_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    boolean oldId_set_ = id_set_;
    id_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ID, oldId, id, !oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetId()
  {
    String oldId = id;
    boolean oldId_set_ = id_set_;
    id = ID_DEFAULT_;
    id_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ID, oldId, ID_DEFAULT_, oldId_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetId()
  {
    return id_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    boolean oldName_set_ = name_set_;
    name_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAME, oldName, name, !oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetName()
  {
    String oldName = name;
    boolean oldName_set_ = name_set_;
    name = NAME_DEFAULT_;
    name_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAME, oldName, NAME_DEFAULT_, oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetName()
  {
    return name_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAccessLevel()
  {
    return accessLevel;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccessLevel(String newAccessLevel)
  {
    String oldAccessLevel = accessLevel;
    accessLevel = newAccessLevel;
    boolean oldAccessLevel_set_ = accessLevel_set_;
    accessLevel_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ACCESS_LEVEL, oldAccessLevel, accessLevel, !oldAccessLevel_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAccessLevel()
  {
    String oldAccessLevel = accessLevel;
    boolean oldAccessLevel_set_ = accessLevel_set_;
    accessLevel = ACCESS_LEVEL_DEFAULT_;
    accessLevel_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ACCESS_LEVEL, oldAccessLevel, ACCESS_LEVEL_DEFAULT_, oldAccessLevel_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAccessLevel()
  {
    return accessLevel_set_;
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
      case PROCESS_HEADER:
        return basicUnsetProcessHeader(changeContext);
      case REDEFINABLE_HEADER:
        return basicUnsetRedefinableHeader(changeContext);
      case FORMAL_PARAMETERS:
        return basicUnsetFormalParameters(changeContext);
      case DATA_FIELDS:
        return basicUnsetDataFields(changeContext);
      case PARTICIPANTS:
        return basicUnsetParticipants(changeContext);
      case APPLICATIONS:
        return basicUnsetApplications(changeContext);
      case ACTIVITY_SETS:
        return basicUnsetActivitySets(changeContext);
      case ACTIVITIES:
        return basicUnsetActivities(changeContext);
      case TRANSITIONS:
        return basicUnsetTransitions(changeContext);
      case EXTENDED_ATTRIBUTES:
        return basicUnsetExtendedAttributes(changeContext);
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
      case PROCESS_HEADER:
        return getProcessHeader();
      case REDEFINABLE_HEADER:
        return getRedefinableHeader();
      case FORMAL_PARAMETERS:
        return getFormalParameters();
      case DATA_FIELDS:
        return getDataFields();
      case PARTICIPANTS:
        return getParticipants();
      case APPLICATIONS:
        return getApplications();
      case ACTIVITY_SETS:
        return getActivitySets();
      case ACTIVITIES:
        return getActivities();
      case TRANSITIONS:
        return getTransitions();
      case EXTENDED_ATTRIBUTES:
        return getExtendedAttributes();
      case ID:
        return getId();
      case NAME:
        return getName();
      case ACCESS_LEVEL:
        return getAccessLevel();
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
      case PROCESS_HEADER:
        setProcessHeader((ProcessHeader)newValue);
        return;
      case REDEFINABLE_HEADER:
        setRedefinableHeader((RedefinableHeader)newValue);
        return;
      case FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)newValue);
        return;
      case DATA_FIELDS:
        setDataFields((DataFields)newValue);
        return;
      case PARTICIPANTS:
        setParticipants((Participants)newValue);
        return;
      case APPLICATIONS:
        setApplications((Applications)newValue);
        return;
      case ACTIVITY_SETS:
        setActivitySets((ActivitySets)newValue);
        return;
      case ACTIVITIES:
        setActivities((Activities)newValue);
        return;
      case TRANSITIONS:
        setTransitions((Transitions)newValue);
        return;
      case EXTENDED_ATTRIBUTES:
        setExtendedAttributes((ExtendedAttributes)newValue);
        return;
      case ID:
        setId((String)newValue);
        return;
      case NAME:
        setName((String)newValue);
        return;
      case ACCESS_LEVEL:
        setAccessLevel((String)newValue);
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
      case PROCESS_HEADER:
        unsetProcessHeader();
        return;
      case REDEFINABLE_HEADER:
        unsetRedefinableHeader();
        return;
      case FORMAL_PARAMETERS:
        unsetFormalParameters();
        return;
      case DATA_FIELDS:
        unsetDataFields();
        return;
      case PARTICIPANTS:
        unsetParticipants();
        return;
      case APPLICATIONS:
        unsetApplications();
        return;
      case ACTIVITY_SETS:
        unsetActivitySets();
        return;
      case ACTIVITIES:
        unsetActivities();
        return;
      case TRANSITIONS:
        unsetTransitions();
        return;
      case EXTENDED_ATTRIBUTES:
        unsetExtendedAttributes();
        return;
      case ID:
        unsetId();
        return;
      case NAME:
        unsetName();
        return;
      case ACCESS_LEVEL:
        unsetAccessLevel();
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
      case PROCESS_HEADER:
        return isSetProcessHeader();
      case REDEFINABLE_HEADER:
        return isSetRedefinableHeader();
      case FORMAL_PARAMETERS:
        return isSetFormalParameters();
      case DATA_FIELDS:
        return isSetDataFields();
      case PARTICIPANTS:
        return isSetParticipants();
      case APPLICATIONS:
        return isSetApplications();
      case ACTIVITY_SETS:
        return isSetActivitySets();
      case ACTIVITIES:
        return isSetActivities();
      case TRANSITIONS:
        return isSetTransitions();
      case EXTENDED_ATTRIBUTES:
        return isSetExtendedAttributes();
      case ID:
        return isSetId();
      case NAME:
        return isSetName();
      case ACCESS_LEVEL:
        return isSetAccessLevel();
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
    result.append(" (Id: ");
    if (id_set_) result.append(id); else result.append("<unset>");
    result.append(", Name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", AccessLevel: ");
    if (accessLevel_set_) result.append(accessLevel); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //WorkflowProcessImpl
