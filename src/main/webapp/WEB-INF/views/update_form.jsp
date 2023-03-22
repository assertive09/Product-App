<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp"%>
</head>
<body background="<c:url value="/resources/img/home.png"/>" class="text-white">
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Change product details</h1>
				<form action="<%= request.getContextPath() %>/update-submit" method="post">
					<input type="hidden" name=pid value="${product.pid}" />
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							value="${product.name}" name="name"
							placeholder="Enter the product name here">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" name="description" id="description"
							rows="5" placeholder="Enter the product description">${product.description}</textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Price</label> <input type="text"
							placeholder="Enter Product Price" name="price"
							value="${product.price}" class="form-control" id="price">
					</div>
					<div class="container text-center">
						<a href="<%=request.getContextPath() + "/"%>/"
							class="btn btn-outline-danger text-danger">Back</a>
						<button type="submit"
							class="btn btn-outline-success text-white">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>