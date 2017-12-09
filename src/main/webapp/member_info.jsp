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

    $('#update_email_button').click( function() {
        $('#update_email_dialog').dialog("open");
    });

    $('#update_email_dialog').dialog({
        title: "Update Email",
        autoOpen: false,
        width: 300,
        modal: true,
        buttons: [
            {
                text: "Save",
                click: function() {
                    var email = $('#update_email_dialog > #email').val();

                    var new_member = member.getMember();
                    new_member.email = email;

                    // Set the email for the new member.
                    var restMethod = {
                        href: "/crm/member",
                        type: "PUT"
                    };
                    restful.callMethod(restMethod, null, function() {
                        member.fetchMember(member_id, displayMember);
                    }, $('#update_email_dialog'), JSON.stringify(new_member));
                }
            },
            {
                text: "Cancel",
                click: function() {
                    $(this).dialog("close");
                }
            }
        ]
    });

    $('#change_password_button').click( function() {
        $('#change_password_dialog').dialog("open");
    });

    $('#change_password_dialog').dialog({
        title: "Change Password",
        autoOpen: false,
        width: 300,
        modal: true,
        buttons: [
            {
                text: "Save",
                click: function() {

                    var password = $('#change_password_dialog > #password').val();
                    var confirm_password = $('#change_password_dialog > #confirm_password').val();

                    if (password != confirm_password) {
                        alert ("Passwords must match!");
                        return;
                    }

                    // Set the password for the new member.
                    var restMethod = {
                        href: "/crm/member/{id}/password/{newPassword}",
                        type: "PUT"
                    };
                    restful.callMethod(restMethod, {
                       '{id}' : member_id,
                       '{newPassword}' : $('#change_password_dialog > #password').val()
                    }, null, $('#change_password_dialog'));
                }
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
<input type="button" class="sidebar_button" id="update_email_button" value="Update Email" />
<input type="button" class="sidebar_button" id="change_password_button" value="Change Password" />
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

<t:change_password_dialog />
<t:update_email_dialog />

</jsp:body>
</t:page>