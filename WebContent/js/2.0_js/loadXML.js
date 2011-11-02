/**
 * javascript xml & xsl load
 */
//function loadXMLDoc(xmlPath) {
//	var xmlDoc;
//
//	if (window.ActiveXObject) { // code for IE
//		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
//	} else if (document.implementation && document.implementation.createDocument) { // code for Mozilla, Firefox, Opera, etc.
//		xmlDoc = document.implementation.createDocument("","",null);
//    } else {
//    	alert('Your browser cannot handle this script');
//    }
//
//    xmlDoc.async = false;
//    xmlDoc.load(xmlPath);
//    return(xmlDoc);
//}
/**
 * javascript xml & xsl load
 */
function loadXMLDoc(xmlPath) {
	var xmlDoc;
	try {					// code for IE
		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	} catch(e) {
		try {				// code for Firefox, Mozilla, Opera, etc.
			xmlDoc = document.implementation.createDocument("", "", null);
		} catch(e) { 
			alert(e.message); 
		}
	}
	try {
		xmlDoc.async=false;
		xmlDoc.load(xmlPath);
		return(xmlDoc);
	} catch(e) {
		try { // Etc (Apple Safari, Google Crome)
			var xmlhttp = new window.XMLHttpRequest();
			xmlhttp.open("GET", xmlPath, false);
			xmlhttp.send(null);
			xmlDoc = xmlhttp.responseXML;
			return(xmlDoc);
		} catch(e) {
			alert(e.message);
		}
	}
	return null;
}


/**
 * close xmlObj
 */
function closeXMLDoc(xmlObj) {
	xmlObj = null;
}

/**
 * javascript xml transform
 * xml : xml object, xsl : xsl object, divName : display object name
 */
function displayResult(xml, xsl, divName) {
	if (window.ActiveXObject) { //IE
		var strHtml = xml.transformNode(xsl);
		document.getElementById(divName).innerHTML = strHtml;
	} else if (document.implementation && document.implementation.createDocument) { //Mozilla, Firefox, Opera, etc.
		var xsltProcessor = new XSLTProcessor();
		xsltProcessor.importStylesheet(xsl);
		var resultDocument = xsltProcessor.transformToFragment(xml,document);
		document.getElementById(divName).appendChild(resultDocument);
	}
}

if (document.implementation.hasFeature("XPath", "3.0")) {
	if (typeof XMLDocument == "undefined"){ XMLDocument = Document; }
		XMLDocument.prototype.selectNodes = function(cXPathString, xNode) {
			if (!xNode) { xNode = this; } 
			var oNSResolver = this.createNSResolver(this.documentElement)
			var aItems = this.evaluate(cXPathString, xNode, oNSResolver, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);
			var aResult = [];
			for (var i = 0; i < aItems.snapshotLength; i++) {
				aResult[i] =  aItems.snapshotItem(i); 
			}
			return aResult;
	};
	XMLDocument.prototype.selectSingleNode = function(cXPathString, xNode) {
		if (!xNode) { xNode = this; } 
		var xItems = this.selectNodes(cXPathString, xNode);
		if (xItems.length > 0) { return xItems[0]; }
		else{ return null; }
	};
	Element.prototype.selectNodes = function(cXPathString) {
		if (this.ownerDocument.selectNodes) { return this.ownerDocument.selectNodes(cXPathString, this); }
		else{throw "For XML Elements Only";}
	};
	Element.prototype.selectSingleNode = function(cXPathString){	
		if (this.ownerDocument.selectSingleNode) { return this.ownerDocument.selectSingleNode(cXPathString, this); }
		else{throw "For XML Elements Only";}
	};
}