<%@ tag description="Breadcrumbs Template" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<c:forEach var="ntry" items="${breadcrumbs}" varStatus="status">
    <c:if test="${ status.index > 0 }"><div class="arrow">&nbsp; -&gt; &nbsp;</div></c:if>
    <div class="breadcrumb" <c:if test="${status.last}">style="font-weight: bold"</c:if>>
    <a href="/<c:out value="${ntry.value}" />"><c:out value="${ntry.key}" /></a>
    </div>
</c:forEach>
<div style="clear:both;"></div>