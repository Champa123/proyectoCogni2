<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script>
	$(function() {
// 		$('#usuarioForm').validate();
		$('#fechaAlta').datepicker({"dateFormat": "yy-mm-dd"});
	});
</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<br>
	<form:form method="post" modelAttribute="usuarioForm" action="guardaredicion.html">
		<form:input path="id" type="hidden" />
		Nombre y apellido: <form:input class="form-control" path="nombreCompleto" type="text" />
		User: <form:input class="form-control" path="usuario" type="text" />
		<form:input path="password" hidden="true" type="password" />
		Fecha de alta: <form:input id="fechaAlta" path="fechaAlta" class="form-control required" type="text" />
		�Activo? <form:checkbox  path="activo"/>
		<br><br>
		<input type="submit" class="btn btn-success" value="Guardar">
		<a href="listar.html" 
					class="btn btn-danger">Volver </a>
	</form:form>
	

<c:import url="/general/template_bottom.jsp" />