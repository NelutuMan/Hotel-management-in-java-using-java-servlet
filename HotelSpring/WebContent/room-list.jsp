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
			style="background-color: brown">
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/home"
					class="navbar-brand">Home</a></li>
					
				<li><a href="<%=request.getContextPath()%>/list_customer"
					class="navbar-brand">Customers</a></li>
					
				<li><a href="<%=request.getContextPath()%>/list_room"
					class="navbar-brand">Rooms</a></li>
						
				<li><a href="<%=request.getContextPath()%>/list_staff"
					class="navbar-brand">Staff</a></li>													
			</ul>		
		</nav>
	</header>
	<br>
	
		<div class="container">
			<h3 class="text-center">Rooms</h3>
			<br>			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="text-align:center">id_room</th>
						<th style="text-align:center">floor</th>
						<th style="text-align:center">customer</th>
						<th style="text-align:center">room_attendant</th>
						<th style="text-align:center">features</th>
						<th style="text-align:center">empty_room</th>
						<th style="text-align:center">Actions</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="room" items="${listRoom}">
						<tr>
							<td style="text-align:center"><c:out value="${room.id_room}" /></td>
							<td style="text-align:center"><c:out value="${room.floor}" /></td>
							<td style="text-align:center"><c:out value="${room.customer}" /></td>
							<td style="text-align:center"><c:out value="${room.room_attendant}" /></td>
							<td style="text-align:center"><c:out value="${room.features}" /></td>
							<td style="text-align:center"><c:out value="${room.empty_room}" /></td>
							<td style="text-align:center">
							<a href="edit_room?id_room=<c:out value='${room.id_room}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete_room?id_room=<c:out value='${room.id_room}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="container" style="text-align:center;">
				<a href="<%=request.getContextPath()%>/new_room" class="btn btn-danger">Add
					New Room</a>					
			</div>
		</div>
	
</body>
</html>