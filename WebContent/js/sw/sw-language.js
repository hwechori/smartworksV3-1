language = {
		bundle : {},
		message : function(key){
			console.log(key, language.bundle[currentUser.locale][key]);
			return language.bundle[currentUser.locale][key];
		}
};