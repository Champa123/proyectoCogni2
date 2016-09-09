<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />


<div class='page-header'>
  <div class='btn-toolbar pull-right'>
<!--     <div class='btn-group'> -->
<!--       <a href="nuevousuario.html" class="btn btn-default">+</a> -->
<!--     </div> -->
  </div>
  <h2>Listado de tareas</h2>
</div>

<table class="table table-striped table-bordered table-hover">
  <tr>
    <th>Id</th>
    <th>Título</th>
    <th>Horas</th>
    <th></th>
  </tr>
  <c:forEach items="${tarea}" var="t">
  	<tr>
	    <td>${t.id}</td>
	    <td>${t.titulo}</td>
	    <td>${t.horas}</td>
	    <td>
	    	<a href="vertarea.html?id=${t.id}" 
					class="btn btn-default">Ver</a>
				
			<a href="editartarea.html?id=${t.id}" 
					class="btn btn-success">Editar</a>
			
			<a href="borrartarea.html?id=${t.id}" 
					class="btn btn-danger">Borrar</a>
	    </td>
  	</tr>
  </c:forEach>
</table>


<c:import url="/general/template_bottom.jsp" />