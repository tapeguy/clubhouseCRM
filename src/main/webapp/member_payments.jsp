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
        $("#member_dues").html(member.getMember().annualClubDues);
        $("#member_payment_plan").html(member.getMember().paymentPlan.display);
        $("#member_balance").html(member.getMember().account.balance);
    }
});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Make a Payment</div>
<form method="post" style="margin: auto">
    <table>
    	<tr>
            <td><label> Amount : $</label></td>
    	</tr>
        <tr>
            <td><input type="number" name="payment"/></td>
        </tr>
        <tr>
            <td><input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Pay Now"/><td>
        </tr>
    </table>
   </form>
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Member Payments: ${name}
</div>
<div class="panel" style="width: 640px; margin-left: 15px">
    <div class="panel-heading">
        <h3 id="member_name"></h3>
    </div>
    <div class="panel-body">
        <table>
            <tr><td>Annual Dues:</td><td id="member_dues"></td></tr>
            <tr><td>Payment Plan:</td><td id="member_payment_plan"></td></tr>
            <tr><td>Account Balance:</td><td id="member_balance"></td></tr>
        </table>
    </div>
</div>
</jsp:body>
</t:page>