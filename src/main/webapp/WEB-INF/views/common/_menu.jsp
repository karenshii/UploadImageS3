<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<div class="templatemo-sidebar">
	<header class="templatemo-site-header">
		<div class="square"></div>
		<h1>Visual Admin</h1>
	</header>
	<div class="profile-photo-container">
		<img
			src="${pageContext.request.contextPath}/resources/img/profile-photo.jpg"
			alt="Profile Photo" class="img-responsive">
		<div class="profile-photo-overlay"></div>
	</div>
	<!-- Search box -->
	<form class="templatemo-search-form" role="search">
		<div class="input-group">
			<button type="submit" class="fa fa-search"></button>
			<input type="text" class="form-control" placeholder="Search"
				name="srch-term" id="srch-term">
		</div>
	</form>
	<div class="mobile-menu-icon">
		<i class="fa fa-bars"></i>
	</div>
	<nav class="templatemo-left-nav">
	<c:url value="/j_spring_security_logout" var="logout"></c:url>
		<form action="${logout}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<ul>
			<li><a href="${pageContext.request.contextPath}/user"
				class="active"><i class="fa fa-home fa-fw"></i>USers Manager</a></li>
			<li><a href="${pageContext.request.contextPath}/product"><i
					class="fa fa-bar-chart fa-fw"></i>Product Manager</a></li>
			<li><a href="${pageContext.request.contextPath}/groupproduct"><i
					class="fa fa-database fa-fw"></i>Group Product Manager</a></li>
			<li><a href="${pageContext.request.contextPath}/shop"><i
					class="fa fa-map-marker fa-fw"></i>Shop Manager</a></li>

			<li><a
				href="${pageContext.request.contextPath}/order-detail-lists"
				class="active"><i class="fa fa-users fa-fw"></i>Order Manager</a></li>
				
			<li><a href="javascript:logout()"><i
					class="fa fa-eject fa-fw"></i>${pageContext.request.userPrincipal.name} |Sign Out</a></li>
		</ul>
	</nav>
</div>