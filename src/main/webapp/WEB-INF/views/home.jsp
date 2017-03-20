<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css" href="resources/css/styles.css">

<div class="page-title">Product List</div>
<c:forEach var="item" items="${productList}">
	<div class="product-preview-container">
		<ul>
			<li><img class="product-image" src="${item.image}" /></li>
			<li>${item.name}</li>
			<li class="hide">${item.id}</li>
			<li>Price: ${item.price}</li>
			<li><a
				href="${pageContext.request.contextPath}/buyProduct?productId=${item.id}">Buy
					Now</a></li>
		</ul>
	</div>
</c:forEach>