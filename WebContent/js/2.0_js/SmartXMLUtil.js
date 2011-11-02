/*  SmartXMLUtil JavaScript, version 0.0.1
 *  (c) 2006-2008 ManInSoft inc.
 *
 *  SmartXMLUtil
 *
 *--------------------------------------------------------------------------*/
 
var SmartXMLUtil = {
	getNodeData: function(xml){
		var value = "";
		if(xml != null && xml.firstChild != null){
			value = xml.firstChild.nodeValue;
		}
		
		return value;
	},
	getChildNode: function(xml, name) {
		if (!(xml.hasChildNodes))
			return null;
			
		for (var x=0; x<xml.childNodes.length; x++) {
			if(xml.childNodes[x].nodeName == name)
				return xml.childNodes[x];
		}
		
		return null;
	},
	getChildNodes: function(xml, childName){
		var childNodes  = [];
		
		if(xml == null || xml.childNodes == undefined || xml.childNodes.length == 0)
			return childNodes;
			
		for(var x = 0 ; x < xml.childNodes.length ; x++){
			if(xml.childNodes[x].nodeName == childName)
				childNodes.push(xml.childNodes[x]);
		}
		
		return childNodes;
	},	
	getChildNodesByAttrVar: function(xml, childName, attrName, attrVar){
		var childNodes  = SmartXMLUtil.getChildNodes(xml, childName);
		
		if(childNodes == null || childNodes.length == 0)
			return null;
		for(var i = 0 ; i < childNodes.length ; i++){
			if(childNodes[i].getAttribute(attrName) == attrVar){
				return childNodes[i];
			}
		}
		return null;
	},
	getChildNodesByAttrVar2: function(xml, childName, attrName, attrVar){
		var childNodes  = SmartXMLUtil.getChildNodes(xml, childName);
		if(childNodes == null || childNodes.length == 0)
			return null;
		
		var nodeArray=[];
		var idx = 0;
		for(var i = 0 ; i < childNodes.length ; i++){
			if(childNodes[i].getAttribute(attrName) == attrVar){
				nodeArray[idx++] = childNodes[i];
			}
		}
		if(nodeArray.length == 0) return null;
		else return nodeArray;
	},
	getXMLString: function(docXml){
		var recordXmlStr;
		if(typeof XMLSerializer != "undefined"){
			recordXmlStr = (new XMLSerializer()).serializeToString(docXml);
		}else if(docXml.xml){
			recordXmlStr = docXml.xml;
		}else{
			alert("not support xml serializer in this browser");
		}
		return recordXmlStr;
	},
	getXML : function(xmlStr){
		var xmlstring = '<?xml version=\"1.0\"?>' + xmlStr;
		var docXml = (new DOMParser()).parseFromString(xmlStr, "text/xml");
		return docXml.documentElement;
	}
};