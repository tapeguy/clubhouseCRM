<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM Admin" nav="admin_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
$(function() {

    function renderMembers() {
       var member_columns = [ 'memberId', 'name', 'email', 'typeString' ];

       // Build the html table of members.
       $('#members').html($('<tr>')
                    .append($('<th>').html('Member ID'))
                    .append($('<th>').html('Name'))
                    .append($('<th>').html('Email'))
                    .append($('<th>').html('Type'))
                    .append($('<th>').html('Payment Plan')));

       var restMethod = {
               href: "/crm/member",
               type: "GET"
       };
       restful.callMethod(restMethod, null, function(msg) {
           $.each(msg.entities, function() {
               var tr = $('<tr>');
               $.each(this, function(key, value) {
                   if (member_columns.indexOf(key) >= 0) {
                       tr.append($('<td>').html(value));
                   }
               });
               tr.append($('<td>').html(this.paymentPlan.display));
               $('#members').append(tr);
           });
       });
    }

    renderMembers();
 
    $('#add_member_button').click( function() {

        // Insert the payment plan options into the dialog
        var restMethod = {
                href: "/crm/paymentPlan",
                type: "GET"
            };
        restful.callMethod(restMethod, null, function(msg) {
            $.each(msg.entities, function(key, value) {   
                $('#add_member_dialog > #payment_plan')
                     .append($('<option>')
                             .attr("value", value.paymentPlanId)
                             .text(value.display)); 
           });
           $('#add_member_dialog').dialog("open");
        });
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
                    var member = {
                        name: $('#add_member_dialog > #name').val(),
                        email: $('#add_member_dialog > #email').val(),
                        type: $('#add_member_dialog > #member_type').val().toUpperCase(),
                        credential: {
                            userName: $('#add_member_dialog > #username').val(),
                            password: ''
                        },
                        paymentPlan: {
                            paymentPlanId: $('#add_member_dialog > #payment_plan').val()
                        }
                    };
                    var restMethod = {
                        href: "/crm/member",
                        type: "POST"
                    };
                    restful.callMethod(restMethod, null, function(msg) {

                        // Set the password for the new member.
                        var restMethod = {
                            href: "/crm/member/{id}/password/{newPassword}",
                            type: "PUT"
                        };
                        restful.callMethod(restMethod, {
                            '{id}' : msg.memberId,
                            '{newPassword}' : $('#add_member_dialog > #password').val()
                        });
                        $('#add_member_dialog').dialog("close");
                        renderMembers();
                    }, null, JSON.stringify(member));
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
        </table>
    </div>
</div>

<t:add_member_dialog />

</jsp:body>
</t:page>