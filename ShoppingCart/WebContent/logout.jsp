<html>
<head> 
<title>Thank you for visiting us</title>
</head>


<body>
<% 
	 String id = request.getSession().getId();
		%>
		<input type="hidden" value=<%=id %>>
<form name="Login" action="/ShoppingCart/cs" method="post">
<a><button type = "submit" name ="action" value = "Logout">Logout</button></a>
	<button type = "submit" name="action" value = "Help">Help</button>
	<br>
	<br>


<h1> Thank you for visiting our web-site</h1>

<input type="hidden" name="page" value="Logout"/>

</form>



</body>


</html>