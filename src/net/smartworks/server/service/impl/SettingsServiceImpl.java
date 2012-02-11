package net.smartworks.server.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.WorkHourPolicy;
import net.smartworks.model.company.CompanyGeneral;
import net.smartworks.server.service.ISettingsService;
import org.springframework.stereotype.Service;

@Service
public class SettingsServiceImpl implements ISettingsService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyDepartments(java.lang.String
	 * )
	 */
	@Override
	public CompanyGeneral getCompanyGeneral() throws Exception {

		try{
			return new CompanyGeneral();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setCompanyGeneral(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public WorkHourPolicy[] getWorkHourPolicies() throws Exception {

		try{
			return new WorkHourPolicy[]{};
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public WorkHourPolicy getWorkHourPolicyById(String id) throws Exception {

		try{
			return new WorkHourPolicy();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public CompanyCalendar[] getCompanyCalendars() throws Exception {

		try{
			return new CompanyCalendar[]{};
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public CompanyCalendar getCompanyCalendarById(String id) throws Exception {

		try{
			return new CompanyCalendar();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setCompanyCalendar(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	

}