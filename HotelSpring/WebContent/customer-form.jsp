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
																								
				<c:if test="${customer != null}">
					<form action="update_customer" method="post">
				</c:if>
				<c:if test="${customer == null}">
					<form action="insert_customer" method="post">
				</c:if>

				<caption>
					<h2 style="text-align:center;">
						<c:if test="${customer != null}">
            			Edit Customer
            			</c:if>
						<c:if test="${customer == null}">
            			Add New Customer
            			</c:if>
					</h2>
				</caption>
				<br>
				
				<c:if test="${customer != null}">
					<input type="hidden" name="id_customer" value="<c:out value='${customer.id_customer}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Customer Name</label> <input type="text"
						value="<c:out value='${customer.customer_name}' />" class="form-control"
						name="customer_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Email</label> <input type="text"
						value="<c:out value='${customer.customer_email}' />" class="form-control"
						name="customer_email">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Checkin</label> <input type="text"
						value="<c:out value='${customer.checkin}' />" class="form-control"
						name="checkin">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Customer Checkout</label> <input type="text"
						value="<c:out value='${customer.checkout}' />" class="form-control"
						name="checkout">
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