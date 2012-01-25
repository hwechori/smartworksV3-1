package net.smartworks.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.community.User;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.config.manager.ISwcManager;
import net.smartworks.server.engine.config.model.SwcEventDay;
import net.smartworks.server.engine.config.model.SwcEventDayCond;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordExtend;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.service.ICalendarService;
import net.smartworks.server.service.util.ModelConverter;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;
import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements ICalendarService {

	private ISwcManager getSwcManager() {
		return SwManagerFactory.getInstance().getSwcManager();
	}
	private ISwdManager getSwdManager() {
		return SwManagerFactory.getInstance().getSwdManager();
	}
	private ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getCompanyCalendars(net.smartworks
	 * .util.LocalDate, int)
	 */
	@Override
	public CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, int days) throws Exception {

		User cUser = SmartUtil.getCurrentUser();

		SwcEventDayCond swcEventDayCond = new SwcEventDayCond();
		swcEventDayCond.setCompanyId(cUser.getCompanyId());

		String fromDateString = null;
		Date searchDay = null;
		CompanyCalendar[] companyCalendars = new CompanyCalendar[3];
		for(int i=0; i<3; i++) {
			CompanyCalendar companyCalendar = new CompanyCalendar();
			if(i == 0) {
			} else if(i == 1) {
				fromDate = new LocalDate(fromDate.getTime() + LocalDate.ONE_DAY);
			} else if(i == 2) {
				fromDate = new LocalDate(fromDate.getTime() + LocalDate.ONE_DAY * 2);
			}
			companyCalendar.setDate(fromDate);
			fromDateString = fromDate.toGMTDateString();
			searchDay = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateString);
			swcEventDayCond.setSearchDay(searchDay);
			SwcEventDay[] swcEventDays = getSwcManager().getEventdays(cUser.getId(), swcEventDayCond, IManager.LEVEL_LITE);

			List<User> userList = new ArrayList<User>();
			if(swcEventDays != null) {
				CompanyEvent[] companyEvents = new CompanyEvent[swcEventDays.length];
				List<CompanyEvent> companyEventList = new ArrayList<CompanyEvent>();
				for(SwcEventDay swcEventDay : swcEventDays) {
					CompanyEvent companyEvent = new CompanyEvent();
					boolean isHoliDay = swcEventDay.getType().equals(CompanyEvent.EVENT_TYPE_HOLIDAY) ? true : false;
					LocalDate plannedStart = new LocalDate(swcEventDay.getStartDay().getTime());
					LocalDate plannedEnd = new LocalDate(swcEventDay.getEndDay().getTime());
					String id = swcEventDay.getObjId();
					String name = swcEventDay.getName();
					if(swcEventDay.getReltdPerson() != null) {
						String[] reltdUsers = swcEventDay.getReltdPerson().split(";");
						for(String reltdUser : reltdUsers) {
							User relatedUser = ModelConverter.getUserByUserId(reltdUser);
							userList.add(relatedUser);
						}
						User[] relatedUsers = new User[userList.size()];
						userList.toArray(relatedUsers);
						companyEvent.setRelatedUsers(relatedUsers);
					}
					companyEvent.setId(id);
					companyEvent.setName(name);
					companyEvent.setIsHoliday(isHoliDay);
					companyEvent.setPlannedStart(plannedStart);
					companyEvent.setPlannedEnd(plannedEnd);
					companyEventList.add(companyEvent);
				}
				companyEventList.toArray(companyEvents);
				companyCalendar.setCompanyEvents(companyEvents);
			}
			companyCalendar.setDate(fromDate);
			companyCalendars[i] = companyCalendar;
		}

		for(int k = 0; k < companyCalendars.length; k++) {
			if(companyCalendars[k] == null) {
				companyCalendars[k] = new CompanyCalendar();
			}
		}
		return companyCalendars;
		//return SmartTest.getCompanyCalendars();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getCompanyCalendars(net.smartworks
	 * .util.LocalDate, net.smartworks.util.LocalDate)
	 */
	@Override
	public CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, LocalDate toDate) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getEventInstances(net.smartworks
	 * .util.LocalDate, int)
	 */
	@Override
	public EventInstanceInfo[] getMyEventInstances(LocalDate fromDate, int days) throws Exception {
		String workId = SmartWork.ID_EVENT_MANAGEMENT;
		User user = SmartUtil.getCurrentUser();

		SwdDomainCond swdDomainCond = new SwdDomainCond();
		swdDomainCond.setCompanyId(user.getCompanyId());

		SwfFormCond swfFormCond = new SwfFormCond();
		swfFormCond.setCompanyId(user.getCompanyId());
		swfFormCond.setPackageId(workId);

		swdDomainCond.setFormId(getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE)[0].getId());

		SwdDomain swdDomain = getSwdManager().getDomain(user.getId(), swdDomainCond, IManager.LEVEL_LITE);

		SwdRecordCond swdRecordCond = new SwdRecordCond();
		swdRecordCond.setCompanyId(user.getCompanyId());
		swdRecordCond.setFormId(swdDomain.getFormId());
		swdRecordCond.setDomainId(swdDomain.getObjId());

		swdRecordCond.setOrders(new Order[]{new Order(FormField.ID_CREATED_DATE, false)});

		SwdRecord[] swdRecords = getSwdManager().getRecords(user.getId(), swdRecordCond, IManager.LEVEL_LITE);

		SwdRecordExtend[] swdRecordExtends = getSwdManager().getCtgPkg(workId);

		List<EventInstanceInfo> eventInstanceInfoList = new ArrayList<EventInstanceInfo>();
		if(swdRecords != null) {
			for(int i=0; i < swdRecords.length; i++) {
				EventInstanceInfo eventInstanceInfo = new EventInstanceInfo();
				SwdRecord swdRecord = swdRecords[i];
				eventInstanceInfo.setId(swdRecord.getRecordId());
				eventInstanceInfo.setOwner(ModelConverter.getUserInfoByUserId(swdRecord.getCreationUser()));
				eventInstanceInfo.setCreatedDate(new LocalDate((swdRecord.getCreationDate()).getTime()));
				int type = WorkInstance.TYPE_INFORMATION;
				eventInstanceInfo.setType(type);
				eventInstanceInfo.setStatus(WorkInstance.STATUS_COMPLETED);
				eventInstanceInfo.setWorkSpace(null);

				WorkCategoryInfo groupInfo = null;
				if (!CommonUtil.isEmpty(swdRecordExtends[0].getSubCtgId()))
					groupInfo = new WorkCategoryInfo(swdRecordExtends[0].getSubCtgId(), swdRecordExtends[0].getSubCtg());

				WorkCategoryInfo categoryInfo = new WorkCategoryInfo(swdRecordExtends[0].getParentCtgId(), swdRecordExtends[0].getParentCtg());

				WorkInfo workInfo = new SmartWorkInfo(swdRecord.getFormId(), swdRecord.getFormName(), type, groupInfo, categoryInfo);

				eventInstanceInfo.setWork(workInfo);
				eventInstanceInfo.setLastModifier(ModelConverter.getUserInfoByUserId(swdRecord.getModificationUser()));
				eventInstanceInfo.setLastModifiedDate(new LocalDate((swdRecord.getModificationDate()).getTime()));

				SwdDataField[] swdDataFields = swdRecord.getDataFields();
				List<UserInfo> userInfoList = new ArrayList<UserInfo>();
				boolean isExistUser = false;
				for(SwdDataField swdDataField : swdDataFields) {
					String value = swdDataField.getValue();
					if(swdDataField.getId().equals("0")) {
						eventInstanceInfo.setSubject(value);
					} else if(swdDataField.getId().equals("6")) {
						eventInstanceInfo.setContent(value);
					} else if(swdDataField.getId().equals("1")) {
						eventInstanceInfo.setStart(LocalDate.convertGMTStringToLocalDate(value));
					} else if(swdDataField.getId().equals("2")) {
						if(value != null)
							eventInstanceInfo.setEnd(LocalDate.convertGMTStringToLocalDate(value));
					} else if(swdDataField.getId().equals("5")) {
						if(value != null) {
							String[] reltdUsers = value.split(";");
							for(String reltdUser : reltdUsers) {
								if(reltdUser.equals(user.getId()))
									isExistUser = true;
								UserInfo relatedUser = ModelConverter.getUserInfoByUserId(reltdUser);
								if(relatedUser != null)
									userInfoList.add(relatedUser);
							}
							UserInfo[] relatedUsers = new UserInfo[userInfoList.size()];
							userInfoList.toArray(relatedUsers);
							eventInstanceInfo.setRelatedUsers(relatedUsers);
						}
					}
				}
				if(isExistUser == true || swdRecord.getCreationUser().equals(user.getId()) || swdRecord.getModificationUser().equals(user.getId()))
					eventInstanceInfoList.add(eventInstanceInfo);
			}
			EventInstanceInfo[] eventInstanceInfos = new EventInstanceInfo[eventInstanceInfoList.size()];
			eventInstanceInfoList.toArray(eventInstanceInfos);
			return eventInstanceInfos;
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getEventInstances(net.smartworks
	 * .util.LocalDate, net.smartworks.util.LocalDate)
	 */
	@Override
	public EventInstanceInfo[] getMyEventInstances(LocalDate fromDate, LocalDate toDate) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getCompanyEventBox(net.smartworks
	 * .util.LocalDate)
	 */
	@Override
	public CompanyCalendar getCompanyEventBox(LocalDate date) throws Exception {
		return SmartTest.getCompanyEventBox(date);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getCompanyEventsByDate(net.smartworks
	 * .util.LocalDate, int)
	 */
	@Override
	public EventInstanceInfo[] getCompanyEventsByDate(LocalDate date, int maxEvents) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyEventsByDate(java.lang.String
	 * , net.smartworks.util.LocalDate, int)
	 */
	@Override
	public EventInstanceInfo[] getMyEventsByDate(LocalDate date, int maxEvents) throws Exception {
		return null;
	}
}
