var selectDate = new Date();
var functionName;
var workTypeGlobal="";
/**
 * Today Image location Informatiozn
 * @param divisionCode	: 중요도,프로세스,프로세스 구분
 * @param imgCode		: 이미지 구분
 * @return
 */
var getTodayImgControl = function (divisionCode,imgCode){
	var imgsrc = "";
	if(divisionCode=="importance"){
		switch(imgCode){
			case "H": imgsrc="../images/label_high.gif";
				break;
			default : imgsrc="";
				break; 
		}
	}else if(divisionCode=="process"){
		switch(imgCode){
		case "SINGLE": imgsrc="../images/icon/package/ic_information.gif";
		break;  
		case "APPROVAL" : imgsrc="../images/type_pro_del.gif";
			break;
		case "REFERENCE" : imgsrc="../images/type_inf_del_ref.gif"; 
			break;
		case "COMMON" : imgsrc="../images/icon/package/ic_process.gif";
			break;
		case "PRCAPPROVAL" : imgsrc="../images/icon/taskType/type_pro_sub.gif";
			break;
		case "FRMAPPROVAL" : imgsrc="../images/icon/taskType/type_inf_sub.gif";
			break;
		case "4" : imgsrc="../images/type_pro_sub.gif";
			break;
		case "5" : imgsrc="../images/ype_pro_rec.gif";
			break;
		case "6" : imgsrc="../images/type_pro_ref.gif";
			break;
		case "7" : imgsrc="../images/type_inf_del_rec.gif";
			break;
		case "8" : imgsrc="../images/type_pro_del_rec.gif";
			break;
		case "9" : imgsrc="../images/type_inf_del_ref.gif";
			break;
		case "10" : imgsrc="../images/type_pro_del_ref.gif";
			break;
		case "11" : imgsrc="../images/type_inf_sub_rec.gif";
			break;
		case "12" : imgsrc="../images/type_pro_sub_rec.gif";
			break;
		case "13" : imgsrc="../images/type_inf_sub_ref.gif";
			break;
		case "14" : imgsrc="../images/type_pro_sub_ref.gif";
			break;
		default : imgsrc="";
			break;
		}
	}else if(divisionCode=="dept"){
		switch(imgCode){
		case "TEAM" : imgsrc="../images/ico_team.gif";
			break;
		case "DEPT" : imgsrc="../images/ico_depart.gif";
			break;
		default : imgsrc="../images/ico_team.gif";
			break;
		}
	}else if(divisionCode == "status"){
		switch(imgCode){
		case "GOING" : imgsrc="../images/cstate_going.gif";
			break;
		case "DELAY" : imgsrc="../images/cstate_delay.gif";
			break;
		case "COMPLETE" : imgsrc="../images/cstate_complete.gif";
			break;
		case "SCHEDULE" : imgsrc="../images/cstate_yet.gif";
			break;
		case "RETURN" : imgsrc="../images/cstate_return.gif";
			break;
		case "WKCANCEL" : imgsrc="../images/cstate_cancel.gif";
		    break;
		default : imgsrc="../images/cstate_going.gif";
			break;
		}
	}
	return imgsrc;
}


/**
 * <pre>selectDate 값  초기화 하고자 하는 경우 Click on the tab, while calling </pre>
 * @return
 */
function initializationSelectDate(){
	selectDate = new Date();
}

/**
 * <Doc>나의 업무 일주일 탭 화면에서 날짜 왼쪽 오른쪽 이미지 클릭시</Doc>
 * @param Obj 	   : R , L
 * @param dateType : week, month, year;
 */
function setSelectDate(obj, dateType){
	if(obj !== undefined){
		if(dateType == "week"){
			var days = selectDate.getDay();
			var firstDay = 1 - days;
			var endDay   = 7 - days;
			if(obj == 'R'){
				selectDate.setDate(selectDate.getDate()+endDay+1); 
			}else if(obj == 'L'){
				selectDate.setDate(selectDate.getDate()-endDay);
			}
		}
	}
}

/**
 * 이전달 ~ 다음달
 * @param month : 기준 selectDate month() 값
 * @return
 */
function prevMonth(month, userLanguage) {
	selectDate = new Date(selectDate.getFullYear(), (month - 1), selectDate
			.getDate());

	var startDate = new Date();
	var endDate = new Date();

	startDate.setFullYear(selectDate.getFullYear());
	endDate.setFullYear(selectDate.getFullYear());

	startDate.setMonth((selectDate.getMonth() + 1));
	endDate.setMonth((selectDate.getMonth() + 2));

	var dateJSON;
	if(userLanguage =='ENG'){
		dateJSON= {
			"startDate" : startDate.getFullYear() + "."
					+ (startDate.getMonth() + 1),
			"endDate" : endDate.getFullYear() + "." + (endDate.getMonth() + 1)
		};
	}else{
		dateJSON= {
				"startDate" : startDate.getFullYear() + "년"
						+ (startDate.getMonth() + 1) + "월",
				"endDate" : endDate.getFullYear() + "년" + (endDate.getMonth() + 1) + "월"
			};
	}
	return dateJSON;
}

/**
 * 다음달 ~ 그다음달
 * @param month : 기준 selectDate month() 값
 * @return
 */
function nextMonth(month, userLanguage) {
	selectDate = new Date(selectDate.getFullYear(), (month + 1), selectDate
			.getDate());
	var startDate = new Date();
	var endDate = new Date();

	startDate.setFullYear(selectDate.getFullYear());
	endDate.setFullYear(selectDate.getFullYear());

	startDate.setMonth((selectDate.getMonth() + 1));
	endDate.setMonth((selectDate.getMonth() + 2));
	
	var dateJSON;
	if(userLanguage =='ENG'){
		dateJSON = {
			"dateItem" : [
					{
						"startDate" : startDate.getFullYear() + "."
								+ ((startDate.getMonth() + 1) == 13 ? 1:(startDate.getMonth() + 1))
					},
					{
						"endDate" : endDate.getFullYear() + "."
								+ ((endDate.getMonth() + 1) == 13 ? 1:(startDate.getMonth() + 1))
					} ]
		};
	}else{
		dateJSON = {
				"dateItem" : [
						{
							"startDate" : startDate.getFullYear() + "년"
									+ ((startDate.getMonth() + 1) == 13 ? 1:(startDate.getMonth() + 1)) + "월"
						},
						{
							"endDate" : endDate.getFullYear() + "년"
									+ ((endDate.getMonth() + 1) == 13 ? 1:(endDate.getMonth() + 1)) + "월"
						} ]
			};
	}
	return dateJSON;
}

/**
 * 이전년도 및 다음년도 구하기 
 * @param year  : 기준년도
 * @param type  : R , L
 * @return
 */
var yearControl = function(year, type) {
	var resultYear = "";
	selectDate.setFullYear(year, 0, 1);

	if (type == "R") {
		selectDate.setFullYear(year + 1, 0, 1);
	} else if (type == "L") {
		selectDate.setFullYear(year - 1, 0, 1);
	}

	return selectDate.getFullYear();
}

/**
 * @param Obj 	   : R , L
 * @param dateType : week, month, year;
 * @return
 */
function getDate(obj, dateType, workType, vchartFlag) {
	setSelectDate(obj, dateType);
	
	var userLanguage = $F('userLanguage');

	var day = selectDate.getDay();
	var year = selectDate.getFullYear();
	var month = selectDate.getMonth();
	var date = selectDate.getDate();

	var firstDay = 1 - day;
	var endDay = 7 - day;
	var sDate = new Date(year, month, date + firstDay); //월
	var eDate = new Date(year, month, date + endDay); //일

	var startDate = "";
	var endDate = "";
	var dateJSON;

	var num = 0;

	if (dateType == 'day') {
		num = 1;
		var dLong = selectDate.getTime();
		if (obj == 'R') {
			selectDate = new Date(dLong + 86400000);
		} else if (obj == 'L') {
			selectDate = new Date(dLong - 86400000);
		}
		if(userLanguage=='ENG'){
			
			startDate = changeDayeType('ENG',(selectDate.getMonth() + 1))+" "+selectDate.getDate()+", "+selectDate.getFullYear();
			
		}else{
			startDate = selectDate.getFullYear() + "년 "
			+ (selectDate.getMonth() + 1) + "월 " + selectDate.getDate()
			+ "일";
		}
	} else if (dateType == "week") {
		num = 2;
		if(userLanguage=='ENG'){
			
			startDate = changeDayeType('ENG',(sDate.getMonth() + 1))+" "+sDate.getDate()+", "+sDate.getFullYear();
			endDate = changeDayeType('ENG',((eDate.getMonth() + 1) == 13 ? 1:(eDate.getMonth() + 1)))+" "+eDate.getDate()+", "+eDate.getFullYear();
			
		}else{
			startDate = sDate.getFullYear() + "." + (sDate.getMonth() + 1) + "."
			+ sDate.getDate() + "";
			endDate = eDate.getFullYear() + "." + ((eDate.getMonth() + 1) == 13 ? 1:(eDate.getMonth() + 1)) + "."
			+ eDate.getDate() + "";
		}
	} else if (dateType == "month") {
		num = 3;
		if (obj == "R") {
			dateJSON = this.nextMonth(month, userLanguage);
			startDate = dateJSON.dateItem[0].startDate;
			endDate = dateJSON.dateItem[1].endDate;
		} else if (obj == "L") {
			dateJSON = this.prevMonth(month, userLanguage);
			startDate = dateJSON.startDate;
			endDate = dateJSON.endDate;
		} else {
			if(userLanguage=='ENG'){
				
				startDate = changeDayeType('ENG',(selectDate.getMonth() + 1))+", "+selectDate.getFullYear();
				endDate   = changeDayeType('ENG',(selectDate.getMonth() + 2) == 13 ? 1:(selectDate.getMonth() + 2))+", "+selectDate.getFullYear();
				
			}else{
				startDate = selectDate.getFullYear() + "년 " + (selectDate.getMonth() + 1)+ "월";
				endDate = selectDate.getFullYear() + "년 " + ((selectDate.getMonth() + 2) == 13 ? 1:(selectDate.getMonth() + 2))+ "월";
			}
		}

	} else if (dateType == "year") {
		num = 4;
		if(userLanguage=='ENG'){
			startDate = "Year "+this.yearControl(year, obj);
		}else{
			startDate = this.yearControl(year, obj) + "년";
		}
	}

	var label = $('simpleCalender');
	while (label.hasChildNodes()) {
		label.removeChild(label.lastChild);
	}

	var DIV = $('simpleCalender');

	//jk yoon 추가.
	if (workType == undefined) {
		if (this.workTypeGlobal != "") {
			workType = this.workTypeGlobal;
		}
	}

	var viewType = $F('viewType');
	var startImg;
	var endImg;

	if (viewType == 'vchart') {
		startImg = new Element('img', {
			src : '../images/date_prev1.png'
		}).observe('click', function() {
			getDate('L', dateType, workType, 'T');
			moveGantt('MOVE_LEFT', 'GanttTaskListViewerApp')
		}).setStyle( {
			'cursor' : 'pointer'
		});
		endImg = new Element('img', {
			src : '../images/date_next1.png'
		}).observe('click', function() {
			getDate('R', dateType, workType, 'T');
			moveGantt('MOVE_RIGHT', 'GanttTaskListViewerApp')
		}).setStyle( {
			'cursor' : 'pointer'
		});
	} else {
		startImg = new Element('img', {
			src : '../images/date_prev1.png'
		}).observe('click', function() {
			getDate('L', dateType, workType)
		}).setStyle( {
			'cursor' : 'pointer'
		});
		endImg = new Element('img', {
			src : '../images/date_next1.png'
		}).observe('click', function() {
			getDate('R', dateType, workType)
		}).setStyle( {
			'cursor' : 'pointer'
		});
	}

	startImg.setAttribute('style', 'cursor:pointer;vertical-align:middle;');
	endImg.setAttribute('style', 'cursor:pointer;vertical-align:middle;');

	var spanStart = new Element('span', {
		id : 'startDay'
	});
	var spanEnd = new Element('span', {
		id : 'endDay'
	});

	if (dateType == "week" || dateType == "month") {
		spanStart.appendChild(startImg);
		spanStart.appendChild(document.createTextNode(startDate));
		spanEnd.appendChild(document.createTextNode(endDate));
		spanEnd.appendChild(endImg);

		DIV.appendChild(spanStart);
		DIV.appendChild(document.createTextNode("~"));
		DIV.appendChild(spanEnd);
	} else if (dateType == "year" || dateType == 'day') {
		spanStart.appendChild(startImg);
		spanStart.appendChild(document.createTextNode(startDate));
		spanStart.appendChild(endImg);

		DIV.appendChild(spanStart);
	}

	if (vchartFlag != 'T') {
		if (workType == 'workManagement') {
			workTab(num, dateType);
		}
	}
	return false;
}

function changeDayeType(type,month){
	if(type=='ENG'){
		if(month=='0'){month = '';}
		else if(month=='1'){month = 'January';}
		else if(month=='2'){month = 'February';}
		else if(month=='3'){month = 'March';}
		else if(month=='4'){month = 'April';}
		else if(month=='5'){month = 'May';}
		else if(month=='6'){month = 'June';}
		else if(month=='7'){month = 'July';}
		else if(month=='8'){month = 'August';}
		else if(month=='9'){month = 'September';}
		else if(month=='10'){month = 'October';}
		else if(month=='11'){month = 'November';}
		else if(month=='12'){month = 'December';}
	}else if(type=='Date'){
		if(month==''){month = '';}
		else if(month=='January'){month = '1';}
		else if(month=='February'){month = '2';}
		else if(month=='March'){month = '3';}
		else if(month=='April'){month = '4';}
		else if(month=='May'){month = '5';}
		else if(month=='June'){month = '6';}
		else if(month=='July'){month = '7';}
		else if(month=='August'){month = '8';}
		else if(month=='September'){month = '9';}
		else if(month=='October'){month = '10';}
		else if(month=='November'){month = '11';}
		else if(month=='December'){month = '12';}
	}
	return month
}
//jk yoon
function viewChartStartDate(){
	var lang = $F('userLanguage');
	var dueDateDiv = document.getElementById('dueDateDiv').innerHTML;
	var dateArr = dueDateDiv.split("~");
	var dateArr0 = dateArr[0];
	var dateArr0_1 = dateArr0.split(' ');
	var startDay = "";
	if(lang == 'ENG'){
		var month = changeDayeType('Date',dateArr0_1[0]);
		var year = dateArr0_1[2];
		var day = dateArr0_1[1].split(',')[0];
		startDay = year +'-'+month+'-'+day+' 00:00:00';
	}else{
		var yearArr = dateArr0.split('년');
		var monthArr = yearArr[1].split('월');
		var dayArr = monthArr[1].split('일');
		startDay = yearArr[0] +'-'+ monthArr[0] +'-'+ dayArr[0]+' 00:00:00';
	}
	$('viewStartDate').setAttribute('value',startDay);
	
}

// 내업무 / 다른사람업무 선택시.
var moveWork = function(key, first) {
	this.workTypeGlobal = 'workManagement';
	if (key == 'my') {
		document.getElementById('other').setAttribute('class', 'choose');
		document.getElementById('my').setAttribute('class', 'select');
		document.getElementById('workManageTab').setAttribute('value', 'my');
		document.getElementById('otherPage').style.display = 'none';
		var tabValue = document.getElementById('tabSort').getAttribute('value');
		if (tabValue === '') {
			tabValue = 'day';
		}
		//viewWorkList(tabValue);
	} else {
		document.getElementById('my').setAttribute('class', 'choose');
		document.getElementById('other').setAttribute('class', 'select');
		document.getElementById('workManageTab').setAttribute('value', 'other');
		document.getElementById('otherPage').style.display = 'block';
		var tabValue = document.getElementById('tabSort').getAttribute('value');
		if (tabValue === '') {
			tabValue = 'day';
		}
		//viewWorkList(tabValue);
	}
	if (first != 'first')
		workTab(1, tabValue, 'first');
};

function changeStrFormat(startStr) {
	var userLanguage = $F('userLanguage'); 
	var startStrArray = startStr.toArray();
	if (startStr.indexOf('년') > -1) {
		if (startStr.indexOf('월') > -1) {
			startStrArray[startStr.indexOf('년')] = '.';
		} else {
			startStrArray[startStr.indexOf('년')] = '';
		}
	}

	if (startStr.indexOf('월') > -1) {
		if (startStr.indexOf('일') > -1) {
			startStrArray[startStr.indexOf('월')] = '.';
		} else {
			startStrArray[startStr.indexOf('월')] = '';
		}
	}
	if (startStr.indexOf('일') > -1) {
		startStrArray[startStr.indexOf('일')] = '';
	}
	startStr = "";
	for ( var i = 0; i < startStrArray.length; i++) {
		startStr += startStrArray[i];
	}
	startStr = startStr.replace(/ /g, '');
	return startStr;
}

function viewWorkList(tab, first) {
	var path = '';
	var userLanguage = $F('userLanguage');
	if (first == 'first') {
		if (tab == undefined)
			this.workDate = getDate(null, 'day', 'workManagement');

		this.workDate = getDate(null, tab, 'workManagement');
		initializationSelectDate();
	}

	var spanStart = document.getElementById('startDay').innerHTML;
	var spanEnd = '';
	
	if (tab != 'day' && tab != 'year')
		spanEnd = document.getElementById('endDay').innerHTML;
	
	if (tab == 'day') {
		document.getElementById('workSort')
				.setAttribute('value', 'workTrDiv_1');
		document.getElementById('pagingSort').setAttribute('value',
				'workTrPagingDiv_1');
		var spanStartArray = spanStart.split('>');
		var spanStartArray2 = spanStartArray[1].split('<');

		var startStr = spanStartArray2[0];
		if(userLanguage=='ENG'){
			var startArray = startStr.split(' ');
			var m = changeDayeType('Date',startArray[0]);
			var d = startArray[1].replace(',','');
			startStr = startArray[2]+"."+m+"."+d;
		}
		
		startStr = changeStrFormat(startStr);
		
		var startDate = startStr + ' 00:00:00';
		var endDate = startStr + ' 23:59:59';
		document.getElementById('startWorkDate').setAttribute('value',
				startDate);
		document.getElementById('endWorkDate').setAttribute('value', endDate);
		path = '../workManagement/wkm/workDayList.jsp';
	} else if (tab == 'week') {
		var spanEnd = document.getElementById('endDay').innerHTML;
		var spanStartArray = spanStart.split('>');
		var startStr = spanStartArray[1];
		
		if(userLanguage=='ENG'){
			var startArray = startStr.split(' ');
			var m = changeDayeType('Date',startArray[0]);
			var d = startArray[1].replace(',','');
			startStr = startArray[2]+"."+m+"."+d;
		}

		startStr = changeStrFormat(startStr);
		
		var startDate = startStr + ' 00:00:00';
		var spanEndArray = spanEnd.split('<');
		var endDateArray = startDate.split('-');
		var endDate = startStr + ' 23:59:59';

		startStr = spanEndArray[0];
		startStr = changeStrFormat(startStr);

		var endDateWeek = startStr + ' 23:59:59';
		//alert(endDateWeek);
		document.getElementById('startWorkDate').setAttribute('value', startDate);
		document.getElementById('endWorkDate').setAttribute('value', endDate);
		path = '../workManagement/wkm/workWeekList.jsp?startDate=' + startDate
				+ '&endDate=' + endDate + '&endDateWeek=' + endDateWeek;
	} else if (tab == 'month') {
		var year = selectDate.getFullYear();
		var month = selectDate.getMonth();
		var day = 1;
		var result = 0;
		for ( var i = 1; i < 8; i++) {
			var date = new Date(year, month, day);
			if (date.getDay() == 0) {
				result = i;
				break;
			} else {
				day = day + 1;
			}
		}

		var spanStartArray = spanStart.split('>');

		var startStr = spanStartArray[1];
		
		if(userLanguage=='ENG'){
			var startArray = startStr.split(' ');
			var m = startArray[0].replace(',','');
			m = changeDayeType('Date',m);
			startStr = startArray[1]+"."+m;
		}
		
		startStr = changeStrFormat(startStr);
		
		var startDate = startStr + ".1 00:00:00";
		//var spanEndArray = spanEnd.split('<');
		var endDate = startStr + "." + result + " 23:59:59";
		document.getElementById('startWorkDate').setAttribute('value',
				startDate);
		document.getElementById('endWorkDate').setAttribute('value', endDate);
		path = '../workManagement/wkm/workMonthList.jsp?startDate=' + startDate
				+ '&endDate=' + endDate
	} else if (tab == 'year') {
		var spanStartArray = spanStart.split('>');
		var spanStartArray2 = spanStartArray[1].split('<');

		var startStr = spanStartArray2[0];
		if(userLanguage=='ENG'){
			var startArray = startStr.split(' ');
			startStr = startArray[1];
		}
		startStr = changeStrFormat(startStr);

		var startDate = startStr + '.1.1 00:00:00';
		var endDate = startStr + '.1.1 23:59:59';
		document.getElementById('startWorkDate').setAttribute('value',
				startDate);
		document.getElementById('endWorkDate').setAttribute('value', endDate);
		path = '../workManagement/wkm/workYearList.jsp?startDate=' + startDate
				+ '&endDate=' + endDate
	} else {
		path = '../workManagement/wkm/workDayList.jsp';
		document.getElementById('workSort')
				.setAttribute('value', 'workTrDiv_1');
		document.getElementById('pagingSort').setAttribute('value',
				'workTrPagingDiv_1');
		var spanStartArray = spanStart.split('>');
		var spanStartArray2 = spanStartArray[1].split('<');

		var startStr = spanStartArray2[0];
		startStr = changeStrFormat(startStr);

		var startDate = startStr + ' 00:00:00';
		var endDate = startStr + ' 23:59:59';
		document.getElementById('startWorkDate').setAttribute('value',
				startDate);
		document.getElementById('endWorkDate').setAttribute('value', endDate);
	}
	return path;
}

/**
 * 업무관리 화면의 각 날짜별 TR 클릭시 함수.
 * @param pageNo
 * @return
 */
function workTrClick(pageNo, workDiv, pagingDiv, startDate, endDate, divCnt) {

	document.getElementById('workSort').setAttribute('value', workDiv);
	document.getElementById('pagingSort').setAttribute('value', pagingDiv);
	//alert(startDate+'//'+endDate);
	document.getElementById('startWorkDate').setAttribute('value', startDate);
	document.getElementById('endWorkDate').setAttribute('value', endDate);
	var tabSort = document.getElementById('tabSort').getAttribute('value');

	var ulTab = document.getElementById('workTab');
	var tabs = ulTab.childNodes;
	var num = 0;
	for ( var i = 0; i < tabs.length; i++) {
		if (tabs[i].getAttribute('class') == 'current') {
			num = i + 1;
			break;
		}
	}

	var workDivArray = workDiv.split('_');
	var pagingDivArray = pagingDiv.split('_');
	//alert(workDiv);
	if (document.getElementById(workDiv).style.display == 'none') {
		//document.getElementById(workDiv).style.display = 'block';
		$(workDiv).show( {
			duration : 0.5
		});
		$(pagingDiv).show( {
			duration : 0.5
		});
	} else {
		//document.getElementById(workDiv).style.display = 'none';
		$(workDiv).fade( {
			duration : 0.5
		});
		$(pagingDiv).fade( {
			duration : 0.5
		});
	}

	/*
	for(var j = 1; j<divCnt; j++){
		if(workDivArray[1]==j){
			document.getElementById(workDiv).style.display='block';
			document.getElementById(pagingDiv).style.display='block';
		}else{
			document.getElementById(workDivArray[0]+'_'+j).style.display='none';
			document.getElementById(pagingDivArray[0]+'_'+j).style.display='none';
		}
	}
	 */
	inProgressWork1('1',undefined, undefined, startDate, endDate);
}

/*
 * 업무 목록 가져오기
 * */
function inProgressWork1(pageNo, workDivId, pagingDivId, startDate, endDate) {
	if (pageNo == undefined) {
		$('pageNo').value = 1;
		pageNo = 1;
		workDivId = 'workTrDiv_1';
		pagingDivId = 'workTrPagingDiv_1';
	} else {
		$('pageNo').value = pageNo;
	}
	var workManageTab = document.getElementById('workManageTab').getAttribute("value");
	var workSort = document.getElementById('workSort').getAttribute('value');
	var tabSort = document.getElementById('tabSort').getAttribute('value');
	var pagingSort = document.getElementById('pagingSort').getAttribute('value');
	var trSort = document.getElementById('trSort').getAttribute('value');

	if(workDivId != undefined){
		workSort = workDivId;
		pagingSort = pagingDivId;
	}
	
	var startWorkDate = document.getElementById('startWorkDate').getAttribute('value');
	var endWorkDate = document.getElementById('endWorkDate').getAttribute('value');
	var pageSize = $F('pageSize');
	
	if(startDate != undefined){
		startWorkDate = startDate;
		endWorkDate = endDate;
	}
	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";
	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""
				&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + ";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value
					+ ";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value
					+ ";";
			v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value
					+ ";";
		}
	}

	this.functionName = "inProgressWork1";
	var params = new Array();
	params.push("method=inProgressWork");
	params.push("workDivid=" + workSort);
	params.push("pagingDivId=" + pagingSort);
	params.push("statusType=opened");
	params.push("searchWord=" + $F('searchWord1'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("pageNo=" + pageNo);
	params.push("workSort=" + workSort);
	params.push("tabSort=" + tabSort);
	params.push("trSort=" + trSort);
	params.push("spanStartDate=" + startWorkDate);
	params.push("spanEndDate=" + endWorkDate);
	params.push("pageSize=" + pageSize);
	if (workManageTab == 'other') {
		var otherUserId = document.getElementById('otherUserId').getAttribute(
				'value');
		params.push("otherUserId=" + otherUserId);
	} else {
		params.push("otherUserId=");
	}
	params = params.join("&");
	linkUrl = getPath() + "/services/portal/wkmService.jsp";
	//"workmanagement.jsp";
	request(linkUrl, params, setTodayTasksCallback1, null, null, null,
			'failed', false);
}
function inMondayWorkDiv(pageNo, workDivid, pageingDivid) {
	if (pageNo != undefined) {
		$('pageNo').value = pageNo;
	}

	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";
	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""
				&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + ";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value
					+ ";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value
					+ ";";
			v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value
					+ ";";
		}
	}

	this.functionName = "getIntendedTasks";
	var params = new Array();
	params.push("method=intendedTasks");
	params.push("workDivid=" + workDivid);
	params.push("pageingDivid=" + pageingDivid);
	params.push("statusType=opened");
	params.push("searchWord=" + $F('searchWord1'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("pageNo=" + pageNo);
	params = params.join("&");
	linkUrl = getPath() + "/services/portal/todayService.jsp";
	request(linkUrl, params, setTodayTasksCallback1, null, 'loading', null,
			'failed', false);
}

function setTodayTasksCallback1() {
	
	var userLanguage = $F('userLanguage');
	
	var xmlDoc = getXmlDOM(getResult());
	var resultXml = SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize = resultXml.getAttribute("totalSize");
	var pageingDivid = resultXml.getAttribute('pageingDivid');
	
	var spanStartDate = resultXml.getAttribute('spanStartDate');
	var spanEndDate = resultXml.getAttribute('spanEndDate');
	
	var IE = document.all ? 1 : 0;
	var workDivid = "";
	if (IE) {
		workDivid = resultXml.getElementsByTagName('workDivid').nextNode().text;
		//workDivid = resultXml.getElementsByTagName('workDivid')[0].text;
	} else {
		workDivid = resultXml.getElementsByTagName('workDivid')[0].textContent;
	}
	if (resultXml.getAttribute('status') == 'OK') {

		var intendedXml = SmartXMLUtil.getChildNodes(resultXml, 'TodayTasks');
		var workDividXml = SmartXMLUtil.getChildNodes(resultXml, 'workDivid');

		var theDiv = $(workDivid);
		var theTbody = theDiv.getElementsByTagName("tbody")[0];
		var theLength = theTbody.childNodes.length;
		for ( var i = 0; i < theLength; i++) {
			theTbody.removeChild(theTbody.firstChild);
		}

		var divId = document.getElementById(workDivid);
		var tbody = divId.getElementsByTagName("tbody")[0];

		if (intendedXml.length != 0) {
			for ( var i = 0; i < intendedXml.length; i++) {
				var taskId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'objId'));
				var taskType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'tskType'));
				var priority = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'priority'));
				var title = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'tskTitle'));
				var assignee = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'assignee'));
				var processInstId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'tskPrcInstId'));
				var formId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'tskForm'));
				var referenceId = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'reference'));
				var team = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'team'));
				var workFlow = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'workFlow'));
				var expectStartTime = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'expectStartTime'));
				var realStartTime = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'realStartTime'));
				var packageStatus = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'packageStatus'));
				var approvalType = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'approvalType'));
				var tskStatus = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'tskStatus'));
				var workStatus = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'workStatus'));
				var toolTip = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'toolTip'));
				var tskRealTitle = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'tskRealTitle'));
				var realWorkFlow = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(intendedXml[i], 'realWorkFlow'));

				//alert(tskStatus+'..,....');
				var tr = null;

				if (formId.indexOf(";") > -1) {
					var formIdArray = formId.split(";");
					formId = formIdArray[1];
				}
				var statusComplete = "";
				if (tskStatus == 21 || tskStatus == 23 || tskStatus == 24) {
					statusComplete = "complete";
				} else if (tskStatus == 11) {
					statusComplete = "opened";
				}

				if (packageStatus == "DEPLOYED") {
					tr = new Element('tr', {
						id : taskId + "tr",
						taskId : taskId,
						processInstId : processInstId,
						taskType : taskType,
						referenceId : referenceId,
						formId : formId,
						statusComplete : statusComplete
					}).observe('click', function() {
						viewMyTask(this);
					}).setStyle( {
						'cursor' : 'pointer'
					});
				} else {
					tr = new Element('tr', {
						id : taskId + "tr",
						taskId : taskId,
						processInstId : processInstId,
						taskType : taskType,
						referenceId : referenceId,
						formId : formId
					}).observe('click', function() {
						viewMyTask(null);
					}).setStyle( {
						'cursor' : 'pointer'
					});
				}

				var td0 = document.createElement("td");
				var td1 = document.createElement("td");
				var td2 = document.createElement("td");
				var td3 = document.createElement("td");
				var td4 = document.createElement("td");
				var td5 = document.createElement("td");
				var td6 = document.createElement("td");
				var td7 = document.createElement("td");

				/*
				td0.setAttribute("width","5%");
				td1.setAttribute("width","5%");
				td2.setAttribute("width","20%");
				td3.setAttribute("width","5%");
				td4.setAttribute("width","12%");
				td5.setAttribute("width","17%");
				td6.setAttribute("width","13%");
				td7.setAttribute("width","13%");
				td8.setAttribute("width","10%");
				 */
					
				var importanceImg = new Element('img', {
					src : this.getTodayImgControl("importance", priority)
				});
				var processImg = document.createElement("img");
				var deptImg = document.createElement("img");
				var workStatusImg = new Element('img', {
					src : this.getTodayImgControl("status", workStatus)
				});

				var prcImgType = taskType;
				if (approvalType == 'prc') {
					prcImgType = 'PRCAPPROVAL';
				} else if (approvalType == 'frm') {
					prcImgType = 'FRMAPPROVAL';
				}
				//alert(prcImgType);

				processImg.src = this.getTodayImgControl("process", prcImgType);
				deptImg.src = this.getTodayImgControl("dept", assignee);

				processImg.setAttribute("style", "width:27px; height:27px;");

				td3.style.textAlign = 'left';
				td0.setAttribute("alt", toolTip);
				td0.setAttribute("title", toolTip);
				td2.setAttribute("alt", tskRealTitle);
				td2.setAttribute("title", tskRealTitle);
				td4.setAttribute("alt", realWorkFlow);
				td4.setAttribute("title", realWorkFlow);

				td0.appendChild(workStatusImg);
				td1.appendChild(processImg);
				td2.appendChild(priority != "H" ? document.createTextNode(""): importanceImg);
				td2.appendChild(document.createTextNode(title));

				if (team != '')
					td3.appendChild(deptImg);
				td3.setAttribute("style", "vertical-align:middle;");
				td3.appendChild(document.createTextNode(" " + team));
				td4.appendChild(document.createTextNode(workFlow == ''? realWorkFlow:workFlow));
				td5.appendChild(document.createTextNode(expectStartTime));
				td6.appendChild(document.createTextNode(realStartTime));
				td7.appendChild(document.createTextNode(assignee));

				tr.appendChild(td0);
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				tr.appendChild(td7);
				tbody.appendChild(tr);
			}
			var parameters = "\,'" + workDivid + "\',\'" + pageingDivid+ "\',\'"+spanStartDate+"\',\'"+spanEndDate+"\'";
			var params = new Array();
			//alert(functionName);
			params.push("totalSize=" + totalSize);
			params.push("pageSize=" + $F('pageSize'));
			params.push("pageNo=" + $F('pageNo'));
			params.push("funcName=" + functionName);
			params.push("parameters=" + parameters);
			params = params.join("&");
			send(getPath() + "/common/listPaging.jsp", pageingDivid, params);

		} else {
			var tr = document.createElement("tr");
			var td = document.createElement("td");

			td.setAttribute("colspan", "8");
			if(userLanguage == 'ENG'){
				td.appendChild(document.createTextNode("No Display List"));
			}else{
				td.appendChild(document.createTextNode("업무가 없습니다."));
			}
			tr.appendChild(td);
			tbody.appendChild(tr);
		}
	}
}
/*
 * Test 참조
 */
function duplicationcheckMessage(userName, userId, saveMode, type,
		duplicationCheck, tableId, messageType) {
	var selectTheUser = document.getElementById(tableId);
	var tBody = selectTheUser.getElementsByTagName("tbody")[0];

	if (duplicationCheck != 'true') {
		var tr = document.createElement('tr');
		tr.id = userId + tableId + "_select_userTr";
		tr.setAttribute("height", 24);
		tr.style.cursor = "pointer";

		var td = document.createElement("td");
		td.setAttribute("bgColor", "#FFFFFF");
		td.setAttribute("align", "left");
		td.style.padding = "5";
		td.id = userId + tableId + "_select_Td";

		td.appendChild(document.createTextNode(userName));
		tr.appendChild(td);
		//tr.onclick = function(){eval("getDeptListClick('"+ userId +"','"+ type +"', this)")};
		tBody.appendChild(tr);
		getDeptListClick(userId, type, tr);
	} else {
		var message = '중복 되었습니다.';
		var messageTypeValue = "";
		
		if(messageType == 'DEPT') {
			messageTypeValue = 'Departmentisalreadyregistered'; //이미 등록된  부서입니다.
		} else {
			messageTypeValue = 'Userisalreadyregistered'; //이미 등록된  사용자입니다.
		}
		warnMessage(message , messageTypeValue);
	}
}

function inProgressWork2(pageNo, workDivId, pagingDivId) {
	if (pageNo == undefined) {
		$('pageNo').value = 1;
		pageNo = 1;
	} else {
		$('pageNo').value = pageNo;
	}
	//alert('1');
	var workManageTab = document.getElementById('workManageTab').getAttribute("value");
	var workSort = document.getElementById('workSort').getAttribute('value');
	var tabSort = document.getElementById('tabSort').getAttribute('value');
	var pagingSort = document.getElementById('pagingSort').getAttribute('value');
	var trSort = document.getElementById('trSort').getAttribute('value');

	var startWorkDate = document.getElementById('startWorkDate').getAttribute('value');
	var endWorkDate = document.getElementById('endWorkDate').getAttribute('value');
	var pageSize = $F('pageSize'); 
		//document.getElementById('pageSize').getAttribute('value');

	var v_filterSelect = "";
	var v_filterSearchKey = "";
	var v_filterSearchWord = "";
	var v_filterSearchUser = "";
	var filterSelect = document.getElementsByName("filterSelect");
	var filterSearchKey = document.getElementsByName("filterSearchKey");
	var filterSearchWord = document.getElementsByName("filterSearchWord");
	var filterSearchUser = document.getElementsByName("filterSearchUser");
	for ( var i = 0; i < filterSearchWord.length; i++) {
		if (filterSelect[i].value != "" && filterSearchKey[i].value != ""&& filterSearchWord[i].value != "") {
			v_filterSelect = v_filterSelect + filterSelect[i].value + ";";
			v_filterSearchKey = v_filterSearchKey + filterSearchKey[i].value + ";";
			v_filterSearchWord = v_filterSearchWord + filterSearchWord[i].value	+ ";";
			v_filterSearchUser = v_filterSearchUser + filterSearchUser[i].value	+ ";";
		}
	}

	var params = new Array();
	params.push("method=inProgressWork");
	params.push("workDivid=" + workSort);
	params.push("pagingDivId=" + pagingSort);
	params.push("statusType=opened");
	params.push("searchWord=" + $F('searchWord'));
	params.push("filterSelect=" + v_filterSelect);
	params.push("filterSearchKey=" + v_filterSearchKey);
	params.push("filterSearchWord=" + v_filterSearchWord);
	params.push("filterSearchUser=" + v_filterSearchUser);
	params.push("pageNo=" + pageNo);
	params.push("workSort=" + workSort);
	params.push("tabSort=" + tabSort);
	params.push("trSort=" + trSort);
	params.push("spanStartDate=" + startWorkDate);
	params.push("spanEndDate=" + endWorkDate);
	params.push("pageSize=" + pageSize);
	params.push("condYn=y");

	if (workManageTab == 'other') {
		var otherUserId = document.getElementById('otherUserId').getAttribute('value');
		params.push("otherUserId=" + otherUserId);
	} else {
		params.push("otherUserId=");
	}
	params = params.join("&");
	linkUrl = getPath() + "/services/portal/wkmService.jsp";
	update(linkUrl, "wkmCond", params);
}