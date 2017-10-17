<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript" src="/js/member.js"></script>
<script type="text/javascript">
var member_id = ${member_id};

$(function() {
    member.fetchMember(member_id, displayMember);

    function displayMember() {
        $("#member_type").html(member.getMember().type);
        $("#member_name").html(member.getMember().name);
        $("#member_username").html(member.getMember().credential.userName);
        $("#member_email").html(member.getMember().email);
        $("#member_payment_plan").html(member.getMember().paymentPlan.display);
    }
});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="update_email" value="Update Email" />
<input type="button" class="sidebar_button" id="change_password" value="Change Password" />
</jsp:attribute>

<jsp:body>
<div class="panel" style="width: 640px; margin-left: 15px">
    <div class="panel-heading">
        <h3 id="member_name"></h3>
    </div>
    <div class="panel-body">
        <table>
            <tr><td style="width: 250px">Type:</td><td id="member_type"></td></tr>
            <tr><td>Username:</td><td id="member_username"></td></tr>
            <tr><td>Email:</td><td id="member_email"></td></tr>
            <tr><td>Payment Plan:</td><td id="member_payment_plan"></td></tr>
        </table>
    </div>
</div>
</jsp:body>
</t:page>