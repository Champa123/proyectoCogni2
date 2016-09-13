<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />




<h1>Listado de Tareas</h1>

<br>
<table class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>Titulo</th>
		<th>Estado</th>
		<th></th>

	</tr>
	<c:forEach items="${tareas}" var="t">
		<tr>
			<td>${t.id}</td>
			<td>${t.titulo}</td>
			<td>${t.estado}</td>

			<td>
				<a href="guardarnuevocomentario.html?id=${t.id}" 
					class="btn btn-success">Agregar Comentario</a>
			</td>

		</tr>
	</c:forEach>
	
</table>


<c:import url="/general/template_bottom.jsp" />