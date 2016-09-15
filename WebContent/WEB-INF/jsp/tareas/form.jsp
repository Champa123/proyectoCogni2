<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />
<script type="text/javascript">
$(function(){
	
	$(".js-example-basic-multiple").select2();
	});

</script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<br>
<form:form method="post" modelAttribute="tareaForm" action="guardarnuevatarea.html?id=${ID}">
	<form:input path="id" type="hidden" />
	
	<div class="form-group">
		<label for="titulo">Titulo</label>
		<form:input class="form-control" path="titulo" type="text" />

		</div>
		<div class="form-group">
			<label for="estado">Estado</label>
			<form:select class="form-control" path="estado" type="select" >
			<form:option class="form-control" value="Completado" >Completado</form:option>
			<form:option class="form-control" value="En curso" >En curso</form:option>
			<form:option class="form-control" value="Cancelado" >Cancelado</form:option>
			</form:select>
		</div>


	<div class="form-group">
		<label for="horas">Horas</label>
		<form:input class="form-control" path="horas" type="number" />
	</div>
<div class="form-group">
			<label for="idUsuarios">Usuarios </label>
			<form:select id="select-multiple" class="js-example-basic-multiple js-states form-control required" 
				multiple="multiple" path="idUsuarios" items="${usuarios}"
				itemLabel="nombreCompleto" itemValue="id">
			</form:select>
		</div>
	<div class="form-group">
		<input type="submit" class="btn btn-success" value="Guardar">
		<a href="guardarnuevatarea.html?id=${ID}" 
					class="btn btn-danger">Volver </a>
	</div>
</form:form>
	

<c:import url="/general/template_bottom.jsp" />