<%@ include file="/taglibs.jsp" %>
<t:popup title="About">

<jsp:attribute name="page_meta_tags">
</jsp:attribute>
<jsp:body>

<div class="logo" style="float: left;">
    <img border="0" src="/images/clubhouse.jpg">
</div>
<h3 style="float: left; padding-left: 30px;">${description}</h3>
<div style="clear: both;"></div>
<table style="padding-left: 20px;">
<tr><td style="width: 125px;"><b>Version:</b></td><td>${version}</td></tr>
<tr><td><b>Build Time:</b></td><td>${buildTimestamp}</td></tr>
<tr><td><b>Build Host:</b></td><td>${buildHost}</td></tr>
</table>
</jsp:body>
</t:popup>