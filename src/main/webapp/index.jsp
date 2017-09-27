<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM">

<jsp:attribute name="page_meta_tags">
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="add_member" value="Add Member" />
<input type="button" class="sidebar_button" id="remove_member" value="Remove Member" />
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Hello ${name}
    <br><br><br><br><br>
</div>
</jsp:body>
</t:page>