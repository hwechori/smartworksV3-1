/**
SmartWorks Static Utilities ..
**/
SmartWorks = function() {
    var Version = '1.0.0';
		
	this.version = function() {
		return Version;
	};
	
    return this;
};

SmartWorks.require = function(jsfile_url) {
	
};

SmartWorks.extend = function(defaults, overide) {
	for(var k in overide) {
		defaults[k] = overide[k];
	};
};

SmartWorks.generateFormFieldId = function(workspaceId, id) {
	return workspaceId + '_formField_' + id;
};