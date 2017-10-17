<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript" src="/js/member.js"></script>
<script type="text/javascript">
var member_id = ${member_id};

$(function() {
    member.fetchMember(member_id);
});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="update_email" value="Update Email" />
<input type="button" class="sidebar_button" id="change_password" value="Change Password" />
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    <table>
        <tr><td>Name:</td><td id="member_name"></td></tr>
        <tr><td>Email:</td><td id="member_email"></td></tr>
    </table>
</div>
</jsp:body>
</t:page>