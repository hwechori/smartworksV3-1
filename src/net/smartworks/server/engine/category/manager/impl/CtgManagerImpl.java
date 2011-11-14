package net.smartworks.server.engine.category.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.category.exception.CtgException;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.category.model.CtgCategoryCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;

import org.hibernate.Query;

public class CtgManagerImpl extends AbstractManager implements ICtgManager {
	
	public CtgManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}
	
	public CtgCategory getCategory(String user, String objId, String level) throws CtgException {
		if (level == null)
			level = LEVEL_ALL;
		if (level.equals(LEVEL_ALL)) {
			try {
				CtgCategory obj = (CtgCategory)get(CtgCategory.class, objId);
				return obj;
			} catch (Exception e) {
				throw new CtgException(e);
			}
		} else {
			CtgCategoryCond cond = new CtgCategoryCond();
			cond.setObjId(objId);
			CtgCategory[] objs = this.getCategorys(user, cond, level);
			if (CommonUtil.isEmpty(objs))
				return null;
			return objs[0];
		}
	}

	public CtgCategory getCategory(String user, CtgCategoryCond cond, String level) throws CtgException {
		if (cond == null)
			return null;
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		CtgCategory[] categorys = getCategorys(user, cond, level);
		if (CommonUtil.isEmpty(categorys))
			return null;
		if (categorys.length > 1)
			throw new CtgException("More than 1 category.");
		return categorys[0];
	}

	public CtgCategory setCategory(String user, CtgCategory obj, String level) throws CtgException {
		try {
			fill(user, obj);
			set(obj);
			return obj;
		} catch (Exception e) {
			throw new CtgException(e);
		}
	}

	public CtgCategory createCategory(String userId, CtgCategory obj) throws CtgException {
		try {
			fill(userId, obj);
			create(obj);
			return obj;
		} catch (Exception e) {
			logger.error(e, e);
			throw new CtgException(e);
		}
	}
	public void removeCategory(String user, String objId) throws CtgException {
		try {
			remove(CtgCategory.class, objId);
		} catch (Exception e) {
			throw new CtgException(e);
		}
	}
	
	private Query appendQuery(StringBuffer buf, CtgCategoryCond cond) throws Exception {
		String objId = null;
		String companyId = null;
		String parentId = null;
		String name = null;
		String nameLike = null;
		int displayOrder = -1;
		Filter[] filters = null;
		String logicalOperator = null;
		Property[] extProps = null;
		String[] objIdNotIns = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			companyId = cond.getCompanyId();
			parentId = cond.getParentId();
			name = cond.getName();
			nameLike = cond.getNameLike();
			displayOrder = cond.getDisplayOrder();
			filters = cond.getFilter();
			logicalOperator = cond.getOperator();
			extProps = cond.getExtendedProperties();
			objIdNotIns = cond.getObjIdNotIns();
		}
		buf.append(" from CtgCategory obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		Map filterMap = new HashMap();
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (parentId != null)
				buf.append(" and obj.parentId = :parentId");
			if (name != null)
				buf.append(" and obj.name = :name");
			if (nameLike != null)
				buf.append(" and obj.name like :nameLike");
			if (displayOrder != -1)
				buf.append(" and obj.displayOrder = :displayOrder");
			if (objIdNotIns != null && objIdNotIns.length != 0) {
				buf.append(" and obj.objId not in (");
				for (int i=0; i<objIdNotIns.length; i++) {
					if( i != 0)
						buf.append(", ");
						buf.append(":objIdNotIn").append(i);
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
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						buf.append(" and extProp").append(i).append(".name = :extName").append(i);
					if (extValue != null)
						buf.append(" and extProp").append(i).append(".value = :extValue").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (companyId != null)
				query.setString("companyId", companyId);
			if (parentId != null)
				query.setString("parentId", parentId);
			if (name != null)
				query.setString("name", name);
			if (nameLike != null)
				query.setString("nameLike", CommonUtil.toLikeString(nameLike));
			if (displayOrder != -1)
				query.setInteger("displayOrder", displayOrder);
			if (objIdNotIns != null && objIdNotIns.length !=0) {
				for (int i=0; i<objIdNotIns.length; i++) {
					query.setString("objIdNotIn"+i, objIdNotIns[i]);
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
			if (extProps != null && extProps.length != 0) {
				for (int i=0; i<extProps.length; i++) {
					Property extProp = extProps[i];
					String extName = extProp.getName();
					String extValue = extProp.getValue();
					if (extName != null)
						query.setString("extName"+i, extName);
					if (extValue != null)
						query.setString("extValue"+i, extValue);
				}
			}
		}
		return query;
	}

	public long getCategorySize(String user, CtgCategoryCond cond) throws CtgException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			throw new CtgException(e);
		}
	}

	public CtgCategory[] getCategorys(String user, CtgCategoryCond cond, String level) throws CtgException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.companyId, obj.parentId"); 
				buf.append(", obj.name, obj.displayOrder, obj.description"); 
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					CtgCategory obj = new CtgCategory();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setParentId(((String)fields[j++]));
					obj.setName((String)fields[j++]);
					obj.setDisplayOrder((Integer)fields[j++]);
					obj.setDescription(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			CtgCategory[] objs = new CtgCategory[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new CtgException(e);
		}
	}
}
