<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>Titulo</th>
		<th>Horas</th>
		<th></th>

	</tr>
	<c:forEach items="${tarea}" var="t">
		<tr>
			<td>${t.id}</td>
			<td>${t.titulo}</td>
			<td>${t.horas}</td>
			<td align="center">
   
   
				<button type="button" class="btn btn-primary btn-modal-tarea" data-toggle="modal" 
				data-id-tarea="${t.id}">Ver</button>
				
				<a href="/trackandbug/tareas/editartarea.html?id=${t.id}" 
					class="btn btn-success">Editar</a>
				
					
					
			</td>
		</tr>
	</c:forEach>
</table>

