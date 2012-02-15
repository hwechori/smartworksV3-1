package net.smartworks.server.engine.config.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.smartworks.server.engine.common.manager.AbstractManager;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.config.exception.SwcException;
import net.smartworks.server.engine.config.manager.ISwcManager;
import net.smartworks.server.engine.config.model.SwcEventDay;
import net.smartworks.server.engine.config.model.SwcEventDayCond;
import net.smartworks.server.engine.config.model.SwcExternalForm;
import net.smartworks.server.engine.config.model.SwcExternalFormCond;
import net.smartworks.server.engine.config.model.SwcExternalFormParameter;
import net.smartworks.server.engine.config.model.SwcWebService;
import net.smartworks.server.engine.config.model.SwcWebServiceCond;
import net.smartworks.server.engine.config.model.SwcWebServiceParameter;
import net.smartworks.server.engine.config.model.SwcWorkHour;
import net.smartworks.server.engine.config.model.SwcWorkHourCond;
import net.smartworks.util.LocalDate;

import org.hibernate.Query;

public class SwcManagerImpl extends AbstractManager implements ISwcManager {

	public SwcManagerImpl() {
		super();
		if (logger.isInfoEnabled())
			logger.info(this.getClass().getName() + " created");
	}

	public SwcWorkHour getWorkhour(String user, String id, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				SwcWorkHour obj = (SwcWorkHour)this.get(SwcWorkHour.class, id);
				return obj;
			} else {
				SwcWorkHourCond cond = new SwcWorkHourCond();
				cond.setObjId(id);
				SwcWorkHour[] objs = this.getWorkhours(user, cond, level);
				if (objs == null || objs.length == 0)
					return null;
				return objs[0];
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public SwcWorkHour getWorkhour(String user, SwcWorkHourCond cond, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		SwcWorkHour[] workhours = getWorkhours(user, cond, level);
		if (CommonUtil.isEmpty(workhours))
			return null;
		try {
			if (workhours.length != 1)
				throw new SwcException("More than 1 Object");
		} catch (SwcException e) {
			logger.error(e, e);
			throw e;
		}
		return workhours[0];
	}
	public void setWorkhour(String user, SwcWorkHour obj, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(user, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("update SwcWorkHour set");
				buf.append(" companyId=:companyId, type=:type, startDayOfWeek=:startDayOfWeek, workingDays=:workingDays,");
				buf.append(" validFromDate=:validFromDate, validToDate=:validToDate,");
				buf.append(" monStartTime=:monStartTime, monEndTime=:monEndTime,");
				buf.append(" tueStartTime=:tueStartTime, tueEndTime=:tueEndTime,");
				buf.append(" wedStartTime=:wedStartTime, wedEndTime=:wedEndTime,");
				buf.append(" thuStartTime=:thuStartTime, thuEndTime=:thuEndTime,");
				buf.append(" friStartTime=:friStartTime, friEndTime=:friEndTime,");
				buf.append(" satStartTime=:satStartTime, satEndTime=:satEndTime,");
				buf.append(" sunStartTime=:sunStartTime, sunEndTime=:sunEndTime,");
				buf.append(" creationDate=:creationDate, creationUser=:creationUser, modificationUser=:modificationUser,");
				buf.append(" modificationDate=:modificationDate where objId=:objId");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(SwcWorkHour.A_COMPANYID, obj.getCompanyId());
				query.setString(SwcWorkHour.A_TYPE, obj.getType());
				query.setString(SwcWorkHour.A_STARTDAYOFWEEK, obj.getStartDayOfWeek());
				query.setInteger(SwcWorkHour.A_WORKINGDAYS, obj.getWorkingDays());
				query.setTimestamp(SwcWorkHour.A_VALIDFROMDATE, obj.getValidFromDate());
				query.setTimestamp(SwcWorkHour.A_VALIDTODATE, obj.getValidToDate());
				
				query.setTimestamp(SwcWorkHour.A_MONSTARTTIME, obj.getMonStartTime());
				query.setTimestamp(SwcWorkHour.A_MONENDTIME, obj.getMonEndTime());
				query.setTimestamp(SwcWorkHour.A_TUESTARTTIME, obj.getTueStartTime());
				query.setTimestamp(SwcWorkHour.A_TUEENDTIME, obj.getTueEndTime());
				query.setTimestamp(SwcWorkHour.A_WEDSTARTTIME, obj.getWedStartTime());
				query.setTimestamp(SwcWorkHour.A_WEDENDTIME, obj.getWedEndTime());
				query.setTimestamp(SwcWorkHour.A_THUSTARTTIME, obj.getThuStartTime());
				query.setTimestamp(SwcWorkHour.A_THUENDTIME, obj.getThuEndTime());
				query.setTimestamp(SwcWorkHour.A_FRISTARTTIME, obj.getFriStartTime());
				query.setTimestamp(SwcWorkHour.A_FRIENDTIME, obj.getFriEndTime());
				query.setTimestamp(SwcWorkHour.A_SATSTARTTIME, obj.getSatStartTime());
				query.setTimestamp(SwcWorkHour.A_SATENDTIME, obj.getSatEndTime());
				query.setTimestamp(SwcWorkHour.A_SUNSTARTTIME, obj.getSunStartTime());
				query.setTimestamp(SwcWorkHour.A_SUNENDTIME, obj.getSunEndTime());
				
				query.setTimestamp(SwcWorkHour.A_CREATIONDATE, obj.getCreationDate());
				query.setString(SwcWorkHour.A_CREATIONUSER, obj.getCreationUser());
				query.setString(SwcWorkHour.A_MODIFICATIONUSER, obj.getModificationUser());
				query.setTimestamp(SwcWorkHour.A_MODIFICATIONDATE, obj.getModificationDate());
				query.setString(SwcWorkHour.A_OBJID, obj.getObjId());
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void createWorkhour(String user, SwcWorkHour obj) throws SwcException {
		try {
			fill(user, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void removeWorkhour(String user, String id) throws SwcException {
		try {
			remove(SwcWorkHour.class, id);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void removeWorkhour(String user, SwcWorkHourCond cond) throws SwcException {
		SwcWorkHour obj = getWorkhour(user, cond, null);
		if (obj == null)
			return;
		removeWorkhour(user, obj.getObjId());
	}

	private Query appendQuery(StringBuffer buf, SwcWorkHourCond cond) throws Exception {
		String id = null;
		String type = null;
		String companyId = null;
		String startDayOfWeek = null;
		int workingDays = -1;
		Date validFromDate = null;
		Date validToDate = null;
		Date searchFromDate = null;
		Date searchToDate = null;
		String creationUser = null;
		Date creationDate = null;
		String modificationUser = null;
		Date modificationDate = null;
		
		if (cond != null) {
			id = cond.getObjId();
			type = cond.getType();
			companyId = cond.getCompanyId();
			startDayOfWeek = cond.getStartDayOfWeek();
			workingDays = cond.getWorkingDays();
			validFromDate = cond.getValidFromDate();
			validToDate = cond.getValidToDate();
			searchFromDate = cond.getSearchFromDate();
			searchToDate = cond.getSearchToDate();
			creationUser = cond.getCreationUser();
			creationDate = cond.getCreationDate();
			modificationUser = cond.getModificationUser();
			modificationDate = cond.getModificationDate();
		}
		buf.append(" from SwcWorkHour obj");
		buf.append(" where obj.objId is not null");
		//TODO 시간 검색에 대한 확인 필요
		if (cond != null) {
			if (id != null)
				buf.append(" and obj.objId = :objId");
			if (type != null)
				buf.append(" and obj.type = :type");
			if (companyId != null)
				buf.append(" and obj.companyId = :companyId");
			if (startDayOfWeek != null)
				buf.append(" and obj.startDayOfWeek = :startDayOfWeek");
			if (workingDays != -1)
				buf.append(" and obj.workingDays = :workingDays");
			if (validFromDate != null)
				buf.append(" and obj.validFromDate <= :validFromDate");
			if (validToDate != null)
				buf.append(" and obj.validToDate = :validToDate");
			if (searchFromDate != null)
				buf.append(" and obj.validFromDate > :searchFromDate");
			if (searchToDate != null)
				buf.append(" and obj.validFromDate <= :searchToDate");
			if (creationUser != null)
				buf.append(" and obj.creationUser = :creationUser");
			if (creationDate != null)
				buf.append(" and obj.creationDate = :creationDate");
			if (modificationUser != null)
				buf.append(" and obj.modificationUser = :modificationUser");
			if (modificationDate != null)
				buf.append(" and obj.modificationDate = :modificationDate");
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		if (cond != null) {
			if (id != null)
				query.setString("objId", id);
			if (type != null)
				query.setString("type", type);
			if (companyId != null)
				query.setString("companyId", companyId);
			if (startDayOfWeek != null)
				query.setString("startDayOfWeek", startDayOfWeek);
			if (workingDays != -1)
				query.setInteger("workingDays", workingDays);
			if (validFromDate != null)
				query.setTimestamp("validFromDate", validFromDate);
			if (validToDate != null)
				query.setTimestamp("validToDate", validToDate);
			if (searchFromDate != null)
				query.setTimestamp("searchFromDate", searchFromDate);
			if (searchToDate != null)
				query.setTimestamp("searchToDate", searchToDate);
			if (creationUser != null)
				query.setString("creationUser", creationUser);
			if (creationDate != null)
				query.setTimestamp("creationDate", creationDate);
			if (modificationUser != null)
				query.setString("modificationUser", modificationUser);
			if (modificationDate != null)
				query.setTimestamp("modificationDate", modificationDate);
		}
		return query;
	}
	public long getWorkhourSize(String user, SwcWorkHourCond cond) throws SwcException {
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
	public SwcWorkHour[] getWorkhours(String user, SwcWorkHourCond cond, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_LITE;
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj");
			} else {
				buf.append(" obj.objId, obj.companyId, obj.type, obj.startDayOfWeek, obj.workingDays,");
				buf.append(" obj.validFromDate, obj.validToDate,");
				buf.append(" obj.monStartTime, obj.monEndTime,");
				buf.append(" obj.tueStartTime, obj.tueEndTime,");
				buf.append(" obj.wedStartTime, obj.wedEndTime,");
				buf.append(" obj.thuStartTime, obj.thuEndTime,");
				buf.append(" obj.friStartTime, obj.friEndTime,");
				buf.append(" obj.satStartTime, obj.satEndTime,");
				buf.append(" obj.sunStartTime, obj.sunEndTime,");
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
					SwcWorkHour obj = new SwcWorkHour();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setCompanyId((String)fields[j++]);
					obj.setType((String)fields[j++]);
					obj.setStartDayOfWeek(((String)fields[j++]));
					obj.setWorkingDays(((Integer)fields[j++]));
					obj.setValidFromDate(((Timestamp)fields[j++]));
					obj.setValidToDate(((Timestamp)fields[j++]));
					obj.setMonStartTime(((Timestamp)fields[j++]));
					obj.setMonEndTime(((Timestamp)fields[j++]));
					obj.setTueStartTime(((Timestamp)fields[j++]));
					obj.setTueEndTime(((Timestamp)fields[j++]));
					obj.setWedStartTime(((Timestamp)fields[j++]));
					obj.setWedEndTime(((Timestamp)fields[j++]));
					obj.setThuStartTime(((Timestamp)fields[j++]));
					obj.setThuEndTime(((Timestamp)fields[j++]));
					obj.setFriStartTime(((Timestamp)fields[j++]));
					obj.setFriEndTime(((Timestamp)fields[j++]));
					obj.setSatStartTime(((Timestamp)fields[j++]));
					obj.setSatEndTime(((Timestamp)fields[j++]));
					obj.setSunStartTime(((Timestamp)fields[j++]));
					obj.setSunEndTime(((Timestamp)fields[j++]));
					obj.setCreationUser(((String)fields[j++]));
					obj.setCreationDate(((Timestamp)fields[j++]));
					obj.setModificationUser(((String)fields[j++]));
					obj.setModificationDate(((Timestamp)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			SwcWorkHour[] objs = new SwcWorkHour[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public SwcWorkHour getPublishedWorkhour(String user, String companyId) throws SwcException {
		try {
			SwcWorkHourCond cond = new SwcWorkHourCond();
			cond.setCompanyId(companyId);
			cond.setValidFromDate(new LocalDate());//date to localdate - 
			
			Order order = new Order("validFromDate", false);
			Order[] orders = new Order[]{order};
			cond.setOrders(orders);
			
			cond.setPageNo(0);
			cond.setPageSize(1);
			
			SwcWorkHour[] hours = getWorkhours(user, cond, IManager.LEVEL_ALL);
			if (CommonUtil.isEmpty(hours))
				return null;
			return hours[0];
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}	
	}
	public SwcWorkHour[] getValidWorkhoursByFromTo(String companyId, String user, Date from, Date to) throws SwcException {
		SwcWorkHour workhour = getPublishedWorkhour(user, companyId);
		if (workhour == null)
			new SwcException("publishedWorkhour is null");

		SwcWorkHourCond cond = new SwcWorkHourCond();
		cond.setCompanyId(companyId);
		cond.setSearchFromDate(from);
		cond.setSearchToDate(to);
		
		SwcWorkHour[] workhours = getWorkhours(user, cond, "LEVEL_ALL");
		
		SwcWorkHour[] workhourArray = null;
		if (CommonUtil.isEmpty(workhours)) {
			workhourArray = new SwcWorkHour[1];
			workhourArray[0] = workhour;
		} else {
			workhourArray = new SwcWorkHour[workhours.length + 1];
			workhourArray[0] = workhour;
			for (int i = 1; i <= workhours.length; i++) {
				workhourArray[i] = workhours[i-1];
			}
		}
		return workhourArray;
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

	public SwcWebService getWebService(String userId, String objId, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				SwcWebService obj = (SwcWebService)this.get(SwcWebService.class, objId);
				return obj;
			} else {
				SwcWebServiceCond cond = new SwcWebServiceCond();
				cond.setObjId(objId);
				return getWebService(userId, cond, level);
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public SwcWebService getWebService(String userId, SwcWebServiceCond cond, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		SwcWebService[] webServiceLists = getWebServices(userId, cond, level);
		if (CommonUtil.isEmpty(webServiceLists))
			return null;
		try {
			if (webServiceLists.length != 1)
				throw new SwcException("More than 1 Object");
		} catch (SwcException e) {
			logger.error(e, e);
			throw e;
		}
		return webServiceLists[0];
	}
	public void setWebService(String userId, SwcWebService obj, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)){
				fill(userId, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append(" update SwcWebService set ");
				buf.append(" webServiceName=:webServiceName, webServiceAddress=:webServiceAddress, wsdlAddress=:wsdlAddress ");
				buf.append(", portName=:portName, A_OPERATIONNAME=:A_OPERATIONNAME, A_DESCRIPTION=:A_DESCRIPTION, ");
				buf.append(" where objId=:objId ");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(SwcWebService.A_WEBSERVICENAME, obj.getWebServiceName());
				query.setString(SwcWebService.A_WEBSERVICEADDRESS, obj.getWebServiceAddress());
				query.setString(SwcWebService.A_WSDLADDRESS, obj.getWsdlAddress());
				query.setString(SwcWebService.A_PORTNAME, obj.getPortName());
				query.setString(SwcWebService.A_OPERATIONNAME, obj.getOperationName());
				query.setString(SwcWebService.A_DESCRIPTION, obj.getDescription());
				query.setString(SwcWebService.A_OBJID, obj.getObjId());
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void createWebService(String userId, SwcWebService obj) throws SwcException {
		try {
			fill(userId, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void removeWebService(String userId, String objId) throws SwcException {
		try {
			remove(SwcWebService.class, objId);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public void removeWebService(String userId, SwcWebServiceCond cond) throws SwcException {
		SwcWebService obj = getWebService(userId, cond, null);
		if (obj == null)
			return;
		removeWebService(userId, obj.getObjId());
	}
	private Query appendQuery(StringBuffer buf, SwcWebServiceCond cond) throws Exception {
		String objId = null;
		String webServiceName = null;
		String webServiceAddress = null;
		String wsdlAddress = null;
		String portName = null;
		String operationName = null;
		String description = null;
		SwcWebServiceParameter[] webServices =null;
		
		if (cond != null) {
			objId = cond.getObjId();
			webServiceName = cond.getWebServiceName();
			webServiceAddress = cond.getWebServiceAddress();
			wsdlAddress = cond.getWsdlAddress();
			portName = cond.getPortName();
			operationName = cond.getOperationName();
			description = cond.getDescription();
		}
		buf.append(" from SwcWebService obj");
		if (webServices != null && webServices.length != 0) {
			for (int i=0; i<webServices.length; i++) {
				buf.append(" left join obj.swcWebServiceParameters as webserviceParameter").append(i);
			}
		}
		buf.append(" where obj.id is not null");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId");
			if (webServiceName != null)
				buf.append(" and obj.webServiceName = :webServiceName");
			if (webServiceAddress != null)
				buf.append(" and obj.webServiceAddress = :webServiceAddress");
			if (wsdlAddress != null)
				buf.append(" and obj.wsdlAddress = :wsdlAddress");
			if (portName != null)
				buf.append(" and obj.portName = :portName");
			if (operationName != null)
				buf.append(" and obj.operationName = :operationName");
			if (description != null)
				buf.append(" and obj.description = :description");
			if (webServices != null && webServices.length != 0) {
				for (int i=0; i<webServices.length; i++) {
					SwcWebServiceParameter webservice = webServices[i];
					String parameterName = webservice.getParameterName();
					String parameterType = webservice.getParameterType();
					String variableName = webservice.getVariableName();
					String type = webservice.getType();
					if (variableName != null)
						buf.append(" and webservice").append(i).append(".variableName = :variableName").append(i);
					if (parameterName != null)
						buf.append(" and webservice").append(i).append(".parameterName = :parameterName").append(i);
					if (parameterType != null)
						buf.append(" and webservice").append(i).append(".parameterType = :parameterType").append(i);
					if (type != null)
						buf.append(" and webservice").append(i).append(".type = :type").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);
		
		Query query = this.createQuery(buf.toString(), cond);
		
		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (webServiceName != null)
				query.setString("webServiceName", webServiceName);
			if (webServiceAddress != null)
				query.setString("webServiceAddress", webServiceAddress);
			if (wsdlAddress != null)
				query.setString("wsdlAddress", wsdlAddress);
			if (portName != null)
				query.setString("portName", portName);
			if (operationName != null)
				query.setString("operationName", operationName);
			if (description != null)
				query.setString("description", description);
			if (webServices != null && webServices.length != 0) {
				for (int i=0; i<webServices.length; i++) {
					SwcWebServiceParameter webService = webServices[i];
					String parameterName = webService.getParameterName();
					String parameterType = webService.getParameterType();
					String variableName = webService.getVariableName();
					String type = webService.getType();
					
					if (parameterName != null)
						query.setString("parameterName"+i, parameterName);
					if (parameterType != null)
						query.setString("parameterType"+i, parameterType);
					if (variableName != null)
						query.setString("variableName"+i, variableName);
					if (type != null)
						query.setString("type"+i, type);
				}
			}
		}
		return query;
	}
	public long getWebServiceSize(String userId, SwcWebServiceCond cond) throws SwcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj) ");
			Query query = this.appendQuery(buf, cond);
			List  list = query.list();

			long count = ((Long)list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	public SwcWebService[] getWebServices(String userId, SwcWebServiceCond cond, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			StringBuffer buf = new StringBuffer();
			buf.append(" select ");
			if(level.equals(LEVEL_ALL)) {
				buf.append(" obj ");
			} else {
				buf.append(" obj.objId, obj.webServiceName, obj.webServiceAddress, obj.wsdlAddress, obj.portName ");
				buf.append(", obj.operationName,  obj.description ");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					SwcWebService obj = new SwcWebService();
					int j = 0;
					obj.setObjId((String)fields[j++]);
					obj.setWebServiceName((String)fields[j++]);
					obj.setWebServiceAddress((String)fields[j++]);
					obj.setWsdlAddress((String)fields[j++]);
					obj.setPortName(((String)fields[j++]));	
					obj.setOperationName((String)fields[j++]);
					obj.setDescription(((String)fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			SwcWebService[] objs = new SwcWebService[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}
	
	public void removeWebServices(String userId, String packageId) throws SwcException {
		if (CommonUtil.isEmpty(packageId))
			return;
		String hql = "delete from SwcWebServiceParameter where objId = '" + packageId + "'";
		Query query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}

	public SwcExternalForm getExternalForm(String userId, String objId, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			if (level.equals(LEVEL_ALL)) {
				SwcExternalForm obj = (SwcExternalForm) this.get(SwcExternalForm.class, objId);
				return obj;
			} else {
				SwcExternalFormCond cond = new SwcExternalFormCond();
				cond.setObjId(objId);
				return getExternalForm(userId, cond, level);
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}

	public SwcExternalForm getExternalForm(String userId, SwcExternalFormCond cond, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		cond.setPageSize(2);
		SwcExternalForm[] webAppServiceLists = getExternalForms(userId, cond, level);
		if (CommonUtil.isEmpty(webAppServiceLists))
			return null;
		try {
			if (webAppServiceLists.length != 1)
				throw new SwcException("More than 1 Object");
		} catch (SwcException e) {
			logger.error(e, e);
			throw e;
		}
		return webAppServiceLists[0];
	}

	public void setExternalForm(String userId, SwcExternalForm obj, String level) throws SwcException {
		if (level == null)
			level = LEVEL_ALL;
		try {
			if (level.equals(LEVEL_ALL)) {
				fill(userId, obj);
				set(obj);
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append(" update SwcExternalForm set ");
				buf.append(" webAppServiceName=:webAppServiceName, webAppServiceUrl=:webAppServiceUrl, modifyMethod=:modifyMethod ");
				buf.append(", viewMethod=:viewMethod, A_DESCRIPTION=:A_DESCRIPTION, ");
				buf.append(" where objId=:objId ");
				Query query = this.getSession().createQuery(buf.toString());
				query.setString(SwcExternalForm.A_EXTERNALFORMNAME, obj.getWebAppServiceName());
				query.setString(SwcExternalForm.A_EXTERNALFORMURL, obj.getWebAppServiceUrl());
				query.setString(SwcExternalForm.A_MODIFYMETHOD, obj.getModifyMethod());
				query.setString(SwcExternalForm.A_VIEWMETHOD, obj.getViewMethod());
				query.setString(SwcExternalForm.A_DESCRIPTION, obj.getDescription());
				query.setString(SwcExternalForm.A_OBJID, obj.getObjId());
			}
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}

	}

	public void createExternalForm(String userId, SwcExternalForm obj) throws SwcException {
		try {
			fill(userId, obj);
			create(obj);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}

	public void removeExternalForm(String userId, String objId) throws SwcException {
		try {
			remove(SwcExternalForm.class, objId);
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}

	}

	public void removeExternalForm(String userId, SwcExternalFormCond cond) throws SwcException {
		SwcExternalForm obj = getExternalForm(userId, cond, null);
		if (obj == null)
			return;
		removeExternalForm(userId, obj.getObjId());

	}

	private Query appendQuery(StringBuffer buf, SwcExternalFormCond cond) throws Exception {
		String objId = null;
		String webAppServiceName = null;
		String webAppServiceUrl = null;
		String modifyMethod = null;
		String viewMethod = null;
		String description = null;
		SwcExternalFormParameter[] webAppServiceParameters = null;

		if (cond != null) {
			objId = cond.getObjId();
			webAppServiceName = cond.getExternalFormName();
			webAppServiceUrl = cond.getExternalFormUrl();
			modifyMethod = cond.getModifyMethod();
			viewMethod = cond.getViewMethod();
			description = cond.getDescription();
		}

		buf.append(" from SwcExternalForm obj ");
		if (webAppServiceParameters != null && webAppServiceParameters.length != 0) {
			for (int i = 0; i < webAppServiceParameters.length; i++) {
				buf.append(" left join obj.swcExternalFormParameters as webappserviceParameter").append(i);
			}
		}
		buf.append(" where obj.id is not null ");
		if (cond != null) {
			if (objId != null)
				buf.append(" and obj.objId = :objId ");
			if (webAppServiceName != null)
				buf.append(" and obj.webAppServiceName = :webAppServiceName ");
			if (webAppServiceUrl != null)
				buf.append(" and obj.webAppServiceUrl = :webAppServiceUrl ");
			if (modifyMethod != null)
				buf.append(" and obj.modifyMethod = :modifyMethod ");
			if (viewMethod != null)
				buf.append(" and obj.viewMethod = :viewMethod ");
			if (description != null)
				buf.append(" and obj.description = :description ");
			if (webAppServiceParameters != null && webAppServiceParameters.length != 0) {
				for (int i = 0; i < webAppServiceParameters.length; i++) {
					SwcExternalFormParameter webparameter = webAppServiceParameters[i];
					String parameterName = webparameter.getParameterName();
					String parameterType = webparameter.getParameterType();
					String variableName = webparameter.getVariableName();
					String type = webparameter.getType();
					if (variableName != null)
						buf.append(" and webparameter").append(i).append(".variableName = :variableName").append(i);
					if (parameterName != null)
						buf.append(" and webparameter").append(i).append(".parameterName = :parameterName").append(i);
					if (parameterType != null)
						buf.append(" and webparameter").append(i).append(".parameterType = :parameterType").append(i);
					if (type != null)
						buf.append(" and webparameter").append(i).append(".type = :type").append(i);
				}
			}
		}
		this.appendOrderQuery(buf, "obj", cond);

		Query query = this.createQuery(buf.toString(), cond);

		if (cond != null) {
			if (objId != null)
				query.setString("objId", objId);
			if (webAppServiceName != null)
				query.setString("webAppServiceName", webAppServiceName);
			if (webAppServiceUrl != null)
				query.setString("webAppServiceUrl", webAppServiceUrl);
			if (modifyMethod != null)
				query.setString("modifyMethod", modifyMethod);
			if (viewMethod != null)
				query.setString("viewMethod", viewMethod);
			if (description != null)
				query.setString("description", description);
			if (webAppServiceParameters != null && webAppServiceParameters.length != 0) {
				for (int i = 0; i < webAppServiceParameters.length; i++) {
					SwcExternalFormParameter webparameter = webAppServiceParameters[i];
					String parameterName = webparameter.getParameterName();
					String parameterType = webparameter.getParameterType();
					String variableName = webparameter.getVariableName();
					String type = webparameter.getType();
					if (parameterName != null)
						query.setString("parameterName" + i, parameterName);
					if (parameterType != null)
						query.setString("parameterType" + i, parameterType);
					if (variableName != null)
						query.setString("variableName" + i, variableName);
					if (type != null)
						query.setString("type" + i, type);
				}
			}
		}
		return query;
	}

	public long getExternalFormSize(String userId, SwcExternalFormCond cond) throws SwcException {
		try {
			StringBuffer buf = new StringBuffer();
			buf.append("select");
			buf.append(" count(obj) ");
			Query query = this.appendQuery(buf, cond);
			List list = query.list();

			long count = ((Long) list.get(0)).longValue();
			return count;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}

	public SwcExternalForm[] getExternalForms(String userId, SwcExternalFormCond cond, String level) throws SwcException {
		try {
			if (level == null)
				level = LEVEL_ALL;
			StringBuffer buf = new StringBuffer();
			buf.append(" select ");
			if (level.equals(LEVEL_ALL)) {
				buf.append(" obj ");
			} else {
				buf.append(" obj.objId, obj.webAppServiceName, obj.webAppServiceUrl, obj.modifyMethod, obj.viewMethod ");
				buf.append(", obj.description ");
			}
			Query query = this.appendQuery(buf, cond);
			List list = query.list();
			if (list == null || list.isEmpty())
				return null;
			if (!level.equals(LEVEL_ALL)) {
				List objList = new ArrayList();
				for (Iterator itr = list.iterator(); itr.hasNext();) {
					Object[] fields = (Object[]) itr.next();
					SwcExternalForm obj = new SwcExternalForm();
					int j = 0;
					obj.setObjId((String) fields[j++]);
					obj.setWebAppServiceName((String) fields[j++]);
					obj.setWebAppServiceUrl((String) fields[j++]);
					obj.setModifyMethod((String) fields[j++]);
					obj.setViewMethod(((String) fields[j++]));
					obj.setDescription(((String) fields[j++]));
					objList.add(obj);
				}
				list = objList;
			}
			SwcExternalForm[] objs = new SwcExternalForm[list.size()];
			list.toArray(objs);
			return objs;
		} catch (Exception e) {
			logger.error(e, e);
			throw new SwcException(e);
		}
	}

	public void removeExternalForms(String userId, String packageId) throws SwcException {
		if (CommonUtil.isEmpty(packageId))
			return;
		String hql = "delete from SwcExternalFormParameter where objId = '" + packageId + "'";
		Query query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}

}