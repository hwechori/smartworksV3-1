package net.smartworks.server.service;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.instance.EventInstance;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.util.LocalDate;

public interface ICalendarService {

	public abstract EventInstanceInfo[] getEventInstances(String companyId, String userId, LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract EventInstanceInfo[] getEventInstances(String companyId, String userId, LocalDate fromDate, int days) throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, LocalDate toDate) throws Exception;

	public abstract CompanyCalendar[] getCompanyCalendars(String companyId, LocalDate fromDate, int days) throws Exception;

	public abstract CompanyCalendar getCompanyEventBox(String companyId, LocalDate date) throws Exception;

	public abstract EventInstanceInfo[] getCompanyEventsByDate(String companyId, LocalDate date, int maxEvents) throws Exception;

	public abstract EventInstanceInfo[] getMyEventsByDate(String companyId, String userId, LocalDate date, int maxEvents) throws Exception;

}
