<!doctype html>
<%@page import="com.productapp.model.Product"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp"%>
</head>
<body background="<c:url value="/resources/img/home.png"/>">

	<div class="container text-center mt-4">
		<h1 class="text-white">Welcome to Product App</h1>
		<div class="container mt-5">
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th scope="col">S.NO.</th>
						<th scope="col">Product Name</th>
						<th scope="col">Description</th>
						<th scope="col">Price</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody class="text-white">
					<c:forEach items="${products}" var="p">
						<tr>
							<th scope="row">${p.getPid()}</th>
							<td>${p.getName()}</td>
							<td>${p.getDescription()}</td>
							<td>&#8377;${p.getPrice()}</td>
							<td><a href="delete/${p.getPid()}"><i
									class="fas fa-trash text-danger"></i></a> &nbsp; <a
								href="update/${p.getPid()}"><i
									class="fas 	far fa-edit text-secondary"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="container text-center">
				<a href="add-product"
					class="btn btn-outline-success text-white">Add Product</a>
			</div>
		</div>
	</div>

</body>
</html>
