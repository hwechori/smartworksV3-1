FormWork = function(workspaceId){
	this.workspaceId = workspaceId;
	//this.userId = null;
	//this.serviceUrl = null;
	this.formId = null;
	this.formVer = null;			
	this.processId = null;
	this.instanceId = null;
	this.type = null;
	this.mode = null;
	this.switchVisible = false;
	this.switchMode = function(viewMode, userId){
		this.userId = userId;
		this.initFormRuntime(this.userId, FormEnv.serviceUrl, this.formId, this.formVer, this.processId, this.instanceId, this.type, viewMode);
	//	this.drawEtc(viewMode, this.type);
	};
	this.getMode = function(){
		return this.mode;
	};
	this.drawEtc = function(viewMode, loadType){
		if(loadType == "2") {
			if(viewMode == 'edit'){
				if (document.getElementById("editTable") != null)
					Element.show($("editTable"));
				if (document.getElementById("viewTable") != null)
					Element.hide($("viewTable"));
				if (document.getElementById("tagViewTable") != null)
					Element.hide($("tagViewTable"));
				if (document.getElementById("tagInputTable") != null)
					Element.show($("tagInputTable"));
			} else{
				if (document.getElementById("editTable") != null)
					Element.hide($("editTable"));
				if (document.getElementById("viewTable") != null)
					Element.show($("viewTable"));
				if (document.getElementById("tagViewTable") != null)
					Element.show($("tagViewTable"));
				if (document.getElementById("tagInputTable") != null)
					Element.hide($("tagInputTable"));
			}
		}
		
		if(document.getElementById("infoTaskTable") != null) {
			if($('infoTaskTable').visible())
				Element.hide($('infoTaskTable'));
		}
	};
	this.initFormRuntime = function(uId, _serviceUrl, _formId, _formVer, _processId, _instanceId, _type, _mode, _switchVisible){
		try{
			FormEnv.userId = uId;
			FormEnv.serviceUrl = _serviceUrl;
			this.formId = _formId;
			this.formVer = _formVer;
			this.processId = _processId;
			this.instanceId =  _instanceId;
			this.type = _type;
			this.mode = _mode;
			this.switchVisible = _switchVisible;
			//init
			FormUserUtil.getSystemInfo(FormEnv.serviceUrl);
			this.drawEtc(this.mode, this.type);
			//Element.addClassName(document.body, 'yui-skin-sam');
			this._formXml = null;
			this._recordXml= null;
			var parameters;
			if(this.type == '1' || this.type == '5'){
				parameters = {method:'getForm', userId:FormEnv.userId, workItemId : this.instanceId, formId : this.formId, language : defaultLanguage, type : this.type, mode : this.mode};
			} else {
				parameters = {method:'getForm', userId : FormEnv.userId, formId : this.formId, version : this.formVer, language : defaultLanguage, type : this.type, mode : this.mode};
			}
			
			var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
									{
										method:'get',
										contentType : 'text/xml',
										parameters: parameters,
										onSuccess: this.loadModelCallBack,
									    onFailure: this.failCallBack,
									    onException : this.exceptionCallBack,
									    req : this
									});
		}catch(e){
			$(this.workspaceId).fire('failed');
		}
	};
	this.loadModelCallBack = function(transport){
		var response = transport.responseXML;
		transport.request.options['req'].loadModel(response);
	};
	this.failCallBack = function(e){
		//alert(FormLang.loadFormMail);
		$(e.options['req'].workspaceId).fire('failed');
	};
	this.exceptionCallBack = function(e){
		$(e.options['req'].workspaceId).fire('failed');
	};
	this._formXml = null,
	this.formRuntime = null;
	this.loadModel = function(formXml){
		this._formXml = formXml;
		var workSpace = $(this.workspaceId);
		this.formRuntime = new FormRuntime(this.workspaceId);
		var docSpace = this.formRuntime.createForm(this._formXml, this.mode);

		if(this.type == "1"){
			this.formRuntime.initDataFields();
			this.loadWorkitem(this.instanceId);
		}else if(this.type == "2"){
			this.loadRecord(this.instanceId);
		}else if(this.type == "5"){
			this.loadWorkitem(this.instanceId);
		}else if(this.type == "0" || this.type == "3" || this.type == "4"){
			this.formRuntime.initDataFields();
		}else{
		}

		if(this.type == 0 || this.type == 3 || this.type == 4){
			$(this.workspaceId).fire('initialized');
		}
	};
	this.loadRecord = function(instanceId){
		var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
				{
					method:'get',
					contentType : 'text/xml',
					parameters: {method:'getSingleFormRecord', userId : FormEnv.userId, recordId : instanceId, formId : this.formId},
					onSuccess: this.loadRecordCallback,
				    onFailure: this.loadRecordFailCallback,
				    onException : this.exceptionCallBack,
					req : this
				});
	};
	this.loadRecordCallback = function(transport){
      var response = transport.responseXML;
      transport.request.options['req'].loadData(SmartXMLUtil.getChildNode(response, 'DataRecord'));
	  if(transport.request.options['req'].mode == 'edit')
      	transport.request.options['req'].formRuntime.refreshAllDataFields();
      $(transport.request.options['req'].workspaceId).fire('initialized');
    };
    this.loadRecordFailCallback = function(e){
    	alert(FormLang.loadFormMail);
    	$(e.options['req'].workspaceId).fire('failed');
    };
	this.loadWorkitem = function(instanceId){
		var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
				{
					method:'get',
					contentType : 'text/xml',
					parameters: {method:'getWorkItemData', userId : FormEnv.userId, workItemId : instanceId},
					onSuccess: this.loadWorkitemCallBack,
				    onFailure: this.loadWorkitemFailCallback,
				    onException : this.exceptionCallBack,
					req : this
				});
	};
	this.loadWorkitemCallBack = function(transport){
      var response = transport.responseXML;
      if(SmartXMLUtil.getChildNode(response, 'Result').getAttribute('status') == 'OK'){
		transport.request.options['req'].loadData(SmartXMLUtil.getChildNode(SmartXMLUtil.getChildNode(response, 'Result'), 'DataRecord'));
		
		if(transport.request.options['req'].mode == 'edit')
			transport.request.options['req'].formRuntime.refreshAllDataFields();

		$(transport.request.options['req'].workspaceId).fire('initialized');
      }else{
      	$(transport.request.options['req'].workspaceId).fire('failed');
      }
    };
    this.loadWorkitemFailCallback = function(e){
    	alert(FormLang.loadFormMail);
    	$(e.options['req'].workspaceId).fire('failed');
    };
	this._recordXml = null,
	this.loadData = function(recordXml){
		this._recordXml = recordXml;
		this.formRuntime.useMapping = false;
		this.formRuntime.loadData(this._formXml, this._recordXml);
		this.formRuntime.useMapping = true;
	};
	this.getInputData = function(){
//		if(this._recordXml == null){
//			var xmlstring = '<?xml version=\"1.0\"?><DataRecord formId=\"' + SmartXMLUtil.getChildNode(this._formXml, 'form').getAttribute('id') + '\" formVersion=\"1\" workItemId=\"\"/>';
//			var docXml = (new DOMParser()).parseFromString(xmlstring, "text/xml");;
//			this._recordXml = docXml.documentElement; 						
//		}
		//this._recordXml = this.formRuntime.getData(this._formXml, this._recordXml);

/*
 * jk yoon : this._recordXml -> null
 * table -- -row error update.. 
 * */ 
		this._recordXml = this.formRuntime.getData(this._formXml, null);
		return this._recordXml;
	};
	this.titile = null;
	this.keyword = null;
	this.desc = null;

	this.save = function(){
		var taskType = "";
		if($('taskType')) {
			taskType = $F('taskType');
		}
		parameters = {method:'saveWorkItemData', userId : FormEnv.userId, taskId : this.instanceId, taskType : taskType};
		if(taskType == "REFERENCE" || taskType == "APPROVAL" ) {
			//if($('comment')) {
			//	parameters['workItemData'] = $F('comment');
			//}
		} else {
			parameters['workItemData'] = SmartXMLUtil.getXMLString(this.getInputData());
		}

		if($('executionFrom'))
			parameters['executionFrom'] = $F('executionFrom');

		if($('executionTo'))
			parameters['executionTo'] = $F('executionTo');

		notifyMessage('notifySaveProgress');
		var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
				{
					method:'post',
					parameters: parameters,
					onSuccess: this.saveCallback,
				    onFailure: this.saveFailCallback,
				    onException : this.exceptionCallBack,
					req : this
				});
	};
	this.saveCallback = function(transport){
		var response = transport.responseXML;
		notifyMessageResult();
		if(SmartXMLUtil.getChildNode(response, 'Result').getAttribute('status') == 'OK'){
			$(transport.request.options['req'].workspaceId).fire('saved');
		} else {
			warnMessage('failed', 'warnSaveFailed');
			$(transport.request.options['req'].workspaceId).fire('failed');
		}
	};
    this.saveFailCallback = function(e){
    	notifyMessageResult();
    	warnMessage('failed', 'warnSaveFailed');
	   	$(e.options['req'].workspaceId).fire('failed');
   	};

	this.infoToTaskSave = function( _approvalsId, _approvalType, _approvalName){

		this.approvalsId   = _approvalsId;
		this.approvalType  = _approvalType;
		this.approvalName  = _approvalName;
		var dataEle = this.getInputData();
		var recordXmlStr;
		recordXmlStr = SmartXMLUtil.getXMLString(dataEle);
		var parameters = {method:'infoTaskToSend', data : recordXmlStr, userId : FormEnv.userId, approvalsId : this.approvalsId, approvalType : this.approvalType, approvalName:this.approvalName};

		if($('domainId'))
			parameters['domainId'] = $F('domainId');

		if($('recordId'))
			parameters['recordId'] = $F('recordId');

		if($('formId'))
			parameters['formId'] = $F('formId');
		if($('receiptTitle'))
			parameters['receiptTitle'] = $F('receiptTitle');		
		if($('receiptUser'))
			parameters['receiptUser'] = $F('receiptUser');
		if($('referenceUser'))
			parameters['referenceUser'] = $F('referenceUser');
		if($('priority'))
			parameters['priority'] = $F('priority');
		if($('receiptFormId'))
			parameters['receiptFormId'] = $F('receiptFormId');
		//전달자 의견, 결재내용
		if($('comment')) {
			if(oEditors.getById['comment']!=''){
				parameters['comment'] = oEditors.getById['comment'].getIR();
			}
		}
		
		var isPublics = document.getElementsByName("isPublic");
		if(isPublics.length != null) {
			for(var i=0; i<isPublics.length; i++) {
				var el = isPublics[i];
				if(el.checked == true) {
					parameters['isPublic'] = el.value;
				}
			}
		}
		if($('preservation'))
			parameters['preservation'] = $F('preservation');
		notifyMessage('notifyCompleteProgress');

		var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
				{
					method:'post',
					parameters: parameters,
					onSuccess: this.infoToTaskSaveCallback,
				    onFailure: this.infoToTaskSaveFailCallback,
				    onException : this.exceptionCallBack,
					req : this
				});
	};
	this.infoToTaskSaveCallback = function(transport){
		var response = transport.responseXML;
		notifyMessageResult();
		if(SmartXMLUtil.getChildNode(response, 'Result').getAttribute('status') == 'OK'){
			var params = $F('searchParams');
      		viewRecord($F('formId'), $F('recordId'), $F('nextPage'));
      		$('searchParams').setAttribute("value", params);
  			//send("../main/index.jsp", "recentWorksTd");
      		//location.href='../main/index.jsp';
		} else {
      		$(transport.request.options['req'].workspaceId).fire('failed');
		}
	};
    this.infoToTaskSaveFailCallback = function(e){
    	warnMessage('failed', 'warnCompleteFailed');
   	};

	this.returnTask = function(){
		var recordXmlStr;
		if(this.mode == 'edit') {
			recordXmlStr = SmartXMLUtil.getXMLString(this.getInputData());
		}

		var parameters = {method:'returnWorkItem', workItemData: recordXmlStr, userId: FormEnv.userId};

		if($('referenceComment')) {
			if(oEditors.getById['referenceComment']!='')
				parameters['referenceComment'] = oEditors.getById['referenceComment'].getIR();
		}

		if($('taskId'))
			parameters['workItemId'] = $F('taskId');
		
		if($('referenceUserId'))
			parameters['referenceUserId'] = $F('referenceUserId');

		//제목(myTask, form, process)
		if($('subject'))
			parameters['subject'] = $F('subject');

		if($('receiptTitle'))
			parameters['receiptTitle'] = $F('receiptTitle');

		if($('comment'))
			parameters['comment'] = $F('comment');
		
		var workSaveSort = false; 
		if($('aprDetailTable').style.display == 'none'){
			workSaveSort = true;
		}
		
		//전자결재, 업무전달 중요도(myTask, form, process)
		if($('priority'))
			parameters['priority'] = $F('priority');
		if(workSaveSort){
			if($('priorityT'))
				parameters['priority'] = $F('priorityT');
		}
		//수신자 업무전달(myTask, form)
		if($('receiptUser'))
			parameters['receiptUser'] = $F('receiptUser'); 
		
		//수신자업무 업무전달(myTask, form)
		if($('receiptFormId'))
			parameters['receiptFormId'] = $F('receiptFormId'); 

		//전자결재, 업무전달 참조자
		if($('referenceUser'))
			parameters['referenceUser'] = $F('referenceUser');
		
		// 업무참조 제목.
		if($('referenceTitle'))
			parameters['receiptTitle'] = $F('referenceTitle');
		
		//alert(parameters.referenceUser+"///////");

		//전달자 의견, 결재내용
		if($('comment')) {
			if(oEditors.getById['comment']!='')
				parameters['comment'] = oEditors.getById['comment'].getIR();
		}
		
		//보존 년한
		if($('preservation'))
			parameters['preservation'] = $F('preservation');

		//처리기한
		if($('hopeEndDate'))
			parameters['hopeEndDate'] = $F('hopeEndDate');
		if($('hopeEndTime'))
			parameters['hopeEndTime'] = $F('hopeEndTime');
		
		//공개여부
		var isPublics = document.getElementsByName("isPublic");
		if(isPublics.length != null) {
			for(var i=0; i<isPublics.length; i++) {
				var el = isPublics[i];
				if(el.checked == true) {
					parameters['isPublic'] = el.value;
					break;
				}
			}
		}
		//jk yoon 추가
		if(workSaveSort){
		//공개여부
			var isPublicsT = document.getElementsByName("isPublicT");
			if(isPublicsT.length != null) {
				for(var i=0; i<isPublicsT.length; i++) {
					var els = isPublicsT[i];
					if(els.checked == true) {
						parameters['isPublic'] = els.value;
						break;
					}
				}
			}
		}
		
		if($('projectName')){
			if($F('projectName')!=''){
				parameters['projectName'] = $F('projectName');
			}
		}
		// 프로젝트명
		if(workSaveSort){
			if($('projectNameT')){
				if($F('projectNameT')!=''){
					parameters['projectName'] = $F('projectNameT');
				}
			}
		}
		
		if($('workContents')){
			if($F('workContents')!=''){
				parameters['workContents'] = $F('workContents');
			}
		}
		if(workSaveSort){
			// 설명
			if($('workContentsT')){
				if($F('workContentsT')!=''){
					parameters['workContents'] = $F('workContentsT');
				}
			}
		}
		
		// 시작시간/ 완료시간 설정.
		if($('startTime'))
			parameters['startTime'] = $F('startTime');
		
		var endTime = new Date();
		parameters['endTime'] = endTime.getTime();

		notifyMessage('HAS_BEEN_REJECTED');
		var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
			{
				method:'post',
				parameters: parameters,
				onSuccess: this.returnTaskCallback,
			    onFailure: this.returnTaskFailCallback,
			    onException : this.exceptionCallBack,
				req : this
			});
	};
	this.returnTaskCallback = function(transport){
		var response = transport.responseXML;
		var result = SmartXMLUtil.getChildNode(response, 'Result');
		notifyMessageResult();
		
		if(result.getAttribute('status') == 'OK'){
			clickListMyTask();
		} else {
			warnMessage('failed', 'warnReturnFailed');
		}
	};
    this.returnTaskFailCallback = function(e){
    	warnMessage('failed','warnReturnFailed');
	   	$(e.options['req'].workspaceId).fire('failed');
   	};

//전자결재 시 반려된 기안 취소
   	this.cancelTask = function(){
		var recordXmlStr;
		if(this.mode == 'edit') {
			recordXmlStr = SmartXMLUtil.getXMLString(this.getInputData());
		}

		var parameters = {method:'cancelWorkItem', workItemData: recordXmlStr, userId: FormEnv.userId};

		if($('referenceComment')) {
			if($F('referenceComment')!='')
				parameters['referenceComment'] = oEditors.getById['referenceComment'].getIR();
		}
		
		if($('taskId'))
			parameters['workItemId'] = $F('taskId');
		
		if($('referenceUserId'))
			parameters['referenceUserId'] = $F('referenceUserId');

		//제목(myTask, form, process)
		if($('subject'))
			parameters['subject'] = $F('subject');

		if($('receiptTitle'))
			parameters['receiptTitle'] = $F('receiptTitle');

		if($('comment'))
			parameters['comment'] = $F('comment');
		
		var workSaveSort = false; 
		if($('aprDetailTable').style.display == 'none'){
			workSaveSort = true;
		}
		
		//전자결재, 업무전달 중요도(myTask, form, process)
		if($('priority'))
			parameters['priority'] = $F('priority');
		if(workSaveSort){
			if($('priorityT'))
				parameters['priority'] = $F('priorityT');
		}
		//수신자 업무전달(myTask, form)
		if($('receiptUser'))
			parameters['receiptUser'] = $F('receiptUser'); 
		
		//수신자업무 업무전달(myTask, form)
		if($('receiptFormId'))
			parameters['receiptFormId'] = $F('receiptFormId'); 

		//전자결재, 업무전달 참조자
		if($('referenceUser'))
			parameters['referenceUser'] = $F('referenceUser');
		
		// 업무참조 제목.
		if($('referenceTitle'))
			parameters['receiptTitle'] = $F('referenceTitle');
		
		//alert(parameters.referenceUser+"///////");

		//전달자 의견, 결재내용
		if($('comment')) {
			if(oEditors.getById['comment']!='')
				parameters['comment'] = oEditors.getById['comment'].getIR();
		}
		
		//보존 년한
		if($('preservation'))
			parameters['preservation'] = $F('preservation');

		//처리기한
		if($('hopeEndDate'))
			parameters['hopeEndDate'] = $F('hopeEndDate');
		if($('hopeEndTime'))
			parameters['hopeEndTime'] = $F('hopeEndTime');
		
		//공개여부
		var isPublics = document.getElementsByName("isPublic");
		if(isPublics.length != null) {
			for(var i=0; i<isPublics.length; i++) {
				var el = isPublics[i];
				if(el.checked == true) {
					parameters['isPublic'] = el.value;
					break;
				}
			}
		}
		//jk yoon 추가
		if(workSaveSort){
		//공개여부
			var isPublicsT = document.getElementsByName("isPublicT");
			if(isPublicsT.length != null) {
				for(var i=0; i<isPublicsT.length; i++) {
					var els = isPublicsT[i];
					if(els.checked == true) {
						parameters['isPublic'] = els.value;
						break;
					}
				}
			}
		}
		
		if($('projectName')){
			if($F('projectName')!=''){
				parameters['projectName'] = $F('projectName');
			}
		}
		// 프로젝트명
		if(workSaveSort){
			if($('projectNameT')){
				if($F('projectNameT')!=''){
					parameters['projectName'] = $F('projectNameT');
				}
			}
		}
		
		if($('workContents')){
			if($F('workContents')!=''){
				parameters['workContents'] = $F('workContents');
			}
		}
		if(workSaveSort){
			// 설명
			if($('workContentsT')){
				if($F('workContentsT')!=''){
					parameters['workContents'] = $F('workContentsT');
				}
			}
		}
		
		// 시작시간/ 완료시간 설정.
		if($('startTime'))
			parameters['startTime'] = $F('startTime');
		
		var endTime = new Date();
		parameters['endTime'] = endTime.getTime();

		notifyMessage('notifyCancelTaskProgress');
		var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
			{
				method:'post',
				parameters: parameters,
				onSuccess: this.cancelTaskCallback,
			    onFailure: this.cancelTaskFailCallback,
			    onException : this.exceptionCallBack,
				req : this
			});
	};
	this.cancelTaskCallback = function(transport){
		var response = transport.responseXML;
		var result = SmartXMLUtil.getChildNode(response, 'Result');
		notifyMessageResult();
		
		if(result.getAttribute('status') == 'OK'){
			clickListMyTask();
		} else {
			warnMessage('failed', 'warnCancelTaskFailed');
		}
	};
    this.returnTaskFailCallback = function(e){
    	warnMessage('failed','warnCancelTaskFailed');
	   	$(e.options['req'].workspaceId).fire('failed');
   	};

	this.complete = function(){
		this.referenceUserId = "";
		this.comment = "";
		this.taskId = "";
		this.taskType = "";
		this.executionFrom = "";
		this.executionTo = "";
		this.domainId = "";
		this.tag = "";
		this.recordId = "";
		//결재라인 필요한 승인, 검토, 대표이사 지역변수
		this.approvalsId = "";
		this.approvalType = "";
		this.approvalName = "";

		// 요기부터 추가
		this.demo = $F('demo');
		//alert('complete::'+demo);
		this.procInstId = "";
		
		this.procInstId = $F('procInstId');
		this.formType = $F('taskType');
		
		//전자결재,업무지시 참조자
		if($('referenceUserId'))
			this.referenceUserId = $F('referenceUserId');
		//업무 종류
		if($('taskType'))
			this.taskType = $F('taskType');
		
		//태그
		if($('tag'))
			this.tag = $F('tag');
		//업무 시작일 : 간트
		if($('executionFrom'))
			this.executionFrom = $F('executionFrom');
		//업무 종료일 : 간트
		if($('executionTo'))
			this.executionTo = $F('executionTo');
		// 업무 도메인 아이디
		if($('domainId'))
			this.domainId = $F('domainId');
		//정보관리업무
		if($('recordId'))
			this.recordId = $F('recordId');
		//참조 결제 업무의 태스크 아이디
		if($('taskId'))
			this.taskId = $F('taskId');

		if(document.getElementsByName("approvalsId") != null) {
			for ( var i = 0 ; i < document.getElementsByName("approvalsId").length; i++ ) {
				if(document.getElementsByName("approvalsId")[i].value != null && document.getElementsByName("approvalsId")[i].value != "") {
					this.approvalsId = this.approvalsId + document.getElementsByName("approvalsId")[i].value + ";";
				}
			}
		}

		if(document.getElementsByName("approvalType") != null) {
			for ( var i = 0 ; i < document.getElementsByName("approvalType").length; i++ ) {
				if(document.getElementsByName("approvalType")[i].value != null && document.getElementsByName("approvalType")[i].value != "") {
					this.approvalType = this.approvalType + document.getElementsByName("approvalType")[i].value + ";";
				}
			}
		}

				if(document.getElementsByName("approvalName") != null) {
			for ( var i = 0 ; i < document.getElementsByName("approvalName").length; i++ ) {
				if(document.getElementsByName("approvalName")[i].value != null && document.getElementsByName("approvalName")[i].value != "") {
					this.approvalName = this.approvalName + document.getElementsByName("approvalName")[i].value + ";";
				}
			}
		}

		this.completeNormal();
	};

	this.completeNormal = function(){	
		notifyMessage('notifyCompleteProgress');
		var aprLineId = "";
		if($('aprLineId'))
			aprLineId = $F('aprLineId');
		//참조 결제선
		if(this.taskType == "REFERENCE" || (this.taskType == "APPROVAL" && aprLineId != "") ) {
			//alert("this.type1-->"+this.type);
			parameters = {method:'executeWorkItem', userId : FormEnv.userId, workItemId : this.taskId, comment:this.comment, tag: this.tag};
			//참조의견, 결재의견
			if($('referenceComment')) {
				if(oEditors.getById['referenceComment']!='')
					parameters['referenceComment'] = oEditors.getById['referenceComment'].getIR();
			}
			//alert(parameters.referenceComment);
			var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
					{
						method:'post',
						parameters: parameters,
						onSuccess: this.completeCallback,
					    onFailure: this.completeFailCallback,
					    onException : this.exceptionCallBack,
						req : this
					});
		} else {
			var validResult = this.formRuntime.validate();
			if(!(validResult['result'])){
				
				var msg = FormLang.field + '(';
				for (var i = 0 ; i < validResult['unvalidField'].length ; i++){
					if(i != 0){
						msg += ', ';
					}
					msg += validResult['unvalidField'][i];
				}
				msg += (')' + FormLang.fillVar);
				notifyMessageResult();
				setTimeout('warnMessage("Youdidnotentertherequireditems", "'+msg+'")',1000);
			} else {
				var dataEle = this.getInputData();
				var recordXmlStr;
				recordXmlStr = SmartXMLUtil.getXMLString(dataEle);
				var parameters;
				//if(this.type == 1 && $F('returnYn') == 'Y')
				//alert("this.type2-->"+this.type);
				if(this.type == 1) {
					parameters = {method:'executeWorkItem', userId : FormEnv.userId, workItemData : recordXmlStr, workItemId : this.instanceId, executionFrom : this.executionFrom, executionTo : this.executionTo, tag : this.tag, approvalsId:this.approvalsId, approvalType:this.approvalType, approvalName:this.approvalName};
				} else if(this.type == 2 || this.type == 3) {
					parameters = {method:'createSingleFormRecord', userId : FormEnv.userId, data : recordXmlStr, domainId : this.domainId, tag : this.tag, recordId : this.recordId, approvalsId:this.approvalsId, approvalType:this.approvalType, approvalName:this.approvalName};
				} else if(this.type == 4){
					parameters = {method:'executeStartWorkItem', userId : FormEnv.userId,
									formId : this.formId, processId : this.processId, version : this.formVer,
									workItemData : recordXmlStr, hopeEndTime : this.hopeEndTime, name: this.name,
									pertType : this.pertType ,ref : this.ref,planFrom : this.planFrom,planTo : this.planTo,
									executionFrom : this.executionFrom, executionTo : this.executionTo, executionDuration : this.executionDuration, assignee : this.assignee,
									approvalsId:this.approvalsId, approvalType:this.approvalType, approvalName:this.approvalName, 
									hopeEndDate:this.hopeEndDate, requiredDay:this.requiredDay, requiredTime:this.requiredTime, requiredMinute:this.requiredMinute,
									packageId:this.packageId, processId:this.processId};
				}

				//제목(myTask, form, process)
				if($('subject'))
					parameters['subject'] = $F('subject');

				if($('receiptTitle'))
					parameters['receiptTitle'] = $F('receiptTitle');
				
				var workSaveSort = false; 
				if($('aprDetailTable').style.display == 'none'){
					workSaveSort = true;
				}
				
				//전자결재, 업무전달 중요도(myTask, form, process)
				if($('priority'))
					parameters['priority'] = $F('priority');
				if(workSaveSort){
					if($('priorityT'))
						parameters['priority'] = $F('priorityT');
				}
				//수신자 업무전달(myTask, form)
				if($('receiptUser'))
					parameters['receiptUser'] = $F('receiptUser'); 
				
				//수신자업무 업무전달(myTask, form)
				if($('receiptFormId'))
					parameters['receiptFormId'] = $F('receiptFormId'); 

				//전자결재, 업무전달 참조자
				if($('referenceUser'))
					parameters['referenceUser'] = $F('referenceUser');
				
				// 업무참조 제목.
				if($('referenceTitle'))
					parameters['receiptTitle'] = $F('referenceTitle');
				
				//alert(parameters.referenceUser+"///////");

				//전달자 의견, 결재내용
				if($('comment')) {
					if(oEditors.getById['comment']!='')
						parameters['comment'] = oEditors.getById['comment'].getIR();
				}
				
				//보존 년한
				if($('preservation'))
					parameters['preservation'] = $F('preservation');

				//처리기한
				if($('hopeEndDate'))
					parameters['hopeEndDate'] = $F('hopeEndDate');
				if($('hopeEndTime'))
					parameters['hopeEndTime'] = $F('hopeEndTime');
				
				//공개여부
				var isPublics = document.getElementsByName("isPublic");
				if(isPublics.length != null) {
					for(var i=0; i<isPublics.length; i++) {
						var el = isPublics[i];
						if(el.checked == true) {
							parameters['isPublic'] = el.value;
							break;
						}
					}
				}
				//jk yoon 추가
				if(workSaveSort){
				//공개여부
					var isPublicsT = document.getElementsByName("isPublicT");
					if(isPublicsT.length != null) {
						for(var i=0; i<isPublicsT.length; i++) {
							var els = isPublicsT[i];
							if(els.checked == true) {
								parameters['isPublic'] = els.value;
								break;
							}
						}
					}
				}
//alert(parameters.isPublic+'||||||');
				
				if($('projectName')){
					if($F('projectName')!=''){
						parameters['projectName'] = $F('projectName');
					}
				}
				// 프로젝트명
				if(workSaveSort){
					if($('projectNameT')){
						if($F('projectNameT')!=''){
							parameters['projectName'] = $F('projectNameT');
						}
					}
				}
				
				if($('workContents')){
					if($F('workContents')!=''){
						parameters['workContents'] = $F('workContents');
					}
				}
				if(workSaveSort){
					// 설명
					if($('workContentsT')){
						if($F('workContentsT')!=''){
							parameters['workContents'] = $F('workContentsT');
						}
					}
				}
				
				// 시작시간/ 완료시간 설정.
				if($('startTime'))
					parameters['startTime'] = $F('startTime');
				
				var endTime = new Date();
				parameters['endTime'] = endTime.getTime();
				
				var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
						{
							method:'post',
							parameters: parameters,
							onSuccess: this.completeCallback,
						    onFailure: this.completeFailCallback,
						    onException : this.exceptionCallBack,
							req : this
						});
			}
		}
	};
	this.completeCallback = function(transport){
//alert('completeCallback');		
		var response = transport.responseXML;
		var result = SmartXMLUtil.getChildNode(response, 'Result');
		notifyMessageResult();
		if(result.getAttribute('status') == 'OK'){
//alert('status ok');			
			//location.href='../main/index.jsp';
			//send("../main/index.jsp","recentWorksTd");
			
			send("../main/tag.jsp","tagTd");

	       	var params = "";
	    	var nextPage = "";
			//검색파라미터
			if($('searchParams'))
				params = $F('searchParams');
			//목록으로 갈 페이지
			if($('nextPage'))
				nextPage = $F('nextPage');
			
//alert(nextPage);			
//alert(transport.request.options['req'].type);			
			if( transport.request.options['req'].type == 1) {
				updateTaskCount();
	       		clickListMyTask(this.taskId, this.formId, this.procInstId, this.formType, this.demo);
	      	} else if(transport.request.options['req'].type == 2) {
	      		var formWork = new FormWork('workspace');
	    		$('workspace')['formWork'] = formWork;
	      		formWork.initFormRuntime(this.userId, '../', $F('formId'), '1', '', transport.request.options['req'].recordId, '2', 'view');
			} else if(transport.request.options['req'].type == 3) {
	      		//연결업무  : dialogPop, 참조업무 팝업창 : referencePop
	      		if(nextPage == "popUp") {
	      			updateRecordList();// 저장완료후 목록 갱신
	      		} else if(nextPage == "dialogPop") {
	      			//To Do
	      		} else if(nextPage == 'newRecord') { 
	      			parent.alertMessage('complete', 'Workregistrationhasbeencompleted', parent.trueReleaseModalDialog);
	      		} else {
	      			updateTaskCount();
	      			//alert($F('formId'));
	      			//viewRecord($F('formId'), transport.request.options['req'].recordId, $F('nextPage'));
	      			//send("../main/index.jsp","recentWorksTd");
		      		$('searchParams').setAttribute("value", params);
		      		clickListForm();
		      		//clickListForm($F('nextPage'));
		      		//location.href='../main/index.jsp';
	      		}
	      	} else if(transport.request.options['req'].type == 4) {
	      		updateTaskCount();
	      		var workitem = SmartXMLUtil.getChildNode(result, 'workitem');
	   			params = params + "&procInstId="+workitem.getAttribute('processInstId');
	   			send("../proc/procView.jsp", "mainTd", params);
	      	} else if(transport.request.options['req'].type == 5) {
	      		updateTaskCount();
				clickListMyTask();
	      	}
	    } else {
	    	var failContent = SmartXMLUtil.getNodeData(SmartXMLUtil.getChildNode(result, 'eString'));
	    	if(failContent == null || failContent == "") {
	    		failContent = "warnCompleteFailed";
	    	}
	    	//라이센스관련
	    	if(failContent == "com.maninsoft.license.exception.LcsException") {
	    		failContent = "사용계약이 만료되었습니다.";
	    	}
	    	warnMessage('failed', failContent);
	    }
    };
    this.completeFailCallback = function(e){
    	notifyMessageResult();
    	warnMessage('failed', 'warnCompleteFailed');
	   	$(e.options['req'].workspaceId).fire('failed');
   	};

	this.cancel = function(){
		$(this.workspaceId).fire('canceled');
	};
	this.remove = function(){
		if(this.type == 2){
			var parameters = {method:'removeSingleFormRecord', userId : FormEnv.userId, recordId : this.instanceId, formId : this.formId};
			if($('domainId')) {
				parameters['domainId'] = $('domainId').getValue();
			}

			var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
				{
					method:'post',
					parameters: parameters,
					onSuccess: this.removeCallback,
				    onFailure: this.removeFailCallback,
				    onException : this.exceptionCallBack,
					req : this
				});
		}else{
			$(this.workspaceId).fire('failed');
		}
	};
	this.removeCallback = function(transport){
      var response = transport.responseXML;
      var result = SmartXMLUtil.getChildNode(response, 'Result');
      if(result.getAttribute('status') == 'OK'){
       	if (transport.request.options['req'].type == 2) {
       		var nextPage = "";
       		if($('nextPage')) {
       			nextPage = $F('nextPage');
       		}
       		var params = "";
       		if($('searchParams')) {
       			params = $F('searchParams');
       		}
       		//listClick(nextPage, params, "mainTd");
       		clickListForm(nextPage);
      	}
      	//send("../main/index.jsp", "recentWorksTd");
      	location.href='../main/index.jsp';
      } else{
    	  warnMessage('failed', 'warnDeleteFailed');
      	$(transport.request.options['req'].worksapceId).fire('failed');
      }
    };
    this.removeFailCallback = function(e){
    	 warnMessage('failed', 'warnDeleteFailed');
	   	$(e.options['req'].worksapceId).fire('failed');
   	};
   	this.screenblock_id = this.worksapceId + '_screenBlock';
	this.addBlockScreen = function(){
		var workspace = $(this.workspaceId);

		var alphaOpt;
		if(Prototype.Browser.IE){
			alphaOpt = "FILTER: alpha(opacity: 50);";
		}else{
			alphaOpt = "opacity: 0.5;";
		}
		var blockScreenStyle = "position: absolute; background-color: black; " + alphaOpt + " z-index: 700; top: 0px; left: 0px; display: block; width: " + Element.getWidth(workspace) + "px; height: " + Element.getHeight(workspace) + "px;";
		var blockScreenEle = new Element("div", {id : this.screenblock_id, style : blockScreenStyle});

		workspace.appendChild(blockScreenEle);
	};
	this.removeBlockScreen = function(){
		$(this.workspaceId).removeChild($(this.screenblock_id));
	};
	this.browserWidth = function() {
		return window.innerWidth || document.body.parentNode.clientWidth;
	};
	this.browserHeight = function() {
		return document.body.parentNode.clientHeight;
	};
	this.completePrcInit = function(_hopeEndTime, _name, _pertType, _ref, _planFrom , _planTo, _executionFrom , _executionTo, _executionDuration, _assignee, _hopeEndDate, _requiredDay, _requiredTime, _requiredMinute, _packageId, _processId){
		this.hopeEndTime = _hopeEndTime;
 		this.name = _name;
 		this.pertType = _pertType;
 		this.ref = _ref;
 		this.planFrom = _planFrom ;
 		this.planTo = _planTo;
 		this.executionFrom = _executionFrom;
 		this.executionTo = _executionTo;
 		this.executionDuration = _executionDuration;
 		this.assignee = _assignee;
 		this.approvalsId = "";
		this.approvalType = "";
		this.approvalName = "";
		
		//jk yoon 추가
		this.hopeEndDate = _hopeEndDate;
		this.requiredDay = _requiredDay;
		this.requiredTime = _requiredTime;
		this.requiredMinute = _requiredMinute;
		this.packageId = _packageId; 
		this.processId = _processId;
		
		
		if($('ApprovalLineTr').visible()) {
			if(document.getElementsByName("approvalsId") != null) {
				for ( var i = 0 ; i < document.getElementsByName("approvalsId").length; i++ ) {
					if(document.getElementsByName("approvalsId")[i].value != null && document.getElementsByName("approvalsId")[i].value != "") {
						this.approvalsId = this.approvalsId + document.getElementsByName("approvalsId")[i].value + ";";
					}
				}
			}
	
			if(document.getElementsByName("approvalType") != null) {
				for ( var i = 0 ; i < document.getElementsByName("approvalType").length; i++ ) {
					if(document.getElementsByName("approvalType")[i].value != null && document.getElementsByName("approvalType")[i].value != "") {
						this.approvalType = this.approvalType + document.getElementsByName("approvalType")[i].value + ";";
					}
				}
			}
	
			if(document.getElementsByName("approvalName") != null) {
				for ( var i = 0 ; i < document.getElementsByName("approvalName").length; i++ ) {
					if(document.getElementsByName("approvalName")[i].value != null && document.getElementsByName("approvalName")[i].value != "") {
						this.approvalName = this.approvalName + document.getElementsByName("approvalName")[i].value + ";";
					}
				}
			}
		}
		this.completeNormal();
	};

	this.delegateTask = function(){
		var parameters = {method:'delegateTask', userId : FormEnv.userId};
		if($('delegateUserId'))
			parameters['delegateUserId'] = $F('delegateUserId');

		if($('taskId'))
			parameters['taskId'] = $F('taskId');

		if(this.type == 1){
			var req = new Ajax.Request(FormEnv.serviceUrl + '/services/runtime/executionService.jsp',
				{
					method:'post',
					parameters: parameters,
					onSuccess: this.delegateTaskCallback,
				    onFailure: this.delegateTaskFailCallback,
				    onException : this.exceptionCallBack,
					req : this
				});
		} else {
			alert(transport.request.options['req'].failedMsg);
		}
	};
	this.delegateTaskCallback = function(transport){
		var response = transport.responseXML;
		var result = SmartXMLUtil.getChildNode(response, 'Result');
		notifyMessageResult();

		if(result.getAttribute('status') == 'OK'){
			clickListMyTask();
		} else {
			warnMessage('failed', 'warnDelegateFailed');
		}
	};
    this.delegateTaskFailCallback = function(e){
    	warnMessage('failed', 'warnDeleteFailed');
	   	$(e.options['req'].workspaceId).fire('failed');
   	};
};
