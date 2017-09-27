<%@ tag description="Popup Template" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="page_meta_tags" required="false" %>

<t:header title="${title}" page_meta_tags='
    <link rel="stylesheet" type="text/css" href="/css/nav.css">
    <script src="/js/modernizr.js"></script>
    ${page_meta_tags}' />

<jsp:doBody />

<t:footer />
