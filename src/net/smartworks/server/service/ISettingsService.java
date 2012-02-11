package net.smartworks.server.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.WorkHourPolicy;
import net.smartworks.model.company.CompanyGeneral;

public interface ISettingsService {

	public abstract CompanyGeneral getCompanyGeneral() throws Exception;

	public abstract void setCompanyGeneral(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract WorkHourPolicy[] getWorkHourPolicies() throws Exception;
	
	public abstract WorkHourPolicy getWorkHourPolicyById(String id) throws Exception;
	
	public abstract void setWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
	public abstract CompanyCalendar[] getCompanyCalendars() throws Exception;
	
	public abstract CompanyCalendar getCompanyCalendarById(String id) throws Exception;
	
	public abstract void setCompanyCalendar(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
	
}