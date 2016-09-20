<%-- <%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
<title>Registration</title>
</head>
<body> --%>
<%@include file="header.jsp" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>

<center>
<h1>REGISTRATION</h1>

<form:form method="POST" action="validate" commandName="userDetails">
      <table>
      <tr>
           <td>User ID:</td>
           <td><form:input type="text" path="userId" /></td>
       </tr>
       <tr>
           <td>User Name:</td>
           <td><form:input type="text" path="name" /></td>
       </tr>
       <tr>
           <td><form:label path="password">Password:</form:label></td>
           <td><form:input path="password" type="password" /></td>
       </tr>
       <tr>
           <td><form:label path="confirmpassword"> Confirm Password:</form:label></td>
           <td><form:input type="password" path="confirmpassword"/></td>
       </tr>
       
       <tr>
           <td><form:label path="email">Email:</form:label></td>
           <td><form:input type="email" path="email"/></td>
       </tr>
       <tr>
           <td><form:label path="address">Address:</form:label></td>
           <td><form:input type="textarea" rows="5" column="5" path="address"/></td>
       </tr>
       <tr>
           <td><form:label path="contact">Contact:</form:label></td>
           <td><form:input path="contact"/></td>
       </tr>
       
       
       <tr>
        
         <td><input type="submit" value="Submit"/></td>
         <td><input type="submit" value="Reset"/></td>
         </tr>
</table>
</form:form>
</center>
</body>
</html>