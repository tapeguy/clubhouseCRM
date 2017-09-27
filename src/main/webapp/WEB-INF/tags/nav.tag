<%@ tag description="Page Nav Template" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<script type="text/javascript" src="js/nav.js"></script>

<nav id="topNav">
    <ul>
        <li><a href="#">File</a>
            <ul>
                <li class="nav-heading"><a href="#" id="reset_dialog_link">New</a></li>
                <li class="nav-heading"><a href="#" id="config_dialog_link">Open</a></li>
                <li><hr /></li>
                <li class="nav-heading"><a href="/crm/config">Save</a></li>
                <li><hr /></li>
                <li class="nav-heading"><a href="/crm/shutdown">Shutdown</a></li>
            </ul>
        </li>
        <li><a href="#">Windows</a>
            <ul>
                <li class="nav-heading"><a href="#" id="debug_popup">Debug Popup</a></li>
            </ul>
        </li>
        <li><a href="#">Help</a>
            <ul>
                <li class="nav-heading"><a href="#" id="about_popup">About</a></li>
            </ul>
        </li>
            <li><div id="server_error">Error connecting to server<span id="server_action"></span></div></li>
            <li class="nav-heading" id="reload_page"><a href="#" id="reload_page_link">Reload Page</a></li>
    </ul>
</nav>

