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
				<c:if test="${room != null}">
					<form action="update_room" method="post">
				</c:if>
				<c:if test="${room == null}">
					<form action="insert_room" method="post">
				</c:if>
				<caption>
					<h2 style="text-align:center;">
						<c:if test="${room != null}">
            			Edit Room
            			</c:if>
						<c:if test="${room == null}">
            			Add New Room
            			</c:if>
					</h2>
				</caption>
				<br>
				
				<c:if test="${room != null}">
					<input type="hidden" name="id_room" value="<c:out value='${room.id_room}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Floor</label> <input type="text"
						value="<c:out value='${room.floor}' />" class="form-control"
						name="floor" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer</label> <input type="text"
						value="<c:out value='${room.customer}' />" class="form-control"
						name="customer">
				</fieldset>

				<fieldset class="form-group">
					<label>Room_attendant</label> <input type="text"
						value="<c:out value='${room.room_attendant}' />" class="form-control"
						name="room_attendant">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Features</label> <input type="text"
						value="<c:out value='${room.features}' />" class="form-control"
						name="features">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Empty_room</label> <input type="text"
						value="<c:out value='${room.empty_room}' />" class="form-control"
						name="empty_room">
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