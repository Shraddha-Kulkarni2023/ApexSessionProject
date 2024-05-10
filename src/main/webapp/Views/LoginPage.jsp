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
<body>
<h1>
Please Enter FirstName and LastName as UserName and Password
</h1>
<script>
function validatelogin() {
	
	var username = document.getElementsByName("username")[0].value;
	var password = document.getElementsByName("password")[0].value;
	
	if(username.length === 0 || password.length === 0) {
		
		alert("Please fill Username and Password Both");
		return false;
	}
	return true;
}
</script>
<div class="div1">
<form action="<%= request.getContextPath()%>/LoginServlet" method="get" onsubmit = "return validatelogin()">
UserName : <input type="text" name="username"><br><br>
Password : <input type="password" name="password"><br><br>
<input type="submit">
</form>
</div>
</body>
</html>