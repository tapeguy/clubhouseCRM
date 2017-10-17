

var member = function() {

    var _member = null;

    return {

        fetchMember : function(member_id, callback) {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "/crm/member/" + member_id,
                success: function(msg) {
                    member.setMember(msg);
                    callback();
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
        }
    };
}();