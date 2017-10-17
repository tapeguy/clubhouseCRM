<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<div id="sidebar_buttons"></div>
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Member Teams: ${name}
</div>
</jsp:body>
</t:page>