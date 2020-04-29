<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro - Casa de Show</title>
</head>

<body>
	<h2>Cadastro - Casa de Show</h2>
	<hr />
	<form:form action="salva" modelAttribute="casashow">
	
		<form:hidden path="id"/>
		
		<label> Nome:</label><br />
		<form:input path="nome"/>
		
		<br />
		<label> Endereco:</label><br />
		<form:input path="logradouro"/>
		
		<br />
		<label> N:</label><br />
		<form:input path="numero"/>
		
		<br />
		<label> Complem.:</label><br />
		<form:input path="complemento"/>
		
		<br />
		<label> CEP:</label><br />
		<form:input path="cep"/>
		
		<br />
		<label> Cidade:</label><br />
		<form:input path="cidade"/>
		
		<br />
		<label> Estado:</label><br />
		<form:input path="estado"/>
		  
		 <br />
		<label> Capacidade:</label><br />
		<form:input path="capacidade"/>
		
		<br />
		<label> Valor:</label><br />
		<form:input path="valor"/>
		
		<br />
		<br />
		<form:button>Cadastrar</form:button>
	</form:form>
</body>
</html>