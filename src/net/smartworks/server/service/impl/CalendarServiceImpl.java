package net.smartworks.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.community.User;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.config.manager.ISwcManager;
import net.smartworks.server.engine.config.model.SwcEventDay;
import net.smartworks.server.engine.config.model.SwcEventDayCond;
import net.smartworks.server.engine.factory.SwManagerFactory;
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getCompanyCalendars(net.smartworks
	 * .util.LocalDate, int)
	 */
	@Override
	public CompanyCalendar[] getCompanyCalendars(LocalDate fromDate, int days) throws Exception {

		/*User cUser = SmartUtil.getCurrentUser();

		SwcEventDayCond swcEventDayCond = new SwcEventDayCond();
		swcEventDayCond.setCompanyId(cUser.getCompanyId());

		String fromDateString = null;
		Date searchDay = null;
		List<CompanyCalendar> companyCalendarList = new ArrayList<CompanyCalendar>();
		for(int i=0; i<3; i++) {
			CompanyCalendar companyCalendar = new CompanyCalendar();
			if(i == 0) {
				fromDateString = new LocalDate(fromDate.getGMTDate()).toLocalDateSimpleDashString();
				companyCalendar.setDate(fromDate);
			} else if(i == 1) {
				fromDateString = new LocalDate(fromDate.getGMTDate() + LocalDate.ONE_DAY).toLocalDateSimpleDashString();
				companyCalendar.setDate(new LocalDate(fromDate.getGMTDate() + LocalDate.ONE_DAY));
			} else if(i == 2) {
				fromDateString = new LocalDate(fromDate.getGMTDate() + LocalDate.ONE_DAY * 2).toLocalDateSimpleDashString();
				companyCalendar.setDate(new LocalDate(fromDate.getGMTDate() + LocalDate.ONE_DAY * 2));
			}
			System.out.println(i +": "+ fromDateString);
			searchDay = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateString);
			System.out.println(i +": "+ searchDay);
			swcEventDayCond.setSearchDay(searchDay);
			SwcEventDay[] swcEventDays = getSwcManager().getEventdays(cUser.getId(), swcEventDayCond, IManager.LEVEL_LITE);

			List<User> userList = new ArrayList<User>();
			if(swcEventDays != null) {
				CompanyEvent[] companyEvents = new CompanyEvent[swcEventDays.length];
				for(int j = 0; j < swcEventDays.length; j++) {
					SwcEventDay swcEventDay = swcEventDays[i];
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
					}
					User[] relatedUsers = new User[userList.size()];
					userList.toArray(relatedUsers);
	
					CompanyEvent companyEvent = new CompanyEvent();
					companyEvent.setId(id);
					companyEvent.setName(name);
					companyEvent.setIsHoliday(isHoliDay);
					companyEvent.setRelatedUsers(relatedUsers);
					companyEvent.setPlannedStart(plannedStart);
					companyEvent.setPlannedEnd(plannedEnd);

					companyEvents[j] = companyEvent;
				}
				companyCalendar.setCompanyEvents(companyEvents);

			}
			companyCalendarList.add(companyCalendar);
		}

		CompanyCalendar[] companyCalendars = new CompanyCalendar[3];

		companyCalendarList.toArray(companyCalendars);

		for(int k = 0; k < companyCalendars.length; k++) {
			if(companyCalendars[k] == null) {
				companyCalendars[k] = new CompanyCalendar();
			}
		}
		return companyCalendars;*/
		return SmartTest.getCompanyCalendars();

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
		return SmartTest.getEventInstances();
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
