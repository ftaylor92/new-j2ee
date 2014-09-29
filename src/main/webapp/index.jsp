<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN">

<html>
	<head>
		<title>new J2EE</title>
	</head>
<body>
<center><h3>New J2EE Features</h3></center>
<p>Site to experiment with new J2EE features as they are realeased.  Starting with Java 1.8 and Java EE 7</p>
<hr/>
<p>contact me at <a HREF="mailto:ftaylor92@bc.edu">FTaylor92@BC.edu</a></p>
<p>see all <a href="http://tinyurl.com/fmt-home">my apps</a></p>
<script>
	$(document).ready(function() {
		$.ajaxSetup({ cache: false, contentType: "application/json; charset=utf-8", dataType:"json"});

		var counterUrl="http://bookmarks.fmtmac.cloudbees.net/rest/counter?site="+ encodeURIComponent(window.location.href);
		$.get(counterUrl, function(data, txtstatus, xbr) {
			$("#counter").html("<br/><br/><small><em>count: "+ data+"</em></small>");
		});
	});
</script>
<div id='counter'></div>

<div id='cloudbees'>
<hr/>
<a href="http://www.cloudbees.com"><img src="http://cloudbees.prod.acquia-sites.com/sites/default/files/styles/large/public/Button-Built-on-CB-1.png?itok=3Tnkun-C" /></a>
</div>
</body>
</html>
