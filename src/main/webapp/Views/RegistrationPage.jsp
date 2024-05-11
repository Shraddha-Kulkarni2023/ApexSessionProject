<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

.div1 {
		width: 20%;
        margin: 50px auto;
        border: 2px solid #ccc;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

}

body {

	text-align:center;
	font-size: 15px;
}
</style>
<script>
function validate() {
	var firstname = document.getElementsByName("firstname")[0].value;
	var lastname = document.getElementsByName("lastname")[0].value;
	var email = document.getElementsByName("email")[0].value;
	var designation = document.getElementsByName("designation")[0].value;
	
	if(firstname.length === 0 || lastname.length === 0 || email.length === 0 || designation.length === 0) {
		alert("Please fill all fields");
		return false;
	}
	
	if(firstname.length < 4 || lastname.length < 4) {
		
		alert("Field length should be greater than 4");
		
		return false;
	}
	return true;
}

</script>


<body>
<%
String error = (String) request.getAttribute("error");
if (error != null && !error.trim().isEmpty()) {
    %>
            <script>
                alert("<%= error %>");
            </script>
    <% 
        }
 %>
<div class="div1">
<form action="<%= request.getContextPath()%>/registration" method="get" onsubmit = "return validate()">
FirstName : <input type="text" name="firstname" required><br><br>
LastName : <input type="text" name="lastname" required><br><br>
Email : <input type="text" name="email" pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" required><br><br>
Designation : <input type="text" name="designation" required><br><br><br>
<input type="submit">
</form>
</div>
</body>
</html>