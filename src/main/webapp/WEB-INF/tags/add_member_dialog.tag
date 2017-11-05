<%@ tag description="Add Member Dialog Template" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>

<div id="add_member_dialog">
   <br>

   <label for="name">Name:</label>
   <input id="name" name="name">
   <br><br>

   <label for="username">Username:</label>
   <input id="username" name="username">
   <br><br>

   <label for="password">Password:</label>
   <input type="password" id="password" name="password">
   <br><br>

   <label for="email">Email:</label>
   <input id="email" name="email">
   <br><br>

   <label for="member_type">Type:</label><br>
   <select id="member_type">
       <option>Member</option>
       <option>Leader</option>
   </select>
   <br><br>

   <label for="payment_plan">Payment Plan:</label>
   <select id="payment_plan">
   </select>
   <br />
</div>
