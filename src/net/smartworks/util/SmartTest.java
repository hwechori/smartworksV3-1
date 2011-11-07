package net.smartworks.util;

import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.instance.EventInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.TaskInstance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.notice.NoticeMessage;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;

public class SmartTest {
	// ************************** 테스트용 데이터
	// ******************************************//
	// ************************** 테스트용 데이터
	// ******************************************//

	public static User getUser1() throws Exception {
		User user = new User();
		user.setId("kmyu@maninsoft.co.kr");
		user.setName("유광민");
		user.setPosition("기술연구소장");
		user.setDepartment("기술사업팀");
		user.setLocale("ko_KR"); // ko_KR, en_US
		user.setTimeZone("SEOUL");
		user.setCompany("(주)맨인소프트");
		user.setPicturePath("images/");
		user.setOrgPictureName(user.getId() + ".jpg");
		user.setMinPictureName(user.getId() + "_min.gif");
		user.setMidPictureName(user.getId() + "_mid.gif");

		return user;
	}

	public static User getUser2() throws Exception {
		User user = new User();
		user.setId("hsshin@maninsoft.co.kr");
		user.setName("신현성");
		user.setPosition("개발팀");
		user.setDepartment("기술연구소");
		user.setLocale("ko_KR"); // ko_KR, en_US
		user.setTimeZone("SEOUL");
		user.setCompany("(주)맨인소프트");
		user.setPicturePath("images/");
		user.setOrgPictureName(user.getId() + ".jpg");
		user.setMinPictureName(user.getId() + "_min.gif");
		user.setMidPictureName(user.getId() + "_mid.gif");

		return user;
	}

	public static User getUser3() throws Exception {
		User user = new User();
		user.setId("hjlee@maninsoft.co.kr");
		user.setName("이현정");
		user.setPosition("대리");
		user.setDepartment("경영기획팀");
		user.setLocale("ko_KR"); // ko_KR, en_US
		user.setTimeZone("SEOUL");
		user.setCompany("(주)맨인소프트");
		user.setPicturePath("images/");
		user.setOrgPictureName(user.getId() + ".jpg");
		user.setMinPictureName(user.getId() + "_min.gif");
		user.setMidPictureName(user.getId() + "_mid.gif");

		return user;
	}

	public static WorkCategory getWorkCategory1() throws Exception {
		return new WorkCategory("cat1", "공통업무");
	}

	public static WorkCategory getWorkCategory2() throws Exception {
		return new WorkCategory("cat2", "영업관리");
	}

	public static SmartWork getSmartWork1() throws Exception {
		return new SmartWork("work1", "근태품의", SmartWork.TYPE_PROCESS, "", getWorkCategory1());
	}

	public static SmartWork getSmartWork2() throws Exception {
		return new SmartWork("work2", "회의록", SmartWork.TYPE_INFORMATION, "", getWorkCategory1());
	}

	public static SmartWork getSmartWork3() throws Exception {
		return new SmartWork("work3", "구매기안", SmartWork.TYPE_PROCESS, "", getWorkCategory1());
	}

	public static SmartWork getSmartWork4() throws Exception {
		return new SmartWork("work4", "제안견적프로세스", SmartWork.TYPE_PROCESS, "", getWorkCategory2());
	}

	public static SmartWork getSmartWork5() throws Exception {
		return new SmartWork("work5", "영업기회", SmartWork.TYPE_INFORMATION, "", getWorkCategory2());
	}

	public static SmartWork getSmartWork6() throws Exception {
		return new SmartWork("work6", "자료실", SmartWork.TYPE_GROUP, "", getWorkCategory2());
	}

	public static SmartWork getSmartWork7() throws Exception {
		return new SmartWork("work11", "구매프로세스", SmartWork.TYPE_PROCESS, "", getWorkCategory2());
	}

	public static SmartWork getSmartWork8() throws Exception {
		return new SmartWork("work21", "구매발주서", SmartWork.TYPE_INFORMATION, "", getWorkCategory2());
	}

	public static SmartWork getSmartWork9() throws Exception {
		return new SmartWork("work31", "자재발주서", SmartWork.TYPE_PROCESS, "", getWorkCategory2());
	}

	public static Group getGroup1() throws Exception {
		return new Group("group1", "SmartWorks.net V3 TFT", new User[] { getUser1(), getUser2() }, getUser1());
	}

	public static Group getGroup2() throws Exception {
		return new Group("group2", "한라공조 협력업체 정보화시스템 고도화 프로젝트", new User[] { SmartUtil.getCurrentUser(), getUser3() }, getUser2());
	}

	public static Group getGroup3() throws Exception {
		return new Group("group3", "금성출판사 그룹웨어 프로젝트", new User[] { getUser2() }, SmartUtil.getCurrentUser());
	}

	public static WorkInstance getWorkInstance1() throws Exception {
		return new WorkInstance("inst1", "휴가 신청합니다.", getSmartWork1(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110211300")));
	}

	public static WorkInstance getWorkInstance2() throws Exception {
		return new WorkInstance("inst2", "스마트웍스 3.0 개발계획 회의록 입니다.", getSmartWork2(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110230900")));
	}

	public static WorkInstance getWorkInstance3() throws Exception {
		return new WorkInstance("inst3", "노트북 구매 기안합니다.", getSmartWork3(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110251621")));
	}

	public static WorkInstance getWorkInstance4() throws Exception {
		return new WorkInstance("inst4", "금성출판사 스마트웍스 프로젝트", getSmartWork5(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110292100")));
	}

	public static WorkInstance getWorkInstance5() throws Exception {
		return new WorkInstance("inst5", "삼성 노트북 구매발주서", getSmartWork8(), getUser3(), new LocalDate(LocalDate.convertStringToTime("201110291300")));
	}

	public static Department getDepartment1() throws Exception {
		return new Department("depart1", "(주)맨인소프트", new User[] { SmartUtil.getCurrentUser(), getUser3() }, SmartUtil.getCurrentUser());
	}

	public static Department getDepartment2() throws Exception {
		return new Department("depart2", "대표이사", new User[] { getUser3(), getUser2() }, getUser1());
	}

	public static Department getDepartment3() throws Exception {
		return new Department("depart3", "경영기획본부", new User[] { getUser2() }, getUser2());
	}

	public static Department getDepartment4() throws Exception {
		return new Department("depart4", "기술사업본부", new User[] { getUser1(), SmartUtil.getCurrentUser() }, SmartUtil.getCurrentUser());
	}

	public static EventInstance getEventInstance1() throws Exception {
		EventInstance event = new EventInstance("event1", "한라공조 협력업체 설명회", new Work("work1", "개인일정"), SmartUtil.getCurrentUser(), new LocalDate(LocalDate.convertStringToTime("201111051600")));
		event.setStart(new LocalDate(LocalDate.convertStringToTime("201111061600")));
		event.setEnd(new LocalDate(LocalDate.convertStringToTime("201111061800")));
		return event;

	}

	public static TaskInstance getTaskInstancePA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance1", "대표이사승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, getUser2(), new LocalDate(LocalDate.convertStringToTime("201110051600")));
		taskInstance.setStatus(Instance.STATUS_RETURNED_DELAYED);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUser());
		return taskInstance;
	}

	public static TaskInstance getTaskInstancePF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance2", "참고하시기 바랍니다.", TaskInstance.TYPE_PROCESS_TASK_FORWARDED, getUser3(), new LocalDate(LocalDate.convertStringToTime("201110151600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceIA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance11", "주간회의 회의록 작성하여 주시기 바랍니다.", TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED, getUser2(), new LocalDate(LocalDate.convertStringToTime("201110250900")));
		taskInstance.setStatus(Instance.STATUS_DELAYED_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUser());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceIF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance12", "주간회의 회의록입니다.", TaskInstance.TYPE_INFORMATION_TASK_FORWARDED, getUser3(), new LocalDate(LocalDate.convertStringToTime("201111011100")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceSA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance13", "제품개발 스토리보드 작성업무", TaskInstance.TYPE_SCHEDULE_TASK_ASSIGNED, getUser2(), new LocalDate(LocalDate.convertStringToTime("201110252100")));
		taskInstance.setStatus(Instance.STATUS_DELAYED_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUser());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceSF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance14", "참조바랍니다<제품개발 스토리보드 작성업무>", TaskInstance.TYPE_SCHEDULE_TASK_FORWARDED, getUser3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceAA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance13", "신규사업기획서 품의", TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED, getUser2(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RETURNED_DELAYED);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUser());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceAF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance14", "기안한 품의서 입니다. 참고하시기 바랍니다.", TaskInstance.TYPE_APPROVAL_TASK_FORWARDED, getUser3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static NoticeMessage getNotificationMessage(int noticeType) throws Exception {

		NoticeMessage notice1, notice2, notice3, notice4, notice5;
		if (noticeType == NoticeMessage.TYPE_SYSTEM_NOTICE) {
			notice1 = new NoticeMessage("notice1", NoticeMessage.TYPE_SYSTEM_NOTICE, getUser1(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
			notice1.setMessage("금주 주말(토요일, 일요일)에 시스템 정기점검을 실시하는 관계를 시스템을 1시간 가량 사용할 수 없으니 이점 양해 바랍니다.");
			return notice1;
		}

		if (noticeType == NoticeMessage.TYPE_EVENT_ALARM) {
			notice2 = new NoticeMessage("notic2", NoticeMessage.TYPE_EVENT_ALARM, getUser2(), new LocalDate(LocalDate.convertStringToTime("201110281000")));
			notice2.setEvent(getEventInstance1());
			return notice2;
		}
		if (noticeType == NoticeMessage.TYPE_TASK_DELAYED) {
			notice3 = new NoticeMessage("notice3", NoticeMessage.TYPE_TASK_DELAYED, SmartUtil.getCurrentUser(), new LocalDate(LocalDate.convertStringToTime("201110291910")));
			notice3.setInstance(getTaskInstancePA());
			return notice3;
		}

		if (noticeType == NoticeMessage.TYPE_JOIN_REQUEST) {
			notice4 = new NoticeMessage("notice4", NoticeMessage.TYPE_JOIN_REQUEST, getUser1(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
			notice4.setGroup(getGroup1());
			notice4.setMessage("님이 커뮤너티에 가입을 신청하셨습니다.");
			return notice4;
		}
		if (noticeType == NoticeMessage.TYPE_INSTANCE_CREATED) {
			notice5 = new NoticeMessage("notice5", NoticeMessage.TYPE_INSTANCE_CREATED, getUser1(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
			notice5.setInstance(getWorkInstance1());
			notice5.setMessage("새로운 업무를 등록하였습니다..");
			return notice5;
		}
		return null;

	}
	
	public static CompanyEvent getCompanyEvent1(){
		CompanyEvent event = new CompanyEvent("companyevent1", "창립기념일");
		event.setIsHoliday(false);
		event.setPlannedStart(new LocalDate());
		event.setPlannedEnd(new LocalDate());
		return event;
	}
	
	public static CompanyEvent getCompanyEvent2(){
		CompanyEvent event = new CompanyEvent("companyevent2", "크리스마스");
		event.setIsHoliday(true);
		event.setPlannedStart(new LocalDate());
		LocalDate date1 = new LocalDate();
		date1.setGMTDate(date1.getGMTDate() + LocalDate.ONE_DAY*2);
		event.setPlannedEnd(date1);
		return event;
	}

	public static Instance[] getRunningInstances() throws Exception {
		TaskInstance[] taskInstances = getAssignedTaskInstances();

		WorkInstance workInstance1 = getWorkInstance1();
		workInstance1.setTasks(new TaskInstance[] {getTaskInstancePA(), getTaskInstancePF(), getTaskInstancePF()});
		
		WorkInstance workInstance2 = getWorkInstance2();
		workInstance2.setTasks(new TaskInstance[] {getTaskInstanceIA(), getTaskInstanceIF()});
		return new Instance[] {taskInstances[0], taskInstances[1], taskInstances[2], taskInstances[3], taskInstances[4], workInstance1, workInstance2};
	}

	public static TaskInstance[] getAssignedTaskInstances() throws Exception{
		TaskInstance assignedInstance1 = new TaskInstance("assignedtask1", "대표이사 승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, SmartTest.getUser3(),
			new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance1.setStatus(Instance.STATUS_DELAYED_RUNNING);
		WorkInstance workInstance1 = getWorkInstance1();
		workInstance1.setTasks(new TaskInstance[] {assignedInstance1});
		assignedInstance1.setWorkInstance(workInstance1);

		TaskInstance assignedInstance2 = new TaskInstance("assignedtask2", "구매기안 기안제출", TaskInstance.TYPE_PROCESS_TASK_FORWARDED,
			SmartTest.getUser3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance2.setStatus(Instance.STATUS_RETURNED);
		WorkInstance workInstance2 = getWorkInstance2();
		workInstance2.setTasks(new TaskInstance[] {assignedInstance2});
		workInstance2.setWorkSpace(getDepartment1());
		assignedInstance2.setWorkInstance(workInstance2);

		TaskInstance assignedInstance3 = new TaskInstance("assignedtask3", "반도체회사 제안서 공유합니다.", TaskInstance.TYPE_INFORMATION_TASK_FORWARDED,
			SmartTest.getUser3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance3.setStatus(Instance.STATUS_RUNNING);
		WorkInstance workInstance3 = getWorkInstance3();
		workInstance3.setTasks(new TaskInstance[] {assignedInstance3});
		assignedInstance3.setWorkInstance(workInstance3);

		TaskInstance assignedInstance4 = new TaskInstance("assignedtask4", "검토자 결재", TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED, SmartTest.getUser3(),
			new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance4.setStatus(Instance.STATUS_RUNNING);
		WorkInstance workInstance4 = getWorkInstance4();
		workInstance4.setTasks(new TaskInstance[] {assignedInstance4});
		assignedInstance4.setWorkInstance(workInstance4);

		TaskInstance assignedInstance5 = new TaskInstance("assignedtask5", "일일보고 입니다.", TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED,
			SmartTest.getUser3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance5.setStatus(Instance.STATUS_RETURNED_DELAYED);
		WorkInstance workInstance5 = getWorkInstance5();
		workInstance5.setTasks(new TaskInstance[] {assignedInstance5});
		workInstance5.setWorkSpace(getGroup1());
		assignedInstance5.setWorkInstance(workInstance5);

		return new TaskInstance[]{assignedInstance1, assignedInstance2, assignedInstance3, assignedInstance4, assignedInstance5};
	}
}
