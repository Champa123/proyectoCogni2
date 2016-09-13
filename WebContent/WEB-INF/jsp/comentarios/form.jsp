<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


	<form:form method="post" modelAttribute="comentarioForm" action="guardarnuevocomentario.html?id=${id}">
		<form:input path="id" type="hidden" />
		<div class="form-group">
		<label for="comentario">Comentario</label>
		<form:textarea class="form-control required" path="comentario" type="text" />
		</div>
		
		<div class="form-group">
		<input type="submit" class="btn btn-success" value="Guardar">
		<a href="index.html" 

					class="btn btn-danger">Volver </a>
		</div>
	</form:form>
	

<c:import url="/general/template_bottom.jsp" />