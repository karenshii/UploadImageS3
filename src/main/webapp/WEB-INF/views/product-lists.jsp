<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="btn">
		<a href="${pageContext.request.contextPath}/addProduct/${shopId}">Add New Product</a>
	</div>
<div
	class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
	<i class="fa fa-times"></i>
	<div class="panel-heading templatemo-position-relative">
		<h2 class="text-uppercase">Product List</h2>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<td>Product ID</td>
					<td>Name</td>
					<td>Price</td>
					<td>Image</td>
					<td>Status</td>
					<td>Last Update</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${productList}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.image}</td>
						<td>${item.status}</td>
						<td>${item.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>