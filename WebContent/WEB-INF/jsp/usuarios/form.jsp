<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script>
	$(function() {
		$('#usuarioForm').validate();
		$('#fechaAlta').datepicker({"dateFormat": "yy-mm-dd"});
	});
</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<br>
	<form:form method="post" modelAttribute="usuarioForm" action="guardarusuario.html">
		<form:input path="id" type="hidden" />
		<div class="form-group">
			<label for="nombreCompleto">Nombre y apellido</label>
			<form:input class="form-control required" path="nombreCompleto" type="text" />
		</div>
		
		<div class="form-group">
			<label for="usuario">Usuario</label>
			<form:input class="form-control required" path="usuario" type="text" />
		</div>
		
		<div class="form-group">
			<label for="password">Password</label>
			<form:input  class="form-control required" path="password" type="password" />
		</div>
		
		<div class="form-group">
			<label for="fechaAlta">Fecha de alta</label>
			<form:input id="fechaAlta" path="fechaAlta" class="form-control required" type="text" />
		</div>
				
		<div class="form-group">
			<label for="activo">¿Activo?</label>
			<form:checkbox  path="activo"/>
		</div>
		
		<div class="form-group">
			<input type="submit" class="btn btn-success" value="Guardar">
			<a href="listar.html" 
						class="btn btn-danger">Volver </a>
		</div>
		
	</form:form>
	

<c:import url="/general/template_bottom.jsp" />