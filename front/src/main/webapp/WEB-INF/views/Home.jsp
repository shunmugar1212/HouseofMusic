 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Home</title>
</head>
<body style="background-image: url('resources/images/bg.png');">

<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="slideshow.jsp"></jsp:include>
<c:if test="${IsUserLoginFail=='true'}">
	<h4><marquee><font color="red">${message}</font></marquee></h4>
</c:if>
<jsp:include page="ProductList.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
 

</body>
</html>