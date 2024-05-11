<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Order" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<style>
body {

	text-align: center;


}


.div1 {

	margin-left: 200px;

}
</style>
<body>
    <h1>Welcome, <%= session.getAttribute("username") %> and <%= session.getAttribute("password") %></h1>
    <div class="div1">
    <table border="1">
    <tr>
    <th>ID</th>
    <th>Customer Name</th>
    <th>Date</th>
    <th>Product Name</th>
    </tr>
    <% 
            List<Order> ordersList = (List<Order>) request.getAttribute("orderlist");
    		if(ordersList != null && !ordersList.isEmpty()) {
            for (Order order : ordersList) {
    %>
        <tr>
            <td><%= order.getId() %></td>
            <td><%= order.getName() %></td>
            <td><%= order.getdate1() %></td>
            <td><%= order.getProductName() %></td>
        </tr>
        <% }
            }
            else {
            	out.println("<tr>No records found</tr>");
            
            }%>
    </table>
    </div>
</body>

</html>