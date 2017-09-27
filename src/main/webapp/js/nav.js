
function openPopup(url,w,h) {
    window.open(url,'popupWindow','width=' + w + ',height=' + h + ',status=yes');
}

function ajaxCall(activeDialog, method, url, data) {
    if(activeDialog)
        activeDialog.dialog("close");
    $.ajax({
         type: method,
         headers: { 'X-HTTP-Method-Override': method },
         contentType: 'application/json',
         dataType: "json",
         data: data,
         processData: false,
         url: url,
         success: function(msg) {
             if(msg && msg.error) {
                 alert(msg.error);
             }
         }
    });
}

var retries = 2;    // Once for each polling function.
$(function() {

    $.ajaxPrefilter(function(options, originalOptions, jqXHR) {

        originalOptions._error = originalOptions.error;

        options.error = function(_jqXHR, _textStatus, _errorThrown) {
            window.setTimeout(function () {
                $("#server_error").show();
                $("#server_action").html(", retrying in 5 seconds...");
            }, 500);
            window.setTimeout(function () {
                if (retries > 0) {
                    $("#server_error").hide();
                    $.ajax(originalOptions);
                    retries--;
                    window.setTimeout(function () { retries = 2; }, 10000);
                } else {
                    $("#server_action").html(", hit reload to continue.");
                    $("#reload_page").show();

                    // Chain original error handlers.
                    if (originalOptions._error)
                        originalOptions._error(_jqXHR, _textStatus, _errorThrown);
                }
            }, 5000);
        };
    });

    $(window).bind('beforeunload', function () {
        $(document).unbind('ajaxError');
    });

    $('#topNav > ul > li').hover(
        function() { $('ul', this).slideDown(200); },
        function() { $('ul', this).stop(true,true).slideUp(400); }
    );

    $('#reload_page').click( function(e) {
        window.location.reload(false);
    });

    $('#about_popup').click( function() {
        openPopup("about", 600, 250);
    });
});
