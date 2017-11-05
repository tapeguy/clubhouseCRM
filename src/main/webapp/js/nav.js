
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

$(function() {

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
