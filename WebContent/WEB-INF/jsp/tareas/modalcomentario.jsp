<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
  <h2>Tarea</h2>
 
  <!-- Modal -->

    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Agregar Comentario</h4>
        </div>
        <div class="modal-body">
          <form:form method="post" modelAttribute="comentarioForm" action="/trackandbug/comentarios/guardarnuevocomentario.html?id=${id}">
		<form:input path="id" type="hidden" />
		<div class="form-group">
		<label for="comentario">Comentario</label>
		<form:textarea class="form-control required" path="comentario" type="text" />
		</div>
		
		<div class="form-group">
		<input type="submit" class="btn btn-success" value="Guardar">
		
		</div>
	</form:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
 