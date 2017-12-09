<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM" nav="member_nav">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
var member_id = ${member_id};

$(function() {

    function renderTeams() {

        // Build the html table of teams.
        $('#teams').html($('<tr>')
                   .append($('<th>').html('Team ID'))
                   .append($('<th>').html('Name'))
                   .append($('<th>').html('Leader')));
     
        var restMethod = {
             href: "/crm/team/member/" + member_id,
             type: "GET"
        };
        restful.callMethod(restMethod, null, function(msg) {
           $.each(msg.entities, function() {
              var tr = $('<tr>');
              tr.append($('<td>').html(this.teamId));
              tr.append($('<td>').html(this.teamName));
              tr.append($('<td>').html(this.leader ? this.leader.name : "---"));

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
<div id="sidebar_buttons"></div>
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