<%@ tag description="Page Template" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="nav" required="true" %>
<%@ attribute name="page_meta_tags" required="false" %>
<%@ attribute name="sidebar_content" required="false" %>
<t:header title="${title}" page_meta_tags='
    <link rel="stylesheet" type="text/css" href="/css/nav.css">
    <script src="/js/modernizr.js"></script>
    ${page_meta_tags}' />
<table>
    <tr>
        <td>
            <div class="logo" style="float: left;">
                <img border="0" src="/images/clubhouse.jpg">
            </div>
        </td>
        <td width="100%" style="vertical-align: top">
        <c:choose>
            <c:when test="${ nav eq 'member_nav' }">
                <t:member_nav />
            </c:when>
            <c:when test="${ nav eq 'admin_nav' }">
                <t:admin_nav />
            </c:when>
        </c:choose>
        </td>
    </tr>
</table>
<c:if test="${not empty breadcrumbs}">
    <div class="breadcrumb_container left_margin right_margin"><t:breadcrumbs /></div>
</c:if>
<br>
<div class="main_content left_margin right_margin">
<c:choose>
    <c:when test="${not empty sidebar_content}">
        <t:sidebar sidebar_content="${sidebar_content}" />
        <div class="sidebar_main_content"><jsp:doBody /></div>
    </c:when>
    <c:otherwise>
        <jsp:doBody />
    </c:otherwise>
</c:choose>
</div>
<t:footer />
