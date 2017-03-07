<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="margin-bottom-10">Add Product Instance</h2>
<form:form action="${pageContext.request.contextPath}/editProduct/"
	modelAttribute="productForm" class="templatemo-login-form"
	method="post">

	<div class="row form-group">
		
		<div class="col-lg-6 col-md-6 form-group">
			<label for="shopId">Shop ID</label>
			<form:input path="shopId" class="form-control" id="shopId" />
		</div>

		<div class="col-lg-6 col-md-6 form-group">
			<label for="name">Product Name</label>
			<form:input path="name" class="form-control" id="name" />
		</div>

		<div class="col-lg-6 col-md-6 form-group">
			<label for="detail">Detail</label>
			<form:input path="detail" class="form-control" id="detail" />
		</div>

		<div class="col-lg-6 col-md-6 form-group">
			<label for="price">Price</label>
			<form:input path="price" class="form-control" id="price" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="image">Image</label>
			<form:input path="image" class="form-control" id="image" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="status">Status</label>
			<form:input path="status" class="form-control" id="status" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<input type="submit" value="Edit" class="btn btn-primary" />
		</div>
		<div class="col-lg-6 col-md-6 form-group" style="visibility: hidden">
			<label for="id">Product ID</label>
			<form:input path="id" class="form-control" id="id" />
		</div>
	</div>
</form:form>