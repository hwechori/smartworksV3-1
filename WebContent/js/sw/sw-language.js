language = {
		locale : 'ko',
		bundle : {},
		setLocale : function(locale){
			language.locale = locale;
		},
		setBundle : function(locale, bundle){
			language.bundle.push({locale: bundle});
		},
		message : function(key){
			console.log(key, language.bundle[language.locale][key]);
			return language.bundle[language.locale][key];
		}
};