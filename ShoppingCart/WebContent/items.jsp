<%@page import="java.util.*,com.example.domain.*"%>

<html>
<head>
<title>Items page</title>
</head>


<body>

	<form  action="/ShoppingCart/cs" method="post">
		
	</form>
	<h1>Hello, this is the Items page</h1>

	<%
		String loginSuccess = (String) request.getAttribute("loginSuccess");
	String cartAddError =(String) request.getAttribute("cartEmpty");
	String cartSuccess = (String)request.getAttribute("addCartSuccess");
		if (loginSuccess != null) {
	%>
	<span style="color: green"><%=loginSuccess%></span>


	<%
		}
	%>
	<% 
		if (cartAddError != null) {
	%>
	<span style="color: red"><%=cartAddError%></span>


	<%
		}
	%>
	
	<% 
		if (cartSuccess != null) {
	%>
	<span style="color: green"><%=cartSuccess%></span>


	<%
		}
	%>
	
	<form name="results" action="/ShoppingCart/cs" method="post">
	<a><button type = "submit" name ="action" value = "Logout">Logout</button></a>
	<button type = "submit" name="action" value = "Help">Help</button>
	<br>
	<br>
		<%
			Collection<Item> items = (Collection<Item>) request.getAttribute("items");
		
		%>
	
		<table>
			<tr>
				<th></th>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			
			<%
				for (Item item : items) 
				{
			%>
			<tr>
				<td><input type="checkbox" name="checkedBox" value="<%=item.getId()%>"/></td>
				<td><%=item.getId()%></td>
				<td><%=item.getName()%></td>
				<td><%=item.getPrice()%></td>
				<td><input type="text" name="quantity"></td>

			</tr>
				

			<%
				}
			%>
			


		</table>
		<br>

		
		<input type = "submit" name ="action" value = "Add to Cart"/>
		<input type = "submit" name="action" value = "Proceed to Checkout"/>

		<input type="hidden" name="page" value="items" />
	</form>
</body>



</html>