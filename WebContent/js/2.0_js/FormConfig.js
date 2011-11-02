var FormConfig = {
	service_url: Mis.getPath() + "/services/runtime/executionService.jsp",
	
	methods_getForm_name: "getForm",
	methods_getForm_service_url: null,
	methods_getForm_parameters_method_name: "method",
	methods_getForm_parameters_user_name: "userId",
	methods_getForm_parameters_id_name: "formId",
	
	methods_getRecord_name: "getSingleFormRecord",
	methods_getRecord_service_url: null,
	methods_getRecord_parameters_method_name: "method",
	methods_getRecord_parameters_user_name: "userId",
	methods_getRecord_parameters_formId_name: "formId",
	methods_getRecord_parameters_id_name: "recordId"
};