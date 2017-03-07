<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div style="color: red;">
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
</div>
<div class="btn">
	<a href="${pageContext.request.contextPath}/addUser">Add New User</a>
</div>
<div
	class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
	<i class="fa fa-times"></i>
	<div class="panel-heading templatemo-position-relative">
		<h2 class="text-uppercase">User Table</h2>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<td>ID</td>
					<td>User Name</td>
					<td>Pass Word</td>
					<td>Role</td>
					<td>Status</td>
					<td>Shoper</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${userInforList}">
					<tr>
						<td>${item.id}</td>
						<td>${item.username}</td>
						<td>${item.password}</td>
						<td>${item.role}</td>
						<td>${item.status}</td>
						<td>${item.shopInfo.name}</td>
						<td><a
							href="${pageContext.request.contextPath}/edituser?id=${item.id}">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/deleteuser?id=${item.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>