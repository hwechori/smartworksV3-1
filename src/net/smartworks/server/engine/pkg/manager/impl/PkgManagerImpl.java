package net.smartworks.server.engine.pkg.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.pkg.exception.SwpException;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;

import org.hibernate.Query;

public class PkgManagerImpl extends AbstractManager implements IPkgManager {

	public PkgManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	
	public PkgPackage getPackage(String userId, String objId, String level) throws SwpException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				PkgPackage obj = (PkgPackage)this.get(PkgPackage.class, objId);
				return obj;
			} else {
				PkgPackageCond cond = new PkgPackageCond();
				cond.setObjId(objId);
				return getPackage(userId, cond, level);
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwpException(e);
		}
	}
	public PkgPackage getPackage(String userId, PkgPackageCond cond, String level) throws SwpException {
		if (level == null)
			level = LEVEL_ALL;
			cond.setPageSize(2);
			PkgPackage[] packages = getPackages(userId, cond, level);
			if (CommonUtil.isEmpty(packages))
				return null;
			try {
				if (packages.length != 1)
					throw new SwpException("More than 1 Object");
			} catch (SwpException e) {
				logger.error(e, e);
				throw e;
			}
			return packages[0];
	}
	public void setPackage(String userId, PkgPackage obj, String level) throws SwpException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(userId, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update PkgPackage set");
				buf.append(" packageId=:packageId, version=:version, latestDeployedYn=:latestDeployedYn,");
				buf.append(" categoryId=:categoryId, type=:type,");
				buf.append(" creationUser=:creationUser, creationDate=:creationDate,");
				buf.append(" modificationUser=:modificationUser, modificationDate=:modificationDate");
				buf.append(" where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(PkgPackage.A_PACKAGEID, obj.getPackageId());
				query.setInteger(PkgPackage.A_VERSION, obj.getVersion());
				query.setString(PkgPackage.A_LATESTDEPLOYEDYN, obj.getLatestDeployedYn());
				query.setString(PkgPackage.A_CATEGORYID, obj.getCategoryId());
				query.setString(PkgPackage.A_TYPE, obj.getType());
				query.setString(PkgPackage.A_CREATIONUSER, obj.getCreationUser());
				query.setTimestamp(PkgPackage.A_CREATIONDATE, obj.getCreationDate());
				query.setString(PkgPackage.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(PkgPackage.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(PkgPackage.A_OBJID, obj.getObjId());
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwpException(e);
		}
	}
	public void createPackage(String userId, PkgPackage obj) throws SwpException {
		try {
			fill(userId, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwpException(e);
		}
	}
	public void removePackage(String userId, String objId) throws SwpException {
		try {
			remove(PkgPackage.class, objId);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwpException(e);
		}
	}
	public void removePackage(String userId, PkgPackageCond cond) throws SwpException {
		PkgPackage obj = getPackage(userId, cond, null);
		if (obj == null)
			return;
		removePackage(userId, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, PkgPackageCond cond) throws Exception {
		String objId = null;
		String name = null;
		String nameLike = null;
		String packageId = null;
		String status = null;
		int version = -1;
		String latestDeployedYn = null;
		String categoryId = null;
		String type = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		Filter[] filters = null;
		String[] statusIns = null;
		String[] categoryIdIns = null;
		String[] packageIdIns = null;
		String logicalOperator = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			name = cond.getName();
			nameLike = cond.getNameLike();
			packageId = cond.getPackageId();
			status = cond.getStatus();
			version = cond.getVersion();
			latestDeployedYn = cond.getLatestDeployedYn();
			categoryId = cond.getCategoryId();
			type = cond.getType();
			creationUser = cond.getCreationUser();
			creationDate = cond.getCreationDate();
			modificationUser = cond.getModificationUser();
			modificationDate = cond.getModificationDate();
			filters = cond.getFilter();
			statusIns = cond.getStatusIns();
			categoryIdIns = cond.getCategoryIdIns();
			packageIdIns = cond.getPackageIdIns();
			logicalOperator = cond.getOperator();
		}
		buf.append(" from PkgPackage obj");
		buf.append(" where obj.objId is not null");
		Map filterMap = new HashMap();
		//TODO 시간 검색에 대한 확인 필요
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (name != null)
				buf.append(" and obj.name = :name");
			if (nameLike != null)
				buf.append(" and obj.name like :nameLike");
			if (packageId != null)
				buf.append(" and obj.packageId = :packageId");
			if (status != null)
				buf.append(" and obj.status = :status");
			if (version > 0)
				buf.append(" and obj.version = :version");
			if (latestDeployedYn != null)
				buf.append(" and obj.latestDeployedYn = :latestDeployedYn");
			if (categoryId != null)
				buf.append(" and obj.categoryId = :categoryId");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (creationDate != null)
				buf.append(" and obj.creationDate = :creationDate");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (modificationDate != null)
				buf.append(" and obj.modificationDate = :modificationDate");
			if (statusIns != null && statusIns.length != 0) {
				buf.append(" and obj.status in (");
				for (int i=0; i<statusIns.length; i++) {
					if (i != 0)
						buf.append(", ");
					buf.append(":statusIn").append(i);
				}
				buf.append(")");
			}
			if (categoryIdIns != null && categoryIdIns.length != 0) {
				buf.append(" and obj.categoryId in (");
				for (int i=0; i<categoryIdIns.length; i++) {
					if (i != 0)
						buf.append(", ");
					buf.append(":categoryIdIn").append(i);
				}
				buf.append(")");
			}

			if (packageIdIns != null && packageIdIns.length != 0) {
				buf.append(" and obj.packageId in (");
				for (int i=0; i<packageIdIns.length; i++) {
					if (i != 0)
						buf.append(", ");
					buf.append(":packageIdIn").append(i);
				}
				buf.append(")");
			}
			if (filters != null) {
				if (!CommonUtil.isEmpty(filters)) {
					if (CommonUtil.isEmpty(logicalOperator))
						logicalOperator = "and";
					String operator;
					String left;
					String right;
					String rightType;
					int i = 0;
					
					for (int j = 0; j < filters.length; j++) {
						Filter f = filters[j];
						operator = f.getOperator();
						left = f.getLeftOperandValue();
						right = f.getRightOperandValue();
						rightType = f.getRightOperandType();
						if (left == null)
							throw new Exception("left operand of filter condition is null.");
						if (operator == null) {
							operator = "=";
						} else {
							operator = operator.trim();
						}
						//left = CommonUtil.toDefault(fieldColumnMap.get(left), left);
						buf.append(CommonUtil.SPACE).append(logicalOperator);
						
						buf.append(CommonUtil.SPACE).append(left);
						if (right == null) {
							if (operator.equals("!=") || 
									(operator.indexOf("=") == -1 && !operator.equalsIgnoreCase("is"))) {
								buf.append(" is not null");
							} else {
								buf.append(" is null");
							}
						} else {
							if (rightType == null || !rightType.equalsIgnoreCase(Filter.OPERANDTYPE_FIELD)) {
								right = "a" + i++;
								filterMap.put(right, f);
							}
							buf.append(CommonUtil.SPACE).append(operator);
							buf.append(CommonUtil.SPACE).append(CommonUtil.COLON).append(right);
						}
					}
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (name != null)
				query.setString("name", name);
			if (nameLike != null)
				query.setString("nameLike", CommonUtil.toLikeString(nameLike));
			if (packageId != null)
				query.setString("packageId", packageId);
			if (status != null)
				query.setString("status", status);
			if (version > 0)
				query.setInteger("version", version);
			if (latestDeployedYn != null)
				query.setString("latestDeployedYn", latestDeployedYn);
			if (categoryId != null)
				query.setString("categoryId", categoryId);
			if (type != null)
				query.setString("type", type);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (creationDate != null)
				query.setTimestamp("creationDate", creationDate);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (modificationDate != null)
				query.setTimestamp("modificationDate", modificationDate);
			if (statusIns != null && statusIns.length != 0) {
				for (int i=0; i<statusIns.length; i++) {
					query.setString("statusIn"+i, statusIns[i]);
				}
			}
			if (categoryIdIns != null && categoryIdIns.length != 0) {
				for (int i=0; i<categoryIdIns.length; i++) {
					query.setString("categoryIdIn"+i, categoryIdIns[i]);
				}
			}
			if (packageIdIns != null && packageIdIns.length != 0) {
				for (int i=0; i<packageIdIns.length; i++) {
					query.setString("packageIdIn"+i, packageIdIns[i]);
				}
			}
			if (filters != null) {
				if (!CommonUtil.isEmpty(filterMap)) {
					Filter f;
					String operType;
					String operValue;
					String operator;
					
					Iterator keyItr = filterMap.keySet().iterator();
					String param = null;
					while (keyItr.hasNext()) {
						param = (String)keyItr.next();
						f = (Filter)filterMap.get(param);
						operType = f.getRightOperandType();
						operator = f.getOperator();
						if (operator.equalsIgnoreCase("like")) {
							operValue = CommonUtil.toLikeString(f.getRightOperandValue());
						} else {
							operValue = f.getRightOperandValue();
						}	
						if (operType == null || operType.equalsIgnoreCase(Filter.OPERANDTYPE_STRING)) {
							query.setString(param, operValue);
						} else if (operType.equalsIgnoreCase(Filter.OPERANDTYPE_INT)) {
							query.setInteger(param, CommonUtil.toInt(operValue));
						} else if (operType.equalsIgnoreCase(Filter.OPERANDTYPE_FLOAT)) {
							query.setFloat(param, CommonUtil.toFloat(operValue));
						} else if (operType.equalsIgnoreCase(Filter.OPERANDTYPE_DATE)) {
							query.setTimestamp(param, DateUtil.toDate(operValue));
						} else if (operType.equalsIgnoreCase("number")) {
							query.setDouble(param, Double.parseDouble(operValue));
						} else if (operType.equalsIgnoreCase("boolean")) {
							query.setBoolean(param, CommonUtil.toBoolean(operValue));
						} else {
							query.setParameter(param, operValue);
						}
					}
				}
			}
		}
		return query;
	}
	public long getPackageSize(String userId, PkgPackageCond cond) throws SwpException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf,cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwpException(e);
		}
	}
	public PkgPackage[] getPackages(String userId, PkgPackageCond cond, String level) throws SwpException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.status");
				buf.append(", obj.creationUser, obj.creationDate, obj.modificationUser, obj.modificationDate");
				buf.append(", obj.packageId, obj.version");
				buf.append(", obj.latestDeployedYn, obj.categoryId, obj.type");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					PkgPackage obj = new PkgPackage();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setStatus((String)fields[j++]);
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Date)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Date)fields[j++]));
					obj.setPackageId(((String)fields[j++]));
					obj.setVersion(CommonUtil.toInt(fields[j++]));
					obj.setLatestDeployedYn(((String)fields[j++]));
					obj.setCategoryId(((String)fields[j++]));
					obj.setType(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			PkgPackage[] objs = new PkgPackage[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwpException(e);
		}
	}
}
