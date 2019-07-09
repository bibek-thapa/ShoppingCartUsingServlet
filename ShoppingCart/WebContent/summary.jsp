<%@page import="com.example.domain.*,java.util.*" %>

<html>
<head>

</head>
<body>
	<h1>This is the summary page</h1>
	<% 
	 String id = request.getSession().getId();
		%>
		<input type="hidden" value=<%=id %>>
<form  action="/ShoppingCart/cs" method="post">

<a><button type = "submit" name ="action" value = "Logout">Logout</button></a>
	<button type = "submit" name="action" value = "Help">Help</button>
<br>
	<br>
<table>

	<tr>
		<th valign="middle">Item</th>
		<th valign="middle">Price</th>
		<th valign="middle">Quantity</th>
		<th valign="middle">Total</th>
	</tr>
	<%
		Map<Integer,Item> checkedItems =(Map<Integer,Item>) session.getAttribute("checkedItemsSession");
		String[] quantity = (String[]) session.getAttribute("checkedQuantitySession");
		
		float sum = 0;
	%>
	
	
	<%
		for(int i = 1; i <= quantity.length ; i++)
		{	
			
	
	%>
	<%if( quantity[i-1] != null && quantity[i-1]!=""){
		System.out.println(i);
		%>
		
		
		<tr>
		<td valign="middle"><%=checkedItems.get(i).getName()%></td>
		<td valign="middle"><%=checkedItems.get(i).getPrice() %></td>
		<td valign="middle"><%=quantity[i-1] %></td>
		<td valign="middle"><%=checkedItems.get(i).getPrice()* Float.parseFloat(quantity[i-1]) %></td> 
		<% sum = sum + checkedItems.get(i).getPrice()* Float.parseFloat(quantity[i-1]);%>
		
		</tr>
	<%} %>
	<%
		}
	%>

	<tr>
		<td>Grand Total</td>
		<td></td>
		<td></td>
		<td><%=sum%></td>
	</tr>
	
	
</table>
<br>

<input type = "submit" name ="action" value = "Back to Cart"/>
<input type = "submit" name="action" value = "Checkout"/>

<input type="hidden" name="page" value="summary"/>

</form>
	

</body>



</html>