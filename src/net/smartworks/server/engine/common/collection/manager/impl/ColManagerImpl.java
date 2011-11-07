package net.smartworks.server.engine.common.collection.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.collection.exception.ColException;
import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.common.collection.model.ColList;
import net.smartworks.server.engine.common.collection.model.ColListCond;
import net.smartworks.server.engine.common.collection.model.ColMap;
import net.smartworks.server.engine.common.collection.model.ColMapCond;
import net.smartworks.server.engine.common.collection.model.ColValue;
import net.smartworks.server.engine.common.collection.model.ColValueCond;
import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.process.link.model.LnkObject;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

@Service
public class ColManagerImpl extends AbstractManager implements IColManager {
	private static final String BAR = CommonUtil.BAR;
	private static final String PERCENT = CommonUtil.PERCENT;

	public ColManagerImpl() {
		super();
	}
	
	public ColMap getMap(String user, String objId, String level) throws ColException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				ColMap obj = (ColMap)this.get(ColMap.class,objId);
				return obj;
			} else {
				ColMapCond cond = new ColMapCond();
				cond.setObjId(objId);
				ColMap[] objs = this.getMaps(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public ColMap getMap(String user, ColMapCond cond, String level) throws ColException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		ColMap[] objs = getMaps(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		if (objs.length != 1)
			throw new ColException("More than 1 Object");
		return objs[0];
	}
	public void setMap(String user, ColMap obj, String level) throws ColException {
		try {
			fill(user, obj);
			set(obj);	
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void createMap(String user, ColMap obj) throws ColException {
		try {
			fill(user, obj);
			create(obj);
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void removeMap(String user, String objId) throws ColException {
		try {
			ColMap obj = this.getMap(user, objId, null);
			this.getHibernateTemplate().delete(obj);
			this.getHibernateTemplate().flush();
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void removeMap(String user, ColMapCond cond) throws ColException {
		ColMap obj = getMap(user, cond, null);
		if (obj == null)
			return;
		removeMap(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf,ColMapCond cond) throws Exception {
		String objId = null;
		String type = null;
		String fromType = null;
		String fromRef = null;
		String toType = null;
		String toRef = null;
		Property[] extProps = null;
		if(cond != null){
			objId = cond.getObjId();
			type = cond.getType();
			fromType = cond.getFromType();
			fromRef = cond.getFromRef();
			toType = cond.getToType();
			toRef = cond.getToRef();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from LnkMap obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if(cond != null){
			if(objId != null)
				buf.append(" and obj.objId =:objId");
			if(type != null)
				buf.append(" and obj.type =:type");
			if(fromType != null)
				buf.append(" and obj.fromType =:fromType");
			if(fromRef != null)
				buf.append(" and obj.fromRef =:fromRef");
			if(toType != null)
				buf.append(" and obj.toType =:toType");
			if(toRef != null)
				buf.append(" and obj.toRef =:toRef");
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
		this.appendOrderQuery(buf,"obj",cond);
	
		Query query = this.createQuery(buf.toString(),cond);
		if(cond != null){
			if(objId != null)
				query.setString("objId",objId);
			if(type != null)
				query.setString("type",type);
			if(fromType != null)
				query.setString("fromType",fromType);
			if(fromRef != null)
				query.setString("fromRef",fromRef);
			if(toType != null)
				query.setString("toType",toType);
			if(toRef != null)
				query.setString("toRef",toRef);
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
	public long getMapSize(String user, ColMapCond cond) throws ColException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf,cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public ColMap[] getMaps(String user, ColMapCond cond, String level) throws ColException {
		try {
			if (level == null)
			level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.modificationDate, obj.type, obj.fromType, obj.fromRef, obj.toType, obj.toRef");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					ColMap obj = new ColMap();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setType(((String)fields[j++]));
					obj.setFromType(((String)fields[j++]));
					obj.setFromRef(((String)fields[j++]));
					obj.setToType(((String)fields[j++]));
					obj.setToRef(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			ColMap[] objs = new ColMap[list.size()];
			list.toArray(objs);
			return objs;
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	
	public ColValue getValue(String user, String objId, String level) throws ColException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				ColValue obj = (ColValue)get(ColValue.class, objId);
				return obj;
			} else {
				ColValueCond cond = new ColValueCond();
				cond.setObjId(objId);
				ColValue[] objs = this.getValues(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public ColValue getValue(String user, ColValueCond cond, String level) throws ColException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		ColValue[] objs = getValues(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		try {
			if (objs.length != 1)
				throw new ColException("More than 1 Object");
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
		return objs[0];
	}
	public void setValue(String user, ColValue obj, String level) throws ColException {
		try {
			fill(user, obj);
			set(obj);
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void createValue(String user, ColValue obj) throws ColException {
		try {
			fill(user, obj);
			create(obj);
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void removeValue(String user, String objId) throws ColException {
		try {
			remove(ColValue.class, objId);
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void removeValue(String user, ColValueCond cond) throws ColException {
		ColValue obj = getValue(user, cond, null);
		if (obj == null)
			return;
		removeValue(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, ColValueCond cond) throws Exception {
		String objId = null;
		String type = null;
		String ref = null;
		String valueLike = null;
		Date expirationDate = null;
		Date expirationDateTo = null;
		String status = null;
		String[] typeIns = null;
		Property[] extProps = null;
		if(cond != null){
			objId = cond.getObjId();
			type = cond.getType();
			ref = cond.getRef();
			valueLike = cond.getValueLike();
			status = cond.getStatus();
			typeIns = cond.getTypeIns();
			expirationDate = cond.getExpirationDate();
			expirationDateTo = cond.getExpirationDateTo();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from LnkValue obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if(cond != null){
			if (objId != null)
				buf.append(" and obj.objId =:objId");
			if (type != null)
				buf.append(" and obj.type =:type");
			if (ref != null)
				buf.append(" and obj.ref =:ref");
			if (expirationDate != null)
				buf.append(" and obj.expirationDate =:expirationDate");
			if (expirationDateTo != null)
				buf.append(" and obj.expirationDate <=:expirationDateTo");
			if (valueLike != null)
				buf.append(" and obj.value like :valueLike");
			if (status != null)
				buf.append(" and obj.status =:status");
			if (typeIns != null && typeIns.length != 0) {
				buf.append(" and obj.type in (");
				for (int i=0; i<typeIns.length; i++) {
					if (i != 0)
						buf.append(", ");
					buf.append(":typeIn").append(i);
				}
				buf.append(")");
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
		this.appendOrderQuery(buf,"obj",cond);
	
		Query query = this.createQuery(buf.toString(),cond);
		if(cond != null){
			if(objId != null)
				query.setString("objId",objId);
			if(type != null)
				query.setString("type",type);
			if(ref != null)
				query.setString("ref",ref);
			if(expirationDate != null)
				query.setTimestamp("expirationDate",expirationDate);
			if(expirationDateTo != null)
				query.setTimestamp("expirationDateTo",expirationDateTo);
			if(valueLike != null)
				query.setString("valueLike", CommonUtil.toLikeString(valueLike));
			if(status != null)
				query.setString("status", status);
			if (typeIns != null && typeIns.length != 0) {
				for (int i=0; i<typeIns.length; i++) {
					query.setString("typeIn"+i, typeIns[i]);
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
	public long getValueSize(String user, ColValueCond cond) throws ColException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf,cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public ColValue[] getValues(String user, ColValueCond cond, String level) throws ColException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.modificationDate, obj.type, obj.ref, obj.expirationDate, obj.value");
				buf.append(", obj.status, obj.description");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					ColValue obj = new ColValue();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setType(((String)fields[j++]));
					obj.setRef(((String)fields[j++]));
					obj.setExpirationDate(((Timestamp)fields[j++]));
					obj.setValue(((String)fields[j++]));
					obj.setStatus(((String)fields[j++]));
					obj.setDescription(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			ColValue[] objs = new ColValue[list.size()];
			list.toArray(objs);
			return objs;
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}

	public ColList getList(String user, String objId, String level) throws ColException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				ColList obj = (ColList)get(ColList.class, objId);
				return obj;
			} else {
				ColListCond cond = new ColListCond();
				cond.setObjId(objId);
				ColList[] objs = this.getLists(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public ColList getList(String user, ColListCond cond, String level) throws ColException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		ColList[] objs = getLists(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		try {
			if (objs.length != 1)
				throw new ColException("More than 1 Object");
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
		return objs[0];
	}
	public void setList(String user, ColList obj, String level) throws ColException {
		try {
			fill(user, obj);
			set(obj);
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void createList(String user, ColList obj) throws ColException {
		try {
			fill(user, obj);
			create(obj);
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void removeList(String user, String objId) throws ColException {
		try {
			remove(ColList.class, objId);
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public void removeList(String user, ColListCond cond) throws ColException {
		ColList obj = getList(user, cond, null);
		if (obj == null)
			return;
		removeList(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, ColListCond cond) throws Exception {
		String objId = null;
		String creationUser = null;
		String modificationUser = null;
		String correlation = null;
		String type = null;
		String typeLike = null;
		String status = null;
		LnkObject[] lnkObjects = null;
		if(cond != null){
			objId = cond.getObjId();
			creationUser = cond.getCreationUser();
			modificationUser = cond.getModificationUser();
			correlation = cond.getCorrelation();
			type = cond.getType();
			typeLike = cond.getTypeLike();
			status = cond.getStatus();
			lnkObjects = cond.getItems();
		}
		buf.append(" from LnkList obj");
		if (lnkObjects != null && lnkObjects.length != 0) {
			for (int i=0; i<lnkObjects.length; i++) {
				buf.append(" left join obj.items as item").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if(cond != null){
			if(objId != null)
				buf.append(" and obj.objId =:objId");
			if(creationUser != null)
				buf.append(" and obj.creationUser =:creationUser");
			if(modificationUser != null)
				buf.append(" and obj.modificationUser =:modificationUser");
			if(correlation != null)
				buf.append(" and obj.correlation =:correlation");
			if(type != null)
				buf.append(" and obj.type =:type");
			if(typeLike != null)
				buf.append(" and obj.type like :typeLike");
			if(status != null)
				buf.append(" and obj.status =:status");
			if (lnkObjects != null && lnkObjects.length != 0) {
				for (int i=0; i<lnkObjects.length; i++) {
					LnkObject lnkObj = lnkObjects[i];
					String lnkType = lnkObj.getType();
					String ref = lnkObj.getRef();
					String label = lnkObj.getLabel();
					String expression = lnkObj.getExpression();
					if (lnkType != null)
						buf.append(" and item").append(i).append(".type = :lnkType").append(i);
					if (ref != null)
						buf.append(" and item").append(i).append(".ref = :ref").append(i);
					if (label != null)
						buf.append(" and item").append(i).append(".label = :label").append(i);
					if (expression != null)
						buf.append(" and item").append(i).append(".expression = :expression").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
	
		Query query = this.createQuery(buf.toString(),cond);
		if(cond != null){
			if(objId != null)
				query.setString("objId",objId);
			if(creationUser != null)
				query.setString("creationUser", creationUser);
			if(modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if(correlation != null)
				query.setString("correlation", correlation);
			if(type != null)
				query.setString("type", type);
			if(status != null)
				query.setString("status", status);
			if(typeLike != null)
				query.setString("typeLike", CommonUtil.toLikeString(typeLike));
			if (lnkObjects != null && lnkObjects.length != 0) {
				for (int i=0; i<lnkObjects.length; i++) {
					LnkObject lnkObj = lnkObjects[i];
					String lnkType = lnkObj.getType();
					String ref = lnkObj.getRef();
					String label = lnkObj.getLabel();
					String expression = lnkObj.getExpression();
					if (lnkType != null)
						query.setString("lnkType"+i, lnkType);
					if (ref != null)
						query.setString("ref"+i, ref);
					if (label != null)
						query.setString("label"+i, label);
					if (expression != null)
						query.setString("expression"+i, expression);
				}
			}
		}
		return query;
	}
	public long getListSize(String user, ColListCond cond) throws ColException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf,cond);
			List list = query.list();
			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
	public ColList[] getLists(String user, ColListCond cond, String level) throws ColException {
		try {
			if (level == null)
			level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.modificationDate, obj.status, obj.description");
				buf.append(", obj.correlation, obj.type");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					ColList obj = new ColList();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setStatus(((String)fields[j++]));
					obj.setDescription(((String)fields[j++]));
					obj.setCorrelation(((String)fields[j++]));
					obj.setType(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			ColList[] objs = new ColList[list.size()];
			list.toArray(objs);
			return objs;
		} catch (ColException e) {
			throw e;
		} catch (Exception e) {
			throw new ColException(e);
		}
	}
}
