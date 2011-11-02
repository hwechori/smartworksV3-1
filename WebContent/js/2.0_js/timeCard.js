
/**
 * 출근부 근퇴관리 신청 화면으로 이동
 */
function timeCardDraft(){
	var linkUrl = "../timeCard/timeCardDraft.jsp";

	var label = $('timeCardDefaultContents');
	while(label.hasChildNodes()){
		label.removeChild(label.firstChild);
	}
	update(linkUrl, "mainView", null, timeCardDraftCallback, "loading", "failed");
}
function timeCardDraftCallback(){
	//alert("세부내용 호출");
}

/**
 * 출근부 근퇴관리 기안 취소
 */
function timeCardDraftCancle(){
	var params = {};
	params['timeCardType'] = $F('timeCardType');
	var linkUrl   = "../timeCard/timeCardIndex.jsp?";
	location.href = linkUrl+$H(params).toQueryString();
}

/**
 * 참조자 리셋
 */
function referenceReset(){
	$('referenceUserId').value = "";
	$('referenceUserName').value = "";
}

/**
나의출근부, 다른사람 출근부
@param type :
*/
function timeCardType(type){
	var param = {
		timeCardType : type				
	}
	var params = $H(param).toQueryString();
	location.href = "../timeCard/timeCardIndex.jsp?"+params;
}


/**
 * 출근부 리스트
 * @param paramsId
 * @timeCardType   : myTimeCard , OtherTimeCard 
 * @timeCardPeriod : week , month , year
 * @return
 */
function getTimeCardList(pageNo){
	
	var timeCardPeriod = "";
	if(pageNo != undefined ){
		$('pageNo').value = pageNo;
	}
	
	if($F('timeCardPeriod') == ''){
		$('timeCardPeriod').value  = "week";
	}

	var params = new Array();
	if($('otherUserId') != undefined ){
		params.push('otherUserId='    + $F('otherUserId'));
	}
	params.push('method='		  + $F('timeCardType'));
	params.push('timeCardPeriod=' + $F('timeCardPeriod'));
	params.push('pageNo='	  	  + pageNo);
	params = params.join("&");
	
	linkUrl = getPath()+"/services/portal/timeCardService.jsp";
	request(linkUrl , params , getTimeCardListCallback , null , null , null , 'failed', true);
}

function getTimeCardListCallback(){
	var xmlDoc 		= getXmlDOM(getResult());
	var resultXml 	= SmartXMLUtil.getChildNode(xmlDoc, 'Result');
	var totalSize 	= resultXml.getAttribute("totalSize");
	var divId 		= resultXml.getAttribute("divId");
	
	var timeCardPeriod = "";
	var IE = document.all ? 1 : 0;
	if(IE){
		timeCardPeriod = resultXml.getElementsByTagName('timeCardPeriod').nextNode().text;
	} else {
		timeCardPeriod = resultXml.getElementsByTagName('timeCardPeriod')[0].textContent;
	}
	timeCardPeriod = 'timeCard'+timeCardPeriod+'Contents';
	if(resultXml.getAttribute('status') == 'OK') {
		var timeCardXml = SmartXMLUtil.getChildNodes(resultXml, 'TimeCardInfo');
		
		var tbody = $(timeCardPeriod).select('tbody')[0];//divId.getElementsByTagName('tbody')[0];
		if(timeCardXml.length !=0 ){
			for(var i=0 ; i < timeCardXml.length ; i ++){
			
				var tr = new Element('tr');
				if(timeCardPeriod == "week"){
					//TODO : 일주일간 자기 출근부 DOM 생성
				}else if(timeCardPeriod == "month"){
					//TODO : 월간 출근부  DOM생성
				}else if(timeCardPeriod == "year"){
					//TODO : 년간 출근부 DOM생성
				}
			}
		}else{
			var tr = new Element('tr');
			var td = new Element('td');
			td.setAttribute("colspan", "11");
			td.appendChild(document.createTextNode("데이터가 없습니다."));
			
			tr.appendChild(td);
			tbody.appendChild(tr);
		}
	}
}




