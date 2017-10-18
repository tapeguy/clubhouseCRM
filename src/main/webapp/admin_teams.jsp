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
<input type="button" class="sidebar_button" id="add_team" value="Add Team" />
<input type="button" class="sidebar_button" id="remove_team" value="Remove Team" />
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Admin Teams
</div>

<t:add_team_dialog />
<t:remove_team_dialog />

</jsp:body>
</t:page>