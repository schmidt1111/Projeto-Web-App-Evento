<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Qintess - Eventos Online</title>
<spring:url value="casashow/" var="casashow"></spring:url>
</head>
<body>
	<h1>Hello Word! Index do site Evento Online</h1>
	<hr  />
	<a href ="${casashow}">CRUD Casa de Show</a>
</body>
</html>