<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<br>
	<form:form method="post" modelAttribute="tareaForm" action="guardarnuevatarea.html?id=${ID}">
		<form:input path="id" type="hidden" />
		<div class="form-group">
		<label for="titulo">Titulo</label>
		<form:input class="form-control" path="titulo" type="text" />
		</div><div class="form-group">
		<label for="estado">Estado</label>
		<form:select class="form-control" path="estado">
		<option></option>
		<option value="Completado">Completado</option>
		<option value="En curso">En curso</option>
		<option value="Cancelado">Cancelado</option>
		</form:select>
		</div>
		<div class="form-group">
		<input type="submit" class="btn btn-success" value="Guardar">
		<a href="guardarnuevatarea.html?id=${ID}" 
					class="btn btn-danger">Volver </a>
		</div>
	</form:form>
	

<c:import url="/general/template_bottom.jsp" />