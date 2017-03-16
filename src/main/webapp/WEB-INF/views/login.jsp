<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.vertical-offset-100 {
	padding-top: 150px;
}
</style>
</head>
<body>
	<c:url value="/j_spring_security_check" var="security_check_action" />
	<c:if test="${error}">
		<font color="red">Wrong username or password!</font>
		<br />
		<br />
	</c:if>
	<div class="container">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="top-login">
						<div class="error-login"></div>
						<c:if test="${not empty error}">
							<div class="error-login">${error}</div>
						</c:if>
						<c:if test="${not empty logout}">
							<div class="logout-msg">${logout}</div>
						</c:if>
					</div>
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8" role="form"
							action="${security_check_action}" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User Name"
										name="username" type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" value="">
								</div>
								<div class="checkbox">
									<label>
									<input style="display: inline-block;" name="remember" type="checkbox" value="remember" />Remember Me</label>
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Login">
							</fieldset>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
