<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
var member_id = ${member_id};

$(function() {

    function renderTeams() {
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

});
</script>
</jsp:attribute>


<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<div id="sidebar_buttons"></div>
</jsp:attribute>

<jsp:body>
<div class="panel" style="margin-left: 15px">
    <div class="panel-heading">
        <h3>You are a member of the following teams</h3>
    </div>
    <div class="panel-body">
        <table id="teams">
        </table>
    </div>
</div>
</jsp:body>
</t:page>