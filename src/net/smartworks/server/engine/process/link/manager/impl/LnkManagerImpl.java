package net.smartworks.server.engine.process.link.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.process.link.exception.LnkException;
import net.smartworks.server.engine.process.link.manager.ILnkManager;
import net.smartworks.server.engine.process.link.model.LnkCondition;
import net.smartworks.server.engine.process.link.model.LnkLink;
import net.smartworks.server.engine.process.link.model.LnkLinkCond;
import net.smartworks.server.engine.process.link.model.LnkObject;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

public class LnkManagerImpl extends AbstractManager implements ILnkManager {
	private static final String BAR = CommonUtil.BAR;
	private static final String PERCENT = CommonUtil.PERCENT;

	public LnkManagerImpl() {
		super();
	}
	
	public LnkLink getLink(String user, String id, String level) throws LnkException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				LnkLink obj = (LnkLink)get(LnkLink.class, id);
				return obj;
			} else {
				LnkLinkCond cond = new LnkLinkCond();
				cond.setObjId(id);
				LnkLink[] objs = this.getLinks(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
	}
	
	public LnkLink getLink(String user, LnkLinkCond cond, String level) throws LnkException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		LnkLink[] objs = getLinks(user, cond, level);
		if (CommonUtil.isEmpty(objs))
			return null;
		try {
			if (objs.length != 1)
				throw new LnkException("More than 1 Object");
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
		return objs[0];
	}
	
	public void setLink(String user, LnkLink obj, String level) throws LnkException {
		try {
			fill(user, obj);
			set(obj);
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
	}
	
	public void createLink(String user, LnkLink obj) throws LnkException {
		try {
			fill(user, obj);
			create(obj);
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
	}
	
	public void removeLink(String user, String id) throws LnkException {
		try {
			remove(LnkLink.class, id);
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
	}
	
	public void removeLink(String user, LnkLinkCond cond) throws LnkException {
		LnkLink obj = getLink(user, cond, null);
		if (obj == null)
			return;
		removeLink(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, LnkLinkCond cond) throws Exception {
		String objId = null;
		String correlation = null;
		String type = null;
		String fromType = null;
		String fromRef = null;
		String fromAssignee = null;
		String toType = null;
		String toRef = null;
		String toAssignee = null;
		String condType = null;
		String condStatus = null;
		
		String fromTypeLike = null;
		String fromLabelLike = null;
		String toTypeLike = null;
		String toLabelLike = null;
		Property[] extProps = null;
		
		if (cond != null) {
			objId = cond.getObjId();
			correlation = cond.getCorrelation();
			type = cond.getType();
			fromType = cond.getFromType();
			fromRef = cond.getFromRef();
			fromAssignee = cond.getFromExpression();
			if (fromAssignee != null)
				fromAssignee = new StringBuffer(PERCENT).append(BAR).append(fromAssignee).append(BAR).append(PERCENT).toString();
			toType = cond.getToType();
			toRef = cond.getToRef();
			toAssignee = cond.getToExpression();
			if (toAssignee != null)
				toAssignee = new StringBuffer(PERCENT).append(BAR).append(toAssignee).append(BAR).append(PERCENT).toString();
			condType = cond.getConditionType();
			condStatus = cond.getConditionExpression();
			if (condStatus != null)
				condStatus = new StringBuffer(PERCENT).append(BAR).append(condStatus).append(BAR).append(PERCENT).toString();
			fromTypeLike = cond.getFromTypeLike();
			fromLabelLike = cond.getFromLabelLike();
			toTypeLike = cond.getToTypeLike();
			toLabelLike = cond.getToLabelLike();
			extProps = cond.getExtendedProperties();
		}
		buf.append(" from LnkLink obj");
		if (extProps != null && extProps.length != 0) {
			for (int i=0; i<extProps.length; i++) {
				buf.append(" left join obj.extendedProperties as extProp").append(i);
			}
		}
		buf.append(" where obj.objId is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (correlation != null)
				buf.append(" and obj.correlation = :correlation");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (fromType != null)
				buf.append(" and obj.from.type = :fromType");
			if (fromRef != null)
				buf.append(" and obj.from.ref = :fromRef");
			if (fromAssignee != null)
				buf.append(" and (obj.from.expression is null or obj.from.expression like :fromAssignee)");
			if (toType != null)
				buf.append(" and obj.to.type = :toType");
			if (toRef != null)
				buf.append(" and obj.to.ref = :toRef");
			if (toAssignee != null)
				buf.append(" and (obj.to.expression is null or obj.to.expression like :toAssignee)");
			if (condType != null)
				buf.append(" and obj.condition.type = :condType");
			if (condStatus != null)
				buf.append(" and obj.condition.expression like :condStatus");
			if (fromTypeLike != null)
				buf.append(" and obj.from.type like :fromTypeLike");
			if (fromLabelLike != null)
				buf.append(" and obj.from.label like :fromLabelLike");
			if (toTypeLike != null)
				buf.append(" and obj.to.type like :toTypeLike");
			if (toLabelLike != null)
				buf.append(" and obj.to.label like :toLabelLike");
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
			if (correlation != null)
				query.setString("correlation", correlation);
			if (type != null)
				query.setString("type", type);
			if (fromType != null)
				query.setString("fromType", fromType);
			if (fromRef != null)
				query.setString("fromRef", fromRef);
			if (fromAssignee != null)
				query.setString("fromAssignee", fromAssignee);
			if (toType != null)
				query.setString("toType", toType);
			if (toRef != null)
				query.setString("toRef", toRef);
			if (toAssignee != null)
				query.setString("toAssignee", toAssignee);
			if (condType != null)
				query.setString("condType", condType);
			if (condStatus != null)
				query.setString("condStatus", condStatus);
			if (fromTypeLike != null)
				query.setString("fromTypeLike", CommonUtil.toLikeString(fromTypeLike));
			if (fromLabelLike != null)
				query.setString("fromLabelLike", CommonUtil.toLikeString(fromLabelLike));
			if (toTypeLike != null)
				query.setString("toTypeLike", CommonUtil.toLikeString(toTypeLike));
			if (toLabelLike != null)
				query.setString("toLabelLike", CommonUtil.toLikeString(toLabelLike));
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
	
	public long getLinkSize(String user, LnkLinkCond cond) throws LnkException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj)");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			long count =((Long)list.get(0)).longValue();
			return count;
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
	}
	
	public LnkLink[] getLinks(String user, LnkLinkCond cond, String level) throws LnkException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.creationUser, obj.creationDate, obj.modificationUser");
				buf.append(", obj.modificationDate, obj.correlation, obj.type, obj.from.type, obj.from.ref, obj.from.label");
				buf.append(", obj.from.expression, obj.to.type, obj.to.ref, obj.to.label, obj.to.expression");
				buf.append(", obj.condition.type, obj.condition.expression");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					LnkLink obj = new LnkLink();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCreationUser((String)fields[j++]);
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					obj.setCorrelation(((String)fields[j++]));
					obj.setType(((String)fields[j++]));
					
					LnkObject from = new LnkObject();
					from.setType((String)fields[j++]);
					from.setRef((String)fields[j++]);
					from.setLabel((String)fields[j++]);
					from.setExpression((String)fields[j++]);
					obj.setFrom(from);
					
					LnkObject to = new LnkObject();
					to.setType((String)fields[j++]);
					to.setRef((String)fields[j++]);
					to.setLabel((String)fields[j++]);
					to.setExpression((String)fields[j++]);
					obj.setTo(to);
					
					LnkCondition condition = new LnkCondition();
					condition.setType((String)fields[j++]);
					condition.setExpression((String)fields[j++]);
					obj.setCondition(condition);
					
					objList.add(obj);
				}
				list = objList;
			}
			LnkLink[] objs = new LnkLink[list.size()];
			list.toArray(objs);
			return objs;
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
	}
	
	public void removeLinks(String user, LnkLinkCond cond) throws LnkException {
		try {
			LnkLink[] objs = this.getLinks(user, cond, LEVEL_ALL);
			super.removeAll(objs);
		} catch (LnkException e) {
			throw e;
		} catch (Exception e) {
			throw new LnkException(e);
		}
	}
	
}
