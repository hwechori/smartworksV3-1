package net.smartworks.server.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.RecordList;
import net.smartworks.model.approval.ApprovalLine;
import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.calendar.WorkHourPolicy;
import net.smartworks.model.company.CompanyGeneral;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.service.ExternalForm;
import net.smartworks.model.service.WebService;
import net.smartworks.server.service.ISettingsService;
import net.smartworks.util.SmartTest;

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
	public RecordList getWorkHourPolicyList(RequestParams params) throws Exception {

		try{
			RecordList recordList =  new RecordList();			
			// 테스트용도이니, 실구현시에는 제거 바람.
			recordList.setRecords(new WorkHourPolicy[]{new WorkHourPolicy(), new WorkHourPolicy()});
			// 테스트용도이니, 실구현시에는 제거 바람.
			return recordList;
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
	public void removeWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public RecordList getCompanyEventList(RequestParams params) throws Exception {

		try{
			RecordList recordList = new RecordList();
			recordList.setRecords(new CompanyEvent[]{SmartTest.getCompanyEvent1(), SmartTest.getCompanyEvent2()});
			return recordList;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public CompanyEvent getCompanyEventById(String id) throws Exception {

		try{
			return new CompanyEvent();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setCompanyEvent(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public void removeCompanyEvent(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public RecordList getApprovalLineList(RequestParams params) throws Exception {

		try{
			RecordList recordList = new RecordList();
			recordList.setRecords(new ApprovalLine[]{});
			return recordList;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public ApprovalLine getApprovalLineById(String id) throws Exception {

		try{
			return new ApprovalLine();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setApprovalLine(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public void removeApprovalLine(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public RecordList getWebServiceList(RequestParams params) throws Exception {

		try{
			RecordList recordList = new RecordList();
			recordList.setRecords(new WebService[]{});
			return recordList;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public WebService getWebServiceById(String id) throws Exception {

		try{
			return new WebService();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setWebService(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public void removeWebService(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public RecordList getExternalFormList(RequestParams params) throws Exception {

		try{
			RecordList recordList = new RecordList();
			recordList.setRecords(new ExternalForm[]{});
			return recordList;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public ExternalForm getExternalFormById(String id) throws Exception {

		try{
			return new ExternalForm();
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setExternalForm(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
	@Override
	public void removeExternalForm(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
	
}