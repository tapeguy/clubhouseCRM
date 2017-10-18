<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM Admin" nav="admin_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
$(function() {
});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="add_event" value="Add Event" />
<input type="button" class="sidebar_button" id="remove_event" value="Remove Event" />
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Admin Events
</div>

<t:add_event_dialog />
<t:remove_event_dialog />

</jsp:body>
</t:page>