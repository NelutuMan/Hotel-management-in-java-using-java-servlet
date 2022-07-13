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
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: brown; " >
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_customer"
					class="navbar-brand">Customers</a></li>
					
				<li><a href="<%=request.getContextPath()%>/list_room"
					class="navbar-brand">Rooms</a></li>
						
				<li><a href="<%=request.getContextPath()%>/list_staff"
					class="navbar-brand">Staff</a></li>							
			</ul>
		</nav>
	</header>
	<br><br><br>
	
	
	
	<div class="container">
			<h3 class="text-center">Hotel Management</h3>
			<br>
			<br>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="text-align:center">Customers in the hotel</th>
						<th style="text-align:center">Rooms available</th>
						<th style="text-align:center">Staff members</th>																	
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="text-align:center"><span style="visibility: hidden;">a</span>
							<c:out value="${customer_count.customers_count}" />	
						</td>
						<td style="text-align:center">
							<c:out value="${room_count.rooms_count}" />
						</td>
						<td style="text-align:center">
							<c:out value="${staff_count.staff_count}" />	
						</td>			
					</tr>					
				</tbody>
				</table>	
			
	</div>
	<br><br>
	
	<div class="container" style="text-align:center;">
		<a href="<%=request.getContextPath()%>/home" class="btn btn-danger" >Count</a>
	</div>
</body>
</html>	