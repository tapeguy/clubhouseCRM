<%@ include file="/taglibs.jsp" %>
<t:popup title="clubhouseCRM">

<jsp:body>
<div id="login_page">
<c:if test="${ param.error != null }">
        <div style="margin: auto; width: 300px;">
            Invalid username or password.
        </div>
        <br>
</c:if>   
<c:if test="${ param.logout != null }">
        <div style="margin: auto; width: 300px;">
            You have been logged out.
        </div>
        <br>
</c:if>
        <div class="smoothbox" id="login_box">
            <form method="post" style="margin: auto">
            <table class="login_table">
                <tr>
                    <td><label> User Name : </label></td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td><label> Password: </label></td>
                    <td><input type="password" name="password"/><td>
                </tr>
                <tr>
                    <td><input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }"></td>
                    <td><input type="submit" value="Sign In"/><td>
                </tr>
            </table>
            </form>
        </div>
</div>
</jsp:body>
</t:popup>