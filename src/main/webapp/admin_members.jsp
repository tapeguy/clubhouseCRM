<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM Admin" nav="admin_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
$(function() {

    var member_columns = [ 'memberId', 'name', 'email', 'typeString' ];
    var restMethod = {
            href: "/crm/member",
            type: "GET"
        };
    restful.callMethod(restMethod, null, displayMembers);
    function displayMembers(msg) {
        $.each(msg.entities, function() {
            var tr = $('<tr>');
            $.each(this, function(key, value) {
                if (member_columns.indexOf(key) >= 0) {
                    tr.append($('<td>').html(value));
                }
            });
            $('#members').append(tr);
        });
    }
 
    $('#add_member_button').click( function() {
        $('#add_member_dialog').dialog("open");
    });

    $('#add_member_dialog').dialog({
        title: "Add Member",
        autoOpen: false,
        width: 300,
        modal: true,
        buttons: [
            {
                text: "Save",
                click: function() {
                },
            },
            {
                text: "Cancel",
                click: function() {
                    $(this).dialog("close");
                }
            }
        ]
    });
});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="add_member_button" value="Add Member" />
</jsp:attribute>

<jsp:body>
<div class="panel" style="margin-left: 15px">
    <div class="panel-heading">
        <h3>Admin Members</h3>
    </div>
    <div class="panel-body">
        <table id="members">
            <tr>
                <th>Member ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Type</th>
            </tr>
        </table>
    </div>
</div>

<t:add_member_dialog />

</jsp:body>
</t:page>