<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Admin</title>
</head>
<body>

<jsp:include page="navbar.jsp"></jsp:include>

<br><br><br><br><br>

	
	<c:choose>
	<c:when test="${isUserClickedView1=='true'}">
		<jsp:include page="ViewCategory.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedView2=='true'}">
		<jsp:include page="ViewProduct.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedView3=='true'}">
		<jsp:include page="ViewSupplier.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedAdd1=='true'}">
		<jsp:include page="AddCategory.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedAdd2=='true'}">
		<jsp:include page="AddProduct.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedAdd3=='true'}">
		<jsp:include page="AddSupplier.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedEdit=='true'}">
		<jsp:include page="EditCategory.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedEdit1=='true'}">
		<jsp:include page="EditProduct.jsp"></jsp:include>
	</c:when>
	<c:when test="${isUserClickedEdit2=='true'}">
		<jsp:include page="EditSupplier.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
	Welcome Admin
	</c:otherwise>
	</c:choose>
	

</body>
</html>