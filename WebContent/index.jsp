<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="js/jquery.3.3.1.min.js"></script>
<link rel="icon" href="favicon.ico">
<title>Log Viewer</title>
<style>
body {
	padding: 0px;
	margin: 0;
	background-color: white;
}

.log {
	background-color: #FFFF99;
	font-family: 'Courier New', Arial;
	font-size: 12px;
	line-height: 20px;
	overflow-x: auto;
	white-space: nowrap;
	width: 90%;
	height: 440px;
	text-align: left;
	margin: 0 auto;
	border: 1px solid #999;
	padding: 10px;
}

.hlight {
	background-color: #FFFF00;
	color: red;
}

button {
	padding: 5px 15px;
	text-align: center;
	font-size: 14px;
	cursor: pointer;
	margin: 10px;
}
</style>
</head>
<body>
	<div style="text-align: center;">
		<div
			style="color: #ddd; font-family: 'Courier New', Arial; padding: 8px; background-color: black; margin-bottom: 20px">
			Log Viewer</div>
		<div id="log" class="log"></div>
		<button onclick="doCopy()" id="copyBtn">Copy</button>
		<button onclick="doRefresh()" id="loadBtn">Refresh</button>
	</div>
	<div style="text-align: center; color:gray;">
		<small>Designed and built with all the love by <a
			href='https://www.jodohonline.net/' target="_blank">www.jodohonline.net</a></small>
	</div>
	<script>
		function doCopy() {
			var elm = document.getElementById("log");
			// for Internet Explorer

			if (document.body.createTextRange) {
				var range = document.body.createTextRange();
				range.moveToElementText(elm);
				range.select();
				document.execCommand("Copy");
				alert("Copied !");
			} else if (window.getSelection) {
				// other browsers

				var selection = window.getSelection();
				var range = document.createRange();
				range.selectNodeContents(elm);
				selection.removeAllRanges();
				selection.addRange(range);
				document.execCommand("Copy");
				alert("Copied !");
			}
		}

		function doRefresh() {
			$('#log').load('View', function() {
				var objDiv = document.getElementById("log");
				objDiv.scrollTop = objDiv.scrollHeight;
			});
		}

		$(document).ready(function() {
			doRefresh();
		})
	</script>

</body>
</html>
