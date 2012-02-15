package net.smartworks.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.smartworks.model.calendar.CompanyCalendar;
import net.smartworks.model.calendar.CompanyEvent;
import net.smartworks.model.calendar.WorkHour;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.Group;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.community.info.CommunityInfo;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.GroupInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.CommentInstance;
import net.smartworks.model.instance.EventInstance;
import net.smartworks.model.instance.FieldData;
import net.smartworks.model.instance.InformationWorkInstance;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.TaskInstance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.AsyncMessageInstanceInfo;
import net.smartworks.model.instance.info.BoardInstanceInfo;
import net.smartworks.model.instance.info.CommentInstanceInfo;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.instance.info.IWInstanceInfo;
import net.smartworks.model.instance.info.ImageInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.InstanceInfoList;
import net.smartworks.model.instance.info.PWInstanceInfo;
import net.smartworks.model.instance.info.RequestParams;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.instance.info.WorkInstanceInfo;
import net.smartworks.model.notice.Notice;
import net.smartworks.model.notice.NoticeBox;
import net.smartworks.model.notice.NoticeMessage;
import net.smartworks.model.report.ChartReport;
import net.smartworks.model.report.Data;
import net.smartworks.model.report.Report;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.InformationWork;
import net.smartworks.model.work.ProcessWork;
import net.smartworks.model.work.SmartDiagram;
import net.smartworks.model.work.SmartForm;
import net.smartworks.model.work.SmartTask;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.model.work.info.SmartFormInfo;
import net.smartworks.model.work.info.SmartTaskInfo;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;

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
		return user;
	}
	public static UserInfo getUserInfo1() throws Exception {
		UserInfo user = new UserInfo();
		user.setId("kmyu@maninsoft.co.kr");
		user.setName("유광민");
		user.setPosition("기술연구소장");
		return user;
	}

	public static UserInfo getUserInfo2() throws Exception {
		UserInfo user = new UserInfo();
		user.setId("hsshin@maninsoft.co.kr");
		user.setName("신현성");
		user.setPosition("개발팀");
		return user;
	}

	public static UserInfo getUserInfo3() throws Exception {
		UserInfo user = new UserInfo();
		user.setId("hjlee@maninsoft.co.kr");
		user.setName("이현정");
		user.setPosition("대리");
		return user;
	}
	
	public static WorkCategoryInfo[] getMyWorkCategories() throws Exception{
		return new WorkCategoryInfo[] { getWorkCategoryInfo1(), getWorkCategoryInfo2() };
	}
	
	public static SmartWorkInfo[] getMyWorksByCategory() throws Exception{
		return new SmartWorkInfo[] {getInformationWorkInfo1(), getProcessWorkInfo1()};
	}

	public static WorkCategory getWorkCategory1() throws Exception {
		return new WorkCategory("cat1", "공통업무");
	}

	public static WorkCategoryInfo getWorkCategoryInfo1() throws Exception {
		return new WorkCategoryInfo("cat1", "공통업무");
	}

	public static WorkCategory getWorkCategory2() throws Exception {
		return new WorkCategory("cat2", "영업관리");
	}

	public static WorkCategoryInfo getWorkCategoryInfo2() throws Exception {
		return new WorkCategoryInfo("cat2", "영업관리");
	}

	public static SmartForm getForm1() throws Exception{
		SmartForm form = new SmartForm();
		form.setFields(new FormField[] {new FormField("f1", "제 목", FormField.TYPE_TEXT), new FormField("f2", "작성자", FormField.TYPE_USER), new FormField("f3", "관리부서", FormField.TYPE_OTHER_WORK), new FormField("f4", "상세설명", FormField.TYPE_RICHTEXT_EDITOR), new FormField("f5", "첨부파일", FormField.TYPE_FILE)});
		form.setDescription("문서를 등록하는 화면입니다. 원하는 문서를 첨부하시고 제목, 작성자 등을 작성하여 주시기 바랍니다.");
		return form;
	}

	public static SmartFormInfo getFormInfo1() throws Exception{
		SmartFormInfo form = new SmartFormInfo();
		form.setDescription("문서를 등록하는 화면입니다. 원하는 문서를 첨부하시고 제목, 작성자 등을 작성하여 주시기 바랍니다.");
		return form;
	}

	public static SmartTask getTask1() throws Exception{
		SmartTask task = new SmartTask("task1", "근태기안");
		task.setForm(getForm1());
		return task;
	}
	
	public static SmartTask getTask2() throws Exception{
		SmartTask task = new SmartTask("task2", "팀장 승인");
		task.setForm(getForm1());
		return task;
	}
	
	public static SmartTask getTask3() throws Exception{
		SmartTask task = new SmartTask("task3", "검토자 확인");
		task.setForm(getForm1());
		return task;
	}
	
	public static SmartTask getTask4() throws Exception{
		SmartTask task = new SmartTask("task4", "대표이사 승인");
		task.setForm(getForm1());
		return task;
	}
	
	public static SmartTaskInfo getTaskInfo1() throws Exception{
		SmartTaskInfo task = new SmartTaskInfo("task1", "근태기안");
		task.setForm(getFormInfo1());
		return task;
	}
	
	public static SmartTaskInfo getTaskInfo2() throws Exception{
		SmartTaskInfo task = new SmartTaskInfo("task2", "팀장 승인");
		task.setForm(getFormInfo1());
		return task;
	}
	
	public static SmartTaskInfo getTaskInfo3() throws Exception{
		SmartTaskInfo task = new SmartTaskInfo("task3", "검토자 확인");
		task.setForm(getFormInfo1());
		return task;
	}
	
	public static SmartTaskInfo getTaskInfo4() throws Exception{
		SmartTaskInfo task = new SmartTaskInfo("task4", "대표이사 승인");
		task.setForm(getFormInfo1());
		return task;
	}
	
	public static SmartDiagram getDiagram1() throws Exception{
		SmartDiagram diagram = new SmartDiagram("diagram1", "");
		diagram.setTasks(new SmartTaskInfo[] {getTaskInfo1(), getTaskInfo2(), getTaskInfo3(), getTaskInfo4()});
		return diagram;
	}
	
	public static InformationWork getInformationWork1() throws Exception{
		InformationWork work = new InformationWork("iwork1", "자료실-UITest", "회사에 필요한 문서를 등록관리하는 정보관리 업무입니다. 필요한 파일선택하여 제목, 등록자등을 입력하여 등록할 수 있습니다.", getWorkCategory1());
		work.setLastModifier(getUser1());
		work.setLastModifiedDate(new LocalDate());
		work.setForm(getForm1());
		work.setKeyField(new FormField("f1", "제 목", "String"));
		work.setDisplayFields(new FormField[] {new FormField("f1", "제 목", FormField.TYPE_TEXT), new FormField("f2", "작성자", FormField.TYPE_USER), new FormField("f3", "관리부서", FormField.TYPE_OTHER_WORK), new FormField("f4", "상세설명", FormField.TYPE_RICHTEXT_EDITOR), new FormField("f5", "첨부파일", FormField.TYPE_FILE)});
		work.setHelpUrl("http://manual.smartworks.net");
		work.setManualFilePath("test/files/");
		work.setManualFileName("법무지원시스템_dashboard디자인가이드.pptx");
		SearchFilter sf = new SearchFilter();
		sf.setId("searchFilter1");
		sf.setName("테스트필터");
		return work;
	}
	
	public static SmartWorkInfo getInformationWorkInfo1() throws Exception{
		SmartWorkInfo work = new SmartWorkInfo("iwork1", "자료실-UITest", SmartWork.TYPE_INFORMATION, null,  getWorkCategoryInfo1());
		return work;
	}
	
	public static ProcessWork getProcessWork1() throws Exception{
		ProcessWork work = new ProcessWork("pwork1", "근태기안-UITest", "개인들이 근태를 신청하는 프로세스업무 입니다. 프로세를 선택하여 필요한 결재라인을 지정하고 근태신청을 진행할 수 있습니다..", getWorkCategory1());
		work.setLastModifier(getUser1());
		work.setLastModifiedDate(new LocalDate());
		work.setHelpUrl("http://manual.smartworks.net");
		work.setManualFilePath("test/files/");
		work.setManualFileName("법무지원시스템_dashboard디자인가이드.pptx");
		work.setDiagram(getDiagram1());
		return work;
	}
	
	public static SmartWorkInfo getProcessWorkInfo1() throws Exception{
		SmartWorkInfo work = new SmartWorkInfo("pwork1", "근태기안-UITest", SmartWork.TYPE_PROCESS, null, getWorkCategoryInfo1());
		return work;
	}
	
	public static SmartWork getSmartWork1() throws Exception {
		
		SmartWork work = new SmartWork("work1", "근태품의 (회사규정번호-2343979187628743628468273482374), (ISO9001-293849234732948928743298472394)", SmartWork.TYPE_PROCESS, "", getWorkCategory1());
		return work;
	}

	public static SmartWorkInfo getSmartWorkInfo1() throws Exception {
		
		SmartWorkInfo work = new SmartWorkInfo("work1", "근태품의", SmartWork.TYPE_PROCESS, null, getWorkCategoryInfo1());
		return work;
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
		return new SmartWork("work6", "자료실", SmartWork.TYPE_SCHEDULE, "", getWorkCategory2());
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

	public static SmartWorkInfo getSmartWorkInfo2() throws Exception {
		return new SmartWorkInfo("work2", "회의록", SmartWork.TYPE_INFORMATION, null, getWorkCategoryInfo1());
	}

	public static SmartWorkInfo getSmartWorkInfo3() throws Exception {
		return new SmartWorkInfo("work3", "구매기안", SmartWork.TYPE_PROCESS, null, getWorkCategoryInfo1());
	}

	public static SmartWorkInfo getSmartWorkInfo4() throws Exception {
		return new SmartWorkInfo("work4", "제안견적프로세스", SmartWork.TYPE_PROCESS, null, getWorkCategoryInfo2());
	}

	public static SmartWorkInfo getSmartWorkInfo5() throws Exception {
		return new SmartWorkInfo("work5", "영업기회", SmartWork.TYPE_INFORMATION, null, getWorkCategoryInfo2());
	}

	public static SmartWorkInfo getSmartWorkInfo6() throws Exception {
		return new SmartWorkInfo("work6", "자료실", SmartWork.TYPE_SCHEDULE, null, getWorkCategoryInfo2());
	}

	public static SmartWorkInfo getSmartWorkInfo7() throws Exception {
		return new SmartWorkInfo("work11", "구매프로세스", SmartWork.TYPE_PROCESS, null, getWorkCategoryInfo2());
	}

	public static SmartWorkInfo getSmartWorkInfo8() throws Exception {
		return new SmartWorkInfo("work21", "구매발주서", SmartWork.TYPE_INFORMATION, null, getWorkCategoryInfo2());
	}

	public static SmartWorkInfo getSmartWorkInfo9() throws Exception {
		return new SmartWorkInfo("work31", "자재발주서", SmartWork.TYPE_PROCESS, null, getWorkCategoryInfo2());
	}

	public static Group getGroup1() throws Exception {
		return new Group("group1", "SmartWorks.net V3 TFT", new UserInfo[] { getUserInfo1(), getUserInfo2() }, getUser1());
	}

	public static Group getGroup2() throws Exception {
		return new Group("group2", "한라공조 협력업체 정보화시스템 고도화 프로젝트", new UserInfo[] { getUserInfo2(), getUserInfo3() }, getUser2());
	}

	public static Group getGroup3() throws Exception {
		return new Group("group3", "금성출판사 그룹웨어 프로젝트", new UserInfo[] { getUserInfo2() }, SmartUtil.getCurrentUserOld());
	}

	public static GroupInfo getGroupInfo1() throws Exception {
		return new GroupInfo("group1", "SmartWorks.net V3 TFT");
	}

	public static GroupInfo getGroupInfo2() throws Exception {
		return new GroupInfo("group2", "한라공조 협력업체 정보화시스템 고도화 프로젝트");
	}

	public static GroupInfo getGroupInfo3() throws Exception {
		return new GroupInfo("group3", "금성출판사 그룹웨어 프로젝트");
	}

	public static WorkInstance getWorkInstance1() throws Exception {
		WorkInstance instance = new WorkInstance("inst1", "휴가 신청합니다.", getSmartWork1(), getUser1(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110211300")));
		return instance;
	}

	public static PWInstanceInfo getWorkInstanceInfo1() throws Exception {
			TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance1", "대표이사승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, getUserInfo2(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110051600")));
			taskInstance.setStatus(Instance.STATUS_RETURNED);
			PWInstanceInfo instance = new PWInstanceInfo("inst1", "휴가 신청합니다.", getSmartWorkInfo1(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110211300")), taskInstance);
			instance.setWork(SmartTest.getProcessWorkInfo1());
			taskInstance.setWorkInstance(instance);
			return instance;
	}

	public static WorkInstance getWorkInstance2() throws Exception {
		WorkInstance instance = new WorkInstance("inst2", "스마트웍스 3.0 개발계획 회의록 입니다.", getSmartWork2(), getUser1(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110230900")));
		instance.setTasks(new TaskInstanceInfo[] {SmartTest.getTaskInstanceInfoIA()});
		return instance;
	}

	public static InformationWorkInstance getInformationWorkInstance1() throws Exception {
		InformationWorkInstance instance = new InformationWorkInstance("inst2", "스마트웍스 3.0 개발계획 회의록 입니다.", getInformationWork1(), getUser1(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110230900")));
		instance.setTasks(new TaskInstanceInfo[] {SmartTest.getTaskInstanceInfoIA()});
		instance.setCreatedDate(new LocalDate());
		return instance;
	}

	public static WorkInstance getWorkInstance3() throws Exception {
		return new WorkInstance("inst3", "노트북 구매 기안합니다.", getSmartWork3(), getUser1(), getUser1(), new LocalDate(LocalDate.convertStringToTime("201110251621")));
	}

	public static WorkInstance getWorkInstance4() throws Exception {
		return new WorkInstance("inst4", "금성출판사 스마트웍스 프로젝트", getSmartWork5(), getUser1(), getUser1(),  new LocalDate(LocalDate.convertStringToTime("201110292100")));
	}

	public static WorkInstance getWorkInstance5() throws Exception {
		return new WorkInstance("inst5", "삼성 노트북 구매발주서", getSmartWork8(), getUser3(), getUser3(), new LocalDate(LocalDate.convertStringToTime("201110291300")));
	}

	public static IWInstanceInfo getWorkInstanceInfo2() throws Exception {
		return new IWInstanceInfo("inst2", "스마트웍스 3.0 개발계획 회의록 입니다.", getSmartWorkInfo2(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110230900")));
	}
	
	public static WorkInstance getWorkInstanceById(String instanceId) throws Exception{
		return getInformationWorkInstance1();
		//		if(instanceId == null || instanceId.equals("")){
//			return getWorkInstance1();
//		}
//		WorkInstance[] workInstances = new WorkInstance[] {getWorkInstance1(), getWorkInstance2(), getWorkInstance3(), getWorkInstance4(), getWorkInstance5() };
//		for(WorkInstance instance : workInstances){
//			if(instance.getId().equals(instanceId)) return instance;
//		}
//		return getWorkInstance1();
	}

	public static PWInstanceInfo getWorkInstanceInfo3() throws Exception {
			TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance1", "대표이사승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, getUserInfo2(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110051600")));
			taskInstance.setStatus(Instance.STATUS_DELAYED_RUNNING);
			taskInstance.setAssignee(getUserInfo1());
			PWInstanceInfo instance = new PWInstanceInfo("inst3", "노트북 구매 기안합니다.", getSmartWorkInfo3(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110251621")), taskInstance);
			taskInstance.setWorkInstance(instance);
		return instance; 
	}

	public static InstanceInfo getWorkInstanceInfo4() throws Exception {
		return new InstanceInfo("inst4", "금성출판사 스마트웍스 프로젝트", Instance.TYPE_WORK, getUserInfo1(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110292100")));
	}

	public static IWInstanceInfo getWorkInstanceInfo5() throws Exception {
		IWInstanceInfo instance = new IWInstanceInfo("inst5", "삼성 노트북 구매발주서", getSmartWorkInfo8(), getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110291300")));
		instance.setCreatedDate(new LocalDate());
		return instance;
	}

	public static Department getDepartment1() throws Exception {
		return new Department("depart1", "(주)맨인소프트", new UserInfo[] { getUserInfo1(), getUserInfo3() }, SmartUtil.getCurrentUserOld());
	}

	public static Department getDepartment2() throws Exception {
		return new Department("depart2", "대표이사", new UserInfo[] { getUserInfo3(), getUserInfo2() }, getUser1());
	}

	public static Department getDepartment3() throws Exception {
		return new Department("depart3", "경영기획본부", new UserInfo[] { getUserInfo2() }, getUser2());
	}

	public static Department getDepartment4() throws Exception {
		return new Department("depart4", "기술사업본부", new UserInfo[] { getUserInfo1(), getUserInfo3() }, SmartUtil.getCurrentUserOld());
	}

	public static DepartmentInfo getDepartmentInfo1() throws Exception {
		return new DepartmentInfo("depart1", "(주)맨인소프트");
	}

	public static DepartmentInfo getDepartmentInfo2() throws Exception {
		return new DepartmentInfo("depart2", "대표이사");
	}

	public static DepartmentInfo getDepartmentInfo3() throws Exception {
		return new DepartmentInfo("depart3", "경영기획본부");
	}

	public static DepartmentInfo getDepartmentInfo4() throws Exception {
		return new DepartmentInfo("depart4", "기술사업본부");
	}

	public static EventInstance getEventInstance1() throws Exception {
		EventInstance event = new EventInstance("event1", "한라공조 협력업체 설명회", new Work("work1", "개인일정"), SmartUtil.getCurrentUserOld(), new LocalDate(LocalDate.convertStringToTime("201111051600")));
		event.setStart(new LocalDate(LocalDate.convertStringToTime("201111061600")));
		event.setEnd(new LocalDate(LocalDate.convertStringToTime("201111061800")));
		return event;
	}

	public static EventInstanceInfo getEventInstanceInfo1() throws Exception {
		EventInstanceInfo event = new EventInstanceInfo("event1", "한라공조 협력업체 설명회", getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201111051600")));
		event.setStart(new LocalDate(LocalDate.convertStringToTime("201111061600")));
		event.setEnd(new LocalDate(LocalDate.convertStringToTime("201111061800")));
		return event;
	}

	public static TaskInstance getTaskInstancePA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance1", "대표이사승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, getUser2(), getUser2(), new LocalDate(LocalDate.convertStringToTime("201110051600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUserOld());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoPA() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance1", "대표이사승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, getUserInfo2(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110051600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
			PWInstanceInfo instance = new PWInstanceInfo("inst1", "휴가 신청합니다.", getSmartWorkInfo1(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110211300")), taskInstance);
		taskInstance.setWorkInstance(instance);
		taskInstance.setAssignee(getUserInfo1());
		return taskInstance;
	}

	public static TaskInstance getTaskInstancePF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance2", "참고하시기 바랍니다.", TaskInstance.TYPE_PROCESS_TASK_FORWARDED, getUser3(), getUser3(), new LocalDate(LocalDate.convertStringToTime("201110151600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoPF() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance2", "참고하시기 바랍니다.", TaskInstance.TYPE_PROCESS_TASK_FORWARDED, getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110151600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstanceInfo2());
		taskInstance.setAssignee(getUserInfo1());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceIA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance11", "주간회의 회의록 작성하여 주시기 바랍니다.", TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED, getUser2(), getUser2(), new LocalDate(LocalDate.convertStringToTime("201110250900")));
		taskInstance.setStatus(Instance.STATUS_DELAYED_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUserOld());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceIF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance12", "주간회의 회의록입니다.", TaskInstance.TYPE_INFORMATION_TASK_FORWARDED, getUser3(), getUser3(), new LocalDate(LocalDate.convertStringToTime("201111011100")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceSA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance13", "제품개발 스토리보드 작성업무", TaskInstance.TYPE_SCHEDULE_TASK_ASSIGNED, getUser2(), getUser2(), new LocalDate(LocalDate.convertStringToTime("201110252100")));
		taskInstance.setStatus(Instance.STATUS_DELAYED_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUserOld());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceSF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance14", "참조바랍니다<제품개발 스토리보드 작성업무>", TaskInstance.TYPE_SCHEDULE_TASK_FORWARDED, getUser3(), getUser3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceAA() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance13", "신규사업기획서 품의", TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED, getUser2(), getUser2(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance1());
		taskInstance.setAssignee(SmartUtil.getCurrentUserOld());
		return taskInstance;
	}

	public static TaskInstance getTaskInstanceAF() throws Exception {
		TaskInstance taskInstance = new TaskInstance("taskInstance14", "기안한 품의서 입니다. 참고하시기 바랍니다.", TaskInstance.TYPE_APPROVAL_TASK_FORWARDED, getUser3(), getUser3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstance2());
		taskInstance.setAssignee(getUser1());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoIA() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance11", "주간회의 회의록 작성하여 주시기 바랍니다.", TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED, getUserInfo2(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110250900")));
		taskInstance.setStatus(Instance.STATUS_DELAYED_RUNNING);
		taskInstance.setWorkInstance(getWorkInstanceInfo1());
		taskInstance.setAssignee(getUserInfo1());
		taskInstance.setCreatedDate(new LocalDate());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoIF() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance12", "주간회의 회의록입니다.", TaskInstance.TYPE_INFORMATION_TASK_FORWARDED, getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201111011100")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstanceInfo2());
		taskInstance.setAssignee(getUserInfo1());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoSA() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance13", "제품개발 스토리보드 작성업무", TaskInstance.TYPE_SCHEDULE_TASK_ASSIGNED, getUserInfo2(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110252100")));
		taskInstance.setStatus(Instance.STATUS_DELAYED_RUNNING);
		taskInstance.setWorkInstance(getWorkInstanceInfo1());
		taskInstance.setAssignee(getUserInfo3());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoSF() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance14", "참조바랍니다<제품개발 스토리보드 작성업무>", TaskInstance.TYPE_SCHEDULE_TASK_FORWARDED, getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstanceInfo2());
		taskInstance.setAssignee(getUserInfo1());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoAA() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance13", "신규사업기획서 품의", TaskInstance.TYPE_APPROVAL_TASK_ASSIGNED, getUserInfo2(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstanceInfo1());
		taskInstance.setAssignee(getUserInfo3());
		return taskInstance;
	}

	public static TaskInstanceInfo getTaskInstanceInfoAF() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance14", "기안한 품의서 입니다. 참고하시기 바랍니다.", TaskInstance.TYPE_APPROVAL_TASK_FORWARDED, getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setWorkInstance(getWorkInstanceInfo2());
		taskInstance.setAssignee(getUserInfo1());
		return taskInstance;
	}

	public static NoticeMessage getNotificationMessage(int noticeType) throws Exception {

		NoticeMessage notice1, notice2, notice3, notice4, notice5;
		if (noticeType == NoticeMessage.TYPE_SYSTEM_NOTICE) {
			notice1 = new NoticeMessage("notice1", NoticeMessage.TYPE_SYSTEM_NOTICE, getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
			notice1.setMessage("금주 주말(토요일, 일요일)에 시스템 정기점검을 실시하는 관계를 시스템을 1시간 가량 사용할 수 없으니 이점 양해 바랍니다.");
			return notice1;
		}

		if (noticeType == NoticeMessage.TYPE_EVENT_ALARM) {
			notice2 = new NoticeMessage("notic2", NoticeMessage.TYPE_EVENT_ALARM, getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110281000")));
			notice2.setEvent(getEventInstanceInfo1());
			return notice2;
		}
		if (noticeType == NoticeMessage.TYPE_TASK_DELAYED) {
			notice3 = new NoticeMessage("notice3", NoticeMessage.TYPE_TASK_DELAYED, getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110291910")));
			notice3.setInstance(getTaskInstanceInfoPA());
			return notice3;
		}

		if (noticeType == NoticeMessage.TYPE_JOIN_REQUEST) {
			notice4 = new NoticeMessage("notice4", NoticeMessage.TYPE_JOIN_REQUEST, getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
			notice4.setGroup(getGroupInfo1());
			notice4.setMessage("님이 커뮤너티에 가입을 신청하셨습니다.");
			return notice4;
		}
		if (noticeType == NoticeMessage.TYPE_INSTANCE_CREATED) {
			notice5 = new NoticeMessage("notice5", NoticeMessage.TYPE_INSTANCE_CREATED, getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
			notice5.setInstance(getWorkInstanceInfo1());
			notice5.setMessage("새로운 업무를 등록하였습니다..");
			return notice5;
		}
		return null;

	}
	
	public static CompanyEvent getCompanyEvent1(){
		CompanyEvent event = new CompanyEvent("companyevent1", "창립기념일");
		event.setHoliday(false);
		event.setPlannedStart(new LocalDate());
		event.setPlannedEnd(new LocalDate());
		return event;
	}
	
	public static CompanyEvent getCompanyEvent2(){
		CompanyEvent event = new CompanyEvent("companyevent2", "크리스마스");
		event.setHoliday(true);
		event.setPlannedStart(new LocalDate());
		LocalDate date1 = new LocalDate();
		date1.setGMTDate(date1.getGMTDate() + LocalDate.ONE_DAY*2);
		event.setPlannedEnd(date1);
		return event;
	}

	public static InstanceInfo[] getRunningInstances() throws Exception {
		TaskInstanceInfo[] taskInstances = getAssignedTaskInstances();

		return new InstanceInfo[] {taskInstances[0], taskInstances[1], taskInstances[2], taskInstances[3]};
	}

	public static TaskInstanceInfo[] getAssignedTaskInstances() throws Exception{
		IWInstanceInfo workInstance2 = new IWInstanceInfo("inst2", "스마트웍스 3.0 개발계획 회의록 입니다.", getSmartWorkInfo2(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110230900")));
		IWInstanceInfo workInstance5 = new IWInstanceInfo("inst5", "삼성 노트북 구매발주서", getSmartWorkInfo8(), getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110291300")));

		TaskInstanceInfo assignedInstance1 = new TaskInstanceInfo("assignedtask1", "대표이사 승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, SmartTest.getUserInfo3(), getUserInfo3(),
			new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance1.setStatus(Instance.STATUS_DELAYED_RUNNING);
		PWInstanceInfo workInstance1 = new PWInstanceInfo("inst1", "휴가 신청합니다.", getSmartWorkInfo1(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110211300")), assignedInstance1);
		assignedInstance1.setWorkInstance(workInstance1);

		TaskInstanceInfo assignedInstance2 = new TaskInstanceInfo("assignedtask2", "구매기안 기안제출", TaskInstance.TYPE_PROCESS_TASK_FORWARDED,
			SmartTest.getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance2.setStatus(Instance.STATUS_RETURNED);
		workInstance2.setWorkSpace(getDepartmentInfo1());
		assignedInstance2.setWorkInstance(workInstance2);

		TaskInstanceInfo assignedInstance3 = new TaskInstanceInfo("assignedtask3", "반도체회사 제안서 공유합니다.", TaskInstance.TYPE_INFORMATION_TASK_FORWARDED,
			SmartTest.getUserInfo3(), getUserInfo3(),  new LocalDate(LocalDate.convertStringToTime("201110251600")));
		assignedInstance3.setStatus(Instance.STATUS_RUNNING);
		PWInstanceInfo workInstance3 = new PWInstanceInfo("inst3", "노트북 구매 기안합니다.", getSmartWorkInfo3(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110251621")), assignedInstance3);
		assignedInstance3.setWorkInstance(workInstance3);

		TaskInstanceInfo assignedInstance5 = new TaskInstanceInfo("assignedtask5", "일일보고 입니다.", TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED,
				SmartTest.getUserInfo3(), getUserInfo3(),  new LocalDate(LocalDate.convertStringToTime("201110251600")));
			assignedInstance5.setStatus(Instance.STATUS_RUNNING);
			workInstance5.setWorkSpace(getGroupInfo1());
			assignedInstance5.setWorkInstance(workInstance5);

		TaskInstanceInfo createdInstance1 = new TaskInstanceInfo("createdtask1", "사진 입니다.", TaskInstance.TYPE_INFORMATION_TASK_CREATED,
				SmartTest.getUserInfo3(), getUserInfo3(),  new LocalDate(LocalDate.convertStringToTime("201110251600")));
		createdInstance1.setStatus(Instance.STATUS_COMPLETED);
		createdInstance1.setWorkSpace(getGroupInfo1());
		ImageInstanceInfo imageInstance = new ImageInstanceInfo("imageinst1", "오늘찍은 사진입니다.", getSmartWorkInfo8(), getUserInfo3(),  new LocalDate(LocalDate.convertStringToTime("201110251600")));
		imageInstance.setImgSource("images/2011-04-05 15.26.02.jpg");
		imageInstance.setContent("안녕하세요......?");
		createdInstance1.setWorkInstance(imageInstance);

		TaskInstanceInfo moreInstance = new TaskInstanceInfo();
		moreInstance.setType(-21);
		return new TaskInstanceInfo[]{assignedInstance1, assignedInstance2, assignedInstance3, assignedInstance5, createdInstance1, moreInstance};
	}
	// For Test...
	public static NoticeMessage[] getNotificationMessages() throws Exception {

		NoticeMessage notice1, notice2, notice3, notice4, notice5;
		notice1 = new NoticeMessage("notice1", NoticeMessage.TYPE_SYSTEM_NOTICE, SmartTest.getUserInfo1(), new LocalDate());
		notice1.setMessage("금주 주말(토요일, 일요일)에 시스템 정기점검을 실시하는 관계를 시스템을 1시간 가량 사용할 수 없으니 이점 양해 바랍니다.");
		notice2 = new NoticeMessage("notic2", NoticeMessage.TYPE_EVENT_ALARM, SmartTest.getUserInfo2(), SmartTest.getEventInstance1().getLastModifiedDate());
		notice2.setEvent(SmartTest.getEventInstanceInfo1());
		notice3 = new NoticeMessage("notice3", NoticeMessage.TYPE_TASK_DELAYED, getUserInfo3(), SmartTest.getTaskInstancePA().getLastModifiedDate());
		notice3.setInstance(SmartTest.getTaskInstanceInfoPA());
		notice4 = new NoticeMessage("notice4", NoticeMessage.TYPE_JOIN_REQUEST, getUserInfo1(), new LocalDate());
		notice4.setGroup(SmartTest.getGroupInfo1());
		notice4.setMessage("님이 커뮤너티에 가입을 신청하셨습니다.");
		notice5 = new NoticeMessage("notice5", NoticeMessage.TYPE_INSTANCE_CREATED, SmartTest.getUserInfo1(), SmartTest.getWorkInstance1().getLastModifiedDate());
		notice5.setInstance(SmartTest.getWorkInstanceInfo1());
		notice5.setMessage("새로운 업무를 등록하였습니다..");
		return new NoticeMessage[] { notice1, notice2, notice3, notice4, notice5 };

	}

	public static NoticeMessage[] getMessageMessages() throws Exception {

		NoticeMessage notice1, notice2, notice3, notice4, notice5;
		AsyncMessageInstanceInfo messageInstance1 = new AsyncMessageInstanceInfo("message1", SmartTest.getUserInfo1(), new LocalDate(), "안녕하세요?  잘지내시죠??? ㅎㅎㅎ");
		notice1 = new NoticeMessage("notice21", 0, SmartTest.getUserInfo1(), new LocalDate());
		notice1.setInstance(messageInstance1);

		AsyncMessageInstanceInfo messageInstance2 = new AsyncMessageInstanceInfo("message2", SmartTest.getUserInfo2(), new LocalDate(),
				"일간 한번 찾아뵙겠습니다. 그동안 몇번 연락드렸었는데, 연락이 안되던데요???");
		notice2 = new NoticeMessage("notice22", 0, SmartTest.getUserInfo1(), new LocalDate());
		notice2.setInstance(messageInstance2);

		AsyncMessageInstanceInfo messageInstance3 = new AsyncMessageInstanceInfo("message3", SmartTest.getUserInfo3(), new LocalDate(), "누구시더라????ㅠ");
		notice3 = new NoticeMessage("notice23", 0, SmartTest.getUserInfo1(), new LocalDate());
		notice3.setInstance(messageInstance3);

		return new NoticeMessage[] { notice1, notice2, notice3 };

	}

	public static CommentInstance[] getCommentInstances() throws Exception{
		CommentInstance commentInstance1 = new CommentInstance("comments1", CommentInstance.COMMENT_TYPE_ON_WORK_MANUAL, "조금더 보강해야 될것 같은데요????",
				SmartTest.getUser3(), new LocalDate());
		commentInstance1.setWork(SmartTest.getInformationWork1());

		CommentInstance commentInstance2 = new CommentInstance("comments2", CommentInstance.COMMENT_TYPE_ON_WORK_MANUAL, "잘모르겠습니다. ㅠㅠ",
				SmartTest.getUser1(), new LocalDate());
		commentInstance2.setWork(SmartTest.getInformationWork1());

		CommentInstance commentInstance3 = new CommentInstance("comments3", CommentInstance.COMMENT_TYPE_ON_WORK_MANUAL, "휴가잘다녀오세요!!!",
				SmartTest.getUser2(), new LocalDate());
		commentInstance3.setWork(SmartTest.getInformationWork1());
		return new CommentInstance[] {commentInstance1, commentInstance2, commentInstance3};
		
	}
	public static NoticeMessage[] getCommentsMessages() throws Exception {

		NoticeMessage notice1, notice2, notice3, notice4, notice5;
		CommentInstanceInfo commentsInstance1 = new CommentInstanceInfo("comments1", CommentInstance.COMMENT_TYPE_ON_WORK_SPACE, "기획서좀 올려주세요!!! ㅎ",
				SmartTest.getUserInfo3(), new LocalDate());
		commentsInstance1.setWorkSpace(getGroupInfo1());
		notice1 = new NoticeMessage("notice21", 0, SmartTest.getUserInfo3(), new LocalDate());
		notice1.setInstance(commentsInstance1);

		CommentInstanceInfo commentsInstance2 = new CommentInstanceInfo("comments2", CommentInstance.COMMENT_TYPE_ON_WORK_MANUAL, "잘모르겠습니다. ㅠㅠ",
				SmartTest.getUserInfo1(), new LocalDate());
		commentsInstance2.setWork(SmartTest.getSmartWorkInfo3());
		notice2 = new NoticeMessage("notice22", 0, SmartTest.getUserInfo1(), new LocalDate());
		notice2.setInstance(commentsInstance2);

		CommentInstanceInfo commentsInstance3 = new CommentInstanceInfo("comments3", CommentInstance.COMMENT_TYPE_ON_WORK_INSTANCE, "휴가잘다녀오세요!!!",
				SmartTest.getUserInfo2(), new LocalDate());
		commentsInstance3.setWorkInstance(SmartTest.getWorkInstanceInfo1());
		notice3 = new NoticeMessage("notice23", 0, SmartTest.getUserInfo2(), new LocalDate());
		notice3.setInstance(commentsInstance3);

		CommentInstanceInfo commentsInstance4 = new CommentInstanceInfo("comments4", CommentInstance.COMMENT_TYPE_ON_TASK_INSTANCE, "재 기안해 주시기 바랍니다...",
				SmartTest.getUserInfo3(), new LocalDate());
		commentsInstance4.setTaskInstance(SmartTest.getTaskInstanceInfoPA());
		notice4 = new NoticeMessage("notice24", 0, SmartTest.getUserInfo3(), new LocalDate());
		notice4.setInstance(commentsInstance4);

		return new NoticeMessage[] {notice1, notice2, notice3, notice4 };
//		return new NoticeMessage[] { notice1, notice2};

	}

	public static NoticeMessage[] getAssignedMessages() throws Exception {

		NoticeMessage notice1, notice2, notice3, notice4, notice5;
		TaskInstanceInfo[] assignedInstances = SmartTest.getAssignedTaskInstances();
		notice1 = new NoticeMessage("notice31", 0, SmartTest.getUserInfo1(), new LocalDate());
		notice1.setInstance(assignedInstances[0]);

		notice2 = new NoticeMessage("notice32", 0, SmartTest.getUserInfo2(), new LocalDate());
		notice2.setInstance(assignedInstances[1]);

		notice3 = new NoticeMessage("notice33", 0, SmartTest.getUserInfo3(), new LocalDate());
		notice3.setInstance(assignedInstances[2]);

		notice4 = new NoticeMessage("notice34", 0, getUserInfo2(), new LocalDate());
		notice4.setInstance(assignedInstances[3]);

//		notice5 = new NoticeMessage("notice35", 0, getUserInfo3(), new LocalDate());
//		notice5.setInstance(assignedInstances[4]);
//
		return new NoticeMessage[] { notice1, notice2, notice3, notice4};
	}

	public static NoticeMessage[] getMailboxMessages() throws Exception {
//
//		NoticeMessage notice1, notice2, notice3, notice4, notice5;
//		MailInstanceInfo mailInstance1 = new MailInstanceInfo("mailinst1", "하이닉스프로젝트관련 회의록입니다.", SmartTest.getUser3(), new LocalDate());
//		mailInstance1.setMailCategory(SmartTest.getWorkCategoryInfo1());
//		mailInstance1.setMailGroup(SmartTest.getSmartWorkInfo6());
//		notice1 = new NoticeMessage("notice41", 0, SmartTest.getUserInfo3(), new LocalDate());
//		notice1.setInstance(mailInstance1);
//
//		MailInstance mailInstance2 = new MailInstance("mailinst2", "내용검토하시고 의견주시기 바랍니다.", SmartTest.getUser1(), new LocalDate());
//		mailInstance2.setMailCategory(SmartTest.getWorkCategory1());
//		notice2 = new NoticeMessage("notice42", 0, SmartTest.getUserInfo3(), new LocalDate());
//		notice2.setInstance(mailInstance2);
//
//		MailInstance mailInstance3 = new MailInstance("mailinst3", "연락처입니다.", SmartTest.getUser3(), new LocalDate());
//		mailInstance3.setMailCategory(SmartTest.getWorkCategory1());
//		mailInstance3.setMailGroup(SmartTest.getSmartWork6());
//		notice3 = new NoticeMessage("notice43", 0, SmartTest.getUser3(), new LocalDate());
//		notice3.setInstance(mailInstance3);
//
//		return new NoticeMessage[] { notice1, notice2, notice3 };
		return null;
	}

	public static NoticeMessage[] getSavedboxMessages() throws Exception {

		NoticeMessage notice1, notice2, notice3, notice4, notice5;

		notice1 = new NoticeMessage("notice31", 0, SmartTest.getUserInfo2(), new LocalDate());
		notice1.setInstance(getTaskInstanceInfoIA());
		
		notice2 = new NoticeMessage("notice32", 0, SmartTest.getUserInfo2(), new LocalDate());
		notice2.setInstance(SmartTest.getWorkInstanceInfo5());
		

		return new NoticeMessage[] { notice1, notice2};

	}
	
	private static IWInstanceInfo[] getInstanceRecords1() throws Exception{
		FieldData[] fieldDatas = new FieldData[] {new FieldData("f1", FormField.TYPE_TEXT, "금성출판사 제안 자료입니다."), new FieldData("f2", FormField.TYPE_USER, "과장 김지숙"), new FieldData("f3", FormField.TYPE_OTHER_WORK, "경영기획본부/마케팅팀"), new FieldData("f4", FormField.TYPE_RICHTEXT_EDITOR, "유용한자료이니 참조들 하시기 바랍니다."), new FieldData("f5", FormField.TYPE_FILE, "금성출판사-제안서.ppt")};
		IWInstanceInfo instanceRecord = new IWInstanceInfo("iworkInstance1", "회의록", SmartTest.getSmartWorkInfo1(), getUserInfo1(), getUserInfo2(), new LocalDate());
		instanceRecord.setDisplayDatas(fieldDatas);
		return new IWInstanceInfo[] {instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord};
	}
	
	private static PWInstanceInfo[] getInstanceRecords2() throws Exception{
		PWInstanceInfo instanceRecord = getWorkInstanceInfo1();
		return new PWInstanceInfo[] {instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord, instanceRecord};
	}
	
	public static InstanceInfoList getWorkInstanceList1(RequestParams params) throws Exception{
		InstanceInfoList instanceList = new InstanceInfoList();
		instanceList.setType(InstanceInfoList.TYPE_INFORMATION_INSTANCE_LIST);
		instanceList.setPageSize(params.getPageSize());
		instanceList.setTotalPages(31);
		instanceList.setCurrentPage(params.getCurrentPage());
		InstanceInfo[] instanceRecords = getInstanceRecords1();
		instanceList.setInstanceDatas(instanceRecords);
		return instanceList;
	}
	public static InstanceInfoList getWorkInstanceList2(RequestParams params) throws Exception{
		InstanceInfoList instanceList = new InstanceInfoList();
		instanceList.setType(InstanceInfoList.TYPE_PROCESS_INSTANCE_LIST);
		instanceList.setPageSize(params.getPageSize());
		instanceList.setTotalPages(31);
		instanceList.setCurrentPage(params.getCurrentPage());
		InstanceInfo[] instanceRecords = getInstanceRecords2();
		instanceList.setInstanceDatas(instanceRecords);
		return instanceList;
	}
	
	public static EventInstanceInfo[] getEventInstances() throws Exception{
		LocalDate time1 = new LocalDate();
		time1.plusToGMTTime(-1 * LocalDate.ONE_HOUR);
		LocalDate time2 = new LocalDate();
		time2.plusToGMTTime(LocalDate.ONE_HOUR);
		LocalDate time3 = new LocalDate();
		time3.plusToGMTTime(3 * LocalDate.ONE_HOUR);
		LocalDate time4 = new LocalDate();
		time4.plusToGMTTime(5 * LocalDate.ONE_HOUR);
		LocalDate time5 = new LocalDate();
		time5.plusToGMTTime(LocalDate.ONE_DAY);
		LocalDate time6 = new LocalDate();
		time6.plusToGMTTime(LocalDate.ONE_DAY + LocalDate.ONE_HOUR);
		LocalDate time7 = new LocalDate();
		time7.plusToGMTTime(2 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 3);
		LocalDate time8 = new LocalDate();
		time8.plusToGMTTime(2 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 7);
		LocalDate time9 = new LocalDate();
		time9.plusToGMTTime(1 * LocalDate.ONE_YEAR + LocalDate.ONE_HOUR * 10);
		LocalDate time10 = new LocalDate();
		time10.plusToGMTTime(1 * LocalDate.ONE_YEAR + LocalDate.ONE_HOUR * 14);
		EventInstanceInfo event1 = new EventInstanceInfo("event1", "정부장님 점심약속", SmartTest.getUserInfo1(), new LocalDate());
		event1.setStart(time1);
		event1.setEnd(time2);
		event1.setRelatedUsers(new UserInfo[] { SmartTest.getUserInfo1() });

		EventInstanceInfo event2 = new EventInstanceInfo("event2", "스마트웍스닷넷 디자인회의", SmartTest.getUserInfo1(), new LocalDate());
		event2.setStart(time3);
		event2.setEnd(time4);
		event2.setWorkSpace(SmartTest.getGroupInfo1());

		EventInstanceInfo event3 = new EventInstanceInfo("event3", "주간업무 보고회의", SmartTest.getUserInfo3(), new LocalDate());
		event3.setStart(time5);
		event3.setEnd(time6);
		event3.setWorkSpace(SmartTest.getDepartmentInfo1());

		EventInstanceInfo event4 = new EventInstanceInfo("event4", "KT 스마트웍킹팀 저녁", SmartTest.getUserInfo1(), new LocalDate());
		event4.setStart(time7);
		event4.setEnd(time8);

		EventInstanceInfo event5 = new EventInstanceInfo("event5", "진산회 골프모임", getUserInfo3(), new LocalDate());
		event5.setStart(time9);
		event5.setEnd(time10);
		return new EventInstanceInfo[] { event1, event2, event3, event4, event5 };		
	}
	
	public static DepartmentInfo[] getMyDepartments() throws Exception{
		return new DepartmentInfo[] { SmartTest.getDepartmentInfo1(), SmartTest.getDepartmentInfo2(), SmartTest.getDepartmentInfo3(), SmartTest.getDepartmentInfo4() };
	}

	public static CompanyCalendar[] getCompanyCalendars() throws Exception{
		CompanyCalendar cc1 = new CompanyCalendar(new LocalDate(), new CompanyEvent[] { SmartTest.getCompanyEvent1(), SmartTest.getCompanyEvent2() },
			new WorkHour());
		CompanyCalendar cc2 = new CompanyCalendar(new LocalDate((new LocalDate()).getTime() + LocalDate.ONE_DAY),
			new CompanyEvent[] { SmartTest.getCompanyEvent2() }, new WorkHour());
		CompanyCalendar cc3 = new CompanyCalendar(new LocalDate((new LocalDate()).getTime() + LocalDate.ONE_DAY * 2),
			new CompanyEvent[] { SmartTest.getCompanyEvent1() }, new WorkHour());
		return new CompanyCalendar[] { cc1, cc2, cc3 };
	}

	public static CompanyCalendar getCompanyEventBox(LocalDate date) throws Exception {
		CompanyCalendar eventBox = new CompanyCalendar();
		eventBox.setDate(date);
		CompanyEvent event1 = new CompanyEvent();
		eventBox.setCompanyEvents(new CompanyEvent[] { event1 });
		return eventBox;
	}

	public static Department getDepartmentById(String departId) throws Exception {
		Department[] departments = new Department[] { SmartTest.getDepartment1(), SmartTest.getDepartment2(), SmartTest.getDepartment3(), SmartTest.getDepartment4() };
		for (int i = 0; i < departments.length; i++) {
			if (departments[i].getId().equals(departId))
				return departments[i];
		}
		return departments[0];
	}

	public static GroupInfo[] getMyGroups() throws Exception {
		return new GroupInfo[] { SmartTest.getGroupInfo1(), SmartTest.getGroupInfo2(), SmartTest.getGroupInfo3() };
	}

	public static Group getGroupById(String groupId) throws Exception {
		Group[] groups = new Group[] { SmartTest.getGroup1(), SmartTest.getGroup2(), SmartTest.getGroup3() };
		for (int i = 0; i < groups.length; i++) {
			if (groups[i].getId().equals(groupId))
				return groups[i];
		}
		return null;
	}

	public static User getUserById(String userId) throws Exception {
		if (SmartUtil.getCurrentUserOld().getId().equals(userId))
			return SmartUtil.getCurrentUserOld();
		else if (SmartTest.getUser1().getId().equals(userId))
			return SmartTest.getUser1();
		else if (SmartTest.getUser2().getId().equals(userId))
			return SmartTest.getUser2();
		return SmartUtil.getCurrentUserOld();
	}

	public static WorkSpaceInfo[] searchCommunity() throws Exception {
		WorkSpaceInfo[] comms = new WorkSpaceInfo[] { getGroupInfo1(), SmartTest.getUserInfo1(), getDepartmentInfo1(), SmartTest.getUserInfo2() };
		return comms;

	}

	public static UserInfo[] searchCommunityMember() throws Exception {
		UserInfo[] users = new UserInfo[] { SmartTest.getUserInfo1(), SmartTest.getUserInfo2() };
		return users;

	}

	public static WorkSpace getWorkSpaceById(String workSpaceId) throws Exception {
		WorkSpace workSpace = null;

		Department[] departments = new Department[] { SmartTest.getDepartment1(), SmartTest.getDepartment2(), SmartTest.getDepartment3(), SmartTest.getDepartment4() };
		for (Department department : departments) {
			if (department.getId().equals(workSpaceId))
				return department;
		}
		Group[] groups = new Group[] { SmartTest.getGroup1(), SmartTest.getGroup2(), SmartTest.getGroup3() };
		for (Group group : groups) {
			if (group.getId().equals(workSpaceId))
				return group;
		}

		if (SmartTest.getUser1().getId().equals(workSpaceId))
			return SmartTest.getUser1();
		if (SmartTest.getUser2().getId().equals(workSpaceId))
			return SmartTest.getUser2();
		if (SmartTest.getUser3().getId().equals(workSpaceId))
			return SmartTest.getUser3();
		if (SmartUtil.getCurrentUserOld().getId().equals(workSpaceId))
			return SmartUtil.getCurrentUserOld();

		return workSpace;
	}

	public static UserInfo[] getAvailableChatter() throws Exception {
		UserInfo[] chatters = new UserInfo[] { SmartTest.getUserInfo2(), SmartTest.getUserInfo1(), SmartTest.getUserInfo2(), SmartTest.getUserInfo1(),
				SmartTest.getUserInfo2(), SmartTest.getUserInfo1(), SmartTest.getUserInfo2(), SmartTest.getUserInfo1()};
		return chatters;
	}

	public static CommunityInfo[] getMyCommunities() throws Exception {
		return (CommunityInfo[])(new WorkSpaceInfo[] {SmartTest.getDepartmentInfo1(), SmartTest.getDepartmentInfo2(), SmartTest.getDepartmentInfo3(), SmartTest.getDepartmentInfo4(), SmartTest.getGroupInfo1(), SmartTest.getGroupInfo2(), SmartTest.getGroupInfo3()}); 
	}

	public static BoardInstanceInfo[] getBoardInstances() throws Exception {
		LocalDate time1 = new LocalDate();
		time1.plusToGMTTime(-(1 * LocalDate.ONE_HOUR));
		LocalDate time2 = new LocalDate();
		time2.plusToGMTTime(-(LocalDate.ONE_HOUR));
		LocalDate time3 = new LocalDate();
		time3.plusToGMTTime(-(3 * LocalDate.ONE_HOUR));
		LocalDate time4 = new LocalDate();
		time4.plusToGMTTime(-(5 * LocalDate.ONE_HOUR));
		LocalDate time5 = new LocalDate();
		time5.plusToGMTTime(-(LocalDate.ONE_DAY));
		LocalDate time6 = new LocalDate();
		time6.plusToGMTTime(-(LocalDate.ONE_DAY + LocalDate.ONE_HOUR));
		LocalDate time7 = new LocalDate();
		time7.plusToGMTTime(-(2 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 3));
		LocalDate time8 = new LocalDate();
		time8.plusToGMTTime(-(2 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 7));
		LocalDate time9 = new LocalDate();
		time9.plusToGMTTime(-(10 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 10));
		LocalDate time10 = new LocalDate();
		time10.plusToGMTTime(-(10 * LocalDate.ONE_DAY + LocalDate.ONE_HOUR * 14));

		BoardInstanceInfo board1 = new BoardInstanceInfo("board1", "워크샵 일정계획 공지 합니다.", SmartTest.getUserInfo1(), time1);
		board1.setWorkSpace(SmartTest.getGroupInfo2());
		board1.setBriefContent("좋은내용으로 기획하고 있으니 많은 의견들 주시기 바랍니다........");
		BoardInstanceInfo board2 = new BoardInstanceInfo("board2", "하반기 해외 B2B마케팅 성공사례 세미나", SmartTest.getUserInfo1(), time2);
		board2.setWorkSpace(SmartTest.getGroupInfo2());
		BoardInstanceInfo board3 = new BoardInstanceInfo("board3", "올레캠퍼스 자바개발자 교육과정 소개합니다.", SmartTest.getUserInfo2(), time3);
		board3.setWorkSpace(SmartTest.getDepartmentInfo2());
		BoardInstanceInfo board4 = new BoardInstanceInfo("board4", "가을 조직개편 조직도 입니다.", SmartTest.getUserInfo3(), time4);
		board4.setWorkSpace(SmartTest.getGroupInfo1());
		BoardInstanceInfo board5 = new BoardInstanceInfo("board5", "가을 정기 임직원 승진 발표", SmartTest.getUserInfo3(), time5);
		BoardInstanceInfo board6 = new BoardInstanceInfo("board6", "2011년도 경영계획 공지합니다.", SmartTest.getUserInfo1(), time6);
		BoardInstanceInfo board7 = new BoardInstanceInfo("board7", "여름휴가 일정 공지합니다.", SmartTest.getUserInfo3(), time7);
		BoardInstanceInfo board8 = new BoardInstanceInfo("board8", "제품개발 프로젝트 전체 일정 계획공지합니다.", SmartTest.getUserInfo2(), time8);
		board8.setWorkSpace(SmartTest.getDepartmentInfo1());
		BoardInstanceInfo board9 = new BoardInstanceInfo("board9", "사무실 이전 계획 입니다.", SmartTest.getUserInfo1(), time9);
		BoardInstanceInfo board10 = new BoardInstanceInfo("board10", "스마트웍스닷넷 장기 로드맵 입니다.", SmartTest.getUserInfo1(),
				time10);
		return new BoardInstanceInfo[] { board1, board2, board3, board4, board5 };
	}

	public static InstanceInfo[] getMyRecentInstances() throws Exception {
		TaskInstanceInfo taskInstance = new TaskInstanceInfo("taskInstance1", "대표이사승인", TaskInstance.TYPE_PROCESS_TASK_ASSIGNED, getUserInfo2(), getUserInfo2(), new LocalDate(LocalDate.convertStringToTime("201110051600")));
		taskInstance.setStatus(Instance.STATUS_RUNNING);
		taskInstance.setAssignee(getUserInfo1());
		PWInstanceInfo workInstance1 = new PWInstanceInfo("inst1", "휴가 신청합니다.", getSmartWorkInfo1(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110211300")), taskInstance);
		IWInstanceInfo workInstance2 = new IWInstanceInfo("inst2", "스마트웍스 3.0 개발계획 회의록 입니다.", getSmartWorkInfo2(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110230900")));
		PWInstanceInfo workInstance3 = new PWInstanceInfo("inst3", "노트북 구매 기안합니다.", getSmartWorkInfo3(), getUserInfo1(), getUserInfo1(), new LocalDate(LocalDate.convertStringToTime("201110251621")), taskInstance);
		IWInstanceInfo workInstance5 = new IWInstanceInfo("inst5", "삼성 노트북 구매발주서", getSmartWorkInfo8(), getUserInfo3(), getUserInfo3(), new LocalDate(LocalDate.convertStringToTime("201110291300")));
		taskInstance.setWorkInstance(workInstance1);

			return new InstanceInfo[] { workInstance1, workInstance2, workInstance3,
					workInstance5 };
	}

	public static Instance getInstanceById(String instanceId) throws Exception {
		Instance[] instances = new Instance[] { SmartTest.getWorkInstance1(), SmartTest.getWorkInstance2(), SmartTest.getWorkInstance3(),
				SmartTest.getWorkInstance4(), SmartTest.getWorkInstance5(), SmartTest.getTaskInstanceIA(), SmartTest.getTaskInstanceIF(),
				SmartTest.getTaskInstancePA(), SmartTest.getTaskInstancePF(), SmartTest.getTaskInstanceSA(), SmartTest.getTaskInstanceSF(),
				SmartTest.getTaskInstanceAA(), SmartTest.getTaskInstanceAF() };
		for (Instance instance : instances) {
			if (instance.getId().equals(instanceId))
				return instance;
		}
		return null;
	}

	public static Notice[] getNoticesForMe() throws Exception {
		return new Notice[] { new Notice(Notice.TYPE_NOTIFICATION, 1), new Notice(Notice.TYPE_MESSAGE, 0), new Notice(Notice.TYPE_COMMENT, 29),
				new Notice(Notice.TYPE_ASSIGNED, 0), new Notice(Notice.TYPE_MAILBOX, 420), new Notice(Notice.TYPE_SAVEDBOX, 7) };
	}

	public static NoticeBox getNoticeBoxForMe10(int noticeType) throws Exception {
		if (noticeType == Notice.TYPE_NOTIFICATION) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getNotificationMessages());
			noticeBox.setNoticeType(Notice.TYPE_NOTIFICATION);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_MESSAGE) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getMessageMessages());
			noticeBox.setNoticeType(Notice.TYPE_MESSAGE);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_COMMENT) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getCommentsMessages());
			noticeBox.setNoticeType(Notice.TYPE_COMMENT);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}

		if (noticeType == Notice.TYPE_ASSIGNED) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getAssignedMessages());
			noticeBox.setNoticeType(Notice.TYPE_ASSIGNED);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}
		if (noticeType == Notice.TYPE_MAILBOX) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getMailboxMessages());
			noticeBox.setNoticeType(Notice.TYPE_MAILBOX);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}
		if (noticeType == Notice.TYPE_SAVEDBOX) {
			NoticeBox noticeBox = new NoticeBox();
			noticeBox.setNoticeMessages(SmartTest.getSavedboxMessages());
			noticeBox.setNoticeType(Notice.TYPE_SAVEDBOX);
			noticeBox.setDateOfLastNotice(new LocalDate());
			noticeBox.setRemainingLength(48);
			return noticeBox;
		}
		return null;
	}

	public static String[] getBroadcastingMessages() throws Exception {
		return new String[] { "오늘 시스템 작업예정으로 오후 5시부터 한시간 동안 시스템을 사용할 수 없으니, 업무진행에 착오없으시길...",
				"금일 전체회식에 전원참석하여 좋은 친목의 시간이 되기를 바랍니다. --- 경영 기획팀 ----" };
	}

	public static Work getWorkById(String workId) throws Exception {
		Work[] works = new Work[] { SmartTest.getSmartWork1(), SmartTest.getSmartWork2(), SmartTest.getSmartWork3(), SmartTest.getSmartWork4(), SmartTest.getProcessWork1(),
				SmartTest.getSmartWork5(), SmartTest.getSmartWork6(), SmartTest.getSmartWork7(), SmartTest.getSmartWork8(), SmartTest.getSmartWork9(), SmartTest.getInformationWork1() };
		for (Work work : works) {
			if (work.getId().equals(workId))
				return work;
		}
		return null;
	}

	public static Report[] getReportsByWorkId() throws Exception{
		return ChartReport.DEFAULT_CHARTS_INFORMATION;
	}

	public static Report getReportById() throws Exception{
		return ChartReport.getChartPCntMonthly();
	}
	
	public static SearchFilter getSearchFilterById() throws Exception{
		return SearchFilter.getMyRecentInstancesFilter(getUser1());
	}

	public static TaskInstanceInfo[] getTaskInstancesByWorkHour(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception {
		return SmartTest.getAssignedTaskInstances();
	}
	public static TaskInstanceInfo[][] getTaskInstancesByWorkHours(String contextId, String spaceId, LocalDate date, int maxSize) throws Exception {
		
		return new TaskInstanceInfo[][]{SmartTest.getAssignedTaskInstances(), SmartTest.getAssignedTaskInstances(), SmartTest.getAssignedTaskInstances()};
	}
	public static TaskInstanceInfo[] getTaskInstancesByDate(String contextId, String spaceId, LocalDate date, int maxSize) throws Exception {
		return SmartTest.getAssignedTaskInstances();
	}
	public static TaskInstanceInfo[][] getTaskInstancesByDates(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception {
		return new TaskInstanceInfo[][]{SmartTest.getAssignedTaskInstances(), SmartTest.getAssignedTaskInstances(), SmartTest.getAssignedTaskInstances(), SmartTest.getAssignedTaskInstances()};
	}
	public static TaskInstanceInfo[] getTaskInstancesByWeek(String contextId, String spaceId, LocalDate weekStart, LocalDate weekEnd, int maxSize) throws Exception {
		return SmartTest.getAssignedTaskInstances();
	}
	public static TaskInstanceInfo[][] getTaskInstancesByWeeks(String contextId, String spaceId, LocalDate month, int maxSize) throws Exception {
		return new TaskInstanceInfo[][]{SmartTest.getAssignedTaskInstances(), SmartTest.getAssignedTaskInstances(), SmartTest.getAssignedTaskInstances()};
	}
	public static TaskInstanceInfo[] getTaskInstancesByDate(String contextId, String spaceId, LocalDate fromDate, LocalDate toDate, int maxSize) throws Exception {
		return SmartTest.getAssignedTaskInstances();
	}
	
	
	public static Data getReportData() throws Exception{
		Data reportData = new Data();
	    Map<String,Object> value1 = new HashMap<String, Object>();
	    Map<String,Object> value2 = new HashMap<String, Object>();
	    Map<String,Object> value3 = new HashMap<String, Object>();
	    Map<String,Object> value4 = new HashMap<String, Object>();
	    Map<String,Object> value5 = new HashMap<String, Object>();
	    Map<String,Object> value6 = new HashMap<String, Object>();
	    Map<String,Object> value7 = new HashMap<String, Object>();
	    Map<String,Object> value8 = new HashMap<String, Object>();
	    Map<String,Object> value9 = new HashMap<String, Object>();
	    Map<String,Object> value10 = new HashMap<String, Object>();
	    Map<String,Object> value11 = new HashMap<String, Object>();
	    Map<String,Object> value12 = new HashMap<String, Object>();
	    List<Map<String , Object>> values  = new java.util.ArrayList<Map<String,Object>>();
	    value1.put("name", "정 윤식");
	    value1.put("yesterday", 10);
	    value1.put("today", 9);
	    value1.put("tomorrow", 11);
	    value1.put("sunday", 10);
	    value1.put("monday", 9);
	    value1.put("tuesday", 11);
	    value2.put("name", "유 광민");
	    value2.put("yesterday", 5);
	    value2.put("today", 3);
	    value2.put("tomorrow", 7);
	    value2.put("sunday", 10);
	    value2.put("monday", 9);
	    value2.put("tuesday", 11);
	    value3.put("name", "신 현성");
	    value3.put("yesterday", 8);
	    value3.put("today", 13);
	    value3.put("tomorrow", 1);
	    value3.put("sunday", 10);
	    value3.put("monday", 9);
	    value3.put("tuesday", 11);
	    value4.put("name", "이 현정");
	    value4.put("yesterday", 8);
	    value4.put("today", 13);
	    value4.put("tomorrow", 1);
	    value4.put("sunday", 10);
	    value4.put("monday", 9);
	    value4.put("tuesday", 11);
	    value5.put("name", "김 지숙");
	    value5.put("yesterday", 8);
	    value5.put("today", 13);
	    value5.put("tomorrow", 1);
	    value5.put("sunday", 10);
	    value5.put("monday", 9);
	    value5.put("tuesday", 11);
	    value6.put("name", "김 태수");
	    value6.put("yesterday", 8);
	    value6.put("today", 13);
	    value6.put("tomorrow", 1);
	    value6.put("sunday", 10);
	    value6.put("monday", 9);
	    value6.put("tuesday", 11);
	    value7.put("name", "김 정남");
	    value7.put("yesterday", 10);
	    value7.put("today", 9);
	    value7.put("tomorrow", 11);
	    value7.put("sunday", 10);
	    value7.put("monday", 9);
	    value7.put("tuesday", 11);
	    value8.put("name", "전 태일");
	    value8.put("yesterday", 5);
	    value8.put("today", 3);
	    value8.put("tomorrow", 7);
	    value8.put("sunday", 10);
	    value8.put("monday", 9);
	    value8.put("tuesday", 11);
	    value9.put("name", "이 현주");
	    value9.put("yesterday", 8);
	    value9.put("today", 13);
	    value9.put("tomorrow", 1);
	    value9.put("sunday", 10);
	    value9.put("monday", 9);
	    value9.put("tuesday", 11);
	    value10.put("name", "박 은현");
	    value10.put("yesterday", 8);
	    value10.put("today", 13);
	    value10.put("tomorrow", 1);
	    value10.put("sunday", 10);
	    value10.put("monday", 9);
	    value10.put("tuesday", 11);
	    value11.put("name", "정 동빈");
	    value11.put("yesterday", 8);
	    value11.put("today", 13);
	    value11.put("tomorrow", 1);
	    value11.put("sunday", 10);
	    value11.put("monday", 9);
	    value11.put("tuesday", 11);
	    value12.put("name", "정 병준");
	    value12.put("yesterday", 8);
	    value12.put("today", 13);
	    value12.put("tomorrow", 1);
	    value12.put("sunday", 10);
	    value12.put("monday", 9);
	    value12.put("tuesday", 11);
	    values.add(value1);
	    values.add(value2);
	    values.add(value3);
	    values.add(value4);
	    values.add(value5);
	    values.add(value6);
	    values.add(value7);
	    values.add(value8);
	    values.add(value9);
	    values.add(value10);
	    values.add(value11);
	    values.add(value12);
	    reportData.setValues(values);
	    reportData.setGroupNames(new String[]{"yesterday", "today", "tomorrow", "sunday", "monday", "tuesday"});
	    reportData.setxFieldName("name");
	    reportData.setyValueName("count");
	    
	    return reportData;
	}
}
