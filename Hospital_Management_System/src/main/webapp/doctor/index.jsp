<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Dashboard</title>
<%@include file="../component/allcss.jsp"%>

</head>
<body>
	<!-- This Jstl code will redirect user(doctor) to the login page if he try to go back after logout basically secure the login page -->
	<c:if test="${empty docObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>
	<h1>Doctor Dashboard</h1>

</body>
</html>