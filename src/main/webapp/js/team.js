

var team = function() {

    var _team = null;

    return {

        fetchTeam : function(team_id, callback) {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "/crm/team/" + team_id,
                success: function(msg) {
                    team.setTeam(msg);
                    callback();
                }
           });
        },

        getTeam : function() {
            return _team;
        },

        setTeam : function(team) {
            _team = team;
        },

        getLinks : function() {
            return team.getTeam()._links;
        }
    };
}();