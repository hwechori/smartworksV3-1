package net.smartworks.server.engine.resource.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.model.SmartServerConstant;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.resource.dao.IDomainDdlDao;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.DBDomainConstant;
import net.smartworks.server.engine.resource.model.IDBDomain;
import net.smartworks.server.engine.resource.model.IDBDomainField;
import net.smartworks.server.engine.resource.model.IFormContent;
import net.smartworks.server.engine.resource.model.IFormDef;
import net.smartworks.server.engine.resource.model.IFormFieldDef;
import net.smartworks.server.engine.resource.model.IFormModel;
import net.smartworks.server.engine.resource.model.hb.HbDBDomain;
import net.smartworks.server.engine.resource.model.hb.HbDBDomainField;
import net.smartworks.server.engine.resource.util.DBDomainUtil;
import net.smartworks.server.engine.resource.util.SmartServerModelUtil;
import net.smartworks.server.engine.resource.util.id.IDCreator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.engine.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * IDomainDdlDao 하이버네이트 구현
 * DDL 쿼리를 위해서 OR Mapping을 하기 보다는 navive SQL Query를 사용한다. 
 */
public class HbDomainDdlDaoImpl extends HibernateDaoSupport implements IDomainDdlDao {
	@Autowired
	public void anyMethod(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	private String dbType;
	public void deleteDomain(String formId, int formVersion) {
		// 1. 도메인 관리 정보 찾기
		Session session = this.getSession();
		Query query = session.createQuery("from HbDBDomain where id in (select id from HbDBDomain where formId = '" + formId + "' and formVersion = " + formVersion + " and masterId is null)");
		IDBDomain masterDomain = (IDBDomain)query.uniqueResult();
		
		if(masterDomain == null)
			return;
		
		// 2. 도메인 관리 정보 삭제		
		query = session.createQuery("delete HbDBDomainField where domainId in (select id from HbDBDomain where id = '" + masterDomain.getId() + "' or masterId = '" + masterDomain.getId() + "')");
		query.executeUpdate();
		
		query = session.createQuery("delete HbDBDomain where id = '" + masterDomain.getId() + "' or masterId = '" + masterDomain.getId() + "'");
		query.executeUpdate();
		
		// 시스템 도메인이면 그냥 리턴
		if(DBDomainConstant.getSystemFormTableMap().containsKey(formId))
			return;
		
		// 3. 폼이 아직 도메인 정보에 남아 있는지 체크
		boolean lastDomain = false;
		boolean existRecord = true;
		
		query = session.createSQLQuery("select count(*) from SWDomain where formId = '" + formId + "'");
		Object countObj = query.uniqueResult();	
		if(countObj == null || Integer.parseInt(countObj.toString()) < 1)
			lastDomain = true;
		
		// 4. 테이블에 레코드가 남아 있는지 체크하여 하나도 없다면 테이블 삭제 시도
		query = session.createSQLQuery("select count(*) from " + masterDomain.getTblName());
		countObj = query.uniqueResult();
		if(countObj == null || Integer.parseInt(countObj.toString()) < 1)
			existRecord = false;
		
		// 5. 마지막 버전의 도메인이고 테이블에 레코드가 남아 있지 않다면 테이블 삭제
		if(lastDomain && !existRecord) {
			query = session.createSQLQuery("DROP TABLE " + masterDomain.getTblName());
			query.executeUpdate();
			
		// 6. 마지막 버전의 도메인이고 테이블에 레코드가 남았다면 테이블 삭제하지 않고 SWRemovedDomain에 추가
		} else if(lastDomain && existRecord) {
			query = session.createSQLQuery("INSERT INTO SWRemovedDomain (formId, tblName) VALUES ('" + formId + "','" + masterDomain.getTblName() + "')");
			query.executeUpdate();
		}
		
		// 7. 관련 폼으로 등록된 의견 삭제
		query = session.createSQLQuery("delete from SWOpinion where groupId = '" + formId + "'");
		query.executeUpdate();
		
		// 8. 관련 폼으로 등록된 포스트 삭제
		query = session.createSQLQuery("delete from SWPost where refGroupId = '" + formId + "'");
		query.executeUpdate();
		
		// 9. 최근 처리 업무에서 관련 폼으로 등록된 건 삭제
		query = session.createSQLQuery("delete from SWWorkHistory where formId = '" + formId + "'");
		query.executeUpdate();
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.dao.IDomainDdlDao#createDomainByPackage(java.lang.String, int)
	 */
	public void createDomainByPackage(String companyId, String packageId, int version) {
		Session session = this.getSession();
		
		// 단위업무에 대해서만 도메인 데이터를 생성한다.
		String hql = "from HbFormContent where packageId = '" + packageId + "' and version =" + version + " and type = '" + IFormModel.TYPE_SINGLE + "'";
		Query query = session.createQuery(hql);
		List<IFormContent> formList = query.list();
		
		if(formList == null || formList.isEmpty())
			return;
		
		for(IFormContent form : formList) {
			if(form != null) {
				IFormDef formDef = SmartServerModelUtil.xmlToForm(form.getContent());
				this.createDomain(companyId, formDef);
			}
		}
	}
	/**
	 * 도메인 필드 아이디를 생성한다.
	 * 
	 * @return
	 */
	protected String getDomainFieldId() {
		return IDCreator.createId(DBDomainConstant.PREFIX_DOMAINFIELDID);
	}
	protected String getMasterDomainId() {
		return IDCreator.createId(DBDomainConstant.PREFIX_MASTERDOMAINID);
	}
	/**
	 * domainId로 디테일 도메인 리스트를 조회
	 * 
	 * @param domainId
	 * @return
	 */
	private List<IDBDomain> getDetailDomainList(String domainId) {
		String sql = "from HbDBDomain where masterId = '" + domainId + "'";
		Query query = this.getSession().createQuery(sql);
		return query.list();
	}
	/**
	 * formId로 최신 버전의 도메인을 조회
	 * 
	 * @param formId
	 */
	private IDBDomain getLatestMasterDomain(String formId) {
		String sql = "from HbDBDomain where formId = '" + formId + "' and masterId is null and formVersion = (select max(formVersion) from HbDBDomain where formId = '" + formId + "' and masterId is null)";
		Query query = this.getSession().createQuery(sql);
		Object obj = query.uniqueResult();
		return (IDBDomain)obj;
	}
	/**
	 * formId로 RemovedDomain 테이블에서 테이블 이름을 찾는다.
	 * 
	 * @param formId
	 * @return
	 */
	private String getTableFromRemovedDomain(String formId) {
		Query query = this.getSession().createSQLQuery("select tblName from SWRemovedDomain where formId = '" + formId + "'");
		Object tblObj = query.uniqueResult();
		return tblObj == null ? null : (String)tblObj;
	}
	/**
	 * 도메인 데이터 테이블 이름을 생성하여 리턴한다.
	 * 
	 * @return
	 */
	protected String getTableName() {
		//return IDCreator.createId(DBDomainConstant.PREFIX_TABLENAME);
		return IDCreator.createShortId(DBDomainConstant.PREFIX_TABLENAME);
	}
	/**
	 * 시스템 도메인을 생성
	 * 
	 * @param formDef
	 * @param masterDomain
	 * @param latestDomain
	 * @param latestDetailDomainList
	 * @param domainList
	 */
	private void createSystemDomain(IFormDef formDef, IDBDomain masterDomain, IDBDomain latestDomain, List<IDBDomain> latestDetailDomainList, List<IDBDomain> domainList) {
		int dispOrder = 1;
		masterDomain.setSystemDomainYn(SmartServerConstant.YES_NO_Y_VALUE);
		String titleFieldId = latestDomain != null ? (latestDomain.getTitleFieldId()) : null;
		String systemTableName = (formDef.getSystemName() != null && formDef.getSystemName().trim().length() > 1) ? formDef.getSystemName() : DBDomainConstant.getSystemFormTableMap().get(formDef.getId());
		masterDomain.setTblName(systemTableName);
		
		// 1. 마스터 도메인 필드 생성
		Iterator<IFormFieldDef> fields = formDef.getFormFieldMap().values().iterator();
		while(fields.hasNext()) {
			IFormFieldDef field = fields.next();
			
			// 첫번째 필드를 일단 타이틀 필드로 잡는다.
			if(dispOrder == 1 && titleFieldId == null)
				titleFieldId = field.getId();
			
			// 필드 이름이 제목이나 title이라면 도메인의 타이틀 필드 아이디로 설정한다.
			if(("제목".equals(field.getName()) || "title".equals(field.getName().toLowerCase())) && (latestDomain == null))
				titleFieldId = field.getId();
			
			IDBDomainField masterField = new HbDBDomainField();
			masterField.setId(this.getDomainFieldId());
			masterField.setDomainId(masterDomain.getId());
			masterField.setFormFieldId(field.getId());
			masterField.setFormFieldName(field.getName());
			masterField.setFormFieldType(field.getType());
			masterField.setDispOrder(dispOrder < 7 ? dispOrder : -1);
			masterField.setArrayYn(field.isArray() ? SmartServerConstant.YES_NO_Y_VALUE : SmartServerConstant.YES_NO_N_VALUE);
			
			// 참조 폼, 폼 필드 아이디
			if(field.getRefForm() != null && !field.getRefForm().equals(""))
				masterField.setFormFieldPath(field.getRefForm() + "." + field.getRefFormField());
			
			// 시스템 필드 라면
			if(field.isSystem()) {
				masterField.setSystemFieldYn(SmartServerConstant.YES_NO_Y_VALUE);
				// 폼 필드의 타이틀이 테이블 칼럼 이름이다.
				masterField.setTableColName(field.getSystemName());
				
			// 일반 필드라면
			} else {				
				masterField.setTableColName(DBDomainUtil.createColumnNameByFormField(field.getId()));
				masterField.setSystemFieldYn(SmartServerConstant.YES_NO_N_VALUE);				
			}

			masterDomain.addFormField(masterField);
			
			dispOrder++;
		}
		
		masterDomain.setTitleFieldId(titleFieldId);
	}
	/**
	 * 일반적인 도메인을 생성
	 * 
	 * @param formDef
	 * @param masterDomain
	 * @param latestDomain
	 * @param latestDetailDomainList
	 * @param domainList
	 */
	private void createBasicDomain(IFormDef formDef, IDBDomain masterDomain, IDBDomain latestDomain, List<IDBDomain> latestDetailDomainList, List<IDBDomain> domainList) {
		int dispOrder = 1;
		String titleFieldId = latestDomain != null ? (latestDomain.getTitleFieldId()) : null;
		
		// 1. 마스터 도메인 필드 생성
		Iterator<IFormFieldDef> fields = formDef.getFormFieldMap().values().iterator();
		while(fields.hasNext()) {
			IFormFieldDef field = fields.next();
			
			// 첫번째 필드를 일단 타이틀 필드로 잡는다.
			if(dispOrder == 1 && titleFieldId == null)
				titleFieldId = field.getId();
			
			// 필드 이름이 제목이나 title이라면 도메인의 타이틀 필드 아이디로 설정한다.
			if(("제목".equals(field.getName()) || "title".equals(field.getName().toLowerCase())) && (latestDomain == null))
				titleFieldId = field.getId();
			
			IDBDomainField masterField = new HbDBDomainField();
			masterField.setId(this.getDomainFieldId());
			masterField.setDomainId(masterDomain.getId());
			masterField.setFormFieldId(field.getId());
			masterField.setFormFieldName(field.getName());
			masterField.setFormFieldType(field.getType());
			masterField.setDispOrder(dispOrder < 7 ? dispOrder : -1);
			
			// 참조 폼, 폼 필드 아이디
			if(field.getRefForm() != null && !field.getRefForm().equals(""))
				masterField.setFormFieldPath(field.getRefForm() + "." + field.getRefFormField());
			
			masterField.setTableColName(DBDomainUtil.createColumnNameByFormField(field.getId()));
			masterField.setArrayYn(field.isArray() ? SmartServerConstant.YES_NO_Y_VALUE : SmartServerConstant.YES_NO_N_VALUE);
			masterField.setSystemFieldYn(field.isSystem() ? SmartServerConstant.YES_NO_Y_VALUE : SmartServerConstant.YES_NO_N_VALUE);
			masterDomain.addFormField(masterField);
			
			dispOrder++;
		}
		
		masterDomain.setTitleFieldId(titleFieldId);
	}	
	private int toColumnType(String fieldType) {
		if (this.getDbType().equalsIgnoreCase("sqlserver")) {
			if (IFormFieldDef.TYPE_STRING.equals(fieldType)) {
				return Types.VARCHAR;
			} else if(IFormFieldDef.TYPE_NUMBER.equals(fieldType)) {
				return Types.DOUBLE;
			} else if(IFormFieldDef.TYPE_DATETIME.equals(fieldType)) {
				return Types.TIMESTAMP;
			} else if(IFormFieldDef.TYPE_BOOLEAN.equals(fieldType)) {
				return Types.BOOLEAN;
			} else if(IFormFieldDef.TYPE_TIME.equals(fieldType)) {		
				return Types.TIMESTAMP;
			} else if(IFormFieldDef.TYPE_TEXT.equals(fieldType)) {
				return Types.CLOB;
			} else if (IFormFieldDef.TYPE_COMPLEX.equals(fieldType)) {
				return Types.CLOB;
			} else {
				return Types.VARCHAR;
			}
		} else {
			if (IFormFieldDef.TYPE_STRING.equals(fieldType)) {
				return Types.VARCHAR;
			} else if(IFormFieldDef.TYPE_NUMBER.equals(fieldType)) {
				return Types.DOUBLE;
			} else if(IFormFieldDef.TYPE_DATETIME.equals(fieldType)) {
				return Types.TIMESTAMP;
			} else if(IFormFieldDef.TYPE_BOOLEAN.equals(fieldType)) {
				return Types.BOOLEAN;
			} else if(IFormFieldDef.TYPE_TIME.equals(fieldType)) {
				return Types.TIME;
			} else if(IFormFieldDef.TYPE_TEXT.equals(fieldType)) {
				return Types.CLOB;
			} else if (IFormFieldDef.TYPE_COMPLEX.equals(fieldType)) {
				return Types.CLOB;
			} else {
				return Types.VARCHAR;
			}
		}
	}
	/**
	 * 테이블 변경
	 * 
	 * @param domain
	 */
	public void alterTable(IDBDomain domain) {
		// 도메인의 테이블 이름으로 테이블 컬럼 메타 데이터를 쿼리하여 비교한다.
		List<String> tableFieldList = new ArrayList<String>();
		Map<String, Integer> tableFieldTypeMap = new HashMap<String, Integer>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			conn = super.getSession().connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from " + domain.getTblName() + " where id is null");
			rsmd = rs.getMetaData();
			
			for(int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
				String columnName = rsmd.getColumnName(i).toLowerCase();
				tableFieldList.add(columnName);
				tableFieldTypeMap.put(columnName, rsmd.getColumnType(i));
			}
			
		} catch (Throwable th) {
			throw new SmartServerRuntimeException("Failed to get table [" + domain.getTblName() + "] metadata!", th);
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		// 새로 추가된 필드 리스트 컨테이너
		List<IDBDomainField> addFieldList = new ArrayList<IDBDomainField>();
		List<IDBDomainField> alterFieldList = new ArrayList<IDBDomainField>();
		Iterator<IDBDomainField> fieldItr = domain.getDomainFieldMap().values().iterator();
		
		// 기존 도메인에 없는 새로 추가된 필드 리스트를 찾는다.
		while(fieldItr.hasNext()) {
			IDBDomainField dField = fieldItr.next();
			
			// 시스템 필드는 제외
			if(SmartServerConstant.YES_NO_Y_VALUE.equals(dField.getSystemFieldYn()))
				continue;
			
			String columnName = dField.getTableColName().toLowerCase();
			if(!tableFieldList.contains(columnName)) {
				addFieldList.add(dField);
			} else {
				if (toColumnType(dField.getFormFieldType()) != tableFieldTypeMap.get(dField.getTableColName())) {
					alterFieldList.add(dField);
				}
			}
		}
		
		String tblName = domain.getTblName();
		
		// 테이블에 새로 추가된 필드를 추가한다.
		if (!CommonUtil.isEmpty(addFieldList)) {
			for(IDBDomainField f : addFieldList)
				this.alterTableAddColumn(tblName, f.getTableColName(), this.findTableColumnType(f.getFormFieldType()));
		}
		
		// 테이블에 타입이 수정된 필드를 수정한다.
		if (!CommonUtil.isEmpty(alterFieldList)) {
			for (IDBDomainField f : alterFieldList) {
				try {
					this.alterTableAlterColumn(tblName, f.getTableColName(), this.findTableColumnType(f.getFormFieldType()));
				} catch (Exception e) {
					logger.warn(e, e);
				}
			}
		}
	}
	private void alterTableAlterColumn(String tableName, String columnName, String columnType) {
		if (this.getDbType().equalsIgnoreCase("sqlserver")) {
			StringBuffer buf = new StringBuffer("alter table ").append(tableName).append(" alter column ").append(columnName).append(" ").append(columnType);
			Query query = this.getSession().createSQLQuery(buf.toString());
			query.executeUpdate();
		} else {
			StringBuffer buf = new StringBuffer("alter table ").append(tableName).append(" alter ").append(columnName).append(" type ").append(columnType);
			Query query = this.getSession().createSQLQuery(buf.toString());
			query.executeUpdate();
		}
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.dao.IDomainDdlDao#alterTableAddColumn(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void alterTableAddColumn(String tableName, String columnName, String columnType) {
		StringBuffer buf = new StringBuffer("alter table ").append(tableName).append(" add ").append(columnName).append(" ").append(columnType);
		Query query = this.getSession().createSQLQuery(buf.toString());
		query.executeUpdate();
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.dao.IDomainDdlDao#createDomain(com.maninsoft.smart.domain.db.model.IDBDomain)
	 */
	public void createDomain(IDBDomain domain) {
		// 제거된 도메인이 존재하는지 여부
		boolean existRemovedDomain = false;
		
		// 테이블 이름이 설정되지 않았다면 마스터 도메인이고 SWRemovedDomain에서 일단 찾는다. TODO 디테일 테이블도 제거된 도메인 체크
		if(domain.getTblName() == null) {
			String oldTblName = this.getTableFromRemovedDomain(domain.getFormId());
			domain.setTblName(oldTblName == null ? this.getTableName() : oldTblName);
			existRemovedDomain = (oldTblName != null);
		}

		HibernateTemplate ht = this.getHibernateTemplate();
		
		// 1. 도메인 관리 정보 생성
		ht.save(domain);
		
		// 2. 도메인 필드 정보 생성
		if(domain.getDomainFieldMap() != null && !domain.getDomainFieldMap().isEmpty())
			ht.saveOrUpdateAll(domain.getDomainFieldMap().values());
		
		// 3. 시스템 도메인이라면 무조건 alter table
		if(DBDomainConstant.getSystemFormTableMap().containsKey(domain.getFormId())) {
			this.alterTable(domain);
		
		// 4. 일반 도메인이라면 ...
		} else {		
			// 4.1 제거된 도메인이 존재한다면 레코드 삭제
			if(existRemovedDomain) {
				this.alterTable(domain);
				Query query = this.getSession().createSQLQuery("delete from SWRemovedDomain where formId = '" + domain.getFormId() + "'");
				query.executeUpdate();
				
			// 4.2 제거된 도메인이 존재하지 않는다면 도메인에서 정보가 존재하면 alter, 없다면 create table
			} else {
				Query query = this.getSession().createSQLQuery("select count(*) from SWDomain where formId = '" + domain.getFormId() + "' and formVersion != " + domain.getFormVersion());
				Object countStr = query.uniqueResult();
				int count = Integer.parseInt(countStr.toString());
				
				if(count > 0)
					// 테이블 이미 존재 - 변경
					this.alterTable(domain);
				else
					// 실제 테이블 생성
					this.createTable(domain);
			}
		}
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.dao.IDomainDdlDao#createTable(com.maninsoft.smart.domain.db.model.IDBDomain)
	 */
	public void createTable(IDBDomain domain) {
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE ");
		sb.append(domain.getTblName());
		sb.append(" (");
		
		if (this.getDbType().equalsIgnoreCase("sqlserver")) {
			sb.append(DBDomainConstant.COLUMNNAME_RECORDID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_DOMAINID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_WORKITEMID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_MASTERRECORDID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_CREATOR).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_CREATEDTIME).append(" ").append(DBDomainConstant.COLUMNDATATYPE_DATETIME).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_MODIFIER).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_MODIFIEDTIME).append(" ").append(DBDomainConstant.COLUMNDATATYPE_DATETIME).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_WORKSPACEID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_100).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_WORKSPACETYPE).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_ACCESSLEVEL).append(" ").append(DBDomainConstant.COLUMNDATATYPE_1).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_ACCESSVALUE).append(" ").append(DBDomainConstant.COLUMNDATATYPE_4000).append(", ");
			
		} else {
			sb.append(DBDomainConstant.COLUMNNAME_RECORDID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_DOMAINID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_WORKITEMID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_MASTERRECORDID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_CREATOR).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_CREATEDTIME).append(" ").append(DBDomainConstant.COLUMNDATATYPE_TIMESTAMP).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_MODIFIER).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_MODIFIEDTIME).append(" ").append(DBDomainConstant.COLUMNDATATYPE_TIMESTAMP).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_WORKSPACEID).append(" ").append(DBDomainConstant.COLUMNDATATYPE_100).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_WORKSPACETYPE).append(" ").append(DBDomainConstant.COLUMNDATATYPE_ID).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_ACCESSLEVEL).append(" ").append(DBDomainConstant.COLUMNDATATYPE_1).append(", ");
			sb.append(DBDomainConstant.COLUMNNAME_ACCESSVALUE).append(" ").append(DBDomainConstant.COLUMNDATATYPE_4000).append(", ");
		}
		
		for (Iterator<IDBDomainField> fieldItr = domain.getDomainFieldMap().values().iterator(); fieldItr.hasNext();) {
			IDBDomainField field = fieldItr.next();
			String tableColumnName = field.getTableColName();
			sb.append(tableColumnName);
			sb.append(" ");
			sb.append(findTableColumnType(field.getFormFieldType()));
			sb.append(",");
		}
		
		sb.append(" primary key(").append(DBDomainConstant.COLUMNNAME_RECORDID).append("))");		
		Query query = this.getSession().createSQLQuery(sb.toString());
		query.executeUpdate();
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.dao.IDomainDdlDao#createDomain(com.maninsoft.smart.server.model.IFormDef)
	 */	
	public void createDomain(String companyId, IFormDef formDef) {
		// 0. 컨테이너 준비
		List<IDBDomain> domainList = new ArrayList<IDBDomain>();
		
		// 1. 마스터 도메인 생성
		IDBDomain masterDomain = new HbDBDomain();
		masterDomain.setFormId(formDef.getId());
		masterDomain.setFormVersion(formDef.getVersion());
		masterDomain.setFormName(formDef.getName());
		masterDomain.setId(this.getMasterDomainId());
		masterDomain.setKeyColumn(DBDomainConstant.COLUMNNAME_RECORDID);
		masterDomain.setTblOwner("");
		masterDomain.setCompanyId(companyId);
		domainList.add(masterDomain);
		
		// 2. formId로 도메인을 찾아서 있다면 같은 이름으로 추가, 없다면 생성
		IDBDomain latestDomain = this.getLatestMasterDomain(formDef.getId());
		if(latestDomain != null)
			masterDomain.setTblName(latestDomain.getTblName());
		
		List<IDBDomain> latestDetailDomainList = null;
		
		// 3. 이미 도메인이 존재한다면 마스터 도메인으로 모든 디테일 도메인을 조회
		if(latestDomain != null) {
			masterDomain.setSystemDomainYn(latestDomain.getSystemDomainYn());
			latestDetailDomainList = this.getDetailDomainList(latestDomain.getId());
		}
		
		// 4. 시스템 도메인이라면
		if(DBDomainConstant.getSystemFormTableMap().containsKey(formDef.getId()))
			this.createSystemDomain(formDef, masterDomain, latestDomain, latestDetailDomainList, domainList);
		// 4. 일반  도메인이라면
		else
			this.createBasicDomain(formDef, masterDomain, latestDomain, latestDetailDomainList, domainList);
		
		// 5. 도메인 데이터 관리 테이블 생성
		if(domainList.size() <= 1)
			this.createDomain(masterDomain);
		else
			this.createDomain(domainList);
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.dao.IDomainDdlDao#createDomain(java.util.List)
	 */
	public void createDomain(List<IDBDomain> domainList) {
		for(IDBDomain domain : domainList)
			this.createDomain(domain);
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.dao.IDomainDdlDao#deleteDomainByPackage(java.lang.String, int)
	 */
	public void deleteDomainByPackage(String packageId, int version) {
		// 단위업무에 대해서만 도메인 데이터를 생성하므로 단위업무에 대해서만 삭제한다.
		String hql = "select distinct formId from SWForm where packageId = '" + packageId + "' and version = " + version + " and type = '" + IFormModel.TYPE_SINGLE + "'";
		Query query = this.getSession().createSQLQuery(hql);
		List<String> formIdList = query.list();
		
		if(formIdList != null) {
			for(String formId : formIdList)
				this.deleteDomain(formId, version);
		}
	}

	/**
	 * 필드 타입에 매핑되는 테이블의 칼럼 타입을 찾아 리턴한다.
	 * 
	 * @param fieldType
	 * @return
	 */
	public String findTableColumnType(String fieldType) {
		if (this.getDbType().equalsIgnoreCase("sqlserver")) {
			if (IFormFieldDef.TYPE_STRING.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_STRING;
			} else if(IFormFieldDef.TYPE_NUMBER.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_NUMBER;
			} else if(IFormFieldDef.TYPE_DATETIME.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_DATETIME;
			} else if(IFormFieldDef.TYPE_BOOLEAN.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_BIT;
			} else if(IFormFieldDef.TYPE_TIME.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_DATETIME;
			} else if(IFormFieldDef.TYPE_TEXT.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_TEXT;
			} else if (IFormFieldDef.TYPE_COMPLEX.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_TEXT;
			} else {
				return DBDomainConstant.COLUMNDATATYPE_DEFAULT;
			}
		} else {
			if (IFormFieldDef.TYPE_STRING.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_STRING;
			} else if(IFormFieldDef.TYPE_NUMBER.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_NUMBER;
			} else if(IFormFieldDef.TYPE_DATETIME.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_TIMESTAMP;
			} else if(IFormFieldDef.TYPE_BOOLEAN.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_BOOLEAN;
			} else if(IFormFieldDef.TYPE_TIME.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_TIME;
			} else if(IFormFieldDef.TYPE_TEXT.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_TEXT;
			} else if (IFormFieldDef.TYPE_COMPLEX.equals(fieldType)) {
				return IDBDomainField.COLUMN_TYPE_TEXT;
			} else {
				return DBDomainConstant.COLUMNDATATYPE_DEFAULT;
			}
		}
	}
	public String getDbType() {
		if (dbType == null) {
			SessionFactory sf = getSessionFactory();
			SessionFactoryImplementor sfi = (SessionFactoryImplementor)sf;
			Dialect dialect = sfi.getDialect();
			if (dialect instanceof PostgreSQLDialect) {
				dbType = "postgresql";
			} else if (dialect instanceof SQLServerDialect) {
				dbType = "sqlserver";
			} else {
				dbType = "oracle";
			}
		}
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
}
