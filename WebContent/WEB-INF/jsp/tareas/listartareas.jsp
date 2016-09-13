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
	<input type="text" id="textoTarea" name="textoTarea" placeholder="Buscar..." class="ui-widget">
	<input id="btnTarea" type="button" value="Buscar">
</form>

<br>
<table class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>Titulo</th>

		<th>Horas</th>
	

		<th>Estado</th>
		<th></th>


	</tr>
	<c:forEach items="${tareas}" var="t">
		<tr>
			<td>${t.id}</td>
			<td>${t.titulo}</td>

			<td>${t.horas}</td>
	

			<td>${t.estado}</td>

			<td>
				<a href="guardarnuevocomentario.html?id=${t.id}" 
					class="btn btn-success">Agregar Comentario</a>
			</td>


		</tr>
	</c:forEach>
	
</table>

<div id="divResult"></div>



<c:import url="/general/template_bottom.jsp" />