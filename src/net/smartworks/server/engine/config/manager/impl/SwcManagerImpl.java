package net.smartworks.server.engine.config.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.config.exception.SwcException;
import net.smartworks.server.engine.config.manager.ISwcManager;
import net.smartworks.server.engine.config.model.SwcEventDay;
import net.smartworks.server.engine.config.model.SwcEventDayCond;

import org.hibernate.Query;

public class SwcManagerImpl extends AbstractManager implements ISwcManager {

	public SwcManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}

	public SwcEventDay getEventday(String user, String id, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				SwcEventDay obj = (SwcEventDay)this.get(SwcEventDay.class, id);
				return obj;
			} else {
				SwcEventDayCond cond = new SwcEventDayCond();
				cond.setObjId(id);
				SwcEventDay[] objs = this.getEventdays(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}	
	}
	public SwcEventDay getEventday(String user, SwcEventDayCond cond, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		SwcEventDay[] eventdays = getEventdays(user, cond, level);
		if (CommonUtil.isEmpty(eventdays))
			return null;
		try {
			if (eventdays.length != 1)
				throw new SwcException("More than 1 Object");
		} catch (SwcException e) {
			logger.error(e, e);
			throw e;
		}
		return eventdays[0];
	}
	public void setEventday(String user, SwcEventDay obj, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update SwcEventDay set");
				buf.append(" name=:name, companyId=:companyId, type=:type,");
				buf.append(" startDay=:startDay, endDay=:endDay, description=:description, reltdPerson=:reltdPerson,");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where ObjId=:ObjId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(SwcEventDay.A_NAME, obj.getName());
				query.setString(SwcEventDay.A_COMPANYID, obj.getCompanyId());
				query.setString(SwcEventDay.A_TYPE, obj.getType());
				query.setTimestamp(SwcEventDay.A_STARTDAY, obj.getStartDay());
				query.setTimestamp(SwcEventDay.A_ENDDAY, obj.getEndDay());
				query.setString(SwcEventDay.A_RELTDPERSON, obj.getReltdPerson());
				query.setString(SwcEventDay.A_DESCRIPTION, obj.getDescription());
				query.setTimestamp(SwcEventDay.A_CREATIONDATE, obj.getCreationDate());
				query.setString(SwcEventDay.A_CREATIONUSER, obj.getCreationUser());
				query.setString(SwcEventDay.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(SwcEventDay.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(SwcEventDay.A_OBJID, obj.getObjId());
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void createEventday(String user, SwcEventDay obj) throws SwcException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void removeEventday(String user, String id) throws SwcException {
		try {
			remove(SwcEventDay.class, id);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void removeEventday(String user, SwcEventDayCond cond) throws SwcException {
		SwcEventDay obj = getEventday(user, cond, null);
		if (obj == null)
			return;
		removeEventday(user, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, SwcEventDayCond cond) throws Exception {
		String id = null;
		String name = null;
		String companyId = null;
		String type = null;
		Date startDay = null;
		Date endDay = null;
		String reltdPerson = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		boolean searchMode = false;
		Date searchFromDate = null;
		Date searchToDate = null;
		Date searchDay = null;
		
		if (cond != null) {
			id = cond.getObjId();
			name = cond.getName();
			companyId = cond.getCompanyId();
			type = cond.getType();
			startDay = cond.getStartDay();
			endDay = cond.getEndDay();
			reltdPerson = cond.getReltdPerson();
			creationUser = cond.getCreationUser();
			creationDate = cond.getCreationDate();
			modificationUser = cond.getModificationUser();
			modificationDate = cond.getModificationDate();
			searchMode = cond.isSearchMode();
			searchFromDate = cond.getSearchFromDate();
			searchToDate = cond.getSearchToDate();
			searchDay = cond.getSearchDay();
		}
		buf.append(" from SwcEventDay obj");
		buf.append(" where obj.objId is not null");
		//TODO 시간 검색에 대한 확인 필요
		if (cond != null) {
			if (id != null)
				buf.append(" and obj.objId = :objId");
			if (name != null)
				buf.append(" and obj.name = :name");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (startDay != null)
				buf.append(" and obj.startDay = :startDay");
			if (endDay != null)
				buf.append(" and obj.endDay = :endDay");
			if (reltdPerson != null)
				buf.append(" and obj.reltdPerson like :reltdPerson");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (creationDate != null)
				buf.append(" and obj.creationDate = :creationDate");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (modificationDate != null)
				buf.append(" and obj.modificationDate = :modificationDate");
			if (searchMode) {
				if (searchFromDate != null) {
					buf.append(" and obj.endDay > :searchFromDate");
				}
				if (searchToDate != null) {
					buf.append(" and obj.startDay < :searchToDate");
				}
			}
			if (searchDay != null) {
				buf.append(" and obj.startDay <= :searchDay");
				buf.append(" and obj.endDay >= :searchDay");
			}
		}
		
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (id != null)
				query.setString("objId", id);
			if (name != null)
				query.setString("name", name);
			if (companyId != null)
				query.setString("companyId", companyId);
			if (type != null)
				query.setString("type", type);
			if (startDay != null)
				query.setTimestamp("startDay", startDay);
			if (endDay != null)
				query.setTimestamp("endDay", endDay);
			if (reltdPerson != null)
				query.setString("reltdPerson", CommonUtil.toLikeString(reltdPerson));
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (creationDate != null)
				query.setTimestamp("creationDate", creationDate);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (modificationDate != null)
				query.setTimestamp("modificationDate", modificationDate);
			if (searchMode) {
				if (searchFromDate != null) {
					query.setTimestamp("searchFromDate", searchFromDate);
				}
				if (searchToDate != null) {
					query.setTimestamp("searchToDate", searchToDate);
				}
			}
			if (searchDay != null) {
				query.setTimestamp("searchDay", searchDay);
			}
		}
		return query;
	}
	public long getEventdaySize(String user, SwcEventDayCond cond) throws SwcException {
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
			throw new SwcException(e);
		}
	}
	public SwcEventDay[] getEventdays(String user, SwcEventDayCond cond, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.name, obj.companyId, obj.type, obj.description,");
				buf.append(" obj.startDay, obj.endDay, obj.reltdPerson,");
				buf.append(" obj.creationUser, obj.creationDate, obj.modificationUser,");
				buf.append(" obj.modificationDate");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					SwcEventDay obj = new SwcEventDay();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setName((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setType(((String)fields[j++]));
					obj.setDescription(((String)fields[j++]));
					obj.setStartDay(((Timestamp)fields[j++]));
					obj.setEndDay(((Timestamp)fields[j++]));
					obj.setReltdPerson(((String)fields[j++]));
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			SwcEventDay[] objs = new SwcEventDay[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}

}