language = {
		locale : 'ko',
		bundle : {},
		setLocale : function(locale){
			language.locale = locale;
		},
		message : function(key){
			console.log(key, language.bundle[language.locale][key]);
			return language.bundle[language.locale][key];
		}
};