
// File Name 	: sw-language.js
// Description 	: SmartWork 의 다국어 지원을 위해, 현재사용자의 locale 정보로 사용자 언어를 제공한다.
// Author 		: Y.S Jung
// Created Date : 2011.11.


smartMessage = {
		// locale 별로 언어 번들을 저장한다..
		bundle : {},
		// key 로 메시지 함수을 호출하면 현재사용자의  locale 로 해당언어의 메시지를 제공한다..
		get : function(key){
			return smartMessage.bundle[currentUser.locale][key];
		}
};