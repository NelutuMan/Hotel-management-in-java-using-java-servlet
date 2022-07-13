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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">																						
				<c:if test="${staff != null}">
					<form action="update_staff" method="post">
				</c:if>
				<c:if test="${staff == null}">
					<form action="insert_staff" method="post">
				</c:if>

				<caption>
					<h2 style="text-align:center;">
						<c:if test="${staff != null}">
            			Edit Staff
            			</c:if>
						<c:if test="${staff == null}">
            			Add New Staff
            			</c:if>
					</h2>
				</caption>
				<br>
				<c:if test="${staff != null}">
					<input type="hidden" name="id_staff" value="<c:out value='${staff.id_staff}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Staff Name</label> <input type="text"
						value="<c:out value='${staff.staff_name}' />" class="form-control"
						name="staff_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Staff Email</label> <input type="text"
						value="<c:out value='${staff.staff_email}' />" class="form-control"
						name="staff_email">
				</fieldset>

				<fieldset class="form-group">
					<label>Position</label> <input type="text"
						value="<c:out value='${staff.position}' />" class="form-control"
						name="position">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Salary</label> <input type="text"
						value="<c:out value='${staff.salary}' />" class="form-control"
						name="salary">
				</fieldset>
				<br>
				<div class="container" style="text-align:center;">
					<button type="submit" class="btn btn-danger" style="text-align:center;">Save</button>
				</div>	
				</form>
			</div>
		</div>
	</div>
</body>
</html>