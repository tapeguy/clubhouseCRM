<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="enroll_event" value="Enroll in Event" />
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Member Events: ${name}
</div>
</jsp:body>
</t:page>