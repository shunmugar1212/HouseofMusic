<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>User</title>
</head>
<body style="background-image: url('resources/images/bg.png');">
<br><br><br>
	<jsp:include page="navbar.jsp"></jsp:include>

	<c:choose>
	<c:when test="${isUserClickedAddtoCart =='true' }">
		<jsp:include page="Cart.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedAbout=='true' }">
			<jsp:include page="About.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedDescription=='true' }">
			<jsp:include page="ProductDes.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedAddress=='true' }">
			<jsp:include page="ViewAddress.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedNewAddress=='true' }">
			<jsp:include page="AddAddress.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserPayment=='true' }">
			<jsp:include page="PaymentPage.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedThankyou=='true' }">
			<jsp:include page="Thankyou.jsp"></jsp:include>
	</c:when>
	<c:when test="${IsUserClickedExplore=='true' }">
			<jsp:include page="ProductList.jsp"></jsp:include>
	</c:when>
	<c:when test="${IsUserClickedExplore1=='true' }">
			<jsp:include page="ProductList.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
	<jsp:include page="ProductList.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
	</c:otherwise>
	</c:choose>
	
	
</body>
</html>