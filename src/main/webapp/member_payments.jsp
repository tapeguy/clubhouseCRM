<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="make_payment" value="Make Payment" />
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Member Payments: ${name}
</div>
</jsp:body>
</t:page>