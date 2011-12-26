language = {
		bundle : {},
		message : function(key){
			return language.bundle[currentUser.locale][key];
		}
};