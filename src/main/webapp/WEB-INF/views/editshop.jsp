<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div style="color: red;">
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
</div>
<h2 class="margin-bottom-10">Edit Shop</h2>
<form:form action="${pageContext.request.contextPath}/editshop"
	modelAttribute="shopForm" class="templatemo-login-form" method="post">
	<form:hidden path="id" class="form-control" id="id" />
	<div class="row form-group">
		<div class="col-lg-6 col-md-6 form-group">
			<label for="shopname">Shop name</label>
			<form:input path="name" class="form-control" id="shopname" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="address">Address</label>
			<form:input path="address" class="form-control" id="address" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="tel">tel</label>
			<form:input path="tel" class="form-control" id="tel" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<form:errors path="*"></form:errors>
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<input type="submit" value="Submit" class="btn btn-primary" />
		</div>
	</div>
</form:form>