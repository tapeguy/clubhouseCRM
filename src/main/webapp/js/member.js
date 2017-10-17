

var member = function() {

    var _member = null;

    return {

        fetchMember : function(member_id) {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "/crm/member/" + member_id,
                success: function(msg){
                    member.setMember(msg);
                }
           });
        },

        getMember : function() {
            return _member;
        },

        setMember : function(member) {
            _member = member;
        },

        getLinks : function() {
            return member.getMember()._links;
        },

        displayEvents : function() {
        },

        displayTeams : function() {
        },

        displayPayments : function() {
        }
    };
}();