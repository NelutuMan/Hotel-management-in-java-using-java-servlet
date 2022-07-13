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
			<h3 class="text-center">Staff</h3>
			<br>			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="text-align:center">id_staff</th>
						<th style="text-align:center">staff_name</th>
						<th style="text-align:center">staff_email</th>
						<th style="text-align:center">position</th>
						<th style="text-align:center">salary</th>
						<th style="text-align:center">Actions</th>										
					</tr>
				</thead>
				<tbody>		
					<c:forEach var="staff" items="${listStaff}">
						<tr>
							<td style="text-align:center"><c:out value="${staff.id_staff}" /></td>
							<td style="text-align:center"><c:out value="${staff.staff_name}" /></td>
							<td style="text-align:center"><c:out value="${staff.staff_email}" /></td>
							<td style="text-align:center"><c:out value="${staff.position}" /></td>
							<td style="text-align:center"><c:out value="${staff.salary}" /></td>
							<td style="text-align:center">
							<a href="edit_staff?id_staff=<c:out value='${staff.id_staff}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete_staff?id_staff=<c:out value='${staff.id_staff}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="container" style="text-align:center;">
				<a href="<%=request.getContextPath()%>/new_staff" class="btn btn-danger">Add New Staff</a>									
			</div>
		</div>
</body>
</html>