<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="tablaTareas" class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>Titulo</th>
		<th>Horas</th>
		<th>Estado</th>
		<th></th>
	</tr>
	<c:forEach items="${tareas}" var="t">
		<tr>
			<td>${t.id}</td>
			<td>${t.titulo}</td>
			<td>${t.horas}</td>
			<td>${t.estado}</td>
			<td>
				<a href="guardarnuevocomentario.html?id=${t.id}" 
					class="btn btn-success">Agregar Comentario</a>
			</td>
		</tr>
	</c:forEach>
</table>