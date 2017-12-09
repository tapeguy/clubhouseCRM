<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
var member_id = ${member_id};

$(function() {

    function renderEvents() {
       var enrolled_columns = [ 'eventId', 'eventDateTime', 'leader', 'eventLocation' ];

       // Build the html table of members.
       $('#members').html($('<tr>')
                  .append($('<th>').html('Event ID'))
                  .append($('<th>').html('Date'))
                  .append($('<th>').html('Leader'))
                  .append($('<th>').html('Location')));
    
       var restMethod = {
            href: "/event/enrolled/" + member_id,
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
             $('#enrolled_events').append(tr);
          });
       });
    }

    $('#enroll_event_button').click( function() {
        $('#enroll_event_button').dialog("open");
    });

    $('#enroll_event_dialog').dialog({
        title: "Enroll in Event",
        autoOpen: false,
        width: 300,
        modal: true,
        buttons: [
            {
                text: "Save",
                click: function() {
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
<input type="button" class="sidebar_button" id="enroll_event_button" value="Enroll in Event" />
</jsp:attribute>

<jsp:body>
<div class="panel" style="margin-left: 15px">
    <div class="panel-heading">
        <h3>Enrolled Events</h3>
    </div>
    <div class="panel-body">
        <table id="enrolled_events">
        </table>
    </div>
</div>

<t:enroll_event_dialog />

</jsp:body>
</t:page>