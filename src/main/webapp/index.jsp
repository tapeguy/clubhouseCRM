<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
$(function() {
    var restMethod = {
            href: "/crm/member",
            type: "GET"
        };
    restful.callMethod(restMethod, null, displayMembers);

    function displayMembers(msg) {
        $.each(msg.entities, function() {
            var tr = $('<tr>');
            $.each(this, function() {
                tr.append('<td>').append(this);
            });
            $('#members').append(tr);
        });
    }
});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Hello ${name}
    <table id="members">
    </table>
</div>
</jsp:body>
</t:page>