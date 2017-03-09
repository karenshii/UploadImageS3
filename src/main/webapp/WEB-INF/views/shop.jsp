<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="btn">
	<a href="${pageContext.request.contextPath}/addshop">Add new Shopper</a>
</div>
<div
	class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
	<i class="fa fa-times"></i>
	<div class="panel-heading templatemo-position-relative">
		<h2 class="text-uppercase">Shop Table</h2>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<td>ID</td>
					<td>shop name</td>
					<td>address</td>
					<td>tel</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listShop}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.address}</td>
						<td>${item.tel}</td>
						<td><a
							href="${pageContext.request.contextPath}/editshop?id=${item.id}">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/deleteshop?id=${item.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>