<html>
<head>

<title>Login Page</title>

</head>
<body>

<h1> Login Page </h1>
<% 
	 String id = request.getSession().getId();
		%>
		<input type="hidden" value=<%=id %>>

<%
	String loginError = (String)request.getAttribute("loginError");
	if(loginError!=null)
	{
%>
	<span style="color:red"> <%=loginError%> </span>

<%
}
%>

<br>
<br>



<form name="Login" action="/ShoppingCart/cs" method="post">
	
	
	UserName : <input type="text" name="username"/>

	Password : <input type="password" name="password" />
	<input type="submit"  name="action" value="Login"/>
	<input type="reset" value ="Reset"/>
	<input type="hidden" name="page" value="login"/>
</form>
	
</body>

</html>