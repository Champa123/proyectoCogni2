<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/general/template_top.jsp" />
<br>
<table style=padding-top:50px class="table table-bordered">
 <tr>
 	<th>Id</th>
 	<th>Nombre</th>
 	<th>Descripcion</th>
 	<th>Fecha de inicio</th>
	<th>Fecha de fin</th>
 	
 </tr> 
<tr>
<td>${proyecto.id}</td>
<td>${proyecto.nombre}</td>
<td>${proyecto.descripcion}</td>
<td><fmt:formatDate value="${proyecto.fechaInicio}" pattern="yyyy-MM-dd" /></td>
<td><fmt:formatDate value="${proyecto.fechaFin}" pattern="yyyy-MM-dd" /></td>
</tr>
</table>

<c:import url="/general/template_bottom.jsp" />