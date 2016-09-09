<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="tablaProyectos" class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Descripcion</th>
		<th>Fecha de inicio</th>
		<th>Fecha de fin</th>
		<th>Usuario Principal</th>
		<th>Horas asignadas</th>
		<th>Horas disponibles</th>
		<th></th>
	</tr>
	<c:forEach items="${proyectos}" var="p">
		<tr id="${p.id}">
			<td>${p.id}</td>
			<td>${p.nombre}</td>
			<td>${p.descripcion}</td>
			<td><fmt:formatDate value="${p.fechaInicio}" pattern="yyyy-MM-dd" /></td>
			<td><fmt:formatDate value="${p.fechaFin}" pattern="yyyy-MM-dd" /></td>
			<td>
				<c:if test="${not empty p.usuarioPrincipal}">
					${p.usuarioPrincipal.nombreCompleto}</c:if>
			</td>
			<td>${p.horasAsignadas}</td>
			<td>${p.horasAsignadas - p.sumaHorasTareas}</td>
			<td align="center">
   
   
				<button type="button" class="btn btn-primary btn-modal" data-toggle="modal" 
				data-id-proyecto="${p.id}">Ver</button>
				
				<a href="editarproyecto.html?id=${p.id}" 
					class="btn btn-info">Editar</a>
				
				<button type="button" 
					data-id-proyecto="${p.id}" class="vertareas btn btn-success">Ver Tareas</button>
				
				<a href="guardarnuevatarea.html?id=${p.id}" 
					class="btn btn-warning">Agregar Tarea</a>
											
				<a href="borrarproyecto.html?id=${p.id}" 
					class="btn btn-danger">Borrar</a>
					
					
					
					
			</td>
		</tr>
	</c:forEach>
</table>
