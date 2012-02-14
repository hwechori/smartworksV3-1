package net.smartworks.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.calendar.WorkHour;
import net.smartworks.model.calendar.WorkHourPolicy;
import net.smartworks.model.community.Community;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.User;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Order;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.config.manager.ISwcManager;
import net.smartworks.server.engine.config.model.SwcEventDay;
import net.smartworks.server.engine.config.model.SwcEventDayCond;
import net.smartworks.server.engine.config.model.SwcWorkHour;
import net.smartworks.server.engine.config.model.SwcWorkHourCond;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordExtend;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
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

		try{
			User cUser = SmartUtil.getCurrentUser();
	
			SwcWorkHourCond swcWorkHourCond = new SwcWorkHourCond();
			swcWorkHourCond.setCompanyId(cUser.getCompanyId());
	
			swcWorkHourCond.setOrders(new Order[]{new Order("validFromDate", false)});
	
			SwcWorkHour[] swcWorkHours = getSwcManager().getWorkhours(cUser.getId(), swcWorkHourCond, IManager.LEVEL_ALL); 
	
			SwcEventDayCond swcEventDayCond = new SwcEventDayCond();
			swcEventDayCond.setCompanyId(cUser.getCompanyId());
	
			String fromDateString = null;
			Date searchDay = null;
			CompanyCalendar[] companyCalendars = new CompanyCalendar[days];
			SwcWorkHour swcWorkHour = new SwcWorkHour();
			for(int i=0; i<days; i++) {
				CompanyCalendar companyCalendar = new CompanyCalendar();
	
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fromDate);
				int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
				int start = 0;
				int end = 0;
				int workTime = 0;
	
				if(swcWorkHours != null) {
					for(int j=0; j<swcWorkHours.length; j++) {
						swcWorkHour = swcWorkHours[j];
						if((new LocalDate(swcWorkHour.getValidFromDate().getTime())).getTime() <= fromDate.getTime()) {
							swcWorkHour = swcWorkHours[j];
							break;
						}
					}
	
					Calendar startCalendar = Calendar.getInstance();
					Calendar endCalendar = Calendar.getInstance();
	
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
	
					companyCalendar.setWorkHour(new WorkHour(start, end, workTime));
				} else {
					companyCalendar.setWorkHour(new WorkHourPolicy().getWorkHour(dayOfWeek));
				}
	
				companyCalendar.setDate(fromDate);
				fromDateString = fromDate.toGMTDateString();
				searchDay = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateString);
				swcEventDayCond.setSearchDay(searchDay);
				SwcEventDay[] swcEventDays = getSwcManager().getEventdays(cUser.getId(), swcEventDayCond, IManager.LEVEL_LITE);
	
				List<Community> userList = new ArrayList<Community>();
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
								if(reltdUser.equals(cUser.getId())) {
									User relatedUser = ModelConverter.getUserByUserId(reltdUser);
									if(relatedUser != null)
										userList.add(relatedUser);
								} else if(reltdUser.equals(cUser.getDepartmentId())) {
									Department relatedUser = ModelConverter.getDepartmentByDepartmentId(reltdUser);
									if(relatedUser != null)
										userList.add(relatedUser);
								}
	// TO DO					else if(reltdUser.getClass().equals(Group.class))
	// TO DO						userList.add(ModelConverter.getGroupByGroupId(reltdUser));
							}
							Community[] relatedUsers = new Community[userList.size()];
							userList.toArray(relatedUsers);
							companyEvent.setRelatedUsers(relatedUsers);
						}
						companyEvent.setId(id);
						companyEvent.setName(name);
						companyEvent.setHoliday(isHoliDay);
						companyEvent.setPlannedStart(plannedStart);
						companyEvent.setPlannedEnd(plannedEnd);
						companyEventList.add(companyEvent);
					}
					companyEventList.toArray(companyEvents);
					companyCalendar.setCompanyEvents(companyEvents);
				}
				companyCalendars[i] = companyCalendar;
				fromDate = new LocalDate(fromDate.getTime() + LocalDate.ONE_DAY);
			}
	
			for(int k = 0; k < companyCalendars.length; k++) {
				if(companyCalendars[k] == null) {
					companyCalendars[k] = new CompanyCalendar();
				}
			}
			return companyCalendars;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
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

		try{
			return getCompanyCalendars(fromDate, (int)LocalDate.getDiffDate(fromDate, toDate)+1);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
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

		LocalDate toDate = new LocalDate(fromDate.getTime() + LocalDate.ONE_DAY*(days-1));

		return this.getMyEventInstances(fromDate, toDate);

/*		try{
			String workId = SmartWork.ID_EVENT_MANAGEMENT;
			User user = SmartUtil.getCurrentUser();
	
			SwdDomainCond swdDomainCond = new SwdDomainCond();
			swdDomainCond.setCompanyId(user.getCompanyId());
	
			SwfFormCond swfFormCond = new SwfFormCond();
			swfFormCond.setCompanyId(user.getCompanyId());
			swfFormCond.setPackageId(workId);
	
			SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE);
	
			if(swfForms == null)
				return null;
			
			String formId = swfForms[0].getId();
	
			swdDomainCond.setFormId(formId);
	
			SwdDomain swdDomain = getSwdManager().getDomain(user.getId(), swdDomainCond, IManager.LEVEL_LITE);
	
			SwdRecordCond swdRecordCond = new SwdRecordCond();
			swdRecordCond.setCompanyId(user.getCompanyId());
			swdRecordCond.setFormId(swdDomain.getFormId());
			swdRecordCond.setDomainId(swdDomain.getObjId());
	
			swdRecordCond.setOrders(new Order[]{new Order(FormField.ID_CREATED_DATE, false)});
	
			List<Filter> filterList = new ArrayList<Filter>();
			Filter filter1 = new Filter();
			Filter filter2 = new Filter();
	
			LocalDate toDate = new LocalDate(fromDate.getTime() + LocalDate.ONE_DAY*(days-1));
	
			String formFieldId = "1";
			String tableColName = getSwdManager().getTableColName(swdDomain.getObjId(), formFieldId);
	
			filter1.setLeftOperandValue(tableColName);
			filter1.setOperator(">=");
			filter1.setRightOperandType(Filter.OPERANDTYPE_DATETIME);
			filter1.setRightOperandValue(LocalDate.convertLocalDateStringToLocalDate(fromDate.toLocalDateSimpleString()).toGMTDateString());
			filterList.add(filter1);
	
			filter2.setLeftOperandValue(tableColName);
			filter2.setOperator("<=");
			filter2.setRightOperandType(Filter.OPERANDTYPE_DATETIME);
			filter2.setRightOperandValue(new LocalDate((LocalDate.convertLocalDateStringToLocalDate(toDate.toLocalDateSimpleString()).getTime() + LocalDate.ONE_DAY)).toGMTDateString());
			filterList.add(filter2);

			Filter[] filters = new Filter[2];
			filterList.toArray(filters);
	
			swdRecordCond.setFilter(filters);
	
			SwdRecord[] swdRecords = getSwdManager().getRecords(user.getId(), swdRecordCond, IManager.LEVEL_ALL);
	
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
					List<CommunityInfo> userInfoList = new ArrayList<CommunityInfo>();
					for(SwdDataField swdDataField : swdDataFields) {
						String value = swdDataField.getValue();
						String refRecordId = swdDataField.getRefRecordId();
						if(swdDataField.getId().equals("0")) {
							eventInstanceInfo.setSubject(value);
						} else if(swdDataField.getId().equals("6")) {
							eventInstanceInfo.setContent(value);
						} else if(swdDataField.getId().equals("1")) {
							LocalDate start = LocalDate.convertGMTStringToLocalDate(value);
							LocalDate fromDateVal = fromDate;
							for(int j=0; j<days; j++) {
								String startString = start.toLocalDateSimpleString();
								String fromDateString = fromDateVal.toLocalDateSimpleString();
								if(startString.equals(fromDateString)) {
									eventInstanceInfo.setStart(start);
								}
								fromDateVal = new LocalDate(fromDateVal.getTime() + LocalDate.ONE_DAY);
							}
							eventInstanceInfo.setStart(start);
						} else if(swdDataField.getId().equals("2")) {
							if(value != null)
								eventInstanceInfo.setEnd(LocalDate.convertGMTStringToLocalDate(value));
						} else if(swdDataField.getId().equals("5")) {
							if(refRecordId != null) {
								String[] reltdUsers = refRecordId.split(";");
								for(String reltdUser : reltdUsers) {
									if(reltdUser.equals(user.getId())) {
										UserInfo relatedUser = ModelConverter.getUserInfoByUserId(reltdUser);
										if(relatedUser != null)
											userInfoList.add(relatedUser);
									} else if(reltdUser.equals(user.getDepartmentId())) {
										DepartmentInfo relatedUser = ModelConverter.getDepartmentInfoByDepartmentId(reltdUser);
										if(relatedUser != null)
											userInfoList.add(relatedUser);
	// TO DO						} else if(reltdUser.equals(user.getGroupId())) {
	// TO DO							GroupInfo relatedUser = ModelConverter.getGroupInfoByGroupId(reltdUser);
	// TO DO							if(relatedUser != null)
	// TO DO								userInfoList.add(relatedUser);
									}
								}
								CommunityInfo[] relatedUsers = new CommunityInfo[userInfoList.size()];
								userInfoList.toArray(relatedUsers);
								eventInstanceInfo.setRelatedUsers(relatedUsers);
							}
						}
					}
					if(eventInstanceInfo.getRelatedUsers() != null) {
						eventInstanceInfoList.add(eventInstanceInfo);
					} else if(swdRecord.getCreationUser().equals(user.getId()) || swdRecord.getModificationUser().equals(user.getId())) {
						eventInstanceInfoList.add(eventInstanceInfo);
					}
				}
				EventInstanceInfo[] eventInstanceInfos = new EventInstanceInfo[eventInstanceInfoList.size()];
				eventInstanceInfoList.toArray(eventInstanceInfos);
				return eventInstanceInfos;
			}
	
			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}*/
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

		try{
			String workId = SmartWork.ID_EVENT_MANAGEMENT;
			User user = SmartUtil.getCurrentUser();
	
			SwdDomainCond swdDomainCond = new SwdDomainCond();
			swdDomainCond.setCompanyId(user.getCompanyId());
	
			SwfFormCond swfFormCond = new SwfFormCond();
			swfFormCond.setCompanyId(user.getCompanyId());
			swfFormCond.setPackageId(workId);
	
			SwfForm[] swfForms = getSwfManager().getForms(user.getId(), swfFormCond, IManager.LEVEL_LITE);
	
			if(swfForms == null)
				return null;
			
			String formId = swfForms[0].getId();
	
			swdDomainCond.setFormId(formId);
	
			SwdDomain swdDomain = getSwdManager().getDomain(user.getId(), swdDomainCond, IManager.LEVEL_LITE);
	
			SwdRecordCond swdRecordCond = new SwdRecordCond();
			swdRecordCond.setCompanyId(user.getCompanyId());
			swdRecordCond.setFormId(swdDomain.getFormId());
			swdRecordCond.setDomainId(swdDomain.getObjId());
	
			swdRecordCond.setOrders(new Order[]{new Order(FormField.ID_CREATED_DATE, false)});
	
			List<Filter> filterList = new ArrayList<Filter>();
			Filter filter1 = new Filter();
			Filter filter2 = new Filter();

			String formFieldId = "1";
			String tableColName = getSwdManager().getTableColName(swdDomain.getObjId(), formFieldId);
	
			filter1.setLeftOperandValue(tableColName);
			filter1.setOperator(">=");
			filter1.setRightOperandType(Filter.OPERANDTYPE_DATETIME);
			filter1.setRightOperandValue(LocalDate.convertLocalDateStringToLocalDate(fromDate.toLocalDateSimpleString()).toGMTDateString());
			filterList.add(filter1);

			filter2.setLeftOperandValue(tableColName);
			filter2.setOperator("<=");
			filter2.setRightOperandType(Filter.OPERANDTYPE_DATETIME);
			filter2.setRightOperandValue(new LocalDate((LocalDate.convertLocalDateStringToLocalDate(toDate.toLocalDateSimpleString()).getTime() + LocalDate.ONE_DAY)).toGMTDateString());
			filterList.add(filter2);
	
			Filter[] filters = new Filter[2];
			filterList.toArray(filters);
	
			swdRecordCond.setFilter(filters);
	
			SwdRecord[] swdRecords = getSwdManager().getRecords(user.getId(), swdRecordCond, IManager.LEVEL_ALL);
	
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
					List<CommunityInfo> userInfoList = new ArrayList<CommunityInfo>();
					for(SwdDataField swdDataField : swdDataFields) {
						String value = swdDataField.getValue();
						String refRecordId = swdDataField.getRefRecordId();
						if(swdDataField.getId().equals("0")) {
							eventInstanceInfo.setSubject(value);
						} else if(swdDataField.getId().equals("6")) {
							eventInstanceInfo.setContent(value);
						} else if(swdDataField.getId().equals("1")) {
							LocalDate start = LocalDate.convertGMTStringToLocalDate(value);
							/*LocalDate fromDateVal = fromDate;
							for(int j=0; j<days; j++) {
								String startString = start.toLocalDateSimpleString();
								String fromDateString = fromDateVal.toLocalDateSimpleString();
								if(startString.equals(fromDateString)) {
									eventInstanceInfo.setStart(start);
								}
								fromDateVal = new LocalDate(fromDateVal.getTime() + LocalDate.ONE_DAY);
							}*/
							eventInstanceInfo.setStart(start);
						} else if(swdDataField.getId().equals("2")) {
							if(value != null)
								eventInstanceInfo.setEnd(LocalDate.convertGMTStringToLocalDate(value));
						} else if(swdDataField.getId().equals("5")) {
							if(refRecordId != null) {
								String[] reltdUsers = refRecordId.split(";");
								for(String reltdUser : reltdUsers) {
									if(reltdUser.equals(user.getId())) {
										UserInfo relatedUser = ModelConverter.getUserInfoByUserId(reltdUser);
										if(relatedUser != null)
											userInfoList.add(relatedUser);
									} else if(reltdUser.equals(user.getDepartmentId())) {
										DepartmentInfo relatedUser = ModelConverter.getDepartmentInfoByDepartmentId(reltdUser);
										if(relatedUser != null)
											userInfoList.add(relatedUser);
	// TO DO						} else if(reltdUser.equals(user.getGroupId())) {
	// TO DO							GroupInfo relatedUser = ModelConverter.getGroupInfoByGroupId(reltdUser);
	// TO DO							if(relatedUser != null)
	// TO DO								userInfoList.add(relatedUser);
									}
								}
								CommunityInfo[] relatedUsers = new CommunityInfo[userInfoList.size()];
								userInfoList.toArray(relatedUsers);
								eventInstanceInfo.setRelatedUsers(relatedUsers);
							}
						}
					}
					if(eventInstanceInfo.getRelatedUsers() != null) {
						eventInstanceInfoList.add(eventInstanceInfo);
					} else if(swdRecord.getCreationUser().equals(user.getId()) || swdRecord.getModificationUser().equals(user.getId())) {
						eventInstanceInfoList.add(eventInstanceInfo);
					}
				}
				EventInstanceInfo[] eventInstanceInfos = new EventInstanceInfo[eventInstanceInfoList.size()];
				eventInstanceInfoList.toArray(eventInstanceInfos);
				return eventInstanceInfos;
			}
	
			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
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
		try{
			return SmartTest.getCompanyEventBox(date);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
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
		try{
			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
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
		try{
			return null;
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

	@Override
	public WorkHourPolicy getCompanyWorkHourPolicy() throws Exception {

		try{
			User cUser = SmartUtil.getCurrentUser();
	
			SwcWorkHourCond swcWorkHourCond = new SwcWorkHourCond();
			swcWorkHourCond.setCompanyId(cUser.getCompanyId());
	
			swcWorkHourCond.setOrders(new Order[]{new Order("validFromDate", false), new Order("modificationDate", false)});
	
			SwcWorkHour[] swcWorkHours = getSwcManager().getWorkhours(cUser.getId(), swcWorkHourCond, IManager.LEVEL_ALL); 
	
			WorkHourPolicy workHourPolicy = new WorkHourPolicy();
			SwcWorkHour swcWorkHour = new SwcWorkHour();
			if(swcWorkHours != null) {
				for(int i=0; i<swcWorkHours.length; i++) {
					if((new LocalDate(swcWorkHours[i].getValidFromDate().getTime())).getTime() <= new LocalDate().getTime()) {
						swcWorkHour = swcWorkHours[i];
						break;
					}
				}
	
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
			// Exception Handling Required
			e.printStackTrace();
			return null;			
			// Exception Handling Required			
		}
	}

}
