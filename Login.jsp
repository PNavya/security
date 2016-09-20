<%@include file="header.jsp" %>
<center>
<h1>LOGIN</h1>

<form method="post" action="perform_login">
<table>
<tr><td>
User ID</td><td><input type="text" name="username" required></td></tr>
<tr><td>
Password</td><td><input type="password" name="password" ></td></tr>
<tr><td>
<input type="submit" value="submit">
<input type="reset" value="Reset"></td></tr>

</table>
</form>
</center>
</body>
</html>