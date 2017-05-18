//print("Welcome to java world");
// Changes XML to JSON
// fixed some bugs from http://davidwalsh.name/convert-xml-json
// October 9, 2012
// Brian Hurlow
function xmlToJson(xml) {

	// Create the return object
	var obj = {};
	// print("ABC")

	// console.log(xml.nodeType, xml.nodeName );

	if (xml.nodeType == 1) { // element
		// do attributes
		if (xml.attributes.length > 0) {
			obj["@attributes"] = {};
			for (var j = 0; j < xml.attributes.length; j++) {
				var attribute = xml.attributes.item(j);
				obj["@attributes"][attribute.nodeName] = attribute.nodeValue;
			}
		}
	} else if (xml.nodeType == 4) { // cdata section
		obj = xml.nodeValue
	}

	// do children
	if (xml.hasChildNodes()) {
		for (var i = 0; i < xml.childNodes.length; i++) {
			var item = xml.childNodes.item(i);
			var nodeName = item.nodeName;
			if (typeof (obj[nodeName]) == "undefined") {
				obj[nodeName] = xmlToJson(item);
			} else {
				if (typeof (obj[nodeName].length) == "undefined") {
					var old = obj[nodeName];
					obj[nodeName] = [];
					obj[nodeName].push(old);
				}
				if (typeof (obj[nodeName]) === 'object') {
					obj[nodeName].push(xmlToJson(item));
				}
			}
		}
	}
	// print("ABC")
	return obj;
};

function readTextFile(file) {
//	var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
//	var rawFile = new XMLHttpRequest();
	var rawFile = new XMLHttpRequest();
	rawFile.open("GET", file, false);
	rawFile.send(null);
	if (xmlhttp.status === 200) {
		eval(rawFile.responseText);

	}
	/*
	 * rawFile.onreadystatechange = function() { if (rawFile.readyState === 4) {
	 * if (rawFile.status === 200 || rawFile.status == 0) { var allText =
	 * rawFile.responseText; alert(allText); } } }
	 */

}
 print("ABC");
readTextFile("file:///F:/Data/Suprith/VASVAL/sample.xml");
xmlToJson(xml);
