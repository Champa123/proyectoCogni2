<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />



<script>

$(document).ready(function(){
	
	buscarTarea();

$('#textoTarea').keypress(function(event){
	var keycode = (event.keyCode ? event.keyCode : event.which);
	if(keycode == '13'){
		event.preventDefault();
		buscarTarea();
		return false;
	}
	
});

$("#divResult").delegate(".btn-modal", "click", function(){
	var id = $(this).data("id-tarea");
	$.get("modalcomentario.html?id=" + id, function(resp){
		$("#myModalComentario").html(resp);
		$("#myModalComentario").modal("show");
	});
});
$("#divResult").delegate(".btn-modal-usuarios", "click", function(){
	var id = $(this).data("id-tarea");
	$.get("modalusuario.html?id=" + id, function(resp){
		$("#myModalUsuario").html(resp);
		$("#myModalUsuario").modal("show");
	});
});
	

$('#btnTarea').click(function(){
	buscarTarea();
});


function buscarTarea (){
	var datos = $('#buscadorTarea').serialize();
	$.get('buscadortareas.html', datos, function(r){
		$('#divResult').html(r);
	});
}	
})
</script>


<h1>Listado de Tareas</h1>

<form class="form-inline" id="buscadorTarea" method="get" action="buscadortareas.html?textoBuscar=">
	<input class="form-control" type="text" id="textoTarea" name="textoTarea" placeholder="Buscar..." class="ui-widget">
	<button type="button" class="btn btn-default" id="btnTarea" type="button">Buscar</button>
</form>
<br>

<div id="divResult"></div>
<div class="modal fade" id="myModalComentario" role="dialog"></div>

<div class="modal fade" id="myModalUsuario" role="dialog"></div>
<div id="divUsuarios"></div>

<c:import url="/general/template_bottom.jsp" />