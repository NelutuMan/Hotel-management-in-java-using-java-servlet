<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Hotel</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
					<form action="login" method="post">
				<caption>
					<h2 style="text-align:center;"> Login </h2>						           			           								
				</caption>
				<br>
				
				<fieldset class="form-group">
					<label>Username</label> 
					<input type="text"class="form-control" name="username" required="required">		
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> 
					<input type="password"class="form-control" name="password" required="required">		
				</fieldset>
				<br>
				<div class="container" style="text-align:center;">
					<button type="submit" class="btn btn-danger" style="text-align:center;">Log in</button>
				</div>	
				</form>
			</div>
		</div>
	</div>
</body>
</html>