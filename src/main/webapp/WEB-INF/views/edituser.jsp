<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="margin-bottom-10">Add User Instance</h2>
<form:form action="${pageContext.request.contextPath}/edituser"
	modelAttribute="userForm" class="templatemo-login-form" method="post">
	<form:hidden path="id"/>
	<div class="row form-group">
		<div class="col-lg-6 col-md-6 form-group">
			<label for="username">User Name</label>
			<form:input path="username" class="form-control" id="username" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="password">Password</label>
			<form:input path="password" class="form-control" id="password" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="role">Role</label>
			<form:input path="role" class="form-control" id="role" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="status">Status</label>
			<form:input path="status" class="form-control" id="status" />
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="shop">Shop</label>
			<form:select path="shopInfo.id" class="form-control" id="shop">
				<form:options items="${listShop}" itemLabel="name" itemValue="id" />
			</form:select>
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<form:errors path="*"></form:errors>
		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</div>
	</div>
</form:form>