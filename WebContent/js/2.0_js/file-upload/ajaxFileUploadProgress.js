//Create my namespace
var davidjc = {};

davidjc.AjaxFileUpload = function(dobefore, doafter, id) {
	
	if(dobefore && typeof(dobefore) == 'function') {
		dobefore();
	}
				
	//Global variable needed to monitor upload progress
	var uploadStartTime = new Date().getTime() / 1000; //seconds start time        //time it started
        var totalFileSize = 0;      //size of file
	var updateRate = 1000;
	var lastProgressUpdate = uploadStartTime;   //last time the data changed
	var lastUploadedSize = -1;                   //current upload size 
	var barwidth = 300; //size of the progress bar
	var fileName;
	var initialisingTxt = "Initialising, please wait.....";
	var timeoutId;
	
	
	//GUI Elements
	/*var fileNameTxt = jQuery("#uploadFilename");
	var progressBarDiv = jQuery("#progress-bar");
	var progressBarTextDiv = jQuery("#progress-text");
	var progressAreaDiv = jQuery("#fileuploadProgress");
	var progressBarGraphic = jQuery("#progress-bgrd"); */
	var docField = jQuery("#" + id +"_upload");
	var theForm = jQuery("#" + id + "_fileuploadForm");
	// var theSubmitButton = jQuery("#" + id +" input[type='submit']");
	
	//Initialise/Reset GUI elements
	/*theSubmitButton.attr("disabled", "disabled");
	fileNameTxt.html(initialisingTxt);
	progressBarGraphic.width(0);
	progressBarTextDiv.html("");*/

	//Start the Ajax File Upload...........
	initialise(doafter);
	
	function initialise(doafter) {
		var action = theForm.attr("action");
		var f = getFileName(docField.val());
		if(f) {		
	        fileName = f;	

			//This is blocked until above method completes
		  	ajaxFileUpload(action, doafter);
			
			//getProgress() will recurse until dowload is over
//			timeoutId = setTimeout(getProgress, updateRate);
	
//        	progressAreaDiv.show();
		}else {
			alert("You must choose a file");
		}

		return false;
	}
	
	/**
	 * Gets the upload progress from the server and then recursively calls itself until
	 * the upload is complete
	 */
	function getProgress() {	
		jQuery.ajax({
			type: "POST",
			url: "uploadprogress.action?rnd=" + new Date().getTime(),
			dataType: "json",
			success: function(jsonData) {
				//alert("getttin progress");
				var aborted = jsonData.aborted;
				if(aborted) {
					abort();	
				}else {
					var percent = jsonData.percentComplete;
					totalFileSize = jsonData.bytesTotal;
					var sent = jsonData.bytesSent;
					
					if(fileNameTxt.html() == initialisingTxt) {
						fileNameTxt.html('<b>Uploading:</b> ' + fileName);
					}
					
					if(sent > 0) {	
						updateProgressBarGUI(sent);
					}
					
					if(percent == "100") {
						//The end
					}else {
						setTimeout(getProgress, updateRate);	 
					}
				}
					
			},
			error: function(request, error, exception) {
				alert("Error detected: " + error + " and exception " + exception);
			}
		}); 
	}
	
	/**
	 * This method performs the upload of the file
	 * 
	 * @param action the url to call
	 * @param callback is the javascript method to call when the upload is complete
	 */
	function ajaxFileUpload(actionurl, doafter){                                        
		jQuery.ajaxFileUpload( {			
			url:actionurl,
			secureuri:false,
			fileElementId: id +"_upload",
			success: function (data, status) {
				complete(true, data);
			},
			error: function (data, status, e){
				abort();
			}
		}) 
		return false;
	}
	
	function abort() {
		complete(false);
	}
	
	function complete(success, data) {
		// progressAreaDiv.hide();
					
		if(doafter && typeof(doafter) == 'function') {
			if(data != null)
				doafter(success,data);
			else
				doafter(success);
		}
		//theSubmitButton.attr("disabled", "");
		clearTimeout(timeoutId);
	}
	
	var previousPercentComplete = 0;
	
	/**
	 * This is called every 2 seconds to update the progress bar
	 */
	function updateProgressBarGUI(bytesTransferred) {  
		//if (bytesTransferred > lastUploadedSize) {
		var now = new Date().getTime() / 1000.0;  // seconds
		var uploadTransferRate = bytesTransferred / (now - uploadStartTime);
		var timeRemaining = (totalFileSize - lastUploadedSize) / uploadTransferRate;
		
		//if (totalFileSize > 5242880) //if greater than 5 megabytes - slow down checks to every 5 seconds
		//	currentRate = 500;
		
	 
		lastUploadedSize = bytesTransferred;
		lastProgressUpdate = now;
		var progress = (0.0 + lastUploadedSize) / totalFileSize;
		var percentComplete = Math.round(100 * progress);
		
		var timeLeft = timeRemaining;
		
		/*
		 * This modifies the server connection frequency based on the progress rate of the upload
		 * So for large files it will slow down progress update checks - or for network glitches which
		 * slow and speed up transfer, it will adjust the rate accordingly.
		 */
		var rateModifier = 3;
		if(previousPercentComplete > 0) {
			if( (percentComplete - previousPercentComplete) < rateModifier ) {
				//If less than 3% change - slow down the checks
				updateRate += 500;	
			}else if( ((percentComplete - previousPercentComplete) > rateModifier) && (updateRate > 1000) ) {
				updateRate -= 500;
			}
		}
		previousPercentComplete = percentComplete;
	
		//jQuery("#errorlog").text(updateRate);
		
		var totalStr = Math.round(totalFileSize / 1024); //changed to kilobytes
		
		if(progress && progress > 0) {
	
			progressBarGraphic.width(barwidth * progress);
		}
			
		var ptext = percentComplete + '% completed (' +
						formatSize(lastUploadedSize) + ' of ' +
						formatSize(totalFileSize) + ')';
		
		ptext += '<br>Estimated time remaining: ' + formatTime(timeLeft);
		ptext += '<br>Transfer rate: ' + formatSize(uploadTransferRate) + " / second ";
		
		progressBarTextDiv.html(ptext);
	}
	
	/**
	 * If bigger than 1MB output MB, else output KB
	 * size check? jk
	 */
	function formatSize(byteCount) {
		var str = Math.round(byteCount/1024);
		if (str > 1024) {
			str = Math.round(100 * str / 1024) / 100.0;
			str += ' MB';
		} else {
			str += ' KB';
		}
		return str;
	}

	/**
	 * Format seconds into a string readable format
	 */
	function formatTime(seconds) {
		var str;
		if (seconds > 3600) {
			var h = Math.floor(seconds / 3600);
			seconds -= h * 3600;
			var m = Math.round(seconds / 60);
			str = h + ' hr. ' + ((m < 10) ? '0' + m : m) + ' min.';
		} else if (seconds > 60) {
			var m = Math.floor(seconds / 60);
			seconds -= m * 60;
			seconds = Math.round(seconds);
			str = m + ' min. ' + ((seconds < 10) ? '0' + seconds : seconds) + ' sec.';
		} else {
			str = Math.round(seconds) + ' sec.';
		}
		return str;
	}
	
	/**
	 * Gets the file name from a path
	 */
	function getFileName(path) {
		if(path) {
			var windows = path.indexOf("\\");
			if(windows && windows > -1) {
				var lastIndex = path.lastIndexOf("\\");
				var filename = path.substring(lastIndex + 1, path.length);
				return filename;
			}else {
				//linux
				var lastIndex = path.lastIndexOf("/");
				var filename = path.substring(lastIndex + 1, path.length);
				return filename;
			}
		}else {
			return null;
		}
	}

};

/**
 *	Static factory - sort of.
 */
davidjc.AjaxFileUpload.initialise = function(dobefore, doafter, id) {
	return new davidjc.AjaxFileUpload(dobefore, doafter, id);	
}


    

    
 






                                                                           






