<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	
	
	hacerBusqueda();
	
	
	$('.fecha').datepicker({"dateFormat": "yy-mm-dd"});
	
	$('#textoBuscar').keypress(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			event.preventDefault();
			hacerBusqueda();
			return false;
		}
		
	});

	$('#btnBuscar').click(function(){
		hacerBusqueda();
	});
	
	$("#divResultado").delegate(".vertareas", "click", function(){
		var id = $(this).data("id-proyecto");
		 mostrarTareas(id)
	});
	
	$("#divResultado").delegate(".btn-modal", "click", function(){
		var id = $(this).data("id-proyecto");
		$.get("modal.html?id=" + id, function(resp){
			$("#myModalProyecto").html(resp);
			$("#myModalProyecto").modal("show");
		});
	});
	
	$("#divTareas").delegate(".btn-modal-tarea", "click", function(){
		var id = $(this).data("id-tarea");
		$.get("modaltarea.html?id=" + id, function(resp){
			$("#myModalTarea").html(resp);
			$("#myModalTarea").modal("show");
		});
	});
	
		
	});

function mostrarTareas(id){
	$.get("listartareas.html?id="+id, function(r){
		$("#divTareas").html(r)
	})
}

function hacerBusqueda (){
	var datos = $('#buscador').serialize();
	$.post('buscadorproyectos.html', datos, function(r){
		$('#divResultado').html(r);
	});
}	

</script>


<h1>Listado de Proyectos</h1>
<a href="nuevoproyecto.html" class="btn btn-warning">Agregar nuevo </a>
<br>
<br>
<form class="form-inline" id="buscador" method="post" action="buscadorproyectos.html">
	<input class="form-control" type="text" id="textoBuscar" name="textoBuscar" placeholder="Buscar..." class="ui-widget">
	<input class="form-control fecha" placeholder="Fecha de inicio" name="fechaInicio" />
	<input class="form-control fecha" placeholder="Fecha de finalización" name="fechaFin" />
	<button type="button" class="btn btn-primary" id="btnBuscar">Buscar</button>
</form>

<br>

<div id="divResultado"></div>
<div id="divTareas"></div>
<div class="modal fade" id="myModalProyecto" role="dialog"></div>
<div class="modal fade" id="myModalTarea" role="dialog"></div>

<c:import url="/general/template_bottom.jsp" />