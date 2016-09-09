<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />


<script type="text/javascript">
$(function(){
	$("#select-single").select2();
	$(".js-example-basic-multiple").select2();
	$('.fecha').datepicker({"dateFormat": "yy-mm-dd"});
	$('#proyectoForm').validate();
})

</script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<br>
	<form:form method="post" modelAttribute="proyectoForm" action="guardareditproyecto.html">
		<form:input path="id" type="hidden" />
		<form:input path="sumaHorasTareas" type="hidden" />
		<div class="form-group">
		<label for="nombre">Nombre</label>
		<form:input class="form-control required" path="nombre" type="text" />
		</div>
		<div class="form-group">
		<label for="descripcion">Descripcion</label>
		<form:textarea class="form-control required" path="descripcion" />
		</div>
		<div class="form-group">
			<label for="fechaInicio">Fecha de inicio</label>
			<form:input class="form-control required fecha" path="fechaInicio" />
		</div>
		<div class="form-group">
			<label for="fechaFin">Fecha de fin</label>
			<form:input class="form-control required fecha" path="fechaFin" />
		</div>
		<div class="form-group">
		<label for="idUsuarioPrincipal">Usuario Principal</label>
		<form:select path="idUsuarioPrincipal" id="select-single" class="js-example-basic-single js-states form-control required" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id">
		</form:select>
		</div>
		<div class="form-group">
			<label for="horasAsignadas">Horas asignadas</label>
			<form:input class="form-control required" path="horasAsignadas" type="number" />
		</div>
		<div class="form-group">
		<label for="idUsuarios">Usuarios </label>
		<form:select id="select-multiple" class="js-example-basic-multiple js-states form-control required" multiple="multiple" path="idUsuarios" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id">
		</form:select>
		</div>
		<br>
		<div class="form-group">
		<input type="submit" class="btn btn-success" value="Guardar">
		<a href="index.html" 
					class="btn btn-danger">Volver </a>
		</div>
	</form:form>
	

<c:import url="/general/template_bottom.jsp" />