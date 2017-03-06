<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="check" value="${userInforList.size()}"></c:set>
<c:if test="${check == 0}">
	<div class="btn">
		<a href="${pageContext.request.contextPath}/adduser">Add New User</a>
	</div>
</c:if>
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