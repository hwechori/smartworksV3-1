package net.smartworks.server.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.RecordList;
import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.calendar.WorkHour;
import net.smartworks.model.calendar.WorkHourPolicy;
import net.smartworks.model.community.User;
import net.smartworks.model.company.CompanyGeneral;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.work.FormField;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.config.manager.ISwcManager;
import net.smartworks.server.engine.config.model.SwcWorkHour;
import net.smartworks.server.engine.config.model.SwcWorkHourCond;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoCompany;
import net.smartworks.server.engine.organization.model.SwoConfig;
import net.smartworks.server.service.ISettingsService;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartTest;
import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Service;

@Service
public class SettingsServiceImpl implements ISettingsService {

	private ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}
	private ISwcManager getSwcManager() {
		return SwManagerFactory.getInstance().getSwcManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.smartworks.service.impl.ISmartWorks#getMyDepartments(java.lang.String
	 * )
	 */
	@Override
	public CompanyGeneral getCompanyGeneral() throws Exception {

		try {
			User user = SmartUtil.getCurrentUser();
			String userId = user.getId();
			String companyId = user.getCompanyId();
			SwoCompany swoCompany = getSwoManager().getCompany(userId, companyId, IManager.LEVEL_ALL);
			SwoConfig swoConfig = getSwoManager().getConfig(userId, companyId, IManager.LEVEL_ALL);
			String id = swoCompany.getId();
			String name = swoCompany.getName();
			String logoName = getSwoManager().getLogo(userId, companyId);
			String sendMailHost = swoConfig.getSmtpAddress();
			String sendMailAccount = swoConfig.getUserId();
			String sendMailPassword = swoConfig.getPassword();
			boolean sendMailNotification = swoConfig.isActivity();
			CompanyGeneral companyGeneral = new CompanyGeneral();
			companyGeneral.setId(id);
			companyGeneral.setName(name);
			companyGeneral.setLogoName(logoName);
			companyGeneral.setSendMailHost(sendMailHost);
			companyGeneral.setSendMailAccount(sendMailAccount);
			companyGeneral.setSendMailPassword(sendMailPassword);
			companyGeneral.setSendMailNotification(sendMailNotification);
			companyGeneral.setTestAfterSaving(true);
			return companyGeneral;
		} catch(Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}		
	}

	@Override
	public void setCompanyGeneral(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try {

			User user = SmartUtil.getCurrentUser();
			String userId = user.getId();
			String companyId = user.getCompanyId();
			String companyName = user.getCompany();

			Map<String, Object> frmCompanyGeneral = (Map<String, Object>)requestBody.get("frmCompanyGeneral");
	
			Set<String> keySet = frmCompanyGeneral.keySet();
			Iterator<String> itr = keySet.iterator();
			List<Map<String, String>> files = null;
			String txtMailHost = null;
			String txtMailAccount = null;
			String pasMailPassword = null;
			boolean isActivity = false;
			String imgCompanyLogo = null;
			String companyFileId = null;
			String companyFileName = null;

			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				Object fieldValue = frmCompanyGeneral.get(fieldId);
				if (fieldValue instanceof LinkedHashMap) {
					Map<String, Object> valueMap = (Map<String, Object>)fieldValue;
					if(fieldId.equals("imgCompanyLogo")) {
						files = (ArrayList<Map<String,String>>)valueMap.get("files");
					}
				} else if(fieldValue instanceof String) {					
					if(fieldId.equals("txtMailHost")) {
						txtMailHost = (String)frmCompanyGeneral.get("txtMailHost");
					} else if(fieldId.equals("txtMailAccount")) {
						txtMailAccount = (String)frmCompanyGeneral.get("txtMailAccount");
					} else if(fieldId.equals("pasMailPassword")) {
						pasMailPassword = (String)frmCompanyGeneral.get("pasMailPassword");
					} else if(fieldId.equals("chkMailNotification")) {
						isActivity = true;
					}
				}
			}

			if(!files.isEmpty()) {
				for(int i=0; i < files.subList(0, files.size()).size(); i++) {
					Map<String, String> fileMap = files.get(i);
					companyFileId = fileMap.get("fileId");
					companyFileName = fileMap.get("fileName");
					imgCompanyLogo = SwManagerFactory.getInstance().getDocManager().insertProfilesFile(companyFileId, companyFileName, user.getCompanyId());
					getSwoManager().setLogo(user.getId(), user.getCompanyId(), imgCompanyLogo);
				}
			}

			SwoConfig swoConfig = getSwoManager().getConfig(userId, companyId, IManager.LEVEL_ALL);

			swoConfig.setId(companyId);
			swoConfig.setName(companyName);
			swoConfig.setCompanyId(companyId);
			swoConfig.setSmtpAddress(txtMailHost);
			swoConfig.setUserId(txtMailAccount);
			swoConfig.setPassword(pasMailPassword);
			swoConfig.setActivity(isActivity);
			getSwoManager().setConfig(userId, swoConfig, IManager.LEVEL_ALL);

		} catch(Exception e) {
			e.printStackTrace();			
		}
	}
	
	@Override
	public RecordList getWorkHourPolicyList(RequestParams params) throws Exception {

		try{

			RecordList recordList = new RecordList();
			User cUser = SmartUtil.getCurrentUser();

			SwcWorkHourCond swcWorkHourCond = new SwcWorkHourCond();
			swcWorkHourCond.setCompanyId(cUser.getCompanyId());

			long totalCount = getSwcManager().getWorkhourSize(cUser.getId(), swcWorkHourCond);

			int pageSize = params.getPageSize();
			if(pageSize == 0) pageSize = 20;

			int currentPage = params.getCurrentPage();
			if(currentPage == 0) currentPage = 1;

			int totalPages = (int)totalCount % pageSize;

			if(totalPages == 0)
				totalPages = (int)totalCount / pageSize;
			else
				totalPages = (int)totalCount / pageSize + 1;

			if (currentPage > 0)
				swcWorkHourCond.setPageNo(currentPage-1);

			if((long)((pageSize * (currentPage - 1)) + 1) > totalCount)
				currentPage = 1;

			swcWorkHourCond.setPageSize(pageSize);

			swcWorkHourCond.setOrders(new Order[]{new Order("modificationDate", false)});
			SwcWorkHour[] swcWorkHours = getSwcManager().getWorkhours(cUser.getId(), swcWorkHourCond, IManager.LEVEL_ALL); 
			List<WorkHourPolicy> workHourPolicyList = new ArrayList<WorkHourPolicy>();

			if(swcWorkHours != null) {
				for(int i=0; i<swcWorkHours.length; i++) {
					SwcWorkHour swcWorkHour = swcWorkHours[i];
					int firstDayOfWeek = Integer.parseInt(swcWorkHour.getStartDayOfWeek()); 
					int workingDays = swcWorkHour.getWorkingDays();

					WorkHourPolicy workHourPolicy = new WorkHourPolicy();
					workHourPolicy.setId(swcWorkHour.getObjId());
					workHourPolicy.setValidFrom(new LocalDate(swcWorkHour.getValidFromDate().getTime()));
					if(swcWorkHour.getValidToDate() != null)
						workHourPolicy.setValidTo(new LocalDate(swcWorkHour.getValidToDate().getTime()));
					workHourPolicy.setFirstDayOfWeek(firstDayOfWeek);
					workHourPolicy.setWorkingDays(workingDays);

					WorkHour[] workHours = new WorkHour[7];
					for(int j=firstDayOfWeek; j<firstDayOfWeek+workingDays; j++) {

						int start;
						int end;
						int workTime;
		
						Calendar startCalendar = Calendar.getInstance();
						Calendar endCalendar = Calendar.getInstance();
						int dayOfWeek = j;
		
						if(j > 7)
							dayOfWeek = j % 7;

						switch (dayOfWeek) {
						case Calendar.SUNDAY:
							startCalendar.setTime(swcWorkHour.getSunStartTime());
							endCalendar.setTime(swcWorkHour.getSunEndTime());
							break;
						case Calendar.MONDAY:
							startCalendar.setTime(swcWorkHour.getMonStartTime());
							endCalendar.setTime(swcWorkHour.getMonEndTime());
							break;
						case Calendar.TUESDAY:
							startCalendar.setTime(swcWorkHour.getTueStartTime());
							endCalendar.setTime(swcWorkHour.getTueEndTime());
							break;
						case Calendar.WEDNESDAY:
							startCalendar.setTime(swcWorkHour.getWedStartTime());
							endCalendar.setTime(swcWorkHour.getWedEndTime());
							break;
						case Calendar.THURSDAY:
							startCalendar.setTime(swcWorkHour.getThuStartTime());
							endCalendar.setTime(swcWorkHour.getThuEndTime());
							break;
						case Calendar.FRIDAY:
							startCalendar.setTime(swcWorkHour.getFriStartTime());
							endCalendar.setTime(swcWorkHour.getFriEndTime());
							break;
						case Calendar.SATURDAY:
							startCalendar.setTime(swcWorkHour.getSatStartTime());
							endCalendar.setTime(swcWorkHour.getSatEndTime());
							break;
						default: 
							break;
						}
						start = startCalendar.get(Calendar.HOUR_OF_DAY) * LocalDate.ONE_HOUR + startCalendar.get(Calendar.MINUTE) * LocalDate.ONE_MINUTE;
						end = endCalendar.get(Calendar.HOUR_OF_DAY) * LocalDate.ONE_HOUR + endCalendar.get(Calendar.MINUTE) * LocalDate.ONE_MINUTE;
						workTime = end - start;

						workHours[dayOfWeek-1] = new WorkHour(start, end, workTime);
					}
					workHourPolicy.setWorkHours(workHours);
					workHourPolicyList.add(workHourPolicy);
				}
				WorkHourPolicy[] workHourPolicies = new WorkHourPolicy[workHourPolicyList.size()];
				workHourPolicyList.toArray(workHourPolicies);

				recordList.setRecords(workHourPolicies);
				recordList.setPageSize(pageSize);
				recordList.setTotalPages(totalPages);
				recordList.setCurrentPage(currentPage);
				recordList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);

				return recordList;
			} else {
				return null;
			}

		 }catch(Exception e) {
			e.printStackTrace();
			return null;			
		}		

	}

	@Override
	public WorkHourPolicy getWorkHourPolicyById(String id) throws Exception {

		try {

			User user = SmartUtil.getCurrentUser();
			SwcWorkHour swcWorkHour = getSwcManager().getWorkhour(user.getId(), id, IManager.LEVEL_ALL);
			WorkHourPolicy workHourPolicy = new WorkHourPolicy();

			if(swcWorkHour != null) {
				int firstDayOfWeek = Integer.parseInt(swcWorkHour.getStartDayOfWeek()); 
				int workingDays = swcWorkHour.getWorkingDays();

				workHourPolicy.setValidFrom(new LocalDate(swcWorkHour.getValidFromDate().getTime()));
				if(swcWorkHour.getValidToDate() != null)
					workHourPolicy.setValidTo(new LocalDate(swcWorkHour.getValidToDate().getTime()));
				workHourPolicy.setFirstDayOfWeek(firstDayOfWeek);
				workHourPolicy.setWorkingDays(workingDays);
	
				WorkHour[] workHours = new WorkHour[7];
				for(int j=firstDayOfWeek; j<firstDayOfWeek+workingDays; j++) {

					int start;
					int end;
					int workTime;
	
					Calendar startCalendar = Calendar.getInstance();
					Calendar endCalendar = Calendar.getInstance();
					int dayOfWeek = j;
	
					if(j > 7)
						dayOfWeek = j % 7;
	
					switch (dayOfWeek) {
					case Calendar.SUNDAY:
						startCalendar.setTime(swcWorkHour.getSunStartTime());
						endCalendar.setTime(swcWorkHour.getSunEndTime());
						break;
					case Calendar.MONDAY:
						startCalendar.setTime(swcWorkHour.getMonStartTime());
						endCalendar.setTime(swcWorkHour.getMonEndTime());
						break;
					case Calendar.TUESDAY:
						startCalendar.setTime(swcWorkHour.getTueStartTime());
						endCalendar.setTime(swcWorkHour.getTueEndTime());
						break;
					case Calendar.WEDNESDAY:
						startCalendar.setTime(swcWorkHour.getWedStartTime());
						endCalendar.setTime(swcWorkHour.getWedEndTime());
						break;
					case Calendar.THURSDAY:
						startCalendar.setTime(swcWorkHour.getThuStartTime());
						endCalendar.setTime(swcWorkHour.getThuEndTime());
						break;
					case Calendar.FRIDAY:
						startCalendar.setTime(swcWorkHour.getFriStartTime());
						endCalendar.setTime(swcWorkHour.getFriEndTime());
						break;
					case Calendar.SATURDAY:
						startCalendar.setTime(swcWorkHour.getSatStartTime());
						endCalendar.setTime(swcWorkHour.getSatEndTime());
						break;
					default:
						break;
					}
					start = startCalendar.get(Calendar.HOUR_OF_DAY) * LocalDate.ONE_HOUR + startCalendar.get(Calendar.MINUTE) * LocalDate.ONE_MINUTE;
					end = endCalendar.get(Calendar.HOUR_OF_DAY) * LocalDate.ONE_HOUR + endCalendar.get(Calendar.MINUTE) * LocalDate.ONE_MINUTE;
					workTime = end - start;
	
					workHours[dayOfWeek-1] = new WorkHour(start, end, workTime);
				}
				workHourPolicy.setWorkHours(workHours);
			} else {
				workHourPolicy = new WorkHourPolicy();
			}

			return workHourPolicy;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public void setWorkHourPolicy(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try {

			User user = SmartUtil.getCurrentUser();
			String userId = user.getId();
			String companyId = user.getCompanyId();

			Map<String, Object> frmEditWorkHour = (Map<String, Object>)requestBody.get("frmEditWorkHour");

			String objId = (String)requestBody.get("objId");

			Set<String> keySet = frmEditWorkHour.keySet();
			Iterator<String> itr = keySet.iterator();

			Date datValidFrom = null;
			String selFirstDayOfWeek = null;
			int selWorkingDays = 0;
			List<String> timWorkStart = null;
			List<String> timWorkEnd = null;
			Date startTime = null;
			Date endTime = null;

			SwcWorkHour swcWorkHour = null;
			if(objId != null)
				swcWorkHour = getSwcManager().getWorkhour(userId, objId, IManager.LEVEL_ALL);
			else
				swcWorkHour = new SwcWorkHour();

			while (itr.hasNext()) {
				String fieldId = (String)itr.next();
				Object fieldValue = frmEditWorkHour.get(fieldId);
				if(fieldValue instanceof String) {					
					if(fieldId.equals("datValidFrom")) {
						datValidFrom = new Date(LocalDate.convertLocalDateStringToLocalDate((String)frmEditWorkHour.get("datValidFrom")).getTime());
						swcWorkHour.setValidFromDate(datValidFrom);
					} else if(fieldId.equals("selFirstDayOfWeek")) {
						selFirstDayOfWeek = (String)frmEditWorkHour.get("selFirstDayOfWeek");
						swcWorkHour.setStartDayOfWeek(selFirstDayOfWeek);
					} else if(fieldId.equals("selWorkingDays")) {
						//selWorkingDays = Integer.parseInt((String)frmEditWorkHour.get("selWorkingDays"));
						//swcWorkHour.setWorkingDays(selWorkingDays);
					}
				} else if(fieldValue instanceof ArrayList) {
					if(fieldId.equals("timWorkStart")) {
						timWorkStart = (ArrayList<String>)frmEditWorkHour.get("timWorkStart");
						selWorkingDays = 0;
						for(int i=0; i<timWorkStart.size(); i++) {
							if(!timWorkStart.get(i).equals("00:00"))
								selWorkingDays++;
							startTime = LocalDate.convertTimeStringToDate(timWorkStart.get(i));
							if(i==0)swcWorkHour.setSunStartTime(startTime);
							else if(i==1)swcWorkHour.setMonStartTime(startTime);
							else if(i==2)swcWorkHour.setTueStartTime(startTime);
							else if(i==3)swcWorkHour.setWedStartTime(startTime);
							else if(i==4)swcWorkHour.setThuStartTime(startTime);
							else if(i==5)swcWorkHour.setFriStartTime(startTime);
							else if(i==6)swcWorkHour.setSatStartTime(startTime);
						}
						swcWorkHour.setWorkingDays(selWorkingDays);
					} else if(fieldId.equals("timWorkEnd")) {
						timWorkEnd = (ArrayList<String>)frmEditWorkHour.get("timWorkEnd");
						for(int i=0; i<timWorkEnd.size(); i++) {
							endTime = LocalDate.convertTimeStringToDate(timWorkEnd.get(i));
							if(i==0)swcWorkHour.setSunEndTime(endTime);
							else if(i==1)swcWorkHour.setMonEndTime(endTime);
							else if(i==2)swcWorkHour.setTueEndTime(endTime);
							else if(i==3)swcWorkHour.setWedEndTime(endTime);
							else if(i==4)swcWorkHour.setThuEndTime(endTime);
							else if(i==5)swcWorkHour.setFriEndTime(endTime);
							else if(i==6)swcWorkHour.setSatEndTime(endTime);
						}
					}
				}
			}
			swcWorkHour.setCompanyId(companyId);
			swcWorkHour.setType("0");
			getSwcManager().setWorkhour(userId, swcWorkHour, IManager.LEVEL_ALL);

		}catch (Exception e){
			e.printStackTrace();
			return;
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
	
}