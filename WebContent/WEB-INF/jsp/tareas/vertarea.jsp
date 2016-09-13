<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>Titulo</th>
		<th>Estado</th>
		<th>Horas</th>
		<th></th>

	</tr>
	<c:forEach items="${tareas}" begin="0" end="4" var="tarea">
		<c:if test="${tarea.estado == 'Completado'}">
           		<tr class="success">
           			<td>${tarea.id}</td>
           			<td>${tarea.titulo}</td>
           			<td>${tarea.estado}</td>
           			<td>${tarea.horas}</td>
           			<td align="center">
           			<a href="/trackandbug/tareas/editartarea.html?id=${tarea.id}" 
						class="btn btn-primary">Editar</a>
           			<button type="button" class="btn btn-success btn-modal-tarea" data-toggle="modal" 
				data-id-tarea="${tarea.id}">Ver</button>
			
			</td>
           		</tr>
           		</c:if>
           		<c:if test="${tarea.estado == 'En curso'}">
           		<tr class="warning">
           			<td>${tarea.id}</td>
           			<td>${tarea.titulo}</td>
           			<td>${tarea.estado}</td>
           			<td>${tarea.horas}</td>
           			<td align="center">
           			<a href="/trackandbug/tareas/editartarea.html?id=${tarea.id}" 
						class="btn btn-primary">Editar</a>
           				<button type="button" class="btn btn-success btn-modal-tarea" data-toggle="modal" 
						data-id-tarea="${tarea.id}">Ver</button>
						
					</td>
           		</tr>
           		</c:if>
           		<c:if test="${tarea.estado == 'Cancelado'}">
           		<tr class="danger">
           			<td>${tarea.id}</td>
           			<td>${tarea.titulo}</td>
           			<td>${tarea.estado}</td>
           			<td>${tarea.horas}</td>
           			<td align="center">
           			<a href="/trackandbug/tareas/editartarea.html?id=${tarea.id}" 
						class="btn btn-primary">Editar</a>
           			<button type="button" class="btn btn-success btn-modal-tarea" data-toggle="modal" 
				data-id-tarea="${tarea.id}">Ver</button>
				
				</td>
           		</tr>
           		</c:if>
   
   
				
					
			
	</c:forEach>
</table>

