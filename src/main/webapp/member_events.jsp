<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
var member_id = ${member_id};

$(function() {

    function renderEvents() {

       // Build the html table of events.
       $('#enrolled_events').html($('<tr>')
                  .append($('<th>').html('Event ID'))
                  .append($('<th>').html('Name'))
                  .append($('<th>').html('Date & Time'))
                  .append($('<th>').html('Leader'))
                  .append($('<th>').html('Location')));
    
       var restMethod = {
            href: "/crm/event/enrolled/" + member_id,
            type: "GET"
       };
       restful.callMethod(restMethod, null, function(msg) {
          $.each(msg.entities, function() {
             var tr = $('<tr>');
             tr.append($('<td>').html(this.eventId));
             tr.append($('<td>').html(this.display));
             tr.append($('<td>').html(this.eventDateTime));
             tr.append($('<td>').html(this.leader ? this.leader.name : "---"));
             tr.append($('<td>').html(this.eventLocation));

             $('#enrolled_events').append(tr);
          });
       });
    }

    renderEvents();

    $('#enroll_event_button').click( function() {
        // Insert the payment plan options into the dialog
        var restMethod = {
            href: "/crm/event/available/" + member_id,
            type: "GET"
        };
        restful.callMethod(restMethod, null, function(msg) {
            $.each(msg.entities, function(key, value) {   
                $('#enroll_event_dialog > #event_name')
                     .append($('<option>')
                             .attr("value", value.eventId)
                             .text(value.display)); 
            });

            $('#enroll_event_dialog').dialog("open");
        });
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
                    var event_id = $('#enroll_event_dialog > #event_name').val();

                    // Add the event.
                    var restMethod = {
                        href: "/crm/event/{id}/addMember/{memberId}",
                        type: "PUT"
                    };
                    restful.callMethod(restMethod, {
	                       '{id}' : event_id,
	                       '{memberId}' : member_id
	                    },
	                    function() {
	                        renderEvents();
	                    },
	                    $('#enroll_event_dialog')
	                );
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
        <table id="enrolled_events" style="width: 80%">
        </table>
    </div>
</div>

<t:enroll_event_dialog />

</jsp:body>
</t:page>