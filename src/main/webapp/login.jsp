<%@ include file="/taglibs.jsp" %>
<t:popup title="clubhouseCRM">

<jsp:body>
<div style="margin-left: 15px">
<c:if test="${ param.error != null }">
        <div>
            Invalid username or password.
        </div>
        <br>
</c:if>   
<c:if test="${ param.logout != null }">
        <div>
            You have been logged out.
        </div>
        <br>
</c:if>    
        <form method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
            
            <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
        </form>
</div>
</jsp:body>
</t:popup>