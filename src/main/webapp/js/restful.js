

var restful = function () {

    return {

        callMethod : function(method, templateMap, successfunc, activeDialog, data) {

            var url = method.href;

            if(activeDialog) {
                $(activeDialog).dialog("close");
            }
            if (templateMap) {
                url = this.templateUrl(url, templateMap);
            }
            $.ajax({
                type: method.type,
                headers: { 'X-HTTP-Method-Override': method.type },
                contentType: 'application/json',
                dataType: "json",
                data: data,
                url: url,
                success: function(msg) {
                    if (successfunc) {
                        successfunc(msg);
                    } else {
                        if(msg && msg.error) {
                            alert(msg.error);
                        }
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    var error = textStatus;
                }
          });
        },

        templateUrl : function(url, map) {
            var rtn = url;

            $.each(map, function(key, value) {
                rtn = replaceAll(rtn, key, value);
            });
            return rtn;
        }
    };

    function replaceAll(string, find, replace) {
    	  return string.replace(new RegExp(escapeRegExp(find), 'g'), replace);
    	}

    function escapeRegExp(string) {
        return string.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1");
    }

}();