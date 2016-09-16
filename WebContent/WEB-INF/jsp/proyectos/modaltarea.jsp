<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="container">
  <h2>Tarea</h2>
 
  <!-- Modal -->

    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">${tarea.titulo}</h4>
        </div>
        <div class="modal-body">
           <table class="table table-striped table-bordered table-hover">
           		<tr>
           		<th>Id</th>
           		<th>Titulo</th>
           		<th>Estado</th>
           		<th>Horas</th>
           		<th></th>

           		
           		</tr>
           		<c:if test="${tarea.estado == 'Completado'}">
           		<tr class="success">
           			<td>${tarea.id}</td>
           			<td>${tarea.titulo}</td>
           			<td>${tarea.estado}</td>
           			<td>${tarea.horas}</td>
           			
           		</tr>
           		</c:if>
           		<c:if test="${tarea.estado == 'En curso'}">
           		<tr class="warning">
           			<td>${tarea.id}</td>
           			<td>${tarea.titulo}</td>
           			<td>${tarea.estado}</td>
           			<td>${tarea.horas}</td>
           			
           		</tr>
           		</c:if>
           		<c:if test="${tarea.estado == 'Cancelado'}">
           		<tr class="danger">
           			<td>${tarea.id}</td>
           			<td>${tarea.titulo}</td>
           			<td>${tarea.estado}</td>
           			<td>${tarea.horas}</td>
           			
           		</tr>
           		</c:if>
           </table>
           <table class="table table-striped table-bordered table-hover">
           		<tr>
           		
           		<th>Comentarios</th>
           		<th></th>
           		</tr>
           		
           			<c:forEach items="${tarea.comentarios}" begin="0" end="9" var="c">
           			<tr>
           				<td>
           					${c.comentario}
           					
           				</td>
           				<td align="center">
           					<a href="/trackandbug/comentarios/borrarcomentario.html?idComent=${c.id}&idTarea=${tarea.id}" 
					class="btn btn-danger">Borrar</a>
           				</td>
              		</tr>
           			</c:forEach>

           </table>
              <table class="table table-striped table-bordered table-hover">
           		<tr>
           		
           		<th>Usuarios de esta tarea</th>
           		
           		</tr>
           		
           			<c:forEach items="${tarea.usuarios}" begin="0" end="4" var="u">
           			<tr>
           				<td>
           					${u.nombreCompleto}
           					
           				</td>
           				
              		</tr>
           			</c:forEach>

           </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
 