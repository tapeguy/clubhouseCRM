<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM Admin" nav="admin_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
var leader_id = ${leader_id};

$(function() {

    function renderTeams() {

        // Build the html table of teams.
        $('#teams').html($('<tr>')
                   .append($('<th>').html('Team ID'))
                   .append($('<th>').html('Name'))
                   //.append($('<th>').html('Leader')));
     
        var restMethod = {
             href: "/crm/team/leader/" + leader_id,
             type: "GET"
        };
        restful.callMethod(restMethod, null, function(msg) {
           $.each(msg.entities, function() {
              var tr = $('<tr>');
              tr.append($('<td>').html(this.teamId));
              tr.append($('<td>').html(this.teamName));
              //tr.append($('<td>').html(this.leader ? this.leader.name : "---"));

              $('#teams').append(tr);
           });
        });
     }

    renderTeams();

});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="add_team" value="Add Team" />
<input type="button" class="sidebar_button" id="remove_team" value="Remove Team" />
</jsp:attribute>

<jsp:body>
<div class="panel" style="margin-left: 15px">
    <div class="panel-heading">
        <h3>Teams</h3>
    </div>
    <div class="panel-body">
        <table id="teams">
        </table>
    </div>
</div>
</jsp:body>       

</t:page>